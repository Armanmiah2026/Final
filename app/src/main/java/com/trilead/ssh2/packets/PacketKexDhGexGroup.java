package com.trilead.ssh2.packets;

import java.io.IOException;
import java.math.BigInteger;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDhGexGroup {
    BigInteger g;
    BigInteger p;
    byte[] payload;

    public PacketKexDhGexGroup(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 31) {
            throw new IllegalArgumentException(za0.i(i3, "This is not a SSH_MSG_KEX_DH_GEX_GROUP! (", ")"));
        }
        this.p = typesReader.readMPINT();
        this.g = typesReader.readMPINT();
        if (typesReader.remain() != 0) {
            throw new IOException("PADDING IN SSH_MSG_KEX_DH_GEX_GROUP!");
        }
    }

    public BigInteger getG() {
        return this.g;
    }

    public BigInteger getP() {
        return this.p;
    }
}
