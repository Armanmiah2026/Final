package sensei0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class em implements ni0 {
    public static long y = 1;
    public static final HashMap z = new HashMap();
    public final FlutterJNI a;
    public final io.flutter.embedding.engine.renderer.e b;
    public final kd c;
    public final zf d;
    public final vu e;
    public final o4 f;
    public final ot g;
    public final ws h;
    public final h5 i;
    public final h5 j;
    public final n3 k;
    public final i3 l;
    public final ws m;
    public final ws n;
    public final a80 o;
    public final fb0 p;
    public final vs q;
    public final i3 r;
    public final io.flutter.plugin.platform.c s;
    public final q10 t;
    public final i3 u;
    public final long w;
    public final HashSet v = new HashSet();
    public final cm x = new cm(this);

    public em(Context context, FlutterJNI flutterJNI, io.flutter.plugin.platform.c cVar, boolean z2, boolean z3) throws Exception {
        AssetManager assets;
        long j = y;
        y = 1 + j;
        this.w = j;
        z.put(Long.valueOf(j), this);
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        o4 o4VarO = o4.O();
        if (flutterJNI == null) {
            Object obj = o4VarO.c;
            flutterJNI = new FlutterJNI();
        }
        this.a = flutterJNI;
        kd kdVar = new kd(flutterJNI, assets, this.w);
        this.c = kdVar;
        flutterJNI.setPlatformMessageHandler(kdVar.d);
        o4.O().getClass();
        this.f = new o4(kdVar, flutterJNI);
        new pf(kdVar);
        this.g = new ot(kdVar);
        i3 i3Var = new i3(kdVar, 16);
        this.h = new ws(kdVar, 9);
        this.i = new h5(kdVar, 1);
        this.j = new h5(kdVar, 0);
        this.l = new i3(kdVar, 21);
        i3 i3Var2 = new i3(kdVar, context.getPackageManager());
        aj ajVar = new aj(kdVar, "flutter/restoration", sb0.a);
        n3 n3Var = new n3();
        n3Var.b = false;
        n3Var.c = false;
        ws wsVar = new ws(21, n3Var);
        n3Var.e = ajVar;
        n3Var.a = z3;
        ajVar.b(wsVar);
        this.k = n3Var;
        this.m = new ws(kdVar, 24);
        this.n = new ws(kdVar, 26);
        a80 a80Var = new a80(kdVar);
        this.o = a80Var;
        fb0 fb0Var = new fb0();
        new aj(kdVar, "flutter/spellcheck", sb0.a).b(new ws(29, fb0Var));
        this.p = fb0Var;
        this.q = new vs(kdVar);
        this.r = new i3(kdVar, 28);
        vu vuVar = new vu(context, i3Var);
        this.e = vuVar;
        um umVar = (um) o4VarO.b;
        if (!flutterJNI.isAttached()) {
            umVar.d(context.getApplicationContext());
            umVar.a(context, null);
        }
        q10 q10Var = new q10();
        q10Var.a = cVar.a;
        q10Var.f = flutterJNI;
        cVar.f = flutterJNI;
        flutterJNI.addEngineLifecycleListener(this.x);
        flutterJNI.setPlatformViewsController(cVar);
        flutterJNI.setPlatformViewsController2(q10Var);
        flutterJNI.setLocalizationPlugin(vuVar);
        o4VarO.getClass();
        flutterJNI.setDeferredComponentManager(null);
        flutterJNI.setSettingsChannel(a80Var);
        if (!flutterJNI.isAttached()) {
            flutterJNI.attachToNative();
            if (!flutterJNI.isAttached()) {
                throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
            }
        }
        this.b = new io.flutter.embedding.engine.renderer.e(flutterJNI);
        this.s = cVar;
        this.t = q10Var;
        i3 i3Var3 = new i3(24, false);
        i3Var3.b = cVar;
        i3Var3.c = q10Var;
        this.u = i3Var3;
        zf zfVar = new zf(context.getApplicationContext(), this, umVar);
        this.d = zfVar;
        vuVar.b(context.getResources().getConfiguration());
        if (z2) {
            Objects.requireNonNull(umVar.e);
            wf0.w(this);
        }
        ri0.a(context, this);
        zfVar.a(new p20(i3Var2));
    }
}
