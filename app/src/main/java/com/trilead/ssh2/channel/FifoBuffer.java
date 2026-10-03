package com.trilead.ssh2.channel;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
class FifoBuffer {
    private boolean closed;
    private int limit;
    private final Object lock;
    private final int pageSize;
    private Pointer r;
    private int sz;
    private Pointer w;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static final class Page {
        final byte[] buf;
        Page next;

        public Page(int i) {
            this.buf = new byte[i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class Pointer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        int off;
        Page p;

        public Pointer(Page page, int i) {
            this.p = page;
            this.off = i;
        }

        private int chunk() {
            int i = FifoBuffer.this.pageSize - this.off;
            if (i > 0) {
                return i;
            }
            Page page = this.p;
            Page pageNewPage = page.next;
            if (pageNewPage == null) {
                pageNewPage = FifoBuffer.this.newPage();
                page.next = pageNewPage;
            }
            this.p = pageNewPage;
            this.off = 0;
            return FifoBuffer.this.pageSize;
        }

        public void read(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                int iMin = Math.min(i2, chunk());
                System.arraycopy(this.p.buf, this.off, bArr, i, iMin);
                this.off += iMin;
                i2 -= iMin;
                i += iMin;
            }
        }

        public void write(byte[] bArr, int i, int i2) {
            while (i2 > 0) {
                int iMin = Math.min(i2, chunk());
                System.arraycopy(bArr, i, this.p.buf, this.off, iMin);
                this.off += iMin;
                i2 -= iMin;
                i += iMin;
            }
        }
    }

    public FifoBuffer(int i, int i2) {
        this(null, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Page newPage() {
        return new Page(this.pageSize);
    }

    private void releaseRing() {
        if (this.closed && readable() == 0) {
            this.w = null;
            this.r = null;
        }
    }

    public void close() {
        synchronized (this.lock) {
            try {
                if (!this.closed) {
                    this.closed = true;
                    releaseRing();
                    this.lock.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        r4.r.read(r5, r6, r2);
        r6 = r6 + r2;
        r7 = r7 - r2;
        r0 = r0 + r2;
        r4.sz -= r2;
        r4.lock.notifyAll();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            java.lang.Object r1 = r4.lock
            monitor-enter(r1)
        L7:
            int r2 = r4.readable()     // Catch: java.lang.Throwable -> L25
            int r2 = java.lang.Math.min(r7, r2)     // Catch: java.lang.Throwable -> L25
            if (r2 <= 0) goto L27
            com.trilead.ssh2.channel.FifoBuffer$Pointer r3 = r4.r     // Catch: java.lang.Throwable -> L25
            r3.read(r5, r6, r2)     // Catch: java.lang.Throwable -> L25
            int r6 = r6 + r2
            int r7 = r7 - r2
            int r0 = r0 + r2
            int r3 = r4.sz     // Catch: java.lang.Throwable -> L25
            int r3 = r3 - r2
            r4.sz = r3     // Catch: java.lang.Throwable -> L25
            java.lang.Object r2 = r4.lock     // Catch: java.lang.Throwable -> L25
            r2.notifyAll()     // Catch: java.lang.Throwable -> L25
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L25
            goto L4
        L25:
            r5 = move-exception
            goto L3b
        L27:
            if (r0 <= 0) goto L2b
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L25
            return r0
        L2b:
            boolean r2 = r4.closed     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L35
            r4.releaseRing()     // Catch: java.lang.Throwable -> L25
            r5 = -1
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L25
            return r5
        L35:
            java.lang.Object r2 = r4.lock     // Catch: java.lang.Throwable -> L25
            r2.wait()     // Catch: java.lang.Throwable -> L25
            goto L7
        L3b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L25
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trilead.ssh2.channel.FifoBuffer.read(byte[], int, int):int");
    }

    public int readable() {
        int i;
        synchronized (this.lock) {
            i = this.sz;
        }
        return i;
    }

    public void setLimit(int i) {
        synchronized (this.lock) {
            this.limit = i;
        }
    }

    public int writable() {
        return Math.max(0, this.limit - readable());
    }

    public void write(byte[] bArr, int i, int i2) {
        int iMin;
        while (i2 > 0) {
            synchronized (this.lock) {
                while (true) {
                    try {
                        iMin = Math.min(i2, writable());
                        if (iMin != 0) {
                            break;
                        } else {
                            this.lock.wait();
                        }
                    } finally {
                    }
                }
                this.w.write(bArr, i, iMin);
                i += iMin;
                i2 -= iMin;
                this.sz += iMin;
                this.lock.notifyAll();
            }
        }
    }

    public int writeTo(OutputStream outputStream) throws IOException {
        int i = 0;
        while (readable() > 0) {
            try {
                byte[] bArr = new byte[1024];
                int i2 = read(bArr, 0, 1024);
                outputStream.write(bArr, 0, i2);
                i += i2;
            } catch (InterruptedException e) {
                throw new AssertionError(e);
            }
        }
        return i;
    }

    public FifoBuffer(Object obj, int i, int i2) {
        this.lock = obj == null ? this : obj;
        this.limit = i2;
        this.pageSize = i;
        Page pageNewPage = newPage();
        this.r = new Pointer(pageNewPage, 0);
        this.w = new Pointer(pageNewPage, 0);
    }
}
