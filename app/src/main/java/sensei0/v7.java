package sensei0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class v7 extends mf0 {
    public static final String[] K = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final r7 L = new r7(PointF.class, "topLeft", 0);
    public static final r7 M = new r7(PointF.class, "bottomRight", 1);
    public static final r7 N = new r7(PointF.class, "bottomRight", 2);
    public static final r7 O = new r7(PointF.class, "topLeft", 3);
    public static final r7 P = new r7(PointF.class, "position", 4);

    public static void L(uf0 uf0Var) {
        View view = uf0Var.b;
        HashMap map = uf0Var.a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", view.getParent());
    }

    @Override // sensei0.mf0
    public final void d(uf0 uf0Var) {
        L(uf0Var);
    }

    @Override // sensei0.mf0
    public final void g(uf0 uf0Var) {
        L(uf0Var);
    }

    @Override // sensei0.mf0
    public final Animator k(ViewGroup viewGroup, uf0 uf0Var, uf0 uf0Var2) {
        int i;
        v7 v7Var;
        Animator animatorA;
        if (uf0Var != null) {
            HashMap map = uf0Var.a;
            if (uf0Var2 != null) {
                HashMap map2 = uf0Var2.a;
                ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
                ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
                if (viewGroup2 != null && viewGroup3 != null) {
                    View view = uf0Var2.b;
                    Rect rect = (Rect) map.get("android:changeBounds:bounds");
                    Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
                    int i2 = rect.left;
                    int i3 = rect2.left;
                    int i4 = rect.top;
                    int i5 = rect2.top;
                    int i6 = rect.right;
                    int i7 = rect2.right;
                    int i8 = rect.bottom;
                    int i9 = rect2.bottom;
                    int i10 = i6 - i2;
                    int i11 = i8 - i4;
                    int i12 = i7 - i3;
                    int i13 = i9 - i5;
                    Rect rect3 = (Rect) map.get("android:changeBounds:clip");
                    Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
                    if ((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0)) {
                        i = 0;
                    } else {
                        i = (i2 == i3 && i4 == i5) ? 0 : 1;
                        if (i6 != i7 || i8 != i9) {
                            i++;
                        }
                    }
                    if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
                        i++;
                    }
                    int i14 = i;
                    if (i14 > 0) {
                        pi0.a(view, i2, i4, i6, i8);
                        if (i14 != 2) {
                            v7Var = this;
                            if (i2 == i3 && i4 == i5) {
                                v7Var.D.getClass();
                                animatorA = vy.a(view, N, mz.e(i6, i8, i7, i9));
                            } else {
                                v7Var.D.getClass();
                                animatorA = vy.a(view, O, mz.e(i2, i4, i3, i5));
                            }
                        } else if (i10 == i12 && i11 == i13) {
                            v7Var = this;
                            v7Var.D.getClass();
                            animatorA = vy.a(view, P, mz.e(i2, i4, i3, i5));
                        } else {
                            v7Var = this;
                            u7 u7Var = new u7(view);
                            v7Var.D.getClass();
                            ObjectAnimator objectAnimatorA = vy.a(u7Var, L, mz.e(i2, i4, i3, i5));
                            v7Var.D.getClass();
                            ObjectAnimator objectAnimatorA2 = vy.a(u7Var, M, mz.e(i6, i8, i7, i9));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
                            animatorSet.addListener(new s7(u7Var));
                            animatorA = animatorSet;
                        }
                        if (view.getParent() instanceof ViewGroup) {
                            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                            fi0.b(viewGroup4, true);
                            v7Var.o().a(new t7(viewGroup4));
                        }
                        return animatorA;
                    }
                }
            }
        }
        return null;
    }

    @Override // sensei0.mf0
    public final String[] q() {
        return K;
    }
}
