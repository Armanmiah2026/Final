package com.trilead.ssh2.packets;

import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketOpenSessionChannel {
    int channelID;
    int initialWindowSize;
    int maxPacketSize;
    byte[] payload;

    public PacketOpenSessionChannel(int i, int i2, int i3) {
        this.channelID = i;
        this.initialWindowSize = i2;
        this.maxPacketSize = i3;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriter = new TypesWriter();
            typesWriter.writeByte(90);
            typesWriter.writeString("session");
            typesWriter.writeUINT32(this.channelID);
            typesWriter.writeUINT32(this.initialWindowSize);
            typesWriter.writeUINT32(this.maxPacketSize);
            this.payload = typesWriter.getBytes();
        }
        return this.payload;
    }

    public PacketOpenSessionChannel(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr);
        int i3 = typesReader.readByte();
        if (i3 == 90) {
            this.channelID = typesReader.readUINT32();
            this.initialWindowSize = typesReader.readUINT32();
            this.maxPacketSize = typesReader.readUINT32();
            if (typesReader.remain() != 0) {
                throw new IOException("Padding in SSH_MSG_CHANNEL_OPEN packet!");
            }
            return;
        }
        throw new IOException(za0.i(i3, "This is not a SSH_MSG_CHANNEL_OPEN! (", ")"));
    }
}
