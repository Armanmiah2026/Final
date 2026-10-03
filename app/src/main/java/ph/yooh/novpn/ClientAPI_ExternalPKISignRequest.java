package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_ExternalPKISignRequest extends ClientAPI_ExternalPKIRequestBase {
    private transient long swigCPtr;

    public ClientAPI_ExternalPKISignRequest(long j, boolean z) {
        super(ovpncliJNI.ClientAPI_ExternalPKISignRequest_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_ExternalPKISignRequest clientAPI_ExternalPKISignRequest) {
        if (clientAPI_ExternalPKISignRequest == null) {
            return 0L;
        }
        return clientAPI_ExternalPKISignRequest.swigCPtr;
    }

    public static long swigRelease(ClientAPI_ExternalPKISignRequest clientAPI_ExternalPKISignRequest) {
        if (clientAPI_ExternalPKISignRequest == null) {
            return 0L;
        }
        if (!clientAPI_ExternalPKISignRequest.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_ExternalPKISignRequest.swigCPtr;
        clientAPI_ExternalPKISignRequest.swigCMemOwn = false;
        clientAPI_ExternalPKISignRequest.delete();
        return j;
    }

    @Override // ph.yooh.novpn.ClientAPI_ExternalPKIRequestBase
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_ExternalPKISignRequest(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ph.yooh.novpn.ClientAPI_ExternalPKIRequestBase
    public void finalize() {
        delete();
    }

    public String getAlgorithm() {
        return ovpncliJNI.ClientAPI_ExternalPKISignRequest_algorithm_get(this.swigCPtr, this);
    }

    public String getData() {
        return ovpncliJNI.ClientAPI_ExternalPKISignRequest_data_get(this.swigCPtr, this);
    }

    public String getHashalg() {
        return ovpncliJNI.ClientAPI_ExternalPKISignRequest_hashalg_get(this.swigCPtr, this);
    }

    public String getSaltlen() {
        return ovpncliJNI.ClientAPI_ExternalPKISignRequest_saltlen_get(this.swigCPtr, this);
    }

    public String getSig() {
        return ovpncliJNI.ClientAPI_ExternalPKISignRequest_sig_get(this.swigCPtr, this);
    }

    public void setAlgorithm(String str) {
        ovpncliJNI.ClientAPI_ExternalPKISignRequest_algorithm_set(this.swigCPtr, this, str);
    }

    public void setData(String str) {
        ovpncliJNI.ClientAPI_ExternalPKISignRequest_data_set(this.swigCPtr, this, str);
    }

    public void setHashalg(String str) {
        ovpncliJNI.ClientAPI_ExternalPKISignRequest_hashalg_set(this.swigCPtr, this, str);
    }

    public void setSaltlen(String str) {
        ovpncliJNI.ClientAPI_ExternalPKISignRequest_saltlen_set(this.swigCPtr, this, str);
    }

    public void setSig(String str) {
        ovpncliJNI.ClientAPI_ExternalPKISignRequest_sig_set(this.swigCPtr, this, str);
    }

    public ClientAPI_ExternalPKISignRequest() {
        this(ovpncliJNI.new_ClientAPI_ExternalPKISignRequest(), true);
    }
}
