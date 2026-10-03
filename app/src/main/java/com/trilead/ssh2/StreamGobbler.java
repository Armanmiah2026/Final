package com.trilead.ssh2;

import com.trilead.ssh2.sftp.AttribFlags;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class StreamGobbler extends InputStream {
    private final InputStream is;
    private final GobblerThread t;
    private final Object synchronizer = new Object();
    private boolean isEOF = false;
    private boolean isClosed = false;
    private IOException exception = null;
    private byte[] buffer = new byte[2048];
    private int read_pos = 0;
    private int write_pos = 0;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class GobblerThread extends Thread {
        public GobblerThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
            while (true) {
                try {
                    int i = StreamGobbler.this.is.read(bArr);
                    synchronized (StreamGobbler.this.synchronizer) {
                        if (i <= 0) {
                            StreamGobbler.this.isEOF = true;
                            StreamGobbler.this.synchronizer.notifyAll();
                            return;
                        }
                        try {
                            if (StreamGobbler.this.buffer.length - StreamGobbler.this.write_pos < i) {
                                int i2 = StreamGobbler.this.write_pos - StreamGobbler.this.read_pos;
                                int i3 = i2 + i;
                                byte[] bArr2 = StreamGobbler.this.buffer;
                                if (i3 > StreamGobbler.this.buffer.length) {
                                    int i4 = i3 / 3;
                                    if (i4 < 256) {
                                        i4 = 256;
                                    }
                                    if (i4 > 8192) {
                                        i4 = 8192;
                                    }
                                    bArr2 = new byte[i3 + i4];
                                }
                                if (i2 > 0) {
                                    System.arraycopy(StreamGobbler.this.buffer, StreamGobbler.this.read_pos, bArr2, 0, i2);
                                }
                                StreamGobbler.this.buffer = bArr2;
                                StreamGobbler.this.read_pos = 0;
                                StreamGobbler.this.write_pos = i2;
                            }
                            System.arraycopy(bArr, 0, StreamGobbler.this.buffer, StreamGobbler.this.write_pos, i);
                            StreamGobbler.this.write_pos += i;
                            StreamGobbler.this.synchronizer.notifyAll();
                        } finally {
                        }
                    }
                } catch (IOException e) {
                    synchronized (StreamGobbler.this.synchronizer) {
                        StreamGobbler.this.exception = e;
                        StreamGobbler.this.synchronizer.notifyAll();
                        return;
                    }
                }
            }
        }
    }

    public StreamGobbler(InputStream inputStream) {
        this.is = inputStream;
        GobblerThread gobblerThread = new GobblerThread();
        this.t = gobblerThread;
        gobblerThread.setDaemon(true);
        gobblerThread.start();
    }

    @Override // java.io.InputStream
    public int available() {
        int i;
        synchronized (this.synchronizer) {
            try {
                if (this.isClosed) {
                    throw new IOException("This StreamGobbler is closed.");
                }
                i = this.write_pos - this.read_pos;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.synchronizer) {
            try {
                if (this.isClosed) {
                    return;
                }
                this.isClosed = true;
                this.isEOF = true;
                this.synchronizer.notifyAll();
                this.is.close();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() {
        synchronized (this.synchronizer) {
            if (this.isClosed) {
                throw new IOException("This StreamGobbler is closed.");
            }
            while (true) {
                int i = this.read_pos;
                if (i != this.write_pos) {
                    byte[] bArr = this.buffer;
                    this.read_pos = i + 1;
                    return bArr[i] & 255;
                }
                IOException iOException = this.exception;
                if (iOException != null) {
                    throw iOException;
                }
                if (this.isEOF) {
                    return -1;
                }
                try {
                    this.synchronizer.wait();
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        bArr.getClass();
        if (i < 0 || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0 || i > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        synchronized (this.synchronizer) {
            if (this.isClosed) {
                throw new IOException("This StreamGobbler is closed.");
            }
            while (true) {
                int i4 = this.read_pos;
                int i5 = this.write_pos;
                if (i4 == i5) {
                    IOException iOException = this.exception;
                    if (iOException == null) {
                        if (this.isEOF) {
                            return -1;
                        }
                        try {
                            this.synchronizer.wait();
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    } else {
                        throw iOException;
                    }
                } else {
                    int i6 = i5 - i4;
                    if (i6 <= i2) {
                        i2 = i6;
                    }
                    System.arraycopy(this.buffer, i4, bArr, i, i2);
                    this.read_pos += i2;
                    return i2;
                }
            }
        }
    }
}
