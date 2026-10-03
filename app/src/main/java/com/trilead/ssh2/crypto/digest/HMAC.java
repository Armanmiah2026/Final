package com.trilead.ssh2.crypto.digest;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class HMAC implements Digest {
    byte[] k_xor_ipad = new byte[64];
    byte[] k_xor_opad = new byte[64];
    Digest md;
    int size;
    byte[] tmp;

    public HMAC(Digest digest, byte[] bArr, int i) {
        this.md = digest;
        this.size = i;
        this.tmp = new byte[digest.getDigestLength()];
        if (bArr.length > 64) {
            digest.reset();
            digest.update(bArr);
            digest.digest(this.tmp);
            bArr = this.tmp;
        }
        System.arraycopy(bArr, 0, this.k_xor_ipad, 0, bArr.length);
        System.arraycopy(bArr, 0, this.k_xor_opad, 0, bArr.length);
        for (int i2 = 0; i2 < 64; i2++) {
            byte[] bArr2 = this.k_xor_ipad;
            bArr2[i2] = (byte) (bArr2[i2] ^ 54);
            byte[] bArr3 = this.k_xor_opad;
            bArr3[i2] = (byte) (bArr3[i2] ^ 92);
        }
        digest.update(this.k_xor_ipad);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void digest(byte[] bArr) {
        digest(bArr, 0);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public int getDigestLength() {
        return this.size;
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void reset() {
        this.md.reset();
        this.md.update(this.k_xor_ipad);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte b) {
        this.md.update(b);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void digest(byte[] bArr, int i) {
        this.md.digest(this.tmp);
        this.md.update(this.k_xor_opad);
        this.md.update(this.tmp);
        this.md.digest(this.tmp);
        System.arraycopy(this.tmp, 0, bArr, i, this.size);
        this.md.update(this.k_xor_ipad);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte[] bArr) {
        this.md.update(bArr);
    }

    @Override // com.trilead.ssh2.crypto.digest.Digest
    public void update(byte[] bArr, int i, int i2) {
        this.md.update(bArr, i, i2);
    }
}
