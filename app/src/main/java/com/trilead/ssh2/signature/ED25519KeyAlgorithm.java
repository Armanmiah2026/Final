package com.trilead.ssh2.signature;

import com.trilead.ssh2.crypto.CertificateDecoder;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.i2p.crypto.eddsa.EdDSAPrivateKey;
import net.i2p.crypto.eddsa.EdDSAPublicKey;
import net.i2p.crypto.eddsa.EdDSASecurityProvider;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveSpec;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec;
import net.i2p.crypto.eddsa.spec.EdDSAPublicKeySpec;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ED25519KeyAlgorithm extends KeyAlgorithm<EdDSAPublicKey, EdDSAPrivateKey> {
    private static final String ED25519_CURVE_NAME = "Ed25519";
    private static final String ED25519_KEY_NAME = "ssh-ed25519";

    public ED25519KeyAlgorithm() {
        super("NoneWithEdDSA", ED25519_KEY_NAME, EdDSAPrivateKey.class, new EdDSASecurityProvider());
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] decodeSignature(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        if (!typesReader.readString().equals(ED25519_KEY_NAME)) {
            throw new IOException("Invalid signature format");
        }
        byte[] byteString = typesReader.readByteString();
        if (typesReader.remain() == 0) {
            return byteString;
        }
        throw new IOException("Unexpected padding in signature");
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] encodeSignature(byte[] bArr) {
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(ED25519_KEY_NAME);
        typesWriter.writeString(bArr, 0, bArr.length);
        return typesWriter.getBytes();
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public List<CertificateDecoder> getCertificateDecoders() {
        return Collections.singletonList(new OpenSshCertificateDecoder(ED25519_KEY_NAME) { // from class: com.trilead.ssh2.signature.ED25519KeyAlgorithm.1
            @Override // com.trilead.ssh2.signature.OpenSshCertificateDecoder
            public KeyPair generateKeyPair(TypesReader typesReader) throws NoSuchAlgorithmException, IOException {
                EdDSANamedCurveSpec byName = EdDSANamedCurveTable.getByName("Ed25519");
                byte[] byteString = typesReader.readByteString();
                byte[] byteString2 = typesReader.readByteString();
                EdDSAPublicKeySpec edDSAPublicKeySpec = new EdDSAPublicKeySpec(byteString, byName);
                EdDSAPrivateKeySpec edDSAPrivateKeySpec = new EdDSAPrivateKeySpec(Arrays.copyOfRange(byteString2, 0, 32), byName);
                KeyFactory keyFactory = KeyFactory.getInstance("EdDSA", new EdDSASecurityProvider());
                return new KeyPair(keyFactory.generatePublic(edDSAPublicKeySpec), keyFactory.generatePrivate(edDSAPrivateKeySpec));
            }
        });
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public EdDSAPublicKey decodePublicKey(byte[] bArr) throws IOException {
        TypesReader typesReader = new TypesReader(bArr);
        if (!typesReader.readString().equals(ED25519_KEY_NAME)) {
            throw new IOException("Invalid key type");
        }
        byte[] byteString = typesReader.readByteString();
        if (typesReader.remain() == 0) {
            return new EdDSAPublicKey(new EdDSAPublicKeySpec(byteString, EdDSANamedCurveTable.getByName("Ed25519")));
        }
        throw new IOException("Unexpected padding in public key");
    }

    @Override // com.trilead.ssh2.signature.KeyAlgorithm
    public byte[] encodePublicKey(EdDSAPublicKey edDSAPublicKey) {
        byte[] abyte = edDSAPublicKey.getAbyte();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(ED25519_KEY_NAME);
        typesWriter.writeString(abyte, 0, abyte.length);
        return typesWriter.getBytes();
    }
}
