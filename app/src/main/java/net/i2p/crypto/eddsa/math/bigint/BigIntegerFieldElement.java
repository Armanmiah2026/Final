package net.i2p.crypto.eddsa.math.bigint;

import java.io.Serializable;
import java.math.BigInteger;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.FieldElement;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class BigIntegerFieldElement extends FieldElement implements Serializable {
    private static final long serialVersionUID = 4890398908392808L;
    final BigInteger bi;

    public BigIntegerFieldElement(Field field, BigInteger bigInteger) {
        super(field);
        this.bi = bigInteger;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement add(FieldElement fieldElement) {
        return new BigIntegerFieldElement(this.f, this.bi.add(((BigIntegerFieldElement) fieldElement).bi)).mod(this.f.getQ());
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement addOne() {
        return new BigIntegerFieldElement(this.f, this.bi.add(BigInteger.ONE)).mod(this.f.getQ());
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement cmov(FieldElement fieldElement, int i) {
        return i == 0 ? this : fieldElement;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement divide(FieldElement fieldElement) {
        return divide(((BigIntegerFieldElement) fieldElement).bi);
    }

    public boolean equals(Object obj) {
        if (obj instanceof BigIntegerFieldElement) {
            return this.bi.equals(((BigIntegerFieldElement) obj).bi);
        }
        return false;
    }

    public int hashCode() {
        return this.bi.hashCode();
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement invert() {
        Field field = this.f;
        return new BigIntegerFieldElement(field, this.bi.modInverse(((BigIntegerFieldElement) field.getQ()).bi));
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public boolean isNonZero() {
        return !this.bi.equals(BigInteger.ZERO);
    }

    public FieldElement mod(FieldElement fieldElement) {
        return new BigIntegerFieldElement(this.f, this.bi.mod(((BigIntegerFieldElement) fieldElement).bi));
    }

    public FieldElement modPow(FieldElement fieldElement, FieldElement fieldElement2) {
        return new BigIntegerFieldElement(this.f, this.bi.modPow(((BigIntegerFieldElement) fieldElement).bi, ((BigIntegerFieldElement) fieldElement2).bi));
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement multiply(FieldElement fieldElement) {
        return new BigIntegerFieldElement(this.f, this.bi.multiply(((BigIntegerFieldElement) fieldElement).bi)).mod(this.f.getQ());
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement negate() {
        return this.f.getQ().subtract(this);
    }

    public FieldElement pow(FieldElement fieldElement) {
        return modPow(fieldElement, this.f.getQ());
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement pow22523() {
        return pow(this.f.getQm5d8());
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement square() {
        return multiply(this);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement squareAndDouble() {
        FieldElement fieldElementSquare = square();
        return fieldElementSquare.add(fieldElementSquare);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement subtract(FieldElement fieldElement) {
        return new BigIntegerFieldElement(this.f, this.bi.subtract(((BigIntegerFieldElement) fieldElement).bi)).mod(this.f.getQ());
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement subtractOne() {
        return new BigIntegerFieldElement(this.f, this.bi.subtract(BigInteger.ONE)).mod(this.f.getQ());
    }

    public String toString() {
        return "[BigIntegerFieldElement val=" + this.bi + "]";
    }

    public FieldElement divide(BigInteger bigInteger) {
        return new BigIntegerFieldElement(this.f, this.bi.divide(bigInteger)).mod(this.f.getQ());
    }
}
