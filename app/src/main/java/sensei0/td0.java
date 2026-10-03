package sensei0;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class td0 {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public td0(String str, int i, int i2, int i3, int i4) {
        if (!(i == -1 && i2 == -1) && (i < 0 || i2 < 0)) {
            throw new IndexOutOfBoundsException("invalid selection: (" + i + ", " + i2 + ")");
        }
        if (!(i3 == -1 && i4 == -1) && (i3 < 0 || i3 > i4)) {
            throw new IndexOutOfBoundsException("invalid composing range: (" + i3 + ", " + i4 + ")");
        }
        if (i4 > str.length()) {
            throw new IndexOutOfBoundsException(za0.h(i3, "invalid composing start: "));
        }
        if (i > str.length()) {
            throw new IndexOutOfBoundsException(za0.h(i, "invalid selection start: "));
        }
        if (i2 > str.length()) {
            throw new IndexOutOfBoundsException(za0.h(i2, "invalid selection end: "));
        }
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static td0 a(JSONObject jSONObject) {
        return new td0(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
    }
}
