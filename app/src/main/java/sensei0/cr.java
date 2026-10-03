package sensei0;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class cr extends InputConnectionWrapper {
    public final /* synthetic */ x2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr(InputConnection inputConnection, x2 x2Var) {
        super(inputConnection, false);
        this.a = x2Var;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        sv svVar = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            svVar = new sv(29, new er(inputContentInfo));
        }
        if (this.a.a(svVar, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
