package sensei0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p9 extends k6 {
    public static ArrayList d0(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new q4(objArr));
    }

    public static int e0(List list) {
        return list.size() - 1;
    }

    public static List f0(Object... objArr) {
        if (objArr.length <= 0) {
            return qi.a;
        }
        List listAsList = Arrays.asList(objArr);
        pr.i("asList(...)", listAsList);
        return listAsList;
    }

    public static final List g0(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : k6.G(list.get(0)) : qi.a;
    }
}
