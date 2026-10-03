package com.trilead.ssh2.transport;

import com.trilead.ssh2.ConnectionInfo;
import com.trilead.ssh2.DHGexParameters;
import com.trilead.ssh2.ServerHostKeyVerifier;
import com.trilead.ssh2.crypto.CryptoWishList;
import com.trilead.ssh2.crypto.KeyMaterial;
import com.trilead.ssh2.crypto.cipher.BlockCipherFactory;
import com.trilead.ssh2.crypto.dh.DhExchange;
import com.trilead.ssh2.crypto.dh.DhGroupExchange;
import com.trilead.ssh2.crypto.digest.MessageMac;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.PacketKexDHInit;
import com.trilead.ssh2.packets.PacketKexDHReply;
import com.trilead.ssh2.packets.PacketKexDhGexGroup;
import com.trilead.ssh2.packets.PacketKexDhGexInit;
import com.trilead.ssh2.packets.PacketKexDhGexReply;
import com.trilead.ssh2.packets.PacketKexDhGexRequest;
import com.trilead.ssh2.packets.PacketKexDhGexRequestOld;
import com.trilead.ssh2.packets.PacketKexInit;
import com.trilead.ssh2.packets.PacketNewKeys;
import com.trilead.ssh2.signature.KeyAlgorithm;
import com.trilead.ssh2.signature.KeyAlgorithmManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class KexManager implements MessageHandler {
    ClientServerHello csh;
    final String hostname;
    KeyMaterial km;
    KexState kxs;
    CryptoWishList nextKEXcryptoWishList;
    final int port;
    final SecureRandom rnd;
    byte[] sessionId;
    final TransportManager tm;
    ServerHostKeyVerifier verifier;
    private static final Logger log = Logger.getLogger(KexManager.class);
    private static final List<String> DEFAULT_KEY_ALGORITHMS = buildDefaultKeyAlgorithms();
    int kexCount = 0;
    final Object accessLock = new Object();
    ConnectionInfo lastConnInfo = null;
    boolean connectionClosed = false;
    boolean ignore_next_kex_packet = false;
    DHGexParameters nextKEXdhgexParameters = new DHGexParameters();

    public KexManager(TransportManager transportManager, ClientServerHello clientServerHello, CryptoWishList cryptoWishList, String str, int i, ServerHostKeyVerifier serverHostKeyVerifier, SecureRandom secureRandom) {
        this.tm = transportManager;
        this.csh = clientServerHello;
        this.nextKEXcryptoWishList = cryptoWishList;
        this.hostname = str;
        this.port = i;
        this.verifier = serverHostKeyVerifier;
        this.rnd = secureRandom;
    }

    private static List<String> buildDefaultKeyAlgorithms() {
        ArrayList arrayList = new ArrayList();
        Iterator<KeyAlgorithm<PublicKey, PrivateKey>> it = KeyAlgorithmManager.getSupportedAlgorithms().iterator();
        while (it.hasNext()) {
            arrayList.add(arrayList.size(), it.next().getKeyFormat());
        }
        return arrayList;
    }

    public static void checkKexAlgorithmList(String[] strArr) {
        for (String str : strArr) {
            if (!"diffie-hellman-group-exchange-sha1".equals(str) && !"diffie-hellman-group14-sha1".equals(str) && !"diffie-hellman-group1-sha1".equals(str) && !"diffie-hellman-group-exchange-sha256".equals(str)) {
                throw new IllegalArgumentException(za0.l("Unknown kex algorithm '", str, "'"));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void checkServerHostkeyAlgorithmsList(java.lang.String[] r5) {
        /*
            int r0 = r5.length
            r1 = 0
        L2:
            if (r1 >= r0) goto L35
            r2 = r5[r1]
            java.util.Collection r3 = com.trilead.ssh2.signature.KeyAlgorithmManager.getSupportedAlgorithms()
            java.util.Iterator r3 = r3.iterator()
        Le:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L27
            java.lang.Object r4 = r3.next()
            com.trilead.ssh2.signature.KeyAlgorithm r4 = (com.trilead.ssh2.signature.KeyAlgorithm) r4
            java.lang.String r4 = r4.getKeyFormat()
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto Le
            int r1 = r1 + 1
            goto L2
        L27:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unknown server host key algorithm '"
            java.lang.String r1 = "'"
            java.lang.String r0 = sensei0.za0.l(r0, r2, r1)
            r5.<init>(r0)
            throw r5
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trilead.ssh2.transport.KexManager.checkServerHostkeyAlgorithmsList(java.lang.String[]):void");
    }

    private boolean compareFirstOfNameList(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null) {
            throw new IllegalArgumentException();
        }
        if (strArr.length == 0 && strArr2.length == 0) {
            return true;
        }
        if (strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        return strArr[0].equals(strArr2[0]);
    }

    private boolean establishKeyMaterial() {
        try {
            int keyLength = MessageMac.getKeyLength(this.kxs.np.mac_algo_client_to_server);
            int keySize = BlockCipherFactory.getKeySize(this.kxs.np.enc_algo_client_to_server);
            int blockSize = BlockCipherFactory.getBlockSize(this.kxs.np.enc_algo_client_to_server);
            int keyLength2 = MessageMac.getKeyLength(this.kxs.np.mac_algo_server_to_client);
            int keySize2 = BlockCipherFactory.getKeySize(this.kxs.np.enc_algo_server_to_client);
            int blockSize2 = BlockCipherFactory.getBlockSize(this.kxs.np.enc_algo_server_to_client);
            String hashAlgorithm = this.kxs.getHashAlgorithm();
            KexState kexState = this.kxs;
            this.km = KeyMaterial.create(hashAlgorithm, kexState.H, kexState.K, this.sessionId, keySize, blockSize, keyLength, keySize2, blockSize2, keyLength2);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    private void finishKex() throws IOException {
        if (this.sessionId == null) {
            this.sessionId = this.kxs.H;
        }
        if (!establishKeyMaterial()) {
            throw new IOException("Could not establish key material for " + this.kxs.np.enc_algo_client_to_server + "/" + this.kxs.np.mac_algo_client_to_server);
        }
        this.tm.sendKexMessage(new PacketNewKeys().getPayload());
        try {
            String str = this.kxs.np.enc_algo_client_to_server;
            KeyMaterial keyMaterial = this.km;
            this.tm.changeSendCipher(BlockCipherFactory.createCipher(str, true, keyMaterial.enc_key_client_to_server, keyMaterial.initial_iv_client_to_server), new MessageMac(this.kxs.np.mac_algo_client_to_server, this.km.integrity_key_client_to_server));
            this.tm.kexFinished();
        } catch (IllegalArgumentException e) {
            throw new IOException("Fatal error during MAC startup! (cipher=" + this.kxs.np.enc_algo_client_to_server + ", mac=" + this.kxs.np.mac_algo_client_to_server + "): " + e, e);
        }
    }

    public static String[] getDefaultKexAlgorithmList() {
        return new String[]{"diffie-hellman-group-exchange-sha256", "diffie-hellman-group-exchange-sha1", "diffie-hellman-group14-sha1", "diffie-hellman-group1-sha1"};
    }

    public static String[] getDefaultServerHostkeyAlgorithmList() {
        List<String> list = DEFAULT_KEY_ALGORITHMS;
        return (String[]) list.toArray(new String[list.size()]);
    }

    private String getFirstMatch(String[] strArr, String[] strArr2) throws NegotiateException {
        if (strArr == null || strArr2 == null) {
            throw new IllegalArgumentException();
        }
        if (strArr.length == 0) {
            return null;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (str.equals(str2)) {
                    return str;
                }
            }
        }
        throw new NegotiateException();
    }

    private boolean isGuessOK(KexParameters kexParameters, KexParameters kexParameters2) {
        if (kexParameters == null || kexParameters2 == null) {
            throw new IllegalArgumentException();
        }
        if (compareFirstOfNameList(kexParameters.kex_algorithms, kexParameters2.kex_algorithms)) {
            return compareFirstOfNameList(kexParameters.server_host_key_algorithms, kexParameters2.server_host_key_algorithms);
        }
        return false;
    }

    private NegotiatedParameters mergeKexParameters(KexParameters kexParameters, KexParameters kexParameters2) {
        NegotiatedParameters negotiatedParameters = new NegotiatedParameters();
        try {
            negotiatedParameters.kex_algo = getFirstMatch(kexParameters.kex_algorithms, kexParameters2.kex_algorithms);
            Logger logger = log;
            logger.log(30, "kex_algo=" + negotiatedParameters.kex_algo);
            negotiatedParameters.server_host_key_algo = getFirstMatch(kexParameters.server_host_key_algorithms, kexParameters2.server_host_key_algorithms);
            logger.log(30, "server_host_key_algo=" + negotiatedParameters.server_host_key_algo);
            negotiatedParameters.enc_algo_client_to_server = getFirstMatch(kexParameters.encryption_algorithms_client_to_server, kexParameters2.encryption_algorithms_client_to_server);
            negotiatedParameters.enc_algo_server_to_client = getFirstMatch(kexParameters.encryption_algorithms_server_to_client, kexParameters2.encryption_algorithms_server_to_client);
            logger.log(30, "enc_algo_client_to_server=" + negotiatedParameters.enc_algo_client_to_server);
            logger.log(30, "enc_algo_server_to_client=" + negotiatedParameters.enc_algo_server_to_client);
            negotiatedParameters.mac_algo_client_to_server = getFirstMatch(kexParameters.mac_algorithms_client_to_server, kexParameters2.mac_algorithms_client_to_server);
            negotiatedParameters.mac_algo_server_to_client = getFirstMatch(kexParameters.mac_algorithms_server_to_client, kexParameters2.mac_algorithms_server_to_client);
            logger.log(30, "mac_algo_client_to_server=" + negotiatedParameters.mac_algo_client_to_server);
            logger.log(30, "mac_algo_server_to_client=" + negotiatedParameters.mac_algo_server_to_client);
            negotiatedParameters.comp_algo_client_to_server = getFirstMatch(kexParameters.compression_algorithms_client_to_server, kexParameters2.compression_algorithms_client_to_server);
            negotiatedParameters.comp_algo_server_to_client = getFirstMatch(kexParameters.compression_algorithms_server_to_client, kexParameters2.compression_algorithms_server_to_client);
            logger.log(30, "comp_algo_client_to_server=" + negotiatedParameters.comp_algo_client_to_server);
            logger.log(30, "comp_algo_server_to_client=" + negotiatedParameters.comp_algo_server_to_client);
            try {
                negotiatedParameters.lang_client_to_server = getFirstMatch(kexParameters.languages_client_to_server, kexParameters2.languages_client_to_server);
            } catch (NegotiateException unused) {
                negotiatedParameters.lang_client_to_server = null;
            }
            try {
                negotiatedParameters.lang_server_to_client = getFirstMatch(kexParameters.languages_server_to_client, kexParameters2.languages_server_to_client);
            } catch (NegotiateException unused2) {
                negotiatedParameters.lang_server_to_client = null;
            }
            if (isGuessOK(kexParameters, kexParameters2)) {
                negotiatedParameters.guessOK = true;
            }
            return negotiatedParameters;
        } catch (NegotiateException unused3) {
            return null;
        }
    }

    private boolean verifySignature(byte[] bArr, byte[] bArr2) throws IOException {
        for (KeyAlgorithm<PublicKey, PrivateKey> keyAlgorithm : KeyAlgorithmManager.getSupportedAlgorithms()) {
            if (keyAlgorithm.getKeyFormat().equals(this.kxs.np.server_host_key_algo)) {
                PublicKey publicKeyDecodePublicKey = keyAlgorithm.decodePublicKey(bArr2);
                return keyAlgorithm.verifySignature(this.kxs.H, keyAlgorithm.decodeSignature(bArr), publicKeyDecodePublicKey);
            }
        }
        throw new IOException(za0.o(new StringBuilder("Unknown server host key algorithm '"), this.kxs.np.server_host_key_algo, "'"));
    }

    public ConnectionInfo getOrWaitForConnectionInfo(int i) {
        ConnectionInfo connectionInfo;
        synchronized (this.accessLock) {
            while (true) {
                try {
                    connectionInfo = this.lastConnInfo;
                    if (connectionInfo == null || connectionInfo.keyExchangeCounter < i) {
                        if (this.connectionClosed) {
                            throw new IOException("Key exchange was not finished, connection is closed.", this.tm.getReasonClosedCause());
                        }
                        try {
                            this.accessLock.wait();
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return connectionInfo;
    }

    @Override // com.trilead.ssh2.transport.MessageHandler
    public void handleEndMessage(Throwable th) {
        synchronized (this.accessLock) {
            this.connectionClosed = true;
            this.accessLock.notifyAll();
        }
    }

    @Override // com.trilead.ssh2.transport.MessageHandler
    public synchronized void handleMessage(byte[] bArr, int i) {
        KexState kexState;
        try {
            kexState = this.kxs;
            if (kexState == null && bArr[0] != 20) {
                throw new IOException("Unexpected KEX message (type " + ((int) bArr[0]) + ")");
            }
        } catch (Throwable th) {
            throw th;
        }
        if (this.ignore_next_kex_packet) {
            this.ignore_next_kex_packet = false;
            return;
        }
        byte b = bArr[0];
        if (b == 20) {
            if (kexState != null && kexState.state != 0) {
                throw new IOException("Unexpected SSH_MSG_KEXINIT message during on-going kex exchange!");
            }
            if (kexState == null) {
                KexState kexState2 = new KexState();
                this.kxs = kexState2;
                kexState2.dhgexParameters = this.nextKEXdhgexParameters;
                PacketKexInit packetKexInit = new PacketKexInit(this.nextKEXcryptoWishList, this.rnd);
                this.kxs.localKEX = packetKexInit;
                this.tm.sendKexMessage(packetKexInit.getPayload());
            }
            PacketKexInit packetKexInit2 = new PacketKexInit(bArr, 0, i);
            KexState kexState3 = this.kxs;
            kexState3.remoteKEX = packetKexInit2;
            kexState3.np = mergeKexParameters(kexState3.localKEX.getKexParameters(), this.kxs.remoteKEX.getKexParameters());
            KexState kexState4 = this.kxs;
            if (kexState4.np == null) {
                throw new IOException("Cannot negotiate, proposals do not match.");
            }
            if (kexState4.remoteKEX.isFirst_kex_packet_follows() && !this.kxs.np.guessOK) {
                this.ignore_next_kex_packet = true;
            }
            if (!this.kxs.np.kex_algo.equals("diffie-hellman-group-exchange-sha1") && !this.kxs.np.kex_algo.equals("diffie-hellman-group-exchange-sha256")) {
                if (!this.kxs.np.kex_algo.equals("diffie-hellman-group1-sha1") && !this.kxs.np.kex_algo.equals("diffie-hellman-group14-sha1")) {
                    throw new IllegalStateException("Unkown KEX method!");
                }
                this.kxs.dhx = new DhExchange("SHA1");
                if (this.kxs.np.kex_algo.equals("diffie-hellman-group1-sha1")) {
                    this.kxs.dhx.init(1, this.rnd);
                } else {
                    this.kxs.dhx.init(14, this.rnd);
                }
                this.tm.sendKexMessage(new PacketKexDHInit(this.kxs.dhx.getE()).getPayload());
                KexState kexState5 = this.kxs;
                kexState5.state = 1;
                kexState5.setHashAlgorithm(kexState5.dhx.getHashAlgorithm());
                return;
            }
            if (this.kxs.dhgexParameters.getMin_group_len() == 0) {
                this.tm.sendKexMessage(new PacketKexDhGexRequestOld(this.kxs.dhgexParameters).getPayload());
            } else {
                this.tm.sendKexMessage(new PacketKexDhGexRequest(this.kxs.dhgexParameters).getPayload());
            }
            KexState kexState6 = this.kxs;
            kexState6.state = 1;
            if (kexState6.np.kex_algo.endsWith("sha1")) {
                this.kxs.setHashAlgorithm("SHA1");
            } else {
                this.kxs.setHashAlgorithm("SHA-256");
            }
            return;
        }
        if (b == 21) {
            KeyMaterial keyMaterial = this.km;
            if (keyMaterial == null) {
                throw new IOException("Peer sent SSH_MSG_NEWKEYS, but I have no key material ready!");
            }
            try {
                this.tm.changeRecvCipher(BlockCipherFactory.createCipher(kexState.np.enc_algo_server_to_client, false, keyMaterial.enc_key_server_to_client, keyMaterial.initial_iv_server_to_client), new MessageMac(this.kxs.np.mac_algo_server_to_client, this.km.integrity_key_server_to_client));
                ConnectionInfo connectionInfo = new ConnectionInfo();
                int i2 = this.kexCount + 1;
                this.kexCount = i2;
                KexState kexState7 = this.kxs;
                NegotiatedParameters negotiatedParameters = kexState7.np;
                connectionInfo.keyExchangeAlgorithm = negotiatedParameters.kex_algo;
                connectionInfo.keyExchangeCounter = i2;
                connectionInfo.clientToServerCryptoAlgorithm = negotiatedParameters.enc_algo_client_to_server;
                connectionInfo.serverToClientCryptoAlgorithm = negotiatedParameters.enc_algo_server_to_client;
                connectionInfo.clientToServerMACAlgorithm = negotiatedParameters.mac_algo_client_to_server;
                connectionInfo.serverToClientMACAlgorithm = negotiatedParameters.mac_algo_server_to_client;
                connectionInfo.serverHostKeyAlgorithm = negotiatedParameters.server_host_key_algo;
                connectionInfo.serverHostKey = kexState7.hostkey;
                synchronized (this.accessLock) {
                    this.lastConnInfo = connectionInfo;
                    this.accessLock.notifyAll();
                }
                this.kxs = null;
                return;
            } catch (IllegalArgumentException e) {
                throw new IOException("Fatal error during MAC startup! (cipher=" + this.kxs.np.enc_algo_server_to_client + ", mac=" + this.kxs.np.mac_algo_server_to_client + "): " + e, e);
            }
        }
        if (kexState == null || kexState.state == 0) {
            throw new IOException("Unexpected Kex submessage!");
        }
        if (!kexState.np.kex_algo.equals("diffie-hellman-group-exchange-sha1") && !this.kxs.np.kex_algo.equals("diffie-hellman-group-exchange-sha256")) {
            if ((!this.kxs.np.kex_algo.equals("diffie-hellman-group1-sha1") && !this.kxs.np.kex_algo.equals("diffie-hellman-group14-sha1")) || this.kxs.state != 1) {
                throw new IllegalStateException("Unkown KEX method! (" + this.kxs.np.kex_algo + ")");
            }
            PacketKexDHReply packetKexDHReply = new PacketKexDHReply(bArr, 0, i);
            this.kxs.hostkey = packetKexDHReply.getHostKey();
            ServerHostKeyVerifier serverHostKeyVerifier = this.verifier;
            if (serverHostKeyVerifier != null) {
                try {
                    String str = this.hostname;
                    int i3 = this.port;
                    KexState kexState8 = this.kxs;
                    if (!serverHostKeyVerifier.verifyServerHostKey(str, i3, kexState8.np.server_host_key_algo, kexState8.hostkey)) {
                        throw new IOException("The server hostkey was not accepted by the verifier callback");
                    }
                } catch (Exception e2) {
                    throw new IOException("The server hostkey was not accepted by the verifier callback.", e2);
                }
            }
            this.kxs.dhx.setF(packetKexDHReply.getF());
            try {
                KexState kexState9 = this.kxs;
                kexState9.H = kexState9.dhx.calculateH(this.csh.getClientString(), this.csh.getServerString(), this.kxs.localKEX.getPayload(), this.kxs.remoteKEX.getPayload(), packetKexDHReply.getHostKey());
                if (!verifySignature(packetKexDHReply.getSignature(), this.kxs.hostkey)) {
                    throw new IOException("Hostkey signature sent by remote is wrong!");
                }
                KexState kexState10 = this.kxs;
                kexState10.K = kexState10.dhx.getK();
                finishKex();
                this.kxs.state = -1;
                return;
            } catch (IllegalArgumentException e3) {
                throw new IOException("KEX error.", e3);
            }
        }
        int i4 = this.kxs.state;
        if (i4 == 1) {
            PacketKexDhGexGroup packetKexDhGexGroup = new PacketKexDhGexGroup(bArr, 0, i);
            KexState kexState11 = this.kxs;
            kexState11.dhgx = new DhGroupExchange(kexState11.getHashAlgorithm(), packetKexDhGexGroup.getP(), packetKexDhGexGroup.getG());
            this.kxs.dhgx.init(this.rnd);
            this.tm.sendKexMessage(new PacketKexDhGexInit(this.kxs.dhgx.getE()).getPayload());
            this.kxs.state = 2;
            return;
        }
        if (i4 != 2) {
            throw new IllegalStateException("Illegal State in KEX Exchange!");
        }
        PacketKexDhGexReply packetKexDhGexReply = new PacketKexDhGexReply(bArr, 0, i);
        this.kxs.hostkey = packetKexDhGexReply.getHostKey();
        ServerHostKeyVerifier serverHostKeyVerifier2 = this.verifier;
        if (serverHostKeyVerifier2 != null) {
            try {
                String str2 = this.hostname;
                int i5 = this.port;
                KexState kexState12 = this.kxs;
                if (!serverHostKeyVerifier2.verifyServerHostKey(str2, i5, kexState12.np.server_host_key_algo, kexState12.hostkey)) {
                    throw new IOException("The server hostkey was not accepted by the verifier callback");
                }
            } catch (Exception e4) {
                throw new IOException("The server hostkey was not accepted by the verifier callback.", e4);
            }
        }
        this.kxs.dhgx.setF(packetKexDhGexReply.getF());
        try {
            KexState kexState13 = this.kxs;
            kexState13.H = kexState13.dhgx.calculateH(this.csh.getClientString(), this.csh.getServerString(), this.kxs.localKEX.getPayload(), this.kxs.remoteKEX.getPayload(), packetKexDhGexReply.getHostKey(), this.kxs.dhgexParameters);
            if (!verifySignature(packetKexDhGexReply.getSignature(), this.kxs.hostkey)) {
                throw new IOException("Hostkey signature sent by remote is wrong!");
            }
            KexState kexState14 = this.kxs;
            kexState14.K = kexState14.dhgx.getK();
            finishKex();
            this.kxs.state = -1;
            return;
        } catch (IllegalArgumentException e5) {
            throw new IOException("KEX error.", e5);
        }
        throw th;
    }

    public synchronized void initiateKEX(CryptoWishList cryptoWishList, DHGexParameters dHGexParameters) {
        this.nextKEXcryptoWishList = cryptoWishList;
        this.nextKEXdhgexParameters = dHGexParameters;
        if (this.kxs == null) {
            KexState kexState = new KexState();
            this.kxs = kexState;
            kexState.dhgexParameters = this.nextKEXdhgexParameters;
            PacketKexInit packetKexInit = new PacketKexInit(this.nextKEXcryptoWishList, this.rnd);
            this.kxs.localKEX = packetKexInit;
            this.tm.sendKexMessage(packetKexInit.getPayload());
        }
    }
}
