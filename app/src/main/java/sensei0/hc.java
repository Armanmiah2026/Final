package sensei0;

import android.telephony.SubscriptionInfo;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hc implements Comparator {
    public final /* synthetic */ int a;

    public /* synthetic */ hc(int i) {
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                Field field = ai0.a;
                float fG = th0.g((View) obj);
                float fG2 = th0.g((View) obj2);
                if (fG > fG2) {
                    return -1;
                }
                return fG < fG2 ? 1 : 0;
            case 1:
                wp wpVar = (wp) obj;
                wp wpVar2 = (wp) obj2;
                RecyclerView recyclerView = wpVar.d;
                if ((recyclerView == null) == (wpVar2.d == null)) {
                    boolean z = wpVar.a;
                    if (z == wpVar2.a) {
                        int i = wpVar2.b - wpVar.b;
                        if (i != 0) {
                            return i;
                        }
                        int i2 = wpVar.c - wpVar2.c;
                        if (i2 != 0) {
                            return i2;
                        }
                        return 0;
                    }
                    if (!z) {
                        return 1;
                    }
                } else if (recyclerView == null) {
                    return 1;
                }
                return -1;
            case 2:
                return Integer.valueOf(((SubscriptionInfo) obj).getSimSlotIndex()).compareTo(Integer.valueOf(((SubscriptionInfo) obj2).getSimSlotIndex()));
            case 3:
                Integer num = (Integer) ((Map.Entry) obj).getKey();
                Integer num2 = (Integer) ((Map.Entry) obj2).getKey();
                if (num == null) {
                    return num2 == null ? 0 : -1;
                }
                if (num2 == null) {
                    return 1;
                }
                return num.compareTo(num2);
            case 4:
                return ((ab0) obj).b - ((ab0) obj2).b;
            default:
                return ((View) obj).getTop() - ((View) obj2).getTop();
        }
    }
}
