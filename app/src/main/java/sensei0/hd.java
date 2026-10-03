package sensei0;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hd extends jw {
    public final RectF q;

    public hd(d80 d80Var, RectF rectF) {
        super(d80Var);
        this.q = rectF;
    }

    @Override // sensei0.jw, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        id idVar = new id(this);
        idVar.F = this;
        idVar.invalidateSelf();
        return idVar;
    }

    public hd(hd hdVar) {
        super(hdVar);
        this.q = hdVar.q;
    }
}
