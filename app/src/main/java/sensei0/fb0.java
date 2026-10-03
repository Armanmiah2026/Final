package sensei0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.behavior.SwipeDismissBehavior;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import java.lang.reflect.Field;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class fb0 implements g10, r1, tx, rm, lk0, sk0 {
    public Object a;

    public /* synthetic */ fb0(Object obj) {
        this.a = obj;
    }

    @Override // sensei0.r1
    public boolean a(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.a;
        if (!swipeDismissBehavior.r(view)) {
            return false;
        }
        Field field = ai0.a;
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.d;
        view.offsetLeftAndRight((!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    @Override // sensei0.lk0
    public String[] b() {
        return ((WebViewProviderFactoryBoundaryInterface) this.a).getSupportedFeatures();
    }

    @Override // sensei0.g10
    public void c(int i, int i2) {
        ((TextureRegistry$SurfaceProducer) this.a).setSize(i, i2);
    }

    public void d(boolean z) {
        ((WebSettingsBoundaryInterface) this.a).setPaymentRequestEnabled(z);
    }

    @Override // sensei0.g10
    public int getHeight() {
        return ((TextureRegistry$SurfaceProducer) this.a).getHeight();
    }

    @Override // sensei0.g10
    public long getId() {
        return ((TextureRegistry$SurfaceProducer) this.a).id();
    }

    @Override // sensei0.lk0
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) k6.d(StaticsBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.a).getStatics());
    }

    @Override // sensei0.g10
    public Surface getSurface() {
        return ((TextureRegistry$SurfaceProducer) this.a).getSurface();
    }

    @Override // sensei0.lk0
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) k6.d(WebkitToCompatConverterBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.a).getWebkitToCompatConverter());
    }

    @Override // sensei0.g10
    public int getWidth() {
        return ((TextureRegistry$SurfaceProducer) this.a).getWidth();
    }

    @Override // sensei0.tx
    public void l(i3 i3Var, rk rkVar) {
        Object obj;
        int i;
        Bundle bundle;
        i3 i3Var2 = (i3) this.a;
        if (((zd0) i3Var2.c) == null) {
            return;
        }
        String str = (String) i3Var.b;
        obj = i3Var.c;
        str.getClass();
        switch (str) {
            case "TextInput.setPlatformViewClient":
                try {
                    JSONObject jSONObject = (JSONObject) obj;
                    int i2 = jSONObject.getInt("platformViewId");
                    boolean zOptBoolean = jSONObject.optBoolean("usesVirtualDisplay", false);
                    io.flutter.plugin.editing.b bVar = ((zd0) i3Var2.c).a;
                    View view = bVar.a;
                    if (zOptBoolean) {
                        view.requestFocus();
                        bVar.e = new ft(3, i2);
                        bVar.b.restartInput(view);
                        bVar.i = false;
                    } else {
                        bVar.e = new ft(4, i2);
                        bVar.j = null;
                    }
                    rkVar.d(null);
                    break;
                } catch (JSONException e) {
                    rkVar.a("error", e.getMessage(), null);
                    return;
                }
                break;
            case "TextInput.setEditingState":
                try {
                    ((zd0) i3Var2.c).c(td0.a((JSONObject) obj));
                    rkVar.d(null);
                    break;
                } catch (JSONException e2) {
                    rkVar.a("error", e2.getMessage(), null);
                    return;
                }
                break;
            case "TextInput.setClient":
                try {
                    JSONArray jSONArray = (JSONArray) obj;
                    ((zd0) i3Var2.c).a(jSONArray.getInt(0), qd0.a(jSONArray.getJSONObject(1)));
                    rkVar.d(null);
                    break;
                } catch (NoSuchFieldException | JSONException e3) {
                    rkVar.a("error", e3.getMessage(), null);
                    return;
                }
                break;
            case "TextInput.hide":
                io.flutter.plugin.editing.b bVar2 = ((zd0) i3Var2.c).a;
                if (bVar2.e.b == 4) {
                    bVar2.d();
                } else {
                    View view2 = bVar2.a;
                    bVar2.d();
                    bVar2.b.hideSoftInputFromWindow(view2.getApplicationWindowToken(), 0);
                }
                rkVar.d(null);
                break;
            case "TextInput.show":
                io.flutter.plugin.editing.b bVar3 = ((zd0) i3Var2.c).a;
                InputMethodManager inputMethodManager = bVar3.b;
                View view3 = bVar3.a;
                qd0 qd0Var = bVar3.f;
                if (qd0Var == null || qd0Var.g.a != 11) {
                    view3.requestFocus();
                    inputMethodManager.showSoftInput(view3, 0);
                } else {
                    bVar3.d();
                    inputMethodManager.hideSoftInputFromWindow(view3.getApplicationWindowToken(), 0);
                }
                rkVar.d(null);
                break;
            case "TextInput.sendAppPrivateCommand":
                try {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    String string = jSONObject2.getString("action");
                    String string2 = jSONObject2.getString("data");
                    if (string2 == null || string2.isEmpty()) {
                        bundle = null;
                    } else {
                        bundle = new Bundle();
                        bundle.putString("data", string2);
                    }
                    io.flutter.plugin.editing.b bVar4 = ((zd0) i3Var2.c).a;
                    bVar4.b.sendAppPrivateCommand(bVar4.a, string, bundle);
                    rkVar.d(null);
                    break;
                } catch (JSONException e4) {
                    rkVar.a("error", e4.getMessage(), null);
                    return;
                }
                break;
            case "TextInput.setEditableSizeAndTransform":
                try {
                    JSONObject jSONObject3 = (JSONObject) obj;
                    double d = jSONObject3.getDouble("width");
                    double d2 = jSONObject3.getDouble("height");
                    JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                    double[] dArr = new double[16];
                    for (i = 0; i < 16; i++) {
                        dArr[i] = jSONArray2.getDouble(i);
                    }
                    ((zd0) i3Var2.c).b(d, d2, dArr);
                    rkVar.d(null);
                    break;
                } catch (JSONException e5) {
                    rkVar.a("error", e5.getMessage(), null);
                    return;
                }
                break;
            case "TextInput.finishAutofillContext":
                zd0 zd0Var = (zd0) i3Var2.c;
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                if (Build.VERSION.SDK_INT >= 26) {
                    AutofillManager autofillManager = zd0Var.a.c;
                    if (autofillManager != null) {
                        if (zBooleanValue) {
                            autofillManager.commit();
                        } else {
                            autofillManager.cancel();
                        }
                    }
                } else {
                    zd0Var.getClass();
                }
                rkVar.d(null);
                break;
            case "TextInput.clearClient":
                io.flutter.plugin.editing.b bVar5 = ((zd0) i3Var2.c).a;
                View view4 = bVar5.a;
                if (bVar5.e.b != 3) {
                    bVar5.h.e(bVar5);
                    bVar5.d();
                    bVar5.f = null;
                    bVar5.e(null);
                    bVar5.e = new ft(1, 0);
                    bVar5.m = null;
                    Field field = ai0.a;
                    rl0 rl0VarA = uh0.a(view4);
                    if (rl0VarA != null && !rl0VarA.a.o(8)) {
                        bVar5.b.restartInput(view4);
                    }
                }
                rkVar.d(null);
                break;
            case "TextInput.requestAutofill":
                io.flutter.plugin.editing.b bVar6 = ((zd0) i3Var2.c).a;
                View view5 = bVar6.a;
                if (Build.VERSION.SDK_INT >= 26 && bVar6.c != null && bVar6.g != null) {
                    String str2 = (String) bVar6.f.j.a;
                    int[] iArr = new int[2];
                    view5.getLocationOnScreen(iArr);
                    Rect rect = new Rect(bVar6.m);
                    rect.offset(iArr[0], iArr[1]);
                    bVar6.c.notifyViewEntered(view5, str2.hashCode(), rect);
                }
                rkVar.d(null);
                break;
            default:
                rkVar.b();
                break;
        }
    }

    @Override // sensei0.g10
    public void release() {
        ((TextureRegistry$SurfaceProducer) this.a).release();
        this.a = null;
    }

    @Override // sensei0.g10
    public void scheduleFrame() {
        ((TextureRegistry$SurfaceProducer) this.a).scheduleFrame();
    }
}
