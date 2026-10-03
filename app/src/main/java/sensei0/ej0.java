package sensei0;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ej0 extends va {
    public boolean o;
    public boolean p;

    @Override // sensei0.va
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i30.b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 6) {
                    this.o = true;
                } else if (index == 13) {
                    this.p = true;
                }
            }
        }
    }

    public abstract void h(hl hlVar, int i, int i2);

    @Override // sensei0.va, android.view.View
    public final void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.o || this.p) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i = 0; i < this.b; i++) {
                View view = (View) constraintLayout.a.get(this.a[i]);
                if (view != null) {
                    if (this.o) {
                        view.setVisibility(visibility);
                    }
                    if (this.p && elevation > 0.0f) {
                        view.setTranslationZ(view.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        c();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        c();
    }
}
