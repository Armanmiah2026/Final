package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zp implements ex {
    public static final zp b = new zp(0);
    public final /* synthetic */ int a;

    public /* synthetic */ zp(int i) {
        this.a = i;
    }

    @Override // sensei0.ex
    public final t30 a(Class cls) {
        switch (this.a) {
            case 0:
                if (!cq.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (t30) cq.d(cls.asSubclass(cq.class)).c(3);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // sensei0.ex
    public final boolean b(Class cls) {
        switch (this.a) {
            case 0:
                return cq.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
