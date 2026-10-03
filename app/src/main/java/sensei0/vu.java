package sensei0;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vu {
    public final i3 a;
    public final Context b;

    public vu(Context context, i3 i3Var) {
        ws wsVar = new ws(3, this);
        this.b = context;
        this.a = i3Var;
        i3Var.c = wsVar;
    }

    public static Locale a(String str) {
        Locale.Builder builder = new Locale.Builder();
        String[] strArrSplit = str.replace('_', '-').split("-");
        builder.setLanguage(strArrSplit[0]);
        int i = 1;
        if (strArrSplit.length > 1 && strArrSplit[1].length() == 4) {
            builder.setScript(strArrSplit[1]);
            i = 2;
        }
        if (strArrSplit.length > i && strArrSplit[i].length() >= 2 && strArrSplit[i].length() <= 3) {
            builder.setRegion(strArrSplit[i]);
        }
        return builder.build();
    }

    public final void b(Configuration configuration) {
        ArrayList arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        int size = locales.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(locales.get(i2));
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            Locale locale = (Locale) obj;
            locale.getLanguage();
            locale.getCountry();
            locale.getVariant();
            arrayList2.add(locale.getLanguage());
            arrayList2.add(locale.getCountry());
            arrayList2.add(locale.getScript());
            arrayList2.add(locale.getVariant());
        }
        ((aj) this.a.b).a("setLocale", arrayList2, null);
    }
}
