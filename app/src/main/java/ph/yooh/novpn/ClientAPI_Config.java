package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_Config extends ConfigCommon {
    private transient long swigCPtr;

    public ClientAPI_Config(long j, boolean z) {
        super(ovpncliJNI.ClientAPI_Config_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(ClientAPI_Config clientAPI_Config) {
        if (clientAPI_Config == null) {
            return 0L;
        }
        return clientAPI_Config.swigCPtr;
    }

    public static long swigRelease(ClientAPI_Config clientAPI_Config) {
        if (clientAPI_Config == null) {
            return 0L;
        }
        if (!clientAPI_Config.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_Config.swigCPtr;
        clientAPI_Config.swigCMemOwn = false;
        clientAPI_Config.delete();
        return j;
    }

    @Override // ph.yooh.novpn.ConfigCommon
    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_Config(j);
                }
                this.swigCPtr = 0L;
            }
            super.delete();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ph.yooh.novpn.ConfigCommon
    public void finalize() {
        delete();
    }

    public String getAllowUnusedAddrFamilies() {
        return ovpncliJNI.ClientAPI_Config_allowUnusedAddrFamilies_get(this.swigCPtr, this);
    }

    public String getCompressionMode() {
        return ovpncliJNI.ClientAPI_Config_compressionMode_get(this.swigCPtr, this);
    }

    public String getContent() {
        return ovpncliJNI.ClientAPI_Config_content_get(this.swigCPtr, this);
    }

    public SWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t getContentList() {
        long jClientAPI_Config_contentList_get = ovpncliJNI.ClientAPI_Config_contentList_get(this.swigCPtr, this);
        if (jClientAPI_Config_contentList_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t(jClientAPI_Config_contentList_get, false);
    }

    public String getExternalPkiAlias() {
        return ovpncliJNI.ClientAPI_Config_externalPkiAlias_get(this.swigCPtr, this);
    }

    public SWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t getPeerInfo() {
        long jClientAPI_Config_peerInfo_get = ovpncliJNI.ClientAPI_Config_peerInfo_get(this.swigCPtr, this);
        if (jClientAPI_Config_peerInfo_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t(jClientAPI_Config_peerInfo_get, false);
    }

    public String getProtoOverride() {
        return ovpncliJNI.ClientAPI_Config_protoOverride_get(this.swigCPtr, this);
    }

    public int getProtoVersionOverride() {
        return ovpncliJNI.ClientAPI_Config_protoVersionOverride_get(this.swigCPtr, this);
    }

    public void setAllowUnusedAddrFamilies(String str) {
        ovpncliJNI.ClientAPI_Config_allowUnusedAddrFamilies_set(this.swigCPtr, this, str);
    }

    public void setCompressionMode(String str) {
        ovpncliJNI.ClientAPI_Config_compressionMode_set(this.swigCPtr, this, str);
    }

    public void setContent(String str) {
        ovpncliJNI.ClientAPI_Config_content_set(this.swigCPtr, this, str);
    }

    public void setContentList(SWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t sWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t) {
        ovpncliJNI.ClientAPI_Config_contentList_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t.getCPtr(sWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t));
    }

    public void setExternalPkiAlias(String str) {
        ovpncliJNI.ClientAPI_Config_externalPkiAlias_set(this.swigCPtr, this, str);
    }

    public void setPeerInfo(SWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t sWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t) {
        ovpncliJNI.ClientAPI_Config_peerInfo_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t.getCPtr(sWIGTYPE_p_std__vectorT_openvpn__ClientAPI__KeyValue_t));
    }

    public void setProtoOverride(String str) {
        ovpncliJNI.ClientAPI_Config_protoOverride_set(this.swigCPtr, this, str);
    }

    public void setProtoVersionOverride(int i) {
        ovpncliJNI.ClientAPI_Config_protoVersionOverride_set(this.swigCPtr, this, i);
    }

    public ClientAPI_Config() {
        this(ovpncliJNI.new_ClientAPI_Config(), true);
    }
}
