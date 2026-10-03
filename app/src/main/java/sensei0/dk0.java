package sensei0;

import android.content.pm.PackageInfo;
import android.net.Uri;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dk0 {
    public static final /* synthetic */ int a = 0;

    static {
        Uri.parse("*");
        Uri.parse("");
        new WeakHashMap();
    }

    public static PackageInfo a() {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", null).invoke(null, null);
    }
}
