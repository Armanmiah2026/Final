package sensei0;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w6 implements ms, Serializable {
    public transient ms a;
    public final Object b;
    public final Class c;
    public final String d;
    public final String f;
    public final boolean h;

    public w6(Object obj, Class cls, String str, String str2, boolean z) {
        this.b = obj;
        this.c = cls;
        this.d = str;
        this.f = str2;
        this.h = z;
    }

    public abstract ms d();

    public final r8 e() {
        boolean z = this.h;
        Class cls = this.c;
        if (!z) {
            return y40.a(cls);
        }
        y40.a.getClass();
        return new oz(cls);
    }
}
