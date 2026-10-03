package sensei0;

import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class x30 implements rt {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ x30(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, sensei0.t60] */
    @Override // sensei0.rt
    public final void f(tt ttVar, lt ltVar) {
        switch (this.a) {
            case 0:
                if (ltVar != lt.ON_CREATE) {
                    throw new AssertionError("Next event must be ON_CREATE");
                }
                ttVar.b().b(this);
                Bundle bundleA = this.b.a().a("androidx.savedstate.Restarter");
                if (bundleA == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundleA.getStringArrayList("classes_to_restore");
                if (stringArrayList == null) {
                    throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                }
                Iterator<String> it = stringArrayList.iterator();
                if (it.hasNext()) {
                    String next = it.next();
                    try {
                        Class<? extends U> clsAsSubclass = Class.forName(next, false, x30.class.getClassLoader()).asSubclass(q60.class);
                        pr.i("{\n                Class.…class.java)\n            }", clsAsSubclass);
                        try {
                            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                            declaredConstructor.setAccessible(true);
                            try {
                                pr.i("{\n                constr…wInstance()\n            }", declaredConstructor.newInstance(null));
                                throw new ClassCastException();
                            } catch (Exception e) {
                                throw new RuntimeException(za0.s("Failed to instantiate ", next), e);
                            }
                        } catch (NoSuchMethodException e2) {
                            throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                        }
                    } catch (ClassNotFoundException e3) {
                        throw new RuntimeException(za0.l("Class ", next, " wasn't found"), e3);
                    }
                }
                return;
            case 1:
                new HashMap();
                yp[] ypVarArr = (yp[]) this.b;
                if (ypVarArr.length > 0) {
                    yp ypVar = ypVarArr[0];
                    throw null;
                }
                if (ypVarArr.length <= 0) {
                    return;
                }
                yp ypVar2 = ypVarArr[0];
                throw null;
            default:
                if (ltVar != lt.ON_CREATE) {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + ltVar).toString());
                }
                ttVar.b().b(this);
                n60 n60Var = (n60) this.b;
                if (n60Var.b) {
                    return;
                }
                Bundle bundleA2 = n60Var.a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
                Bundle bundle = new Bundle();
                Bundle bundle2 = n60Var.c;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                if (bundleA2 != null) {
                    bundle.putAll(bundleA2);
                }
                n60Var.c = bundle;
                n60Var.b = true;
                return;
        }
    }
}
