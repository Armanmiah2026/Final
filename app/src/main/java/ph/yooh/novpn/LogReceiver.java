package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class LogReceiver implements LogReceiverSwigInterface {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LogReceiver(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LogReceiver logReceiver) {
        if (logReceiver == null) {
            return 0L;
        }
        return logReceiver.swigCPtr;
    }

    public static long swigRelease(LogReceiver logReceiver) {
        if (logReceiver == null) {
            return 0L;
        }
        if (!logReceiver.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = logReceiver.swigCPtr;
        logReceiver.swigCMemOwn = false;
        logReceiver.delete();
        return j;
    }

    @Override // ph.yooh.novpn.LogReceiverSwigInterface
    public long LogReceiverSwigInterface_GetInterfaceCPtr() {
        return ovpncliJNI.LogReceiver_LogReceiverSwigInterface_GetInterfaceCPtr(this.swigCPtr);
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_LogReceiver(j);
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

    @Override // ph.yooh.novpn.LogReceiverSwigInterface
    public void log(ClientAPI_LogInfo clientAPI_LogInfo) {
        ovpncliJNI.LogReceiver_log(this.swigCPtr, this, ClientAPI_LogInfo.getCPtr(clientAPI_LogInfo), clientAPI_LogInfo);
    }
}
