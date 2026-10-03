package sensei0;

import android.view.View;
import android.view.Window;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class sl0 extends ui0 {
    public final Window d;

    public sl0(Window window, mz mzVar) {
        this.d = window;
    }

    @Override // sensei0.ui0
    public final void c(boolean z) {
        if (!z) {
            f(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            return;
        }
        Window window = this.d;
        window.clearFlags(67108864);
        window.addFlags(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(8192 | decorView.getSystemUiVisibility());
    }

    public final void f(int i) {
        View decorView = this.d.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
