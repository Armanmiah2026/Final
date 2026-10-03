package com.trilead.ssh2.packets;

import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthBanner {
    String language;
    String message;
    byte[] payload;

    public PacketUserauthBanner(String str, String str2) {
        this.message = str;
        this.language = str2;
    }

    public String getBanner() {
        return this.message;
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(53);
            typesWriterG.writeString(this.message);
            typesWriterG.writeString(this.language);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }

    public PacketUserauthBanner(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 == 53) {
            this.message = typesReader.readString("UTF-8");
            this.language = typesReader.readString();
            if (typesReader.remain() != 0) {
                throw new IOException("Padding in SSH_MSG_USERAUTH_REQUEST packet!");
            }
            return;
        }
        throw new IOException(za0.i(i3, "This is not a SSH_MSG_USERAUTH_BANNER! (", ")"));
    }
}
