package sensei0;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f0 extends ContentObserver {
    public final int a;
    public final /* synthetic */ io.flutter.view.b b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(io.flutter.view.b bVar, int i) {
        super(new Handler());
        this.b = bVar;
        this.a = i;
    }

    public abstract boolean a();

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        io.flutter.view.b bVar = this.b;
        if (bVar.u) {
            return;
        }
        bVar.n(this.a, a());
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        onChange(z, null);
    }
}
