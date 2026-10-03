package sensei0;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gq extends View {
    public gq(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i) {
        xa xaVar = (xa) getLayoutParams();
        xaVar.a = i;
        setLayoutParams(xaVar);
    }

    public void setGuidelineEnd(int i) {
        xa xaVar = (xa) getLayoutParams();
        xaVar.b = i;
        setLayoutParams(xaVar);
    }

    public void setGuidelinePercent(float f) {
        xa xaVar = (xa) getLayoutParams();
        xaVar.c = f;
        setLayoutParams(xaVar);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
