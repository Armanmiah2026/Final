package sensei0;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class d10 extends o {
    @Override // sensei0.o
    public final Random a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        pr.i("current(...)", threadLocalRandomCurrent);
        return threadLocalRandomCurrent;
    }
}
