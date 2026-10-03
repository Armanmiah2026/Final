package sensei0;

import android.view.KeyEvent;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class i5 {
    public final /* synthetic */ int a;
    public int b;
    public boolean c;
    public final Object d;
    public final Object e;

    public i5(ro roVar) {
        this.a = 0;
        roVar.getClass();
        this.d = new ArrayList();
        this.b = -1;
        this.e = roVar;
    }

    public void a(int i) {
        int i2 = this.a;
        Object obj = this.d;
        Object obj2 = this.e;
        switch (i2) {
            case 1:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj2;
                WeakReference weakReference = bottomSheetBehavior.U;
                if (weakReference != null && weakReference.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        Field field = ai0.a;
                        ((View) bottomSheetBehavior.U.get()).postOnAnimation((f5) obj);
                        this.c = true;
                    }
                    break;
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj2;
                WeakReference weakReference2 = sideSheetBehavior.p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        Field field2 = ai0.a;
                        ((View) sideSheetBehavior.p.get()).postOnAnimation((u2) obj);
                        this.c = true;
                    }
                    break;
                }
                break;
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                StringBuilder sb = new StringBuilder(128);
                sb.append("BackStackEntry{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                if (this.b >= 0) {
                    sb.append(" #");
                    sb.append(this.b);
                }
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public i5(o4 o4Var, KeyEvent keyEvent) {
        this.a = 2;
        this.e = o4Var;
        this.b = ((ys[]) o4Var.b).length;
        this.c = false;
        this.d = keyEvent;
    }

    public i5(SideSheetBehavior sideSheetBehavior) {
        this.a = 3;
        this.e = sideSheetBehavior;
        this.d = new u2(13, this);
    }

    public i5(BottomSheetBehavior bottomSheetBehavior) {
        this.a = 1;
        this.e = bottomSheetBehavior;
        this.d = new f5(1, this);
    }
}
