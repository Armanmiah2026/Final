package sensei0;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class w8 {
    public static final w8 c = new w8();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();

    public static void b(HashMap map, v8 v8Var, lt ltVar, Class cls) {
        lt ltVar2 = (lt) map.get(v8Var);
        if (ltVar2 == null || ltVar == ltVar2) {
            if (ltVar2 == null) {
                map.put(v8Var, ltVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + v8Var.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + ltVar2 + ", new value " + ltVar);
    }

    public final u8 a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.a;
        if (superclass != null) {
            u8 u8VarA = (u8) map2.get(superclass);
            if (u8VarA == null) {
                u8VarA = a(superclass, null);
            }
            map.putAll(u8VarA.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            u8 u8VarA2 = (u8) map2.get(cls2);
            if (u8VarA2 == null) {
                u8VarA2 = a(cls2, null);
            }
            for (Map.Entry entry : u8VarA2.b.entrySet()) {
                b(map, (v8) entry.getKey(), (lt) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            yy yyVar = (yy) method.getAnnotation(yy.class);
            if (yyVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!tt.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                lt ltVarValue = yyVar.value();
                if (parameterTypes.length > 1) {
                    if (!lt.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (ltVarValue != lt.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new v8(i, method), ltVarValue, cls);
                z = true;
            }
        }
        u8 u8Var = new u8(map);
        map2.put(cls, u8Var);
        this.b.put(cls, Boolean.valueOf(z));
        return u8Var;
    }
}
