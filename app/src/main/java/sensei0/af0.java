package sensei0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.sensei.tunnel.R;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class af0 {
    public final Context a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;

    public af0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.d = layoutParams;
        this.e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        this.a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.b = viewInflate;
        this.c = (TextView) viewInflate.findViewById(R.id.message);
        layoutParams.setTitle(af0.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public af0(Activity activity, nt ntVar) {
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = new HashSet();
        this.f = new HashSet();
        new HashSet();
        this.g = new HashSet();
        this.a = activity;
        this.b = new HiddenLifecycleReference(ntVar);
    }
}
