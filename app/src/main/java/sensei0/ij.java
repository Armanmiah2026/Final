package sensei0;

import android.util.Log;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ij extends InputStream implements DataInput {
    public final DataInputStream a;
    public int b;
    public ByteOrder c;
    public byte[] d;
    public final int f;

    public ij(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this(byteArrayInputStream, 0);
        this.f = bArr.length;
    }

    public final void a(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = i - i2;
            DataInputStream dataInputStream = this.a;
            int iSkip = (int) dataInputStream.skip(i3);
            if (iSkip <= 0) {
                if (this.d == null) {
                    this.d = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
                }
                iSkip = dataInputStream.read(this.d, 0, Math.min(AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT, i3));
                if (iSkip == -1) {
                    throw new EOFException(za0.i(i, "Reached EOF while skipping ", " bytes."));
                }
            }
            i2 += iSkip;
        }
        this.b += i2;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.a.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.b++;
        return this.a.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.b++;
        return this.a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        this.b++;
        int i = this.a.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.b += 2;
        return this.a.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.b += i2;
        this.a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.b += 4;
        DataInputStream dataInputStream = this.a;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        if ((i | i2 | i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IOException("Invalid byte order: " + this.c);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        long j;
        long j2;
        this.b += 8;
        DataInputStream dataInputStream = this.a;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        int i5 = dataInputStream.read();
        int i6 = dataInputStream.read();
        int i7 = dataInputStream.read();
        int i8 = dataInputStream.read();
        if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            j = (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8);
            j2 = i;
        } else {
            if (byteOrder != ByteOrder.BIG_ENDIAN) {
                throw new IOException("Invalid byte order: " + this.c);
            }
            j = (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8);
            j2 = i8;
        }
        return j + j2;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.b += 2;
        DataInputStream dataInputStream = this.a;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (short) ((i2 << 8) + i);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (short) ((i << 8) + i2);
        }
        throw new IOException("Invalid byte order: " + this.c);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.b += 2;
        return this.a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.b++;
        return this.a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.b += 2;
        DataInputStream dataInputStream = this.a;
        int i = dataInputStream.read();
        int i2 = dataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i2 << 8) + i;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i << 8) + i2;
        }
        throw new IOException("Invalid byte order: " + this.c);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ij(InputStream inputStream) {
        this(inputStream, 0);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.a.read(bArr, i, i2);
        this.b += i3;
        return i3;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.b += bArr.length;
        this.a.readFully(bArr);
    }

    public ij(InputStream inputStream, int i) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.a = dataInputStream;
        dataInputStream.mark(0);
        this.b = 0;
        this.c = byteOrder;
        this.f = inputStream instanceof ij ? ((ij) inputStream).f : -1;
    }
}
