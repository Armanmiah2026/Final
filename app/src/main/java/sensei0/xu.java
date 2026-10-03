package sensei0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class xu {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(xu.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(xu.class, Object.class, "_prev$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(xu.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        r6 = ((sensei0.e50) r6).a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        if (r5.get(r4) == r3) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sensei0.xu f() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sensei0.xu.b
            java.lang.Object r1 = r0.get(r9)
            sensei0.xu r1 = (sensei0.xu) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = sensei0.xu.a
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            goto L2d
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
            goto L2d
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.j()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            if (r6 != 0) goto L2e
        L2d:
            return r3
        L2e:
            boolean r7 = r6 instanceof sensei0.bz
            if (r7 == 0) goto L38
            sensei0.bz r6 = (sensei0.bz) r6
            r6.a(r3)
            goto L0
        L38:
            boolean r7 = r6 instanceof sensei0.e50
            if (r7 == 0) goto L58
            if (r4 == 0) goto L51
            sensei0.e50 r6 = (sensei0.e50) r6
            sensei0.xu r6 = r6.a
        L42:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L4a
            r3 = r4
            goto La
        L4a:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L42
            goto L0
        L51:
            java.lang.Object r3 = r0.get(r3)
            sensei0.xu r3 = (sensei0.xu) r3
            goto Lb
        L58:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            sensei0.pr.g(r4, r6)
            r4 = r6
            sensei0.xu r4 = (sensei0.xu) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.xu.f():sensei0.xu");
    }

    public final void g(xu xuVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            xu xuVar2 = (xu) atomicReferenceFieldUpdater.get(xuVar);
            if (h() != xuVar) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(xuVar, xuVar2, this)) {
                if (atomicReferenceFieldUpdater.get(xuVar) != xuVar2) {
                    break;
                }
            }
            if (j()) {
                xuVar.f();
                return;
            }
            return;
        }
    }

    public final Object h() {
        while (true) {
            Object obj = a.get(this);
            if (!(obj instanceof bz)) {
                return obj;
            }
            ((bz) obj).a(this);
        }
    }

    public final xu i() {
        xu xuVar;
        Object objH = h();
        e50 e50Var = objH instanceof e50 ? (e50) objH : null;
        if (e50Var != null && (xuVar = e50Var.a) != null) {
            return xuVar;
        }
        pr.g("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }", objH);
        return (xu) objH;
    }

    public boolean j() {
        return h() instanceof e50;
    }

    public String toString() {
        return new wu(this, xe.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;") + '@' + xe.o(this);
    }
}
