package sensei0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 extends v3 implements h2 {
    public final /* synthetic */ g2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f2(g2 g2Var, Context context) {
        super(context, R.attr.actionOverflowButtonStyle);
        this.d = g2Var;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        wf0.B(this, getContentDescription());
        setOnTouchListener(new a2(this, this));
    }

    @Override // sensei0.h2
    public final boolean a() {
        return false;
    }

    @Override // sensei0.h2
    public final boolean c() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.d.h();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
