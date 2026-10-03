package sensei0;

import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class uu extends SpannableStringBuilder {
    public int a = 0;
    public int b = 0;
    public final ArrayList c = new ArrayList();
    public final ArrayList d = new ArrayList();
    public final ArrayList f = new ArrayList();
    public String h;
    public String o;
    public int p;
    public int q;
    public int r;
    public int s;
    public final su t;

    public uu(td0 td0Var, View view) {
        this.t = new su(view, this);
        if (td0Var != null) {
            f(td0Var);
        }
    }

    public final void a(tu tuVar) {
        if (this.b > 0) {
            Log.e("ListenableEditingState", "adding a listener " + tuVar.toString() + " in a listener callback");
        }
        if (this.a <= 0) {
            this.c.add(tuVar);
        } else {
            Log.w("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            this.d.add(tuVar);
        }
    }

    public final void b() {
        this.a++;
        if (this.b > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.a != 1 || this.c.isEmpty()) {
            return;
        }
        this.o = toString();
        this.p = Selection.getSelectionStart(this);
        this.q = Selection.getSelectionEnd(this);
        this.r = BaseInputConnection.getComposingSpanStart(this);
        this.s = BaseInputConnection.getComposingSpanEnd(this);
    }

    public final void c() {
        int i = this.a;
        if (i == 0) {
            Log.e("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        ArrayList arrayList = this.c;
        ArrayList arrayList2 = this.d;
        if (i == 1) {
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                this.b++;
                ((tu) obj).a(true);
                this.b--;
            }
            if (!arrayList.isEmpty()) {
                arrayList.size();
                d(!toString().equals(this.o), (this.p == Selection.getSelectionStart(this) && this.q == Selection.getSelectionEnd(this)) ? false : true, (this.r == BaseInputConnection.getComposingSpanStart(this) && this.s == BaseInputConnection.getComposingSpanEnd(this)) ? false : true);
            }
        }
        arrayList.addAll(arrayList2);
        arrayList2.clear();
        this.a--;
    }

    public final void d(boolean z, boolean z2, boolean z3) {
        if (z || z2 || z3) {
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                this.b++;
                ((tu) obj).a(z);
                this.b--;
            }
        }
    }

    public final void e(tu tuVar) {
        if (this.b > 0) {
            Log.e("ListenableEditingState", "removing a listener " + tuVar.toString() + " in a listener callback");
        }
        this.c.remove(tuVar);
        if (this.a > 0) {
            this.d.remove(tuVar);
        }
    }

    public final void f(td0 td0Var) {
        b();
        replace(0, length(), (CharSequence) td0Var.a);
        int i = td0Var.b;
        if (i >= 0) {
            Selection.setSelection(this, i, td0Var.c);
        } else {
            Selection.removeSelection(this);
        }
        int i2 = td0Var.d;
        int i3 = td0Var.e;
        if (i2 < 0 || i2 >= i3) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.t.setComposingRegion(i2, i3);
        }
        this.f.clear();
        c();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        super.setSpan(obj, i, i2, i3);
        String string = toString();
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        pd0 pd0Var = new pd0();
        pd0Var.e = selectionStart;
        pd0Var.f = selectionEnd;
        pd0Var.g = composingSpanStart;
        pd0Var.h = composingSpanEnd;
        pd0Var.a = string;
        pd0Var.b = "";
        pd0Var.c = -1;
        pd0Var.d = -1;
        this.f.add(pd0Var);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final String toString() {
        String str = this.h;
        if (str != null) {
            return str;
        }
        String string = super.toString();
        this.h = string;
        return string;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (this.b > 0) {
            Log.e("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        String string = toString();
        int i5 = i2 - i;
        boolean z = i5 != i4 - i3;
        for (int i6 = 0; i6 < i5 && !z; i6++) {
            z |= charAt(i + i6) != charSequence.charAt(i3 + i6);
        }
        if (z) {
            this.h = null;
        }
        int selectionStart = Selection.getSelectionStart(this);
        int selectionEnd = Selection.getSelectionEnd(this);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this);
        SpannableStringBuilder spannableStringBuilderReplace = super.replace(i, i2, charSequence, i3, i4);
        int selectionStart2 = Selection.getSelectionStart(this);
        int selectionEnd2 = Selection.getSelectionEnd(this);
        int composingSpanStart2 = BaseInputConnection.getComposingSpanStart(this);
        int composingSpanEnd2 = BaseInputConnection.getComposingSpanEnd(this);
        pd0 pd0Var = new pd0();
        pd0Var.e = selectionStart2;
        pd0Var.f = selectionEnd2;
        pd0Var.g = composingSpanStart2;
        pd0Var.h = composingSpanEnd2;
        String string2 = charSequence.toString();
        pd0Var.a = string;
        pd0Var.b = string2;
        pd0Var.c = i;
        pd0Var.d = i2;
        this.f.add(pd0Var);
        if (this.a > 0) {
            return spannableStringBuilderReplace;
        }
        d(z, (Selection.getSelectionStart(this) == selectionStart && Selection.getSelectionEnd(this) == selectionEnd) ? false : true, (BaseInputConnection.getComposingSpanStart(this) == composingSpanStart && BaseInputConnection.getComposingSpanEnd(this) == composingSpanEnd) ? false : true);
        return spannableStringBuilderReplace;
    }
}
