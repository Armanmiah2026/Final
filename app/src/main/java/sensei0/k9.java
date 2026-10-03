package sensei0;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class k9 {
    public final j9 a;
    public int b;
    public int c;
    public int d = 0;

    public k9(j9 j9Var) {
        Charset charset = mr.a;
        this.a = j9Var;
        j9Var.b = this;
    }

    public final int a() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.u();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final void b(Object obj, v60 v60Var, rj rjVar) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            v60Var.d(obj, this, rjVar);
            if (this.b == this.c) {
            } else {
                throw new tr("Failed to parse the message.");
            }
        } finally {
            this.c = i;
        }
    }

    public final void c(Object obj, v60 v60Var, rj rjVar) throws tr {
        j9 j9Var = this.a;
        int iV = j9Var.v();
        if (j9Var.a >= 100) {
            throw new tr("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iE = j9Var.e(iV);
        j9Var.a++;
        v60Var.d(obj, this, rjVar);
        j9Var.a(0);
        j9Var.a--;
        j9Var.d(iE);
    }

    public final void d(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 0) {
            do {
                ((f30) lrVar).add(Boolean.valueOf(j9Var.f()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iB = j9Var.b() + j9Var.v();
        do {
            ((f30) lrVar).add(Boolean.valueOf(j9Var.f()));
        } while (j9Var.b() < iB);
        v(iB);
    }

    public final u6 e() throws sr {
        w(2);
        return this.a.g();
    }

    public final void f(lr lrVar) throws sr {
        int iU;
        if ((this.b & 7) != 2) {
            throw tr.b();
        }
        do {
            ((f30) lrVar).add(e());
            j9 j9Var = this.a;
            if (j9Var.c()) {
                return;
            } else {
                iU = j9Var.u();
            }
        } while (iU == this.b);
        this.d = iU;
    }

    public final void g(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 1) {
            do {
                ((f30) lrVar).add(Double.valueOf(j9Var.h()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iV = j9Var.v();
        if ((iV & 7) != 0) {
            throw new tr("Failed to parse the message.");
        }
        int iB = j9Var.b() + iV;
        do {
            ((f30) lrVar).add(Double.valueOf(j9Var.h()));
        } while (j9Var.b() < iB);
    }

    public final void h(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 0) {
            do {
                ((f30) lrVar).add(Integer.valueOf(j9Var.i()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iB = j9Var.b() + j9Var.v();
        do {
            ((f30) lrVar).add(Integer.valueOf(j9Var.i()));
        } while (j9Var.b() < iB);
        v(iB);
    }

    public final Object i(gm0 gm0Var, Class cls, rj rjVar) throws tr {
        int iOrdinal = gm0Var.ordinal();
        j9 j9Var = this.a;
        switch (iOrdinal) {
            case 0:
                w(1);
                return Double.valueOf(j9Var.h());
            case 1:
                w(5);
                return Float.valueOf(j9Var.l());
            case 2:
                w(0);
                return Long.valueOf(j9Var.n());
            case 3:
                w(0);
                return Long.valueOf(j9Var.w());
            case 4:
                w(0);
                return Integer.valueOf(j9Var.m());
            case 5:
                w(1);
                return Long.valueOf(j9Var.k());
            case 6:
                w(5);
                return Integer.valueOf(j9Var.j());
            case 7:
                w(0);
                return Boolean.valueOf(j9Var.f());
            case 8:
                w(2);
                return j9Var.t();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                w(2);
                v60 v60VarA = e30.c.a(cls);
                cq cqVarI = v60VarA.i();
                c(cqVarI, v60VarA, rjVar);
                v60VarA.e(cqVarI);
                return cqVarI;
            case 11:
                return e();
            case 12:
                w(0);
                return Integer.valueOf(j9Var.v());
            case 13:
                w(0);
                return Integer.valueOf(j9Var.i());
            case 14:
                w(5);
                return Integer.valueOf(j9Var.o());
            case 15:
                w(1);
                return Long.valueOf(j9Var.p());
            case 16:
                w(0);
                return Integer.valueOf(j9Var.q());
            case 17:
                w(0);
                return Long.valueOf(j9Var.r());
        }
    }

    public final void j(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 2) {
            int iV = j9Var.v();
            if ((iV & 3) != 0) {
                throw new tr("Failed to parse the message.");
            }
            int iB = j9Var.b() + iV;
            do {
                ((f30) lrVar).add(Integer.valueOf(j9Var.j()));
            } while (j9Var.b() < iB);
            return;
        }
        if (i != 5) {
            throw tr.b();
        }
        do {
            ((f30) lrVar).add(Integer.valueOf(j9Var.j()));
            if (j9Var.c()) {
                return;
            } else {
                iU = j9Var.u();
            }
        } while (iU == this.b);
        this.d = iU;
    }

    public final void k(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 1) {
            do {
                ((f30) lrVar).add(Long.valueOf(j9Var.k()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iV = j9Var.v();
        if ((iV & 7) != 0) {
            throw new tr("Failed to parse the message.");
        }
        int iB = j9Var.b() + iV;
        do {
            ((f30) lrVar).add(Long.valueOf(j9Var.k()));
        } while (j9Var.b() < iB);
    }

    public final void l(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 2) {
            int iV = j9Var.v();
            if ((iV & 3) != 0) {
                throw new tr("Failed to parse the message.");
            }
            int iB = j9Var.b() + iV;
            do {
                ((f30) lrVar).add(Float.valueOf(j9Var.l()));
            } while (j9Var.b() < iB);
            return;
        }
        if (i != 5) {
            throw tr.b();
        }
        do {
            ((f30) lrVar).add(Float.valueOf(j9Var.l()));
            if (j9Var.c()) {
                return;
            } else {
                iU = j9Var.u();
            }
        } while (iU == this.b);
        this.d = iU;
    }

    public final void m(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 0) {
            do {
                ((f30) lrVar).add(Integer.valueOf(j9Var.m()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iB = j9Var.b() + j9Var.v();
        do {
            ((f30) lrVar).add(Integer.valueOf(j9Var.m()));
        } while (j9Var.b() < iB);
        v(iB);
    }

    public final void n(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 0) {
            do {
                ((f30) lrVar).add(Long.valueOf(j9Var.n()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iB = j9Var.b() + j9Var.v();
        do {
            ((f30) lrVar).add(Long.valueOf(j9Var.n()));
        } while (j9Var.b() < iB);
        v(iB);
    }

    public final void o(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 2) {
            int iV = j9Var.v();
            if ((iV & 3) != 0) {
                throw new tr("Failed to parse the message.");
            }
            int iB = j9Var.b() + iV;
            do {
                ((f30) lrVar).add(Integer.valueOf(j9Var.o()));
            } while (j9Var.b() < iB);
            return;
        }
        if (i != 5) {
            throw tr.b();
        }
        do {
            ((f30) lrVar).add(Integer.valueOf(j9Var.o()));
            if (j9Var.c()) {
                return;
            } else {
                iU = j9Var.u();
            }
        } while (iU == this.b);
        this.d = iU;
    }

    public final void p(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 1) {
            do {
                ((f30) lrVar).add(Long.valueOf(j9Var.p()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iV = j9Var.v();
        if ((iV & 7) != 0) {
            throw new tr("Failed to parse the message.");
        }
        int iB = j9Var.b() + iV;
        do {
            ((f30) lrVar).add(Long.valueOf(j9Var.p()));
        } while (j9Var.b() < iB);
    }

    public final void q(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 0) {
            do {
                ((f30) lrVar).add(Integer.valueOf(j9Var.q()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iB = j9Var.b() + j9Var.v();
        do {
            ((f30) lrVar).add(Integer.valueOf(j9Var.q()));
        } while (j9Var.b() < iB);
        v(iB);
    }

    public final void r(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 0) {
            do {
                ((f30) lrVar).add(Long.valueOf(j9Var.r()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iB = j9Var.b() + j9Var.v();
        do {
            ((f30) lrVar).add(Long.valueOf(j9Var.r()));
        } while (j9Var.b() < iB);
        v(iB);
    }

    public final void s(lr lrVar, boolean z) throws sr {
        String strS;
        int iU;
        if ((this.b & 7) != 2) {
            throw tr.b();
        }
        do {
            j9 j9Var = this.a;
            if (z) {
                w(2);
                strS = j9Var.t();
            } else {
                w(2);
                strS = j9Var.s();
            }
            ((f30) lrVar).add(strS);
            if (j9Var.c()) {
                return;
            } else {
                iU = j9Var.u();
            }
        } while (iU == this.b);
        this.d = iU;
    }

    public final void t(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 0) {
            do {
                ((f30) lrVar).add(Integer.valueOf(j9Var.v()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iB = j9Var.b() + j9Var.v();
        do {
            ((f30) lrVar).add(Integer.valueOf(j9Var.v()));
        } while (j9Var.b() < iB);
        v(iB);
    }

    public final void u(lr lrVar) throws tr {
        int iU;
        int i = this.b & 7;
        j9 j9Var = this.a;
        if (i == 0) {
            do {
                ((f30) lrVar).add(Long.valueOf(j9Var.w()));
                if (j9Var.c()) {
                    return;
                } else {
                    iU = j9Var.u();
                }
            } while (iU == this.b);
            this.d = iU;
            return;
        }
        if (i != 2) {
            throw tr.b();
        }
        int iB = j9Var.b() + j9Var.v();
        do {
            ((f30) lrVar).add(Long.valueOf(j9Var.w()));
        } while (j9Var.b() < iB);
        v(iB);
    }

    public final void v(int i) throws tr {
        if (this.a.b() != i) {
            throw tr.e();
        }
    }

    public final void w(int i) throws sr {
        if ((this.b & 7) != i) {
            throw tr.b();
        }
    }

    public final boolean x() {
        int i;
        j9 j9Var = this.a;
        if (j9Var.c() || (i = this.b) == this.c) {
            return false;
        }
        return j9Var.x(i);
    }
}
