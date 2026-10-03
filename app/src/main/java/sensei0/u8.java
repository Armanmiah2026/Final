package sensei0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class u8 {
    public final HashMap a = new HashMap();
    public final HashMap b;

    public u8(HashMap map) {
        this.b = map;
        for (Map.Entry entry : map.entrySet()) {
            lt ltVar = (lt) entry.getValue();
            List arrayList = (List) this.a.get(ltVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(ltVar, arrayList);
            }
            arrayList.add((v8) entry.getKey());
        }
    }

    public static void a(List list, tt ttVar, lt ltVar, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                v8 v8Var = (v8) list.get(size);
                Method method = v8Var.b;
                try {
                    int i = v8Var.a;
                    if (i == 0) {
                        method.invoke(obj, null);
                    } else if (i == 1) {
                        method.invoke(obj, ttVar);
                    } else if (i == 2) {
                        method.invoke(obj, ttVar, ltVar);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }
}
