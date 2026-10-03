package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_InterfaceStats {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_InterfaceStats(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_InterfaceStats clientAPI_InterfaceStats) {
        if (clientAPI_InterfaceStats == null) {
            return 0L;
        }
        return clientAPI_InterfaceStats.swigCPtr;
    }

    public static long swigRelease(ClientAPI_InterfaceStats clientAPI_InterfaceStats) {
        if (clientAPI_InterfaceStats == null) {
            return 0L;
        }
        if (!clientAPI_InterfaceStats.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_InterfaceStats.swigCPtr;
        clientAPI_InterfaceStats.swigCMemOwn = false;
        clientAPI_InterfaceStats.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_InterfaceStats(j);
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

    public long getBytesIn() {
        return ovpncliJNI.ClientAPI_InterfaceStats_bytesIn_get(this.swigCPtr, this);
    }

    public long getBytesOut() {
        return ovpncliJNI.ClientAPI_InterfaceStats_bytesOut_get(this.swigCPtr, this);
    }

    public long getErrorsIn() {
        return ovpncliJNI.ClientAPI_InterfaceStats_errorsIn_get(this.swigCPtr, this);
    }

    public long getErrorsOut() {
        return ovpncliJNI.ClientAPI_InterfaceStats_errorsOut_get(this.swigCPtr, this);
    }

    public long getPacketsIn() {
        return ovpncliJNI.ClientAPI_InterfaceStats_packetsIn_get(this.swigCPtr, this);
    }

    public long getPacketsOut() {
        return ovpncliJNI.ClientAPI_InterfaceStats_packetsOut_get(this.swigCPtr, this);
    }

    public void setBytesIn(long j) {
        ovpncliJNI.ClientAPI_InterfaceStats_bytesIn_set(this.swigCPtr, this, j);
    }

    public void setBytesOut(long j) {
        ovpncliJNI.ClientAPI_InterfaceStats_bytesOut_set(this.swigCPtr, this, j);
    }

    public void setErrorsIn(long j) {
        ovpncliJNI.ClientAPI_InterfaceStats_errorsIn_set(this.swigCPtr, this, j);
    }

    public void setErrorsOut(long j) {
        ovpncliJNI.ClientAPI_InterfaceStats_errorsOut_set(this.swigCPtr, this, j);
    }

    public void setPacketsIn(long j) {
        ovpncliJNI.ClientAPI_InterfaceStats_packetsIn_set(this.swigCPtr, this, j);
    }

    public void setPacketsOut(long j) {
        ovpncliJNI.ClientAPI_InterfaceStats_packetsOut_set(this.swigCPtr, this, j);
    }

    public ClientAPI_InterfaceStats() {
        this(ovpncliJNI.new_ClientAPI_InterfaceStats(), true);
    }
}
