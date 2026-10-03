package com.trilead.ssh2.packets;

import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketDisconnect {
    String desc;
    String lang;
    byte[] payload;
    int reason;

    public PacketDisconnect(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 1) {
            throw new IOException(za0.i(i3, "This is not a Disconnect Packet! (", ")"));
        }
        this.reason = typesReader.readUINT32();
        this.desc = typesReader.readString();
        this.lang = typesReader.readString();
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(1);
            typesWriterG.writeUINT32(this.reason);
            typesWriterG.writeString(this.desc);
            typesWriterG.writeString(this.lang);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }

    public PacketDisconnect(int i, String str, String str2) {
        this.reason = i;
        this.desc = str;
        this.lang = str2;
    }
}
