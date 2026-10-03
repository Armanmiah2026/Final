package sensei0;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xb0 extends x implements gl, il, up {
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(xb0.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;
    public int d;

    public xb0(Object obj) {
        this._state$volatile = obj;
    }

    public final boolean a(Object obj, Object obj2) {
        int i;
        yb0[] yb0VarArr;
        tn tnVar;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !pr.b(obj3, obj)) {
                return false;
            }
            if (pr.b(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i2 = this.d;
            if ((i2 & 1) != 0) {
                this.d = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.d = i3;
            yb0[] yb0VarArr2 = this.a;
            while (true) {
                if (yb0VarArr2 != null) {
                    for (yb0 yb0Var : yb0VarArr2) {
                        if (yb0Var != null) {
                            AtomicReference atomicReference = yb0Var.a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != (tnVar = mm0.g)) {
                                    tn tnVar2 = mm0.f;
                                    if (obj4 != tnVar2) {
                                        while (!atomicReference.compareAndSet(obj4, tnVar2)) {
                                            if (atomicReference.get() != obj4) {
                                                break;
                                            }
                                        }
                                        ((f7) obj4).h(mg0.a);
                                        break;
                                    }
                                    while (!atomicReference.compareAndSet(obj4, tnVar)) {
                                        if (atomicReference.get() != obj4) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i = this.d;
                    if (i == i3) {
                        this.d = i3 + 1;
                        return true;
                    }
                    yb0VarArr = this.a;
                }
                yb0VarArr2 = yb0VarArr;
                i3 = i;
            }
        }
    }

    @Override // sensei0.il
    public final Object d(Object obj, yb ybVar) {
        if (obj == null) {
            obj = pr.e;
        }
        a(null, obj);
        return mg0.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0148, code lost:
    
        if (r4 != r3) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0145, code lost:
    
        if (r5 != r3) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:14:0x0039, B:50:0x00c7, B:52:0x00cf, B:55:0x00d6, B:56:0x00dc, B:58:0x00df, B:68:0x0100, B:71:0x0110, B:72:0x012c, B:78:0x013c, B:75:0x0133, B:77:0x0139, B:60:0x00e5, B:64:0x00ec, B:21:0x0054, B:24:0x005f, B:49:0x00b7), top: B:102:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00df A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:14:0x0039, B:50:0x00c7, B:52:0x00cf, B:55:0x00d6, B:56:0x00dc, B:58:0x00df, B:68:0x0100, B:71:0x0110, B:72:0x012c, B:78:0x013c, B:75:0x0133, B:77:0x0139, B:60:0x00e5, B:64:0x00ec, B:21:0x0054, B:24:0x005f, B:49:0x00b7), top: B:102:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0110 A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:14:0x0039, B:50:0x00c7, B:52:0x00cf, B:55:0x00d6, B:56:0x00dc, B:58:0x00df, B:68:0x0100, B:71:0x0110, B:72:0x012c, B:78:0x013c, B:75:0x0133, B:77:0x0139, B:60:0x00e5, B:64:0x00ec, B:21:0x0054, B:24:0x005f, B:49:0x00b7), top: B:102:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x010f -> B:50:0x00c7). Please report as a decompilation issue!!! */
    @Override // sensei0.gl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(sensei0.il r18, sensei0.yb r19) {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.xb0.e(sensei0.il, sensei0.yb):java.lang.Object");
    }
}
