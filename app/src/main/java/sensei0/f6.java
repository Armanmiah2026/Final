package sensei0;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class f6 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f6(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.a) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                kw kwVar = ((BottomSheetBehavior) this.b).i;
                if (kwVar != null) {
                    jw jwVar = kwVar.a;
                    if (jwVar.i != fFloatValue) {
                        jwVar.i = fFloatValue;
                        kwVar.f = true;
                        kwVar.invalidateSelf();
                    }
                }
                break;
            case 1:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                jk jkVar = (jk) this.b;
                jkVar.b.setAlpha(iFloatValue);
                jkVar.c.setAlpha(iFloatValue);
                jkVar.n.invalidate();
                break;
            default:
                ((TextInputLayout) this.b).D0.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
