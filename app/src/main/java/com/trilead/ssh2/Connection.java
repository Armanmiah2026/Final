package com.trilead.ssh2;

import com.trilead.ssh2.auth.AgentProxy;
import com.trilead.ssh2.auth.AuthenticationManager;
import com.trilead.ssh2.channel.ChannelManager;
import com.trilead.ssh2.crypto.CryptoWishList;
import com.trilead.ssh2.crypto.cipher.BlockCipherFactory;
import com.trilead.ssh2.crypto.digest.MessageMac;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.PacketIgnore;
import com.trilead.ssh2.transport.ClientServerHello;
import com.trilead.ssh2.transport.KexManager;
import com.trilead.ssh2.transport.TransportManager;
import com.trilead.ssh2.util.TimeoutService;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.util.Vector;
import sensei0.b0;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Connection {
    public static final String identification = "TrileadSSH2Java_213";
    private static final Logger log = Logger.getLogger(Connection.class);
    private AuthenticationManager am;
    private boolean authenticated;
    private ChannelManager cm;
    private final Vector<ConnectionMonitor> connectionMonitors;
    private final CryptoWishList cryptoWishList;
    private DHGexParameters dhgexpara;
    private SecureRandom generator;
    private final String hostname;
    private final int port;
    private ProxyData proxyData;
    private final String sourceAddress;
    private boolean tcpNoDelay;
    private TransportManager tm;

    /* JADX INFO: renamed from: com.trilead.ssh2.Connection$1TimeoutState, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public final class C1TimeoutState {
        boolean isCancelled = false;
        boolean timeoutSocketClosed = false;

        public C1TimeoutState() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static final class PumpThread extends Thread {
        private final InputStream in;
        private final OutputStream out;

        public PumpThread(InputStream inputStream, OutputStream outputStream) {
            super("pump thread");
            this.in = inputStream;
            this.out = outputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int i = this.in.read(bArr);
                    if (i < 0) {
                        this.in.close();
                        return;
                    }
                    this.out.write(bArr, 0, i);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public Connection(String str) {
        this(str, 22);
    }

    public static synchronized String[] getAvailableCiphers() {
        return BlockCipherFactory.getDefaultCipherList();
    }

    public static synchronized String[] getAvailableMACs() {
        return MessageMac.getMacs();
    }

    public static synchronized String[] getAvailableServerHostKeyAlgorithms() {
        return KexManager.getDefaultServerHostkeyAlgorithmList();
    }

    private SecureRandom getOrCreateSecureRND() {
        if (this.generator == null) {
            this.generator = RandomFactory.create();
        }
        return this.generator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connect$0(C1TimeoutState c1TimeoutState) {
        synchronized (c1TimeoutState) {
            try {
                if (c1TimeoutState.isCancelled) {
                    return;
                }
                c1TimeoutState.timeoutSocketClosed = true;
                close(new SocketTimeoutException("The connect timeout expired"), false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$enableDebugging$1(int i, String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        System.err.println(jCurrentTimeMillis + " : " + str + ": " + str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String[] removeDuplicates(String[] strArr) {
        if (strArr == null || strArr.length < 2) {
            return strArr;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        int i = 0;
        for (String str : strArr) {
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    strArr2[i] = str;
                    i++;
                    break;
                }
                if ((str != null || strArr2[i2] != 0) && (str == null || !str.equals(strArr2[i2]))) {
                    i2++;
                }
            }
        }
        if (i == length) {
            return strArr2;
        }
        String[] strArr3 = new String[i];
        System.arraycopy(strArr2, 0, strArr3, 0, i);
        return strArr3;
    }

    public synchronized void addConnectionMonitor(ConnectionMonitor connectionMonitor) {
        try {
            if (connectionMonitor == null) {
                throw new IllegalArgumentException("cmon argument is null");
            }
            this.connectionMonitors.addElement(connectionMonitor);
            TransportManager transportManager = this.tm;
            if (transportManager != null) {
                transportManager.setConnectionMonitors(this.connectionMonitors);
            }
            AuthenticationManager authenticationManager = this.am;
            if (authenticationManager != null) {
                authenticationManager.setConnectionMonitors(this.connectionMonitors);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean authenticateWithAgent(String str, AgentProxy agentProxy) {
        boolean zAuthenticatePublicKey;
        try {
            if (this.tm == null) {
                throw new IllegalStateException("Connection is not established!");
            }
            if (this.authenticated) {
                throw new IllegalStateException("Connection is already authenticated!");
            }
            if (this.am == null) {
                AuthenticationManager authenticationManager = new AuthenticationManager(this.tm);
                this.am = authenticationManager;
                authenticationManager.setConnectionMonitors(this.connectionMonitors);
            }
            if (this.cm == null) {
                this.cm = new ChannelManager(this.tm);
            }
            if (str == null) {
                throw new IllegalArgumentException("user argument is null");
            }
            zAuthenticatePublicKey = this.am.authenticatePublicKey(str, agentProxy);
            this.authenticated = zAuthenticatePublicKey;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticatePublicKey;
    }

    @Deprecated
    public synchronized boolean authenticateWithDSA(String str, String str2, String str3) {
        boolean zAuthenticatePublicKey;
        try {
            if (this.tm == null) {
                throw new IllegalStateException("Connection is not established!");
            }
            if (this.authenticated) {
                throw new IllegalStateException("Connection is already authenticated!");
            }
            if (this.am == null) {
                AuthenticationManager authenticationManager = new AuthenticationManager(this.tm);
                this.am = authenticationManager;
                authenticationManager.setConnectionMonitors(this.connectionMonitors);
            }
            if (this.cm == null) {
                this.cm = new ChannelManager(this.tm);
            }
            if (str == null) {
                throw new IllegalArgumentException("user argument is null");
            }
            if (str2 == null) {
                throw new IllegalArgumentException("pem argument is null");
            }
            zAuthenticatePublicKey = this.am.authenticatePublicKey(str, str2.toCharArray(), str3, getOrCreateSecureRND());
            this.authenticated = zAuthenticatePublicKey;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticatePublicKey;
    }

    public synchronized boolean authenticateWithKeyboardInteractive(String str, InteractiveCallback interactiveCallback) {
        return authenticateWithKeyboardInteractive(str, null, interactiveCallback);
    }

    public synchronized boolean authenticateWithNone(String str) {
        boolean zAuthenticateNone;
        try {
            if (this.tm == null) {
                throw new IllegalStateException("Connection is not established!");
            }
            if (this.authenticated) {
                throw new IllegalStateException("Connection is already authenticated!");
            }
            if (this.am == null) {
                AuthenticationManager authenticationManager = new AuthenticationManager(this.tm);
                this.am = authenticationManager;
                authenticationManager.setConnectionMonitors(this.connectionMonitors);
            }
            if (this.cm == null) {
                this.cm = new ChannelManager(this.tm);
            }
            if (str == null) {
                throw new IllegalArgumentException("user argument is null");
            }
            zAuthenticateNone = this.am.authenticateNone(str);
            this.authenticated = zAuthenticateNone;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticateNone;
    }

    public synchronized boolean authenticateWithPassword(String str, String str2) {
        boolean zAuthenticatePassword;
        try {
            if (this.tm == null) {
                throw new IllegalStateException("Connection is not established!");
            }
            if (this.authenticated) {
                throw new IllegalStateException("Connection is already authenticated!");
            }
            if (this.am == null) {
                AuthenticationManager authenticationManager = new AuthenticationManager(this.tm);
                this.am = authenticationManager;
                authenticationManager.setConnectionMonitors(this.connectionMonitors);
            }
            if (this.cm == null) {
                this.cm = new ChannelManager(this.tm);
            }
            if (str == null) {
                throw new IllegalArgumentException("user argument is null");
            }
            if (str2 == null) {
                throw new IllegalArgumentException("password argument is null");
            }
            zAuthenticatePassword = this.am.authenticatePassword(str, str2);
            this.authenticated = zAuthenticatePassword;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticatePassword;
    }

    public synchronized boolean authenticateWithPublicKey(String str, char[] cArr, String str2) {
        boolean zAuthenticatePublicKey;
        try {
            if (this.tm == null) {
                throw new IllegalStateException("Connection is not established!");
            }
            if (this.authenticated) {
                throw new IllegalStateException("Connection is already authenticated!");
            }
            if (this.am == null) {
                AuthenticationManager authenticationManager = new AuthenticationManager(this.tm);
                this.am = authenticationManager;
                authenticationManager.setConnectionMonitors(this.connectionMonitors);
            }
            if (this.cm == null) {
                this.cm = new ChannelManager(this.tm);
            }
            if (str == null) {
                throw new IllegalArgumentException("user argument is null");
            }
            if (cArr == null) {
                throw new IllegalArgumentException("pemPrivateKey argument is null");
            }
            zAuthenticatePublicKey = this.am.authenticatePublicKey(str, cArr, str2, getOrCreateSecureRND());
            this.authenticated = zAuthenticatePublicKey;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticatePublicKey;
    }

    public synchronized void cancelRemotePortForwarding(int i) {
        if (this.tm == null) {
            throw new IllegalStateException("You need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("The connection is not authenticated.");
        }
        this.cm.requestCancelGlobalForward(i);
    }

    public synchronized void close() {
        try {
            Logger logger = log;
            if (logger.isEnabled()) {
                logger.log(50, "Closing All");
            }
            close(new Throwable("Closed due to user request."), false);
        } catch (Throwable th) {
            throw th;
        }
    }

    public ConnectionInfo connect() {
        return connect(null, 0, 0);
    }

    public synchronized DynamicPortForwarder createDynamicPortForwarder(InetSocketAddress inetSocketAddress) {
        return createDynamicPortForwarder(inetSocketAddress, 0);
    }

    public synchronized LocalPortForwarder createLocalPortForwarder(int i, String str, int i2) {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot forward ports, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot forward ports, connection is not authenticated.");
        }
        return new LocalPortForwarder(this.cm, i, str, i2);
    }

    public synchronized LocalStreamForwarder createLocalStreamForwarder(String str, int i) {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot forward, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot forward, connection is not authenticated.");
        }
        return new LocalStreamForwarder(this.cm, str, i);
    }

    public synchronized SCPClient createSCPClient() {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot create SCP client, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot create SCP client, connection is not authenticated.");
        }
        return new SCPClient(this);
    }

    @Deprecated
    public synchronized void enableDebugging(boolean z, DebugLogger debugLogger) {
        try {
            Logger.enabled = z;
            if (!z) {
                Logger.logger = null;
            } else if (debugLogger == null) {
                Logger.logger = new b0(1);
            } else {
                Logger.logger = debugLogger;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public int exec(String str, OutputStream outputStream) {
        Session sessionOpenSession = openSession();
        try {
            sessionOpenSession.execCommand(str);
            PumpThread pumpThread = new PumpThread(sessionOpenSession.getStdout(), outputStream);
            pumpThread.start();
            PumpThread pumpThread2 = new PumpThread(sessionOpenSession.getStderr(), outputStream);
            pumpThread2.start();
            sessionOpenSession.getStdin().close();
            pumpThread.join();
            pumpThread2.join();
            sessionOpenSession.waitForCondition(32, 3000L);
            Integer exitStatus = sessionOpenSession.getExitStatus();
            if (exitStatus != null) {
                return exitStatus.intValue();
            }
            sessionOpenSession.close();
            return -1;
        } finally {
            sessionOpenSession.close();
        }
    }

    public synchronized void forceKeyExchange() {
        TransportManager transportManager = this.tm;
        if (transportManager == null) {
            throw new IllegalStateException("You need to establish a connection first.");
        }
        transportManager.forceKeyExchange(this.cryptoWishList, this.dhgexpara);
    }

    public synchronized ConnectionInfo getConnectionInfo() {
        TransportManager transportManager;
        transportManager = this.tm;
        if (transportManager == null) {
            throw new IllegalStateException("Cannot get details of connection, you need to establish a connection first.");
        }
        return transportManager.getConnectionInfo(1);
    }

    public synchronized String getHostname() {
        return this.hostname;
    }

    public synchronized int getPort() {
        return this.port;
    }

    public Throwable getReasonClosedCause() {
        TransportManager transportManager = this.tm;
        if (transportManager != null) {
            return transportManager.getReasonClosedCause();
        }
        return null;
    }

    public synchronized String[] getRemainingAuthMethods(String str) {
        try {
            if (str == null) {
                throw new IllegalArgumentException("user argument may not be NULL!");
            }
            if (this.tm == null) {
                throw new IllegalStateException("Connection is not established!");
            }
            if (this.authenticated) {
                throw new IllegalStateException("Connection is already authenticated!");
            }
            if (this.am == null) {
                AuthenticationManager authenticationManager = new AuthenticationManager(this.tm);
                this.am = authenticationManager;
                authenticationManager.setConnectionMonitors(this.connectionMonitors);
            }
            if (this.cm == null) {
                this.cm = new ChannelManager(this.tm);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.am.getRemainingMethods(str);
    }

    public synchronized ClientServerHello getVersionInfo() {
        TransportManager transportManager;
        transportManager = this.tm;
        if (transportManager == null) {
            throw new IllegalStateException("Cannot get details of connection, you need to establish a connection first.");
        }
        return transportManager.getVersionInfo();
    }

    public synchronized boolean isAuthMethodAvailable(String str, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException("method argument may not be NULL!");
        }
        for (String str3 : getRemainingAuthMethods(str)) {
            if (str3.compareTo(str2) == 0) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isAuthenticationComplete() {
        return this.authenticated;
    }

    public synchronized boolean isAuthenticationPartialSuccess() {
        AuthenticationManager authenticationManager = this.am;
        if (authenticationManager == null) {
            return false;
        }
        return authenticationManager.getPartialSuccess();
    }

    public synchronized Session openSession() {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot open session, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot open session, connection is not authenticated.");
        }
        return new Session(this.cm, getOrCreateSecureRND());
    }

    public synchronized long ping() {
        if (this.tm == null) {
            throw new IllegalStateException("You need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("The connection is not authenticated.");
        }
        return this.cm.requestGlobalTrileadPing();
    }

    public synchronized void requestRemotePortForwarding(String str, int i, String str2, int i2) {
        if (this.tm == null) {
            throw new IllegalStateException("You need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("The connection is not authenticated.");
        }
        if (str == null || str2 == null || i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.cm.requestGlobalForward(str, i, str2, i2);
    }

    public synchronized void sendIgnorePacket() {
        SecureRandom orCreateSecureRND = getOrCreateSecureRND();
        byte[] bArr = new byte[orCreateSecureRND.nextInt(16)];
        orCreateSecureRND.nextBytes(bArr);
        sendIgnorePacket(bArr);
    }

    public synchronized void setClient2ServerCiphers(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                BlockCipherFactory.checkCipherList(strArrRemoveDuplicates);
                this.cryptoWishList.c2s_enc_algos = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setClient2ServerMACs(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                MessageMac.checkMacs(strArrRemoveDuplicates);
                this.cryptoWishList.c2s_mac_algos = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setDHGexParameters(DHGexParameters dHGexParameters) {
        if (dHGexParameters == null) {
            throw new IllegalArgumentException();
        }
        this.dhgexpara = dHGexParameters;
    }

    public synchronized void setProxyData(ProxyData proxyData) {
        this.proxyData = proxyData;
    }

    public synchronized void setSecureRandom(SecureRandom secureRandom) {
        if (secureRandom == null) {
            throw new IllegalArgumentException();
        }
        this.generator = secureRandom;
    }

    public synchronized void setServer2ClientCiphers(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                BlockCipherFactory.checkCipherList(strArrRemoveDuplicates);
                this.cryptoWishList.s2c_enc_algos = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setServer2ClientMACs(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                MessageMac.checkMacs(strArrRemoveDuplicates);
                this.cryptoWishList.s2c_mac_algos = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setServerHostKeyAlgorithms(String[] strArr) {
        if (strArr != null) {
            if (strArr.length != 0) {
                String[] strArrRemoveDuplicates = removeDuplicates(strArr);
                KexManager.checkServerHostkeyAlgorithmsList(strArrRemoveDuplicates);
                this.cryptoWishList.serverHostKeyAlgorithms = strArrRemoveDuplicates;
            }
        }
        throw new IllegalArgumentException();
    }

    public synchronized void setTCPNoDelay(boolean z) {
        this.tcpNoDelay = z;
        TransportManager transportManager = this.tm;
        if (transportManager != null) {
            transportManager.setTcpNoDelay(z);
        }
    }

    public Connection(String str, int i) {
        this(str, i, null);
    }

    public synchronized boolean authenticateWithKeyboardInteractive(String str, String[] strArr, InteractiveCallback interactiveCallback) {
        boolean zAuthenticateInteractive;
        try {
            if (interactiveCallback == null) {
                throw new IllegalArgumentException("Callback may not ne NULL!");
            }
            if (this.tm == null) {
                throw new IllegalStateException("Connection is not established!");
            }
            if (this.authenticated) {
                throw new IllegalStateException("Connection is already authenticated!");
            }
            if (this.am == null) {
                AuthenticationManager authenticationManager = new AuthenticationManager(this.tm);
                this.am = authenticationManager;
                authenticationManager.setConnectionMonitors(this.connectionMonitors);
            }
            if (this.cm == null) {
                this.cm = new ChannelManager(this.tm);
            }
            if (str == null) {
                throw new IllegalArgumentException("user argument is null");
            }
            zAuthenticateInteractive = this.am.authenticateInteractive(str, strArr, interactiveCallback);
            this.authenticated = zAuthenticateInteractive;
        } catch (Throwable th) {
            throw th;
        }
        return zAuthenticateInteractive;
    }

    public ConnectionInfo connect(ServerHostKeyVerifier serverHostKeyVerifier) {
        return connect(serverHostKeyVerifier, 0, 0);
    }

    public synchronized DynamicPortForwarder createDynamicPortForwarder(InetSocketAddress inetSocketAddress, int i) {
        if (this.tm == null) {
            throw new IllegalStateException("Cannot forward ports, you need to establish a connection first.");
        }
        if (!this.authenticated) {
            throw new IllegalStateException("Cannot forward ports, connection is not authenticated.");
        }
        return new DynamicPortForwarder(this.cm, inetSocketAddress, i);
    }

    public Connection(String str, int i, String str2) {
        this.authenticated = false;
        this.cryptoWishList = new CryptoWishList();
        this.dhgexpara = new DHGexParameters();
        this.tcpNoDelay = false;
        this.proxyData = null;
        this.connectionMonitors = new Vector<>();
        this.hostname = str;
        this.port = i;
        this.sourceAddress = str2;
    }

    public ConnectionInfo connect(ServerHostKeyVerifier serverHostKeyVerifier, int i, int i2) {
        return connect(serverHostKeyVerifier, i, 0, i2);
    }

    public ConnectionInfo connect(ServerHostKeyVerifier serverHostKeyVerifier, int i, int i2, int i3) throws IOException {
        if (this.tm != null) {
            throw new IOException(za0.o(new StringBuilder("Connection to "), this.hostname, " is already in connected state!"));
        }
        if (i < 0) {
            throw new IllegalArgumentException("connectTimeout must be non-negative!");
        }
        if (i3 >= 0) {
            final C1TimeoutState c1TimeoutState = new C1TimeoutState();
            TransportManager transportManager = new TransportManager(this.hostname, this.port, this.sourceAddress);
            this.tm = transportManager;
            transportManager.setConnectionMonitors(this.connectionMonitors);
            synchronized (this.tm) {
            }
            TimeoutService.TimeoutToken timeoutTokenAddTimeoutHandler = null;
            if (i3 > 0) {
                try {
                    try {
                        timeoutTokenAddTimeoutHandler = TimeoutService.addTimeoutHandler(System.currentTimeMillis() + ((long) i3), new Runnable() { // from class: com.trilead.ssh2.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.lambda$connect$0(c1TimeoutState);
                            }
                        });
                    } catch (Throwable th) {
                        if (timeoutTokenAddTimeoutHandler != null) {
                            TimeoutService.cancelTimeoutHandler(timeoutTokenAddTimeoutHandler);
                            synchronized (c1TimeoutState) {
                                try {
                                    if (c1TimeoutState.timeoutSocketClosed) {
                                        throw new IOException("This exception will be replaced by the one below =)");
                                    }
                                    c1TimeoutState.isCancelled = true;
                                    throw th;
                                } finally {
                                }
                            }
                        }
                        throw th;
                    }
                } catch (SocketTimeoutException e) {
                    throw e;
                } catch (IOException e2) {
                    close(new Throwable("There was a problem during connect.", e2), false);
                    synchronized (c1TimeoutState) {
                        if (!c1TimeoutState.timeoutSocketClosed) {
                            if (e2 instanceof HTTPProxyException) {
                                throw e2;
                            }
                            throw new IOException("There was a problem while connecting to " + this.hostname + ":" + this.port, e2);
                        }
                        throw new SocketTimeoutException("The kexTimeout (" + i3 + " ms) expired.");
                    }
                }
            }
            try {
                this.tm.initialize(this.cryptoWishList, serverHostKeyVerifier, this.dhgexpara, i, i2, getOrCreateSecureRND(), this.proxyData);
                this.tm.setTcpNoDelay(this.tcpNoDelay);
                ConnectionInfo connectionInfo = this.tm.getConnectionInfo(1);
                if (timeoutTokenAddTimeoutHandler == null) {
                    return connectionInfo;
                }
                TimeoutService.cancelTimeoutHandler(timeoutTokenAddTimeoutHandler);
                synchronized (c1TimeoutState) {
                    try {
                        if (!c1TimeoutState.timeoutSocketClosed) {
                            c1TimeoutState.isCancelled = true;
                        } else {
                            throw new IOException("This exception will be replaced by the one below =)");
                        }
                    } finally {
                    }
                }
                return connectionInfo;
            } catch (SocketTimeoutException e3) {
                throw ((SocketTimeoutException) new SocketTimeoutException("The connect() operation on the socket timed out.").initCause(e3));
            }
        }
        throw new IllegalArgumentException("kexTimeout must be non-negative!");
    }

    private synchronized void close(Throwable th, boolean z) {
        try {
            ChannelManager channelManager = this.cm;
            if (channelManager != null) {
                channelManager.closeAllChannels();
            }
            TransportManager transportManager = this.tm;
            if (transportManager != null) {
                transportManager.close(th, !z);
                this.tm = null;
            }
            this.am = null;
            this.cm = null;
            this.authenticated = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void sendIgnorePacket(byte[] bArr) {
        if (bArr != null) {
            if (this.tm != null) {
                PacketIgnore packetIgnore = new PacketIgnore();
                packetIgnore.setData(bArr);
                this.tm.sendMessage(packetIgnore.getPayload());
            } else {
                throw new IllegalStateException("Cannot send SSH_MSG_IGNORE packet, you need to establish a connection first.");
            }
        } else {
            throw new IllegalArgumentException("data argument must not be null.");
        }
    }

    public synchronized LocalPortForwarder createLocalPortForwarder(InetSocketAddress inetSocketAddress, String str, int i) {
        if (this.tm != null) {
            if (this.authenticated) {
            } else {
                throw new IllegalStateException("Cannot forward ports, connection is not authenticated.");
            }
        } else {
            throw new IllegalStateException("Cannot forward ports, you need to establish a connection first.");
        }
        return new LocalPortForwarder(this.cm, inetSocketAddress, str, i);
    }

    public synchronized DynamicPortForwarder createDynamicPortForwarder(int i) {
        return new DynamicPortForwarder(this.cm, i, 0);
    }

    public synchronized DynamicPortForwarder createDynamicPortForwarder(int i, int i2) {
        if (this.tm != null) {
            if (this.authenticated) {
            } else {
                throw new IllegalStateException("Cannot forward ports, connection is not authenticated.");
            }
        } else {
            throw new IllegalStateException("Cannot forward ports, you need to establish a connection first.");
        }
        return new DynamicPortForwarder(this.cm, i, i2);
    }

    public synchronized boolean authenticateWithPublicKey(String str, File file, String str2) {
        CharArrayWriter charArrayWriter;
        if (file != null) {
            char[] cArr = new char[256];
            charArrayWriter = new CharArrayWriter();
            FileReader fileReader = new FileReader(file);
            while (true) {
                int i = fileReader.read(cArr);
                if (i < 0) {
                    fileReader.close();
                } else {
                    charArrayWriter.write(cArr, 0, i);
                }
            }
        } else {
            throw new IllegalArgumentException("pemFile argument is null");
        }
        return authenticateWithPublicKey(str, charArrayWriter.toCharArray(), str2);
    }

    public void setCompression(boolean z) {
    }
}
