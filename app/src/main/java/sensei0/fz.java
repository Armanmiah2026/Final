package sensei0;

import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import com.sensei.tunnel.SenseiTunnelVpnService;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fz implements uo {
    public final /* synthetic */ int a;
    public final /* synthetic */ kz b;

    public /* synthetic */ fz(kz kzVar, int i) {
        this.a = i;
        this.b = kzVar;
    }

    @Override // sensei0.uo
    public final Object a() {
        int i = this.a;
        kz kzVar = this.b;
        switch (i) {
            case 0:
                boolean z = SenseiTunnelVpnService.J0;
                xe.i("ovpn tun_builder_establish called");
                VpnService.Builder builder = (VpnService.Builder) kzVar.j.get();
                int iDetachFd = -1;
                if (builder == null) {
                    xe.i("ovpn tun_builder_establish: Builder is NULL — cannot create TUN");
                } else {
                    for (String str : p9.f0(kzVar.e, kzVar.f)) {
                        if (!fc0.l0(str)) {
                            try {
                                pr.f(builder.addDnsServer(str));
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    int i2 = 0;
                    Iterator it = v70.d0(new cl(new cl(b50.b(new b50("(?im)^\\s*dhcp-option\\s+DNS\\s+(\\S+)\\s*$"), kzVar.b), new a3(6), 2), new a3(19), 0)).iterator();
                    while (it.hasNext()) {
                        try {
                            pr.f(builder.addDnsServer((String) it.next()));
                        } catch (Throwable unused2) {
                        }
                    }
                    ArrayList arrayList = kzVar.p;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        try {
                            pr.f(builder.addDnsServer((String) obj));
                        } catch (Throwable unused3) {
                        }
                    }
                    ArrayList arrayList2 = kzVar.q;
                    int size2 = arrayList2.size();
                    while (i2 < size2) {
                        Object obj2 = arrayList2.get(i2);
                        i2++;
                        try {
                            pr.f(builder.addSearchDomain((String) obj2));
                        } catch (Throwable unused4) {
                        }
                    }
                    ParcelFileDescriptor parcelFileDescriptorEstablish = builder.establish();
                    if (parcelFileDescriptorEstablish == null) {
                        boolean z2 = SenseiTunnelVpnService.J0;
                        xe.i("ovpn tun_builder_establish: Builder.establish() returned NULL (interface rejected by the system)");
                    } else {
                        iDetachFd = parcelFileDescriptorEstablish.detachFd();
                        kzVar.k.set(Integer.valueOf(iDetachFd));
                        kzVar.m.set(true);
                        kzVar.c("ovpn:done");
                        boolean z3 = SenseiTunnelVpnService.J0;
                        xe.i("ovpn tun fd=" + iDetachFd + " acquired");
                    }
                }
                return Integer.valueOf(iDetachFd);
            default:
                kzVar.p.clear();
                kzVar.q.clear();
                SenseiTunnelVpnService senseiTunnelVpnService = kzVar.a;
                VpnService.Builder mtu = new VpnService.Builder(senseiTunnelVpnService).setSession(kzVar.c).setMtu(kzVar.d);
                pr.i("setMtu(...)", mtu);
                try {
                    pr.f(mtu.addDisallowedApplication(senseiTunnelVpnService.getPackageName()));
                    break;
                } catch (Throwable unused5) {
                }
                kzVar.j.set(mtu);
                return Boolean.TRUE;
        }
    }
}
