package sensei0;

import android.widget.Toast;
import com.sensei.tunnel.MainActivity;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yf implements Runnable {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ yf(MainActivity mainActivity, String str, int i) {
        this.c = mainActivity;
        this.d = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        int i2 = this.b;
        Object obj = this.d;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                ((u20) ((zf) obj2).c).c(i2, obj);
                break;
            default:
                boolean z = MainActivity.B;
                Toast.makeText((MainActivity) obj2, (String) obj, i2).show();
                break;
        }
    }

    public /* synthetic */ yf(zf zfVar, int i, Object obj) {
        this.c = zfVar;
        this.b = i;
        this.d = obj;
    }
}
