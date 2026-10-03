package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_TransportStats {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_TransportStats(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_TransportStats clientAPI_TransportStats) {
        if (clientAPI_TransportStats == null) {
            return 0L;
        }
        return clientAPI_TransportStats.swigCPtr;
    }

    public static long swigRelease(ClientAPI_TransportStats clientAPI_TransportStats) {
        if (clientAPI_TransportStats == null) {
            return 0L;
        }
        if (!clientAPI_TransportStats.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_TransportStats.swigCPtr;
        clientAPI_TransportStats.swigCMemOwn = false;
        clientAPI_TransportStats.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_TransportStats(j);
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
        return ovpncliJNI.ClientAPI_TransportStats_bytesIn_get(this.swigCPtr, this);
    }

    public long getBytesOut() {
        return ovpncliJNI.ClientAPI_TransportStats_bytesOut_get(this.swigCPtr, this);
    }

    public int getLastPacketReceived() {
        return ovpncliJNI.ClientAPI_TransportStats_lastPacketReceived_get(this.swigCPtr, this);
    }

    public long getPacketsIn() {
        return ovpncliJNI.ClientAPI_TransportStats_packetsIn_get(this.swigCPtr, this);
    }

    public long getPacketsOut() {
        return ovpncliJNI.ClientAPI_TransportStats_packetsOut_get(this.swigCPtr, this);
    }

    public void setBytesIn(long j) {
        ovpncliJNI.ClientAPI_TransportStats_bytesIn_set(this.swigCPtr, this, j);
    }

    public void setBytesOut(long j) {
        ovpncliJNI.ClientAPI_TransportStats_bytesOut_set(this.swigCPtr, this, j);
    }

    public void setLastPacketReceived(int i) {
        ovpncliJNI.ClientAPI_TransportStats_lastPacketReceived_set(this.swigCPtr, this, i);
    }

    public void setPacketsIn(long j) {
        ovpncliJNI.ClientAPI_TransportStats_packetsIn_set(this.swigCPtr, this, j);
    }

    public void setPacketsOut(long j) {
        ovpncliJNI.ClientAPI_TransportStats_packetsOut_set(this.swigCPtr, this, j);
    }

    public ClientAPI_TransportStats() {
        this(ovpncliJNI.new_ClientAPI_TransportStats(), true);
    }
}
