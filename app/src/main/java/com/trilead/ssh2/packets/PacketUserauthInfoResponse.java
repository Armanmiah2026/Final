package com.trilead.ssh2.packets;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthInfoResponse {
    byte[] payload;
    String[] responses;

    public PacketUserauthInfoResponse(String[] strArr) {
        this.responses = strArr;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(61);
            typesWriterG.writeUINT32(this.responses.length);
            int i = 0;
            while (true) {
                String[] strArr = this.responses;
                if (i >= strArr.length) {
                    break;
                }
                typesWriterG.writeString(strArr[i]);
                i++;
            }
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
