package sensei0;

import android.content.Context;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u90 {
    public static final /* synthetic */ ps[] a = {new c30(v6.a, u90.class, "sharedPreferencesDataStore", "getSharedPreferencesDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;")};
    public static final z10 b;

    static {
        z9 z9Var;
        nc ncVar = nc.h;
        lc lcVarJ = kg.b;
        rc0 rc0Var = new rc0();
        lcVarJ.getClass();
        oi oiVar = oi.a;
        if (rc0Var != oiVar) {
            lc lcVarC = lcVarJ.c(rc0Var.getKey());
            if (lcVarC == oiVar) {
                lcVarJ = rc0Var;
            } else {
                mh mhVar = mh.c;
                zb zbVar = (zb) lcVarC.n(mhVar);
                if (zbVar == null) {
                    z9Var = new z9(lcVarC, rc0Var);
                } else {
                    lc lcVarC2 = lcVarC.c(mhVar);
                    if (lcVarC2 == oiVar) {
                        lcVarJ = new z9(rc0Var, zbVar);
                    } else {
                        z9Var = new z9(new z9(lcVarC2, rc0Var), zbVar);
                    }
                }
                lcVarJ = z9Var;
            }
        }
        if (lcVarJ.n(mh.p) == null) {
            lcVarJ = lcVarJ.j(new es());
        }
        b = new z10(ncVar, new vb(lcVarJ));
    }

    public static final ws a(Context context) {
        ws wsVar;
        pr.j("<this>", context);
        z10 z10Var = b;
        ps psVar = a[0];
        z10Var.getClass();
        pr.j("property", psVar);
        ws wsVar2 = z10Var.d;
        if (wsVar2 != null) {
            return wsVar2;
        }
        synchronized (z10Var.c) {
            try {
                if (z10Var.d == null) {
                    Context applicationContext = context.getApplicationContext();
                    fp fpVar = z10Var.a;
                    pr.i("applicationContext", applicationContext);
                    List list = (List) fpVar.g(applicationContext);
                    uc ucVar = z10Var.b;
                    y10 y10Var = new y10(0, applicationContext, z10Var);
                    pr.j("migrations", list);
                    ve veVar = new ve(new wk(new vk(1, y10Var)), k6.G(new a7(list, (xb) null, 3)), new pf(28), ucVar);
                    z10Var.d = new ws(17, new ws(17, veVar));
                }
                wsVar = z10Var.d;
                pr.f(wsVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return wsVar;
    }

    public static final boolean b(String str, Object obj, Set set) {
        pr.j("key", str);
        return set == null ? (obj instanceof Boolean) || (obj instanceof Long) || (obj instanceof String) || (obj instanceof Double) : set.contains(str);
    }

    public static final Object c(Object obj, pf pfVar) {
        if (!(obj instanceof String)) {
            return obj;
        }
        String str = (String) obj;
        if (nc0.d0(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu", false)) {
            if (nc0.d0(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!", false)) {
                return obj;
            }
            String strSubstring = str.substring(40);
            pr.i("substring(...)", strSubstring);
            return pfVar.a(strSubstring);
        }
        if (!nc0.d0(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu", false)) {
            return obj;
        }
        String strSubstring2 = str.substring(40);
        pr.i("substring(...)", strSubstring2);
        return Double.valueOf(Double.parseDouble(strSubstring2));
    }
}
