package net.i2p.crypto.eddsa.math.ed25519;

import net.i2p.crypto.eddsa.math.Encoding;
import net.i2p.crypto.eddsa.math.FieldElement;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Ed25519LittleEndianEncoding extends Encoding {
    public static int load_3(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        return ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | i2;
    }

    public static long load_4(byte[] bArr, int i) {
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        return ((long) ((bArr[i + 3] << 24) | i2 | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    @Override // net.i2p.crypto.eddsa.math.Encoding
    public FieldElement decode(byte[] bArr) {
        long jLoad_4 = load_4(bArr, 0);
        long jLoad_3 = load_3(bArr, 4) << 6;
        long jLoad_32 = load_3(bArr, 7) << 5;
        long jLoad_33 = load_3(bArr, 10) << 3;
        long jLoad_34 = load_3(bArr, 13) << 2;
        long jLoad_42 = load_4(bArr, 16);
        long jLoad_35 = load_3(bArr, 20) << 7;
        long jLoad_36 = load_3(bArr, 23) << 5;
        long jLoad_37 = load_3(bArr, 26) << 4;
        long jLoad_38 = (load_3(bArr, 29) & 8388607) << 2;
        long j = (jLoad_38 + 16777216) >> 25;
        long j2 = (19 * j) + jLoad_4;
        long j3 = jLoad_38 - (j << 25);
        long j4 = (jLoad_3 + 16777216) >> 25;
        long j5 = jLoad_32 + j4;
        long j6 = (jLoad_33 + 16777216) >> 25;
        long j7 = jLoad_34 + j6;
        long j8 = jLoad_33 - (j6 << 25);
        long j9 = (jLoad_42 + 16777216) >> 25;
        long j10 = jLoad_35 + j9;
        long j11 = jLoad_42 - (j9 << 25);
        long j12 = (jLoad_36 + 16777216) >> 25;
        long j13 = jLoad_37 + j12;
        long j14 = (j2 + 33554432) >> 26;
        long j15 = (jLoad_3 - (j4 << 25)) + j14;
        long j16 = (j5 + 33554432) >> 26;
        long j17 = j8 + j16;
        long j18 = j5 - (j16 << 26);
        long j19 = (j7 + 33554432) >> 26;
        long j20 = j11 + j19;
        long j21 = j7 - (j19 << 26);
        long j22 = (j10 + 33554432) >> 26;
        long j23 = (jLoad_36 - (j12 << 25)) + j22;
        long j24 = j10 - (j22 << 26);
        long j25 = (j13 + 33554432) >> 26;
        return new Ed25519FieldElement(this.f, new int[]{(int) (j2 - (j14 << 26)), (int) j15, (int) j18, (int) j17, (int) j21, (int) j20, (int) j24, (int) j23, (int) (j13 - (j25 << 26)), (int) (j3 + j25)});
    }

    @Override // net.i2p.crypto.eddsa.math.Encoding
    public byte[] encode(FieldElement fieldElement) {
        int[] iArr = ((Ed25519FieldElement) fieldElement).t;
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
        int i11 = (((i10 + ((i9 + ((i8 + ((i7 + ((i6 + ((i5 + ((i4 + ((i3 + ((i2 + ((i + (((i10 * 19) + 16777216) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25) * 19) + i;
        int i12 = i11 >> 26;
        int i13 = i2 + i12;
        int i14 = i11 - (i12 << 26);
        int i15 = i13 >> 25;
        int i16 = i3 + i15;
        int i17 = i13 - (i15 << 25);
        int i18 = i16 >> 26;
        int i19 = i4 + i18;
        int i20 = i16 - (i18 << 26);
        int i21 = i19 >> 25;
        int i22 = i5 + i21;
        int i23 = i19 - (i21 << 25);
        int i24 = i22 >> 26;
        int i25 = i6 + i24;
        int i26 = i22 - (i24 << 26);
        int i27 = i25 >> 25;
        int i28 = i7 + i27;
        int i29 = i25 - (i27 << 25);
        int i30 = i28 >> 26;
        int i31 = i8 + i30;
        int i32 = i28 - (i30 << 26);
        int i33 = i31 >> 25;
        int i34 = i9 + i33;
        int i35 = i31 - (i33 << 25);
        int i36 = i34 >> 26;
        int i37 = i10 + i36;
        int i38 = i34 - (i36 << 26);
        int i39 = i37 - ((i37 >> 25) << 25);
        return new byte[]{(byte) i14, (byte) (i14 >> 8), (byte) (i14 >> 16), (byte) ((i14 >> 24) | (i17 << 2)), (byte) (i17 >> 6), (byte) (i17 >> 14), (byte) ((i17 >> 22) | (i20 << 3)), (byte) (i20 >> 5), (byte) (i20 >> 13), (byte) ((i20 >> 21) | (i23 << 5)), (byte) (i23 >> 3), (byte) (i23 >> 11), (byte) ((i23 >> 19) | (i26 << 6)), (byte) (i26 >> 2), (byte) (i26 >> 10), (byte) (i26 >> 18), (byte) i29, (byte) (i29 >> 8), (byte) (i29 >> 16), (byte) ((i29 >> 24) | (i32 << 1)), (byte) (i32 >> 7), (byte) (i32 >> 15), (byte) ((i32 >> 23) | (i35 << 3)), (byte) (i35 >> 5), (byte) (i35 >> 13), (byte) ((i35 >> 21) | (i38 << 4)), (byte) (i38 >> 4), (byte) (i38 >> 12), (byte) ((i38 >> 20) | (i39 << 6)), (byte) (i39 >> 2), (byte) (i39 >> 10), (byte) (i39 >> 18)};
    }

    @Override // net.i2p.crypto.eddsa.math.Encoding
    public boolean isNegative(FieldElement fieldElement) {
        return (encode(fieldElement)[0] & 1) != 0;
    }
}
