package sensei0;

import android.content.Context;
import android.graphics.Typeface;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.os.Trace;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.sensei.tunnel.MainActivity;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ u2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zIsEmpty;
        LocalSocket localSocketAccept;
        int i;
        List listE;
        boolean z = false;
        Object[] objArr = 0;
        switch (this.a) {
            case 0:
                v2 v2Var = (v2) this.b;
                if (v2Var.j) {
                    return;
                }
                while (true) {
                    WeakReference weakReference = (WeakReference) v2Var.e.poll();
                    if (weakReference == null) {
                        v2Var.g.postDelayed(v2Var.h, v2Var.k);
                        return;
                    }
                    HashMap map = v2Var.f;
                    if (map instanceof os) {
                        wf0.G("kotlin.collections.MutableMap", map);
                        throw null;
                    }
                    Long l = (Long) map.remove(weakReference);
                    if (l != null) {
                        v2Var.c.remove(l);
                        v2Var.d.remove(l);
                        new j1(((z2) v2Var.a.b).a, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", (dx) z2.b.a(), null).k(k6.G(l), new x2(objArr == true ? 1 : 0, new c3(l.longValue())));
                    }
                }
                break;
            case 1:
                ((CarouselLayoutManager) this.b).M();
                return;
            case 2:
                ((b9) this.b).s(true);
                return;
            case 3:
                qd qdVar = (qd) this.b;
                ExecutorService executorService = qdVar.a;
                ConcurrentLinkedQueue concurrentLinkedQueue = qdVar.b;
                AtomicBoolean atomicBoolean = qdVar.c;
                if (atomicBoolean.compareAndSet(false, true)) {
                    int i2 = 3;
                    try {
                        Runnable runnable = (Runnable) concurrentLinkedQueue.poll();
                        if (runnable != null) {
                            runnable.run();
                        }
                        if (zIsEmpty) {
                            return;
                        } else {
                            return;
                        }
                    } finally {
                        atomicBoolean.set(false);
                        if (!concurrentLinkedQueue.isEmpty()) {
                            executorService.execute(new u2(i2, qdVar));
                        }
                    }
                    break;
                }
                return;
            case 4:
                jh jhVar = (jh) this.b;
                boolean zIsPopupShowing = jhVar.h.isPopupShowing();
                jhVar.s(zIsPopupShowing);
                jhVar.m = zIsPopupShowing;
                return;
            case 5:
                ((sm) this.b).b.f.prefetchDefaultFontManager();
                return;
            case 6:
                ((an) this.b).getClass();
                return;
            case 7:
                yn ynVar = (yn) this.b;
                synchronized (ynVar.d) {
                    try {
                        if (ynVar.p == null) {
                            return;
                        }
                        try {
                            jo joVarB = ynVar.b();
                            int i3 = joVarB.f;
                            if (i3 == 2) {
                                synchronized (ynVar.d) {
                                }
                            }
                            if (i3 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i3 + ")");
                            }
                            try {
                                int i4 = cf0.a;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                pf pfVar = ynVar.c;
                                Context context = ynVar.a;
                                pfVar.getClass();
                                jo[] joVarArr = {joVarB};
                                pr prVar = xf0.a;
                                Trace.beginSection(mm0.l0("TypefaceCompat.createFromFontInfo"));
                                try {
                                    Typeface typefaceO = xf0.a.o(context, joVarArr, 0);
                                    Trace.endSection();
                                    MappedByteBuffer mappedByteBufferR = wf0.r(ynVar.a, joVarB.a);
                                    if (mappedByteBufferR == null || typefaceO == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        j1 j1Var = new j1(typefaceO, wf0.u(mappedByteBufferR));
                                        Trace.endSection();
                                        synchronized (ynVar.d) {
                                            try {
                                                mm0 mm0Var = ynVar.p;
                                                if (mm0Var != null) {
                                                    mm0Var.S(j1Var);
                                                }
                                            } finally {
                                            }
                                            break;
                                        }
                                        ynVar.a();
                                        return;
                                    } finally {
                                        int i5 = cf0.a;
                                    }
                                } finally {
                                    Trace.endSection();
                                }
                            } finally {
                            }
                            break;
                        } catch (Throwable th) {
                            synchronized (ynVar.d) {
                                try {
                                    mm0 mm0Var2 = ynVar.p;
                                    if (mm0Var2 != null) {
                                        mm0Var2.P(th);
                                    }
                                    ynVar.a();
                                    return;
                                } finally {
                                }
                            }
                        }
                    } finally {
                    }
                }
            case 8:
                rk rkVar = (rk) this.b;
                boolean z2 = MainActivity.B;
                rkVar.a("missing_apk", "Downloaded APK not found", null);
                return;
            case 9:
                cz czVar = (cz) this.b;
                AtomicBoolean atomicBoolean2 = czVar.k;
                try {
                    LocalServerSocket localServerSocket = czVar.o;
                    if (localServerSocket != null && (localSocketAccept = localServerSocket.accept()) != null) {
                        czVar.q = localSocketAccept;
                        try {
                            LocalServerSocket localServerSocket2 = czVar.o;
                            if (localServerSocket2 != null) {
                                localServerSocket2.close();
                            }
                            break;
                        } catch (Exception unused) {
                        }
                        czVar.f("version 3\n");
                        InputStream inputStream = localSocketAccept.getInputStream();
                        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE];
                        String str = "";
                        while (atomicBoolean2.get() && (i = inputStream.read(bArr)) >= 0) {
                            try {
                                FileDescriptor[] ancillaryFileDescriptors = localSocketAccept.getAncillaryFileDescriptors();
                                if (ancillaryFileDescriptors != null) {
                                    for (FileDescriptor fileDescriptor : ancillaryFileDescriptors) {
                                        if (fileDescriptor != null) {
                                            czVar.s.addLast(fileDescriptor);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                Log.w("OpenVpn2Engine", "ancillary fds: " + e.getMessage());
                            }
                            String str2 = str + new String(bArr, 0, i, e8.a);
                            while (true) {
                                str = str2;
                                while (fc0.e0(str, "\n", false)) {
                                    listE = new b50("\\r?\\n").e(2, str);
                                    czVar.d((String) listE.get(0));
                                    if (listE.size() == 1) {
                                        str = "";
                                    }
                                }
                                str2 = (String) listE.get(1);
                            }
                            break;
                        }
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    if (atomicBoolean2.get()) {
                        Log.w("OpenVpn2Engine", "management thread: " + e2.getMessage());
                        return;
                    }
                    return;
                }
            case 10:
                ((io.flutter.plugin.platform.c) this.b).e(false);
                return;
            case 11:
                o20 o20Var = (o20) this.b;
                vt vtVar = o20Var.h;
                if (o20Var.b == 0) {
                    o20Var.c = true;
                    vtVar.e(lt.ON_PAUSE);
                }
                if (o20Var.a == 0 && o20Var.c) {
                    vtVar.e(lt.ON_STOP);
                    o20Var.d = true;
                    return;
                }
                return;
            case 12:
                ((q30) this.b).e();
                return;
            case 13:
                i5 i5Var = (i5) this.b;
                i5Var.c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) i5Var.e;
                ci0 ci0Var = sideSheetBehavior.i;
                if (ci0Var != null && ci0Var.f()) {
                    i5Var.a(i5Var.b);
                    return;
                } else {
                    if (sideSheetBehavior.h == 2) {
                        sideSheetBehavior.r(i5Var.b);
                        return;
                    }
                    return;
                }
            case 14:
                ((TextInputLayout) this.b).d.requestLayout();
                return;
            default:
                View view = (View) this.b;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                return;
        }
    }
}
