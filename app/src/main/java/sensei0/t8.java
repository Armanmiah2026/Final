package sensei0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t8 implements ns, r8 {
    public static final Map b;
    public final Class a;

    static {
        Map mapD0;
        List listF0 = p9.f0(uo.class, fp.class, jp.class, kp.class, lp.class, mp.class, np.class, op.class, pp.class, qp.class, vo.class, wo.class, xo.class, yo.class, zo.class, ap.class, bp.class, cp.class, dp.class, ep.class, gp.class, hp.class, ip.class);
        ArrayList arrayList = new ArrayList(q9.h0(listF0));
        int i = 0;
        int i2 = 0;
        for (Object obj : listF0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new qz((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        int size = arrayList.size();
        if (size == 0) {
            mapD0 = ri.a;
        } else if (size != 1) {
            mapD0 = new LinkedHashMap(xv.c0(arrayList.size()));
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj2 = arrayList.get(i);
                i++;
                qz qzVar = (qz) obj2;
                mapD0.put(qzVar.a, qzVar.b);
            }
        } else {
            mapD0 = xv.d0((qz) arrayList.get(0));
        }
        b = mapD0;
    }

    public t8(Class cls) {
        pr.j("jClass", cls);
        this.a = cls;
    }

    @Override // sensei0.r8
    public final Class a() {
        return this.a;
    }

    public final String b() {
        String strE;
        Class cls = this.a;
        pr.j("jClass", cls);
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String strE2 = wf0.E(cls.getName());
                return strE2 == null ? cls.getSimpleName() : strE2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (strE = wf0.E(componentType.getName())) != null) {
                strConcat = strE.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return fc0.w0(simpleName, enclosingMethod.getName() + '$', simpleName);
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            return fc0.v0(simpleName, '$', simpleName);
        }
        return fc0.w0(simpleName, enclosingConstructor.getName() + '$', simpleName);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof t8) && k6.z(this).equals(k6.z((ns) obj));
    }

    public final int hashCode() {
        return k6.z(this).hashCode();
    }

    public final String toString() {
        return this.a.toString() + " (Kotlin reflection is not available)";
    }
}
