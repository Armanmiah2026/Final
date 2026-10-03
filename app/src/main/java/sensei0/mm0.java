package sensei0;

import android.R;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mm0 {
    public static final Object[] a = new Object[0];
    public static final String[] b = new String[0];
    public static final int[] c = {R.attr.theme, com.google.android.material.R.attr.theme};
    public static final int[] d = {com.google.android.material.R.attr.materialThemeOverlay};
    public static final mz e = new mz(2);
    public static final tn f = new tn("NONE", 4);
    public static final tn g = new tn("PENDING", 4);
    public static long h;
    public static Method i;
    public static Method j;
    public static Method k;

    public static void F(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static ng G(bs bsVar, boolean z, gs gsVar, int i2) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = (i2 & 2) != 0;
        if (bsVar instanceof ls) {
            return ((ls) bsVar).H(z, z2, gsVar);
        }
        fs fsVar = new fs(1, gsVar, or.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0, 0);
        ls lsVar = (ls) bsVar;
        lsVar.getClass();
        return lsVar.H(z, z2, new nr(fsVar));
    }

    public static boolean I(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static int L(int i2, int i3, float f2) {
        return x9.b(x9.d(i3, Math.round(Color.alpha(i3) * f2)), i2);
    }

    public static o4 M(Context context) {
        String string;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo.metaData;
            String str = hm.a.b;
            String str2 = hm.b.b;
            String string2 = null;
            if (bundle == null) {
                string = null;
            } else {
                string = bundle.getString(str, null);
                if (string == null) {
                    string = bundle.getString(str2);
                }
            }
            Bundle bundle2 = applicationInfo.metaData;
            String str3 = hm.f.b;
            if (bundle2 != null) {
                bundle2.getString(str3, null);
            }
            Bundle bundle3 = applicationInfo.metaData;
            String str4 = hm.g.b;
            if (bundle3 != null) {
                bundle3.getString(str4, null);
            }
            Bundle bundle4 = applicationInfo.metaData;
            String str5 = hm.c.b;
            String str6 = hm.d.b;
            if (bundle4 != null && (string2 = bundle4.getString(str5, null)) == null) {
                string2 = bundle4.getString(str6);
            }
            return new o4(string, string2, applicationInfo.nativeLibraryDir);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Typeface N(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, pr.l(configuration.fontWeightAdjustment + typeface.getWeight(), 1, 1000), typeface.isItalic());
    }

    public static void O(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static void Z(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(sensei0.le0 r4, sensei0.fe r5, java.lang.Throwable r6, sensei0.yb r7) {
        /*
            boolean r0 = r7 instanceof sensei0.kl
            if (r0 == 0) goto L13
            r0 = r7
            sensei0.kl r0 = (sensei0.kl) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            sensei0.kl r0 = new sensei0.kl
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f
            int r1 = r0.h
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            java.lang.Throwable r6 = r0.d
            sensei0.wf0.H(r7)     // Catch: java.lang.Throwable -> L27
            goto L41
        L27:
            r4 = move-exception
            goto L44
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            sensei0.wf0.H(r7)
            r0.d = r6     // Catch: java.lang.Throwable -> L27
            r0.h = r2     // Catch: java.lang.Throwable -> L27
            java.lang.Object r4 = r5.i(r4, r6, r0)     // Catch: java.lang.Throwable -> L27
            sensei0.vc r5 = sensei0.vc.a
            if (r4 != r5) goto L41
            return r5
        L41:
            sensei0.mg0 r4 = sensei0.mg0.a
            return r4
        L44:
            if (r6 == 0) goto L4b
            if (r6 == r4) goto L4b
            sensei0.wf0.a(r4, r6)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.mm0.a(sensei0.le0, sensei0.fe, java.lang.Throwable, sensei0.yb):java.lang.Object");
    }

    public static int a0(Context context, int i2, int i3) {
        TypedValue typedValueX = wf0.x(context, i2);
        return (typedValueX == null || typedValueX.type != 16) ? i3 : typedValueX.data;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0082 -> B:25:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0085 -> B:25:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(java.util.List r6, sensei0.zd r7, sensei0.yb r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof sensei0.td
            if (r0 == 0) goto L13
            r0 = r8
            sensei0.td r0 = (sensei0.td) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.o = r1
            goto L18
        L13:
            sensei0.td r0 = new sensei0.td
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.h
            int r1 = r0.o
            r2 = 2
            r3 = 1
            sensei0.vc r4 = sensei0.vc.a
            if (r1 == 0) goto L42
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.util.Iterator r6 = r0.f
            java.io.Serializable r7 = r0.d
            sensei0.x40 r7 = (sensei0.x40) r7
            sensei0.wf0.H(r8)     // Catch: java.lang.Throwable -> L30
            goto L65
        L30:
            r8 = move-exception
            goto L7e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.io.Serializable r6 = r0.d
            java.util.List r6 = (java.util.List) r6
            sensei0.wf0.H(r8)
            goto L5c
        L42:
            sensei0.wf0.H(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            sensei0.vd r1 = new sensei0.vd
            r5 = 0
            r1.<init>(r6, r8, r5)
            r0.d = r8
            r0.o = r3
            java.lang.Object r6 = r7.a(r1, r0)
            if (r6 != r4) goto L5b
            goto L93
        L5b:
            r6 = r8
        L5c:
            sensei0.x40 r7 = new sensei0.x40
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L65:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L8b
            java.lang.Object r8 = r6.next()
            sensei0.fp r8 = (sensei0.fp) r8
            r0.d = r7     // Catch: java.lang.Throwable -> L30
            r0.f = r6     // Catch: java.lang.Throwable -> L30
            r0.o = r2     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.g(r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r4) goto L65
            goto L93
        L7e:
            java.lang.Object r1 = r7.a
            if (r1 != 0) goto L85
            r7.a = r8
            goto L65
        L85:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            sensei0.wf0.a(r1, r8)
            goto L65
        L8b:
            java.lang.Object r6 = r7.a
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            if (r6 != 0) goto L94
            sensei0.mg0 r4 = sensei0.mg0.a
        L93:
            return r4
        L94:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.mm0.b(java.util.List, sensei0.zd, sensei0.yb):java.lang.Object");
    }

    public static TimeInterpolator b0(Context context, int i2, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!I(strValueOf, "cubic-bezier") && !I(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (I(strValueOf, "cubic-bezier")) {
            String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
            if (strArrSplit.length == 4) {
                return new PathInterpolator(x(0, strArrSplit), x(1, strArrSplit), x(2, strArrSplit), x(3, strArrSplit));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
        }
        if (!I(strValueOf, "path")) {
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String strSubstring = strValueOf.substring(5, strValueOf.length() - 1);
        Path path = new Path();
        try {
            uz.b(k6.n(strSubstring), path);
            return new PathInterpolator(path);
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing ".concat(strSubstring), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:177:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x068f  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x069b  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x06b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06d1 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(sensei0.ib r40, sensei0.eu r41, int r42) {
        /*
            Method dump skipped, instruction units count: 1758
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.mm0.c(sensei0.ib, sensei0.eu, int):void");
    }

    public static void c0(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static void d(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static void d0(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        Field field = ai0.a;
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = zHasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    public static void e0(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i2);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i3);
    }

    public static void f0(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        pr.j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.instance", lxVar, null);
        if (c9Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.i00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    switch (i2) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            long jLongValue = ((Long) obj2).longValue();
                            try {
                                g30 g30Var2 = c9Var2.a;
                                g30Var2.b.a(jLongValue, g30Var2.e);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager", obj3);
                            bm bmVar = (bm) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                            String str = (String) obj4;
                            try {
                                c9Var3.getClass();
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            try {
                                String[] list2 = bmVar.a.list(str);
                                listF02 = k6.G(list2 == null ? new ArrayList() : Arrays.asList(list2));
                                i3Var.s(listF02);
                                return;
                            } catch (IOException e2) {
                                throw new RuntimeException(e2.getMessage());
                            }
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj5 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager", obj5);
                            bm bmVar2 = (bm) obj5;
                            Object obj6 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                            String str2 = (String) obj6;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(((String) ((um) bmVar2.b.b).e.c) + File.separator + str2);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            return;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.list", lxVar, null);
        if (c9Var != null) {
            final int i3 = 1;
            j1Var2.l(new u5() { // from class: sensei0.i00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    switch (i3) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            long jLongValue = ((Long) obj2).longValue();
                            try {
                                g30 g30Var2 = c9Var2.a;
                                g30Var2.b.a(jLongValue, g30Var2.e);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager", obj3);
                            bm bmVar = (bm) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                            String str = (String) obj4;
                            try {
                                c9Var3.getClass();
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            try {
                                String[] list2 = bmVar.a.list(str);
                                listF02 = k6.G(list2 == null ? new ArrayList() : Arrays.asList(list2));
                                i3Var.s(listF02);
                                return;
                            } catch (IOException e2) {
                                throw new RuntimeException(e2.getMessage());
                            }
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj5 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager", obj5);
                            bm bmVar2 = (bm) obj5;
                            Object obj6 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                            String str2 = (String) obj6;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(((String) ((um) bmVar2.b.b).e.c) + File.separator + str2);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            return;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.FlutterAssetManager.getAssetFilePathByName", lxVar, null);
        if (c9Var == null) {
            j1Var3.l(null);
        } else {
            final int i4 = 2;
            j1Var3.l(new u5() { // from class: sensei0.i00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    switch (i4) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            long jLongValue = ((Long) obj2).longValue();
                            try {
                                g30 g30Var2 = c9Var2.a;
                                g30Var2.b.a(jLongValue, g30Var2.e);
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            return;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager", obj3);
                            bm bmVar = (bm) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                            String str = (String) obj4;
                            try {
                                c9Var3.getClass();
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            try {
                                String[] list2 = bmVar.a.list(str);
                                listF02 = k6.G(list2 == null ? new ArrayList() : Arrays.asList(list2));
                                i3Var.s(listF02);
                                return;
                            } catch (IOException e2) {
                                throw new RuntimeException(e2.getMessage());
                            }
                        default:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj5 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.FlutterAssetManager", obj5);
                            bm bmVar2 = (bm) obj5;
                            Object obj6 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                            String str2 = (String) obj6;
                            try {
                                c9Var4.getClass();
                                listF03 = k6.G(((String) ((um) bmVar2.b.b).e.c) + File.separator + str2);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            return;
                    }
                }
            });
        }
    }

    public static void g0(a6 a6Var, final c9 c9Var) {
        g30 g30Var;
        pr.j("binaryMessenger", a6Var);
        dx lxVar = (c9Var == null || (g30Var = c9Var.a) == null) ? new lx(3) : g30Var.a();
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.pigeon_defaultConstructor", lxVar, null);
        if (c9Var != null) {
            final int i2 = 0;
            j1Var.l(new u5() { // from class: sensei0.p00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i2) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), new qj0(c9Var2));
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj3);
                            qj0 qj0Var = (qj0) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj4);
                            boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c9Var3.getClass();
                                qj0Var.c = zBooleanValue;
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj5);
                            qj0 qj0Var2 = (qj0) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj6);
                            boolean zBooleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c9Var4.getClass();
                                qj0Var2.d = zBooleanValue2;
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj7 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj7);
                            qj0 qj0Var3 = (qj0) obj7;
                            Object obj8 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                qj0Var3.e = zBooleanValue3;
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj9 = list4.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj9);
                            qj0 qj0Var4 = (qj0) obj9;
                            Object obj10 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                qj0Var4.f = zBooleanValue4;
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj11);
                            qj0 qj0Var5 = (qj0) obj11;
                            Object obj12 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                qj0Var5.g = zBooleanValue5;
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnShowFileChooser", lxVar, null);
        if (c9Var != null) {
            final int i3 = 1;
            j1Var2.l(new u5() { // from class: sensei0.p00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i3) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), new qj0(c9Var2));
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj3);
                            qj0 qj0Var = (qj0) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj4);
                            boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c9Var3.getClass();
                                qj0Var.c = zBooleanValue;
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj5);
                            qj0 qj0Var2 = (qj0) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj6);
                            boolean zBooleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c9Var4.getClass();
                                qj0Var2.d = zBooleanValue2;
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj7 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj7);
                            qj0 qj0Var3 = (qj0) obj7;
                            Object obj8 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                qj0Var3.e = zBooleanValue3;
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj9 = list4.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj9);
                            qj0 qj0Var4 = (qj0) obj9;
                            Object obj10 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                qj0Var4.f = zBooleanValue4;
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj11);
                            qj0 qj0Var5 = (qj0) obj11;
                            Object obj12 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                qj0Var5.g = zBooleanValue5;
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnConsoleMessage", lxVar, null);
        if (c9Var != null) {
            final int i4 = 2;
            j1Var3.l(new u5() { // from class: sensei0.p00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i4) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), new qj0(c9Var2));
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj3);
                            qj0 qj0Var = (qj0) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj4);
                            boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c9Var3.getClass();
                                qj0Var.c = zBooleanValue;
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj5);
                            qj0 qj0Var2 = (qj0) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj6);
                            boolean zBooleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c9Var4.getClass();
                                qj0Var2.d = zBooleanValue2;
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj7 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj7);
                            qj0 qj0Var3 = (qj0) obj7;
                            Object obj8 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                qj0Var3.e = zBooleanValue3;
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj9 = list4.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj9);
                            qj0 qj0Var4 = (qj0) obj9;
                            Object obj10 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                qj0Var4.f = zBooleanValue4;
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj11);
                            qj0 qj0Var5 = (qj0) obj11;
                            Object obj12 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                qj0Var5.g = zBooleanValue5;
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsAlert", lxVar, null);
        if (c9Var != null) {
            final int i5 = 3;
            j1Var4.l(new u5() { // from class: sensei0.p00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i5) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), new qj0(c9Var2));
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj3);
                            qj0 qj0Var = (qj0) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj4);
                            boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c9Var3.getClass();
                                qj0Var.c = zBooleanValue;
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj5);
                            qj0 qj0Var2 = (qj0) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj6);
                            boolean zBooleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c9Var4.getClass();
                                qj0Var2.d = zBooleanValue2;
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj7 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj7);
                            qj0 qj0Var3 = (qj0) obj7;
                            Object obj8 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                qj0Var3.e = zBooleanValue3;
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj9 = list4.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj9);
                            qj0 qj0Var4 = (qj0) obj9;
                            Object obj10 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                qj0Var4.f = zBooleanValue4;
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj11);
                            qj0 qj0Var5 = (qj0) obj11;
                            Object obj12 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                qj0Var5.g = zBooleanValue5;
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsConfirm", lxVar, null);
        if (c9Var != null) {
            final int i6 = 4;
            j1Var5.l(new u5() { // from class: sensei0.p00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i6) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), new qj0(c9Var2));
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj3);
                            qj0 qj0Var = (qj0) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj4);
                            boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c9Var3.getClass();
                                qj0Var.c = zBooleanValue;
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj5);
                            qj0 qj0Var2 = (qj0) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj6);
                            boolean zBooleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c9Var4.getClass();
                                qj0Var2.d = zBooleanValue2;
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj7 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj7);
                            qj0 qj0Var3 = (qj0) obj7;
                            Object obj8 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                qj0Var3.e = zBooleanValue3;
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj9 = list4.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj9);
                            qj0 qj0Var4 = (qj0) obj9;
                            Object obj10 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                qj0Var4.f = zBooleanValue4;
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj11);
                            qj0 qj0Var5 = (qj0) obj11;
                            Object obj12 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                qj0Var5.g = zBooleanValue5;
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                    }
                }
            });
        } else {
            j1Var5.l(null);
        }
        j1 j1Var6 = new j1(a6Var, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsPrompt", lxVar, null);
        if (c9Var == null) {
            j1Var6.l(null);
        } else {
            final int i7 = 5;
            j1Var6.l(new u5() { // from class: sensei0.p00
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listF0;
                    List listF02;
                    List listF03;
                    List listF04;
                    List listF05;
                    List listF06;
                    switch (i7) {
                        case 0:
                            c9 c9Var2 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            Object obj2 = ((List) obj).get(0);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                            try {
                                c9Var2.a.b.a(((Long) obj2).longValue(), new qj0(c9Var2));
                                listF0 = k6.G(null);
                                break;
                            } catch (Throwable th) {
                                if (th instanceof t2) {
                                    t2 t2Var = th;
                                    listF0 = p9.f0(t2Var.a, t2Var.b, t2Var.c);
                                } else {
                                    listF0 = p9.f0(th.getClass().getSimpleName(), th.toString(), za0.m("Cause: ", th.getCause(), ", Stacktrace: ", Log.getStackTraceString(th)));
                                }
                            }
                            i3Var.s(listF0);
                            break;
                        case 1:
                            c9 c9Var3 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj3);
                            qj0 qj0Var = (qj0) obj3;
                            Object obj4 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj4);
                            boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                            try {
                                c9Var3.getClass();
                                qj0Var.c = zBooleanValue;
                                listF02 = k6.G(null);
                                break;
                            } catch (Throwable th2) {
                                if (th2 instanceof t2) {
                                    t2 t2Var2 = th2;
                                    listF02 = p9.f0(t2Var2.a, t2Var2.b, t2Var2.c);
                                } else {
                                    listF02 = p9.f0(th2.getClass().getSimpleName(), th2.toString(), za0.m("Cause: ", th2.getCause(), ", Stacktrace: ", Log.getStackTraceString(th2)));
                                }
                            }
                            i3Var.s(listF02);
                            break;
                        case 2:
                            c9 c9Var4 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj5);
                            qj0 qj0Var2 = (qj0) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj6);
                            boolean zBooleanValue2 = ((Boolean) obj6).booleanValue();
                            try {
                                c9Var4.getClass();
                                qj0Var2.d = zBooleanValue2;
                                listF03 = k6.G(null);
                                break;
                            } catch (Throwable th3) {
                                if (th3 instanceof t2) {
                                    t2 t2Var3 = th3;
                                    listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                                } else {
                                    listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                                }
                            }
                            i3Var.s(listF03);
                            break;
                        case 3:
                            c9 c9Var5 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list3 = (List) obj;
                            Object obj7 = list3.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj7);
                            qj0 qj0Var3 = (qj0) obj7;
                            Object obj8 = list3.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj8);
                            boolean zBooleanValue3 = ((Boolean) obj8).booleanValue();
                            try {
                                c9Var5.getClass();
                                qj0Var3.e = zBooleanValue3;
                                listF04 = k6.G(null);
                                break;
                            } catch (Throwable th4) {
                                if (th4 instanceof t2) {
                                    t2 t2Var4 = th4;
                                    listF04 = p9.f0(t2Var4.a, t2Var4.b, t2Var4.c);
                                } else {
                                    listF04 = p9.f0(th4.getClass().getSimpleName(), th4.toString(), za0.m("Cause: ", th4.getCause(), ", Stacktrace: ", Log.getStackTraceString(th4)));
                                }
                            }
                            i3Var.s(listF04);
                            break;
                        case 4:
                            c9 c9Var6 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj9 = list4.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj9);
                            qj0 qj0Var4 = (qj0) obj9;
                            Object obj10 = list4.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj10);
                            boolean zBooleanValue4 = ((Boolean) obj10).booleanValue();
                            try {
                                c9Var6.getClass();
                                qj0Var4.f = zBooleanValue4;
                                listF05 = k6.G(null);
                                break;
                            } catch (Throwable th5) {
                                if (th5 instanceof t2) {
                                    t2 t2Var5 = th5;
                                    listF05 = p9.f0(t2Var5.a, t2Var5.b, t2Var5.c);
                                } else {
                                    listF05 = p9.f0(th5.getClass().getSimpleName(), th5.toString(), za0.m("Cause: ", th5.getCause(), ", Stacktrace: ", Log.getStackTraceString(th5)));
                                }
                            }
                            i3Var.s(listF05);
                            break;
                        default:
                            c9 c9Var7 = c9Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj11 = list5.get(0);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl", obj11);
                            qj0 qj0Var5 = (qj0) obj11;
                            Object obj12 = list5.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj12);
                            boolean zBooleanValue5 = ((Boolean) obj12).booleanValue();
                            try {
                                c9Var7.getClass();
                                qj0Var5.g = zBooleanValue5;
                                listF06 = k6.G(null);
                                break;
                            } catch (Throwable th6) {
                                if (th6 instanceof t2) {
                                    t2 t2Var6 = th6;
                                    listF06 = p9.f0(t2Var6.a, t2Var6.b, t2Var6.c);
                                } else {
                                    listF06 = p9.f0(th6.getClass().getSimpleName(), th6.toString(), za0.m("Cause: ", th6.getCause(), ", Stacktrace: ", Log.getStackTraceString(th6)));
                                }
                            }
                            i3Var.s(listF06);
                            break;
                    }
                }
            });
        }
    }

    public static boolean i0(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr.length >= bArr2.length) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i2] == bArr2[i2]) {
                }
            }
            return true;
        }
        return false;
    }

    public static final Object[] j0(Collection collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = 2147483645;
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                        pr.i("copyOf(...)", objArrCopyOf);
                    } else if (!it.hasNext()) {
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i3);
                        pr.i("copyOf(...)", objArrCopyOf2);
                        return objArrCopyOf2;
                    }
                    i2 = i3;
                }
            }
        }
        return a;
    }

    public static final Object[] k0(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        int size = collection.size();
        int i2 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    pr.g("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>", objNewInstance);
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = 2147483645;
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                        pr.i("copyOf(...)", objArrCopyOf);
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf == objArr) {
                            objArr[i3] = null;
                            return objArr;
                        }
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i3);
                        pr.i("copyOf(...)", objArrCopyOf2);
                        return objArrCopyOf2;
                    }
                    i2 = i3;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    public static final void l(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                wf0.a(th, th2);
            }
        }
    }

    public static String l0(String str) {
        return str.length() <= 127 ? str : str.substring(0, 127);
    }

    public static int m(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static int n(p40 p40Var, bd bdVar, View view, View view2, g40 g40Var, boolean z) {
        if (g40Var.p() == 0 || p40Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(g40.x(view) - g40.x(view2)) + 1;
        }
        return Math.min(bdVar.f(), bdVar.b(view2) - bdVar.c(view));
    }

    public static int o(p40 p40Var, bd bdVar, View view, View view2, g40 g40Var, boolean z, boolean z2) {
        if (g40Var.p() == 0 || p40Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (p40Var.a() - Math.max(g40.x(view), g40.x(view2))) - 1) : Math.max(0, Math.min(g40.x(view), g40.x(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(bdVar.b(view2) - bdVar.c(view)) / (Math.abs(g40.x(view) - g40.x(view2)) + 1))) + (bdVar.e() - bdVar.c(view)));
        }
        return iMax;
    }

    public static Context o0(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        boolean z = (context instanceof wb) && ((wb) context).a == resourceId;
        if (resourceId == 0 || z) {
            return context;
        }
        wb wbVar = new wb(context);
        wbVar.a = resourceId;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, c);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            wbVar.getTheme().applyStyle(resourceId2, true);
        }
        return wbVar;
    }

    public static int p(p40 p40Var, bd bdVar, View view, View view2, g40 g40Var, boolean z) {
        if (g40Var.p() == 0 || p40Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return p40Var.a();
        }
        return (int) (((bdVar.b(view2) - bdVar.c(view)) / (Math.abs(g40.x(view) - g40.x(view2)) + 1)) * p40Var.a());
    }

    public static ArrayList p0(Throwable th) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }

    public static ImageView.ScaleType q(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 5 ? i2 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] r(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            jArr[i2] = iArr[i2];
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x029e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void r0(android.content.Context r18, java.util.concurrent.Executor r19, sensei0.u20 r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.mm0.r0(android.content.Context, java.util.concurrent.Executor, sensei0.u20, boolean):void");
    }

    public static int s(Context context, int i2, int i3) {
        Integer numValueOf;
        TypedValue typedValueX = wf0.x(context, i2);
        if (typedValueX != null) {
            int i4 = typedValueX.resourceId;
            numValueOf = Integer.valueOf(i4 != 0 ? context.getColor(i4) : typedValueX.data);
        } else {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i3;
    }

    public static int t(View view, int i2) {
        Context context = view.getContext();
        TypedValue typedValueY = wf0.y(view.getContext(), i2, view.getClass().getCanonicalName());
        int i3 = typedValueY.resourceId;
        return i3 != 0 ? context.getColor(i3) : typedValueY.data;
    }

    public static float x(int i2, String[] strArr) {
        float f2 = Float.parseFloat(strArr[i2]);
        if (f2 >= 0.0f && f2 <= 1.0f) {
            return f2;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f2);
    }

    public abstract int A(View view);

    public abstract int B(CoordinatorLayout coordinatorLayout);

    public abstract int C();

    public int D(View view) {
        return 0;
    }

    public int E() {
        return 0;
    }

    public abstract boolean H(float f2);

    public abstract boolean J(View view);

    public abstract boolean K(float f2, float f3);

    public abstract void P(Throwable th);

    public abstract void Q(int i2);

    public abstract void R(Typeface typeface, boolean z);

    public abstract void S(j1 j1Var);

    public abstract void U(int i2);

    public abstract void V(View view, int i2, int i3);

    public abstract void W(View view, float f2, float f3);

    public abstract void X(v vVar, v vVar2);

    public abstract void Y(v vVar, Thread thread);

    public abstract int e(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float f(int i2);

    public abstract boolean g(w wVar, s sVar);

    public abstract boolean h(w wVar, Object obj, Object obj2);

    public abstract boolean h0(View view, float f2);

    public abstract boolean i(w wVar, v vVar, v vVar2);

    public abstract int j(View view, int i2);

    public abstract int k(View view, int i2);

    public abstract boolean m0(View view, int i2);

    public abstract void n0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3);

    public abstract void q0(int i2, int i3, byte[] bArr);

    public abstract void u(n80 n80Var, float f2, float f3);

    public abstract int v();

    public abstract int w();

    public abstract int y();

    public abstract int z();

    public void T(View view, int i2) {
    }
}
