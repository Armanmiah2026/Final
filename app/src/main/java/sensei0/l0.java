package sensei0;

import android.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends f0 {
    public final String c;
    public final /* synthetic */ io.flutter.view.b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(io.flutter.view.b bVar) {
        super(bVar, 2);
        this.d = bVar;
        this.c = "accessibility_display_inversion_enabled";
    }

    @Override // sensei0.f0
    public final boolean a() {
        return Settings.Secure.getInt(this.d.f, this.c) == 1;
    }
}
