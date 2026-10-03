package sensei0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jh0 {
    public final y4 a;
    public final y4 b;
    public final y4 c;

    public jh0(y4 y4Var, y4 y4Var2, y4 y4Var3) {
        this.a = y4Var;
        this.b = y4Var2;
        this.c = y4Var3;
    }

    public abstract kh0 a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        y4 y4Var = this.c;
        Class cls2 = (Class) y4Var.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        y4Var.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        y4 y4Var = this.a;
        Method method = (Method) y4Var.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, jh0.class.getClassLoader()).getDeclaredMethod("read", jh0.class);
        y4Var.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        y4 y4Var = this.b;
        Method method = (Method) y4Var.get(name);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, jh0.class);
        y4Var.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i);

    public final Parcelable f(Parcelable parcelable, int i) {
        if (!e(i)) {
            return parcelable;
        }
        return ((kh0) this).e.readParcelable(kh0.class.getClassLoader());
    }

    public final lh0 g() {
        String string = ((kh0) this).e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (lh0) c(string).invoke(null, a());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract void h(int i);

    public final void i(lh0 lh0Var) {
        if (lh0Var == null) {
            ((kh0) this).e.writeString(null);
            return;
        }
        try {
            ((kh0) this).e.writeString(b(lh0Var.getClass()).getName());
            kh0 kh0VarA = a();
            try {
                d(lh0Var.getClass()).invoke(null, lh0Var, kh0VarA);
                Parcel parcel = kh0VarA.e;
                int i = kh0VarA.i;
                if (i >= 0) {
                    int i2 = kh0VarA.d.get(i);
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(lh0Var.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
