package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ConfigCommon {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ConfigCommon(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ConfigCommon configCommon) {
        if (configCommon == null) {
            return 0L;
        }
        return configCommon.swigCPtr;
    }

    public static long swigRelease(ConfigCommon configCommon) {
        if (configCommon == null) {
            return 0L;
        }
        if (!configCommon.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = configCommon.swigCPtr;
        configCommon.swigCMemOwn = false;
        configCommon.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ConfigCommon(j);
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

    public boolean getAllowLocalDnsResolvers() {
        return ovpncliJNI.ConfigCommon_allowLocalDnsResolvers_get(this.swigCPtr, this);
    }

    public boolean getAllowLocalLanAccess() {
        return ovpncliJNI.ConfigCommon_allowLocalLanAccess_get(this.swigCPtr, this);
    }

    public boolean getAltProxy() {
        return ovpncliJNI.ConfigCommon_altProxy_get(this.swigCPtr, this);
    }

    public String getAppCustomProtocols() {
        return ovpncliJNI.ConfigCommon_appCustomProtocols_get(this.swigCPtr, this);
    }

    public boolean getAutologinSessions() {
        return ovpncliJNI.ConfigCommon_autologinSessions_get(this.swigCPtr, this);
    }

    public long getClockTickMS() {
        return ovpncliJNI.ConfigCommon_clockTickMS_get(this.swigCPtr, this);
    }

    public int getConnTimeout() {
        return ovpncliJNI.ConfigCommon_connTimeout_get(this.swigCPtr, this);
    }

    public boolean getDco() {
        return ovpncliJNI.ConfigCommon_dco_get(this.swigCPtr, this);
    }

    public int getDefaultKeyDirection() {
        return ovpncliJNI.ConfigCommon_defaultKeyDirection_get(this.swigCPtr, this);
    }

    public boolean getDhcpSearchDomainsAsSplitDomains() {
        return ovpncliJNI.ConfigCommon_dhcpSearchDomainsAsSplitDomains_get(this.swigCPtr, this);
    }

    public boolean getDisableClientCert() {
        return ovpncliJNI.ConfigCommon_disableClientCert_get(this.swigCPtr, this);
    }

    public boolean getEcho() {
        return ovpncliJNI.ConfigCommon_echo_get(this.swigCPtr, this);
    }

    public boolean getEnableLegacyAlgorithms() {
        return ovpncliJNI.ConfigCommon_enableLegacyAlgorithms_get(this.swigCPtr, this);
    }

    public boolean getEnableNonPreferredDCAlgorithms() {
        return ovpncliJNI.ConfigCommon_enableNonPreferredDCAlgorithms_get(this.swigCPtr, this);
    }

    public boolean getEnableRouteEmulation() {
        return ovpncliJNI.ConfigCommon_enableRouteEmulation_get(this.swigCPtr, this);
    }

    public boolean getGenerateTunBuilderCaptureEvent() {
        return ovpncliJNI.ConfigCommon_generateTunBuilderCaptureEvent_get(this.swigCPtr, this);
    }

    public boolean getGoogleDnsFallback() {
        return ovpncliJNI.ConfigCommon_googleDnsFallback_get(this.swigCPtr, this);
    }

    public String getGremlinConfig() {
        return ovpncliJNI.ConfigCommon_gremlinConfig_get(this.swigCPtr, this);
    }

    public String getGuiVersion() {
        return ovpncliJNI.ConfigCommon_guiVersion_get(this.swigCPtr, this);
    }

    public String getHwAddrOverride() {
        return ovpncliJNI.ConfigCommon_hwAddrOverride_get(this.swigCPtr, this);
    }

    public boolean getInfo() {
        return ovpncliJNI.ConfigCommon_info_get(this.swigCPtr, this);
    }

    public String getPlatformVersion() {
        return ovpncliJNI.ConfigCommon_platformVersion_get(this.swigCPtr, this);
    }

    public String getPortOverride() {
        return ovpncliJNI.ConfigCommon_portOverride_get(this.swigCPtr, this);
    }

    public String getPrivateKeyPassword() {
        return ovpncliJNI.ConfigCommon_privateKeyPassword_get(this.swigCPtr, this);
    }

    public boolean getProxyAllowCleartextAuth() {
        return ovpncliJNI.ConfigCommon_proxyAllowCleartextAuth_get(this.swigCPtr, this);
    }

    public String getProxyHost() {
        return ovpncliJNI.ConfigCommon_proxyHost_get(this.swigCPtr, this);
    }

    public String getProxyPassword() {
        return ovpncliJNI.ConfigCommon_proxyPassword_get(this.swigCPtr, this);
    }

    public String getProxyPort() {
        return ovpncliJNI.ConfigCommon_proxyPort_get(this.swigCPtr, this);
    }

    public String getProxyUsername() {
        return ovpncliJNI.ConfigCommon_proxyUsername_get(this.swigCPtr, this);
    }

    public boolean getRetryOnAuthFailed() {
        return ovpncliJNI.ConfigCommon_retryOnAuthFailed_get(this.swigCPtr, this);
    }

    public String getServerOverride() {
        return ovpncliJNI.ConfigCommon_serverOverride_get(this.swigCPtr, this);
    }

    public int getSslDebugLevel() {
        return ovpncliJNI.ConfigCommon_sslDebugLevel_get(this.swigCPtr, this);
    }

    public String getSsoMethods() {
        return ovpncliJNI.ConfigCommon_ssoMethods_get(this.swigCPtr, this);
    }

    public boolean getSynchronousDnsLookup() {
        return ovpncliJNI.ConfigCommon_synchronousDnsLookup_get(this.swigCPtr, this);
    }

    public String getTlsCertProfileOverride() {
        return ovpncliJNI.ConfigCommon_tlsCertProfileOverride_get(this.swigCPtr, this);
    }

    public String getTlsCipherList() {
        return ovpncliJNI.ConfigCommon_tlsCipherList_get(this.swigCPtr, this);
    }

    public String getTlsCiphersuitesList() {
        return ovpncliJNI.ConfigCommon_tlsCiphersuitesList_get(this.swigCPtr, this);
    }

    public String getTlsVersionMinOverride() {
        return ovpncliJNI.ConfigCommon_tlsVersionMinOverride_get(this.swigCPtr, this);
    }

    public boolean getTunPersist() {
        return ovpncliJNI.ConfigCommon_tunPersist_get(this.swigCPtr, this);
    }

    public boolean getWintun() {
        return ovpncliJNI.ConfigCommon_wintun_get(this.swigCPtr, this);
    }

    public void setAllowLocalDnsResolvers(boolean z) {
        ovpncliJNI.ConfigCommon_allowLocalDnsResolvers_set(this.swigCPtr, this, z);
    }

    public void setAllowLocalLanAccess(boolean z) {
        ovpncliJNI.ConfigCommon_allowLocalLanAccess_set(this.swigCPtr, this, z);
    }

    public void setAltProxy(boolean z) {
        ovpncliJNI.ConfigCommon_altProxy_set(this.swigCPtr, this, z);
    }

    public void setAppCustomProtocols(String str) {
        ovpncliJNI.ConfigCommon_appCustomProtocols_set(this.swigCPtr, this, str);
    }

    public void setAutologinSessions(boolean z) {
        ovpncliJNI.ConfigCommon_autologinSessions_set(this.swigCPtr, this, z);
    }

    public void setClockTickMS(long j) {
        ovpncliJNI.ConfigCommon_clockTickMS_set(this.swigCPtr, this, j);
    }

    public void setConnTimeout(int i) {
        ovpncliJNI.ConfigCommon_connTimeout_set(this.swigCPtr, this, i);
    }

    public void setDco(boolean z) {
        ovpncliJNI.ConfigCommon_dco_set(this.swigCPtr, this, z);
    }

    public void setDefaultKeyDirection(int i) {
        ovpncliJNI.ConfigCommon_defaultKeyDirection_set(this.swigCPtr, this, i);
    }

    public void setDhcpSearchDomainsAsSplitDomains(boolean z) {
        ovpncliJNI.ConfigCommon_dhcpSearchDomainsAsSplitDomains_set(this.swigCPtr, this, z);
    }

    public void setDisableClientCert(boolean z) {
        ovpncliJNI.ConfigCommon_disableClientCert_set(this.swigCPtr, this, z);
    }

    public void setEcho(boolean z) {
        ovpncliJNI.ConfigCommon_echo_set(this.swigCPtr, this, z);
    }

    public void setEnableLegacyAlgorithms(boolean z) {
        ovpncliJNI.ConfigCommon_enableLegacyAlgorithms_set(this.swigCPtr, this, z);
    }

    public void setEnableNonPreferredDCAlgorithms(boolean z) {
        ovpncliJNI.ConfigCommon_enableNonPreferredDCAlgorithms_set(this.swigCPtr, this, z);
    }

    public void setEnableRouteEmulation(boolean z) {
        ovpncliJNI.ConfigCommon_enableRouteEmulation_set(this.swigCPtr, this, z);
    }

    public void setGenerateTunBuilderCaptureEvent(boolean z) {
        ovpncliJNI.ConfigCommon_generateTunBuilderCaptureEvent_set(this.swigCPtr, this, z);
    }

    public void setGoogleDnsFallback(boolean z) {
        ovpncliJNI.ConfigCommon_googleDnsFallback_set(this.swigCPtr, this, z);
    }

    public void setGremlinConfig(String str) {
        ovpncliJNI.ConfigCommon_gremlinConfig_set(this.swigCPtr, this, str);
    }

    public void setGuiVersion(String str) {
        ovpncliJNI.ConfigCommon_guiVersion_set(this.swigCPtr, this, str);
    }

    public void setHwAddrOverride(String str) {
        ovpncliJNI.ConfigCommon_hwAddrOverride_set(this.swigCPtr, this, str);
    }

    public void setInfo(boolean z) {
        ovpncliJNI.ConfigCommon_info_set(this.swigCPtr, this, z);
    }

    public void setPlatformVersion(String str) {
        ovpncliJNI.ConfigCommon_platformVersion_set(this.swigCPtr, this, str);
    }

    public void setPortOverride(String str) {
        ovpncliJNI.ConfigCommon_portOverride_set(this.swigCPtr, this, str);
    }

    public void setPrivateKeyPassword(String str) {
        ovpncliJNI.ConfigCommon_privateKeyPassword_set(this.swigCPtr, this, str);
    }

    public void setProxyAllowCleartextAuth(boolean z) {
        ovpncliJNI.ConfigCommon_proxyAllowCleartextAuth_set(this.swigCPtr, this, z);
    }

    public void setProxyHost(String str) {
        ovpncliJNI.ConfigCommon_proxyHost_set(this.swigCPtr, this, str);
    }

    public void setProxyPassword(String str) {
        ovpncliJNI.ConfigCommon_proxyPassword_set(this.swigCPtr, this, str);
    }

    public void setProxyPort(String str) {
        ovpncliJNI.ConfigCommon_proxyPort_set(this.swigCPtr, this, str);
    }

    public void setProxyUsername(String str) {
        ovpncliJNI.ConfigCommon_proxyUsername_set(this.swigCPtr, this, str);
    }

    public void setRetryOnAuthFailed(boolean z) {
        ovpncliJNI.ConfigCommon_retryOnAuthFailed_set(this.swigCPtr, this, z);
    }

    public void setServerOverride(String str) {
        ovpncliJNI.ConfigCommon_serverOverride_set(this.swigCPtr, this, str);
    }

    public void setSslDebugLevel(int i) {
        ovpncliJNI.ConfigCommon_sslDebugLevel_set(this.swigCPtr, this, i);
    }

    public void setSsoMethods(String str) {
        ovpncliJNI.ConfigCommon_ssoMethods_set(this.swigCPtr, this, str);
    }

    public void setSynchronousDnsLookup(boolean z) {
        ovpncliJNI.ConfigCommon_synchronousDnsLookup_set(this.swigCPtr, this, z);
    }

    public void setTlsCertProfileOverride(String str) {
        ovpncliJNI.ConfigCommon_tlsCertProfileOverride_set(this.swigCPtr, this, str);
    }

    public void setTlsCipherList(String str) {
        ovpncliJNI.ConfigCommon_tlsCipherList_set(this.swigCPtr, this, str);
    }

    public void setTlsCiphersuitesList(String str) {
        ovpncliJNI.ConfigCommon_tlsCiphersuitesList_set(this.swigCPtr, this, str);
    }

    public void setTlsVersionMinOverride(String str) {
        ovpncliJNI.ConfigCommon_tlsVersionMinOverride_set(this.swigCPtr, this, str);
    }

    public void setTunPersist(boolean z) {
        ovpncliJNI.ConfigCommon_tunPersist_set(this.swigCPtr, this, z);
    }

    public void setWintun(boolean z) {
        ovpncliJNI.ConfigCommon_wintun_set(this.swigCPtr, this, z);
    }

    public ConfigCommon() {
        this(ovpncliJNI.new_ConfigCommon(), true);
    }
}
