package sensei0;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ul0 extends ui0 {
    public final WindowInsetsController d;
    public Window e;

    public ul0(WindowInsetsController windowInsetsController, mz mzVar) {
        this.d = windowInsetsController;
    }

    @Override // sensei0.ui0
    public final void b(boolean z) {
        Window window = this.e;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.d.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.d.setSystemBarsAppearance(0, 16);
    }

    @Override // sensei0.ui0
    public final void c(boolean z) {
        Window window = this.e;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            }
            this.d.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.d.setSystemBarsAppearance(0, 8);
    }
}
