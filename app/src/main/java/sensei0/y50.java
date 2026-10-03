package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class y50 extends mm0 {
    @Override // sensei0.mm0
    public final void u(n80 n80Var, float f, float f2) {
        n80Var.d(f2 * f, 180.0f, 90.0f);
        float f3 = f2 * 2.0f * f;
        j80 j80Var = new j80(0.0f, 0.0f, f3, f3);
        j80Var.f = 180.0f;
        j80Var.g = 90.0f;
        n80Var.f.add(j80Var);
        h80 h80Var = new h80(j80Var);
        n80Var.a(180.0f);
        n80Var.g.add(h80Var);
        n80Var.d = 270.0f;
        float f4 = (0.0f + f3) * 0.5f;
        float f5 = (f3 - 0.0f) / 2.0f;
        double d = 270.0f;
        n80Var.b = (((float) Math.cos(Math.toRadians(d))) * f5) + f4;
        n80Var.c = (f5 * ((float) Math.sin(Math.toRadians(d)))) + f4;
    }
}
