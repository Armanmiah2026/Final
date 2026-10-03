package sensei0;

import android.hardware.display.DisplayManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jj0 {
    public static jj0 e;
    public static mg f;
    public final FlutterJNI b;
    public long a = -1;
    public ij0 c = new ij0(this, 0);
    public final fb0 d = new fb0(this);

    public jj0(FlutterJNI flutterJNI) {
        this.b = flutterJNI;
    }

    public static jj0 a(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (e == null) {
            e = new jj0(flutterJNI);
        }
        if (f == null) {
            jj0 jj0Var = e;
            Objects.requireNonNull(jj0Var);
            mg mgVar = new mg(jj0Var, displayManager, 1);
            f = mgVar;
            displayManager.registerDisplayListener(mgVar, null);
        }
        if (e.a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            e.a = (long) (1.0E9d / ((double) refreshRate));
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return e;
    }
}
