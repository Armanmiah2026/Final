package com.trilead.ssh2.packets;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionExecCommand {
    public String command;
    byte[] payload;
    public int recipientChannelID;
    public boolean wantReply;

    public PacketSessionExecCommand(int i, boolean z, String str) {
        this.recipientChannelID = i;
        this.wantReply = z;
        this.command = str;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(98);
            typesWriterG.writeUINT32(this.recipientChannelID);
            typesWriterG.writeString("exec");
            typesWriterG.writeBoolean(this.wantReply);
            typesWriterG.writeString(this.command);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
