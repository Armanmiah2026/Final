package sensei0;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pa0 extends ViewGroup {
    public final Rect a;
    public final Rect b;

    public pa0(Context context) {
        super(context);
        this.a = new Rect();
        this.b = new Rect();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
            this.a.set(i, i2, i3, i4);
            Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.a, layoutParams.x, layoutParams.y, this.b);
            Rect rect = this.b;
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), AttribFlags.SSH_FILEXFER_ATTR_EXTENDED), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), AttribFlags.SSH_FILEXFER_ATTR_EXTENDED));
        }
        super.onMeasure(i, i2);
    }
}
