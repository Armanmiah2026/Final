package sensei0;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class q80 {
    public static final /* synthetic */ q80 a = new q80();
    public static final dd0 b = new dd0(new w2(27));

    public static dx a() {
        return (dx) b.a();
    }

    public static void b(a6 a6Var, final r80 r80Var, String str) {
        pr.j("binaryMessenger", a6Var);
        String strConcat = str.length() > 0 ? ".".concat(str) : "";
        mh mhVarH = a6Var.h();
        j1 j1Var = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setBool", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i = 6;
            j1Var.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setString", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i2 = 12;
            j1Var2.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i2) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setInt", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i3 = 13;
            j1Var3.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i3) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDouble", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i4 = 14;
            j1Var4.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i4) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setEncodedStringList", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i5 = 0;
            j1Var5.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i5) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var5.l(null);
        }
        j1 j1Var6 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.setDeprecatedStringList", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i6 = 1;
            j1Var6.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i6) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var6.l(null);
        }
        j1 j1Var7 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getString", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i7 = 2;
            j1Var7.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i7) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var7.l(null);
        }
        j1 j1Var8 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getBool", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i8 = 3;
            j1Var8.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i8) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var8.l(null);
        }
        j1 j1Var9 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getDouble", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i9 = 4;
            j1Var9.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i9) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var9.l(null);
        }
        j1 j1Var10 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getInt", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i10 = 5;
            j1Var10.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i10) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var10.l(null);
        }
        j1 j1Var11 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getPlatformEncodedStringList", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i11 = 7;
            j1Var11.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i11) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var11.l(null);
        }
        j1 j1Var12 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getStringList", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i12 = 8;
            j1Var12.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i12) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var12.l(null);
        }
        j1 j1Var13 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.clear", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i13 = 9;
            j1Var13.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i13) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var13.l(null);
        }
        j1 j1Var14 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getAll", strConcat), a(), mhVarH);
        if (r80Var != null) {
            final int i14 = 10;
            j1Var14.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i14) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        } else {
            j1Var14.l(null);
        }
        j1 j1Var15 = new j1(a6Var, za0.s("dev.flutter.pigeon.shared_preferences_android.SharedPreferencesAsyncApi.getKeys", strConcat), a(), mhVarH);
        if (r80Var == null) {
            j1Var15.l(null);
        } else {
            final int i15 = 11;
            j1Var15.l(new u5() { // from class: sensei0.p80
                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    List listA9;
                    List listA10;
                    List listA11;
                    List listA12;
                    List listA13;
                    List listA14;
                    List listA15;
                    switch (i15) {
                        case 0:
                            r80 r80Var2 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                            String str2 = (String) obj2;
                            Object obj3 = list.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                            String str3 = (String) obj3;
                            Object obj4 = list.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj4);
                            try {
                                r80Var2.r(str2, str3, (s80) obj4);
                                listA = k6.G(null);
                            } catch (Throwable th) {
                                listA = pr.a(th);
                            }
                            i3Var.s(listA);
                            break;
                        case 1:
                            r80 r80Var3 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list2 = (List) obj;
                            Object obj5 = list2.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                            String str4 = (String) obj5;
                            Object obj6 = list2.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj6);
                            List list3 = (List) obj6;
                            Object obj7 = list2.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj7);
                            try {
                                r80Var3.f(str4, list3, (s80) obj7);
                                listA2 = k6.G(null);
                            } catch (Throwable th2) {
                                listA2 = pr.a(th2);
                            }
                            i3Var.s(listA2);
                            break;
                        case 2:
                            r80 r80Var4 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                            String str5 = (String) obj8;
                            Object obj9 = list4.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj9);
                            try {
                                listA3 = k6.G(r80Var4.p(str5, (s80) obj9));
                            } catch (Throwable th3) {
                                listA3 = pr.a(th3);
                            }
                            i3Var.s(listA3);
                            break;
                        case 3:
                            r80 r80Var5 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                            String str6 = (String) obj10;
                            Object obj11 = list5.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj11);
                            try {
                                listA4 = k6.G(r80Var5.q(str6, (s80) obj11));
                            } catch (Throwable th4) {
                                listA4 = pr.a(th4);
                            }
                            i3Var.s(listA4);
                            break;
                        case 4:
                            r80 r80Var6 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list6 = (List) obj;
                            Object obj12 = list6.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                            String str7 = (String) obj12;
                            Object obj13 = list6.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj13);
                            try {
                                listA5 = k6.G(r80Var6.a(str7, (s80) obj13));
                            } catch (Throwable th5) {
                                listA5 = pr.a(th5);
                            }
                            i3Var.s(listA5);
                            break;
                        case 5:
                            r80 r80Var7 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list7 = (List) obj;
                            Object obj14 = list7.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                            String str8 = (String) obj14;
                            Object obj15 = list7.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj15);
                            try {
                                listA6 = k6.G(r80Var7.j(str8, (s80) obj15));
                            } catch (Throwable th6) {
                                listA6 = pr.a(th6);
                            }
                            i3Var.s(listA6);
                            break;
                        case 6:
                            r80 r80Var8 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list8 = (List) obj;
                            Object obj16 = list8.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                            String str9 = (String) obj16;
                            Object obj17 = list8.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Boolean", obj17);
                            boolean zBooleanValue = ((Boolean) obj17).booleanValue();
                            Object obj18 = list8.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj18);
                            try {
                                r80Var8.b(str9, zBooleanValue, (s80) obj18);
                                listA7 = k6.G(null);
                            } catch (Throwable th7) {
                                listA7 = pr.a(th7);
                            }
                            i3Var.s(listA7);
                            break;
                        case 7:
                            r80 r80Var9 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list9 = (List) obj;
                            Object obj19 = list9.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                            String str10 = (String) obj19;
                            Object obj20 = list9.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj20);
                            try {
                                listA8 = k6.G(r80Var9.k(str10, (s80) obj20));
                            } catch (Throwable th8) {
                                listA8 = pr.a(th8);
                            }
                            i3Var.s(listA8);
                            break;
                        case 8:
                            r80 r80Var10 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list10 = (List) obj;
                            Object obj21 = list10.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                            String str11 = (String) obj21;
                            Object obj22 = list10.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj22);
                            try {
                                listA9 = k6.G(r80Var10.c(str11, (s80) obj22));
                            } catch (Throwable th9) {
                                listA9 = pr.a(th9);
                            }
                            i3Var.s(listA9);
                            break;
                        case 9:
                            r80 r80Var11 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list11 = (List) obj;
                            List list12 = (List) list11.get(0);
                            Object obj23 = list11.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj23);
                            try {
                                r80Var11.o(list12, (s80) obj23);
                                listA10 = k6.G(null);
                            } catch (Throwable th10) {
                                listA10 = pr.a(th10);
                            }
                            i3Var.s(listA10);
                            break;
                        case 10:
                            r80 r80Var12 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list13 = (List) obj;
                            List list14 = (List) list13.get(0);
                            Object obj24 = list13.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj24);
                            try {
                                listA11 = k6.G(r80Var12.i(list14, (s80) obj24));
                            } catch (Throwable th11) {
                                listA11 = pr.a(th11);
                            }
                            i3Var.s(listA11);
                            break;
                        case 11:
                            r80 r80Var13 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list15 = (List) obj;
                            List list16 = (List) list15.get(0);
                            Object obj25 = list15.get(1);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj25);
                            try {
                                listA12 = k6.G(r80Var13.t(list16, (s80) obj25));
                            } catch (Throwable th12) {
                                listA12 = pr.a(th12);
                            }
                            i3Var.s(listA12);
                            break;
                        case 12:
                            r80 r80Var14 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list17 = (List) obj;
                            Object obj26 = list17.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                            String str12 = (String) obj26;
                            Object obj27 = list17.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                            String str13 = (String) obj27;
                            Object obj28 = list17.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj28);
                            try {
                                r80Var14.s(str12, str13, (s80) obj28);
                                listA13 = k6.G(null);
                            } catch (Throwable th13) {
                                listA13 = pr.a(th13);
                            }
                            i3Var.s(listA13);
                            break;
                        case 13:
                            r80 r80Var15 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list18 = (List) obj;
                            Object obj29 = list18.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                            String str14 = (String) obj29;
                            Object obj30 = list18.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Long", obj30);
                            long jLongValue = ((Long) obj30).longValue();
                            Object obj31 = list18.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj31);
                            try {
                                r80Var15.d(str14, jLongValue, (s80) obj31);
                                listA14 = k6.G(null);
                            } catch (Throwable th14) {
                                listA14 = pr.a(th14);
                            }
                            i3Var.s(listA14);
                            break;
                        default:
                            r80 r80Var16 = r80Var;
                            pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>", obj);
                            List list19 = (List) obj;
                            Object obj32 = list19.get(0);
                            pr.g("null cannot be cast to non-null type kotlin.String", obj32);
                            String str15 = (String) obj32;
                            Object obj33 = list19.get(1);
                            pr.g("null cannot be cast to non-null type kotlin.Double", obj33);
                            double dDoubleValue = ((Double) obj33).doubleValue();
                            Object obj34 = list19.get(2);
                            pr.g("null cannot be cast to non-null type io.flutter.plugins.sharedpreferences.SharedPreferencesPigeonOptions", obj34);
                            try {
                                r80Var16.l(str15, dDoubleValue, (s80) obj34);
                                listA15 = k6.G(null);
                            } catch (Throwable th15) {
                                listA15 = pr.a(th15);
                            }
                            i3Var.s(listA15);
                            break;
                    }
                }
            });
        }
    }
}
