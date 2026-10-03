package io.flutter.view;

import android.R;
import android.app.UiModeManager;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.trilead.ssh2.sftp.AttribFlags;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sourceforge.jsocks.Proxy;
import sensei0.a0;
import sensei0.b0;
import sensei0.c0;
import sensei0.d0;
import sensei0.e0;
import sensei0.g0;
import sensei0.h0;
import sensei0.i0;
import sensei0.j0;
import sensei0.j1;
import sensei0.j10;
import sensei0.k0;
import sensei0.l0;
import sensei0.m0;
import sensei0.mh;
import sensei0.o4;
import sensei0.pr;
import sensei0.sv;
import sensei0.u0;
import sensei0.y;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AccessibilityNodeProvider {
    public final View a;
    public final o4 b;
    public final AccessibilityManager c;
    public final AccessibilityViewEmbedder d;
    public final j10 e;
    public final ContentResolver f;
    public final HashMap g;
    public final HashMap h;
    public m0 i;
    public Integer j;
    public Integer k;
    public int l;
    public String m;
    public m0 n;
    public m0 o;
    public m0 p;
    public final ArrayList q;
    public int r;
    public sv s;
    public boolean t;
    public boolean u;
    public final d0 v;
    public final e0 w;
    public final i0 x;
    public final l0 y;
    public final k0 z;
    public static final int[] C = za0.v(33);
    public static final int A = 267386881;
    public static final int B = -1;

    public b(View view, o4 o4Var, AccessibilityManager accessibilityManager, ContentResolver contentResolver, j10 j10Var) {
        AccessibilityViewEmbedder accessibilityViewEmbedder = new AccessibilityViewEmbedder(view, Proxy.SOCKS_NO_PROXY);
        this.g = new HashMap();
        this.h = new HashMap();
        this.l = 0;
        this.q = new ArrayList();
        this.r = 0;
        this.t = false;
        this.u = false;
        a aVar = new a(this);
        d0 d0Var = new d0(this);
        this.v = d0Var;
        int i = Build.VERSION.SDK_INT;
        i0 a0Var = i >= 34 ? new a0(this) : new b0(0);
        this.x = a0Var;
        this.a = view;
        this.b = o4Var;
        this.c = accessibilityManager;
        this.f = contentResolver;
        this.d = accessibilityViewEmbedder;
        this.e = j10Var;
        o4Var.d = aVar;
        ((FlutterJNI) o4Var.c).setAccessibilityDelegate(aVar);
        d0Var.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(d0Var);
        e0 e0Var = new e0(this, accessibilityManager);
        this.w = e0Var;
        e0Var.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(e0Var);
        this.l |= 128;
        k0 k0Var = new k0(this);
        this.z = k0Var;
        n(k0Var.a, k0Var.a());
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, k0Var);
        if (i >= 31 && view.getResources() != null) {
            n(4, h0.a(view.getResources().getConfiguration()));
        }
        l0 l0Var = new l0(this);
        this.y = l0Var;
        n(l0Var.a, l0Var.a());
        contentResolver.registerContentObserver(Settings.Secure.getUriFor("accessibility_display_inversion_enabled"), false, l0Var);
        if (i >= 34) {
            l();
            Context context = view.getContext();
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
            if (uiModeManager != null) {
                uiModeManager.addContrastChangeListener(context.getMainExecutor(), y.f(a0Var));
            }
        }
        j10Var.c(this);
    }

    public static String d(ByteBuffer byteBuffer, String[] strArr) {
        int i = byteBuffer.getInt();
        if (i == B) {
            return null;
        }
        return strArr[i];
    }

    public final boolean a(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        AccessibilityViewEmbedder accessibilityViewEmbedder = this.d;
        if (!accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.k = recordFlutterId;
            this.n = null;
            return true;
        }
        if (eventType == 128) {
            this.p = null;
            return true;
        }
        if (eventType == 32768) {
            this.j = recordFlutterId;
            this.i = null;
            return true;
        }
        if (eventType != 65536) {
            return true;
        }
        this.k = null;
        this.j = null;
        return true;
    }

    public final j0 b(int i) {
        Integer numValueOf = Integer.valueOf(i);
        HashMap map = this.h;
        j0 j0Var = (j0) map.get(numValueOf);
        if (j0Var != null) {
            return j0Var;
        }
        j0 j0Var2 = new j0();
        j0Var2.c = -1;
        j0Var2.b = i;
        j0Var2.a = A + i;
        map.put(Integer.valueOf(i), j0Var2);
        return j0Var2;
    }

    public final m0 c(int i) {
        Integer numValueOf = Integer.valueOf(i);
        HashMap map = this.g;
        m0 m0Var = (m0) map.get(numValueOf);
        if (m0Var != null) {
            return m0Var;
        }
        m0 m0Var2 = new m0(this);
        m0Var2.b = i;
        map.put(Integer.valueOf(i), m0Var2);
        return m0Var2;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        mh mhVar;
        boolean zH;
        int i2;
        String str;
        int i3;
        int i4;
        int i5 = 1;
        k(true);
        AccessibilityViewEmbedder accessibilityViewEmbedder = this.d;
        if (i >= 65536) {
            return accessibilityViewEmbedder.createAccessibilityNodeInfo(i);
        }
        HashMap map = this.g;
        View view = this.a;
        if (i == -1) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            if (map.containsKey(0)) {
                accessibilityNodeInfoObtain.addChild(view, 0);
            }
            accessibilityNodeInfoObtain.setImportantForAccessibility(false);
            return accessibilityNodeInfoObtain;
        }
        m0 m0Var = (m0) map.get(Integer.valueOf(i));
        if (m0Var != null) {
            int i6 = m0Var.i;
            j10 j10Var = this.e;
            if (i6 == -1 || !j10Var.h(i6)) {
                AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain(view, i);
                accessibilityNodeInfoObtain2.setImportantForAccessibility((m0Var.h(12) || (m0Var.e() == null && m0Var.d == 0)) ? false : true);
                accessibilityNodeInfoObtain2.setViewIdResourceName("");
                String str2 = m0Var.o;
                if (str2 != null) {
                    accessibilityNodeInfoObtain2.setViewIdResourceName(str2);
                }
                accessibilityNodeInfoObtain2.setPackageName(view.getContext().getPackageName());
                accessibilityNodeInfoObtain2.setClassName("android.view.View");
                accessibilityNodeInfoObtain2.setSource(view, i);
                int iU = za0.u(C[m0Var.E]);
                if (iU == 12) {
                    mhVar = pr.g;
                } else if (iU == 23) {
                    mhVar = pr.f;
                } else if (iU != 25) {
                    switch (iU) {
                        case 14:
                            mhVar = pr.h;
                            break;
                        case 15:
                        case 16:
                        case 17:
                            mhVar = pr.k;
                            break;
                        case 18:
                            mhVar = pr.i;
                            break;
                        default:
                            mhVar = pr.l;
                            break;
                    }
                } else {
                    mhVar = pr.j;
                }
                accessibilityNodeInfoObtain2.setFocusable(m0Var.j());
                b bVar = m0Var.a;
                m0 m0Var2 = bVar.n;
                if (m0Var2 != null) {
                    accessibilityNodeInfoObtain2.setFocused(m0Var2.b == m0Var.b);
                }
                m0 m0Var3 = bVar.i;
                if (m0Var3 != null) {
                    accessibilityNodeInfoObtain2.setAccessibilityFocused(m0Var3.b == m0Var.b);
                }
                m0 m0Var4 = bVar.i;
                if (m0Var4 == null || m0Var4.b != m0Var.b) {
                    accessibilityNodeInfoObtain2.addAction(64);
                } else {
                    accessibilityNodeInfoObtain2.addAction(128);
                }
                if (m0Var.g(g0.u)) {
                    accessibilityNodeInfoObtain2.addAction(Proxy.SOCKS_PROXY_NO_CONNECT);
                }
                if (m0Var.g(g0.v)) {
                    accessibilityNodeInfoObtain2.addAction(AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME);
                }
                if (m0Var.g(g0.w)) {
                    accessibilityNodeInfoObtain2.addAction(Proxy.SOCKS_NO_PROXY);
                }
                if (m0Var.g(g0.x)) {
                    accessibilityNodeInfoObtain2.addAction(AttribFlags.SSH_FILEXFER_ATTR_CTIME);
                }
                if (m0Var.g(g0.E)) {
                    accessibilityNodeInfoObtain2.addAction(2097152);
                }
                if (m0Var.g(g0.B)) {
                    accessibilityNodeInfoObtain2.setDismissable(true);
                    accessibilityNodeInfoObtain2.addAction(1048576);
                }
                g0 g0Var = g0.b;
                if (m0Var.g(g0Var)) {
                    if (m0Var.Z != null) {
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, m0Var.Z.e));
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else {
                        accessibilityNodeInfoObtain2.addAction(16);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    }
                }
                if (m0Var.g(g0.c)) {
                    if (m0Var.a0 != null) {
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, m0Var.a0.e));
                        accessibilityNodeInfoObtain2.setLongClickable(true);
                    } else {
                        accessibilityNodeInfoObtain2.addAction(32);
                        accessibilityNodeInfoObtain2.setLongClickable(true);
                    }
                }
                if (m0Var.h(16)) {
                    accessibilityNodeInfoObtain2.setLiveRegion(1);
                }
                accessibilityNodeInfoObtain2.setSelected(m0Var.h(3));
                if (Build.VERSION.SDK_INT >= 28) {
                    accessibilityNodeInfoObtain2.setHeading(m0Var.F > 0);
                }
                ArrayList arrayList = m0Var.Y;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i7 = 0;
                    while (i7 < size) {
                        Object obj = arrayList.get(i7);
                        i7++;
                        j0 j0Var = (j0) obj;
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(j0Var.a, j0Var.d));
                        i5 = i5;
                    }
                }
                int i8 = i5;
                if (m0Var.h(5)) {
                    accessibilityNodeInfoObtain2.setPassword(m0Var.h(11));
                    if (!m0Var.h(21)) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.EditText");
                    }
                    accessibilityNodeInfoObtain2.setEditable(!m0Var.h(21));
                    int i9 = m0Var.g;
                    if (i9 != -1 && (i4 = m0Var.h) != -1) {
                        accessibilityNodeInfoObtain2.setTextSelection(i9, i4);
                    }
                    m0 m0Var5 = bVar.i;
                    if (m0Var5 != null && m0Var5.b == m0Var.b) {
                        accessibilityNodeInfoObtain2.setLiveRegion(i8);
                    }
                    if (m0Var.g(g0.s)) {
                        accessibilityNodeInfoObtain2.addAction(256);
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (m0Var.g(g0.t)) {
                        accessibilityNodeInfoObtain2.addAction(512);
                        i3 = 1;
                    }
                    if (m0Var.g(g0.C)) {
                        accessibilityNodeInfoObtain2.addAction(256);
                        i3 |= 2;
                    }
                    if (m0Var.g(g0.D)) {
                        accessibilityNodeInfoObtain2.addAction(512);
                        i3 |= 2;
                    }
                    accessibilityNodeInfoObtain2.setMovementGranularities(i3);
                    if (m0Var.e >= 0) {
                        String str3 = m0Var.r;
                        accessibilityNodeInfoObtain2.setMaxTextLength(((str3 == null ? 0 : str3.length()) - m0Var.f) + m0Var.e);
                    }
                }
                if (m0Var.h(4)) {
                    zH = true;
                } else {
                    String str4 = m0Var.A;
                    zH = (str4 == null || str4.isEmpty()) ? m0Var.h(23) : false;
                }
                if (zH) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                }
                if (m0Var.h(15)) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.ImageView");
                }
                if (!m0Var.g(g0Var) && m0Var.h(24)) {
                    accessibilityNodeInfoObtain2.addAction(16);
                    accessibilityNodeInfoObtain2.setClickable(true);
                }
                g0 g0Var2 = g0.p;
                boolean zG = m0Var.g(g0Var2);
                g0 g0Var3 = g0.q;
                if (zG || m0Var.g(g0Var3)) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.SeekBar");
                    if (m0Var.g(g0Var2)) {
                        accessibilityNodeInfoObtain2.addAction(AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE);
                    }
                    if (m0Var.g(g0Var3)) {
                        accessibilityNodeInfoObtain2.addAction(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
                    }
                }
                g0 g0Var4 = g0.d;
                boolean zG2 = m0Var.g(g0Var4);
                g0 g0Var5 = g0.o;
                g0 g0Var6 = g0.h;
                g0 g0Var7 = g0.f;
                if (zG2 || m0Var.g(g0Var6) || m0Var.g(g0Var7) || m0Var.g(g0Var5)) {
                    accessibilityNodeInfoObtain2.setScrollable(true);
                    if (m0Var.h(19)) {
                        if (m0Var.g(g0Var4) || m0Var.g(g0Var7)) {
                            accessibilityNodeInfoObtain2.setClassName("android.widget.HorizontalScrollView");
                        } else {
                            accessibilityNodeInfoObtain2.setClassName("android.widget.ScrollView");
                        }
                    }
                }
                if (m0Var.g(g0Var4) || m0Var.g(g0Var6)) {
                    accessibilityNodeInfoObtain2.addAction(AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE);
                }
                if (m0Var.g(g0Var7) || m0Var.g(g0Var5)) {
                    accessibilityNodeInfoObtain2.addAction(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
                }
                if (bVar.m(m0Var)) {
                    if (m0Var.g(g0Var4) || m0Var.g(g0Var7)) {
                        if (Build.VERSION.SDK_INT < 33) {
                            accessibilityNodeInfoObtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, m0Var.j, false));
                        } else {
                            accessibilityNodeInfoObtain2.setCollectionInfo(u0.C(m0Var.j));
                        }
                    } else if (Build.VERSION.SDK_INT < 33) {
                        accessibilityNodeInfoObtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(m0Var.j, 1, false));
                    } else {
                        accessibilityNodeInfoObtain2.setCollectionInfo(u0.p(m0Var.j));
                    }
                }
                m0 m0Var6 = m0Var.V;
                if (m0Var6 != null && bVar.m(m0Var6) && m0Var.V.h(19)) {
                    m0 m0Var7 = m0Var.V;
                    ArrayList arrayList2 = m0Var7.W;
                    boolean z = (m0Var7.g(g0Var4) || m0Var7.g(g0Var7)) ? false : true;
                    int iIndexOf = arrayList2.indexOf(m0Var);
                    if (z) {
                        if (Build.VERSION.SDK_INT < 33) {
                            accessibilityNodeInfoObtain2.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(iIndexOf, 1, 0, 1, m0Var.h(10)));
                        } else {
                            accessibilityNodeInfoObtain2.setCollectionItemInfo(u0.q(iIndexOf, m0Var.h(10)));
                        }
                    } else if (Build.VERSION.SDK_INT < 33) {
                        accessibilityNodeInfoObtain2.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, iIndexOf, 1, m0Var.h(10)));
                    } else {
                        accessibilityNodeInfoObtain2.setCollectionItemInfo(u0.D(iIndexOf, m0Var.h(10)));
                    }
                }
                if (m0Var.h(5)) {
                    j1 j1Var = new j1();
                    j1Var.a = m0Var.r;
                    j1Var.d = m0Var.s;
                    j1Var.b = m0Var.b();
                    accessibilityNodeInfoObtain2.setText(j1Var.a());
                    if (Build.VERSION.SDK_INT >= 28) {
                        j1 j1Var2 = new j1();
                        j1Var2.a = m0Var.p;
                        j1Var2.d = m0Var.q;
                        j1Var2.c = m0Var.A;
                        j1Var2.b = m0Var.b();
                        SpannableString spannableStringA = j1Var2.a();
                        j1 j1Var3 = new j1();
                        j1Var3.a = m0Var.x;
                        j1Var3.d = m0Var.y;
                        j1Var3.b = m0Var.b();
                        CharSequence[] charSequenceArr = {spannableStringA, j1Var3.a()};
                        CharSequence charSequence = null;
                        for (int i10 = 0; i10 < 2; i10++) {
                            CharSequence charSequenceConcat = charSequenceArr[i10];
                            if (charSequenceConcat != null && charSequenceConcat.length() > 0) {
                                if (charSequence != null && charSequence.length() != 0) {
                                    charSequenceConcat = TextUtils.concat(charSequence, ", ", charSequenceConcat);
                                }
                                charSequence = charSequenceConcat;
                            }
                        }
                        i2 = 3;
                        accessibilityNodeInfoObtain2.setHintText(charSequence);
                    } else {
                        i2 = 3;
                    }
                } else {
                    i2 = 3;
                    if (!m0Var.h(12)) {
                        CharSequence charSequenceE = m0Var.e();
                        if (Build.VERSION.SDK_INT < 28 && m0Var.z != null) {
                            charSequenceE = ((Object) (charSequenceE != null ? charSequenceE : "")) + "\n" + m0Var.z;
                        }
                        if (charSequenceE != null) {
                            accessibilityNodeInfoObtain2.setContentDescription(charSequenceE);
                        }
                    }
                }
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 28 && (str = m0Var.z) != null) {
                    accessibilityNodeInfoObtain2.setTooltipText(str);
                    if (m0Var.e() == null) {
                        accessibilityNodeInfoObtain2.setContentDescription(m0Var.z);
                    }
                }
                boolean zH2 = m0Var.h(1);
                boolean zH3 = m0Var.h(17);
                accessibilityNodeInfoObtain2.setCheckable(zH2 || zH3);
                if (zH2) {
                    if (m0Var.h(9)) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.RadioButton");
                    } else {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.CheckBox");
                    }
                    boolean zH4 = m0Var.h(2);
                    boolean zH5 = m0Var.h(26);
                    if (i11 >= 36) {
                        accessibilityNodeInfoObtain2.setChecked(zH5 ? 2 : zH4 ? 1 : 0);
                    } else {
                        accessibilityNodeInfoObtain2.setChecked(zH4);
                    }
                } else if (zH3) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Switch");
                    boolean zH6 = m0Var.h(18);
                    if (i11 >= 36) {
                        accessibilityNodeInfoObtain2.setChecked(zH6 ? 1 : 0);
                    } else {
                        accessibilityNodeInfoObtain2.setChecked(zH6);
                    }
                }
                if (i11 >= 36 && m0Var.h(27)) {
                    accessibilityNodeInfoObtain2.setExpandedState(m0Var.h(28) ? i2 : 1);
                    if (m0Var.g(g0.F)) {
                        accessibilityNodeInfoObtain2.addAction(Proxy.SOCKS_AUTH_NOT_SUPPORTED);
                    }
                    if (m0Var.g(g0.G)) {
                        accessibilityNodeInfoObtain2.addAction(Proxy.SOCKS_METHOD_NOTSUPPORTED);
                    }
                }
                mhVar.o(accessibilityNodeInfoObtain2, m0Var);
                m0 m0Var8 = m0Var.V;
                if (m0Var8 != null) {
                    accessibilityNodeInfoObtain2.setParent(view, m0Var8.b);
                } else {
                    accessibilityNodeInfoObtain2.setParent(view);
                }
                int i12 = m0Var.G;
                if (i12 != -1) {
                    accessibilityNodeInfoObtain2.setTraversalAfter(view, i12);
                }
                Rect rect = m0Var.f0;
                m0 m0Var9 = m0Var.V;
                if (m0Var9 != null) {
                    Rect rect2 = m0Var9.f0;
                    Rect rect3 = new Rect(rect);
                    rect3.offset(-rect2.left, -rect2.top);
                    accessibilityNodeInfoObtain2.setBoundsInParent(rect3);
                } else {
                    accessibilityNodeInfoObtain2.setBoundsInParent(rect);
                }
                Rect rect4 = new Rect(rect);
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                rect4.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(rect4);
                accessibilityNodeInfoObtain2.setVisibleToUser(true);
                accessibilityNodeInfoObtain2.setEnabled(!m0Var.h(7) || m0Var.h(8));
                ArrayList arrayList3 = m0Var.W;
                int size2 = arrayList3.size();
                int i13 = 0;
                while (i13 < size2) {
                    Object obj2 = arrayList3.get(i13);
                    i13++;
                    m0 m0Var10 = (m0) obj2;
                    if (!m0Var10.h(14)) {
                        int i14 = m0Var10.i;
                        if (i14 != -1) {
                            View viewK = j10Var.k(i14);
                            if (!j10Var.h(m0Var10.i) && viewK != null) {
                                viewK.setImportantForAccessibility(0);
                                accessibilityNodeInfoObtain2.addChild(viewK);
                            }
                        }
                        accessibilityNodeInfoObtain2.addChild(view, m0Var10.b);
                    }
                }
                return accessibilityNodeInfoObtain2;
            }
            View viewK2 = j10Var.k(m0Var.i);
            if (viewK2 != null) {
                return accessibilityViewEmbedder.getRootNode(viewK2, m0Var.b, m0Var.f0);
            }
        }
        return null;
    }

    public final AccessibilityEvent e(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        View view = this.a;
        accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        accessibilityEventObtain.setSource(view, i);
        return accessibilityEventObtain;
    }

    public final boolean f(MotionEvent motionEvent, boolean z) {
        m0 m0VarI;
        if (this.c.isTouchExplorationEnabled()) {
            HashMap map = this.g;
            if (!map.isEmpty()) {
                m0 m0VarI2 = ((m0) map.get(0)).i(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z);
                if (m0VarI2 == null || m0VarI2.i == -1) {
                    if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (!map.isEmpty() && (m0VarI = ((m0) map.get(0)).i(new float[]{x, y, 0.0f, 1.0f}, z)) != this.p) {
                            if (m0VarI != null) {
                                h(m0VarI.b, 128);
                            }
                            m0 m0Var = this.p;
                            if (m0Var != null) {
                                h(m0Var.b, 256);
                            }
                            this.p = m0VarI;
                        }
                    } else {
                        if (motionEvent.getAction() != 10) {
                            motionEvent.toString();
                            return false;
                        }
                        m0 m0Var2 = this.p;
                        if (m0Var2 != null) {
                            h(m0Var2.b, 256);
                            this.p = null;
                        }
                    }
                    return true;
                }
                if (!z) {
                    return this.d.onAccessibilityHoverEvent(m0VarI2.b, motionEvent);
                }
            }
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i) {
        if (i == 1) {
            m0 m0Var = this.n;
            if (m0Var != null) {
                return createAccessibilityNodeInfo(m0Var.b);
            }
            Integer num = this.k;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i != 2) {
            return null;
        }
        m0 m0Var2 = this.i;
        if (m0Var2 != null) {
            return createAccessibilityNodeInfo(m0Var2.b);
        }
        Integer num2 = this.j;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    public final boolean g(m0 m0Var, int i, Bundle bundle, boolean z) {
        int i2;
        int i3 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z2 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i4 = m0Var.g;
        int i5 = m0Var.h;
        if (i5 >= 0 && i4 >= 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 == 8 || i3 == 16) {
                            if (z) {
                                m0Var.h = m0Var.r.length();
                            } else {
                                m0Var.h = 0;
                            }
                        }
                    } else if (z && i5 < m0Var.r.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(m0Var.r.substring(m0Var.h));
                        if (matcher.find()) {
                            m0Var.h = matcher.start(1) + m0Var.h;
                        } else {
                            m0Var.h = m0Var.r.length();
                        }
                    } else if (!z && m0Var.h > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(m0Var.r.substring(0, m0Var.h));
                        if (matcher2.find()) {
                            m0Var.h = matcher2.start(1);
                        } else {
                            m0Var.h = 0;
                        }
                    }
                } else if (z && i5 < m0Var.r.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(m0Var.r.substring(m0Var.h));
                    matcher3.find();
                    if (matcher3.find()) {
                        m0Var.h = matcher3.start(1) + m0Var.h;
                    } else {
                        m0Var.h = m0Var.r.length();
                    }
                } else if (!z && m0Var.h > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(m0Var.r.substring(0, m0Var.h));
                    if (matcher4.find()) {
                        m0Var.h = matcher4.start(1);
                    }
                }
            } else if (z && i5 < m0Var.r.length()) {
                m0Var.h++;
            } else if (!z && (i2 = m0Var.h) > 0) {
                m0Var.h = i2 - 1;
            }
            if (!z2) {
                m0Var.g = m0Var.h;
            }
        }
        if (i4 != m0Var.g || i5 != m0Var.h) {
            String str = m0Var.r;
            if (str == null) {
                str = "";
            }
            AccessibilityEvent accessibilityEventE = e(m0Var.b, AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            accessibilityEventE.getText().add(str);
            accessibilityEventE.setFromIndex(m0Var.g);
            accessibilityEventE.setToIndex(m0Var.h);
            accessibilityEventE.setItemCount(str.length());
            i(accessibilityEventE);
        }
        o4 o4Var = this.b;
        if (i3 == 1) {
            if (z) {
                g0 g0Var = g0.s;
                if (m0Var.g(g0Var)) {
                    o4Var.A(i, g0Var, Boolean.valueOf(z2));
                    return true;
                }
            }
            if (!z) {
                g0 g0Var2 = g0.t;
                if (m0Var.g(g0Var2)) {
                    o4Var.A(i, g0Var2, Boolean.valueOf(z2));
                    return true;
                }
            }
        } else if (i3 == 2) {
            if (z) {
                g0 g0Var3 = g0.C;
                if (m0Var.g(g0Var3)) {
                    o4Var.A(i, g0Var3, Boolean.valueOf(z2));
                    return true;
                }
            }
            if (!z) {
                g0 g0Var4 = g0.D;
                if (m0Var.g(g0Var4)) {
                    o4Var.A(i, g0Var4, Boolean.valueOf(z2));
                    return true;
                }
            }
        } else if (i3 == 4 || i3 == 8 || i3 == 16) {
            return true;
        }
        return false;
    }

    public final void h(int i, int i2) {
        if (this.c.isEnabled()) {
            i(e(i, i2));
        }
    }

    public final void i(AccessibilityEvent accessibilityEvent) {
        if (this.c.isEnabled()) {
            View view = this.a;
            view.getParent().requestSendAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public final void j(int i, int i2) {
        AccessibilityEvent accessibilityEventE = e(i, 2048);
        accessibilityEventE.setContentChangeTypes(i2);
        i(accessibilityEventE);
    }

    public final void k(boolean z) {
        if (this.t == z) {
            return;
        }
        this.t = z;
        n(1, z);
    }

    public final void l() {
        UiModeManager uiModeManager = (UiModeManager) this.a.getContext().getSystemService("uimode");
        if (uiModeManager == null) {
            n(6, false);
        } else {
            n(6, uiModeManager.getContrast() > 0.0f);
        }
    }

    public final boolean m(m0 m0Var) {
        if (m0Var.j > 1) {
            m0 m0Var2 = this.i;
            m0 m0Var3 = null;
            if (m0Var2 != null) {
                m0 m0Var4 = m0Var2.V;
                while (true) {
                    if (m0Var4 == null) {
                        m0Var4 = null;
                        break;
                    }
                    if (m0Var4 == m0Var) {
                        break;
                    }
                    m0Var4 = m0Var4.V;
                }
                if (m0Var4 != null) {
                    return true;
                }
            }
            m0 m0Var5 = this.i;
            c0 c0Var = new c0();
            if (m0Var5 != null) {
                m0 m0Var6 = m0Var5.V;
                while (true) {
                    if (m0Var6 == null) {
                        break;
                    }
                    if (c0Var.test(m0Var6)) {
                        m0Var3 = m0Var6;
                        break;
                    }
                    m0Var6 = m0Var6.V;
                }
                if (m0Var3 != null) {
                }
            }
            return true;
        }
        return false;
    }

    public final void n(int i, boolean z) {
        if (z) {
            this.l = za0.d(i) | this.l;
        } else {
            this.l = (~za0.d(i)) & this.l;
        }
        ((FlutterJNI) this.b.c).setAccessibilityFeatures(this.l);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i, int i2, Bundle bundle) {
        if (i >= 65536) {
            boolean zPerformAction = this.d.performAction(i, i2, bundle);
            if (zPerformAction && i2 == 128) {
                this.j = null;
            }
            return zPerformAction;
        }
        Integer numValueOf = Integer.valueOf(i);
        HashMap map = this.g;
        m0 m0Var = (m0) map.get(numValueOf);
        if (m0Var != null) {
            g0 g0Var = g0.p;
            g0 g0Var2 = g0.q;
            o4 o4Var = this.b;
            switch (i2) {
                case 16:
                    o4Var.z(i, g0.b);
                    return true;
                case 32:
                    o4Var.z(i, g0.c);
                    return true;
                case 64:
                    if (this.i == null) {
                        this.a.invalidate();
                    }
                    this.i = m0Var;
                    o4Var.z(i, g0.y);
                    HashMap map2 = new HashMap();
                    map2.put("type", "didGainFocus");
                    map2.put("nodeId", Integer.valueOf(m0Var.b));
                    ((j1) o4Var.b).k(map2, null);
                    h(i, AttribFlags.SSH_FILEXFER_ATTR_CTIME);
                    if (!m0Var.g(g0Var) && !m0Var.g(g0Var2)) {
                        return true;
                    }
                    h(i, 4);
                    return true;
                case 128:
                    m0 m0Var2 = this.i;
                    if (m0Var2 != null && m0Var2.b == i) {
                        this.i = null;
                    }
                    Integer num = this.j;
                    if (num != null && num.intValue() == i) {
                        this.j = null;
                    }
                    o4Var.z(i, g0.z);
                    h(i, Proxy.SOCKS_NO_PROXY);
                    return true;
                case 256:
                    return g(m0Var, i, bundle, true);
                case 512:
                    return g(m0Var, i, bundle, false);
                case AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE /* 4096 */:
                    g0 g0Var3 = g0.h;
                    if (m0Var.g(g0Var3)) {
                        o4Var.z(i, g0Var3);
                        return true;
                    }
                    g0 g0Var4 = g0.d;
                    if (m0Var.g(g0Var4)) {
                        o4Var.z(i, g0Var4);
                        return true;
                    }
                    if (m0Var.g(g0Var)) {
                        m0Var.r = m0Var.t;
                        m0Var.s = m0Var.u;
                        h(i, 4);
                        o4Var.z(i, g0Var);
                        return true;
                    }
                    break;
                case AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT /* 8192 */:
                    g0 g0Var5 = g0.o;
                    if (m0Var.g(g0Var5)) {
                        o4Var.z(i, g0Var5);
                        return true;
                    }
                    g0 g0Var6 = g0.f;
                    if (m0Var.g(g0Var6)) {
                        o4Var.z(i, g0Var6);
                        return true;
                    }
                    if (m0Var.g(g0Var2)) {
                        m0Var.r = m0Var.v;
                        m0Var.s = m0Var.w;
                        h(i, 4);
                        o4Var.z(i, g0Var2);
                        return true;
                    }
                    break;
                case AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME /* 16384 */:
                    o4Var.z(i, g0.v);
                    return true;
                case AttribFlags.SSH_FILEXFER_ATTR_CTIME /* 32768 */:
                    o4Var.z(i, g0.x);
                    return true;
                case Proxy.SOCKS_NO_PROXY /* 65536 */:
                    o4Var.z(i, g0.w);
                    return true;
                case Proxy.SOCKS_PROXY_NO_CONNECT /* 131072 */:
                    HashMap map3 = new HashMap();
                    if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                        map3.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                        map3.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                    } else {
                        map3.put("base", Integer.valueOf(m0Var.h));
                        map3.put("extent", Integer.valueOf(m0Var.h));
                    }
                    o4Var.A(i, g0.u, map3);
                    m0 m0Var3 = (m0) map.get(Integer.valueOf(i));
                    m0Var3.g = ((Integer) map3.get("base")).intValue();
                    m0Var3.h = ((Integer) map3.get("extent")).intValue();
                    return true;
                case Proxy.SOCKS_AUTH_NOT_SUPPORTED /* 262144 */:
                    o4Var.z(i, g0.F);
                    return true;
                case Proxy.SOCKS_METHOD_NOTSUPPORTED /* 524288 */:
                    o4Var.z(i, g0.G);
                    return true;
                case 1048576:
                    o4Var.z(i, g0.B);
                    return true;
                case 2097152:
                    String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
                    o4Var.A(i, g0.E, string);
                    m0Var.r = string;
                    m0Var.s = null;
                    return true;
                case R.id.accessibilityActionShowOnScreen:
                    o4Var.z(i, g0.r);
                    return true;
                default:
                    j0 j0Var = (j0) this.h.get(Integer.valueOf(i2 - A));
                    if (j0Var != null) {
                        o4Var.A(i, g0.A, Integer.valueOf(j0Var.b));
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
