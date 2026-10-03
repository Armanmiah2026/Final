package sensei0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c60 extends yb implements il {
    public final il d;
    public final lc f;
    public final int h;
    public lc o;
    public yb p;

    public c60(il ilVar, lc lcVar) {
        super(fa.c, oi.a);
        this.d = ilVar;
        this.f = lcVar;
        this.h = ((Number) lcVar.d(0, mc.f)).intValue();
    }

    @Override // sensei0.il
    public final Object d(Object obj, yb ybVar) {
        try {
            Object objP = p(ybVar, obj);
            return objP == vc.a ? objP : mg0.a;
        } catch (Throwable th) {
            this.o = new vg(th, ybVar.f());
            throw th;
        }
    }

    @Override // sensei0.l5, sensei0.wc
    public final wc e() {
        yb ybVar = this.p;
        if (ybVar != null) {
            return ybVar;
        }
        return null;
    }

    @Override // sensei0.yb, sensei0.xb
    public final lc f() {
        lc lcVar = this.o;
        return lcVar == null ? oi.a : lcVar;
    }

    @Override // sensei0.l5
    public final StackTraceElement k() {
        return null;
    }

    @Override // sensei0.l5
    public final Object n(Object obj) {
        Throwable thA = v50.a(obj);
        if (thA != null) {
            this.o = new vg(thA, f());
        }
        yb ybVar = this.p;
        if (ybVar != null) {
            ybVar.h(obj);
        }
        return vc.a;
    }

    public final Object p(yb ybVar, Object obj) {
        Comparable comparable;
        String strSubstring;
        lc lcVarF = ybVar.f();
        bs bsVar = (bs) lcVarF.n(mh.p);
        if (bsVar != null && !bsVar.a()) {
            throw ((ls) bsVar).z();
        }
        lc lcVar = this.o;
        if (lcVar != lcVarF) {
            int i = 0;
            if (lcVar instanceof vg) {
                String str = "\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + ((vg) lcVar).a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ";
                pr.j("<this>", str);
                List listO0 = fc0.o0(str);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : listO0) {
                    if (!fc0.l0((String) obj2)) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = new ArrayList(q9.h0(arrayList));
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj3 = arrayList.get(i2);
                    i2++;
                    String str2 = (String) obj3;
                    int length = str2.length();
                    int length2 = 0;
                    while (true) {
                        if (length2 >= length) {
                            length2 = -1;
                            break;
                        }
                        if (!pr.F(str2.charAt(length2))) {
                            break;
                        }
                        length2++;
                    }
                    if (length2 == -1) {
                        length2 = str2.length();
                    }
                    arrayList2.add(Integer.valueOf(length2));
                }
                Iterator it = arrayList2.iterator();
                if (it.hasNext()) {
                    comparable = (Comparable) it.next();
                    while (it.hasNext()) {
                        Comparable comparable2 = (Comparable) it.next();
                        if (comparable.compareTo(comparable2) > 0) {
                            comparable = comparable2;
                        }
                    }
                } else {
                    comparable = null;
                }
                Integer num = (Integer) comparable;
                int iIntValue = num != null ? num.intValue() : 0;
                int length3 = str.length();
                listO0.size();
                int size2 = listO0.size() - 1;
                ArrayList arrayList3 = new ArrayList();
                for (Object obj4 : listO0) {
                    int i3 = i + 1;
                    if (i < 0) {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                    String str3 = (String) obj4;
                    if ((i == 0 || i == size2) && fc0.l0(str3)) {
                        strSubstring = null;
                    } else {
                        pr.j("<this>", str3);
                        if (iIntValue < 0) {
                            throw new IllegalArgumentException(za0.i(iIntValue, "Requested character count ", " is less than zero.").toString());
                        }
                        int length4 = str3.length();
                        if (iIntValue <= length4) {
                            length4 = iIntValue;
                        }
                        strSubstring = str3.substring(length4);
                        pr.i("substring(...)", strSubstring);
                    }
                    if (strSubstring != null) {
                        arrayList3.add(strSubstring);
                    }
                    i = i3;
                }
                StringBuilder sb = new StringBuilder(length3);
                o9.l0(arrayList3, sb, "\n", "", "", "...", null);
                throw new IllegalStateException(sb.toString().toString());
            }
            if (((Number) lcVarF.d(0, new f60(this))).intValue() != this.h) {
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f + ",\n\t\tbut emission happened in " + lcVarF + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.o = lcVarF;
        }
        this.p = ybVar;
        kp kpVar = e60.a;
        il ilVar = this.d;
        pr.g("null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>", ilVar);
        Object objI = kpVar.i(ilVar, obj, this);
        if (!pr.b(objI, vc.a)) {
            this.p = null;
        }
        return objI;
    }
}
