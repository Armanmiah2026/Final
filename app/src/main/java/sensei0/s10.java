package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class s10 {
    public final /* synthetic */ int a;
    public final Object[] b;
    public int c;

    public s10(int i) {
        this.a = 0;
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.b = new Object[i];
    }

    public Object a() {
        switch (this.a) {
            case 0:
                int i = this.c;
                if (i <= 0) {
                    return null;
                }
                int i2 = i - 1;
                Object[] objArr = this.b;
                Object obj = objArr[i2];
                pr.g("null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool", obj);
                objArr[i2] = null;
                this.c--;
                return obj;
            default:
                int i3 = this.c;
                if (i3 <= 0) {
                    return null;
                }
                int i4 = i3 - 1;
                Object[] objArr2 = this.b;
                Object obj2 = objArr2[i4];
                objArr2[i4] = null;
                this.c = i3 - 1;
                return obj2;
        }
    }

    public void b(a5 a5Var) {
        int i = this.c;
        Object[] objArr = this.b;
        if (i < objArr.length) {
            objArr[i] = a5Var;
            this.c = i + 1;
        }
    }

    public boolean c(Object obj) {
        Object[] objArr;
        boolean z;
        pr.j("instance", obj);
        int i = this.c;
        int i2 = 0;
        while (true) {
            objArr = this.b;
            if (i2 >= i) {
                z = false;
                break;
            }
            if (objArr[i2] == obj) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i3 = this.c;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.c = i3 + 1;
        return true;
    }

    public s10() {
        this.a = 1;
        this.b = new Object[256];
    }
}
