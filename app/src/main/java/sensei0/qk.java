package sensei0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qk implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
    public final Activity a;

    public qk(Activity activity) {
        this.a = activity;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void c(tt ttVar) {
        onActivityDestroyed(this.a);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.a != activity || activity.getApplicationContext() == null) {
            return;
        }
        ((Application) activity.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void a(tt ttVar) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void b(tt ttVar) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void d(tt ttVar) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void e(tt ttVar) {
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void g(tt ttVar) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
