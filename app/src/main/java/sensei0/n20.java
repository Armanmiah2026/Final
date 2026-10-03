package sensei0;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class n20 extends ni {
    final /* synthetic */ o20 this$0;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static final class a extends ni {
        final /* synthetic */ o20 this$0;

        public a(o20 o20Var) {
            this.this$0 = o20Var;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            pr.j("activity", activity);
            this.this$0.c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            pr.j("activity", activity);
            o20 o20Var = this.this$0;
            int i = o20Var.a + 1;
            o20Var.a = i;
            if (i == 1 && o20Var.d) {
                o20Var.h.e(lt.ON_START);
                o20Var.d = false;
            }
        }
    }

    public n20(o20 o20Var) {
        this.this$0 = o20Var;
    }

    @Override // sensei0.ni, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        pr.j("activity", activity);
        if (Build.VERSION.SDK_INT < 29) {
            int i = i50.b;
            Fragment fragmentFindFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            pr.g("null cannot be cast to non-null type androidx.lifecycle.ReportFragment", fragmentFindFragmentByTag);
            ((i50) fragmentFindFragmentByTag).a = this.this$0.p;
        }
    }

    @Override // sensei0.ni, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        pr.j("activity", activity);
        o20 o20Var = this.this$0;
        int i = o20Var.b - 1;
        o20Var.b = i;
        if (i == 0) {
            Handler handler = o20Var.f;
            pr.f(handler);
            handler.postDelayed(o20Var.o, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        pr.j("activity", activity);
        m20.a(activity, new a(this.this$0));
    }

    @Override // sensei0.ni, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        pr.j("activity", activity);
        o20 o20Var = this.this$0;
        int i = o20Var.a - 1;
        o20Var.a = i;
        if (i == 0 && o20Var.c) {
            o20Var.h.e(lt.ON_STOP);
            o20Var.d = true;
        }
    }
}
