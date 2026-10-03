package sensei0;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class et implements sp, Serializable {
    public final int a;

    public et(int i) {
        this.a = i;
    }

    @Override // sensei0.sp
    public final int b() {
        return this.a;
    }

    public final String toString() {
        y40.a.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            string = string.substring(21);
        }
        pr.i("renderLambdaToString(...)", string);
        return string;
    }
}
