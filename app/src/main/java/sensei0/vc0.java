package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vc0 implements hn {
    public final /* synthetic */ Runnable a;
    public final /* synthetic */ xc0 b;

    public vc0(xc0 xc0Var, Runnable runnable) {
        this.b = xc0Var;
        this.a = runnable;
    }

    @Override // sensei0.hn
    public final void b() {
        this.a.run();
        io.flutter.embedding.engine.renderer.e eVar = this.b.b;
        if (eVar != null) {
            eVar.g(this);
        }
    }

    @Override // sensei0.hn
    public final void a() {
    }
}
