package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DnsAddress {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DnsAddress(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DnsAddress dnsAddress) {
        if (dnsAddress == null) {
            return 0L;
        }
        return dnsAddress.swigCPtr;
    }

    public static long swigRelease(DnsAddress dnsAddress) {
        if (dnsAddress == null) {
            return 0L;
        }
        if (!dnsAddress.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = dnsAddress.swigCPtr;
        dnsAddress.swigCMemOwn = false;
        dnsAddress.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_DnsAddress(j);
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

    public String getAddress() {
        return ovpncliJNI.DnsAddress_address_get(this.swigCPtr, this);
    }

    public long getPort() {
        return ovpncliJNI.DnsAddress_port_get(this.swigCPtr, this);
    }

    public void setAddress(String str) {
        ovpncliJNI.DnsAddress_address_set(this.swigCPtr, this, str);
    }

    public void setPort(long j) {
        ovpncliJNI.DnsAddress_port_set(this.swigCPtr, this, j);
    }

    public String to_string() {
        return ovpncliJNI.DnsAddress_to_string(this.swigCPtr, this);
    }

    public void validate(String str) {
        ovpncliJNI.DnsAddress_validate(this.swigCPtr, this, str);
    }

    public DnsAddress() {
        this(ovpncliJNI.new_DnsAddress__SWIG_0(), true);
    }

    public DnsAddress(String str) {
        this(ovpncliJNI.new_DnsAddress__SWIG_1(str), true);
    }
}
