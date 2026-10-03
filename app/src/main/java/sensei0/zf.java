package sensei0;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import com.trilead.ssh2.packets.Packets;
import com.trilead.ssh2.sftp.ErrorCodes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zf {
    public boolean a;
    public final Object b;
    public final Object c;
    public final Object d;
    public Object e;
    public final Serializable f;
    public Object g;
    public Object h;

    public zf(Context context, em emVar, um umVar) {
        this.b = new HashMap();
        this.f = new HashMap();
        this.a = false;
        new HashMap();
        new HashMap();
        new HashMap();
        this.c = emVar;
        this.d = umVar;
        kd kdVar = emVar.c;
        lm lmVar = emVar.s.a;
        sv svVar = new sv(23, umVar);
        j1 j1Var = new j1();
        j1Var.a = context;
        j1Var.b = kdVar;
        j1Var.c = lmVar;
        j1Var.d = svVar;
        this.e = j1Var;
    }

    public void a(xm xmVar) {
        HashMap map = (HashMap) this.b;
        df0.b("FlutterEngineConnectionRegistry#add ".concat(xmVar.getClass().getSimpleName()));
        try {
            if (map.containsKey(xmVar.getClass())) {
                Log.w("FlutterEngineCxnRegstry", "Attempted to register plugin (" + xmVar + ") but it was already registered with this FlutterEngine (" + ((em) this.c) + ").");
                Trace.endSection();
                return;
            }
            xmVar.toString();
            map.put(xmVar.getClass(), xmVar);
            xmVar.g((j1) this.e);
            if (xmVar instanceof l2) {
                l2 l2Var = (l2) xmVar;
                ((HashMap) this.f).put(xmVar.getClass(), l2Var);
                if (f()) {
                    l2Var.d((af0) this.h);
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void b(vl vlVar, vt vtVar) {
        this.h = new af0(vlVar, vtVar);
        Intent intent = vlVar.getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("enable-software-rendering", false) : false;
        if (booleanExtra) {
            String str = hm.h.b;
        } else {
            booleanExtra = ((um) this.d).a;
        }
        em emVar = (em) this.c;
        emVar.s.D = booleanExtra;
        i3 i3Var = emVar.u;
        io.flutter.embedding.engine.renderer.e eVar = emVar.b;
        kd kdVar = emVar.c;
        io.flutter.plugin.platform.c cVar = (io.flutter.plugin.platform.c) i3Var.b;
        if (cVar.c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        cVar.c = vlVar;
        cVar.h = eVar;
        cVar.p = new i3(kdVar, 23);
        q10 q10Var = (q10) i3Var.c;
        if (q10Var.c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        q10Var.c = vlVar;
        i3 i3Var2 = new i3(kdVar, 22);
        q10Var.o = i3Var2;
        i3Var2.c = q10Var.y;
        cVar.p.c = i3Var;
        for (l2 l2Var : ((HashMap) this.f).values()) {
            if (this.a) {
                l2Var.c((af0) this.h);
            } else {
                l2Var.d((af0) this.h);
            }
        }
        this.a = false;
    }

    public void c() {
        if (!f()) {
            Log.e("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        df0.b("FlutterEngineConnectionRegistry#detachFromActivity");
        try {
            Iterator it = ((HashMap) this.f).values().iterator();
            while (it.hasNext()) {
                ((l2) it.next()).b();
            }
            d();
            Trace.endSection();
        } catch (Throwable th) {
            try {
                Trace.endSection();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void d() {
        em emVar = (em) this.c;
        io.flutter.plugin.platform.c cVar = emVar.s;
        i3 i3Var = cVar.p;
        if (i3Var != null) {
            i3Var.c = null;
        }
        cVar.d();
        cVar.p = null;
        cVar.c = null;
        cVar.h = null;
        q10 q10Var = emVar.t;
        i3 i3Var2 = q10Var.o;
        if (i3Var2 != null) {
            i3Var2.c = null;
        }
        Surface surface = q10Var.v;
        if (surface != null) {
            surface.release();
            q10Var.v = null;
            q10Var.w = null;
        }
        q10Var.o = null;
        q10Var.c = null;
        this.g = null;
        this.h = null;
    }

    public void e() {
        if (f()) {
            c();
        }
    }

    public boolean f() {
        return ((zl) this.g) != null;
    }

    public FileInputStream g(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            ((u20) this.c).b();
            return null;
        }
    }

    public void h(int i, Serializable serializable) {
        ((Executor) this.b).execute(new yf(this, i, serializable));
    }

    public zf(AssetManager assetManager, Executor executor, u20 u20Var, String str, File file) {
        this.a = false;
        this.b = executor;
        this.c = u20Var;
        this.g = str;
        this.f = file;
        int i = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i <= 34) {
            switch (i) {
                case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                    bArr = xe.s;
                    break;
                case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                    bArr = xe.r;
                    break;
                case ErrorCodes.SSH_FX_DELETE_PENDING /* 27 */:
                    bArr = xe.q;
                    break;
                case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                case ErrorCodes.SSH_FX_OWNER_INVALID /* 29 */:
                case 30:
                    bArr = xe.p;
                    break;
                case 31:
                case 32:
                case Packets.SSH_MSG_KEX_DH_GEX_REPLY /* 33 */:
                case Packets.SSH_MSG_KEX_DH_GEX_REQUEST /* 34 */:
                    bArr = xe.o;
                    break;
            }
        }
        this.d = bArr;
    }
}
