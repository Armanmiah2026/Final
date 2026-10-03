package sensei0;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class sb0 implements ux {
    public static final sb0 a;

    static {
        rb0 rb0Var = rb0.a;
        a = new sb0();
    }

    @Override // sensei0.ux
    public final ByteBuffer c(Object obj) throws IOException {
        qb0 qb0Var = new qb0();
        qb0Var.write(0);
        rb0.a.k(qb0Var, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(qb0Var.size());
        byteBufferAllocateDirect.put(qb0Var.a(), 0, qb0Var.size());
        return byteBufferAllocateDirect;
    }

    @Override // sensei0.ux
    public final ByteBuffer e(String str, String str2) throws IOException {
        qb0 qb0Var = new qb0();
        qb0Var.write(1);
        rb0 rb0Var = rb0.a;
        rb0Var.k(qb0Var, "error");
        rb0Var.k(qb0Var, str);
        rb0Var.k(qb0Var, null);
        rb0Var.k(qb0Var, str2);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(qb0Var.size());
        byteBufferAllocateDirect.put(qb0Var.a(), 0, qb0Var.size());
        return byteBufferAllocateDirect;
    }

    @Override // sensei0.ux
    public final ByteBuffer f(String str, String str2, Object obj) throws IOException {
        qb0 qb0Var = new qb0();
        qb0Var.write(1);
        rb0 rb0Var = rb0.a;
        rb0Var.k(qb0Var, str);
        rb0Var.k(qb0Var, str2);
        if (obj instanceof Throwable) {
            rb0Var.k(qb0Var, Log.getStackTraceString((Throwable) obj));
        } else {
            rb0Var.k(qb0Var, obj);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(qb0Var.size());
        byteBufferAllocateDirect.put(qb0Var.a(), 0, qb0Var.size());
        return byteBufferAllocateDirect;
    }

    @Override // sensei0.ux
    public final i3 g(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        rb0 rb0Var = rb0.a;
        Object objE = rb0Var.e(byteBuffer);
        Object objE2 = rb0Var.e(byteBuffer);
        if (!(objE instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new i3((String) objE, objE2, 17, false);
    }

    @Override // sensei0.ux
    public final Object h(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        byte b = byteBuffer.get();
        if (b != 0) {
            if (b == 1) {
            }
            throw new IllegalArgumentException("Envelope corrupted");
        }
        Object objE = rb0.a.e(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return objE;
        }
        rb0 rb0Var = rb0.a;
        Object objE2 = rb0Var.e(byteBuffer);
        Object objE3 = rb0Var.e(byteBuffer);
        Object objE4 = rb0Var.e(byteBuffer);
        if ((objE2 instanceof String) && ((objE3 == null || (objE3 instanceof String)) && !byteBuffer.hasRemaining())) {
            throw new mm((String) objE2, (String) objE3, objE4);
        }
        throw new IllegalArgumentException("Envelope corrupted");
    }

    @Override // sensei0.ux
    public final ByteBuffer i(i3 i3Var) {
        qb0 qb0Var = new qb0();
        rb0 rb0Var = rb0.a;
        rb0Var.k(qb0Var, (String) i3Var.b);
        rb0Var.k(qb0Var, i3Var.c);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(qb0Var.size());
        byteBufferAllocateDirect.put(qb0Var.a(), 0, qb0Var.size());
        return byteBufferAllocateDirect;
    }
}
