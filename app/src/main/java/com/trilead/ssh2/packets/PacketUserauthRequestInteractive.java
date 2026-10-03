package com.trilead.ssh2.packets;

import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthRequestInteractive {
    byte[] payload;
    String serviceName;
    String[] submethods;
    String userName;

    public PacketUserauthRequestInteractive(String str, String str2, String[] strArr) {
        this.serviceName = str;
        this.userName = str2;
        this.submethods = strArr;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(50);
            typesWriterG.writeString(this.userName);
            typesWriterG.writeString(this.serviceName);
            typesWriterG.writeString("keyboard-interactive");
            typesWriterG.writeString("");
            typesWriterG.writeNameList(this.submethods);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
