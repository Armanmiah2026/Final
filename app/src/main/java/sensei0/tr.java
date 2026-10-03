package sensei0;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class tr extends IOException {
    public boolean a;

    public static tr a() {
        return new tr("Protocol message had invalid UTF-8.");
    }

    public static sr b() {
        return new sr("Protocol message tag had invalid wire type.");
    }

    public static tr c() {
        return new tr("CodedInputStream encountered a malformed varint.");
    }

    public static tr d() {
        return new tr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static tr e() {
        return new tr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
