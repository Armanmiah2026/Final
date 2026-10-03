package sensei0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class nm extends View implements f50 {
    public ImageReader a;
    public Image b;
    public Bitmap c;
    public io.flutter.embedding.engine.renderer.e d;
    public final boolean f;
    public final int h;
    public boolean o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nm(Context context, int i, int i2, int i3) {
        super(context, null);
        ImageReader imageReaderF = f(i, i2);
        this.f = false;
        this.o = false;
        this.a = imageReaderF;
        this.h = i3;
        setAlpha(0.0f);
        this.f = pr.E(getContext());
    }

    public static ImageReader f(int i, int i2) {
        if (i <= 0) {
            Locale locale = Locale.US;
            Log.w("FlutterImageView", "ImageReader width must be greater than 0, but given width=" + i + ", set width=1");
            i = 1;
        }
        if (i2 <= 0) {
            Locale locale2 = Locale.US;
            Log.w("FlutterImageView", "ImageReader height must be greater than 0, but given height=" + i2 + ", set height=1");
            i2 = 1;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i, i2, 1, 3, 768L) : ImageReader.newInstance(i, i2, 1, 3);
    }

    @Override // sensei0.f50
    public final void a() {
        if (this.o) {
            setAlpha(0.0f);
            e();
            this.c = null;
            Image image = this.b;
            if (image != null) {
                image.close();
                this.b = null;
            }
            invalidate();
            this.o = false;
        }
    }

    @Override // sensei0.f50
    public final void c(io.flutter.embedding.engine.renderer.e eVar) {
        if (za0.u(this.h) == 0) {
            Surface surface = this.a.getSurface();
            eVar.c = surface;
            eVar.a.onSurfaceWindowChanged(surface);
        }
        setAlpha(1.0f);
        this.d = eVar;
        this.o = true;
    }

    public final boolean e() {
        if (!this.o) {
            return false;
        }
        Image imageAcquireLatestImage = this.a.acquireLatestImage();
        if (imageAcquireLatestImage != null) {
            Image image = this.b;
            if (image != null) {
                image.close();
                this.b = null;
            }
            this.b = imageAcquireLatestImage;
            invalidate();
        }
        return imageAcquireLatestImage != null;
    }

    public final void g(int i, int i2) {
        if (this.d == null) {
            return;
        }
        if (i == this.a.getWidth() && i2 == this.a.getHeight()) {
            return;
        }
        Image image = this.b;
        if (image != null) {
            image.close();
            this.b = null;
        }
        this.a.close();
        this.a = f(i, i2);
    }

    @Override // sensei0.f50
    public io.flutter.embedding.engine.renderer.e getAttachedRenderer() {
        return this.d;
    }

    public ImageReader getImageReader() {
        return this.a;
    }

    public Surface getSurface() {
        return this.a.getSurface();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Image image = this.b;
        if (image != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                HardwareBuffer hardwareBuffer = image.getHardwareBuffer();
                ColorSpace.Named unused = ColorSpace.Named.SRGB;
                this.c = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
                hardwareBuffer.close();
            } else {
                Image.Plane[] planes = image.getPlanes();
                if (planes.length == 1) {
                    Image.Plane plane = planes[0];
                    int rowStride = plane.getRowStride() / plane.getPixelStride();
                    int height = this.b.getHeight();
                    Bitmap bitmap = this.c;
                    if (bitmap == null || bitmap.getWidth() != rowStride || this.c.getHeight() != height) {
                        this.c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
                    }
                    ByteBuffer buffer = plane.getBuffer();
                    buffer.rewind();
                    this.c.copyPixelsFromBuffer(buffer);
                }
            }
        }
        Bitmap bitmap2 = this.c;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (!this.f) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        setMeasuredDimension(Math.max(View.MeasureSpec.getSize(i), mode == 0 ? 1 : 0), Math.max(View.MeasureSpec.getSize(i2), View.MeasureSpec.getMode(i2) == 0 ? 1 : 0));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!(i == this.a.getWidth() && i2 == this.a.getHeight()) && this.h == 1 && this.o) {
            g(i, i2);
            io.flutter.embedding.engine.renderer.e eVar = this.d;
            Surface surface = this.a.getSurface();
            eVar.c = surface;
            eVar.a.onSurfaceWindowChanged(surface);
        }
    }

    @Override // sensei0.f50
    public final void b() {
    }

    @Override // sensei0.f50
    public final void d() {
    }
}
