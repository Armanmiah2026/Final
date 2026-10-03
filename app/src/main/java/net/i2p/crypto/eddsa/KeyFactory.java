package net.i2p.crypto.eddsa;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec;
import net.i2p.crypto.eddsa.spec.EdDSAPublicKeySpec;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class KeyFactory extends KeyFactorySpi {
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof EdDSAPrivateKeySpec) {
            return new EdDSAPrivateKey((EdDSAPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            return new EdDSAPrivateKey((PKCS8EncodedKeySpec) keySpec);
        }
        throw new InvalidKeySpecException("key spec not recognised: " + keySpec.getClass());
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof EdDSAPublicKeySpec) {
            return new EdDSAPublicKey((EdDSAPublicKeySpec) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            return new EdDSAPublicKey((X509EncodedKeySpec) keySpec);
        }
        throw new InvalidKeySpecException("key spec not recognised: " + keySpec.getClass());
    }

    @Override // java.security.KeyFactorySpi
    public <T extends KeySpec> T engineGetKeySpec(Key key, Class<T> cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(EdDSAPublicKeySpec.class) && (key instanceof EdDSAPublicKey)) {
            EdDSAPublicKey edDSAPublicKey = (EdDSAPublicKey) key;
            if (edDSAPublicKey.getParams() != null) {
                return new EdDSAPublicKeySpec(edDSAPublicKey.getA(), edDSAPublicKey.getParams());
            }
        } else if (cls.isAssignableFrom(EdDSAPrivateKeySpec.class) && (key instanceof EdDSAPrivateKey)) {
            EdDSAPrivateKey edDSAPrivateKey = (EdDSAPrivateKey) key;
            if (edDSAPrivateKey.getParams() != null) {
                return new EdDSAPrivateKeySpec(edDSAPrivateKey.getSeed(), edDSAPrivateKey.getH(), edDSAPrivateKey.geta(), edDSAPrivateKey.getA(), edDSAPrivateKey.getParams());
            }
        }
        throw new InvalidKeySpecException("not implemented yet " + key + " " + cls);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("No other EdDSA key providers known");
    }
}
