package sensei0;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.view.ContextMenu;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mo implements ComponentCallbacks, View.OnCreateContextMenuListener, tt, t60 {
    public static final Object s = new Object();
    public final int a = -1;
    public final String b = UUID.randomUUID().toString();
    public final ro c = new ro();
    public final boolean d = true;
    public o4 f;
    public final mt h;
    public vt o;
    public s60 p;
    public final ArrayList q;
    public final sv r;

    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object, sensei0.tt] */
    public mo() {
        Object obj;
        n60 n60Var;
        new f5(6, this);
        this.h = mt.f;
        new fy();
        new AtomicInteger();
        this.q = new ArrayList();
        this.r = new sv(26, this);
        this.o = new vt(this);
        this.p = new s60(this);
        ArrayList arrayList = this.q;
        sv svVar = this.r;
        if (arrayList.contains(svVar)) {
            return;
        }
        if (this.a < 0) {
            arrayList.add(svVar);
            return;
        }
        mo moVar = (mo) svVar.b;
        moVar.p.b();
        mt mtVar = moVar.o.c;
        if (mtVar != mt.b && mtVar != mt.c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        r60 r60Var = (r60) moVar.p.c;
        r60Var.getClass();
        Iterator it = ((k60) r60Var.c).iterator();
        while (true) {
            g60 g60Var = (g60) it;
            obj = null;
            if (!g60Var.hasNext()) {
                n60Var = null;
                break;
            }
            Map.Entry entry = (Map.Entry) g60Var.next();
            pr.i("components", entry);
            String str = (String) entry.getKey();
            n60Var = (n60) entry.getValue();
            if (pr.b(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                break;
            }
        }
        if (n60Var == null) {
            n60 n60Var2 = new n60((r60) moVar.p.c, moVar);
            k60 k60Var = (k60) ((r60) moVar.p.c).c;
            h60 h60VarA = k60Var.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
            if (h60VarA != null) {
                obj = h60VarA.b;
            } else {
                h60 h60Var = new h60("androidx.lifecycle.internal.SavedStateHandlesProvider", n60Var2);
                k60Var.d++;
                h60 h60Var2 = k60Var.b;
                if (h60Var2 == null) {
                    k60Var.a = h60Var;
                    k60Var.b = h60Var;
                } else {
                    h60Var2.c = h60Var;
                    h60Var.d = h60Var2;
                    k60Var.b = h60Var;
                }
            }
            if (((n60) obj) != null) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            moVar.o.a(new x30(2, n60Var2));
        }
        s60 s60Var = moVar.p;
        if (!s60Var.a) {
            s60Var.b();
        }
        vt vtVarB = s60Var.b.b();
        if (vtVarB.c.compareTo(mt.d) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + vtVarB.c).toString());
        }
        r60 r60Var2 = (r60) s60Var.c;
        if (!r60Var2.a) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (r60Var2.b) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        r60Var2.d = null;
        r60Var2.b = true;
    }

    @Override // sensei0.t60
    public final r60 a() {
        return (r60) this.p.c;
    }

    @Override // sensei0.tt
    public final vt b() {
        return this.o;
    }

    public final bd c() {
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final ro d() {
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.b);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }
}
