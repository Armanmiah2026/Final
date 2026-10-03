package sensei0;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class wg0 {
    public static final Unsafe a;
    public static final Class b;
    public static final vg0 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    static {
        Unsafe unsafeI = i();
        a = unsafeI;
        b = p2.a;
        boolean zH = h(Long.TYPE);
        boolean zH2 = h(Integer.TYPE);
        vg0 ug0Var = null;
        if (unsafeI != null) {
            if (!p2.a()) {
                ug0Var = new ug0(unsafeI);
            } else if (zH) {
                ug0Var = new tg0(unsafeI, 1);
            } else if (zH2) {
                ug0Var = new tg0(unsafeI, 0);
            }
        }
        c = ug0Var;
        d = ug0Var == null ? false : ug0Var.r();
        e = ug0Var == null ? false : ug0Var.q();
        f = e(byte[].class);
        e(boolean[].class);
        f(boolean[].class);
        e(int[].class);
        f(int[].class);
        e(long[].class);
        f(long[].class);
        e(float[].class);
        f(float[].class);
        e(double[].class);
        f(double[].class);
        e(Object[].class);
        f(Object[].class);
        Field fieldG = g();
        if (fieldG != null && ug0Var != null) {
            ug0Var.i(fieldG);
        }
        g = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static void a(Throwable th) {
        Logger.getLogger(wg0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(long j, Object obj) {
        return ((byte) ((c.f((-4) & j, obj) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static boolean c(long j, Object obj) {
        return ((byte) ((c.f((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static Object d(Class cls) {
        try {
            return a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int e(Class cls) {
        if (e) {
            return c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (e) {
            c.b(cls);
        }
    }

    public static Field g() {
        Field declaredField;
        Field declaredField2;
        if (p2.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static boolean h(Class cls) {
        if (!p2.a()) {
            return false;
        }
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged(new sg0());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j, byte b2) {
        c.k(bArr, f + j, b2);
    }

    public static void k(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iF = c.f(j2, obj);
        int i = ((~((int) j)) & 3) << 3;
        m(obj, j2, ((255 & b2) << i) | (iF & (~(255 << i))));
    }

    public static void l(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        m(obj, j2, ((255 & b2) << i) | (c.f(j2, obj) & (~(255 << i))));
    }

    public static void m(Object obj, long j, int i) {
        c.n(obj, j, i);
    }

    public static void n(Object obj, long j, long j2) {
        c.o(obj, j, j2);
    }

    public static void o(Object obj, long j, Object obj2) {
        c.p(obj, j, obj2);
    }
}
