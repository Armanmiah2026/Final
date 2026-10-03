package com.trilead.ssh2.channel;

import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.PacketChannelOpenConfirmation;
import com.trilead.ssh2.packets.PacketChannelOpenFailure;
import com.trilead.ssh2.packets.PacketChannelTrileadPing;
import com.trilead.ssh2.packets.PacketGlobalCancelForwardRequest;
import com.trilead.ssh2.packets.PacketGlobalForwardRequest;
import com.trilead.ssh2.packets.PacketGlobalTrileadPing;
import com.trilead.ssh2.packets.PacketOpenDirectTCPIPChannel;
import com.trilead.ssh2.packets.PacketOpenSessionChannel;
import com.trilead.ssh2.packets.PacketSessionExecCommand;
import com.trilead.ssh2.packets.PacketSessionPtyRequest;
import com.trilead.ssh2.packets.PacketSessionStartShell;
import com.trilead.ssh2.packets.PacketSessionSubsystemRequest;
import com.trilead.ssh2.packets.PacketSessionX11Request;
import com.trilead.ssh2.packets.Packets;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.transport.MessageHandler;
import com.trilead.ssh2.transport.TransportManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.Vector;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ChannelManager implements MessageHandler {
    private static final Logger log = Logger.getLogger(ChannelManager.class);
    TransportManager tm;
    private final HashMap x11_magic_cookies = new HashMap();
    private final Vector channels = new Vector();
    private int nextLocalChannel = 100;
    private boolean shutdown = false;
    private int globalSuccessCounter = 0;
    private int globalFailedCounter = 0;
    private final HashMap remoteForwardings = new HashMap();
    private final Vector listenerThreads = new Vector();
    private boolean listenerThreadsAllowed = true;

    public ChannelManager(TransportManager transportManager) {
        this.tm = transportManager;
        transportManager.registerMessageHandler(this, 80, 100);
    }

    private int addChannel(Channel channel) {
        int i;
        synchronized (this.channels) {
            this.channels.addElement(channel);
            i = this.nextLocalChannel;
            this.nextLocalChannel = i + 1;
        }
        return i;
    }

    private Channel getChannel(int i) {
        synchronized (this.channels) {
            for (int i2 = 0; i2 < this.channels.size(); i2++) {
                try {
                    Channel channel = (Channel) this.channels.elementAt(i2);
                    if (channel.localID == i) {
                        return channel;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    private IOException ioException(String str, Channel channel) {
        return new IOException(str, channel.getReasonClosedCause());
    }

    private void removeChannel(int i) {
        synchronized (this.channels) {
            int i2 = 0;
            while (true) {
                try {
                    if (i2 >= this.channels.size()) {
                        break;
                    }
                    if (((Channel) this.channels.elementAt(i2)).localID == i) {
                        this.channels.removeElementAt(i2);
                        break;
                    }
                    i2++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r1 = r4.failedCounter;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        if (r1 != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r0 != 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003a, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        if (r1 != 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
    
        if (r0 != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        throw new java.io.IOException("Illegal state. The server sent " + r4.successCounter + " SSH_MSG_CHANNEL_SUCCESS and " + r4.failedCounter + " SSH_MSG_CHANNEL_FAILURE messages.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean waitForChannelRequestResult(com.trilead.ssh2.channel.Channel r4) {
        /*
            r3 = this;
            monitor-enter(r4)
        L1:
            int r0 = r4.successCounter     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L32
            int r1 = r4.failedCounter     // Catch: java.lang.Throwable -> L12
            if (r1 != 0) goto L32
            int r0 = r4.state     // Catch: java.lang.Throwable -> L12
            r1 = 2
            if (r0 != r1) goto L1a
            r4.wait()     // Catch: java.lang.Throwable -> L12 java.lang.InterruptedException -> L14
            goto L1
        L12:
            r0 = move-exception
            goto L6a
        L14:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            throw r0     // Catch: java.lang.Throwable -> L12
        L1a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = "This SSH2 channel is not open. state: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            int r1 = r4.state     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            java.io.IOException r0 = r3.ioException(r0, r4)     // Catch: java.lang.Throwable -> L12
            throw r0     // Catch: java.lang.Throwable -> L12
        L32:
            int r1 = r4.failedCounter     // Catch: java.lang.Throwable -> L12
            r2 = 1
            if (r1 != 0) goto L3b
            if (r0 != r2) goto L3b
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            return r2
        L3b:
            if (r1 != r2) goto L42
            if (r0 != 0) goto L42
            r0 = 0
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            return r0
        L42:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r1.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = "Illegal state. The server sent "
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            int r2 = r4.successCounter     // Catch: java.lang.Throwable -> L12
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = " SSH_MSG_CHANNEL_SUCCESS and "
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            int r2 = r4.failedCounter     // Catch: java.lang.Throwable -> L12
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = " SSH_MSG_CHANNEL_FAILURE messages."
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L12
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L12
            throw r0     // Catch: java.lang.Throwable -> L12
        L6a:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L12
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trilead.ssh2.channel.ChannelManager.waitForChannelRequestResult(com.trilead.ssh2.channel.Channel):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
    
        r2 = r4.globalFailedCounter;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        if (r2 != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002a, code lost:
    
        if (r1 != 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:
    
        if (r2 != 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0030, code lost:
    
        if (r1 != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0034, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        throw new java.io.IOException("Illegal state. The server sent " + r4.globalSuccessCounter + " SSH_MSG_REQUEST_SUCCESS and " + r4.globalFailedCounter + " SSH_MSG_REQUEST_FAILURE messages.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean waitForGlobalRequestResult() {
        /*
            r4 = this;
            java.util.Vector r0 = r4.channels
            monitor-enter(r0)
        L3:
            int r1 = r4.globalSuccessCounter     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L25
            int r2 = r4.globalFailedCounter     // Catch: java.lang.Throwable -> L15
            if (r2 != 0) goto L25
            boolean r1 = r4.shutdown     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L1d
            java.util.Vector r1 = r4.channels     // Catch: java.lang.Throwable -> L15 java.lang.InterruptedException -> L17
            r1.wait()     // Catch: java.lang.Throwable -> L15 java.lang.InterruptedException -> L17
            goto L3
        L15:
            r1 = move-exception
            goto L5d
        L17:
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L15
            r1.<init>()     // Catch: java.lang.Throwable -> L15
            throw r1     // Catch: java.lang.Throwable -> L15
        L1d:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L15
            java.lang.String r2 = "The connection is being shutdown"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L15
            throw r1     // Catch: java.lang.Throwable -> L15
        L25:
            int r2 = r4.globalFailedCounter     // Catch: java.lang.Throwable -> L15
            r3 = 1
            if (r2 != 0) goto L2e
            if (r1 != r3) goto L2e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return r3
        L2e:
            if (r2 != r3) goto L35
            if (r1 != 0) goto L35
            r1 = 0
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return r1
        L35:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L15
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L15
            r2.<init>()     // Catch: java.lang.Throwable -> L15
            java.lang.String r3 = "Illegal state. The server sent "
            r2.append(r3)     // Catch: java.lang.Throwable -> L15
            int r3 = r4.globalSuccessCounter     // Catch: java.lang.Throwable -> L15
            r2.append(r3)     // Catch: java.lang.Throwable -> L15
            java.lang.String r3 = " SSH_MSG_REQUEST_SUCCESS and "
            r2.append(r3)     // Catch: java.lang.Throwable -> L15
            int r3 = r4.globalFailedCounter     // Catch: java.lang.Throwable -> L15
            r2.append(r3)     // Catch: java.lang.Throwable -> L15
            java.lang.String r3 = " SSH_MSG_REQUEST_FAILURE messages."
            r2.append(r3)     // Catch: java.lang.Throwable -> L15
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L15
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L15
            throw r1     // Catch: java.lang.Throwable -> L15
        L5d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trilead.ssh2.channel.ChannelManager.waitForGlobalRequestResult():boolean");
    }

    private void waitUntilChannelOpen(Channel channel) {
        int i;
        synchronized (channel) {
            while (true) {
                i = channel.state;
                if (i != 1) {
                    break;
                }
                try {
                    channel.wait();
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            }
            if (i != 2) {
                removeChannel(channel.localID);
                throw ioException("Could not open channel (state:" + channel.state + ")", channel);
            }
        }
    }

    public X11ServerData checkX11Cookie(String str) {
        synchronized (this.x11_magic_cookies) {
            try {
                if (str == null) {
                    return null;
                }
                return (X11ServerData) this.x11_magic_cookies.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void closeAllChannels() {
        Vector vector;
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Closing all channels");
        }
        synchronized (this.channels) {
            vector = (Vector) this.channels.clone();
        }
        for (int i = 0; i < vector.size(); i++) {
            try {
                closeChannel((Channel) vector.elementAt(i), "Closing all channels", true);
            } catch (IOException unused) {
            }
        }
    }

    public void closeChannel(Channel channel, String str, boolean z) {
        byte[] bArr = new byte[5];
        synchronized (channel) {
            if (z) {
                try {
                    channel.state = 4;
                    channel.eof();
                } finally {
                }
            }
            channel.setReasonClosed(str);
            bArr[0] = 97;
            int i = channel.remoteID;
            bArr[1] = (byte) (i >> 24);
            bArr[2] = (byte) (i >> 16);
            bArr[3] = (byte) (i >> 8);
            bArr[4] = (byte) i;
            channel.notifyAll();
        }
        synchronized (channel.channelSendLock) {
            try {
                if (channel.closeMessageSent) {
                    return;
                }
                this.tm.sendMessage(bArr);
                channel.closeMessageSent = true;
                Logger logger = log;
                if (logger.isEnabled()) {
                    logger.log(50, "Sent SSH_MSG_CHANNEL_CLOSE (channel " + channel.localID + ")");
                }
            } finally {
            }
        }
    }

    public int getAvailable(Channel channel, boolean z) {
        int iAvailable;
        synchronized (channel) {
            try {
                iAvailable = (z ? channel.stderr : channel.stdout).available();
            } catch (Throwable th) {
                throw th;
            }
        }
        return iAvailable;
    }

    public int getChannelData(Channel channel, boolean z, byte[] bArr, int i, int i2) {
        synchronized (channel) {
            try {
                try {
                    int i3 = (z ? channel.stderr : channel.stdout).read(bArr, i, i2);
                    if (i3 <= 0) {
                        return i3;
                    }
                    channel.freeupWindow(i3);
                    return i3;
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.trilead.ssh2.transport.MessageHandler
    public void handleEndMessage(Throwable th) {
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "HandleMessage: got shutdown");
        }
        synchronized (this.listenerThreads) {
            for (int i = 0; i < this.listenerThreads.size(); i++) {
                try {
                    ((IChannelWorkerThread) this.listenerThreads.elementAt(i)).stopWorking();
                } finally {
                }
            }
            this.listenerThreadsAllowed = false;
        }
        synchronized (this.channels) {
            try {
                this.shutdown = true;
                for (int i2 = 0; i2 < this.channels.size(); i2++) {
                    Channel channel = (Channel) this.channels.elementAt(i2);
                    synchronized (channel) {
                        channel.eof();
                        channel.state = 4;
                        channel.setReasonClosed(new IOException("The connection is being shutdown", th));
                        channel.closeMessageRecv = true;
                        channel.notifyAll();
                    }
                }
                this.channels.setSize(0);
                this.channels.trimToSize();
                this.channels.notifyAll();
            } finally {
            }
        }
    }

    @Override // com.trilead.ssh2.transport.MessageHandler
    public void handleMessage(byte[] bArr, int i) throws IOException {
        byte b = bArr[0];
        switch (b) {
            case Packets.SSH_MSG_GLOBAL_REQUEST /* 80 */:
                msgGlobalRequest(bArr, i);
                return;
            case Packets.SSH_MSG_REQUEST_SUCCESS /* 81 */:
                msgGlobalSuccess();
                return;
            case Packets.SSH_MSG_REQUEST_FAILURE /* 82 */:
                msgGlobalFailure();
                return;
            default:
                switch (b) {
                    case 90:
                        msgChannelOpen(bArr, i);
                        return;
                    case 91:
                        msgChannelOpenConfirmation(bArr, i);
                        return;
                    case 92:
                        msgChannelOpenFailure(bArr, i);
                        return;
                    case 93:
                        msgChannelWindowAdjust(bArr, i);
                        return;
                    case Packets.SSH_MSG_CHANNEL_DATA /* 94 */:
                        msgChannelData(bArr, i);
                        return;
                    case Packets.SSH_MSG_CHANNEL_EXTENDED_DATA /* 95 */:
                        msgChannelExtendedData(bArr, i);
                        return;
                    case Packets.SSH_MSG_CHANNEL_EOF /* 96 */:
                        msgChannelEOF(bArr, i);
                        return;
                    case Packets.SSH_MSG_CHANNEL_CLOSE /* 97 */:
                        msgChannelClose(bArr, i);
                        return;
                    case Packets.SSH_MSG_CHANNEL_REQUEST /* 98 */:
                        msgChannelRequest(bArr, i);
                        return;
                    case Packets.SSH_MSG_CHANNEL_SUCCESS /* 99 */:
                        msgChannelSuccess(bArr, i);
                        return;
                    case Packets.SSH_MSG_CHANNEL_FAILURE /* 100 */:
                        msgChannelFailure(bArr, i);
                        return;
                    default:
                        throw new IOException("Cannot handle unknown channel message " + (bArr[0] & 255));
                }
        }
    }

    public void msgChannelClose(byte[] bArr, int i) throws IOException {
        if (i != 5) {
            throw new IOException(za0.i(i, "SSH_MSG_CHANNEL_CLOSE message has wrong size (", ")"));
        }
        int i2 = (bArr[4] & 255) | ((bArr[1] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 8);
        Channel channel = getChannel(i2);
        if (channel == null) {
            throw new IOException(za0.h(i2, "Unexpected SSH_MSG_CHANNEL_CLOSE message for non-existent channel "));
        }
        synchronized (channel) {
            channel.eof();
            channel.state = 4;
            channel.setReasonClosed("Close requested by remote");
            channel.closeMessageRecv = true;
            removeChannel(channel.localID);
            channel.notifyAll();
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Got SSH_MSG_CHANNEL_CLOSE (channel " + i2 + ")");
        }
    }

    public void msgChannelData(byte[] bArr, int i) throws IOException {
        if (i <= 9) {
            throw new IOException(za0.i(i, "SSH_MSG_CHANNEL_DATA message has wrong size (", ")"));
        }
        int i2 = ((bArr[1] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 8) | (bArr[4] & 255);
        int i3 = (bArr[8] & 255) | ((bArr[5] & 255) << 24) | ((bArr[6] & 255) << 16) | ((bArr[7] & 255) << 8);
        Channel channel = getChannel(i2);
        if (channel == null) {
            throw new IOException(za0.h(i2, "Unexpected SSH_MSG_CHANNEL_DATA message for non-existent channel "));
        }
        int i4 = i - 9;
        if (i3 != i4) {
            throw new IOException("SSH_MSG_CHANNEL_DATA message has wrong len (calculated " + i4 + ", got " + i3 + ")");
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Got SSH_MSG_CHANNEL_DATA (channel " + i2 + ", " + i3 + ")");
        }
        synchronized (channel) {
            try {
                int i5 = channel.state;
                if (i5 == 4) {
                    return;
                }
                if (i5 != 2) {
                    throw new IOException("Got SSH_MSG_CHANNEL_DATA, but channel is not in correct state (" + channel.state + ")");
                }
                int i6 = channel.localWindow;
                if (i6 < i3) {
                    throw new IOException("Remote sent too much data, does not fit into window.");
                }
                channel.localWindow = i6 - i3;
                channel.stdout.write(bArr, 9, i3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void msgChannelEOF(byte[] bArr, int i) throws IOException {
        if (i != 5) {
            throw new IOException(za0.i(i, "SSH_MSG_CHANNEL_EOF message has wrong size (", ")"));
        }
        int i2 = (bArr[4] & 255) | ((bArr[1] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 8);
        Channel channel = getChannel(i2);
        if (channel == null) {
            throw new IOException(za0.h(i2, "Unexpected SSH_MSG_CHANNEL_EOF message for non-existent channel "));
        }
        channel.eof();
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Got SSH_MSG_CHANNEL_EOF (channel " + i2 + ")");
        }
    }

    public void msgChannelExtendedData(byte[] bArr, int i) throws IOException {
        if (i <= 13) {
            throw new IOException(za0.i(i, "SSH_MSG_CHANNEL_EXTENDED_DATA message has wrong size (", ")"));
        }
        int i2 = ((bArr[1] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 8) | (bArr[4] & 255);
        int i3 = ((bArr[5] & 255) << 24) | ((bArr[6] & 255) << 16) | ((bArr[7] & 255) << 8) | (bArr[8] & 255);
        int i4 = ((bArr[11] & 255) << 8) | ((bArr[9] & 255) << 24) | ((bArr[10] & 255) << 16) | (bArr[12] & 255);
        Channel channel = getChannel(i2);
        if (channel == null) {
            throw new IOException(za0.h(i2, "Unexpected SSH_MSG_CHANNEL_EXTENDED_DATA message for non-existent channel "));
        }
        if (i3 != 1) {
            throw new IOException(za0.i(i3, "SSH_MSG_CHANNEL_EXTENDED_DATA message has unknown type (", ")"));
        }
        int i5 = i - 13;
        if (i4 != i5) {
            throw new IOException("SSH_MSG_CHANNEL_EXTENDED_DATA message has wrong len (calculated " + i5 + ", got " + i4 + ")");
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Got SSH_MSG_CHANNEL_EXTENDED_DATA (channel " + i2 + ", " + i4 + ")");
        }
        synchronized (channel) {
            try {
                int i6 = channel.state;
                if (i6 == 4) {
                    return;
                }
                if (i6 != 2) {
                    throw new IOException("Got SSH_MSG_CHANNEL_EXTENDED_DATA, but channel is not in correct state (" + channel.state + ")");
                }
                int i7 = channel.localWindow;
                if (i7 < i4) {
                    throw new IOException("Remote sent too much data, does not fit into window.");
                }
                channel.localWindow = i7 - i4;
                channel.stderr.write(bArr, 13, i4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void msgChannelFailure(byte[] bArr, int i) throws IOException {
        if (i != 5) {
            throw new IOException(za0.i(i, "SSH_MSG_CHANNEL_FAILURE message has wrong size (", ")"));
        }
        int i2 = (bArr[4] & 255) | ((bArr[1] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 8);
        Channel channel = getChannel(i2);
        if (channel == null) {
            throw new IOException(za0.h(i2, "Unexpected SSH_MSG_CHANNEL_FAILURE message for non-existent channel "));
        }
        synchronized (channel) {
            channel.failedCounter++;
            channel.notifyAll();
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Got SSH_MSG_CHANNEL_FAILURE (channel " + i2 + ")");
        }
    }

    public void msgChannelOpen(byte[] bArr, int i) throws IOException {
        RemoteForwardingData remoteForwardingData;
        TypesReader typesReader = new TypesReader(bArr, 0, i);
        typesReader.readByte();
        String string = typesReader.readString();
        int uint32 = typesReader.readUINT32();
        int uint322 = typesReader.readUINT32();
        int uint323 = typesReader.readUINT32();
        if ("x11".equals(string)) {
            synchronized (this.x11_magic_cookies) {
                try {
                    if (this.x11_magic_cookies.size() == 0) {
                        this.tm.sendAsynchronousMessage(new PacketChannelOpenFailure(uint32, 1, "X11 forwarding not activated", "").getPayload());
                        Logger logger = log;
                        if (logger.isEnabled()) {
                            logger.log(20, "Unexpected X11 request, denying it!");
                        }
                        return;
                    }
                    String string2 = typesReader.readString();
                    int uint324 = typesReader.readUINT32();
                    Channel channel = new Channel(this);
                    synchronized (channel) {
                        channel.remoteID = uint32;
                        channel.remoteWindow = ((long) uint322) & 4294967295L;
                        channel.remoteMaxPacketSize = uint323;
                        channel.localID = addChannel(channel);
                    }
                    RemoteX11AcceptThread remoteX11AcceptThread = new RemoteX11AcceptThread(channel, string2, uint324);
                    remoteX11AcceptThread.setDaemon(true);
                    remoteX11AcceptThread.start();
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (!"forwarded-tcpip".equals(string)) {
            this.tm.sendAsynchronousMessage(new PacketChannelOpenFailure(uint32, 3, "Unknown channel type", "").getPayload());
            Logger logger2 = log;
            if (logger2.isEnabled()) {
                logger2.log(20, "The peer tried to open an unsupported channel type (" + string + ")");
                return;
            }
            return;
        }
        String string3 = typesReader.readString();
        int uint325 = typesReader.readUINT32();
        String string4 = typesReader.readString();
        int uint326 = typesReader.readUINT32();
        synchronized (this.remoteForwardings) {
            remoteForwardingData = (RemoteForwardingData) this.remoteForwardings.get(Integer.valueOf(uint325));
        }
        if (remoteForwardingData == null) {
            this.tm.sendAsynchronousMessage(new PacketChannelOpenFailure(uint32, 1, "No thanks, unknown port in forwarded-tcpip request", "").getPayload());
            Logger logger3 = log;
            if (logger3.isEnabled()) {
                logger3.log(20, "Unexpected forwarded-tcpip request, denying it!");
                return;
            }
            return;
        }
        Channel channel2 = new Channel(this);
        synchronized (channel2) {
            channel2.remoteID = uint32;
            channel2.remoteWindow = ((long) uint322) & 4294967295L;
            channel2.remoteMaxPacketSize = uint323;
            channel2.localID = addChannel(channel2);
        }
        RemoteAcceptThread remoteAcceptThread = new RemoteAcceptThread(channel2, string3, uint325, string4, uint326, remoteForwardingData.targetAddress, remoteForwardingData.targetPort);
        remoteAcceptThread.setDaemon(true);
        remoteAcceptThread.start();
    }

    public void msgChannelOpenConfirmation(byte[] bArr, int i) throws IOException {
        PacketChannelOpenConfirmation packetChannelOpenConfirmation = new PacketChannelOpenConfirmation(bArr, 0, i);
        Channel channel = getChannel(packetChannelOpenConfirmation.recipientChannelID);
        if (channel == null) {
            throw new IOException("Unexpected SSH_MSG_CHANNEL_OPEN_CONFIRMATION message for non-existent channel " + packetChannelOpenConfirmation.recipientChannelID);
        }
        synchronized (channel) {
            if (channel.state != 1) {
                throw new IOException("Unexpected SSH_MSG_CHANNEL_OPEN_CONFIRMATION message for channel " + packetChannelOpenConfirmation.recipientChannelID);
            }
            channel.remoteID = packetChannelOpenConfirmation.senderChannelID;
            channel.remoteWindow = ((long) packetChannelOpenConfirmation.initialWindowSize) & 4294967295L;
            channel.remoteMaxPacketSize = packetChannelOpenConfirmation.maxPacketSize;
            channel.state = 2;
            channel.notifyAll();
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Got SSH_MSG_CHANNEL_OPEN_CONFIRMATION (channel " + packetChannelOpenConfirmation.recipientChannelID + " / remote: " + packetChannelOpenConfirmation.senderChannelID + ")");
        }
    }

    public void msgChannelOpenFailure(byte[] bArr, int i) throws IOException {
        if (i < 5) {
            throw new IOException(za0.i(i, "SSH_MSG_CHANNEL_OPEN_FAILURE message has wrong size (", ")"));
        }
        TypesReader typesReader = new TypesReader(bArr, 0, i);
        typesReader.readByte();
        int uint32 = typesReader.readUINT32();
        Channel channel = getChannel(uint32);
        if (channel == null) {
            throw new IOException(za0.h(uint32, "Unexpected SSH_MSG_CHANNEL_OPEN_FAILURE message for non-existent channel "));
        }
        int uint322 = typesReader.readUINT32();
        String string = typesReader.readString("UTF-8");
        String strI = uint322 != 1 ? uint322 != 2 ? uint322 != 3 ? uint322 != 4 ? za0.i(uint322, "UNKNOWN REASON CODE (", ")") : "SSH_OPEN_RESOURCE_SHORTAGE" : "SSH_OPEN_UNKNOWN_CHANNEL_TYPE" : "SSH_OPEN_CONNECT_FAILED" : "SSH_OPEN_ADMINISTRATIVELY_PROHIBITED";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            char cCharAt = stringBuffer.charAt(i2);
            if (cCharAt < ' ' || cCharAt > '~') {
                stringBuffer.setCharAt(i2, (char) 65533);
            }
        }
        synchronized (channel) {
            channel.eof();
            channel.state = 4;
            channel.setReasonClosed("The server refused to open the channel (" + strI + ", '" + ((Object) stringBuffer) + "')");
            channel.notifyAll();
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Got SSH_MSG_CHANNEL_OPEN_FAILURE (channel " + uint32 + ")");
        }
    }

    public void msgChannelRequest(byte[] bArr, int i) throws IOException {
        TypesReader typesReader = new TypesReader(bArr, 0, i);
        typesReader.readByte();
        int uint32 = typesReader.readUINT32();
        Channel channel = getChannel(uint32);
        if (channel == null) {
            throw new IOException(za0.h(uint32, "Unexpected SSH_MSG_CHANNEL_REQUEST message for non-existent channel "));
        }
        String string = typesReader.readString("US-ASCII");
        boolean z = typesReader.readBoolean();
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Got SSH_MSG_CHANNEL_REQUEST (channel " + uint32 + ", '" + string + "')");
        }
        if (string.equals("exit-status")) {
            if (z) {
                throw new IOException("Badly formatted SSH_MSG_CHANNEL_REQUEST message, 'want reply' is true");
            }
            int uint322 = typesReader.readUINT32();
            if (typesReader.remain() != 0) {
                throw new IOException("Badly formatted SSH_MSG_CHANNEL_REQUEST message");
            }
            synchronized (channel) {
                channel.exit_status = Integer.valueOf(uint322);
                channel.notifyAll();
            }
            if (logger.isEnabled()) {
                logger.log(50, "Got EXIT STATUS (channel " + uint32 + ", status " + uint322 + ")");
                return;
            }
            return;
        }
        if (!string.equals("exit-signal")) {
            if (z) {
                int i2 = channel.remoteID;
                this.tm.sendAsynchronousMessage(new byte[]{100, (byte) (i2 >> 24), (byte) (i2 >> 16), (byte) (i2 >> 8), (byte) i2});
            }
            if (logger.isEnabled()) {
                logger.log(50, "Channel request '" + string + "' is not known, ignoring it");
                return;
            }
            return;
        }
        if (z) {
            throw new IOException("Badly formatted SSH_MSG_CHANNEL_REQUEST message, 'want reply' is true");
        }
        String string2 = typesReader.readString("US-ASCII");
        typesReader.readBoolean();
        typesReader.readString();
        typesReader.readString();
        if (typesReader.remain() != 0) {
            throw new IOException("Badly formatted SSH_MSG_CHANNEL_REQUEST message");
        }
        synchronized (channel) {
            channel.exit_signal = string2;
            channel.notifyAll();
        }
        if (logger.isEnabled()) {
            logger.log(50, "Got EXIT SIGNAL (channel " + uint32 + ", signal " + string2 + ")");
        }
    }

    public void msgChannelSuccess(byte[] bArr, int i) throws IOException {
        if (i != 5) {
            throw new IOException(za0.i(i, "SSH_MSG_CHANNEL_SUCCESS message has wrong size (", ")"));
        }
        int i2 = (bArr[4] & 255) | ((bArr[1] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 8);
        Channel channel = getChannel(i2);
        if (channel == null) {
            throw new IOException(za0.h(i2, "Unexpected SSH_MSG_CHANNEL_SUCCESS message for non-existent channel "));
        }
        synchronized (channel) {
            channel.successCounter++;
            channel.notifyAll();
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Got SSH_MSG_CHANNEL_SUCCESS (channel " + i2 + ")");
        }
    }

    public void msgChannelWindowAdjust(byte[] bArr, int i) throws IOException {
        if (i != 9) {
            throw new IOException(za0.i(i, "SSH_MSG_CHANNEL_WINDOW_ADJUST message has wrong size (", ")"));
        }
        int i2 = ((bArr[1] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 8) | (bArr[4] & 255);
        int i3 = (bArr[8] & 255) | ((bArr[5] & 255) << 24) | ((bArr[6] & 255) << 16) | ((bArr[7] & 255) << 8);
        Channel channel = getChannel(i2);
        if (channel == null) {
            throw new IOException(za0.h(i2, "Unexpected SSH_MSG_CHANNEL_WINDOW_ADJUST message for non-existent channel "));
        }
        synchronized (channel) {
            try {
                long j = channel.remoteWindow + (((long) i3) & 4294967295L);
                channel.remoteWindow = j;
                if (j > 4294967295L) {
                    channel.remoteWindow = 4294967295L;
                }
                channel.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Got SSH_MSG_CHANNEL_WINDOW_ADJUST (channel " + i2 + ", " + i3 + ")");
        }
    }

    public void msgGlobalFailure() {
        synchronized (this.channels) {
            this.globalFailedCounter++;
            this.channels.notifyAll();
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Got SSH_MSG_REQUEST_FAILURE");
        }
    }

    public void msgGlobalRequest(byte[] bArr, int i) throws IOException {
        TypesReader typesReader = new TypesReader(bArr, 0, i);
        typesReader.readByte();
        String string = typesReader.readString();
        if (typesReader.readBoolean()) {
            this.tm.sendAsynchronousMessage(new byte[]{82});
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Got SSH_MSG_GLOBAL_REQUEST (" + string + ")");
        }
    }

    public void msgGlobalSuccess() {
        synchronized (this.channels) {
            this.globalSuccessCounter++;
            this.channels.notifyAll();
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Got SSH_MSG_REQUEST_SUCCESS");
        }
    }

    public Channel openDirectTCPIPChannel(String str, int i, String str2, int i2) throws IOException {
        int iAddChannel;
        Channel channel = new Channel(this);
        synchronized (channel) {
            iAddChannel = addChannel(channel);
            channel.localID = iAddChannel;
        }
        this.tm.sendMessage(new PacketOpenDirectTCPIPChannel(iAddChannel, channel.localWindow, channel.localMaxPacketSize, str, i, str2, i2).getPayload());
        waitUntilChannelOpen(channel);
        return channel;
    }

    public Channel openSessionChannel() throws IOException {
        Channel channel = new Channel(this);
        synchronized (channel) {
            channel.localID = addChannel(channel);
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Sending SSH_MSG_CHANNEL_OPEN (Channel " + channel.localID + ")");
        }
        this.tm.sendMessage(new PacketOpenSessionChannel(channel.localID, channel.localWindow, channel.localMaxPacketSize).getPayload());
        waitUntilChannelOpen(channel);
        return channel;
    }

    public void registerThread(IChannelWorkerThread iChannelWorkerThread) {
        synchronized (this.listenerThreads) {
            try {
                if (!this.listenerThreadsAllowed) {
                    throw new IOException("Too late, this connection is closed.");
                }
                this.listenerThreads.addElement(iChannelWorkerThread);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void registerX11Cookie(String str, X11ServerData x11ServerData) {
        synchronized (this.x11_magic_cookies) {
            this.x11_magic_cookies.put(str, x11ServerData);
        }
    }

    public void requestCancelGlobalForward(int i) throws IOException {
        RemoteForwardingData remoteForwardingData;
        synchronized (this.remoteForwardings) {
            remoteForwardingData = (RemoteForwardingData) this.remoteForwardings.get(Integer.valueOf(i));
            if (remoteForwardingData == null) {
                throw new IOException("Sorry, there is no known remote forwarding for remote port " + i);
            }
        }
        synchronized (this.channels) {
            this.globalFailedCounter = 0;
            this.globalSuccessCounter = 0;
        }
        this.tm.sendMessage(new PacketGlobalCancelForwardRequest(true, remoteForwardingData.bindAddress, remoteForwardingData.bindPort).getPayload());
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Requesting cancelation of remote forward ('" + remoteForwardingData.bindAddress + "', " + remoteForwardingData.bindPort + ")");
        }
        try {
            if (!waitForGlobalRequestResult()) {
                throw new IOException("The server denied the request.");
            }
            synchronized (this.remoteForwardings) {
                this.remoteForwardings.remove(remoteForwardingData);
            }
        } catch (Throwable th) {
            synchronized (this.remoteForwardings) {
                this.remoteForwardings.remove(remoteForwardingData);
                throw th;
            }
        }
    }

    public void requestChannelTrileadPing(Channel channel) {
        PacketChannelTrileadPing packetChannelTrileadPing;
        synchronized (channel) {
            if (channel.state != 2) {
                throw ioException("Cannot ping this channel", channel);
            }
            packetChannelTrileadPing = new PacketChannelTrileadPing(channel.remoteID);
            channel.failedCounter = 0;
            channel.successCounter = 0;
        }
        synchronized (channel.channelSendLock) {
            if (channel.closeMessageSent) {
                throw ioException("Cannot ping this channel", channel);
            }
            this.tm.sendMessage(packetChannelTrileadPing.getPayload());
        }
        try {
            if (waitForChannelRequestResult(channel)) {
                throw new IOException("Your server is alive - but buggy. It replied with SSH_MSG_SESSION_SUCCESS when it actually should not.");
            }
        } catch (IOException e) {
            throw new IOException("The ping request failed.", e);
        }
    }

    public void requestExecCommand(Channel channel, String str) {
        PacketSessionExecCommand packetSessionExecCommand;
        synchronized (channel) {
            if (channel.state != 2) {
                throw ioException("Cannot execute command on this channel", channel);
            }
            packetSessionExecCommand = new PacketSessionExecCommand(channel.remoteID, true, str);
            channel.failedCounter = 0;
            channel.successCounter = 0;
        }
        synchronized (channel.channelSendLock) {
            if (channel.closeMessageSent) {
                throw ioException("Cannot execute command on this channel", channel);
            }
            this.tm.sendMessage(packetSessionExecCommand.getPayload());
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Executing command (channel " + channel.localID + ", '" + str + "')");
        }
        try {
            if (waitForChannelRequestResult(channel)) {
            } else {
                throw new IOException("The server denied the request.");
            }
        } catch (IOException e) {
            throw new IOException("The execute request failed.", e);
        }
    }

    public int requestGlobalForward(String str, int i, String str2, int i2) throws IOException {
        RemoteForwardingData remoteForwardingData = new RemoteForwardingData();
        remoteForwardingData.bindAddress = str;
        remoteForwardingData.bindPort = i;
        remoteForwardingData.targetAddress = str2;
        remoteForwardingData.targetPort = i2;
        synchronized (this.remoteForwardings) {
            Integer numValueOf = Integer.valueOf(i);
            if (this.remoteForwardings.get(numValueOf) != null) {
                throw new IOException("There is already a forwarding for remote port " + i);
            }
            this.remoteForwardings.put(numValueOf, remoteForwardingData);
        }
        synchronized (this.channels) {
            this.globalFailedCounter = 0;
            this.globalSuccessCounter = 0;
        }
        this.tm.sendMessage(new PacketGlobalForwardRequest(true, str, i).getPayload());
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Requesting a remote forwarding ('" + str + "', " + i + ")");
        }
        try {
            if (waitForGlobalRequestResult()) {
                return i;
            }
            throw new IOException("The server denied the request (did you enable port forwarding?)");
        } catch (IOException e) {
            synchronized (this.remoteForwardings) {
                this.remoteForwardings.remove(remoteForwardingData);
                throw e;
            }
        }
    }

    public long requestGlobalTrileadPing() throws IOException {
        synchronized (this.channels) {
            this.globalFailedCounter = 0;
            this.globalSuccessCounter = 0;
        }
        PacketGlobalTrileadPing packetGlobalTrileadPing = new PacketGlobalTrileadPing();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.tm.sendMessage(packetGlobalTrileadPing.getPayload());
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Sending SSH_MSG_GLOBAL_REQUEST 'trilead-ping'.");
        }
        try {
            return waitForGlobalRequestResult() ? System.currentTimeMillis() - jCurrentTimeMillis : System.currentTimeMillis() - jCurrentTimeMillis;
        } catch (IOException e) {
            throw new IOException("The ping request failed.", e);
        }
    }

    public void requestPTY(Channel channel, String str, int i, int i2, int i3, int i4, byte[] bArr) {
        PacketSessionPtyRequest packetSessionPtyRequest;
        synchronized (channel) {
            if (channel.state != 2) {
                throw ioException("Cannot request PTY on this channel", channel);
            }
            packetSessionPtyRequest = new PacketSessionPtyRequest(channel.remoteID, true, str, i, i2, i3, i4, bArr);
            channel.failedCounter = 0;
            channel.successCounter = 0;
        }
        synchronized (channel.channelSendLock) {
            if (channel.closeMessageSent) {
                throw ioException("Cannot request PTY on this channel", channel);
            }
            this.tm.sendMessage(packetSessionPtyRequest.getPayload());
        }
        try {
            if (waitForChannelRequestResult(channel)) {
            } else {
                throw new IOException("The server denied the request.");
            }
        } catch (IOException e) {
            throw new IOException("PTY request failed", e);
        }
    }

    public void requestShell(Channel channel) {
        PacketSessionStartShell packetSessionStartShell;
        synchronized (channel) {
            if (channel.state != 2) {
                throw ioException("Cannot start shell on this channel", channel);
            }
            packetSessionStartShell = new PacketSessionStartShell(channel.remoteID, true);
            channel.failedCounter = 0;
            channel.successCounter = 0;
        }
        synchronized (channel.channelSendLock) {
            if (channel.closeMessageSent) {
                throw ioException("Cannot start shell on this channel", channel);
            }
            this.tm.sendMessage(packetSessionStartShell.getPayload());
        }
        try {
            if (waitForChannelRequestResult(channel)) {
            } else {
                throw new IOException("The server denied the request.");
            }
        } catch (IOException e) {
            throw new IOException("The shell request failed.", e);
        }
    }

    public void requestSubSystem(Channel channel, String str) {
        PacketSessionSubsystemRequest packetSessionSubsystemRequest;
        synchronized (channel) {
            if (channel.state != 2) {
                throw ioException("Cannot request subsystem on this channel", channel);
            }
            packetSessionSubsystemRequest = new PacketSessionSubsystemRequest(channel.remoteID, true, str);
            channel.failedCounter = 0;
            channel.successCounter = 0;
        }
        synchronized (channel.channelSendLock) {
            if (channel.closeMessageSent) {
                throw ioException("Cannot request subsystem on this channel", channel);
            }
            this.tm.sendMessage(packetSessionSubsystemRequest.getPayload());
        }
        try {
            if (waitForChannelRequestResult(channel)) {
            } else {
                throw new IOException("The server denied the request.");
            }
        } catch (IOException e) {
            throw new IOException("The subsystem request failed.", e);
        }
    }

    public void requestX11(Channel channel, boolean z, String str, String str2, int i) {
        PacketSessionX11Request packetSessionX11Request;
        synchronized (channel) {
            if (channel.state != 2) {
                throw ioException("Cannot request X11 on this channel", channel);
            }
            packetSessionX11Request = new PacketSessionX11Request(channel.remoteID, true, z, str, str2, i);
            channel.failedCounter = 0;
            channel.successCounter = 0;
        }
        synchronized (channel.channelSendLock) {
            if (channel.closeMessageSent) {
                throw ioException("Cannot request X11 on this channel", channel);
            }
            this.tm.sendMessage(packetSessionX11Request.getPayload());
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Requesting X11 forwarding (Channel " + channel.localID + "/" + channel.remoteID + ")");
        }
        try {
            if (waitForChannelRequestResult(channel)) {
            } else {
                throw new IOException("The server denied the request.");
            }
        } catch (IOException e) {
            throw new IOException("The X11 request failed.", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:
    
        if (r3 < r14) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        r0 = (int) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
    
        r3 = r11.remoteMaxPacketSize - (r10.tm.getPacketOverheadEstimate() + 9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r3 > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        if (r0 <= r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r11.remoteWindow -= (long) r0;
        r3 = new byte[r0 + 9];
        r3[0] = 94;
        r6 = r11.remoteID;
        r3[1] = (byte) (r6 >> 24);
        r3[2] = (byte) (r6 >> 16);
        r3[3] = (byte) (r6 >> 8);
        r3[4] = (byte) r6;
        r3[5] = (byte) (r0 >> 24);
        r3[6] = (byte) (r0 >> 16);
        r3[7] = (byte) (r0 >> 8);
        r3[8] = (byte) r0;
        java.lang.System.arraycopy(r12, r13, r3, 9, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendData(com.trilead.ssh2.channel.Channel r11, byte[] r12, int r13, int r14) {
        /*
            r10 = this;
        L0:
            if (r14 <= 0) goto Lbc
            monitor-enter(r11)
        L3:
            int r0 = r11.state     // Catch: java.lang.Throwable -> L88
            r1 = 4
            if (r0 == r1) goto Lb3
            r2 = 2
            if (r0 != r2) goto L95
            long r3 = r11.remoteWindow     // Catch: java.lang.Throwable -> L88
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L8a
            long r5 = (long) r14     // Catch: java.lang.Throwable -> L88
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L1a
            r0 = r14
            goto L1b
        L1a:
            int r0 = (int) r3     // Catch: java.lang.Throwable -> L88
        L1b:
            int r3 = r11.remoteMaxPacketSize     // Catch: java.lang.Throwable -> L88
            com.trilead.ssh2.transport.TransportManager r4 = r10.tm     // Catch: java.lang.Throwable -> L88
            int r4 = r4.getPacketOverheadEstimate()     // Catch: java.lang.Throwable -> L88
            r5 = 9
            int r4 = r4 + r5
            int r3 = r3 - r4
            r4 = 1
            if (r3 > 0) goto L2b
            r3 = r4
        L2b:
            if (r0 <= r3) goto L2e
            r0 = r3
        L2e:
            long r6 = r11.remoteWindow     // Catch: java.lang.Throwable -> L88
            long r8 = (long) r0     // Catch: java.lang.Throwable -> L88
            long r6 = r6 - r8
            r11.remoteWindow = r6     // Catch: java.lang.Throwable -> L88
            int r3 = r0 + 9
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L88
            r6 = 0
            r7 = 94
            r3[r6] = r7     // Catch: java.lang.Throwable -> L88
            int r6 = r11.remoteID     // Catch: java.lang.Throwable -> L88
            int r7 = r6 >> 24
            byte r7 = (byte) r7     // Catch: java.lang.Throwable -> L88
            r3[r4] = r7     // Catch: java.lang.Throwable -> L88
            int r4 = r6 >> 16
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> L88
            r3[r2] = r4     // Catch: java.lang.Throwable -> L88
            int r2 = r6 >> 8
            byte r2 = (byte) r2     // Catch: java.lang.Throwable -> L88
            r4 = 3
            r3[r4] = r2     // Catch: java.lang.Throwable -> L88
            byte r2 = (byte) r6     // Catch: java.lang.Throwable -> L88
            r3[r1] = r2     // Catch: java.lang.Throwable -> L88
            int r1 = r0 >> 24
            byte r1 = (byte) r1     // Catch: java.lang.Throwable -> L88
            r2 = 5
            r3[r2] = r1     // Catch: java.lang.Throwable -> L88
            int r1 = r0 >> 16
            byte r1 = (byte) r1     // Catch: java.lang.Throwable -> L88
            r2 = 6
            r3[r2] = r1     // Catch: java.lang.Throwable -> L88
            int r1 = r0 >> 8
            byte r1 = (byte) r1     // Catch: java.lang.Throwable -> L88
            r2 = 7
            r3[r2] = r1     // Catch: java.lang.Throwable -> L88
            byte r1 = (byte) r0     // Catch: java.lang.Throwable -> L88
            r2 = 8
            r3[r2] = r1     // Catch: java.lang.Throwable -> L88
            java.lang.System.arraycopy(r12, r13, r3, r5, r0)     // Catch: java.lang.Throwable -> L88
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L88
            java.lang.Object r1 = r11.channelSendLock
            monitor-enter(r1)
            boolean r2 = r11.closeMessageSent     // Catch: java.lang.Throwable -> L7d
            if (r2 != 0) goto L7f
            com.trilead.ssh2.transport.TransportManager r2 = r10.tm     // Catch: java.lang.Throwable -> L7d
            r2.sendMessage(r3)     // Catch: java.lang.Throwable -> L7d
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L7d
            int r13 = r13 + r0
            int r14 = r14 - r0
            goto L0
        L7d:
            r11 = move-exception
            goto L86
        L7f:
            java.lang.String r12 = "SSH channel is closed"
            java.io.IOException r11 = r10.ioException(r12, r11)     // Catch: java.lang.Throwable -> L7d
            throw r11     // Catch: java.lang.Throwable -> L7d
        L86:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L7d
            throw r11
        L88:
            r12 = move-exception
            goto Lba
        L8a:
            r11.wait()     // Catch: java.lang.Throwable -> L88 java.lang.InterruptedException -> L8f
            goto L3
        L8f:
            java.io.InterruptedIOException r12 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L88
            r12.<init>()     // Catch: java.lang.Throwable -> L88
            throw r12     // Catch: java.lang.Throwable -> L88
        L95:
            java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L88
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L88
            r13.<init>()     // Catch: java.lang.Throwable -> L88
            java.lang.String r14 = "SSH channel in strange state. ("
            r13.append(r14)     // Catch: java.lang.Throwable -> L88
            int r14 = r11.state     // Catch: java.lang.Throwable -> L88
            r13.append(r14)     // Catch: java.lang.Throwable -> L88
            java.lang.String r14 = ")"
            r13.append(r14)     // Catch: java.lang.Throwable -> L88
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L88
            r12.<init>(r13)     // Catch: java.lang.Throwable -> L88
            throw r12     // Catch: java.lang.Throwable -> L88
        Lb3:
            java.lang.String r12 = "SSH channel is closed"
            java.io.IOException r12 = r10.ioException(r12, r11)     // Catch: java.lang.Throwable -> L88
            throw r12     // Catch: java.lang.Throwable -> L88
        Lba:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L88
            throw r12
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trilead.ssh2.channel.ChannelManager.sendData(com.trilead.ssh2.channel.Channel, byte[], int, int):void");
    }

    public void sendEOF(Channel channel) {
        byte[] bArr = new byte[5];
        synchronized (channel) {
            try {
                if (channel.state != 2) {
                    return;
                }
                bArr[0] = 96;
                int i = channel.remoteID;
                bArr[1] = (byte) (i >> 24);
                bArr[2] = (byte) (i >> 16);
                bArr[3] = (byte) (i >> 8);
                bArr[4] = (byte) i;
                synchronized (channel.channelSendLock) {
                    try {
                        if (channel.closeMessageSent) {
                            return;
                        }
                        this.tm.sendMessage(bArr);
                        Logger logger = log;
                        if (logger.isEnabled()) {
                            logger.log(50, "Sent EOF (Channel " + channel.localID + "/" + channel.remoteID + ")");
                        }
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    public void sendOpenConfirmation(Channel channel) {
        synchronized (channel) {
            try {
                if (channel.state != 1) {
                    return;
                }
                channel.state = 2;
                PacketChannelOpenConfirmation packetChannelOpenConfirmation = new PacketChannelOpenConfirmation(channel.remoteID, channel.localID, channel.localWindow, channel.localMaxPacketSize);
                synchronized (channel.channelSendLock) {
                    try {
                        if (channel.closeMessageSent) {
                            return;
                        }
                        this.tm.sendMessage(packetChannelOpenConfirmation.getPayload());
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    public void unRegisterX11Cookie(String str, boolean z) {
        Vector vector;
        if (str == null) {
            throw new IllegalStateException("hexFakeCookie may not be null");
        }
        synchronized (this.x11_magic_cookies) {
            this.x11_magic_cookies.remove(str);
        }
        if (z) {
            Logger logger = log;
            if (logger.isEnabled()) {
                logger.log(50, "Closing all X11 channels for the given fake cookie");
            }
            synchronized (this.channels) {
                vector = (Vector) this.channels.clone();
            }
            for (int i = 0; i < vector.size(); i++) {
                Channel channel = (Channel) vector.elementAt(i);
                synchronized (channel) {
                    try {
                        if (str.equals(channel.hexX11FakeCookie)) {
                            try {
                                closeChannel(channel, "Closing X11 channel since the corresponding session is closing", true);
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public int waitForCondition(Channel channel, long j, int i) {
        synchronized (channel) {
            long jCurrentTimeMillis = 0;
            boolean z = false;
            while (true) {
                try {
                    int i2 = channel.stdout.readable();
                    int i3 = channel.stderr.readable();
                    int i4 = i2 > 0 ? 4 : 0;
                    if (i3 > 0) {
                        i4 |= 8;
                    }
                    if (channel.isEOF()) {
                        i4 |= 16;
                    }
                    if (channel.getExitStatus() != null) {
                        i4 |= 32;
                    }
                    if (channel.getExitSignal() != null) {
                        i4 |= 64;
                    }
                    if (channel.state == 4) {
                        return i4 | 18;
                    }
                    if ((i4 & i) != 0) {
                        return i4;
                    }
                    if (j > 0) {
                        if (z) {
                            j = jCurrentTimeMillis - System.currentTimeMillis();
                            if (j <= 0) {
                                return i4 | 1;
                            }
                        } else {
                            jCurrentTimeMillis = System.currentTimeMillis() + j;
                            z = true;
                        }
                    }
                    if (j > 0) {
                        channel.wait(j);
                    } else {
                        channel.wait();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
