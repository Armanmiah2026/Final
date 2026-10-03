package com.trilead.ssh2.packets;

import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketIgnore {
    byte[] data;
    byte[] payload;

    public PacketIgnore() {
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(2);
            byte[] bArr = this.data;
            if (bArr != null) {
                typesWriterG.writeString(bArr, 0, bArr.length);
            } else {
                typesWriterG.writeString("");
            }
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
        this.payload = null;
    }

    public PacketIgnore(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        int i3 = new TypesReader(bArr, i, i2).readByte();
        if (i3 != 2) {
            throw new IOException(za0.i(i3, "This is not a SSH_MSG_IGNORE packet! (", ")"));
        }
    }
}
