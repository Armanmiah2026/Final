package io.flutter.embedding.engine.renderer;

import android.hardware.SyncFence;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import io.flutter.view.TextureRegistry$ImageConsumer;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import sensei0.bn;
import sensei0.ee0;
import sensei0.fe0;
import sensei0.qs;
import sensei0.w0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@qs
final class FlutterRenderer$ImageReaderSurfaceProducer implements TextureRegistry$SurfaceProducer, TextureRegistry$ImageConsumer, ee0 {
    private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
    private static final int MAX_DEQUEUED_IMAGES = 2;
    private static final int MAX_IMAGES = 7;
    private static final String TAG = "ImageReaderSurfaceProducer";
    private static final boolean VERBOSE_LOGS = false;
    private static final boolean trimOnMemoryPressure = true;
    fe0 callback;
    private final long id;
    private boolean released;
    final /* synthetic */ e this$0;
    private boolean ignoringFence = VERBOSE_LOGS;
    private int requestedWidth = 1;
    private int requestedHeight = 1;
    private boolean createNewReader = true;
    boolean notifiedDestroy = VERBOSE_LOGS;
    private long lastDequeueTime = 0;
    private long lastQueueTime = 0;
    private long lastScheduleTime = 0;
    private int numTrims = 0;
    private final Object lock = new Object();
    private final ArrayDeque<d> imageReaderQueue = new ArrayDeque<>();
    private final HashMap<ImageReader, d> perImageReaders = new HashMap<>();
    private ArrayList<b> lastDequeuedImage = new ArrayList<>();
    private d lastReaderDequeuedFrom = null;

    public FlutterRenderer$ImageReaderSurfaceProducer(e eVar, long j) {
        this.this$0 = eVar;
        this.id = j;
    }

