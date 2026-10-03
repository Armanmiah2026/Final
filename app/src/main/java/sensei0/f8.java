package sensei0;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class f8 extends p0 {
    public final /* synthetic */ int d;
    public final /* synthetic */ View e;

    public /* synthetic */ f8(View view, int i) {
        this.d = i;
        this.e = view;
    }

    @Override // sensei0.p0
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.d) {
            case 0:
                super.c(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.e).d);
                break;
            default:
                super.c(view, accessibilityEvent);
                break;
        }
    }

    @Override // sensei0.p0
    public final void d(View view, d1 d1Var) {
        int i = this.d;
        View view2 = this.e;
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        switch (i) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = d1Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) view2;
                accessibilityNodeInfo.setCheckable(checkableImageButton.f);
                accessibilityNodeInfo.setChecked(checkableImageButton.d);
                break;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, d1Var.a);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) view2;
                int i2 = MaterialButtonToggleGroup.s;
                int i3 = -1;
                if (view instanceof MaterialButton) {
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i4 < materialButtonToggleGroup.getChildCount()) {
                            if (materialButtonToggleGroup.getChildAt(i4) == view) {
                                i3 = i5;
                            } else {
                                if ((materialButtonToggleGroup.getChildAt(i4) instanceof MaterialButton) && materialButtonToggleGroup.c(i4)) {
                                    i5++;
                                }
                                i4++;
                            }
                        }
                    }
                }
                d1Var.i(c1.a(((MaterialButton) view).w, 0, 1, i3, 1));
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo2 = d1Var.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) view2).F);
                break;
        }
    }
}
