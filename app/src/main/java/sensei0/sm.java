package sensei0;

import android.content.Context;
import android.os.Build;
import android.os.Trace;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sm implements Callable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ um b;

    public sm(um umVar, Context context) {
        this.b = umVar;
        this.a = context;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        um umVar = this.b;
        Context context = this.a;
        df0.b("FlutterLoader initTask");
        int i = 0;
        try {
            try {
                FlutterJNI flutterJNI = umVar.f;
                flutterJNI.loadLibrary(context);
                flutterJNI.updateRefreshRate();
                umVar.g.execute(new u2(5, this));
                File filesDir = context.getFilesDir();
                if (filesDir == null) {
                    filesDir = new File(context.getDataDir().getPath(), "files");
                }
                String path = filesDir.getPath();
                File codeCacheDir = context.getCodeCacheDir();
                if (codeCacheDir == null) {
                    codeCacheDir = context.getCacheDir();
                }
                if (codeCacheDir == null) {
                    codeCacheDir = new File(context.getDataDir().getPath(), "cache");
                }
                String path2 = codeCacheDir.getPath();
                File dir = context.getDir("flutter", 0);
                if (dir == null) {
                    dir = new File(context.getDataDir().getPath(), "app_flutter");
                }
                dir.getPath();
                tm tmVar = new tm(path, path2);
                Trace.endSection();
                return tmVar;
            } catch (UnsatisfiedLinkError e) {
                if (!e.toString().contains("couldn't find \"libflutter.so\"") && !e.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                    throw e;
                }
                String property = System.getProperty("os.arch");
                File file = new File((String) umVar.e.d);
                String[] list = file.list();
                ArrayList arrayList = new ArrayList();
                String[] strArr = Build.SUPPORTED_ABIS;
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = strArr[i2];
                    StringBuilder sb = new StringBuilder();
                    sb.append("!");
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append("lib");
                    sb.append(str2);
                    sb.append(str);
                    String string = sb.toString();
                    String[] strArr2 = context.getApplicationInfo().splitSourceDirs;
                    ArrayList arrayList2 = new ArrayList();
                    if (strArr2 != null) {
                        int length2 = strArr2.length;
                        for (int i3 = i; i3 < length2; i3++) {
                            arrayList2.add(strArr2[i3] + string);
                        }
                        arrayList.addAll(arrayList2);
                    }
                    String str3 = context.getApplicationInfo().sourceDir;
                    if (str3 != null && !str3.isEmpty()) {
                        arrayList.add(str3 + string);
                    }
                    i2++;
                    i = 0;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: ");
                sb2.append(property);
                sb2.append(", and the native libraries directory (with path ");
                sb2.append(file.getAbsolutePath());
                sb2.append(") ");
                sb2.append(file.exists() ? "contains the following files: " + Arrays.toString(list) : "does not exist");
                sb2.append(arrayList.isEmpty() ? "" : ", and the split and source libraries directory (with path(s) " + arrayList + ")");
                sb2.append(".");
                throw new UnsupportedOperationException(sb2.toString(), e);
            }
        } finally {
        }
    }
}
