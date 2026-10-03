package sensei0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class v70 extends w70 {
    public static Object c0(v9 v9Var) {
        fu fuVar = (fu) v9Var.iterator();
        if (fuVar.hasNext()) {
            return fuVar.next();
        }
        return null;
    }

    public static List d0(u70 u70Var) {
        Iterator it = u70Var.iterator();
        if (!it.hasNext()) {
            return qi.a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return k6.G(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
