package net.sourceforge.jsocks;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class SocksServerSocket extends ServerSocket {
    boolean doing_direct;
    protected String localHost;
    protected InetAddress localIP;
    protected int localPort;
    protected Proxy proxy;
    InetAddress remoteAddr;

    public SocksServerSocket(InetAddress inetAddress, int i) {
        this(Proxy.defaultProxy, inetAddress, i);
    }

    private void doDirect() {
        this.doing_direct = true;
        this.localPort = super.getLocalPort();
        InetAddress inetAddress = super.getInetAddress();
        this.localIP = inetAddress;
        this.localHost = inetAddress.getHostName();
    }

    @Override // java.net.ServerSocket
    public Socket accept() throws IOException {
        Socket socketAccept;
        if (this.doing_direct) {
            while (true) {
                socketAccept = super.accept();
                if (socketAccept.getInetAddress().equals(this.remoteAddr)) {
                    break;
                }
                socketAccept.close();
            }
        } else {
            Proxy proxy = this.proxy;
            if (proxy == null) {
                return null;
            }
            ProxyMessage proxyMessageAccept = proxy.accept();
            socketAccept = proxyMessageAccept.ip == null ? new SocksSocket(proxyMessageAccept.host, proxyMessageAccept.port, this.proxy) : new SocksSocket(proxyMessageAccept.ip, proxyMessageAccept.port, this.proxy);
            this.proxy.proxySocket.setSoTimeout(0);
        }
        this.proxy = null;
        return socketAccept;
    }

    @Override // java.net.ServerSocket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Proxy proxy = this.proxy;
        if (proxy != null) {
            proxy.endSession();
        }
        this.proxy = null;
    }

    public String getHost() {
        return this.localHost;
    }

    @Override // java.net.ServerSocket
    public InetAddress getInetAddress() {
        if (this.localIP == null) {
            try {
                this.localIP = InetAddress.getByName(this.localHost);
            } catch (UnknownHostException unused) {
                return null;
            }
        }
        return this.localIP;
    }

    @Override // java.net.ServerSocket
    public int getLocalPort() {
        return this.localPort;
    }

    @Override // java.net.ServerSocket
    public void setSoTimeout(int i) throws SocketException {
        super.setSoTimeout(i);
        if (this.doing_direct) {
            return;
        }
        this.proxy.proxySocket.setSoTimeout(i);
    }

    public SocksServerSocket(Proxy proxy, InetAddress inetAddress, int i) {
        super(0);
        this.doing_direct = false;
        this.remoteAddr = inetAddress;
        doDirect();
    }

    public SocksServerSocket(String str, int i) {
        super(0);
        this.doing_direct = false;
        this.remoteAddr = InetAddress.getByName(str);
        doDirect();
    }
}
