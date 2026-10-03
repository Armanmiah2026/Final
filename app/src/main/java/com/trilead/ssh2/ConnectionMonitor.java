package com.trilead.ssh2;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public interface ConnectionMonitor {
    public static final int SERVER_BANNER = 101;

    void connectionLost(Throwable th);

    void log(int i, String str, String str2);

    void onReceiveInfo(int i, String str);
}
