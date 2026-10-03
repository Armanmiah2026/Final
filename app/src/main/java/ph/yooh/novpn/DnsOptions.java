package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DnsOptions {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DnsOptions(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DnsOptions dnsOptions) {
        if (dnsOptions == null) {
            return 0L;
        }
        return dnsOptions.swigCPtr;
    }

    public static long swigRelease(DnsOptions dnsOptions) {
        if (dnsOptions == null) {
            return 0L;
        }
        if (!dnsOptions.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = dnsOptions.swigCPtr;
        dnsOptions.swigCMemOwn = false;
        dnsOptions.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_DnsOptions(j);
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

    public boolean getFrom_dhcp_options() {
        return ovpncliJNI.DnsOptions_from_dhcp_options_get(this.swigCPtr, this);
    }

    public DnsOptions_DomainsList getSearch_domains() {
        long jDnsOptions_search_domains_get = ovpncliJNI.DnsOptions_search_domains_get(this.swigCPtr, this);
        if (jDnsOptions_search_domains_get == 0) {
            return null;
        }
        return new DnsOptions_DomainsList(jDnsOptions_search_domains_get, false);
    }

    public DnsOptions_ServersMap getServers() {
        long jDnsOptions_servers_get = ovpncliJNI.DnsOptions_servers_get(this.swigCPtr, this);
        if (jDnsOptions_servers_get == 0) {
            return null;
        }
        return new DnsOptions_ServersMap(jDnsOptions_servers_get, false);
    }

    public void setFrom_dhcp_options(boolean z) {
        ovpncliJNI.DnsOptions_from_dhcp_options_set(this.swigCPtr, this, z);
    }

    public void setSearch_domains(DnsOptions_DomainsList dnsOptions_DomainsList) {
        ovpncliJNI.DnsOptions_search_domains_set(this.swigCPtr, this, DnsOptions_DomainsList.getCPtr(dnsOptions_DomainsList), dnsOptions_DomainsList);
    }

    public void setServers(DnsOptions_ServersMap dnsOptions_ServersMap) {
        ovpncliJNI.DnsOptions_servers_set(this.swigCPtr, this, DnsOptions_ServersMap.getCPtr(dnsOptions_ServersMap), dnsOptions_ServersMap);
    }

    public String to_string() {
        return ovpncliJNI.DnsOptions_to_string(this.swigCPtr, this);
    }

    public DnsOptions() {
        this(ovpncliJNI.new_DnsOptions(), true);
    }
}
