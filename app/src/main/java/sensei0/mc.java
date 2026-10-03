package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mc extends et implements jp {
    public static final mc c;
    public static final mc d;
    public static final mc f;
    public static final mc h;
    public static final mc o;
    public static final mc p;
    public final /* synthetic */ int b;

    static {
        int i = 2;
        c = new mc(i, 0);
        d = new mc(i, 1);
        f = new mc(i, 2);
        h = new mc(i, 3);
        o = new mc(i, 4);
        p = new mc(i, 5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mc(int i, int i2) {
        super(i);
        this.b = i2;
    }

    @Override // sensei0.jp
    public final Object c(Object obj, Object obj2) {
        switch (this.b) {
            case 0:
                return ((lc) obj).j((jc) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 2:
                return Integer.valueOf(((Number) obj).intValue() + 1);
            case 3:
                jc jcVar = (jc) obj2;
                if (!(jcVar instanceof he0)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? jcVar : Integer.valueOf(iIntValue + 1);
            case 4:
                he0 he0Var = (he0) obj;
                jc jcVar2 = (jc) obj2;
                if (he0Var != null) {
                    return he0Var;
                }
                if (jcVar2 instanceof he0) {
                    return (he0) jcVar2;
                }
                return null;
            case 5:
                return (ke0) obj;
            default:
                return ((lc) obj).j((jc) obj2);
        }
    }
}
