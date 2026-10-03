package ph.yooh.novpn;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DnsOptions_DomainsList extends AbstractList<DnsDomain> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DnsOptions_DomainsList(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    private void doAdd(DnsDomain dnsDomain) {
        ovpncliJNI.DnsOptions_DomainsList_doAdd__SWIG_0(this.swigCPtr, this, DnsDomain.getCPtr(dnsDomain), dnsDomain);
    }

    private int doCapacity() {
        return ovpncliJNI.DnsOptions_DomainsList_doCapacity(this.swigCPtr, this);
    }

    private DnsDomain doGet(int i) {
        return new DnsDomain(ovpncliJNI.DnsOptions_DomainsList_doGet(this.swigCPtr, this, i), false);
    }

    private DnsDomain doRemove(int i) {
        return new DnsDomain(ovpncliJNI.DnsOptions_DomainsList_doRemove(this.swigCPtr, this, i), true);
    }

    private void doRemoveRange(int i, int i2) {
        ovpncliJNI.DnsOptions_DomainsList_doRemoveRange(this.swigCPtr, this, i, i2);
    }

    private void doReserve(int i) {
        ovpncliJNI.DnsOptions_DomainsList_doReserve(this.swigCPtr, this, i);
    }

    private DnsDomain doSet(int i, DnsDomain dnsDomain) {
        return new DnsDomain(ovpncliJNI.DnsOptions_DomainsList_doSet(this.swigCPtr, this, i, DnsDomain.getCPtr(dnsDomain), dnsDomain), true);
    }

    private int doSize() {
        return ovpncliJNI.DnsOptions_DomainsList_doSize(this.swigCPtr, this);
    }

    public static long getCPtr(DnsOptions_DomainsList dnsOptions_DomainsList) {
        if (dnsOptions_DomainsList == null) {
            return 0L;
        }
        return dnsOptions_DomainsList.swigCPtr;
    }

    public static long swigRelease(DnsOptions_DomainsList dnsOptions_DomainsList) {
        if (dnsOptions_DomainsList == null) {
            return 0L;
        }
        if (!dnsOptions_DomainsList.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = dnsOptions_DomainsList.swigCPtr;
        dnsOptions_DomainsList.swigCMemOwn = false;
        dnsOptions_DomainsList.delete();
        return j;
    }

    public int capacity() {
        return doCapacity();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ovpncliJNI.DnsOptions_DomainsList_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_DnsOptions_DomainsList(j);
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return ovpncliJNI.DnsOptions_DomainsList_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i2) {
        ((AbstractList) this).modCount++;
        doRemoveRange(i, i2);
    }

    public void reserve(int i) {
        doReserve(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return doSize();
    }

    private void doAdd(int i, DnsDomain dnsDomain) {
        ovpncliJNI.DnsOptions_DomainsList_doAdd__SWIG_1(this.swigCPtr, this, i, DnsDomain.getCPtr(dnsDomain), dnsDomain);
    }

    @Override // java.util.AbstractList, java.util.List
    public DnsDomain get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public DnsDomain remove(int i) {
        ((AbstractList) this).modCount++;
        return doRemove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public DnsDomain set(int i, DnsDomain dnsDomain) {
        return doSet(i, dnsDomain);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(DnsDomain dnsDomain) {
        ((AbstractList) this).modCount++;
        doAdd(dnsDomain);
        return true;
    }

    public DnsOptions_DomainsList(DnsDomain[] dnsDomainArr) {
        this();
        reserve(dnsDomainArr.length);
        for (DnsDomain dnsDomain : dnsDomainArr) {
            add(dnsDomain);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, DnsDomain dnsDomain) {
        ((AbstractList) this).modCount++;
        doAdd(i, dnsDomain);
    }

    public DnsOptions_DomainsList(Iterable<DnsDomain> iterable) {
        this();
        Iterator<DnsDomain> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public DnsOptions_DomainsList() {
        this(ovpncliJNI.new_DnsOptions_DomainsList__SWIG_0(), true);
    }

    public DnsOptions_DomainsList(DnsOptions_DomainsList dnsOptions_DomainsList) {
        this(ovpncliJNI.new_DnsOptions_DomainsList__SWIG_1(getCPtr(dnsOptions_DomainsList), dnsOptions_DomainsList), true);
    }

    public DnsOptions_DomainsList(int i, DnsDomain dnsDomain) {
        this(ovpncliJNI.new_DnsOptions_DomainsList__SWIG_2(i, DnsDomain.getCPtr(dnsDomain), dnsDomain), true);
    }
}
