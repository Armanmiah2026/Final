package sensei0;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m20 {
    public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        pr.j("activity", activity);
        pr.j("callback", activityLifecycleCallbacks);
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
