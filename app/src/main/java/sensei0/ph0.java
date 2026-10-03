package sensei0;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ph0 extends fd0 {
    public final /* synthetic */ int e;

    public ph0(int i, Class cls, int i2, int i3, int i4) {
        this.e = i4;
        this.a = i;
        this.d = cls;
        this.c = i2;
        this.b = i3;
    }

    @Override // sensei0.fd0
    public final Object b(View view) {
        switch (this.e) {
            case 0:
                return wh0.a(view);
            default:
                return yh0.b(view);
        }
    }

    @Override // sensei0.fd0
    public final void c(View view, Object obj) {
        switch (this.e) {
            case 0:
                wh0.d(view, (CharSequence) obj);
                break;
            default:
                yh0.c(view, (CharSequence) obj);
                break;
        }
    }

    @Override // sensei0.fd0
    public final boolean e(Object obj, Object obj2) {
        boolean zEquals;
        switch (this.e) {
            case 0:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
        }
        return !zEquals;
    }
}
