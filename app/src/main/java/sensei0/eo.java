package sensei0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Trace;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eo {
    public static final ev a = new ev(16);
    public static final ThreadPoolExecutor b;
    public static final Object c;
    public static final ka0 d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new k50());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
        c = new Object();
        d = new ka0(0);
    }

    public static String a(int i, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((xn) list.get(i2)).g);
            sb.append("-");
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static co b(String str, Context context, List list, int i) {
        int i2;
        Typeface typefaceO;
        ev evVar = a;
        Trace.beginSection(mm0.l0("getFontSync"));
        try {
            Typeface typeface = (Typeface) evVar.a(str);
            if (typeface != null) {
                return new co(typeface);
            }
            i6 i6VarA = wn.a(context, list);
            List list2 = (List) i6VarA.b;
            int i3 = i6VarA.a;
            if (i3 != 0) {
                i2 = i3 != 1 ? -3 : -2;
            } else {
                jo[] joVarArr = (jo[]) list2.get(0);
                if (joVarArr == null || joVarArr.length == 0) {
                    i2 = 1;
                } else {
                    int length = joVarArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            i2 = 0;
                            break;
                        }
                        int i5 = joVarArr[i4].f;
                        if (i5 == 0) {
                            i4++;
                        } else if (i5 >= 0) {
                            i2 = i5;
                        }
                    }
                }
            }
            if (i2 != 0) {
                return new co(i2);
            }
            if (list2.size() <= 1 || Build.VERSION.SDK_INT < 29) {
                jo[] joVarArr2 = (jo[]) list2.get(0);
                pr prVar = xf0.a;
                Trace.beginSection(mm0.l0("TypefaceCompat.createFromFontInfo"));
                typefaceO = xf0.a.o(context, joVarArr2, i);
                Trace.endSection();
            } else {
                pr prVar2 = xf0.a;
                Trace.beginSection(mm0.l0("TypefaceCompat.createFromFontInfoWithFallback"));
                typefaceO = xf0.a.p(context, list2, i);
                Trace.endSection();
            }
            if (typefaceO == null) {
                return new co(-3);
            }
            evVar.b(str, typefaceO);
            return new co(typefaceO);
        } catch (PackageManager.NameNotFoundException unused) {
            return new co(-1);
        } catch (Throwable th) {
            throw th;
        } finally {
            Trace.endSection();
        }
    }
}
