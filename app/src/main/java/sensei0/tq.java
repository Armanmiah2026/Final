package sensei0;

import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.view.TextureRegistry$ImageTextureEntry;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tq implements g10 {
    public TextureRegistry$ImageTextureEntry a;
    public ImageReader b;
    public int c = 0;
    public int d = 0;
    public final Handler f = new Handler();
    public final sq h = new sq(this);

    public tq(TextureRegistry$ImageTextureEntry textureRegistry$ImageTextureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.a = textureRegistry$ImageTextureEntry;
    }

    @Override // sensei0.g10
    public final void c(int i, int i2) {
        ImageReader imageReaderNewInstance;
        ImageReader imageReader = this.b;
        if (imageReader != null && this.c == i && this.d == i2) {
            return;
        }
        if (imageReader != null) {
            this.a.pushImage(null);
            this.b.close();
            this.b = null;
        }
        this.c = i;
        this.d = i2;
        int i3 = Build.VERSION.SDK_INT;
        Handler handler = this.f;
        sq sqVar = this.h;
        if (i3 >= 33) {
            w0.l();
            ImageReader.Builder builderC = w0.c(this.c, this.d);
            builderC.setMaxImages(4);
            builderC.setImageFormat(34);
            builderC.setUsage(256L);
            imageReaderNewInstance = builderC.build();
            imageReaderNewInstance.setOnImageAvailableListener(sqVar, handler);
        } else {
            if (i3 < 29) {
                throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
            }
            imageReaderNewInstance = ImageReader.newInstance(i, i2, 34, 4, 256L);
            imageReaderNewInstance.setOnImageAvailableListener(sqVar, handler);
        }
        this.b = imageReaderNewInstance;
    }

    @Override // sensei0.g10
    public final int getHeight() {
        return this.d;
    }

    @Override // sensei0.g10
    public final long getId() {
        return this.a.id();
    }

    @Override // sensei0.g10
    public final Surface getSurface() {
        return this.b.getSurface();
    }

    @Override // sensei0.g10
    public final int getWidth() {
        return this.c;
    }

    @Override // sensei0.g10
    public final void release() {
        if (this.b != null) {
            this.a.pushImage(null);
            this.b.close();
            this.b = null;
        }
        this.a = null;
    }
}
