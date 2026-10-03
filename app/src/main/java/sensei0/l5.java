package sensei0;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l5 implements xb, wc, Serializable {
    public final xb a;

    public l5(xb xbVar) {
        this.a = xbVar;
    }

    public wc e() {
        xb xbVar = this.a;
        if (xbVar instanceof wc) {
            return (wc) xbVar;
        }
        return null;
    }

    @Override // sensei0.xb
    public final void h(Object obj) {
        xb xbVar = this;
        while (true) {
            l5 l5Var = (l5) xbVar;
            xb xbVar2 = l5Var.a;
            pr.f(xbVar2);
            try {
                obj = l5Var.n(obj);
                if (obj == vc.a) {
                    return;
                }
            } catch (Throwable th) {
                obj = wf0.i(th);
            }
            l5Var.o();
            if (!(xbVar2 instanceof l5)) {
                xbVar2.h(obj);
                return;
            }
            xbVar = xbVar2;
        }
    }

    public xb j(Object obj, xb xbVar) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public StackTraceElement k() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        we weVar = (we) getClass().getAnnotation(we.class);
        String str = null;
        if (weVar == null || weVar.v() < 1) {
            return null;
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? weVar.l()[iIntValue] : -1;
        o4 o4Var = k6.d;
        o4 o4Var2 = k6.e;
        if (o4Var2 == null) {
            try {
                o4 o4Var3 = new o4(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null), 13);
                k6.e = o4Var3;
                o4Var2 = o4Var3;
            } catch (Exception unused2) {
                k6.e = o4Var;
                o4Var2 = o4Var;
            }
        }
        if (o4Var2 != o4Var && (method = (Method) o4Var2.b) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = (Method) o4Var2.c) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = (Method) o4Var2.d;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = weVar.c();
        } else {
            strC = str + '/' + weVar.c();
        }
        return new StackTraceElement(strC, weVar.m(), weVar.f(), i);
    }

    public abstract Object n(Object obj);

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object objK = k();
        if (objK == null) {
            objK = getClass().getName();
        }
        sb.append(objK);
        return sb.toString();
    }

    public void o() {
    }
}
