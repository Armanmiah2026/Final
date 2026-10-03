package com.trilead.ssh2.packets;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketSessionX11Request {
    byte[] payload;
    public int recipientChannelID;
    public boolean singleConnection;
    public boolean wantReply;
    String x11AuthenticationCookie;
    String x11AuthenticationProtocol;
    int x11ScreenNumber;

    public PacketSessionX11Request(int i, boolean z, boolean z2, String str, String str2, int i2) {
        this.recipientChannelID = i;
        this.wantReply = z;
        this.singleConnection = z2;
        this.x11AuthenticationProtocol = str;
        this.x11AuthenticationCookie = str2;
        this.x11ScreenNumber = i2;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(98);
            typesWriterG.writeUINT32(this.recipientChannelID);
            typesWriterG.writeString("x11-req");
            typesWriterG.writeBoolean(this.wantReply);
            typesWriterG.writeBoolean(this.singleConnection);
            typesWriterG.writeString(this.x11AuthenticationProtocol);
            typesWriterG.writeString(this.x11AuthenticationCookie);
            typesWriterG.writeUINT32(this.x11ScreenNumber);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
