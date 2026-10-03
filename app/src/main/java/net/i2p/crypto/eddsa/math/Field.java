package net.i2p.crypto.eddsa.math;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Field implements Serializable {
    private static final long serialVersionUID = 8746587465875676L;
    public final FieldElement EIGHT;
    public final FieldElement FIVE;
    public final FieldElement FOUR;
    public final FieldElement ONE;
    public final FieldElement TWO;
    public final FieldElement ZERO;
    private final int b;
    private final Encoding enc;
    private final FieldElement q;
    private final FieldElement qm2;
    private final FieldElement qm5d8;

    public Field(int i, byte[] bArr, Encoding encoding) {
        this.b = i;
        this.enc = encoding;
        encoding.setField(this);
        FieldElement fieldElementFromByteArray = fromByteArray(bArr);
        this.q = fieldElementFromByteArray;
        this.ZERO = fromByteArray(Constants.ZERO);
        this.ONE = fromByteArray(Constants.ONE);
        FieldElement fieldElementFromByteArray2 = fromByteArray(Constants.TWO);
        this.TWO = fieldElementFromByteArray2;
        this.FOUR = fromByteArray(Constants.FOUR);
        FieldElement fieldElementFromByteArray3 = fromByteArray(Constants.FIVE);
        this.FIVE = fieldElementFromByteArray3;
        FieldElement fieldElementFromByteArray4 = fromByteArray(Constants.EIGHT);
        this.EIGHT = fieldElementFromByteArray4;
        this.qm2 = fieldElementFromByteArray.subtract(fieldElementFromByteArray2);
        this.qm5d8 = fieldElementFromByteArray.subtract(fieldElementFromByteArray3).divide(fieldElementFromByteArray4);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        return this.b == field.b && this.q.equals(field.q);
    }

    public FieldElement fromByteArray(byte[] bArr) {
        return this.enc.decode(bArr);
    }

    public Encoding getEncoding() {
        return this.enc;
    }

    public FieldElement getQ() {
        return this.q;
    }

    public FieldElement getQm2() {
        return this.qm2;
    }

    public FieldElement getQm5d8() {
        return this.qm5d8;
    }

    public int getb() {
        return this.b;
    }

    public int hashCode() {
        return this.q.hashCode();
    }
}
