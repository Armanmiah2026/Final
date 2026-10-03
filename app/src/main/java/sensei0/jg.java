package sensei0;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jg extends gd0 {
    public int c;

    public jg(int i) {
        super(0L, id0.g);
        this.c = i;
    }

    public abstract void b(Object obj, CancellationException cancellationException);

    public abstract xb c();

    public Throwable d(Object obj) {
        ga gaVar = obj instanceof ga ? (ga) obj : null;
        if (gaVar != null) {
            return gaVar.a;
        }
        return null;
    }

    public final void i(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            wf0.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        pr.f(th);
        wf0.o(new yc("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th), c().f());
    }

    public abstract Object j();

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r13 = this;
            sensei0.mg0 r0 = sensei0.mg0.a
            sensei0.xs r1 = r13.b
            sensei0.xb r2 = r13.c()     // Catch: java.lang.Throwable -> L25
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            sensei0.pr.g(r3, r2)     // Catch: java.lang.Throwable -> L25
            sensei0.hg r2 = (sensei0.hg) r2     // Catch: java.lang.Throwable -> L25
            sensei0.yb r3 = r2.f     // Catch: java.lang.Throwable -> L25
            java.lang.Object r2 = r2.o     // Catch: java.lang.Throwable -> L25
            sensei0.lc r4 = r3.f()     // Catch: java.lang.Throwable -> L25
            java.lang.Object r2 = sensei0.xe.P(r4, r2)     // Catch: java.lang.Throwable -> L25
            sensei0.tn r5 = sensei0.xe.v     // Catch: java.lang.Throwable -> L25
            r6 = 0
            if (r2 == r5) goto L28
            sensei0.jg0 r5 = sensei0.xe.Q(r3, r4, r2)     // Catch: java.lang.Throwable -> L25
            goto L29
        L25:
            r2 = move-exception
            goto La1
        L28:
            r5 = r6
        L29:
            sensei0.lc r7 = r3.f()     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r8 = r13.j()     // Catch: java.lang.Throwable -> L4c
            java.lang.Throwable r9 = r13.d(r8)     // Catch: java.lang.Throwable -> L4c
            if (r9 != 0) goto L4e
            int r10 = r13.c     // Catch: java.lang.Throwable -> L4c
            r11 = 1
            if (r10 == r11) goto L41
            r12 = 2
            if (r10 != r12) goto L40
            goto L41
        L40:
            r11 = 0
        L41:
            if (r11 == 0) goto L4e
            sensei0.mh r10 = sensei0.mh.p     // Catch: java.lang.Throwable -> L4c
            sensei0.jc r7 = r7.n(r10)     // Catch: java.lang.Throwable -> L4c
            sensei0.bs r7 = (sensei0.bs) r7     // Catch: java.lang.Throwable -> L4c
            goto L4f
        L4c:
            r3 = move-exception
            goto L95
        L4e:
            r7 = r6
        L4f:
            if (r7 == 0) goto L68
            boolean r10 = r7.a()     // Catch: java.lang.Throwable -> L4c
            if (r10 != 0) goto L68
            sensei0.ls r7 = (sensei0.ls) r7     // Catch: java.lang.Throwable -> L4c
            java.util.concurrent.CancellationException r7 = r7.z()     // Catch: java.lang.Throwable -> L4c
            r13.b(r8, r7)     // Catch: java.lang.Throwable -> L4c
            sensei0.u50 r7 = sensei0.wf0.i(r7)     // Catch: java.lang.Throwable -> L4c
            r3.h(r7)     // Catch: java.lang.Throwable -> L4c
            goto L79
        L68:
            if (r9 == 0) goto L72
            sensei0.u50 r7 = sensei0.wf0.i(r9)     // Catch: java.lang.Throwable -> L4c
            r3.h(r7)     // Catch: java.lang.Throwable -> L4c
            goto L79
        L72:
            java.lang.Object r7 = r13.g(r8)     // Catch: java.lang.Throwable -> L4c
            r3.h(r7)     // Catch: java.lang.Throwable -> L4c
        L79:
            if (r5 == 0) goto L81
            boolean r3 = r5.W()     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L84
        L81:
            sensei0.xe.C(r4, r2)     // Catch: java.lang.Throwable -> L25
        L84:
            r1.getClass()     // Catch: java.lang.Throwable -> L88
            goto L8d
        L88:
            r0 = move-exception
            sensei0.u50 r0 = sensei0.wf0.i(r0)
        L8d:
            java.lang.Throwable r0 = sensei0.v50.a(r0)
            r13.i(r6, r0)
            goto Lb1
        L95:
            if (r5 == 0) goto L9d
            boolean r5 = r5.W()     // Catch: java.lang.Throwable -> L25
            if (r5 == 0) goto La0
        L9d:
            sensei0.xe.C(r4, r2)     // Catch: java.lang.Throwable -> L25
        La0:
            throw r3     // Catch: java.lang.Throwable -> L25
        La1:
            r1.getClass()     // Catch: java.lang.Throwable -> La5
            goto Laa
        La5:
            r0 = move-exception
            sensei0.u50 r0 = sensei0.wf0.i(r0)
        Laa:
            java.lang.Throwable r0 = sensei0.v50.a(r0)
            r13.i(r2, r0)
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.jg.run():void");
    }

    public Object g(Object obj) {
        return obj;
    }
}
