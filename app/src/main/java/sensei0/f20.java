package sensei0;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class f20 extends cq {
    private static final f20 DEFAULT_INSTANCE;
    private static volatile sz PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private uv preferences_ = uv.b;

    static {
        f20 f20Var = new f20();
        DEFAULT_INSTANCE = f20Var;
        cq.j(f20.class, f20Var);
    }

    public static uv l(f20 f20Var) {
        uv uvVar = f20Var.preferences_;
        if (!uvVar.a) {
            f20Var.preferences_ = uvVar.b();
        }
        return f20Var.preferences_;
    }

    public static d20 n() {
        return (d20) ((aq) DEFAULT_INSTANCE.c(5));
    }

    public static f20 o(FileInputStream fileInputStream) {
        f20 f20Var = DEFAULT_INSTANCE;
        i9 i9Var = new i9(fileInputStream);
        rj rjVarA = rj.a();
        cq cqVarI = f20Var.i();
        try {
            e30 e30Var = e30.c;
            e30Var.getClass();
            v60 v60VarA = e30Var.a(cqVarI.getClass());
            k9 k9Var = i9Var.b;
            if (k9Var == null) {
                k9Var = new k9(i9Var);
            }
            v60VarA.d(cqVarI, k9Var, rjVarA);
            v60VarA.e(cqVarI);
            if (cq.f(cqVarI, true)) {
                return (f20) cqVarI;
            }
            throw new tr(new lg0().getMessage());
        } catch (RuntimeException e) {
            if (e.getCause() instanceof tr) {
                throw ((tr) e.getCause());
            }
            throw e;
        } catch (tr e2) {
            if (e2.a) {
                throw new tr(e2.getMessage(), e2);
            }
            throw e2;
        } catch (IOException e3) {
            if (e3.getCause() instanceof tr) {
                throw ((tr) e3.getCause());
            }
            throw new tr(e3.getMessage(), e3);
        } catch (lg0 e4) {
            throw new tr(e4.getMessage());
        }
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
                return new t30(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", e20.a});
            case 3:
                return new f20();
            case 4:
                return new d20(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                sz szVar = PARSER;
                if (szVar != null) {
                    return szVar;
                }
                synchronized (f20.class) {
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

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
