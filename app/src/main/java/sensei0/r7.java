package sensei0;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class r7 extends Property {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r7(Class cls, String str, int i) {
        super(cls, str);
        this.a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return Float.valueOf(((SwitchCompat) obj).H);
            case 6:
                return Float.valueOf(pi0.a.a((View) obj));
            default:
                return ((View) obj).getClipBounds();
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                u7 u7Var = (u7) obj;
                PointF pointF = (PointF) obj2;
                u7Var.getClass();
                u7Var.a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                u7Var.b = iRound;
                int i = u7Var.f + 1;
                u7Var.f = i;
                if (i == u7Var.g) {
                    pi0.a(u7Var.e, u7Var.a, iRound, u7Var.c, u7Var.d);
                    u7Var.f = 0;
                    u7Var.g = 0;
                }
                break;
            case 1:
                u7 u7Var2 = (u7) obj;
                PointF pointF2 = (PointF) obj2;
                u7Var2.getClass();
                u7Var2.c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                u7Var2.d = iRound2;
                int i2 = u7Var2.g + 1;
                u7Var2.g = i2;
                if (u7Var2.f == i2) {
                    pi0.a(u7Var2.e, u7Var2.a, u7Var2.b, u7Var2.c, iRound2);
                    u7Var2.f = 0;
                    u7Var2.g = 0;
                }
                break;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                pi0.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 3:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                pi0.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 4:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                pi0.a(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case 5:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 6:
                float fFloatValue = ((Float) obj2).floatValue();
                pi0.a.d((View) obj, fFloatValue);
                break;
            default:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
        }
    }
}
