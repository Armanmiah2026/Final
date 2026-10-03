package ph.yooh.novpn;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DnsDomain {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DnsDomain(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DnsDomain dnsDomain) {
        if (dnsDomain == null) {
            return 0L;
        }
        return dnsDomain.swigCPtr;
    }

    public static long swigRelease(DnsDomain dnsDomain) {
        if (dnsDomain == null) {
            return 0L;
        }
        if (!dnsDomain.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = dnsDomain.swigCPtr;
        dnsDomain.swigCMemOwn = false;
        dnsDomain.delete();
        return j;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_DnsDomain(j);
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

    public String getDomain() {
        return ovpncliJNI.DnsDomain_domain_get(this.swigCPtr, this);
    }

    public void setDomain(String str) {
        ovpncliJNI.DnsDomain_domain_set(this.swigCPtr, this, str);
    }

    public String to_string() {
        return ovpncliJNI.DnsDomain_to_string(this.swigCPtr, this);
    }

    public void validate(String str) {
        ovpncliJNI.DnsDomain_validate(this.swigCPtr, this, str);
    }

    public DnsDomain() {
        this(ovpncliJNI.new_DnsDomain__SWIG_0(), true);
    }

    public DnsDomain(String str) {
        this(ovpncliJNI.new_DnsDomain__SWIG_1(str), true);
    }
}
