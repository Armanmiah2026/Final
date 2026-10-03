package com.trilead.ssh2.packets;

import java.util.HashMap;
import java.util.Map;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class PacketSignal {
    private static final Map<Integer, String> SIGNALS;
    byte[] payload;
    public int recipientChannelID;
    public String signalName;

    static {
        HashMap map = new HashMap();
        SIGNALS = map;
        map.put(14, "ALRM");
        map.put(1, "HUP");
        map.put(2, "INT");
        map.put(9, "KILL");
        map.put(13, "PIPE");
        map.put(15, "TERM");
        map.put(6, "ABRT");
        map.put(8, "FPE");
        map.put(4, "ILL");
        map.put(3, "QUIT");
        map.put(11, "SEGV");
        map.put(5, "TRAP");
    }

    public PacketSignal(int i, String str) {
        this.recipientChannelID = i;
        this.signalName = str.startsWith("SIG") ? str.substring(3) : str;
    }

    public static String strsignal(int i) {
        return SIGNALS.get(Integer.valueOf(i));
    }

    public byte[] getPayload() {
        if (this.payload == null) {
            TypesWriter typesWriterG = za0.g(98);
            typesWriterG.writeUINT32(this.recipientChannelID);
            typesWriterG.writeString("signal");
            typesWriterG.writeBoolean(false);
            typesWriterG.writeString(this.signalName);
            this.payload = typesWriterG.getBytes();
        }
        return this.payload;
    }
}
