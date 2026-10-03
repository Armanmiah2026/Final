package sensei0;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class v8 {
    public final int a;
    public final Method b;

    public v8(int i, Method method) {
        this.a = i;
        this.b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v8)) {
            return false;
        }
        v8 v8Var = (v8) obj;
        return this.a == v8Var.a && this.b.getName().equals(v8Var.b.getName());
    }

    public final int hashCode() {
        return this.b.getName().hashCode() + (this.a * 31);
    }
}
