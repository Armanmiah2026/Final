package io.flutter.plugin.editing;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ ImeSyncDeferringInsetsCallback a;

    public a(ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback) {
        this.a = imeSyncDeferringInsetsCallback;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.a;
        imeSyncDeferringInsetsCallback.view = view;
        if (imeSyncDeferringInsetsCallback.needsSave) {
            imeSyncDeferringInsetsCallback.lastWindowInsets = windowInsets;
            imeSyncDeferringInsetsCallback.needsSave = false;
        }
        return imeSyncDeferringInsetsCallback.animating ? WindowInsets.CONSUMED : view.onApplyWindowInsets(windowInsets);
    }
}
