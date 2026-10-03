package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class s6 extends u6 {
    public final int f;
    public final int h;

    public s6(byte[] bArr, int i, int i2) {
        super(bArr);
        u6.b(i, i + i2, bArr.length);
        this.f = i;
        this.h = i2;
    }

    @Override // sensei0.u6
    public final byte a(int i) {
        int i2 = this.h;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.b[this.f + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(za0.h(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(za0.j("Index > length: ", i, ", ", i2));
    }

    @Override // sensei0.u6
    public final void d(byte[] bArr, int i) {
        System.arraycopy(this.b, this.f, bArr, 0, i);
    }

    @Override // sensei0.u6
    public final int e() {
        return this.f;
    }

    @Override // sensei0.u6
    public final byte f(int i) {
        return this.b[this.f + i];
    }

    @Override // sensei0.u6
    public final int size() {
        return this.h;
    }
}
