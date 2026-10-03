package sensei0;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Window;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ia0 implements pk0 {
    public static volatile ia0 c;
    public static final ReentrantLock d = new ReentrantLock();
    public final pj a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();

    public ia0(ga0 ga0Var) {
        this.a = ga0Var;
        if (ga0Var != null) {
            ga0Var.d(new ws(28, this));
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // sensei0.pk0
    public final void a(Context context, t20 t20Var, jn jnVar) {
        Object next;
        WindowManager.LayoutParams attributes;
        mg0 mg0Var = null;
        iBinder = null;
        IBinder iBinder = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        qi qiVar = qi.a;
        if (activity != null) {
            ReentrantLock reentrantLock = d;
            reentrantLock.lock();
            try {
                pj pjVar = this.a;
                if (pjVar == null) {
                    jnVar.accept(new wl0(qiVar));
                    return;
                }
                CopyOnWriteArrayList copyOnWriteArrayList = this.b;
                boolean z = false;
                if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (((ha0) it.next()).a.equals(activity)) {
                            z = true;
                            break;
                        }
                    }
                }
                ha0 ha0Var = new ha0(activity, t20Var, jnVar);
                copyOnWriteArrayList.add(ha0Var);
                if (z) {
                    Iterator it2 = copyOnWriteArrayList.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it2.next();
                            if (activity.equals(((ha0) next).a)) {
                                break;
                            }
                        }
                    }
                    ha0 ha0Var2 = (ha0) next;
                    wl0 wl0Var = ha0Var2 != null ? ha0Var2.c : null;
                    if (wl0Var != null) {
                        ha0Var.c = wl0Var;
                        ha0Var.b.accept(wl0Var);
                    }
                } else {
                    ga0 ga0Var = (ga0) pjVar;
                    Window window = activity.getWindow();
                    if (window != null && (attributes = window.getAttributes()) != null) {
                        iBinder = attributes.token;
                    }
                    if (iBinder != null) {
                        ga0Var.c(iBinder, activity);
                    } else {
                        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new fa0(ga0Var, activity));
                    }
                }
                reentrantLock.unlock();
                mg0Var = mg0.a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (mg0Var == null) {
            jnVar.accept(new wl0(qiVar));
        }
    }

    @Override // sensei0.pk0
    public final void b(jn jnVar) {
        synchronized (d) {
            try {
                if (this.a == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (ha0 ha0Var : this.b) {
                    if (ha0Var.b == jnVar) {
                        arrayList.add(ha0Var);
                    }
                }
                this.b.removeAll(arrayList);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    Activity activity = ((ha0) obj).a;
                    CopyOnWriteArrayList copyOnWriteArrayList = this.b;
                    if (copyOnWriteArrayList == null || !copyOnWriteArrayList.isEmpty()) {
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            if (((ha0) it.next()).a.equals(activity)) {
                                break;
                            }
                        }
                    }
                    pj pjVar = this.a;
                    if (pjVar != null) {
                        ((ga0) pjVar).b(activity);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
