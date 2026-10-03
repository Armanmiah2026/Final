package sensei0;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t90 implements xm, r80 {
    public Context a;
    public o4 b;
    public final pf c = new pf(20);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object h(sensei0.t90 r4, java.lang.String r5, java.lang.String r6, sensei0.yb r7) {
        /*
            boolean r0 = r7 instanceof sensei0.u80
            if (r0 == 0) goto L13
            r0 = r7
            sensei0.u80 r0 = (sensei0.u80) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            sensei0.u80 r0 = new sensei0.u80
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.d
            int r1 = r0.h
            r2 = 1
            if (r1 == 0) goto L2d
            if (r1 != r2) goto L25
            sensei0.wf0.H(r7)
            goto L59
        L25:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            sensei0.wf0.H(r7)
            java.lang.String r7 = "name"
            sensei0.pr.j(r7, r5)
            sensei0.a20 r7 = new sensei0.a20
            r7.<init>(r5)
            android.content.Context r4 = r4.a
            r5 = 0
            if (r4 == 0) goto L5c
            sensei0.ws r4 = sensei0.u90.a(r4)
            sensei0.v80 r1 = new sensei0.v80
            r1.<init>(r7, r6, r5)
            r0.h = r2
            sensei0.x10 r6 = new sensei0.x10
            r7 = 1
            r6.<init>(r1, r5, r7)
            java.lang.Object r4 = r4.a(r6, r0)
            sensei0.vc r5 = sensei0.vc.a
            if (r4 != r5) goto L59
            return r5
        L59:
            sensei0.mg0 r4 = sensei0.mg0.a
            return r4
        L5c:
            java.lang.String r4 = "context"
            sensei0.pr.V(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.t90.h(sensei0.t90, java.lang.String, java.lang.String, sensei0.yb):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r12 == r6) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b6, code lost:
    
        if (r12 == r6) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b8, code lost:
    
        return r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b6 -> B:35:0x00b9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m(sensei0.t90 r10, java.util.List r11, sensei0.yb r12) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.t90.m(sensei0.t90, java.util.List, sensei0.yb):java.lang.Object");
    }

    @Override // sensei0.r80
    public final Double a(String str, s80 s80Var) throws Throwable {
        x40 x40Var = new x40();
        wf0.z(new a90(str, this, x40Var, null, 1));
        return (Double) x40Var.a;
    }

    @Override // sensei0.r80
    public final void b(String str, boolean z, s80 s80Var) throws Throwable {
        wf0.z(new n90(str, this, z, null));
    }

    @Override // sensei0.r80
    public final ec0 c(String str, s80 s80Var) throws Throwable {
        String strP = p(str, s80Var);
        if (strP != null) {
            return nc0.d0(strP, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!", false) ? new ec0(strP, cc0.d) : nc0.d0(strP, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu", false) ? new ec0(null, cc0.c) : new ec0(null, cc0.f);
        }
        return null;
    }

    @Override // sensei0.r80
    public final void d(String str, long j, s80 s80Var) throws Throwable {
        wf0.z(new s90(str, this, j, null));
    }

    @Override // sensei0.xm
    public final void e(j1 j1Var) {
        pr.j("binding", j1Var);
        a6 a6Var = (a6) j1Var.b;
        pr.i("getBinaryMessenger(...)", a6Var);
        r80.g.getClass();
        q80.b(a6Var, null, "data_store");
        o4 o4Var = this.b;
        if (o4Var != null) {
            q80.b((a6) o4Var.b, null, "shared_preferences");
        }
        this.b = null;
    }

    @Override // sensei0.r80
    public final void f(String str, List list, s80 s80Var) throws Throwable {
        wf0.z(new o90(this, str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu".concat(this.c.b(list)), null, 0));
    }

    @Override // sensei0.xm
    public final void g(j1 j1Var) {
        pr.j("binding", j1Var);
        a6 a6Var = (a6) j1Var.b;
        pr.i("getBinaryMessenger(...)", a6Var);
        Context context = (Context) j1Var.a;
        pr.i("getApplicationContext(...)", context);
        this.a = context;
        try {
            r80.g.getClass();
            q80.b(a6Var, this, "data_store");
            this.b = new o4(a6Var, context, this.c);
        } catch (Exception e) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e);
        }
        new ht().g(j1Var);
    }

    @Override // sensei0.r80
    public final Map i(List list, s80 s80Var) {
        return (Map) wf0.z(new t80(this, list, null, 1));
    }

    @Override // sensei0.r80
    public final Long j(String str, s80 s80Var) throws Throwable {
        x40 x40Var = new x40();
        wf0.z(new a90(str, this, x40Var, null, 2));
        return (Long) x40Var.a;
    }

    @Override // sensei0.r80
    public final ArrayList k(String str, s80 s80Var) throws Throwable {
        List list;
        String strP = p(str, s80Var);
        if (strP == null || nc0.d0(strP, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!", false) || !nc0.d0(strP, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu", false) || (list = (List) u90.c(strP, this.c)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof String) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // sensei0.r80
    public final void l(String str, double d, s80 s80Var) throws Throwable {
        wf0.z(new q90(str, this, d, null));
    }

    @Override // sensei0.r80
    public final void o(List list, s80 s80Var) throws Throwable {
        wf0.z(new t80(this, list, null, 0));
    }

    @Override // sensei0.r80
    public final String p(String str, s80 s80Var) throws Throwable {
        x40 x40Var = new x40();
        wf0.z(new a90(str, this, x40Var, null, 3));
        return (String) x40Var.a;
    }

    @Override // sensei0.r80
    public final Boolean q(String str, s80 s80Var) throws Throwable {
        x40 x40Var = new x40();
        wf0.z(new a90(str, this, x40Var, null, 0));
        return (Boolean) x40Var.a;
    }

    @Override // sensei0.r80
    public final void r(String str, String str2, s80 s80Var) throws Throwable {
        wf0.z(new o90(this, str, str2, null, 1));
    }

    @Override // sensei0.r80
    public final void s(String str, String str2, s80 s80Var) throws Throwable {
        wf0.z(new o90(this, str, str2, null, 2));
    }

    @Override // sensei0.r80
    public final List t(List list, s80 s80Var) {
        return o9.r0(((Map) wf0.z(new t80(this, list, null, 2))).keySet());
    }
}
