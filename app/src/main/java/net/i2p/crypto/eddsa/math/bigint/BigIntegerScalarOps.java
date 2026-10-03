package net.i2p.crypto.eddsa.math.bigint;

import java.math.BigInteger;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.ScalarOps;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class BigIntegerScalarOps implements ScalarOps {
    private final BigIntegerLittleEndianEncoding enc;
    private final BigInteger l;

    public BigIntegerScalarOps(Field field, BigInteger bigInteger) {
        this.l = bigInteger;
        BigIntegerLittleEndianEncoding bigIntegerLittleEndianEncoding = new BigIntegerLittleEndianEncoding();
        this.enc = bigIntegerLittleEndianEncoding;
        bigIntegerLittleEndianEncoding.setField(field);
    }

    @Override // net.i2p.crypto.eddsa.math.ScalarOps
    public byte[] multiplyAndAdd(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        BigIntegerLittleEndianEncoding bigIntegerLittleEndianEncoding = this.enc;
        return bigIntegerLittleEndianEncoding.encode(bigIntegerLittleEndianEncoding.toBigInteger(bArr).multiply(this.enc.toBigInteger(bArr2)).add(this.enc.toBigInteger(bArr3)).mod(this.l));
    }

    @Override // net.i2p.crypto.eddsa.math.ScalarOps
    public byte[] reduce(byte[] bArr) {
        BigIntegerLittleEndianEncoding bigIntegerLittleEndianEncoding = this.enc;
        return bigIntegerLittleEndianEncoding.encode(bigIntegerLittleEndianEncoding.toBigInteger(bArr).mod(this.l));
    }
}
