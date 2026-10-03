package sensei0;

import android.hardware.display.DisplayManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mg implements DisplayManager.DisplayListener {
    public final /* synthetic */ int a;
    public final DisplayManager b;
    public final /* synthetic */ Object c;

    public /* synthetic */ mg(Object obj, DisplayManager displayManager, int i) {
        this.a = i;
        this.c = obj;
        this.b = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.c;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((DisplayManager.DisplayListener) obj).onDisplayAdded(i);
                }
                break;
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        switch (this.a) {
            case 0:
                if (this.b.getDisplay(i) != null) {
                    ArrayList arrayList = (ArrayList) this.c;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((DisplayManager.DisplayListener) obj).onDisplayChanged(i);
                    }
                    break;
                }
                break;
            default:
                if (i == 0) {
                    float refreshRate = this.b.getDisplay(0).getRefreshRate();
                    jj0 jj0Var = (jj0) this.c;
                    jj0Var.a = (long) (1.0E9d / ((double) refreshRate));
                    jj0Var.b.setRefreshRateFPS(refreshRate);
                }
                break;
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
        switch (this.a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.c;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((DisplayManager.DisplayListener) obj).onDisplayRemoved(i);
                }
                break;
        }
    }

    private final void a(int i) {
    }

    private final void b(int i) {
    }
}
