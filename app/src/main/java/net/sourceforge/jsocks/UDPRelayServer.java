package net.sourceforge.jsocks;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import net.sourceforge.jsocks.server.ServerAuthenticator;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
class UDPRelayServer implements Runnable {
    static int datagramSize = 65535;
    static int iddleTimeout = 180000;
    static PrintStream log;
    static Proxy proxy;
    ServerAuthenticator auth;
    DatagramSocket client_sock;
    Socket controlConnection;
    long lastReadTime;
    Thread master_thread;
    Thread pipe_thread1;
    Thread pipe_thread2;
    InetAddress relayIP;
    int relayPort;
    DatagramSocket remote_sock;

    public UDPRelayServer(InetAddress inetAddress, int i, Thread thread, Socket socket, ServerAuthenticator serverAuthenticator) {
        this.master_thread = thread;
        this.controlConnection = socket;
        this.auth = serverAuthenticator;
        Socks5DatagramSocket socks5DatagramSocket = new Socks5DatagramSocket(true, serverAuthenticator.getUdpEncapsulation(), inetAddress, i);
        this.client_sock = socks5DatagramSocket;
        this.relayPort = socks5DatagramSocket.getLocalPort();
        InetAddress localAddress = this.client_sock.getLocalAddress();
        this.relayIP = localAddress;
        if (localAddress.getHostAddress().equals("0.0.0.0")) {
            this.relayIP = InetAddress.getLocalHost();
        }
        if (proxy == null) {
            this.remote_sock = new DatagramSocket();
        } else {
            this.remote_sock = new Socks5DatagramSocket(proxy, 0, null);
        }
    }

    private synchronized void abort() {
        if (this.pipe_thread1 == null) {
            return;
        }
        log("Aborting UDP Relay Server");
        this.remote_sock.close();
        this.client_sock.close();
        Socket socket = this.controlConnection;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
        Thread thread = this.master_thread;
        if (thread != null) {
            thread.interrupt();
        }
        this.pipe_thread1.interrupt();
        this.pipe_thread2.interrupt();
        this.pipe_thread1 = null;
    }

    private static void log(String str) {
        PrintStream printStream = log;
        if (printStream != null) {
            printStream.println(str);
            log.flush();
        }
    }

    private void pipe(DatagramSocket datagramSocket, DatagramSocket datagramSocket2, boolean z) throws IOException {
        int i = datagramSize;
        DatagramPacket datagramPacket = new DatagramPacket(new byte[i], i);
        while (true) {
            try {
                datagramSocket.receive(datagramPacket);
                this.lastReadTime = System.currentTimeMillis();
                if (this.auth.checkRequest(datagramPacket, z)) {
                    datagramSocket2.send(datagramPacket);
                }
            } catch (InterruptedIOException unused) {
                if (iddleTimeout == 0 || System.currentTimeMillis() - this.lastReadTime >= iddleTimeout - 100) {
                    return;
                }
            } catch (UnknownHostException unused2) {
                log("Dropping datagram for unknown host");
            }
            datagramPacket.setLength(i);
        }
    }

    public static void setDatagramSize(int i) {
        datagramSize = i;
    }

    public static void setTimeout(int i) {
        iddleTimeout = i;
    }

    public InetAddress getRelayIP() {
        return this.relayIP;
    }

    public int getRelayPort() {
        return this.relayPort;
    }

    @Override // java.lang.Runnable
    public void run() {
        StringBuilder sb;
        try {
            if (Thread.currentThread().getName().equals("pipe1")) {
                pipe(this.remote_sock, this.client_sock, false);
            } else {
                pipe(this.client_sock, this.remote_sock, true);
            }
            abort();
            sb = new StringBuilder("UDP Pipe thread ");
        } catch (IOException unused) {
            abort();
            sb = new StringBuilder("UDP Pipe thread ");
        } catch (Throwable th) {
            abort();
            log("UDP Pipe thread " + Thread.currentThread().getName() + " stopped.");
            throw th;
        }
        sb.append(Thread.currentThread().getName());
        sb.append(" stopped.");
        log(sb.toString());
    }

    public void start() throws SocketException {
        this.remote_sock.setSoTimeout(iddleTimeout);
        this.client_sock.setSoTimeout(iddleTimeout);
        log("Starting UDP relay server on " + this.relayIP + ":" + this.relayPort);
        log("Remote socket " + this.remote_sock.getLocalAddress() + ":" + this.remote_sock.getLocalPort());
        this.pipe_thread1 = new Thread(this, "pipe1");
        this.pipe_thread2 = new Thread(this, "pipe2");
        this.lastReadTime = System.currentTimeMillis();
        this.pipe_thread1.start();
        this.pipe_thread2.start();
    }

    public synchronized void stop() {
        this.master_thread = null;
        this.controlConnection = null;
        abort();
    }
}
