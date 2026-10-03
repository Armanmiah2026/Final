package net.i2p.crypto.eddsa.spec;

import net.i2p.crypto.eddsa.math.Curve;
import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.math.ScalarOps;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class EdDSANamedCurveSpec extends EdDSAParameterSpec {
    private final String name;

    public EdDSANamedCurveSpec(String str, Curve curve, String str2, ScalarOps scalarOps, GroupElement groupElement) {
        super(curve, str2, scalarOps, groupElement);
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
