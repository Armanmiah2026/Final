package sensei0;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class p20 implements xm, l2, r10 {
    public final PackageManager a;
    public af0 b;
    public HashMap c;
    public final HashMap d = new HashMap();

    public p20(i3 i3Var) {
        this.a = (PackageManager) i3Var.b;
        i3Var.c = this;
    }

    @Override // sensei0.r10
    public final boolean a(int i, int i2, Intent intent) {
        Integer numValueOf = Integer.valueOf(i);
        HashMap map = this.d;
        if (!map.containsKey(numValueOf)) {
            return false;
        }
        ((rk) map.remove(Integer.valueOf(i))).d(i2 == -1 ? intent.getStringExtra("android.intent.extra.PROCESS_TEXT") : null);
        return true;
    }

    @Override // sensei0.l2
    public final void b() {
        ((HashSet) this.b.d).remove(this);
        this.b = null;
    }

    @Override // sensei0.l2
    public final void c(af0 af0Var) {
        this.b = af0Var;
        ((HashSet) af0Var.d).add(this);
    }

    @Override // sensei0.l2
    public final void d(af0 af0Var) {
        this.b = af0Var;
        ((HashSet) af0Var.d).add(this);
    }

    @Override // sensei0.l2
    public final void f() {
        ((HashSet) this.b.d).remove(this);
        this.b = null;
    }

    public final void h(String str, String str2, boolean z, rk rkVar) {
        if (this.b == null) {
            rkVar.a("error", "Plugin not bound to an Activity", null);
            return;
        }
        HashMap map = this.c;
        if (map == null) {
            rkVar.a("error", "Can not process text actions before calling queryTextActions", null);
            return;
        }
        ResolveInfo resolveInfo = (ResolveInfo) map.get(str);
        if (resolveInfo == null) {
            rkVar.a("error", "Text processing activity not found", null);
            return;
        }
        int iHashCode = rkVar.hashCode();
        this.d.put(Integer.valueOf(iHashCode), rkVar);
        Intent intent = new Intent();
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.setAction("android.intent.action.PROCESS_TEXT");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.PROCESS_TEXT", str2);
        intent.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", z);
        ((Activity) this.b.a).startActivityForResult(intent, iHashCode);
    }

    public final HashMap i() {
        HashMap map = this.c;
        PackageManager packageManager = this.a;
        if (map == null) {
            this.c = new HashMap();
            Intent type = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
            for (ResolveInfo resolveInfo : Build.VERSION.SDK_INT >= 33 ? packageManager.queryIntentActivities(type, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.queryIntentActivities(type, 0)) {
                this.c.put(resolveInfo.activityInfo.name, resolveInfo);
            }
        }
        HashMap map2 = new HashMap();
        for (String str : this.c.keySet()) {
            map2.put(str, ((ResolveInfo) this.c.get(str)).loadLabel(packageManager).toString());
        }
        return map2;
    }

    @Override // sensei0.xm
    public final void e(j1 j1Var) {
    }

    @Override // sensei0.xm
    public final void g(j1 j1Var) {
    }
}
