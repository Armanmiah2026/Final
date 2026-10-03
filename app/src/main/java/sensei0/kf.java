package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class kf extends d40 {
    public boolean g;
    public ArrayList h;
    public ArrayList i;
    public ArrayList j;
    public ArrayList k;
    public ArrayList l;
    public ArrayList m;
    public ArrayList n;
    public ArrayList o;
    public ArrayList p;
    public ArrayList q;
    public ArrayList r;

    public static void e(ArrayList arrayList) {
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        ((s40) arrayList.get(size)).getClass();
        throw null;
    }

    @Override // sensei0.d40
    public final void b(s40 s40Var) {
        s40Var.getClass();
        throw null;
    }

    @Override // sensei0.d40
    public final void c() {
        ArrayList arrayList = this.n;
        ArrayList arrayList2 = this.l;
        ArrayList arrayList3 = this.m;
        ArrayList arrayList4 = this.k;
        ArrayList arrayList5 = this.i;
        ArrayList arrayList6 = this.h;
        ArrayList arrayList7 = this.j;
        int size = arrayList7.size() - 1;
        if (size >= 0) {
            ((jf) arrayList7.get(size)).getClass();
            throw null;
        }
        for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
            a((s40) arrayList6.get(size2));
            arrayList6.remove(size2);
        }
        int size3 = arrayList5.size() - 1;
        if (size3 >= 0) {
            ((s40) arrayList5.get(size3)).getClass();
            throw null;
        }
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            ((hf) arrayList4.get(size4)).getClass();
        }
        arrayList4.clear();
        if (d()) {
            for (int size5 = arrayList3.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList8 = (ArrayList) arrayList3.get(size5);
                int size6 = arrayList8.size() - 1;
                if (size6 >= 0) {
                    ((jf) arrayList8.get(size6)).getClass();
                    throw null;
                }
            }
            for (int size7 = arrayList2.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList9 = (ArrayList) arrayList2.get(size7);
                int size8 = arrayList9.size() - 1;
                if (size8 >= 0) {
                    ((s40) arrayList9.get(size8)).getClass();
                    throw null;
                }
            }
            for (int size9 = arrayList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    ((hf) arrayList10.get(size10)).getClass();
                    if (arrayList10.isEmpty()) {
                        arrayList.remove(arrayList10);
                    }
                }
            }
            e(this.q);
            e(this.p);
            e(this.o);
            e(this.r);
            ArrayList arrayList11 = this.b;
            if (arrayList11.size() > 0) {
                arrayList11.get(0).getClass();
                throw new ClassCastException();
            }
            arrayList11.clear();
        }
    }

    @Override // sensei0.d40
    public final boolean d() {
        return (this.i.isEmpty() && this.k.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.p.isEmpty() && this.q.isEmpty() && this.o.isEmpty() && this.r.isEmpty() && this.m.isEmpty() && this.l.isEmpty() && this.n.isEmpty()) ? false : true;
    }

    public final void f() {
        if (d()) {
            return;
        }
        ArrayList arrayList = this.b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void g(ArrayList arrayList, s40 s40Var) {
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        ((hf) arrayList.get(size)).getClass();
        s40Var.getClass();
        throw null;
    }
}
