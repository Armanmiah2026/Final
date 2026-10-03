package io.flutter.plugin.platform;

import android.app.Presentation;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import sensei0.e10;
import sensei0.pa0;
import sensei0.q0;
import sensei0.qa0;
import sensei0.qs;
import sensei0.ra0;
import sensei0.sa0;
import sensei0.ta0;
import sensei0.xl0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@qs
class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final q0 accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private qa0 rootView;
    private boolean startFocused;
    private final ta0 state;
    private int viewId;

    public SingleViewPresentation(Context context, Display display, e10 e10Var, q0 q0Var, int i, View.OnFocusChangeListener onFocusChangeListener) {
        super(new ra0(context, null), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = q0Var;
        this.viewId = i;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        ta0 ta0Var = new ta0();
        this.state = ta0Var;
        ta0Var.a = e10Var;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public ta0 detachState() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        qa0 qa0Var = this.rootView;
        if (qa0Var != null) {
            qa0Var.removeAllViews();
        }
        return this.state;
    }

    public e10 getView() {
        return this.state.a;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ta0 ta0Var = this.state;
        if (ta0Var.c == null) {
            ta0Var.c = new pa0(getContext());
        }
        if (this.state.b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            ta0 ta0Var2 = this.state;
            ta0Var2.b = new xl0(windowManager, ta0Var2.c);
        }
        this.container = new FrameLayout(getContext());
        sa0 sa0Var = new sa0(getContext(), this.state.b, this.outerContext);
        View view = this.state.a.getView();
        if (view.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) view.getContext()).setBaseContext(sa0Var);
        } else {
            Log.w(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(view);
        qa0 qa0Var = new qa0(getContext(), this.accessibilityEventsDelegate, view);
        this.rootView = qa0Var;
        qa0Var.addView(this.container);
        this.rootView.addView(this.state.c);
        view.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }

    public SingleViewPresentation(Context context, Display display, q0 q0Var, ta0 ta0Var, View.OnFocusChangeListener onFocusChangeListener, boolean z) {
        super(new ra0(context, null), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = q0Var;
        this.state = ta0Var;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z;
    }
}
