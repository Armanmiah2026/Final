package sensei0;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class o20 implements tt {
    public static final o20 q = new o20();
    public int a;
    public int b;
    public Handler f;
    public boolean c = true;
    public boolean d = true;
    public final vt h = new vt(this);
    public final u2 o = new u2(11, this);
    public final ws p = new ws(18, this);

    @Override // sensei0.tt
    public final vt b() {
        return this.h;
    }

    public final void c() {
        int i = this.b + 1;
        this.b = i;
        if (i == 1) {
            if (this.c) {
                this.h.e(lt.ON_RESUME);
                this.c = false;
            } else {
                Handler handler = this.f;
                pr.f(handler);
                handler.removeCallbacks(this.o);
            }
        }
    }
}
