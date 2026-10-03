package sensei0;

import android.app.Notification;
import android.app.NotificationChannel;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class s0 {
    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ Notification.Builder b(SenseiTunnelVpnService senseiTunnelVpnService) {
        return new Notification.Builder(senseiTunnelVpnService, "sensei_tunnel_vpn");
    }

    public static /* synthetic */ NotificationChannel c() {
        return new NotificationChannel("sensei_tunnel_vpn", "Sensei Tunnel VPN", 2);
    }

    public static /* synthetic */ Locale.LanguageRange k(String str) {
        return new Locale.LanguageRange(str);
    }

    public static /* synthetic */ void m() {
    }
}
