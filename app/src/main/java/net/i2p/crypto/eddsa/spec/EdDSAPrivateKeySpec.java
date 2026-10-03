package net.i2p.crypto.eddsa.spec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import net.i2p.crypto.eddsa.math.GroupElement;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class EdDSAPrivateKeySpec implements KeySpec {
    private final GroupElement A;
    private final byte[] a;
    private final byte[] h;
    private final byte[] seed;
    private final EdDSAParameterSpec spec;

    public EdDSAPrivateKeySpec(byte[] bArr, EdDSAParameterSpec edDSAParameterSpec) {
        if (bArr.length != edDSAParameterSpec.getCurve().getField().getb() / 8) {
            throw new IllegalArgumentException("seed length is wrong");
        }
        this.spec = edDSAParameterSpec;
        this.seed = bArr;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(edDSAParameterSpec.getHashAlgorithm());
            int bVar = edDSAParameterSpec.getCurve().getField().getb();
            byte[] bArrDigest = messageDigest.digest(bArr);
            this.h = bArrDigest;
            bArrDigest[0] = (byte) (bArrDigest[0] & 248);
            int i = (bVar / 8) - 1;
            bArrDigest[i] = (byte) (bArrDigest[i] & 63);
            int i2 = (bVar / 8) - 1;
            bArrDigest[i2] = (byte) (bArrDigest[i2] | 64);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDigest, 0, bVar / 8);
            this.a = bArrCopyOfRange;
            this.A = edDSAParameterSpec.getB().scalarMultiply(bArrCopyOfRange);
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalArgumentException("Unsupported hash algorithm");
        }
    }

    public GroupElement getA() {
        return this.A;
    }

    public byte[] getH() {
        return this.h;
    }

    public EdDSAParameterSpec getParams() {
        return this.spec;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public byte[] geta() {
        return this.a;
    }

    public EdDSAPrivateKeySpec(EdDSAParameterSpec edDSAParameterSpec, byte[] bArr) {
        if (bArr.length == edDSAParameterSpec.getCurve().getField().getb() / 4) {
            this.seed = null;
            this.h = bArr;
            this.spec = edDSAParameterSpec;
            int bVar = edDSAParameterSpec.getCurve().getField().getb();
            bArr[0] = (byte) (bArr[0] & 248);
            int i = bVar / 8;
            int i2 = i - 1;
            byte b = (byte) (bArr[i2] & 63);
            bArr[i2] = b;
            bArr[i2] = (byte) (b | 64);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
            this.a = bArrCopyOfRange;
            this.A = edDSAParameterSpec.getB().scalarMultiply(bArrCopyOfRange);
            return;
        }
        throw new IllegalArgumentException("hash length is wrong");
    }

    public EdDSAPrivateKeySpec(byte[] bArr, byte[] bArr2, byte[] bArr3, GroupElement groupElement, EdDSAParameterSpec edDSAParameterSpec) {
        this.seed = bArr;
        this.h = bArr2;
        this.a = bArr3;
        this.A = groupElement;
        this.spec = edDSAParameterSpec;
    }
}
