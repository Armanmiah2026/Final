package sensei0;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ug0 extends vg0 {
    @Override // sensei0.vg0
    public final boolean c(long j, Object obj) {
        return this.a.getBoolean(obj, j);
    }

    @Override // sensei0.vg0
    public final double d(long j, Object obj) {
        return this.a.getDouble(obj, j);
    }

    @Override // sensei0.vg0
    public final float e(long j, Object obj) {
        return this.a.getFloat(obj, j);
    }

    @Override // sensei0.vg0
    public final void j(Object obj, long j, boolean z) {
        this.a.putBoolean(obj, j, z);
    }

    @Override // sensei0.vg0
    public final void k(Object obj, long j, byte b) {
        this.a.putByte(obj, j, b);
    }

    @Override // sensei0.vg0
    public final void l(Object obj, long j, double d) {
        this.a.putDouble(obj, j, d);
    }

    @Override // sensei0.vg0
    public final void m(Object obj, long j, float f) {
        this.a.putFloat(obj, j, f);
    }

    @Override // sensei0.vg0
    public final boolean q() {
        if (!super.q()) {
            return false;
        }
        try {
            Class<?> cls = this.a.getClass();
            Class cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            wg0.a(th);
            return false;
        }
    }

    @Override // sensei0.vg0
    public final boolean r() {
        Unsafe unsafe = this.a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                if (wg0.g() != null) {
                    try {
                        Class<?> cls3 = this.a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        wg0.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                wg0.a(th2);
            }
        }
        return false;
    }
}
