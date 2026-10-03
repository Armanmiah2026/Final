package sensei0;

import android.util.Log;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sg {
    public static final AtomicInteger h = new AtomicInteger(1);
    public final int a;
    public final List b;
    public DatagramSocket d;
    public int f;
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final ThreadPoolExecutor e = new ThreadPoolExecutor(2, 8, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(64), new of(1), new ThreadPoolExecutor.CallerRunsPolicy());
    public final ConcurrentHashMap g = new ConcurrentHashMap();

    public sg(int i, List list) {
        this.a = i;
        this.b = list;
        this.f = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00a7 A[Catch: all -> 0x00bb, TryCatch #1 {all -> 0x00bb, blocks: (B:3:0x0012, B:5:0x004d, B:7:0x0051, B:21:0x00a7, B:23:0x00af, B:31:0x00ee, B:33:0x0116, B:37:0x011f, B:43:0x014c, B:47:0x017d, B:50:0x0186, B:51:0x019c, B:39:0x0126, B:40:0x013e, B:41:0x013f, B:42:0x0148, B:52:0x019d, B:53:0x01b5, B:26:0x00bf, B:28:0x00cd, B:30:0x00e2, B:54:0x01b6, B:55:0x01bd, B:11:0x0083, B:13:0x0089, B:15:0x0095, B:19:0x009e, B:56:0x01be, B:57:0x01e2), top: B:64:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf A[Catch: all -> 0x00bb, TryCatch #1 {all -> 0x00bb, blocks: (B:3:0x0012, B:5:0x004d, B:7:0x0051, B:21:0x00a7, B:23:0x00af, B:31:0x00ee, B:33:0x0116, B:37:0x011f, B:43:0x014c, B:47:0x017d, B:50:0x0186, B:51:0x019c, B:39:0x0126, B:40:0x013e, B:41:0x013f, B:42:0x0148, B:52:0x019d, B:53:0x01b5, B:26:0x00bf, B:28:0x00cd, B:30:0x00e2, B:54:0x01b6, B:55:0x01bd, B:11:0x0083, B:13:0x0089, B:15:0x0095, B:19:0x009e, B:56:0x01be, B:57:0x01e2), top: B:64:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0116 A[Catch: all -> 0x00bb, TryCatch #1 {all -> 0x00bb, blocks: (B:3:0x0012, B:5:0x004d, B:7:0x0051, B:21:0x00a7, B:23:0x00af, B:31:0x00ee, B:33:0x0116, B:37:0x011f, B:43:0x014c, B:47:0x017d, B:50:0x0186, B:51:0x019c, B:39:0x0126, B:40:0x013e, B:41:0x013f, B:42:0x0148, B:52:0x019d, B:53:0x01b5, B:26:0x00bf, B:28:0x00cd, B:30:0x00e2, B:54:0x01b6, B:55:0x01bd, B:11:0x0083, B:13:0x0089, B:15:0x0095, B:19:0x009e, B:56:0x01be, B:57:0x01e2), top: B:64:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019d A[Catch: all -> 0x00bb, TryCatch #1 {all -> 0x00bb, blocks: (B:3:0x0012, B:5:0x004d, B:7:0x0051, B:21:0x00a7, B:23:0x00af, B:31:0x00ee, B:33:0x0116, B:37:0x011f, B:43:0x014c, B:47:0x017d, B:50:0x0186, B:51:0x019c, B:39:0x0126, B:40:0x013e, B:41:0x013f, B:42:0x0148, B:52:0x019d, B:53:0x01b5, B:26:0x00bf, B:28:0x00cd, B:30:0x00e2, B:54:0x01b6, B:55:0x01bd, B:11:0x0083, B:13:0x0089, B:15:0x0095, B:19:0x009e, B:56:0x01be, B:57:0x01e2), top: B:64:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a(java.lang.String r20, int r21, byte[] r22) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.sg.a(java.lang.String, int, byte[]):byte[]");
    }

    public final void b() {
        x40 x40Var = new x40();
        int localPort = this.a;
        int i = localPort + 16;
        if (localPort <= i) {
            int i2 = localPort;
            while (true) {
                try {
                    x40Var.a = new DatagramSocket(new InetSocketAddress("127.0.0.1", i2));
                    localPort = i2;
                    break;
                } catch (SocketException unused) {
                    if (i2 != i) {
                        if (i2 == i) {
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        DatagramSocket datagramSocket = new DatagramSocket(new InetSocketAddress("127.0.0.1", 0));
                        x40Var.a = datagramSocket;
                        localPort = datagramSocket.getLocalPort();
                        break;
                    }
                }
            }
        }
        this.f = localPort;
        this.d = (DatagramSocket) x40Var.a;
        this.c.set(true);
        Thread thread = new Thread(new qg(0, this, x40Var));
        thread.setDaemon(true);
        thread.start();
        Log.i("DnsGateway", "DNS gateway on 127.0.0.1:" + localPort + " via socks 127.0.0.1:10808 -> " + this.b);
    }
}
