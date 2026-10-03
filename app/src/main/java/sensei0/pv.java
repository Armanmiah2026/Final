package sensei0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.sensei.tunnel.MainActivity;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pv implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ MainActivity a;
    public final /* synthetic */ AtomicBoolean b;

    public pv(MainActivity mainActivity, AtomicBoolean atomicBoolean) {
        this.a = mainActivity;
        this.b = atomicBoolean;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        pr.j("activity", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        pr.j("activity", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        pr.j("activity", activity);
        if (activity == this.a) {
            this.b.set(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        pr.j("activity", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        pr.j("activity", activity);
        pr.j("outState", bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        pr.j("activity", activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        pr.j("activity", activity);
    }
}
