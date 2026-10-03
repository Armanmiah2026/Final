package sensei0;

import java.util.List;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zv {
    public final Matcher a;
    public final CharSequence b;
    public yv c;

    public zv(Matcher matcher, CharSequence charSequence) {
        pr.j("input", charSequence);
        this.a = matcher;
        this.b = charSequence;
    }

    public final List a() {
        if (this.c == null) {
            this.c = new yv(this);
        }
        yv yvVar = this.c;
        pr.f(yvVar);
        return yvVar;
    }

    public final zv b() {
        Matcher matcher = this.a;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.b;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        pr.i("matcher(...)", matcher2);
        return xe.b(matcher2, iEnd, charSequence);
    }
}
