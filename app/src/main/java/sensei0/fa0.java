package sensei0;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fa0 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final Object c;

    public fa0(View view, io.flutter.plugin.platform.a aVar) {
        this.b = view;
        this.c = aVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Window window;
        WindowManager.LayoutParams attributes;
        switch (this.a) {
            case 0:
                pr.j("view", view);
                view.removeOnAttachStateChangeListener(this);
                Activity activity = (Activity) ((WeakReference) this.c).get();
                IBinder iBinder = (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                if (activity != null && iBinder != null) {
                    ((ga0) this.b).c(iBinder, activity);
                }
                break;
            default:
                View view2 = (View) this.b;
                view2.getViewTreeObserver().addOnDrawListener(new dj0(view2, new f5(15, this)));
                view2.removeOnAttachStateChangeListener(this);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.a) {
            case 0:
                pr.j("view", view);
                break;
        }
    }

    public fa0(ga0 ga0Var, Activity activity) {
        pr.j("sidecarCompat", ga0Var);
        this.b = ga0Var;
        this.c = new WeakReference(activity);
    }

    private final void a(View view) {
    }
}
