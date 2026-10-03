package com.trilead.ssh2.crypto;

import com.trilead.ssh2.crypto.cipher.AES;
import com.trilead.ssh2.crypto.cipher.CBCMode;
import com.trilead.ssh2.crypto.cipher.DES;
import com.trilead.ssh2.crypto.cipher.DESede;
import com.trilead.ssh2.crypto.digest.MD5;
import com.trilead.ssh2.signature.DSAPrivateKey;
import com.trilead.ssh2.signature.KeyAlgorithm;
import com.trilead.ssh2.signature.KeyAlgorithmManager;
import com.trilead.ssh2.signature.RSAPrivateKey;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PEMDecoder {
    private static final Logger LOGGER = Logger.getLogger(PEMDecoder.class.getName());
    private static final int PEM_DSA_PRIVATE_KEY = 2;
    private static final int PEM_RSA_PRIVATE_KEY = 1;

    @Deprecated
    public static Object decode(char[] cArr, String str) throws IOException {
        PEMStructure pem = parsePEM(cArr);
        if (isPEMEncrypted(pem)) {
            if (str == null) {
                throw new IOException("PEM is encrypted, but no password was specified");
            }
            decryptPEM(pem, str.getBytes(StandardCharsets.ISO_8859_1));
        }
        int i = pem.pemType;
        if (i != 2) {
            if (i != 1) {
                throw new IOException("PEM problem: it is of unknown type");
            }
            SimpleDERReader simpleDERReader = new SimpleDERReader(pem.data);
            byte[] sequenceAsByteArray = simpleDERReader.readSequenceAsByteArray();
            if (simpleDERReader.available() != 0) {
                throw new IOException("Padding in RSA PRIVATE KEY DER stream.");
            }
            simpleDERReader.resetInput(sequenceAsByteArray);
            BigInteger bigInteger = simpleDERReader.readInt();
            if (bigInteger.compareTo(BigInteger.ZERO) == 0 || bigInteger.compareTo(BigInteger.ONE) == 0) {
                return new RSAPrivateKey(simpleDERReader.readInt(), simpleDERReader.readInt(), simpleDERReader.readInt());
            }
            throw new IOException("Wrong version (" + bigInteger + ") in RSA PRIVATE KEY DER stream.");
        }
        SimpleDERReader simpleDERReader2 = new SimpleDERReader(pem.data);
        byte[] sequenceAsByteArray2 = simpleDERReader2.readSequenceAsByteArray();
        if (simpleDERReader2.available() != 0) {
            throw new IOException("Padding in DSA PRIVATE KEY DER stream.");
        }
        simpleDERReader2.resetInput(sequenceAsByteArray2);
        BigInteger bigInteger2 = simpleDERReader2.readInt();
        if (bigInteger2.compareTo(BigInteger.ZERO) != 0) {
            throw new IOException("Wrong version (" + bigInteger2 + ") in DSA PRIVATE KEY DER stream.");
        }
        BigInteger bigInteger3 = simpleDERReader2.readInt();
        BigInteger bigInteger4 = simpleDERReader2.readInt();
        BigInteger bigInteger5 = simpleDERReader2.readInt();
        BigInteger bigInteger6 = simpleDERReader2.readInt();
        BigInteger bigInteger7 = simpleDERReader2.readInt();
        if (simpleDERReader2.available() == 0) {
            return new DSAPrivateKey(bigInteger3, bigInteger4, bigInteger5, bigInteger6, bigInteger7);
        }
        throw new IOException("Padding in DSA PRIVATE KEY DER stream.");
    }

    public static KeyPair decodeKeyPair(char[] cArr, String str) throws IOException {
        Iterator<KeyAlgorithm<PublicKey, PrivateKey>> it = KeyAlgorithmManager.getSupportedAlgorithms().iterator();
        while (it.hasNext()) {
            for (CertificateDecoder certificateDecoder : it.next().getCertificateDecoders()) {
                try {
                    PEMStructure pem = parsePEM(cArr, certificateDecoder);
                    if (isPEMEncrypted(pem)) {
                        if (str == null) {
                            throw new IOException("PEM is encrypted, but no password was specified");
                        }
                        decryptPEM(pem, str.getBytes(StandardCharsets.ISO_8859_1));
                    }
                    return certificateDecoder.createKeyPair(pem, str);
                } catch (IOException e) {
                    LOGGER.log(Level.FINE, "Could not decode PEM Key using current decoder: ".concat(certificateDecoder.getClass().getName()), (Throwable) e);
                }
            }
        }
        throw new IOException("PEM problem: it is of unknown type");
    }

    private static void decryptPEM(PEMStructure pEMStructure, byte[] bArr) throws IOException {
        CBCMode cBCMode;
        String[] strArr = pEMStructure.dekInfo;
        if (strArr == null) {
            throw new IOException("Broken PEM, no mode and salt given, but encryption enabled");
        }
        if (strArr.length != 2) {
            throw new IOException("Broken PEM, DEK-Info is incomplete!");
        }
        String str = strArr[0];
        byte[] bArrHexToByteArray = hexToByteArray(strArr[1]);
        if (str.equals("DES-EDE3-CBC")) {
            DESede dESede = new DESede();
            dESede.init(false, generateKeyFromPasswordSaltWithMD5(bArr, bArrHexToByteArray, 24));
            cBCMode = new CBCMode(dESede, bArrHexToByteArray, false);
        } else if (str.equals("DES-CBC")) {
            DES des = new DES();
            des.init(false, generateKeyFromPasswordSaltWithMD5(bArr, bArrHexToByteArray, 8));
            cBCMode = new CBCMode(des, bArrHexToByteArray, false);
        } else if (str.equals("AES-128-CBC")) {
            AES aes = new AES();
            aes.init(false, generateKeyFromPasswordSaltWithMD5(bArr, bArrHexToByteArray, 16));
            cBCMode = new CBCMode(aes, bArrHexToByteArray, false);
        } else if (str.equals("AES-192-CBC")) {
            AES aes2 = new AES();
            aes2.init(false, generateKeyFromPasswordSaltWithMD5(bArr, bArrHexToByteArray, 24));
            cBCMode = new CBCMode(aes2, bArrHexToByteArray, false);
        } else {
            if (!str.equals("AES-256-CBC")) {
                throw new IOException("Cannot decrypt PEM structure, unknown cipher ".concat(str));
            }
            AES aes3 = new AES();
            aes3.init(false, generateKeyFromPasswordSaltWithMD5(bArr, bArrHexToByteArray, 32));
            cBCMode = new CBCMode(aes3, bArrHexToByteArray, false);
        }
        if (pEMStructure.data.length % cBCMode.getBlockSize() != 0) {
            throw new IOException("Invalid PEM structure, size of encrypted block is not a multiple of " + cBCMode.getBlockSize());
        }
        byte[] bArr2 = new byte[pEMStructure.data.length];
        for (int i = 0; i < pEMStructure.data.length / cBCMode.getBlockSize(); i++) {
            cBCMode.transformBlock(pEMStructure.data, cBCMode.getBlockSize() * i, bArr2, cBCMode.getBlockSize() * i);
        }
        pEMStructure.data = removePadding(bArr2, cBCMode.getBlockSize());
        pEMStructure.dekInfo = null;
        pEMStructure.procType = null;
    }

    public static byte[] generateKeyFromPasswordSaltWithMD5(byte[] bArr, byte[] bArr2, int i) {
        if (bArr2.length < 8) {
            throw new IllegalArgumentException("Salt needs to be at least 8 bytes for key generation.");
        }
        MD5 md5 = new MD5();
        byte[] bArr3 = new byte[i];
        int digestLength = md5.getDigestLength();
        byte[] bArr4 = new byte[digestLength];
        int i2 = i;
        while (true) {
            md5.update(bArr, 0, bArr.length);
            md5.update(bArr2, 0, 8);
            int i3 = i2 < digestLength ? i2 : digestLength;
            md5.digest(bArr4, 0);
            System.arraycopy(bArr4, 0, bArr3, i - i2, i3);
            i2 -= i3;
            if (i2 == 0) {
                return bArr3;
            }
            md5.update(bArr4, 0, digestLength);
        }
    }

    private static byte[] hexToByteArray(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null argument");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Uneven string length in hex encoding.");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((hexToInt(str.charAt(i2)) * 16) + hexToInt(str.charAt(i2 + 1)));
        }
        return bArr;
    }

    private static int hexToInt(char c) {
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c < '0' || c > '9') {
            throw new IllegalArgumentException("Need hex char");
        }
        return c - '0';
    }

    public static boolean isPEMEncrypted(PEMStructure pEMStructure) throws IOException {
        String[] strArr = pEMStructure.procType;
        if (strArr == null) {
            return false;
        }
        if (strArr.length != 2) {
            throw new IOException("Unknown Proc-Type field.");
        }
        if ("4".equals(strArr[0])) {
            return "ENCRYPTED".equals(pEMStructure.procType[1]);
        }
        throw new IOException(za0.o(new StringBuilder("Unknown Proc-Type field ("), pEMStructure.procType[0], ")"));
    }

    private static PEMStructure parsePEM(char[] cArr) throws IOException {
        String str;
        PEMStructure pEMStructure = new PEMStructure();
        BufferedReader bufferedReader = new BufferedReader(new CharArrayReader(cArr));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                throw new IOException("Invalid PEM structure, '-----BEGIN...' missing");
            }
            String strTrim = line.trim();
            if (strTrim.startsWith("-----BEGIN DSA PRIVATE KEY-----")) {
                pEMStructure.pemType = 2;
                str = "-----END DSA PRIVATE KEY-----";
                break;
            }
            if (strTrim.startsWith("-----BEGIN RSA PRIVATE KEY-----")) {
                pEMStructure.pemType = 1;
                str = "-----END RSA PRIVATE KEY-----";
                break;
            }
        }
        while (true) {
            String line2 = bufferedReader.readLine();
            if (line2 == null) {
                throw new IOException(za0.l("Invalid PEM structure, ", str, " missing"));
            }
            String strTrim2 = line2.trim();
            int iIndexOf = strTrim2.indexOf(58);
            if (iIndexOf == -1) {
                StringBuilder sb = new StringBuilder();
                while (strTrim2 != null) {
                    String strTrim3 = strTrim2.trim();
                    if (strTrim3.startsWith(str)) {
                        int length = sb.length();
                        char[] cArr2 = new char[length];
                        sb.getChars(0, length, cArr2, 0);
                        byte[] bArrDecode = Base64.decode(cArr2);
                        pEMStructure.data = bArrDecode;
                        if (bArrDecode.length != 0) {
                            return pEMStructure;
                        }
                        throw new IOException("Invalid PEM structure, no data available");
                    }
                    sb.append(strTrim3);
                    strTrim2 = bufferedReader.readLine();
                }
                throw new IOException(za0.l("Invalid PEM structure, ", str, " missing"));
            }
            int i = iIndexOf + 1;
            String strSubstring = strTrim2.substring(0, i);
            String[] strArrSplit = strTrim2.substring(i).split(",");
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                strArrSplit[i2] = strArrSplit[i2].trim();
            }
            if ("Proc-Type:".equals(strSubstring)) {
                pEMStructure.procType = strArrSplit;
            } else if ("DEK-Info:".equals(strSubstring)) {
                pEMStructure.dekInfo = strArrSplit;
            }
        }
    }

    private static byte[] removePadding(byte[] bArr, int i) throws IOException {
        int i2 = bArr[bArr.length - 1] & 255;
        if (i2 < 1 || i2 > i) {
            throw new IOException("Decrypted PEM has wrong padding, did you specify the correct password?");
        }
        for (int i3 = 2; i3 <= i2; i3++) {
            if (bArr[bArr.length - i3] != i2) {
                throw new IOException("Decrypted PEM has wrong padding, did you specify the correct password?");
            }
        }
        byte[] bArr2 = new byte[bArr.length - i2];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length - i2);
        return bArr2;
    }

    private static PEMStructure parsePEM(char[] cArr, CertificateDecoder certificateDecoder) throws IOException {
        String line;
        PEMStructure pEMStructure = new PEMStructure();
        BufferedReader bufferedReader = new BufferedReader(new CharArrayReader(cArr));
        do {
            line = bufferedReader.readLine();
            if (line == null) {
                throw new IOException("Invalid PEM structure, '-----BEGIN...' missing");
            }
        } while (!line.trim().startsWith(certificateDecoder.getStartLine()));
        String endLine = certificateDecoder.getEndLine();
        while (true) {
            String line2 = bufferedReader.readLine();
            if (line2 != null) {
                String strTrim = line2.trim();
                int iIndexOf = strTrim.indexOf(58);
                if (iIndexOf == -1) {
                    StringBuilder sb = new StringBuilder();
                    while (strTrim != null) {
                        String strTrim2 = strTrim.trim();
                        if (strTrim2.startsWith(endLine)) {
                            int length = sb.length();
                            char[] cArr2 = new char[length];
                            sb.getChars(0, length, cArr2, 0);
                            byte[] bArrDecode = Base64.decode(cArr2);
                            pEMStructure.data = bArrDecode;
                            if (bArrDecode.length != 0) {
                                return pEMStructure;
                            }
                            throw new IOException("Invalid PEM structure, no data available");
                        }
                        sb.append(strTrim2);
                        strTrim = bufferedReader.readLine();
                    }
                    throw new IOException(za0.l("Invalid PEM structure, ", endLine, " missing"));
                }
                int i = iIndexOf + 1;
                String strSubstring = strTrim.substring(0, i);
                String[] strArrSplit = strTrim.substring(i).split(",");
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    strArrSplit[i2] = strArrSplit[i2].trim();
                }
                if ("Proc-Type:".equals(strSubstring)) {
                    pEMStructure.procType = strArrSplit;
                } else if ("DEK-Info:".equals(strSubstring)) {
                    pEMStructure.dekInfo = strArrSplit;
                }
            } else {
                throw new IOException(za0.l("Invalid PEM structure, ", endLine, " missing"));
            }
        }
    }
}
