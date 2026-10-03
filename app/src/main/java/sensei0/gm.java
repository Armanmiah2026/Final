package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gm {
    public final String a;
    public final String b;
    public final boolean c;

    public gm(int i, String str, String str2) {
        this(str, str2, "io.flutter.embedding.android.", false);
    }

    public gm(String str, String str2) {
        this(str, str2, "io.flutter.embedding.android.", true);
    }

    public gm(String str, String str2, String str3, boolean z) {
        this.a = str;
        this.b = str3.concat(str2);
        this.c = z;
    }
}
