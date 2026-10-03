package sensei0;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class e30 {
    public static final e30 c = new e30();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final sv a = new sv(0);

    public final v60 a(Class cls) {
        v60 v60VarW;
        Class cls2;
        mr.a("messageType", cls);
        ConcurrentHashMap concurrentHashMap = this.b;
        v60 v60Var = (v60) concurrentHashMap.get(cls);
        if (v60Var != null) {
            return v60Var;
        }
        sv svVar = this.a;
        svVar.getClass();
        Class cls3 = w60.a;
        if (!cq.class.isAssignableFrom(cls) && (cls2 = w60.a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        t30 t30VarA = ((rv) svVar.b).a(cls);
        int i = t30VarA.d;
        n nVar = t30VarA.a;
        if ((i & 2) == 2) {
            if (cq.class.isAssignableFrom(cls)) {
                v60VarW = new hx(w60.c, tj.a, nVar);
            } else {
                og0 og0Var = w60.b;
                sj sjVar = tj.b;
                if (sjVar == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                v60VarW = new hx(og0Var, sjVar, nVar);
            }
        } else if (cq.class.isAssignableFrom(cls)) {
            sj sjVar2 = null;
            qy qyVar = ry.b;
            hu huVar = iu.b;
            og0 og0Var2 = w60.c;
            if (za0.u(t30VarA.a()) != 1) {
                sjVar2 = tj.a;
            }
            sj sjVar3 = sjVar2;
            vv vvVar = wv.b;
            if (!(t30VarA instanceof t30)) {
                int[] iArr = gx.n;
                t30VarA.getClass();
                throw new ClassCastException();
            }
            v60VarW = gx.w(t30VarA, qyVar, huVar, og0Var2, sjVar3, vvVar);
        } else {
            sj sjVar4 = null;
            qy qyVar2 = ry.a;
            hu huVar2 = iu.a;
            og0 og0Var3 = w60.b;
            if (za0.u(t30VarA.a()) != 1 && (sjVar4 = tj.b) == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            sj sjVar5 = sjVar4;
            vv vvVar2 = wv.a;
            if (!(t30VarA instanceof t30)) {
                int[] iArr2 = gx.n;
                t30VarA.getClass();
                throw new ClassCastException();
            }
            v60VarW = gx.w(t30VarA, qyVar2, huVar2, og0Var3, sjVar5, vvVar2);
        }
        v60 v60Var2 = (v60) concurrentHashMap.putIfAbsent(cls, v60VarW);
        return v60Var2 != null ? v60Var2 : v60VarW;
    }
}
