package sensei0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cq extends n {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, cq> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected ng0 unknownFields;

    public cq() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ng0.f;
    }

    public static cq d(Class cls) {
        cq cqVar = defaultInstanceMap.get(cls);
        if (cqVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                cqVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (cqVar != null) {
            return cqVar;
        }
        cq cqVar2 = (cq) ((cq) wg0.d(cls)).c(6);
        if (cqVar2 == null) {
            throw new IllegalStateException();
        }
        defaultInstanceMap.put(cls, cqVar2);
        return cqVar2;
    }

    public static Object e(Method method, cq cqVar, Object... objArr) {
        try {
            return method.invoke(cqVar, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final boolean f(cq cqVar, boolean z) {
        byte bByteValue = ((Byte) cqVar.c(1)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        e30 e30Var = e30.c;
        e30Var.getClass();
        boolean zG = e30Var.a(cqVar.getClass()).g(cqVar);
        if (z) {
            cqVar.c(2);
        }
        return zG;
    }

    public static void j(Class cls, cq cqVar) {
        cqVar.h();
        defaultInstanceMap.put(cls, cqVar);
    }

    @Override // sensei0.n
    public final int a(v60 v60Var) {
        int iH;
        int iH2;
        if (g()) {
            if (v60Var == null) {
                e30 e30Var = e30.c;
                e30Var.getClass();
                iH2 = e30Var.a(getClass()).h(this);
            } else {
                iH2 = v60Var.h(this);
            }
            if (iH2 >= 0) {
                return iH2;
            }
            throw new IllegalStateException(za0.h(iH2, "serialized size must be non-negative, was "));
        }
        int i = this.memoizedSerializedSize;
        if ((i & Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i & Integer.MAX_VALUE;
        }
        if (v60Var == null) {
            e30 e30Var2 = e30.c;
            e30Var2.getClass();
            iH = e30Var2.a(getClass()).h(this);
        } else {
            iH = v60Var.h(this);
        }
        k(iH);
        return iH;
    }

    @Override // sensei0.n
    public final void b(m9 m9Var) {
        e30 e30Var = e30.c;
        e30Var.getClass();
        v60 v60VarA = e30Var.a(getClass());
        sv svVar = m9Var.l;
        if (svVar == null) {
            svVar = new sv(m9Var);
        }
        v60VarA.b(this, svVar);
    }

    public abstract Object c(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e30 e30Var = e30.c;
        e30Var.getClass();
        return e30Var.a(getClass()).f(this, (cq) obj);
    }

    public final boolean g() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    public final void h() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    public final int hashCode() {
        if (g()) {
            e30 e30Var = e30.c;
            e30Var.getClass();
            return e30Var.a(getClass()).c(this);
        }
        if (this.memoizedHashCode == 0) {
            e30 e30Var2 = e30.c;
            e30Var2.getClass();
            this.memoizedHashCode = e30Var2.a(getClass()).c(this);
        }
        return this.memoizedHashCode;
    }

    public final cq i() {
        return (cq) c(4);
    }

    public final void k(int i) {
        if (i < 0) {
            throw new IllegalStateException(za0.h(i, "serialized size must be non-negative, was "));
        }
        this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = fx.a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        fx.c(this, sb, 0);
        return sb.toString();
    }
}
