package sensei0;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.sensei.tunnel.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class i7 extends e40 {
    public final Paint a;
    public final List b;

    public i7() {
        Paint paint = new Paint();
        this.a = paint;
        this.b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // sensei0.e40
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Canvas canvas2;
        int iV;
        int iT;
        float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
        Paint paint = this.a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((dt) it.next()).getClass();
            int i = x9.a;
            float f = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f))));
            int iU = 0;
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).O()) {
                j7 j7Var = ((CarouselLayoutManager) recyclerView.getLayoutManager()).i;
                switch (j7Var.b) {
                    case 0:
                        break;
                    default:
                        iU = j7Var.c.w();
                        break;
                }
                float f2 = iU;
                j7 j7Var2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).i;
                switch (j7Var2.b) {
                    case 0:
                        iT = j7Var2.c.g;
                        break;
                    default:
                        CarouselLayoutManager carouselLayoutManager = j7Var2.c;
                        iT = carouselLayoutManager.g - carouselLayoutManager.t();
                        break;
                }
                canvas2 = canvas;
                canvas2.drawLine(0.0f, f2, 0.0f, iT, paint);
            } else {
                canvas2 = canvas;
                j7 j7Var3 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).i;
                switch (j7Var3.b) {
                    case 0:
                        iU = j7Var3.c.u();
                        break;
                }
                float f3 = iU;
                j7 j7Var4 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).i;
                switch (j7Var4.b) {
                    case 0:
                        CarouselLayoutManager carouselLayoutManager2 = j7Var4.c;
                        iV = carouselLayoutManager2.f - carouselLayoutManager2.v();
                        break;
                    default:
                        iV = j7Var4.c.f;
                        break;
                }
                canvas2.drawLine(f3, 0.0f, iV, 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
