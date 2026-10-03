package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fa implements xb {
    public static final fa b = new fa(0);
    public static final fa c = new fa(1);
    public final /* synthetic */ int a;

    public /* synthetic */ fa(int i) {
        this.a = i;
    }

    @Override // sensei0.xb
    public final lc f() {
        switch (this.a) {
            case 0:
                throw new IllegalStateException("This continuation is already complete");
            default:
                return oi.a;
        }
    }

    @Override // sensei0.xb
    public final void h(Object obj) {
        switch (this.a) {
            case 0:
                throw new IllegalStateException("This continuation is already complete");
            default:
                return;
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return "This continuation is already complete";
            default:
                return super.toString();
        }
    }

    private final void a(Object obj) {
    }
}
