package sensei0;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v20 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Context b;

    public /* synthetic */ v20(Context context, int i) {
        this.a = i;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                (Build.VERSION.SDK_INT >= 28 ? y20.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new v20(this.b, 1), new Random().nextInt(Math.max(1000, 1)) + 5000);
                break;
            case 1:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new v20(this.b, 2));
                break;
            default:
                mm0.r0(this.b, new t20(), mm0.e, false);
                break;
        }
    }

    public /* synthetic */ v20(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.a = 0;
        this.b = context;
    }
}
