package sensei0;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.trilead.ssh2.sftp.AttribFlags;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nb0 {
    public final ArrayList a = new ArrayList();
    public int b = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    public int c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
    public final int d;
    public final /* synthetic */ StaggeredGridLayoutManager e;

    public nb0(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.e = staggeredGridLayoutManager;
        this.d = i;
    }

    public final int a(int i) {
        int i2 = this.c;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.a.size() == 0) {
            return i;
        }
        View view = (View) this.a.get(r3.size() - 1);
        kb0 kb0Var = (kb0) view.getLayoutParams();
        this.c = this.e.j.b(view);
        kb0Var.getClass();
        return this.c;
    }
}
