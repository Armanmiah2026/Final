package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mn implements hn {
    public final /* synthetic */ io.flutter.embedding.engine.renderer.e a;
    public final /* synthetic */ u2 b;
    public final /* synthetic */ nn c;

    public mn(nn nnVar, io.flutter.embedding.engine.renderer.e eVar, u2 u2Var) {
        this.c = nnVar;
        this.a = eVar;
        this.b = u2Var;
    }

    @Override // sensei0.hn
    public final void b() {
        nm nmVar;
        this.a.g(this);
        this.b.run();
        nn nnVar = this.c;
        if ((nnVar.f instanceof nm) || (nmVar = nnVar.d) == null) {
            return;
        }
        nmVar.a();
        nm nmVar2 = nnVar.d;
        if (nmVar2 != null) {
            nmVar2.a.close();
            nnVar.removeView(nnVar.d);
            nnVar.d = null;
        }
    }

    @Override // sensei0.hn
    public final void a() {
    }
}
