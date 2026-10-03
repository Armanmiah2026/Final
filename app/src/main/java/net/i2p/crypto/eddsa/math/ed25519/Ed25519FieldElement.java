package net.i2p.crypto.eddsa.math.ed25519;

import java.util.Arrays;
import net.i2p.crypto.eddsa.Utils;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.FieldElement;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Ed25519FieldElement extends FieldElement {
    private static final byte[] ZERO = new byte[32];
    final int[] t;

    public Ed25519FieldElement(Field field, int[] iArr) {
        super(field);
        if (iArr.length != 10) {
            throw new IllegalArgumentException("Invalid radix-2^51 representation");
        }
        this.t = iArr;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement add(FieldElement fieldElement) {
        int[] iArr = ((Ed25519FieldElement) fieldElement).t;
        int[] iArr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr2[i] = this.t[i] + iArr[i];
        }
        return new Ed25519FieldElement(this.f, iArr2);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement cmov(FieldElement fieldElement, int i) {
        Ed25519FieldElement ed25519FieldElement = (Ed25519FieldElement) fieldElement;
        int i2 = -i;
        int[] iArr = new int[10];
        for (int i3 = 0; i3 < 10; i3++) {
            int[] iArr2 = this.t;
            int i4 = iArr2[i3];
            iArr[i3] = i4;
            iArr[i3] = ((iArr2[i3] ^ ed25519FieldElement.t[i3]) & i2) ^ i4;
        }
        return new Ed25519FieldElement(this.f, iArr);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Ed25519FieldElement) && 1 == Utils.equal(toByteArray(), ((Ed25519FieldElement) obj).toByteArray());
    }

    public int hashCode() {
        return Arrays.hashCode(this.t);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement invert() {
        FieldElement fieldElementSquare = square();
        FieldElement fieldElementMultiply = multiply(fieldElementSquare.square().square());
        FieldElement fieldElementMultiply2 = fieldElementSquare.multiply(fieldElementMultiply);
        FieldElement fieldElementMultiply3 = fieldElementMultiply.multiply(fieldElementMultiply2.square());
        FieldElement fieldElementSquare2 = fieldElementMultiply3.square();
        for (int i = 1; i < 5; i++) {
            fieldElementSquare2 = fieldElementSquare2.square();
        }
        FieldElement fieldElementMultiply4 = fieldElementSquare2.multiply(fieldElementMultiply3);
        FieldElement fieldElementSquare3 = fieldElementMultiply4.square();
        for (int i2 = 1; i2 < 10; i2++) {
            fieldElementSquare3 = fieldElementSquare3.square();
        }
        FieldElement fieldElementMultiply5 = fieldElementSquare3.multiply(fieldElementMultiply4);
        FieldElement fieldElementSquare4 = fieldElementMultiply5.square();
        for (int i3 = 1; i3 < 20; i3++) {
            fieldElementSquare4 = fieldElementSquare4.square();
        }
        FieldElement fieldElementSquare5 = fieldElementSquare4.multiply(fieldElementMultiply5).square();
        for (int i4 = 1; i4 < 10; i4++) {
            fieldElementSquare5 = fieldElementSquare5.square();
        }
        FieldElement fieldElementMultiply6 = fieldElementSquare5.multiply(fieldElementMultiply4);
        FieldElement fieldElementSquare6 = fieldElementMultiply6.square();
        for (int i5 = 1; i5 < 50; i5++) {
            fieldElementSquare6 = fieldElementSquare6.square();
        }
        FieldElement fieldElementMultiply7 = fieldElementSquare6.multiply(fieldElementMultiply6);
        FieldElement fieldElementSquare7 = fieldElementMultiply7.square();
        for (int i6 = 1; i6 < 100; i6++) {
            fieldElementSquare7 = fieldElementSquare7.square();
        }
        FieldElement fieldElementSquare8 = fieldElementSquare7.multiply(fieldElementMultiply7).square();
        for (int i7 = 1; i7 < 50; i7++) {
            fieldElementSquare8 = fieldElementSquare8.square();
        }
        FieldElement fieldElementSquare9 = fieldElementSquare8.multiply(fieldElementMultiply6).square();
        for (int i8 = 1; i8 < 5; i8++) {
            fieldElementSquare9 = fieldElementSquare9.square();
        }
        return fieldElementSquare9.multiply(fieldElementMultiply2);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public boolean isNonZero() {
        return Utils.equal(toByteArray(), ZERO) == 0;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement multiply(FieldElement fieldElement) {
        int[] iArr = ((Ed25519FieldElement) fieldElement).t;
        int i = iArr[1];
        int i2 = iArr[2];
        int i3 = iArr[3];
        int i4 = iArr[4];
        int i5 = iArr[5];
        int i6 = iArr[6];
        int i7 = iArr[7];
        int i8 = iArr[8];
        int i9 = iArr[9];
        int i10 = i9 * 19;
        int[] iArr2 = this.t;
        int i11 = iArr2[1];
        int i12 = iArr2[3];
        int i13 = iArr2[5];
        int i14 = i13 * 2;
        int i15 = iArr2[7];
        int i16 = i15 * 2;
        int i17 = iArr2[9];
        int i18 = i17 * 2;
        int i19 = iArr2[0];
        int i20 = iArr[0];
        long j = ((long) i2) * ((long) i19);
        long j2 = i11 * 2;
        long j3 = ((long) i) * j2;
        long j4 = ((long) i2) * ((long) i11);
        long j5 = ((long) i3) * j2;
        long j6 = ((long) i5) * j2;
        long j7 = ((long) i7) * j2;
        long j8 = i10;
        long j9 = j2 * j8;
        int i21 = iArr2[2];
        long j10 = ((long) i20) * ((long) i21);
        long j11 = ((long) i) * ((long) i21);
        long j12 = ((long) i2) * ((long) i21);
        long j13 = ((long) i3) * ((long) i21);
        long j14 = ((long) i4) * ((long) i21);
        long j15 = ((long) i5) * ((long) i21);
        long j16 = ((long) i6) * ((long) i21);
        long j17 = ((long) i21) * ((long) i7);
        long j18 = i8 * 19;
        long j19 = ((long) i21) * j18;
        long j20 = ((long) i21) * j8;
        long j21 = ((long) i20) * ((long) i12);
        long j22 = i12 * 2;
        long j23 = ((long) i) * j22;
        long j24 = ((long) i2) * ((long) i12);
        long j25 = ((long) i3) * j22;
        long j26 = ((long) i4) * ((long) i12);
        long j27 = ((long) i5) * j22;
        long j28 = ((long) i12) * ((long) i6);
        long j29 = i7 * 19;
        long j30 = j22 * j29;
        long j31 = ((long) i12) * j18;
        long j32 = j22 * j8;
        int i22 = iArr2[4];
        long j33 = ((long) i20) * ((long) i22);
        long j34 = ((long) i) * ((long) i22);
        long j35 = ((long) i2) * ((long) i22);
        long j36 = ((long) i3) * ((long) i22);
        long j37 = ((long) i4) * ((long) i22);
        long j38 = ((long) i5) * ((long) i22);
        long j39 = i6 * 19;
        long j40 = ((long) i22) * j39;
        long j41 = ((long) i22) * j29;
        long j42 = ((long) i22) * j18;
        long j43 = ((long) i22) * j8;
        long j44 = ((long) i20) * ((long) i13);
        long j45 = i14;
        long j46 = ((long) i) * j45;
        long j47 = ((long) i2) * ((long) i13);
        long j48 = ((long) i3) * j45;
        long j49 = ((long) i4) * ((long) i13);
        long j50 = i5 * 19;
        long j51 = j45 * j50;
        long j52 = ((long) i13) * j39;
        long j53 = j45 * j29;
        long j54 = ((long) i13) * j18;
        long j55 = j45 * j8;
        int i23 = iArr2[6];
        long j56 = ((long) i20) * ((long) i23);
        long j57 = ((long) i) * ((long) i23);
        long j58 = ((long) i2) * ((long) i23);
        long j59 = ((long) i23) * ((long) i3);
        long j60 = i4 * 19;
        long j61 = ((long) i23) * j60;
        long j62 = ((long) i23) * j50;
        long j63 = ((long) i23) * j39;
        long j64 = ((long) i23) * j29;
        long j65 = ((long) i23) * j18;
        long j66 = ((long) i23) * j8;
        long j67 = ((long) i20) * ((long) i15);
        long j68 = i16;
        long j69 = ((long) i) * j68;
        long j70 = ((long) i2) * ((long) i15);
        long j71 = i3 * 19;
        long j72 = j68 * j71;
        long j73 = ((long) i15) * j60;
        long j74 = j68 * j50;
        long j75 = ((long) i15) * j39;
        long j76 = j68 * j29;
        long j77 = ((long) i15) * j18;
        long j78 = j68 * j8;
        int i24 = iArr2[8];
        long j79 = ((long) i20) * ((long) i24);
        long j80 = ((long) i) * ((long) i24);
        long j81 = i2 * 19;
        long j82 = ((long) i24) * j81;
        long j83 = ((long) i24) * j71;
        long j84 = ((long) i24) * j60;
        long j85 = ((long) i24) * j50;
        long j86 = ((long) i24) * j39;
        long j87 = ((long) i24) * j29;
        long j88 = ((long) i24) * j18;
        long j89 = ((long) i24) * j8;
        long j90 = ((long) i20) * ((long) i17);
        long j91 = i18;
        long j92 = ((long) (i * 19)) * j91;
        long j93 = ((long) i17) * j81;
        long j94 = ((long) i17) * j18;
        long j95 = j8 * j91;
        long j96 = (((long) i20) * ((long) i19)) + j9 + j19 + j30 + j40 + j51 + j61 + j72 + j82 + j92;
        long j97 = (((long) i) * ((long) i19)) + (((long) i20) * ((long) i11)) + j20 + j31 + j41 + j52 + j62 + j73 + j83 + j93;
        long j98 = j + j3 + j10 + j32 + j42 + j53 + j63 + j74 + j84 + (j71 * j91);
        long j99 = (((long) i3) * ((long) i19)) + j4 + j11 + j21 + j43 + j54 + j64 + j75 + j85 + (((long) i17) * j60);
        long j100 = (((long) i4) * ((long) i19)) + j5 + j12 + j23 + j33 + j55 + j65 + j76 + j86 + (j50 * j91);
        long j101 = (((long) i5) * ((long) i19)) + (((long) i4) * ((long) i11)) + j13 + j24 + j34 + j44 + j66 + j77 + j87 + (((long) i17) * j39);
        long j102 = (((long) i6) * ((long) i19)) + j6 + j14 + j25 + j35 + j46 + j56 + j78 + j88 + (j29 * j91);
        long j103 = (((long) i7) * ((long) i19)) + (((long) i6) * ((long) i11)) + j15 + j26 + j36 + j47 + j57 + j67 + j89 + j94;
        long j104 = (((long) i8) * ((long) i19)) + j7 + j16 + j27 + j37 + j48 + j58 + j69 + j79 + j95;
        long j105 = (((long) i9) * ((long) i19)) + (((long) i11) * ((long) i8)) + j17 + j28 + j38 + j49 + j59 + j70 + j80 + j90;
        long j106 = (j96 + 33554432) >> 26;
        long j107 = j97 + j106;
        long j108 = j96 - (j106 << 26);
        long j109 = (j100 + 33554432) >> 26;
        long j110 = j101 + j109;
        long j111 = (j107 + 16777216) >> 25;
        long j112 = j98 + j111;
        long j113 = j107 - (j111 << 25);
        long j114 = (j110 + 16777216) >> 25;
        long j115 = j102 + j114;
        long j116 = j110 - (j114 << 25);
        long j117 = (j112 + 33554432) >> 26;
        long j118 = j99 + j117;
        long j119 = j112 - (j117 << 26);
        long j120 = (j115 + 33554432) >> 26;
        long j121 = j103 + j120;
        long j122 = j115 - (j120 << 26);
        long j123 = (j118 + 16777216) >> 25;
        long j124 = (j100 - (j109 << 26)) + j123;
        long j125 = j118 - (j123 << 25);
        long j126 = (j121 + 16777216) >> 25;
        long j127 = j104 + j126;
        long j128 = j121 - (j126 << 25);
        long j129 = (j124 + 33554432) >> 26;
        long j130 = (j127 + 33554432) >> 26;
        long j131 = j105 + j130;
        long j132 = j127 - (j130 << 26);
        long j133 = (j131 + 16777216) >> 25;
        long j134 = (19 * j133) + j108;
        long j135 = j131 - (j133 << 25);
        long j136 = (j134 + 33554432) >> 26;
        return new Ed25519FieldElement(this.f, new int[]{(int) (j134 - (j136 << 26)), (int) (j113 + j136), (int) j119, (int) j125, (int) (j124 - (j129 << 26)), (int) (j116 + j129), (int) j122, (int) j128, (int) j132, (int) j135});
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement negate() {
        int[] iArr = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr[i] = -this.t[i];
        }
        return new Ed25519FieldElement(this.f, iArr);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement pow22523() {
        FieldElement fieldElementSquare = square();
        FieldElement fieldElementMultiply = multiply(fieldElementSquare.square().square());
        FieldElement fieldElementMultiply2 = fieldElementMultiply.multiply(fieldElementSquare.multiply(fieldElementMultiply).square());
        FieldElement fieldElementSquare2 = fieldElementMultiply2.square();
        for (int i = 1; i < 5; i++) {
            fieldElementSquare2 = fieldElementSquare2.square();
        }
        FieldElement fieldElementMultiply3 = fieldElementSquare2.multiply(fieldElementMultiply2);
        FieldElement fieldElementSquare3 = fieldElementMultiply3.square();
        for (int i2 = 1; i2 < 10; i2++) {
            fieldElementSquare3 = fieldElementSquare3.square();
        }
        FieldElement fieldElementMultiply4 = fieldElementSquare3.multiply(fieldElementMultiply3);
        FieldElement fieldElementSquare4 = fieldElementMultiply4.square();
        for (int i3 = 1; i3 < 20; i3++) {
            fieldElementSquare4 = fieldElementSquare4.square();
        }
        FieldElement fieldElementSquare5 = fieldElementSquare4.multiply(fieldElementMultiply4).square();
        for (int i4 = 1; i4 < 10; i4++) {
            fieldElementSquare5 = fieldElementSquare5.square();
        }
        FieldElement fieldElementMultiply5 = fieldElementSquare5.multiply(fieldElementMultiply3);
        FieldElement fieldElementSquare6 = fieldElementMultiply5.square();
        for (int i5 = 1; i5 < 50; i5++) {
            fieldElementSquare6 = fieldElementSquare6.square();
        }
        FieldElement fieldElementMultiply6 = fieldElementSquare6.multiply(fieldElementMultiply5);
        FieldElement fieldElementSquare7 = fieldElementMultiply6.square();
        for (int i6 = 1; i6 < 100; i6++) {
            fieldElementSquare7 = fieldElementSquare7.square();
        }
        FieldElement fieldElementSquare8 = fieldElementSquare7.multiply(fieldElementMultiply6).square();
        for (int i7 = 1; i7 < 50; i7++) {
            fieldElementSquare8 = fieldElementSquare8.square();
        }
        return multiply(fieldElementSquare8.multiply(fieldElementMultiply5).square().square());
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement square() {
        int[] iArr = this.t;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = i3 * 2;
        int i12 = i5 * 2;
        int i13 = i7 * 2;
        int i14 = i7 * 19;
        int i15 = i9 * 19;
        int i16 = i10 * 38;
        long j = i;
        long j2 = j * j;
        long j3 = i * 2;
        long j4 = i2;
        long j5 = j3 * j4;
        long j6 = i3;
        long j7 = j3 * j6;
        long j8 = i4;
        long j9 = j3 * j8;
        long j10 = i5;
        long j11 = j3 * j10;
        long j12 = i6;
        long j13 = j3 * j12;
        long j14 = i7;
        long j15 = j3 * j14;
        long j16 = i8;
        long j17 = j3 * j16;
        long j18 = i9;
        long j19 = j3 * j18;
        long j20 = i10;
        long j21 = j3 * j20;
        long j22 = i2 * 2;
        long j23 = j4 * j22;
        long j24 = j22 * j6;
        long j25 = i4 * 2;
        long j26 = j22 * j10;
        long j27 = i6 * 2;
        long j28 = j22 * j27;
        long j29 = i8 * 2;
        long j30 = j22 * j29;
        long j31 = i16;
        long j32 = j22 * j31;
        long j33 = i11;
        long j34 = j33 * j8;
        long j35 = j33 * j10;
        long j36 = j33 * j12;
        long j37 = j33 * j14;
        long j38 = j33 * j16;
        long j39 = i15;
        long j40 = j33 * j39;
        long j41 = j6 * j31;
        long j42 = j25 * j27;
        long j43 = i8 * 38;
        long j44 = j25 * j43;
        long j45 = j25 * j39;
        long j46 = j25 * j31;
        long j47 = i12;
        long j48 = j47 * j12;
        long j49 = i14;
        long j50 = j47 * j49;
        long j51 = j10 * j43;
        long j52 = j47 * j39;
        long j53 = j10 * j31;
        long j54 = j49 * j14;
        long j55 = j14 * j43;
        long j56 = j2 + j32 + j40 + j44 + j50 + (j12 * ((long) (i6 * 38)));
        long j57 = j11 + (j22 * j25) + (j6 * j6) + (j27 * j31) + (((long) i13) * j39) + (j16 * j43);
        long j58 = j13 + j26 + j34 + (j14 * j31);
        long j59 = j15 + j28 + j35 + (j8 * j25);
        long j60 = j17 + (j22 * j14) + j36 + (j25 * j10);
        long j61 = j19 + j30 + j37 + j42 + (j10 * j10);
        long j62 = j21 + (j22 * j18) + j38 + (j25 * j14) + j48;
        long j63 = (j56 + 33554432) >> 26;
        long j64 = j5 + j41 + j45 + j51 + (j27 * j49) + j63;
        long j65 = j56 - (j63 << 26);
        long j66 = (j57 + 33554432) >> 26;
        long j67 = j58 + (j29 * j39) + j66;
        long j68 = (j64 + 16777216) >> 25;
        long j69 = j7 + j23 + j46 + j52 + (j27 * j43) + j54 + j68;
        long j70 = j64 - (j68 << 25);
        long j71 = (j67 + 16777216) >> 25;
        long j72 = j59 + (j29 * j31) + (j18 * j39) + j71;
        long j73 = j67 - (j71 << 25);
        long j74 = (j69 + 33554432) >> 26;
        long j75 = j9 + j24 + j53 + (j27 * j39) + j55 + j74;
        long j76 = (j72 + 33554432) >> 26;
        long j77 = j60 + (j18 * j31) + j76;
        long j78 = (j75 + 16777216) >> 25;
        long j79 = (j57 - (j66 << 26)) + j78;
        long j80 = (j77 + 16777216) >> 25;
        long j81 = j61 + (j20 * j31) + j80;
        long j82 = j77 - (j80 << 25);
        long j83 = (j79 + 33554432) >> 26;
        long j84 = j73 + j83;
        long j85 = j79 - (j83 << 26);
        long j86 = (j81 + 33554432) >> 26;
        long j87 = j62 + j86;
        long j88 = (j87 + 16777216) >> 25;
        long j89 = (19 * j88) + j65;
        long j90 = (j89 + 33554432) >> 26;
        return new Ed25519FieldElement(this.f, new int[]{(int) (j89 - (j90 << 26)), (int) (j70 + j90), (int) (j69 - (j74 << 26)), (int) (j75 - (j78 << 25)), (int) j85, (int) j84, (int) (j72 - (j76 << 26)), (int) j82, (int) (j81 - (j86 << 26)), (int) (j87 - (j88 << 25))});
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement squareAndDouble() {
        int[] iArr = this.t;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = i3 * 2;
        int i12 = i5 * 2;
        int i13 = i7 * 2;
        int i14 = i7 * 19;
        int i15 = i9 * 19;
        int i16 = i10 * 38;
        long j = i;
        long j2 = j * j;
        long j3 = i * 2;
        long j4 = i2;
        long j5 = j3 * j4;
        long j6 = i3;
        long j7 = j3 * j6;
        long j8 = i4;
        long j9 = j3 * j8;
        long j10 = i5;
        long j11 = j3 * j10;
        long j12 = i6;
        long j13 = j3 * j12;
        long j14 = i7;
        long j15 = j3 * j14;
        long j16 = i8;
        long j17 = j3 * j16;
        long j18 = i9;
        long j19 = j3 * j18;
        long j20 = i10;
        long j21 = j3 * j20;
        long j22 = i2 * 2;
        long j23 = j4 * j22;
        long j24 = j22 * j6;
        long j25 = i4 * 2;
        long j26 = j22 * j10;
        long j27 = i6 * 2;
        long j28 = j22 * j27;
        long j29 = i8 * 2;
        long j30 = j22 * j29;
        long j31 = i16;
        long j32 = j22 * j31;
        long j33 = i11;
        long j34 = j33 * j8;
        long j35 = j33 * j10;
        long j36 = j33 * j12;
        long j37 = j33 * j14;
        long j38 = j33 * j16;
        long j39 = i15;
        long j40 = j33 * j39;
        long j41 = j6 * j31;
        long j42 = j25 * j27;
        long j43 = i8 * 38;
        long j44 = j25 * j43;
        long j45 = j25 * j39;
        long j46 = j25 * j31;
        long j47 = i12;
        long j48 = j47 * j12;
        long j49 = i14;
        long j50 = j47 * j49;
        long j51 = j10 * j43;
        long j52 = j47 * j39;
        long j53 = j10 * j31;
        long j54 = j49 * j14;
        long j55 = j14 * j43;
        long j56 = j2 + j32 + j40 + j44 + j50 + (j12 * ((long) (i6 * 38)));
        long j57 = j5 + j41 + j45 + j51 + (j27 * j49);
        long j58 = j7 + j23 + j46 + j52 + (j27 * j43) + j54;
        long j59 = j9 + j24 + j53 + (j27 * j39) + j55;
        long j60 = j11 + (j22 * j25) + (j6 * j6) + (j27 * j31) + (((long) i13) * j39) + (j16 * j43);
        long j61 = j13 + j26 + j34 + (j14 * j31) + (j29 * j39);
        long j62 = j15 + j28 + j35 + (j8 * j25) + (j29 * j31) + (j18 * j39);
        long j63 = j17 + (j22 * j14) + j36 + (j25 * j10) + (j18 * j31);
        long j64 = j19 + j30 + j37 + j42 + (j10 * j10) + (j20 * j31);
        long j65 = j21 + (j22 * j18) + j38 + (j25 * j14) + j48;
        long j66 = j56 + j56;
        long j67 = j60 + j60;
        long j68 = (j66 + 33554432) >> 26;
        long j69 = j57 + j57 + j68;
        long j70 = j66 - (j68 << 26);
        long j71 = (j67 + 33554432) >> 26;
        long j72 = j61 + j61 + j71;
        long j73 = (j69 + 16777216) >> 25;
        long j74 = j58 + j58 + j73;
        long j75 = j69 - (j73 << 25);
        long j76 = (j72 + 16777216) >> 25;
        long j77 = j62 + j62 + j76;
        long j78 = j72 - (j76 << 25);
        long j79 = (j74 + 33554432) >> 26;
        long j80 = j59 + j59 + j79;
        long j81 = (j77 + 33554432) >> 26;
        long j82 = j63 + j63 + j81;
        long j83 = (j80 + 16777216) >> 25;
        long j84 = (j67 - (j71 << 26)) + j83;
        long j85 = (j82 + 16777216) >> 25;
        long j86 = j64 + j64 + j85;
        long j87 = j82 - (j85 << 25);
        long j88 = (j84 + 33554432) >> 26;
        long j89 = j78 + j88;
        long j90 = j84 - (j88 << 26);
        long j91 = (j86 + 33554432) >> 26;
        long j92 = j65 + j65 + j91;
        long j93 = (j92 + 16777216) >> 25;
        long j94 = (19 * j93) + j70;
        long j95 = (j94 + 33554432) >> 26;
        return new Ed25519FieldElement(this.f, new int[]{(int) (j94 - (j95 << 26)), (int) (j75 + j95), (int) (j74 - (j79 << 26)), (int) (j80 - (j83 << 25)), (int) j90, (int) j89, (int) (j77 - (j81 << 26)), (int) j87, (int) (j86 - (j91 << 26)), (int) (j92 - (j93 << 25))});
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public FieldElement subtract(FieldElement fieldElement) {
        int[] iArr = ((Ed25519FieldElement) fieldElement).t;
        int[] iArr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr2[i] = this.t[i] - iArr[i];
        }
        return new Ed25519FieldElement(this.f, iArr2);
    }

    public String toString() {
        return "[Ed25519FieldElement val=" + Utils.bytesToHex(toByteArray()) + "]";
    }
}
