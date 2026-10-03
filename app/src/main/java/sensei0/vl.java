package sensei0;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.window.OnBackInvokedCallback;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vl extends Activity implements yl, tt {
    public static final int f = View.generateViewId();
    public boolean a = false;
    public zl b;
    public final vt c;
    public final OnBackInvokedCallback d;

    public vl() {
        int i = Build.VERSION.SDK_INT;
        this.d = i < 33 ? null : i >= 34 ? new ul(this) : new tl(0, this);
        this.c = new vt(this);
    }

    @Override // sensei0.tt
    public final vt b() {
        return this.c;
    }

    public final String c() {
        String dataString;
        if ((getApplicationInfo().flags & 2) == 0 || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            return null;
        }
        return dataString;
    }

    public final int d() {
        if (!getIntent().hasExtra("background_mode")) {
            return 1;
        }
        String stringExtra = getIntent().getStringExtra("background_mode");
        if (stringExtra == null) {
            throw new NullPointerException("Name is null");
        }
        if (stringExtra.equals("opaque")) {
            return 1;
        }
        if (stringExtra.equals("transparent")) {
            return 2;
        }
        throw new IllegalArgumentException("No enum constant io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.".concat(stringExtra));
    }

    public final String e() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    public final String f() {
        if (getIntent().hasExtra("dart_entrypoint")) {
            return getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            Bundle bundleH = h();
            String string = bundleH != null ? bundleH.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    public final String g() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle bundleH = h();
            if (bundleH != null) {
                return bundleH.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final Bundle h() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public final void i(boolean z) {
        if (z && !this.a) {
            if (Build.VERSION.SDK_INT >= 33) {
                getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.d);
                this.a = true;
                return;
            }
            return;
        }
        if (z || !this.a || Build.VERSION.SDK_INT < 33) {
            return;
        }
        getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.d);
        this.a = false;
    }

    public final boolean j() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (e() != null || this.b.g) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    public final boolean k() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : e() == null;
    }

    public final boolean l(String str) {
        zl zlVar = this.b;
        if (zlVar == null) {
            Log.w("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after release.");
            return false;
        }
        if (zlVar.j) {
            return true;
        }
        Log.w("FlutterActivity", "FlutterActivity " + hashCode() + " " + str + " called after detach.");
        return false;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (l("onActivityResult")) {
            zl zlVar = this.b;
            zlVar.c();
            if (zlVar.b == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            Objects.toString(intent);
            zf zfVar = zlVar.b.d;
            if (!zfVar.f()) {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
                return;
            }
            df0.b("FlutterEngineConnectionRegistry#onActivityResult");
            try {
                af0 af0Var = (af0) zfVar.h;
                af0Var.getClass();
                Iterator it = new HashSet((HashSet) af0Var.d).iterator();
                while (true) {
                    boolean z = false;
                    while (it.hasNext()) {
                        if (((r10) it.next()).a(i, i2, intent) || z) {
                            z = true;
                        }
                    }
                    Trace.endSection();
                    return;
                }
            } catch (Throwable th) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        if (l("onBackPressed")) {
            zl zlVar = this.b;
            zlVar.c();
            em emVar = zlVar.b;
            if (emVar != null) {
                emVar.i.a.a("popRoute", null, null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0507  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0613 A[LOOP:1: B:226:0x060d->B:228:0x0613, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0628 A[LOOP:2: B:230:0x0622->B:232:0x0628, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x063d A[LOOP:3: B:234:0x0637->B:236:0x063d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0658 A[LOOP:4: B:238:0x0652->B:240:0x0658, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x066c A[LOOP:5: B:241:0x0666->B:243:0x066c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x06e5  */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.view.View, sensei0.f50] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r18) {
        /*
            Method dump skipped, instruction units count: 1787
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.vl.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (l("onDestroy")) {
            this.b.e();
            this.b.f();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.d);
            this.a = false;
        }
        zl zlVar = this.b;
        if (zlVar != null) {
            zlVar.a = null;
            zlVar.b = null;
            zlVar.c = null;
            zlVar.d = null;
            zlVar.e = null;
            this.b = null;
        }
        this.c.e(lt.ON_DESTROY);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (l("onNewIntent")) {
            zl zlVar = this.b;
            zlVar.c();
            em emVar = zlVar.b;
            if (emVar == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            zf zfVar = emVar.d;
            if (zfVar.f()) {
                df0.b("FlutterEngineConnectionRegistry#onNewIntent");
                try {
                    Iterator it = ((HashSet) ((af0) zfVar.h).e).iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                    Trace.endSection();
                } catch (Throwable th) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            }
            String strD = zlVar.d(intent);
            if (strD == null || strD.isEmpty()) {
                return;
            }
            h5 h5Var = zlVar.b.i;
            h5Var.getClass();
            HashMap map = new HashMap();
            map.put("location", strD);
            h5Var.a.a("pushRouteInformation", map, null);
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        if (l("onPause")) {
            zl zlVar = this.b;
            zlVar.c();
            zlVar.a.getClass();
            em emVar = zlVar.b;
            if (emVar != null) {
                ot otVar = emVar.g;
                otVar.a(3, otVar.c);
            }
        }
        this.c.e(lt.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        if (l("onPostResume")) {
            zl zlVar = this.b;
            zlVar.c();
            if (zlVar.b == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            b10 b10Var = zlVar.d;
            if (b10Var != null) {
                b10Var.b();
            }
            zlVar.b.s.j();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (l("onRequestPermissionsResult")) {
            zl zlVar = this.b;
            zlVar.c();
            if (zlVar.b == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            Arrays.toString(strArr);
            Arrays.toString(iArr);
            zf zfVar = zlVar.b.d;
            if (!zfVar.f()) {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
                return;
            }
            df0.b("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
            try {
                Iterator it = ((HashSet) ((af0) zfVar.h).c).iterator();
                if (!it.hasNext()) {
                    Trace.endSection();
                } else {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.e(lt.ON_RESUME);
        if (l("onResume")) {
            zl zlVar = this.b;
            zlVar.c();
            zlVar.b.b.i();
            zlVar.a.getClass();
            em emVar = zlVar.b;
            if (emVar != null) {
                ot otVar = emVar.g;
                otVar.a(2, otVar.c);
            }
        }
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (l("onSaveInstanceState")) {
            zl zlVar = this.b;
            zlVar.c();
            if (zlVar.a.k()) {
                bundle.putByteArray("framework", (byte[]) zlVar.b.k.d);
            }
            zlVar.a.getClass();
            Bundle bundle2 = new Bundle();
            zf zfVar = zlVar.b.d;
            if (zfVar.f()) {
                df0.b("FlutterEngineConnectionRegistry#onSaveInstanceState");
                try {
                    Iterator it = ((HashSet) ((af0) zfVar.h).g).iterator();
                    if (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                    Trace.endSection();
                } catch (Throwable th) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            }
            bundle.putBundle("plugins", bundle2);
            if (zlVar.a.e() == null || zlVar.a.j()) {
                return;
            }
            bundle.putBoolean("enableOnBackInvokedCallbackState", zlVar.a.a);
        }
    }

    @Override // android.app.Activity
    public final void onStart() {
        Bundle bundleH;
        super.onStart();
        this.c.e(lt.ON_START);
        if (l("onStart")) {
            zl zlVar = this.b;
            zlVar.c();
            if (zlVar.a.e() == null && !zlVar.b.c.h) {
                String strG = zlVar.a.g();
                if (strG == null) {
                    vl vlVar = zlVar.a;
                    vlVar.getClass();
                    strG = zlVar.d(vlVar.getIntent());
                    if (strG == null) {
                        strG = "/";
                    }
                }
                vl vlVar2 = zlVar.a;
                vlVar2.getClass();
                try {
                    bundleH = vlVar2.h();
                } catch (PackageManager.NameNotFoundException unused) {
                }
                String string = bundleH != null ? bundleH.getString("io.flutter.EntrypointUri") : null;
                zlVar.a.f();
                zlVar.b.i.a.a("setInitialRoute", strG, null);
                String strC = zlVar.a.c();
                if (strC == null || strC.isEmpty()) {
                    strC = (String) ((um) o4.O().b).e.c;
                }
                zlVar.b.c.a(string == null ? new jd(strC, zlVar.a.f()) : new jd(strC, string, zlVar.a.f()), (List) zlVar.a.getIntent().getSerializableExtra("dart_entrypoint_args"));
            }
            Integer num = zlVar.k;
            if (num != null) {
                zlVar.c.setVisibility(num.intValue());
            }
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        if (l("onStop")) {
            zl zlVar = this.b;
            zlVar.c();
            zlVar.a.getClass();
            em emVar = zlVar.b;
            if (emVar != null) {
                ot otVar = emVar.g;
                otVar.a(5, otVar.c);
            }
            zlVar.k = Integer.valueOf(zlVar.c.getVisibility());
            zlVar.c.setVisibility(8);
            em emVar2 = zlVar.b;
            if (emVar2 != null) {
                emVar2.b.f(40);
            }
        }
        this.c.e(lt.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (l("onTrimMemory")) {
            zl zlVar = this.b;
            zlVar.c();
            em emVar = zlVar.b;
            if (emVar != null) {
                if (zlVar.i && i >= 10) {
                    FlutterJNI flutterJNI = emVar.c.a;
                    if (flutterJNI.isAttached()) {
                        flutterJNI.notifyLowMemoryWarning();
                    }
                    vs vsVar = zlVar.b.q;
                    vsVar.getClass();
                    HashMap map = new HashMap(1);
                    map.put("type", "memoryPressure");
                    vsVar.a.k(map, null);
                }
                zlVar.b.b.f(i);
                io.flutter.plugin.platform.c cVar = zlVar.b.s;
                if (i < 40) {
                    cVar.getClass();
                    return;
                }
                Iterator it = cVar.r.values().iterator();
                while (it.hasNext()) {
                    ((io.flutter.plugin.platform.d) it.next()).h.setSurface(null);
                }
            }
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        if (l("onUserLeaveHint")) {
            zl zlVar = this.b;
            zlVar.c();
            em emVar = zlVar.b;
            if (emVar == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
                return;
            }
            zf zfVar = emVar.d;
            if (!zfVar.f()) {
                Log.e("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
                return;
            }
            df0.b("FlutterEngineConnectionRegistry#onUserLeaveHint");
            try {
                Iterator it = ((HashSet) ((af0) zfVar.h).f).iterator();
                if (!it.hasNext()) {
                    Trace.endSection();
                } else {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (l("onWindowFocusChanged")) {
            zl zlVar = this.b;
            zlVar.c();
            zlVar.a.getClass();
            em emVar = zlVar.b;
            if (emVar != null) {
                ot otVar = emVar.g;
                if (z) {
                    otVar.a(otVar.a, true);
                } else {
                    otVar.a(otVar.a, false);
                }
            }
        }
    }
}
