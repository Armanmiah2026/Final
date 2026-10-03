package com.trilead.ssh2;

import com.trilead.ssh2.crypto.Base64;
import com.trilead.ssh2.crypto.digest.Digest;
import com.trilead.ssh2.crypto.digest.MD5;
import com.trilead.ssh2.crypto.digest.MessageMac;
import com.trilead.ssh2.crypto.digest.SHA1;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.signature.KeyAlgorithm;
import com.trilead.ssh2.signature.KeyAlgorithmManager;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class KnownHosts {
    public static final int HOSTKEY_HAS_CHANGED = 2;
    public static final int HOSTKEY_IS_NEW = 1;
    public static final int HOSTKEY_IS_OK = 0;
    private static final Logger LOGGER = Logger.getLogger(KnownHosts.class);
    private static final SecureRandom SECURE_RANDOM = RandomFactory.create();
    private final LinkedList<KnownHostsEntry> publicKeys = new LinkedList<>();

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class KnownHostsEntry {
        private final String algorithm;
        private final PublicKey key;
        private final String[] patterns;

        public /* synthetic */ KnownHostsEntry(KnownHosts knownHosts, String[] strArr, PublicKey publicKey, String str, int i) {
            this(strArr, publicKey, str);
        }

        private KnownHostsEntry(String[] strArr, PublicKey publicKey, String str) {
            this.patterns = strArr;
            this.key = publicKey;
            this.algorithm = str;
        }
    }

    public KnownHosts() {
    }

    public static void addHostkeyToFile(File file, String[] strArr, String str, byte[] bArr) throws IOException {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("Need at least one hostname specification");
        }
        if (str == null || bArr == null) {
            throw new IllegalArgumentException();
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                charArrayWriter.write(44);
            }
            charArrayWriter.write(strArr[i]);
        }
        charArrayWriter.write(32);
        charArrayWriter.write(str);
        charArrayWriter.write(32);
        charArrayWriter.write(Base64.encode(bArr));
        charArrayWriter.write("\n");
        char[] charArray = charArrayWriter.toCharArray();
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        long length = randomAccessFile.length();
        if (length > 0) {
            randomAccessFile.seek(length - 1);
            if (randomAccessFile.read() != 10) {
                randomAccessFile.write(10);
            }
        }
        randomAccessFile.write(new String(charArray).getBytes(StandardCharsets.ISO_8859_1));
        randomAccessFile.close();
    }

    private boolean checkHashed(String str, String str2) {
        int iIndexOf;
        if (!str.startsWith("|1|") || (iIndexOf = str.indexOf(124, 3)) == -1) {
            return false;
        }
        String strSubstring = str.substring(3, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        try {
            byte[] bArrDecode = Base64.decode(strSubstring.toCharArray());
            byte[] bArrDecode2 = Base64.decode(strSubstring2.toCharArray());
            if (bArrDecode.length != new SHA1().getDigestLength()) {
                return false;
            }
            byte[] bArrHmacSha1Hash = hmacSha1Hash(bArrDecode, str2);
            for (int i = 0; i < bArrHmacSha1Hash.length; i++) {
                if (bArrHmacSha1Hash[i] != bArrDecode2[i]) {
                    return false;
                }
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private int checkKey(String str, PublicKey publicKey) {
        synchronized (this.publicKeys) {
            try {
                int i = 1;
                for (KnownHostsEntry knownHostsEntry : this.publicKeys) {
                    if (hostnameMatches(knownHostsEntry.patterns, str)) {
                        if (matchKeys(knownHostsEntry.key, publicKey)) {
                            return 0;
                        }
                        i = 2;
                    }
                }
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String createBubblebabbleFingerprint(String str, byte[] bArr) {
        return rawToBubblebabbleFingerprint(rawFingerPrint("sha1", str, bArr));
    }

    public static String createHashedHostname(String str) {
        byte[] bArr = new byte[new SHA1().getDigestLength()];
        SECURE_RANDOM.nextBytes(bArr);
        byte[] bArrHmacSha1Hash = hmacSha1Hash(bArr, str);
        return "|1|" + new String(Base64.encode(bArr)) + "|" + new String(Base64.encode(bArrHmacSha1Hash));
    }

    public static String createHexFingerprint(String str, byte[] bArr) {
        return rawToHexFingerprint(rawFingerPrint("md5", str, bArr));
    }

    private PublicKey decodeHostKey(String str, byte[] bArr) {
        for (KeyAlgorithm<PublicKey, PrivateKey> keyAlgorithm : KeyAlgorithmManager.getSupportedAlgorithms()) {
            if (keyAlgorithm.getKeyFormat().equals(str)) {
                return keyAlgorithm.decodePublicKey(bArr);
            }
        }
        throw new IllegalArgumentException(za0.s("Unknown hostkey type ", str));
    }

    private Vector<KnownHostsEntry> getAllKnownHostEntries(String str) {
        Vector<KnownHostsEntry> vector = new Vector<>();
        synchronized (this.publicKeys) {
            try {
                for (KnownHostsEntry knownHostsEntry : this.publicKeys) {
                    if (hostnameMatches(knownHostsEntry.patterns, str)) {
                        vector.addElement(knownHostsEntry);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return vector;
    }

    private static byte[] hmacSha1Hash(byte[] bArr, String str) {
        if (bArr.length != 20) {
            throw new IllegalArgumentException(za0.n(new StringBuilder("Salt has wrong length ("), bArr.length, ")"));
        }
        MessageMac messageMac = new MessageMac("hmac-sha1", bArr);
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        messageMac.update(bytes, 0, bytes.length);
        byte[] bArr2 = new byte[20];
        messageMac.getMac(bArr2, 0);
        return bArr2;
    }

    private boolean hostnameMatches(String[] strArr, String str) {
        boolean z;
        String lowerCase = str.toLowerCase();
        boolean z2 = false;
        for (String strSubstring : strArr) {
            if (strSubstring != null) {
                if (strSubstring.length() <= 0 || strSubstring.charAt(0) != '!') {
                    z = false;
                } else {
                    strSubstring = strSubstring.substring(1);
                    z = true;
                }
                if (!z2 || z) {
                    if (strSubstring.charAt(0) != '|') {
                        String lowerCase2 = strSubstring.toLowerCase();
                        if (lowerCase2.indexOf(63) == -1 && lowerCase2.indexOf(42) == -1) {
                            if (lowerCase2.compareTo(lowerCase) != 0) {
                                int iIndexOf = lowerCase2.indexOf(58);
                                int iIndexOf2 = lowerCase2.indexOf(58);
                                if (iIndexOf > 0 && iIndexOf < lowerCase2.length() - 2 && iIndexOf == iIndexOf2) {
                                    if (!lowerCase2.startsWith("[" + lowerCase + ']')) {
                                        continue;
                                    } else if (z) {
                                        return false;
                                    }
                                }
                            } else if (z) {
                                return false;
                            }
                            z2 = true;
                        } else if (pseudoRegex(lowerCase2.toCharArray(), 0, lowerCase.toCharArray(), 0)) {
                            if (z) {
                                return false;
                            }
                            z2 = true;
                        } else {
                            continue;
                        }
                    } else if (checkHashed(strSubstring, lowerCase)) {
                        if (z) {
                            return false;
                        }
                        z2 = true;
                    } else {
                        continue;
                    }
                }
            }
        }
        return z2;
    }

    private void initialize(char[] cArr) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new CharArrayReader(cArr));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            String strTrim = line.trim();
            if (!strTrim.startsWith("#")) {
                String[] strArrSplit = strTrim.split(" ");
                if (strArrSplit.length >= 3) {
                    String str = strArrSplit[1];
                    Iterator<KeyAlgorithm<PublicKey, PrivateKey>> it = KeyAlgorithmManager.getSupportedAlgorithms().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            LOGGER.log(1, "Unsupported key type: " + str);
                            break;
                        }
                        if (it.next().getKeyFormat().equals(str)) {
                            try {
                                addHostkey(strArrSplit[0].split(","), str, Base64.decode(strArrSplit[2].toCharArray()));
                                break;
                            } catch (IOWarningException e) {
                                LOGGER.log(30, za0.l("Ignored invalid line '", strTrim, "'"), e);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean matchKeys(PublicKey publicKey, PublicKey publicKey2) {
        return publicKey == null ? publicKey2 == null : publicKey.equals(publicKey2);
    }

    private boolean pseudoRegex(char[] cArr, int i, char[] cArr2, int i2) {
        while (cArr.length != i) {
            char c = cArr[i];
            if (c == '*') {
                int i3 = i + 1;
                if (cArr.length == i3) {
                    return true;
                }
                char c2 = cArr[i3];
                if (c2 == '*' || c2 == '?') {
                    while (!pseudoRegex(cArr, i3, cArr2, i2)) {
                        i2++;
                        if (cArr2.length == i2) {
                            return false;
                        }
                    }
                    return true;
                }
                do {
                    if (cArr[i3] == cArr2[i2] && pseudoRegex(cArr, i + 2, cArr2, i2 + 1)) {
                        return true;
                    }
                    i2++;
                } while (cArr2.length != i2);
                return false;
            }
            if (cArr2.length == i2) {
                return false;
            }
            if (c != '?' && c != cArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return cArr2.length == i2;
    }

    private static byte[] rawFingerPrint(String str, String str2, byte[] bArr) {
        Digest sha1;
        if ("md5".equals(str)) {
            sha1 = new MD5();
        } else {
            if (!"sha1".equals(str)) {
                throw new IllegalArgumentException(za0.s("Unknown hash type ", str));
            }
            sha1 = new SHA1();
        }
        Iterator<KeyAlgorithm<PublicKey, PrivateKey>> it = KeyAlgorithmManager.getSupportedAlgorithms().iterator();
        while (it.hasNext()) {
            if (it.next().getKeyFormat().equals(str2)) {
                if (bArr == null) {
                    throw new IllegalArgumentException("hostkey is null");
                }
                sha1.update(bArr);
                byte[] bArr2 = new byte[sha1.getDigestLength()];
                sha1.digest(bArr2);
                return bArr2;
            }
        }
        throw new IllegalArgumentException(za0.s("Unknown key type ", str2));
    }

    private static String rawToBubblebabbleFingerprint(byte[] bArr) {
        char[] charArray = "aeiouy".toCharArray();
        char[] charArray2 = "bcdfghklmnprstvzx".toCharArray();
        StringBuilder sb = new StringBuilder("x");
        int i = 1;
        int length = (bArr.length / 2) + 1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (i3 < length || bArr.length % 2 != 0) {
                int i4 = i2 * 2;
                sb.append(charArray[(((bArr[i4] >> 6) & 3) + i) % 6]);
                sb.append(charArray2[(bArr[i4] >> 2) & 15]);
                sb.append(charArray[((i / 6) + (bArr[i4] & 3)) % 6]);
                if (i3 < length) {
                    int i5 = i4 + 1;
                    sb.append(charArray2[(bArr[i5] >> 4) & 15]);
                    sb.append('-');
                    sb.append(charArray2[bArr[i5] & 15]);
                    i = ((((bArr[i4] & 255) * 7) + (bArr[i5] & 255)) + (i * 5)) % 36;
                }
            } else {
                sb.append(charArray[i % 6]);
                sb.append('x');
                sb.append(charArray[i / 6]);
            }
            i2 = i3;
        }
        sb.append('x');
        return sb.toString();
    }

    private static String rawToHexFingerprint(byte[] bArr) {
        char[] charArray = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                sb.append(':');
            }
            byte b = bArr[i];
            sb.append(charArray[(b & 255) >> 4]);
            sb.append(charArray[b & 15]);
        }
        return sb.toString();
    }

    private String[] recommendHostkeyAlgorithms(String str) {
        Iterator<KnownHostsEntry> it = getAllKnownHostEntries(str).iterator();
        String str2 = null;
        while (true) {
            if (it.hasNext()) {
                String str3 = it.next().algorithm;
                if (str2 == null) {
                    str2 = str3;
                } else if (!str2.equals(str3)) {
                    break;
                }
            } else if (str2 != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<KeyAlgorithm<PublicKey, PrivateKey>> it2 = KeyAlgorithmManager.getSupportedAlgorithms().iterator();
                while (it2.hasNext()) {
                    arrayList.add(arrayList.size(), it2.next().getKeyFormat());
                }
                if (arrayList.contains(str2)) {
                    arrayList.remove(str2);
                    arrayList.add(0, str2);
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        return null;
    }

    public void addHostkey(String[] strArr, String str, byte[] bArr) throws IOWarningException {
        if (strArr == null) {
            throw new IllegalArgumentException("hostnames may not be null");
        }
        for (KeyAlgorithm<PublicKey, PrivateKey> keyAlgorithm : KeyAlgorithmManager.getSupportedAlgorithms()) {
            if (str.equals(keyAlgorithm.getKeyFormat())) {
                PublicKey publicKeyDecodePublicKey = keyAlgorithm.decodePublicKey(bArr);
                synchronized (this.publicKeys) {
                    this.publicKeys.add(new KnownHostsEntry(this, strArr, publicKeyDecodePublicKey, str, 0));
                }
                return;
            }
        }
        throw new IOWarningException(za0.l("Unknwon host key type (", str, ")"));
    }

    public void addHostkeys(char[] cArr) throws IOException {
        initialize(cArr);
    }

    public String[] getPreferredServerHostkeyAlgorithmOrder(String str) {
        String[] strArrRecommendHostkeyAlgorithms = recommendHostkeyAlgorithms(str);
        if (strArrRecommendHostkeyAlgorithms != null) {
            return strArrRecommendHostkeyAlgorithms;
        }
        try {
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                String[] strArrRecommendHostkeyAlgorithms2 = recommendHostkeyAlgorithms(inetAddress.getHostAddress());
                if (strArrRecommendHostkeyAlgorithms2 != null) {
                    return strArrRecommendHostkeyAlgorithms2;
                }
            }
        } catch (UnknownHostException unused) {
        }
        return null;
    }

    public int verifyHostkey(String str, String str2, byte[] bArr) {
        PublicKey publicKeyDecodeHostKey = decodeHostKey(str2, bArr);
        int iCheckKey = checkKey(str, publicKeyDecodeHostKey);
        if (iCheckKey == 0) {
            return iCheckKey;
        }
        try {
            for (InetAddress inetAddress : InetAddress.getAllByName(str)) {
                int iCheckKey2 = checkKey(inetAddress.getHostAddress(), publicKeyDecodeHostKey);
                if (iCheckKey2 == 0) {
                    return iCheckKey2;
                }
                if (iCheckKey2 == 2) {
                    iCheckKey = 2;
                }
            }
        } catch (UnknownHostException unused) {
        }
        return iCheckKey;
    }

    public void addHostkeys(File file) throws IOException {
        initialize(file);
    }

    public KnownHosts(char[] cArr) throws IOException {
        initialize(cArr);
    }

    public KnownHosts(File file) throws IOException {
        initialize(file);
    }

    private void initialize(File file) throws IOException {
        char[] cArr = new char[512];
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (!file.createNewFile()) {
            LOGGER.log(10, "Could not create known hosts file");
        }
        FileReader fileReader = new FileReader(file);
        while (true) {
            try {
                int i = fileReader.read(cArr);
                if (i < 0) {
                    fileReader.close();
                    initialize(charArrayWriter.toCharArray());
                    return;
                }
                charArrayWriter.write(cArr, 0, i);
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }
}
