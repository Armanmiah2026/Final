package com.trilead.ssh2;

import com.trilead.ssh2.crypto.Base64;
import com.trilead.ssh2.transport.ClientServerHello;
import com.trilead.ssh2.transport.TransportManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class HTTPProxyData implements ProxyData {
    private final String proxyHost;
    private final String proxyPass;
    private final int proxyPort;
    private final String proxyUser;
    private final String[] requestHeaderLines;
    private Socket sock;

    public HTTPProxyData(String str, int i) {
        this(str, i, null, null);
    }

    @Override // com.trilead.ssh2.ProxyData
    public void close() {
        Socket socket = this.sock;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.trilead.ssh2.ProxyData
    public Socket openConnection(String str, int i, int i2, int i3) throws IOException {
        this.sock = new Socket();
        this.sock.connect(new InetSocketAddress(TransportManager.createInetAddress(this.proxyHost), this.proxyPort), i2);
        this.sock.setSoTimeout(i3);
        StringBuffer stringBuffer = new StringBuffer("CONNECT ");
        stringBuffer.append(str);
        stringBuffer.append(':');
        stringBuffer.append(i);
        stringBuffer.append(" HTTP/1.0\r\n");
        if (this.proxyUser != null && this.proxyPass != null) {
            char[] cArrEncode = Base64.encode((this.proxyUser + ":" + this.proxyPass).getBytes(StandardCharsets.ISO_8859_1));
            stringBuffer.append("Proxy-Authorization: Basic ");
            stringBuffer.append(cArrEncode);
            stringBuffer.append("\r\n");
        }
        if (this.requestHeaderLines != null) {
            int i4 = 0;
            while (true) {
                String[] strArr = this.requestHeaderLines;
                if (i4 >= strArr.length) {
                    break;
                }
                String str2 = strArr[i4];
                if (str2 != null) {
                    stringBuffer.append(str2);
                    stringBuffer.append("\r\n");
                }
                i4++;
            }
        }
        stringBuffer.append("\r\n");
        OutputStream outputStream = this.sock.getOutputStream();
        try {
            outputStream.write(stringBuffer.toString().getBytes(StandardCharsets.ISO_8859_1));
        } catch (UnsupportedEncodingException unused) {
            outputStream.write(stringBuffer.toString().getBytes());
        }
        outputStream.flush();
        byte[] bArr = new byte[1024];
        InputStream inputStream = this.sock.getInputStream();
        String str3 = new String(bArr, 0, ClientServerHello.readLineRN(inputStream, bArr), StandardCharsets.ISO_8859_1);
        if (!str3.startsWith("HTTP/")) {
            throw new IOException("The proxy did not send back a valid HTTP response.");
        }
        if (str3.length() < 14 || str3.charAt(8) != ' ' || str3.charAt(12) != ' ') {
            throw new IOException("The proxy did not send back a valid HTTP response.");
        }
        try {
            int i5 = Integer.parseInt(str3.substring(9, 12));
            if (i5 < 0 || i5 > 999) {
                throw new IOException("The proxy did not send back a valid HTTP response.");
            }
            if (i5 != 200) {
                throw new HTTPProxyException(str3.substring(13), i5);
            }
            while (ClientServerHello.readLineRN(inputStream, bArr) != 0) {
            }
            return this.sock;
        } catch (NumberFormatException unused2) {
            throw new IOException("The proxy did not send back a valid HTTP response.");
        }
    }

    public HTTPProxyData(String str, int i, String str2, String str3) {
        this(str, i, str2, str3, null);
    }

    public HTTPProxyData(String str, int i, String str2, String str3, String[] strArr) {
        if (str == null) {
            throw new IllegalArgumentException("proxyHost must be non-null");
        }
        if (i >= 0) {
            this.proxyHost = str;
            this.proxyPort = i;
            this.proxyUser = str2;
            this.proxyPass = str3;
            this.requestHeaderLines = strArr;
            return;
        }
        throw new IllegalArgumentException("proxyPort must be non-negative");
    }
}
