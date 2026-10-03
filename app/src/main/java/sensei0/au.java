package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class au {
    public final /* synthetic */ int a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    public au(int i) {
        this.a = i;
        switch (i) {
            case 1:
                break;
            default:
                this.b = -1;
                this.c = AttribFlags.SSH_FILEXFER_ATTR_EXTENDED;
                this.d = false;
                this.e = false;
                break;
        }
    }

    public String toString() {
        switch (this.a) {
            case 0:
                return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
            default:
                return super.toString();
        }
    }
}
