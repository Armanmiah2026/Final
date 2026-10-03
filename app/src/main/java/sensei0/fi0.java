package sensei0;

import android.os.Build;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fi0 {
    public static boolean a = true;

    public static boolean a(String str) {
        g3 g3Var = gk0.a;
        Set<oa> setUnmodifiableSet = Collections.unmodifiableSet(h3.c);
        HashSet hashSet = new HashSet();
        for (oa oaVar : setUnmodifiableSet) {
            if (((h3) oaVar).a.equals(str)) {
                hashSet.add(oaVar);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature ".concat(str));
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            h3 h3Var = (h3) ((oa) it.next());
            if (h3Var.a() || h3Var.b()) {
                return true;
            }
        }
        return false;
    }

    public static void b(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            ei0.b(viewGroup, z);
        } else if (a) {
            try {
                ei0.b(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                a = false;
            }
        }
    }
}
