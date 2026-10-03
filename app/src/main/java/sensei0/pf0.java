package sensei0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pf0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public mf0 a;
    public ViewGroup b;

    /* JADX WARN: Removed duplicated region for block: B:100:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01f5 A[EDGE_INSN: B:134:0x01f5->B:90:0x01f5 BREAK  A[LOOP:1: B:18:0x0084->B:89:0x01eb], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fc  */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onPreDraw() {
        /*
            Method dump skipped, instruction units count: 703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pf0.onPreDraw():boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.b;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        qf0.c.remove(viewGroup);
        ArrayList arrayList = (ArrayList) qf0.b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((mf0) obj).A(viewGroup);
            }
        }
        this.a.i(true);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
