package sensei0;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.trilead.ssh2.sftp.AttribFlags;
import net.sourceforge.jsocks.Proxy;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {
    public static final x0 e;
    public static final x0 f;
    public static final x0 g;
    public static final x0 h;
    public static final x0 i;
    public static final x0 j;
    public static final x0 k;
    public static final x0 l;
    public final Object a;
    public final int b;
    public final Class c;
    public final r1 d;

    static {
        new x0(1);
        new x0(2);
        new x0(4);
        new x0(8);
        e = new x0(16);
        new x0(32);
        new x0(64);
        new x0(128);
        new x0(256, k1.class);
        new x0(512, k1.class);
        new x0(1024, l1.class);
        new x0(2048, l1.class);
        f = new x0(AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE);
        g = new x0(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
        new x0(AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME);
        new x0(AttribFlags.SSH_FILEXFER_ATTR_CTIME);
        new x0(Proxy.SOCKS_NO_PROXY);
        new x0(Proxy.SOCKS_PROXY_NO_CONNECT, p1.class);
        h = new x0(Proxy.SOCKS_AUTH_NOT_SUPPORTED);
        i = new x0(Proxy.SOCKS_METHOD_NOTSUPPORTED);
        j = new x0(1048576);
        new x0(2097152, q1.class);
        int i2 = Build.VERSION.SDK_INT;
        new x0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        new x0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, n1.class);
        k = new x0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        new x0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        l = new x0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        new x0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        new x0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
        new x0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
        new x0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        new x0(i2 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
        new x0(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        new x0(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, o1.class);
        new x0(i2 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, m1.class);
        new x0(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
        new x0(i2 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
        new x0(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        new x0(i2 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
        new x0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        new x0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
        new x0(i2 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
        new x0(i2 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        new x0(i2 >= 34 ? a1.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public x0(int i2) {
        this(null, i2, null, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof x0)) {
            return false;
        }
        Object obj2 = ((x0) obj).a;
        Object obj3 = this.a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
        String strD = d1.d(this.b);
        if (strD.equals("ACTION_UNKNOWN")) {
            Object obj = this.a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                strD = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb.append(strD);
        return sb.toString();
    }

    public x0(int i2, Class cls) {
        this(null, i2, null, null, cls);
    }

    public x0(Object obj, int i2, String str, r1 r1Var, Class cls) {
        this.b = i2;
        this.d = r1Var;
        if (obj == null) {
            this.a = new AccessibilityNodeInfo.AccessibilityAction(i2, str);
        } else {
            this.a = obj;
        }
        this.c = cls;
    }
}
