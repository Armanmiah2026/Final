package com.trilead.ssh2.packets;

import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketUserauthInfoRequest {
    boolean[] echo;
    String instruction;
    String languageTag;
    String name;
    int numPrompts;
    byte[] payload;
    String[] prompt;

    public PacketUserauthInfoRequest(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        TypesReader typesReader = new TypesReader(bArr, i, i2);
        int i3 = typesReader.readByte();
        if (i3 != 60) {
            throw new IOException(za0.i(i3, "This is not a SSH_MSG_USERAUTH_INFO_REQUEST! (", ")"));
        }
        this.name = typesReader.readString();
        this.instruction = typesReader.readString();
        this.languageTag = typesReader.readString();
        int uint32 = typesReader.readUINT32();
        this.numPrompts = uint32;
        this.prompt = new String[uint32];
        this.echo = new boolean[uint32];
        for (int i4 = 0; i4 < this.numPrompts; i4++) {
            this.prompt[i4] = typesReader.readString();
            this.echo[i4] = typesReader.readBoolean();
        }
        if (typesReader.remain() != 0) {
            throw new IOException("Padding in SSH_MSG_USERAUTH_INFO_REQUEST packet!");
        }
    }

    public boolean[] getEcho() {
        return this.echo;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public String getLanguageTag() {
        return this.languageTag;
    }

    public String getName() {
        return this.name;
    }

    public int getNumPrompts() {
        return this.numPrompts;
    }

    public String[] getPrompt() {
        return this.prompt;
    }
}
