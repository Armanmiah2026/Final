package com.trilead.ssh2.signature;

import com.trilead.ssh2.IOWarningException;
import com.trilead.ssh2.crypto.SimpleDERReader;
import com.trilead.ssh2.crypto.digest.SHA1;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import java.io.IOException;
import java.math.BigInteger;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RSASHA1Verify {
    private static final Logger log = Logger.getLogger(RSASHA1Verify.class);

    @Deprecated
    public static RSAPublicKey decodeSSHRSAPublicKey(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        String string = typesReader.readString();
        if (!string.equals("ssh-rsa")) {
            throw new IOWarningException(za0.l("Unsupported key format found '", string, "' while expecting ssh-rsa"));
        }
        BigInteger mpint = typesReader.readMPINT();
        BigInteger mpint2 = typesReader.readMPINT();
        if (typesReader.remain() == 0) {
            return new RSAPublicKey(mpint, mpint2);
        }
        throw new IOException("Padding in RSA public key!");
    }

    @Deprecated
    public static RSASignature decodeSSHRSASignature(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        if (!typesReader.readString().equals("ssh-rsa")) {
            throw new IOException("Peer sent wrong signature format");
        }
        byte[] byteString = typesReader.readByteString();
        if (byteString.length == 0) {
            throw new IOException("Error in RSA signature, S is empty.");
        }
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(80, "Decoding ssh-rsa signature string (length: " + byteString.length + ")");
        }
        if (typesReader.remain() == 0) {
            return new RSASignature(new BigInteger(1, byteString));
        }
        throw new IOException("Padding in RSA signature!");
    }

    @Deprecated
    public static byte[] encodeSSHRSAPublicKey(RSAPublicKey rSAPublicKey) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString("ssh-rsa");
        typesWriter.writeMPInt(rSAPublicKey.getE());
        typesWriter.writeMPInt(rSAPublicKey.getN());
        return typesWriter.getBytes();
    }

    @Deprecated
    public static byte[] encodeSSHRSASignature(RSASignature rSASignature) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString("ssh-rsa");
        byte[] byteArray = rSASignature.getS().toByteArray();
        if (byteArray.length <= 1 || byteArray[0] != 0) {
            typesWriter.writeString(byteArray, 0, byteArray.length);
        } else {
            typesWriter.writeString(byteArray, 1, byteArray.length - 1);
        }
        return typesWriter.getBytes();
    }

    @Deprecated
    public static RSASignature generateSignature(byte[] bArr, RSAPrivateKey rSAPrivateKey) throws IOException {
        SHA1 sha1 = new SHA1();
        sha1.update(bArr);
        int digestLength = sha1.getDigestLength();
        byte[] bArr2 = new byte[digestLength];
        sha1.digest(bArr2);
        byte[] bArr3 = {48, 33, 48, 9, 6, 5, 43, 14, 3, 2, 26, 5, 0, 4, 20};
        int iBitLength = ((rSAPrivateKey.getN().bitLength() + 7) / 8) - (17 + digestLength);
        int i = iBitLength - 1;
        if (i < 8) {
            throw new IOException("Cannot sign with RSA, message too long");
        }
        byte[] bArr4 = new byte[digestLength + 17 + i];
        bArr4[0] = 1;
        int i2 = 0;
        while (i2 < i) {
            i2++;
            bArr4[i2] = -1;
        }
        bArr4[iBitLength] = 0;
        System.arraycopy(bArr3, 0, bArr4, iBitLength + 1, 15);
        System.arraycopy(bArr2, 0, bArr4, iBitLength + 16, digestLength);
        return new RSASignature(new BigInteger(1, bArr4).modPow(rSAPrivateKey.getD(), rSAPrivateKey.getN()));
    }

    @Deprecated
    public static boolean verifySignature(byte[] bArr, RSASignature rSASignature, RSAPublicKey rSAPublicKey) throws IOException {
        SHA1 sha1 = new SHA1();
        sha1.update(bArr);
        int digestLength = sha1.getDigestLength();
        byte[] bArr2 = new byte[digestLength];
        sha1.digest(bArr2);
        BigInteger n = rSAPublicKey.getN();
        BigInteger e = rSAPublicKey.getE();
        BigInteger s = rSASignature.getS();
        if (n.compareTo(s) <= 0) {
            log.log(20, "ssh-rsa signature: n.compareTo(s) <= 0");
            return false;
        }
        int iBitLength = (n.bitLength() + 7) / 8;
        if (iBitLength < 1) {
            log.log(20, "ssh-rsa signature: rsa_block_len < 1");
            return false;
        }
        byte[] byteArray = s.modPow(e, n).toByteArray();
        int i = (byteArray.length <= 0 || byteArray[0] != 0) ? 0 : 1;
        if (byteArray.length - i != iBitLength - 1) {
            log.log(20, "ssh-rsa signature: (v.length - startpos) != (rsa_block_len - 1)");
            return false;
        }
        if (byteArray[i] != 1) {
            log.log(20, "ssh-rsa signature: v[startpos] != 0x01");
            return false;
        }
        int i2 = i + 1;
        for (int i3 = i2; i3 < byteArray.length; i3++) {
            byte b = byteArray[i3];
            if (b == 0) {
                if (i3 - i2 < 8) {
                    log.log(20, "ssh-rsa signature: num_pad < 8");
                    return false;
                }
                int i4 = i3 + 1;
                if (i4 >= byteArray.length) {
                    log.log(20, "ssh-rsa signature: pos >= v.length");
                    return false;
                }
                SimpleDERReader simpleDERReader = new SimpleDERReader(byteArray, i4, byteArray.length - i4);
                byte[] sequenceAsByteArray = simpleDERReader.readSequenceAsByteArray();
                if (simpleDERReader.available() != 0) {
                    log.log(20, "ssh-rsa signature: dr.available() != 0");
                    return false;
                }
                simpleDERReader.resetInput(sequenceAsByteArray);
                byte[] sequenceAsByteArray2 = simpleDERReader.readSequenceAsByteArray();
                if (sequenceAsByteArray2.length < 8 || sequenceAsByteArray2.length > 9) {
                    log.log(20, "ssh-rsa signature: (digestAlgorithm.length < 8) || (digestAlgorithm.length > 9)");
                    return false;
                }
                byte[] bArr3 = {6, 5, 43, 14, 3, 2, 26, 5, 0};
                for (int i5 = 0; i5 < sequenceAsByteArray2.length; i5++) {
                    if (sequenceAsByteArray2[i5] != bArr3[i5]) {
                        log.log(20, "ssh-rsa signature: digestAlgorithm[i] != digestAlgorithm_sha1[i]");
                        return false;
                    }
                }
                byte[] octetString = simpleDERReader.readOctetString();
                if (simpleDERReader.available() != 0) {
                    log.log(20, "ssh-rsa signature: dr.available() != 0 (II)");
                    return false;
                }
                if (octetString.length != digestLength) {
                    log.log(20, "ssh-rsa signature: digest.length != sha_message.length");
                    return false;
                }
                for (int i6 = 0; i6 < digestLength; i6++) {
                    if (bArr2[i6] != octetString[i6]) {
                        log.log(20, "ssh-rsa signature: sha_message[i] != digest[i]");
                        return false;
                    }
                }
                return true;
            }
            if (b != -1) {
                log.log(20, "ssh-rsa signature: v[pos] != (byte) 0xff");
                return false;
            }
        }
        log.log(20, "ssh-rsa signature: pos >= v.length");
        return false;
    }
}
