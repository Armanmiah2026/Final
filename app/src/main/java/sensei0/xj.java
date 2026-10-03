package sensei0;

import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xj implements pk0 {
    public final WindowLayoutComponent a;
    public final ReentrantLock b = new ReentrantLock();
    public final LinkedHashMap c = new LinkedHashMap();
    public final LinkedHashMap d = new LinkedHashMap();

    public xj(WindowLayoutComponent windowLayoutComponent) {
        this.a = windowLayoutComponent;
    }

    @Override // sensei0.pk0
    public final void a(Context context, t20 t20Var, jn jnVar) {
        mg0 mg0Var;
        LinkedHashMap linkedHashMap = this.c;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            dy dyVar = (dy) linkedHashMap.get(context);
            LinkedHashMap linkedHashMap2 = this.d;
            if (dyVar != null) {
                dyVar.b(jnVar);
                linkedHashMap2.put(jnVar, context);
                mg0Var = mg0.a;
            } else {
                mg0Var = null;
            }
            if (mg0Var == null) {
                dy dyVar2 = new dy(context);
                linkedHashMap.put(context, dyVar2);
                linkedHashMap2.put(jnVar, context);
                dyVar2.b(jnVar);
                this.a.addWindowLayoutInfoListener(context, dyVar2);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // sensei0.pk0
    public final void b(jn jnVar) {
        LinkedHashMap linkedHashMap = this.c;
        LinkedHashMap linkedHashMap2 = this.d;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            Context context = (Context) linkedHashMap2.get(jnVar);
            if (context == null) {
                return;
            }
            dy dyVar = (dy) linkedHashMap.get(context);
            if (dyVar == null) {
                return;
            }
            LinkedHashSet linkedHashSet = dyVar.d;
            ReentrantLock reentrantLock2 = dyVar.b;
            reentrantLock2.lock();
            try {
                linkedHashSet.remove(jnVar);
                reentrantLock2.unlock();
                linkedHashMap2.remove(jnVar);
                if (linkedHashSet.isEmpty()) {
                    linkedHashMap.remove(context);
                    this.a.removeWindowLayoutInfoListener(dyVar);
                }
            } catch (Throwable th) {
                reentrantLock2.unlock();
                throw th;
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
