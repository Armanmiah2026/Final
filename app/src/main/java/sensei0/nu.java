package sensei0;

import android.database.DataSetObserver;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nu extends DataSetObserver {
    public final /* synthetic */ qu a;

    public nu(qu quVar) {
        this.a = quVar;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        qu quVar = this.a;
        if (quVar.D.isShowing()) {
            quVar.b();
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.a.dismiss();
    }
}
