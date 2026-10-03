package io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.util.SparseArray;
import android.view.View;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.plugin.platform.c;
import sensei0.aj;
import sensei0.ft;
import sensei0.i3;
import sensei0.j1;
import sensei0.q10;
import sensei0.qd0;
import sensei0.td0;
import sensei0.tu;
import sensei0.uu;
import sensei0.ws;
import sensei0.yd0;
import sensei0.zd0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements tu {
    public final View a;
    public final InputMethodManager b;
    public final AutofillManager c;
    public final i3 d;
    public ft e = new ft(1, 0);
    public qd0 f;
    public SparseArray g;
    public uu h;
    public boolean i;
    public InputConnection j;
    public final c k;
    public final q10 l;
    public Rect m;
    public final ImeSyncDeferringInsetsCallback n;
    public td0 o;
    public boolean p;

    public b(View view, i3 i3Var, ws wsVar, c cVar, q10 q10Var) {
        this.a = view;
        this.h = new uu(null, view);
        this.b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.c = yd0.a(view.getContext().getSystemService(yd0.f()));
        } else {
            this.c = null;
        }
        if (i >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.n = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
            imeSyncDeferringInsetsCallback.setImeVisibilityListener(new zd0(this));
        }
        this.d = i3Var;
        i3Var.c = new zd0(this);
        ((aj) i3Var.b).a("TextInputClient.requestExistingInputState", null, null);
        this.k = cVar;
        cVar.o = this;
        this.l = q10Var;
        q10Var.h = this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
    
        if (r7 == r0.e) goto L38;
     */
    @Override // sensei0.tu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r19) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.b.a(boolean):void");
    }

    public final void b(int i) {
        ft ftVar = this.e;
        int i2 = ftVar.b;
        if ((i2 == 3 || i2 == 4) && ftVar.c == i) {
            this.e = new ft(1, 0);
            d();
            View view = this.a;
            IBinder applicationWindowToken = view.getApplicationWindowToken();
            InputMethodManager inputMethodManager = this.b;
            inputMethodManager.hideSoftInputFromWindow(applicationWindowToken, 0);
            inputMethodManager.restartInput(view);
            this.i = false;
        }
    }

    public final void c() {
        this.k.o = null;
        this.l.h = null;
        this.d.c = null;
        d();
        this.h.e(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.n;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public final void d() {
        AutofillManager autofillManager;
        qd0 qd0Var;
        j1 j1Var;
        if (Build.VERSION.SDK_INT < 26 || (autofillManager = this.c) == null || (qd0Var = this.f) == null || (j1Var = qd0Var.j) == null || this.g == null) {
            return;
        }
        autofillManager.notifyViewExited(this.a, ((String) j1Var.a).hashCode());
    }

    public final void e(qd0 qd0Var) {
        j1 j1Var;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (qd0Var == null || (j1Var = qd0Var.j) == null) {
            this.g = null;
            return;
        }
        qd0[] qd0VarArr = qd0Var.l;
        SparseArray sparseArray = new SparseArray();
        this.g = sparseArray;
        if (qd0VarArr == null) {
            sparseArray.put(((String) j1Var.a).hashCode(), qd0Var);
            return;
        }
        for (qd0 qd0Var2 : qd0VarArr) {
            j1 j1Var2 = qd0Var2.j;
            if (j1Var2 != null) {
                String str = (String) j1Var2.a;
                this.g.put(str.hashCode(), qd0Var2);
                this.c.notifyValueChanged(this.a, str.hashCode(), AutofillValue.forText(((td0) j1Var2.d).a));
            }
        }
    }
}
