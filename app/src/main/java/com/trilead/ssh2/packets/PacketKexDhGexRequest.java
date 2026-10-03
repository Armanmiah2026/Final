package com.trilead.ssh2.packets;

import com.trilead.ssh2.DHGexParameters;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketKexDhGexRequest {
    int max;
    int min;
    int n;
    byte[] payload;

    public PacketKexDhGexRequest(DHGexParameters dHGexParameters) {
        this.min = dHGexParameters.getMin_group_len();
        this.n = dHGexParameters.getPref_group_len();
        this.max = dHGexParameters.getMax_group_len();
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(34);
            typesWriterG.writeUINT32(this.min);
            typesWriterG.writeUINT32(this.n);
            typesWriterG.writeUINT32(this.max);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
