package sensei0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tk0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ zk0 a;
    public final /* synthetic */ rl0 b;
    public final /* synthetic */ rl0 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ View e;

    public tk0(zk0 zk0Var, rl0 rl0Var, rl0 rl0Var2, int i, View view) {
        this.a = zk0Var;
        this.b = rl0Var;
        this.c = rl0Var2;
        this.d = i;
        this.e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        zk0 zk0Var = this.a;
        yk0 yk0Var = zk0Var.a;
        yk0Var.d(animatedFraction);
        rl0 rl0Var = this.b;
        ol0 ol0Var = rl0Var.a;
        float fB = yk0Var.b();
        PathInterpolator pathInterpolator = vk0.e;
        int i = Build.VERSION.SDK_INT;
        fl0 el0Var = i >= 34 ? new el0(rl0Var) : i >= 31 ? new dl0(rl0Var) : i >= 30 ? new cl0(rl0Var) : i >= 29 ? new bl0(rl0Var) : new al0(rl0Var);
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((this.d & i2) == 0) {
                el0Var.c(i2, ol0Var.f(i2));
            } else {
                hr hrVarF = ol0Var.f(i2);
                hr hrVarF2 = this.c.a.f(i2);
                float f = 1.0f - fB;
                el0Var.c(i2, rl0.b(hrVarF, (int) (((double) ((hrVarF.a - hrVarF2.a) * f)) + 0.5d), (int) (((double) ((hrVarF.b - hrVarF2.b) * f)) + 0.5d), (int) (((double) ((hrVarF.c - hrVarF2.c) * f)) + 0.5d), (int) (((double) ((hrVarF.d - hrVarF2.d) * f)) + 0.5d)));
            }
        }
        vk0.g(this.e, el0Var.b(), Collections.singletonList(zk0Var));
    }
}
