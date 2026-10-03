package net.sourceforge.jsocks;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProxyMessage {
    public int command;
    public String host;
    public InetAddress ip;
    public int port;
    public String user;
    public int version;

    public ProxyMessage() {
        this.ip = null;
        this.host = null;
        this.user = null;
    }

    public static final String bytes2IPV4(byte[] bArr, int i) {
        String str = "" + (bArr[i] & 255);
        for (int i2 = i + 1; i2 < i + 4; i2++) {
            str = str + "." + (bArr[i2] & 255);
        }
        return str;
    }

    public static final String bytes2IPV6(byte[] bArr, int i) {
        return null;
    }

    public InetAddress getInetAddress() {
        return this.ip;
    }

    public abstract void read(InputStream inputStream);

    public abstract void read(InputStream inputStream, boolean z);

    public String toString() {
        StringBuilder sb = new StringBuilder("Proxy Message:\nVersion:");
        sb.append(this.version);
        sb.append("\nCommand:");
        sb.append(this.command);
        sb.append("\nIP:     ");
        sb.append(this.ip);
        sb.append("\nPort:   ");
        sb.append(this.port);
        sb.append("\nUser:   ");
        return za0.o(sb, this.user, "\n");
    }

    public abstract void write(OutputStream outputStream);

    public ProxyMessage(int i, InetAddress inetAddress, int i2) {
        this.host = null;
        this.user = null;
        this.command = i;
        this.ip = inetAddress;
        this.port = i2;
    }
}
