package sensei0;

import com.sensei.tunnel.MainActivity;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class iv implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ rk b;
    public final /* synthetic */ Object c;

    public /* synthetic */ iv(rk rkVar, Object obj, int i) {
        this.a = i;
        this.b = rkVar;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        Object obj = this.c;
        rk rkVar = this.b;
        switch (i) {
            case 0:
                boolean z = MainActivity.B;
                rkVar.d(obj);
                break;
            case 1:
                boolean z2 = MainActivity.B;
                rkVar.d(obj);
                break;
            default:
                boolean z3 = MainActivity.B;
                rkVar.d(obj);
                break;
        }
    }
}
