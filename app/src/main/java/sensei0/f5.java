package sensei0;

import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class f5 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f5(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        g2 g2Var;
        int i = this.a;
        int i2 = 2;
        int i3 = 1;
        int i4 = 0;
        Object obj = this.b;
        switch (i) {
            case 0:
                ru ruVar = (ru) obj;
                gh ghVar = ruVar.c;
                e5 e5Var = ruVar.a;
                if (ruVar.w) {
                    if (ruVar.u) {
                        ruVar.u = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        e5Var.e = jCurrentAnimationTimeMillis;
                        e5Var.g = -1L;
                        e5Var.f = jCurrentAnimationTimeMillis;
                        e5Var.h = 0.5f;
                    }
                    if ((e5Var.g > 0 && AnimationUtils.currentAnimationTimeMillis() > e5Var.g + ((long) e5Var.i)) || !ruVar.e()) {
                        ruVar.w = false;
                        return;
                    }
                    if (ruVar.v) {
                        ruVar.v = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                        ghVar.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (e5Var.f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fA = e5Var.a(jCurrentAnimationTimeMillis2);
                    long j2 = jCurrentAnimationTimeMillis2 - e5Var.f;
                    e5Var.f = jCurrentAnimationTimeMillis2;
                    ruVar.y.scrollListBy((int) (j2 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * e5Var.d));
                    Field field = ai0.a;
                    ghVar.postOnAnimation(this);
                    return;
                }
                return;
            case 1:
                i5 i5Var = (i5) obj;
                i5Var.c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) i5Var.e;
                ci0 ci0Var = bottomSheetBehavior.M;
                if (ci0Var != null && ci0Var.f()) {
                    i5Var.a(i5Var.b);
                    return;
                } else {
                    if (bottomSheetBehavior.L == 2) {
                        bottomSheetBehavior.C(i5Var.b);
                        return;
                    }
                    return;
                }
            case 2:
                ((eg) obj).t.onDismiss(null);
                return;
            case 3:
                gh ghVar2 = (gh) obj;
                ghVar2.t = null;
                ghVar2.drawableStateChanged();
                return;
            case 4:
                jk jkVar = (jk) obj;
                ValueAnimator valueAnimator = jkVar.u;
                int i5 = jkVar.v;
                if (i5 == 1) {
                    valueAnimator.cancel();
                } else if (i5 != 2) {
                    return;
                }
                jkVar.v = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            case 5:
                ((rk) ((rk) obj).b).b();
                return;
            case 6:
                mo moVar = (mo) obj;
                if (moVar.f != null) {
                    if (moVar.f == null) {
                        o4 o4Var = new o4(9);
                        Object obj2 = mo.s;
                        o4Var.b = obj2;
                        o4Var.c = obj2;
                        o4Var.d = obj2;
                        moVar.f = o4Var;
                    }
                    moVar.f.getClass();
                    return;
                }
                return;
            case 7:
                ((ro) obj).getClass();
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            case 8:
                d40 d40Var = ((RecyclerView) obj).L;
                if (d40Var != null) {
                    kf kfVar = (kf) d40Var;
                    ArrayList arrayList = kfVar.h;
                    boolean zIsEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = kfVar.j;
                    boolean zIsEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = kfVar.k;
                    boolean zIsEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = kfVar.i;
                    boolean zIsEmpty4 = arrayList4.isEmpty();
                    if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
                        return;
                    }
                    if (arrayList.size() > 0) {
                        ((s40) arrayList.get(0)).getClass();
                        throw null;
                    }
                    arrayList.clear();
                    if (zIsEmpty2) {
                        j = 0;
                    } else {
                        ArrayList arrayList5 = new ArrayList();
                        arrayList5.addAll(arrayList2);
                        j = 0;
                        kfVar.m.add(arrayList5);
                        arrayList2.clear();
                        ef efVar = new ef(kfVar, arrayList5, i4);
                        if (!zIsEmpty) {
                            ((jf) arrayList5.get(0)).getClass();
                            throw null;
                        }
                        efVar.run();
                    }
                    if (!zIsEmpty3) {
                        ArrayList arrayList6 = new ArrayList();
                        arrayList6.addAll(arrayList3);
                        kfVar.n.add(arrayList6);
                        arrayList3.clear();
                        ef efVar2 = new ef(kfVar, arrayList6, i3);
                        if (!zIsEmpty) {
                            ((hf) arrayList6.get(0)).getClass();
                            throw null;
                        }
                        efVar2.run();
                    }
                    if (zIsEmpty4) {
                        return;
                    }
                    ArrayList arrayList7 = new ArrayList();
                    arrayList7.addAll(arrayList4);
                    kfVar.l.add(arrayList7);
                    arrayList4.clear();
                    ef efVar3 = new ef(kfVar, arrayList7, i2);
                    if (zIsEmpty && zIsEmpty2 && zIsEmpty3) {
                        efVar3.run();
                        return;
                    }
                    Math.max(!zIsEmpty2 ? kfVar.e : j, !zIsEmpty3 ? kfVar.f : j);
                    ((s40) arrayList7.get(0)).getClass();
                    Field field2 = ai0.a;
                    throw null;
                }
                return;
            case 9:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) obj;
                if (searchView$SearchAutoComplete.h) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.h = false;
                    return;
                }
                return;
            case 10:
                SenseiTunnelVpnService senseiTunnelVpnService = (SenseiTunnelVpnService) obj;
                if (senseiTunnelVpnService.N > 0) {
                    senseiTunnelVpnService.C(true);
                    senseiTunnelVpnService.Q.postDelayed(this, 1000L);
                    return;
                }
                return;
            case 11:
                ((StaggeredGridLayoutManager) obj).O();
                return;
            case 12:
                CheckableImageButton checkableImageButton = ((TextInputLayout) obj).c.o;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 13:
                ActionMenuView actionMenuView = ((Toolbar) obj).a;
                if (actionMenuView == null || (g2Var = actionMenuView.A) == null) {
                    return;
                }
                g2Var.h();
                return;
            case 14:
                ((ci0) obj).n(0);
                return;
            case 15:
                fa0 fa0Var = (fa0) obj;
                ((View) fa0Var.b).postDelayed((io.flutter.plugin.platform.a) fa0Var.c, 128L);
                return;
            default:
                dj0 dj0Var = (dj0) obj;
                dj0Var.a.getViewTreeObserver().removeOnDrawListener(dj0Var);
                return;
        }
    }
}
