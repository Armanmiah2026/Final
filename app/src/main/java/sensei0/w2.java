package sensei0;

import android.content.Intent;
import android.net.Uri;
import com.sensei.tunnel.MainActivity;
import com.trilead.ssh2.sftp.ErrorCodes;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w2 implements uo {
    public final /* synthetic */ int a;

    public /* synthetic */ w2(int i) {
        this.a = i;
    }

    @Override // sensei0.uo
    public final Object a() {
        switch (this.a) {
            case 0:
                return new lx(3);
            case 1:
                boolean z = MainActivity.B;
                return new Intent("android.intent.action.DIAL", Uri.parse("tel:*#*#4636#*#*"));
            case 2:
                boolean z2 = MainActivity.B;
                return new Intent("android.intent.action.DIAL", Uri.parse("tel:*#*#3646633#*#*"));
            case 3:
                boolean z3 = MainActivity.B;
                Intent className = new Intent().setClassName("com.samsung.android.app.telephonyui", "com.samsung.android.app.telephonyui.hiddennetworksetting.MainActivity");
                pr.i("setClassName(...)", className);
                return className;
            case 4:
                boolean z4 = MainActivity.B;
                Intent className2 = new Intent().setClassName("com.sec.android.RilServiceModeApp", "com.sec.android.RilServiceModeApp.ServiceModeApp");
                pr.i("setClassName(...)", className2);
                return className2;
            case 5:
                boolean z5 = MainActivity.B;
                Intent className3 = new Intent().setClassName("com.android.phone", "com.android.phone.settings.OperatorsSettingsActivity");
                pr.i("setClassName(...)", className3);
                return className3;
            case 6:
                boolean z6 = MainActivity.B;
                Intent className4 = new Intent().setClassName("com.android.settings", "com.android.settings.Settings$NetworkDashboardActivity");
                pr.i("setClassName(...)", className4);
                return className4;
            case 7:
                boolean z7 = MainActivity.B;
                return new Intent("android.settings.WIRELESS_SETTINGS");
            case 8:
                boolean z8 = MainActivity.B;
                return new Intent("android.settings.SETTINGS");
            case 9:
                boolean z9 = MainActivity.B;
                Intent className5 = new Intent().setClassName("com.android.phone", "com.android.phone.settings.RadioInfo");
                pr.i("setClassName(...)", className5);
                return className5;
            case 10:
                boolean z10 = MainActivity.B;
                Intent className6 = new Intent().setClassName("com.android.settings", "com.android.settings.Settings$TestingSettingsActivity");
                pr.i("setClassName(...)", className6);
                return className6;
            case 11:
                boolean z11 = MainActivity.B;
                Intent className7 = new Intent().setClassName("com.android.settings", "com.android.settings.RadioInfo");
                pr.i("setClassName(...)", className7);
                return className7;
            case 12:
                boolean z12 = MainActivity.B;
                Intent className8 = new Intent().setClassName("com.android.settings", "com.android.settings.TestingSettings");
                pr.i("setClassName(...)", className8);
                return className8;
            case 13:
                boolean z13 = MainActivity.B;
                Intent className9 = new Intent().setClassName("com.android.settings", "com.android.settings.Settings$MobileNetworkListActivity");
                pr.i("setClassName(...)", className9);
                return className9;
            case 14:
                boolean z14 = MainActivity.B;
                Intent className10 = new Intent().setClassName("com.android.settings", "com.android.settings.Settings$MobileNetworkActivity");
                pr.i("setClassName(...)", className10);
                return className10;
            case 15:
                boolean z15 = MainActivity.B;
                return new Intent("android.settings.MOBILE_NETWORK_SETTINGS");
            case 16:
                boolean z16 = MainActivity.B;
                return new Intent("android.settings.NETWORK_OPERATOR_SETTINGS");
            case 17:
                boolean z17 = MainActivity.B;
                Intent className11 = new Intent().setClassName("com.android.settings", "com.android.settings.Settings$NetworkDashboardActivity");
                pr.i("setClassName(...)", className11);
                return className11;
            case 18:
                boolean z18 = MainActivity.B;
                return new Intent("android.settings.APN_SETTINGS");
            case 19:
                boolean z19 = MainActivity.B;
                Intent className12 = new Intent().setClassName("com.android.settings", "com.android.settings.Settings$MobileNetworkListActivity");
                pr.i("setClassName(...)", className12);
                return className12;
            case 20:
                boolean z20 = MainActivity.B;
                return new Intent("android.settings.MOBILE_NETWORK_SETTINGS");
            case 21:
                boolean z21 = MainActivity.B;
                return new Intent("android.settings.NETWORK_OPERATOR_SETTINGS");
            case ErrorCodes.SSH_FX_CANNOT_DELETE /* 22 */:
                boolean z22 = MainActivity.B;
                return new Intent("android.settings.DATA_ROAMING_SETTINGS");
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                boolean z23 = MainActivity.B;
                return new Intent("android.settings.DATA_USAGE_SETTINGS");
            case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                boolean z24 = MainActivity.B;
                Intent className13 = new Intent().setClassName("com.android.settings", "com.android.settings.Settings$NetworkDashboardActivity");
                pr.i("setClassName(...)", className13);
                return className13;
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                boolean z25 = MainActivity.B;
                return new Intent("android.settings.WIRELESS_SETTINGS");
            case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                boolean z26 = MainActivity.B;
                return new Intent("android.settings.SETTINGS");
            default:
                return new lx(4);
        }
    }
}
