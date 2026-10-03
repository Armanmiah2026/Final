package sensei0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ht implements xm {
    public SharedPreferences a;
    public final pf b = new pf(18);

    public static void d(a6 a6Var, final ht htVar) {
        mh mhVarH = a6Var.h();
        lx lxVar = lx.e;
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.remove", lxVar, mhVarH);
        if (htVar != null) {
            final int i = 0;
            j1Var.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setBool", lxVar, mhVarH);
        if (htVar != null) {
            final int i2 = 1;
            j1Var2.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i2) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setString", lxVar, mhVarH);
        if (htVar != null) {
            final int i3 = 2;
            j1Var3.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i3) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setInt", lxVar, mhVarH);
        if (htVar != null) {
            final int i4 = 3;
            j1Var4.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i4) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDouble", lxVar, mhVarH);
        if (htVar != null) {
            final int i5 = 4;
            j1Var5.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i5) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        } else {
            j1Var5.l(null);
        }
        j1 j1Var6 = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setEncodedStringList", lxVar, mhVarH);
        if (htVar != null) {
            final int i6 = 5;
            j1Var6.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i6) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        } else {
            j1Var6.l(null);
        }
        j1 j1Var7 = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDeprecatedStringList", lxVar, mhVarH);
        if (htVar != null) {
            final int i7 = 6;
            j1Var7.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i7) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        } else {
            j1Var7.l(null);
        }
        j1 j1Var8 = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.clear", lxVar, mhVarH);
        if (htVar != null) {
            final int i8 = 7;
            j1Var8.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i8) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        } else {
            j1Var8.l(null);
        }
        j1 j1Var9 = new j1(a6Var, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.getAll", lxVar, mhVarH);
        if (htVar == null) {
            j1Var9.l(null);
        } else {
            final int i9 = 8;
            j1Var9.l(new u5(htVar) { // from class: sensei0.mx
                public final /* synthetic */ ht b;

                {
                    this.b = htVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i9) {
                        case 0:
                            ht htVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, Boolean.valueOf(htVar2.a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                            } catch (Throwable th) {
                                arrayList = mm0.p0(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            ht htVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            ArrayList arrayList3 = (ArrayList) obj;
                            try {
                                arrayList2.add(0, Boolean.valueOf(htVar3.a.edit().putBoolean((String) arrayList3.get(0), ((Boolean) arrayList3.get(1)).booleanValue()).commit()));
                            } catch (Throwable th2) {
                                arrayList2 = mm0.p0(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            ht htVar4 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            ArrayList arrayList5 = (ArrayList) obj;
                            try {
                                arrayList4.add(0, htVar4.c((String) arrayList5.get(0), (String) arrayList5.get(1)));
                            } catch (Throwable th3) {
                                arrayList4 = mm0.p0(th3);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 3:
                            ht htVar5 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = (ArrayList) obj;
                            try {
                                arrayList6.add(0, Boolean.valueOf(htVar5.a.edit().putLong((String) arrayList7.get(0), ((Long) arrayList7.get(1)).longValue()).commit()));
                            } catch (Throwable th4) {
                                arrayList6 = mm0.p0(th4);
                            }
                            i3Var.s(arrayList6);
                            break;
                        case 4:
                            ht htVar6 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            ArrayList arrayList9 = (ArrayList) obj;
                            String str = (String) arrayList9.get(0);
                            Double d = (Double) arrayList9.get(1);
                            try {
                                htVar6.getClass();
                                String string = Double.toString(d.doubleValue());
                                arrayList8.add(0, Boolean.valueOf(htVar6.a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                            } catch (Throwable th5) {
                                arrayList8 = mm0.p0(th5);
                            }
                            i3Var.s(arrayList8);
                            break;
                        case 5:
                            ht htVar7 = this.b;
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList arrayList11 = (ArrayList) obj;
                            try {
                                arrayList10.add(0, Boolean.valueOf(htVar7.a.edit().putString((String) arrayList11.get(0), (String) arrayList11.get(1)).commit()));
                            } catch (Throwable th6) {
                                arrayList10 = mm0.p0(th6);
                            }
                            i3Var.s(arrayList10);
                            break;
                        case 6:
                            ht htVar8 = this.b;
                            ArrayList arrayList12 = new ArrayList();
                            ArrayList arrayList13 = (ArrayList) obj;
                            String str2 = (String) arrayList13.get(0);
                            List list = (List) arrayList13.get(1);
                            try {
                                arrayList12.add(0, Boolean.valueOf(htVar8.a.edit().putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + htVar8.b.b(list)).commit()));
                            } catch (Throwable th7) {
                                arrayList12 = mm0.p0(th7);
                            }
                            i3Var.s(arrayList12);
                            break;
                        case 7:
                            ht htVar9 = this.b;
                            ArrayList arrayList14 = new ArrayList();
                            ArrayList arrayList15 = (ArrayList) obj;
                            try {
                                arrayList14.add(0, htVar9.a((String) arrayList15.get(0), (List) arrayList15.get(1)));
                            } catch (Throwable th8) {
                                arrayList14 = mm0.p0(th8);
                            }
                            i3Var.s(arrayList14);
                            break;
                        default:
                            ht htVar10 = this.b;
                            ArrayList arrayList16 = new ArrayList();
                            ArrayList arrayList17 = (ArrayList) obj;
                            try {
                                arrayList16.add(0, htVar10.b((String) arrayList17.get(0), (List) arrayList17.get(1)));
                            } catch (Throwable th9) {
                                arrayList16 = mm0.p0(th9);
                            }
                            i3Var.s(arrayList16);
                            break;
                    }
                }
            });
        }
    }

    public final Boolean a(String str, List list) {
        SharedPreferences.Editor editorEdit = this.a.edit();
        Map<String, ?> all = this.a.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (list == null || list.contains(str2))) {
                arrayList.add(str2);
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            editorEdit.remove((String) obj);
        }
        return Boolean.valueOf(editorEdit.commit());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final HashMap b(String str, List list) throws ClassNotFoundException, IOException {
        Object bigInteger;
        Object objValueOf;
        Set hashSet = list == null ? null : new HashSet(list);
        Map<String, ?> all = this.a.getAll();
        HashMap map = new HashMap();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (hashSet == null || hashSet.contains(str2))) {
                Object obj = all.get(str2);
                Objects.requireNonNull(obj);
                boolean z = obj instanceof String;
                pf pfVar = this.b;
                if (z) {
                    String str3 = (String) obj;
                    if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                        objValueOf = obj;
                        if (!str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!")) {
                            objValueOf = pfVar.a(str3.substring(40));
                        }
                    } else if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
                        bigInteger = new BigInteger(str3.substring(44), 36);
                        objValueOf = bigInteger;
                    } else {
                        objValueOf = obj;
                        if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                            objValueOf = Double.valueOf(str3.substring(40));
                        }
                    }
                    map.put(str2, objValueOf);
                } else {
                    boolean z2 = obj instanceof Set;
                    objValueOf = obj;
                    if (z2) {
                        ArrayList arrayList = new ArrayList((Set) obj);
                        this.a.edit().remove(str2).putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + pfVar.b(arrayList)).apply();
                        bigInteger = arrayList;
                        objValueOf = bigInteger;
                    }
                    map.put(str2, objValueOf);
                }
            }
        }
        return map;
    }

    public final Boolean c(String str, String str2) {
        if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
            throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
        }
        return Boolean.valueOf(this.a.edit().putString(str, str2).commit());
    }

    @Override // sensei0.xm
    public final void e(j1 j1Var) {
        d((a6) j1Var.b, null);
    }

    @Override // sensei0.xm
    public final void g(j1 j1Var) {
        a6 a6Var = (a6) j1Var.b;
        this.a = ((Context) j1Var.a).getSharedPreferences("FlutterSharedPreferences", 0);
        try {
            d(a6Var, this);
        } catch (Exception e) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e);
        }
    }
}
