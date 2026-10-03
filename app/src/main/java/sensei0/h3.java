package sensei0;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h3 implements oa {
    public static final HashSet c = new HashSet();
    public final String a;
    public final String b;

    public h3(String str, String str2) {
        this.a = str;
        this.b = str2;
        c.add(this);
    }

    public abstract boolean a();

    public boolean b() {
        HashSet hashSet = f3.a;
        String str = this.b;
        if (hashSet.contains(str)) {
            return true;
        }
        String str2 = Build.TYPE;
        if (!"eng".equals(str2) && !"userdebug".equals(str2)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":dev");
        return hashSet.contains(sb.toString());
    }
}
