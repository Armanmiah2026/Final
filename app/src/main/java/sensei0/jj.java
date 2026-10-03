package sensei0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class jj {
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    public jj(int i, int i2, byte[] bArr) {
        this(-1L, bArr, i, i2);
    }

    public static jj a(long j, ByteOrder byteOrder) {
        long[] jArr = {j};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[nj.E[4]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putInt((int) jArr[0]);
        return new jj(4, 1, byteBufferWrap.array());
    }

    public static jj b(lj ljVar, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[nj.E[5]]);
        byteBufferWrap.order(byteOrder);
        lj ljVar2 = new lj[]{ljVar}[0];
        byteBufferWrap.putInt((int) ljVar2.a);
        byteBufferWrap.putInt((int) ljVar2.b);
        return new jj(5, 1, byteBufferWrap.array());
    }

    public static jj c(int i, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[nj.E[3]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putShort((short) new int[]{i}[0]);
        return new jj(3, 1, byteBufferWrap.array());
    }

    public final double d(ByteOrder byteOrder) throws Throwable {
        Object objG = g(byteOrder);
        if (objG == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objG instanceof String) {
            return Double.parseDouble((String) objG);
        }
        if (objG instanceof long[]) {
            if (((long[]) objG).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objG instanceof int[]) {
            if (((int[]) objG).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objG instanceof double[]) {
            double[] dArr = (double[]) objG;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objG instanceof lj[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        lj[] ljVarArr = (lj[]) objG;
        if (ljVarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        lj ljVar = ljVarArr[0];
        return ljVar.a / ljVar.b;
    }

    public final int e(ByteOrder byteOrder) throws Throwable {
        Object objG = g(byteOrder);
        if (objG == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objG instanceof String) {
            return Integer.parseInt((String) objG);
        }
        if (objG instanceof long[]) {
            long[] jArr = (long[]) objG;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objG instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objG;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String f(ByteOrder byteOrder) throws Throwable {
        Object objG = g(byteOrder);
        if (objG == null) {
            return null;
        }
        if (objG instanceof String) {
            return (String) objG;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (objG instanceof long[]) {
            long[] jArr = (long[]) objG;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objG instanceof int[]) {
            int[] iArr = (int[]) objG;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objG instanceof double[]) {
            double[] dArr = (double[]) objG;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objG instanceof lj[])) {
            return null;
        }
        lj[] ljVarArr = (lj[]) objG;
        while (i < ljVarArr.length) {
            sb.append(ljVarArr[i].a);
            sb.append('/');
            sb.append(ljVarArr[i].b);
            i++;
            if (i != ljVarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:17:0x0032 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v23, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v24, types: [long[]] */
    /* JADX WARN: Type inference failed for: r14v25, types: [sensei0.lj[]] */
    /* JADX WARN: Type inference failed for: r14v26, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v27, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v28, types: [sensei0.lj[]] */
    /* JADX WARN: Type inference failed for: r14v29, types: [double[]] */
    /* JADX WARN: Type inference failed for: r14v30, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r14v31, types: [double[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.Serializable g(java.nio.ByteOrder r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.jj.g(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(nj.D[this.a]);
        sb.append(", data length:");
        return za0.n(sb, this.d.length, ")");
    }

    public jj(long j, byte[] bArr, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bArr;
    }
}
