package sensei0;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class bc0 implements dx {
    public static final Charset a = Charset.forName("UTF8");
    public static final bc0 b = new bc0();

    public static String c(ByteBuffer byteBuffer) {
        byte[] bArrArray;
        int iArrayOffset;
        if (byteBuffer == null) {
            return null;
        }
        int iRemaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArrArray = byteBuffer.array();
            iArrayOffset = byteBuffer.arrayOffset();
        } else {
            bArrArray = new byte[iRemaining];
            byteBuffer.get(bArrArray);
            iArrayOffset = 0;
        }
        return new String(bArrArray, iArrayOffset, iRemaining, a);
    }

    public static ByteBuffer d(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(a);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bytes.length);
        byteBufferAllocateDirect.put(bytes);
        return byteBufferAllocateDirect;
    }

    @Override // sensei0.dx
    public final /* bridge */ /* synthetic */ ByteBuffer a(Object obj) {
        return d((String) obj);
    }

    @Override // sensei0.dx
    public final /* bridge */ /* synthetic */ Object b(ByteBuffer byteBuffer) {
        return c(byteBuffer);
    }
}
