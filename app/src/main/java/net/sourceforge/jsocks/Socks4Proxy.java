package net.sourceforge.jsocks;

import java.io.InputStream;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Socks4Proxy extends Proxy implements Cloneable {
    String user;

    public Socks4Proxy(InetAddress inetAddress, int i, String str) {
        this(null, inetAddress, i, str);
    }

    public Object clone() {
        Socks4Proxy socks4Proxy = new Socks4Proxy(this.proxyIP, this.proxyPort, this.user);
        socks4Proxy.chainProxy = this.chainProxy;
        return socks4Proxy;
    }

    @Override // net.sourceforge.jsocks.Proxy
    public Proxy copy() {
        Socks4Proxy socks4Proxy = new Socks4Proxy(this.proxyIP, this.proxyPort, this.user);
        socks4Proxy.chainProxy = this.chainProxy;
        return socks4Proxy;
    }

    @Override // net.sourceforge.jsocks.Proxy
    public ProxyMessage formMessage(InputStream inputStream) {
        return new Socks4Message(inputStream, true);
    }

    public Socks4Proxy(Proxy proxy, InetAddress inetAddress, int i, String str) {
        super(proxy, inetAddress, i);
        this.user = new String(str);
        this.version = 4;
    }

    @Override // net.sourceforge.jsocks.Proxy
    public ProxyMessage formMessage(int i, InetAddress inetAddress, int i2) {
        int i3 = 1;
        if (i != 1) {
            i3 = 2;
            if (i != 2) {
                return null;
            }
        }
        return new Socks4Message(i3, inetAddress, i2, this.user);
    }

    @Override // net.sourceforge.jsocks.Proxy
    public ProxyMessage formMessage(int i, String str, int i2) {
        return formMessage(i, InetAddress.getByName(str), i2);
    }

    public Socks4Proxy(String str, int i, String str2) {
        super(str, i);
        this.user = new String(str2);
        this.version = 4;
    }
}
