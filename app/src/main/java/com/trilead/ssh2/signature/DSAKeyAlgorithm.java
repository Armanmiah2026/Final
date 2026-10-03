package com.trilead.ssh2.signature;

import com.trilead.ssh2.IOWarningException;
import com.trilead.ssh2.crypto.CertificateDecoder;
import com.trilead.ssh2.crypto.PEMStructure;
import com.trilead.ssh2.crypto.SimpleDERReader;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.DSAParams;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DSAKeyAlgorithm extends KeyAlgorithm<java.security.interfaces.DSAPublicKey, java.security.interfaces.DSAPrivateKey> {

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class DsaCertificateDecoder extends CertificateDecoder {
        public /* synthetic */ DsaCertificateDecoder(int i) {
            this();
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public KeyPair createKeyPair(PEMStructure pEMStructure) throws IOException {
            SimpleDERReader simpleDERReader = new SimpleDERReader(pEMStructure.getData());
            byte[] sequenceAsByteArray = simpleDERReader.readSequenceAsByteArray();
            if (simpleDERReader.available() != 0) {
                throw new IOException("Padding in DSA PRIVATE KEY DER stream.");
            }
            simpleDERReader.resetInput(sequenceAsByteArray);
            BigInteger bigInteger = simpleDERReader.readInt();
            if (bigInteger.compareTo(BigInteger.ZERO) != 0) {
                throw new IOException("Wrong version (" + bigInteger + ") in DSA PRIVATE KEY DER stream.");
            }
            BigInteger bigInteger2 = simpleDERReader.readInt();
            BigInteger bigInteger3 = simpleDERReader.readInt();
            BigInteger bigInteger4 = simpleDERReader.readInt();
            BigInteger bigInteger5 = simpleDERReader.readInt();
            BigInteger bigInteger6 = simpleDERReader.readInt();
            if (simpleDERReader.available() != 0) {
                throw new IOException("Padding in DSA PRIVATE KEY DER stream.");
            }
            try {
                DSAPrivateKeySpec dSAPrivateKeySpec = new DSAPrivateKeySpec(bigInteger6, bigInteger2, bigInteger3, bigInteger4);
                DSAPublicKeySpec dSAPublicKeySpec = new DSAPublicKeySpec(bigInteger5, bigInteger2, bigInteger3, bigInteger4);
                KeyFactory keyFactory = KeyFactory.getInstance("DSA");
                return new KeyPair(keyFactory.generatePublic(dSAPublicKeySpec), keyFactory.generatePrivate(dSAPrivateKeySpec));
            } catch (GeneralSecurityException unused) {
                throw new IOException("Could not decode DSA key pair");
            }
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public String getEndLine() {
            return "-----END DSA PRIVATE KEY-----";
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public String getStartLine() {
            return "-----BEGIN DSA PRIVATE KEY-----";
        }

        private DsaCertificateDecoder() {
        }
    }

    public DSAKeyAlgorithm() {
        super("SHA1WithDSA", "ssh-dss", java.security.interfaces.DSAPrivateKey.class);
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] decodeSignature(byte[] bArr) throws IOException {
        byte b;
        byte b2;
        if (bArr.length != 40) {
            TypesReader typesReader = new TypesReader(bArr);
            if (!typesReader.readString().equals(getKeyFormat())) {
                throw new IOException("Peer sent wrong signature format");
            }
            bArr = typesReader.readByteString();
            if (bArr.length != 40) {
                throw new IOException("Peer sent corrupt signature");
            }
            if (typesReader.remain() != 0) {
                throw new IOException("Padding in DSA signature!");
            }
        }
        byte b3 = bArr[0];
        if (b3 == 0 && (b = bArr[1]) == 0 && (b2 = bArr[2]) == 0) {
            int i = ((b3 << 24) & (-16777216)) | ((b << 16) & 16711680) | ((b2 << 8) & 65280) | (bArr[3] & 255);
            int i2 = ((bArr[4 + i] << 24) & (-16777216)) | (16711680 & (bArr[i + 5] << 16)) | (65280 & (bArr[i + 6] << 8)) | (bArr[i + 7] & 255);
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i + 8, bArr2, 0, i2);
            bArr = bArr2;
        }
        int i3 = (bArr[0] & 128) != 0 ? 1 : 0;
        byte b4 = (bArr[20] & 128) != 0 ? (byte) 1 : (byte) 0;
        byte[] bArr3 = new byte[za0.f(bArr.length, 6, i3, b4)];
        bArr3[0] = 48;
        if (bArr.length != 40) {
            throw new IOException("Peer sent corrupt signature");
        }
        bArr3[1] = 44;
        byte b5 = (byte) (44 + i3);
        bArr3[1] = b5;
        bArr3[1] = (byte) (b5 + b4);
        bArr3[2] = 2;
        bArr3[3] = 20;
        bArr3[3] = (byte) (20 + i3);
        System.arraycopy(bArr, 0, bArr3, i3 + 4, 20);
        bArr3[bArr3[3] + 4] = 2;
        bArr3[bArr3[3] + 5] = 20;
        int i4 = bArr3[3] + 5;
        bArr3[i4] = (byte) (bArr3[i4] + b4);
        System.arraycopy(bArr, 20, bArr3, bArr3[3] + 6 + b4, 20);
        return bArr3;
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] encodeSignature(byte[] bArr) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(getKeyFormat());
        int i = bArr[3] & 255;
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 4, bArr2, 0, i);
        int i2 = bArr[i + 5] & 255;
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, i + 6, bArr3, 0, i2);
        byte[] bArr4 = new byte[40];
        int i3 = i < 20 ? i : 20;
        int i4 = i2 < 20 ? i2 : 20;
        System.arraycopy(bArr2, i - i3, bArr4, 20 - i3, i3);
        System.arraycopy(bArr3, i2 - i4, bArr4, 40 - i4, i4);
        typesWriter.writeString(bArr4, 0, 40);
        return typesWriter.getBytes();
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public List<CertificateDecoder> getCertificateDecoders() {
        return Arrays.asList(new DsaCertificateDecoder(0), new OpenSshCertificateDecoder(getKeyFormat()) { // from class: com.trilead.ssh2.signature.DSAKeyAlgorithm.1
            @Override // com.trilead.ssh2.signature.OpenSshCertificateDecoder
            public KeyPair generateKeyPair(TypesReader typesReader) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
                BigInteger mpint = typesReader.readMPINT();
                BigInteger mpint2 = typesReader.readMPINT();
                BigInteger mpint3 = typesReader.readMPINT();
                BigInteger mpint4 = typesReader.readMPINT();
                DSAPrivateKeySpec dSAPrivateKeySpec = new DSAPrivateKeySpec(typesReader.readMPINT(), mpint, mpint2, mpint3);
                DSAPublicKeySpec dSAPublicKeySpec = new DSAPublicKeySpec(mpint4, mpint, mpint2, mpint3);
                KeyFactory keyFactory = KeyFactory.getInstance("DSA");
                return new KeyPair(keyFactory.generatePublic(dSAPublicKeySpec), keyFactory.generatePrivate(dSAPrivateKeySpec));
            }
        });
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public java.security.interfaces.DSAPublicKey decodePublicKey(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        String string = typesReader.readString();
        if (!string.equals(getKeyFormat())) {
            throw new IOWarningException("Unsupported key format found '" + string + "' while expecting " + getKeyFormat());
        }
        BigInteger mpint = typesReader.readMPINT();
        BigInteger mpint2 = typesReader.readMPINT();
        BigInteger mpint3 = typesReader.readMPINT();
        BigInteger mpint4 = typesReader.readMPINT();
        if (typesReader.remain() != 0) {
            throw new IOException("Padding in DSA public key!");
        }
        try {
            return (java.security.interfaces.DSAPublicKey) KeyFactory.getInstance("DSA").generatePublic(new DSAPublicKeySpec(mpint4, mpint, mpint2, mpint3));
        } catch (GeneralSecurityException e) {
            throw new IOException("Could not generate DSA Key", e);
        }
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] encodePublicKey(java.security.interfaces.DSAPublicKey dSAPublicKey) {
        DSAParams params = dSAPublicKey.getParams();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(getKeyFormat());
        typesWriter.writeMPInt(params.getP());
        typesWriter.writeMPInt(params.getQ());
        typesWriter.writeMPInt(params.getG());
        typesWriter.writeMPInt(dSAPublicKey.getY());
        return typesWriter.getBytes();
    }
}
