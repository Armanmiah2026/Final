package sensei0;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import sensei0.i50;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pt extends ni {
    @Override // sensei0.ni, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        pr.j("activity", activity);
        int i = i50.b;
        if (Build.VERSION.SDK_INT >= 29) {
            i50.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new i50.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new i50(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
