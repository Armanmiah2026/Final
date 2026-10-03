package sensei0;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e8 {
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        pr.i("forName(...)", charsetForName);
        a = charsetForName;
        pr.i("forName(...)", Charset.forName("UTF-16"));
        pr.i("forName(...)", Charset.forName("UTF-16BE"));
        pr.i("forName(...)", Charset.forName("UTF-16LE"));
        Charset charsetForName2 = Charset.forName("US-ASCII");
        pr.i("forName(...)", charsetForName2);
        b = charsetForName2;
        Charset charsetForName3 = Charset.forName("ISO-8859-1");
        pr.i("forName(...)", charsetForName3);
        c = charsetForName3;
    }
}
