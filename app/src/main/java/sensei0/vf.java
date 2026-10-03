package sensei0;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vf {
    public ib a;
    public boolean b;
    public boolean c;
    public ib d;
    public ArrayList e;
    public ya f;
    public s5 g;
    public ArrayList h;

    public final void a(wf wfVar, int i, ArrayList arrayList, a60 a60Var) {
        ok0 ok0Var = wfVar.d;
        a60 a60Var2 = ok0Var.c;
        wf wfVar2 = ok0Var.i;
        wf wfVar3 = ok0Var.h;
        if (a60Var2 == null) {
            ib ibVar = this.a;
            if (ok0Var == ibVar.d || ok0Var == ibVar.e) {
                return;
            }
            if (a60Var == null) {
                a60Var = new a60();
                a60Var.a = null;
                a60Var.b = new ArrayList();
                a60Var.a = ok0Var;
                arrayList.add(a60Var);
            }
            ok0Var.c = a60Var;
            a60Var.b.add(ok0Var);
            ArrayList arrayList2 = wfVar3.k;
            int size = arrayList2.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                uf ufVar = (uf) obj;
                if (ufVar instanceof wf) {
                    a((wf) ufVar, i, arrayList, a60Var);
                }
            }
            ArrayList arrayList3 = wfVar2.k;
            int size2 = arrayList3.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList3.get(i4);
                i4++;
                uf ufVar2 = (uf) obj2;
                if (ufVar2 instanceof wf) {
                    a((wf) ufVar2, i, arrayList, a60Var);
                }
            }
            if (i == 1 && (ok0Var instanceof mh0)) {
                ArrayList arrayList4 = ((mh0) ok0Var).k.k;
                int size3 = arrayList4.size();
                int i5 = 0;
                while (i5 < size3) {
                    Object obj3 = arrayList4.get(i5);
                    i5++;
                    uf ufVar3 = (uf) obj3;
                    if (ufVar3 instanceof wf) {
                        a((wf) ufVar3, i, arrayList, a60Var);
                    }
                }
            }
            ArrayList arrayList5 = wfVar3.l;
            int size4 = arrayList5.size();
            int i6 = 0;
            while (i6 < size4) {
                Object obj4 = arrayList5.get(i6);
                i6++;
                a((wf) obj4, i, arrayList, a60Var);
            }
            ArrayList arrayList6 = wfVar2.l;
            int size5 = arrayList6.size();
            int i7 = 0;
            while (i7 < size5) {
                Object obj5 = arrayList6.get(i7);
                i7++;
                a((wf) obj5, i, arrayList, a60Var);
            }
            if (i == 1 && (ok0Var instanceof mh0)) {
                ArrayList arrayList7 = ((mh0) ok0Var).k.l;
                int size6 = arrayList7.size();
                while (i2 < size6) {
                    Object obj6 = arrayList7.get(i2);
                    i2++;
                    a((wf) obj6, i, arrayList, a60Var);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d4, code lost:
    
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x026a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(sensei0.ib r27) {
        /*
            Method dump skipped, instruction units count: 785
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.vf.b(sensei0.ib):void");
    }

    public final void c() {
        ib ibVar = this.a;
        ArrayList arrayList = this.h;
        ArrayList arrayList2 = this.e;
        arrayList2.clear();
        ib ibVar2 = this.d;
        ibVar2.d.f();
        mh0 mh0Var = ibVar2.e;
        mh0Var.f();
        arrayList2.add(ibVar2.d);
        arrayList2.add(mh0Var);
        ArrayList arrayList3 = ibVar2.d0;
        int size = arrayList3.size();
        HashSet hashSet = null;
        int i = 0;
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            hb hbVar = (hb) obj;
            if (hbVar instanceof hq) {
                iq iqVar = new iq(hbVar);
                hbVar.d.f();
                hbVar.e.f();
                iqVar.f = ((hq) hbVar).h0;
                arrayList2.add(iqVar);
            } else {
                if (hbVar.q()) {
                    if (hbVar.b == null) {
                        hbVar.b = new q7(hbVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(hbVar.b);
                } else {
                    arrayList2.add(hbVar.d);
                }
                if (hbVar.r()) {
                    if (hbVar.c == null) {
                        hbVar.c = new q7(hbVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(hbVar.c);
                } else {
                    arrayList2.add(hbVar.e);
                }
                if (hbVar instanceof nq) {
                    arrayList2.add(new mq(hbVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList2.addAll(hashSet);
        }
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            ((ok0) obj2).f();
        }
        int size3 = arrayList2.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj3 = arrayList2.get(i3);
            i3++;
            ok0 ok0Var = (ok0) obj3;
            if (ok0Var.b != ibVar2) {
                ok0Var.d();
            }
        }
        arrayList.clear();
        e(ibVar.d, 0, arrayList);
        e(ibVar.e, 1, arrayList);
        this.b = false;
    }

    public final int d(ib ibVar, int i) {
        ArrayList arrayList;
        int i2;
        long jMax;
        float f;
        ib ibVar2 = ibVar;
        ArrayList arrayList2 = this.h;
        int size = arrayList2.size();
        long j = 0;
        int i3 = 0;
        long jMax2 = 0;
        while (i3 < size) {
            ok0 ok0Var = ((a60) arrayList2.get(i3)).a;
            if (!(ok0Var instanceof q7) ? !(i != 0 ? (ok0Var instanceof mh0) : (ok0Var instanceof oq)) : ((q7) ok0Var).f != i) {
                wf wfVar = (i == 0 ? ibVar2.d : ibVar2.e).h;
                wf wfVar2 = (i == 0 ? ibVar2.d : ibVar2.e).i;
                wf wfVar3 = ok0Var.h;
                wf wfVar4 = ok0Var.i;
                boolean zContains = wfVar3.l.contains(wfVar);
                boolean zContains2 = wfVar4.l.contains(wfVar2);
                long j2 = ok0Var.j();
                if (zContains && zContains2) {
                    long jB = a60.b(wfVar3, j);
                    long jA = a60.a(wfVar4, j);
                    long j3 = jB - j2;
                    int i4 = wfVar4.f;
                    arrayList = arrayList2;
                    i2 = size;
                    if (j3 >= (-i4)) {
                        j3 += (long) i4;
                    }
                    long j4 = wfVar3.f;
                    long j5 = ((-jA) - j2) - j4;
                    if (j5 >= j4) {
                        j5 -= j4;
                    }
                    hb hbVar = ok0Var.b;
                    if (i == 0) {
                        f = hbVar.S;
                    } else if (i == 1) {
                        f = hbVar.T;
                    } else {
                        hbVar.getClass();
                        f = -1.0f;
                    }
                    float f2 = f > 0.0f ? (long) ((j3 / (1.0f - f)) + (j5 / f)) : 0L;
                    jMax = (((long) wfVar3.f) + ((((long) ((f2 * f) + 0.5f)) + j2) + ((long) (((1.0f - f) * f2) + 0.5f)))) - ((long) wfVar4.f);
                } else {
                    arrayList = arrayList2;
                    i2 = size;
                    jMax = zContains ? Math.max(a60.b(wfVar3, wfVar3.f), ((long) wfVar3.f) + j2) : zContains2 ? Math.max(-a60.a(wfVar4, wfVar4.f), ((long) (-wfVar4.f)) + j2) : (ok0Var.j() + ((long) wfVar3.f)) - ((long) wfVar4.f);
                }
            } else {
                arrayList = arrayList2;
                i2 = size;
                jMax = j;
            }
            jMax2 = Math.max(jMax2, jMax);
            i3++;
            ibVar2 = ibVar;
            arrayList2 = arrayList;
            size = i2;
            j = 0;
        }
        return (int) jMax2;
    }

    public final void e(ok0 ok0Var, int i, ArrayList arrayList) {
        wf wfVar = ok0Var.h;
        wf wfVar2 = ok0Var.i;
        ArrayList arrayList2 = wfVar.k;
        int size = arrayList2.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            uf ufVar = (uf) obj;
            if (ufVar instanceof wf) {
                a((wf) ufVar, i, arrayList, null);
            } else if (ufVar instanceof ok0) {
                a(((ok0) ufVar).h, i, arrayList, null);
            }
        }
        ArrayList arrayList3 = wfVar2.k;
        int size2 = arrayList3.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj2 = arrayList3.get(i4);
            i4++;
            uf ufVar2 = (uf) obj2;
            if (ufVar2 instanceof wf) {
                a((wf) ufVar2, i, arrayList, null);
            } else if (ufVar2 instanceof ok0) {
                a(((ok0) ufVar2).i, i, arrayList, null);
            }
        }
        if (i == 1) {
            ArrayList arrayList4 = ((mh0) ok0Var).k.k;
            int size3 = arrayList4.size();
            while (i2 < size3) {
                Object obj3 = arrayList4.get(i2);
                i2++;
                uf ufVar3 = (uf) obj3;
                if (ufVar3 instanceof wf) {
                    a((wf) ufVar3, i, arrayList, null);
                }
            }
        }
    }

    public final void f(int i, int i2, int i3, int i4, hb hbVar) {
        s5 s5Var = this.g;
        s5Var.a = i;
        s5Var.b = i3;
        s5Var.c = i2;
        s5Var.d = i4;
        this.f.a(hbVar, s5Var);
        hbVar.y(s5Var.e);
        hbVar.v(s5Var.f);
        hbVar.w = s5Var.h;
        int i5 = s5Var.g;
        hbVar.P = i5;
        hbVar.w = i5 > 0;
    }

    public final void g() {
        r5 r5Var;
        vf vfVar = this;
        ArrayList arrayList = vfVar.a.d0;
        int size = arrayList.size();
        char c = 0;
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            hb hbVar = (hb) arrayList.get(i);
            boolean z = hbVar.a;
            oq oqVar = hbVar.d;
            mh0 mh0Var = hbVar.e;
            if (!z) {
                int[] iArr = hbVar.c0;
                int i3 = iArr[c];
                int i4 = iArr[1];
                int i5 = hbVar.j;
                int i6 = hbVar.k;
                char c2 = (i3 == 2 || (i3 == 3 && i5 == 1)) ? (char) 1 : c;
                char c3 = (i4 == 2 || (i4 == 3 && i6 == 1)) ? (char) 1 : c;
                gg ggVar = oqVar.e;
                gg ggVar2 = oqVar.e;
                boolean z2 = ggVar.j;
                gg ggVar3 = mh0Var.e;
                gg ggVar4 = mh0Var.e;
                boolean z3 = ggVar3.j;
                char c4 = c2;
                if (z2 && z3) {
                    vfVar.f(1, ggVar.g, 1, ggVar3.g, hbVar);
                    hbVar.a = true;
                } else if (z2 && c3 != 0) {
                    f(1, ggVar.g, 2, ggVar3.g, hbVar);
                    if (i4 == 3) {
                        ggVar4.m = hbVar.i();
                    } else {
                        ggVar4.d(hbVar.i());
                        hbVar.a = true;
                    }
                } else if (z3 && c4 != 0) {
                    f(2, ggVar.g, 1, ggVar3.g, hbVar);
                    if (i3 == 3) {
                        ggVar2.m = hbVar.l();
                    } else {
                        ggVar2.d(hbVar.l());
                        hbVar.a = true;
                    }
                }
                if (hbVar.a && (r5Var = mh0Var.l) != null) {
                    r5Var.d(hbVar.P);
                }
                c = 0;
                vfVar = this;
            }
            i = i2;
        }
    }
}
