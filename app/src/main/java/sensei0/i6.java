package sensei0;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class i6 implements r1 {
    public final int a;
    public final Object b;

    public i6(int i, at[] atVarArr) {
        this.a = i;
        this.b = atVarArr;
    }

    @Override // sensei0.r1
    public boolean a(View view) {
        ((BottomSheetBehavior) this.b).B(this.a);
        return true;
    }

    public i6() {
        this.a = 1;
        this.b = Collections.singletonList(null);
    }

    public i6(ArrayList arrayList) {
        this.a = 0;
        this.b = arrayList;
    }

    public i6(BottomSheetBehavior bottomSheetBehavior, int i) {
        this.b = bottomSheetBehavior;
        this.a = i;
    }
}
