package io.flutter.embedding.engine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaExtractor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.trilead.ssh2.sftp.AttribFlags;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.embedding.engine.renderer.e;
import io.flutter.plugin.platform.c;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.TextureRegistry$ImageConsumer;
import io.flutter.view.a;
import io.flutter.view.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.sourceforge.jsocks.Proxy;
import sensei0.a80;
import sensei0.b0;
import sensei0.dm;
import sensei0.e10;
import sensei0.fb0;
import sensei0.g0;
import sensei0.hn;
import sensei0.i3;
import sensei0.ia;
import sensei0.ij0;
import sensei0.in;
import sensei0.j0;
import sensei0.j1;
import sensei0.jj;
import sensei0.jj0;
import sensei0.ln;
import sensei0.m0;
import sensei0.m10;
import sensei0.md;
import sensei0.mh;
import sensei0.mn;
import sensei0.mw;
import sensei0.mz;
import sensei0.nj;
import sensei0.nm;
import sensei0.nn;
import sensei0.o10;
import sensei0.od;
import sensei0.p10;
import sensei0.pm;
import sensei0.q0;
import sensei0.q10;
import sensei0.qf;
import sensei0.qm;
import sensei0.qs;
import sensei0.rb0;
import sensei0.rd;
import sensei0.rm;
import sensei0.rq;
import sensei0.sv;
import sensei0.t0;
import sensei0.u2;
import sensei0.u30;
import sensei0.vl;
import sensei0.vu;
import sensei0.wf0;
import sensei0.wm;
import sensei0.y00;
import sensei0.ya;
import sensei0.z00;
import sensei0.z5;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@qs
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static rm asyncWaitForVsyncDelegate = null;
    private static float displayDensity = -1.0f;
    private static float displayHeight = -1.0f;
    private static float displayWidth = -1.0f;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private static String vmServiceUri;
    private qm accessibilityDelegate;
    private qf deferredComponentManager;
    private vu localizationPlugin;
    private Long nativeShellHolderId;
    private y00 platformMessageHandler;
    private c platformViewsController;
    private q10 platformViewsController2;
    private a80 settingsChannel;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();
    private final Set<dm> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<hn> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private final Set<in> flutterUiResizeListeners = new CopyOnWriteArraySet();
    private final Looper mainLooper = Looper.getMainLooper();

    private static void asyncWaitForVsync(long j) {
        rm rmVar = asyncWaitForVsyncDelegate;
        if (rmVar == null) {
            throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        }
        fb0 fb0Var = (fb0) rmVar;
        fb0Var.getClass();
        Choreographer choreographer = Choreographer.getInstance();
        jj0 jj0Var = (jj0) fb0Var.a;
        ij0 ij0Var = jj0Var.c;
        if (ij0Var != null) {
            ij0Var.a = j;
            jj0Var.c = null;
        } else {
            ij0Var = new ij0(jj0Var, j);
        }
        choreographer.postFrameCallback(ij0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static Bitmap decodeImage(ByteBuffer byteBuffer, long j) {
        rq rqVar;
        sv svVar = 0;
        svVar = 0;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        pm pmVar = new pm(j);
        ya yaVar = new ya();
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr);
        byteBuffer.rewind();
        int iE = 1;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, iRemaining, options);
            yaVar.g = options.outMimeType;
            yaVar.e = options.outHeight;
            yaVar.f = options.outWidth;
        } catch (Exception e) {
            Log.e("BitmapMetadataReader", "Failed to decode image for mime type", e);
        }
        if ("image/heif".equals((String) yaVar.g)) {
            try {
                mw mwVar = new mw(bArr);
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(mwVar);
                wf0.v(yaVar, mediaExtractor);
            } catch (Exception e2) {
                Log.e("MediaMetadataReader", "Failed to decode HEIF image using MediaExtractor", e2);
            }
            nativeImageHeaderCallback(pmVar.a, yaVar.a, yaVar.b);
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    nj njVar = new nj(byteArrayInputStream);
                    jj jjVarC = njVar.c("Orientation");
                    if (jjVarC != null) {
                        try {
                            iE = jjVarC.e(njVar.e);
                        } catch (NumberFormatException unused) {
                        }
                    }
                    yaVar.d = iE;
                    byteArrayInputStream.close();
                } finally {
                }
            } catch (IOException e3) {
                Log.e("ExifMetadataReader", "Failed to read EXIF metadata", e3);
            }
        }
        if ("image/heif".equals((String) yaVar.g)) {
            int i = Build.VERSION.SDK_INT;
            if (i == 36) {
                rqVar = new rq(svVar, 0);
            } else if (i < 36) {
                rqVar = new rq(svVar, 1);
            }
            svVar = rqVar;
        }
        if (svVar == 0) {
            svVar = new sv(28, pmVar);
        }
        return svVar.z(byteBuffer, yaVar);
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    public static String getVMServiceUri() {
        return vmServiceUri;
    }

    private void handlePlatformMessageResponse(int i, ByteBuffer byteBuffer) {
        z5 z5Var;
        y00 y00Var = this.platformMessageHandler;
        if (y00Var == null || (z5Var = (z5) ((rd) y00Var).h.remove(Integer.valueOf(i))) == null) {
            return;
        }
        try {
            z5Var.a(byteBuffer);
            if (byteBuffer == null || !byteBuffer.isDirect()) {
                return;
            }
            byteBuffer.limit(0);
        } catch (Error e) {
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
                throw e;
            }
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, e);
        } catch (Exception e2) {
            Log.e("DartMessenger", "Uncaught exception in binary message reply handler", e2);
        }
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j);

    private native void nativeDeferredComponentInstallFailure(int i, String str, boolean z);

    private native void nativeDestroy(long j);

    private native void nativeDispatchEmptyPlatformMessage(long j, String str, int i);

    private native void nativeDispatchPlatformMessage(long j, String str, ByteBuffer byteBuffer, int i, int i2);

    private native void nativeDispatchPointerDataPacket(long j, ByteBuffer byteBuffer, int i);

    private native void nativeDispatchSemanticsAction(long j, int i, int i2, ByteBuffer byteBuffer, int i3);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i);

    private native Bitmap nativeGetBitmap(long j);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j, int i, int i2);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j, int i);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j, int i);

    private native void nativeInvokePlatformMessageResponseCallback(long j, int i, ByteBuffer byteBuffer, int i2);

    private native boolean nativeIsSurfaceControlEnabled(long j);

    private native void nativeLoadDartDeferredLibrary(long j, int i, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j);

    private native void nativeMarkTextureFrameAvailable(long j, long j2);

    private native void nativeNotifyLowMemoryWarning(long j);

    private native void nativeOnVsync(long j, long j2, long j3);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterImageTexture(long j, long j2, WeakReference<TextureRegistry$ImageConsumer> weakReference, boolean z);

    private native void nativeRegisterTexture(long j, long j2, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j, String str, String str2, String str3, AssetManager assetManager, List<String> list, long j2);

    private native void nativeScheduleFrame(long j);

    private native void nativeSetAccessibilityFeatures(long j, int i);

    private native void nativeSetSemanticsEnabled(long j, boolean z);

    private native void nativeSetViewportMetrics(long j, float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int[] iArr, int[] iArr2, int[] iArr3, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23);

    private native FlutterJNI nativeSpawn(long j, String str, String str2, String str3, List<String> list, long j2);

    private native void nativeSurfaceChanged(long j, int i, int i2);

    private native void nativeSurfaceCreated(long j, Surface surface);

    private native void nativeSurfaceDestroyed(long j);

    private native void nativeSurfaceWindowChanged(long j, Surface surface);

    private native void nativeUnregisterTexture(long j, long j2);

    private native void nativeUpdateDisplayMetrics(long j);

    private native void nativeUpdateJavaAssetManager(long j, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f);

    private void onPreEngineRestart() {
        Iterator<dm> it = this.engineLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void setApplicationLocale(String str) {
        ensureRunningOnMainThread();
        qm qmVar = this.accessibilityDelegate;
        if (qmVar != null) {
            ((a) qmVar).a.m = str;
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        qm qmVar = this.accessibilityDelegate;
        if (qmVar != null) {
            a aVar = (a) qmVar;
            aVar.getClass();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            b bVar = aVar.a;
            bVar.getClass();
            while (byteBuffer.hasRemaining()) {
                j0 j0VarB = bVar.b(byteBuffer.getInt());
                j0VarB.c = byteBuffer.getInt();
                j0VarB.d = b.d(byteBuffer, strArr);
                j0VarB.e = b.d(byteBuffer, strArr);
            }
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        qm qmVar = this.accessibilityDelegate;
        if (qmVar != null) {
            ((a) qmVar).a(byteBuffer, strArr, byteBufferArr);
        }
    }

    public boolean IsSurfaceControlEnabled() {
        return nativeIsSurfaceControlEnabled(this.nativeShellHolderId.longValue());
    }

    public void addEngineLifecycleListener(dm dmVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(dmVar);
    }

    public void addIsDisplayingFlutterUiListener(hn hnVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(hnVar);
    }

    public void addResizingFlutterUiListener(in inVar) {
        ensureRunningOnMainThread();
        this.flutterUiResizeListeners.add(inVar);
    }

    @SuppressLint({"NewApi"})
    public void applyTransactions() {
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("");
        }
        ArrayList arrayList = q10Var.t;
        SurfaceControl.Transaction transactionJ = o10.j();
        for (int i = 0; i < arrayList.size(); i++) {
            transactionJ = transactionJ.merge(t0.j(arrayList.get(i)));
        }
        transactionJ.apply();
        arrayList.clear();
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j) {
        nativeCleanupMessageData(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0128, code lost:
    
        r4 = r0.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012d, code lost:
    
        if (r5 >= r4) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012f, code lost:
    
        r6 = r0.get(r5);
        r5 = r5 + 1;
        r6 = (java.util.Locale) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0143, code lost:
    
        if (r3.getLanguage().equals(r6.toLanguageTag()) == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0146, code lost:
    
        r4 = r0.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x014b, code lost:
    
        if (r5 >= r4) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x014d, code lost:
    
        r6 = r0.get(r5);
        r5 = r5 + 1;
        r6 = (java.util.Locale) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0161, code lost:
    
        if (r3.getLanguage().equals(r6.getLanguage()) == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0164, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String[] computePlatformResolvedLocale(java.lang.String[] r10) {
        /*
            Method dump skipped, instruction units count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.computePlatformResolvedLocale(java.lang.String[]):java.lang.String[]");
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        c cVar = this.platformViewsController;
        if (cVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        Context context = cVar.d.getContext();
        int width = cVar.d.getWidth();
        int height = cVar.d.getHeight();
        q0 q0Var = cVar.q;
        z00 z00Var = new z00(context, width, height, 2);
        z00Var.p = q0Var;
        int i = cVar.x;
        cVar.x = i + 1;
        cVar.v.put(i, z00Var);
        return new FlutterOverlaySurface(i, z00Var.getSurface());
    }

    @SuppressLint({"NewApi"})
    public FlutterOverlaySurface createOverlaySurface2() {
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        if (q10Var.v == null) {
            SurfaceControl.Builder builderH = t0.h();
            builderH.setBufferSize(q10Var.d.getWidth(), q10Var.d.getHeight());
            builderH.setFormat(1);
            builderH.setName("Flutter Overlay Surface");
            builderH.setOpaque(false);
            builderH.setHidden(false);
            SurfaceControl surfaceControlBuild = builderH.build();
            SurfaceControl.Transaction transactionBuildReparentTransaction = q10Var.d.getRootSurfaceControl().buildReparentTransaction(surfaceControlBuild);
            transactionBuildReparentTransaction.setLayer(surfaceControlBuild, 1000);
            transactionBuildReparentTransaction.apply();
            q10Var.v = o10.i(surfaceControlBuild);
            q10Var.w = surfaceControlBuild;
        }
        return new FlutterOverlaySurface(0, q10Var.v);
    }

    @SuppressLint({"NewApi"})
    public SurfaceControl.Transaction createTransaction() {
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("");
        }
        SurfaceControl.Transaction transactionJ = o10.j();
        q10Var.t.add(transactionJ);
        return transactionJ;
    }

    public void deferredComponentInstallFailure(int i, String str, boolean z) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i, str, z);
    }

    @SuppressLint({"NewApi"})
    public void destroyOverlaySurface2() {
        ensureRunningOnMainThread();
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        Surface surface = q10Var.v;
        if (surface != null) {
            surface.release();
            q10Var.v = null;
            q10Var.w = null;
        }
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        c cVar = this.platformViewsController;
        if (cVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        cVar.d();
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i, int i2) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i, i2);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i2);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i);
    }

    public void dispatchSemanticsAction(int i, g0 g0Var) {
        dispatchSemanticsAction(i, g0Var, null);
    }

    @SuppressLint({"NewApi"})
    public void endFrame2() {
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("");
        }
        ArrayList arrayList = q10Var.u;
        SurfaceControl.Transaction transactionJ = o10.j();
        for (int i = 0; i < arrayList.size(); i++) {
            transactionJ = transactionJ.merge(t0.j(arrayList.get(i)));
        }
        arrayList.clear();
        q10Var.d.invalidate();
        q10Var.d.getRootSurfaceControl().applyTransactionOnDraw(transactionJ);
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float getScaledFontSize(float r7, int r8) {
        /*
            r6 = this;
            sensei0.a80 r0 = r6.settingsChannel
            r1 = 0
            if (r0 != 0) goto L6
            goto L70
        L6:
            sensei0.o4 r0 = r0.a
            java.lang.Object r2 = r0.b
            java.util.concurrent.ConcurrentLinkedQueue r2 = (java.util.concurrent.ConcurrentLinkedQueue) r2
            java.lang.Object r3 = r0.c
            sensei0.z70 r3 = (sensei0.z70) r3
            if (r3 != 0) goto L1a
            java.lang.Object r3 = r2.poll()
            sensei0.z70 r3 = (sensei0.z70) r3
            r0.c = r3
        L1a:
            java.lang.Object r3 = r0.c
            sensei0.z70 r3 = (sensei0.z70) r3
            if (r3 == 0) goto L2d
            int r4 = r3.a
            if (r4 >= r8) goto L2d
            java.lang.Object r3 = r2.poll()
            sensei0.z70 r3 = (sensei0.z70) r3
            r0.c = r3
            goto L1a
        L2d:
            java.lang.String r2 = "Cannot find config with generation: "
            java.lang.String r4 = "SettingsChannel"
            if (r3 != 0) goto L49
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r2 = ", after exhausting the queue."
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r4, r0)
        L47:
            r3 = r1
            goto L6b
        L49:
            int r5 = r3.a
            if (r5 == r8) goto L6b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r8)
            java.lang.String r2 = ", the oldest config is now: "
            r3.append(r2)
            java.lang.Object r0 = r0.c
            sensei0.z70 r0 = (sensei0.z70) r0
            int r0 = r0.a
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.e(r4, r0)
            goto L47
        L6b:
            if (r3 != 0) goto L6e
            goto L70
        L6e:
            android.util.DisplayMetrics r1 = r3.b
        L70:
            if (r1 != 0) goto L8d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "getScaledFontSize called with configurationId "
            r7.<init>(r0)
            r7.append(r8)
            java.lang.String r8 = ", which can't be found."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "FlutterJNI"
            android.util.Log.e(r8, r7)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            return r7
        L8d:
            r8 = 2
            float r7 = android.util.TypedValue.applyDimension(r8, r7, r1)
            float r8 = r1.density
            float r7 = r7 / r8
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.getScaledFontSize(float, int):float");
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i, long j) {
        od odVar;
        boolean z;
        y00 y00Var = this.platformMessageHandler;
        if (y00Var == null) {
            nativeCleanupMessageData(j);
            return;
        }
        rd rdVar = (rd) y00Var;
        synchronized (rdVar.d) {
            try {
                odVar = (od) rdVar.b.get(str);
                z = rdVar.f.get() && odVar == null;
                if (z) {
                    if (!rdVar.c.containsKey(str)) {
                        rdVar.c.put(str, new LinkedList());
                    }
                    ((List) rdVar.c.get(str)).add(new md(j, byteBuffer, i));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            return;
        }
        rdVar.a(str, odVar, byteBuffer, i, j);
    }

    @SuppressLint({"NewApi"})
    public void hideOverlaySurface2() {
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        if (q10Var.w == null) {
            return;
        }
        SurfaceControl.Transaction transactionJ = o10.j();
        q10Var.t.add(transactionJ);
        transactionJ.setVisibility(q10Var.w, false);
    }

    @SuppressLint({"NewApi"})
    public void hidePlatformView2(int i) {
        ensureRunningOnMainThread();
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to hide a platform view");
        }
        if (q10Var.a(i)) {
            ((wm) q10Var.r.get(i)).setVisibility(8);
        }
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j, int i) {
        if (initCalled) {
            Log.w(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j, i);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i);
            } else {
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i);
            }
            this.shellHolderLock.readLock().unlock();
        } catch (Throwable th) {
            this.shellHolderLock.readLock().unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v9, types: [io.flutter.embedding.engine.FlutterJNI] */
    public void invokePlatformMessageResponseCallback(int i, ByteBuffer byteBuffer, int i2) throws Throwable {
        FlutterJNI flutterJNIIsAttached;
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
        this.shellHolderLock.readLock().lock();
        try {
            flutterJNIIsAttached = isAttached();
            try {
                if (flutterJNIIsAttached != 0) {
                    FlutterJNI flutterJNI = this;
                    flutterJNI.nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i, byteBuffer, i2);
                    flutterJNIIsAttached = flutterJNI;
                } else {
                    flutterJNIIsAttached = this;
                    Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i);
                }
                flutterJNIIsAttached.shellHolderLock.readLock().unlock();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                flutterJNIIsAttached.shellHolderLock.readLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            flutterJNIIsAttached = this;
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i) {
        return nativeFlutterTextUtilsIsEmoji(i);
    }

    public boolean isCodePointEmojiModifier(int i) {
        return nativeFlutterTextUtilsIsEmojiModifier(i);
    }

    public boolean isCodePointEmojiModifierBase(int i) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i);
    }

    public boolean isCodePointRegionalIndicator(int i) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i);
    }

    public boolean isCodePointVariantSelector(int i) {
        return nativeFlutterTextUtilsIsVariationSelector(i);
    }

    public void loadDartDeferredLibrary(int i, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i, strArr);
    }

    public void loadLibrary(Context context) throws Throwable {
        String[] strArrT;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (loadLibraryCalled) {
            Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        b0 b0Var = new b0(4);
        j1 j1Var = new j1(8);
        j1Var.d = b0Var;
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        j1Var.f("Beginning load of %s...", "flutter");
        mz mzVar = (mz) j1Var.b;
        HashSet hashSet = (HashSet) j1Var.a;
        if (hashSet.contains("flutter")) {
            j1Var.f("%s already loaded previously!", "flutter");
        } else {
            i3 i3Var = null;
            try {
                mzVar.getClass();
                System.loadLibrary("flutter");
                hashSet.add("flutter");
                j1Var.f("%s (%s) was loaded normally!", "flutter", null);
            } catch (UnsatisfiedLinkError e) {
                j1Var.f("Loading the library normally failed: %s", Log.getStackTraceString(e));
                j1Var.f("%s (%s) was not loaded normally, re-linking...", "flutter", null);
                File fileE = j1Var.e(context);
                if (!fileE.exists()) {
                    File dir = context.getDir("lib", 0);
                    File fileE2 = j1Var.e(context);
                    mzVar.getClass();
                    File[] fileArrListFiles = dir.listFiles(new u30(System.mapLibraryName("flutter")));
                    if (fileArrListFiles != null) {
                        for (File file : fileArrListFiles) {
                            if (!file.getAbsolutePath().equals(fileE2.getAbsolutePath())) {
                                file.delete();
                            }
                        }
                    }
                    mh mhVar = (mh) j1Var.c;
                    String[] strArr = Build.SUPPORTED_ABIS;
                    if (strArr.length <= 0) {
                        String str = Build.CPU_ABI2;
                        strArr = (str == null || str.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str};
                    }
                    String strMapLibraryName = System.mapLibraryName("flutter");
                    mhVar.getClass();
                    try {
                        i3 i3VarR = mh.r(context, strArr, strMapLibraryName, j1Var);
                        try {
                            if (i3VarR == null) {
                                try {
                                    strArrT = mh.t(context, strMapLibraryName);
                                } catch (Exception e2) {
                                    strArrT = new String[]{e2.toString()};
                                }
                                StringBuilder sb = new StringBuilder("Could not find '");
                                sb.append(strMapLibraryName);
                                sb.append("'. Looked for: ");
                                sb.append(Arrays.toString(strArr));
                                sb.append(", but only found: ");
                                throw new ia(za0.o(sb, Arrays.toString(strArrT), "."));
                            }
                            ZipFile zipFile = (ZipFile) i3VarR.b;
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                if (i < 5) {
                                    j1Var.f("Found %s! Extracting...", strMapLibraryName);
                                    try {
                                        if (fileE.exists() || fileE.createNewFile()) {
                                            try {
                                                inputStream2 = zipFile.getInputStream((ZipEntry) i3VarR.c);
                                            } catch (FileNotFoundException unused) {
                                                inputStream2 = null;
                                            } catch (IOException unused2) {
                                                inputStream2 = null;
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStream = null;
                                            }
                                            try {
                                                fileOutputStream2 = new FileOutputStream(fileE);
                                                try {
                                                    try {
                                                        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE];
                                                        long j = 0;
                                                        while (true) {
                                                            int i3 = inputStream2.read(bArr);
                                                            if (i3 == -1) {
                                                                break;
                                                            }
                                                            fileOutputStream2.write(bArr, 0, i3);
                                                            j += (long) i3;
                                                        }
                                                        fileOutputStream2.flush();
                                                        fileOutputStream2.getFD().sync();
                                                        if (j == fileE.length()) {
                                                            mh.n(inputStream2);
                                                            mh.n(fileOutputStream2);
                                                            fileE.setReadable(true, false);
                                                            fileE.setExecutable(true, false);
                                                            fileE.setWritable(true);
                                                            break;
                                                        }
                                                    } catch (FileNotFoundException | IOException unused3) {
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    inputStream = inputStream2;
                                                    fileOutputStream = fileOutputStream2;
                                                    mh.n(inputStream);
                                                    mh.n(fileOutputStream);
                                                    throw th;
                                                }
                                            } catch (FileNotFoundException unused4) {
                                                fileOutputStream2 = null;
                                                mh.n(inputStream2);
                                                mh.n(fileOutputStream2);
                                                i = i2;
                                            } catch (IOException unused5) {
                                                fileOutputStream2 = null;
                                                mh.n(inputStream2);
                                                mh.n(fileOutputStream2);
                                                i = i2;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                inputStream = inputStream2;
                                                fileOutputStream = null;
                                                mh.n(inputStream);
                                                mh.n(fileOutputStream);
                                                throw th;
                                            }
                                            mh.n(inputStream2);
                                            mh.n(fileOutputStream2);
                                        }
                                    } catch (IOException unused6) {
                                    }
                                    i = i2;
                                } else if (((b0) j1Var.d) != null) {
                                    lambda$loadLibrary$0("FATAL! Couldn't extract the library from the APK!");
                                }
                            }
                            try {
                                zipFile.close();
                            } catch (IOException unused7) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            i3Var = i3VarR;
                            if (i3Var != null) {
                                try {
                                    ((ZipFile) i3Var.b).close();
                                } catch (IOException unused8) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                String absolutePath = fileE.getAbsolutePath();
                mzVar.getClass();
                System.load(absolutePath);
                hashSet.add("flutter");
                j1Var.f("%s (%s) was re-linked!", "flutter", null);
            }
        }
        loadLibraryCalled = true;
    }

    public void markTextureFrameAvailable(long j) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j);
    }

    public void maybeResizeSurfaceView(int i, int i2) {
        boolean z;
        Iterator<in> it = this.flutterUiResizeListeners.iterator();
        while (it.hasNext()) {
            View view = ((ln) it.next()).a.f;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                boolean z2 = true;
                if (view.getHeight() != i2) {
                    layoutParams.height = i2;
                    z = true;
                } else {
                    z = false;
                }
                if (view.getWidth() != i) {
                    layoutParams.width = i;
                } else {
                    z2 = z;
                }
                if (z2) {
                    view.setLayoutParams(layoutParams);
                }
            } else {
                Log.e("FlutterView", "Flutter engine view not set.");
            }
        }
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        c cVar = this.platformViewsController;
        if (cVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
        }
        cVar.A.clear();
        cVar.B.clear();
    }

    public void onDisplayOverlaySurface(int i, int i2, int i3, int i4, int i5) {
        ensureRunningOnMainThread();
        c cVar = this.platformViewsController;
        if (cVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        SparseArray sparseArray = cVar.v;
        if (sparseArray.get(i) == null) {
            throw new IllegalStateException(za0.i(i, "The overlay surface (id:", ") doesn't exist"));
        }
        cVar.g();
        View view = (z00) sparseArray.get(i);
        if (view.getParent() == null) {
            cVar.d.addView(view);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        view.setLayoutParams(layoutParams);
        view.setVisibility(0);
        view.bringToFront();
        cVar.A.add(Integer.valueOf(i));
    }

    public void onDisplayPlatformView(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        c cVar = this.platformViewsController;
        if (cVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        cVar.g();
        SparseArray sparseArray = cVar.u;
        SparseArray sparseArray2 = cVar.t;
        e10 e10Var = (e10) sparseArray2.get(i);
        if (e10Var == null) {
            return;
        }
        if (sparseArray.get(i) == null) {
            View view = e10Var.getView();
            if (view == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
            if (view.getParent() != null) {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
            vl vlVar = cVar.c;
            wm wmVar = new wm(vlVar, vlVar.getResources().getDisplayMetrics().density, cVar.b);
            wmVar.setOnDescendantFocusChangeListener(new m10(cVar, i, 0));
            sparseArray.put(i, wmVar);
            view.setImportantForAccessibility(4);
            wmVar.addView(view);
            cVar.d.addView(wmVar);
        }
        wm wmVar2 = (wm) sparseArray.get(i);
        wmVar2.a = flutterMutatorsStack;
        wmVar2.c = i2;
        wmVar2.d = i3;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5, 51);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = i3;
        wmVar2.setLayoutParams(layoutParams);
        wmVar2.setWillNotDraw(false);
        wmVar2.setVisibility(0);
        wmVar2.bringToFront();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i6, i7);
        View view2 = ((e10) sparseArray2.get(i)).getView();
        if (view2 != null) {
            view2.setLayoutParams(layoutParams2);
            view2.bringToFront();
        }
        cVar.B.add(Integer.valueOf(i));
    }

    @SuppressLint({"NewApi"})
    public void onDisplayPlatformView2(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        if (q10Var.a(i)) {
            wm wmVar = (wm) q10Var.r.get(i);
            wmVar.a = flutterMutatorsStack;
            wmVar.c = i2;
            wmVar.d = i3;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5, 51);
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = i3;
            wmVar.setLayoutParams(layoutParams);
            wmVar.setWillNotDraw(false);
            wmVar.setVisibility(0);
            wmVar.bringToFront();
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i6, i7, 51);
            View view = ((e10) q10Var.q.get(i)).getView();
            if (view != null) {
                view.setLayoutParams(layoutParams2);
                view.bringToFront();
                if (view instanceof SurfaceView) {
                    SurfaceView surfaceView = (SurfaceView) view;
                    HashSet hashSet = q10Var.x;
                    RectF rectF = new RectF(i2, i3, i4 + i2, i5 + i3);
                    Rect rect = new Rect();
                    rectF.roundOut(rect);
                    List<Path> finalClippingPaths = flutterMutatorsStack.getFinalClippingPaths();
                    if (finalClippingPaths != null && !finalClippingPaths.isEmpty()) {
                        RectF rectF2 = new RectF();
                        Iterator<Path> it = finalClippingPaths.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            it.next().computeBounds(rectF2, true);
                            Rect rect2 = new Rect();
                            rectF2.roundOut(rect2);
                            if (!rect.intersect(rect2)) {
                                rect.setEmpty();
                                break;
                            }
                        }
                    }
                    rect.offset(-i2, -i3);
                    if (rect.width() < 0 || rect.height() < 0) {
                        rect.setEmpty();
                    }
                    float finalOpacity = flutterMutatorsStack.getFinalOpacity();
                    SurfaceControl surfaceControl = surfaceView.getSurfaceControl();
                    if (surfaceControl == null) {
                        if (hashSet.contains(Integer.valueOf(i))) {
                            return;
                        }
                        hashSet.add(Integer.valueOf(i));
                        surfaceView.getHolder().addCallback(new p10(q10Var, surfaceView, finalOpacity, rect, i));
                        return;
                    }
                    if (!surfaceControl.isValid()) {
                        surfaceView.getId();
                        return;
                    }
                    SurfaceControl.Transaction transactionJ = o10.j();
                    q10Var.t.add(transactionJ);
                    transactionJ.setAlpha(surfaceControl, finalOpacity).setCrop(surfaceControl, rect);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, sensei0.f50] */
    public void onEndFrame() {
        f50 r3;
        ensureRunningOnMainThread();
        c cVar = this.platformViewsController;
        if (cVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
        }
        boolean z = false;
        if (!cVar.y || !cVar.B.isEmpty()) {
            if (cVar.y) {
                nm nmVar = cVar.d.d;
                if (nmVar != null ? nmVar.e() : false) {
                    z = true;
                }
            }
            cVar.e(z);
            return;
        }
        cVar.y = false;
        nn nnVar = cVar.d;
        u2 u2Var = new u2(10, cVar);
        nm nmVar2 = nnVar.d;
        if (nmVar2 == null || (r3 = (f50) nnVar.h) == null) {
            return;
        }
        nnVar.f = r3;
        nnVar.h = null;
        e eVar = nnVar.q.b;
        if (eVar != null) {
            r3.b();
            eVar.a(new mn(nnVar, eVar, u2Var));
            return;
        }
        nmVar2.a();
        nm nmVar3 = nnVar.d;
        if (nmVar3 != null) {
            nmVar3.a.close();
            nnVar.removeView(nnVar.d);
            nnVar.d = null;
        }
        u2Var.run();
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        Iterator<hn> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        Iterator<hn> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void onSurfaceChanged(int i, int i2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i, i2);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j, long j2, long j3) {
        nativeOnVsync(j, j2, j3);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerImageTexture(long j, TextureRegistry$ImageConsumer textureRegistry$ImageConsumer, boolean z) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterImageTexture(this.nativeShellHolderId.longValue(), j, new WeakReference<>(textureRegistry$ImageConsumer), z);
    }

    public void registerTexture(long j, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j, new WeakReference<>(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(dm dmVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(dmVar);
    }

    public void removeIsDisplayingFlutterUiListener(hn hnVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(hnVar);
    }

    public void removeResizingFlutterUiListener(in inVar) {
        ensureRunningOnMainThread();
        this.flutterUiResizeListeners.remove(inVar);
    }

    public void requestDartDeferredLibrary(int i) {
        Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list, long j) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list, j);
    }

    public void scheduleFrame() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeScheduleFrame(this.nativeShellHolderId.longValue());
    }

    public void setAccessibilityDelegate(qm qmVar) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = qmVar;
    }

    public void setAccessibilityFeatures(int i) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setAccessibilityFeaturesInNative(i);
        }
    }

    public void setAccessibilityFeaturesInNative(int i) {
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i);
    }

    public void setAsyncWaitForVsyncDelegate(rm rmVar) {
        asyncWaitForVsyncDelegate = rmVar;
    }

    public void setDeferredComponentManager(qf qfVar) {
        ensureRunningOnMainThread();
        if (qfVar != null) {
            qfVar.a();
        }
    }

    public void setLocalizationPlugin(vu vuVar) {
        ensureRunningOnMainThread();
        this.localizationPlugin = vuVar;
    }

    public void setPlatformMessageHandler(y00 y00Var) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = y00Var;
    }

    public void setPlatformViewsController(c cVar) {
        ensureRunningOnMainThread();
        this.platformViewsController = cVar;
    }

    public void setPlatformViewsController2(q10 q10Var) {
        ensureRunningOnMainThread();
        this.platformViewsController2 = q10Var;
    }

    public void setRefreshRateFPS(float f) {
        refreshRateFPS = f;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setSemanticsEnabledInNative(z);
        }
    }

    public void setSemanticsEnabledInNative(boolean z) {
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z);
    }

    public void setSemanticsTreeEnabled(boolean z) {
        ensureRunningOnMainThread();
        qm qmVar = this.accessibilityDelegate;
        if (qmVar == null || z) {
            return;
        }
        b bVar = ((a) qmVar).a;
        bVar.g.clear();
        m0 m0Var = bVar.i;
        if (m0Var != null) {
            bVar.h(m0Var.b, Proxy.SOCKS_NO_PROXY);
        }
        bVar.i = null;
        bVar.p = null;
        bVar.j(0, 1);
    }

    public void setSettingsChannel(a80 a80Var) {
        ensureRunningOnMainThread();
        this.settingsChannel = a80Var;
    }

    public void setViewportMetrics(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int[] iArr, int[] iArr2, int[] iArr3, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, iArr, iArr2, iArr3, i16, i17, i18, i19, i20, i21, i22, i23);
    }

    @SuppressLint({"NewApi"})
    public void showOverlaySurface2() {
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        if (q10Var.w == null) {
            return;
        }
        SurfaceControl.Transaction transactionJ = o10.j();
        q10Var.t.add(transactionJ);
        transactionJ.setVisibility(q10Var.w, true);
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list, long j) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI flutterJNINativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list, j);
        Long l = flutterJNINativeSpawn.nativeShellHolderId;
        if ((l == null || l.longValue() == 0) ? false : true) {
            return flutterJNINativeSpawn;
        }
        throw new IllegalStateException("Failed to spawn new JNI connected shell from existing shell.");
    }

    @SuppressLint({"NewApi"})
    public void swapTransactions() {
        q10 q10Var = this.platformViewsController2;
        if (q10Var == null) {
            throw new RuntimeException("");
        }
        synchronized (q10Var) {
            q10Var.u.clear();
            q10Var.u.addAll(q10Var.t);
            q10Var.t.clear();
        }
    }

    public void unregisterTexture(long j) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j);
    }

    public void updateDisplayMetrics(int i, float f, float f2, float f3) {
        displayWidth = f;
        displayHeight = f2;
        displayDensity = f3;
        if (loadLibraryCalled) {
            nativeUpdateDisplayMetrics(this.nativeShellHolderId.longValue());
        }
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }

    public void dispatchSemanticsAction(int i, g0 g0Var, Object obj) {
        ByteBuffer byteBufferA;
        int iPosition;
        ensureAttachedToNative();
        if (obj != null) {
            byteBufferA = rb0.a.a(obj);
            iPosition = byteBufferA.position();
        } else {
            byteBufferA = null;
            iPosition = 0;
        }
        dispatchSemanticsAction(i, g0Var.a, byteBufferA, iPosition);
    }

    public void dispatchSemanticsAction(int i, int i2, ByteBuffer byteBuffer, int i3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i, i2, byteBuffer, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadLibrary$0(String str) {
    }
}
