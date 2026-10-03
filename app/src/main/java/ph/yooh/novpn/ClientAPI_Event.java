package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_Event {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_Event(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_Event clientAPI_Event) {
        if (clientAPI_Event == null) {
            return 0L;
        }
        return clientAPI_Event.swigCPtr;
    }

    public static long swigRelease(ClientAPI_Event clientAPI_Event) {
        if (clientAPI_Event == null) {
            return 0L;
        }
        if (!clientAPI_Event.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_Event.swigCPtr;
        clientAPI_Event.swigCMemOwn = false;
        clientAPI_Event.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_Event(j);
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

    public boolean getError() {
        return ovpncliJNI.ClientAPI_Event_error_get(this.swigCPtr, this);
    }

    public boolean getFatal() {
        return ovpncliJNI.ClientAPI_Event_fatal_get(this.swigCPtr, this);
    }

    public String getInfo() {
        return ovpncliJNI.ClientAPI_Event_info_get(this.swigCPtr, this);
    }

    public String getName() {
        return ovpncliJNI.ClientAPI_Event_name_get(this.swigCPtr, this);
    }

    public void setError(boolean z) {
        ovpncliJNI.ClientAPI_Event_error_set(this.swigCPtr, this, z);
    }

    public void setFatal(boolean z) {
        ovpncliJNI.ClientAPI_Event_fatal_set(this.swigCPtr, this, z);
    }

    public void setInfo(String str) {
        ovpncliJNI.ClientAPI_Event_info_set(this.swigCPtr, this, str);
    }

    public void setName(String str) {
        ovpncliJNI.ClientAPI_Event_name_set(this.swigCPtr, this, str);
    }

    public ClientAPI_Event() {
        this(ovpncliJNI.new_ClientAPI_Event(), true);
    }
}
