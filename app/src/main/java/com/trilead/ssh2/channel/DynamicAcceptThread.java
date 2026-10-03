package com.trilead.ssh2.channel;

import com.trilead.ssh2.log.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;
import net.sourceforge.jsocks.ProxyMessage;
import net.sourceforge.jsocks.Socks5Message;
import net.sourceforge.jsocks.SocksException;
import net.sourceforge.jsocks.server.ServerAuthenticator;
import net.sourceforge.jsocks.server.ServerAuthenticatorNone;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DynamicAcceptThread extends Thread implements IChannelWorkerThread {
    private static final int MAX_THREAD_COUNT = 25;
    private static final Logger log = Logger.getLogger(DynamicAcceptThread.class);
    private final ChannelManager cm;
    private final ServerSocket ss;
    private final Semaphore threadBound;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class DynamicAcceptRunnable implements Runnable {
        private static final int idleTimeout = 360000;
        private ServerAuthenticator auth;
        private InputStream in;
        private ProxyMessage msg;
        private OutputStream out;
        private final Socket sock;

        public DynamicAcceptRunnable(ServerAuthenticator serverAuthenticator, Socket socket) {
            this.auth = serverAuthenticator;
            this.sock = socket;
            DynamicAcceptThread.this.setName("DynamicAcceptRunnable");
        }

        private void handleRequest(ProxyMessage proxyMessage) throws IOException {
            if (!this.auth.checkRequest(proxyMessage)) {
                throw new SocksException(1);
            }
            if (proxyMessage.command != 1) {
                throw new SocksException(7);
            }
            onConnect(proxyMessage);
        }

        private void onConnect(ProxyMessage proxyMessage) throws IOException {
            new Socks5Message(0, (InetAddress) null, 0).write(this.out);
            String hostAddress = proxyMessage.host;
            InetAddress inetAddress = proxyMessage.ip;
            if (inetAddress != null) {
                hostAddress = inetAddress.getHostAddress();
            }
            try {
                try {
                    Channel channelOpenDirectTCPIPChannel = DynamicAcceptThread.this.cm.openDirectTCPIPChannel(hostAddress, proxyMessage.port, "127.0.0.1", 0);
                    try {
                        StreamForwarder streamForwarder = new StreamForwarder(channelOpenDirectTCPIPChannel, null, null, channelOpenDirectTCPIPChannel.getStdoutStream(), this.out, "RemoteToLocal");
                        StreamForwarder streamForwarder2 = new StreamForwarder(channelOpenDirectTCPIPChannel, streamForwarder, this.sock, this.in, channelOpenDirectTCPIPChannel.stdinStream, "LocalToRemote");
                        streamForwarder.setDaemon(true);
                        streamForwarder2.setDaemon(true);
                        streamForwarder.start();
                        streamForwarder2.start();
                    } catch (IOException e) {
                        channelOpenDirectTCPIPChannel.cm.closeChannel(channelOpenDirectTCPIPChannel, "Weird error during creation of StreamForwarder (" + e.getMessage() + ")", true);
                    }
                } catch (IOException unused) {
                    this.sock.close();
                }
            } catch (IOException unused2) {
            }
        }

        private ProxyMessage readMsg(InputStream inputStream) throws IOException {
            PushbackInputStream pushbackInputStream = inputStream instanceof PushbackInputStream ? (PushbackInputStream) inputStream : new PushbackInputStream(inputStream);
            int i = pushbackInputStream.read();
            pushbackInputStream.unread(i);
            if (i == 5) {
                return new Socks5Message(pushbackInputStream, false);
            }
            throw new SocksException(1);
        }

        private void sendErrorMessage(int i) {
            try {
                new Socks5Message(i).write(this.out);
            } catch (IOException unused) {
            }
        }

        private void startSession() throws IOException {
            this.sock.setSoTimeout(idleTimeout);
            try {
                ServerAuthenticator serverAuthenticatorStartSession = this.auth.startSession(this.sock);
                this.auth = serverAuthenticatorStartSession;
                if (serverAuthenticatorStartSession == null) {
                    DynamicAcceptThread.log.log(50, "SOCKS auth failed");
                    return;
                }
                this.in = serverAuthenticatorStartSession.getInputStream();
                this.out = this.auth.getOutputStream();
                ProxyMessage msg = readMsg(this.in);
                this.msg = msg;
                handleRequest(msg);
            } catch (IOException e) {
                DynamicAcceptThread.log.log(50, "Could not start SOCKS session");
                e.printStackTrace();
                this.auth = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ServerAuthenticator serverAuthenticator;
            try {
                try {
                    try {
                        startSession();
                    } catch (Error unused) {
                        System.gc();
                        if (this.auth != null) {
                            serverAuthenticator = this.auth;
                            serverAuthenticator.endSession();
                        }
                        DynamicAcceptThread.this.threadBound.release();
                    }
                } catch (IOException e) {
                    int i = 1;
                    int i2 = e instanceof SocksException ? ((SocksException) e).errCode : e instanceof NoRouteToHostException ? 4 : e instanceof ConnectException ? 5 : e instanceof InterruptedIOException ? 6 : 1;
                    if (i2 <= 8 && i2 >= 0) {
                        i = i2;
                    }
                    sendErrorMessage(i);
                    serverAuthenticator = this.auth;
                    if (serverAuthenticator != null) {
                        serverAuthenticator.endSession();
                    }
                    DynamicAcceptThread.this.threadBound.release();
                }
            } finally {
                ServerAuthenticator serverAuthenticator2 = this.auth;
                if (serverAuthenticator2 != null) {
                    serverAuthenticator2.endSession();
                }
                DynamicAcceptThread.this.threadBound.release();
            }
        }
    }

    public DynamicAcceptThread(ChannelManager channelManager, InetSocketAddress inetSocketAddress, int i) throws IOException {
        this.cm = channelManager;
        setName("DynamicAcceptThread");
        ServerSocket serverSocket = new ServerSocket();
        this.ss = serverSocket;
        serverSocket.bind(inetSocketAddress);
        this.threadBound = new Semaphore(i < 2 ? 25 : i);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.cm.registerThread(this);
            while (true) {
                try {
                    Socket socketAccept = this.ss.accept();
                    this.threadBound.acquireUninterruptibly();
                    Thread thread = new Thread(new DynamicAcceptRunnable(new ServerAuthenticatorNone(), socketAccept));
                    thread.setDaemon(true);
                    thread.start();
                } catch (IOException unused) {
                    stopWorking();
                    return;
                }
            }
        } catch (IOException unused2) {
            stopWorking();
        }
    }

    @Override // com.trilead.ssh2.channel.IChannelWorkerThread
    public void stopWorking() {
        try {
            this.ss.close();
        } catch (IOException unused) {
        }
    }

    public DynamicAcceptThread(ChannelManager channelManager, int i, int i2) {
        this.cm = channelManager;
        setName("DynamicAcceptThread");
        this.ss = new ServerSocket(i);
        this.threadBound = new Semaphore(i2 < 2 ? 25 : i2);
    }
}
