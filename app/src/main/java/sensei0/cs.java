package sensei0;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cs extends CancellationException {
    public final transient ls a;

    public cs(String str, Throwable th, ls lsVar) {
        super(str);
        this.a = lsVar;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cs)) {
            return false;
        }
        cs csVar = (cs) obj;
        return pr.b(csVar.getMessage(), getMessage()) && pr.b(csVar.a, this.a) && pr.b(csVar.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        pr.f(message);
        int iHashCode = (this.a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.a;
    }
}
