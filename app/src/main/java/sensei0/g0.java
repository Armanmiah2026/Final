package sensei0;

import com.trilead.ssh2.sftp.AttribFlags;
import net.sourceforge.jsocks.Proxy;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public enum g0 {
    b(1),
    c(2),
    d(4),
    f(8),
    h(16),
    o(32),
    p(64),
    q(128),
    r(256),
    s(512),
    t(1024),
    u(2048),
    v(AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE),
    w(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT),
    x(AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME),
    y(AttribFlags.SSH_FILEXFER_ATTR_CTIME),
    z(Proxy.SOCKS_NO_PROXY),
    A(Proxy.SOCKS_PROXY_NO_CONNECT),
    B(Proxy.SOCKS_AUTH_NOT_SUPPORTED),
    C(Proxy.SOCKS_METHOD_NOTSUPPORTED),
    D(1048576),
    E(2097152),
    /* JADX INFO: Fake field, exist only in values array */
    EF1(4194304),
    /* JADX INFO: Fake field, exist only in values array */
    EF0(8388608),
    F(16777216),
    G(33554432);

    public final int a;

    g0(int i) {
        this.a = i;
    }
}
