package sensei0;

import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a2 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final float a;
    public final int b;
    public final int c;
    public final View d;
    public lo f;
    public lo h;
    public boolean o;
    public int p;
    public final int[] q;
    public final /* synthetic */ int r;
    public final /* synthetic */ View s;

    public a2(View view) {
        this.q = new int[2];
        this.d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.b = tapTimeout;
        this.c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        lo loVar = this.h;
        View view = this.d;
        if (loVar != null) {
            view.removeCallbacks(loVar);
        }
        lo loVar2 = this.f;
        if (loVar2 != null) {
            view.removeCallbacks(loVar2);
        }
    }

    public final sw b() {
        c2 c2Var;
        switch (this.r) {
            case 0:
                b2 b2Var = ((ActionMenuItemView) this.s).u;
                if (b2Var == null || (c2Var = ((d2) b2Var).a.A) == null) {
                    return null;
                }
                return c2Var.a();
            default:
                c2 c2Var2 = ((f2) this.s).d.z;
                if (c2Var2 == null) {
                    return null;
                }
                return c2Var2.a();
        }
    }

    public final boolean c() {
        sw swVarB;
        switch (this.r) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.s;
                ow owVar = actionMenuItemView.s;
                return owVar != null && owVar.a(actionMenuItemView.p) && (swVarB = b()) != null && swVarB.h();
            default:
                ((f2) this.s).d.h();
                return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0124  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.a2.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.o = false;
        this.p = -1;
        lo loVar = this.f;
        if (loVar != null) {
            this.d.removeCallbacks(loVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a2(ActionMenuItemView actionMenuItemView) {
        this((View) actionMenuItemView);
        this.r = 0;
        this.s = actionMenuItemView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a2(f2 f2Var, f2 f2Var2) {
        this(f2Var2);
        this.r = 1;
        this.s = f2Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
