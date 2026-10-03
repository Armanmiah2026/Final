package sensei0;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import com.sensei.tunnel.R;
import com.trilead.ssh2.sftp.AttribFlags;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class o8 extends p0 {
    public static final Rect o = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED, AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
    public static final pf p = new pf(7);
    public static final pf q = new pf(8);
    public final AccessibilityManager h;
    public final Chip i;
    public oj j;
    public final /* synthetic */ Chip n;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public int k = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    public int l = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    public int m = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;

    public o8(Chip chip, Chip chip2) {
        this.n = chip;
        this.i = chip2;
        this.h = (AccessibilityManager) chip2.getContext().getSystemService("accessibility");
        chip2.setFocusable(true);
        Field field = ai0.a;
        if (chip2.getImportantForAccessibility() == 0) {
            chip2.setImportantForAccessibility(1);
        }
    }

    @Override // sensei0.p0
    public final sv b(View view) {
        if (this.j == null) {
            this.j = new oj(this);
        }
        return this.j;
    }

    @Override // sensei0.p0
    public final void d(View view, d1 d1Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = d1Var.a;
        this.a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = this.n;
        q8 q8Var = chip.f;
        accessibilityNodeInfo.setCheckable(q8Var != null && q8Var.Y);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        accessibilityNodeInfo.setClassName(chip.getAccessibilityClassName());
        d1Var.j(chip.getText());
    }

    public final boolean j(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
        if (i == 1) {
            Chip chip = this.n;
            chip.u = false;
            chip.refreshDrawableState();
        }
        p(i, 8);
        return true;
    }

    public final d1 k(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        d1 d1Var = new d1(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        accessibilityNodeInfoObtain.setClassName("android.view.View");
        Rect rect = o;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        Chip chip = this.i;
        accessibilityNodeInfoObtain.setParent(chip);
        AccessibilityNodeInfo accessibilityNodeInfo = d1Var.a;
        if (i == 1) {
            Chip chip2 = this.n;
            CharSequence closeIconContentDescription = chip2.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = chip2.getText();
                accessibilityNodeInfo.setContentDescription(chip2.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            accessibilityNodeInfo.setBoundsInParent(chip2.getCloseIconTouchBoundsInt());
            d1Var.b(x0.e);
            accessibilityNodeInfo.setEnabled(chip2.isEnabled());
        } else {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.E);
        }
        if (d1Var.g() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.e;
        d1Var.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(chip.getContext().getPackageName());
        d1Var.b = i;
        accessibilityNodeInfoObtain.setSource(chip, i);
        if (this.k == i) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            d1Var.a(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            d1Var.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            d1Var.a(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            d1Var.a(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.g;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.d;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            d1Var.f(rect3);
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                accessibilityNodeInfoObtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                break;
                            }
                            parent = view.getParent();
                        } else if (parent != null) {
                            accessibilityNodeInfoObtain.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return d1Var;
    }

    public final void l(ArrayList arrayList) {
        q8 q8Var;
        arrayList.add(0);
        Rect rect = Chip.E;
        Chip chip = this.n;
        if (!chip.c() || (q8Var = chip.f) == null || !q8Var.S || chip.p == null) {
            return;
        }
        arrayList.add(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m(int r19, android.graphics.Rect r20) {
        /*
            Method dump skipped, instruction units count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.o8.m(int, android.graphics.Rect):boolean");
    }

    public final d1 n(int i) {
        if (i != -1) {
            return k(i);
        }
        Chip chip = this.i;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(chip);
        d1 d1Var = new d1(accessibilityNodeInfoObtain);
        Field field = ai0.a;
        chip.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            d1Var.a.addChild(chip, ((Integer) arrayList.get(i2)).intValue());
        }
        return d1Var;
    }

    public final boolean o(int i) {
        int i2;
        Chip chip = this.i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            j(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.l = i;
        if (i == 1) {
            Chip chip2 = this.n;
            chip2.u = true;
            chip2.refreshDrawableState();
        }
        p(i, 8);
        return true;
    }

    public final void p(int i, int i2) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = (view = this.i).getParent()) == null) {
            return;
        }
        if (i != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            d1 d1VarN = n(i);
            accessibilityEventObtain.getText().add(d1VarN.g());
            AccessibilityNodeInfo accessibilityNodeInfo = d1VarN.a;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }
}
