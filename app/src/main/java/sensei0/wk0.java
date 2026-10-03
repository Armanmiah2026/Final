package sensei0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class wk0 extends WindowInsetsAnimation$Callback {
    public final qb a;
    public List b;
    public ArrayList c;
    public final HashMap d;

    public wk0(qb qbVar) {
        super(0);
        this.d = new HashMap();
        this.a = qbVar;
    }

    public final zk0 a(WindowInsetsAnimation windowInsetsAnimation) {
        zk0 zk0Var = (zk0) this.d.get(windowInsetsAnimation);
        if (zk0Var == null) {
            zk0Var = new zk0(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                zk0Var.a = new xk0(windowInsetsAnimation);
            }
            this.d.put(windowInsetsAnimation, zk0Var);
        }
        return zk0Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        ((View) this.a.f).setTranslationY(0.0f);
        this.d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        qb qbVar = this.a;
        View view = (View) qbVar.f;
        int[] iArr = (int[]) qbVar.h;
        view.getLocationOnScreen(iArr);
        qbVar.c = iArr[1];
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.c = arrayList2;
            this.b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationM = u0.m(list.get(size));
            zk0 zk0VarA = a(windowInsetsAnimationM);
            zk0VarA.a.d(windowInsetsAnimationM.getFraction());
            this.c.add(zk0VarA);
        }
        rl0 rl0VarD = rl0.d(null, windowInsets);
        this.a.a(rl0VarD, this.b);
        return rl0VarD.c();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        a(windowInsetsAnimation);
        hr hrVarC = hr.c(bounds.getLowerBound());
        hr hrVarC2 = hr.c(bounds.getUpperBound());
        qb qbVar = this.a;
        View view = (View) qbVar.f;
        int[] iArr = (int[]) qbVar.h;
        view.getLocationOnScreen(iArr);
        int i = qbVar.c - iArr[1];
        qbVar.d = i;
        view.setTranslationY(i);
        u0.r();
        return u0.k(hrVarC.d(), hrVarC2.d());
    }
}
