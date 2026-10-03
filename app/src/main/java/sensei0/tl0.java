package sensei0;

import android.view.View;
import android.view.Window;
import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class tl0 extends sl0 {
    @Override // sensei0.ui0
    public final void b(boolean z) {
        if (!z) {
            f(16);
            return;
        }
        Window window = this.d;
        window.clearFlags(134217728);
        window.addFlags(AttribFlags.SSH_FILEXFER_ATTR_EXTENDED);
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(16 | decorView.getSystemUiVisibility());
    }
}
