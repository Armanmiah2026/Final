package sensei0;

import android.content.Context;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nc extends et implements fp {
    public static final nc c;
    public static final nc d;
    public static final nc f;
    public static final nc h;
    public final /* synthetic */ int b;

    static {
        int i = 1;
        c = new nc(i, 0);
        d = new nc(i, 1);
        f = new nc(i, 2);
        h = new nc(i, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nc(int i, int i2) {
        super(i);
        this.b = i2;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        switch (this.b) {
            case 0:
                jc jcVar = (jc) obj;
                if (jcVar instanceof pc) {
                    return (pc) jcVar;
                }
                return null;
            case 1:
                File file = (File) obj;
                pr.j("it", file);
                String absolutePath = file.getCanonicalFile().getAbsolutePath();
                pr.i("file.canonicalFile.absolutePath", absolutePath);
                return new oa0(absolutePath);
            case 2:
                Map.Entry entry = (Map.Entry) obj;
                pr.j("entry", entry);
                Object value = entry.getValue();
                return "  " + ((a20) entry.getKey()).a + " = " + (value instanceof byte[] ? c5.a0((byte[]) value, ", ", null, 56) : String.valueOf(entry.getValue()));
            default:
                pr.j("it", (Context) obj);
                return qi.a;
        }
    }
}
