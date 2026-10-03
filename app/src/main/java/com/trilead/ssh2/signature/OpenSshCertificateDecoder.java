package com.trilead.ssh2.signature;

import com.trilead.ssh2.crypto.CertificateDecoder;
import com.trilead.ssh2.crypto.PEMStructure;
import com.trilead.ssh2.crypto.cipher.BlockCipher;
import com.trilead.ssh2.crypto.cipher.BlockCipherFactory;
import com.trilead.ssh2.crypto.cipher.CBCMode;
import com.trilead.ssh2.crypto.cipher.DES;
import com.trilead.ssh2.packets.TypesReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
abstract class OpenSshCertificateDecoder extends CertificateDecoder {
    private final String keyAlgorithm;

    /**
     * OpenSSH cipher descriptor. JADX emitted this as an enum extending an
     * ordinary class, which is illegal Java. The original behaviour is a fixed
     * set of immutable cipher descriptors, so normal singleton instances are
     * used here.
     */
    public static abstract class SshCipher {
        private final int blockSize;
        private final int keyLength;
        private final String[] sshCipherNames;

        public static final SshCipher DESEDE_CBC = new SshCipher(24, 8, "des-ede3-cbc") {
            @Override public BlockCipher createBlockCipher(byte[] key, byte[] iv, boolean encrypt) {
                return BlockCipherFactory.createCipher("3des-cbc", encrypt, key, iv);
            }
        };
        public static final SshCipher DES_CBC = new SshCipher(8, 8, "des-cbc") {
            @Override public BlockCipher createBlockCipher(byte[] key, byte[] iv, boolean encrypt) {
                DES des = new DES();
                des.init(encrypt, key);
                return new CBCMode(des, iv, encrypt);
            }
        };
        public static final SshCipher AES128_CBC = new SshCipher(16, 16, "aes-128-cbc", "aes128-cbc") {
            @Override public BlockCipher createBlockCipher(byte[] key, byte[] iv, boolean encrypt) {
                return BlockCipherFactory.createCipher("aes128-cbc", encrypt, key, iv);
            }
        };
        public static final SshCipher AES192_CBC = new SshCipher(24, 16, "aes-192-cbc", "aes192-cbc") {
            @Override public BlockCipher createBlockCipher(byte[] key, byte[] iv, boolean encrypt) {
                return BlockCipherFactory.createCipher("aes192-cbc", encrypt, key, iv);
            }
        };
        public static final SshCipher AES256_CBC = new SshCipher(32, 16, "aes-256-cbc", "aes256-cbc") {
            @Override public BlockCipher createBlockCipher(byte[] key, byte[] iv, boolean encrypt) {
                return BlockCipherFactory.createCipher("aes256-cbc", encrypt, key, iv);
            }
        };
        public static final SshCipher AES256_CTR = new SshCipher(32, 16, "aes-256-ctr", "aes256-ctr") {
            @Override public BlockCipher createBlockCipher(byte[] key, byte[] iv, boolean encrypt) {
                return BlockCipherFactory.createCipher("aes256-ctr", encrypt, key, iv);
            }
        };

        private static final SshCipher[] VALUES = {
                DESEDE_CBC, DES_CBC, AES128_CBC, AES192_CBC, AES256_CBC, AES256_CTR
        };

        private SshCipher(int keyLength, int blockSize, String primaryName, String... aliases) {
            this.keyLength = keyLength;
            this.blockSize = blockSize;
            this.sshCipherNames = new String[aliases.length + 1];
            this.sshCipherNames[0] = primaryName;
            System.arraycopy(aliases, 0, this.sshCipherNames, 1, aliases.length);
        }

        public static SshCipher getInstance(String name) {
            for (SshCipher cipher : VALUES) {
                for (String cipherName : cipher.sshCipherNames) {
                    if (cipherName.equalsIgnoreCase(name)) return cipher;
                }
            }
            throw new IllegalArgumentException(za0.s("Unknown Cipher: ", name));
        }

        public abstract BlockCipher createBlockCipher(byte[] key, byte[] iv, boolean encrypt);
        public int getBlockSize() { return blockSize; }
        public int getKeyLength() { return keyLength; }
    }

