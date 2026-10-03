package sensei0;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.trilead.ssh2.sftp.ErrorCodes;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ws implements tx, aw, wd, u20, gl {
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ ws(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    private final void j(i3 i3Var, rk rkVar) {
        Object obj;
        i3 i3Var2 = (i3) this.b;
        if (((l10) i3Var2.c) == null) {
            return;
        }
        String str = (String) i3Var.b;
        obj = i3Var.c;
        str.getClass();
        switch (str) {
            case "create":
                Map map = (Map) obj;
                boolean z = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
                ByteBuffer byteBufferWrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
                try {
                    if (((l10) i3Var2.c).v()) {
                        ((l10) i3Var2.c).t(new f10(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), 0, byteBufferWrap));
                        rkVar.d(null);
                        return;
                    }
                    if (z) {
                        ((l10) i3Var2.c).i(new f10(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), 0.0d, 0.0d, 0.0d, 0.0d, ((Integer) map.get("direction")).intValue(), 3, byteBufferWrap));
                        rkVar.d(null);
                        return;
                    }
                    boolean z2 = map.containsKey("hybridFallback") && ((Boolean) map.get("hybridFallback")).booleanValue();
                    long jD = ((l10) i3Var2.c).d(new f10(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d, map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d, ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), z2 ? 2 : 1, byteBufferWrap));
                    if (jD != -2) {
                        rkVar.d(Long.valueOf(jD));
                        return;
                    } else {
                        if (!z2) {
                            throw new AssertionError("Platform view attempted to fall back to hybrid mode when not requested.");
                        }
                        rkVar.d(null);
                        return;
                    }
                } catch (IllegalStateException e) {
                    rkVar.a("error", Log.getStackTraceString(e), null);
                    return;
                }
            case "offset":
                Map map2 = (Map) obj;
                try {
                    ((l10) i3Var2.c).f(((Integer) map2.get("id")).intValue(), ((Double) map2.get("top")).doubleValue(), ((Double) map2.get("left")).doubleValue());
                    rkVar.d(null);
                    return;
                } catch (IllegalStateException e2) {
                    rkVar.a("error", Log.getStackTraceString(e2), null);
                    return;
                }
            case "resize":
                Map map3 = (Map) obj;
                try {
                    ((l10) i3Var2.c).m(new k10(((Integer) map3.get("id")).intValue(), ((Double) map3.get("width")).doubleValue(), ((Double) map3.get("height")).doubleValue()), new x2(10, rkVar));
                    return;
                } catch (IllegalStateException e3) {
                    rkVar.a("error", Log.getStackTraceString(e3), null);
                    return;
                }
            case "clearFocus":
                try {
                    ((l10) i3Var2.c).n(((Integer) obj).intValue());
                    rkVar.d(null);
                    return;
                } catch (IllegalStateException e4) {
                    rkVar.a("error", Log.getStackTraceString(e4), null);
                    return;
                }
            case "synchronizeToNativeViewHierarchy":
                try {
                    ((l10) i3Var2.c).b(((Boolean) obj).booleanValue());
                    rkVar.d(null);
                    return;
                } catch (IllegalStateException e5) {
                    rkVar.a("error", Log.getStackTraceString(e5), null);
                    return;
                }
            case "touch":
                List list = (List) obj;
                try {
                    ((l10) i3Var2.c).p(new h10(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                    rkVar.d(null);
                    return;
                } catch (IllegalStateException e6) {
                    rkVar.a("error", Log.getStackTraceString(e6), null);
                    return;
                }
            case "setDirection":
                Map map4 = (Map) obj;
                try {
                    ((l10) i3Var2.c).g(((Integer) map4.get("id")).intValue(), ((Integer) map4.get("direction")).intValue());
                    rkVar.d(null);
                    return;
                } catch (IllegalStateException e7) {
                    rkVar.a("error", Log.getStackTraceString(e7), null);
                    return;
                }
            case "dispose":
                try {
                    ((l10) i3Var2.c).r(((Integer) ((Map) obj).get("id")).intValue());
                    rkVar.d(null);
                    return;
                } catch (IllegalStateException e8) {
                    rkVar.a("error", Log.getStackTraceString(e8), null);
                    return;
                }
            default:
                rkVar.b();
                return;
        }
    }

    private final void k(i3 i3Var, rk rkVar) {
        i3 i3Var2 = (i3) this.b;
        if (((p20) i3Var2.c) == null) {
            return;
        }
        String str = (String) i3Var.b;
        Object obj = i3Var.c;
        str.getClass();
        if (!str.equals("ProcessText.processTextAction")) {
            if (!str.equals("ProcessText.queryTextActions")) {
                rkVar.b();
                return;
            }
            try {
                rkVar.d(((p20) i3Var2.c).i());
                return;
            } catch (IllegalStateException e) {
                rkVar.a("error", e.getMessage(), null);
                return;
            }
        }
        try {
            ArrayList arrayList = (ArrayList) obj;
            ((p20) i3Var2.c).h((String) arrayList.get(0), (String) arrayList.get(1), ((Boolean) arrayList.get(2)).booleanValue(), rkVar);
        } catch (IllegalStateException e2) {
            rkVar.a("error", e2.getMessage(), null);
        }
    }

    private final void m(i3 i3Var, rk rkVar) {
        boolean z;
        ws wsVar = (ws) this.b;
        if (((i3) wsVar.b) == null) {
            return;
        }
        String str = (String) i3Var.b;
        str.getClass();
        z = true;
        switch (str) {
            case "Scribe.isFeatureAvailable":
                try {
                    i3 i3Var2 = (i3) wsVar.b;
                    if (Build.VERSION.SDK_INT >= 34) {
                        if (((InputMethodManager) i3Var2.b).isStylusHandwritingAvailable()) {
                        }
                        rkVar.d(Boolean.valueOf(z));
                        break;
                    } else {
                        i3Var2.getClass();
                    }
                    z = false;
                    rkVar.d(Boolean.valueOf(z));
                    break;
                } catch (IllegalStateException e) {
                    rkVar.a("error", e.getMessage(), null);
                    return;
                }
                break;
            case "Scribe.startStylusHandwriting":
                if (Build.VERSION.SDK_INT >= 33) {
                    try {
                        i3 i3Var3 = (i3) wsVar.b;
                        ((InputMethodManager) i3Var3.b).startStylusHandwriting((View) i3Var3.c);
                        rkVar.d(null);
                    } catch (IllegalStateException e2) {
                        rkVar.a("error", e2.getMessage(), null);
                        return;
                    }
                    break;
                } else {
                    rkVar.a("error", "Requires API level 33 or higher.", null);
                    break;
                }
                break;
            case "Scribe.isStylusHandwritingAvailable":
                if (Build.VERSION.SDK_INT >= 34) {
                    try {
                        rkVar.d(Boolean.valueOf(((InputMethodManager) ((i3) wsVar.b).b).isStylusHandwritingAvailable()));
                    } catch (IllegalStateException e3) {
                        rkVar.a("error", e3.getMessage(), null);
                        return;
                    }
                    break;
                } else {
                    rkVar.a("error", "Requires API level 34 or higher.", null);
                    break;
                }
                break;
            default:
                rkVar.b();
                break;
        }
    }

    private final void n(i3 i3Var, rk rkVar) {
        int i;
        ws wsVar = (ws) this.b;
        if (((u3) wsVar.b) == null) {
            return;
        }
        String str = (String) i3Var.b;
        str.getClass();
        i = 2;
        switch (str) {
            case "SensitiveContent.getContentSensitivity":
                try {
                    int iB = ((u3) wsVar.b).b();
                    if (iB == 0) {
                        i = 0;
                    } else if (iB == 1) {
                        i = 1;
                    } else if (iB != 2) {
                        i = 3;
                    }
                    rkVar.d(Integer.valueOf(i));
                    return;
                } catch (IllegalArgumentException | IllegalStateException e) {
                    rkVar.a("error", e.getMessage(), null);
                    return;
                }
            case "SensitiveContent.setContentSensitivity":
                int iIntValue = ((Integer) i3Var.c).intValue();
                try {
                    u3 u3Var = (u3) wsVar.b;
                    if (iIntValue == 0) {
                        i = 0;
                    } else if (iIntValue == 1) {
                        i = 1;
                    } else if (iIntValue != 2) {
                        throw new IllegalArgumentException(za0.i(iIntValue, "contentSensitivityIndex ", " not known to the SensitiveContentChannel."));
                    }
                    u3Var.d(i);
                    return;
                } catch (IllegalArgumentException | IllegalStateException e2) {
                    rkVar.a("error", e2.getMessage(), null);
                    return;
                }
            case "SensitiveContent.isSupported":
                ((u3) wsVar.b).getClass();
                rkVar.d(Boolean.valueOf(Build.VERSION.SDK_INT >= 35));
                return;
            default:
                rkVar.b();
                return;
        }
    }

    @Override // sensei0.wd
    public Object a(jp jpVar, yb ybVar) {
        return ((wd) this.b).a(new x10(jpVar, null, 0), ybVar);
    }

    @Override // sensei0.u20
    public void b() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // sensei0.u20
    public void c(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.b).setResultCode(i);
    }

    public void d(String str) {
        ay ayVar = (ay) ((i3) this.b).b;
        if (i3.f == null) {
            fm fmVar = new fm();
            fmVar.put("alias", 1010);
            fmVar.put("allScroll", 1013);
            fmVar.put("basic", 1000);
            fmVar.put("cell", 1006);
            fmVar.put("click", 1002);
            fmVar.put("contextMenu", 1001);
            fmVar.put("copy", 1011);
            fmVar.put("forbidden", 1012);
            fmVar.put("grab", 1020);
            fmVar.put("grabbing", 1021);
            fmVar.put("help", 1003);
            fmVar.put("move", 1013);
            fmVar.put("none", 0);
            fmVar.put("noDrop", 1012);
            fmVar.put("precise", 1007);
            fmVar.put("text", 1008);
            fmVar.put("resizeColumn", 1014);
            fmVar.put("resizeDown", 1015);
            fmVar.put("resizeUpLeft", 1016);
            fmVar.put("resizeDownRight", 1017);
            fmVar.put("resizeLeft", 1014);
            fmVar.put("resizeLeftRight", 1014);
            fmVar.put("resizeRight", 1014);
            fmVar.put("resizeRow", 1015);
            fmVar.put("resizeUp", 1015);
            fmVar.put("resizeUpDown", 1015);
            fmVar.put("resizeUpLeft", 1017);
            fmVar.put("resizeUpRight", 1016);
            fmVar.put("resizeUpLeftDownRight", 1017);
            fmVar.put("resizeUpRightDownLeft", 1016);
            fmVar.put("verticalText", 1009);
            fmVar.put("wait", 1004);
            fmVar.put("zoomIn", 1018);
            fmVar.put("zoomOut", 1019);
            i3.f = fmVar;
        }
        ayVar.setPointerIcon(PointerIcon.getSystemIcon(((nn) ayVar).getContext(), ((Integer) i3.f.getOrDefault(str, 1000)).intValue()));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Type inference failed for: r6v4, types: [sensei0.bd0, sensei0.jp] */
    @Override // sensei0.gl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(sensei0.il r6, sensei0.yb r7) throws java.lang.Throwable {
        /*
            r5 = this;
            int r0 = r5.a
            switch(r0) {
                case 22: goto L4d;
                default: goto L5;
            }
        L5:
            boolean r0 = r7 instanceof sensei0.k90
            if (r0 == 0) goto L18
            r0 = r7
            sensei0.k90 r0 = (sensei0.k90) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L18
            int r1 = r1 - r2
            r0.f = r1
            goto L1d
        L18:
            sensei0.k90 r0 = new sensei0.k90
            r0.<init>(r5, r7)
        L1d:
            java.lang.Object r7 = r0.d
            int r1 = r0.f
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            sensei0.wf0.H(r7)
            goto L4a
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            sensei0.wf0.H(r7)
            java.lang.Object r7 = r5.b
            sensei0.gl r7 = (sensei0.gl) r7
            sensei0.he r1 = new sensei0.he
            r3 = 1
            r1.<init>(r6, r3)
            r0.f = r2
            java.lang.Object r6 = r7.e(r1, r0)
            sensei0.vc r7 = sensei0.vc.a
            if (r6 != r7) goto L4a
            goto L4c
        L4a:
            sensei0.mg0 r7 = sensei0.mg0.a
        L4c:
            return r7
        L4d:
            boolean r0 = r7 instanceof sensei0.i
            if (r0 == 0) goto L60
            r0 = r7
            sensei0.i r0 = (sensei0.i) r0
            int r1 = r0.o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L60
            int r1 = r1 - r2
            r0.o = r1
            goto L65
        L60:
            sensei0.i r0 = new sensei0.i
            r0.<init>(r5, r7)
        L65:
            java.lang.Object r7 = r0.f
            int r1 = r0.o
            sensei0.mg0 r2 = sensei0.mg0.a
            r3 = 1
            if (r1 == 0) goto L80
            if (r1 != r3) goto L78
            sensei0.c60 r6 = r0.d
            sensei0.wf0.H(r7)     // Catch: java.lang.Throwable -> L76
            goto La4
        L76:
            r7 = move-exception
            goto Lae
        L78:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L80:
            sensei0.wf0.H(r7)
            sensei0.c60 r7 = new sensei0.c60
            sensei0.lc r1 = r0.b
            sensei0.pr.f(r1)
            r7.<init>(r6, r1)
            r0.d = r7     // Catch: java.lang.Throwable -> Lac
            r0.o = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r6 = r5.b     // Catch: java.lang.Throwable -> Lac
            sensei0.bd0 r6 = (sensei0.bd0) r6     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r6 = r6.c(r7, r0)     // Catch: java.lang.Throwable -> Lac
            sensei0.vc r0 = sensei0.vc.a
            if (r6 != r0) goto L9e
            goto L9f
        L9e:
            r6 = r2
        L9f:
            if (r6 != r0) goto La3
            r2 = r0
            goto La7
        La3:
            r6 = r7
        La4:
            r6.o()
        La7:
            return r2
        La8:
            r4 = r7
            r7 = r6
            r6 = r4
            goto Lae
        Lac:
            r6 = move-exception
            goto La8
        Lae:
            r6.o()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.ws.e(sensei0.il, sensei0.yb):java.lang.Object");
    }

    public void f(int i) {
        e10 e10Var = (e10) ((q10) this.b).q.get(i);
        if (e10Var == null) {
            Log.e("PlatformViewsController2", "Clearing focus on an unknown view with id: " + i);
            return;
        }
        View view = e10Var.getView();
        if (view != null) {
            view.clearFocus();
            return;
        }
        Log.e("PlatformViewsController2", "Clearing focus on a null view with id: " + i);
    }

    public void g(int i) {
        q10 q10Var = (q10) this.b;
        SparseArray sparseArray = q10Var.r;
        q10Var.x.remove(Integer.valueOf(i));
        SparseArray sparseArray2 = q10Var.q;
        e10 e10Var = (e10) sparseArray2.get(i);
        if (e10Var == null) {
            Log.e("PlatformViewsController2", "Disposing unknown platform view with id: " + i);
            return;
        }
        if (e10Var.getView() != null) {
            View view = e10Var.getView();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        sparseArray2.remove(i);
        wm wmVar = (wm) sparseArray.get(i);
        if (wmVar != null) {
            wmVar.removeAllViews();
            wmVar.a();
            ViewGroup viewGroup2 = (ViewGroup) wmVar.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(wmVar);
            }
            sparseArray.remove(i);
        }
    }

    @Override // sensei0.wd
    public gl getData() {
        return ((wd) this.b).getData();
    }

    public CharSequence h(u00 u00Var) {
        Activity activity = ((b10) this.b).a;
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
        CharSequence charSequence = null;
        if (clipboardManager.hasPrimaryClip()) {
            try {
                try {
                    ClipData primaryClip = clipboardManager.getPrimaryClip();
                    if (primaryClip != null) {
                        if (u00Var != null) {
                            if (u00Var == u00.a) {
                            }
                        }
                        ClipData.Item itemAt = primaryClip.getItemAt(0);
                        CharSequence text = itemAt.getText();
                        if (text != null) {
                            return text;
                        }
                        try {
                            Uri uri = itemAt.getUri();
                            if (uri == null) {
                                Log.w("PlatformPlugin", "Clipboard item contained no textual content nor a URI to retrieve it from.");
                                return null;
                            }
                            String scheme = uri.getScheme();
                            if (!scheme.equals("content")) {
                                Log.w("PlatformPlugin", "Clipboard item contains a Uri with scheme '" + scheme + "'that is unhandled.");
                                return null;
                            }
                            AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = activity.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
                            CharSequence charSequenceCoerceToText = itemAt.coerceToText(activity);
                            if (assetFileDescriptorOpenTypedAssetFileDescriptor == null) {
                                return charSequenceCoerceToText;
                            }
                            try {
                                assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                                return charSequenceCoerceToText;
                            } catch (IOException e) {
                                charSequence = charSequenceCoerceToText;
                                e = e;
                                Log.w("PlatformPlugin", "Failed to close AssetFileDescriptor while trying to read text from URI.", e);
                                return charSequence;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            charSequence = text;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (FileNotFoundException unused) {
                Log.w("PlatformPlugin", "Clipboard text was unable to be received from content URI.");
                return charSequence;
            } catch (SecurityException e4) {
                Log.w("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e4);
                return charSequence;
            }
        }
        return null;
    }

    public String i(String str, String str2) {
        vu vuVar = (vu) this.b;
        Context contextCreateConfigurationContext = vuVar.b;
        if (str2 != null) {
            Locale localeA = vu.a(str2);
            Configuration configuration = new Configuration(vuVar.b.getResources().getConfiguration());
            configuration.setLocale(localeA);
            contextCreateConfigurationContext = vuVar.b.createConfigurationContext(configuration);
        }
        int identifier = contextCreateConfigurationContext.getResources().getIdentifier(str, "string", vuVar.b.getPackageName());
        if (identifier != 0) {
            return contextCreateConfigurationContext.getResources().getString(identifier);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // sensei0.tx
    public void l(i3 i3Var, rk rkVar) {
        ClipDescription primaryClipDescription;
        u00 u00VarA;
        Object obj;
        switch (this.a) {
            case 2:
                i3 i3Var2 = (i3) this.b;
                if (((ws) i3Var2.c) == null) {
                    return;
                }
                String str = (String) i3Var.b;
                str.getClass();
                if (!str.equals("Localization.getStringResource")) {
                    rkVar.b();
                    return;
                }
                JSONObject jSONObject = (JSONObject) i3Var.c;
                try {
                    rkVar.d(((ws) i3Var2.c).i(jSONObject.getString("key"), jSONObject.has("locale") ? jSONObject.getString("locale") : null));
                    return;
                } catch (JSONException e) {
                    rkVar.a("error", e.getMessage(), null);
                    return;
                }
            case 8:
                ws wsVar = (ws) this.b;
                if (((ws) wsVar.b) == null) {
                    return;
                }
                String str2 = (String) i3Var.b;
                try {
                    if (str2.hashCode() == -1307105544 && str2.equals("activateSystemCursor")) {
                        try {
                            ((ws) wsVar.b).d((String) ((HashMap) i3Var.c).get("kind"));
                            rkVar.d(Boolean.TRUE);
                        } catch (Exception e2) {
                            rkVar.a("error", "Error when setting cursors: " + e2.getMessage(), null);
                        }
                    }
                    return;
                } catch (Exception e3) {
                    rkVar.a("error", "Unhandled error: " + e3.getMessage(), null);
                    return;
                }
            case 12:
                i3 i3Var3 = (i3) this.b;
                if (((ws) i3Var3.c) == null) {
                    return;
                }
                String str3 = (String) i3Var.b;
                Object obj2 = i3Var.c;
                try {
                    switch (str3.hashCode()) {
                        case -1501580720:
                            if (str3.equals("SystemNavigator.setFrameworkHandlesBack")) {
                                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                                yl ylVar = ((b10) ((ws) i3Var3.c).b).c;
                                if (ylVar != null) {
                                    ((vl) ylVar).i(zBooleanValue);
                                }
                                rkVar.d(null);
                                return;
                            }
                            rkVar.b();
                            return;
                        case -931781241:
                            if (str3.equals("Share.invoke")) {
                                b10 b10Var = (b10) ((ws) i3Var3.c).b;
                                Intent intent = new Intent();
                                intent.setAction("android.intent.action.SEND");
                                intent.setType("text/plain");
                                intent.putExtra("android.intent.extra.TEXT", (String) obj2);
                                b10Var.a.startActivity(Intent.createChooser(intent, null));
                                rkVar.d(null);
                                return;
                            }
                            rkVar.b();
                            return;
                        case -766342101:
                            if (str3.equals("SystemNavigator.pop")) {
                                Activity activity = ((b10) ((ws) i3Var3.c).b).a;
                                if (activity instanceof xy) {
                                    ((ja) ((xy) activity)).getClass();
                                    throw null;
                                }
                                activity.finish();
                                rkVar.d(null);
                                return;
                            }
                            rkVar.b();
                            return;
                        case -720677196:
                            if (str3.equals("Clipboard.setData")) {
                                ((ClipboardManager) ((b10) ((ws) i3Var3.c).b).a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", ((JSONObject) obj2).getString("text")));
                                rkVar.d(null);
                                return;
                            }
                            rkVar.b();
                            return;
                        case -577225884:
                            if (str3.equals("SystemChrome.setSystemUIChangeListener")) {
                                b10 b10Var2 = (b10) ((ws) i3Var3.c).b;
                                View decorView = b10Var2.a.getWindow().getDecorView();
                                decorView.setOnSystemUiVisibilityChangeListener(new a10(b10Var2, decorView));
                                rkVar.d(null);
                                return;
                            }
                            rkVar.b();
                            return;
                        case -548468504:
                            if (str3.equals("SystemChrome.setApplicationSwitcherDescription")) {
                                try {
                                    JSONObject jSONObject2 = (JSONObject) obj2;
                                    int i = jSONObject2.getInt("primaryColor");
                                    if (i != 0) {
                                        i |= -16777216;
                                    }
                                    String string = jSONObject2.getString("label");
                                    Activity activity2 = ((b10) ((ws) i3Var3.c).b).a;
                                    if (Build.VERSION.SDK_INT < 28) {
                                        activity2.setTaskDescription(new ActivityManager.TaskDescription(string, (Bitmap) null, i));
                                    } else {
                                        activity2.setTaskDescription(z.c(i, string));
                                    }
                                    rkVar.d(null);
                                    return;
                                } catch (JSONException e4) {
                                    rkVar.a("error", e4.getMessage(), null);
                                    return;
                                }
                            }
                            rkVar.b();
                            return;
                        case -247230243:
                            if (str3.equals("HapticFeedback.vibrate")) {
                                try {
                                    ((ws) i3Var3.c).s(za0.b((String) obj2));
                                    rkVar.d(null);
                                    return;
                                } catch (NoSuchFieldException e5) {
                                    rkVar.a("error", e5.getMessage(), null);
                                    return;
                                }
                            }
                            rkVar.b();
                            return;
                        case -215273374:
                            if (str3.equals("SystemSound.play")) {
                                try {
                                    int iC = za0.c((String) obj2);
                                    b10 b10Var3 = (b10) ((ws) i3Var3.c).b;
                                    if (iC == 1) {
                                        b10Var3.a.getWindow().getDecorView().playSoundEffect(0);
                                    }
                                    rkVar.d(null);
                                    return;
                                } catch (NoSuchFieldException e6) {
                                    rkVar.a("error", e6.getMessage(), null);
                                    return;
                                }
                            }
                            rkVar.b();
                            return;
                        case 241845679:
                            if (str3.equals("SystemChrome.restoreSystemUIOverlays")) {
                                ((b10) ((ws) i3Var3.c).b).b();
                                rkVar.d(null);
                                return;
                            }
                            rkVar.b();
                            return;
                        case 875995648:
                            if (str3.equals("Clipboard.hasStrings")) {
                                ClipboardManager clipboardManager = (ClipboardManager) ((b10) ((ws) i3Var3.c).b).a.getSystemService("clipboard");
                                if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
                                    zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("value", zHasMimeType);
                                rkVar.d(jSONObject3);
                                return;
                            }
                            rkVar.b();
                            return;
                        case 1128339786:
                            if (str3.equals("SystemChrome.setEnabledSystemUIMode")) {
                                try {
                                    ((ws) i3Var3.c).r(i3.y(i3Var3, (String) obj2));
                                    rkVar.d(null);
                                    return;
                                } catch (NoSuchFieldException | JSONException e7) {
                                    rkVar.a("error", e7.getMessage(), null);
                                    return;
                                }
                            }
                            rkVar.b();
                            return;
                        case 1390477857:
                            if (str3.equals("SystemChrome.setSystemUIOverlayStyle")) {
                                try {
                                    ((b10) ((ws) i3Var3.c).b).a(i3.z(i3Var3, (JSONObject) obj2));
                                    rkVar.d(null);
                                    return;
                                } catch (NoSuchFieldException | JSONException e8) {
                                    rkVar.a("error", e8.getMessage(), null);
                                    return;
                                }
                            }
                            rkVar.b();
                            return;
                        case 1514180520:
                            if (str3.equals("Clipboard.getData")) {
                                String str4 = (String) obj2;
                                if (str4 != null) {
                                    try {
                                        u00VarA = u00.a(str4);
                                    } catch (NoSuchFieldException unused) {
                                        rkVar.a("error", "No such clipboard content format: ".concat(str4), null);
                                        u00VarA = null;
                                    }
                                    break;
                                } else {
                                    u00VarA = null;
                                }
                                CharSequence charSequenceH = ((ws) i3Var3.c).h(u00VarA);
                                if (charSequenceH == null) {
                                    rkVar.d(null);
                                    return;
                                }
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("text", charSequenceH);
                                rkVar.d(jSONObject4);
                                return;
                            }
                            rkVar.b();
                            return;
                        case 1674312266:
                            if (str3.equals("SystemChrome.setEnabledSystemUIOverlays")) {
                                try {
                                    ((ws) i3Var3.c).q(i3.x(i3Var3, (JSONArray) obj2));
                                    rkVar.d(null);
                                    return;
                                } catch (NoSuchFieldException | JSONException e9) {
                                    rkVar.a("error", e9.getMessage(), null);
                                    return;
                                }
                            }
                            rkVar.b();
                            return;
                        case 2119655719:
                            if (str3.equals("SystemChrome.setPreferredOrientations")) {
                                try {
                                    ((b10) ((ws) i3Var3.c).b).a.setRequestedOrientation(i3.w(i3Var3, (JSONArray) obj2));
                                    rkVar.d(null);
                                    return;
                                } catch (NoSuchFieldException | JSONException e10) {
                                    rkVar.a("error", e10.getMessage(), null);
                                    return;
                                }
                            }
                            rkVar.b();
                            return;
                        default:
                            rkVar.b();
                            return;
                    }
                } catch (JSONException e11) {
                    rkVar.a("error", "JSON error: " + e11.getMessage(), null);
                    return;
                }
            case 14:
                j(i3Var, rkVar);
                return;
            case 15:
                i3 i3Var4 = (i3) this.b;
                if (((ws) i3Var4.c) == null) {
                    return;
                }
                String str5 = (String) i3Var.b;
                obj = i3Var.c;
                str5.getClass();
                switch (str5) {
                    case "create":
                        Map map = (Map) obj;
                        ByteBuffer byteBufferWrap = map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null;
                        try {
                            int iIntValue = ((Integer) map.get("id")).intValue();
                            String str6 = (String) map.get("viewType");
                            int iIntValue2 = ((Integer) map.get("direction")).intValue();
                            q10 q10Var = (q10) ((ws) i3Var4.c).b;
                            rn rnVar = (rn) q10Var.a.a.get(str6);
                            if (rnVar == null) {
                                throw new IllegalStateException("Trying to create a platform view of unregistered type: " + str6);
                            }
                            e10 e10VarA = rnVar.a(byteBufferWrap != null ? rnVar.a.b(byteBufferWrap) : null);
                            View view = e10VarA.getView();
                            if (view == null) {
                                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
                            }
                            view.setLayoutDirection(iIntValue2);
                            q10Var.q.put(iIntValue, e10VarA);
                            rkVar.d(null);
                            return;
                        } catch (IllegalStateException e12) {
                            rkVar.a("error", Log.getStackTraceString(e12), null);
                            return;
                        }
                    case "clearFocus":
                        try {
                            ((ws) i3Var4.c).f(((Integer) obj).intValue());
                            rkVar.d(null);
                            return;
                        } catch (IllegalStateException e13) {
                            rkVar.a("error", Log.getStackTraceString(e13), null);
                            return;
                        }
                    case "touch":
                        List list = (List) obj;
                        try {
                            ((ws) i3Var4.c).o(new h10(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                            rkVar.d(null);
                            return;
                        } catch (IllegalStateException e14) {
                            rkVar.a("error", Log.getStackTraceString(e14), null);
                            return;
                        }
                    case "setDirection":
                        Map map2 = (Map) obj;
                        try {
                            ((ws) i3Var4.c).p(((Integer) map2.get("id")).intValue(), ((Integer) map2.get("direction")).intValue());
                            rkVar.d(null);
                            return;
                        } catch (IllegalStateException e15) {
                            rkVar.a("error", Log.getStackTraceString(e15), null);
                            return;
                        }
                    case "isSurfaceControlEnabled":
                        FlutterJNI flutterJNI = ((q10) ((ws) i3Var4.c).b).f;
                        rkVar.d(Boolean.valueOf(flutterJNI != null ? flutterJNI.IsSurfaceControlEnabled() : false));
                        return;
                    case "dispose":
                        try {
                            ((ws) i3Var4.c).g(((Integer) ((Map) obj).get("id")).intValue());
                            rkVar.d(null);
                            return;
                        } catch (IllegalStateException e16) {
                            rkVar.a("error", Log.getStackTraceString(e16), null);
                            return;
                        }
                    default:
                        rkVar.b();
                        return;
                }
            case 19:
                k(i3Var, rkVar);
                return;
            case 21:
                n3 n3Var = (n3) this.b;
                String str7 = (String) i3Var.b;
                Object obj3 = i3Var.c;
                str7.getClass();
                if (!str7.equals("get")) {
                    if (!str7.equals("put")) {
                        rkVar.b();
                        return;
                    } else {
                        n3Var.d = (byte[]) obj3;
                        rkVar.d(null);
                        return;
                    }
                }
                n3Var.c = true;
                if (n3Var.b || !n3Var.a) {
                    rkVar.d(n3.b((byte[]) n3Var.d));
                    return;
                } else {
                    n3Var.f = rkVar;
                    return;
                }
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                m(i3Var, rkVar);
                return;
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                n(i3Var, rkVar);
                return;
            default:
                fb0 fb0Var = (fb0) this.b;
                if (((gb0) fb0Var.a) == null) {
                    return;
                }
                String str8 = (String) i3Var.b;
                Object obj4 = i3Var.c;
                str8.getClass();
                if (!str8.equals("SpellCheck.initiateSpellCheck")) {
                    rkVar.b();
                    return;
                }
                try {
                    ArrayList arrayList = (ArrayList) obj4;
                    ((gb0) fb0Var.a).a((String) arrayList.get(0), (String) arrayList.get(1), rkVar);
                    return;
                } catch (IllegalStateException e17) {
                    rkVar.a("error", e17.getMessage(), null);
                    return;
                }
        }
    }

    public void o(h10 h10Var) {
        int i = h10Var.a;
        q10 q10Var = (q10) this.b;
        float f = q10Var.c.getResources().getDisplayMetrics().density;
        e10 e10Var = (e10) q10Var.q.get(i);
        if (e10Var == null) {
            Log.e("PlatformViewsController2", "Sending touch to an unknown view with id: " + i);
            return;
        }
        View view = e10Var.getView();
        if (view == null) {
            Log.e("PlatformViewsController2", "Sending touch to a null view with id: " + i);
            return;
        }
        long j = h10Var.p;
        int i2 = h10Var.e;
        MotionEvent motionEventI = q10Var.s.I(new xx(j));
        List<List> list = (List) h10Var.g;
        ArrayList arrayList = new ArrayList();
        for (List list2 : list) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = (float) ((Double) list2.get(0)).doubleValue();
            pointerCoords.pressure = (float) ((Double) list2.get(1)).doubleValue();
            pointerCoords.size = (float) ((Double) list2.get(2)).doubleValue();
            double d = f;
            pointerCoords.toolMajor = (float) (((Double) list2.get(3)).doubleValue() * d);
            pointerCoords.toolMinor = (float) (((Double) list2.get(4)).doubleValue() * d);
            pointerCoords.touchMajor = (float) (((Double) list2.get(5)).doubleValue() * d);
            pointerCoords.touchMinor = (float) (((Double) list2.get(6)).doubleValue() * d);
            pointerCoords.x = (float) (((Double) list2.get(7)).doubleValue() * d);
            pointerCoords.y = (float) (((Double) list2.get(8)).doubleValue() * d);
            arrayList.add(pointerCoords);
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) arrayList.toArray(new MotionEvent.PointerCoords[i2]);
        if (motionEventI == null) {
            List<List> list3 = (List) h10Var.f;
            ArrayList arrayList2 = new ArrayList();
            for (List list4 : list3) {
                MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                pointerProperties.id = ((Integer) list4.get(0)).intValue();
                pointerProperties.toolType = ((Integer) list4.get(1)).intValue();
                arrayList2.add(pointerProperties);
            }
            motionEventI = MotionEvent.obtain(h10Var.b.longValue(), h10Var.c.longValue(), h10Var.d, h10Var.e, (MotionEvent.PointerProperties[]) arrayList2.toArray(new MotionEvent.PointerProperties[i2]), pointerCoordsArr, h10Var.h, h10Var.i, h10Var.j, h10Var.k, h10Var.l, h10Var.m, h10Var.n, h10Var.o);
        } else if (pointerCoordsArr.length >= 1) {
            motionEventI.offsetLocation(pointerCoordsArr[0].x - motionEventI.getX(), pointerCoordsArr[0].y - motionEventI.getY());
        }
        view.dispatchTouchEvent(motionEventI);
    }

    public void p(int i, int i2) {
        e10 e10Var = (e10) ((q10) this.b).q.get(i);
        if (e10Var == null) {
            Log.e("PlatformViewsController2", "Setting direction to an unknown view with id: " + i);
            return;
        }
        View view = e10Var.getView();
        if (view != null) {
            view.setLayoutDirection(i2);
            return;
        }
        Log.e("PlatformViewsController2", "Setting direction to a null view with id: " + i);
    }

    public void q(ArrayList arrayList) {
        b10 b10Var = (b10) this.b;
        if (b10Var.f) {
            b10Var.f = false;
            qi0.c(b10Var.a.getWindow(), true);
        }
        int i = arrayList.isEmpty() ? 5894 : 1798;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int iOrdinal = ((w00) arrayList.get(i2)).ordinal();
            if (iOrdinal == 0) {
                i &= -5;
            } else if (iOrdinal == 1) {
                i &= -515;
            }
        }
        b10Var.e = i;
        b10Var.b();
    }

    public void r(int i) {
        int i2;
        b10 b10Var = (b10) this.b;
        Activity activity = b10Var.a;
        if (i != 4 && b10Var.f) {
            b10Var.f = false;
            qi0.c(activity.getWindow(), true);
        }
        if (i == 1) {
            i2 = 1798;
        } else if (i == 2) {
            i2 = 3846;
        } else {
            if (i != 3) {
                if (i != 4 || Build.VERSION.SDK_INT < 29) {
                    return;
                }
                b10Var.f = true;
                activity.getWindow().getDecorView().setSystemUiVisibility(0);
                qi0.c(activity.getWindow(), false);
                v00 v00Var = b10Var.d;
                if (v00Var != null) {
                    b10Var.a(v00Var);
                    return;
                }
                return;
            }
            i2 = 5894;
        }
        b10Var.e = i2;
        b10Var.b();
    }

    public void s(int i) {
        View decorView = ((b10) this.b).a.getWindow().getDecorView();
        switch (za0.u(i)) {
            case 0:
                decorView.performHapticFeedback(0);
                break;
            case 1:
                decorView.performHapticFeedback(1);
                break;
            case 2:
                decorView.performHapticFeedback(3);
                break;
            case 3:
                decorView.performHapticFeedback(6);
                break;
            case 4:
                decorView.performHapticFeedback(4);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 30) {
                    decorView.performHapticFeedback(16);
                }
                break;
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    decorView.performHapticFeedback(3);
                }
                break;
            case 7:
                if (Build.VERSION.SDK_INT >= 30) {
                    decorView.performHapticFeedback(17);
                }
                break;
        }
    }

    public ws(int i) {
        this.a = i;
        switch (i) {
            case 4:
                this.b = new LinkedHashMap(0, 0.75f, true);
                break;
        }
    }

    public ws(kd kdVar, int i) {
        this.a = i;
        switch (i) {
            case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                new aj(kdVar, "flutter/scribe", mh.o).b(new ws(23, this));
                break;
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
            default:
                new aj(kdVar, "flutter/mousecursor", sb0.a).b(new ws(8, this));
                break;
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                new aj(kdVar, "flutter/sensitivecontent", sb0.a).b(new ws(25, this));
                break;
        }
    }

    public ws(a6 a6Var) {
        this.a = 0;
        new aj(a6Var, "flutter/keyboard", sb0.a).b(new i3(this));
    }

    public ws(oe0 oe0Var) {
        this.a = 7;
        this.b = new CopyOnWriteArrayList();
        new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ws(jp jpVar) {
        this.a = 22;
        this.b = (bd0) jpVar;
    }
}
