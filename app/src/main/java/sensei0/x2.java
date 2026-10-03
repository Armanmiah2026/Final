package sensei0;

import android.content.ClipData;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.webkit.WebStorage;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x2 implements v5, tx, u5, oi0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ x2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public boolean a(sv svVar, int i, Bundle bundle) {
        pb svVar2;
        r3 r3Var = (r3) this.b;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((fr) svVar.b).m();
                Parcelable parcelable = (Parcelable) ((fr) svVar.b).g();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        fr frVar = (fr) svVar.b;
        ClipData clipData = new ClipData(frVar.getDescription(), new ClipData.Item(frVar.h()));
        if (i2 >= 31) {
            svVar2 = new sv(clipData, 2);
        } else {
            qb qbVar = new qb();
            qbVar.b = clipData;
            qbVar.c = 2;
            svVar2 = qbVar;
        }
        svVar2.r(frVar.n());
        svVar2.setExtras(bundle);
        return ai0.g(r3Var, svVar2.build()) == null;
    }

    @Override // sensei0.oi0
    public boolean b(View view) {
        for (Class cls : (Class[]) this.b) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // sensei0.u5
    public void j(Object obj, i3 i3Var) {
        List listF0;
        List listF02;
        List listF03;
        List listF04;
        switch (this.a) {
            case 6:
                c9 c9Var = (c9) this.b;
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj2 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type kotlin.Long", obj2);
                try {
                    c9Var.a.b.a(((Long) obj2).longValue(), new ug(c9Var));
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
            case 7:
                c9 c9Var2 = (c9) this.b;
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                List list = (List) obj;
                Object obj3 = list.get(0);
                pr.g("null cannot be cast to non-null type kotlin.Long", obj3);
                long jLongValue = ((Long) obj3).longValue();
                Object obj4 = list.get(1);
                pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                try {
                    c9Var2.a.b.a(jLongValue, new zr((String) obj4, c9Var2));
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
                return;
            case 8:
                c9 c9Var3 = (c9) this.b;
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                List list2 = (List) obj;
                int i = 0;
                Object obj5 = list2.get(0);
                pr.g("null cannot be cast to non-null type android.net.http.SslError", obj5);
                SslError sslError = (SslError) obj5;
                Object obj6 = list2.get(1);
                pr.g("null cannot be cast to non-null type io.flutter.plugins.webviewflutter.SslErrorType", obj6);
                hb0 hb0Var = (hb0) obj6;
                try {
                } catch (Throwable th3) {
                    if (th3 instanceof t2) {
                        t2 t2Var3 = th3;
                        listF03 = p9.f0(t2Var3.a, t2Var3.b, t2Var3.c);
                    } else {
                        listF03 = p9.f0(th3.getClass().getSimpleName(), th3.toString(), za0.m("Cause: ", th3.getCause(), ", Stacktrace: ", Log.getStackTraceString(th3)));
                    }
                }
                switch (hb0Var.ordinal()) {
                    case 0:
                        i = 4;
                        listF03 = k6.G(Boolean.valueOf(sslError.hasError(i)));
                        i3Var.s(listF03);
                        return;
                    case 1:
                        i = 1;
                        listF03 = k6.G(Boolean.valueOf(sslError.hasError(i)));
                        i3Var.s(listF03);
                        return;
                    case 2:
                        i = 2;
                        listF03 = k6.G(Boolean.valueOf(sslError.hasError(i)));
                        i3Var.s(listF03);
                        return;
                    case 3:
                        i = 5;
                        listF03 = k6.G(Boolean.valueOf(sslError.hasError(i)));
                        i3Var.s(listF03);
                        return;
                    case 4:
                        listF03 = k6.G(Boolean.valueOf(sslError.hasError(i)));
                        i3Var.s(listF03);
                        return;
                    case 5:
                        i = 3;
                        listF03 = k6.G(Boolean.valueOf(sslError.hasError(i)));
                        i3Var.s(listF03);
                        return;
                    case 6:
                        c9Var3.a.getClass();
                        throw new IllegalArgumentException(hb0Var + " doesn't represent a native value.");
                    default:
                        i = -1;
                        listF03 = k6.G(Boolean.valueOf(sslError.hasError(i)));
                        i3Var.s(listF03);
                        return;
                }
            default:
                c9 c9Var4 = (c9) this.b;
                pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                Object obj7 = ((List) obj).get(0);
                pr.g("null cannot be cast to non-null type kotlin.Long", obj7);
                try {
                    c9Var4.a.b.a(((Long) obj7).longValue(), WebStorage.getInstance());
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
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0458 A[Catch: Exception -> 0x05bc, TryCatch #2 {Exception -> 0x05bc, blocks: (B:117:0x0249, B:119:0x024f, B:120:0x0260, B:122:0x027b, B:123:0x0297, B:125:0x029d, B:126:0x02ae, B:128:0x02b8, B:129:0x02ca, B:131:0x02f8, B:133:0x030c, B:137:0x034c, B:139:0x036b, B:144:0x0376, B:146:0x0399, B:148:0x03a1, B:149:0x03b1, B:151:0x03b8, B:153:0x03be, B:154:0x03ce, B:156:0x03d9, B:158:0x03e0, B:159:0x03ee, B:161:0x03f6, B:163:0x0406, B:165:0x0416, B:166:0x0419, B:168:0x0423, B:170:0x0429, B:171:0x0458, B:173:0x045f, B:178:0x047b, B:180:0x0481, B:181:0x0491, B:184:0x049a, B:193:0x04ab, B:198:0x04c3, B:201:0x04cf, B:206:0x04e5, B:208:0x0503, B:211:0x0519, B:214:0x0581, B:220:0x059a, B:222:0x059f, B:223:0x05a6), top: B:518:0x0249 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0491 A[Catch: Exception -> 0x05bc, TryCatch #2 {Exception -> 0x05bc, blocks: (B:117:0x0249, B:119:0x024f, B:120:0x0260, B:122:0x027b, B:123:0x0297, B:125:0x029d, B:126:0x02ae, B:128:0x02b8, B:129:0x02ca, B:131:0x02f8, B:133:0x030c, B:137:0x034c, B:139:0x036b, B:144:0x0376, B:146:0x0399, B:148:0x03a1, B:149:0x03b1, B:151:0x03b8, B:153:0x03be, B:154:0x03ce, B:156:0x03d9, B:158:0x03e0, B:159:0x03ee, B:161:0x03f6, B:163:0x0406, B:165:0x0416, B:166:0x0419, B:168:0x0423, B:170:0x0429, B:171:0x0458, B:173:0x045f, B:178:0x047b, B:180:0x0481, B:181:0x0491, B:184:0x049a, B:193:0x04ab, B:198:0x04c3, B:201:0x04cf, B:206:0x04e5, B:208:0x0503, B:211:0x0519, B:214:0x0581, B:220:0x059a, B:222:0x059f, B:223:0x05a6), top: B:518:0x0249 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04ab A[Catch: Exception -> 0x05bc, TryCatch #2 {Exception -> 0x05bc, blocks: (B:117:0x0249, B:119:0x024f, B:120:0x0260, B:122:0x027b, B:123:0x0297, B:125:0x029d, B:126:0x02ae, B:128:0x02b8, B:129:0x02ca, B:131:0x02f8, B:133:0x030c, B:137:0x034c, B:139:0x036b, B:144:0x0376, B:146:0x0399, B:148:0x03a1, B:149:0x03b1, B:151:0x03b8, B:153:0x03be, B:154:0x03ce, B:156:0x03d9, B:158:0x03e0, B:159:0x03ee, B:161:0x03f6, B:163:0x0406, B:165:0x0416, B:166:0x0419, B:168:0x0423, B:170:0x0429, B:171:0x0458, B:173:0x045f, B:178:0x047b, B:180:0x0481, B:181:0x0491, B:184:0x049a, B:193:0x04ab, B:198:0x04c3, B:201:0x04cf, B:206:0x04e5, B:208:0x0503, B:211:0x0519, B:214:0x0581, B:220:0x059a, B:222:0x059f, B:223:0x05a6), top: B:518:0x0249 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0516  */
    @Override // sensei0.tx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void l(sensei0.i3 r39, sensei0.rk r40) {
        /*
            Method dump skipped, instruction units count: 3048
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.x2.l(sensei0.i3, sensei0.rk):void");
    }

    @Override // sensei0.v5
    public void s(Object obj) {
        switch (this.a) {
            case 0:
                long j = ((c3) this.b).a;
                if (!(obj instanceof List)) {
                    wf0.i(new t2("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference'.", ""));
                    Log.e("PigeonProxyApiRegistrar", "Failed to remove Dart strong reference with identifier: " + j);
                } else {
                    List list = (List) obj;
                    if (list.size() > 1) {
                        Object obj2 = list.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                        Object obj3 = list.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                        wf0.i(new t2((String) obj2, (String) obj3, (String) list.get(2)));
                        Log.e("PigeonProxyApiRegistrar", "Failed to remove Dart strong reference with identifier: " + j);
                    }
                }
                break;
            default:
                x2 x2Var = (x2) this.b;
                boolean z = false;
                if (obj != null) {
                    try {
                        z = ((JSONObject) obj).getBoolean("handled");
                    } catch (JSONException e) {
                        Log.e("KeyEventChannel", "Unable to unpack JSON message: " + e);
                    }
                }
                ((g6) x2Var.b).c(z);
                break;
        }
    }
}
