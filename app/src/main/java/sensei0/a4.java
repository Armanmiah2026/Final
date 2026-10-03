package sensei0;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a4 implements Runnable {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Object d;

    public a4(TextView textView, Typeface typeface, int i) {
        this.c = textView;
        this.d = typeface;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ((TextView) this.c).setTypeface((Typeface) this.d, this.b);
                break;
            default:
                ((BottomSheetBehavior) this.d).E(this.c, this.b, false);
                break;
        }
    }

    public a4(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.d = bottomSheetBehavior;
        this.c = view;
        this.b = i;
    }
}
