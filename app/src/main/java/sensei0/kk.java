package sensei0;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class kk {
    public static final /* synthetic */ int c = 0;
    public final ua0 a = ua0.f();
    public boolean b;

    static {
        new kk(0);
    }

    public kk() {
    }

    public static void b(m9 m9Var, gm0 gm0Var, int i, Object obj) throws l9 {
        if (gm0Var == gm0.d) {
            m9Var.S0(i, 3);
            ((n) obj).b(m9Var);
            m9Var.S0(i, 4);
        }
        m9Var.S0(i, gm0Var.b);
        switch (gm0Var.ordinal()) {
            case 0:
                m9Var.M0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                m9Var.K0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                m9Var.W0(((Long) obj).longValue());
                break;
            case 3:
                m9Var.W0(((Long) obj).longValue());
                break;
            case 4:
                m9Var.O0(((Integer) obj).intValue());
                break;
            case 5:
                m9Var.M0(((Long) obj).longValue());
                break;
            case 6:
                m9Var.K0(((Integer) obj).intValue());
                break;
            case 7:
                m9Var.E0(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof u6)) {
                    m9Var.R0((String) obj);
                } else {
                    m9Var.I0((u6) obj);
                }
                break;
            case 9:
                ((n) obj).b(m9Var);
                break;
            case 10:
                n nVar = (n) obj;
                m9Var.getClass();
                m9Var.U0(((cq) nVar).a(null));
                nVar.b(m9Var);
                break;
            case 11:
                if (!(obj instanceof u6)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    m9Var.U0(length);
                    m9Var.F0(bArr, 0, length);
                } else {
                    m9Var.I0((u6) obj);
                }
                break;
            case 12:
                m9Var.U0(((Integer) obj).intValue());
                break;
            case 13:
                m9Var.O0(((Integer) obj).intValue());
                break;
            case 14:
                m9Var.K0(((Integer) obj).intValue());
                break;
            case 15:
                m9Var.M0(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                m9Var.U0((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                m9Var.W0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.b) {
            return;
        }
        ua0 ua0Var = this.a;
        int size = ua0Var.a.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entryC = ua0Var.c(i);
            if (entryC.getValue() instanceof cq) {
                cq cqVar = (cq) entryC.getValue();
                cqVar.getClass();
                e30 e30Var = e30.c;
                e30Var.getClass();
                e30Var.a(cqVar.getClass()).e(cqVar);
                cqVar.h();
            }
        }
        if (!ua0Var.c) {
            if (ua0Var.a.size() > 0) {
                ua0Var.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator it = ua0Var.d().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!ua0Var.c) {
            ua0Var.b = ua0Var.b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(ua0Var.b);
            ua0Var.f = ua0Var.f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(ua0Var.f);
            ua0Var.c = true;
        }
        this.b = true;
    }

    public final Object clone() {
        kk kkVar = new kk();
        ua0 ua0Var = this.a;
        if (ua0Var.a.size() > 0) {
            Map.Entry entryC = ua0Var.c(0);
            if (entryC.getKey() != null) {
                throw new ClassCastException();
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = ua0Var.d().iterator();
        if (!it.hasNext()) {
            return kkVar;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            throw new ClassCastException();
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kk) {
            return this.a.equals(((kk) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public kk(int i) {
        a();
        a();
    }
}
