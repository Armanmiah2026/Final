package sensei0;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class h20 extends cq {
    private static final h20 DEFAULT_INSTANCE;
    private static volatile sz PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private lr strings_ = f30.d;

    static {
        h20 h20Var = new h20();
        DEFAULT_INSTANCE = h20Var;
        cq.j(h20.class, h20Var);
    }

    public static void l(h20 h20Var, Set set) {
        lr lrVar = h20Var.strings_;
        if (!((p) lrVar).a) {
            f30 f30Var = (f30) lrVar;
            int i = f30Var.c;
            h20Var.strings_ = f30Var.c(i == 0 ? 10 : i * 2);
        }
        RandomAccess randomAccess = h20Var.strings_;
        Charset charset = mr.a;
        if (randomAccess instanceof ArrayList) {
            ((ArrayList) randomAccess).ensureCapacity(set.size() + ((f30) randomAccess).c);
        }
        f30 f30Var2 = (f30) randomAccess;
        int i2 = f30Var2.c;
        for (Object obj : set) {
            if (obj == null) {
                String str = "Element at index " + (f30Var2.c - i2) + " is null.";
                for (int i3 = f30Var2.c - 1; i3 >= i2; i3--) {
                    f30Var2.remove(i3);
                }
                throw new NullPointerException(str);
            }
            f30Var2.add(obj);
        }
    }

    public static h20 m() {
        return DEFAULT_INSTANCE;
    }

    public static g20 o() {
        return (g20) ((aq) DEFAULT_INSTANCE.c(5));
    }

    @Override // sensei0.cq
    public final Object c(int i) {
        sz bqVar;
        switch (za0.u(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new t30(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new h20();
            case 4:
                return new g20(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                sz szVar = PARSER;
                if (szVar != null) {
                    return szVar;
                }
                synchronized (h20.class) {
                    try {
                        bqVar = PARSER;
                        if (bqVar == null) {
                            bqVar = new bq();
                            PARSER = bqVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return bqVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final lr n() {
        return this.strings_;
    }
}
