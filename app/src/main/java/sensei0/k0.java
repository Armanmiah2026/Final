package sensei0;

import android.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 extends f0 {
    public final String c;
    public final float d;
    public final /* synthetic */ io.flutter.view.b e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(io.flutter.view.b bVar) {
        super(bVar, 3);
        this.e = bVar;
        this.c = "transition_animation_scale";
        this.d = 1.0f;
    }

    @Override // sensei0.f0
    public final boolean a() {
        return Settings.Global.getFloat(this.e.f, this.c, this.d) == 0.0f;
    }
}
