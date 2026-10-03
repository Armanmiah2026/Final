package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tc0 {
    public CharSequence A;
    public final /* synthetic */ uc0 D;
    public final Menu a;
    public boolean h;
    public int i;
    public int j;
    public CharSequence k;
    public CharSequence l;
    public int m;
    public char n;
    public int o;
    public char p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public int w;
    public String x;
    public String y;
    public CharSequence z;
    public ColorStateList B = null;
    public PorterDuff.Mode C = null;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public boolean f = true;
    public boolean g = true;

    public tc0(uc0 uc0Var, Menu menu) {
        this.D = uc0Var;
        this.a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.D.c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        uc0 uc0Var = this.D;
        Context context = uc0Var.c;
        boolean z = false;
        menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
        int i = this.v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        if (this.y != null) {
            if (context.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (uc0Var.d == null) {
                uc0Var.d = uc0.a(context);
            }
            Object obj = uc0Var.d;
            String str = this.y;
            sc0 sc0Var = new sc0();
            sc0Var.a = obj;
            Class<?> cls = obj.getClass();
            try {
                sc0Var.b = cls.getMethod(str, sc0.c);
                menuItem.setOnMenuItemClickListener(sc0Var);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }
        if (this.r >= 2 && (menuItem instanceof rw)) {
            rw rwVar = (rw) menuItem;
            rwVar.x = (rwVar.x & (-5)) | 4;
        }
        String str2 = this.x;
        if (str2 != null) {
            menuItem.setActionView((View) a(str2, uc0.e, uc0Var.a));
            z = true;
        }
        int i2 = this.w;
        if (i2 > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i2);
            }
        }
        CharSequence charSequence = this.z;
        boolean z2 = menuItem instanceof rw;
        if (z2) {
            ((rw) menuItem).c(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            e3.g(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.A;
        if (z2) {
            ((rw) menuItem).e(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            e3.k(menuItem, charSequence2);
        }
        char c = this.n;
        int i3 = this.o;
        if (z2) {
            ((rw) menuItem).setAlphabeticShortcut(c, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            e3.f(menuItem, c, i3);
        }
        char c2 = this.p;
        int i4 = this.q;
        if (z2) {
            ((rw) menuItem).setNumericShortcut(c2, i4);
        } else if (Build.VERSION.SDK_INT >= 26) {
            e3.j(menuItem, c2, i4);
        }
        PorterDuff.Mode mode = this.C;
        if (mode != null) {
            if (z2) {
                ((rw) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                e3.i(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.B;
        if (colorStateList != null) {
            if (z2) {
                ((rw) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                e3.h(menuItem, colorStateList);
            }
        }
    }
}
