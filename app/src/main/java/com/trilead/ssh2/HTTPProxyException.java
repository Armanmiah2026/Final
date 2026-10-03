package com.trilead.ssh2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class HTTPProxyException extends IOException {
    private static final long serialVersionUID = 2241537397104426186L;
    public final int httpErrorCode;
    public final String httpResponse;

    public HTTPProxyException(String str, int i) {
        super("HTTP Proxy Error (" + i + " " + str + ")");
        this.httpResponse = str;
        this.httpErrorCode = i;
    }
}
