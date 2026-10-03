package sensei0;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class eg0 {
    public static final ThreadLocal d = new ThreadLocal();
    public final int a;
    public final j1 b;
    public volatile int c = 0;

    public eg0(j1 j1Var, int i) {
        this.b = j1Var;
        this.a = i;
    }

    public final int a(int i) {
        qx qxVarB = b();
        int iA = qxVarB.a(16);
        if (iA == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) qxVarB.d;
        int i2 = iA + qxVarB.a;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final qx b() {
        ThreadLocal threadLocal = d;
        qx qxVar = (qx) threadLocal.get();
        if (qxVar == null) {
            qxVar = new qx();
            threadLocal.set(qxVar);
        }
        rx rxVar = (rx) this.b.a;
        int iA = rxVar.a(6);
        if (iA != 0) {
            int i = iA + rxVar.a;
            int i2 = (this.a * 4) + ((ByteBuffer) rxVar.d).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) rxVar.d).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) rxVar.d;
            qxVar.d = byteBuffer;
            if (byteBuffer != null) {
                qxVar.a = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                qxVar.b = i4;
                qxVar.c = ((ByteBuffer) qxVar.d).getShort(i4);
                return qxVar;
            }
            qxVar.a = 0;
            qxVar.b = 0;
            qxVar.c = 0;
        }
        return qxVar;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        qx qxVarB = b();
        int iA = qxVarB.a(4);
        sb.append(Integer.toHexString(iA != 0 ? ((ByteBuffer) qxVarB.d).getInt(iA + qxVarB.a) : 0));
        sb.append(", codepoints:");
        qx qxVarB2 = b();
        int iA2 = qxVarB2.a(16);
        if (iA2 != 0) {
            int i2 = iA2 + qxVarB2.a;
            i = ((ByteBuffer) qxVarB2.d).getInt(((ByteBuffer) qxVarB2.d).getInt(i2) + i2);
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Integer.toHexString(a(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
