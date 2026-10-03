package sensei0;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fd0 {
    public int a;
    public int b;
    public int c;
    public Object d;

    public fd0() {
        if (mz.b == null) {
            mz.b = new mz(22);
        }
    }

    public int a(int i) {
        if (i < this.c) {
            return ((ByteBuffer) this.d).getShort(this.b + i);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, Object obj);

    public void d(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.b) {
            c(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.b) {
            tag = b(view);
        } else {
            tag = view.getTag(this.a);
            if (!((Class) this.d).isInstance(tag)) {
                tag = null;
            }
        }
        if (e(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateB = ai0.b(view);
            p0 p0Var = accessibilityDelegateB == null ? null : accessibilityDelegateB instanceof o0 ? ((o0) accessibilityDelegateB).a : new p0(accessibilityDelegateB);
            if (p0Var == null) {
                p0Var = new p0();
            }
            ai0.k(view, p0Var);
            view.setTag(this.a, obj);
            ai0.f(view, this.c);
        }
    }

    public abstract boolean e(Object obj, Object obj2);
}
