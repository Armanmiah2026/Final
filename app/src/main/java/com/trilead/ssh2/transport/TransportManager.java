package com.trilead.ssh2.transport;

import com.trilead.ssh2.ConnectionInfo;
import com.trilead.ssh2.ConnectionMonitor;
import com.trilead.ssh2.DHGexParameters;
import com.trilead.ssh2.ProxyData;
import com.trilead.ssh2.ServerHostKeyVerifier;
import com.trilead.ssh2.crypto.CryptoWishList;
import com.trilead.ssh2.crypto.cipher.BlockCipher;
import com.trilead.ssh2.crypto.digest.MAC;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.PacketDisconnect;
import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.util.Tokenizer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.SecureRandom;
import java.util.Vector;
import net.sourceforge.jsocks.Proxy;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class TransportManager {
    private final Vector asynchronousQueue;
    private Thread asynchronousThread;
    Vector connectionMonitors;
    final Object connectionSemaphore;
    boolean flagKexOngoing;
    String hostname;
    KexManager km;
    Vector messageHandlers;
    boolean monitorsWereInformed;
    int port;
    ProxyData proxyData;
    Throwable reasonClosedCause;
    Thread receiveThread;
    Socket sock;
    private final String sourceAddress;
    TransportConnection tc;
    private ClientServerHello versions;
    private static final Logger log = Logger.getLogger(TransportManager.class);
    public static final int MAX_PACKET_SIZE = Integer.getInteger(TransportManager.class.getName().concat(".maxPacketSize"), Proxy.SOCKS_NO_PROXY).intValue();

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class AsynchronousWorker extends Thread {
        public AsynchronousWorker() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            while (true) {
                synchronized (TransportManager.this.asynchronousQueue) {
                    if (TransportManager.this.asynchronousQueue.size() == 0) {
                        try {
                            TransportManager.this.asynchronousQueue.wait(2000L);
                        } catch (InterruptedException unused) {
                        }
                        if (TransportManager.this.asynchronousQueue.size() == 0) {
                            TransportManager.this.asynchronousThread = null;
                            return;
                        }
                    }
                    bArr = (byte[]) TransportManager.this.asynchronousQueue.remove(0);
                }
                try {
                    TransportManager.this.sendMessage(bArr);
                } catch (IOException unused2) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class HandlerEntry {
        int high;
        int low;
        MessageHandler mh;

        public HandlerEntry() {
        }
    }

    public TransportManager(String str, int i) {
        this(str, i, null);
    }

    private Socket connectDirect(String str, int i, int i2, int i3) throws IOException {
        Socket socket = new Socket();
        String str2 = this.sourceAddress;
        if (str2 != null) {
            socket.bind(new InetSocketAddress(createInetAddress(str2), 0));
        }
        socket.connect(new InetSocketAddress(createInetAddress(str), i), i2);
        socket.setSoTimeout(i3);
        return socket;
    }

    public static InetAddress createInetAddress(String str) {
        InetAddress iPv4Address = parseIPv4Address(str);
        return iPv4Address != null ? iPv4Address : InetAddress.getByName(str);
    }

    private void ensureConnected() throws IOException {
        if (this.reasonClosedCause != null) {
            throw new IOException("Sorry, this connection is closed.", this.reasonClosedCause);
        }
    }

    private void establishConnection(ProxyData proxyData, int i, int i2) {
        if (proxyData == null) {
            this.sock = connectDirect(this.hostname, this.port, i, i2);
        } else {
            this.sock = proxyData.openConnection(this.hostname, this.port, i, i2);
        }
    }

    private static InetAddress parseIPv4Address(String str) {
        String[] tokens;
        if (str == null || (tokens = Tokenizer.parseTokens(str, '.')) == null || tokens.length != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            if (tokens[i].length() == 0 || tokens[i].length() > 3) {
                return null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < tokens[i].length(); i3++) {
                char cCharAt = tokens[i].charAt(i3);
                if (cCharAt < '0' || cCharAt > '9') {
                    return null;
                }
                i2 = (i2 * 10) + (cCharAt - '0');
            }
            if (i2 > 255) {
                return null;
            }
            bArr[i] = (byte) i2;
        }
        return InetAddress.getByAddress(str, bArr);
    }

    public void changeRecvCipher(BlockCipher blockCipher, MAC mac) {
        this.tc.changeRecvCipher(blockCipher, mac);
    }

    public void changeSendCipher(BlockCipher blockCipher, MAC mac) {
        this.tc.changeSendCipher(blockCipher, mac);
    }

    public void close(Throwable th, boolean z) {
        Vector vector;
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(50, "Closing all conections");
        }
        if (!z) {
            try {
                ProxyData proxyData = this.proxyData;
                if (proxyData != null) {
                    proxyData.close();
                }
                Socket socket = this.sock;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException unused) {
            }
        }
        synchronized (this.connectionSemaphore) {
            if (this.reasonClosedCause == null) {
                if (z) {
                    try {
                        byte[] payload = new PacketDisconnect(11, th.getMessage(), "").getPayload();
                        TransportConnection transportConnection = this.tc;
                        if (transportConnection != null) {
                            transportConnection.sendMessage(payload);
                        }
                    } catch (IOException unused2) {
                    }
                    try {
                        ProxyData proxyData2 = this.proxyData;
                        if (proxyData2 != null) {
                            proxyData2.close();
                        }
                        Socket socket2 = this.sock;
                        if (socket2 != null) {
                            socket2.close();
                        }
                    } catch (IOException unused3) {
                    }
                }
                if (th == null) {
                    th = new Exception("Unknown cause");
                }
                this.reasonClosedCause = th;
            }
            this.connectionSemaphore.notifyAll();
        }
        synchronized (this) {
            try {
                if (this.monitorsWereInformed) {
                    vector = null;
                } else {
                    this.monitorsWereInformed = true;
                    vector = (Vector) this.connectionMonitors.clone();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {
                try {
                    ((ConnectionMonitor) vector.elementAt(i)).connectionLost(this.reasonClosedCause);
                } catch (Exception unused4) {
                }
            }
        }
    }

    public void forceKeyExchange(CryptoWishList cryptoWishList, DHGexParameters dHGexParameters) {
        this.km.initiateKEX(cryptoWishList, dHGexParameters);
    }

    public ConnectionInfo getConnectionInfo(int i) {
        return this.km.getOrWaitForConnectionInfo(i);
    }

    public int getPacketOverheadEstimate() {
        return this.tc.getPacketOverheadEstimate();
    }

    public Throwable getReasonClosedCause() {
        Throwable th;
        synchronized (this.connectionSemaphore) {
            th = this.reasonClosedCause;
        }
        return th;
    }

    public byte[] getSessionIdentifier() {
        return this.km.sessionId;
    }

    public ClientServerHello getVersionInfo() {
        return this.versions;
    }

    public void initialize(CryptoWishList cryptoWishList, ServerHostKeyVerifier serverHostKeyVerifier, DHGexParameters dHGexParameters, int i, SecureRandom secureRandom, ProxyData proxyData) {
        initialize(cryptoWishList, serverHostKeyVerifier, dHGexParameters, i, 0, secureRandom, proxyData);
    }

    public boolean isConnectionClosed() {
        return getReasonClosedCause() != null;
    }

    public void kexFinished() {
        synchronized (this.connectionSemaphore) {
            this.flagKexOngoing = false;
            this.connectionSemaphore.notifyAll();
        }
    }

    public void receiveLoop() throws IOException {
        MessageHandler messageHandler;
        int i = MAX_PACKET_SIZE;
        byte[] bArr = new byte[i];
        while (true) {
            int i2 = 0;
            int iReceiveMessage = this.tc.receiveMessage(bArr, 0, i);
            int i3 = bArr[0] & 255;
            if (i3 != 2) {
                if (i3 == 4) {
                    if (log.isEnabled()) {
                        TypesReader typesReader = new TypesReader(bArr, 0, iReceiveMessage);
                        typesReader.readByte();
                        typesReader.readBoolean();
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(typesReader.readString("UTF-8"));
                        while (i2 < stringBuffer.length()) {
                            char cCharAt = stringBuffer.charAt(i2);
                            if (cCharAt < ' ' || cCharAt > '~') {
                                stringBuffer.setCharAt(i2, (char) 65533);
                            }
                            i2++;
                        }
                        log.log(50, "DEBUG Message from remote: '" + ((Object) stringBuffer) + "'");
                    }
                } else {
                    if (i3 == 3) {
                        throw new IOException("Peer sent UNIMPLEMENTED message, that should not happen.");
                    }
                    if (i3 == 1) {
                        TypesReader typesReader2 = new TypesReader(bArr, 0, iReceiveMessage);
                        typesReader2.readByte();
                        int uint32 = typesReader2.readUINT32();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(typesReader2.readString("UTF-8"));
                        if (stringBuffer2.length() > 255) {
                            stringBuffer2.setLength(255);
                            stringBuffer2.setCharAt(254, '.');
                            stringBuffer2.setCharAt(253, '.');
                            stringBuffer2.setCharAt(252, '.');
                        }
                        while (i2 < stringBuffer2.length()) {
                            char cCharAt2 = stringBuffer2.charAt(i2);
                            if (cCharAt2 < ' ' || cCharAt2 > '~') {
                                stringBuffer2.setCharAt(i2, (char) 65533);
                            }
                            i2++;
                        }
                        throw new IOException("Peer sent DISCONNECT message (reason code " + uint32 + "): " + ((Object) stringBuffer2));
                    }
                    if (i3 == 20 || i3 == 21 || (i3 >= 30 && i3 <= 49)) {
                        this.km.handleMessage(bArr, iReceiveMessage);
                    } else {
                        while (true) {
                            if (i2 >= this.messageHandlers.size()) {
                                messageHandler = null;
                                break;
                            }
                            HandlerEntry handlerEntry = (HandlerEntry) this.messageHandlers.elementAt(i2);
                            if (handlerEntry.low <= i3 && i3 <= handlerEntry.high) {
                                messageHandler = handlerEntry.mh;
                                break;
                            }
                            i2++;
                        }
                        if (messageHandler == null) {
                            throw new IOException(za0.i(i3, "Unexpected SSH message (type ", ")"));
                        }
                        messageHandler.handleMessage(bArr, iReceiveMessage);
                    }
                }
            }
        }
    }

    public void registerMessageHandler(MessageHandler messageHandler, int i, int i2) {
        HandlerEntry handlerEntry = new HandlerEntry();
        handlerEntry.mh = messageHandler;
        handlerEntry.low = i;
        handlerEntry.high = i2;
        synchronized (this.messageHandlers) {
            this.messageHandlers.addElement(handlerEntry);
        }
    }

    public void removeMessageHandler(MessageHandler messageHandler, int i, int i2) {
        synchronized (this.messageHandlers) {
            int i3 = 0;
            while (true) {
                try {
                    if (i3 >= this.messageHandlers.size()) {
                        break;
                    }
                    HandlerEntry handlerEntry = (HandlerEntry) this.messageHandlers.elementAt(i3);
                    if (handlerEntry.mh == messageHandler && handlerEntry.low == i && handlerEntry.high == i2) {
                        this.messageHandlers.removeElementAt(i3);
                        break;
                    }
                    i3++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void sendAsynchronousMessage(byte[] bArr) {
        synchronized (this.asynchronousQueue) {
            try {
                this.asynchronousQueue.addElement(bArr);
                if (this.asynchronousQueue.size() > 100) {
                    throw new IOException("Error: the peer is not consuming our asynchronous replies.");
                }
                if (this.asynchronousThread == null) {
                    AsynchronousWorker asynchronousWorker = new AsynchronousWorker();
                    this.asynchronousThread = asynchronousWorker;
                    asynchronousWorker.setDaemon(true);
                    this.asynchronousThread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void sendKexMessage(byte[] bArr) {
        synchronized (this.connectionSemaphore) {
            try {
                ensureConnected();
                this.flagKexOngoing = true;
                try {
                    this.tc.sendMessage(bArr);
                } catch (IOException e) {
                    close(e, false);
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void sendMessage(byte[] bArr) throws IOException {
        if (Thread.currentThread() == this.receiveThread) {
            throw new IOException("Assertion error: sendMessage may never be invoked by the receiver thread!");
        }
        synchronized (this.connectionSemaphore) {
            while (true) {
                try {
                    ensureConnected();
                    if (this.flagKexOngoing) {
                        try {
                            this.connectionSemaphore.wait();
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    } else {
                        try {
                            this.tc.sendMessage(bArr);
                        } catch (IOException e) {
                            close(e, false);
                            throw e;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
                throw th;
            }
        }
    }

    public void setConnectionMonitors(Vector vector) {
        synchronized (this) {
            this.connectionMonitors = (Vector) vector.clone();
        }
    }

    public void setSoTimeout(int i) throws SocketException {
        this.sock.setSoTimeout(i);
    }

    public void setTcpNoDelay(boolean z) throws SocketException {
        this.sock.setTcpNoDelay(z);
    }

    public TransportManager(String str, int i, String str2) {
        this.asynchronousQueue = new Vector();
        this.asynchronousThread = null;
        this.connectionSemaphore = new Object();
        this.flagKexOngoing = false;
        this.reasonClosedCause = null;
        this.messageHandlers = new Vector();
        this.connectionMonitors = new Vector();
        this.monitorsWereInformed = false;
        this.hostname = str;
        this.port = i;
        this.sourceAddress = str2;
    }

    public void initialize(CryptoWishList cryptoWishList, ServerHostKeyVerifier serverHostKeyVerifier, DHGexParameters dHGexParameters, int i, int i2, SecureRandom secureRandom, ProxyData proxyData) {
        this.proxyData = proxyData;
        establishConnection(proxyData, i, i2);
        ClientServerHello clientServerHello = new ClientServerHello(this.sock.getInputStream(), this.sock.getOutputStream());
        this.versions = clientServerHello;
        this.tc = new TransportConnection(this.sock.getInputStream(), this.sock.getOutputStream(), secureRandom);
        KexManager kexManager = new KexManager(this, clientServerHello, cryptoWishList, this.hostname, this.port, serverHostKeyVerifier, secureRandom);
        this.km = kexManager;
        kexManager.initiateKEX(cryptoWishList, dHGexParameters);
        Thread thread = new Thread(new Runnable() { // from class: com.trilead.ssh2.transport.TransportManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TransportManager.this.receiveLoop();
                    e = new AssertionError();
                } catch (IOException e) {
                    e = e;
                    if (TransportManager.log.isEnabled() && !TransportManager.this.isConnectionClosed()) {
                        TransportManager.log.log(10, "Receive thread: error in receiveLoop", e);
                    }
                    TransportManager.this.close(e, false);
                }
                if (TransportManager.log.isEnabled()) {
                    TransportManager.log.log(50, "Receive thread: back from receiveLoop");
                }
                KexManager kexManager2 = TransportManager.this.km;
                if (kexManager2 != null) {
                    try {
                        kexManager2.handleEndMessage(e);
                    } catch (IOException unused) {
                    }
                }
                for (int i3 = 0; i3 < TransportManager.this.messageHandlers.size(); i3++) {
                    try {
                        ((HandlerEntry) TransportManager.this.messageHandlers.elementAt(i3)).mh.handleEndMessage(e);
                    } catch (Exception unused2) {
                    }
                }
            }
        });
        this.receiveThread = thread;
        thread.setDaemon(true);
        this.receiveThread.start();
    }
}
