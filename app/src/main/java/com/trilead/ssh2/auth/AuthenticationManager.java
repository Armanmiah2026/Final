package com.trilead.ssh2.auth;

import com.trilead.ssh2.ConnectionMonitor;
import com.trilead.ssh2.InteractiveCallback;
import com.trilead.ssh2.crypto.PEMDecoder;
import com.trilead.ssh2.packets.PacketServiceAccept;
import com.trilead.ssh2.packets.PacketServiceRequest;
import com.trilead.ssh2.packets.PacketUserauthBanner;
import com.trilead.ssh2.packets.PacketUserauthFailure;
import com.trilead.ssh2.packets.PacketUserauthInfoRequest;
import com.trilead.ssh2.packets.PacketUserauthInfoResponse;
import com.trilead.ssh2.packets.PacketUserauthRequestInteractive;
import com.trilead.ssh2.packets.PacketUserauthRequestNone;
import com.trilead.ssh2.packets.PacketUserauthRequestPassword;
import com.trilead.ssh2.packets.PacketUserauthRequestPublicKey;
import com.trilead.ssh2.packets.TypesWriter;
import com.trilead.ssh2.signature.KeyAlgorithm;
import com.trilead.ssh2.signature.KeyAlgorithmManager;
import com.trilead.ssh2.transport.MessageHandler;
import com.trilead.ssh2.transport.TransportManager;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Vector;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class AuthenticationManager implements MessageHandler {
    public static final String PROPERTY_TIMEOUT;
    public static final long TIMEOUT;
    TransportManager tm;
    Vector<byte[]> packets = new Vector<>();
    Vector<ConnectionMonitor> connMonitors = new Vector<>();
    boolean connectionClosed = false;
    String[] remainingMethods = new String[0];
    boolean isPartialSuccess = false;
    boolean authenticated = false;
    boolean initDone = false;

    static {
        String strConcat = AuthenticationManager.class.getName().concat(".timeout");
        PROPERTY_TIMEOUT = strConcat;
        TIMEOUT = Long.valueOf(System.getProperty(strConcat, "120000")).longValue();
    }

    public AuthenticationManager(TransportManager transportManager) {
        this.tm = transportManager;
    }

    private boolean initialize(String str) throws IOException {
        if (this.initDone) {
            return this.authenticated;
        }
        this.tm.registerMessageHandler(this, 0, 255);
        this.tm.sendMessage(new PacketServiceRequest("ssh-userauth").getPayload());
        this.tm.sendMessage(new PacketUserauthRequestNone("ssh-connection", str).getPayload());
        byte[] nextMessage = getNextMessage();
        new PacketServiceAccept(nextMessage, 0, nextMessage.length);
        byte[] nextMessage2 = getNextMessage();
        this.initDone = true;
        byte b = nextMessage2[0];
        if (b == 52) {
            this.authenticated = true;
            this.tm.removeMessageHandler(this, 0, 255);
            return true;
        }
        if (b != 51) {
            throw new IOException(za0.n(new StringBuilder("Unexpected SSH message (type "), nextMessage2[0], ")"));
        }
        PacketUserauthFailure packetUserauthFailure = new PacketUserauthFailure(nextMessage2, 0, nextMessage2.length);
        this.remainingMethods = packetUserauthFailure.getAuthThatCanContinue();
        this.isPartialSuccess = packetUserauthFailure.isPartialSuccess();
        return false;
    }

    public boolean authenticateInteractive(String str, String[] strArr, InteractiveCallback interactiveCallback) throws IOException {
        try {
            initialize(str);
            if (!methodPossible("keyboard-interactive")) {
                throw new IOException("Authentication method keyboard-interactive not supported by the server at this stage.");
            }
            if (strArr == null) {
                strArr = new String[0];
            }
            this.tm.sendMessage(new PacketUserauthRequestInteractive("ssh-connection", str, strArr).getPayload());
            while (true) {
                byte[] nextMessage = getNextMessage();
                byte b = nextMessage[0];
                if (b == 52) {
                    this.authenticated = true;
                    this.tm.removeMessageHandler(this, 0, 255);
                    return true;
                }
                if (b == 51) {
                    PacketUserauthFailure packetUserauthFailure = new PacketUserauthFailure(nextMessage, 0, nextMessage.length);
                    this.remainingMethods = packetUserauthFailure.getAuthThatCanContinue();
                    this.isPartialSuccess = packetUserauthFailure.isPartialSuccess();
                    return false;
                }
                if (b != 60) {
                    throw new IOException("Unexpected SSH message (type " + ((int) nextMessage[0]) + ")");
                }
                PacketUserauthInfoRequest packetUserauthInfoRequest = new PacketUserauthInfoRequest(nextMessage, 0, nextMessage.length);
                try {
                    InteractiveCallback interactiveCallback2 = interactiveCallback;
                    String[] strArrReplyToChallenge = interactiveCallback2.replyToChallenge(packetUserauthInfoRequest.getName(), packetUserauthInfoRequest.getInstruction(), packetUserauthInfoRequest.getNumPrompts(), packetUserauthInfoRequest.getPrompt(), packetUserauthInfoRequest.getEcho());
                    if (strArrReplyToChallenge == null) {
                        throw new IOException("Your callback may not return NULL!");
                    }
                    this.tm.sendMessage(new PacketUserauthInfoResponse(strArrReplyToChallenge).getPayload());
                    interactiveCallback = interactiveCallback2;
                } catch (Exception e) {
                    throw new IOException("Exception in callback.", e);
                }
            }
        } catch (IOException e2) {
            this.tm.close(e2, false);
            throw new IOException("Keyboard-interactive authentication failed.", e2);
        }
    }

    public boolean authenticateNone(String str) throws IOException {
        try {
            initialize(str);
            return this.authenticated;
        } catch (IOException e) {
            this.tm.close(e, false);
            throw new IOException("None authentication failed.", e);
        }
    }

    public boolean authenticatePassword(String str, String str2) throws IOException {
        try {
            initialize(str);
            if (!methodPossible("password")) {
                throw new IOException("Authentication method password not supported by the server at this stage.");
            }
            this.tm.sendMessage(new PacketUserauthRequestPassword("ssh-connection", str, str2).getPayload());
            byte[] nextMessage = getNextMessage();
            byte b = nextMessage[0];
            if (b == 52) {
                this.authenticated = true;
                this.tm.removeMessageHandler(this, 0, 255);
                return true;
            }
            if (b == 51) {
                PacketUserauthFailure packetUserauthFailure = new PacketUserauthFailure(nextMessage, 0, nextMessage.length);
                this.remainingMethods = packetUserauthFailure.getAuthThatCanContinue();
                this.isPartialSuccess = packetUserauthFailure.isPartialSuccess();
                return false;
            }
            throw new IOException("Unexpected SSH message (type " + ((int) nextMessage[0]) + ")");
        } catch (IOException e) {
            this.tm.close(e, false);
            throw new IOException("Password authentication failed.", e);
        }
    }

    public boolean authenticatePublicKey(String str, AgentProxy agentProxy) throws IOException {
        initialize(str);
        Iterator<AgentIdentity> it = agentProxy.getIdentities().iterator();
        while (it.hasNext()) {
            if (authenticatePublicKey(str, agentProxy, it.next())) {
                return true;
            }
        }
        return false;
    }

    public byte[] deQueue() {
        byte[] bArrFirstElement;
        synchronized (this.packets) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() + TIMEOUT;
                for (long jCurrentTimeMillis2 = System.currentTimeMillis(); this.packets.size() == 0 && jCurrentTimeMillis2 < jCurrentTimeMillis; jCurrentTimeMillis2 = System.currentTimeMillis()) {
                    if (this.connectionClosed) {
                        throw new IOException("The connection is closed.", this.tm.getReasonClosedCause());
                    }
                    try {
                        this.packets.wait(TIMEOUT);
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException(e.getMessage());
                    }
                }
                if (this.packets.size() == 0) {
                    throw new IOException("No valid packets after " + TIMEOUT + " milliseconds, you can increase the timeout by setting the property -D" + PROPERTY_TIMEOUT + "=<MILLISECONDS>");
                }
                bArrFirstElement = this.packets.firstElement();
                this.packets.removeElementAt(0);
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrFirstElement;
    }

    public byte[] getNextMessage() {
        while (true) {
            byte[] bArrDeQueue = deQueue();
            if (bArrDeQueue[0] != 53) {
                return bArrDeQueue;
            }
            String banner = new PacketUserauthBanner(bArrDeQueue, 0, bArrDeQueue.length).getBanner();
            if (banner != null) {
                Iterator<ConnectionMonitor> it = this.connMonitors.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveInfo(101, banner);
                }
            }
        }
    }

    public boolean getPartialSuccess() {
        return this.isPartialSuccess;
    }

    public String[] getRemainingMethods(String str) throws IOException {
        initialize(str);
        return this.remainingMethods;
    }

    @Override // com.trilead.ssh2.transport.MessageHandler
    public void handleEndMessage(Throwable th) {
        synchronized (this.packets) {
            this.connectionClosed = true;
            this.packets.notifyAll();
        }
    }

    @Override // com.trilead.ssh2.transport.MessageHandler
    public void handleMessage(byte[] bArr, int i) {
        synchronized (this.packets) {
            try {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                this.packets.addElement(bArr2);
                this.packets.notifyAll();
                if (this.packets.size() > 5) {
                    this.connectionClosed = true;
                    throw new IOException("Error, peer is flooding us with authentication packets.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean methodPossible(String str) {
        String[] strArr = this.remainingMethods;
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2.compareTo(str) == 0) {
                return true;
            }
        }
        return false;
    }

    public void setConnectionMonitors(Vector<ConnectionMonitor> vector) {
        this.connMonitors = (Vector) vector.clone();
    }

    public boolean authenticatePublicKey(String str, AgentProxy agentProxy, AgentIdentity agentIdentity) throws IOException {
        if (methodPossible("publickey")) {
            byte[] publicKeyBlob = agentIdentity.getPublicKeyBlob();
            if (publicKeyBlob == null) {
                return false;
            }
            TypesWriter typesWriter = new TypesWriter();
            byte[] sessionIdentifier = this.tm.getSessionIdentifier();
            typesWriter.writeString(sessionIdentifier, 0, sessionIdentifier.length);
            typesWriter.writeByte(50);
            typesWriter.writeString(str);
            typesWriter.writeString("ssh-connection");
            typesWriter.writeString("publickey");
            typesWriter.writeBoolean(true);
            typesWriter.writeString(agentIdentity.getAlgName());
            typesWriter.writeString(publicKeyBlob, 0, publicKeyBlob.length);
            this.tm.sendMessage(new PacketUserauthRequestPublicKey("ssh-connection", str, agentIdentity.getAlgName(), publicKeyBlob, agentIdentity.sign(typesWriter.getBytes())).getPayload());
            byte[] nextMessage = getNextMessage();
            byte b = nextMessage[0];
            if (b == 52) {
                this.authenticated = true;
                this.tm.removeMessageHandler(this, 0, 255);
                return true;
            }
            if (b == 51) {
                PacketUserauthFailure packetUserauthFailure = new PacketUserauthFailure(nextMessage, 0, nextMessage.length);
                this.remainingMethods = packetUserauthFailure.getAuthThatCanContinue();
                this.isPartialSuccess = packetUserauthFailure.isPartialSuccess();
                return false;
            }
            throw new IOException(za0.n(new StringBuilder("Unexpected SSH message (type "), nextMessage[0], ")"));
        }
        throw new IOException("Authentication method publickey not supported by the server at this stage.");
    }

    public boolean authenticatePublicKey(String str, char[] cArr, String str2, SecureRandom secureRandom) throws IOException {
        try {
            initialize(str);
            if (methodPossible("publickey")) {
                KeyPair keyPairDecodeKeyPair = PEMDecoder.decodeKeyPair(cArr, str2);
                PrivateKey privateKey = keyPairDecodeKeyPair.getPrivate();
                for (KeyAlgorithm<PublicKey, PrivateKey> keyAlgorithm : KeyAlgorithmManager.getSupportedAlgorithms()) {
                    if (keyAlgorithm.supportsKey(privateKey)) {
                        byte[] bArrEncodePublicKey = keyAlgorithm.encodePublicKey(keyPairDecodeKeyPair.getPublic());
                        TypesWriter typesWriter = new TypesWriter();
                        byte[] sessionIdentifier = this.tm.getSessionIdentifier();
                        typesWriter.writeString(sessionIdentifier, 0, sessionIdentifier.length);
                        typesWriter.writeByte(50);
                        typesWriter.writeString(str);
                        typesWriter.writeString("ssh-connection");
                        typesWriter.writeString("publickey");
                        typesWriter.writeBoolean(true);
                        typesWriter.writeString(keyAlgorithm.getKeyFormat());
                        typesWriter.writeString(bArrEncodePublicKey, 0, bArrEncodePublicKey.length);
                        this.tm.sendMessage(new PacketUserauthRequestPublicKey("ssh-connection", str, keyAlgorithm.getKeyFormat(), bArrEncodePublicKey, keyAlgorithm.encodeSignature(keyAlgorithm.generateSignature(typesWriter.getBytes(), keyPairDecodeKeyPair.getPrivate(), secureRandom))).getPayload());
                        byte[] nextMessage = getNextMessage();
                        byte b = nextMessage[0];
                        if (b == 52) {
                            this.authenticated = true;
                            this.tm.removeMessageHandler(this, 0, 255);
                            return true;
                        }
                        if (b == 51) {
                            PacketUserauthFailure packetUserauthFailure = new PacketUserauthFailure(nextMessage, 0, nextMessage.length);
                            this.remainingMethods = packetUserauthFailure.getAuthThatCanContinue();
                            this.isPartialSuccess = packetUserauthFailure.isPartialSuccess();
                            return false;
                        }
                        throw new IOException("Unexpected SSH message (type " + ((int) nextMessage[0]) + ")");
                    }
                }
                throw new IOException("Unknown private key type returned by the PEM decoder.");
            }
            throw new IOException("Authentication method publickey not supported by the server at this stage.");
        } catch (IOException e) {
            this.tm.close(e, false);
            throw new IOException("Publickey authentication failed.", e);
        }
    }
}
