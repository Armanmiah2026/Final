package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class iq extends ok0 {
    @Override // sensei0.uf
    public final void a(uf ufVar) {
        wf wfVar = this.h;
        if (wfVar.c && !wfVar.j) {
            wfVar.d((int) ((((wf) wfVar.l.get(0)).g * ((hq) this.b).d0) + 0.5f));
        }
    }

    @Override // sensei0.ok0
    public final void d() {
        hb hbVar = this.b;
        hq hqVar = (hq) hbVar;
        int i = hqVar.e0;
        int i2 = hqVar.f0;
        int i3 = hqVar.h0;
        wf wfVar = this.h;
        if (i3 == 1) {
            if (i != -1) {
                wfVar.l.add(hbVar.I.d.h);
                this.b.I.d.h.k.add(wfVar);
                wfVar.f = i;
            } else if (i2 != -1) {
                wfVar.l.add(hbVar.I.d.i);
                this.b.I.d.i.k.add(wfVar);
                wfVar.f = -i2;
            } else {
                wfVar.b = true;
                wfVar.l.add(hbVar.I.d.i);
                this.b.I.d.i.k.add(wfVar);
            }
            m(this.b.d.h);
            m(this.b.d.i);
            return;
        }
        if (i != -1) {
            wfVar.l.add(hbVar.I.e.h);
            this.b.I.e.h.k.add(wfVar);
            wfVar.f = i;
        } else if (i2 != -1) {
            wfVar.l.add(hbVar.I.e.i);
            this.b.I.e.i.k.add(wfVar);
            wfVar.f = -i2;
        } else {
            wfVar.b = true;
            wfVar.l.add(hbVar.I.e.i);
            this.b.I.e.i.k.add(wfVar);
        }
        m(this.b.e.h);
        m(this.b.e.i);
    }

    @Override // sensei0.ok0
    public final void e() {
        hb hbVar = this.b;
        int i = ((hq) hbVar).h0;
        wf wfVar = this.h;
        if (i == 1) {
            hbVar.N = wfVar.g;
        } else {
            hbVar.O = wfVar.g;
        }
    }

    @Override // sensei0.ok0
    public final void f() {
        this.h.c();
    }

    @Override // sensei0.ok0
    public final boolean k() {
        return false;
    }

    public final void m(wf wfVar) {
        wf wfVar2 = this.h;
        wfVar2.k.add(wfVar);
        wfVar.l.add(wfVar2);
    }
}
