package sensei0;

import com.google.android.material.carousel.CarouselLayoutManager;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class j7 {
    public final int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ CarouselLayoutManager c;

    public j7(int i) {
        this.a = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j7(CarouselLayoutManager carouselLayoutManager, int i) {
        this(1);
        this.b = i;
        switch (i) {
            case 1:
                this.c = carouselLayoutManager;
                this(0);
                break;
            default:
                this.c = carouselLayoutManager;
                break;
        }
    }
}
