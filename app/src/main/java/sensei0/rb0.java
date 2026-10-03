package sensei0;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class rb0 implements dx {
    public static final rb0 a = new rb0();
    public static final boolean b;
    public static final Charset c;

    static {
        b = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        c = Charset.forName("UTF8");
    }

    public static void c(ByteBuffer byteBuffer, int i) {
        int iPosition = byteBuffer.position() % i;
        if (iPosition != 0) {
            byteBuffer.position((byteBuffer.position() + i) - iPosition);
        }
    }

    public static int d(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        int i = byteBuffer.get() & 255;
        return i < 254 ? i : i == 254 ? byteBuffer.getChar() : byteBuffer.getInt();
    }

    public static void g(qb0 qb0Var, int i) {
        int size = qb0Var.size() % i;
        if (size != 0) {
            for (int i2 = 0; i2 < i - size; i2++) {
                qb0Var.write(0);
            }
        }
    }

    public static void h(qb0 qb0Var, int i) {
        if (b) {
            qb0Var.write(i);
            qb0Var.write(i >>> 8);
            qb0Var.write(i >>> 16);
            qb0Var.write(i >>> 24);
            return;
        }
        qb0Var.write(i >>> 24);
        qb0Var.write(i >>> 16);
        qb0Var.write(i >>> 8);
        qb0Var.write(i);
    }

    public static void i(qb0 qb0Var, long j) {
        if (b) {
            qb0Var.write((byte) j);
            qb0Var.write((byte) (j >>> 8));
            qb0Var.write((byte) (j >>> 16));
            qb0Var.write((byte) (j >>> 24));
            qb0Var.write((byte) (j >>> 32));
            qb0Var.write((byte) (j >>> 40));
            qb0Var.write((byte) (j >>> 48));
            qb0Var.write((byte) (j >>> 56));
            return;
        }
        qb0Var.write((byte) (j >>> 56));
        qb0Var.write((byte) (j >>> 48));
        qb0Var.write((byte) (j >>> 40));
        qb0Var.write((byte) (j >>> 32));
        qb0Var.write((byte) (j >>> 24));
        qb0Var.write((byte) (j >>> 16));
        qb0Var.write((byte) (j >>> 8));
        qb0Var.write((byte) j);
    }

    public static void j(qb0 qb0Var, int i) {
        if (i < 254) {
            qb0Var.write(i);
            return;
        }
        if (i > 65535) {
            qb0Var.write(255);
            h(qb0Var, i);
            return;
        }
        qb0Var.write(254);
        if (b) {
            qb0Var.write(i);
            qb0Var.write(i >>> 8);
        } else {
            qb0Var.write(i >>> 8);
            qb0Var.write(i);
        }
    }

    @Override // sensei0.dx
    public final ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        qb0 qb0Var = new qb0();
        k(qb0Var, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(qb0Var.size());
        byteBufferAllocateDirect.put(qb0Var.a(), 0, qb0Var.size());
        return byteBufferAllocateDirect;
    }

    @Override // sensei0.dx
    public final Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object objE = e(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return objE;
    }

    public final Object e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return f(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public Object f(byte b2, ByteBuffer byteBuffer) {
        Charset charset = c;
        int i = 0;
        switch (b2) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case 5:
                byte[] bArr = new byte[d(byteBuffer)];
                byteBuffer.get(bArr);
                return new BigInteger(new String(bArr, charset), 16);
            case 6:
                c(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case 7:
                byte[] bArr2 = new byte[d(byteBuffer)];
                byteBuffer.get(bArr2);
                return new String(bArr2, charset);
            case 8:
                byte[] bArr3 = new byte[d(byteBuffer)];
                byteBuffer.get(bArr3);
                return bArr3;
            case 9:
                int iD = d(byteBuffer);
                int[] iArr = new int[iD];
                c(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr);
                byteBuffer.position((iD * 4) + byteBuffer.position());
                return iArr;
            case 10:
                int iD2 = d(byteBuffer);
                long[] jArr = new long[iD2];
                c(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr);
                byteBuffer.position((iD2 * 8) + byteBuffer.position());
                return jArr;
            case 11:
                int iD3 = d(byteBuffer);
                double[] dArr = new double[iD3];
                c(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr);
                byteBuffer.position((iD3 * 8) + byteBuffer.position());
                return dArr;
            case 12:
                int iD4 = d(byteBuffer);
                ArrayList arrayList = new ArrayList(iD4);
                while (i < iD4) {
                    arrayList.add(e(byteBuffer));
                    i++;
                }
                return arrayList;
            case 13:
                int iD5 = d(byteBuffer);
                HashMap map = new HashMap();
                while (i < iD5) {
                    map.put(e(byteBuffer), e(byteBuffer));
                    i++;
                }
                return map;
            case 14:
                int iD6 = d(byteBuffer);
                float[] fArr = new float[iD6];
                c(byteBuffer, 4);
                byteBuffer.asFloatBuffer().get(fArr);
                byteBuffer.position((iD6 * 4) + byteBuffer.position());
                return fArr;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    public void k(qb0 qb0Var, Object obj) {
        int i = 0;
        if (obj == null || obj.equals(null)) {
            qb0Var.write(0);
            return;
        }
        if (obj instanceof Boolean) {
            qb0Var.write(((Boolean) obj).booleanValue() ? 1 : 2);
            return;
        }
        boolean z = obj instanceof Number;
        Charset charset = c;
        if (z) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                qb0Var.write(3);
                h(qb0Var, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                qb0Var.write(4);
                i(qb0Var, ((Long) obj).longValue());
                return;
            }
            if ((obj instanceof Float) || (obj instanceof Double)) {
                qb0Var.write(6);
                g(qb0Var, 8);
                i(qb0Var, Double.doubleToLongBits(((Number) obj).doubleValue()));
                return;
            } else {
                if (!(obj instanceof BigInteger)) {
                    throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                }
                qb0Var.write(5);
                byte[] bytes = ((BigInteger) obj).toString(16).getBytes(charset);
                j(qb0Var, bytes.length);
                qb0Var.write(bytes, 0, bytes.length);
                return;
            }
        }
        if (obj instanceof CharSequence) {
            qb0Var.write(7);
            byte[] bytes2 = obj.toString().getBytes(charset);
            j(qb0Var, bytes2.length);
            qb0Var.write(bytes2, 0, bytes2.length);
            return;
        }
        if (obj instanceof byte[]) {
            qb0Var.write(8);
            byte[] bArr = (byte[]) obj;
            j(qb0Var, bArr.length);
            qb0Var.write(bArr, 0, bArr.length);
            return;
        }
        if (obj instanceof int[]) {
            qb0Var.write(9);
            int[] iArr = (int[]) obj;
            j(qb0Var, iArr.length);
            g(qb0Var, 4);
            int length = iArr.length;
            while (i < length) {
                h(qb0Var, iArr[i]);
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            qb0Var.write(10);
            long[] jArr = (long[]) obj;
            j(qb0Var, jArr.length);
            g(qb0Var, 8);
            int length2 = jArr.length;
            while (i < length2) {
                i(qb0Var, jArr[i]);
                i++;
            }
            return;
        }
        if (obj instanceof double[]) {
            qb0Var.write(11);
            double[] dArr = (double[]) obj;
            j(qb0Var, dArr.length);
            g(qb0Var, 8);
            int length3 = dArr.length;
            while (i < length3) {
                i(qb0Var, Double.doubleToLongBits(dArr[i]));
                i++;
            }
            return;
        }
        if (obj instanceof List) {
            qb0Var.write(12);
            List list = (List) obj;
            j(qb0Var, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k(qb0Var, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            qb0Var.write(13);
            Map map = (Map) obj;
            j(qb0Var, map.size());
            for (Map.Entry entry : map.entrySet()) {
                k(qb0Var, entry.getKey());
                k(qb0Var, entry.getValue());
            }
            return;
        }
        if (!(obj instanceof float[])) {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        }
        qb0Var.write(14);
        float[] fArr = (float[]) obj;
        j(qb0Var, fArr.length);
        g(qb0Var, 4);
        int length4 = fArr.length;
        while (i < length4) {
            h(qb0Var, Float.floatToIntBits(fArr[i]));
            i++;
        }
    }
}
