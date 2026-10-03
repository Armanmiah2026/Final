package com.trilead.ssh2.signature;

import com.trilead.ssh2.crypto.CertificateDecoder;
import com.trilead.ssh2.crypto.PEMStructure;
import com.trilead.ssh2.crypto.SimpleDERReader;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import java.util.List;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ECDSAKeyAlgorithm extends KeyAlgorithm<ECPublicKey, ECPrivateKey> {
    private static final byte ANS1_INTEGER = 2;
    private static final byte ANS1_ZERO = 0;
    private static final String ECDSA_SHA2_PREFIX = "ecdsa-sha2-";
    private final String curveName;
    private final ECParameterSpec ecParameterSpec;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class ECDSASha2Nistp256 extends ECDSAKeyAlgorithm {
        public ECDSASha2Nistp256() {
            super("SHA256withECDSA", "nistp256", new ECParameterSpec(new EllipticCurve(new ECFieldFp(new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF", 16)), new BigInteger("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC", 16), new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16)), new ECPoint(new BigInteger("6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296", 16), new BigInteger("4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5", 16)), new BigInteger("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551", 16), 1), 0);
        }

        @Override // com.trilead.ssh2.signature.ECDSAKeyAlgorithm, com.trilead.ssh2.signature.KeyAlgorithm
        public /* bridge */ /* synthetic */ PublicKey decodePublicKey(byte[] bArr) {
            return super.decodePublicKey(bArr);
        }

        @Override // com.trilead.ssh2.signature.ECDSAKeyAlgorithm, com.trilead.ssh2.signature.KeyAlgorithm
        public /* bridge */ /* synthetic */ byte[] encodePublicKey(PublicKey publicKey) {
            return super.encodePublicKey((ECPublicKey) publicKey);
        }

        @Override // com.trilead.ssh2.signature.KeyAlgorithm
        public List<CertificateDecoder> getCertificateDecoders() {
            return Arrays.asList(new EcdsaCertificateDecoder("1.2.840.10045.3.1.7", getEcParameterSpec(), 0), new OpenSshEcdsaCertificateDecoder(getKeyFormat(), getCurveName(), getEcParameterSpec()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class ECDSASha2Nistp384 extends ECDSAKeyAlgorithm {
        public ECDSASha2Nistp384() {
            super("SHA384withECDSA", "nistp384", new ECParameterSpec(new EllipticCurve(new ECFieldFp(new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF", 16)), new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC", 16), new BigInteger("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF", 16)), new ECPoint(new BigInteger("AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB7", 16), new BigInteger("3617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F", 16)), new BigInteger("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973", 16), 1), 0);
        }

        @Override // com.trilead.ssh2.signature.ECDSAKeyAlgorithm, com.trilead.ssh2.signature.KeyAlgorithm
        public /* bridge */ /* synthetic */ PublicKey decodePublicKey(byte[] bArr) {
            return super.decodePublicKey(bArr);
        }

        @Override // com.trilead.ssh2.signature.ECDSAKeyAlgorithm, com.trilead.ssh2.signature.KeyAlgorithm
        public /* bridge */ /* synthetic */ byte[] encodePublicKey(PublicKey publicKey) {
            return super.encodePublicKey((ECPublicKey) publicKey);
        }

        @Override // com.trilead.ssh2.signature.KeyAlgorithm
        public List<CertificateDecoder> getCertificateDecoders() {
            return Arrays.asList(new EcdsaCertificateDecoder("1.3.132.0.34", getEcParameterSpec(), 0), new OpenSshEcdsaCertificateDecoder(getKeyFormat(), getCurveName(), getEcParameterSpec()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class ECDSASha2Nistp521 extends ECDSAKeyAlgorithm {
        public ECDSASha2Nistp521() {
            super("SHA512withECDSA", "nistp521", new ECParameterSpec(new EllipticCurve(new ECFieldFp(new BigInteger("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", 16)), new BigInteger("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC", 16), new BigInteger("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00", 16)), new ECPoint(new BigInteger("00C6858E06B70404E9CD9E3ECB662395B4429C648139053FB521F828AF606B4D3DBAA14B5E77EFE75928FE1DC127A2FFA8DE3348B3C1856A429BF97E7E31C2E5BD66", 16), new BigInteger("011839296A789A3BC0045C8A5FB42C7D1BD998F54449579B446817AFBD17273E662C97EE72995EF42640C550B9013FAD0761353C7086A272C24088BE94769FD16650", 16)), new BigInteger("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409", 16), 1), 0);
        }

        @Override // com.trilead.ssh2.signature.ECDSAKeyAlgorithm, com.trilead.ssh2.signature.KeyAlgorithm
        public /* bridge */ /* synthetic */ PublicKey decodePublicKey(byte[] bArr) {
            return super.decodePublicKey(bArr);
        }

        @Override // com.trilead.ssh2.signature.ECDSAKeyAlgorithm, com.trilead.ssh2.signature.KeyAlgorithm
        public /* bridge */ /* synthetic */ byte[] encodePublicKey(PublicKey publicKey) {
            return super.encodePublicKey((ECPublicKey) publicKey);
        }

        @Override // com.trilead.ssh2.signature.KeyAlgorithm
        public List<CertificateDecoder> getCertificateDecoders() {
            return Arrays.asList(new EcdsaCertificateDecoder("1.3.132.0.35", getEcParameterSpec(), 0), new OpenSshEcdsaCertificateDecoder(getKeyFormat(), getCurveName(), getEcParameterSpec()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class EcdsaCertificateDecoder extends CertificateDecoder {
        private final ECParameterSpec ecParameterSpec;
        private final String oid;

        public /* synthetic */ EcdsaCertificateDecoder(String str, ECParameterSpec eCParameterSpec, int i) {
            this(str, eCParameterSpec);
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public KeyPair createKeyPair(PEMStructure pEMStructure) throws IOException {
            SimpleDERReader simpleDERReader = new SimpleDERReader(pEMStructure.getData());
            byte[] sequenceAsByteArray = simpleDERReader.readSequenceAsByteArray();
            if (simpleDERReader.available() != 0) {
                throw new IOException("Unexpected padding in EC private key");
            }
            SimpleDERReader simpleDERReader2 = new SimpleDERReader(sequenceAsByteArray);
            BigInteger bigInteger = simpleDERReader2.readInt();
            if (bigInteger.compareTo(BigInteger.ONE) != 0) {
                throw new IOException("Unexpected version number in EC private key: " + bigInteger);
            }
            byte[] octetString = simpleDERReader2.readOctetString();
            String oid = null;
            byte[] octetString2 = null;
            while (simpleDERReader2.available() > 0) {
                int constructedType = simpleDERReader2.readConstructedType();
                SimpleDERReader constructed = simpleDERReader2.readConstructed();
                if (constructedType == 0) {
                    oid = constructed.readOid();
                } else if (constructedType == 1) {
                    octetString2 = constructed.readOctetString();
                }
            }
            if (!this.oid.equals(oid)) {
                throw new IOException("Incorrect OID for current curve");
            }
            BigInteger bigInteger2 = new BigInteger(1, octetString);
            int length = octetString2.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(octetString2, 1, bArr, 0, length);
            ECPoint eCPointDecodePoint = ECDSAKeyAlgorithm.decodePoint(bArr, this.ecParameterSpec.getCurve());
            ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(bigInteger2, this.ecParameterSpec);
            ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPointDecodePoint, this.ecParameterSpec);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("EC");
                return new KeyPair(keyFactory.generatePublic(eCPublicKeySpec), keyFactory.generatePrivate(eCPrivateKeySpec));
            } catch (GeneralSecurityException unused) {
                throw new IOException("Could not generate EC key pair");
            }
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public String getEndLine() {
            return "-----END EC PRIVATE KEY-----";
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public String getStartLine() {
            return "-----BEGIN EC PRIVATE KEY-----";
        }

        private EcdsaCertificateDecoder(String str, ECParameterSpec eCParameterSpec) {
            this.oid = str;
            this.ecParameterSpec = eCParameterSpec;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class OpenSshEcdsaCertificateDecoder extends OpenSshCertificateDecoder {
        private final String curveName;
        private final ECParameterSpec ecParameterSpec;

        public OpenSshEcdsaCertificateDecoder(String str, String str2, ECParameterSpec eCParameterSpec) {
            super(str);
            this.curveName = str2;
            this.ecParameterSpec = eCParameterSpec;
        }

        @Override // com.trilead.ssh2.signature.OpenSshCertificateDecoder
        public KeyPair generateKeyPair(TypesReader typesReader) throws NoSuchAlgorithmException, IOException {
            String string = typesReader.readString();
            if (!string.equals(this.curveName)) {
                throw new IOException("Incorrect curve name: ".concat(string));
            }
            byte[] byteString = typesReader.readByteString();
            BigInteger mpint = typesReader.readMPINT();
            ECPoint eCPointDecodePoint = ECDSAKeyAlgorithm.decodePoint(byteString, this.ecParameterSpec.getCurve());
            if (eCPointDecodePoint == null) {
                throw new IOException("Invalid ECDSA group");
            }
            ECPublicKeySpec eCPublicKeySpec = new ECPublicKeySpec(eCPointDecodePoint, this.ecParameterSpec);
            ECPrivateKeySpec eCPrivateKeySpec = new ECPrivateKeySpec(mpint, this.ecParameterSpec);
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            return new KeyPair(keyFactory.generatePublic(eCPublicKeySpec), keyFactory.generatePrivate(eCPrivateKeySpec));
        }
    }

    public /* synthetic */ ECDSAKeyAlgorithm(String str, String str2, ECParameterSpec eCParameterSpec, int i) {
        this(str, str2, eCParameterSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ECPoint decodePoint(byte[] bArr, EllipticCurve ellipticCurve) {
        int fieldSize = (ellipticCurve.getField().getFieldSize() + 7) / 8;
        if (bArr.length != (fieldSize * 2) + 1 || bArr[0] != 4 || bArr.length == 0) {
            return null;
        }
        byte[] bArr2 = new byte[fieldSize];
        System.arraycopy(bArr, 1, bArr2, 0, fieldSize);
        byte[] bArr3 = new byte[fieldSize];
        System.arraycopy(bArr, fieldSize + 1, bArr3, 0, fieldSize);
        return new ECPoint(new BigInteger(1, bArr2), new BigInteger(1, bArr3));
    }

    private static byte[] encodePoint(ECPoint eCPoint, EllipticCurve ellipticCurve) {
        int fieldSize = (ellipticCurve.getField().getFieldSize() + 7) / 8;
        byte[] bArr = new byte[(fieldSize * 2) + 1];
        bArr[0] = 4;
        byte[] bArrRemoveLeadingZeroes = removeLeadingZeroes(eCPoint.getAffineX().toByteArray());
        int i = fieldSize + 1;
        System.arraycopy(bArrRemoveLeadingZeroes, 0, bArr, i - bArrRemoveLeadingZeroes.length, bArrRemoveLeadingZeroes.length);
        byte[] bArrRemoveLeadingZeroes2 = removeLeadingZeroes(eCPoint.getAffineY().toByteArray());
        System.arraycopy(bArrRemoveLeadingZeroes2, 0, bArr, (i + fieldSize) - bArrRemoveLeadingZeroes2.length, bArrRemoveLeadingZeroes2.length);
        return bArr;
    }

    private static byte[] removeLeadingZeroes(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int i = 1;
        while (i < bArr.length - 1 && bArr[i] == 0) {
            i++;
        }
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }

    private static void writeLength(int i, OutputStream outputStream) throws IOException {
        if (i <= 127) {
            outputStream.write(i);
            return;
        }
        int i2 = 0;
        int i3 = i;
        while (i3 != 0) {
            i3 >>>= 8;
            i2++;
        }
        outputStream.write(i2 | 128);
        for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
            outputStream.write((byte) (i >> i4));
        }
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] decodeSignature(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        String string = typesReader.readString();
        if (!string.equals(getKeyFormat())) {
            throw new IOException("Unsupported signature format: ".concat(string));
        }
        byte[] byteString = typesReader.readByteString();
        if (typesReader.remain() != 0) {
            throw new IOException("Unexpected padding in ECDSA signature");
        }
        TypesReader typesReader2 = new TypesReader(byteString);
        byte[] byteArray = typesReader2.readMPINT().toByteArray();
        byte[] byteArray2 = typesReader2.readMPINT().toByteArray();
        int length = byteArray.length;
        int length2 = byteArray2.length;
        if ((byteArray[0] & 128) != 0) {
            length++;
        }
        if ((byteArray2[0] & 128) != 0) {
            length2++;
        }
        int i = length + 6 + length2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        byteArrayOutputStream.write(48);
        writeLength(i - 2, byteArrayOutputStream);
        byteArrayOutputStream.write(2);
        writeLength(length, byteArrayOutputStream);
        if (length != byteArray.length) {
            byteArrayOutputStream.write(0);
        }
        byteArrayOutputStream.write(byteArray);
        byteArrayOutputStream.write(2);
        writeLength(length2, byteArrayOutputStream);
        if (length2 != byteArray2.length) {
            byteArrayOutputStream.write(0);
        }
        byteArrayOutputStream.write(byteArray2);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] encodeSignature(byte[] bArr) throws IOException {
        SimpleDERReader simpleDERReader = new SimpleDERReader(new SimpleDERReader(bArr).readSequenceAsByteArray());
        BigInteger bigInteger = simpleDERReader.readInt();
        BigInteger bigInteger2 = simpleDERReader.readInt();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeMPInt(bigInteger);
        typesWriter.writeMPInt(bigInteger2);
        byte[] bytes = typesWriter.getBytes();
        TypesWriter typesWriter2 = new TypesWriter();
        typesWriter2.writeString(getKeyFormat());
        typesWriter2.writeString(bytes, 0, bytes.length);
        return typesWriter2.getBytes();
    }

    public String getCurveName() {
        return this.curveName;
    }

    public ECParameterSpec getEcParameterSpec() {
        return this.ecParameterSpec;
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public boolean supportsKey(PrivateKey privateKey) {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            if (super.supportsKey(eCPrivateKey) && eCPrivateKey.getParams().getCurve().getField().getFieldSize() == getEcParameterSpec().getCurve().getField().getFieldSize()) {
                return true;
            }
        }
        return false;
    }

    private ECDSAKeyAlgorithm(String str, String str2, ECParameterSpec eCParameterSpec) {
        super(str, za0.s(ECDSA_SHA2_PREFIX, str2), ECPrivateKey.class);
        this.curveName = str2;
        this.ecParameterSpec = eCParameterSpec;
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public ECPublicKey decodePublicKey(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        if (!typesReader.readString().equals(getKeyFormat())) {
            throw new IOException("Invalid key format");
        }
        typesReader.readString();
        byte[] byteString = typesReader.readByteString();
        if (typesReader.remain() != 0) {
            throw new IOException("Unexpected adding in ECDSA public key");
        }
        ECParameterSpec ecParameterSpec = getEcParameterSpec();
        ECPoint eCPointDecodePoint = decodePoint(byteString, ecParameterSpec.getCurve());
        if (eCPointDecodePoint == null) {
            throw new IOException("Invalid ECDSA group");
        }
        try {
            return (ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPointDecodePoint, ecParameterSpec));
        } catch (GeneralSecurityException e) {
            throw new IOException("Could not decode ECDSA key", e);
        }
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] encodePublicKey(ECPublicKey eCPublicKey) {
        byte[] bArrEncodePoint = encodePoint(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(getKeyFormat());
        typesWriter.writeString(getCurveName());
        typesWriter.writeString(bArrEncodePoint, 0, bArrEncodePoint.length);
        return typesWriter.getBytes();
    }
}
