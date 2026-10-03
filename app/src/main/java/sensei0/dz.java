package sensei0;

import android.net.VpnService;
import android.util.Log;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import ph.yooh.novpn.ClientAPI_Event;
import ph.yooh.novpn.DnsOptions;
import ph.yooh.novpn.DnsOptions_AddressList;
import ph.yooh.novpn.DnsOptions_DomainsList;
import ph.yooh.novpn.DnsServer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dz implements uo {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ dz(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // sensei0.uo
    public final Object a() {
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                ClientAPI_Event clientAPI_Event = (ClientAPI_Event) obj2;
                kz kzVar = (kz) obj;
                String name = clientAPI_Event.getName();
                if (name == null) {
                    name = "";
                }
                String info = clientAPI_Event.getInfo();
                if (info == null) {
                    info = "";
                }
                String str = "ovpn-event: " + name + " " + (info.length() > 0 ? za0.l("(", info, ")") : "");
                Log.i("OpenVpnEngine", str);
                boolean z = SenseiTunnelVpnService.J0;
                xe.i(str);
                if (clientAPI_Event.getError() || clientAPI_Event.getFatal()) {
                    AtomicReference atomicReference = kzVar.l;
                    String str2 = fc0.l0(info) ? name : name + ": " + info;
                    while (!atomicReference.compareAndSet(null, str2) && atomicReference.get() == null) {
                    }
                }
                if (name.equals("CERT_VERIFY_FAIL")) {
                    boolean z2 = SenseiTunnelVpnService.J0;
                    xe.i("ovpn: The profile's <ca> does not match the server's current certificate (server certs re-issued 2026-08-27). Re-import the latest .ovpn — the same file OpenVPN Lite uses (export it from Lite or re-download from the panel).");
                }
                if (name.equals("CONNECTED")) {
                    kzVar.m.set(true);
                }
                return mg0.a;
            case 1:
                String str3 = (String) obj2;
                VpnService.Builder builder = (VpnService.Builder) ((kz) obj).j.get();
                if (builder != null) {
                    builder.setSession(str3);
                }
                return Boolean.TRUE;
            case 2:
                DnsOptions dnsOptions = (DnsOptions) obj2;
                kz kzVar2 = (kz) obj;
                ArrayList arrayList = kzVar2.p;
                ArrayList arrayList2 = kzVar2.q;
                Set<Map.Entry<Integer, DnsServer>> setEntrySet = dnsOptions.getServers().entrySet();
                pr.i("<get-entries>(...)", setEntrySet);
                Iterator it = o9.n0(setEntrySet, new hc(3)).iterator();
                while (true) {
                    int i2 = 0;
                    if (!it.hasNext()) {
                        DnsOptions_DomainsList search_domains = dnsOptions.getSearch_domains();
                        int size = search_domains.size();
                        while (i2 < size) {
                            String domain = search_domains.get(i2).getDomain();
                            pr.f(domain);
                            if (!fc0.l0(domain) && !arrayList2.contains(domain)) {
                                arrayList2.add(domain);
                            }
                            i2++;
                        }
                        boolean z3 = SenseiTunnelVpnService.J0;
                        xe.i("ovpn pushed DNS: " + o9.m0(arrayList, null, null, null, null, 63) + " domains: " + o9.m0(arrayList2, null, null, null, null, 63));
                        return Boolean.TRUE;
                    }
                    Object next = it.next();
                    pr.i("next(...)", next);
                    DnsServer dnsServer = (DnsServer) ((Map.Entry) next).getValue();
                    DnsOptions_AddressList addresses = dnsServer.getAddresses();
                    int size2 = addresses.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        String address = addresses.get(i3).getAddress();
                        pr.f(address);
                        if (!fc0.l0(address) && !arrayList.contains(address)) {
                            arrayList.add(address);
                        }
                    }
                    DnsOptions_DomainsList domains = dnsServer.getDomains();
                    int size3 = domains.size();
                    while (i2 < size3) {
                        String domain2 = domains.get(i2).getDomain();
                        pr.f(domain2);
                        if (!fc0.l0(domain2) && !arrayList2.contains(domain2)) {
                            arrayList2.add(domain2);
                        }
                        i2++;
                    }
                }
                break;
            default:
                return ((b50) obj2).a((CharSequence) obj);
        }
    }

    public /* synthetic */ dz(kz kzVar, String str) {
        this.a = 1;
        this.b = kzVar;
        this.c = str;
    }
}
