package net.sourceforge.jsocks;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import net.sourceforge.jsocks.server.ServerAuthenticator;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ProxyServer implements Runnable {
    static final int ABORT_MODE = 3;
    static final int ACCEPT_MODE = 1;
    static final int BUF_SIZE = 8192;
    static final int PIPE_MODE = 2;
    static final int START_MODE = 0;
    static int acceptTimeout = 180000;
    static final String[] command_names = {"CONNECT", "BIND", "UDP_ASSOCIATE"};
    protected static int iddleTimeout = 180000;
    static PrintStream log;
    static Proxy proxy;
    ServerAuthenticator auth;
    InputStream in;
    long lastReadTime;
    int mode;
    ProxyMessage msg;
    OutputStream out;
    Thread pipe_thread1;
    Thread pipe_thread2;
    UDPRelayServer relayServer;
    InputStream remote_in;
    OutputStream remote_out;
    Socket remote_sock;
    Socket sock;
    ServerSocket ss;

    public ProxyServer(ServerAuthenticator serverAuthenticator) {
        this.msg = null;
        this.sock = null;
        this.remote_sock = null;
        this.ss = null;
        this.relayServer = null;
        this.auth = serverAuthenticator;
    }

    private synchronized void abort() {
        try {
            if (this.mode == 3) {
                return;
            }
            this.mode = 3;
            try {
                log("Aborting operation");
                Socket socket = this.remote_sock;
                if (socket != null) {
                    socket.close();
                }
                Socket socket2 = this.sock;
                if (socket2 != null) {
                    socket2.close();
                }
                UDPRelayServer uDPRelayServer = this.relayServer;
                if (uDPRelayServer != null) {
                    uDPRelayServer.stop();
                }
                ServerSocket serverSocket = this.ss;
                if (serverSocket != null) {
                    serverSocket.close();
                }
                Thread thread = this.pipe_thread1;
                if (thread != null) {
                    thread.interrupt();
                }
                Thread thread2 = this.pipe_thread2;
                if (thread2 != null) {
                    thread2.interrupt();
                }
            } catch (IOException unused) {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static final String command2String(int i) {
        return (i <= 0 || i >= 4) ? za0.h(i, "Unknown Command ") : command_names[i - 1];
    }

    private void doAccept() throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (true) {
            Socket socketAccept = this.ss.accept();
            if (socketAccept.getInetAddress().equals(this.msg.ip)) {
                this.ss.close();
                this.remote_sock = socketAccept;
                this.remote_in = socketAccept.getInputStream();
                this.remote_out = socketAccept.getOutputStream();
                this.remote_sock.setSoTimeout(iddleTimeout);
                log("Accepted from " + socketAccept.getInetAddress() + ":" + socketAccept.getPort());
                (this.msg.version == 5 ? new Socks5Message(0, socketAccept.getInetAddress(), socketAccept.getPort()) : new Socks4Message(90, socketAccept.getInetAddress(), socketAccept.getPort())).write(this.out);
                return;
            }
            if (this.ss instanceof SocksServerSocket) {
                socketAccept.close();
                this.ss.close();
                throw new SocksException(1);
            }
            int i = acceptTimeout;
            if (i != 0) {
                int iCurrentTimeMillis = i - ((int) (System.currentTimeMillis() - jCurrentTimeMillis));
                if (iCurrentTimeMillis <= 0) {
                    throw new InterruptedIOException("In doAccept()");
                }
                this.ss.setSoTimeout(iCurrentTimeMillis);
            }
            socketAccept.close();
        }
    }

    public static Proxy getProxy() {
        return proxy;
    }

    private void handleException(IOException iOException) {
        int i;
        if (this.msg == null || (i = this.mode) == 3 || i == 2) {
            return;
        }
        int i2 = 1;
        int i3 = iOException instanceof SocksException ? ((SocksException) iOException).errCode : iOException instanceof NoRouteToHostException ? 4 : iOException instanceof ConnectException ? 5 : iOException instanceof InterruptedIOException ? 6 : 1;
        if (i3 <= 8 && i3 >= 0) {
            i2 = i3;
        }
        sendErrorMessage(i2);
    }

    public static final void log(ProxyMessage proxyMessage) {
        String str;
        log("Request version:" + proxyMessage.version + "\tCommand: " + command2String(proxyMessage.command));
        StringBuilder sb = new StringBuilder("IP:");
        sb.append(proxyMessage.ip);
        sb.append("\tPort:");
        sb.append(proxyMessage.port);
        if (proxyMessage.version == 4) {
            str = "\tUser:" + proxyMessage.user;
        } else {
            str = "";
        }
        sb.append(str);
        log(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x009a, code lost:
    
        if (r2 == 2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009d, code lost:
    
        r5.remote_out.write(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onBind(net.sourceforge.jsocks.ProxyMessage r6) throws java.io.IOException {
        /*
            r5 = this;
            net.sourceforge.jsocks.Proxy r0 = net.sourceforge.jsocks.ProxyServer.proxy
            r1 = 0
            if (r0 != 0) goto Ld
            java.net.ServerSocket r0 = new java.net.ServerSocket
            r0.<init>(r1)
            r5.ss = r0
            goto L1a
        Ld:
            net.sourceforge.jsocks.SocksServerSocket r0 = new net.sourceforge.jsocks.SocksServerSocket
            net.sourceforge.jsocks.Proxy r2 = net.sourceforge.jsocks.ProxyServer.proxy
            java.net.InetAddress r3 = r6.ip
            int r4 = r6.port
            r0.<init>(r2, r3, r4)
            r5.ss = r0
        L1a:
            java.net.ServerSocket r0 = r5.ss
            int r2 = net.sourceforge.jsocks.ProxyServer.acceptTimeout
            r0.setSoTimeout(r2)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Trying accept on "
            r0.<init>(r2)
            java.net.ServerSocket r2 = r5.ss
            java.net.InetAddress r2 = r2.getInetAddress()
            r0.append(r2)
            java.lang.String r2 = ":"
            r0.append(r2)
            java.net.ServerSocket r2 = r5.ss
            int r2 = r2.getLocalPort()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            log(r0)
            int r6 = r6.version
            r0 = 5
            if (r6 != r0) goto L5d
            net.sourceforge.jsocks.Socks5Message r6 = new net.sourceforge.jsocks.Socks5Message
            java.net.ServerSocket r0 = r5.ss
            java.net.InetAddress r0 = r0.getInetAddress()
            java.net.ServerSocket r2 = r5.ss
            int r2 = r2.getLocalPort()
            r6.<init>(r1, r0, r2)
            goto L70
        L5d:
            net.sourceforge.jsocks.Socks4Message r6 = new net.sourceforge.jsocks.Socks4Message
            java.net.ServerSocket r0 = r5.ss
            java.net.InetAddress r0 = r0.getInetAddress()
            java.net.ServerSocket r2 = r5.ss
            int r2 = r2.getLocalPort()
            r3 = 90
            r6.<init>(r3, r0, r2)
        L70:
            java.io.OutputStream r0 = r5.out
            r6.write(r0)
            r6 = 1
            r5.mode = r6
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r5.pipe_thread1 = r0
            java.lang.Thread r0 = new java.lang.Thread
            r0.<init>(r5)
            r5.pipe_thread2 = r0
            r0.start()
            java.net.Socket r0 = r5.sock
            r0.setSoTimeout(r1)
        L8d:
            r0 = 2
            java.io.InputStream r2 = r5.in     // Catch: java.lang.Throwable -> La3 java.io.InterruptedIOException -> La5 java.io.EOFException -> Lb4
            int r1 = r2.read()     // Catch: java.lang.Throwable -> La3 java.io.InterruptedIOException -> La5 java.io.EOFException -> Lb4
            if (r1 < 0) goto Laa
            int r2 = r5.mode     // Catch: java.lang.Throwable -> La3 java.io.InterruptedIOException -> La5 java.io.EOFException -> Lb4
            if (r2 == r6) goto L8d
            if (r2 == r0) goto L9d
            goto Lb4
        L9d:
            java.io.OutputStream r6 = r5.remote_out     // Catch: java.lang.Throwable -> La3 java.io.InterruptedIOException -> La5 java.io.EOFException -> Lb4
            r6.write(r1)     // Catch: java.lang.Throwable -> La3 java.io.InterruptedIOException -> La5 java.io.EOFException -> Lb4
            goto Laa
        La3:
            r6 = move-exception
            throw r6
        La5:
            int r6 = r5.mode
            if (r6 == r0) goto Laa
            goto Lb4
        Laa:
            if (r1 >= 0) goto Lad
            goto Lb4
        Lad:
            java.io.InputStream r6 = r5.in
            java.io.OutputStream r0 = r5.remote_out
            r5.pipe(r6, r0)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sourceforge.jsocks.ProxyServer.onBind(net.sourceforge.jsocks.ProxyMessage):void");
    }

    private void onConnect(ProxyMessage proxyMessage) {
        Socket socket = new Socket(proxyMessage.ip, proxyMessage.port);
        log("Connected to " + socket.getInetAddress() + ":" + socket.getPort());
        (proxyMessage instanceof Socks5Message ? new Socks5Message(0, socket.getLocalAddress(), socket.getLocalPort()) : new Socks4Message(90, socket.getLocalAddress(), socket.getLocalPort())).write(this.out);
        startPipe(socket);
    }

    private void onUDP(ProxyMessage proxyMessage) throws IOException {
        if (proxyMessage.ip.getHostAddress().equals("0.0.0.0")) {
            proxyMessage.ip = this.sock.getInetAddress();
        }
        log("Creating UDP relay server for " + proxyMessage.ip + ":" + proxyMessage.port);
        UDPRelayServer uDPRelayServer = new UDPRelayServer(proxyMessage.ip, proxyMessage.port, Thread.currentThread(), this.sock, this.auth);
        this.relayServer = uDPRelayServer;
        new Socks5Message(0, uDPRelayServer.relayIP, uDPRelayServer.relayPort).write(this.out);
        this.relayServer.start();
        this.sock.setSoTimeout(0);
        do {
            try {
            } catch (EOFException unused) {
                return;
            }
        } while (this.in.read() >= 0);
    }

    private void pipe(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.lastReadTime = System.currentTimeMillis();
        byte[] bArr = new byte[8192];
        do {
            int i = 0;
            while (i >= 0) {
                if (i != 0) {
                    try {
                        outputStream.write(bArr, 0, i);
                        outputStream.flush();
                    } catch (InterruptedIOException unused) {
                        if (iddleTimeout == 0) {
                            return;
                        }
                    }
                }
                i = inputStream.read(bArr);
                this.lastReadTime = System.currentTimeMillis();
            }
            return;
        } while (System.currentTimeMillis() - this.lastReadTime < iddleTimeout - 1000);
    }

    private void sendErrorMessage(int i) {
        try {
            (this.msg instanceof Socks4Message ? new Socks4Message(91) : new Socks5Message(i)).write(this.out);
        } catch (IOException unused) {
        }
    }

    public static void setAcceptTimeout(int i) {
        acceptTimeout = i;
    }

    public static void setDatagramSize(int i) {
        UDPRelayServer.setDatagramSize(i);
    }

    public static void setIddleTimeout(int i) {
        iddleTimeout = i;
    }

    public static void setLog(OutputStream outputStream) {
        if (outputStream == null) {
            log = null;
        } else {
            log = new PrintStream(outputStream, true);
        }
        UDPRelayServer.log = log;
    }

    public static void setProxy(Proxy proxy2) {
        proxy = proxy2;
        UDPRelayServer.proxy = proxy2;
    }

    public static void setUDPTimeout(int i) {
        UDPRelayServer.setTimeout(i);
    }

    private void startPipe(Socket socket) {
        this.mode = 2;
        this.remote_sock = socket;
        try {
            this.remote_in = socket.getInputStream();
            this.remote_out = socket.getOutputStream();
            this.pipe_thread1 = Thread.currentThread();
            Thread thread = new Thread(this);
            this.pipe_thread2 = thread;
            thread.start();
            pipe(this.in, this.remote_out);
        } catch (IOException unused) {
        }
    }

    private void startSession() throws IOException {
        this.sock.setSoTimeout(iddleTimeout);
        try {
            ServerAuthenticator serverAuthenticatorStartSession = this.auth.startSession(this.sock);
            this.auth = serverAuthenticatorStartSession;
            if (serverAuthenticatorStartSession == null) {
                log("Authentication failed");
                return;
            }
            this.in = serverAuthenticatorStartSession.getInputStream();
            this.out = this.auth.getOutputStream();
            ProxyMessage msg = readMsg(this.in);
            this.msg = msg;
            handleRequest(msg);
        } catch (IOException e) {
            log("Auth throwed exception:" + e);
            this.auth = null;
        }
    }

    public void handleRequest(ProxyMessage proxyMessage) throws IOException {
        if (!this.auth.checkRequest(proxyMessage)) {
            throw new SocksException(1);
        }
        if (proxyMessage.ip == null) {
            if (!(proxyMessage instanceof Socks5Message)) {
                throw new SocksException(1);
            }
            proxyMessage.ip = InetAddress.getByName(proxyMessage.host);
        }
        log(proxyMessage);
        int i = proxyMessage.command;
        if (i == 1) {
            onConnect(proxyMessage);
        } else if (i == 2) {
            onBind(proxyMessage);
        } else {
            if (i != 3) {
                throw new SocksException(7);
            }
            onUDP(proxyMessage);
        }
    }

    public ProxyMessage readMsg(InputStream inputStream) throws IOException {
        PushbackInputStream pushbackInputStream = inputStream instanceof PushbackInputStream ? (PushbackInputStream) inputStream : new PushbackInputStream(inputStream);
        int i = pushbackInputStream.read();
        pushbackInputStream.unread(i);
        if (i == 5) {
            return new Socks5Message(pushbackInputStream, false);
        }
        if (i == 4) {
            return new Socks4Message(pushbackInputStream, false);
        }
        throw new SocksException(1);
    }

    @Override // java.lang.Runnable
    public void run() {
        ServerAuthenticator serverAuthenticator;
        int i = this.mode;
        try {
            if (i == 0) {
                try {
                    startSession();
                } catch (IOException e) {
                    handleException(e);
                    abort();
                    serverAuthenticator = this.auth != null ? this.auth : serverAuthenticator;
                }
                return;
            }
            if (i == 1) {
                try {
                    try {
                        doAccept();
                        this.mode = 2;
                        this.pipe_thread1.interrupt();
                        pipe(this.remote_in, this.out);
                    } catch (IOException e2) {
                        handleException(e2);
                    }
                    return;
                } finally {
                    abort();
                    log("Accept thread(remote->client) stopped");
                }
            }
            if (i != 2) {
                if (i != 3) {
                    log("Unexpected MODE " + this.mode);
                    return;
                }
                return;
            }
            try {
                pipe(this.remote_in, this.out);
            } catch (IOException unused) {
            } catch (Throwable th) {
                abort();
                log("Support thread(remote->client) stopped");
                throw th;
            }
            abort();
            log("Support thread(remote->client) stopped");
        } finally {
            abort();
            serverAuthenticator = this.auth;
            if (serverAuthenticator != null) {
                serverAuthenticator.endSession();
            }
            log("Main thread(client->remote)stopped.");
        }
    }

    public void start(int i) {
        start(i, 5, null);
    }

    public void stop() {
        try {
            ServerSocket serverSocket = this.ss;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException unused) {
        }
    }

    public void start(int i, int i2, InetAddress inetAddress) {
        try {
            this.ss = new ServerSocket(i, i2, inetAddress);
            log("Starting SOCKS Proxy on:" + this.ss.getInetAddress().getHostAddress() + ":" + this.ss.getLocalPort());
            while (true) {
                Socket socketAccept = this.ss.accept();
                log("Accepted from:" + socketAccept.getInetAddress().getHostName() + ":" + socketAccept.getPort());
                new Thread(new ProxyServer(this.auth, socketAccept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProxyServer(ServerAuthenticator serverAuthenticator, Socket socket) {
        this.msg = null;
        this.remote_sock = null;
        this.ss = null;
        this.relayServer = null;
        this.auth = serverAuthenticator;
        this.sock = socket;
        this.mode = 0;
    }

    public static final void log(String str) {
        PrintStream printStream = log;
        if (printStream != null) {
            printStream.println(str);
            log.flush();
        }
    }
}
