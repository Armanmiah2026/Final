package sensei0;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class i50 extends Fragment {
    public static final /* synthetic */ int b = 0;
    public ws a;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final h50 Companion = new h50();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            pr.j("activity", activity);
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            pr.j("activity", activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            pr.j("activity", activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            pr.j("activity", activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            pr.j("activity", activity);
            int i = i50.b;
            g50.a(activity, lt.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            pr.j("activity", activity);
            int i = i50.b;
            g50.a(activity, lt.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            pr.j("activity", activity);
            int i = i50.b;
            g50.a(activity, lt.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            pr.j("activity", activity);
            int i = i50.b;
            g50.a(activity, lt.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            pr.j("activity", activity);
            int i = i50.b;
            g50.a(activity, lt.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            pr.j("activity", activity);
            int i = i50.b;
            g50.a(activity, lt.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            pr.j("activity", activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            pr.j("activity", activity);
            pr.j("bundle", bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            pr.j("activity", activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            pr.j("activity", activity);
        }
    }

    public final void a(lt ltVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            pr.i("activity", activity);
            g50.a(activity, ltVar);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(lt.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(lt.ON_DESTROY);
        this.a = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(lt.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        ws wsVar = this.a;
        if (wsVar != null) {
            ((o20) wsVar.b).c();
        }
        a(lt.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        ws wsVar = this.a;
        if (wsVar != null) {
            o20 o20Var = (o20) wsVar.b;
            int i = o20Var.a + 1;
            o20Var.a = i;
            if (i == 1 && o20Var.d) {
                o20Var.h.e(lt.ON_START);
                o20Var.d = false;
            }
        }
        a(lt.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(lt.ON_STOP);
    }
}
