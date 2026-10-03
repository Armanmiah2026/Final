package sensei0;

import android.util.Log;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ck extends k6 {
    public final Object j;
    public final String k;
    public final int l;
    public final bm0 m;

    public ck(Object obj, String str, mh mhVar, int i) {
        Collection collectionAsList;
        pr.j("value", obj);
        za0.p(i, "verificationMode");
        this.j = obj;
        this.k = str;
        this.l = i;
        String strM = k6.m(str, obj);
        pr.j("message", strM);
        bm0 bm0Var = new bm0(strM);
        StackTraceElement[] stackTrace = bm0Var.getStackTrace();
        pr.i("stackTrace", stackTrace);
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        if (length < 0) {
            throw new IllegalArgumentException(za0.i(length, "Requested element count ", " is less than zero.").toString());
        }
        if (length == 0) {
            collectionAsList = qi.a;
        } else {
            int length2 = stackTrace.length;
            if (length >= length2) {
                collectionAsList = c5.c0(stackTrace);
            } else if (length == 1) {
                collectionAsList = k6.G(stackTrace[length2 - 1]);
            } else {
                xe.f(length2, stackTrace.length);
                Object[] objArrCopyOfRange = Arrays.copyOfRange(stackTrace, length2 - length, length2);
                pr.i("copyOfRange(...)", objArrCopyOfRange);
                collectionAsList = Arrays.asList(objArrCopyOfRange);
                pr.i("asList(...)", collectionAsList);
            }
        }
        bm0Var.setStackTrace((StackTraceElement[]) collectionAsList.toArray(new StackTraceElement[0]));
        this.m = bm0Var;
    }

    @Override // sensei0.k6
    public final Object i() throws bm0 {
        int iU = za0.u(this.l);
        if (iU == 0) {
            throw this.m;
        }
        if (iU != 1) {
            if (iU == 2) {
                return null;
            }
            throw new ia();
        }
        String strM = k6.m(this.k, this.j);
        pr.j("message", strM);
        Log.d("da0", strM);
        return null;
    }

    @Override // sensei0.k6
    public final k6 S(String str, fp fpVar) {
        return this;
    }
}
