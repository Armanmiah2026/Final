package sensei0;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ji extends sh {
    public final /* synthetic */ int a = 0;
    public final WeakReference b;

    public ji(EditText editText) {
        this.b = new WeakReference(editText);
    }

    @Override // sensei0.sh
    public void a() {
        switch (this.a) {
            case 1:
                SwitchCompat switchCompat = (SwitchCompat) this.b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    @Override // sensei0.sh
    public final void b() {
        switch (this.a) {
            case 0:
                ki.a((EditText) this.b.get(), 1);
                break;
            default:
                SwitchCompat switchCompat = (SwitchCompat) this.b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                }
                break;
        }
    }

    public ji(SwitchCompat switchCompat) {
        this.b = new WeakReference(switchCompat);
    }
}
