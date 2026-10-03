package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class og0 {
    public static ng0 a(Object obj) {
        cq cqVar = (cq) obj;
        ng0 ng0Var = cqVar.unknownFields;
        if (ng0Var != ng0.f) {
            return ng0Var;
        }
        ng0 ng0Var2 = new ng0(0, new int[8], new Object[8], true);
        cqVar.unknownFields = ng0Var2;
        return ng0Var2;
    }

    public static boolean b(int i, Object obj, k9 k9Var) throws tr {
        j9 j9Var = k9Var.a;
        int i2 = k9Var.b;
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            k9Var.w(0);
            ((ng0) obj).c(i3 << 3, Long.valueOf(j9Var.n()));
            return true;
        }
        if (i4 == 1) {
            k9Var.w(1);
            ((ng0) obj).c((i3 << 3) | 1, Long.valueOf(j9Var.k()));
            return true;
        }
        if (i4 == 2) {
            ((ng0) obj).c((i3 << 3) | 2, k9Var.e());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw tr.b();
            }
            k9Var.w(5);
            ((ng0) obj).c(5 | (i3 << 3), Integer.valueOf(j9Var.j()));
            return true;
        }
        ng0 ng0Var = new ng0(0, new int[8], new Object[8], true);
        int i5 = i3 << 3;
        int i6 = i5 | 4;
        int i7 = i + 1;
        if (i7 >= 100) {
            throw new tr("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (k9Var.a() != Integer.MAX_VALUE && b(i7, ng0Var, k9Var)) {
        }
        if (i6 != k9Var.b) {
            throw new tr("Protocol message end-group tag did not match expected tag.");
        }
        if (ng0Var.e) {
            ng0Var.e = false;
        }
        ((ng0) obj).c(i5 | 3, ng0Var);
        return true;
    }
}
