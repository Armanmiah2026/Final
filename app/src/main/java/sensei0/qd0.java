package sensei0;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qd0 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final rd0 g;
    public final Integer h;
    public final String i;
    public final j1 j;
    public final String[] k;
    public final qd0[] l;
    public final Locale[] m;

    public qd0(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, rd0 rd0Var, Integer num, String str, j1 j1Var, String[] strArr, qd0[] qd0VarArr, Locale[] localeArr) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = i;
        this.g = rd0Var;
        this.h = num;
        this.i = str;
        this.j = j1Var;
        this.k = strArr;
        this.l = qd0VarArr;
        this.m = localeArr;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v1 sensei0.qd0, still in use, count: 2, list:
          (r8v1 sensei0.qd0) from 0x021e: PHI (r8v2 sensei0.qd0) = (r8v1 sensei0.qd0), (r8v4 sensei0.qd0) binds: [B:120:0x0211, B:312:0x04fc] A[DONT_GENERATE, DONT_INLINE]
          (r8v1 sensei0.qd0) from 0x01e8: MOVE (r30v5 sensei0.qd0) = (r8v1 sensei0.qd0) (LINE:489)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public static sensei0.qd0 a(org.json.JSONObject r35) {
        /*
            Method dump skipped, instruction units count: 1748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.qd0.a(org.json.JSONObject):sensei0.qd0");
    }
}
