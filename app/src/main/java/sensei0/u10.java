package sensei0;

import android.text.PrecomputedText;
import android.text.TextPaint;
import android.view.DisplayCutout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class u10 {
    public static /* synthetic */ PrecomputedText.Params.Builder f(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ DisplayCutout h(Object obj) {
        return (DisplayCutout) obj;
    }

    public static /* bridge */ /* synthetic */ boolean k(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }

    public static /* bridge */ /* synthetic */ boolean l(Object obj) {
        return obj instanceof DisplayCutout;
    }
}
