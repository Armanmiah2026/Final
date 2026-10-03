package sensei0;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class km {
    public final ArrayList a = new ArrayList();

    public km(vl vlVar, String[] strArr) {
        um umVar = (um) o4.O().b;
        if (umVar.b) {
            return;
        }
        umVar.d(vlVar.getApplicationContext());
        umVar.a(vlVar.getApplicationContext(), strArr);
    }

    public final em a(jm jmVar) {
        em emVar;
        Context context = jmVar.a;
        jd jdVar = jmVar.b;
        String str = jmVar.c;
        List<String> list = jmVar.d;
        io.flutter.plugin.platform.c cVar = new io.flutter.plugin.platform.c();
        boolean z = jmVar.e;
        boolean z2 = jmVar.f;
        if (jdVar == null) {
            um umVar = (um) o4.O().b;
            if (!umVar.b) {
                throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
            }
            jdVar = new jd((String) umVar.e.c, "main");
        }
        jd jdVar2 = jdVar;
        ArrayList arrayList = this.a;
        if (arrayList.size() == 0) {
            emVar = new em(context, null, cVar, z, z2);
            if (str != null) {
                emVar.i.a.a("setInitialRoute", str, null);
            }
            emVar.c.a(jdVar2, list);
        } else {
            em emVar2 = (em) arrayList.get(0);
            if (!emVar2.a.isAttached()) {
                throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
            }
            emVar = new em(context, emVar2.a.spawn(jdVar2.c, jdVar2.b, str, list, em.y), cVar, z, z2);
        }
        arrayList.add(emVar);
        emVar.v.add(new im(this, emVar));
        return emVar;
    }
}
