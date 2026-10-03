package sensei0;

import android.webkit.ConsoleMessage;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ra {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
        a = iArr;
        try {
            iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
