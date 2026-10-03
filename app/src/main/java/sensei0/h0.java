package sensei0;

import android.content.res.Configuration;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {
    public static boolean a(Configuration configuration) {
        int i = configuration.fontWeightAdjustment;
        return i != Integer.MAX_VALUE && i >= 300;
    }
}
