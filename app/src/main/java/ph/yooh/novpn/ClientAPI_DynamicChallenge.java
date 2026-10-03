package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_DynamicChallenge {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_DynamicChallenge(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_DynamicChallenge clientAPI_DynamicChallenge) {
        if (clientAPI_DynamicChallenge == null) {
            return 0L;
        }
        return clientAPI_DynamicChallenge.swigCPtr;
    }

    public static long swigRelease(ClientAPI_DynamicChallenge clientAPI_DynamicChallenge) {
        if (clientAPI_DynamicChallenge == null) {
            return 0L;
        }
        if (!clientAPI_DynamicChallenge.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_DynamicChallenge.swigCPtr;
        clientAPI_DynamicChallenge.swigCMemOwn = false;
        clientAPI_DynamicChallenge.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_DynamicChallenge(j);
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

    public String getChallenge() {
        return ovpncliJNI.ClientAPI_DynamicChallenge_challenge_get(this.swigCPtr, this);
    }

    public boolean getEcho() {
        return ovpncliJNI.ClientAPI_DynamicChallenge_echo_get(this.swigCPtr, this);
    }

    public boolean getResponseRequired() {
        return ovpncliJNI.ClientAPI_DynamicChallenge_responseRequired_get(this.swigCPtr, this);
    }

    public String getStateID() {
        return ovpncliJNI.ClientAPI_DynamicChallenge_stateID_get(this.swigCPtr, this);
    }

    public void setChallenge(String str) {
        ovpncliJNI.ClientAPI_DynamicChallenge_challenge_set(this.swigCPtr, this, str);
    }

    public void setEcho(boolean z) {
        ovpncliJNI.ClientAPI_DynamicChallenge_echo_set(this.swigCPtr, this, z);
    }

    public void setResponseRequired(boolean z) {
        ovpncliJNI.ClientAPI_DynamicChallenge_responseRequired_set(this.swigCPtr, this, z);
    }

    public void setStateID(String str) {
        ovpncliJNI.ClientAPI_DynamicChallenge_stateID_set(this.swigCPtr, this, str);
    }

    public ClientAPI_DynamicChallenge() {
        this(ovpncliJNI.new_ClientAPI_DynamicChallenge(), true);
    }
}
