package sensei0;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ro {
    public final ArrayList a = new ArrayList();
    public final so b;
    public ArrayList c;
    public final AtomicInteger d;
    public final Map e;
    public final Map f;
    public final Map g;
    public final int h;

    public ro() {
        so soVar = new so();
        soVar.a = new ArrayList();
        new HashMap();
        new HashMap();
        this.b = soVar;
        new ArrayList();
        new pf(this, 15);
        this.d = new AtomicInteger();
        this.e = Collections.synchronizedMap(new HashMap());
        this.f = Collections.synchronizedMap(new HashMap());
        this.g = Collections.synchronizedMap(new HashMap());
        new ArrayList();
        new pf(this, 14);
        new CopyOnWriteArrayList();
        final int i = 0;
        new kb(this) { // from class: sensei0.no
            public final /* synthetic */ ro b;

            {
                this.b = this;
            }

            @Override // sensei0.kb
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.b.a(false);
                        break;
                    default:
                        if (((Integer) obj).intValue() == 80) {
                            this.b.c(false);
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        new kb(this) { // from class: sensei0.no
            public final /* synthetic */ ro b;

            {
                this.b = this;
            }

            @Override // sensei0.kb
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.b.a(false);
                        break;
                    default:
                        if (((Integer) obj).intValue() == 80) {
                            this.b.c(false);
                        }
                        break;
                }
            }
        };
        final int i3 = 0;
        new kb(this) { // from class: sensei0.oo
            @Override // sensei0.kb
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    default:
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                }
            }
        };
        final int i4 = 1;
        new kb(this) { // from class: sensei0.oo
            @Override // sensei0.kb
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    default:
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                }
            }
        };
        this.h = -1;
        new ArrayDeque();
        new f5(7, this);
    }

    public static boolean f(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean g(mo moVar) {
        return moVar == null || moVar.d;
    }

    public final void a(boolean z) {
        for (mo moVar : this.b.a()) {
            if (moVar != null && z) {
                moVar.c.a(true);
            }
        }
    }

    public final boolean b() {
        if (this.h < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (mo moVar : this.b.a()) {
            if (moVar != null && g(moVar) && moVar.c.b()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(moVar);
                z = true;
            }
        }
        if (this.c != null) {
            for (int i = 0; i < this.c.size(); i++) {
                mo moVar2 = (mo) this.c.get(i);
                if (arrayList == null || !arrayList.contains(moVar2)) {
                    moVar2.getClass();
                }
            }
        }
        this.c = arrayList;
        return z;
    }

    public final void c(boolean z) {
        for (mo moVar : this.b.a()) {
            if (moVar != null && z) {
                moVar.c.c(true);
            }
        }
    }

    public final boolean d() {
        if (this.h < 1) {
            return false;
        }
        for (mo moVar : this.b.a()) {
            if (moVar != null && moVar.c.d()) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        boolean z = false;
        if (this.h < 1) {
            return false;
        }
        for (mo moVar : this.b.a()) {
            if (moVar != null && g(moVar) && moVar.c.e()) {
                z = true;
            }
        }
        return z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        sb.append("null");
        sb.append("}}");
        return sb.toString();
    }
}
