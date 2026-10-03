package sensei0;

import androidx.window.sidecar.SidecarDisplayFeature;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class aa0 extends et implements fp {
    public static final aa0 b = new aa0(1);

    @Override // sensei0.fp
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Boolean g(SidecarDisplayFeature sidecarDisplayFeature) {
        pr.j("$this$require", sidecarDisplayFeature);
        return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
    }
}
