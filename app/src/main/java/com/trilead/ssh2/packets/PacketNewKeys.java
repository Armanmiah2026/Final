package com.trilead.ssh2.packets;

import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketNewKeys {
    byte[] payload;

    public PacketNewKeys() {
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriter = new TypesWriter();
            typesWriter.writeByte(21);
            this.payload = typesWriter.getBytes();
        }
        return this.payload;
    }

    public PacketNewKeys(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 21) {
            throw new IOException(za0.i(i3, "This is not a SSH_MSG_NEWKEYS! (", ")"));
        }
        if (typesReader.remain() != 0) {
            throw new IOException("Padding in SSH_MSG_NEWKEYS packet!");
        }
    }
}
