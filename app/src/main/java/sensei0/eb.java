package sensei0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class eb {
    public int a;
    public int b;
    public float c;
    public float d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i30.f);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == 1) {
                this.c = typedArrayObtainStyledAttributes.getFloat(index, this.c);
            } else if (index == 0) {
                int i2 = typedArrayObtainStyledAttributes.getInt(index, this.a);
                this.a = i2;
                this.a = gb.d[i2];
            } else if (index == 4) {
                this.b = typedArrayObtainStyledAttributes.getInt(index, this.b);
            } else if (index == 3) {
                this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
