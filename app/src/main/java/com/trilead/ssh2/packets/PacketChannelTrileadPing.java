package com.trilead.ssh2.packets;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketChannelTrileadPing {
    byte[] payload;
    public int recipientChannelID;

    public PacketChannelTrileadPing(int i) {
        this.recipientChannelID = i;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(98);
            typesWriterG.writeUINT32(this.recipientChannelID);
            typesWriterG.writeString("trilead-ping");
            typesWriterG.writeBoolean(true);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
