package sensei0;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vh0 {
    public static int a(View view) {
        return view.getImportantForAutofill();
    }

    public static void b(View view, int i) {
        view.setImportantForAutofill(i);
    }
}
