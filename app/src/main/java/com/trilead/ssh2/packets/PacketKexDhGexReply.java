package com.trilead.ssh2.packets;

import java.io.IOException;
import java.math.BigInteger;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDhGexReply {
    BigInteger f;
    byte[] hostKey;
    byte[] payload;
    byte[] signature;

    public PacketKexDhGexReply(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 33) {
            throw new IOException(za0.i(i3, "This is not a SSH_MSG_KEX_DH_GEX_REPLY! (", ")"));
        }
        this.hostKey = typesReader.readByteString();
        this.f = typesReader.readMPINT();
        this.signature = typesReader.readByteString();
        if (typesReader.remain() != 0) {
            throw new IOException("PADDING IN SSH_MSG_KEX_DH_GEX_REPLY!");
        }
    }

    public BigInteger getF() {
        return this.f;
    }

    public byte[] getHostKey() {
        return this.hostKey;
    }

    public byte[] getSignature() {
        return this.signature;
    }
}
