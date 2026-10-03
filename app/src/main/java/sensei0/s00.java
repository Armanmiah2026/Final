package sensei0;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s00 implements v5 {
    public final /* synthetic */ int a;
    public final /* synthetic */ fp b;

    public /* synthetic */ s00(fp fpVar, int i) {
        this.a = i;
        this.b = fpVar;
    }

    @Override // sensei0.v5
    public final void s(Object obj) {
        u50 u50VarA;
        u50 u50VarA2;
        u50 u50VarA3;
        u50 u50VarA4;
        u50 u50VarA5;
        u50 u50VarA6;
        u50 u50VarA7;
        u50 u50VarA8;
        u50 u50VarA9;
        u50 u50VarA10;
        u50 u50VarA11;
        u50 u50VarA12;
        u50 u50VarA13;
        u50 u50VarA14;
        u50 u50VarA15;
        switch (this.a) {
            case 0:
                boolean z = obj instanceof List;
                fp fpVar = this.b;
                if (z) {
                    List list = (List) obj;
                    if (list.size() <= 1) {
                        fpVar.g(new v50(mg0.a));
                    } else {
                        Object obj2 = list.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                        Object obj3 = list.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                        u50VarA = wf0.i(new t2((String) obj2, (String) obj3, (String) list.get(2)));
                    }
                } else {
                    u50VarA = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.urlLoading'.", "");
                }
                sd0.b(u50VarA, fpVar);
                break;
            case 1:
                boolean z2 = obj instanceof List;
                fp fpVar2 = this.b;
                if (z2) {
                    List list2 = (List) obj;
                    if (list2.size() <= 1) {
                        fpVar2.g(new v50(mg0.a));
                    } else {
                        Object obj4 = list2.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                        Object obj5 = list2.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                        u50VarA2 = wf0.i(new t2((String) obj4, (String) obj5, (String) list2.get(2)));
                    }
                } else {
                    u50VarA2 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.doUpdateVisitedHistory'.", "");
                }
                sd0.b(u50VarA2, fpVar2);
                break;
            case 2:
                boolean z3 = obj instanceof List;
                fp fpVar3 = this.b;
                if (z3) {
                    List list3 = (List) obj;
                    if (list3.size() <= 1) {
                        fpVar3.g(new v50(mg0.a));
                    } else {
                        Object obj6 = list3.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                        Object obj7 = list3.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj7);
                        u50VarA3 = wf0.i(new t2((String) obj6, (String) obj7, (String) list3.get(2)));
                    }
                } else {
                    u50VarA3 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpError'.", "");
                }
                sd0.b(u50VarA3, fpVar3);
                break;
            case 3:
                boolean z4 = obj instanceof List;
                fp fpVar4 = this.b;
                if (z4) {
                    List list4 = (List) obj;
                    if (list4.size() <= 1) {
                        fpVar4.g(new v50(mg0.a));
                    } else {
                        Object obj8 = list4.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj8);
                        Object obj9 = list4.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj9);
                        u50VarA4 = wf0.i(new t2((String) obj8, (String) obj9, (String) list4.get(2)));
                    }
                } else {
                    u50VarA4 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onLoadResource'.", "");
                }
                sd0.b(u50VarA4, fpVar4);
                break;
            case 4:
                boolean z5 = obj instanceof List;
                fp fpVar5 = this.b;
                if (z5) {
                    List list5 = (List) obj;
                    if (list5.size() <= 1) {
                        fpVar5.g(new v50(mg0.a));
                    } else {
                        Object obj10 = list5.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                        Object obj11 = list5.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj11);
                        u50VarA5 = wf0.i(new t2((String) obj10, (String) obj11, (String) list5.get(2)));
                    }
                } else {
                    u50VarA5 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedLoginRequest'.", "");
                }
                sd0.b(u50VarA5, fpVar5);
                break;
            case 5:
                boolean z6 = obj instanceof List;
                fp fpVar6 = this.b;
                if (z6) {
                    List list6 = (List) obj;
                    if (list6.size() <= 1) {
                        fpVar6.g(new v50(mg0.a));
                    } else {
                        Object obj12 = list6.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj12);
                        Object obj13 = list6.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj13);
                        u50VarA6 = wf0.i(new t2((String) obj12, (String) obj13, (String) list6.get(2)));
                    }
                } else {
                    u50VarA6 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageStarted'.", "");
                }
                sd0.b(u50VarA6, fpVar6);
                break;
            case 6:
                boolean z7 = obj instanceof List;
                fp fpVar7 = this.b;
                if (z7) {
                    List list7 = (List) obj;
                    if (list7.size() <= 1) {
                        fpVar7.g(new v50(mg0.a));
                    } else {
                        Object obj14 = list7.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj14);
                        Object obj15 = list7.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj15);
                        u50VarA7 = wf0.i(new t2((String) obj14, (String) obj15, (String) list7.get(2)));
                    }
                } else {
                    u50VarA7 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedClientCertRequest'.", "");
                }
                sd0.b(u50VarA7, fpVar7);
                break;
            case 7:
                boolean z8 = obj instanceof List;
                fp fpVar8 = this.b;
                if (z8) {
                    List list8 = (List) obj;
                    if (list8.size() <= 1) {
                        fpVar8.g(new v50(mg0.a));
                    } else {
                        Object obj16 = list8.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj16);
                        Object obj17 = list8.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj17);
                        u50VarA8 = wf0.i(new t2((String) obj16, (String) obj17, (String) list8.get(2)));
                    }
                } else {
                    u50VarA8 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.requestLoading'.", "");
                }
                sd0.b(u50VarA8, fpVar8);
                break;
            case 8:
                boolean z9 = obj instanceof List;
                fp fpVar9 = this.b;
                if (z9) {
                    List list9 = (List) obj;
                    if (list9.size() <= 1) {
                        fpVar9.g(new v50(mg0.a));
                    } else {
                        Object obj18 = list9.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj18);
                        Object obj19 = list9.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj19);
                        u50VarA9 = wf0.i(new t2((String) obj18, (String) obj19, (String) list9.get(2)));
                    }
                } else {
                    u50VarA9 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageCommitVisible'.", "");
                }
                sd0.b(u50VarA9, fpVar9);
                break;
            case 9:
                boolean z10 = obj instanceof List;
                fp fpVar10 = this.b;
                if (z10) {
                    List list10 = (List) obj;
                    if (list10.size() <= 1) {
                        fpVar10.g(new v50(mg0.a));
                    } else {
                        Object obj20 = list10.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj20);
                        Object obj21 = list10.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj21);
                        u50VarA10 = wf0.i(new t2((String) obj20, (String) obj21, (String) list10.get(2)));
                    }
                } else {
                    u50VarA10 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onPageFinished'.", "");
                }
                sd0.b(u50VarA10, fpVar10);
                break;
            case 10:
                boolean z11 = obj instanceof List;
                fp fpVar11 = this.b;
                if (z11) {
                    List list11 = (List) obj;
                    if (list11.size() <= 1) {
                        fpVar11.g(new v50(mg0.a));
                    } else {
                        Object obj22 = list11.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj22);
                        Object obj23 = list11.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj23);
                        u50VarA11 = wf0.i(new t2((String) obj22, (String) obj23, (String) list11.get(2)));
                    }
                } else {
                    u50VarA11 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedError'.", "");
                }
                sd0.b(u50VarA11, fpVar11);
                break;
            case 11:
                boolean z12 = obj instanceof List;
                fp fpVar12 = this.b;
                if (z12) {
                    List list12 = (List) obj;
                    if (list12.size() <= 1) {
                        fpVar12.g(new v50(mg0.a));
                    } else {
                        Object obj24 = list12.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj24);
                        Object obj25 = list12.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj25);
                        u50VarA12 = wf0.i(new t2((String) obj24, (String) obj25, (String) list12.get(2)));
                    }
                } else {
                    u50VarA12 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedHttpAuthRequest'.", "");
                }
                sd0.b(u50VarA12, fpVar12);
                break;
            case 12:
                boolean z13 = obj instanceof List;
                fp fpVar13 = this.b;
                if (z13) {
                    List list13 = (List) obj;
                    if (list13.size() <= 1) {
                        fpVar13.g(new v50(mg0.a));
                    } else {
                        Object obj26 = list13.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj26);
                        Object obj27 = list13.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj27);
                        u50VarA13 = wf0.i(new t2((String) obj26, (String) obj27, (String) list13.get(2)));
                    }
                } else {
                    u50VarA13 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onFormResubmission'.", "");
                }
                sd0.b(u50VarA13, fpVar13);
                break;
            case 13:
                boolean z14 = obj instanceof List;
                fp fpVar14 = this.b;
                if (z14) {
                    List list14 = (List) obj;
                    if (list14.size() <= 1) {
                        fpVar14.g(new v50(mg0.a));
                    } else {
                        Object obj28 = list14.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj28);
                        Object obj29 = list14.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj29);
                        u50VarA14 = wf0.i(new t2((String) obj28, (String) obj29, (String) list14.get(2)));
                    }
                } else {
                    u50VarA14 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onReceivedSslError'.", "");
                }
                sd0.b(u50VarA14, fpVar14);
                break;
            default:
                boolean z15 = obj instanceof List;
                fp fpVar15 = this.b;
                if (z15) {
                    List list15 = (List) obj;
                    if (list15.size() <= 1) {
                        fpVar15.g(new v50(mg0.a));
                    } else {
                        Object obj30 = list15.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj30);
                        Object obj31 = list15.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj31);
                        u50VarA15 = wf0.i(new t2((String) obj30, (String) obj31, (String) list15.get(2)));
                    }
                } else {
                    u50VarA15 = sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebViewClient.onScaleChanged'.", "");
                }
                sd0.b(u50VarA15, fpVar15);
                break;
        }
    }
}
