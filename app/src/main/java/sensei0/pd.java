package sensei0;

import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pd implements z5 {
    public final FlutterJNI a;
    public final int b;
    public final AtomicBoolean c = new AtomicBoolean(false);

    public pd(FlutterJNI flutterJNI, int i) {
        this.a = flutterJNI;
        this.b = i;
    }

    @Override // sensei0.z5
    public final void a(ByteBuffer byteBuffer) throws Throwable {
        if (this.c.getAndSet(true)) {
            throw new IllegalStateException("Reply already submitted");
        }
        int i = this.b;
        FlutterJNI flutterJNI = this.a;
        if (byteBuffer == null) {
            flutterJNI.invokePlatformMessageEmptyResponseCallback(i);
        } else {
            flutterJNI.invokePlatformMessageResponseCallback(i, byteBuffer, byteBuffer.position());
        }
    }
}
