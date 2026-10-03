package com.trilead.ssh2.signature;

import com.trilead.ssh2.IOWarningException;
import com.trilead.ssh2.crypto.digest.SHA1;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class DSASHA1Verify {
    private static final Logger log = Logger.getLogger(DSASHA1Verify.class);

    @Deprecated
    public static DSAPublicKey decodeSSHDSAPublicKey(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        String string = typesReader.readString();
        if (!string.equals("ssh-dss")) {
            throw new IOWarningException(za0.l("Unsupported key format found '", string, "' while expecting ssh-dss"));
        }
        BigInteger mpint = typesReader.readMPINT();
        BigInteger mpint2 = typesReader.readMPINT();
        BigInteger mpint3 = typesReader.readMPINT();
        BigInteger mpint4 = typesReader.readMPINT();
        if (typesReader.remain() == 0) {
            return new DSAPublicKey(mpint, mpint2, mpint3, mpint4);
        }
        throw new IOException("Padding in DSA public key!");
    }

    @Deprecated
    public static DSASignature decodeSSHDSASignature(byte[] bArr) throws IOException {
        if (bArr.length != 40) {
            TypesReader typesReader = new TypesReader(bArr);
            if (!typesReader.readString().equals("ssh-dss")) {
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
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        BigInteger bigInteger = new BigInteger(1, bArr2);
        System.arraycopy(bArr, 20, bArr2, 0, 20);
        BigInteger bigInteger2 = new BigInteger(1, bArr2);
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(30, "decoded ssh-dss signature: first bytes r(" + (bArr[0] & 255) + "), s(" + (bArr[20] & 255) + ")");
        }
        return new DSASignature(bigInteger, bigInteger2);
    }

    @Deprecated
    public static byte[] encodeSSHDSAPublicKey(DSAPublicKey dSAPublicKey) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString("ssh-dss");
        typesWriter.writeMPInt(dSAPublicKey.getP());
        typesWriter.writeMPInt(dSAPublicKey.getQ());
        typesWriter.writeMPInt(dSAPublicKey.getG());
        typesWriter.writeMPInt(dSAPublicKey.getY());
        return typesWriter.getBytes();
    }

    @Deprecated
    public static byte[] encodeSSHDSASignature(DSASignature dSASignature) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString("ssh-dss");
        byte[] byteArray = dSASignature.getR().toByteArray();
        byte[] byteArray2 = dSASignature.getS().toByteArray();
        byte[] bArr = new byte[40];
        int length = byteArray.length < 20 ? byteArray.length : 20;
        int length2 = byteArray2.length < 20 ? byteArray2.length : 20;
        System.arraycopy(byteArray, byteArray.length - length, bArr, 20 - length, length);
        System.arraycopy(byteArray2, byteArray2.length - length2, bArr, 40 - length2, length2);
        typesWriter.writeString(bArr, 0, 40);
        return typesWriter.getBytes();
    }

    @Deprecated
    public static DSASignature generateSignature(byte[] bArr, DSAPrivateKey dSAPrivateKey, SecureRandom secureRandom) {
        BigInteger bigInteger;
        SHA1 sha1 = new SHA1();
        sha1.update(bArr);
        byte[] bArr2 = new byte[sha1.getDigestLength()];
        sha1.digest(bArr2);
        BigInteger bigInteger2 = new BigInteger(1, bArr2);
        int iBitLength = dSAPrivateKey.getQ().bitLength();
        do {
            bigInteger = new BigInteger(iBitLength, secureRandom);
        } while (bigInteger.compareTo(dSAPrivateKey.getQ()) >= 0);
        BigInteger bigIntegerMod = dSAPrivateKey.getG().modPow(bigInteger, dSAPrivateKey.getP()).mod(dSAPrivateKey.getQ());
        return new DSASignature(bigIntegerMod, bigInteger.modInverse(dSAPrivateKey.getQ()).multiply(bigInteger2.add(dSAPrivateKey.getX().multiply(bigIntegerMod))).mod(dSAPrivateKey.getQ()));
    }

    @Deprecated
    public static boolean verifySignature(byte[] bArr, DSASignature dSASignature, DSAPublicKey dSAPublicKey) {
        SHA1 sha1 = new SHA1();
        sha1.update(bArr);
        byte[] bArr2 = new byte[sha1.getDigestLength()];
        sha1.digest(bArr2);
        BigInteger bigInteger = new BigInteger(1, bArr2);
        BigInteger r = dSASignature.getR();
        BigInteger s = dSASignature.getS();
        BigInteger g = dSAPublicKey.getG();
        BigInteger p = dSAPublicKey.getP();
        BigInteger q = dSAPublicKey.getQ();
        BigInteger y = dSAPublicKey.getY();
        BigInteger bigInteger2 = BigInteger.ZERO;
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(60, "ssh-dss signature: m: " + bigInteger.toString(16));
            logger.log(60, "ssh-dss signature: r: " + r.toString(16));
            logger.log(60, "ssh-dss signature: s: " + s.toString(16));
            logger.log(60, "ssh-dss signature: g: " + g.toString(16));
            logger.log(60, "ssh-dss signature: p: " + p.toString(16));
            logger.log(60, "ssh-dss signature: q: " + q.toString(16));
            logger.log(60, "ssh-dss signature: y: " + y.toString(16));
        }
        if (bigInteger2.compareTo(r) >= 0 || q.compareTo(r) <= 0) {
            logger.log(20, "ssh-dss signature: zero.compareTo(r) >= 0 || q.compareTo(r) <= 0");
            return false;
        }
        if (bigInteger2.compareTo(s) >= 0 || q.compareTo(s) <= 0) {
            logger.log(20, "ssh-dss signature: zero.compareTo(s) >= 0 || q.compareTo(s) <= 0");
            return false;
        }
        BigInteger bigIntegerModInverse = s.modInverse(q);
        return g.modPow(bigInteger.multiply(bigIntegerModInverse).mod(q), p).multiply(y.modPow(r.multiply(bigIntegerModInverse).mod(q), p)).mod(p).mod(q).equals(r);
    }
}
