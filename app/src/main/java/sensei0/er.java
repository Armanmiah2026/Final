package sensei0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class er implements fr {
    public final InputContentInfo a;

    public er(Object obj) {
        this.a = (InputContentInfo) obj;
    }

    @Override // sensei0.fr
    public final Object g() {
        return this.a;
    }

    @Override // sensei0.fr
    public final ClipDescription getDescription() {
        return this.a.getDescription();
    }

    @Override // sensei0.fr
    public final Uri h() {
        return this.a.getContentUri();
    }

    @Override // sensei0.fr
    public final void m() {
        this.a.requestPermission();
    }

    @Override // sensei0.fr
    public final Uri n() {
        return this.a.getLinkUri();
    }

    public er(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.a = new InputContentInfo(uri, clipDescription, uri2);
    }
}
