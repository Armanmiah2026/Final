package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class j5 extends va {
    public int o;
    public int p;
    public k5 q;

    @Override // sensei0.va
    public final void f(hb hbVar, boolean z) {
        int i = this.o;
        this.p = i;
        if (z) {
            if (i == 5) {
                this.p = 1;
            } else if (i == 6) {
                this.p = 0;
            }
        } else if (i == 5) {
            this.p = 0;
        } else if (i == 6) {
            this.p = 1;
        }
        if (hbVar instanceof k5) {
            ((k5) hbVar).f0 = this.p;
        }
    }

    public int getMargin() {
        return this.q.h0;
    }

    public int getType() {
        return this.o;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.q.g0 = z;
    }

    public void setDpMargin(int i) {
        this.q.h0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.q.h0 = i;
    }

    public void setType(int i) {
        this.o = i;
    }
}
