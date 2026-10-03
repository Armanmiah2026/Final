package sensei0;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ol0 {
    public static final rl0 b;
    public final rl0 a;

    static {
        int i = Build.VERSION.SDK_INT;
        b = (i >= 34 ? new el0() : i >= 31 ? new dl0() : i >= 30 ? new cl0() : i >= 29 ? new bl0() : new al0()).b().a.a().a.b().a.c();
    }

    public ol0(rl0 rl0Var) {
        this.a = rl0Var;
    }

    public rl0 a() {
        return this.a;
    }

    public rl0 b() {
        return this.a;
    }

    public rl0 c() {
        return this.a;
    }

    public lg e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ol0)) {
            return false;
        }
        ol0 ol0Var = (ol0) obj;
        return n() == ol0Var.n() && m() == ol0Var.m() && Objects.equals(j(), ol0Var.j()) && Objects.equals(h(), ol0Var.h()) && Objects.equals(e(), ol0Var.e());
    }

    public hr f(int i) {
        return hr.e;
    }

    public hr g() {
        return j();
    }

    public hr h() {
        return hr.e;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e());
    }

    public hr i() {
        return j();
    }

    public hr j() {
        return hr.e;
    }

    public hr k() {
        return j();
    }

    public rl0 l(int i, int i2, int i3, int i4) {
        return b;
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public boolean o(int i) {
        return true;
    }

    public void d(View view) {
    }

    public void p(hr[] hrVarArr) {
    }

    public void q(rl0 rl0Var) {
    }

    public void r(hr hrVar) {
    }

    public void s(int i) {
    }
}
