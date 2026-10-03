package sensei0;

import android.app.Activity;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g50 {
    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Activity activity, lt ltVar) {
        vt vtVarB;
        pr.j("event", ltVar);
        if (!(activity instanceof tt) || (vtVarB = ((tt) activity).b()) == null) {
            return;
        }
        vtVarB.e(ltVar);
    }
}
