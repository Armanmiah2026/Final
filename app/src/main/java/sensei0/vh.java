package sensei0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.DefaultLifecycleObserver;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vh implements DefaultLifecycleObserver {
    public final /* synthetic */ nt a;

    public vh(EmojiCompatInitializer emojiCompatInitializer, nt ntVar) {
        this.a = ntVar;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void b(tt ttVar) {
        (Build.VERSION.SDK_INT >= 28 ? la.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new yh(), 500L);
        this.a.b(this);
    }
}
