package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_AppCustomControlMessageEvent {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_AppCustomControlMessageEvent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_AppCustomControlMessageEvent clientAPI_AppCustomControlMessageEvent) {
        if (clientAPI_AppCustomControlMessageEvent == null) {
            return 0L;
        }
        return clientAPI_AppCustomControlMessageEvent.swigCPtr;
    }

    public static long swigRelease(ClientAPI_AppCustomControlMessageEvent clientAPI_AppCustomControlMessageEvent) {
        if (clientAPI_AppCustomControlMessageEvent == null) {
            return 0L;
        }
        if (!clientAPI_AppCustomControlMessageEvent.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_AppCustomControlMessageEvent.swigCPtr;
        clientAPI_AppCustomControlMessageEvent.swigCMemOwn = false;
        clientAPI_AppCustomControlMessageEvent.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_AppCustomControlMessageEvent(j);
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

    public String getPayload() {
        return ovpncliJNI.ClientAPI_AppCustomControlMessageEvent_payload_get(this.swigCPtr, this);
    }

    public String getProtocol() {
        return ovpncliJNI.ClientAPI_AppCustomControlMessageEvent_protocol_get(this.swigCPtr, this);
    }

    public void setPayload(String str) {
        ovpncliJNI.ClientAPI_AppCustomControlMessageEvent_payload_set(this.swigCPtr, this, str);
    }

    public void setProtocol(String str) {
        ovpncliJNI.ClientAPI_AppCustomControlMessageEvent_protocol_set(this.swigCPtr, this, str);
    }

    public ClientAPI_AppCustomControlMessageEvent() {
        this(ovpncliJNI.new_ClientAPI_AppCustomControlMessageEvent(), true);
    }
}
