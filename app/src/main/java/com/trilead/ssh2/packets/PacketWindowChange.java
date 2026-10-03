package com.trilead.ssh2.packets;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketWindowChange {
    public int character_height;
    public int character_width;
    byte[] payload;
    public int pixel_height;
    public int pixel_width;
    public int recipientChannelID;

    public PacketWindowChange(int i, int i2, int i3, int i4, int i5) {
        this.recipientChannelID = i;
        this.character_width = i2;
        this.character_height = i3;
        this.pixel_width = i4;
        this.pixel_height = i5;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(98);
            typesWriterG.writeUINT32(this.recipientChannelID);
            typesWriterG.writeString("window-change");
            typesWriterG.writeBoolean(false);
            typesWriterG.writeUINT32(this.character_width);
            typesWriterG.writeUINT32(this.character_height);
            typesWriterG.writeUINT32(this.pixel_width);
            typesWriterG.writeUINT32(this.pixel_height);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
