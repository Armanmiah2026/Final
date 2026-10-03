package sensei0;

import android.hardware.display.DisplayManager;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c9 {
    public final g30 a;

    public c9(g30 g30Var, int i) {
        switch (i) {
            case 1:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 2:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 3:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 4:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 5:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 6:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 7:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 8:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 9:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 10:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 11:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 12:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 13:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            case 14:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
            default:
                pr.j("pigeonRegistrar", g30Var);
                this.a = g30Var;
                break;
        }
    }

    public nk0 a() {
        DisplayManager displayManager = (DisplayManager) this.a.d.getSystemService("display");
        ArrayList arrayListB0 = pr.b0(displayManager);
        nk0 nk0Var = new nk0(this);
        ArrayList arrayListB02 = pr.b0(displayManager);
        arrayListB02.removeAll(arrayListB0);
        if (!arrayListB02.isEmpty()) {
            int size = arrayListB02.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListB02.get(i);
                i++;
                displayManager.unregisterDisplayListener((DisplayManager.DisplayListener) obj);
                displayManager.registerDisplayListener(new mg(arrayListB02, displayManager, 0), null);
            }
        }
        return nk0Var;
    }
}
