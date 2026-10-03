package net.sourceforge.jsocks;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Proxy {
    public static final int SOCKS_ADDR_NOT_SUPPORTED = 8;
    public static final int SOCKS_AUTH_FAILURE = 327680;
    public static final int SOCKS_AUTH_NOT_SUPPORTED = 262144;
    public static final int SOCKS_BADCONNECT = 2;
    public static final int SOCKS_BADNETWORK = 3;
    static final int SOCKS_CMD_BIND = 2;
    public static final int SOCKS_CMD_CONNECT = 1;
    public static final int SOCKS_CMD_NOT_SUPPORTED = 7;
    static final int SOCKS_CMD_UDP_ASSOCIATE = 3;
    public static final int SOCKS_CONNECTION_REFUSED = 5;
    public static final int SOCKS_DIRECT_FAILED = 458752;
    public static final int SOCKS_FAILURE = 1;
    public static final int SOCKS_HOST_UNREACHABLE = 4;
    public static final int SOCKS_JUST_ERROR = 393216;
    public static final int SOCKS_METHOD_NOTSUPPORTED = 524288;
    public static final int SOCKS_NO_PROXY = 65536;
    public static final int SOCKS_PROXY_IO_ERROR = 196608;
    public static final int SOCKS_PROXY_NO_CONNECT = 131072;
    public static final int SOCKS_SUCCESS = 0;
    public static final int SOCKS_TTL_EXPIRE = 6;
    protected static Proxy defaultProxy;
    protected Proxy chainProxy;
    protected InputStream in;
    protected OutputStream out;
    protected String proxyHost;
    protected InetAddress proxyIP;
    protected int proxyPort;
    protected Socket proxySocket;
    protected int version;

    public Proxy(InetAddress inetAddress, int i) {
        this.proxyHost = null;
        this.proxySocket = null;
        this.chainProxy = null;
        this.proxyIP = inetAddress;
        this.proxyPort = i;
    }

    public static Proxy getDefaultProxy() {
        return defaultProxy;
    }

    public static Proxy parseProxy(String str) {
        int i;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ":");
        if (stringTokenizer.countTokens() < 1) {
            return null;
        }
        String strNextToken = stringTokenizer.nextToken();
        if (stringTokenizer.hasMoreTokens()) {
            try {
                i = Integer.parseInt(stringTokenizer.nextToken().trim());
            } catch (NumberFormatException unused) {
                i = 1080;
            }
        } else {
            i = 1080;
        }
        String strNextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
        try {
            Proxy socks4Proxy = (strNextToken2 != null && (stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null) == null) ? new Socks4Proxy(strNextToken, i, strNextToken2) : new Socks5Proxy(strNextToken, i);
            return socks4Proxy;
        } catch (UnknownHostException unused2) {
            return null;
        }
    }

    public static void setDefaultProxy(InetAddress inetAddress, int i) {
        defaultProxy = new Socks5Proxy(inetAddress, i);
    }

    public ProxyMessage accept() throws SocksException, InterruptedIOException {
        try {
            return formMessage(this.in);
        } catch (InterruptedIOException e) {
            throw e;
        } catch (IOException e2) {
            endSession();
            throw new SocksException(SOCKS_PROXY_IO_ERROR, "While Trying accept:" + e2);
        }
    }

    public ProxyMessage bind(InetAddress inetAddress, int i) throws SocksException {
        try {
            startSession();
            return exchange(formMessage(2, inetAddress, i));
        } catch (SocksException e) {
            endSession();
            throw e;
        }
    }

    public ProxyMessage connect(InetAddress inetAddress, int i) throws SocksException {
        try {
            startSession();
            return exchange(formMessage(1, inetAddress, i));
        } catch (SocksException e) {
            endSession();
            throw e;
        }
    }

    public abstract Proxy copy();

    public void endSession() {
        try {
            Socket socket = this.proxySocket;
            if (socket != null) {
                socket.close();
            }
            this.proxySocket = null;
        } catch (IOException unused) {
        }
    }

    public ProxyMessage exchange(ProxyMessage proxyMessage) throws SocksException {
        try {
            proxyMessage.write(this.out);
            return formMessage(this.in);
        } catch (SocksException e) {
            throw e;
        } catch (IOException e2) {
            throw new SocksException(SOCKS_PROXY_IO_ERROR, "" + e2);
        }
    }

    public abstract ProxyMessage formMessage(int i, String str, int i2);

    public abstract ProxyMessage formMessage(int i, InetAddress inetAddress, int i2);

    public abstract ProxyMessage formMessage(InputStream inputStream);

    public InetAddress getInetAddress() {
        return this.proxyIP;
    }

    public int getPort() {
        return this.proxyPort;
    }

    public ProxyMessage readMsg() {
        return formMessage(this.in);
    }

    public void sendMsg(ProxyMessage proxyMessage) {
        proxyMessage.write(this.out);
    }

    public void startSession() {
        try {
            Socket socket = new Socket(this.proxyIP, this.proxyPort);
            this.proxySocket = socket;
            this.in = socket.getInputStream();
            this.out = this.proxySocket.getOutputStream();
        } catch (SocksException e) {
            throw e;
        } catch (IOException e2) {
            throw new SocksException(SOCKS_PROXY_IO_ERROR, "" + e2);
        }
    }

    public String toString() {
        return "" + this.proxyIP.getHostName() + ":" + this.proxyPort + "\tVersion " + this.version;
    }

    public ProxyMessage udpAssociate(InetAddress inetAddress, int i) throws SocksException {
        try {
            startSession();
            ProxyMessage proxyMessageFormMessage = formMessage(3, inetAddress, i);
            if (proxyMessageFormMessage != null) {
                return exchange(proxyMessageFormMessage);
            }
            endSession();
            throw new SocksException(SOCKS_METHOD_NOTSUPPORTED, "This version of proxy does not support UDP associate, use version 5");
        } catch (SocksException e) {
            endSession();
            throw e;
        }
    }

    public static void setDefaultProxy(InetAddress inetAddress, int i, String str) {
        defaultProxy = new Socks4Proxy(inetAddress, i, str);
    }

    public static void setDefaultProxy(Proxy proxy) {
        defaultProxy = proxy;
    }

    public static void setDefaultProxy(String str, int i) {
        defaultProxy = new Socks5Proxy(str, i);
    }

    public static void setDefaultProxy(String str, int i, String str2) {
        defaultProxy = new Socks4Proxy(str, i, str2);
    }

    public ProxyMessage bind(String str, int i) throws SocksException {
        try {
            startSession();
            return exchange(formMessage(2, str, i));
        } catch (SocksException e) {
            endSession();
            throw e;
        }
    }

    public ProxyMessage connect(String str, int i) throws SocksException {
        try {
            startSession();
            return exchange(formMessage(1, str, i));
        } catch (SocksException e) {
            endSession();
            throw e;
        }
    }

    public Proxy(Proxy proxy) {
        this.proxyIP = null;
        this.proxyHost = null;
        this.proxySocket = null;
        this.chainProxy = null;
        this.proxyIP = proxy.proxyIP;
        this.proxyPort = proxy.proxyPort;
        this.version = proxy.version;
    }

    public ProxyMessage udpAssociate(String str, int i) throws SocksException {
        try {
            startSession();
            ProxyMessage proxyMessageFormMessage = formMessage(3, str, i);
            if (proxyMessageFormMessage != null) {
                return exchange(proxyMessageFormMessage);
            }
            endSession();
            throw new SocksException(SOCKS_METHOD_NOTSUPPORTED, "This version of proxy does not support UDP associate, use version 5");
        } catch (SocksException e) {
            endSession();
            throw e;
        }
    }

    public Proxy(Proxy proxy, InetAddress inetAddress, int i) {
        this.proxyHost = null;
        this.proxySocket = null;
        this.chainProxy = proxy;
        this.proxyIP = inetAddress;
        this.proxyPort = i;
    }

    public Proxy(String str, int i) {
        this.proxyIP = null;
        this.proxySocket = null;
        this.chainProxy = null;
        this.proxyHost = str;
        this.proxyIP = InetAddress.getByName(str);
        this.proxyPort = i;
    }
}
