package sensei0;

import android.media.Image;
import android.media.ImageReader;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sq implements ImageReader.OnImageAvailableListener {
    public final /* synthetic */ tq a;

    public sq(tq tqVar) {
        this.a = tqVar;
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Image imageAcquireLatestImage;
        try {
            imageAcquireLatestImage = imageReader.acquireLatestImage();
        } catch (IllegalStateException e) {
            Log.e("ImageReaderPlatformViewRenderTarget", "onImageAvailable acquireLatestImage failed: " + e);
            imageAcquireLatestImage = null;
        }
        if (imageAcquireLatestImage == null) {
            return;
        }
        this.a.a.pushImage(imageAcquireLatestImage);
    }
}
