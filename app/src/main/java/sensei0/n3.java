package sensei0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class n3 {
    public boolean a;
    public boolean b;
    public boolean c;
    public Object d;
    public Object e;
    public Object f;

    public static HashMap b(byte[] bArr) {
        HashMap map = new HashMap();
        map.put("enabled", Boolean.TRUE);
        map.put("data", bArr);
        return map;
    }

    public void a() {
        m3 m3Var = (m3) this.d;
        Drawable buttonDrawable = m3Var.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.a || this.b) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.a) {
                    drawableMutate.setTintList((ColorStateList) this.e);
                }
                if (this.b) {
                    drawableMutate.setTintMode((PorterDuff.Mode) this.f);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(m3Var.getDrawableState());
                }
                m3Var.setButtonDrawable(drawableMutate);
            }
        }
    }
}
