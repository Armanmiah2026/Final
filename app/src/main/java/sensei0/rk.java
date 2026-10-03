package sensei0;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rk {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ rk(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    public final void a(String str, String str2, Object obj) {
        switch (this.a) {
            case 0:
                ((Handler) this.c).post(new m7(this, str, str2, obj, 1));
                break;
            case 1:
                ((pd) this.b).a(((aj) ((i3) this.c).c).c.f(str, str2, obj));
                break;
            default:
                Log.e("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
                break;
        }
    }

    public final void b() {
        switch (this.a) {
            case 0:
                ((Handler) this.c).post(new f5(5, this));
                break;
            case 1:
                ((pd) this.b).a(null);
                break;
        }
    }

    public final void d(Object obj) {
        switch (this.a) {
            case 0:
                ((Handler) this.c).post(new e2(3, this, obj));
                break;
            case 1:
                ((pd) this.b).a(((aj) ((i3) this.c).c).c.c(obj));
                break;
            default:
                ((n3) this.c).d = (byte[]) this.b;
                break;
        }
    }

    public rk(rk rkVar) {
        this.a = 0;
        this.b = rkVar;
        this.c = new Handler(Looper.getMainLooper());
    }

    private final void c() {
    }
}
