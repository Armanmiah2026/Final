package ph.yooh.novpn;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientAPI_StringVec extends AbstractList<String> implements RandomAccess {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClientAPI_StringVec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    private void doAdd(String str) {
        ovpncliJNI.ClientAPI_StringVec_doAdd__SWIG_0(this.swigCPtr, this, str);
    }

    private int doCapacity() {
        return ovpncliJNI.ClientAPI_StringVec_doCapacity(this.swigCPtr, this);
    }

    private String doGet(int i) {
        return ovpncliJNI.ClientAPI_StringVec_doGet(this.swigCPtr, this, i);
    }

    private String doRemove(int i) {
        return ovpncliJNI.ClientAPI_StringVec_doRemove(this.swigCPtr, this, i);
    }

    private void doRemoveRange(int i, int i2) {
        ovpncliJNI.ClientAPI_StringVec_doRemoveRange(this.swigCPtr, this, i, i2);
    }

    private void doReserve(int i) {
        ovpncliJNI.ClientAPI_StringVec_doReserve(this.swigCPtr, this, i);
    }

    private String doSet(int i, String str) {
        return ovpncliJNI.ClientAPI_StringVec_doSet(this.swigCPtr, this, i, str);
    }

    private int doSize() {
        return ovpncliJNI.ClientAPI_StringVec_doSize(this.swigCPtr, this);
    }

    public static long getCPtr(ClientAPI_StringVec clientAPI_StringVec) {
        if (clientAPI_StringVec == null) {
            return 0L;
        }
        return clientAPI_StringVec.swigCPtr;
    }

    public static long swigRelease(ClientAPI_StringVec clientAPI_StringVec) {
        if (clientAPI_StringVec == null) {
            return 0L;
        }
        if (!clientAPI_StringVec.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = clientAPI_StringVec.swigCPtr;
        clientAPI_StringVec.swigCMemOwn = false;
        clientAPI_StringVec.delete();
        return j;
    }

    public int capacity() {
        return doCapacity();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ovpncliJNI.ClientAPI_StringVec_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_ClientAPI_StringVec(j);
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
        return ovpncliJNI.ClientAPI_StringVec_isEmpty(this.swigCPtr, this);
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

    private void doAdd(int i, String str) {
        ovpncliJNI.ClientAPI_StringVec_doAdd__SWIG_1(this.swigCPtr, this, i, str);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int i) {
        return doGet(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public String remove(int i) {
        ((AbstractList) this).modCount++;
        return doRemove(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public String set(int i, String str) {
        return doSet(i, str);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(String str) {
        ((AbstractList) this).modCount++;
        doAdd(str);
        return true;
    }

    public ClientAPI_StringVec(String[] strArr) {
        this();
        reserve(strArr.length);
        for (String str : strArr) {
            add(str);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, String str) {
        ((AbstractList) this).modCount++;
        doAdd(i, str);
    }

    public ClientAPI_StringVec(Iterable<String> iterable) {
        this();
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public ClientAPI_StringVec() {
        this(ovpncliJNI.new_ClientAPI_StringVec__SWIG_0(), true);
    }

    public ClientAPI_StringVec(ClientAPI_StringVec clientAPI_StringVec) {
        this(ovpncliJNI.new_ClientAPI_StringVec__SWIG_1(getCPtr(clientAPI_StringVec), clientAPI_StringVec), true);
    }

    public ClientAPI_StringVec(int i, String str) {
        this(ovpncliJNI.new_ClientAPI_StringVec__SWIG_2(i, str), true);
    }
}
