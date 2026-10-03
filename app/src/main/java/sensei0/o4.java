package sensei0;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.ClipDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.sensei.tunnel.R;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugins.urllauncher.WebViewActivity;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class o4 implements y5, fr, r80, gl {
    public static volatile o4 f;
    public static final Object h = new Object();
    public static o4 o;
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ o4(int i) {
        this.a = i;
    }

    public static Bundle C(Map map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, (String) map.get(str));
        }
        return bundle;
    }

    public static o4 H(Context context) {
        if (f == null) {
            synchronized (h) {
                try {
                    if (f == null) {
                        f = new o4(context, 0);
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public static o4 O() {
        if (o == null) {
            pf pfVar = new pf(10);
            om omVar = new om();
            omVar.a = 0;
            ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(omVar);
            FlutterJNI flutterJNI = new FlutterJNI();
            um umVar = new um();
            umVar.a = false;
            umVar.b = false;
            umVar.f = flutterJNI;
            umVar.g = executorServiceNewCachedThreadPool;
            o4 o4Var = new o4(8);
            o4Var.b = umVar;
            o4Var.c = pfVar;
            o4Var.d = executorServiceNewCachedThreadPool;
            o = o4Var;
        }
        return o;
    }

    public static o4 Q(Context context, AttributeSet attributeSet, int[] iArr, int i) {
        return new o4(context, context.obtainStyledAttributes(attributeSet, iArr, i, 0));
    }

    public static void X(a6 a6Var, final o4 o4Var) {
        lx lxVar = lx.f;
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.canLaunchUrl", lxVar, null);
        if (o4Var != null) {
            final int i = 0;
            j1Var.l(new u5(o4Var) { // from class: sensei0.ox
                public final /* synthetic */ o4 b;

                {
                    this.b = o4Var;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    Boolean bool;
                    switch (i) {
                        case 0:
                            o4 o4Var2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, o4Var2.v((String) ((ArrayList) obj).get(0)));
                                break;
                            } catch (Throwable th) {
                                arrayList = k6.Z(th);
                            }
                            i3Var.s(arrayList);
                            return;
                        case 1:
                            o4 o4Var3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            String str = (String) arrayList3.get(0);
                            Map map = (Map) arrayList3.get(1);
                            try {
                                if (((Activity) o4Var3.c) == null) {
                                    throw new jx();
                                }
                                try {
                                    ((Activity) o4Var3.c).startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", o4.C(map)));
                                    bool = Boolean.TRUE;
                                } catch (ActivityNotFoundException unused) {
                                    bool = Boolean.FALSE;
                                }
                                arrayList2.add(0, bool);
                            } catch (Throwable th2) {
                                arrayList2 = k6.Z(th2);
                            }
                            i3Var.s(arrayList2);
                            return;
                        case 2:
                            o4 o4Var4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, o4Var4.T((String) arrayList5.get(0), (Boolean) arrayList5.get(1), (px) arrayList5.get(2), (ix) arrayList5.get(3)));
                                break;
                            } catch (Throwable th3) {
                                arrayList4 = k6.Z(th3);
                            }
                            i3Var.s(arrayList4);
                            return;
                        case 3:
                            o4 o4Var5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                arrayList6.add(0, o4Var5.Z());
                                break;
                            } catch (Throwable th4) {
                                arrayList6 = k6.Z(th4);
                            }
                            i3Var.s(arrayList6);
                            return;
                        default:
                            o4 o4Var6 = this.b;
                            ArrayList arrayList7 = new ArrayList();
                            try {
                                ((Context) o4Var6.d).sendBroadcast(new Intent("close action"));
                                arrayList7.add(0, null);
                                break;
                            } catch (Throwable th5) {
                                arrayList7 = k6.Z(th5);
                            }
                            i3Var.s(arrayList7);
                            return;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.launchUrl", lxVar, null);
        if (o4Var != null) {
            final int i2 = 1;
            j1Var2.l(new u5(o4Var) { // from class: sensei0.ox
                public final /* synthetic */ o4 b;

                {
                    this.b = o4Var;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    Boolean bool;
                    switch (i2) {
                        case 0:
                            o4 o4Var2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, o4Var2.v((String) ((ArrayList) obj).get(0)));
                                break;
                            } catch (Throwable th) {
                                arrayList = k6.Z(th);
                            }
                            i3Var.s(arrayList);
                            return;
                        case 1:
                            o4 o4Var3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            String str = (String) arrayList3.get(0);
                            Map map = (Map) arrayList3.get(1);
                            try {
                                if (((Activity) o4Var3.c) == null) {
                                    throw new jx();
                                }
                                try {
                                    ((Activity) o4Var3.c).startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", o4.C(map)));
                                    bool = Boolean.TRUE;
                                } catch (ActivityNotFoundException unused) {
                                    bool = Boolean.FALSE;
                                }
                                arrayList2.add(0, bool);
                            } catch (Throwable th2) {
                                arrayList2 = k6.Z(th2);
                            }
                            i3Var.s(arrayList2);
                            return;
                        case 2:
                            o4 o4Var4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, o4Var4.T((String) arrayList5.get(0), (Boolean) arrayList5.get(1), (px) arrayList5.get(2), (ix) arrayList5.get(3)));
                                break;
                            } catch (Throwable th3) {
                                arrayList4 = k6.Z(th3);
                            }
                            i3Var.s(arrayList4);
                            return;
                        case 3:
                            o4 o4Var5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                arrayList6.add(0, o4Var5.Z());
                                break;
                            } catch (Throwable th4) {
                                arrayList6 = k6.Z(th4);
                            }
                            i3Var.s(arrayList6);
                            return;
                        default:
                            o4 o4Var6 = this.b;
                            ArrayList arrayList7 = new ArrayList();
                            try {
                                ((Context) o4Var6.d).sendBroadcast(new Intent("close action"));
                                arrayList7.add(0, null);
                                break;
                            } catch (Throwable th5) {
                                arrayList7 = k6.Z(th5);
                            }
                            i3Var.s(arrayList7);
                            return;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.openUrlInApp", lxVar, null);
        if (o4Var != null) {
            final int i3 = 2;
            j1Var3.l(new u5(o4Var) { // from class: sensei0.ox
                public final /* synthetic */ o4 b;

                {
                    this.b = o4Var;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    Boolean bool;
                    switch (i3) {
                        case 0:
                            o4 o4Var2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, o4Var2.v((String) ((ArrayList) obj).get(0)));
                                break;
                            } catch (Throwable th) {
                                arrayList = k6.Z(th);
                            }
                            i3Var.s(arrayList);
                            return;
                        case 1:
                            o4 o4Var3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            String str = (String) arrayList3.get(0);
                            Map map = (Map) arrayList3.get(1);
                            try {
                                if (((Activity) o4Var3.c) == null) {
                                    throw new jx();
                                }
                                try {
                                    ((Activity) o4Var3.c).startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", o4.C(map)));
                                    bool = Boolean.TRUE;
                                } catch (ActivityNotFoundException unused) {
                                    bool = Boolean.FALSE;
                                }
                                arrayList2.add(0, bool);
                            } catch (Throwable th2) {
                                arrayList2 = k6.Z(th2);
                            }
                            i3Var.s(arrayList2);
                            return;
                        case 2:
                            o4 o4Var4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, o4Var4.T((String) arrayList5.get(0), (Boolean) arrayList5.get(1), (px) arrayList5.get(2), (ix) arrayList5.get(3)));
                                break;
                            } catch (Throwable th3) {
                                arrayList4 = k6.Z(th3);
                            }
                            i3Var.s(arrayList4);
                            return;
                        case 3:
                            o4 o4Var5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                arrayList6.add(0, o4Var5.Z());
                                break;
                            } catch (Throwable th4) {
                                arrayList6 = k6.Z(th4);
                            }
                            i3Var.s(arrayList6);
                            return;
                        default:
                            o4 o4Var6 = this.b;
                            ArrayList arrayList7 = new ArrayList();
                            try {
                                ((Context) o4Var6.d).sendBroadcast(new Intent("close action"));
                                arrayList7.add(0, null);
                                break;
                            } catch (Throwable th5) {
                                arrayList7 = k6.Z(th5);
                            }
                            i3Var.s(arrayList7);
                            return;
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.supportsCustomTabs", lxVar, null);
        if (o4Var != null) {
            final int i4 = 3;
            j1Var4.l(new u5(o4Var) { // from class: sensei0.ox
                public final /* synthetic */ o4 b;

                {
                    this.b = o4Var;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    Boolean bool;
                    switch (i4) {
                        case 0:
                            o4 o4Var2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, o4Var2.v((String) ((ArrayList) obj).get(0)));
                                break;
                            } catch (Throwable th) {
                                arrayList = k6.Z(th);
                            }
                            i3Var.s(arrayList);
                            return;
                        case 1:
                            o4 o4Var3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            String str = (String) arrayList3.get(0);
                            Map map = (Map) arrayList3.get(1);
                            try {
                                if (((Activity) o4Var3.c) == null) {
                                    throw new jx();
                                }
                                try {
                                    ((Activity) o4Var3.c).startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", o4.C(map)));
                                    bool = Boolean.TRUE;
                                } catch (ActivityNotFoundException unused) {
                                    bool = Boolean.FALSE;
                                }
                                arrayList2.add(0, bool);
                            } catch (Throwable th2) {
                                arrayList2 = k6.Z(th2);
                            }
                            i3Var.s(arrayList2);
                            return;
                        case 2:
                            o4 o4Var4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, o4Var4.T((String) arrayList5.get(0), (Boolean) arrayList5.get(1), (px) arrayList5.get(2), (ix) arrayList5.get(3)));
                                break;
                            } catch (Throwable th3) {
                                arrayList4 = k6.Z(th3);
                            }
                            i3Var.s(arrayList4);
                            return;
                        case 3:
                            o4 o4Var5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                arrayList6.add(0, o4Var5.Z());
                                break;
                            } catch (Throwable th4) {
                                arrayList6 = k6.Z(th4);
                            }
                            i3Var.s(arrayList6);
                            return;
                        default:
                            o4 o4Var6 = this.b;
                            ArrayList arrayList7 = new ArrayList();
                            try {
                                ((Context) o4Var6.d).sendBroadcast(new Intent("close action"));
                                arrayList7.add(0, null);
                                break;
                            } catch (Throwable th5) {
                                arrayList7 = k6.Z(th5);
                            }
                            i3Var.s(arrayList7);
                            return;
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, "dev.flutter.pigeon.url_launcher_android.UrlLauncherApi.closeWebView", lxVar, null);
        if (o4Var == null) {
            j1Var5.l(null);
        } else {
            final int i5 = 4;
            j1Var5.l(new u5(o4Var) { // from class: sensei0.ox
                public final /* synthetic */ o4 b;

                {
                    this.b = o4Var;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    Boolean bool;
                    switch (i5) {
                        case 0:
                            o4 o4Var2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, o4Var2.v((String) ((ArrayList) obj).get(0)));
                                break;
                            } catch (Throwable th) {
                                arrayList = k6.Z(th);
                            }
                            i3Var.s(arrayList);
                            return;
                        case 1:
                            o4 o4Var3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            String str = (String) arrayList3.get(0);
                            Map map = (Map) arrayList3.get(1);
                            try {
                                if (((Activity) o4Var3.c) == null) {
                                    throw new jx();
                                }
                                try {
                                    ((Activity) o4Var3.c).startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse(str)).putExtra("com.android.browser.headers", o4.C(map)));
                                    bool = Boolean.TRUE;
                                } catch (ActivityNotFoundException unused) {
                                    bool = Boolean.FALSE;
                                }
                                arrayList2.add(0, bool);
                            } catch (Throwable th2) {
                                arrayList2 = k6.Z(th2);
                            }
                            i3Var.s(arrayList2);
                            return;
                        case 2:
                            o4 o4Var4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, o4Var4.T((String) arrayList5.get(0), (Boolean) arrayList5.get(1), (px) arrayList5.get(2), (ix) arrayList5.get(3)));
                                break;
                            } catch (Throwable th3) {
                                arrayList4 = k6.Z(th3);
                            }
                            i3Var.s(arrayList4);
                            return;
                        case 3:
                            o4 o4Var5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                arrayList6.add(0, o4Var5.Z());
                                break;
                            } catch (Throwable th4) {
                                arrayList6 = k6.Z(th4);
                            }
                            i3Var.s(arrayList6);
                            return;
                        default:
                            o4 o4Var6 = this.b;
                            ArrayList arrayList7 = new ArrayList();
                            try {
                                ((Context) o4Var6.d).sendBroadcast(new Intent("close action"));
                                arrayList7.add(0, null);
                                break;
                            } catch (Throwable th5) {
                                arrayList7 = k6.Z(th5);
                            }
                            i3Var.s(arrayList7);
                            return;
                    }
                }
            });
        }
    }

    public static boolean x(Editable editable, KeyEvent keyEvent, boolean z) {
        fg0[] fg0VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (fg0VarArr = (fg0[]) editable.getSpans(selectionStart, selectionEnd, fg0.class)) != null && fg0VarArr.length > 0) {
                for (fg0 fg0Var : fg0VarArr) {
                    int spanStart = editable.getSpanStart(fg0Var);
                    int spanEnd = editable.getSpanEnd(fg0Var);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void A(int i, g0 g0Var, Serializable serializable) {
        ((FlutterJNI) this.c).dispatchSemanticsAction(i, g0Var, serializable);
    }

    public Object B(Class cls, HashSet hashSet) {
        boolean zBooleanValue;
        Object objB;
        HashMap map = (HashMap) this.b;
        if (Build.VERSION.SDK_INT >= 29) {
            zBooleanValue = bf0.c();
        } else {
            try {
                if (mm0.i == null) {
                    mm0.h = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    mm0.i = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                zBooleanValue = ((Boolean) mm0.i.invoke(null, Long.valueOf(mm0.h))).booleanValue();
            } catch (Exception e) {
                mm0.F("isTagEnabled", e);
                zBooleanValue = false;
            }
        }
        if (zBooleanValue) {
            try {
                Trace.beginSection(mm0.l0(cls.getSimpleName()));
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        if (map.containsKey(cls)) {
            objB = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                ar arVar = (ar) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listA = arVar.a();
                if (!listA.isEmpty()) {
                    for (Class cls2 : listA) {
                        if (!map.containsKey(cls2)) {
                            B(cls2, hashSet);
                        }
                    }
                }
                objB = arVar.b((Context) this.d);
                hashSet.remove(cls);
                map.put(cls, objB);
            } catch (Throwable th2) {
                throw new ia(th2);
            }
        }
        Trace.endSection();
        return objB;
    }

    public int D(int i, int i2) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        while (i2 < size) {
            ((m2) arrayList.get(i2)).getClass();
            i2++;
        }
        return i;
    }

    public ColorStateList E(int i) {
        int resourceId;
        ColorStateList colorStateListK;
        TypedArray typedArray = (TypedArray) this.b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListK = wf0.k((Context) this.d, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListK;
    }

    public Drawable F(int i) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) ? typedArray.getDrawable(i) : wf0.m((Context) this.d, resourceId);
    }

    public Typeface G(int i, int i2, z3 z3Var) {
        int resourceId = ((TypedArray) this.b).getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.c) == null) {
            this.c = new TypedValue();
        }
        Context context = (Context) this.d;
        TypedValue typedValue = (TypedValue) this.c;
        ThreadLocal threadLocal = s50.a;
        if (context.isRestricted()) {
            return null;
        }
        return s50.b(context, resourceId, typedValue, i2, z3Var, true, false);
    }

    public int I(int i) {
        k8 k8Var = (k8) this.c;
        if (i < 0) {
            return -1;
        }
        int childCount = ((z30) this.b).a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int iB = i - (i2 - k8Var.b(i2));
            if (iB == 0) {
                while (k8Var.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iB;
        }
        return -1;
    }

    public View J(int i) {
        return ((z30) this.b).a.getChildAt(i);
    }

    public int K() {
        return ((z30) this.b).a.getChildCount();
    }

    public boolean L(KeyEvent keyEvent) {
        ys[] ysVarArr = (ys[]) this.b;
        if (((HashSet) this.c).remove(keyEvent)) {
            return false;
        }
        if (ysVarArr.length <= 0) {
            R(keyEvent);
            return true;
        }
        i5 i5Var = new i5(this, keyEvent);
        for (ys ysVar : ysVarArr) {
            ysVar.j(keyEvent, new g6(i5Var));
        }
        return true;
    }

    public boolean M(CharSequence charSequence, int i, int i2, eg0 eg0Var) {
        if ((eg0Var.c & 3) == 0) {
            rh rhVar = (rh) this.d;
            qx qxVarB = eg0Var.b();
            int iA = qxVarB.a(8);
            if (iA != 0) {
                ((ByteBuffer) qxVarB.d).getShort(iA + qxVarB.a);
            }
            cf cfVar = (cf) rhVar;
            cfVar.getClass();
            ThreadLocal threadLocal = cf.b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = cfVar.a;
            String string = sb.toString();
            int i3 = pz.a;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i4 = eg0Var.c & 4;
            eg0Var.c = zHasGlyph ? i4 | 2 : i4 | 1;
        }
        return (eg0Var.c & 3) == 2;
    }

    public boolean N() {
        return ((ArrayList) this.c).size() > 0;
    }

    public boolean P(ya yaVar, hb hbVar, boolean z) {
        s5 s5Var = (s5) this.c;
        int[] iArr = hbVar.c0;
        int[] iArr2 = hbVar.l;
        s5Var.a = iArr[0];
        s5Var.b = iArr[1];
        s5Var.c = hbVar.l();
        s5Var.d = hbVar.i();
        s5Var.i = false;
        s5Var.j = z;
        boolean z2 = s5Var.a == 3;
        boolean z3 = s5Var.b == 3;
        boolean z4 = z2 && hbVar.L > 0.0f;
        boolean z5 = z3 && hbVar.L > 0.0f;
        if (z4 && iArr2[0] == 4) {
            s5Var.a = 1;
        }
        if (z5 && iArr2[1] == 4) {
            s5Var.b = 1;
        }
        yaVar.a(hbVar, s5Var);
        hbVar.y(s5Var.e);
        hbVar.v(s5Var.f);
        hbVar.w = s5Var.h;
        int i = s5Var.g;
        hbVar.P = i;
        hbVar.w = i > 0;
        s5Var.j = false;
        return s5Var.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void R(android.view.KeyEvent r10) {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o4.R(android.view.KeyEvent):void");
    }

    public void S(Activity activity, wl0 wl0Var) {
        WeakHashMap weakHashMap = (WeakHashMap) this.d;
        pr.j("activity", activity);
        ReentrantLock reentrantLock = (ReentrantLock) this.c;
        reentrantLock.lock();
        try {
            if (wl0Var.equals((wl0) weakHashMap.get(activity))) {
                return;
            }
            reentrantLock.unlock();
            for (ha0 ha0Var : ((ia0) ((ws) this.b).b).b) {
                if (ha0Var.a.equals(activity)) {
                    ha0Var.c = wl0Var;
                    ha0Var.b.accept(wl0Var);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public Boolean T(String str, Boolean bool, px pxVar, ix ixVar) {
        ActivityOptions activityOptionsA;
        if (((Activity) this.c) == null) {
            throw new jx();
        }
        Bundle bundleC = C(pxVar.c);
        if (bool.booleanValue()) {
            Iterator it = pxVar.c.keySet().iterator();
            while (true) {
                byte b = 1;
                if (it.hasNext()) {
                    String lowerCase = ((String) it.next()).toLowerCase(Locale.US);
                    lowerCase.getClass();
                    switch (lowerCase.hashCode()) {
                        case -1423461112:
                            if (!lowerCase.equals("accept")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case -1229727188:
                            if (!lowerCase.equals("content-language")) {
                                b = -1;
                            }
                            break;
                        case 785670158:
                            if (!lowerCase.equals("content-type")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 802785917:
                            if (!lowerCase.equals("accept-language")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                    }
                } else {
                    Uri uri = Uri.parse(str);
                    Activity activity = (Activity) this.c;
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", ixVar.a.booleanValue() ? 1 : 0);
                    if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                        Bundle bundle = new Bundle();
                        bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                        intent.putExtras(bundle);
                    }
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.putExtras(new Bundle());
                    intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
                    int i = Build.VERSION.SDK_INT;
                    String strA = ed.a();
                    if (!TextUtils.isEmpty(strA)) {
                        Bundle bundleExtra = intent.hasExtra("com.android.browser.headers") ? intent.getBundleExtra("com.android.browser.headers") : new Bundle();
                        if (!bundleExtra.containsKey("Accept-Language")) {
                            bundleExtra.putString("Accept-Language", strA);
                            intent.putExtra("com.android.browser.headers", bundleExtra);
                        }
                    }
                    if (i >= 34) {
                        activityOptionsA = dd.a();
                        fd.a(activityOptionsA, false);
                    } else {
                        activityOptionsA = null;
                    }
                    Bundle bundle2 = activityOptionsA != null ? activityOptionsA.toBundle() : null;
                    intent.putExtra("com.android.browser.headers", bundleC);
                    try {
                        intent.setData(uri);
                        activity.startActivity(intent, bundle2);
                        return Boolean.TRUE;
                    } catch (ActivityNotFoundException unused) {
                    }
                }
            }
        }
        Activity activity2 = (Activity) this.c;
        boolean zBooleanValue = pxVar.a.booleanValue();
        boolean zBooleanValue2 = pxVar.b.booleanValue();
        int i2 = WebViewActivity.f;
        try {
            ((Activity) this.c).startActivity(new Intent(activity2, (Class<?>) WebViewActivity.class).putExtra("url", str).putExtra("enableJavaScript", zBooleanValue).putExtra("enableDomStorage", zBooleanValue2).putExtra("com.android.browser.headers", bundleC));
            return Boolean.TRUE;
        } catch (ActivityNotFoundException unused2) {
            return Boolean.FALSE;
        }
    }

    public Object U(CharSequence charSequence, int i, int i2, int i3, boolean z, fi fiVar) {
        int i4;
        char c;
        gi giVar = new gi((sx) ((j1) this.c).c);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int i5 = 0;
        boolean zQ = true;
        int iCharCount = i;
        loop0: while (true) {
            i4 = iCharCount;
            while (iCharCount < i2 && i5 < i3 && zQ) {
                SparseArray sparseArray = giVar.c.a;
                sx sxVar = sparseArray == null ? null : (sx) sparseArray.get(iCodePointAt);
                if (giVar.a == 2) {
                    if (sxVar != null) {
                        giVar.c = sxVar;
                        giVar.f++;
                    } else {
                        if (iCodePointAt == 65038) {
                            giVar.a();
                        } else if (iCodePointAt != 65039) {
                            sx sxVar2 = giVar.c;
                            if (sxVar2.b != null) {
                                if (giVar.f != 1) {
                                    giVar.d = sxVar2;
                                    giVar.a();
                                } else if (giVar.b()) {
                                    giVar.d = giVar.c;
                                    giVar.a();
                                } else {
                                    giVar.a();
                                }
                                c = 3;
                            } else {
                                giVar.a();
                            }
                        }
                        c = 1;
                    }
                    c = 2;
                } else if (sxVar == null) {
                    giVar.a();
                    c = 1;
                } else {
                    giVar.a = 2;
                    giVar.c = sxVar;
                    giVar.f = 1;
                    c = 2;
                }
                giVar.e = iCodePointAt;
                if (c == 1) {
                    iCharCount = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                    if (iCharCount < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                } else if (c == 2) {
                    int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                    if (iCharCount2 < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                    }
                    iCharCount = iCharCount2;
                } else if (c == 3) {
                    if (z || !M(charSequence, i4, iCharCount, giVar.d.b)) {
                        zQ = fiVar.q(charSequence, i4, iCharCount, giVar.d.b);
                        i5++;
                    }
                }
            }
            break loop0;
        }
        if (giVar.a == 2 && giVar.c.b != null && ((giVar.f > 1 || giVar.b()) && i5 < i3 && zQ && (z || !M(charSequence, i4, iCharCount, giVar.c.b)))) {
            fiVar.q(charSequence, i4, iCharCount, giVar.c.b);
        }
        return fiVar.a();
    }

    public void V() {
        ((TypedArray) this.b).recycle();
    }

    public void W(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            m2 m2Var = (m2) arrayList.get(i);
            m2Var.getClass();
            ((s10) this.b).c(m2Var);
        }
        arrayList.clear();
    }

    public void Y(ib ibVar, int i, int i2) {
        int i3 = ibVar.Q;
        int i4 = ibVar.R;
        ibVar.Q = 0;
        ibVar.R = 0;
        ibVar.y(i);
        ibVar.v(i2);
        if (i3 < 0) {
            ibVar.Q = 0;
        } else {
            ibVar.Q = i3;
        }
        if (i4 < 0) {
            ibVar.R = 0;
        } else {
            ibVar.R = i4;
        }
        ((ib) this.d).E();
    }

    public Boolean Z() {
        String str;
        Context context = (Context) this.d;
        List list = Collections.EMPTY_LIST;
        PackageManager packageManager = context.getPackageManager();
        List arrayList = list == null ? new ArrayList() : list;
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://")), 0);
        if (resolveInfoResolveActivity != null) {
            String str2 = resolveInfoResolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str2);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                str = (String) it.next();
                intent.setPackage(str);
                if (packageManager.resolveService(intent, 0) != null) {
                    break;
                }
            } else {
                if (Build.VERSION.SDK_INT >= 30) {
                    Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
                }
                str = null;
            }
        }
        return Boolean.valueOf(str != null);
    }

    @Override // sensei0.r80
    public Double a(String str, s80 s80Var) {
        SharedPreferences sharedPreferencesW = w(s80Var);
        if (!sharedPreferencesW.contains(str)) {
            return null;
        }
        Object objC = u90.c(sharedPreferencesW.getString(str, ""), (pf) this.c);
        pr.g("null cannot be cast to non-null type kotlin.Double", objC);
        return (Double) objC;
    }

    public void a0(View view) {
        if (((ArrayList) this.d).remove(view)) {
            RecyclerView.r(view);
        }
    }

    @Override // sensei0.r80
    public void b(String str, boolean z, s80 s80Var) {
        w(s80Var).edit().putBoolean(str, z).apply();
    }

    @Override // sensei0.r80
    public ec0 c(String str, s80 s80Var) {
        SharedPreferences sharedPreferencesW = w(s80Var);
        if (!sharedPreferencesW.contains(str)) {
            return null;
        }
        String string = sharedPreferencesW.getString(str, "");
        pr.f(string);
        return nc0.d0(string, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!", false) ? new ec0(string, cc0.d) : nc0.d0(string, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu", false) ? new ec0(null, cc0.c) : new ec0(null, cc0.f);
    }

    @Override // sensei0.r80
    public void d(String str, long j, s80 s80Var) {
        w(s80Var).edit().putLong(str, j).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // sensei0.gl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(sensei0.il r6, sensei0.yb r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof sensei0.b90
            if (r0 == 0) goto L13
            r0 = r7
            sensei0.b90 r0 = (sensei0.b90) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            sensei0.b90 r0 = new sensei0.b90
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.d
            int r1 = r0.f
            r2 = 1
            if (r1 == 0) goto L2d
            if (r1 != r2) goto L25
            sensei0.wf0.H(r7)
            goto L4c
        L25:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            sensei0.wf0.H(r7)
            java.lang.Object r7 = r5.b
            sensei0.gl r7 = (sensei0.gl) r7
            sensei0.pl r1 = new sensei0.pl
            java.lang.Object r3 = r5.c
            sensei0.a20 r3 = (sensei0.a20) r3
            java.lang.Object r4 = r5.d
            sensei0.t90 r4 = (sensei0.t90) r4
            r1.<init>(r6, r3, r4)
            r0.f = r2
            java.lang.Object r6 = r7.e(r1, r0)
            sensei0.vc r7 = sensei0.vc.a
            if (r6 != r7) goto L4c
            return r7
        L4c:
            sensei0.mg0 r6 = sensei0.mg0.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o4.e(sensei0.il, sensei0.yb):java.lang.Object");
    }

    @Override // sensei0.r80
    public void f(String str, List list, s80 s80Var) {
        w(s80Var).edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu".concat(((pf) this.c).b(list))).apply();
    }

    @Override // sensei0.fr
    public Object g() {
        return null;
    }

    @Override // sensei0.fr
    public ClipDescription getDescription() {
        return (ClipDescription) this.c;
    }

    @Override // sensei0.fr
    public Uri h() {
        return (Uri) this.b;
    }

    @Override // sensei0.r80
    public Map i(List list, s80 s80Var) {
        Object value;
        Map<String, ?> all = w(s80Var).getAll();
        pr.i("getAll(...)", all);
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (u90.b(entry.getKey(), entry.getValue(), list != null ? o9.t0(list) : null) && (value = entry.getValue()) != null) {
                String key = entry.getKey();
                Object objC = u90.c(value, (pf) this.c);
                pr.g("null cannot be cast to non-null type kotlin.Any", objC);
                map.put(key, objC);
            }
        }
        return map;
    }

    @Override // sensei0.r80
    public Long j(String str, s80 s80Var) {
        long j;
        SharedPreferences sharedPreferencesW = w(s80Var);
        if (!sharedPreferencesW.contains(str)) {
            return null;
        }
        try {
            j = sharedPreferencesW.getLong(str, 0L);
        } catch (ClassCastException unused) {
            j = sharedPreferencesW.getInt(str, 0);
        }
        return Long.valueOf(j);
    }

    @Override // sensei0.r80
    public ArrayList k(String str, s80 s80Var) {
        List list;
        SharedPreferences sharedPreferencesW = w(s80Var);
        if (!sharedPreferencesW.contains(str)) {
            return null;
        }
        String string = sharedPreferencesW.getString(str, "");
        pr.f(string);
        if (!nc0.d0(string, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu", false) || nc0.d0(string, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!", false) || (list = (List) u90.c(sharedPreferencesW.getString(str, ""), (pf) this.c)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof String) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // sensei0.r80
    public void l(String str, double d, s80 s80Var) {
        w(s80Var).edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + d).apply();
    }

    @Override // sensei0.fr
    public Uri n() {
        return (Uri) this.d;
    }

    @Override // sensei0.r80
    public void o(List list, s80 s80Var) {
        SharedPreferences sharedPreferencesW = w(s80Var);
        SharedPreferences.Editor editorEdit = sharedPreferencesW.edit();
        pr.i("edit(...)", editorEdit);
        Map<String, ?> all = sharedPreferencesW.getAll();
        pr.i("getAll(...)", all);
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            if (u90.b(str, all.get(str), list != null ? o9.t0(list) : null)) {
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        pr.i("iterator(...)", it);
        while (it.hasNext()) {
            Object next = it.next();
            pr.i("next(...)", next);
            editorEdit.remove((String) next);
        }
        editorEdit.apply();
    }

    @Override // sensei0.r80
    public String p(String str, s80 s80Var) {
        SharedPreferences sharedPreferencesW = w(s80Var);
        if (sharedPreferencesW.contains(str)) {
            return sharedPreferencesW.getString(str, "");
        }
        return null;
    }

    @Override // sensei0.r80
    public Boolean q(String str, s80 s80Var) {
        SharedPreferences sharedPreferencesW = w(s80Var);
        if (sharedPreferencesW.contains(str)) {
            return Boolean.valueOf(sharedPreferencesW.getBoolean(str, true));
        }
        return null;
    }

    @Override // sensei0.r80
    public void r(String str, String str2, s80 s80Var) {
        w(s80Var).edit().putString(str, str2).apply();
    }

    @Override // sensei0.r80
    public void s(String str, String str2, s80 s80Var) {
        w(s80Var).edit().putString(str, str2).apply();
    }

    @Override // sensei0.r80
    public List t(List list, s80 s80Var) {
        Map<String, ?> all = w(s80Var).getAll();
        pr.i("getAll(...)", all);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            pr.i("<get-key>(...)", key);
            if (u90.b(key, entry.getValue(), list != null ? o9.t0(list) : null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return o9.r0(linkedHashMap.keySet());
    }

    public String toString() {
        switch (this.a) {
            case 4:
                return ((k8) this.c).toString() + ", hidden list:" + ((ArrayList) this.d).size();
            default:
                return super.toString();
        }
    }

    @Override // sensei0.y5
    public void u(ByteBuffer byteBuffer, pd pdVar) throws Throwable {
        AtomicReference atomicReference = (AtomicReference) this.c;
        zi ziVar = (zi) this.b;
        aj ajVar = (aj) this.d;
        String str = ajVar.b;
        ux uxVar = ajVar.c;
        String str2 = (String) uxVar.g(byteBuffer).b;
        if (!str2.equals("listen")) {
            if (!str2.equals("cancel")) {
                pdVar.a(null);
                return;
            }
            if (((yi) atomicReference.getAndSet(null)) == null) {
                pdVar.a(uxVar.f("error", "No active stream to cancel", null));
                return;
            }
            try {
                ziVar.onCancel();
                pdVar.a(uxVar.c(null));
                return;
            } catch (RuntimeException e) {
                Log.e("EventChannel#" + str, "Failed to close event stream", e);
                pdVar.a(uxVar.f("error", e.getMessage(), null));
                return;
            }
        }
        yi yiVar = new yi(this);
        if (((yi) atomicReference.getAndSet(yiVar)) != null) {
            try {
                ziVar.onCancel();
            } catch (RuntimeException e2) {
                Log.e("EventChannel#" + str, "Failed to close existing event stream", e2);
            }
        }
        try {
            ziVar.c(yiVar);
            pdVar.a(uxVar.c(null));
        } catch (RuntimeException e3) {
            atomicReference.set(null);
            Log.e("EventChannel#" + str, "Failed to open event stream", e3);
            pdVar.a(uxVar.f("error", e3.getMessage(), null));
        }
    }

    public Boolean v(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        ComponentName componentNameResolveActivity = intent.resolveActivity(((Context) ((x2) this.b).b).getPackageManager());
        return (componentNameResolveActivity == null ? null : componentNameResolveActivity.toShortString()) == null ? Boolean.FALSE : Boolean.valueOf(!"{com.android.fallback/com.android.fallback.Fallback}".equals(r3));
    }

    public SharedPreferences w(s80 s80Var) {
        Context context = (Context) this.d;
        String str = s80Var.a;
        if (str != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            pr.f(sharedPreferences);
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        pr.f(sharedPreferences2);
        return sharedPreferences2;
    }

    public void y(Bundle bundle) {
        HashSet hashSet = (HashSet) this.c;
        String string = ((Context) this.d).getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (ar.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    B((Class) it.next(), hashSet2);
                }
            } catch (ClassNotFoundException e) {
                throw new ia(e);
            }
        }
    }

    public void z(int i, g0 g0Var) {
        ((FlutterJNI) this.c).dispatchSemanticsAction(i, g0Var);
    }

    public /* synthetic */ o4(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public o4(String str, String str2, String str3) {
        this.a = 7;
        this.b = str == null ? "libapp.so" : str;
        this.c = str2 == null ? "flutter_assets" : str2;
        this.d = str3;
    }

    public o4(z30 z30Var) {
        this.a = 4;
        this.b = z30Var;
        this.c = new k8();
        this.d = new ArrayList();
    }

    public o4(Context context, TypedArray typedArray) {
        this.a = 18;
        this.d = context;
        this.b = typedArray;
    }

    public o4(Context context, int i) {
        this.a = i;
        switch (i) {
            case 19:
                x2 x2Var = new x2(11, context);
                this.d = context;
                this.b = x2Var;
                break;
            default:
                this.d = context.getApplicationContext();
                this.c = new HashSet();
                this.b = new HashMap();
                break;
        }
    }

    public o4(ib ibVar) {
        this.a = 3;
        this.b = new ArrayList();
        this.c = new s5();
        this.d = ibVar;
    }

    public o4(mz mzVar) {
        this.a = 2;
        this.b = new s10(30);
        this.c = new ArrayList();
        this.d = new ArrayList();
        new pf(29, this);
    }

    public o4(kd kdVar, FlutterJNI flutterJNI) {
        this.a = 1;
        sv svVar = new sv(1, this);
        j1 j1Var = new j1(kdVar, "flutter/accessibility", rb0.a, null);
        this.b = j1Var;
        j1Var.l(svVar);
        this.c = flutterJNI;
    }

    public o4(zs zsVar) {
        this.a = 11;
        this.c = new HashSet();
        this.d = zsVar;
        nn nnVar = (nn) zsVar;
        this.b = new ys[]{new us(nnVar.getBinaryMessenger()), new i3(new vs(nnVar.getBinaryMessenger()))};
        new ws(nnVar.getBinaryMessenger()).b = this;
    }

    public o4(j1 j1Var, pf pfVar, cf cfVar, Set set) {
        this.a = 5;
        this.b = pfVar;
        this.c = j1Var;
        this.d = cfVar;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            U(str, 0, str.length(), 1, true, new tn(str, 3));
        }
    }

    public o4() {
        this.a = 14;
        this.b = new ConcurrentLinkedQueue();
    }

    public o4(aj ajVar, zi ziVar) {
        this.a = 6;
        this.d = ajVar;
        this.c = new AtomicReference(null);
        this.b = ziVar;
    }

    public o4(a6 a6Var, Context context, pf pfVar) {
        this.a = 15;
        pr.j("messenger", a6Var);
        pr.j("context", context);
        this.b = a6Var;
        this.d = context;
        this.c = pfVar;
        try {
            r80.g.getClass();
            q80.b(a6Var, this, "shared_preferences");
        } catch (Exception e) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesBackend", e);
        }
    }

    public o4(ws wsVar) {
        this.a = 17;
        this.b = wsVar;
        this.c = new ReentrantLock();
        this.d = new WeakHashMap();
    }

    @Override // sensei0.fr
    public void m() {
    }
}
