package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends mm0 {
    @Override // sensei0.mm0
    public final void X(v vVar, v vVar2) {
        vVar.b = vVar2;
    }

    @Override // sensei0.mm0
    public final void Y(v vVar, Thread thread) {
        vVar.a = thread;
    }

    @Override // sensei0.mm0
    public final boolean g(w wVar, s sVar) {
        s sVar2 = s.b;
        synchronized (wVar) {
            try {
                if (wVar.b != sVar) {
                    return false;
                }
                wVar.b = sVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // sensei0.mm0
    public final boolean h(w wVar, Object obj, Object obj2) {
        synchronized (wVar) {
            try {
                if (wVar.a != obj) {
                    return false;
                }
                wVar.a = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // sensei0.mm0
    public final boolean i(w wVar, v vVar, v vVar2) {
        synchronized (wVar) {
            try {
                if (wVar.c != vVar) {
                    return false;
                }
                wVar.c = vVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
