package sensei0;

import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class od0 {
    public float c;
    public final WeakReference e;
    public ld0 f;
    public final TextPaint a = new TextPaint(1);
    public final m8 b = new m8(1, this);
    public boolean d = true;

    public od0(q8 q8Var) {
        this.e = new WeakReference(null);
        this.e = new WeakReference(q8Var);
    }

    public final float a(String str) {
        if (!this.d) {
            return this.c;
        }
        TextPaint textPaint = this.a;
        this.c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.d = false;
        return this.c;
    }
}
