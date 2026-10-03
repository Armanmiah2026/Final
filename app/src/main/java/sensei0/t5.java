package sensei0;

import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t5 implements z5 {
    public final /* synthetic */ int a;
    public final Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t5(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // sensei0.z5
    public final void a(ByteBuffer byteBuffer) {
        switch (this.a) {
            case 0:
                j1 j1Var = (j1) this.c;
                try {
                    ((v5) this.b).s(((dx) j1Var.c).b(byteBuffer));
                } catch (RuntimeException e) {
                    Log.e("BasicMessageChannel#" + ((String) j1Var.a), "Failed to handle message reply", e);
                    return;
                }
                break;
            default:
                aj ajVar = (aj) this.c;
                rk rkVar = (rk) this.b;
                try {
                    if (byteBuffer == null) {
                        rkVar.b();
                    } else {
                        try {
                            rkVar.d(ajVar.c.h(byteBuffer));
                        } catch (mm e2) {
                            rkVar.a(e2.a, e2.getMessage(), e2.b);
                        }
                    }
                } catch (RuntimeException e3) {
                    Log.e("MethodChannel#" + ajVar.b, "Failed to handle method call result", e3);
                    return;
                }
                break;
        }
    }
}
