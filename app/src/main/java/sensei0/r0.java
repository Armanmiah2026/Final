package sensei0;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import com.google.android.material.internal.CheckableImageButton;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final x2 a;

    public r0(x2 x2Var) {
        this.a = x2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r0) {
            return this.a.equals(((r0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        jh jhVar = (jh) this.a.b;
        AutoCompleteTextView autoCompleteTextView = jhVar.h;
        if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
            return;
        }
        CheckableImageButton checkableImageButton = jhVar.d;
        int i = z ? 2 : 1;
        Field field = ai0.a;
        checkableImageButton.setImportantForAccessibility(i);
    }
}
