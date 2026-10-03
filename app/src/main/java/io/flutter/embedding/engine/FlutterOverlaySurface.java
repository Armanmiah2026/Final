package io.flutter.embedding.engine;

import android.view.Surface;
import sensei0.qs;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@qs
public class FlutterOverlaySurface {
    private final int id;
    private final Surface surface;

    public FlutterOverlaySurface(int i, Surface surface) {
        this.id = i;
        this.surface = surface;
    }

    public int getId() {
        return this.id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
