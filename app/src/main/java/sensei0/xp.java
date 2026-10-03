package sensei0;

import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xp implements Runnable {
    public static final ThreadLocal f = new ThreadLocal();
    public static final hc h = new hc(1);
    public ArrayList a;
    public long b;
    public long c;
    public ArrayList d;

    public final void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.u && this.b == 0) {
            this.b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        vp vpVar = recyclerView.e0;
        vpVar.a = i;
        vpVar.b = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a8, code lost:
    
        r9 = r4.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00aa, code lost:
    
        r4.E++;
        r9.g(r8, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b7, code lost:
    
        if (r5.e() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        if (r5.f() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bf, code lost:
    
        r9.e(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c5, code lost:
    
        r9.a(null, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c8, code lost:
    
        r4.v(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d8, code lost:
    
        r4.v(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00db, code lost:
    
        throw r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(long r13) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.xp.b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.a;
        try {
            int i = cf0.a;
            Trace.beginSection("RV Prefetch");
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = (RecyclerView) arrayList.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.c);
                }
            }
            this.b = 0L;
            Trace.endSection();
        } catch (Throwable th) {
            this.b = 0L;
            int i3 = cf0.a;
            Trace.endSection();
            throw th;
        }
    }
}
