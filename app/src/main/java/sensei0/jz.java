package sensei0;

import android.net.VpnService;
import android.os.Build;
import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;
import ph.yooh.novpn.ClientAPI_AppCustomControlMessageEvent;
import ph.yooh.novpn.ClientAPI_Event;
import ph.yooh.novpn.ClientAPI_ExternalPKICertRequest;
import ph.yooh.novpn.ClientAPI_ExternalPKISignRequest;
import ph.yooh.novpn.ClientAPI_LogInfo;
import ph.yooh.novpn.ClientAPI_OpenVPNClient;
import ph.yooh.novpn.ClientAPI_StringVec;
import ph.yooh.novpn.DnsOptions;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jz extends ClientAPI_OpenVPNClient {
    public final /* synthetic */ kz a;

    public jz(kz kzVar) {
        this.a = kzVar;
    }

    @Override // ph.yooh.novpn.ClientAPI_OpenVPNClient
    public final void acc_event(ClientAPI_AppCustomControlMessageEvent clientAPI_AppCustomControlMessageEvent) {
        pr.j("accEvent", clientAPI_AppCustomControlMessageEvent);
    }

    @Override // ph.yooh.novpn.ClientAPI_OpenVPNClient
    public final void event(ClientAPI_Event clientAPI_Event) {
        pr.j("apiEvent", clientAPI_Event);
        kz kzVar = this.a;
        kzVar.c("ovpn:cb_event");
        try {
            new dz(0, clientAPI_Event, kzVar).a();
        } catch (Throwable th) {
            String str = "ovpn callback event failed: " + th.getClass().getSimpleName() + ": " + th.getMessage();
            Log.w("OpenVpnEngine", str, th);
            boolean z = SenseiTunnelVpnService.J0;
            xe.i(str);
        }
    }

    @Override // ph.yooh.novpn.ClientAPI_OpenVPNClient
    public final void external_pki_cert_request(ClientAPI_ExternalPKICertRequest clientAPI_ExternalPKICertRequest) {
        pr.j("req", clientAPI_ExternalPKICertRequest);
    }

    @Override // ph.yooh.novpn.ClientAPI_OpenVPNClient
    public final void external_pki_sign_request(ClientAPI_ExternalPKISignRequest clientAPI_ExternalPKISignRequest) {
        pr.j("req", clientAPI_ExternalPKISignRequest);
    }

    @Override // ph.yooh.novpn.ClientAPI_OpenVPNClient, ph.yooh.novpn.LogReceiverSwigInterface
    public final void log(ClientAPI_LogInfo clientAPI_LogInfo) {
        pr.j("loginfo", clientAPI_LogInfo);
        this.a.c("ovpn:cb_log");
        try {
            new hz(0, clientAPI_LogInfo).a();
        } catch (Throwable th) {
            String str = "ovpn callback log failed: " + th.getClass().getSimpleName() + ": " + th.getMessage();
            Log.w("OpenVpnEngine", str, th);
            boolean z = SenseiTunnelVpnService.J0;
            xe.i(str);
        }
    }

    @Override // ph.yooh.novpn.ClientAPI_OpenVPNClient
    public final boolean pause_on_connection_timeout() {
        return false;
    }

    @Override // ph.yooh.novpn.ClientAPI_OpenVPNClient
    public final boolean socket_protect(int i, String str, boolean z) {
        pr.j("remote", str);
        kz kzVar = this.a;
        kzVar.c("ovpn:cb_socket_protect");
        return kz.a("socket_protect(" + i + ")", new ez(kzVar, i, 0));
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_add_address(String str, int i, String str2, boolean z, boolean z2) {
        pr.j("address", str);
        pr.j("gateway", str2);
        kz kzVar = this.a;
        kzVar.c("ovpn:cb_address");
        StringBuilder sb = new StringBuilder("tun_builder_add_address(");
        sb.append(str);
        sb.append("/");
        return kz.a(za0.n(sb, i, ")"), new gz(z, kzVar, str, i, 1));
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_add_proxy_bypass(String str) {
        pr.j("bypassHost", str);
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_add_route(String str, int i, int i2, boolean z) {
        pr.j("address", str);
        kz kzVar = this.a;
        kzVar.c("ovpn:cb_route");
        StringBuilder sb = new StringBuilder("tun_builder_add_route(");
        sb.append(str);
        sb.append("/");
        return kz.a(za0.n(sb, i, ")"), new gz(z, kzVar, str, i, 2));
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_add_wins_server(String str) {
        pr.j("address", str);
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final int tun_builder_establish() {
        kz kzVar = this.a;
        kzVar.c("ovpn:cb_establish");
        return ((Number) kz.b("tun_builder_establish", -1, new fz(kzVar, 0))).intValue();
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final void tun_builder_establish_lite() {
        tun_builder_establish();
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_exclude_route(String str, int i, int i2, boolean z) {
        pr.j("address", str);
        kz kzVar = this.a;
        kzVar.c("ovpn:cb_exclude");
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        return kz.a("tun_builder_exclude_route(" + str + "/" + i + ")", new gz(z, kzVar, str, i, 0));
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final ClientAPI_StringVec tun_builder_get_local_networks(boolean z) {
        this.a.c("ovpn:cb_local_networks");
        return new ClientAPI_StringVec();
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_new() {
        kz kzVar = this.a;
        kzVar.c("ovpn:cb_new");
        return kz.a("tun_builder_new", new fz(kzVar, 1));
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_persist() {
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_reroute_gw(final boolean z, final boolean z2, long j) {
        final kz kzVar = this.a;
        kzVar.c("ovpn:cb_reroute");
        return kz.a("tun_builder_reroute_gw", new uo() { // from class: sensei0.iz
            @Override // sensei0.uo
            public final Object a() {
                kz kzVar2 = kzVar;
                VpnService.Builder builder = (VpnService.Builder) kzVar2.j.get();
                boolean z3 = false;
                if (builder != null) {
                    if (z) {
                        try {
                            pr.f(builder.addRoute("0.0.0.0", 0));
                        } catch (Throwable unused) {
                        }
                    }
                    if (z2 && kzVar2.o) {
                        try {
                            pr.f(builder.addRoute("::", 0));
                        } catch (Throwable unused2) {
                        }
                    }
                    z3 = true;
                }
                return Boolean.valueOf(z3);
            }
        });
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_allow_family(int i, boolean z) {
        if (i != 10) {
            return true;
        }
        this.a.o = z;
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_allow_local_dns(boolean z) {
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_dns_options(DnsOptions dnsOptions) {
        pr.j("dns", dnsOptions);
        return kz.a("tun_builder_set_dns_options", new dz(2, dnsOptions, this.a));
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_layer(int i) {
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_mtu(int i) {
        return kz.a("tun_builder_set_mtu", new ez(this.a, i, 1));
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_proxy_auto_config_url(String str) {
        pr.j("url", str);
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_proxy_http(String str, int i) {
        pr.j("host", str);
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_proxy_https(String str, int i) {
        pr.j("host", str);
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_remote_address(String str, boolean z) {
        pr.j("address", str);
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_route_metric_default(int i) {
        return true;
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final boolean tun_builder_set_session_name(String str) {
        pr.j("name", str);
        return kz.a("tun_builder_set_session_name", new dz(this.a, str));
    }

    @Override // ph.yooh.novpn.ClientAPI_TunBuilderBase
    public final void tun_builder_teardown(boolean z) {
        this.a.j.set(null);
    }
}
