package sensei0;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w60 {
    public static final Class a;
    public static final og0 b;
    public static final og0 c;

    static {
        Class<?> cls;
        Class<?> cls2;
        e30 e30Var = e30.c;
        og0 og0Var = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            e30 e30Var2 = e30.c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                og0Var = (og0) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        b = og0Var;
        c = new og0();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iB0 = 0;
        for (int i = 0; i < size; i++) {
            iB0 += m9.B0(((Integer) list.get(i)).intValue());
        }
        return iB0;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m9.z0(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (m9.z0(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iB0 = 0;
        for (int i = 0; i < size; i++) {
            iB0 += m9.B0(((Integer) list.get(i)).intValue());
        }
        return iB0;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iB0 = 0;
        for (int i = 0; i < size; i++) {
            iB0 += m9.B0(((Long) list.get(i)).longValue());
        }
        return iB0;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA0 = 0;
        for (int i = 0; i < size; i++) {
            int iIntValue = ((Integer) list.get(i)).intValue();
            iA0 += m9.A0((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return iA0;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iB0 = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iB0 += m9.B0((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iB0;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA0 = 0;
        for (int i = 0; i < size; i++) {
            iA0 += m9.A0(((Integer) list.get(i)).intValue());
        }
        return iA0;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iB0 = 0;
        for (int i = 0; i < size; i++) {
            iB0 += m9.B0(((Long) list.get(i)).longValue());
        }
        return iB0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void k(og0 og0Var, Object obj, Object obj2) {
        og0Var.getClass();
        cq cqVar = (cq) obj;
        ng0 ng0Var = cqVar.unknownFields;
        ng0 ng0Var2 = ((cq) obj2).unknownFields;
        ng0 ng0Var3 = ng0.f;
        if (!ng0Var3.equals(ng0Var2)) {
            if (ng0Var3.equals(ng0Var)) {
                int i = ng0Var.a + ng0Var2.a;
                int[] iArrCopyOf = Arrays.copyOf(ng0Var.b, i);
                System.arraycopy(ng0Var2.b, 0, iArrCopyOf, ng0Var.a, ng0Var2.a);
                Object[] objArrCopyOf = Arrays.copyOf(ng0Var.c, i);
                System.arraycopy(ng0Var2.c, 0, objArrCopyOf, ng0Var.a, ng0Var2.a);
                ng0Var = new ng0(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                ng0Var.getClass();
                if (!ng0Var2.equals(ng0Var3)) {
                    if (!ng0Var.e) {
                        throw new UnsupportedOperationException();
                    }
                    int i2 = ng0Var.a + ng0Var2.a;
                    ng0Var.a(i2);
                    System.arraycopy(ng0Var2.b, 0, ng0Var.b, ng0Var.a, ng0Var2.a);
                    System.arraycopy(ng0Var2.c, 0, ng0Var.c, ng0Var.a, ng0Var2.a);
                    ng0Var.a = i2;
                }
            }
        }
        cqVar.unknownFields = ng0Var;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void m(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.G0(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            Logger logger = m9.q;
            i3++;
        }
        m9Var.U0(i3);
        while (i2 < list.size()) {
            m9Var.E0(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void n(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                double dDoubleValue = ((Double) list.get(i2)).doubleValue();
                m9Var.getClass();
                m9Var.L0(i, Double.doubleToRawLongBits(dDoubleValue));
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            Logger logger = m9.q;
            i3 += 8;
        }
        m9Var.U0(i3);
        while (i2 < list.size()) {
            m9Var.M0(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void o(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.N0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int iB0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB0 += m9.B0(((Integer) list.get(i3)).intValue());
        }
        m9Var.U0(iB0);
        while (i2 < list.size()) {
            m9Var.O0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void p(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.J0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = m9.q;
            i3 += 4;
        }
        m9Var.U0(i3);
        while (i2 < list.size()) {
            m9Var.K0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void q(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.L0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = m9.q;
            i3 += 8;
        }
        m9Var.U0(i3);
        while (i2 < list.size()) {
            m9Var.M0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void r(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                float fFloatValue = ((Float) list.get(i2)).floatValue();
                m9Var.getClass();
                m9Var.J0(i, Float.floatToRawIntBits(fFloatValue));
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            Logger logger = m9.q;
            i3 += 4;
        }
        m9Var.U0(i3);
        while (i2 < list.size()) {
            m9Var.K0(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void s(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.N0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int iB0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB0 += m9.B0(((Integer) list.get(i3)).intValue());
        }
        m9Var.U0(iB0);
        while (i2 < list.size()) {
            m9Var.O0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void t(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.V0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int iB0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB0 += m9.B0(((Long) list.get(i3)).longValue());
        }
        m9Var.U0(iB0);
        while (i2 < list.size()) {
            m9Var.W0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void u(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.J0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            Logger logger = m9.q;
            i3 += 4;
        }
        m9Var.U0(i3);
        while (i2 < list.size()) {
            m9Var.K0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void v(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.L0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            Logger logger = m9.q;
            i3 += 8;
        }
        m9Var.U0(i3);
        while (i2 < list.size()) {
            m9Var.M0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void w(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                m9Var.T0(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int iA0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int iIntValue2 = ((Integer) list.get(i3)).intValue();
            iA0 += m9.A0((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        m9Var.U0(iA0);
        while (i2 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            m9Var.U0((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i2++;
        }
    }

    public static void x(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                m9Var.V0(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int iB0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iB0 += m9.B0((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        m9Var.U0(iB0);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            m9Var.W0((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i2++;
        }
    }

    public static void y(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.T0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int iA0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iA0 += m9.A0(((Integer) list.get(i3)).intValue());
        }
        m9Var.U0(iA0);
        while (i2 < list.size()) {
            m9Var.U0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void z(int i, List list, sv svVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        m9 m9Var = (m9) svVar.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                m9Var.V0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        m9Var.S0(i, 2);
        int iB0 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iB0 += m9.B0(((Long) list.get(i3)).longValue());
        }
        m9Var.U0(iB0);
        while (i2 < list.size()) {
            m9Var.W0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static Object j(Object obj, int i, lr lrVar, Object obj2, og0 og0Var) {
        return obj2;
    }
}
