package sensei0;

import android.view.View;
import io.flutter.plugin.platform.c;
import io.flutter.plugin.editing.b;

/**
 * Reconstructed by replacing a JADX-lost anonymous View.OnFocusChangeListener.
 * mode=0 handles focus loss/gain for the embedded Android platform view.
 * mode=1 reports focus gain to Flutter.
 */
public final class n10 implements View.OnFocusChangeListener {
    private final c controller;
    private final f10 request;
    private final int mode;

    public n10(c controller, f10 request, int mode) {
        this.controller = controller;
        this.request = request;
        this.mode = mode;
    }

    @Override
    public void onFocusChange(View view, boolean focused) {
        int viewId = request.a;
        if (mode == 0) {
            if (!focused) {
                b editing = controller.o;
                if (editing != null) editing.b(viewId);
            } else {
                aj channel = (aj) controller.p.b;
                if (channel != null) channel.a("viewFocused", Integer.valueOf(viewId), null);
            }
        } else if (focused) {
            i3 registry = controller.p;
            aj channel = (aj) registry.b;
            if (channel != null) channel.a("viewFocused", Integer.valueOf(viewId), null);
        }
    }
}
