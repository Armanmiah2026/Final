package com.trilead.ssh2.jenkins;

import com.trilead.ssh2.Connection;
import com.trilead.ssh2.SFTPException;
import com.trilead.ssh2.SFTPv3Client;
import com.trilead.ssh2.SFTPv3FileAttributes;
import com.trilead.ssh2.SFTPv3FileHandle;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class SFTPClient extends SFTPv3Client {

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class SFTPOutputStream extends OutputStream {
        private final SFTPv3FileHandle h;
        private long offset = 0;

        public SFTPOutputStream(SFTPv3FileHandle sFTPv3FileHandle) {
            this.h = sFTPv3FileHandle;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            SFTPClient.this.closeFile(this.h);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) i});
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            SFTPClient.this.write(this.h, this.offset, bArr, i, i2);
            this.offset += (long) i2;
        }
    }

    public SFTPClient(Connection connection) {
        super(connection);
    }

    @Override // com.trilead.ssh2.SFTPv3Client
    public SFTPv3FileAttributes _stat(String str) throws SFTPException {
        try {
            return stat(str);
        } catch (SFTPException e) {
            int serverErrorCode = e.getServerErrorCode();
            if (serverErrorCode == 2 || serverErrorCode == 10) {
                return null;
            }
            throw e;
        }
    }

    @Override // com.trilead.ssh2.SFTPv3Client
    public void chmod(String str, int i) throws IOException {
        SFTPv3FileAttributes sFTPv3FileAttributes = new SFTPv3FileAttributes();
        sFTPv3FileAttributes.permissions = Integer.valueOf(i);
        setstat(str, sFTPv3FileAttributes);
    }

    @Override // com.trilead.ssh2.SFTPv3Client
    public boolean exists(String str) {
        return _stat(str) != null;
    }

    @Override // com.trilead.ssh2.SFTPv3Client
    public void mkdirs(String str, int i) throws IOException {
        SFTPv3FileAttributes sFTPv3FileAttributes_stat = _stat(str);
        if (sFTPv3FileAttributes_stat == null || !sFTPv3FileAttributes_stat.isDirectory()) {
            int iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf > 0) {
                mkdirs(str.substring(0, iLastIndexOf), i);
            }
            try {
                mkdir(str, i);
            } catch (IOException e) {
                throw new IOException("Failed to mkdir ".concat(str), e);
            }
        }
    }

    @Override // com.trilead.ssh2.SFTPv3Client
    public InputStream read(String str) {
        return new SFTPInputStream(openFileRO(str));
    }

    @Override // com.trilead.ssh2.SFTPv3Client
    public OutputStream writeToFile(String str) {
        return new SFTPOutputStream(createFile(str));
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class SFTPInputStream extends InputStream {
        private final SFTPv3FileHandle h;
        private long offset = 0;

        public SFTPInputStream(SFTPv3FileHandle sFTPv3FileHandle) {
            this.h = sFTPv3FileHandle;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            SFTPClient.this.closeFile(this.h);
        }

        @Override // java.io.InputStream
        public int read() {
            byte[] bArr = new byte[1];
            if (read(bArr) < 0) {
                return -1;
            }
            return bArr[0];
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            this.offset += j;
            return j;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = SFTPClient.this.read(this.h, this.offset, bArr, i, i2);
            if (i3 < 0) {
                return -1;
            }
            this.offset += (long) i3;
            return i3;
        }
    }
}
