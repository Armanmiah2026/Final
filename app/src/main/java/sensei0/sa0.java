package sensei0;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sa0 extends ContextWrapper {
    public final xl0 a;
    public xl0 b;
    public final Context c;

    public sa0(Context context, xl0 xl0Var, Context context2) {
        super(context);
        this.a = xl0Var;
        this.c = context2;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"window".equals(str)) {
            return super.getSystemService(str);
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length && i < 11; i++) {
            if (stackTrace[i].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i].getMethodName().equals("<init>")) {
                return this.c.getSystemService(str);
            }
        }
        if (this.b == null) {
            this.b = this.a;
        }
        return this.b;
    }
}
