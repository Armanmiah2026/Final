package com.trilead.ssh2.packets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketOpenDirectTCPIPChannel {
    int channelID;
    String host_to_connect;
    int initialWindowSize;
    int maxPacketSize;
    String originator_IP_address;
    int originator_port;
    byte[] payload;
    int port_to_connect;

    public PacketOpenDirectTCPIPChannel(int i, int i2, int i3, String str, int i4, String str2, int i5) {
        this.channelID = i;
        this.initialWindowSize = i2;
        this.maxPacketSize = i3;
        this.host_to_connect = str;
        this.port_to_connect = i4;
        this.originator_IP_address = str2;
        this.originator_port = i5;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriter = new TypesWriter();
            typesWriter.writeByte(90);
            typesWriter.writeString("direct-tcpip");
            typesWriter.writeUINT32(this.channelID);
            typesWriter.writeUINT32(this.initialWindowSize);
            typesWriter.writeUINT32(this.maxPacketSize);
            typesWriter.writeString(this.host_to_connect);
            typesWriter.writeUINT32(this.port_to_connect);
            typesWriter.writeString(this.originator_IP_address);
            typesWriter.writeUINT32(this.originator_port);
            this.payload = typesWriter.getBytes();
        }
        return this.payload;
    }
}
