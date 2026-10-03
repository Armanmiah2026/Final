package sensei0;

import android.text.StaticLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class l4 extends k4 {
    @Override // sensei0.k4, sensei0.m4
    public void a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    @Override // sensei0.m4
    public boolean b(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}
