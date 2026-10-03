package sensei0;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import com.sensei.tunnel.R;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class iw<S> extends eg {
    public final LinkedHashSet x;
    public final LinkedHashSet y;

    public iw() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.x = new LinkedHashSet();
        this.y = new LinkedHashSet();
    }

    public static boolean e(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(wf0.y(context, R.attr.materialCalendarStyle, fw.class.getCanonicalName()).data, new int[]{i});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    @Override // sensei0.eg, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // sensei0.eg, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }
}
