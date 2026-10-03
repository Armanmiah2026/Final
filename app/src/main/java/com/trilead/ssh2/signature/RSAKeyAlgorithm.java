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
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class RSAKeyAlgorithm extends KeyAlgorithm<java.security.interfaces.RSAPublicKey, java.security.interfaces.RSAPrivateKey> {

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class RSACertificateDecoder extends CertificateDecoder {
        public /* synthetic */ RSACertificateDecoder(int i) {
            this();
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public KeyPair createKeyPair(PEMStructure pEMStructure) throws IOException {
            SimpleDERReader simpleDERReader = new SimpleDERReader(pEMStructure.getData());
            byte[] sequenceAsByteArray = simpleDERReader.readSequenceAsByteArray();
            if (simpleDERReader.available() != 0) {
                throw new IOException("Padding in RSA PRIVATE KEY DER stream.");
            }
            simpleDERReader.resetInput(sequenceAsByteArray);
            BigInteger bigInteger = simpleDERReader.readInt();
            if (bigInteger.compareTo(BigInteger.ZERO) != 0 && bigInteger.compareTo(BigInteger.ONE) != 0) {
                throw new IOException("Wrong version (" + bigInteger + ") in RSA PRIVATE KEY DER stream.");
            }
            BigInteger bigInteger2 = simpleDERReader.readInt();
            BigInteger bigInteger3 = simpleDERReader.readInt();
            try {
                RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec = new RSAPrivateCrtKeySpec(bigInteger2, bigInteger3, simpleDERReader.readInt(), simpleDERReader.readInt(), simpleDERReader.readInt(), simpleDERReader.readInt(), simpleDERReader.readInt(), simpleDERReader.readInt());
                RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec(bigInteger2, bigInteger3);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(rSAPublicKeySpec), keyFactory.generatePrivate(rSAPrivateCrtKeySpec));
            } catch (GeneralSecurityException unused) {
                throw new IOException("Could not decode RSA Key Pair");
            }
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public String getEndLine() {
            return "-----END RSA PRIVATE KEY-----";
        }

        @Override // com.trilead.ssh2.crypto.CertificateDecoder
        public String getStartLine() {
            return "-----BEGIN RSA PRIVATE KEY-----";
        }

        private RSACertificateDecoder() {
        }
    }

    public RSAKeyAlgorithm() {
        super("SHA1WithRSA", "ssh-rsa", java.security.interfaces.RSAPrivateKey.class);
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] decodeSignature(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        if (!typesReader.readString().equals(getKeyFormat())) {
            throw new IOException("Peer sent wrong signature format");
        }
        byte[] byteString = typesReader.readByteString();
        if (byteString.length == 0) {
            throw new IOException("Error in RSA signature, S is empty.");
        }
        if (typesReader.remain() == 0) {
            return byteString;
        }
        throw new IOException("Padding in RSA signature!");
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] encodeSignature(byte[] bArr) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(getKeyFormat());
        if (bArr.length <= 1 || bArr[0] != 0) {
            typesWriter.writeString(bArr, 0, bArr.length);
        } else {
            typesWriter.writeString(bArr, 1, bArr.length - 1);
        }
        return typesWriter.getBytes();
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public List<CertificateDecoder> getCertificateDecoders() {
        return Arrays.asList(new RSACertificateDecoder(0), new OpenSshCertificateDecoder("ssh-rsa") { // from class: com.trilead.ssh2.signature.RSAKeyAlgorithm.1
            @Override // com.trilead.ssh2.signature.OpenSshCertificateDecoder
            public KeyPair generateKeyPair(TypesReader typesReader) throws NoSuchAlgorithmException, IOException {
                KeySpec rSAPrivateKeySpec;
                BigInteger mpint = typesReader.readMPINT();
                BigInteger mpint2 = typesReader.readMPINT();
                BigInteger mpint3 = typesReader.readMPINT();
                BigInteger mpint4 = typesReader.readMPINT();
                BigInteger mpint5 = typesReader.readMPINT();
                RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec(mpint, mpint2);
                if (mpint5 == null || mpint4 == null) {
                    rSAPrivateKeySpec = new RSAPrivateKeySpec(mpint, mpint3);
                } else {
                    BigInteger bigIntegerModInverse = mpint4.modInverse(mpint5);
                    BigInteger bigInteger = BigInteger.ONE;
                    rSAPrivateKeySpec = new RSAPrivateCrtKeySpec(mpint, mpint2, mpint3, mpint5, bigIntegerModInverse, mpint3.mod(mpint5.subtract(bigInteger)), mpint3.mod(bigIntegerModInverse.subtract(bigInteger)), mpint4);
                }
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(rSAPublicKeySpec), keyFactory.generatePrivate(rSAPrivateKeySpec));
            }
        });
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public java.security.interfaces.RSAPublicKey decodePublicKey(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        String string = typesReader.readString();
        if (!string.equals(getKeyFormat())) {
            throw new IOWarningException("Unsupported key format found '" + string + "' while expecting " + getKeyFormat());
        }
        BigInteger mpint = typesReader.readMPINT();
        BigInteger mpint2 = typesReader.readMPINT();
        if (typesReader.remain() != 0) {
            throw new IOException("Padding in RSA public key!");
        }
        try {
            return (java.security.interfaces.RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(mpint2, mpint));
        } catch (GeneralSecurityException e) {
            throw new IOException("Could not generate RSA key", e);
        }
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] encodePublicKey(java.security.interfaces.RSAPublicKey rSAPublicKey) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(getKeyFormat());
        typesWriter.writeMPInt(rSAPublicKey.getPublicExponent());
        typesWriter.writeMPInt(rSAPublicKey.getModulus());
        return typesWriter.getBytes();
    }
}
