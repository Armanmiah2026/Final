package sensei0;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class y10 extends et implements uo {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y10(int i, Object obj, Object obj2) {
        super(0);
        this.b = i;
        this.c = obj;
        this.d = obj2;
    }

    @Override // sensei0.uo
    public final Object a() {
        switch (this.b) {
            case 0:
                Context context = (Context) this.c;
                ((z10) this.d).getClass();
                String strConcat = "FlutterSharedPreferences".concat(".preferences_pb");
                pr.j("fileName", strConcat);
                return new File(context.getApplicationContext().getFilesDir(), "datastore/".concat(strConcat));
            default:
                ((pk0) ((fb0) this.c).a).b((jn) this.d);
                return mg0.a;
        }
    }
}
