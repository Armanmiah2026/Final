package sensei0;

import android.graphics.Rect;
import android.opengl.Matrix;
import android.text.SpannableString;
import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {
    public String A;
    public String B;
    public String C;
    public String D;
    public int E;
    public int F;
    public long I;
    public int J;
    public int K;
    public int L;
    public float M;
    public String N;
    public String O;
    public float P;
    public float Q;
    public float R;
    public float S;
    public float[] T;
    public float[] U;
    public m0 V;
    public ArrayList Y;
    public j0 Z;
    public final io.flutter.view.b a;
    public j0 a0;
    public long c;
    public float[] c0;
    public int d;
    public int e;
    public float[] e0;
    public int f;
    public Rect f0;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public float l;
    public float m;
    public float n;
    public String o;
    public String p;
    public ArrayList q;
    public String r;
    public List s;
    public String t;
    public ArrayList u;
    public String v;
    public ArrayList w;
    public String x;
    public ArrayList y;
    public String z;
    public int b = -1;
    public int G = -1;
    public boolean H = false;
    public final ArrayList W = new ArrayList();
    public final ArrayList X = new ArrayList();
    public boolean b0 = true;
    public boolean d0 = true;

    public m0(io.flutter.view.b bVar) {
        this.a = bVar;
    }

    public static ArrayList d(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        int i = byteBuffer.getInt();
        if (i == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = byteBuffer.getInt();
            int i4 = byteBuffer.getInt();
            int i5 = za0.v(2)[byteBuffer.getInt()];
            int iU = za0.u(i5);
            if (iU == 0) {
                byteBuffer.getInt();
                h1 h1Var = new h1();
                h1Var.a = i3;
                h1Var.b = i4;
                h1Var.c = i5;
                arrayList.add(h1Var);
            } else if (iU == 1) {
                ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                g1 g1Var = new g1();
                g1Var.a = i3;
                g1Var.b = i4;
                g1Var.c = i5;
                g1Var.d = StandardCharsets.UTF_8.decode(byteBuffer2).toString();
                arrayList.add(g1Var);
            }
        }
        return arrayList;
    }

    public static void k(float[] fArr, float[] fArr2, float[] fArr3) {
        Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
        float f = fArr[3];
        fArr[0] = fArr[0] / f;
        fArr[1] = fArr[1] / f;
        fArr[2] = fArr[2] / f;
        fArr[3] = 0.0f;
    }

    public final void a(ArrayList arrayList) {
        if (h(12)) {
            arrayList.add(this);
        }
        ArrayList arrayList2 = this.W;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((m0) obj).a(arrayList);
        }
    }

    public final String b() {
        String str = this.B;
        return (str == null || str.isEmpty()) ? this.a.m : this.B;
    }

    public final String c() {
        String str;
        if (h(13) && (str = this.p) != null && !str.isEmpty()) {
            return this.p;
        }
        ArrayList arrayList = this.W;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String strC = ((m0) obj).c();
            if (strC != null && !strC.isEmpty()) {
                return strC;
            }
        }
        return null;
    }

    public final CharSequence e() {
        j1 j1Var = new j1();
        j1Var.a = this.r;
        j1Var.d = this.s;
        j1Var.b = b();
        SpannableString spannableStringA = j1Var.a();
        j1 j1Var2 = new j1();
        j1Var2.a = this.p;
        j1Var2.d = this.q;
        j1Var2.c = this.A;
        j1Var2.b = b();
        SpannableString spannableStringA2 = j1Var2.a();
        j1 j1Var3 = new j1();
        j1Var3.a = this.x;
        j1Var3.d = this.y;
        j1Var3.b = b();
        CharSequence[] charSequenceArr = {spannableStringA, spannableStringA2, j1Var3.a()};
        CharSequence charSequenceConcat = null;
        for (int i = 0; i < 3; i++) {
            CharSequence charSequence = charSequenceArr[i];
            if (charSequence != null && charSequence.length() > 0) {
                charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
            }
        }
        return charSequenceConcat;
    }

    public final boolean f(int i) {
        return (this.I & ((long) za0.e(i))) != 0;
    }

    public final boolean g(g0 g0Var) {
        return (g0Var.a & this.d) != 0;
    }

    public final boolean h(int i) {
        return (this.c & ((long) za0.e(i))) != 0;
    }

    public final m0 i(float[] fArr, boolean z) {
        float f = fArr[3];
        boolean z2 = false;
        float f2 = fArr[0] / f;
        float f3 = fArr[1] / f;
        if (f2 < this.P || f2 >= this.R || f3 < this.Q || f3 >= this.S) {
            return null;
        }
        float[] fArr2 = new float[4];
        ArrayList arrayList = this.X;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            m0 m0Var = (m0) arrayList.get(i);
            if (!m0Var.h(14)) {
                if (m0Var.b0) {
                    m0Var.b0 = false;
                    if (m0Var.c0 == null) {
                        m0Var.c0 = new float[16];
                    }
                    if (m0Var.U == null) {
                        float[] fArr3 = new float[16];
                        m0Var.U = fArr3;
                        Matrix.setIdentityM(fArr3, 0);
                    }
                    if (!Matrix.invertM(m0Var.c0, 0, m0Var.U, 0)) {
                        Arrays.fill(m0Var.c0, 0.0f);
                    }
                }
                float[] fArr4 = fArr;
                Matrix.multiplyMV(fArr2, 0, m0Var.c0, 0, fArr4, 0);
                m0 m0VarI = m0Var.i(fArr2, z);
                if (m0VarI != null) {
                    return m0VarI;
                }
                fArr = fArr4;
            }
            i = i2;
        }
        if (z && this.i != -1) {
            z2 = true;
        }
        if (j() || z2) {
            return this;
        }
        return null;
    }

    public final boolean j() {
        if (h(12)) {
            return false;
        }
        if (h(22)) {
            return true;
        }
        if (h(32)) {
            return false;
        }
        int i = this.d;
        int i2 = io.flutter.view.b.A;
        if ((i & (-61)) != 0 || (this.c & ((long) 10682871)) != 0) {
            return true;
        }
        String str = this.p;
        if (str != null && !str.isEmpty()) {
            return true;
        }
        String str2 = this.r;
        if (str2 != null && !str2.isEmpty()) {
            return true;
        }
        String str3 = this.x;
        return (str3 == null || str3.isEmpty()) ? false : true;
    }

    public final void l(float[] fArr, HashSet hashSet, boolean z, boolean z2) {
        float[] fArr2;
        hashSet.add(this);
        if (this.d0) {
            z = true;
        }
        int i = 0;
        if (z) {
            if (this.e0 == null) {
                this.e0 = new float[16];
            }
            if (z2) {
                if (this.U == null) {
                    float[] fArr3 = new float[16];
                    this.U = fArr3;
                    Matrix.setIdentityM(fArr3, 0);
                }
                fArr2 = this.U;
            } else {
                if (this.T == null) {
                    float[] fArr4 = new float[16];
                    this.T = fArr4;
                    Matrix.setIdentityM(fArr4, 0);
                }
                fArr2 = this.T;
            }
            Matrix.multiplyMM(this.e0, 0, fArr, 0, fArr2, 0);
            float[] fArr5 = {this.P, this.Q, 0.0f, 1.0f};
            float[] fArr6 = new float[4];
            float[] fArr7 = new float[4];
            float[] fArr8 = new float[4];
            float[] fArr9 = new float[4];
            k(fArr6, this.e0, fArr5);
            fArr5[0] = this.R;
            fArr5[1] = this.Q;
            k(fArr7, this.e0, fArr5);
            fArr5[0] = this.R;
            fArr5[1] = this.S;
            k(fArr8, this.e0, fArr5);
            fArr5[0] = this.P;
            fArr5[1] = this.S;
            k(fArr9, this.e0, fArr5);
            if (this.f0 == null) {
                this.f0 = new Rect();
            }
            this.f0.set(Math.round(Math.min(fArr6[0], Math.min(fArr7[0], Math.min(fArr8[0], fArr9[0])))), Math.round(Math.min(fArr6[1], Math.min(fArr7[1], Math.min(fArr8[1], fArr9[1])))), Math.round(Math.max(fArr6[0], Math.max(fArr7[0], Math.max(fArr8[0], fArr9[0])))), Math.round(Math.max(fArr6[1], Math.max(fArr7[1], Math.max(fArr8[1], fArr9[1])))));
            this.d0 = false;
        }
        ArrayList arrayList = this.W;
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            m0 m0Var = (m0) obj;
            m0Var.G = i2;
            i2 = m0Var.b;
            m0Var.l(this.e0, hashSet, z, false);
        }
        ArrayList arrayList2 = this.X;
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            m0 m0Var2 = (m0) obj2;
            if (!hashSet.contains(m0Var2)) {
                m0Var2.l(this.e0, hashSet, z, true);
            }
        }
    }
}