    private void cleanup() {
        synchronized (this.lock) {
            try {
                for (d dVar : this.perImageReaders.values()) {
                    if (this.lastReaderDequeuedFrom == dVar) {
                        this.lastReaderDequeuedFrom = null;
                    }
                    dVar.c = true;
                    dVar.a.close();
                    dVar.b.clear();
                }
                this.perImageReaders.clear();
                if (this.lastDequeuedImage.size() > 0) {
                    ArrayList<b> arrayList = this.lastDequeuedImage;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        b bVar = arrayList.get(i);
                        i++;
                        bVar.a.close();
                    }
                    this.lastDequeuedImage.clear();
                }
                d dVar2 = this.lastReaderDequeuedFrom;
                if (dVar2 != null) {
                    dVar2.c = true;
                    dVar2.a.close();
                    dVar2.b.clear();
                    this.lastReaderDequeuedFrom = null;
                }
                this.imageReaderQueue.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private ImageReader createImageReader29() {
        return ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 7, 256L);
    }

    private ImageReader createImageReader33() {
        w0.l();
        ImageReader.Builder builderC = w0.c(this.requestedWidth, this.requestedHeight);
        builderC.setMaxImages(7);
        builderC.setImageFormat(34);
        builderC.setUsage(256L);
        return builderC.build();
    }

    private d getActiveReader() {
        synchronized (this.lock) {
            try {
                if (!this.createNewReader) {
                    d dVarPeekLast = this.imageReaderQueue.peekLast();
                    if (dVarPeekLast.a.getSurface().isValid()) {
                        return dVarPeekLast;
                    }
                }
                this.createNewReader = VERBOSE_LOGS;
                return getOrCreatePerImageReader(createImageReader());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private d getOrCreatePerImageReader(ImageReader imageReader) {
        d dVar = this.perImageReaders.get(imageReader);
        if (dVar != null) {
            return dVar;
        }
        d dVarCreatePerImageReader = createPerImageReader(imageReader);
        this.perImageReaders.put(imageReader, dVarCreatePerImageReader);
        this.imageReaderQueue.add(dVarCreatePerImageReader);
        return dVarCreatePerImageReader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$dequeueImage$0() {
        if (this.released) {
            return;
        }
        this.this$0.a.scheduleFrame();
    }

    private void maybeWaitOnFence(Image image) {
        if (image == null || this.ignoringFence) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            waitOnFence(image);
        } else {
            this.ignoringFence = true;
        }
    }

    private void releaseInternal() {
        cleanup();
        this.released = true;
        this.this$0.h(this);
        this.this$0.g.remove(this);
    }

    @Override // io.flutter.view.TextureRegistry$ImageConsumer
    public Image acquireLatestImage() {
        b bVarDequeueImage = dequeueImage();
        if (bVarDequeueImage == null) {
            return null;
        }
        Image image = bVarDequeueImage.a;
        maybeWaitOnFence(image);
        return image;
    }

    public ImageReader createImageReader() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return createImageReader33();
        }
        if (i >= 29) {
            return createImageReader29();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    public d createPerImageReader(ImageReader imageReader) {
        return new d(this, imageReader);
    }

    public double deltaMillis(long j) {
        return j / 1000000.0d;
    }

    public b dequeueImage() {
        b bVar;
        boolean z;
        synchronized (this.lock) {
            try {
                Iterator<d> it = this.imageReaderQueue.iterator();
                bVar = null;
                while (true) {
                    boolean zHasNext = it.hasNext();
                    z = VERBOSE_LOGS;
                    if (!zHasNext) {
                        break;
                    }
                    d next = it.next();
                    ArrayDeque arrayDeque = next.b;
                    b bVar2 = arrayDeque.isEmpty() ? null : (b) arrayDeque.removeFirst();
                    if (bVar2 == null) {
                        bVar = bVar2;
                    } else {
                        while (this.lastDequeuedImage.size() > 2) {
                            this.lastDequeuedImage.remove(0).a.close();
                        }
                        this.lastDequeuedImage.add(bVar2);
                        this.lastReaderDequeuedFrom = next;
                        bVar = bVar2;
                    }
                }
                pruneImageReaderQueue();
                Iterator<d> it2 = this.imageReaderQueue.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().b.isEmpty()) {
                        z = true;
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            this.this$0.e.post(new Runnable() { // from class: io.flutter.embedding.engine.renderer.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.lambda$dequeueImage$0();
                }
            });
        }
        return bVar;
    }

    public void disableFenceForTest() {
        this.ignoringFence = true;
    }

    public void finalize() throws Throwable {
        try {
            if (this.released) {
                return;
            }
            releaseInternal();
            e eVar = this.this$0;
            eVar.e.post(new bn(this.id, eVar.a));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public Surface getForcedNewSurface() {
        this.createNewReader = true;
        return getSurface();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public int getHeight() {
        return this.requestedHeight;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public Surface getSurface() {
        return getActiveReader().a.getSurface();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public int getWidth() {
        return this.requestedWidth;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public boolean handlesCropAndRotation() {
        return VERBOSE_LOGS;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public long id() {
        return this.id;
    }

    public int numImageReaders() {
        int size;
        synchronized (this.lock) {
            size = this.imageReaderQueue.size();
        }
        return size;
    }

    public int numImages() {
        int size;
        synchronized (this.lock) {
            try {
                Iterator<d> it = this.imageReaderQueue.iterator();
                size = 0;
                while (it.hasNext()) {
                    size += it.next().b.size();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return size;
    }

    public int numTrims() {
        int i;
        synchronized (this.lock) {
            i = this.numTrims;
        }
        return i;
    }

    public void onImage(ImageReader imageReader, Image image) {
        b bVar;
        synchronized (this.lock) {
            d orCreatePerImageReader = getOrCreatePerImageReader(imageReader);
            ArrayDeque arrayDeque = orCreatePerImageReader.b;
            if (orCreatePerImageReader.c) {
                bVar = null;
            } else {
                FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer = orCreatePerImageReader.d;
                System.nanoTime();
                b bVar2 = new b(flutterRenderer$ImageReaderSurfaceProducer, image);
                arrayDeque.add(bVar2);
                while (arrayDeque.size() > 2) {
                    ((b) arrayDeque.removeFirst()).a.close();
                }
                bVar = bVar2;
            }
        }
        if (bVar == null) {
            return;
        }
        this.this$0.a.scheduleFrame();
    }

    @Override // sensei0.ee0
    public void onTrimMemory(int i) {
        if (i < 40) {
            return;
        }
        synchronized (this.lock) {
            this.numTrims++;
        }
        cleanup();
        this.createNewReader = true;
    }

    public int pendingDequeuedImages() {
        return this.lastDequeuedImage.size();
    }

    public void pruneImageReaderQueue() {
        d dVarPeekFirst;
        while (this.imageReaderQueue.size() > 1 && (dVarPeekFirst = this.imageReaderQueue.peekFirst()) != null) {
            ImageReader imageReader = dVarPeekFirst.a;
            ArrayDeque arrayDeque = dVarPeekFirst.b;
            if (!arrayDeque.isEmpty() || dVarPeekFirst.d.lastReaderDequeuedFrom == dVarPeekFirst) {
                return;
            }
            this.imageReaderQueue.removeFirst();
            this.perImageReaders.remove(imageReader);
            dVarPeekFirst.c = true;
            imageReader.close();
            arrayDeque.clear();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void release() {
        if (this.released) {
            return;
        }
        releaseInternal();
        e eVar = this.this$0;
        eVar.a.unregisterTexture(this.id);
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void scheduleFrame() {
        this.this$0.a.scheduleFrame();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void setSize(int i, int i2) {
        int iMax = Math.max(1, i);
        int iMax2 = Math.max(1, i2);
        if (this.requestedWidth == iMax && this.requestedHeight == iMax2) {
            return;
        }
        this.createNewReader = true;
        this.requestedHeight = iMax2;
        this.requestedWidth = iMax;
    }

    public void waitOnFence(Image image) {
        try {
            SyncFence fence = image.getFence();
            try {
                fence.awaitForever();
                fence.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void setCallback(fe0 fe0Var) {
    }
}
