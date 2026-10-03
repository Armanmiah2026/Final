package sensei0;

import android.R;
import android.content.Context;
import android.graphics.Matrix;
import android.util.TypedValue;
import android.view.MotionEvent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class s2 {
    public static final Matrix f = new Matrix();
    public final io.flutter.embedding.engine.renderer.e a;
    public final i3 b;
    public final boolean c;
    public final HashMap d = new HashMap();
    public int e;

    public s2(io.flutter.embedding.engine.renderer.e eVar, boolean z) {
        this.a = eVar;
        if (i3.d == null) {
            i3.d = new i3(19);
        }
        this.b = i3.d;
        this.c = z;
    }

    public static int b(int i) {
        if (i == 0) {
            return 4;
        }
        if (i != 1) {
            if (i == 5) {
                return 4;
            }
            if (i != 6) {
                if (i == 2) {
                    return 5;
                }
                if (i != 7) {
                    if (i == 3) {
                        return 0;
                    }
                    if (i != 8) {
                        return -1;
                    }
                }
                return 3;
            }
        }
        return 6;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v7 int, still in use, count: 2, list:
          (r11v7 int) from 0x00a6: IF  (r11v7 int) == (-1 int)  -> B:4:0x000d A[HIDDEN] (LINE:167)
          (r11v7 int) from 0x00ac: PHI (r11v2 int) = (r11v1 int), (r11v7 int) binds: [B:42:0x00aa, B:40:0x00a6] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:53)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        */
    public final void a(android.view.MotionEvent r29, int r30, int r31, int r32, android.graphics.Matrix r33, java.nio.ByteBuffer r34, android.content.Context r35) {
        /*
            Method dump skipped, instruction units count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.s2.a(android.view.MotionEvent, int, int, int, android.graphics.Matrix, java.nio.ByteBuffer, android.content.Context):void");
    }

    public final int c(Context context) {
        if (this.e == 0) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                return 48;
            }
            this.e = (int) typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.e;
    }

    public final void d(MotionEvent motionEvent, Matrix matrix) {
        int actionMasked = motionEvent.getActionMasked();
        int iB = b(motionEvent.getActionMasked());
        char c = 5;
        boolean z = actionMasked == 0 || actionMasked == 5;
        boolean z2 = !z && (actionMasked == 1 || actionMasked == 6);
        int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
        if (toolType == 1) {
            c = 0;
        } else if (toolType == 2) {
            c = 2;
        } else if (toolType == 3) {
            c = 1;
        } else if (toolType == 4) {
            c = 3;
        }
        int i = (z2 && c == 0) ? 1 : 0;
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((pointerCount + i) * 288);
        byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (z) {
            a(motionEvent, motionEvent.getActionIndex(), iB, 0, matrix, byteBufferAllocateDirect, null);
        } else if (z2) {
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != motionEvent.getActionIndex() && motionEvent.getToolType(i2) == 1) {
                    a(motionEvent, i2, 5, 1, matrix, byteBufferAllocateDirect, null);
                }
            }
            a(motionEvent, motionEvent.getActionIndex(), iB, 0, matrix, byteBufferAllocateDirect, null);
            if (i != 0) {
                a(motionEvent, motionEvent.getActionIndex(), 2, 0, matrix, byteBufferAllocateDirect, null);
            }
        } else {
            for (int i3 = 0; i3 < pointerCount; i3++) {
                a(motionEvent, i3, iB, (pointerCount << 8) | 2, matrix, byteBufferAllocateDirect, null);
            }
        }
        if (byteBufferAllocateDirect.position() % 288 != 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        this.a.a.dispatchPointerDataPacket(byteBufferAllocateDirect, byteBufferAllocateDirect.position());
    }
}
