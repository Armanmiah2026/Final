package sensei0;

import android.view.KeyCharacterMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xs {
    public int a;

    public xs() {
        this.a = 0;
    }

    public Character a(int i) {
        char c = (char) i;
        if ((Integer.MIN_VALUE & i) != 0) {
            int i2 = i & Integer.MAX_VALUE;
            int i3 = this.a;
            if (i3 != 0) {
                this.a = KeyCharacterMap.getDeadChar(i3, i2);
            } else {
                this.a = i2;
            }
        } else {
            int i4 = this.a;
            if (i4 != 0) {
                int deadChar = KeyCharacterMap.getDeadChar(i4, i);
                if (deadChar > 0) {
                    c = (char) deadChar;
                }
                this.a = 0;
            }
        }
        return Character.valueOf(c);
    }

    public xs(int i) {
        this.a = i;
    }
}
