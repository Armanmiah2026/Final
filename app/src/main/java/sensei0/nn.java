package sensei0;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import com.trilead.ssh2.sftp.AttribFlags;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nn extends FrameLayout implements ay, zs {
    public fb0 A;
    public final cn B;
    public final sv C;
    public final kn D;
    public final ln E;
    public final wl F;
    public jn G;
    public int H;
    public int I;
    public pn J;
    public boolean a;
    public final en b;
    public final gn c;
    public nm d;
    public View f;
    public View h;
    public final HashSet o;
    public boolean p;
    public em q;
    public final HashSet r;
    public i3 s;
    public io.flutter.plugin.editing.b t;
    public gb0 u;
    public vu v;
    public o4 w;
    public s2 x;
    public io.flutter.view.b y;
    public TextServicesManager z;

    public nn(vl vlVar, en enVar) {
        super(vlVar, null);
        this.a = false;
        this.o = new HashSet();
        this.r = new HashSet();
        this.B = new cn();
        this.C = new sv(25, this);
        this.D = new kn(this, new Handler(Looper.getMainLooper()));
        this.E = new ln(this);
        this.F = new wl(2, this);
        this.J = new pn();
        this.b = enVar;
        this.f = enVar;
        b();
    }

    /* JADX WARN: Type inference failed for: r0v36, types: [android.view.View, sensei0.f50] */
    public final void a() {
        UiModeManager uiModeManager;
        Objects.toString(this.q);
        if (c()) {
            Iterator it = this.r.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            getContext().getContentResolver().unregisterContentObserver(this.D);
            io.flutter.plugin.platform.c cVar = this.q.s;
            SparseArray sparseArray = cVar.t;
            SparseArray sparseArray2 = cVar.u;
            SparseArray sparseArray3 = cVar.w;
            for (int i = 0; i < sparseArray3.size(); i++) {
                cVar.d.removeView((i10) sparseArray3.valueAt(i));
            }
            for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
                cVar.d.removeView((wm) sparseArray2.valueAt(i2));
            }
            cVar.d();
            SparseArray sparseArray4 = cVar.v;
            if (cVar.d == null) {
                Log.e("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
            } else {
                for (int i3 = 0; i3 < sparseArray4.size(); i3++) {
                    cVar.d.removeView((View) sparseArray4.valueAt(i3));
                }
                sparseArray4.clear();
            }
            cVar.d = null;
            cVar.y = false;
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                ((e10) sparseArray.valueAt(i4)).getClass();
            }
            q10 q10Var = this.q.t;
            SparseArray sparseArray5 = q10Var.q;
            SparseArray sparseArray6 = q10Var.r;
            for (int i5 = 0; i5 < sparseArray6.size(); i5++) {
                q10Var.d.removeView((wm) sparseArray6.valueAt(i5));
            }
            Surface surface = q10Var.v;
            if (surface != null) {
                surface.release();
                q10Var.v = null;
                q10Var.w = null;
            }
            q10Var.d = null;
            for (int i6 = 0; i6 < sparseArray5.size(); i6++) {
                ((e10) sparseArray5.valueAt(i6)).getClass();
            }
            this.q.s.o();
            this.q.t.o();
            io.flutter.view.b bVar = this.y;
            bVar.u = true;
            bVar.e.o();
            bVar.s = null;
            AccessibilityManager accessibilityManager = bVar.c;
            accessibilityManager.removeAccessibilityStateChangeListener(bVar.v);
            accessibilityManager.removeTouchExplorationStateChangeListener(bVar.w);
            ContentResolver contentResolver = bVar.f;
            contentResolver.unregisterContentObserver(bVar.z);
            contentResolver.unregisterContentObserver(bVar.y);
            if (Build.VERSION.SDK_INT >= 34 && (uiModeManager = (UiModeManager) bVar.a.getContext().getSystemService("uimode")) != null) {
                uiModeManager.removeContrastChangeListener(y.e(bVar.x));
            }
            o4 o4Var = bVar.b;
            o4Var.d = null;
            ((FlutterJNI) o4Var.c).setAccessibilityDelegate(null);
            this.y = null;
            this.t.b.restartInput(this);
            this.t.c();
            int size = ((HashSet) this.w.c).size();
            if (size > 0) {
                Log.w("KeyboardManager", "A KeyboardManager was destroyed with " + size + " unhandled redispatch event(s).");
            }
            gb0 gb0Var = this.u;
            if (gb0Var != null) {
                gb0Var.a.a = null;
                SpellCheckerSession spellCheckerSession = gb0Var.c;
                if (spellCheckerSession != null) {
                    spellCheckerSession.close();
                }
            }
            i3 i3Var = this.s;
            if (i3Var != null) {
                ((ws) i3Var.c).b = null;
            }
            io.flutter.embedding.engine.renderer.e eVar = this.q.b;
            this.p = false;
            eVar.g(this.F);
            FlutterJNI flutterJNI = eVar.a;
            if (this.a) {
                flutterJNI.removeResizingFlutterUiListener(this.E);
            }
            eVar.j();
            flutterJNI.setSemanticsEnabled(false);
            View view = this.h;
            if (view != null && this.f == this.d) {
                this.f = view;
            }
            this.f.a();
            nm nmVar = this.d;
            if (nmVar != null) {
                nmVar.a.close();
                removeView(this.d);
                this.d = null;
            }
            this.h = null;
            this.q = null;
        }
    }

    @Override // android.view.View
    public final void autofill(SparseArray sparseArray) {
        qd0 qd0Var;
        j1 j1Var;
        j1 j1Var2;
        io.flutter.plugin.editing.b bVar = this.t;
        if (bVar == null || Build.VERSION.SDK_INT < 26 || (qd0Var = bVar.f) == null || bVar.g == null || (j1Var = qd0Var.j) == null) {
            return;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            qd0 qd0Var2 = (qd0) bVar.g.get(sparseArray.keyAt(i));
            if (qd0Var2 != null && (j1Var2 = qd0Var2.j) != null) {
                String str = (String) j1Var2.a;
                String string = yd0.c(sparseArray.valueAt(i)).getTextValue().toString();
                td0 td0Var = new td0(string, string.length(), string.length(), -1, -1);
                if (str.equals((String) j1Var.a)) {
                    bVar.h.f(td0Var);
                } else {
                    map.put(str, td0Var);
                }
            }
        }
        i3 i3Var = bVar.d;
        int i2 = bVar.e.c;
        i3Var.getClass();
        map.size();
        HashMap map2 = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            td0 td0Var2 = (td0) entry.getValue();
            map2.put((String) entry.getKey(), i3.B(td0Var2.a, td0Var2.b, td0Var2.c, -1, -1));
        }
        ((aj) i3Var.b).a("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i2), map2), null);
    }

    public final void b() {
        en enVar = this.b;
        if (enVar != null) {
            addView(enVar);
        } else {
            gn gnVar = this.c;
            if (gnVar != null) {
                addView(gnVar);
            } else {
                addView(this.d);
            }
        }
        this.a = pr.E(getContext());
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View, sensei0.f50] */
    public final boolean c() {
        em emVar = this.q;
        return emVar != null && emVar.b == this.f.getAttachedRenderer();
    }

    @Override // android.view.View
    public final boolean checkInputConnectionProxy(View view) {
        em emVar = this.q;
        if (emVar == null) {
            return super.checkInputConnectionProxy(view);
        }
        HashMap map = emVar.s.s;
        if (view == null || !map.containsKey(view.getContext())) {
            return false;
        }
        View view2 = (View) map.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instruction units count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.nn.d():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (c() && this.w.L(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    public final void e() {
        if (!c()) {
            Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        float f = getResources().getDisplayMetrics().density;
        cn cnVar = this.B;
        cnVar.a = f;
        cnVar.t = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        io.flutter.embedding.engine.renderer.e eVar = this.q.b;
        eVar.getClass();
        int i = cnVar.b;
        ArrayList arrayList = cnVar.z;
        ArrayList arrayList2 = cnVar.y;
        if (i == 0) {
            int i2 = cnVar.d;
            int i3 = cnVar.e;
            if (i2 <= 0 && i3 <= 0) {
                return;
            }
        } else {
            int i4 = cnVar.c;
            if (i4 == 0) {
                int i5 = cnVar.f;
                int i6 = cnVar.g;
                if (i5 <= 0 && i6 <= 0) {
                    return;
                }
            } else if (i <= 0 || i4 <= 0 || cnVar.a <= 0.0f) {
                return;
            }
        }
        arrayList2.size();
        arrayList.size();
        int size = arrayList.size() + arrayList2.size();
        int[] iArr = new int[size * 4];
        int[] iArr2 = new int[size];
        int[] iArr3 = new int[size];
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            ym ymVar = (ym) arrayList2.get(i7);
            int i8 = i7 * 4;
            Rect rect = ymVar.a;
            iArr[i8] = rect.left;
            iArr[i8 + 1] = rect.top;
            iArr[i8 + 2] = rect.right;
            iArr[i8 + 3] = rect.bottom;
            iArr2[i7] = za0.u(ymVar.b);
            iArr3[i7] = za0.u(ymVar.c);
        }
        int size2 = arrayList2.size() * 4;
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            ym ymVar2 = (ym) arrayList.get(i9);
            int i10 = (i9 * 4) + size2;
            Rect rect2 = ymVar2.a;
            iArr[i10] = rect2.left;
            iArr[i10 + 1] = rect2.top;
            iArr[i10 + 2] = rect2.right;
            iArr[i10 + 3] = rect2.bottom;
            iArr2[arrayList2.size() + i9] = za0.u(ymVar2.b);
            iArr3[arrayList2.size() + i9] = za0.u(ymVar2.c);
        }
        eVar.a.setViewportMetrics(cnVar.a, cnVar.b, cnVar.c, cnVar.h, cnVar.i, cnVar.j, cnVar.k, cnVar.l, cnVar.m, cnVar.n, cnVar.o, cnVar.p, cnVar.q, cnVar.r, cnVar.s, cnVar.t, iArr, iArr2, iArr3, cnVar.d, cnVar.e, cnVar.f, cnVar.g, cnVar.u, cnVar.v, cnVar.w, cnVar.x);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.b bVar = this.y;
        if (bVar == null || !bVar.c.isEnabled()) {
            return null;
        }
        return this.y;
    }

    public em getAttachedFlutterEngine() {
        return this.q;
    }

    public a6 getBinaryMessenger() {
        return this.q.c;
    }

    public nm getCurrentImageSurface() {
        return this.d;
    }

    public cn getViewportMetrics() {
        return this.B;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets r18) {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.nn.onApplyWindowInsets(android.view.WindowInsets):android.view.WindowInsets");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        fb0 fb0Var;
        super.onAttachedToWindow();
        xb xbVar = null;
        try {
            rk0 rk0Var = sk0.n;
            Context context = getContext();
            rk0Var.getClass();
            fb0Var = new fb0(new ii0(rk0.a(context)));
        } catch (NoClassDefFoundError unused) {
            fb0Var = null;
        }
        this.A = fb0Var;
        Activity activityB = ri0.b(getContext());
        fb0 fb0Var2 = this.A;
        if (fb0Var2 == null || activityB == null) {
            return;
        }
        this.G = new jn(0, this);
        Context context2 = getContext();
        Executor executorB = Build.VERSION.SDK_INT >= 28 ? tb.b(context2) : new ej(new Handler(context2.getMainLooper()), 0);
        jn jnVar = this.G;
        ii0 ii0Var = (ii0) fb0Var2.a;
        pr.j("executor", executorB);
        pr.j("consumer", jnVar);
        i3 i3Var = (i3) ii0Var.c;
        fb0 fb0Var3 = (fb0) ii0Var.b;
        fb0Var3.getClass();
        y7 y7Var = new y7(fb0Var3, activityB, xbVar, 3);
        m6 m6Var = m6.a;
        oi oiVar = oi.a;
        y6 y6Var = new y6(y7Var, oiVar, -2, m6Var);
        nf nfVar = kg.a;
        jq jqVar = qv.a;
        if (jqVar.n(mh.p) != null) {
            throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + jqVar).toString());
        }
        gl glVarY = y6Var;
        if (!jqVar.equals(oiVar)) {
            glVarY = pr.y(y6Var, jqVar, 0, null, 6);
        }
        LinkedHashMap linkedHashMap = (LinkedHashMap) i3Var.c;
        ReentrantLock reentrantLock = (ReentrantLock) i3Var.b;
        reentrantLock.lock();
        try {
            if (linkedHashMap.get(jnVar) == null) {
                lc gjVar = new gj(executorB);
                if (gjVar.n(mh.p) == null) {
                    gjVar = gjVar.j(new es());
                }
                a7 a7Var = new a7(glVarY, jnVar, (xb) null);
                xc xcVar = xc.a;
                lc lcVarK = xe.k(gjVar, oiVar, true);
                nf nfVar2 = kg.a;
                if (lcVarK != nfVar2 && lcVarK.n(mh.c) == null) {
                    lcVarK = lcVarK.j(nfVar2);
                }
                g ob0Var = new ob0(lcVarK, true);
                ob0Var.V(xcVar, ob0Var, a7Var);
                linkedHashMap.put(jnVar, ob0Var);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) throws Exception {
        super.onConfigurationChanged(configuration);
        if (this.q != null) {
            this.v.b(configuration);
            d();
            ri0.a(getContext(), this.q);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0060 A[PHI: r8
      0x0060: PHI (r8v13 int) = (r8v6 int), (r8v16 int) binds: [B:73:0x00bb, B:31:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ba  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r17) {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.nn.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        jn jnVar;
        fb0 fb0Var = this.A;
        if (fb0Var != null && (jnVar = this.G) != null) {
            i3 i3Var = (i3) ((ii0) fb0Var.a).c;
            LinkedHashMap linkedHashMap = (LinkedHashMap) i3Var.c;
            ReentrantLock reentrantLock = (ReentrantLock) i3Var.b;
            reentrantLock.lock();
            try {
                bs bsVar = (bs) linkedHashMap.get(jnVar);
                if (bsVar != null) {
                    bsVar.b(null);
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        this.G = null;
        this.A = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (c()) {
            s2 s2Var = this.x;
            Context context = getContext();
            s2Var.getClass();
            boolean zIsFromSource = motionEvent.isFromSource(2);
            boolean z = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
            if (zIsFromSource && z) {
                int iB = s2.b(motionEvent.getActionMasked());
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 288);
                byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
                s2Var.a(motionEvent, motionEvent.getActionIndex(), iB, 0, s2.f, byteBufferAllocateDirect, context);
                if (byteBufferAllocateDirect.position() % 288 != 0) {
                    throw new AssertionError("Packet position is not on field boundary.");
                }
                s2Var.a.a.dispatchPointerDataPacket(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
                return true;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        return !c() ? super.onHoverEvent(motionEvent) : this.y.f(motionEvent, false);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        this.H = View.MeasureSpec.getMode(i);
        this.I = View.MeasureSpec.getMode(i2);
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i) {
        Rect rect;
        super.onProvideAutofillVirtualStructure(viewStructure, i);
        io.flutter.plugin.editing.b bVar = this.t;
        if (bVar == null || Build.VERSION.SDK_INT < 26 || bVar.g == null) {
            return;
        }
        String str = (String) bVar.f.j.a;
        AutofillId autofillId = viewStructure.getAutofillId();
        for (int i2 = 0; i2 < bVar.g.size(); i2++) {
            int iKeyAt = bVar.g.keyAt(i2);
            j1 j1Var = ((qd0) bVar.g.valueAt(i2)).j;
            if (j1Var != null) {
                viewStructure.addChildCount(1);
                ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
                viewStructureNewChild.setAutofillId(autofillId, iKeyAt);
                String[] strArr = (String[]) j1Var.c;
                if (strArr.length > 0) {
                    viewStructureNewChild.setAutofillHints(strArr);
                }
                viewStructureNewChild.setAutofillType(1);
                viewStructureNewChild.setVisibility(0);
                String str2 = (String) j1Var.b;
                if (str2 != null) {
                    viewStructureNewChild.setHint(str2);
                }
                if (str.hashCode() != iKeyAt || (rect = bVar.m) == null) {
                    viewStructureNewChild.setDimens(0, 0, 0, 0, 1, 1);
                    viewStructureNewChild.setAutofillValue(AutofillValue.forText(((td0) j1Var.d).a));
                } else {
                    viewStructureNewChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), bVar.m.height());
                    viewStructureNewChild.setAutofillValue(AutofillValue.forText(bVar.h));
                }
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cn cnVar = this.B;
        cnVar.b = i;
        cnVar.c = i2;
        boolean z = this.a;
        if (z && this.I == 0) {
            cnVar.f = 0;
            cnVar.g = AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT;
        } else {
            cnVar.f = i2;
            cnVar.g = i2;
        }
        if (z && this.H == 0) {
            cnVar.d = 0;
            cnVar.e = AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT;
        } else {
            cnVar.d = i;
            cnVar.e = i;
        }
        e();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!c()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        this.x.d(motionEvent, s2.f);
        return true;
    }

    public void setDelegate(pn pnVar) {
        this.J = pnVar;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f;
        if (view instanceof en) {
            ((en) view).setVisibility(i);
        }
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, java.util.List] */
    public void setWindowInfoListenerDisplayFeatures(wl0 wl0Var) {
        tn tnVar = tn.d;
        List<lq> r9 = wl0Var.a;
        ArrayList arrayList = new ArrayList();
        for (lq lqVar : r9) {
            lqVar.a.a().toString();
            l6 l6Var = lqVar.a;
            int i = 2;
            int i2 = ((l6Var.c - l6Var.a == 0 || l6Var.d - l6Var.b == 0) ? tn.c : tnVar) == tnVar ? 3 : 2;
            tn tnVar2 = lqVar.c;
            if (tnVar2 != tn.f) {
                i = tnVar2 == tn.h ? 3 : 1;
            }
            arrayList.add(new ym(l6Var.a(), i2, i));
        }
        ArrayList arrayList2 = this.B.y;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        e();
    }

    public nn(vl vlVar, gn gnVar) {
        super(vlVar, null);
        this.a = false;
        this.o = new HashSet();
        this.r = new HashSet();
        this.B = new cn();
        this.C = new sv(25, this);
        this.D = new kn(this, new Handler(Looper.getMainLooper()));
        this.E = new ln(this);
        this.F = new wl(2, this);
        this.J = new pn();
        this.c = gnVar;
        this.f = gnVar;
        b();
    }
}
