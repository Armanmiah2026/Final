package sensei0;

import android.content.pm.PackageManager;
import android.content.pm.Signature;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ze extends mh {
    @Override // sensei0.mh
    public final Signature[] s(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }
}
