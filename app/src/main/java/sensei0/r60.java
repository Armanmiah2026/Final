package sensei0;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class r60 {
    public boolean a;
    public boolean b;
    public Object c;
    public Object d;

    public Bundle a(String str) {
        if (!this.b) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = (Bundle) this.d;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = (Bundle) this.d;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = (Bundle) this.d;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.d = null;
        return bundle2;
    }
}
