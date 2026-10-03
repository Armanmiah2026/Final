package com.trilead.ssh2.log;

import com.trilead.ssh2.DebugLogger;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Logger {
    public static boolean enabled = false;
    public static DebugLogger logger;
    private final java.util.logging.Logger log;

    public Logger(Class cls) {
        this.log = java.util.logging.Logger.getLogger(cls.getName());
    }

    public static final Logger getLogger(Class cls) {
        return new Logger(cls);
    }

    private Level level(int i) {
        return i <= 20 ? Level.FINE : i <= 50 ? Level.FINER : Level.FINEST;
    }

    public final boolean isEnabled() {
        return true;
    }

    public final void log(int i, String str) {
        this.log.log(level(i), str);
    }

    public final void log(int i, String str, Throwable th) {
        this.log.log(level(i), str, th);
    }
}
