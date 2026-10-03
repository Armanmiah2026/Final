package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_OpenVPNClientHelper {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_OpenVPNClientHelper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static String copyright() {
        return ovpncliJNI.ClientAPI_OpenVPNClientHelper_copyright();
    }

    public static long getCPtr(ClientAPI_OpenVPNClientHelper clientAPI_OpenVPNClientHelper) {
        if (clientAPI_OpenVPNClientHelper == null) {
            return 0L;
        }
        return clientAPI_OpenVPNClientHelper.swigCPtr;
    }

    public static int max_profile_size() {
        return ovpncliJNI.ClientAPI_OpenVPNClientHelper_max_profile_size();
    }

    public static boolean parse_dynamic_challenge(String str, ClientAPI_DynamicChallenge clientAPI_DynamicChallenge) {
        return ovpncliJNI.ClientAPI_OpenVPNClientHelper_parse_dynamic_challenge(str, ClientAPI_DynamicChallenge.getCPtr(clientAPI_DynamicChallenge), clientAPI_DynamicChallenge);
    }

    public static String platform() {
        return ovpncliJNI.ClientAPI_OpenVPNClientHelper_platform();
    }

    public static long swigRelease(ClientAPI_OpenVPNClientHelper clientAPI_OpenVPNClientHelper) {
        if (clientAPI_OpenVPNClientHelper == null) {
            return 0L;
        }
        if (!clientAPI_OpenVPNClientHelper.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_OpenVPNClientHelper.swigCPtr;
        clientAPI_OpenVPNClientHelper.swigCMemOwn = false;
        clientAPI_OpenVPNClientHelper.delete();
        return j;
    }

    public String crypto_self_test() {
        return ovpncliJNI.ClientAPI_OpenVPNClientHelper_crypto_self_test(this.swigCPtr, this);
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_OpenVPNClientHelper(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public ClientAPI_EvalConfig eval_config(ClientAPI_Config clientAPI_Config) {
        return new ClientAPI_EvalConfig(ovpncliJNI.ClientAPI_OpenVPNClientHelper_eval_config(this.swigCPtr, this, ClientAPI_Config.getCPtr(clientAPI_Config), clientAPI_Config), true);
    }

    public void finalize() {
        delete();
    }

    public ClientAPI_MergeConfig merge_config(String str, boolean z) {
        return new ClientAPI_MergeConfig(ovpncliJNI.ClientAPI_OpenVPNClientHelper_merge_config(this.swigCPtr, this, str, z), true);
    }

    public ClientAPI_MergeConfig merge_config_string(String str) {
        return new ClientAPI_MergeConfig(ovpncliJNI.ClientAPI_OpenVPNClientHelper_merge_config_string(this.swigCPtr, this, str), true);
    }

    public ClientAPI_OpenVPNClientHelper() {
        this(ovpncliJNI.new_ClientAPI_OpenVPNClientHelper(), true);
    }
}
