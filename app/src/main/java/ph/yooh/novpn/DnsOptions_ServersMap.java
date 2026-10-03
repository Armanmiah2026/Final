package ph.yooh.novpn;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DnsOptions_ServersMap extends AbstractMap<Integer, DnsServer> {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public static class Iterator {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public Iterator(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(Iterator iterator) {
            if (iterator == null) {
                return 0L;
            }
            return iterator.swigCPtr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getKey() {
            return ovpncliJNI.DnsOptions_ServersMap_Iterator_getKey(this.swigCPtr, this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Iterator getNextUnchecked() {
            return new Iterator(ovpncliJNI.DnsOptions_ServersMap_Iterator_getNextUnchecked(this.swigCPtr, this), true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DnsServer getValue() {
            return new DnsServer(ovpncliJNI.DnsOptions_ServersMap_Iterator_getValue(this.swigCPtr, this), true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isNot(Iterator iterator) {
            return ovpncliJNI.DnsOptions_ServersMap_Iterator_isNot(this.swigCPtr, this, getCPtr(iterator), iterator);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(DnsServer dnsServer) {
            ovpncliJNI.DnsOptions_ServersMap_Iterator_setValue(this.swigCPtr, this, DnsServer.getCPtr(dnsServer), dnsServer);
        }

        public static long swigRelease(Iterator iterator) {
            if (iterator == null) {
                return 0L;
            }
            if (!iterator.swigCMemOwn) {
                throw new RuntimeException("Cannot release ownership as memory is not owned");
            }
            long j = iterator.swigCPtr;
            iterator.swigCMemOwn = false;
            iterator.delete();
            return j;
        }

        public synchronized void delete() {
            try {
                long j = this.swigCPtr;
                if (j != 0) {
                    if (this.swigCMemOwn) {
                        this.swigCMemOwn = false;
                        ovpncliJNI.delete_DnsOptions_ServersMap_Iterator(j);
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
    }

    public DnsOptions_ServersMap(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    private Iterator begin() {
        return new Iterator(ovpncliJNI.DnsOptions_ServersMap_begin(this.swigCPtr, this), true);
    }

    private boolean containsImpl(int i) {
        return ovpncliJNI.DnsOptions_ServersMap_containsImpl(this.swigCPtr, this, i);
    }

    private Iterator end() {
        return new Iterator(ovpncliJNI.DnsOptions_ServersMap_end(this.swigCPtr, this), true);
    }

    private Iterator find(int i) {
        return new Iterator(ovpncliJNI.DnsOptions_ServersMap_find(this.swigCPtr, this, i), true);
    }

    public static long getCPtr(DnsOptions_ServersMap dnsOptions_ServersMap) {
        if (dnsOptions_ServersMap == null) {
            return 0L;
        }
        return dnsOptions_ServersMap.swigCPtr;
    }

    private void putUnchecked(int i, DnsServer dnsServer) {
        ovpncliJNI.DnsOptions_ServersMap_putUnchecked(this.swigCPtr, this, i, DnsServer.getCPtr(dnsServer), dnsServer);
    }

    private void removeUnchecked(Iterator iterator) {
        ovpncliJNI.DnsOptions_ServersMap_removeUnchecked(this.swigCPtr, this, Iterator.getCPtr(iterator), iterator);
    }

    private int sizeImpl() {
        return ovpncliJNI.DnsOptions_ServersMap_sizeImpl(this.swigCPtr, this);
    }

    public static long swigRelease(DnsOptions_ServersMap dnsOptions_ServersMap) {
        if (dnsOptions_ServersMap == null) {
            return 0L;
        }
        if (!dnsOptions_ServersMap.swigCMemOwn) {
            throw new RuntimeException("Cannot release ownership as memory is not owned");
        }
        long j = dnsOptions_ServersMap.swigCPtr;
        dnsOptions_ServersMap.swigCMemOwn = false;
        dnsOptions_ServersMap.delete();
        return j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        ovpncliJNI.DnsOptions_ServersMap_clear(this.swigCPtr, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj instanceof Integer) {
            return containsImpl(((Integer) obj).intValue());
        }
        return false;
    }

    public synchronized void delete() {
        try {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    ovpncliJNI.delete_DnsOptions_ServersMap(j);
                }
                this.swigCPtr = 0L;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [ph.yooh.novpn.DnsOptions_ServersMap$1] */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<Integer, DnsServer>> entrySet() {
        HashSet hashSet = new HashSet();
        Iterator iteratorEnd = end();
        for (Iterator iteratorBegin = begin(); iteratorBegin.isNot(iteratorEnd); iteratorBegin = iteratorBegin.getNextUnchecked()) {
            hashSet.add(new Map.Entry<Integer, DnsServer>() { // from class: ph.yooh.novpn.DnsOptions_ServersMap.1
                private Iterator iterator;

                /* JADX INFO: Access modifiers changed from: private */
                public Map.Entry<Integer, DnsServer> init(Iterator iterator) {
                    this.iterator = iterator;
                    return this;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Map.Entry
                public Integer getKey() {
                    return Integer.valueOf(this.iterator.getKey());
                }

                @Override // java.util.Map.Entry
                public DnsServer getValue() {
                    return this.iterator.getValue();
                }

                @Override // java.util.Map.Entry
                public DnsServer setValue(DnsServer dnsServer) {
                    DnsServer value = this.iterator.getValue();
                    this.iterator.setValue(dnsServer);
                    return value;
                }
            }.init(iteratorBegin));
        }
        return hashSet;
    }

    public void finalize() {
        delete();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return ovpncliJNI.DnsOptions_ServersMap_isEmpty(this.swigCPtr, this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return sizeImpl();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public DnsServer get(Object obj) {
        if (!(obj instanceof Integer)) {
            return null;
        }
        Iterator iteratorFind = find(((Integer) obj).intValue());
        if (iteratorFind.isNot(end())) {
            return iteratorFind.getValue();
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public DnsServer put(Integer num, DnsServer dnsServer) {
        Iterator iteratorFind = find(num.intValue());
        if (!iteratorFind.isNot(end())) {
            putUnchecked(num.intValue(), dnsServer);
            return null;
        }
        DnsServer value = iteratorFind.getValue();
        iteratorFind.setValue(dnsServer);
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public DnsServer remove(Object obj) {
        if (!(obj instanceof Integer)) {
            return null;
        }
        Iterator iteratorFind = find(((Integer) obj).intValue());
        if (!iteratorFind.isNot(end())) {
            return null;
        }
        DnsServer value = iteratorFind.getValue();
        removeUnchecked(iteratorFind);
        return value;
    }

    public DnsOptions_ServersMap() {
        this(ovpncliJNI.new_DnsOptions_ServersMap__SWIG_0(), true);
    }

    public DnsOptions_ServersMap(DnsOptions_ServersMap dnsOptions_ServersMap) {
        this(ovpncliJNI.new_DnsOptions_ServersMap__SWIG_1(getCPtr(dnsOptions_ServersMap), dnsOptions_ServersMap), true);
    }
}
