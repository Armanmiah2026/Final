package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_LogInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_LogInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_LogInfo clientAPI_LogInfo) {
        if (clientAPI_LogInfo == null) {
            return 0L;
        }
        return clientAPI_LogInfo.swigCPtr;
    }

    public static long swigRelease(ClientAPI_LogInfo clientAPI_LogInfo) {
        if (clientAPI_LogInfo == null) {
            return 0L;
        }
        if (!clientAPI_LogInfo.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_LogInfo.swigCPtr;
        clientAPI_LogInfo.swigCMemOwn = false;
        clientAPI_LogInfo.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_LogInfo(j);
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

    public String getText() {
        return ovpncliJNI.ClientAPI_LogInfo_text_get(this.swigCPtr, this);
    }

    public void setText(String str) {
        ovpncliJNI.ClientAPI_LogInfo_text_set(this.swigCPtr, this, str);
    }

    public ClientAPI_LogInfo() {
        this(ovpncliJNI.new_ClientAPI_LogInfo__SWIG_0(), true);
    }

    public ClientAPI_LogInfo(String str) {
        this(ovpncliJNI.new_ClientAPI_LogInfo__SWIG_1(str), true);
    }
}
