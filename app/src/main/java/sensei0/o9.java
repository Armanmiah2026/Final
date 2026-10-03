package sensei0;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class o9 extends u9 {
    public static List i0(ArrayList arrayList) {
        int size = arrayList.size() - 1;
        if (size <= 0) {
            return qi.a;
        }
        if (size == 1) {
            if (arrayList.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            return k6.G(arrayList.get(arrayList.size() - 1));
        }
        ArrayList arrayList2 = new ArrayList(size);
        int size2 = arrayList.size();
        for (int i = 1; i < size2; i++) {
            arrayList2.add(arrayList.get(i));
        }
        return arrayList2;
    }

    public static Object j0(List list) {
        pr.j("<this>", list);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static Object k0(int i, List list) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static final void l0(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, fp fpVar) {
        pr.j("<this>", iterable);
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : iterable) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            xe.c(sb, obj, fpVar);
        }
        sb.append(charSequence3);
    }

    public static String m0(Collection collection, String str, String str2, String str3, fp fpVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            fpVar = null;
        }
        pr.j("<this>", collection);
        StringBuilder sb = new StringBuilder();
        l0(collection, sb, str4, str5, str6, "...", fpVar);
        return sb.toString();
    }

    public static List n0(Collection collection, Comparator comparator) {
        if (collection.size() <= 1) {
            return r0(collection);
        }
        Object[] array = collection.toArray(new Object[0]);
        pr.j("<this>", array);
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        List listAsList = Arrays.asList(array);
        pr.i("asList(...)", listAsList);
        return listAsList;
    }

    public static List o0(int i, List list) {
        if (i < 0) {
            throw new IllegalArgumentException(za0.i(i, "Requested element count ", " is less than zero.").toString());
        }
        if (i == 0) {
            return qi.a;
        }
        if (i >= list.size()) {
            return r0(list);
        }
        int i2 = 0;
        if (i == 1) {
            if (list.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            return k6.G(list.get(0));
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return p9.g0(arrayList);
    }

    public static byte[] p0(List list) {
        pr.j("<this>", list);
        byte[] bArr = new byte[list.size()];
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = ((Number) it.next()).byteValue();
            i++;
        }
        return bArr;
    }

    public static final void q0(Iterable iterable, AbstractCollection abstractCollection) {
        pr.j("<this>", iterable);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List r0(Iterable iterable) {
        ArrayList arrayListS0;
        pr.j("<this>", iterable);
        boolean z = iterable instanceof Collection;
        if (!z) {
            if (z) {
                arrayListS0 = s0((Collection) iterable);
            } else {
                ArrayList arrayList = new ArrayList();
                q0(iterable, arrayList);
                arrayListS0 = arrayList;
            }
            return p9.g0(arrayListS0);
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return qi.a;
        }
        if (size != 1) {
            return s0(collection);
        }
        return k6.G(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static ArrayList s0(Collection collection) {
        pr.j("<this>", collection);
        return new ArrayList(collection);
    }

    public static Set t0(Collection collection) {
        pr.j("<this>", collection);
        int size = collection.size();
        if (size == 0) {
            return si.a;
        }
        if (size != 1) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(xv.c0(collection.size()));
            q0(collection, linkedHashSet);
            return linkedHashSet;
        }
        Set setSingleton = Collections.singleton(collection instanceof List ? ((List) collection).get(0) : collection.iterator().next());
        pr.i("singleton(...)", setSingleton);
        return setSingleton;
    }
}
