package sensei0;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t70 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ AtomicBoolean a;

    public t70(AtomicBoolean atomicBoolean) {
        this.a = atomicBoolean;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        pr.j("network", network);
        this.a.set(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        pr.j("network", network);
        pr.j("caps", networkCapabilities);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        pr.j("network", network);
    }
}
