package sensei0;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.sensei.tunnel.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends View.AccessibilityDelegate {
    public final p0 a;

    public o0(p0 p0Var) {
        this.a = p0Var;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.a(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        sv svVarB = this.a.b(view);
        if (svVarB != null) {
            return (AccessibilityNodeProvider) svVarB.b;
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.c(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        Object tag;
        Object objValueOf;
        Object tag2;
        int iKeyAt;
        d1 d1Var = new d1(accessibilityNodeInfo);
        Field field = ai0.a;
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            tag = Boolean.valueOf(wh0.c(view));
        } else {
            tag = view.getTag(R.id.tag_screen_reader_focusable);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        int i2 = 0;
        boolean z = bool != null && bool.booleanValue();
        if (i >= 28) {
            accessibilityNodeInfo.setScreenReaderFocusable(z);
        } else {
            d1Var.h(1, z);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            objValueOf = Boolean.valueOf(wh0.b(view));
        } else {
            Object tag3 = view.getTag(R.id.tag_accessibility_heading);
            objValueOf = Boolean.class.isInstance(tag3) ? tag3 : null;
        }
        Boolean bool2 = (Boolean) objValueOf;
        boolean z2 = bool2 != null && bool2.booleanValue();
        if (i >= 28) {
            accessibilityNodeInfo.setHeading(z2);
        } else {
            d1Var.h(2, z2);
        }
        CharSequence charSequenceC = ai0.c(view);
        if (i >= 28) {
            accessibilityNodeInfo.setPaneTitle(charSequenceC);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequenceC);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            tag2 = yh0.b(view);
        } else {
            tag2 = view.getTag(R.id.tag_state_description);
            if (!CharSequence.class.isInstance(tag2)) {
                tag2 = null;
            }
        }
        CharSequence charSequence = (CharSequence) tag2;
        if (i >= 30) {
            y0.e(accessibilityNodeInfo, charSequence);
        } else {
            accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
        this.a.d(view, d1Var);
        CharSequence text = accessibilityNodeInfo.getText();
        if (i < 26) {
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            accessibilityNodeInfo.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
            if (sparseArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    if (((WeakReference) sparseArray.valueAt(i3)).get() == null) {
                        arrayList.add(Integer.valueOf(i3));
                    }
                }
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    sparseArray.remove(((Integer) arrayList.get(i4)).intValue());
                }
            }
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            if (clickableSpanArr != null && clickableSpanArr.length > 0) {
                accessibilityNodeInfo.getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                SparseArray sparseArray2 = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray2);
                }
                int i5 = 0;
                while (i5 < clickableSpanArr.length) {
                    ClickableSpan clickableSpan = clickableSpanArr[i5];
                    int i6 = i2;
                    while (true) {
                        if (i6 >= sparseArray2.size()) {
                            iKeyAt = d1.c;
                            d1.c = iKeyAt + 1;
                            break;
                        } else {
                            if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i6)).get())) {
                                iKeyAt = sparseArray2.keyAt(i6);
                                break;
                            }
                            i6++;
                        }
                    }
                    sparseArray2.put(iKeyAt, new WeakReference(clickableSpanArr[i5]));
                    ClickableSpan clickableSpan2 = clickableSpanArr[i5];
                    Spanned spanned = (Spanned) text;
                    d1Var.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                    d1Var.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                    d1Var.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                    d1Var.c("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(iKeyAt));
                    i5++;
                    i2 = 0;
                }
            }
        }
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            d1Var.b((x0) list.get(i7));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.a.e(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.f(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.a.g(view, i, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEvent(View view, int i) {
        this.a.h(view, i);
    }

    @Override // android.view.View.AccessibilityDelegate
    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.a.i(view, accessibilityEvent);
    }
}
