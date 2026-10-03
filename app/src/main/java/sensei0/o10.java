package sensei0;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.view.Surface;
import android.view.SurfaceControl;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class o10 {
    public static /* synthetic */ Typeface.CustomFallbackBuilder b(FontFamily fontFamily) {
        return new Typeface.CustomFallbackBuilder(fontFamily);
    }

    public static /* synthetic */ FontFamily.Builder g(Font font) {
        return new FontFamily.Builder(font);
    }

    public static /* synthetic */ Surface i(SurfaceControl surfaceControl) {
        return new Surface(surfaceControl);
    }

    public static /* synthetic */ SurfaceControl.Transaction j() {
        return new SurfaceControl.Transaction();
    }

    public static /* synthetic */ void n() {
    }

    public static /* synthetic */ void z() {
    }
}
