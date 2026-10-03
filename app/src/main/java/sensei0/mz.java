package sensei0;

import android.graphics.Path;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class mz implements u20, z60 {
    public static mz b;
    public final /* synthetic */ int a;

    public /* synthetic */ mz(int i) {
        this.a = i;
    }

    public static Path e(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        return path;
    }

    public static void i(WebSettings webSettings, boolean z) {
        fb0 sj0Var;
        if (!gk0.d.b()) {
            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
        }
        try {
            sj0Var = new fb0((WebSettingsBoundaryInterface) k6.d(WebSettingsBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) ik0.a.a).convertSettings(webSettings)));
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 30 || !"android.webkit.WebSettingsWrapper".equals(webSettings.getClass().getCanonicalName())) {
                throw e;
            }
            Log.e("WebSettingsCompat", "Error converting WebSettings to Chrome implementation. All AndroidX method calls on this WebSettings instance will be no-op calls. See https://crbug.com/388824130 for more info.", e);
            sj0Var = new sj0(null);
        }
        sj0Var.d(z);
    }

    public o60 a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @Override // sensei0.u20
    public void b() {
        switch (this.a) {
            case 2:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    @Override // sensei0.u20
    public void c(int i, Object obj) {
        String str;
        switch (this.a) {
            case 2:
                break;
            default:
                switch (i) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i == 6 || i == 7 || i == 8) {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                } else {
                    Log.d("ProfileInstaller", str);
                }
                break;
        }
    }

    public o60 d(Class cls, ey eyVar) {
        return new o60();
    }

    public boolean f(CharSequence charSequence) {
        return false;
    }

    public /* synthetic */ mz(View view, int i) {
        this.a = i;
    }

    public mz(View view) {
        this.a = 13;
        if (Build.VERSION.SDK_INT >= 30) {
            new ya0(view, 12);
        } else {
            new mz(view, 12);
        }
    }

    public mz(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.a = 16;
    }

    private final void g() {
    }

    private final void h(int i, Object obj) {
    }

    @Override // sensei0.z60
    public void onScrollLimit(int i, int i2, int i3, boolean z) {
    }

    @Override // sensei0.z60
    public void onScrollProgress(int i, int i2, int i3, int i4) {
    }
}
