package sensei0;

import android.animation.ValueAnimator;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z8 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ xi b;

    public /* synthetic */ z8(xi xiVar, int i) {
        this.a = i;
        this.b = xiVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.a) {
            case 0:
                b9 b9Var = (b9) this.b;
                b9Var.getClass();
                b9Var.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 1:
                b9 b9Var2 = (b9) this.b;
                b9Var2.getClass();
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CheckableImageButton checkableImageButton = b9Var2.d;
                checkableImageButton.setScaleX(fFloatValue);
                checkableImageButton.setScaleY(fFloatValue);
                break;
            default:
                jh jhVar = (jh) this.b;
                jhVar.getClass();
                jhVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
