package net.i2p.crypto.eddsa.math;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FieldElement implements Serializable {
    private static final long serialVersionUID = 1239527465875676L;
    protected final Field f;

    public FieldElement(Field field) {
        if (field == null) {
            throw new IllegalArgumentException("field cannot be null");
        }
        this.f = field;
    }

    public abstract FieldElement add(FieldElement fieldElement);

    public FieldElement addOne() {
        return add(this.f.ONE);
    }

    public abstract FieldElement cmov(FieldElement fieldElement, int i);

    public FieldElement divide(FieldElement fieldElement) {
        return multiply(fieldElement.invert());
    }

    public abstract FieldElement invert();

    public boolean isNegative() {
        return this.f.getEncoding().isNegative(this);
    }

    public abstract boolean isNonZero();

    public abstract FieldElement multiply(FieldElement fieldElement);

    public abstract FieldElement negate();

    public abstract FieldElement pow22523();

    public abstract FieldElement square();

    public abstract FieldElement squareAndDouble();

    public abstract FieldElement subtract(FieldElement fieldElement);

    public FieldElement subtractOne() {
        return subtract(this.f.ONE);
    }

    public byte[] toByteArray() {
        return this.f.getEncoding().encode(this);
    }
}
