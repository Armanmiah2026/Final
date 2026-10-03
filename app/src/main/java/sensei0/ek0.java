package sensei0;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ek0 extends h3 {
    public final Pattern d;

    public ek0() {
        super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        this.d = Pattern.compile("\\A\\d+");
    }

    @Override // sensei0.h3
    public final boolean a() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override // sensei0.h3
    public final boolean b() {
        int i;
        PackageInfo packageInfoA;
        boolean zB = super.b();
        if (!zB || (i = Build.VERSION.SDK_INT) >= 29) {
            return zB;
        }
        int i2 = dk0.a;
        if (i >= 26) {
            packageInfoA = WebView.getCurrentWebViewPackage();
        } else {
            try {
                packageInfoA = dk0.a();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                packageInfoA = null;
            }
        }
        if (packageInfoA == null) {
            return false;
        }
        Matcher matcher = this.d.matcher(packageInfoA.versionName);
        return matcher.find() && Integer.parseInt(packageInfoA.versionName.substring(matcher.start(), matcher.end())) >= 105;
    }
}
