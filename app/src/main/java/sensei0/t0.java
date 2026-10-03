package sensei0;

import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.view.SurfaceControl;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class t0 {
    public static /* bridge */ /* synthetic */ ColorStateListDrawable e(Drawable drawable) {
        return (ColorStateListDrawable) drawable;
    }

    public static /* synthetic */ SurfaceControl.Builder h() {
        return new SurfaceControl.Builder();
    }

    public static /* bridge */ /* synthetic */ SurfaceControl.Transaction j(Object obj) {
        return (SurfaceControl.Transaction) obj;
    }

    public static /* synthetic */ void m() {
    }

    public static /* bridge */ /* synthetic */ boolean r(Drawable drawable) {
        return drawable instanceof ColorStateListDrawable;
    }
}
