package com.trilead.ssh2.crypto.cipher;

import java.util.Vector;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class BlockCipherFactory {
    private static final CipherSupplier AES_SUPPLIER;
    private static final CipherSupplier BLOWFISH_SUPPLIER;
    private static final CipherSupplier DESEDE_SUPPLIER;
    static Vector ciphers = new Vector();

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class CipherEntry {
        int blocksize;
        CipherSupplier factory;
        int keysize;
        String type;

        public CipherEntry(String str, int i, int i2, CipherSupplier cipherSupplier) {
            this.type = str;
            this.blocksize = i;
            this.keysize = i2;
            this.factory = cipherSupplier;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public interface CipherSupplier {
        BlockCipher create();
    }

    static {
        CipherSupplier cipherSupplier = new CipherSupplier() { // from class: com.trilead.ssh2.crypto.cipher.BlockCipherFactory.1
            @Override // com.trilead.ssh2.crypto.cipher.BlockCipherFactory.CipherSupplier
            public BlockCipher create() {
                return new AES();
            }
        };
        AES_SUPPLIER = cipherSupplier;
        CipherSupplier cipherSupplier2 = new CipherSupplier() { // from class: com.trilead.ssh2.crypto.cipher.BlockCipherFactory.2
            @Override // com.trilead.ssh2.crypto.cipher.BlockCipherFactory.CipherSupplier
            public BlockCipher create() {
                return new BlowFish();
            }
        };
        BLOWFISH_SUPPLIER = cipherSupplier2;
        CipherSupplier cipherSupplier3 = new CipherSupplier() { // from class: com.trilead.ssh2.crypto.cipher.BlockCipherFactory.3
            @Override // com.trilead.ssh2.crypto.cipher.BlockCipherFactory.CipherSupplier
            public BlockCipher create() {
                return new DESede();
            }
        };
        DESEDE_SUPPLIER = cipherSupplier3;
        ciphers.addElement(new CipherEntry("aes256-ctr", 16, 32, cipherSupplier));
        ciphers.addElement(new CipherEntry("aes192-ctr", 16, 24, cipherSupplier));
        ciphers.addElement(new CipherEntry("aes128-ctr", 16, 16, cipherSupplier));
        ciphers.addElement(new CipherEntry("blowfish-ctr", 8, 16, cipherSupplier2));
        ciphers.addElement(new CipherEntry("aes256-cbc", 16, 32, cipherSupplier));
        ciphers.addElement(new CipherEntry("aes192-cbc", 16, 24, cipherSupplier));
        ciphers.addElement(new CipherEntry("aes128-cbc", 16, 16, cipherSupplier));
        ciphers.addElement(new CipherEntry("blowfish-cbc", 8, 16, cipherSupplier2));
        ciphers.addElement(new CipherEntry("3des-ctr", 8, 24, cipherSupplier3));
        ciphers.addElement(new CipherEntry("3des-cbc", 8, 24, cipherSupplier3));
    }

    public static void checkCipherList(String[] strArr) {
        for (String str : strArr) {
            getEntry(str);
        }
    }

    public static BlockCipher createCipher(String str, boolean z, byte[] bArr, byte[] bArr2) {
        try {
            BlockCipher blockCipherCreate = getEntry(str).factory.create();
            if (str.endsWith("-cbc")) {
                blockCipherCreate.init(z, bArr);
                return new CBCMode(blockCipherCreate, bArr2, z);
            }
            if (!str.endsWith("-ctr")) {
                throw new IllegalArgumentException("Cannot instantiate ".concat(str));
            }
            blockCipherCreate.init(true, bArr);
            return new CTRMode(blockCipherCreate, bArr2, z);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalArgumentException("Cannot instantiate " + str + ": " + e2, e2);
        }
    }

    public static int getBlockSize(String str) {
        return getEntry(str).blocksize;
    }

    public static String[] getDefaultCipherList() {
        String[] strArr = new String[ciphers.size()];
        for (int i = 0; i < ciphers.size(); i++) {
            strArr[i] = ((CipherEntry) ciphers.elementAt(i)).type;
        }
        return strArr;
    }

    private static CipherEntry getEntry(String str) {
        for (int i = 0; i < ciphers.size(); i++) {
            CipherEntry cipherEntry = (CipherEntry) ciphers.elementAt(i);
            if (cipherEntry.type.equals(str)) {
                return cipherEntry;
            }
        }
        throw new IllegalArgumentException(za0.s("Unkown algorithm ", str));
    }

    public static int getKeySize(String str) {
        return getEntry(str).keysize;
    }
}
