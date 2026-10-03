package sensei0;

import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class dy implements kb, Consumer {
    public final Context a;
    public wl0 c;
    public final ReentrantLock b = new ReentrantLock();
    public final LinkedHashSet d = new LinkedHashSet();

    public dy(Context context) {
        this.a = context;
    }

    @Override // sensei0.kb
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(WindowLayoutInfo windowLayoutInfo) {
        pr.j("value", windowLayoutInfo);
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            this.c = zj.b(this.a, windowLayoutInfo);
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((kb) it.next()).accept(this.c);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(jn jnVar) {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            wl0 wl0Var = this.c;
            if (wl0Var != null) {
                jnVar.accept(wl0Var);
            }
            this.d.add(jnVar);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
