package sensei0;

import android.window.BackEvent;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class h5 {
    public final aj a;

    public h5(kd kdVar, int i) {
        switch (i) {
            case 1:
                pf pfVar = new pf(27);
                aj ajVar = new aj(kdVar, "flutter/navigation", mh.o);
                this.a = ajVar;
                ajVar.b(pfVar);
                break;
            default:
                mh mhVar = new mh(18);
                aj ajVar2 = new aj(kdVar, "flutter/backgesture", sb0.a);
                this.a = ajVar2;
                ajVar2.b(mhVar);
                break;
        }
    }

    public static HashMap a(BackEvent backEvent) {
        HashMap map = new HashMap(3);
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        map.put("touchOffset", (Float.isNaN(touchX) || Float.isNaN(touchY)) ? null : Arrays.asList(Float.valueOf(touchX), Float.valueOf(touchY)));
        map.put("progress", Float.valueOf(backEvent.getProgress()));
        map.put("swipeEdge", Integer.valueOf(backEvent.getSwipeEdge()));
        return map;
    }
}
