package sensei0;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.util.DisplayMetrics;
import android.util.Log;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class um {
    public boolean a;
    public boolean b;
    public pf c;
    public long d;
    public o4 e;
    public FlutterJNI f;
    public ExecutorService g;
    public Future h;

    public static String b(Context context, String str) throws IOException {
        File file = new File(str);
        try {
            String canonicalPath = file.getCanonicalPath();
            boolean zStartsWith = canonicalPath.startsWith(context.getApplicationContext().getFilesDir().getCanonicalPath() + File.separator);
            boolean zEndsWith = canonicalPath.endsWith(".so");
            if (zStartsWith && zEndsWith) {
                return canonicalPath;
            }
            Log.e("FlutterLoader", "External path " + canonicalPath + " rejected; not overriding aot-shared-library-name.");
            return null;
        } catch (IOException unused) {
            Log.e("FlutterLoader", "External path " + file.getPath() + " is not a valid path. Please ensure this shared AOT library exists.");
            return null;
        }
    }

    public static void c(Context context, String str, ArrayList arrayList) {
        String strB;
        try {
            strB = b(context, str);
        } catch (IOException e) {
            Log.e("FlutterLoader", "Error while validating AOT shared library name flag: " + str, e);
            strB = null;
        }
        if (strB != null) {
            arrayList.add(0, hm.a.a + strB);
            return;
        }
        Log.e("FlutterLoader", "Skipping unsafe AOT shared library name flag: " + str + ". Please ensure that the library is vetted and placed in your application's internal storage.");
    }

    public final void a(Context context, String[] strArr) {
        boolean z;
        boolean z2;
        Iterator it;
        if (this.b) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.c == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            df0.b("FlutterLoader#ensureInitializationComplete");
            try {
                tm tmVar = (tm) this.h.get();
                ArrayList arrayList = new ArrayList();
                arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
                arrayList.add("--icu-native-lib-path=" + ((String) this.e.d) + File.separator + "libflutter.so");
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle != null) {
                    z = false;
                    z2 = false;
                    for (Iterator it2 = hm.k.iterator(); it2.hasNext(); it2 = it) {
                        gm gmVar = (gm) it2.next();
                        String str = gmVar.b;
                        if (!bundle.containsKey(str)) {
                            it = it2;
                        } else if (gmVar == hm.i) {
                            Log.w("FlutterLoader", "For testing purposes only: test flag specified in the manifest was loaded by the FlutterLoader.");
                            it = it2;
                        } else {
                            if (hm.l.contains(gmVar)) {
                                throw new IllegalArgumentException(str + " is disabled and no longer allowed. Please remove this flag from your application manifest.");
                            }
                            fm fmVar = hm.m;
                            if (((gm) fmVar.get(gmVar)) != null) {
                                StringBuilder sb = new StringBuilder();
                                it = it2;
                                sb.append("If you are trying to specify ");
                                sb.append(str);
                                sb.append(" in your application manifest, please make sure to use the new metadata key name: ");
                                sb.append(((gm) fmVar.get(gmVar)).b);
                                Log.w("FlutterLoader", sb.toString());
                            } else {
                                it = it2;
                                if (!gmVar.c) {
                                    Log.e("FlutterLoader", "Flag with metadata key " + str + " is not allowed in release builds and will be ignored if specified in the application manifest or via the command line.");
                                }
                            }
                            if (gmVar == hm.e) {
                                z = true;
                            } else if (gmVar == hm.j) {
                                z2 = true;
                            } else {
                                gm gmVar2 = hm.h;
                                if (gmVar == gmVar2) {
                                    this.a = bundle.getBoolean(gmVar2.b, false);
                                } else if (gmVar == hm.a || gmVar == hm.b) {
                                    String string = bundle.getString(str);
                                    if (string == null) {
                                        Log.e("FlutterLoader", "Flag " + str + " was specified with an empty path. Please specify a path to the desired AOT shared library.");
                                    } else {
                                        c(context, string, arrayList);
                                    }
                                }
                            }
                            String str2 = gmVar.a;
                            if (str2.endsWith("=")) {
                                Object obj = bundle.get(str);
                                String string2 = obj != null ? obj.toString() : null;
                                if (string2 == null) {
                                    Log.e("FlutterLoader", "Flag with metadata key " + str + " requires a value, but no value was found. Please specify a value.");
                                } else {
                                    arrayList.add(str2 + string2);
                                }
                            } else if (bundle.getBoolean(str, false)) {
                                arrayList.add(str2);
                            }
                        }
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                if (strArr != null) {
                    for (String str3 : strArr) {
                        gm gmVarA = hm.a(str3);
                        if (gmVarA == null) {
                            arrayList.add(str3);
                        } else if (gmVarA.equals(hm.i)) {
                            Log.w("FlutterLoader", "For testing purposes only: test flag specified on the command line was loaded by the FlutterLoader.");
                        } else {
                            gm gmVar3 = hm.a;
                            if (gmVarA.equals(gmVar3) || gmVarA.equals(hm.b)) {
                                c(context, str3.substring(gmVar3.a.length()), arrayList);
                            } else if (gmVarA.c) {
                                arrayList.add(str3);
                            } else {
                                Log.e("FlutterLoader", "Command line argument " + str3 + " is not allowed in release builds and will be ignored if specified in the application manifest or via the command line.");
                            }
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                gm gmVar4 = hm.a;
                sb2.append(gmVar4.a);
                sb2.append((String) this.e.b);
                arrayList.add(sb2.toString());
                arrayList.add(gmVar4.a + ((String) this.e.d) + File.separator + ((String) this.e.b));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("--cache-dir-path=");
                sb3.append(tmVar.b);
                arrayList.add(sb3.toString());
                Objects.requireNonNull(this.e);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("--domain-network-policy=");
                Objects.requireNonNull(this.e);
                sb4.append("");
                arrayList.add(sb4.toString());
                this.c.getClass();
                if (!z) {
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                    arrayList.add(hm.e.a + ((int) ((r2.totalMem / 1000000.0d) / 2.0d)));
                }
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 48));
                arrayList.add("--prefetched-default-font-manager");
                if (!z2) {
                    arrayList.add(hm.j.a + "true");
                }
                this.f.init(context, (String[]) arrayList.toArray(new String[0]), null, tmVar.a, tmVar.b, SystemClock.uptimeMillis() - this.d, Build.VERSION.SDK_INT);
                this.b = true;
                Trace.endSection();
            } finally {
            }
        } catch (Exception e) {
            Log.e("FlutterLoader", "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    public final void d(Context context) {
        pf pfVar = new pf(11);
        if (this.c != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        df0.b("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.c = pfVar;
            this.d = SystemClock.uptimeMillis();
            this.e = mm0.M(applicationContext);
            jj0 jj0VarA = jj0.a((DisplayManager) applicationContext.getSystemService("display"), this.f);
            jj0VarA.b.setAsyncWaitForVsyncDelegate(jj0VarA.d);
            this.h = this.g.submit(new sm(this, applicationContext));
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
}
