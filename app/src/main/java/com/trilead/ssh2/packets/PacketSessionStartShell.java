package com.trilead.ssh2.packets;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionStartShell {
    byte[] payload;
    public int recipientChannelID;
    public boolean wantReply;

    public PacketSessionStartShell(int i, boolean z) {
        this.recipientChannelID = i;
        this.wantReply = z;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(98);
            typesWriterG.writeUINT32(this.recipientChannelID);
            typesWriterG.writeString("shell");
            typesWriterG.writeBoolean(this.wantReply);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
