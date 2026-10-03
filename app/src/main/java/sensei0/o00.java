package sensei0;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o00 implements v5 {
    public final /* synthetic */ int a;
    public final /* synthetic */ f b;

    public /* synthetic */ o00(f fVar, int i) {
        this.a = i;
        this.b = fVar;
    }

    @Override // sensei0.v5
    public final void s(Object obj) {
        switch (this.a) {
            case 0:
                fp fpVar = (fp) this.b.b;
                if (!(obj instanceof List)) {
                    fpVar.g(new w50(sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt'.", "")));
                } else {
                    List list = (List) obj;
                    if (list.size() <= 1) {
                        fpVar.g(new w50((String) list.get(0)));
                    } else {
                        Object obj2 = list.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj2);
                        Object obj3 = list.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj3);
                        fpVar.g(new w50(wf0.i(new t2((String) obj2, (String) obj3, (String) list.get(2)))));
                    }
                }
                break;
            case 1:
                fp fpVar2 = (fp) this.b.b;
                if (!(obj instanceof List)) {
                    fpVar2.g(new w50(sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert'.", "")));
                } else {
                    List list2 = (List) obj;
                    if (list2.size() <= 1) {
                        fpVar2.g(new w50(mg0.a));
                    } else {
                        Object obj4 = list2.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj4);
                        Object obj5 = list2.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj5);
                        fpVar2.g(new w50(wf0.i(new t2((String) obj4, (String) obj5, (String) list2.get(2)))));
                    }
                }
                break;
            case 2:
                fp fpVar3 = (fp) this.b.b;
                if (!(obj instanceof List)) {
                    fpVar3.g(new w50(sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser'.", "")));
                } else {
                    List list3 = (List) obj;
                    if (list3.size() > 1) {
                        Object obj6 = list3.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj6);
                        Object obj7 = list3.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj7);
                        fpVar3.g(new w50(wf0.i(new t2((String) obj6, (String) obj7, (String) list3.get(2)))));
                    } else if (list3.get(0) != null) {
                        Object obj8 = list3.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>", obj8);
                        fpVar3.g(new w50((List) obj8));
                    } else {
                        fpVar3.g(new w50(sd0.a("null-error", "Flutter api returned null value for non-null return value.", "")));
                    }
                }
                break;
            default:
                fp fpVar4 = (fp) this.b.b;
                if (!(obj instanceof List)) {
                    fpVar4.g(new w50(sd0.a("channel-error", "Unable to establish connection on channel: 'dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm'.", "")));
                } else {
                    List list4 = (List) obj;
                    if (list4.size() > 1) {
                        Object obj9 = list4.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj9);
                        Object obj10 = list4.get(1);
                        pr.g("null cannot be cast to non-null type kotlin.String", obj10);
                        fpVar4.g(new w50(wf0.i(new t2((String) obj9, (String) obj10, (String) list4.get(2)))));
                    } else if (list4.get(0) != null) {
                        Object obj11 = list4.get(0);
                        pr.g("null cannot be cast to non-null type kotlin.Boolean", obj11);
                        fpVar4.g(new w50((Boolean) obj11));
                    } else {
                        fpVar4.g(new w50(sd0.a("null-error", "Flutter api returned null value for non-null return value.", "")));
                    }
                }
                break;
        }
    }
}
