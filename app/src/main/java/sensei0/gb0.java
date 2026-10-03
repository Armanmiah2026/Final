package sensei0;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gb0 implements SpellCheckerSession.SpellCheckerSessionListener {
    public final fb0 a;
    public final TextServicesManager b;
    public SpellCheckerSession c;
    public rk d;

    public gb0(TextServicesManager textServicesManager, fb0 fb0Var) {
        this.b = textServicesManager;
        this.a = fb0Var;
        fb0Var.a = this;
    }

    public final void a(String str, String str2, rk rkVar) {
        if (this.d != null) {
            rkVar.a("error", "Previous spell check request still pending.", null);
            return;
        }
        this.d = rkVar;
        Locale localeA = vu.a(str);
        if (this.c == null) {
            this.c = this.b.newSpellCheckerSession(null, localeA, this, true);
        }
        this.c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public final void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        if (sentenceSuggestionsInfoArr.length == 0) {
            this.d.d(new ArrayList());
            this.d = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
        if (sentenceSuggestionsInfo == null) {
            this.d.d(new ArrayList());
            this.d = null;
            return;
        }
        for (int i = 0; i < sentenceSuggestionsInfo.getSuggestionsCount(); i++) {
            SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i);
            int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
            if (suggestionsCount > 0) {
                HashMap map = new HashMap();
                int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i);
                int lengthAt = sentenceSuggestionsInfo.getLengthAt(i) + offsetAt;
                map.put("startIndex", Integer.valueOf(offsetAt));
                map.put("endIndex", Integer.valueOf(lengthAt));
                ArrayList arrayList2 = new ArrayList();
                boolean z = false;
                for (int i2 = 0; i2 < suggestionsCount; i2++) {
                    String suggestionAt = suggestionsInfoAt.getSuggestionAt(i2);
                    if (!suggestionAt.isEmpty()) {
                        arrayList2.add(suggestionAt);
                        z = true;
                    }
                }
                if (z) {
                    map.put("suggestions", arrayList2);
                    arrayList.add(map);
                }
            }
        }
        this.d.d(arrayList);
        this.d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public final void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
