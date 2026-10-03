package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.sensei.tunnel.R;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q30 extends ConstraintLayout {
    public final u2 x;
    public int y;
    public final kw z;

    public q30(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        kw kwVar = new kw();
        this.z = kwVar;
        d50 d50Var = new d50(0.5f);
        c80 c80VarD = kwVar.a.a.d();
        c80VarD.e = d50Var;
        c80VarD.f = d50Var;
        c80VarD.g = d50Var;
        c80VarD.h = d50Var;
        kwVar.setShapeAppearanceModel(c80VarD.a());
        this.z.j(ColorStateList.valueOf(-1));
        kw kwVar2 = this.z;
        Field field = ai0.a;
        setBackground(kwVar2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o30.n, R.attr.materialClockStyle, 0);
        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.x = new u2(12, this);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            Field field = ai0.a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            u2 u2Var = this.x;
            handler.removeCallbacks(u2Var);
            handler.post(u2Var);
        }
    }

    public abstract void e();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        e();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            u2 u2Var = this.x;
            handler.removeCallbacks(u2Var);
            handler.post(u2Var);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.z.j(ColorStateList.valueOf(i));
    }
}
