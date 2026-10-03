package com.trilead.ssh2.packets;

import com.trilead.ssh2.DHGexParameters;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDhGexRequestOld {
    int n;
    byte[] payload;

    public PacketKexDhGexRequestOld(DHGexParameters dHGexParameters) {
        this.n = dHGexParameters.getPref_group_len();
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(30);
            typesWriterG.writeUINT32(this.n);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
