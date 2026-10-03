package com.trilead.ssh2;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class SFTPv3FileHandle {
    final SFTPv3Client client;
    final byte[] fileHandle;
    boolean isClosed = false;

    public SFTPv3FileHandle(SFTPv3Client sFTPv3Client, byte[] bArr) {
        this.client = sFTPv3Client;
        this.fileHandle = bArr;
    }

    public SFTPv3Client getClient() {
        return this.client;
    }

    public boolean isClosed() {
        return this.isClosed;
    }
}
