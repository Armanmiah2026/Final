package sensei0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class lb implements InvocationHandler {
    public final t8 a;
    public final vj b;

    public lb(t8 t8Var, vj vjVar) {
        this.a = t8Var;
        this.b = vjVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        boolean zIsInstance;
        String strE;
        pr.j("obj", obj);
        pr.j("method", method);
        boolean zB = pr.b(method.getName(), "accept");
        vj vjVar = this.b;
        strE = null;
        strE = null;
        strE = null;
        String strE2 = null;
        if (!zB || objArr == null || objArr.length != 1) {
            if ((pr.b(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) == true) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if ((pr.b(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) == true) {
                return Integer.valueOf(vjVar.hashCode());
            }
            if (pr.b(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
                z = true;
            }
            if (z) {
                return vjVar.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
        Object obj2 = objArr[0];
        Class cls = this.a.a;
        pr.j("jClass", cls);
        Map map = t8.b;
        pr.g("null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>", map);
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            zIsInstance = wf0.p(num.intValue(), obj2);
        } else {
            zIsInstance = (cls.isPrimitive() ? k6.z(y40.a(cls)) : cls).isInstance(obj2);
        }
        if (zIsInstance) {
            pr.g("null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast", obj2);
            vjVar.g(obj2);
            return mg0.a;
        }
        StringBuilder sb = new StringBuilder("Value cannot be cast to ");
        if (!cls.isAnonymousClass() && !cls.isLocalClass()) {
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive() && (strE = wf0.e(componentType.getName())) != null) {
                    strE2 = strE.concat("Array");
                }
                if (strE2 == null) {
                    strE2 = "kotlin.Array";
                }
            } else {
                strE2 = wf0.e(cls.getName());
                if (strE2 == null) {
                    strE2 = cls.getCanonicalName();
                }
            }
        }
        sb.append(strE2);
        throw new ClassCastException(sb.toString());
    }
}
