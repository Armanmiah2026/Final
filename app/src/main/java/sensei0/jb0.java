package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jb0 {
    public static final /* synthetic */ int a = 0;

    static {
        Object objI;
        Object objI2;
        Exception exc = new Exception();
        String simpleName = mm0.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objI = l5.class.getCanonicalName();
        } catch (Throwable th) {
            objI = wf0.i(th);
        }
        if (v50.a(objI) != null) {
            objI = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objI2 = jb0.class.getCanonicalName();
        } catch (Throwable th2) {
            objI2 = wf0.i(th2);
        }
        if (v50.a(objI2) != null) {
            objI2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
