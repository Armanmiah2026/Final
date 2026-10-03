package sensei0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mf0 implements Cloneable {
    public static final Animator[] G = new Animator[0];
    public static final int[] H = {2, 1, 3, 4};
    public static final mz I = new mz(19);
    public static final ThreadLocal J = new ThreadLocal();
    public long E;
    public long F;
    public ArrayList s;
    public ArrayList t;
    public jf0[] u;
    public final String a = getClass().getName();
    public long b = -1;
    public long c = -1;
    public TimeInterpolator d = null;
    public final ArrayList f = new ArrayList();
    public final ArrayList h = new ArrayList();
    public j1 o = new j1(11);
    public j1 p = new j1(11);
    public g5 q = null;
    public final int[] r = H;
    public final ArrayList v = new ArrayList();
    public Animator[] w = G;
    public int x = 0;
    public boolean y = false;
    public boolean z = false;
    public mf0 A = null;
    public ArrayList B = null;
    public ArrayList C = new ArrayList();
    public mz D = I;

    public static void b(j1 j1Var, View view, uf0 uf0Var) {
        y4 y4Var = (y4) j1Var.a;
        y4 y4Var2 = (y4) j1Var.d;
        SparseArray sparseArray = (SparseArray) j1Var.b;
        cv cvVar = (cv) j1Var.c;
        y4Var.put(view, uf0Var);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        Field field = ai0.a;
        String strF = th0.f(view);
        if (strF != null) {
            if (y4Var2.containsKey(strF)) {
                y4Var2.put(strF, null);
            } else {
                y4Var2.put(strF, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (cvVar.a) {
                    int i = cvVar.d;
                    long[] jArr = cvVar.b;
                    Object[] objArr = cvVar.c;
                    int i2 = 0;
                    for (int i3 = 0; i3 < i; i3++) {
                        Object obj = objArr[i3];
                        if (obj != wf0.c) {
                            if (i3 != i2) {
                                jArr[i2] = jArr[i3];
                                objArr[i2] = obj;
                                objArr[i3] = null;
                            }
                            i2++;
                        }
                    }
                    cvVar.a = false;
                    cvVar.d = i2;
                }
                if (xe.e(cvVar.b, cvVar.d, itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    cvVar.d(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) cvVar.b(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    cvVar.d(itemIdAtPosition, null);
                }
            }
        }
    }

    public static y4 p() {
        ThreadLocal threadLocal = J;
        y4 y4Var = (y4) threadLocal.get();
        if (y4Var != null) {
            return y4Var;
        }
        y4 y4Var2 = new y4(0);
        threadLocal.set(y4Var2);
        return y4Var2;
    }

    public static boolean v(uf0 uf0Var, uf0 uf0Var2, String str) {
        Object obj = uf0Var.a.get(str);
        Object obj2 = uf0Var2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(View view) {
        if (this.y) {
            if (!this.z) {
                ArrayList arrayList = this.v;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.w);
                this.w = G;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.w = animatorArr;
                w(this, lf0.m, false);
            }
            this.y = false;
        }
    }

    public void B() {
        J();
        y4 y4VarP = p();
        ArrayList arrayList = this.C;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Animator animator = (Animator) obj;
            if (y4VarP.containsKey(animator)) {
                J();
                if (animator != null) {
                    animator.addListener(new ff0(this, y4VarP));
                    long j = this.c;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.b;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.d;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new v1(3, this));
                    animator.start();
                }
            }
        }
        this.C.clear();
        m();
    }

    public void C(long j, long j2) {
        long j3 = this.E;
        int i = 0;
        boolean z = j < j2;
        if ((j2 < 0 && j >= 0) || (j2 > j3 && j <= j3)) {
            this.z = false;
            w(this, lf0.i, z);
        }
        ArrayList arrayList = this.v;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.w);
        this.w = G;
        while (i < size) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            hf0.b(animator, Math.min(Math.max(0L, j), hf0.a(animator)));
            i++;
            j3 = j3;
        }
        long j4 = j3;
        this.w = animatorArr;
        if ((j <= j4 || j2 > j4) && (j >= 0 || j2 < 0)) {
            return;
        }
        if (j > j4) {
            this.z = true;
        }
        w(this, lf0.j, z);
    }

    public void D(long j) {
        this.c = j;
    }

    public void F(TimeInterpolator timeInterpolator) {
        this.d = timeInterpolator;
    }

    public void G(mz mzVar) {
        if (mzVar == null) {
            this.D = I;
        } else {
            this.D = mzVar;
        }
    }

    public void I(long j) {
        this.b = j;
    }

    public final void J() {
        if (this.x == 0) {
            w(this, lf0.i, false);
            this.z = false;
        }
        this.x++;
    }

    public String K(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.c != -1) {
            sb.append("dur(");
            sb.append(this.c);
            sb.append(") ");
        }
        if (this.b != -1) {
            sb.append("dly(");
            sb.append(this.b);
            sb.append(") ");
        }
        if (this.d != null) {
            sb.append("interp(");
            sb.append(this.d);
            sb.append(") ");
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.h;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void a(jf0 jf0Var) {
        if (this.B == null) {
            this.B = new ArrayList();
        }
        this.B.add(jf0Var);
    }

    public void c() {
        ArrayList arrayList = this.v;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.w);
        this.w = G;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.w = animatorArr;
        w(this, lf0.k, false);
    }

    public abstract void d(uf0 uf0Var);

    public final void e(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            uf0 uf0Var = new uf0(view);
            if (z) {
                g(uf0Var);
            } else {
                d(uf0Var);
            }
            uf0Var.c.add(this);
            f(uf0Var);
            if (z) {
                b(this.o, view, uf0Var);
            } else {
                b(this.p, view, uf0Var);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                e(viewGroup.getChildAt(i), z);
            }
        }
    }

    public abstract void g(uf0 uf0Var);

    public final void h(ViewGroup viewGroup, boolean z) {
        i(z);
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.h;
        if (size <= 0 && arrayList2.size() <= 0) {
            e(viewGroup, z);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (viewFindViewById != null) {
                uf0 uf0Var = new uf0(viewFindViewById);
                if (z) {
                    g(uf0Var);
                } else {
                    d(uf0Var);
                }
                uf0Var.c.add(this);
                f(uf0Var);
                if (z) {
                    b(this.o, viewFindViewById, uf0Var);
                } else {
                    b(this.p, viewFindViewById, uf0Var);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            View view = (View) arrayList2.get(i2);
            uf0 uf0Var2 = new uf0(view);
            if (z) {
                g(uf0Var2);
            } else {
                d(uf0Var2);
            }
            uf0Var2.c.add(this);
            f(uf0Var2);
            if (z) {
                b(this.o, view, uf0Var2);
            } else {
                b(this.p, view, uf0Var2);
            }
        }
    }

    public final void i(boolean z) {
        if (z) {
            ((y4) this.o.a).clear();
            ((SparseArray) this.o.b).clear();
            ((cv) this.o.c).a();
        } else {
            ((y4) this.p.a).clear();
            ((SparseArray) this.p.b).clear();
            ((cv) this.p.c).a();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public mf0 clone() {
        try {
            mf0 mf0Var = (mf0) super.clone();
            mf0Var.C = new ArrayList();
            mf0Var.o = new j1(11);
            mf0Var.p = new j1(11);
            mf0Var.s = null;
            mf0Var.t = null;
            mf0Var.A = this;
            mf0Var.B = null;
            return mf0Var;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Animator k(ViewGroup viewGroup, uf0 uf0Var, uf0 uf0Var2) {
        return null;
    }

    public void l(ViewGroup viewGroup, j1 j1Var, j1 j1Var2, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int i2;
        View view;
        uf0 uf0Var;
        Animator animator;
        uf0 uf0Var2;
        y4 y4VarP = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        o().getClass();
        int i3 = 0;
        while (i3 < size) {
            uf0 uf0Var3 = (uf0) arrayList.get(i3);
            uf0 uf0Var4 = (uf0) arrayList2.get(i3);
            if (uf0Var3 != null && !uf0Var3.c.contains(this)) {
                uf0Var3 = null;
            }
            if (uf0Var4 != null && !uf0Var4.c.contains(this)) {
                uf0Var4 = null;
            }
            if ((uf0Var3 != null || uf0Var4 != null) && (uf0Var3 == null || uf0Var4 == null || t(uf0Var3, uf0Var4))) {
                Animator animatorK = k(viewGroup, uf0Var3, uf0Var4);
                if (animatorK != null) {
                    String str = this.a;
                    if (uf0Var4 != null) {
                        view = uf0Var4.b;
                        String[] strArrQ = q();
                        if (strArrQ != null && strArrQ.length > 0) {
                            uf0Var2 = new uf0(view);
                            uf0 uf0Var5 = (uf0) ((y4) j1Var2.a).get(view);
                            i = size;
                            if (uf0Var5 != null) {
                                int i4 = 0;
                                while (i4 < strArrQ.length) {
                                    String str2 = strArrQ[i4];
                                    int i5 = i3;
                                    uf0Var2.a.put(str2, uf0Var5.a.get(str2));
                                    i4++;
                                    i3 = i5;
                                    uf0Var5 = uf0Var5;
                                }
                            }
                            i2 = i3;
                            int i6 = y4VarP.c;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    animator = animatorK;
                                    break;
                                }
                                gf0 gf0Var = (gf0) y4VarP.get((Animator) y4VarP.f(i7));
                                if (gf0Var.c != null && gf0Var.a == view && gf0Var.b.equals(str) && gf0Var.c.equals(uf0Var2)) {
                                    animator = null;
                                    break;
                                }
                                i7++;
                            }
                        } else {
                            i = size;
                            i2 = i3;
                            animator = animatorK;
                            uf0Var2 = null;
                        }
                        animatorK = animator;
                        uf0Var = uf0Var2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = uf0Var3.b;
                        uf0Var = null;
                    }
                    if (animatorK != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        gf0 gf0Var2 = new gf0();
                        gf0Var2.a = view;
                        gf0Var2.b = str;
                        gf0Var2.c = uf0Var;
                        gf0Var2.d = windowId;
                        gf0Var2.e = this;
                        gf0Var2.f = animatorK;
                        y4VarP.put(animatorK, gf0Var2);
                        this.C.add(animatorK);
                    }
                }
                i3 = i2 + 1;
                size = i;
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                gf0 gf0Var3 = (gf0) y4VarP.get((Animator) this.C.get(sparseIntArray.keyAt(i8)));
                gf0Var3.f.setStartDelay(gf0Var3.f.getStartDelay() + (((long) sparseIntArray.valueAt(i8)) - Long.MAX_VALUE));
            }
        }
    }

    public final void m() {
        int i = this.x - 1;
        this.x = i;
        if (i == 0) {
            w(this, lf0.j, false);
            for (int i2 = 0; i2 < ((cv) this.o.c).e(); i2++) {
                View view = (View) ((cv) this.o.c).f(i2);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < ((cv) this.p.c).e(); i3++) {
                View view2 = (View) ((cv) this.p.c).f(i3);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.z = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (r2 < 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        r5 = r4.t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r5 = r4.s;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003b, code lost:
    
        return (sensei0.uf0) r5.get(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sensei0.uf0 n(android.view.View r5, boolean r6) {
        /*
            r4 = this;
            sensei0.g5 r0 = r4.q
            if (r0 == 0) goto L9
            sensei0.uf0 r5 = r0.n(r5, r6)
            return r5
        L9:
            if (r6 == 0) goto Le
            java.util.ArrayList r0 = r4.s
            goto L10
        Le:
            java.util.ArrayList r0 = r4.t
        L10:
            if (r0 != 0) goto L13
            goto L3c
        L13:
            int r1 = r0.size()
            r2 = 0
        L18:
            if (r2 >= r1) goto L2b
            java.lang.Object r3 = r0.get(r2)
            sensei0.uf0 r3 = (sensei0.uf0) r3
            if (r3 != 0) goto L23
            goto L3c
        L23:
            android.view.View r3 = r3.b
            if (r3 != r5) goto L28
            goto L2c
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            r2 = -1
        L2c:
            if (r2 < 0) goto L3c
            if (r6 == 0) goto L33
            java.util.ArrayList r5 = r4.t
            goto L35
        L33:
            java.util.ArrayList r5 = r4.s
        L35:
            java.lang.Object r5 = r5.get(r2)
            sensei0.uf0 r5 = (sensei0.uf0) r5
            return r5
        L3c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.mf0.n(android.view.View, boolean):sensei0.uf0");
    }

    public final mf0 o() {
        g5 g5Var = this.q;
        return g5Var != null ? g5Var.o() : this;
    }

    public String[] q() {
        return null;
    }

    public final uf0 r(View view, boolean z) {
        g5 g5Var = this.q;
        if (g5Var != null) {
            return g5Var.r(view, z);
        }
        return (uf0) ((y4) (z ? this.o : this.p).a).get(view);
    }

    public boolean s() {
        return !this.v.isEmpty();
    }

    public boolean t(uf0 uf0Var, uf0 uf0Var2) {
        if (uf0Var != null && uf0Var2 != null) {
            String[] strArrQ = q();
            if (strArrQ != null) {
                for (String str : strArrQ) {
                    if (v(uf0Var, uf0Var2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = uf0Var.a.keySet().iterator();
                while (it.hasNext()) {
                    if (v(uf0Var, uf0Var2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final String toString() {
        return K("");
    }

    public final boolean u(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        ArrayList arrayList2 = this.h;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    public final void w(mf0 mf0Var, lf0 lf0Var, boolean z) {
        mf0 mf0Var2 = this.A;
        if (mf0Var2 != null) {
            mf0Var2.w(mf0Var, lf0Var, z);
        }
        ArrayList arrayList = this.B;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.B.size();
        jf0[] jf0VarArr = this.u;
        if (jf0VarArr == null) {
            jf0VarArr = new jf0[size];
        }
        this.u = null;
        jf0[] jf0VarArr2 = (jf0[]) this.B.toArray(jf0VarArr);
        for (int i = 0; i < size; i++) {
            lf0Var.a(jf0VarArr2[i], mf0Var, z);
            jf0VarArr2[i] = null;
        }
        this.u = jf0VarArr2;
    }

    public void x(View view) {
        if (this.z) {
            return;
        }
        ArrayList arrayList = this.v;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.w);
        this.w = G;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.w = animatorArr;
        w(this, lf0.l, false);
        this.y = true;
    }

    public void y() {
        y4 y4VarP = p();
        this.E = 0L;
        for (int i = 0; i < this.C.size(); i++) {
            Animator animator = (Animator) this.C.get(i);
            gf0 gf0Var = (gf0) y4VarP.get(animator);
            if (animator != null && gf0Var != null) {
                Animator animator2 = gf0Var.f;
                long j = this.c;
                if (j >= 0) {
                    animator2.setDuration(j);
                }
                long j2 = this.b;
                if (j2 >= 0) {
                    animator2.setStartDelay(animator2.getStartDelay() + j2);
                }
                TimeInterpolator timeInterpolator = this.d;
                if (timeInterpolator != null) {
                    animator2.setInterpolator(timeInterpolator);
                }
                this.v.add(animator);
                this.E = Math.max(this.E, hf0.a(animator));
            }
        }
        this.C.clear();
    }

    public mf0 z(jf0 jf0Var) {
        mf0 mf0Var;
        ArrayList arrayList = this.B;
        if (arrayList != null) {
            if (!arrayList.remove(jf0Var) && (mf0Var = this.A) != null) {
                mf0Var.z(jf0Var);
            }
            if (this.B.size() == 0) {
                this.B = null;
            }
        }
        return this;
    }

    public void E(k6 k6Var) {
    }

    public void f(uf0 uf0Var) {
    }

    public void H() {
    }
}
