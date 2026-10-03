package sensei0;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class lx extends rb0 {
    public static final lx e = new lx(0);
    public static final lx f = new lx(1);
    public static final lx g = new lx(2);
    public final /* synthetic */ int d;

    public /* synthetic */ lx(int i) {
        this.d = i;
    }

    @Override // sensei0.rb0
    public Object f(byte b, ByteBuffer byteBuffer) {
        Object obj;
        switch (this.d) {
            case 1:
                if (b == -127) {
                    ArrayList arrayList = (ArrayList) e(byteBuffer);
                    px pxVar = new px();
                    Boolean bool = (Boolean) arrayList.get(0);
                    if (bool == null) {
                        throw new IllegalStateException("Nonnull field \"enableJavaScript\" is null.");
                    }
                    pxVar.a = bool;
                    Boolean bool2 = (Boolean) arrayList.get(1);
                    if (bool2 == null) {
                        throw new IllegalStateException("Nonnull field \"enableDomStorage\" is null.");
                    }
                    pxVar.b = bool2;
                    Map map = (Map) arrayList.get(2);
                    if (map == null) {
                        throw new IllegalStateException("Nonnull field \"headers\" is null.");
                    }
                    pxVar.c = map;
                    obj = pxVar;
                } else {
                    if (b != -126) {
                        return super.f(b, byteBuffer);
                    }
                    ArrayList arrayList2 = (ArrayList) e(byteBuffer);
                    ix ixVar = new ix();
                    Boolean bool3 = (Boolean) arrayList2.get(0);
                    if (bool3 == null) {
                        throw new IllegalStateException("Nonnull field \"showTitle\" is null.");
                    }
                    ixVar.a = bool3;
                    obj = ixVar;
                }
                return obj;
            case 2:
                if (b != -127) {
                    return super.f(b, byteBuffer);
                }
                Object objE = e(byteBuffer);
                if (objE == null) {
                    return null;
                }
                return nx.values()[((Long) objE).intValue()];
            case 3:
                pr.j("buffer", byteBuffer);
                int i = 0;
                if (b == -127) {
                    Long l = (Long) e(byteBuffer);
                    if (l != null) {
                        int iLongValue = (int) l.longValue();
                        mk.b.getClass();
                        mk[] mkVarArrValues = mk.values();
                        int length = mkVarArrValues.length;
                        while (i < length) {
                            mk mkVar = mkVarArrValues[i];
                            if (mkVar.a == iLongValue) {
                                return mkVar;
                            }
                            i++;
                        }
                    }
                } else if (b == -126) {
                    Long l2 = (Long) e(byteBuffer);
                    if (l2 != null) {
                        int iLongValue2 = (int) l2.longValue();
                        qa.b.getClass();
                        qa[] qaVarArrValues = qa.values();
                        int length2 = qaVarArrValues.length;
                        while (i < length2) {
                            qa qaVar = qaVarArrValues[i];
                            if (qaVar.a == iLongValue2) {
                                return qaVar;
                            }
                            i++;
                        }
                    }
                } else if (b == -125) {
                    Long l3 = (Long) e(byteBuffer);
                    if (l3 != null) {
                        int iLongValue3 = (int) l3.longValue();
                        nz.b.getClass();
                        nz[] nzVarArrValues = nz.values();
                        int length3 = nzVarArrValues.length;
                        while (i < length3) {
                            nz nzVar = nzVarArrValues[i];
                            if (nzVar.a == iLongValue3) {
                                return nzVar;
                            }
                            i++;
                        }
                    }
                } else if (b == -124) {
                    Long l4 = (Long) e(byteBuffer);
                    if (l4 != null) {
                        int iLongValue4 = (int) l4.longValue();
                        hb0.b.getClass();
                        hb0[] hb0VarArrValues = hb0.values();
                        int length4 = hb0VarArrValues.length;
                        while (i < length4) {
                            hb0 hb0Var = hb0VarArrValues[i];
                            if (hb0Var.a == iLongValue4) {
                                return hb0Var;
                            }
                            i++;
                        }
                    }
                } else {
                    if (b != -123) {
                        return super.f(b, byteBuffer);
                    }
                    Long l5 = (Long) e(byteBuffer);
                    if (l5 != null) {
                        int iLongValue5 = (int) l5.longValue();
                        vx.b.getClass();
                        vx[] vxVarArrValues = vx.values();
                        int length5 = vxVarArrValues.length;
                        while (i < length5) {
                            vx vxVar = vxVarArrValues[i];
                            if (vxVar.a == iLongValue5) {
                                return vxVar;
                            }
                            i++;
                        }
                    }
                }
                return null;
            case 4:
                pr.j("buffer", byteBuffer);
                if (b == -127) {
                    Long l6 = (Long) e(byteBuffer);
                    if (l6 == null) {
                        return null;
                    }
                    int iLongValue6 = (int) l6.longValue();
                    cc0.b.getClass();
                    for (cc0 cc0Var : cc0.values()) {
                        if (cc0Var.a == iLongValue6) {
                            return cc0Var;
                        }
                    }
                    return null;
                }
                if (b == -126) {
                    Object objE2 = e(byteBuffer);
                    List list = objE2 instanceof List ? (List) objE2 : null;
                    if (list == null) {
                        return null;
                    }
                    String str = (String) list.get(0);
                    Object obj2 = list.get(1);
                    pr.g("null cannot be cast to non-null type kotlin.Boolean", obj2);
                    return new s80(str, ((Boolean) obj2).booleanValue());
                }
                if (b != -125) {
                    return super.f(b, byteBuffer);
                }
                Object objE3 = e(byteBuffer);
                List list2 = objE3 instanceof List ? (List) objE3 : null;
                if (list2 == null) {
                    return null;
                }
                String str2 = (String) list2.get(0);
                Object obj3 = list2.get(1);
                pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.StringListLookupResultType", obj3);
                return new ec0(str2, (cc0) obj3);
            default:
                return super.f(b, byteBuffer);
        }
    }

    @Override // sensei0.rb0
    public void k(qb0 qb0Var, Object obj) {
        switch (this.d) {
            case 1:
                if (obj instanceof px) {
                    qb0Var.write(129);
                    px pxVar = (px) obj;
                    ArrayList arrayList = new ArrayList(3);
                    arrayList.add(pxVar.a);
                    arrayList.add(pxVar.b);
                    arrayList.add(pxVar.c);
                    k(qb0Var, arrayList);
                } else if (!(obj instanceof ix)) {
                    super.k(qb0Var, obj);
                } else {
                    qb0Var.write(130);
                    ArrayList arrayList2 = new ArrayList(1);
                    arrayList2.add(((ix) obj).a);
                    k(qb0Var, arrayList2);
                }
                break;
            case 2:
                if (!(obj instanceof nx)) {
                    super.k(qb0Var, obj);
                } else {
                    qb0Var.write(129);
                    k(qb0Var, Integer.valueOf(((nx) obj).a));
                }
                break;
            case 3:
                if (obj instanceof mk) {
                    qb0Var.write(129);
                    k(qb0Var, Integer.valueOf(((mk) obj).a));
                } else if (obj instanceof qa) {
                    qb0Var.write(130);
                    k(qb0Var, Integer.valueOf(((qa) obj).a));
                } else if (obj instanceof nz) {
                    qb0Var.write(131);
                    k(qb0Var, Integer.valueOf(((nz) obj).a));
                } else if (obj instanceof hb0) {
                    qb0Var.write(132);
                    k(qb0Var, Integer.valueOf(((hb0) obj).a));
                } else if (!(obj instanceof vx)) {
                    super.k(qb0Var, obj);
                } else {
                    qb0Var.write(133);
                    k(qb0Var, Integer.valueOf(((vx) obj).a));
                }
                break;
            case 4:
                if (obj instanceof cc0) {
                    qb0Var.write(129);
                    k(qb0Var, Integer.valueOf(((cc0) obj).a));
                } else if (obj instanceof s80) {
                    qb0Var.write(130);
                    s80 s80Var = (s80) obj;
                    k(qb0Var, p9.f0(s80Var.a, Boolean.valueOf(s80Var.b)));
                } else if (!(obj instanceof ec0)) {
                    super.k(qb0Var, obj);
                } else {
                    qb0Var.write(131);
                    ec0 ec0Var = (ec0) obj;
                    k(qb0Var, p9.f0(ec0Var.a, ec0Var.b));
                }
                break;
            default:
                super.k(qb0Var, obj);
                break;
        }
    }
}
