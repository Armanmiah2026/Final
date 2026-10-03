package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class e4 {
    public final TextView a;
    public r60 b;
    public r60 c;
    public r60 d;
    public r60 e;
    public r60 f;
    public r60 g;
    public r60 h;
    public final n4 i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public e4(TextView textView) {
        this.a = textView;
        this.i = new n4(textView);
    }

    public static r60 c(Context context, p3 p3Var, int i) {
        ColorStateList colorStateListF;
        synchronized (p3Var) {
            colorStateListF = p3Var.a.f(context, i);
        }
        if (colorStateListF == null) {
            return null;
        }
        r60 r60Var = new r60();
        r60Var.b = true;
        r60Var.c = colorStateListF;
        return r60Var;
    }

    public static void f(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            y0.d(editorInfo, text);
            return;
        }
        text.getClass();
        if (i >= 30) {
            y0.d(editorInfo, text);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        int length = text.length();
        if (i4 < 0 || i2 > length) {
            mm0.e0(editorInfo, null, 0, 0);
            return;
        }
        int i5 = editorInfo.inputType & 4095;
        if (i5 == 129 || i5 == 225 || i5 == 18) {
            mm0.e0(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            mm0.e0(editorInfo, text, i4, i2);
            return;
        }
        int i6 = i2 - i4;
        int i7 = i6 > 1024 ? 0 : i6;
        int i8 = 2048 - i7;
        int iMin = Math.min(text.length() - i2, i8 - Math.min(i4, (int) (((double) i8) * 0.8d)));
        int iMin2 = Math.min(i4, i8 - iMin);
        int i9 = i4 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i9))) {
            i9++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i2 + iMin) - 1))) {
            iMin--;
        }
        int i10 = iMin2 + i7;
        mm0.e0(editorInfo, i7 != i6 ? TextUtils.concat(text.subSequence(i9, i9 + iMin2), text.subSequence(i2, iMin + i2)) : text.subSequence(i9, i10 + iMin + i9), iMin2, i10);
    }

    public final void a(Drawable drawable, r60 r60Var) {
        if (drawable == null || r60Var == null) {
            return;
        }
        p3.d(drawable, r60Var, this.a.getDrawableState());
    }

    public final void b() {
        r60 r60Var = this.b;
        TextView textView = this.a;
        if (r60Var != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    /* JADX WARN: Removed duplicated region for block: B:240:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(android.util.AttributeSet r29, int r30) {
        /*
            Method dump skipped, instruction units count: 1006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.e4.d(android.util.AttributeSet, int):void");
    }

    public final void e(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, p30.s);
        o4 o4Var = new o4(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        l(context, o4Var);
        if (i2 >= 26 && typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            c4.d(textView, string);
        }
        o4Var.V();
        Typeface typeface = this.l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.j);
        }
    }

    public final void g(int i, int i2, int i3, int i4) {
        n4 n4Var = this.i;
        if (n4Var.j()) {
            DisplayMetrics displayMetrics = n4Var.j.getResources().getDisplayMetrics();
            n4Var.k(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (n4Var.h()) {
                n4Var.a();
            }
        }
    }

    public final void h(int[] iArr, int i) {
        n4 n4Var = this.i;
        if (n4Var.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = n4Var.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                n4Var.f = n4.b(iArrCopyOf);
                if (!n4Var.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                n4Var.g = false;
            }
            if (n4Var.h()) {
                n4Var.a();
            }
        }
    }

    public final void i(int i) {
        n4 n4Var = this.i;
        if (n4Var.j()) {
            if (i == 0) {
                n4Var.a = 0;
                n4Var.d = -1.0f;
                n4Var.e = -1.0f;
                n4Var.c = -1.0f;
                n4Var.f = new int[0];
                n4Var.b = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException(za0.h(i, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = n4Var.j.getResources().getDisplayMetrics();
            n4Var.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (n4Var.h()) {
                n4Var.a();
            }
        }
    }

    public final void j(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new r60();
        }
        r60 r60Var = this.h;
        r60Var.c = colorStateList;
        r60Var.b = colorStateList != null;
        this.b = r60Var;
        this.c = r60Var;
        this.d = r60Var;
        this.e = r60Var;
        this.f = r60Var;
        this.g = r60Var;
    }

    public final void k(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new r60();
        }
        r60 r60Var = this.h;
        r60Var.d = mode;
        r60Var.a = mode != null;
        this.b = r60Var;
        this.c = r60Var;
        this.d = r60Var;
        this.e = r60Var;
        this.f = r60Var;
        this.g = r60Var;
    }

    public final void l(Context context, o4 o4Var) {
        String string;
        int i = this.j;
        TypedArray typedArray = (TypedArray) o4Var.b;
        this.j = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.k = i3;
            if (i3 != -1) {
                this.j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.m = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (i4 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        int i6 = this.k;
        int i7 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceG = o4Var.G(i5, this.j, new z3(this, i6, i7, new WeakReference(this.a)));
                if (typefaceG != null) {
                    if (i2 < 28 || this.k == -1) {
                        this.l = typefaceG;
                    } else {
                        this.l = d4.a(Typeface.create(typefaceG, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(string, this.j);
        } else {
            this.l = d4.a(Typeface.create(string, 0), this.k, (this.j & 2) != 0);
        }
    }
}
