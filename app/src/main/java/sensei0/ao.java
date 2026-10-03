package sensei0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ao implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ ao(String str, Context context, Object obj, int i, int i2) {
        this.a = i2;
        this.b = str;
        this.c = context;
        this.e = obj;
        this.d = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.a) {
            case 0:
                Object[] objArr = {(xn) this.e};
                ArrayList arrayList = new ArrayList(1);
                Object obj = objArr[0];
                Objects.requireNonNull(obj);
                arrayList.add(obj);
                return eo.b(this.b, this.c, Collections.unmodifiableList(arrayList), this.d);
            default:
                try {
                    return eo.b(this.b, this.c, (ArrayList) this.e, this.d);
                } catch (Throwable unused) {
                    return new co(-3);
                }
        }
    }
}
