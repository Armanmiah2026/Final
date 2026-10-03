package sensei0;

import android.media.ImageReader;
import android.net.IpPrefix;
import java.net.InetAddress;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class w0 {
    public static /* synthetic */ ImageReader.Builder c(int i, int i2) {
        return new ImageReader.Builder(i, i2);
    }

    public static /* synthetic */ IpPrefix e(InetAddress inetAddress) {
        return new IpPrefix(inetAddress, 8);
    }

    public static /* synthetic */ IpPrefix f(InetAddress inetAddress, int i) {
        return new IpPrefix(inetAddress, i);
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ IpPrefix u(InetAddress inetAddress) {
        return new IpPrefix(inetAddress, 12);
    }

    public static /* synthetic */ IpPrefix y(InetAddress inetAddress) {
        return new IpPrefix(inetAddress, 16);
    }
}
