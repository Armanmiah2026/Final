package com.trilead.ssh2.packets;

import java.math.BigInteger;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDHInit {
    BigInteger e;
    byte[] payload;

    public PacketKexDHInit(BigInteger bigInteger) {
        this.e = bigInteger;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(30);
            typesWriterG.writeMPInt(this.e);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
