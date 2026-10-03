package sensei0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class wf implements uf {
    public final ok0 d;
    public int f;
    public int g;
    public ok0 a = null;
    public boolean b = false;
    public boolean c = false;
    public int e = 1;
    public int h = 1;
    public gg i = null;
    public boolean j = false;
    public final ArrayList k = new ArrayList();
    public final ArrayList l = new ArrayList();

    public wf(ok0 ok0Var) {
        this.d = ok0Var;
    }

    @Override // sensei0.uf
    public final void a(uf ufVar) {
        ArrayList arrayList = this.l;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            if (!((wf) obj).j) {
                return;
            }
        }
        this.c = true;
        ok0 ok0Var = this.a;
        if (ok0Var != null) {
            ok0Var.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        int size2 = arrayList.size();
        wf wfVar = null;
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList.get(i3);
            i3++;
            wf wfVar2 = (wf) obj2;
            if (!(wfVar2 instanceof gg)) {
                i++;
                wfVar = wfVar2;
            }
        }
        if (wfVar != null && i == 1 && wfVar.j) {
            gg ggVar = this.i;
            if (ggVar != null) {
                if (!ggVar.j) {
                    return;
                } else {
                    this.f = this.h * ggVar.g;
                }
            }
            d(wfVar.g + this.f);
        }
        ok0 ok0Var2 = this.a;
        if (ok0Var2 != null) {
            ok0Var2.a(this);
        }
    }

    public final void b(ok0 ok0Var) {
        this.k.add(ok0Var);
        if (this.j) {
            ok0Var.a(ok0Var);
        }
    }

    public final void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            uf ufVar = (uf) obj;
            ufVar.a(ufVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.W);
        sb.append(":");
        switch (this.e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
