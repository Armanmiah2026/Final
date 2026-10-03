package sensei0;

import android.widget.FrameLayout;
import com.sensei.tunnel.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qf0 {
    public static final g5 a;
    public static final ThreadLocal b;
    public static final ArrayList c;

    static {
        g5 g5Var = new g5();
        g5Var.K = new ArrayList();
        g5Var.N = false;
        g5Var.O = 0;
        g5Var.L = false;
        g5Var.L(new bk(2));
        g5Var.L(new v7());
        g5Var.L(new bk(1));
        a = g5Var;
        b = new ThreadLocal();
        c = new ArrayList();
    }

    public static void a(FrameLayout frameLayout, mf0 mf0Var) {
        ArrayList arrayList = c;
        if (arrayList.contains(frameLayout) || !frameLayout.isLaidOut()) {
            return;
        }
        arrayList.add(frameLayout);
        if (mf0Var == null) {
            mf0Var = a;
        }
        mf0 mf0VarClone = mf0Var.clone();
        ArrayList arrayList2 = (ArrayList) b().get(frameLayout);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((mf0) obj).x(frameLayout);
            }
        }
        mf0VarClone.h(frameLayout, true);
        if (frameLayout.getTag(R.id.transition_current_scene) != null) {
            throw new ClassCastException();
        }
        frameLayout.setTag(R.id.transition_current_scene, null);
        pf0 pf0Var = new pf0();
        pf0Var.a = mf0VarClone;
        pf0Var.b = frameLayout;
        frameLayout.addOnAttachStateChangeListener(pf0Var);
        frameLayout.getViewTreeObserver().addOnPreDrawListener(pf0Var);
    }

    public static y4 b() {
        y4 y4Var;
        ThreadLocal threadLocal = b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (y4Var = (y4) weakReference.get()) != null) {
            return y4Var;
        }
        y4 y4Var2 = new y4(0);
        threadLocal.set(new WeakReference(y4Var2));
        return y4Var2;
    }
}
