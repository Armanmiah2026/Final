package sensei0;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class x10 extends bd0 implements jp {
    public final /* synthetic */ int f;
    public int h;
    public /* synthetic */ Object o;
    public final /* synthetic */ bd0 p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public x10(jp jpVar, xb xbVar, int i) {
        super(2, xbVar);
        this.f = i;
        switch (i) {
            case 1:
                this.p = (bd0) jpVar;
                super(2, xbVar);
                break;
            default:
                this.p = (bd0) jpVar;
                break;
        }
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        gy gyVar = (gy) obj;
        xb xbVar = (xb) obj2;
        switch (this.f) {
        }
        return ((x10) j(gyVar, xbVar)).n(mg0.a);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [sensei0.bd0, sensei0.jp] */
    /* JADX WARN: Type inference failed for: r1v1, types: [sensei0.bd0, sensei0.jp] */
    @Override // sensei0.l5
    public final xb j(Object obj, xb xbVar) {
        switch (this.f) {
            case 0:
                x10 x10Var = new x10(this.p, xbVar, 0);
                x10Var.o = obj;
                return x10Var;
            default:
                x10 x10Var2 = new x10(this.p, xbVar, 1);
                x10Var2.o = obj;
                return x10Var2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [sensei0.bd0, sensei0.jp] */
    /* JADX WARN: Type inference failed for: r4v14, types: [sensei0.bd0, sensei0.jp] */
    @Override // sensei0.l5
    public final Object n(Object obj) {
        switch (this.f) {
            case 0:
                int i = this.h;
                if (i == 0) {
                    wf0.H(obj);
                    gy gyVar = (gy) this.o;
                    this.h = 1;
                    obj = this.p.c(gyVar, this);
                    vc vcVar = vc.a;
                    if (obj == vcVar) {
                        return vcVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    wf0.H(obj);
                }
                gy gyVar2 = (gy) obj;
                pr.g("null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences", gyVar2);
                ((AtomicBoolean) gyVar2.b.b).set(true);
                return gyVar2;
            default:
                int i2 = this.h;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    gy gyVar3 = (gy) this.o;
                    wf0.H(obj);
                    return gyVar3;
                }
                wf0.H(obj);
                gy gyVar4 = new gy(new LinkedHashMap(((gy) this.o).a()), false);
                this.o = gyVar4;
                this.h = 1;
                Object objC = this.p.c(gyVar4, this);
                vc vcVar2 = vc.a;
                return objC == vcVar2 ? vcVar2 : gyVar4;
        }
    }
}
