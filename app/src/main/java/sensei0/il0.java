package sensei0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class il0 extends hl0 {
    public il0(rl0 rl0Var, WindowInsets windowInsets) {
        super(rl0Var, windowInsets);
    }

    @Override // sensei0.ol0
    public rl0 a() {
        return rl0.d(null, this.c.consumeDisplayCutout());
    }

    @Override // sensei0.ol0
    public lg e() {
        DisplayCutout displayCutout = this.c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new lg(displayCutout);
    }

    @Override // sensei0.gl0, sensei0.ol0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof il0)) {
            return false;
        }
        il0 il0Var = (il0) obj;
        return Objects.equals(this.c, il0Var.c) && Objects.equals(this.g, il0Var.g) && gl0.A(this.h, il0Var.h);
    }

    @Override // sensei0.ol0
    public int hashCode() {
        return this.c.hashCode();
    }
}
