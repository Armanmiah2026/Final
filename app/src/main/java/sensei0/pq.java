package sensei0;

import com.sensei.tunnel.MainActivity;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pq implements ThreadFactory {
    public final /* synthetic */ int a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.a) {
            case 0:
                Thread thread = new Thread(runnable, "sensei-http-bridge");
                thread.setDaemon(true);
                return thread;
            case 1:
                boolean z = MainActivity.B;
                Thread thread2 = new Thread(runnable, "sensei-io");
                thread2.setDaemon(true);
                return thread2;
            default:
                boolean z2 = SenseiTunnelVpnService.J0;
                Thread thread3 = new Thread(runnable, "sensei-ping");
                thread3.setDaemon(true);
                return thread3;
        }
    }
}
