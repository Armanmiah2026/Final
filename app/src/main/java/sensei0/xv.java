package sensei0;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xv extends pr {
    public static int c0(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map d0(qz qzVar) {
        pr.j("pair", qzVar);
        Map mapSingletonMap = Collections.singletonMap(qzVar.a, qzVar.b);
        pr.i("singletonMap(...)", mapSingletonMap);
        return mapSingletonMap;
    }

    public static Map e0(qz... qzVarArr) {
        if (qzVarArr.length <= 0) {
            return ri.a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(c0(qzVarArr.length));
        for (qz qzVar : qzVarArr) {
            linkedHashMap.put(qzVar.a, qzVar.b);
        }
        return linkedHashMap;
    }
}
