package net.i2p.crypto.eddsa.math;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import net.i2p.crypto.eddsa.Utils;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class GroupElement implements Serializable {
    private static final long serialVersionUID = 2395879087349587L;
    final FieldElement T;
    final FieldElement X;
    final FieldElement Y;
    final FieldElement Z;
    final Curve curve;
    final GroupElement[] dblPrecmp;
    final GroupElement[][] precmp;
    final Representation repr;

    /* JADX INFO: renamed from: net.i2p.crypto.eddsa.math.GroupElement$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation;

        static {
            int[] iArr = new int[Representation.values().length];
            $SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation = iArr;
            try {
                iArr[Representation.P2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[Representation.P3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[Representation.CACHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[Representation.P3PrecomputedDouble.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[Representation.P1P1.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[Representation.PRECOMP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public enum Representation {
        P2,
        P3,
        P3PrecomputedDouble,
        P1P1,
        PRECOMP,
        CACHED
    }

    public GroupElement(Curve curve, Representation representation, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4) {
        this(curve, representation, fieldElement, fieldElement2, fieldElement3, fieldElement4, false);
    }

    public static GroupElement cached(Curve curve, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4) {
        return new GroupElement(curve, Representation.CACHED, fieldElement, fieldElement2, fieldElement3, fieldElement4);
    }

    private GroupElement madd(GroupElement groupElement) {
        if (this.repr != Representation.P3) {
            throw new UnsupportedOperationException();
        }
        if (groupElement.repr != Representation.PRECOMP) {
            throw new IllegalArgumentException();
        }
        FieldElement fieldElementAdd = this.Y.add(this.X);
        FieldElement fieldElementSubtract = this.Y.subtract(this.X);
        FieldElement fieldElementMultiply = fieldElementAdd.multiply(groupElement.X);
        FieldElement fieldElementMultiply2 = fieldElementSubtract.multiply(groupElement.Y);
        FieldElement fieldElementMultiply3 = groupElement.Z.multiply(this.T);
        FieldElement fieldElement = this.Z;
        FieldElement fieldElementAdd2 = fieldElement.add(fieldElement);
        return p1p1(this.curve, fieldElementMultiply.subtract(fieldElementMultiply2), fieldElementMultiply.add(fieldElementMultiply2), fieldElementAdd2.add(fieldElementMultiply3), fieldElementAdd2.subtract(fieldElementMultiply3));
    }

    private GroupElement msub(GroupElement groupElement) {
        if (this.repr != Representation.P3) {
            throw new UnsupportedOperationException();
        }
        if (groupElement.repr != Representation.PRECOMP) {
            throw new IllegalArgumentException();
        }
        FieldElement fieldElementAdd = this.Y.add(this.X);
        FieldElement fieldElementSubtract = this.Y.subtract(this.X);
        FieldElement fieldElementMultiply = fieldElementAdd.multiply(groupElement.Y);
        FieldElement fieldElementMultiply2 = fieldElementSubtract.multiply(groupElement.X);
        FieldElement fieldElementMultiply3 = groupElement.Z.multiply(this.T);
        FieldElement fieldElement = this.Z;
        FieldElement fieldElementAdd2 = fieldElement.add(fieldElement);
        return p1p1(this.curve, fieldElementMultiply.subtract(fieldElementMultiply2), fieldElementMultiply.add(fieldElementMultiply2), fieldElementAdd2.subtract(fieldElementMultiply3), fieldElementAdd2.add(fieldElementMultiply3));
    }

    public static GroupElement p1p1(Curve curve, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4) {
        return new GroupElement(curve, Representation.P1P1, fieldElement, fieldElement2, fieldElement3, fieldElement4);
    }

    public static GroupElement p2(Curve curve, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3) {
        return new GroupElement(curve, Representation.P2, fieldElement, fieldElement2, fieldElement3, null);
    }

    public static GroupElement p3(Curve curve, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4) {
        return p3(curve, fieldElement, fieldElement2, fieldElement3, fieldElement4, false);
    }

    public static GroupElement precomp(Curve curve, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3) {
        return new GroupElement(curve, Representation.PRECOMP, fieldElement, fieldElement2, fieldElement3, null);
    }

    private GroupElement[] precomputeDouble() {
        GroupElement[] groupElementArr = new GroupElement[8];
        GroupElement p3 = this;
        for (int i = 0; i < 8; i++) {
            FieldElement fieldElementInvert = p3.Z.invert();
            FieldElement fieldElementMultiply = p3.X.multiply(fieldElementInvert);
            FieldElement fieldElementMultiply2 = p3.Y.multiply(fieldElementInvert);
            groupElementArr[i] = precomp(this.curve, fieldElementMultiply2.add(fieldElementMultiply), fieldElementMultiply2.subtract(fieldElementMultiply), fieldElementMultiply.multiply(fieldElementMultiply2).multiply(this.curve.get2D()));
            p3 = add(add(p3.toCached()).toP3().toCached()).toP3();
        }
        return groupElementArr;
    }

    private GroupElement[][] precomputeSingle() {
        GroupElement[][] groupElementArr = (GroupElement[][]) Array.newInstance((Class<?>) GroupElement.class, 32, 8);
        GroupElement p3 = this;
        for (int i = 0; i < 32; i++) {
            GroupElement p32 = p3;
            for (int i2 = 0; i2 < 8; i2++) {
                FieldElement fieldElementInvert = p32.Z.invert();
                FieldElement fieldElementMultiply = p32.X.multiply(fieldElementInvert);
                FieldElement fieldElementMultiply2 = p32.Y.multiply(fieldElementInvert);
                groupElementArr[i][i2] = precomp(this.curve, fieldElementMultiply2.add(fieldElementMultiply), fieldElementMultiply2.subtract(fieldElementMultiply), fieldElementMultiply.multiply(fieldElementMultiply2).multiply(this.curve.get2D()));
                p32 = p32.add(p3.toCached()).toP3();
            }
            for (int i3 = 0; i3 < 8; i3++) {
                p3 = p3.add(p3.toCached()).toP3();
            }
        }
        return groupElementArr;
    }

    public static byte[] slide(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) (1 & (bArr[i2 >> 3] >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr2[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr2[i];
                    if (b != 0) {
                        byte b2 = bArr2[i3];
                        if ((b << i4) + b2 <= 15) {
                            bArr2[i3] = (byte) (b2 + (b << i4));
                            bArr2[i] = 0;
                        } else if (b2 - (b << i4) >= -15) {
                            bArr2[i3] = (byte) (b2 - (b << i4));
                            while (true) {
                                if (i >= 256) {
                                    break;
                                }
                                if (bArr2[i] == 0) {
                                    bArr2[i] = 1;
                                    break;
                                }
                                bArr2[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    public static byte[] toRadix16(byte[] bArr) {
        byte[] bArr2 = new byte[64];
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            int i3 = i2 * 2;
            bArr2[i3] = (byte) (bArr[i2] & 15);
            bArr2[i3 + 1] = (byte) ((bArr[i2] >> 4) & 15);
        }
        int i4 = 0;
        while (i < 63) {
            byte b = (byte) (bArr2[i] + i4);
            bArr2[i] = b;
            int i5 = (b + 8) >> 4;
            bArr2[i] = (byte) (b - (i5 << 4));
            i++;
            i4 = i5;
        }
        bArr2[63] = (byte) (bArr2[63] + i4);
        return bArr2;
    }

    private GroupElement toRep(Representation representation) {
        int[] iArr = AnonymousClass1.$SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation;
        int i = iArr[this.repr.ordinal()];
        if (i == 1) {
            if (iArr[representation.ordinal()] == 1) {
                return p2(this.curve, this.X, this.Y, this.Z);
            }
            throw new IllegalArgumentException();
        }
        if (i == 2) {
            int i2 = iArr[representation.ordinal()];
            if (i2 == 1) {
                return p2(this.curve, this.X, this.Y, this.Z);
            }
            if (i2 == 2) {
                return p3(this.curve, this.X, this.Y, this.Z, this.T);
            }
            if (i2 == 3) {
                return cached(this.curve, this.Y.add(this.X), this.Y.subtract(this.X), this.Z, this.T.multiply(this.curve.get2D()));
            }
            throw new IllegalArgumentException();
        }
        if (i == 3) {
            if (iArr[representation.ordinal()] == 3) {
                return cached(this.curve, this.X, this.Y, this.Z, this.T);
            }
            throw new IllegalArgumentException();
        }
        if (i != 5) {
            if (i != 6) {
                throw new UnsupportedOperationException();
            }
            if (iArr[representation.ordinal()] == 6) {
                return precomp(this.curve, this.X, this.Y, this.Z);
            }
            throw new IllegalArgumentException();
        }
        int i3 = iArr[representation.ordinal()];
        if (i3 == 1) {
            return p2(this.curve, this.X.multiply(this.T), this.Y.multiply(this.Z), this.Z.multiply(this.T));
        }
        if (i3 == 2) {
            return p3(this.curve, this.X.multiply(this.T), this.Y.multiply(this.Z), this.Z.multiply(this.T), this.X.multiply(this.Y), false);
        }
        if (i3 == 4) {
            return p3(this.curve, this.X.multiply(this.T), this.Y.multiply(this.Z), this.Z.multiply(this.T), this.X.multiply(this.Y), true);
        }
        if (i3 == 5) {
            return p1p1(this.curve, this.X, this.Y, this.Z, this.T);
        }
        throw new IllegalArgumentException();
    }

    public GroupElement add(GroupElement groupElement) {
        if (this.repr != Representation.P3) {
            throw new UnsupportedOperationException();
        }
        if (groupElement.repr != Representation.CACHED) {
            throw new IllegalArgumentException();
        }
        FieldElement fieldElementAdd = this.Y.add(this.X);
        FieldElement fieldElementSubtract = this.Y.subtract(this.X);
        FieldElement fieldElementMultiply = fieldElementAdd.multiply(groupElement.X);
        FieldElement fieldElementMultiply2 = fieldElementSubtract.multiply(groupElement.Y);
        FieldElement fieldElementMultiply3 = groupElement.T.multiply(this.T);
        FieldElement fieldElementMultiply4 = this.Z.multiply(groupElement.Z);
        FieldElement fieldElementAdd2 = fieldElementMultiply4.add(fieldElementMultiply4);
        return p1p1(this.curve, fieldElementMultiply.subtract(fieldElementMultiply2), fieldElementMultiply.add(fieldElementMultiply2), fieldElementAdd2.add(fieldElementMultiply3), fieldElementAdd2.subtract(fieldElementMultiply3));
    }

    public GroupElement cmov(GroupElement groupElement, int i) {
        return precomp(this.curve, this.X.cmov(groupElement.X, i), this.Y.cmov(groupElement.Y, i), this.Z.cmov(groupElement.Z, i));
    }

    public GroupElement dbl() {
        int i = AnonymousClass1.$SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[this.repr.ordinal()];
        if (i != 1 && i != 2) {
            throw new UnsupportedOperationException();
        }
        FieldElement fieldElementSquare = this.X.square();
        FieldElement fieldElementSquare2 = this.Y.square();
        FieldElement fieldElementSquareAndDouble = this.Z.squareAndDouble();
        FieldElement fieldElementSquare3 = this.X.add(this.Y).square();
        FieldElement fieldElementAdd = fieldElementSquare2.add(fieldElementSquare);
        FieldElement fieldElementSubtract = fieldElementSquare2.subtract(fieldElementSquare);
        return p1p1(this.curve, fieldElementSquare3.subtract(fieldElementAdd), fieldElementAdd, fieldElementSubtract, fieldElementSquareAndDouble.subtract(fieldElementSubtract));
    }

    public GroupElement doubleScalarMultiplyVariableTime(GroupElement groupElement, byte[] bArr, byte[] bArr2) {
        byte[] bArrSlide = slide(bArr);
        byte[] bArrSlide2 = slide(bArr2);
        GroupElement zero = this.curve.getZero(Representation.P2);
        int i = 255;
        while (i >= 0 && bArrSlide[i] == 0 && bArrSlide2[i] == 0) {
            i--;
        }
        while (i >= 0) {
            GroupElement groupElementDbl = zero.dbl();
            byte b = bArrSlide[i];
            if (b > 0) {
                groupElementDbl = groupElementDbl.toP3().madd(groupElement.dblPrecmp[bArrSlide[i] / 2]);
            } else if (b < 0) {
                groupElementDbl = groupElementDbl.toP3().msub(groupElement.dblPrecmp[(-bArrSlide[i]) / 2]);
            }
            byte b2 = bArrSlide2[i];
            if (b2 > 0) {
                groupElementDbl = groupElementDbl.toP3().madd(this.dblPrecmp[bArrSlide2[i] / 2]);
            } else if (b2 < 0) {
                groupElementDbl = groupElementDbl.toP3().msub(this.dblPrecmp[(-bArrSlide2[i]) / 2]);
            }
            zero = groupElementDbl.toP2();
            i--;
        }
        return zero;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GroupElement)) {
            return false;
        }
        GroupElement rep = (GroupElement) obj;
        if (!this.repr.equals(rep.repr)) {
            try {
                rep = rep.toRep(this.repr);
            } catch (RuntimeException unused) {
                return false;
            }
        }
        int i = AnonymousClass1.$SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[this.repr.ordinal()];
        if (i == 1 || i == 2) {
            if (this.Z.equals(rep.Z)) {
                return this.X.equals(rep.X) && this.Y.equals(rep.Y);
            }
            return this.X.multiply(rep.Z).equals(rep.X.multiply(this.Z)) && this.Y.multiply(rep.Z).equals(rep.Y.multiply(this.Z));
        }
        if (i != 3) {
            return i != 5 ? i == 6 && this.X.equals(rep.X) && this.Y.equals(rep.Y) && this.Z.equals(rep.Z) : toP2().equals(rep);
        }
        if (this.Z.equals(rep.Z)) {
            return this.X.equals(rep.X) && this.Y.equals(rep.Y) && this.T.equals(rep.T);
        }
        return this.X.multiply(rep.Z).equals(rep.X.multiply(this.Z)) && this.Y.multiply(rep.Z).equals(rep.Y.multiply(this.Z)) && this.T.multiply(rep.Z).equals(rep.T.multiply(this.Z));
    }

    public Curve getCurve() {
        return this.curve;
    }

    public Representation getRepresentation() {
        return this.repr;
    }

    public FieldElement getT() {
        return this.T;
    }

    public FieldElement getX() {
        return this.X;
    }

    public FieldElement getY() {
        return this.Y;
    }

    public FieldElement getZ() {
        return this.Z;
    }

    public int hashCode() {
        return Arrays.hashCode(toByteArray());
    }

    public boolean isOnCurve() {
        return isOnCurve(this.curve);
    }

    public GroupElement negate() {
        Representation representation = this.repr;
        Representation representation2 = Representation.P3;
        if (representation == representation2) {
            return this.curve.getZero(representation2).sub(toCached()).toP3PrecomputeDouble();
        }
        throw new UnsupportedOperationException();
    }

    public GroupElement scalarMultiply(byte[] bArr) {
        byte[] radix16 = toRadix16(bArr);
        GroupElement zero = this.curve.getZero(Representation.P3);
        for (int i = 1; i < 64; i += 2) {
            zero = zero.madd(select(i / 2, radix16[i])).toP3();
        }
        GroupElement p3 = zero.dbl().toP2().dbl().toP2().dbl().toP2().dbl().toP3();
        for (int i2 = 0; i2 < 64; i2 += 2) {
            p3 = p3.madd(select(i2 / 2, radix16[i2])).toP3();
        }
        return p3;
    }

    public GroupElement select(int i, int i2) {
        int iNegative = Utils.negative(i2);
        int i3 = i2 - (((-iNegative) & i2) << 1);
        GroupElement groupElementCmov = this.curve.getZero(Representation.PRECOMP).cmov(this.precmp[i][0], Utils.equal(i3, 1)).cmov(this.precmp[i][1], Utils.equal(i3, 2)).cmov(this.precmp[i][2], Utils.equal(i3, 3)).cmov(this.precmp[i][3], Utils.equal(i3, 4)).cmov(this.precmp[i][4], Utils.equal(i3, 5)).cmov(this.precmp[i][5], Utils.equal(i3, 6)).cmov(this.precmp[i][6], Utils.equal(i3, 7)).cmov(this.precmp[i][7], Utils.equal(i3, 8));
        return groupElementCmov.cmov(precomp(this.curve, groupElementCmov.Y, groupElementCmov.X, groupElementCmov.Z.negate()), iNegative);
    }

    public GroupElement sub(GroupElement groupElement) {
        if (this.repr != Representation.P3) {
            throw new UnsupportedOperationException();
        }
        if (groupElement.repr != Representation.CACHED) {
            throw new IllegalArgumentException();
        }
        FieldElement fieldElementAdd = this.Y.add(this.X);
        FieldElement fieldElementSubtract = this.Y.subtract(this.X);
        FieldElement fieldElementMultiply = fieldElementAdd.multiply(groupElement.Y);
        FieldElement fieldElementMultiply2 = fieldElementSubtract.multiply(groupElement.X);
        FieldElement fieldElementMultiply3 = groupElement.T.multiply(this.T);
        FieldElement fieldElementMultiply4 = this.Z.multiply(groupElement.Z);
        FieldElement fieldElementAdd2 = fieldElementMultiply4.add(fieldElementMultiply4);
        return p1p1(this.curve, fieldElementMultiply.subtract(fieldElementMultiply2), fieldElementMultiply.add(fieldElementMultiply2), fieldElementAdd2.subtract(fieldElementMultiply3), fieldElementAdd2.add(fieldElementMultiply3));
    }

    public byte[] toByteArray() {
        int i = AnonymousClass1.$SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[this.repr.ordinal()];
        if (i != 1 && i != 2) {
            return toP2().toByteArray();
        }
        FieldElement fieldElementInvert = this.Z.invert();
        FieldElement fieldElementMultiply = this.X.multiply(fieldElementInvert);
        byte[] byteArray = this.Y.multiply(fieldElementInvert).toByteArray();
        int length = byteArray.length - 1;
        byteArray[length] = (byte) (byteArray[length] | (fieldElementMultiply.isNegative() ? (byte) -128 : (byte) 0));
        return byteArray;
    }

    public GroupElement toCached() {
        return toRep(Representation.CACHED);
    }

    public GroupElement toP2() {
        return toRep(Representation.P2);
    }

    public GroupElement toP3() {
        return toRep(Representation.P3);
    }

    public GroupElement toP3PrecomputeDouble() {
        return toRep(Representation.P3PrecomputedDouble);
    }

    public String toString() {
        return "[GroupElement\nX=" + this.X + "\nY=" + this.Y + "\nZ=" + this.Z + "\nT=" + this.T + "\n]";
    }

    public GroupElement(Curve curve, Representation representation, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4, boolean z) {
        this.curve = curve;
        this.repr = representation;
        this.X = fieldElement;
        this.Y = fieldElement2;
        this.Z = fieldElement3;
        this.T = fieldElement4;
        this.precmp = null;
        this.dblPrecmp = z ? precomputeDouble() : null;
    }

    public static GroupElement p3(Curve curve, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4, boolean z) {
        return new GroupElement(curve, Representation.P3, fieldElement, fieldElement2, fieldElement3, fieldElement4, z);
    }

    public boolean isOnCurve(Curve curve) {
        int i = AnonymousClass1.$SwitchMap$net$i2p$crypto$eddsa$math$GroupElement$Representation[this.repr.ordinal()];
        if (i != 1 && i != 2) {
            return toP2().isOnCurve(curve);
        }
        FieldElement fieldElementInvert = this.Z.invert();
        FieldElement fieldElementMultiply = this.X.multiply(fieldElementInvert);
        FieldElement fieldElementMultiply2 = this.Y.multiply(fieldElementInvert);
        FieldElement fieldElementSquare = fieldElementMultiply.square();
        FieldElement fieldElementSquare2 = fieldElementMultiply2.square();
        return curve.getField().ONE.add(curve.getD().multiply(fieldElementSquare).multiply(fieldElementSquare2)).add(fieldElementSquare).equals(fieldElementSquare2);
    }

    public GroupElement(Curve curve, byte[] bArr) {
        this(curve, bArr, false);
    }

    public GroupElement(Curve curve, byte[] bArr, boolean z) {
        FieldElement fieldElementFromByteArray = curve.getField().fromByteArray(bArr);
        FieldElement fieldElementSquare = fieldElementFromByteArray.square();
        FieldElement fieldElementSubtractOne = fieldElementSquare.subtractOne();
        FieldElement fieldElementAddOne = fieldElementSquare.multiply(curve.getD()).addOne();
        FieldElement fieldElementMultiply = fieldElementAddOne.square().multiply(fieldElementAddOne);
        FieldElement fieldElementMultiply2 = fieldElementMultiply.multiply(fieldElementSubtractOne).multiply(fieldElementMultiply.square().multiply(fieldElementAddOne).multiply(fieldElementSubtractOne).pow22523());
        FieldElement fieldElementMultiply3 = fieldElementMultiply2.square().multiply(fieldElementAddOne);
        if (fieldElementMultiply3.subtract(fieldElementSubtractOne).isNonZero()) {
            if (!fieldElementMultiply3.add(fieldElementSubtractOne).isNonZero()) {
                fieldElementMultiply2 = fieldElementMultiply2.multiply(curve.getI());
            } else {
                throw new IllegalArgumentException("not a valid GroupElement");
            }
        }
        fieldElementMultiply2 = fieldElementMultiply2.isNegative() != Utils.bit(bArr, curve.getField().getb() + (-1)) ? fieldElementMultiply2.negate() : fieldElementMultiply2;
        this.curve = curve;
        this.repr = Representation.P3;
        this.X = fieldElementMultiply2;
        this.Y = fieldElementFromByteArray;
        this.Z = curve.getField().ONE;
        this.T = fieldElementMultiply2.multiply(fieldElementFromByteArray);
        if (z) {
            this.precmp = precomputeSingle();
            this.dblPrecmp = precomputeDouble();
        } else {
            this.precmp = null;
            this.dblPrecmp = null;
        }
    }
}
