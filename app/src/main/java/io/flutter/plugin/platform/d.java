package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.view.View;
import sensei0.cj0;
import sensei0.e10;
import sensei0.g10;
import sensei0.n10;
import sensei0.q0;
import sensei0.vl;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final cj0 i = new cj0();
    public SingleViewPresentation a;
    public final Context b;
    public final q0 c;
    public final int d;
    public final int e;
    public final g10 f;
    public final n10 g;
    public VirtualDisplay h;

    public d(vl vlVar, q0 q0Var, VirtualDisplay virtualDisplay, e10 e10Var, g10 g10Var, n10 n10Var, int i2) {
        this.b = vlVar;
        this.c = q0Var;
        this.f = g10Var;
        this.g = n10Var;
        this.e = i2;
        this.h = virtualDisplay;
        this.d = vlVar.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(vlVar, this.h.getDisplay(), e10Var, q0Var, i2, n10Var);
        this.a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public final View a() {
        SingleViewPresentation singleViewPresentation = this.a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }
}
