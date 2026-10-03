package net.i2p.crypto.eddsa;

import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class EdDSAPrivateKey implements EdDSAKey, PrivateKey {
    private static final int IDLEN_BYTE = 6;
    private static final int OID_BYTE = 11;
    private static final int OID_ED25519 = 112;
    private static final int OID_OLD = 100;
    private static final long serialVersionUID = 23495873459878957L;
    private final GroupElement A;
    private final byte[] Abyte;
    private final byte[] a;
    private final EdDSAParameterSpec edDsaSpec;
    private final byte[] h;
    private final byte[] seed;

    public EdDSAPrivateKey(EdDSAPrivateKeySpec edDSAPrivateKeySpec) {
        this.seed = edDSAPrivateKeySpec.getSeed();
        this.h = edDSAPrivateKeySpec.getH();
        this.a = edDSAPrivateKeySpec.geta();
        GroupElement a = edDSAPrivateKeySpec.getA();
        this.A = a;
        this.Abyte = a.toByteArray();
        this.edDsaSpec = edDSAPrivateKeySpec.getParams();
    }

    private static byte[] decode(byte[] bArr) throws InvalidKeySpecException {
        byte b;
        int i;
        int i2;
        try {
            byte b2 = bArr[11];
            if (b2 == 100) {
                i = 49;
                b = 8;
            } else {
                if (b2 != OID_ED25519) {
                    throw new InvalidKeySpecException("unsupported key spec");
                }
                if (bArr[6] == 7) {
                    i = 50;
                    b = 7;
                } else {
                    b = 5;
                    i = 48;
                }
            }
            if (bArr.length != i) {
                throw new InvalidKeySpecException("invalid key spec length");
            }
            if (bArr[0] != 48 || bArr[1] != i - 2 || bArr[2] != 2 || bArr[3] != 1 || bArr[4] != 0 || bArr[5] != 48 || bArr[6] != b || bArr[7] != 6 || bArr[8] != 3 || bArr[9] != 43 || bArr[10] != 101) {
                throw new InvalidKeySpecException("unsupported key spec");
            }
            int i3 = 14;
            if (b2 != 100) {
                if (b != 7) {
                    i3 = 12;
                } else if (bArr[12] != 5 || bArr[13] != 0) {
                    throw new InvalidKeySpecException("unsupported key spec");
                }
                int i4 = i3 + 1;
                if (bArr[i3] == 4) {
                    i2 = bArr[i4] == 34 ? i3 + 2 : 15;
                }
                throw new InvalidKeySpecException("unsupported key spec");
            }
            if (bArr[12] != 10 || bArr[13] != 1 || bArr[14] != 1) {
                throw new InvalidKeySpecException("unsupported key spec");
            }
            int i5 = i2 + 1;
            if (bArr[i2] == 4) {
                int i6 = i2 + 2;
                if (bArr[i5] == 32) {
                    byte[] bArr2 = new byte[32];
                    System.arraycopy(bArr, i6, bArr2, 0, 32);
                    return bArr2;
                }
            }
            throw new InvalidKeySpecException("unsupported key spec");
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidKeySpecException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EdDSAPrivateKey)) {
            return false;
        }
        EdDSAPrivateKey edDSAPrivateKey = (EdDSAPrivateKey) obj;
        return Arrays.equals(this.seed, edDSAPrivateKey.getSeed()) && this.edDsaSpec.equals(edDSAPrivateKey.getParams());
    }

    public GroupElement getA() {
        return this.A;
    }

    public byte[] getAbyte() {
        return this.Abyte;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "EdDSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        byte[] bArr;
        if (!this.edDsaSpec.equals(EdDSANamedCurveTable.ED_25519_CURVE_SPEC) || (bArr = this.seed) == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 16];
        bArr2[0] = 48;
        bArr2[1] = (byte) (length + 14);
        bArr2[2] = 2;
        bArr2[3] = 1;
        bArr2[4] = 0;
        bArr2[5] = 48;
        bArr2[6] = 5;
        bArr2[7] = 6;
        bArr2[8] = 3;
        bArr2[9] = 43;
        bArr2[10] = 101;
        bArr2[11] = 112;
        bArr2[12] = 4;
        bArr2[13] = (byte) (bArr.length + 2);
        bArr2[14] = 4;
        bArr2[15] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public byte[] getH() {
        return this.h;
    }

    @Override // net.i2p.crypto.eddsa.EdDSAKey
    public EdDSAParameterSpec getParams() {
        return this.edDsaSpec;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public byte[] geta() {
        return this.a;
    }

    public int hashCode() {
        return Arrays.hashCode(this.seed);
    }

    public EdDSAPrivateKey(PKCS8EncodedKeySpec pKCS8EncodedKeySpec) {
        this(new EdDSAPrivateKeySpec(decode(pKCS8EncodedKeySpec.getEncoded()), EdDSANamedCurveTable.ED_25519_CURVE_SPEC));
    }
}
