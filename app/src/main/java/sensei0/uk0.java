package sensei0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class uk0 implements View.OnApplyWindowInsetsListener {
    public final qb a;
    public rl0 b;

    public uk0(View view, qb qbVar) {
        rl0 rl0VarB;
        this.a = qbVar;
        Field field = ai0.a;
        rl0 rl0VarA = uh0.a(view);
        if (rl0VarA != null) {
            int i = Build.VERSION.SDK_INT;
            rl0VarB = (i >= 34 ? new el0(rl0VarA) : i >= 31 ? new dl0(rl0VarA) : i >= 30 ? new cl0(rl0VarA) : i >= 29 ? new bl0(rl0VarA) : new al0(rl0VarA)).b();
        } else {
            rl0VarB = null;
        }
        this.b = rl0VarB;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int[] iArr;
        boolean z;
        if (!view.isLaidOut()) {
            this.b = rl0.d(view, windowInsets);
            return vk0.i(view, windowInsets);
        }
        rl0 rl0VarD = rl0.d(view, windowInsets);
        ol0 ol0Var = rl0VarD.a;
        if (this.b == null) {
            Field field = ai0.a;
            this.b = uh0.a(view);
        }
        if (this.b == null) {
            this.b = rl0VarD;
            return vk0.i(view, windowInsets);
        }
        qb qbVarJ = vk0.j(view);
        if (qbVarJ != null && Objects.equals((rl0) qbVarJ.b, rl0VarD)) {
            return vk0.i(view, windowInsets);
        }
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        rl0 rl0Var = this.b;
        int i = 1;
        while (i <= 512) {
            hr hrVarF = ol0Var.f(i);
            hr hrVarF2 = rl0Var.a.f(i);
            int i2 = hrVarF.a;
            int i3 = hrVarF.d;
            int i4 = hrVarF.c;
            int i5 = hrVarF.b;
            int i6 = hrVarF2.a;
            int i7 = hrVarF2.d;
            int i8 = hrVarF2.c;
            int i9 = hrVarF2.b;
            if (i2 > i6 || i5 > i9 || i4 > i8 || i3 > i7) {
                iArr = iArr2;
                z = true;
            } else {
                iArr = iArr2;
                z = false;
            }
            if (z != (i2 < i6 || i5 < i9 || i4 < i8 || i3 < i7)) {
                if (z) {
                    iArr[0] = iArr[0] | i;
                } else {
                    iArr3[0] = iArr3[0] | i;
                }
            }
            i <<= 1;
            iArr2 = iArr;
        }
        int i10 = iArr2[0];
        int i11 = iArr3[0];
        int i12 = i10 | i11;
        if (i12 == 0) {
            this.b = rl0VarD;
            return vk0.i(view, windowInsets);
        }
        rl0 rl0Var2 = this.b;
        zk0 zk0Var = new zk0(i12, (i10 & 8) != 0 ? vk0.e : (i11 & 8) != 0 ? vk0.f : (i10 & 519) != 0 ? vk0.g : (i11 & 519) != 0 ? vk0.h : null, (i12 & 8) != 0 ? 160L : 250L);
        zk0Var.a.d(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(zk0Var.a.a());
        hr hrVarF3 = ol0Var.f(i12);
        hr hrVarF4 = rl0Var2.a.f(i12);
        int iMin = Math.min(hrVarF3.a, hrVarF4.a);
        int i13 = hrVarF3.b;
        int i14 = hrVarF4.b;
        int iMin2 = Math.min(i13, i14);
        int i15 = hrVarF3.c;
        int i16 = hrVarF4.c;
        int iMin3 = Math.min(i15, i16);
        int i17 = hrVarF3.d;
        int i18 = hrVarF4.d;
        ii0 ii0Var = new ii0(4, hr.b(iMin, iMin2, iMin3, Math.min(i17, i18)), hr.b(Math.max(hrVarF3.a, hrVarF4.a), Math.max(i13, i14), Math.max(i15, i16), Math.max(i17, i18)));
        vk0.f(view, rl0VarD, false);
        duration.addUpdateListener(new tk0(zk0Var, rl0VarD, rl0Var2, i12, view));
        duration.addListener(new ff0(zk0Var, view));
        l50 l50Var = new l50(view, zk0Var, ii0Var, duration);
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        az azVar = new az(view, l50Var);
        view.getViewTreeObserver().addOnPreDrawListener(azVar);
        view.addOnAttachStateChangeListener(azVar);
        this.b = rl0VarD;
        return vk0.i(view, windowInsets);
    }
}
