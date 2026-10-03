package com.trilead.ssh2.util;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class IOUtils {
    public static void closeQuietly(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }
}
