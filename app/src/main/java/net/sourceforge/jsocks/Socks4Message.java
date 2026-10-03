package net.sourceforge.jsocks;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Socks4Message extends ProxyMessage {
    public static final int REPLY_BAD_IDENTD = 93;
    public static final int REPLY_NO_CONNECT = 92;
    public static final int REPLY_OK = 90;
    public static final int REPLY_REJECTED = 91;
    public static final int REQUEST_BIND = 2;
    public static final int REQUEST_CONNECT = 1;
    static final int SOCKS_VERSION = 4;
    static final String[] replyMessage = {"Request Granted", "Request Rejected or Failed", "Failed request, can't connect to Identd", "Failed request, bad user name"};
    private byte[] msgBytes;
    private int msgLength;

    public Socks4Message(InputStream inputStream, boolean z) throws IOException {
        this.msgBytes = null;
        read(inputStream, z);
    }

    public static InetAddress bytes2IP(byte[] bArr) {
        try {
            return InetAddress.getByName(ProxyMessage.bytes2IPV4(bArr, 0));
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    @Override // net.sourceforge.jsocks.ProxyMessage
    public void read(InputStream inputStream) throws IOException {
        read(inputStream, true);
    }

    @Override // net.sourceforge.jsocks.ProxyMessage
    public void write(OutputStream outputStream) throws IOException {
        if (this.msgBytes == null) {
            Socks4Message socks4Message = new Socks4Message(this.version, this.command, this.ip, this.port, this.user);
            this.msgBytes = socks4Message.msgBytes;
            this.msgLength = socks4Message.msgLength;
        }
        outputStream.write(this.msgBytes);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    @Override // net.sourceforge.jsocks.ProxyMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void read(java.io.InputStream r5, boolean r6) throws java.io.IOException {
        /*
            r4 = this;
            java.io.DataInputStream r0 = new java.io.DataInputStream
            r0.<init>(r5)
            int r1 = r0.readUnsignedByte()
            r4.version = r1
            int r1 = r0.readUnsignedByte()
            r4.command = r1
            if (r6 == 0) goto L2d
            r2 = 90
            if (r1 == r2) goto L2d
            if (r1 <= r2) goto L23
            r5 = 93
            if (r1 >= r5) goto L23
            java.lang.String[] r5 = net.sourceforge.jsocks.Socks4Message.replyMessage
            int r1 = r1 - r2
            r5 = r5[r1]
            goto L25
        L23:
            java.lang.String r5 = "Unknown Reply Code"
        L25:
            net.sourceforge.jsocks.SocksException r6 = new net.sourceforge.jsocks.SocksException
            int r0 = r4.command
            r6.<init>(r0, r5)
            throw r6
        L2d:
            int r1 = r0.readUnsignedShort()
            r4.port = r1
            r1 = 4
            byte[] r1 = new byte[r1]
            r0.readFully(r1)
            r0 = 0
            r2 = r1[r0]
            if (r2 != 0) goto L4e
            r2 = 1
            r3 = r1[r2]
            if (r3 != 0) goto L4e
            r3 = 2
            r3 = r1[r3]
            if (r3 != 0) goto L4e
            r3 = 3
            r3 = r1[r3]
            if (r3 == 0) goto L4e
            goto L5b
        L4e:
            java.net.InetAddress r1 = bytes2IP(r1)
            r4.ip = r1
            java.lang.String r1 = r1.getHostName()
            r4.host = r1
            r2 = r0
        L5b:
            if (r6 != 0) goto L89
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
        L62:
            int r1 = r5.read()
            if (r1 == 0) goto L6d
            char r1 = (char) r1
            r6.append(r1)
            goto L62
        L6d:
            java.lang.String r1 = r6.toString()
            r4.user = r1
            if (r2 == 0) goto L89
            r6.setLength(r0)
        L78:
            int r0 = r5.read()
            if (r0 == 0) goto L83
            char r0 = (char) r0
            r6.append(r0)
            goto L78
        L83:
            java.lang.String r5 = r6.toString()
            r4.host = r5
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sourceforge.jsocks.Socks4Message.read(java.io.InputStream, boolean):void");
    }

    public Socks4Message(int i) {
        super(i, null, 0);
        this.user = null;
        this.msgLength = 2;
        this.msgBytes = new byte[]{0, (byte) this.command};
    }

    public Socks4Message(int i, InetAddress inetAddress, int i2) {
        this(0, i, inetAddress, i2, null);
    }

    public Socks4Message(int i, InetAddress inetAddress, int i2, String str) {
        this(4, i, inetAddress, i2, str);
    }

    public Socks4Message(int i, int i2, InetAddress inetAddress, int i3, String str) {
        byte[] address;
        super(i2, inetAddress, i3);
        this.user = str;
        this.version = i;
        int length = str == null ? 8 : str.length() + 9;
        this.msgLength = length;
        byte[] bArr = new byte[length];
        this.msgBytes = bArr;
        bArr[0] = (byte) i;
        bArr[1] = (byte) this.command;
        bArr[2] = (byte) (i3 >> 8);
        bArr[3] = (byte) i3;
        if (inetAddress != null) {
            address = inetAddress.getAddress();
        } else {
            address = new byte[]{0, 0, 0, 0};
        }
        System.arraycopy(address, 0, this.msgBytes, 4, 4);
        if (str != null) {
            byte[] bytes = str.getBytes();
            System.arraycopy(bytes, 0, this.msgBytes, 8, bytes.length);
            byte[] bArr2 = this.msgBytes;
            bArr2[bArr2.length - 1] = 0;
        }
    }
}
