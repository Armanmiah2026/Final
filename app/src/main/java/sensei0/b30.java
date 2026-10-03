package sensei0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b30 {
    public static final n50 a = new n50();
    public static final Object b = new Object();
    public static mz c = null;

    public static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? z20.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static mz b() {
        mz mzVar = new mz(5);
        c = mzVar;
        n50 n50Var = a;
        n50Var.getClass();
        if (w.h.h(n50Var, null, mzVar)) {
            w.b(n50Var);
        }
        return c;
    }

    public static void c(Context context, boolean z) {
        a30 a30VarA;
        int i;
        if (z || c == null) {
            synchronized (b) {
                if (!z) {
                    try {
                        if (c != null) {
                            return;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 28 && i2 != 30) {
                    File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length = file.length();
                    int i3 = 0;
                    boolean z2 = file.exists() && length > 0;
                    File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    long length2 = file2.length();
                    boolean z3 = file2.exists() && length2 > 0;
                    try {
                        long jA = a(context);
                        File file3 = new File(context.getFilesDir(), "profileInstalled");
                        if (file3.exists()) {
                            try {
                                a30VarA = a30.a(file3);
                            } catch (IOException unused) {
                                b();
                                return;
                            }
                        } else {
                            a30VarA = null;
                        }
                        if (a30VarA != null && a30VarA.c == jA && (i = a30VarA.b) != 2) {
                            i3 = i;
                        } else if (z2) {
                            i3 = 1;
                        } else if (z3) {
                            i3 = 2;
                        }
                        if (z && z3 && i3 != 1) {
                            i3 = 2;
                        }
                        if (a30VarA != null && a30VarA.b == 2 && i3 == 1 && length < a30VarA.d) {
                            i3 = 3;
                        }
                        a30 a30Var = new a30(1, i3, jA, length2);
                        if (a30VarA == null || !a30VarA.equals(a30Var)) {
                            try {
                                a30Var.b(file3);
                            } catch (IOException unused2) {
                            }
                        }
                        b();
                        return;
                    } catch (PackageManager.NameNotFoundException unused3) {
                        b();
                        return;
                    }
                }
                b();
            }
        }
    }
}
