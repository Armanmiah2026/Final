package com.trilead.ssh2.packets;

import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketChannelWindowAdjust {
    byte[] payload;
    public int recipientChannelID;
    public int windowChange;

    public PacketChannelWindowAdjust(int i, int i2) {
        this.recipientChannelID = i;
        this.windowChange = i2;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(93);
            typesWriterG.writeUINT32(this.recipientChannelID);
            typesWriterG.writeUINT32(this.windowChange);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }

    public PacketChannelWindowAdjust(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 == 93) {
            this.recipientChannelID = typesReader.readUINT32();
            this.windowChange = typesReader.readUINT32();
            if (typesReader.remain() != 0) {
                throw new IOException("Padding in SSH_MSG_CHANNEL_WINDOW_ADJUST packet!");
            }
            return;
        }
        throw new IOException(za0.i(i3, "This is not a SSH_MSG_CHANNEL_WINDOW_ADJUST! (", ")"));
    }
}
