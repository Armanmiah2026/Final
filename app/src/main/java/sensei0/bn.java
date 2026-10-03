package sensei0;

import io.flutter.embedding.engine.FlutterJNI;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class bn implements Runnable {
    public final long a;
    public final FlutterJNI b;

    public bn(long j, FlutterJNI flutterJNI) {
        this.a = j;
        this.b = flutterJNI;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlutterJNI flutterJNI = this.b;
        if (flutterJNI.isAttached()) {
            flutterJNI.unregisterTexture(this.a);
        }
    }
}
