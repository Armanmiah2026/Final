package sensei0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.sensei.tunnel.SenseiTunnelVpnService;
import io.flutter.plugins.urllauncher.WebViewActivity;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class r70 extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ ContextWrapper b;

    public /* synthetic */ r70(ContextWrapper contextWrapper, int i) {
        this.a = i;
        this.b = contextWrapper;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                String action = intent != null ? intent.getAction() : null;
                if (action != null) {
                    int iHashCode = action.hashCode();
                    if (iHashCode != -1454123155) {
                        if (iHashCode != 870701415 || !action.equals("android.os.action.DEVICE_IDLE_MODE_CHANGED")) {
                        }
                    } else if (!action.equals("android.intent.action.SCREEN_ON")) {
                    }
                    ((SenseiTunnelVpnService) this.b).B0 = true;
                }
                break;
            default:
                if ("close action".equals(intent.getAction())) {
                    ((WebViewActivity) this.b).finish();
                }
                break;
        }
    }
}
