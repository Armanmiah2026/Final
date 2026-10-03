package sensei0;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ii extends xe {
    public final hi w;

    public ii(TextView textView) {
        this.w = new hi(textView);
    }

    @Override // sensei0.xe
    public final void E(boolean z) {
        if (uh.k != null) {
            this.w.E(z);
        }
    }

    @Override // sensei0.xe
    public final void F(boolean z) {
        hi hiVar = this.w;
        if (uh.k != null) {
            hiVar.F(z);
        } else {
            hiVar.y = z;
        }
    }

    @Override // sensei0.xe
    public final TransformationMethod S(TransformationMethod transformationMethod) {
        return !(uh.k != null) ? transformationMethod : this.w.S(transformationMethod);
    }

    @Override // sensei0.xe
    public final InputFilter[] n(InputFilter[] inputFilterArr) {
        return !(uh.k != null) ? inputFilterArr : this.w.n(inputFilterArr);
    }

    @Override // sensei0.xe
    public final boolean r() {
        return this.w.y;
    }
}
