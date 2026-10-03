package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_RemoteOverride {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_RemoteOverride(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_RemoteOverride clientAPI_RemoteOverride) {
        if (clientAPI_RemoteOverride == null) {
            return 0L;
        }
        return clientAPI_RemoteOverride.swigCPtr;
    }

    public static long swigRelease(ClientAPI_RemoteOverride clientAPI_RemoteOverride) {
        if (clientAPI_RemoteOverride == null) {
            return 0L;
        }
        if (!clientAPI_RemoteOverride.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_RemoteOverride.swigCPtr;
        clientAPI_RemoteOverride.swigCMemOwn = false;
        clientAPI_RemoteOverride.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_RemoteOverride(j);
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

    public String getError() {
        return ovpncliJNI.ClientAPI_RemoteOverride_error_get(this.swigCPtr, this);
    }

    public String getHost() {
        return ovpncliJNI.ClientAPI_RemoteOverride_host_get(this.swigCPtr, this);
    }

    public String getIp() {
        return ovpncliJNI.ClientAPI_RemoteOverride_ip_get(this.swigCPtr, this);
    }

    public String getPort() {
        return ovpncliJNI.ClientAPI_RemoteOverride_port_get(this.swigCPtr, this);
    }

    public String getProto() {
        return ovpncliJNI.ClientAPI_RemoteOverride_proto_get(this.swigCPtr, this);
    }

    public void setError(String str) {
        ovpncliJNI.ClientAPI_RemoteOverride_error_set(this.swigCPtr, this, str);
    }

    public void setHost(String str) {
        ovpncliJNI.ClientAPI_RemoteOverride_host_set(this.swigCPtr, this, str);
    }

    public void setIp(String str) {
        ovpncliJNI.ClientAPI_RemoteOverride_ip_set(this.swigCPtr, this, str);
    }

    public void setPort(String str) {
        ovpncliJNI.ClientAPI_RemoteOverride_port_set(this.swigCPtr, this, str);
    }

    public void setProto(String str) {
        ovpncliJNI.ClientAPI_RemoteOverride_proto_set(this.swigCPtr, this, str);
    }

    public ClientAPI_RemoteOverride() {
        this(ovpncliJNI.new_ClientAPI_RemoteOverride(), true);
    }
}
