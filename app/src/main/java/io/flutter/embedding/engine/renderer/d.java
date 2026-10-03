package io.flutter.embedding.engine.renderer;

import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final ImageReader a;
    public final ArrayDeque b = new ArrayDeque();
    public boolean c = false;
    public final /* synthetic */ FlutterRenderer$ImageReaderSurfaceProducer d;

    public d(FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer, ImageReader imageReader) {
        this.d = flutterRenderer$ImageReaderSurfaceProducer;
        this.a = imageReader;
        imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.c
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(ImageReader imageReader2) {
                Image imageAcquireLatestImage;
                d dVar = this.a;
                FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer2 = dVar.d;
                try {
                    imageAcquireLatestImage = imageReader2.acquireLatestImage();
                } catch (IllegalStateException e) {
                    Log.e("ImageReaderSurfaceProducer", "onImageAvailable acquireLatestImage failed: " + e);
                    imageAcquireLatestImage = null;
                }
                if (imageAcquireLatestImage == null) {
                    return;
                }
                if (flutterRenderer$ImageReaderSurfaceProducer2.released || dVar.c) {
                    imageAcquireLatestImage.close();
                } else {
                    flutterRenderer$ImageReaderSurfaceProducer2.onImage(imageReader2, imageAcquireLatestImage);
                }
            }
        }, new Handler(Looper.getMainLooper()));
    }
}
