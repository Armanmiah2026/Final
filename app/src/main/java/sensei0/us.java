package sensei0;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class us implements ys {
    public final a6 a;
    public final HashMap b = new HashMap();
    public final HashMap c;
    public final xs d;

    public us(a6 a6Var) {
        HashMap map = new HashMap();
        this.c = map;
        this.d = new xs();
        this.a = a6Var;
        fm fmVar = ct.a;
        bt btVar = new bt();
        btVar.a = false;
        bt btVar2 = new bt[]{btVar}[0];
        btVar2.getClass();
        map.put(4294967556L, btVar2);
    }

    public final void a(rs rsVar, final g6 g6Var) {
        long j;
        long j2;
        byte[] bytes = null;
        z5 z5Var = g6Var == null ? null : new z5() { // from class: sensei0.ss
            @Override // sensei0.z5
            public final void a(ByteBuffer byteBuffer) {
                Boolean boolValueOf = Boolean.FALSE;
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                    if (byteBuffer.capacity() != 0) {
                        boolValueOf = Boolean.valueOf(byteBuffer.get() != 0);
                    }
                } else {
                    Log.w("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
                }
                g6Var.c(boolValueOf.booleanValue());
            }
        };
        try {
            String str = rsVar.g;
            if (str != null) {
                bytes = str.getBytes("UTF-8");
            }
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(length + 56);
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocateDirect.putLong(length);
            byteBufferAllocateDirect.putLong(rsVar.a);
            int i = rsVar.b;
            if (i == 1) {
                j = 0;
            } else if (i == 2) {
                j = 1;
            } else {
                if (i != 3) {
                    throw null;
                }
                j = 2;
            }
            byteBufferAllocateDirect.putLong(j);
            byteBufferAllocateDirect.putLong(rsVar.c);
            byteBufferAllocateDirect.putLong(rsVar.d);
            byteBufferAllocateDirect.putLong(rsVar.e ? 1L : 0L);
            int i2 = rsVar.f;
            if (i2 == 1) {
                j2 = 0;
            } else if (i2 == 2) {
                j2 = 1;
            } else if (i2 == 3) {
                j2 = 2;
            } else if (i2 == 4) {
                j2 = 3;
            } else {
                if (i2 != 5) {
                    throw null;
                }
                j2 = 4;
            }
            byteBufferAllocateDirect.putLong(j2);
            if (bytes != null) {
                byteBufferAllocateDirect.put(bytes);
            }
            this.a.p("flutter/keydata", byteBufferAllocateDirect, z5Var);
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }

    public final void b(boolean z, Long l, Long l2, long j) {
        rs rsVar = new rs();
        rsVar.a = j;
        rsVar.b = z ? 1 : 2;
        rsVar.d = l.longValue();
        rsVar.c = l2.longValue();
        rsVar.g = null;
        rsVar.e = true;
        rsVar.f = 1;
        if (l2.longValue() != 0 && l.longValue() != 0) {
            if (!z) {
                l = null;
            }
            c(l2, l);
        }
        a(rsVar, null);
    }

    public final void c(Long l, Long l2) {
        HashMap map = this.b;
        if (l2 != null) {
            if (((Long) map.put(l, l2)) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (((Long) map.remove(l)) == null) {
            throw new AssertionError("The key was empty");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02e5  */
    @Override // sensei0.ys
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(final android.view.KeyEvent r30, sensei0.g6 r31) {
        /*
            Method dump skipped, instruction units count: 888
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.us.j(android.view.KeyEvent, sensei0.g6):void");
    }
}
