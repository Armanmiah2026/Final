package sensei0;

import android.os.Build;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class wl implements hn {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ wl(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // sensei0.hn
    public final void a() {
        switch (this.a) {
            case 0:
                zl zlVar = (zl) this.b;
                zlVar.a.getClass();
                zlVar.h = false;
                break;
            case 1:
                ((io.flutter.embedding.engine.renderer.e) this.b).d = false;
                break;
            case 2:
                nn nnVar = (nn) this.b;
                nnVar.p = false;
                Iterator it = nnVar.o.iterator();
                while (it.hasNext()) {
                    ((hn) it.next()).a();
                }
                break;
        }
    }

    @Override // sensei0.hn
    public final void b() {
        switch (this.a) {
            case 0:
                zl zlVar = (zl) this.b;
                vl vlVar = zlVar.a;
                if (Build.VERSION.SDK_INT >= 29) {
                    vlVar.reportFullyDrawn();
                } else {
                    vlVar.getClass();
                }
                zlVar.h = true;
                zlVar.i = true;
                break;
            case 1:
                ((io.flutter.embedding.engine.renderer.e) this.b).d = true;
                break;
            case 2:
                nn nnVar = (nn) this.b;
                nnVar.p = true;
                Iterator it = nnVar.o.iterator();
                while (it.hasNext()) {
                    ((hn) it.next()).b();
                }
                break;
            default:
                xc0 xc0Var = (xc0) this.b;
                xc0Var.a.setAlpha(1.0f);
                io.flutter.embedding.engine.renderer.e eVar = xc0Var.b;
                if (eVar != null) {
                    eVar.g(this);
                }
                break;
        }
    }

    private final void c() {
    }
}
