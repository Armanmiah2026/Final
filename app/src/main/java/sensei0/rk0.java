package sensei0;

import android.content.Context;
import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rk0 {
    public static final /* synthetic */ rk0 a = new rk0();
    public static final dd0 b;
    public static final mh c;

    static {
        y40.a(sk0.class).b();
        b = new dd0(qk0.b);
        c = mh.f;
    }

    public static fb0 a(Context context) {
        pr.j("context", context);
        Object obj = (pk0) b.a();
        if (obj == null) {
            ia0 ia0Var = ia0.c;
            if (ia0.c == null) {
                ReentrantLock reentrantLock = ia0.d;
                reentrantLock.lock();
                try {
                    if (ia0.c == null) {
                        ga0 ga0Var = null;
                        try {
                            ih0 ih0VarB = ea0.b();
                            if (ih0VarB != null) {
                                ih0 ih0Var = ih0.h;
                                pr.j("other", ih0Var);
                                Object objA = ih0VarB.f.a();
                                pr.i("<get-bigInteger>(...)", objA);
                                Object objA2 = ih0Var.f.a();
                                pr.i("<get-bigInteger>(...)", objA2);
                                if (((BigInteger) objA).compareTo((BigInteger) objA2) >= 0) {
                                    ga0 ga0Var2 = new ga0(context);
                                    if (ga0Var2.e()) {
                                        ga0Var = ga0Var2;
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        ia0.c = new ia0(ga0Var);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            obj = ia0.c;
            pr.f(obj);
        }
        int i = am0.b;
        int i2 = am0.b;
        fb0 fb0Var = new fb0();
        fb0Var.a = obj;
        c.getClass();
        return fb0Var;
    }
}
