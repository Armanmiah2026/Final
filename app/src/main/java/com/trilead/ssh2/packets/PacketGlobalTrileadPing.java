package com.trilead.ssh2.packets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketGlobalTrileadPing {
    byte[] payload;

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriter = new TypesWriter();
            typesWriter.writeByte(80);
            typesWriter.writeString("trilead-ping");
            typesWriter.writeBoolean(true);
            this.payload = typesWriter.getBytes();
        }
        return this.payload;
    }
}
