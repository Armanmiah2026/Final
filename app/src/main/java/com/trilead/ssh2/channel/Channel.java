package com.trilead.ssh2.channel;

import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.PacketSignal;
import com.trilead.ssh2.packets.PacketWindowChange;
import com.trilead.ssh2.transport.TransportManager;
import com.trilead.ssh2.util.IOUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Channel {
    static final int STATE_CLOSED = 4;
    static final int STATE_OPEN = 2;
    static final int STATE_OPENING = 1;
    int channelBufferSize = CHANNEL_BUFFER_SIZE;
    final Object channelSendLock;
    boolean closeMessageRecv;
    boolean closeMessageSent;
    final ChannelManager cm;
    private boolean eof;
    String exit_signal;
    Integer exit_status;
    int failedCounter;
    String hexX11FakeCookie;
    int localID;
    int localMaxPacketSize;
    int localWindow;
    final byte[] msgWindowAdjust;
    private Throwable reasonClosed;
    private final Object reasonClosedLock;
    int remoteID;
    int remoteMaxPacketSize;
    long remoteWindow;
    int state;
    final Output stderr;
    final ChannelOutputStream stdinStream;
    final Output stdout;
    int successCounter;
    private static final int CHANNEL_BUFFER_SIZE = Integer.getInteger(Channel.class.getName().concat(".bufferSize"), 1064960).intValue();
    private static final Logger log = Logger.getLogger(Channel.class);

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class Output {
        FifoBuffer buffer;
        OutputStream sink;
        ChannelInputStream stream;

        public Output() {
            this.buffer = new FifoBuffer(Channel.this, 2048, Channel.this.channelBufferSize);
        }

        public int available() {
            FifoBuffer fifoBuffer = this.buffer;
            if (fifoBuffer != null) {
                int i = fifoBuffer.readable();
                return i > 0 ? i : Channel.this.isEOF() ? -1 : 0;
            }
            throw new IllegalStateException("Output is being piped to " + this.sink);
        }

        public void eof() {
            FifoBuffer fifoBuffer = this.buffer;
            if (fifoBuffer != null) {
                fifoBuffer.close();
            } else {
                IOUtils.closeQuietly(this.sink);
            }
        }

        public void pipeTo(OutputStream outputStream) {
            this.sink = outputStream;
            if (this.buffer.readable() != 0) {
                Channel.this.freeupWindow(this.buffer.writeTo(outputStream));
            }
            this.buffer = null;
            this.stream = null;
        }

        public int read(byte[] bArr, int i, int i2) {
            return this.buffer.read(bArr, i, i2);
        }

        public int readable() {
            FifoBuffer fifoBuffer = this.buffer;
            if (fifoBuffer != null) {
                return fifoBuffer.readable();
            }
            return 0;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            FifoBuffer fifoBuffer = this.buffer;
            if (fifoBuffer != null) {
                try {
                    fifoBuffer.write(bArr, i, i2);
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            } else {
                this.sink.write(bArr, i, i2);
                Channel.this.freeupWindow(i2, true);
            }
        }
    }

    public Channel(ChannelManager channelManager) {
        Output output = new Output();
        this.stdout = output;
        Output output2 = new Output();
        this.stderr = output2;
        this.localID = -1;
        this.remoteID = -1;
        this.channelSendLock = new Object();
        this.closeMessageSent = false;
        this.msgWindowAdjust = new byte[9];
        this.state = 1;
        this.closeMessageRecv = false;
        this.successCounter = 0;
        this.failedCounter = 0;
        this.remoteWindow = 0L;
        this.localMaxPacketSize = -1;
        this.remoteMaxPacketSize = -1;
        this.eof = false;
        this.reasonClosedLock = new Object();
        this.reasonClosed = null;
        this.cm = channelManager;
        this.localWindow = this.channelBufferSize;
        this.localMaxPacketSize = TransportManager.MAX_PACKET_SIZE - 1024;
        this.stdinStream = new ChannelOutputStream(this);
        output.stream = new ChannelInputStream(this, false);
        output2.stream = new ChannelInputStream(this, true);
    }

    public synchronized void eof() {
        this.stdout.eof();
        this.stderr.eof();
        this.eof = true;
    }

    public void freeupWindow(int i) {
        freeupWindow(i, false);
    }

    public String getExitSignal() {
        String str;
        synchronized (this) {
            str = this.exit_signal;
        }
        return str;
    }

    public Integer getExitStatus() {
        Integer num;
        synchronized (this) {
            num = this.exit_status;
        }
        return num;
    }

    @Deprecated
    public String getReasonClosed() {
        String message;
        synchronized (this.reasonClosedLock) {
            try {
                Throwable th = this.reasonClosed;
                message = th != null ? th.getMessage() : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return message;
    }

    public Throwable getReasonClosedCause() {
        Throwable th;
        synchronized (this.reasonClosedLock) {
            th = this.reasonClosed;
        }
        return th;
    }

    public ChannelInputStream getStderrStream() {
        return this.stderr.stream;
    }

    public ChannelOutputStream getStdinStream() {
        return this.stdinStream;
    }

    public ChannelInputStream getStdoutStream() {
        return this.stdout.stream;
    }

    public boolean isEOF() {
        return this.eof;
    }

    public synchronized void pipeStderrStream(OutputStream outputStream) {
        this.stderr.pipeTo(outputStream);
    }

    public synchronized void pipeStdoutStream(OutputStream outputStream) {
        this.stdout.pipeTo(outputStream);
    }

    public void requestWindowChange(int i, int i2, int i3, int i4) {
        PacketWindowChange packetWindowChange;
        synchronized (this) {
            if (this.state != 2) {
                throw new IOException("Cannot request window-change on this channel", getReasonClosedCause());
            }
            packetWindowChange = new PacketWindowChange(this.remoteID, i, i2, i3, i4);
        }
        synchronized (this.channelSendLock) {
            try {
                if (this.closeMessageSent) {
                    throw new IOException("Cannot request window-change on this channel", getReasonClosedCause());
                }
                this.cm.tm.sendMessage(packetWindowChange.getPayload());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setReasonClosed(String str) {
        setReasonClosed(new IOException(str));
    }

    public synchronized void setWindowSize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Invalid value: " + i);
        }
        this.channelBufferSize = i;
    }

    public void signal(String str) {
        PacketSignal packetSignal;
        synchronized (this) {
            if (this.state != 2) {
                throw new IOException("Cannot send signal on this channel", getReasonClosedCause());
            }
            packetSignal = new PacketSignal(this.remoteID, str);
        }
        synchronized (this.channelSendLock) {
            try {
                if (this.closeMessageSent) {
                    throw new IOException("Cannot request window-change on this channel", getReasonClosedCause());
                }
                this.cm.tm.sendMessage(packetSignal.getPayload());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void freeupWindow(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (i <= 0) {
            return;
        }
        synchronized (this) {
            try {
                int i5 = this.localWindow;
                int i6 = this.channelBufferSize;
                if (i5 <= (i6 * 3) / 4) {
                    int i7 = (i6 - this.stdout.readable()) - this.stderr.readable();
                    int i8 = this.localWindow;
                    i2 = i7 - i8;
                    if (i2 > 0) {
                        this.localWindow = i8 + i2;
                    }
                } else {
                    i2 = 0;
                }
                i3 = this.remoteID;
                i4 = this.localID;
            } finally {
            }
        }
        if (i2 > 0) {
            Logger logger = log;
            if (logger.isEnabled()) {
                logger.log(80, "Sending SSH_MSG_CHANNEL_WINDOW_ADJUST (channel " + i4 + ", " + i2 + ")");
            }
            synchronized (this.channelSendLock) {
                try {
                    byte[] bArr = this.msgWindowAdjust;
                    bArr[0] = 93;
                    bArr[1] = (byte) (i3 >> 24);
                    bArr[2] = (byte) (i3 >> 16);
                    bArr[3] = (byte) (i3 >> 8);
                    bArr[4] = (byte) i3;
                    bArr[5] = (byte) (i2 >> 24);
                    bArr[6] = (byte) (i2 >> 16);
                    bArr[7] = (byte) (i2 >> 8);
                    bArr[8] = (byte) i2;
                    if (!this.closeMessageSent) {
                        if (z) {
                            this.cm.tm.sendAsynchronousMessage(bArr);
                        } else {
                            this.cm.tm.sendMessage(bArr);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public void setReasonClosed(Throwable th) {
        synchronized (this.reasonClosedLock) {
            try {
                if (this.reasonClosed == null) {
                    this.reasonClosed = th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
