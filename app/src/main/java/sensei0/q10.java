package sensei0;

import android.util.SparseArray;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class q10 implements j10 {
    public lm a;
    public s2 b;
    public vl c;
    public nn d;
    public io.flutter.plugin.editing.b h;
    public i3 o;
    public final i3 s;
    public FlutterJNI f = null;
    public Surface v = null;
    public SurfaceControl w = null;
    public final HashSet x = new HashSet();
    public final ws y = new ws(16, this);
    public final q0 p = new q0();
    public final SparseArray q = new SparseArray();
    public final SparseArray r = new SparseArray();
    public final ArrayList t = new ArrayList();
    public final ArrayList u = new ArrayList();

    public q10() {
        if (i3.d == null) {
            i3.d = new i3(19);
        }
        this.s = i3.d;
    }

    public final boolean a(int i) {
        e10 e10Var = (e10) this.q.get(i);
        if (e10Var == null) {
            return false;
        }
        SparseArray sparseArray = this.r;
        if (sparseArray.get(i) != null) {
            return true;
        }
        View view = e10Var.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (view.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        vl vlVar = this.c;
        wm wmVar = new wm(vlVar, vlVar.getResources().getDisplayMetrics().density, this.b);
        wmVar.setOnDescendantFocusChangeListener(new m10(this, i, 1));
        sparseArray.put(i, wmVar);
        view.setImportantForAccessibility(4);
        wmVar.addView(view);
        this.d.addView(wmVar);
        return true;
    }

    @Override // sensei0.j10
    public final void c(io.flutter.view.b bVar) {
        this.p.a = bVar;
    }

    @Override // sensei0.j10
    public final boolean h(int i) {
        return false;
    }

    @Override // sensei0.j10
    public final View k(int i) {
        e10 e10Var = (e10) this.q.get(i);
        if (e10Var == null) {
            return null;
        }
        return e10Var.getView();
    }

    @Override // sensei0.j10
    public final void o() {
        this.p.a = null;
    }
}