    public OpenSshCertificateDecoder(String str) {
        this.keyAlgorithm = str;
    }

    private static byte[] decryptData(byte[] bArr, byte[] bArr2, SshCipher sshCipher) {
        int keyLength = sshCipher.getKeyLength();
        byte[] bArr3 = new byte[keyLength];
        int blockSize = sshCipher.getBlockSize();
        byte[] bArr4 = new byte[blockSize];
        System.arraycopy(bArr2, 0, bArr3, 0, keyLength);
        System.arraycopy(bArr2, keyLength, bArr4, 0, blockSize);
        BlockCipher blockCipherCreateBlockCipher = sshCipher.createBlockCipher(bArr3, bArr4, false);
        byte[] bArr5 = new byte[bArr.length];
        for (int i = 0; i < bArr.length / blockCipherCreateBlockCipher.getBlockSize(); i++) {
            blockCipherCreateBlockCipher.transformBlock(bArr, blockCipherCreateBlockCipher.getBlockSize() * i, bArr5, blockCipherCreateBlockCipher.getBlockSize() * i);
        }
        return bArr5;
    }

    private static byte[] generateKayAndIvPbkdf2(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        throw new UnsupportedOperationException("Encrypted OpenSSH private keys are not supported");
    }

    @Override // com.trilead.ssh2.crypto.CertificateDecoder
    public KeyPair createKeyPair(PEMStructure pEMStructure) {
        return null;
    }

    public abstract KeyPair generateKeyPair(TypesReader typesReader);

    @Override // com.trilead.ssh2.crypto.CertificateDecoder
    public String getEndLine() {
        return "-----END OPENSSH PRIVATE KEY-----";
    }

    @Override // com.trilead.ssh2.crypto.CertificateDecoder
    public String getStartLine() {
        return "-----BEGIN OPENSSH PRIVATE KEY-----";
    }

    @Override // com.trilead.ssh2.crypto.CertificateDecoder
    public KeyPair createKeyPair(PEMStructure pEMStructure, String str) throws IOException {
        TypesReader typesReader = new TypesReader(pEMStructure.getData());
        byte[] bytes = typesReader.readBytes(15);
        Charset charset = StandardCharsets.UTF_8;
        if (!"openssh-key-v1".equals(new String(bytes, charset).trim())) {
            throw new IOException("Could not find openssh header in key");
        }
        String string = typesReader.readString();
        String string2 = typesReader.readString();
        byte[] byteString = typesReader.readByteString();
        if (typesReader.readUINT32() != 1) {
            throw new IOException("Only single OpenSSH keys are supported");
        }
        typesReader.readByteString();
        byte[] byteString2 = typesReader.readByteString();
        if ("bcrypt".equals(string2)) {
            if (str == null) {
                throw new IOException("PEM is encrypted but password has not been specified");
            }
            TypesReader typesReader2 = new TypesReader(byteString);
            byte[] byteString3 = typesReader2.readByteString();
            int uint32 = typesReader2.readUINT32();
            SshCipher sshCipher = SshCipher.getInstance(string);
            byteString2 = decryptData(byteString2, generateKayAndIvPbkdf2(str.getBytes(charset), byteString3, uint32, sshCipher.getKeyLength(), sshCipher.getBlockSize()), sshCipher);
        } else if (!"none".equals(string) || !"none".equals(string2)) {
            throw new IOException("Unexpected encryption method for key");
        }
        TypesReader typesReader3 = new TypesReader(byteString2);
        if (typesReader3.readUINT32() != typesReader3.readUINT32()) {
            throw new IOException("Check integers didn't match");
        }
        String string3 = typesReader3.readString();
        if (!string3.equals(this.keyAlgorithm)) {
            throw new IOException("Invalid key type: ".concat(string3));
        }
        try {
            KeyPair keyPairGenerateKeyPair = generateKeyPair(typesReader3);
            typesReader3.readByteString();
            int i = 0;
            while (i < typesReader.remain()) {
                i++;
                if (i != typesReader.readByte()) {
                    throw new IOException("Incorrect padding on private keys");
                }
            }
            return keyPairGenerateKeyPair;
        } catch (GeneralSecurityException e) {
            throw new IOException("Could not create key pair", e);
        }
    }
}
