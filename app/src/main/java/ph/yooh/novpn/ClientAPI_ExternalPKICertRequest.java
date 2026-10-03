package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_ExternalPKICertRequest extends ClientAPI_ExternalPKIRequestBase {
    private transient long swigCPtr;

    public ClientAPI_ExternalPKICertRequest(long j, boolean z) {
        super(ovpncliJNI.ClientAPI_ExternalPKICertRequest_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_ExternalPKICertRequest clientAPI_ExternalPKICertRequest) {
        if (clientAPI_ExternalPKICertRequest == null) {
            return 0L;
        }
        return clientAPI_ExternalPKICertRequest.swigCPtr;
    }

    public static long swigRelease(ClientAPI_ExternalPKICertRequest clientAPI_ExternalPKICertRequest) {
        if (clientAPI_ExternalPKICertRequest == null) {
            return 0L;
        }
        if (!clientAPI_ExternalPKICertRequest.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_ExternalPKICertRequest.swigCPtr;
        clientAPI_ExternalPKICertRequest.swigCMemOwn = false;
        clientAPI_ExternalPKICertRequest.delete();
        return j;
    }

    @Override // ph.yooh.novpn.ClientAPI_ExternalPKIRequestBase
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_ExternalPKICertRequest(j);
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

    public String getCert() {
        return ovpncliJNI.ClientAPI_ExternalPKICertRequest_cert_get(this.swigCPtr, this);
    }

    public String getSupportingChain() {
        return ovpncliJNI.ClientAPI_ExternalPKICertRequest_supportingChain_get(this.swigCPtr, this);
    }

    public void setCert(String str) {
        ovpncliJNI.ClientAPI_ExternalPKICertRequest_cert_set(this.swigCPtr, this, str);
    }

    public void setSupportingChain(String str) {
        ovpncliJNI.ClientAPI_ExternalPKICertRequest_supportingChain_set(this.swigCPtr, this, str);
    }

    public ClientAPI_ExternalPKICertRequest() {
        this(ovpncliJNI.new_ClientAPI_ExternalPKICertRequest(), true);
    }
}
