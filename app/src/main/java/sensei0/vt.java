package sensei0;

import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vt extends nt {
    public final boolean a;
    public gk b;
    public mt c;
    public final WeakReference d;
    public int e;
    public boolean f;
    public boolean g;
    public final ArrayList h;
    public final xb0 i;

    public vt(tt ttVar) {
        new AtomicReference();
        this.a = true;
        this.b = new gk();
        mt mtVar = mt.b;
        this.c = mtVar;
        this.h = new ArrayList();
        this.d = new WeakReference(ttVar);
        this.i = new xb0(mtVar);
    }

    @Override // sensei0.nt
    public final void a(st stVar) {
        rt mfVar;
        Object obj;
        tt ttVar;
        pr.j("observer", stVar);
        d("addObserver");
        mt mtVar = this.c;
        mt mtVar2 = mt.a;
        if (mtVar != mtVar2) {
            mtVar2 = mt.b;
        }
        ut utVar = new ut();
        HashMap map = wt.a;
        boolean z = stVar instanceof rt;
        boolean z2 = stVar instanceof DefaultLifecycleObserver;
        int i = 1;
        if (z && z2) {
            mfVar = new mf((DefaultLifecycleObserver) stVar, (rt) stVar);
        } else if (z2) {
            mfVar = new mf((DefaultLifecycleObserver) stVar, null);
        } else if (z) {
            mfVar = (rt) stVar;
        } else {
            Class<?> cls = stVar.getClass();
            if (wt.b(cls) == 2) {
                Object obj2 = wt.b.get(cls);
                pr.f(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    wt.a((Constructor) list.get(0), stVar);
                    throw null;
                }
                int size = list.size();
                yp[] ypVarArr = new yp[size];
                if (size > 0) {
                    wt.a((Constructor) list.get(0), stVar);
                    throw null;
                }
                mfVar = new x30(i, ypVarArr);
            } else {
                mfVar = new mf(stVar);
            }
        }
        utVar.b = mfVar;
        utVar.a = mtVar2;
        gk gkVar = this.b;
        h60 h60VarA = gkVar.a(stVar);
        if (h60VarA != null) {
            obj = h60VarA.b;
        } else {
            HashMap map2 = gkVar.f;
            h60 h60Var = new h60(stVar, utVar);
            gkVar.d++;
            h60 h60Var2 = gkVar.b;
            if (h60Var2 == null) {
                gkVar.a = h60Var;
                gkVar.b = h60Var;
            } else {
                h60Var2.c = h60Var;
                h60Var.d = h60Var2;
                gkVar.b = h60Var;
            }
            map2.put(stVar, h60Var);
            obj = null;
        }
        if (((ut) obj) == null && (ttVar = (tt) this.d.get()) != null) {
            boolean z3 = this.e != 0 || this.f;
            mt mtVarC = c(stVar);
            this.e++;
            while (utVar.a.compareTo(mtVarC) < 0 && this.b.f.containsKey(stVar)) {
                mt mtVar3 = utVar.a;
                ArrayList arrayList = this.h;
                arrayList.add(mtVar3);
                jt jtVar = lt.Companion;
                mt mtVar4 = utVar.a;
                jtVar.getClass();
                pr.j("state", mtVar4);
                int iOrdinal = mtVar4.ordinal();
                lt ltVar = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : lt.ON_RESUME : lt.ON_START : lt.ON_CREATE;
                if (ltVar == null) {
                    throw new IllegalStateException("no event up from " + utVar.a);
                }
                utVar.a(ttVar, ltVar);
                arrayList.remove(arrayList.size() - 1);
                mtVarC = c(stVar);
            }
            if (!z3) {
                f();
            }
            this.e--;
        }
    }

    @Override // sensei0.nt
    public final void b(st stVar) {
        pr.j("observer", stVar);
        d("removeObserver");
        this.b.b(stVar);
    }

    public final mt c(st stVar) {
        HashMap map = this.b.f;
        h60 h60Var = map.containsKey(stVar) ? ((h60) map.get(stVar)).d : null;
        mt mtVar = h60Var != null ? ((ut) h60Var.b).a : null;
        ArrayList arrayList = this.h;
        mt mtVar2 = arrayList.isEmpty() ? null : (mt) arrayList.get(arrayList.size() - 1);
        mt mtVar3 = this.c;
        pr.j("state1", mtVar3);
        if (mtVar == null || mtVar.compareTo(mtVar3) >= 0) {
            mtVar = mtVar3;
        }
        return (mtVar2 == null || mtVar2.compareTo(mtVar) >= 0) ? mtVar : mtVar2;
    }

    public final void d(String str) {
        if (this.a) {
            ((p4) p4.K().f).getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(za0.l("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void e(lt ltVar) {
        pr.j("event", ltVar);
        d("handleLifecycleEvent");
        mt mtVarA = ltVar.a();
        mt mtVar = this.c;
        if (mtVar == mtVarA) {
            return;
        }
        mt mtVar2 = mt.b;
        mt mtVar3 = mt.a;
        if (mtVar == mtVar2 && mtVarA == mtVar3) {
            throw new IllegalStateException(("no event down from " + this.c + " in component " + this.d.get()).toString());
        }
        this.c = mtVarA;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        f();
        this.f = false;
        if (this.c == mtVar3) {
            this.b = new gk();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r12.g = false;
        r0 = r12.c;
        r1 = r12.i;
        r1.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
    
        r0 = sensei0.pr.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
    
        r1.a(null, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f() {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.vt.f():void");
    }
}
