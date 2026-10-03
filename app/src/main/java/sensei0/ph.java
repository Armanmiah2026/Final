package sensei0;

import android.content.Context;
import android.util.TypedValue;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ph {
    public static final int f = (int) Math.round(5.1000000000000005d);
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public ph(Context context) {
        TypedValue typedValueX = wf0.x(context, R.attr.elevationOverlayEnabled);
        boolean z = (typedValueX == null || typedValueX.type != 18 || typedValueX.data == 0) ? false : true;
        int iS = mm0.s(context, R.attr.elevationOverlayColor, 0);
        int iS2 = mm0.s(context, R.attr.elevationOverlayAccentColor, 0);
        int iS3 = mm0.s(context, R.attr.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a = z;
        this.b = iS;
        this.c = iS2;
        this.d = iS3;
        this.e = f2;
    }
}
