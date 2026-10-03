package com.trilead.ssh2.packets;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionPtyRequest {
    public int character_height;
    public int character_width;
    byte[] payload;
    public int pixel_height;
    public int pixel_width;
    public int recipientChannelID;
    public String term;
    public byte[] terminal_modes;
    public boolean wantReply;

    public PacketSessionPtyRequest(int i, boolean z, String str, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.recipientChannelID = i;
        this.wantReply = z;
        this.term = str;
        this.character_width = i2;
        this.character_height = i3;
        this.pixel_width = i4;
        this.pixel_height = i5;
        this.terminal_modes = bArr;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(98);
            typesWriterG.writeUINT32(this.recipientChannelID);
            typesWriterG.writeString("pty-req");
            typesWriterG.writeBoolean(this.wantReply);
            typesWriterG.writeString(this.term);
            typesWriterG.writeUINT32(this.character_width);
            typesWriterG.writeUINT32(this.character_height);
            typesWriterG.writeUINT32(this.pixel_width);
            typesWriterG.writeUINT32(this.pixel_height);
            byte[] bArr = this.terminal_modes;
            typesWriterG.writeString(bArr, 0, bArr.length);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
