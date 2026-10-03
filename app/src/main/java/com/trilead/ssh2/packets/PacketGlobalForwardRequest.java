package com.trilead.ssh2.packets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketGlobalForwardRequest {
    public String bindAddress;
    public int bindPort;
    byte[] payload;
    public boolean wantReply;

    public PacketGlobalForwardRequest(boolean z, String str, int i) {
        this.wantReply = z;
        this.bindAddress = str;
        this.bindPort = i;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriter = new TypesWriter();
            typesWriter.writeByte(80);
            typesWriter.writeString("tcpip-forward");
            typesWriter.writeBoolean(this.wantReply);
            typesWriter.writeString(this.bindAddress);
            typesWriter.writeUINT32(this.bindPort);
            this.payload = typesWriter.getBytes();
        }
        return this.payload;
    }
}
