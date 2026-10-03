package sensei0;

import com.sensei.tunnel.MainActivity;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gv implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ MainActivity b;

    public /* synthetic */ gv(MainActivity mainActivity, int i) {
        this.a = i;
        this.b = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        MainActivity mainActivity = this.b;
        switch (i) {
            case 0:
                boolean z = MainActivity.B;
                mainActivity.x(true);
                break;
            case 1:
                boolean z2 = MainActivity.B;
                mainActivity.A();
                break;
            case 2:
                boolean z3 = MainActivity.B;
                mainActivity.A();
                break;
            default:
                boolean z4 = MainActivity.B;
                mainActivity.C("Could not open settings — please open your phone's settings manually", true);
                break;
        }
    }
}
