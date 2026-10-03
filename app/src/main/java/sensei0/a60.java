package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a60 {
    public ok0 a;
    public ArrayList b;

    public static long a(wf wfVar, long j) {
        ok0 ok0Var = wfVar.d;
        ArrayList arrayList = wfVar.k;
        if (ok0Var instanceof mq) {
            return j;
        }
        int size = arrayList.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            uf ufVar = (uf) arrayList.get(i);
            if (ufVar instanceof wf) {
                wf wfVar2 = (wf) ufVar;
                if (wfVar2.d != ok0Var) {
                    jMin = Math.min(jMin, a(wfVar2, ((long) wfVar2.f) + j));
                }
            }
        }
        wf wfVar3 = ok0Var.i;
        wf wfVar4 = ok0Var.h;
        if (wfVar != wfVar3) {
            return jMin;
        }
        long j2 = j - ok0Var.j();
        return Math.min(Math.min(jMin, a(wfVar4, j2)), j2 - ((long) wfVar4.f));
    }

    public static long b(wf wfVar, long j) {
        ok0 ok0Var = wfVar.d;
        ArrayList arrayList = wfVar.k;
        if (ok0Var instanceof mq) {
            return j;
        }
        int size = arrayList.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            uf ufVar = (uf) arrayList.get(i);
            if (ufVar instanceof wf) {
                wf wfVar2 = (wf) ufVar;
                if (wfVar2.d != ok0Var) {
                    jMax = Math.max(jMax, b(wfVar2, ((long) wfVar2.f) + j));
                }
            }
        }
        wf wfVar3 = ok0Var.h;
        wf wfVar4 = ok0Var.i;
        if (wfVar != wfVar3) {
            return jMax;
        }
        long j2 = ok0Var.j() + j;
        return Math.max(Math.max(jMax, b(wfVar4, j2)), j2 - ((long) wfVar4.f));
    }
}
