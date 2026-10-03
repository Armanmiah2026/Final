package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import com.sensei.tunnel.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class p50 {
    public static p50 g;
    public WeakHashMap a;
    public final WeakHashMap b = new WeakHashMap(0);
    public TypedValue c;
    public boolean d;
    public o3 e;
    public static final PorterDuff.Mode f = PorterDuff.Mode.SRC_IN;
    public static final o50 h = new o50(6);

    public static synchronized p50 b() {
        try {
            if (g == null) {
                g = new p50();
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        o50 o50Var = h;
        o50Var.getClass();
        int i2 = (31 + i) * 31;
        porterDuffColorFilter = (PorterDuffColorFilter) o50Var.a(Integer.valueOf(mode.hashCode() + i2));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i) {
        Drawable drawableNewDrawable;
        WeakReference weakReference;
        if (this.c == null) {
            this.c = new TypedValue();
        }
        TypedValue typedValue = this.c;
        context.getResources().getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        synchronized (this) {
            cv cvVar = (cv) this.b.get(context);
            drawableNewDrawable = null;
            if (cvVar != null && (weakReference = (WeakReference) cvVar.b(j)) != null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                if (constantState != null) {
                    drawableNewDrawable = constantState.newDrawable(context.getResources());
                } else {
                    int iE = xe.e(cvVar.b, cvVar.d, j);
                    if (iE >= 0) {
                        Object[] objArr = cvVar.c;
                        Object obj = objArr[iE];
                        Object obj2 = wf0.c;
                        if (obj != obj2) {
                            objArr[iE] = obj2;
                            cvVar.a = true;
                        }
                    }
                }
            }
        }
        if (drawableNewDrawable != null) {
            return drawableNewDrawable;
        }
        LayerDrawable layerDrawableC = null;
        if (this.e != null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                layerDrawableC = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i == R.drawable.abc_ratingbar_material) {
                layerDrawableC = o3.c(this, context, R.dimen.abc_star_big);
            } else if (i == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawableC = o3.c(this, context, R.dimen.abc_star_medium);
            } else if (i == R.drawable.abc_ratingbar_small_material) {
                layerDrawableC = o3.c(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawableC == null) {
            return layerDrawableC;
        }
        layerDrawableC.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawableC.getConstantState();
                if (constantState2 != null) {
                    cv cvVar2 = (cv) this.b.get(context);
                    if (cvVar2 == null) {
                        cvVar2 = new cv();
                        this.b.put(context, cvVar2);
                    }
                    cvVar2.d(j, new WeakReference(constantState2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return layerDrawableC;
    }

    public final synchronized Drawable c(Context context, int i) {
        return d(context, i);
    }

    public final synchronized Drawable d(Context context, int i) {
        Drawable drawableA;
        try {
            if (!this.d) {
                this.d = true;
                Drawable drawableC = c(context, R.drawable.abc_vector_test);
                if (drawableC == null || (!(drawableC instanceof eh0) && !"android.graphics.drawable.VectorDrawable".equals(drawableC.getClass().getName()))) {
                    this.d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            drawableA = a(context, i);
            if (drawableA == null) {
                drawableA = context.getDrawable(i);
            }
            if (drawableA != null) {
                drawableA = g(context, i, drawableA);
            }
            if (drawableA != null) {
                ah.a(drawableA);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableA;
    }

    public final synchronized ColorStateList f(Context context, int i) {
        ColorStateList colorStateList;
        eb0 eb0Var;
        WeakHashMap weakHashMap = this.a;
        ColorStateList colorStateListD = null;
        colorStateList = (weakHashMap == null || (eb0Var = (eb0) weakHashMap.get(context)) == null) ? null : (ColorStateList) eb0Var.b(i);
        if (colorStateList == null) {
            o3 o3Var = this.e;
            if (o3Var != null) {
                colorStateListD = o3Var.d(context, i);
            }
            if (colorStateListD != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap();
                }
                eb0 eb0Var2 = (eb0) this.a.get(context);
                if (eb0Var2 == null) {
                    eb0Var2 = new eb0();
                    this.a.put(context, eb0Var2);
                }
                eb0Var2.a(i, colorStateListD);
            }
            colorStateList = colorStateListD;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable g(android.content.Context r9, int r10, android.graphics.drawable.Drawable r11) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.p50.g(android.content.Context, int, android.graphics.drawable.Drawable):android.graphics.drawable.Drawable");
    }
}
