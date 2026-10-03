package com.trilead.ssh2.packets;

import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthRequestPublicKey {
    String password;
    byte[] payload;
    byte[] pk;
    String pkAlgoName;
    String serviceName;
    byte[] sig;
    String userName;

    public PacketUserauthRequestPublicKey(String str, String str2, String str3, byte[] bArr, byte[] bArr2) {
        this.serviceName = str;
        this.userName = str2;
        this.pkAlgoName = str3;
        this.pk = bArr;
        this.sig = bArr2;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(50);
            typesWriterG.writeString(this.userName);
            typesWriterG.writeString(this.serviceName);
            typesWriterG.writeString("publickey");
            typesWriterG.writeBoolean(true);
            typesWriterG.writeString(this.pkAlgoName);
            byte[] bArr = this.pk;
            typesWriterG.writeString(bArr, 0, bArr.length);
            byte[] bArr2 = this.sig;
            typesWriterG.writeString(bArr2, 0, bArr2.length);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }

    public PacketUserauthRequestPublicKey(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        int i3 = new TypesReader(bArr, i, i2).readByte();
        if (i3 != 50) {
            throw new IOException(za0.i(i3, "This is not a SSH_MSG_USERAUTH_REQUEST! (", ")"));
        }
        throw new IOException("Not implemented!");
    }
}
