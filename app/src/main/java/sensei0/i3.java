package sensei0;

import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.trilead.ssh2.sftp.ErrorCodes;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class i3 implements v5, y5, fi, gl, ys, tx, j10, l10 {
    public static i3 d;
    public static fm f;
    public final /* synthetic */ int a;
    public Object b;
    public Object c;

    public /* synthetic */ i3(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    public static HashMap B(String str, int i, int i2, int i3, int i4) {
        HashMap map = new HashMap();
        map.put("text", str);
        map.put("selectionBase", Integer.valueOf(i));
        map.put("selectionExtent", Integer.valueOf(i2));
        map.put("composingBase", Integer.valueOf(i3));
        map.put("composingExtent", Integer.valueOf(i4));
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0081 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int w(sensei0.i3 r11, org.json.JSONArray r12) throws org.json.JSONException, java.lang.NoSuchFieldException {
        /*
            r11 = 0
            r0 = r11
            r1 = r0
            r2 = r1
        L4:
            int r3 = r12.length()
            r4 = 4
            r5 = 2
            r6 = 1
            if (r0 >= r3) goto L68
            java.lang.String r3 = r12.getString(r0)
            int[] r4 = sensei0.za0.v(r4)
            int r7 = r4.length
            r8 = r11
        L17:
            if (r8 >= r7) goto L5c
            r9 = r4[r8]
            r10 = 1
            if (r9 == r10) goto L32
            r10 = 2
            if (r9 == r10) goto L2f
            r10 = 3
            if (r9 == r10) goto L2c
            r10 = 4
            if (r9 != r10) goto L2a
            java.lang.String r10 = "DeviceOrientation.landscapeRight"
            goto L34
        L2a:
            r11 = 0
            throw r11
        L2c:
            java.lang.String r10 = "DeviceOrientation.landscapeLeft"
            goto L34
        L2f:
            java.lang.String r10 = "DeviceOrientation.portraitDown"
            goto L34
        L32:
            java.lang.String r10 = "DeviceOrientation.portraitUp"
        L34:
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L59
            int r3 = sensei0.za0.u(r9)
            if (r3 == 0) goto L51
            if (r3 == r6) goto L4e
            if (r3 == r5) goto L4b
            r4 = 3
            if (r3 == r4) goto L48
            goto L53
        L48:
            r1 = r1 | 8
            goto L53
        L4b:
            r1 = r1 | 2
            goto L53
        L4e:
            r1 = r1 | 4
            goto L53
        L51:
            r1 = r1 | 1
        L53:
            if (r2 != 0) goto L56
            r2 = r1
        L56:
            int r0 = r0 + 1
            goto L4
        L59:
            int r8 = r8 + 1
            goto L17
        L5c:
            java.lang.NoSuchFieldException r11 = new java.lang.NoSuchFieldException
            java.lang.String r12 = "No such DeviceOrientation: "
            java.lang.String r12 = sensei0.za0.s(r12, r3)
            r11.<init>(r12)
            throw r11
        L68:
            if (r1 == 0) goto L85
            r12 = 8
            switch(r1) {
                case 2: goto L84;
                case 3: goto L7a;
                case 4: goto L82;
                case 5: goto L77;
                case 6: goto L7a;
                case 7: goto L7a;
                case 8: goto L81;
                case 9: goto L7a;
                case 10: goto L74;
                case 11: goto L73;
                case 12: goto L7a;
                case 13: goto L7a;
                case 14: goto L7a;
                case 15: goto L70;
                default: goto L6f;
            }
        L6f:
            goto L80
        L70:
            r11 = 13
            return r11
        L73:
            return r5
        L74:
            r11 = 11
            return r11
        L77:
            r11 = 12
            return r11
        L7a:
            if (r2 == r5) goto L84
            if (r2 == r4) goto L82
            if (r2 == r12) goto L81
        L80:
            return r6
        L81:
            return r12
        L82:
            r11 = 9
        L84:
            return r11
        L85:
            r11 = -1
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.i3.w(sensei0.i3, org.json.JSONArray):int");
    }

    public static ArrayList x(i3 i3Var, JSONArray jSONArray) throws JSONException, NoSuchFieldException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            for (w00 w00Var : w00.values()) {
                if (w00Var.a.equals(string)) {
                    int iOrdinal = w00Var.ordinal();
                    if (iOrdinal == 0) {
                        arrayList.add(w00.TOP_OVERLAYS);
                    } else if (iOrdinal == 1) {
                        arrayList.add(w00.BOTTOM_OVERLAYS);
                    }
                }
            }
            throw new NoSuchFieldException(za0.s("No such SystemUiOverlay: ", string));
        }
        return arrayList;
    }

    public static int y(i3 i3Var, String str) throws NoSuchFieldException {
        String str2;
        for (int i : za0.v(4)) {
            if (i == 1) {
                str2 = "SystemUiMode.leanBack";
            } else if (i == 2) {
                str2 = "SystemUiMode.immersive";
            } else if (i == 3) {
                str2 = "SystemUiMode.immersiveSticky";
            } else {
                if (i != 4) {
                    throw null;
                }
                str2 = "SystemUiMode.edgeToEdge";
            }
            if (str2.equals(str)) {
                int iU = za0.u(i);
                if (iU == 0) {
                    return 1;
                }
                if (iU != 1) {
                    return iU != 2 ? 4 : 3;
                }
                return 2;
            }
        }
        throw new NoSuchFieldException(za0.s("No such SystemUiMode: ", str));
    }

    public static v00 z(i3 i3Var, JSONObject jSONObject) {
        return new v00(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? za0.a(jSONObject.getString("statusBarIconBrightness")) : 0, !jSONObject.isNull("systemStatusBarContrastEnforced") ? Boolean.valueOf(jSONObject.getBoolean("systemStatusBarContrastEnforced")) : null, !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null, jSONObject.isNull("systemNavigationBarIconBrightness") ? 0 : za0.a(jSONObject.getString("systemNavigationBarIconBrightness")), !jSONObject.isNull("systemNavigationBarDividerColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")) : null, jSONObject.isNull("systemNavigationBarContrastEnforced") ? null : Boolean.valueOf(jSONObject.getBoolean("systemNavigationBarContrastEnforced")));
    }

    public Object A(String str) {
        Object obj = this.c;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public View C(int i, int i2, int i3, int i4) {
        int iU;
        int i5;
        int iV;
        View viewO;
        int left;
        int i6;
        int right;
        int i7;
        nh0 nh0Var = (nh0) this.c;
        f40 f40Var = (f40) this.b;
        switch (f40Var.a) {
            case 0:
                iU = f40Var.b.u();
                break;
            default:
                iU = f40Var.b.w();
                break;
        }
        switch (f40Var.a) {
            case 0:
                g40 g40Var = f40Var.b;
                i5 = g40Var.f;
                iV = g40Var.v();
                break;
            default:
                g40 g40Var2 = f40Var.b;
                i5 = g40Var2.g;
                iV = g40Var2.t();
                break;
        }
        int i8 = i5 - iV;
        int i9 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            switch (f40Var.a) {
                case 0:
                    viewO = f40Var.b.o(i);
                    break;
                default:
                    viewO = f40Var.b.o(i);
                    break;
            }
            switch (f40Var.a) {
                case 0:
                    h40 h40Var = (h40) viewO.getLayoutParams();
                    left = viewO.getLeft() - ((h40) viewO.getLayoutParams()).a.left;
                    i6 = ((ViewGroup.MarginLayoutParams) h40Var).leftMargin;
                    break;
                default:
                    h40 h40Var2 = (h40) viewO.getLayoutParams();
                    left = viewO.getTop() - ((h40) viewO.getLayoutParams()).a.top;
                    i6 = ((ViewGroup.MarginLayoutParams) h40Var2).topMargin;
                    break;
            }
            int i10 = left - i6;
            switch (f40Var.a) {
                case 0:
                    h40 h40Var3 = (h40) viewO.getLayoutParams();
                    right = viewO.getRight() + ((h40) viewO.getLayoutParams()).a.right;
                    i7 = ((ViewGroup.MarginLayoutParams) h40Var3).rightMargin;
                    break;
                default:
                    h40 h40Var4 = (h40) viewO.getLayoutParams();
                    right = viewO.getBottom() + ((h40) viewO.getLayoutParams()).a.bottom;
                    i7 = ((ViewGroup.MarginLayoutParams) h40Var4).bottomMargin;
                    break;
            }
            int i11 = right + i7;
            nh0Var.b = iU;
            nh0Var.c = i8;
            nh0Var.d = i10;
            nh0Var.e = i11;
            if (i3 != 0) {
                nh0Var.a = i3;
                if (nh0Var.a()) {
                    return viewO;
                }
            }
            if (i4 != 0) {
                nh0Var.a = i4;
                if (nh0Var.a()) {
                    view = viewO;
                }
            }
            i += i9;
        }
        return view;
    }

    public KeyListener D(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((i3) ((sv) this.c).b).getClass();
        if (keyListener instanceof ei) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new ei(keyListener);
    }

    public void E(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = ((EditText) this.b).getContext().obtainStyledAttributes(attributeSet, p30.g, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            J(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public bi F(InputConnection inputConnection, EditorInfo editorInfo) {
        sv svVar = (sv) this.c;
        if (inputConnection == null) {
            svVar.getClass();
            inputConnection = null;
        } else {
            i3 i3Var = (i3) svVar.b;
            i3Var.getClass();
            if (!(inputConnection instanceof bi)) {
                inputConnection = new bi((EditText) i3Var.b, inputConnection, editorInfo);
            }
        }
        return (bi) inputConnection;
    }

    public void G(co coVar) {
        ej ejVar = (ej) this.c;
        fb0 fb0Var = (fb0) this.b;
        int i = coVar.b;
        if (i == 0) {
            ejVar.execute(new e2(fb0Var, coVar.a, 1, false));
        } else {
            ejVar.execute(new b7(fb0Var, i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x01c1, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void H(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.i3.H(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public MotionEvent I(xx xxVar) {
        long j = xxVar.a;
        LongSparseArray longSparseArray = (LongSparseArray) this.b;
        PriorityQueue priorityQueue = (PriorityQueue) this.c;
        while (!priorityQueue.isEmpty() && ((Long) priorityQueue.peek()).longValue() < j) {
            longSparseArray.remove(((Long) priorityQueue.poll()).longValue());
        }
        if (!priorityQueue.isEmpty() && ((Long) priorityQueue.peek()).longValue() == j) {
            priorityQueue.poll();
        }
        MotionEvent motionEvent = (MotionEvent) longSparseArray.get(j);
        longSparseArray.remove(j);
        return motionEvent;
    }

    public void J(boolean z) {
        ki kiVar = (ki) ((i3) ((sv) this.c).b).c;
        if (kiVar.c != z) {
            if (kiVar.b != null) {
                uh uhVarA = uh.a();
                ji jiVar = kiVar.b;
                uhVarA.getClass();
                pr.h("initCallback cannot be null", jiVar);
                ReentrantReadWriteLock reentrantReadWriteLock = uhVarA.a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    uhVarA.b.remove(jiVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            kiVar.c = z;
            if (z) {
                ki.a(kiVar.a, uh.a().b());
            }
        }
    }

    @Override // sensei0.fi
    public Object a() {
        return (rg0) this.b;
    }

    @Override // sensei0.l10
    public void b(boolean z) {
        ((io.flutter.plugin.platform.c) this.b).E.a.z = z;
    }

    @Override // sensei0.j10
    public void c(io.flutter.view.b bVar) {
        ((io.flutter.plugin.platform.c) this.b).q.a = bVar;
        ((q10) this.c).p.a = bVar;
    }

    @Override // sensei0.l10
    public long d(f10 f10Var) {
        return ((io.flutter.plugin.platform.c) this.b).E.d(f10Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // sensei0.gl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(sensei0.il r7, sensei0.yb r8) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.i3.e(sensei0.il, sensei0.yb):java.lang.Object");
    }

    @Override // sensei0.l10
    public void f(int i, double d2, double d3) {
        if (((q10) this.c).k(i) != null) {
            return;
        }
        ((io.flutter.plugin.platform.c) this.b).E.f(i, d2, d3);
    }

    @Override // sensei0.l10
    public void g(int i, int i2) {
        q10 q10Var = (q10) this.c;
        if (q10Var.k(i) != null) {
            q10Var.y.p(i, i2);
        } else {
            ((io.flutter.plugin.platform.c) this.b).E.g(i, i2);
        }
    }

    @Override // sensei0.j10
    public boolean h(int i) {
        q10 q10Var = (q10) this.c;
        if (q10Var.k(i) == null) {
            return ((io.flutter.plugin.platform.c) this.b).h(i);
        }
        q10Var.getClass();
        return false;
    }

    @Override // sensei0.l10
    public void i(f10 f10Var) {
        ((io.flutter.plugin.platform.c) this.b).E.i(f10Var);
    }

    @Override // sensei0.ys
    public void j(KeyEvent keyEvent, g6 g6Var) {
        int action = keyEvent.getAction();
        if (action != 0 && action != 1) {
            g6Var.c(false);
            return;
        }
        Character chA = ((xs) this.c).a(keyEvent.getUnicodeChar());
        boolean z = action != 0;
        vs vsVar = (vs) this.b;
        x2 x2Var = new x2(3, g6Var);
        j1 j1Var = vsVar.a;
        HashMap map = new HashMap();
        map.put("type", z ? "keyup" : "keydown");
        map.put("keymap", "android");
        map.put("flags", Integer.valueOf(keyEvent.getFlags()));
        map.put("plainCodePoint", Integer.valueOf(keyEvent.getUnicodeChar(0)));
        map.put("codePoint", Integer.valueOf(keyEvent.getUnicodeChar()));
        map.put("keyCode", Integer.valueOf(keyEvent.getKeyCode()));
        map.put("scanCode", Integer.valueOf(keyEvent.getScanCode()));
        map.put("metaState", Integer.valueOf(keyEvent.getMetaState()));
        map.put("character", chA.toString());
        map.put("source", Integer.valueOf(keyEvent.getSource()));
        map.put("deviceId", Integer.valueOf(keyEvent.getDeviceId()));
        map.put("repeatCount", Integer.valueOf(keyEvent.getRepeatCount()));
        j1Var.k(map, new x2(4, x2Var));
    }

    @Override // sensei0.j10
    public View k(int i) {
        q10 q10Var = (q10) this.c;
        return q10Var.k(i) != null ? q10Var.k(i) : ((io.flutter.plugin.platform.c) this.b).k(i);
    }

    @Override // sensei0.tx
    public void l(i3 i3Var, rk rkVar) {
        ws wsVar = (ws) this.c;
        if (((o4) wsVar.b) == null) {
            rkVar.d((Map) this.b);
            return;
        }
        String str = (String) i3Var.b;
        str.getClass();
        if (!str.equals("getKeyboardState")) {
            rkVar.b();
            return;
        }
        try {
            this.b = Collections.unmodifiableMap(((us) ((ys[]) ((o4) wsVar.b).b)[0]).b);
        } catch (IllegalStateException e) {
            rkVar.a("error", e.getMessage(), null);
        }
        rkVar.d((Map) this.b);
    }

    @Override // sensei0.l10
    public void m(k10 k10Var, x2 x2Var) {
        if (((q10) this.c).k(k10Var.a) != null) {
            return;
        }
        ((io.flutter.plugin.platform.c) this.b).E.m(k10Var, x2Var);
    }

    @Override // sensei0.l10
    public void n(int i) {
        q10 q10Var = (q10) this.c;
        if (q10Var.k(i) != null) {
            q10Var.y.f(i);
        } else {
            ((io.flutter.plugin.platform.c) this.b).E.n(i);
        }
    }

    @Override // sensei0.j10
    public void o() {
        ((io.flutter.plugin.platform.c) this.b).o();
        ((q10) this.c).o();
    }

    @Override // sensei0.l10
    public void p(h10 h10Var) {
        q10 q10Var = (q10) this.c;
        if (q10Var.k(h10Var.a) != null) {
            q10Var.y.o(h10Var);
        } else {
            ((io.flutter.plugin.platform.c) this.b).E.p(h10Var);
        }
    }

    @Override // sensei0.fi
    public boolean q(CharSequence charSequence, int i, int i2, eg0 eg0Var) {
        if ((eg0Var.c & 4) > 0) {
            return true;
        }
        if (((rg0) this.b) == null) {
            this.b = new rg0(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((pf) this.c).getClass();
        ((rg0) this.b).setSpan(new fg0(eg0Var), i, i2, 33);
        return true;
    }

    @Override // sensei0.l10
    public void r(int i) {
        q10 q10Var = (q10) this.c;
        if (q10Var.k(i) != null) {
            q10Var.y.g(i);
        } else {
            ((io.flutter.plugin.platform.c) this.b).E.r(i);
        }
    }

    @Override // sensei0.v5
    public void s(Object obj) {
        switch (this.a) {
            case 3:
                ((pd) this.b).a(((dx) ((j1) ((i3) this.c).c).c).a(obj));
                break;
            default:
                o4 o4Var = (o4) this.c;
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) o4Var.b;
                z70 z70Var = (z70) this.b;
                concurrentLinkedQueue.remove(z70Var);
                if (!((ConcurrentLinkedQueue) o4Var.b).isEmpty()) {
                    Log.e("SettingsChannel", "The queue becomes empty after removing config generation " + z70Var.a);
                }
                break;
        }
    }

    @Override // sensei0.l10
    public void t(f10 f10Var) {
        q10 q10Var = (q10) ((q10) this.c).y.b;
        lm lmVar = q10Var.a;
        String str = f10Var.b;
        int i = f10Var.a;
        rn rnVar = (rn) lmVar.a.get(str);
        if (rnVar == null) {
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + str);
        }
        ByteBuffer byteBuffer = f10Var.i;
        e10 e10VarA = rnVar.a(byteBuffer != null ? rnVar.a.b(byteBuffer) : null);
        View view = e10VarA.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        view.setLayoutDirection(f10Var.g);
        q10Var.q.put(i, e10VarA);
    }

    @Override // sensei0.y5
    public void u(ByteBuffer byteBuffer, pd pdVar) throws Throwable {
        switch (this.a) {
            case 4:
                j1 j1Var = (j1) this.c;
                try {
                    ((u5) this.b).j(((dx) j1Var.c).b(byteBuffer), new i3(3, this, pdVar));
                } catch (RuntimeException e) {
                    Log.e("BasicMessageChannel#" + ((String) j1Var.a), "Failed to handle message", e);
                    pdVar.a(null);
                    return;
                }
                break;
            default:
                aj ajVar = (aj) this.c;
                ux uxVar = ajVar.c;
                try {
                    ((tx) this.b).l(uxVar.g(byteBuffer), new rk(1, this, pdVar));
                } catch (RuntimeException e2) {
                    Log.e("MethodChannel#" + ajVar.b, "Failed to handle method call", e2);
                    pdVar.a(uxVar.e(e2.getMessage(), Log.getStackTraceString(e2)));
                }
                break;
        }
    }

    @Override // sensei0.l10
    public boolean v() {
        FlutterJNI flutterJNI = ((q10) this.c).f;
        if (flutterJNI == null) {
            return false;
        }
        return flutterJNI.IsSurfaceControlEnabled();
    }

    public /* synthetic */ i3(int i, boolean z) {
        this.a = i;
    }

    public /* synthetic */ i3(Object obj, Object obj2, int i, boolean z) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public i3(ay ayVar, ws wsVar) {
        this.a = 20;
        this.b = ayVar;
        this.c = wsVar;
        wsVar.b = new ws(10, this);
    }

    public i3(vs vsVar) {
        this.a = 14;
        this.c = new xs();
        this.b = vsVar;
    }

    public i3(ws wsVar) {
        this.a = 15;
        this.c = wsVar;
        this.b = new HashMap();
    }

    public i3(int i) {
        this.a = i;
        switch (i) {
            case 19:
                this.b = new LongSparseArray();
                this.c = new PriorityQueue();
                break;
            default:
                this.b = new ReentrantLock();
                this.c = new LinkedHashMap();
                break;
        }
    }

    public i3(View view, InputMethodManager inputMethodManager, ws wsVar) {
        this.a = 26;
        if (Build.VERSION.SDK_INT >= 33) {
            view.setAutoHandwritingEnabled(false);
        }
        this.c = view;
        this.b = inputMethodManager;
        wsVar.b = this;
    }

    public i3(EditText editText, int i) {
        this.a = i;
        switch (i) {
            case 8:
                this.b = editText;
                ki kiVar = new ki(editText);
                this.c = kiVar;
                editText.addTextChangedListener(kiVar);
                if (zh.b == null) {
                    synchronized (zh.a) {
                        try {
                            if (zh.b == null) {
                                zh zhVar = new zh();
                                try {
                                    zh.c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, zh.class.getClassLoader());
                                    break;
                                } catch (Throwable unused) {
                                }
                                zh.b = zhVar;
                            }
                        } finally {
                        }
                        break;
                    }
                }
                editText.setEditableFactory(zh.b);
                return;
            default:
                this.b = editText;
                this.c = new sv(editText);
                return;
        }
    }

    public i3(kd kdVar, int i) {
        this.a = i;
        switch (i) {
            case 21:
                ws wsVar = new ws(12, this);
                aj ajVar = new aj(kdVar, "flutter/platform", mh.o);
                this.b = ajVar;
                ajVar.b(wsVar);
                break;
            case ErrorCodes.SSH_FX_CANNOT_DELETE /* 22 */:
                ws wsVar2 = new ws(15, this);
                aj ajVar2 = new aj(kdVar, "flutter/platform_views_2", sb0.a);
                this.b = ajVar2;
                ajVar2.b(wsVar2);
                break;
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                ws wsVar3 = new ws(14, this);
                aj ajVar3 = new aj(kdVar, "flutter/platform_views", sb0.a);
                this.b = ajVar3;
                ajVar3.b(wsVar3);
                break;
            case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                fb0 fb0Var = new fb0(this);
                aj ajVar4 = new aj(kdVar, "flutter/textinput", mh.o);
                this.b = ajVar4;
                ajVar4.b(fb0Var);
                break;
            default:
                ws wsVar4 = new ws(2, this);
                aj ajVar5 = new aj(kdVar, "flutter/localization", mh.o);
                this.b = ajVar5;
                ajVar5.b(wsVar4);
                break;
        }
    }

    public i3(kd kdVar, PackageManager packageManager) {
        this.a = 25;
        ws wsVar = new ws(19, this);
        this.b = packageManager;
        new aj(kdVar, "flutter/processtext", sb0.a).b(wsVar);
    }

    public i3(f40 f40Var) {
        this.a = 29;
        this.b = f40Var;
        nh0 nh0Var = new nh0();
        nh0Var.a = 0;
        this.c = nh0Var;
    }
}
