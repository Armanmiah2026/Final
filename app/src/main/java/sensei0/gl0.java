package sensei0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gl0 extends ol0 {
    public static boolean i = false;
    public static Method j;
    public static Class k;
    public static Field l;
    public static Field m;
    public final WindowInsets c;
    public hr[] d;
    public hr e;
    public rl0 f;
    public hr g;
    public int h;

    public gl0(rl0 rl0Var, WindowInsets windowInsets) {
        super(rl0Var);
        this.e = null;
        this.c = windowInsets;
    }

    public static boolean A(int i2, int i3) {
        return (i2 & 6) == (i3 & 6);
    }

    @SuppressLint({"WrongConstant"})
    private hr t(int i2, boolean z) {
        hr hrVarA = hr.e;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                hrVarA = hr.a(hrVarA, u(i3, z));
            }
        }
        return hrVarA;
    }

    private hr v() {
        rl0 rl0Var = this.f;
        return rl0Var != null ? rl0Var.a.h() : hr.e;
    }

    private hr w(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!i) {
            y();
        }
        Method method = j;
        if (method != null && k != null && l != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) l.get(m.get(objInvoke));
                if (rect != null) {
                    return hr.b(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void y() {
        try {
            j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            k = cls;
            l = cls.getDeclaredField("mVisibleInsets");
            m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            l.setAccessible(true);
            m.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        i = true;
    }

    @Override // sensei0.ol0
    public void d(View view) {
        hr hrVarW = w(view);
        if (hrVarW == null) {
            hrVarW = hr.e;
        }
        z(hrVarW);
    }

    @Override // sensei0.ol0
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        gl0 gl0Var = (gl0) obj;
        return Objects.equals(this.g, gl0Var.g) && A(this.h, gl0Var.h);
    }

    @Override // sensei0.ol0
    public hr f(int i2) {
        return t(i2, false);
    }

    @Override // sensei0.ol0
    public final hr j() {
        if (this.e == null) {
            WindowInsets windowInsets = this.c;
            this.e = hr.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.e;
    }

    @Override // sensei0.ol0
    public rl0 l(int i2, int i3, int i4, int i5) {
        rl0 rl0VarD = rl0.d(null, this.c);
        int i6 = Build.VERSION.SDK_INT;
        fl0 el0Var = i6 >= 34 ? new el0(rl0VarD) : i6 >= 31 ? new dl0(rl0VarD) : i6 >= 30 ? new cl0(rl0VarD) : i6 >= 29 ? new bl0(rl0VarD) : new al0(rl0VarD);
        el0Var.g(rl0.b(j(), i2, i3, i4, i5));
        el0Var.e(rl0.b(h(), i2, i3, i4, i5));
        return el0Var.b();
    }

    @Override // sensei0.ol0
    public boolean n() {
        return this.c.isRound();
    }

    @Override // sensei0.ol0
    @SuppressLint({"WrongConstant"})
    public boolean o(int i2) {
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0 && !x(i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // sensei0.ol0
    public void p(hr[] hrVarArr) {
        this.d = hrVarArr;
    }

    @Override // sensei0.ol0
    public void q(rl0 rl0Var) {
        this.f = rl0Var;
    }

    @Override // sensei0.ol0
    public void s(int i2) {
        this.h = i2;
    }

    public hr u(int i2, boolean z) {
        hr hrVarH;
        int i3;
        hr hrVar = hr.e;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 8) {
                    hr[] hrVarArr = this.d;
                    hrVarH = hrVarArr != null ? hrVarArr[ri0.c(8)] : null;
                    if (hrVarH != null) {
                        return hrVarH;
                    }
                    hr hrVarJ = j();
                    hr hrVarV = v();
                    int i4 = hrVarJ.d;
                    if (i4 > hrVarV.d) {
                        return hr.b(0, 0, 0, i4);
                    }
                    hr hrVar2 = this.g;
                    if (hrVar2 != null && !hrVar2.equals(hrVar) && (i3 = this.g.d) > hrVarV.d) {
                        return hr.b(0, 0, 0, i3);
                    }
                } else {
                    if (i2 == 16) {
                        return i();
                    }
                    if (i2 == 32) {
                        return g();
                    }
                    if (i2 == 64) {
                        return k();
                    }
                    if (i2 == 128) {
                        rl0 rl0Var = this.f;
                        lg lgVarE = rl0Var != null ? rl0Var.a.e() : e();
                        if (lgVarE != null) {
                            int i5 = Build.VERSION.SDK_INT;
                            return hr.b(i5 >= 28 ? tb.e(lgVarE.a) : 0, i5 >= 28 ? tb.g(lgVarE.a) : 0, i5 >= 28 ? tb.f(lgVarE.a) : 0, i5 >= 28 ? tb.d(lgVarE.a) : 0);
                        }
                    }
                }
            } else {
                if (z) {
                    hr hrVarV2 = v();
                    hr hrVarH2 = h();
                    return hr.b(Math.max(hrVarV2.a, hrVarH2.a), 0, Math.max(hrVarV2.c, hrVarH2.c), Math.max(hrVarV2.d, hrVarH2.d));
                }
                if ((this.h & 2) == 0) {
                    hr hrVarJ2 = j();
                    rl0 rl0Var2 = this.f;
                    hrVarH = rl0Var2 != null ? rl0Var2.a.h() : null;
                    int iMin = hrVarJ2.d;
                    if (hrVarH != null) {
                        iMin = Math.min(iMin, hrVarH.d);
                    }
                    return hr.b(hrVarJ2.a, 0, hrVarJ2.c, iMin);
                }
            }
        } else {
            if (z) {
                return hr.b(0, Math.max(v().b, j().b), 0, 0);
            }
            if ((this.h & 4) == 0) {
                return hr.b(0, j().b, 0, 0);
            }
        }
        return hrVar;
    }

    public boolean x(int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 8 && i2 != 128) {
                return true;
            }
        }
        return !u(i2, false).equals(hr.e);
    }

    public void z(hr hrVar) {
        this.g = hrVar;
    }
}
