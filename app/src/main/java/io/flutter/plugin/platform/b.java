package io.flutter.plugin.platform;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import java.util.HashMap;
import sensei0.cj0;
import sensei0.e10;
import sensei0.f10;
import sensei0.fa0;
import sensei0.g10;
import sensei0.h10;
import sensei0.i10;
import sensei0.k10;
import sensei0.l10;
import sensei0.q0;
import sensei0.ri0;
import sensei0.rk;
import sensei0.ta0;
import sensei0.vl;
import sensei0.vm;
import sensei0.wm;
import sensei0.x2;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements l10 {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // sensei0.l10
    public final void b(boolean z) {
        this.a.z = z;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [sensei0.n10] */
    @Override // sensei0.l10
    public final long d(final f10 f10Var) {
        i10 i10Var;
        long j;
        final c cVar = this.a;
        c.a(cVar, f10Var);
        double d = f10Var.d;
        double d2 = f10Var.c;
        int i = f10Var.a;
        SparseArray sparseArray = cVar.w;
        if (sparseArray.get(i) != null) {
            throw new IllegalStateException(za0.h(i, "Trying to create an already created platform view, view id: "));
        }
        if (cVar.h == null) {
            throw new IllegalStateException(za0.h(i, "Texture registry is null. This means that platform views controller was detached, view id: "));
        }
        if (cVar.d == null) {
            throw new IllegalStateException(za0.h(i, "Flutter view is null. This means the platform views controller doesn't have an attached view, view id: "));
        }
        final int i2 = 1;
        e10 e10VarB = cVar.b(f10Var, true);
        View view = e10VarB.getView();
        if (view.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        if (ri0.d(view, new x2(12, c.F))) {
            if (f10Var.h == 2) {
                if (cVar.f.IsSurfaceControlEnabled()) {
                    throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
                }
                return -2L;
            }
            if (!cVar.D) {
                g10 g10VarI = c.i(cVar.h);
                int iM = cVar.m(d2);
                int iM2 = cVar.m(d);
                vl vlVar = cVar.c;
                q0 q0Var = cVar.q;
                int i3 = f10Var.a;
                n10 r6 = new n10(cVar, f10Var, i2);
                cj0 cj0Var = d.i;
                d dVar = null;
                if (iM != 0 && iM2 != 0) {
                    DisplayManager displayManager = (DisplayManager) vlVar.getSystemService("display");
                    DisplayMetrics displayMetrics = vlVar.getResources().getDisplayMetrics();
                    g10VarI.c(iM, iM2);
                    VirtualDisplay virtualDisplayCreateVirtualDisplay = displayManager.createVirtualDisplay(za0.h(i3, "flutter-vd#"), iM, iM2, displayMetrics.densityDpi, g10VarI.getSurface(), 0, d.i, null);
                    if (virtualDisplayCreateVirtualDisplay != null) {
                        dVar = new d(vlVar, q0Var, virtualDisplayCreateVirtualDisplay, e10VarB, g10VarI, r6, i3);
                    }
                }
                if (dVar != null) {
                    cVar.r.put(Integer.valueOf(i), dVar);
                    View view2 = e10VarB.getView();
                    cVar.s.put(view2.getContext(), view2);
                    return g10VarI.getId();
                }
                throw new IllegalStateException("Failed creating virtual display for a " + f10Var.b + " with id: " + i);
            }
        }
        int iM3 = cVar.m(d2);
        int iM4 = cVar.m(d);
        if (cVar.D) {
            i10Var = new i10(cVar.c);
            j = -1;
        } else {
            g10 g10VarI2 = c.i(cVar.h);
            i10 i10Var2 = new i10(cVar.c);
            i10Var2.h = g10VarI2;
            Surface surface = g10VarI2.getSurface();
            if (surface != null) {
                Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
                try {
                    canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                } finally {
                    surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
                }
            }
            long id = g10VarI2.getId();
            i10Var = i10Var2;
            j = id;
        }
        i10Var.setTouchProcessor(cVar.b);
        g10 g10Var = i10Var.h;
        if (g10Var != null) {
            g10Var.c(iM3, iM4);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iM3, iM4, 51);
        int iM5 = cVar.m(f10Var.e);
        int iM6 = cVar.m(f10Var.f);
        layoutParams.topMargin = iM5;
        layoutParams.leftMargin = iM6;
        i10Var.setLayoutParams(layoutParams);
        View view3 = e10VarB.getView();
        view3.setLayoutParams(new FrameLayout.LayoutParams(iM3, iM4));
        view3.setImportantForAccessibility(4);
        i10Var.addView(view3);
        final int i4 = 0;
        i10Var.setOnDescendantFocusChangeListener(new n10(cVar, f10Var, 0));
        cVar.d.addView(i10Var);
        sparseArray.append(i, i10Var);
        return j;
    }

    @Override // sensei0.l10
    public final void f(int i, double d, double d2) {
        c cVar = this.a;
        if (cVar.h(i)) {
            return;
        }
        i10 i10Var = (i10) cVar.w.get(i);
        if (i10Var == null) {
            Log.e("PlatformViewsController", "Setting offset for unknown platform view with id: " + i);
            return;
        }
        int iM = cVar.m(d);
        int iM2 = cVar.m(d2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) i10Var.getLayoutParams();
        layoutParams.topMargin = iM;
        layoutParams.leftMargin = iM2;
        layoutParams.gravity = 51;
        i10Var.setLayoutParams(layoutParams);
    }

    @Override // sensei0.l10
    public final void g(int i, int i2) {
        View view;
        if (i2 != 0 && i2 != 1) {
            throw new IllegalStateException("Trying to set unknown direction value: " + i2 + "(view id: " + i + ")");
        }
        c cVar = this.a;
        if (cVar.h(i)) {
            view = ((d) cVar.r.get(Integer.valueOf(i))).a();
        } else {
            e10 e10Var = (e10) cVar.t.get(i);
            if (e10Var == null) {
                Log.e("PlatformViewsController", "Setting direction to an unknown view with id: " + i);
                return;
            }
            view = e10Var.getView();
        }
        if (view != null) {
            view.setLayoutDirection(i2);
            return;
        }
        Log.e("PlatformViewsController", "Setting direction to a null view with id: " + i);
    }

    @Override // sensei0.l10
    public final void i(f10 f10Var) {
        c cVar = this.a;
        c.a(cVar, f10Var);
        if (cVar.f.IsSurfaceControlEnabled()) {
            throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
        }
        cVar.b(f10Var, false);
        if (cVar.f.IsSurfaceControlEnabled()) {
            throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [io.flutter.plugin.platform.a, java.lang.Runnable] */
    @Override // sensei0.l10
    public final void m(k10 k10Var, final x2 x2Var) {
        g10 g10Var;
        double d = k10Var.b;
        c cVar = this.a;
        int iM = cVar.m(d);
        int iM2 = cVar.m(k10Var.c);
        int i = k10Var.a;
        if (!cVar.h(i)) {
            e10 e10Var = (e10) cVar.t.get(i);
            i10 i10Var = (i10) cVar.w.get(i);
            if (e10Var == null || i10Var == null) {
                Log.e("PlatformViewsController", "Resizing unknown platform view with id: " + i);
                return;
            }
            if ((iM > i10Var.getRenderTargetWidth() || iM2 > i10Var.getRenderTargetHeight()) && (g10Var = i10Var.h) != null) {
                g10Var.c(iM, iM2);
            }
            ViewGroup.LayoutParams layoutParams = i10Var.getLayoutParams();
            layoutParams.width = iM;
            layoutParams.height = iM2;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 51;
            }
            i10Var.setLayoutParams(layoutParams);
            View view = e10Var.getView();
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = iM;
                layoutParams2.height = iM2;
                view.setLayoutParams(layoutParams2);
            }
            int iRound = (int) Math.round(((double) i10Var.getRenderTargetWidth()) / ((double) cVar.f()));
            int iRound2 = (int) Math.round(((double) i10Var.getRenderTargetHeight()) / ((double) cVar.f()));
            rk rkVar = (rk) x2Var.b;
            HashMap map = new HashMap();
            map.put("width", Double.valueOf(iRound));
            map.put("height", Double.valueOf(iRound2));
            rkVar.d(map);
            return;
        }
        final float f = cVar.f();
        final d dVar = (d) cVar.r.get(Integer.valueOf(i));
        io.flutter.plugin.editing.b bVar = cVar.o;
        if (bVar != null) {
            if (bVar.e.b == 3) {
                bVar.p = true;
            }
            SingleViewPresentation singleViewPresentation = dVar.a;
            if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
                dVar.a.getView().getClass();
            }
        }
        Runnable r4 = new Runnable() { // from class: io.flutter.plugin.platform.a
            @Override // java.lang.Runnable
            public final void run() {
                c cVar2 = this.a.a;
                io.flutter.plugin.editing.b bVar2 = cVar2.o;
                d dVar2 = dVar;
                if (bVar2 != null) {
                    if (bVar2.e.b == 3) {
                        bVar2.p = false;
                    }
                    SingleViewPresentation singleViewPresentation2 = dVar2.a;
                    if (singleViewPresentation2 != null && singleViewPresentation2.getView() != null) {
                        dVar2.a.getView().getClass();
                    }
                }
                double dF = cVar2.c == null ? f : cVar2.f();
                int iRound3 = (int) Math.round(((double) dVar2.f.getWidth()) / dF);
                int iRound4 = (int) Math.round(((double) dVar2.f.getHeight()) / dF);
                rk rkVar2 = (rk) x2Var.b;
                HashMap map2 = new HashMap();
                map2.put("width", Double.valueOf(iRound3));
                map2.put("height", Double.valueOf(iRound4));
                rkVar2.d(map2);
            }
        };
        g10 g10Var2 = dVar.f;
        if (iM == g10Var2.getWidth() && iM2 == dVar.f.getHeight()) {
            dVar.a().postDelayed(r4, 0L);
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            View viewA = dVar.a();
            g10Var2.c(iM, iM2);
            dVar.h.resize(iM, iM2, dVar.d);
            dVar.h.setSurface(g10Var2.getSurface());
            viewA.postDelayed(r4, 0L);
            return;
        }
        boolean zIsFocused = dVar.a().isFocused();
        ta0 ta0VarDetachState = dVar.a.detachState();
        dVar.h.setSurface(null);
        dVar.h.release();
        DisplayManager displayManager = (DisplayManager) dVar.b.getSystemService("display");
        g10Var2.c(iM, iM2);
        dVar.h = displayManager.createVirtualDisplay("flutter-vd#" + dVar.e, iM, iM2, dVar.d, g10Var2.getSurface(), 0, d.i, null);
        View viewA2 = dVar.a();
        viewA2.addOnAttachStateChangeListener(new fa0(viewA2, (a) r4));
        SingleViewPresentation singleViewPresentation2 = new SingleViewPresentation(dVar.b, dVar.h.getDisplay(), dVar.c, ta0VarDetachState, dVar.g, zIsFocused);
        singleViewPresentation2.show();
        dVar.a.cancel();
        dVar.a = singleViewPresentation2;
    }

    @Override // sensei0.l10
    public final void n(int i) {
        View view;
        c cVar = this.a;
        if (cVar.h(i)) {
            view = ((d) cVar.r.get(Integer.valueOf(i))).a();
        } else {
            e10 e10Var = (e10) cVar.t.get(i);
            if (e10Var == null) {
                Log.e("PlatformViewsController", "Clearing focus on an unknown view with id: " + i);
                return;
            }
            view = e10Var.getView();
        }
        if (view != null) {
            view.clearFocus();
            return;
        }
        Log.e("PlatformViewsController", "Clearing focus on a null view with id: " + i);
    }

    @Override // sensei0.l10
    public final void p(h10 h10Var) {
        int i = h10Var.a;
        c cVar = this.a;
        float f = cVar.c.getResources().getDisplayMetrics().density;
        if (cVar.h(i)) {
            d dVar = (d) cVar.r.get(Integer.valueOf(i));
            MotionEvent motionEventL = cVar.l(f, h10Var, true);
            SingleViewPresentation singleViewPresentation = dVar.a;
            if (singleViewPresentation == null) {
                return;
            }
            singleViewPresentation.dispatchTouchEvent(motionEventL);
            return;
        }
        e10 e10Var = (e10) cVar.t.get(i);
        if (e10Var == null) {
            Log.e("PlatformViewsController", "Sending touch to an unknown view with id: " + i);
            return;
        }
        View view = e10Var.getView();
        if (view != null) {
            view.dispatchTouchEvent(cVar.l(f, h10Var, false));
            return;
        }
        Log.e("PlatformViewsController", "Sending touch to a null view with id: " + i);
    }

    @Override // sensei0.l10
    public final void r(int i) {
        vm vmVar;
        c cVar = this.a;
        SparseArray sparseArray = cVar.u;
        SparseArray sparseArray2 = cVar.w;
        HashMap map = cVar.r;
        SparseArray sparseArray3 = cVar.t;
        e10 e10Var = (e10) sparseArray3.get(i);
        if (e10Var == null) {
            Log.e("PlatformViewsController", "Disposing unknown platform view with id: " + i);
            return;
        }
        if (e10Var.getView() != null) {
            View view = e10Var.getView();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        sparseArray3.remove(i);
        if (cVar.h(i)) {
            d dVar = (d) map.get(Integer.valueOf(i));
            View viewA = dVar.a();
            if (viewA != null) {
                cVar.s.remove(viewA.getContext());
            }
            dVar.a.cancel();
            dVar.a.detachState();
            dVar.h.release();
            dVar.f.release();
            map.remove(Integer.valueOf(i));
            return;
        }
        i10 i10Var = (i10) sparseArray2.get(i);
        if (i10Var == null) {
            wm wmVar = (wm) sparseArray.get(i);
            if (wmVar != null) {
                wmVar.removeAllViews();
                wmVar.a();
                ViewGroup viewGroup2 = (ViewGroup) wmVar.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(wmVar);
                }
                sparseArray.remove(i);
                return;
            }
            return;
        }
        i10Var.removeAllViews();
        g10 g10Var = i10Var.h;
        if (g10Var != null) {
            g10Var.release();
            i10Var.h = null;
        }
        ViewTreeObserver viewTreeObserver = i10Var.getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (vmVar = i10Var.o) != null) {
            i10Var.o = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(vmVar);
        }
        ViewGroup viewGroup3 = (ViewGroup) i10Var.getParent();
        if (viewGroup3 != null) {
            viewGroup3.removeView(i10Var);
        }
        sparseArray2.remove(i);
    }

    @Override // sensei0.l10
    public final void t(f10 f10Var) {
        throw new IllegalStateException("Trying to create an HC++ platform view from within PlatformViewsController1. Request: " + f10Var);
    }

    @Override // sensei0.l10
    public final boolean v() {
        return false;
    }
}
