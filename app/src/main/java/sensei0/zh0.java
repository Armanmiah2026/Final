package sensei0;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zh0 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static sb b(View view, sb sbVar) {
        ContentInfo contentInfoO = sbVar.a.o();
        Objects.requireNonNull(contentInfoO);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoO);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoO ? sbVar : new sb(new sv(contentInfoPerformReceiveContent));
    }
}
