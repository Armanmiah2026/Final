package net.i2p.crypto.eddsa;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class EdDSASecurityProvider extends Provider {
    public static final String PROVIDER_NAME = "EdDSA";
    private static final long serialVersionUID = 1210027906682292307L;

    public EdDSASecurityProvider() {
        super("EdDSA", 0.3d, "str4d EdDSA security provider wrapper");
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: net.i2p.crypto.eddsa.EdDSASecurityProvider.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                EdDSASecurityProvider.this.setup();
                return null;
            }
        });
    }

    public void setup() {
        put("KeyFactory.EdDSA", "net.i2p.crypto.eddsa.KeyFactory");
        put("KeyPairGenerator.EdDSA", "net.i2p.crypto.eddsa.KeyPairGenerator");
        put("Signature.NONEwithEdDSA", "net.i2p.crypto.eddsa.EdDSAEngine");
        put("Alg.Alias.KeyFactory.1.3.101.112", "EdDSA");
        put("Alg.Alias.KeyFactory.OID.1.3.101.112", "EdDSA");
        put("Alg.Alias.KeyPairGenerator.1.3.101.112", "EdDSA");
        put("Alg.Alias.KeyPairGenerator.OID.1.3.101.112", "EdDSA");
        put("Alg.Alias.Signature.1.3.101.112", EdDSAEngine.SIGNATURE_ALGORITHM);
        put("Alg.Alias.Signature.OID.1.3.101.112", EdDSAEngine.SIGNATURE_ALGORITHM);
    }
}
