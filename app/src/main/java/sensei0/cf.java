package sensei0;

import android.text.TextPaint;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cf implements rh {
    public static final ThreadLocal b = new ThreadLocal();
    public final TextPaint a;

    public cf() {
        TextPaint textPaint = new TextPaint();
        this.a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
