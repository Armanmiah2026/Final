package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ExternalPKIImpl {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ExternalPKIImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ExternalPKIImpl externalPKIImpl) {
        if (externalPKIImpl == null) {
            return 0L;
        }
        return externalPKIImpl.swigCPtr;
    }

    public static long swigRelease(ExternalPKIImpl externalPKIImpl) {
        if (externalPKIImpl == null) {
            return 0L;
        }
        if (!externalPKIImpl.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = externalPKIImpl.swigCPtr;
        externalPKIImpl.swigCMemOwn = false;
        externalPKIImpl.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ExternalPKIImpl(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void finalize() {
        delete();
    }

    public ExternalPKIImpl() {
        this(ovpncliJNI.new_ExternalPKIImpl(), true);
    }
}
