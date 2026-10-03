package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_SessionToken {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_SessionToken(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_SessionToken clientAPI_SessionToken) {
        if (clientAPI_SessionToken == null) {
            return 0L;
        }
        return clientAPI_SessionToken.swigCPtr;
    }

    public static long swigRelease(ClientAPI_SessionToken clientAPI_SessionToken) {
        if (clientAPI_SessionToken == null) {
            return 0L;
        }
        if (!clientAPI_SessionToken.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_SessionToken.swigCPtr;
        clientAPI_SessionToken.swigCMemOwn = false;
        clientAPI_SessionToken.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_SessionToken(j);
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

    public String getSession_id() {
        return ovpncliJNI.ClientAPI_SessionToken_session_id_get(this.swigCPtr, this);
    }

    public String getUsername() {
        return ovpncliJNI.ClientAPI_SessionToken_username_get(this.swigCPtr, this);
    }

    public void setSession_id(String str) {
        ovpncliJNI.ClientAPI_SessionToken_session_id_set(this.swigCPtr, this, str);
    }

    public void setUsername(String str) {
        ovpncliJNI.ClientAPI_SessionToken_username_set(this.swigCPtr, this, str);
    }

    public ClientAPI_SessionToken() {
        this(ovpncliJNI.new_ClientAPI_SessionToken(), true);
    }
}
