package sensei0;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ju implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ qu a;

    public ju(qu quVar) {
        this.a = quVar;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        xw xwVar;
        if (i == -1 || (xwVar = this.a.c) == null) {
            return;
        }
        xwVar.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
