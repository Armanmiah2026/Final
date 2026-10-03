package sensei0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class rq extends sv {
    public final /* synthetic */ int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rq(pm pmVar, int i) {
        super(28, pmVar);
        this.d = i;
    }

    @Override // sensei0.sv
    public final Bitmap z(ByteBuffer byteBuffer, ya yaVar) {
        switch (this.d) {
            case 0:
                Bitmap bitmapZ = super.z(byteBuffer, yaVar);
                if (bitmapZ != null) {
                    return bitmapZ;
                }
                int iRemaining = byteBuffer.remaining();
                byte[] bArr = new byte[iRemaining];
                byteBuffer.get(bArr);
                byteBuffer.rewind();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, iRemaining, options);
                if (yaVar.c == 0) {
                    return k6.a(bitmapDecodeByteArray, yaVar.d);
                }
                Matrix matrix = new Matrix();
                matrix.postRotate(yaVar.c);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
                bitmapDecodeByteArray.recycle();
                return k6.a(bitmapCreateBitmap, yaVar.d);
            default:
                return k6.a(super.z(byteBuffer, yaVar), yaVar.d);
        }
    }
}
