package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_MergeConfig {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_MergeConfig(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_MergeConfig clientAPI_MergeConfig) {
        if (clientAPI_MergeConfig == null) {
            return 0L;
        }
        return clientAPI_MergeConfig.swigCPtr;
    }

    public static long swigRelease(ClientAPI_MergeConfig clientAPI_MergeConfig) {
        if (clientAPI_MergeConfig == null) {
            return 0L;
        }
        if (!clientAPI_MergeConfig.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_MergeConfig.swigCPtr;
        clientAPI_MergeConfig.swigCMemOwn = false;
        clientAPI_MergeConfig.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_MergeConfig(j);
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

    public String getBasename() {
        return ovpncliJNI.ClientAPI_MergeConfig_basename_get(this.swigCPtr, this);
    }

    public String getErrorText() {
        return ovpncliJNI.ClientAPI_MergeConfig_errorText_get(this.swigCPtr, this);
    }

    public String getProfileContent() {
        return ovpncliJNI.ClientAPI_MergeConfig_profileContent_get(this.swigCPtr, this);
    }

    public ClientAPI_StringVec getRefPathList() {
        long jClientAPI_MergeConfig_refPathList_get = ovpncliJNI.ClientAPI_MergeConfig_refPathList_get(this.swigCPtr, this);
        if (jClientAPI_MergeConfig_refPathList_get == 0) {
            return null;
        }
        return new ClientAPI_StringVec(jClientAPI_MergeConfig_refPathList_get, false);
    }

    public String getStatus() {
        return ovpncliJNI.ClientAPI_MergeConfig_status_get(this.swigCPtr, this);
    }

    public void setBasename(String str) {
        ovpncliJNI.ClientAPI_MergeConfig_basename_set(this.swigCPtr, this, str);
    }

    public void setErrorText(String str) {
        ovpncliJNI.ClientAPI_MergeConfig_errorText_set(this.swigCPtr, this, str);
    }

    public void setProfileContent(String str) {
        ovpncliJNI.ClientAPI_MergeConfig_profileContent_set(this.swigCPtr, this, str);
    }

    public void setRefPathList(ClientAPI_StringVec clientAPI_StringVec) {
        ovpncliJNI.ClientAPI_MergeConfig_refPathList_set(this.swigCPtr, this, ClientAPI_StringVec.getCPtr(clientAPI_StringVec), clientAPI_StringVec);
    }

    public void setStatus(String str) {
        ovpncliJNI.ClientAPI_MergeConfig_status_set(this.swigCPtr, this, str);
    }

    public ClientAPI_MergeConfig() {
        this(ovpncliJNI.new_ClientAPI_MergeConfig(), true);
    }
}
