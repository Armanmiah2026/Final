package sensei0;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class g5 extends mf0 {
    public ArrayList K;
    public boolean L;
    public int M;
    public boolean N;
    public int O;

    @Override // sensei0.mf0
    public final void A(View view) {
        super.A(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            ((mf0) this.K.get(i)).A(view);
        }
    }

    @Override // sensei0.mf0
    public final void B() {
        if (this.K.isEmpty()) {
            J();
            m();
            return;
        }
        rf0 rf0Var = new rf0();
        rf0Var.b = this;
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((mf0) obj).a(rf0Var);
        }
        this.M = this.K.size();
        if (this.L) {
            ArrayList arrayList2 = this.K;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((mf0) obj2).B();
            }
            return;
        }
        for (int i3 = 1; i3 < this.K.size(); i3++) {
            ((mf0) this.K.get(i3 - 1)).a(new rf0((mf0) this.K.get(i3), 2));
        }
        mf0 mf0Var = (mf0) this.K.get(0);
        if (mf0Var != null) {
            mf0Var.B();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // sensei0.mf0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void C(long r20, long r22) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.g5.C(long, long):void");
    }

    @Override // sensei0.mf0
    public final void D(long j) {
        ArrayList arrayList;
        this.c = j;
        if (j < 0 || (arrayList = this.K) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((mf0) this.K.get(i)).D(j);
        }
    }

    @Override // sensei0.mf0
    public final void E(k6 k6Var) {
        this.O |= 8;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            ((mf0) this.K.get(i)).E(k6Var);
        }
    }

    @Override // sensei0.mf0
    public final void F(TimeInterpolator timeInterpolator) {
        this.O |= 1;
        ArrayList arrayList = this.K;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((mf0) this.K.get(i)).F(timeInterpolator);
            }
        }
        this.d = timeInterpolator;
    }

    @Override // sensei0.mf0
    public final void G(mz mzVar) {
        super.G(mzVar);
        this.O |= 4;
        if (this.K != null) {
            for (int i = 0; i < this.K.size(); i++) {
                ((mf0) this.K.get(i)).G(mzVar);
            }
        }
    }

    @Override // sensei0.mf0
    public final void H() {
        this.O |= 2;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            ((mf0) this.K.get(i)).H();
        }
    }

    @Override // sensei0.mf0
    public final void I(long j) {
        this.b = j;
    }

    @Override // sensei0.mf0
    public final String K(String str) {
        String strK = super.K(str);
        for (int i = 0; i < this.K.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strK);
            sb.append("\n");
            sb.append(((mf0) this.K.get(i)).K(str + "  "));
            strK = sb.toString();
        }
        return strK;
    }

    public final void L(mf0 mf0Var) {
        this.K.add(mf0Var);
        mf0Var.q = this;
        long j = this.c;
        if (j >= 0) {
            mf0Var.D(j);
        }
        if ((this.O & 1) != 0) {
            mf0Var.F(this.d);
        }
        if ((this.O & 2) != 0) {
            mf0Var.H();
        }
        if ((this.O & 4) != 0) {
            mf0Var.G(this.D);
        }
        if ((this.O & 8) != 0) {
            mf0Var.E(null);
        }
    }

    @Override // sensei0.mf0
    public final void c() {
        super.c();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            ((mf0) this.K.get(i)).c();
        }
    }

    @Override // sensei0.mf0
    public final void d(uf0 uf0Var) {
        View view = uf0Var.b;
        if (u(view)) {
            ArrayList arrayList = this.K;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                mf0 mf0Var = (mf0) obj;
                if (mf0Var.u(view)) {
                    mf0Var.d(uf0Var);
                    uf0Var.c.add(mf0Var);
                }
            }
        }
    }

    @Override // sensei0.mf0
    public final void f(uf0 uf0Var) {
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            ((mf0) this.K.get(i)).f(uf0Var);
        }
    }

    @Override // sensei0.mf0
    public final void g(uf0 uf0Var) {
        View view = uf0Var.b;
        if (u(view)) {
            ArrayList arrayList = this.K;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                mf0 mf0Var = (mf0) obj;
                if (mf0Var.u(view)) {
                    mf0Var.g(uf0Var);
                    uf0Var.c.add(mf0Var);
                }
            }
        }
    }

    @Override // sensei0.mf0
    /* JADX INFO: renamed from: j */
    public final mf0 clone() {
        g5 g5Var = (g5) super.clone();
        g5Var.K = new ArrayList();
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            mf0 mf0VarClone = ((mf0) this.K.get(i)).clone();
            g5Var.K.add(mf0VarClone);
            mf0VarClone.q = g5Var;
        }
        return g5Var;
    }

    @Override // sensei0.mf0
    public final void l(ViewGroup viewGroup, j1 j1Var, j1 j1Var2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.b;
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            mf0 mf0Var = (mf0) this.K.get(i);
            if (j > 0 && (this.L || i == 0)) {
                long j2 = mf0Var.b;
                if (j2 > 0) {
                    mf0Var.I(j2 + j);
                } else {
                    mf0Var.I(j);
                }
            }
            mf0Var.l(viewGroup, j1Var, j1Var2, arrayList, arrayList2);
        }
    }

    @Override // sensei0.mf0
    public final boolean s() {
        for (int i = 0; i < this.K.size(); i++) {
            if (((mf0) this.K.get(i)).s()) {
                return true;
            }
        }
        return false;
    }

    @Override // sensei0.mf0
    public final void x(View view) {
        super.x(view);
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            ((mf0) this.K.get(i)).x(view);
        }
    }

    @Override // sensei0.mf0
    public final void y() {
        this.E = 0L;
        int i = 0;
        rf0 rf0Var = new rf0(this, i);
        while (i < this.K.size()) {
            mf0 mf0Var = (mf0) this.K.get(i);
            mf0Var.a(rf0Var);
            mf0Var.y();
            long j = mf0Var.E;
            if (this.L) {
                this.E = Math.max(this.E, j);
            } else {
                long j2 = this.E;
                mf0Var.F = j2;
                this.E = j2 + j;
            }
            i++;
        }
    }

    @Override // sensei0.mf0
    public final mf0 z(jf0 jf0Var) {
        super.z(jf0Var);
        return this;
    }
}
