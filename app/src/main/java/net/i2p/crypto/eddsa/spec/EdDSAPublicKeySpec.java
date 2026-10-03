package net.i2p.crypto.eddsa.spec;

import java.security.spec.KeySpec;
import net.i2p.crypto.eddsa.math.GroupElement;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class EdDSAPublicKeySpec implements KeySpec {
    private final GroupElement A;
    private GroupElement Aneg = null;
    private final EdDSAParameterSpec spec;

    public EdDSAPublicKeySpec(byte[] bArr, EdDSAParameterSpec edDSAParameterSpec) {
        if (bArr.length != edDSAParameterSpec.getCurve().getField().getb() / 8) {
            throw new IllegalArgumentException("public-key length is wrong");
        }
        this.A = new GroupElement(edDSAParameterSpec.getCurve(), bArr);
        this.spec = edDSAParameterSpec;
    }

    public GroupElement getA() {
        return this.A;
    }

    public GroupElement getNegativeA() {
        GroupElement groupElement = this.Aneg;
        if (groupElement != null) {
            return groupElement;
        }
        GroupElement groupElementNegate = this.A.negate();
        this.Aneg = groupElementNegate;
        return groupElementNegate;
    }

    public EdDSAParameterSpec getParams() {
        return this.spec;
    }

    public EdDSAPublicKeySpec(GroupElement groupElement, EdDSAParameterSpec edDSAParameterSpec) {
        this.A = groupElement;
        this.spec = edDSAParameterSpec;
    }
}
