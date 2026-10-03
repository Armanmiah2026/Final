package sensei0;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class r40 implements Runnable {
    public int a;
    public int b;
    public OverScroller c;
    public Interpolator d;
    public boolean f;
    public boolean h;
    public final /* synthetic */ RecyclerView o;

    public r40(RecyclerView recyclerView) {
        this.o = recyclerView;
        y30 y30Var = RecyclerView.s0;
        this.d = y30Var;
        this.f = false;
        this.h = false;
        this.c = new OverScroller(recyclerView.getContext(), y30Var);
    }

    public final void a() {
        if (this.f) {
            this.h = true;
            return;
        }
        RecyclerView recyclerView = this.o;
        recyclerView.removeCallbacks(this);
        Field field = ai0.a;
        recyclerView.postOnAnimation(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public final void run() {
        boolean r1;
        int i;
        int i2;
        RecyclerView recyclerView = this.o;
        int[] iArr = recyclerView.n0;
        if (recyclerView.q == null) {
            recyclerView.removeCallbacks(this);
            this.c.abortAnimation();
            return;
        }
        this.h = false;
        this.f = true;
        recyclerView.f();
        OverScroller overScroller = this.c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i3 = currX - this.a;
            int i4 = currY - this.b;
            this.a = currX;
            this.b = currY;
            int[] iArr2 = recyclerView.n0;
            iArr2[0] = 0;
            iArr2[1] = 0;
            if (recyclerView.i(i3, i4, 1, iArr2, null)) {
                i = i3 - iArr[0];
                i2 = i4 - iArr[1];
            } else {
                i = i3;
                i2 = i4;
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.e(i, i2);
            }
            if (!recyclerView.r.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.n0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            boolean z = false;
            recyclerView.j(0, 0, i, i2, null, 1, iArr3);
            int i5 = i - iArr[0];
            int i6 = i2 - iArr[1];
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z2 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
            recyclerView.q.getClass();
            if (z2) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                    if (i6 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i6 <= 0) {
                        currVelocity = 0;
                    }
                    if (i7 < 0) {
                        recyclerView.l();
                        if (recyclerView.H.isFinished()) {
                            recyclerView.H.onAbsorb(-i7);
                        }
                    } else if (i7 > 0) {
                        recyclerView.m();
                        if (recyclerView.J.isFinished()) {
                            recyclerView.J.onAbsorb(i7);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.n();
                        if (recyclerView.I.isFinished()) {
                            recyclerView.I.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.k();
                        if (recyclerView.K.isFinished()) {
                            recyclerView.K.onAbsorb(currVelocity);
                        }
                    }
                    if (i7 != 0 || currVelocity != 0) {
                        Field field = ai0.a;
                        recyclerView.postInvalidateOnAnimation();
                    }
                }
                vp vpVar = recyclerView.e0;
                vpVar.getClass();
                vpVar.c = 0;
                r1 = z;
            } else {
                a();
                xp xpVar = recyclerView.d0;
                r1 = z;
                if (xpVar != null) {
                    xpVar.a(recyclerView, 0, 0);
                    r1 = z;
                }
            }
        } else {
            r1 = 0;
        }
        recyclerView.q.getClass();
        this.f = r1;
        if (!this.h) {
            recyclerView.setScrollState(r1);
            recyclerView.E(1);
        } else {
            recyclerView.removeCallbacks(this);
            Field field2 = ai0.a;
            recyclerView.postOnAnimation(this);
        }
    }
}
