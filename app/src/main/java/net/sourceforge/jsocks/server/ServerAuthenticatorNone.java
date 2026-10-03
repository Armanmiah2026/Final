package net.sourceforge.jsocks.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.DatagramPacket;
import java.net.Socket;
import net.sourceforge.jsocks.ProxyMessage;
import net.sourceforge.jsocks.UDPEncapsulation;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ServerAuthenticatorNone implements ServerAuthenticator {
    static final byte[] socks5response = {5, 0};
    InputStream in;
    OutputStream out;

    public ServerAuthenticatorNone() {
        this.in = null;
        this.out = null;
    }

    public static boolean selectSocks5Authentication(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        int i2 = inputStream.read();
        boolean z = false;
        if (i2 <= 0) {
            return false;
        }
        byte[] bArr = new byte[i2];
        byte[] bArr2 = {5, -1};
        int i3 = 0;
        while (i3 < i2) {
            i3 += inputStream.read(bArr, i3, i2 - i3);
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            if (bArr[i4] == i) {
                bArr2[1] = (byte) i;
                z = true;
                break;
            }
            i4++;
        }
        outputStream.write(bArr2);
        return z;
    }

    @Override // net.sourceforge.jsocks.server.ServerAuthenticator
    public boolean checkRequest(DatagramPacket datagramPacket, boolean z) {
        return true;
    }

    @Override // net.sourceforge.jsocks.server.ServerAuthenticator
    public InputStream getInputStream() {
        return this.in;
    }

    @Override // net.sourceforge.jsocks.server.ServerAuthenticator
    public OutputStream getOutputStream() {
        return this.out;
    }

    @Override // net.sourceforge.jsocks.server.ServerAuthenticator
    public UDPEncapsulation getUdpEncapsulation() {
        return null;
    }

    @Override // net.sourceforge.jsocks.server.ServerAuthenticator
    public ServerAuthenticator startSession(Socket socket) throws IOException {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(socket.getInputStream());
        OutputStream outputStream = socket.getOutputStream();
        int i = pushbackInputStream.read();
        if (i == 5) {
            if (!selectSocks5Authentication(pushbackInputStream, outputStream, 0)) {
                return null;
            }
        } else {
            if (i != 4) {
                return null;
            }
            pushbackInputStream.unread(i);
        }
        return new ServerAuthenticatorNone(pushbackInputStream, outputStream);
    }

    @Override // net.sourceforge.jsocks.server.ServerAuthenticator
    public boolean checkRequest(ProxyMessage proxyMessage) {
        return true;
    }

    public ServerAuthenticatorNone(InputStream inputStream, OutputStream outputStream) {
        this.in = inputStream;
        this.out = outputStream;
    }

    @Override // net.sourceforge.jsocks.server.ServerAuthenticator
    public void endSession() {
    }
}
