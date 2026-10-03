package sensei0;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import com.trilead.ssh2.sftp.AttribFlags;
import java.lang.reflect.Field;
import net.sourceforge.jsocks.Proxy;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class oj extends sv {
    public final /* synthetic */ o8 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oj(o8 o8Var) {
        super(2);
        this.d = o8Var;
    }

    @Override // sensei0.sv
    public final d1 A(int i) {
        o8 o8Var = this.d;
        int i2 = i == 2 ? o8Var.k : o8Var.l;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return y(i2);
    }

    @Override // sensei0.sv
    public final boolean E(int i, int i2, Bundle bundle) {
        int i3;
        o8 o8Var = this.d;
        Chip chip = o8Var.i;
        if (i == -1) {
            Field field = ai0.a;
            return chip.performAccessibilityAction(i2, bundle);
        }
        if (i2 == 1) {
            return o8Var.o(i);
        }
        if (i2 == 2) {
            return o8Var.j(i);
        }
        boolean z = false;
        if (i2 == 64) {
            AccessibilityManager accessibilityManager = o8Var.h;
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i3 = o8Var.k) == i) {
                return false;
            }
            if (i3 != Integer.MIN_VALUE) {
                o8Var.k = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                chip.invalidate();
                o8Var.p(i3, Proxy.SOCKS_NO_PROXY);
            }
            o8Var.k = i;
            chip.invalidate();
            o8Var.p(i, AttribFlags.SSH_FILEXFER_ATTR_CTIME);
            return true;
        }
        if (i2 == 128) {
            if (o8Var.k != i) {
                return false;
            }
            o8Var.k = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
            chip.invalidate();
            o8Var.p(i, Proxy.SOCKS_NO_PROXY);
            return true;
        }
        Chip chip2 = o8Var.n;
        if (i2 == 16) {
            if (i == 0) {
                return chip2.performClick();
            }
            if (i == 1) {
                chip2.playSoundEffect(0);
                View.OnClickListener onClickListener = chip2.p;
                if (onClickListener != null) {
                    onClickListener.onClick(chip2);
                    z = true;
                }
                if (chip2.A) {
                    chip2.z.p(1, 1);
                }
            }
        }
        return z;
    }

    @Override // sensei0.sv
    public final d1 y(int i) {
        return new d1(AccessibilityNodeInfo.obtain(this.d.n(i).a));
    }
}
