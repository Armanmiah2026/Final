package sensei0;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class g3 extends h3 {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g3(int i, String str, String str2) {
        super(str, str2);
        this.d = i;
    }

    @Override // sensei0.h3
    public final boolean a() {
        switch (this.d) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return false;
            case 3:
                return Build.VERSION.SDK_INT >= 26;
            case 4:
                return Build.VERSION.SDK_INT >= 27;
            case 5:
                return Build.VERSION.SDK_INT >= 28;
            default:
                return Build.VERSION.SDK_INT >= 29;
        }
    }
}
