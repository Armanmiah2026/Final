package sensei0;

import com.sensei.tunnel.SenseiTunnelVpnService;
import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n70 implements fp {
    public final /* synthetic */ int a;
    public final /* synthetic */ SenseiTunnelVpnService b;

    public /* synthetic */ n70(SenseiTunnelVpnService senseiTunnelVpnService, int i) {
        this.a = i;
        this.b = senseiTunnelVpnService;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        boolean zProtect;
        int i = this.a;
        SenseiTunnelVpnService senseiTunnelVpnService = this.b;
        Socket socket = (Socket) obj;
        switch (i) {
            case 0:
                boolean z = SenseiTunnelVpnService.J0;
                pr.j("sock", socket);
                zProtect = senseiTunnelVpnService.protect(socket);
                break;
            case 1:
                boolean z2 = SenseiTunnelVpnService.J0;
                pr.j("sock", socket);
                zProtect = senseiTunnelVpnService.protect(socket);
                break;
            default:
                boolean z3 = SenseiTunnelVpnService.J0;
                pr.j("sock", socket);
                zProtect = senseiTunnelVpnService.protect(socket);
                break;
        }
        return Boolean.valueOf(zProtect);
    }
}
