package io.flutter.view;

import android.graphics.SurfaceTexture;
import sensei0.de0;
import sensei0.ee0;
import sensei0.qs;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@qs
public interface TextureRegistry$SurfaceTextureEntry {
    /* synthetic */ long id();

    /* synthetic */ void release();

    SurfaceTexture surfaceTexture();

    default void setOnFrameConsumedListener(de0 de0Var) {
    }

    default void setOnTrimMemoryListener(ee0 ee0Var) {
    }
}
