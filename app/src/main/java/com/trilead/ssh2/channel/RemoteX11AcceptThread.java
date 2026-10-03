package com.trilead.ssh2.channel;

import com.trilead.ssh2.log.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteX11AcceptThread extends Thread {
    private static final Logger log = Logger.getLogger(RemoteX11AcceptThread.class);
    Channel c;
    String remoteOriginatorAddress;
    int remoteOriginatorPort;
    Socket s;

    public RemoteX11AcceptThread(Channel channel, String str, int i) {
        this.c = channel;
        this.remoteOriginatorAddress = str;
        this.remoteOriginatorPort = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Channel channel;
        try {
            Channel channel2 = this.c;
            channel2.cm.sendOpenConfirmation(channel2);
            ChannelOutputStream stdinStream = this.c.getStdinStream();
            ChannelInputStream stdoutStream = this.c.getStdoutStream();
            byte[] bArr = new byte[6];
            if (stdoutStream.read(bArr) != 6) {
                throw new IOException("Unexpected EOF on X11 startup!");
            }
            byte b = bArr[0];
            if (b != 66 && b != 108) {
                throw new IOException("Unknown endian format in X11 message!");
            }
            int i = b == 66 ? 0 : 1;
            byte[] bArr2 = new byte[6];
            if (stdoutStream.read(bArr2) != 6) {
                throw new IOException("Unexpected EOF on X11 startup!");
            }
            int i2 = ((bArr2[i] & 255) << 8) | (bArr2[1 - i] & 255);
            int i3 = (bArr2[3 - i] & 255) | ((bArr2[i + 2] & 255) << 8);
            if (i2 > 256 || i3 > 256) {
                throw new IOException("Buggy X11 authorization data");
            }
            int i4 = (4 - (i2 % 4)) % 4;
            int i5 = (4 - (i3 % 4)) % 4;
            byte[] bArr3 = new byte[i2];
            byte[] bArr4 = new byte[i3];
            byte[] bArr5 = new byte[4];
            if (stdoutStream.read(bArr3) != i2) {
                throw new IOException("Unexpected EOF on X11 startup! (authProtocolName)");
            }
            if (stdoutStream.read(bArr5, 0, i4) != i4) {
                throw new IOException("Unexpected EOF on X11 startup! (authProtocolNamePadding)");
            }
            if (stdoutStream.read(bArr4) != i3) {
                throw new IOException("Unexpected EOF on X11 startup! (authProtocolData)");
            }
            if (stdoutStream.read(bArr5, 0, i5) != i5) {
                throw new IOException("Unexpected EOF on X11 startup! (authProtocolDataPadding)");
            }
            if (!"MIT-MAGIC-COOKIE-1".equals(new String(bArr3, StandardCharsets.ISO_8859_1))) {
                throw new IOException("Unknown X11 authorization protocol!");
            }
            if (i3 != 16) {
                throw new IOException("Wrong data length for X11 authorization data!");
            }
            StringBuilder sb = new StringBuilder(32);
            for (int i6 = 0; i6 < i3; i6++) {
                String hexString = Integer.toHexString(bArr4[i6] & 255);
                if (hexString.length() != 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            String string = sb.toString();
            synchronized (this.c) {
                channel = this.c;
                channel.hexX11FakeCookie = string;
            }
            X11ServerData x11ServerDataCheckX11Cookie = channel.cm.checkX11Cookie(string);
            if (x11ServerDataCheckX11Cookie == null) {
                throw new IOException("Invalid X11 cookie received.");
            }
            Socket socket = new Socket(x11ServerDataCheckX11Cookie.hostname, x11ServerDataCheckX11Cookie.port);
            this.s = socket;
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = this.s.getInputStream();
            outputStream.write(bArr);
            byte[] bArr6 = x11ServerDataCheckX11Cookie.x11_magic_cookie;
            if (bArr6 == null) {
                outputStream.write(new byte[6]);
            } else {
                if (bArr6.length != 16) {
                    throw new IOException("The real X11 cookie has an invalid length!");
                }
                outputStream.write(bArr2);
                outputStream.write(bArr3);
                outputStream.write(bArr5, 0, i4);
                outputStream.write(x11ServerDataCheckX11Cookie.x11_magic_cookie);
                outputStream.write(bArr5, 0, i5);
            }
            outputStream.flush();
            StreamForwarder streamForwarder = new StreamForwarder(this.c, null, null, stdoutStream, outputStream, "RemoteToX11");
            StreamForwarder streamForwarder2 = new StreamForwarder(this.c, null, null, inputStream, stdinStream, "X11ToRemote");
            streamForwarder.setDaemon(true);
            streamForwarder.start();
            streamForwarder2.run();
            while (streamForwarder.isAlive()) {
                try {
                    streamForwarder.join();
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            }
            Channel channel3 = this.c;
            channel3.cm.closeChannel(channel3, "EOF on both X11 streams reached.", true);
            this.s.close();
        } catch (IOException e) {
            log.log(50, "IOException in X11 proxy code", e);
            try {
                Channel channel4 = this.c;
                channel4.cm.closeChannel(channel4, "IOException in X11 proxy code (" + e.getMessage() + ")", true);
            } catch (IOException unused2) {
            }
            try {
                Socket socket2 = this.s;
                if (socket2 != null) {
                    socket2.close();
                }
            } catch (IOException unused3) {
            }
        }
    }
}
