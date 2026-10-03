package sensei0;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class z30 {
    public final /* synthetic */ RecyclerView a;

    public /* synthetic */ z30(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(int i) {
        RecyclerView recyclerView = this.a;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            RecyclerView.r(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }
}
