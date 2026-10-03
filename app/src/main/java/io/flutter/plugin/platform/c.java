package io.flutter.plugin.platform;

import android.content.MutableContextWrapper;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.e;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import sensei0.e10;
import sensei0.em;
import sensei0.f10;
import sensei0.fb0;
import sensei0.g10;
import sensei0.h10;
import sensei0.i3;
import sensei0.j10;
import sensei0.lm;
import sensei0.nm;
import sensei0.nn;
import sensei0.q0;
import sensei0.rn;
import sensei0.s2;
import sensei0.ta0;
import sensei0.tq;
import sensei0.vl;
import sensei0.xx;
import sensei0.z00;
import sensei0.za0;
import sensei0.zc0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements j10 {
    public static final Class[] F = {SurfaceView.class};
    public final i3 C;
    public s2 b;
    public vl c;
    public nn d;
    public e h;
    public io.flutter.plugin.editing.b o;
    public i3 p;
    public FlutterJNI f = null;
    public int x = 0;
    public boolean y = false;
    public boolean z = true;
    public boolean D = false;
    public final b E = new b(this);
    public final lm a = new lm(2);
    public final HashMap r = new HashMap();
    public final q0 q = new q0();
    public final HashMap s = new HashMap();
    public final SparseArray v = new SparseArray();
    public final HashSet A = new HashSet();
    public final HashSet B = new HashSet();
    public final SparseArray w = new SparseArray();
    public final SparseArray t = new SparseArray();
    public final SparseArray u = new SparseArray();

    public c() {
        if (i3.d == null) {
            i3.d = new i3(19);
        }
        this.C = i3.d;
    }

    public static void a(c cVar, f10 f10Var) {
        int i = f10Var.g;
        if (i == 0 || i == 1) {
            return;
        }
        StringBuilder sb = new StringBuilder("Trying to create a view with unknown direction value: ");
        sb.append(i);
        sb.append("(view id: ");
        throw new IllegalStateException(za0.n(sb, f10Var.a, ")"));
    }

    public static g10 i(e eVar) {
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            return i >= 29 ? new tq(eVar.c()) : new zc0(eVar.e());
        }
        TextureRegistry$SurfaceProducer textureRegistry$SurfaceProducerD = eVar.d(i <= 34 ? 2 : 1);
        fb0 fb0Var = new fb0();
        fb0Var.a = textureRegistry$SurfaceProducerD;
        return fb0Var;
    }

    public final e10 b(f10 f10Var, boolean z) {
        String str = f10Var.b;
        int i = f10Var.a;
        rn rnVar = (rn) this.a.a.get(str);
        if (rnVar == null) {
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + str);
        }
        ByteBuffer byteBuffer = f10Var.i;
        Object objB = byteBuffer != null ? rnVar.a.b(byteBuffer) : null;
        if (z) {
            new MutableContextWrapper(this.c);
        }
        e10 e10VarA = rnVar.a(objB);
        View view = e10VarA.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        view.setLayoutDirection(f10Var.g);
        this.t.put(i, e10VarA);
        return e10VarA;
    }

    @Override // sensei0.j10
    public final void c(io.flutter.view.b bVar) {
        this.q.a = bVar;
    }

    public final void d() {
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.v;
            if (i >= sparseArray.size()) {
                return;
            }
            z00 z00Var = (z00) sparseArray.valueAt(i);
            z00Var.a();
            z00Var.a.close();
            i++;
        }
    }

    public final void e(boolean z) {
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.v;
            if (i >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i);
            z00 z00Var = (z00) sparseArray.valueAt(i);
            if (this.A.contains(Integer.valueOf(iKeyAt))) {
                em emVar = this.d.q;
                if (emVar != null) {
                    z00Var.c(emVar.b);
                }
                z &= z00Var.e();
            } else {
                if (!this.y) {
                    z00Var.a();
                }
                z00Var.setVisibility(8);
                this.d.removeView(z00Var);
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            SparseArray sparseArray2 = this.u;
            if (i2 >= sparseArray2.size()) {
                return;
            }
            int iKeyAt2 = sparseArray2.keyAt(i2);
            View view = (View) sparseArray2.get(iKeyAt2);
            if (!this.B.contains(Integer.valueOf(iKeyAt2)) || (!z && this.z)) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
            i2++;
        }
    }

    public final float f() {
        return this.c.getResources().getDisplayMetrics().density;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, sensei0.f50] */
    public final void g() {
        if (!this.z || this.y) {
            return;
        }
        nn nnVar = this.d;
        nnVar.f.d();
        nm nmVar = nnVar.d;
        if (nmVar == null) {
            nm nmVar2 = new nm(nnVar.getContext(), nnVar.getWidth(), nnVar.getHeight(), 1);
            nnVar.d = nmVar2;
            nnVar.addView(nmVar2);
        } else {
            nmVar.g(nnVar.getWidth(), nnVar.getHeight());
        }
        nnVar.h = nnVar.f;
        nm nmVar3 = nnVar.d;
        nnVar.f = nmVar3;
        em emVar = nnVar.q;
        if (emVar != null) {
            nmVar3.c(emVar.b);
        }
        this.y = true;
    }

    @Override // sensei0.j10
    public final boolean h(int i) {
        return this.r.containsKey(Integer.valueOf(i));
    }

    public final void j() {
        for (d dVar : this.r.values()) {
            g10 g10Var = dVar.f;
            g10 g10Var2 = dVar.f;
            int width = g10Var.getWidth();
            int height = g10Var2.getHeight();
            boolean zIsFocused = dVar.a().isFocused();
            ta0 ta0VarDetachState = dVar.a.detachState();
            dVar.h.setSurface(null);
            dVar.h.release();
            dVar.h = ((DisplayManager) dVar.b.getSystemService("display")).createVirtualDisplay("flutter-vd#" + dVar.e, width, height, dVar.d, g10Var2.getSurface(), 0, d.i, null);
            SingleViewPresentation singleViewPresentation = new SingleViewPresentation(dVar.b, dVar.h.getDisplay(), dVar.c, ta0VarDetachState, dVar.g, zIsFocused);
            singleViewPresentation.show();
            dVar.a.cancel();
            dVar.a = singleViewPresentation;
        }
    }

    @Override // sensei0.j10
    public final View k(int i) {
        if (h(i)) {
            return ((d) this.r.get(Integer.valueOf(i))).a();
        }
        e10 e10Var = (e10) this.t.get(i);
        if (e10Var == null) {
            return null;
        }
        return e10Var.getView();
    }

    public final MotionEvent l(float f, h10 h10Var, boolean z) {
        long j = h10Var.p;
        int i = h10Var.e;
        MotionEvent motionEventI = this.C.I(new xx(j));
        List<List> list = (List) h10Var.g;
        ArrayList arrayList = new ArrayList();
        for (List list2 : list) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = (float) ((Double) list2.get(0)).doubleValue();
            pointerCoords.pressure = (float) ((Double) list2.get(1)).doubleValue();
            pointerCoords.size = (float) ((Double) list2.get(2)).doubleValue();
            double d = f;
            pointerCoords.toolMajor = (float) (((Double) list2.get(3)).doubleValue() * d);
            pointerCoords.toolMinor = (float) (((Double) list2.get(4)).doubleValue() * d);
            pointerCoords.touchMajor = (float) (((Double) list2.get(5)).doubleValue() * d);
            pointerCoords.touchMinor = (float) (((Double) list2.get(6)).doubleValue() * d);
            pointerCoords.x = (float) (((Double) list2.get(7)).doubleValue() * d);
            pointerCoords.y = (float) (((Double) list2.get(8)).doubleValue() * d);
            arrayList.add(pointerCoords);
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) arrayList.toArray(new MotionEvent.PointerCoords[i]);
        List<List> list3 = (List) h10Var.f;
        ArrayList arrayList2 = new ArrayList();
        for (List list4 : list3) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = ((Integer) list4.get(0)).intValue();
            pointerProperties.toolType = ((Integer) list4.get(1)).intValue();
            arrayList2.add(pointerProperties);
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) arrayList2.toArray(new MotionEvent.PointerProperties[i]);
        if (z || motionEventI == null) {
            return MotionEvent.obtain(h10Var.b.longValue(), h10Var.c.longValue(), h10Var.d, h10Var.e, pointerPropertiesArr, pointerCoordsArr, h10Var.h, h10Var.i, h10Var.j, h10Var.k, h10Var.l, h10Var.m, h10Var.n, h10Var.o);
        }
        if (motionEventI.getPointerCount() != i || motionEventI.getAction() != h10Var.d) {
            return MotionEvent.obtain(motionEventI.getDownTime(), motionEventI.getEventTime(), h10Var.d, h10Var.e, pointerPropertiesArr, pointerCoordsArr, motionEventI.getMetaState(), motionEventI.getButtonState(), motionEventI.getXPrecision(), motionEventI.getYPrecision(), motionEventI.getDeviceId(), motionEventI.getEdgeFlags(), motionEventI.getSource(), motionEventI.getFlags());
        }
        if (pointerCoordsArr.length < 1) {
            return motionEventI;
        }
        motionEventI.offsetLocation(pointerCoordsArr[0].x - motionEventI.getX(), pointerCoordsArr[0].y - motionEventI.getY());
        return motionEventI;
    }

    public final int m(double d) {
        return (int) Math.round(d * ((double) f()));
    }

    @Override // sensei0.j10
    public final void o() {
        this.q.a = null;
    }
}
