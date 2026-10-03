package sensei0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qb implements pb, rb {
    public final /* synthetic */ int a;
    public Object b;
    public int c;
    public int d;
    public Object f;
    public Cloneable h;

    public /* synthetic */ qb() {
        this.a = 0;
    }

    public void a(rl0 rl0Var, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((((zk0) it.next()).a.c() & 8) != 0) {
                ((View) this.f).setTranslationY(d3.c(this.d, 0, r3.a.b()));
                return;
            }
        }
    }

    @Override // sensei0.pb
    public sb build() {
        return new sb(new qb(this));
    }

    @Override // sensei0.rb
    public ClipData d() {
        return (ClipData) this.b;
    }

    @Override // sensei0.rb
    public int m() {
        return this.d;
    }

    @Override // sensei0.rb
    public ContentInfo o() {
        return null;
    }

    @Override // sensei0.pb
    public void r(Uri uri) {
        this.f = uri;
    }

    @Override // sensei0.rb
    public int s() {
        return this.c;
    }

    @Override // sensei0.pb
    public void setExtras(Bundle bundle) {
        this.h = bundle;
    }

    public String toString() {
        String str;
        switch (this.a) {
            case 1:
                Uri uri = (Uri) this.f;
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(((ClipData) this.b).getDescription());
                sb.append(", source=");
                int i = this.c;
                sb.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i2 = this.d;
                sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return za0.o(sb, ((Bundle) this.h) != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    @Override // sensei0.pb
    public void x(int i) {
        this.d = i;
    }

    public qb(qb qbVar) {
        this.a = 1;
        ClipData clipData = (ClipData) qbVar.b;
        clipData.getClass();
        this.b = clipData;
        int i = qbVar.c;
        if (i < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.c = i;
        int i2 = qbVar.d;
        if ((i2 & 1) == i2) {
            this.d = i2;
            this.f = (Uri) qbVar.f;
            this.h = (Bundle) qbVar.h;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [int[], java.lang.Cloneable] */
    public qb(View view) {
        this.a = 2;
        this.h = new int[2];
        this.f = view;
    }
}
