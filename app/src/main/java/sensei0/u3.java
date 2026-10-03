package sensei0;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class u3 {
    public int a = 0;
    public KeyEvent.Callback b;
    public Object c;

    public u3(ImageView imageView) {
        this.b = imageView;
    }

    public void a() {
        r60 r60Var;
        ImageView imageView = (ImageView) this.b;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            ah.a(drawable);
        }
        if (drawable == null || (r60Var = (r60) this.c) == null) {
            return;
        }
        p3.d(drawable, r60Var, imageView.getDrawableState());
    }

    public int b() {
        int i = this.a;
        if (Build.VERSION.SDK_INT < 35) {
            return 2;
        }
        View viewFindViewById = ((Activity) this.b).findViewById(i);
        if (viewFindViewById != null) {
            return viewFindViewById.getContentSensitivity();
        }
        throw new IllegalArgumentException(za0.i(i, "FlutterView with ID ", "not found"));
    }

    public void c(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.b;
        Context context = imageView.getContext();
        int[] iArr = p30.e;
        o4 o4VarQ = o4.Q(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) o4VarQ.b;
        ai0.j(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) o4VarQ.b, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = wf0.m(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                ah.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(o4VarQ.E(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(ah.c(typedArray.getInt(3, -1), null));
            }
            o4VarQ.V();
        } catch (Throwable th) {
            o4VarQ.V();
            throw th;
        }
    }

    public void d(int i) {
        int i2 = this.a;
        if (Build.VERSION.SDK_INT < 35) {
            throw new IllegalStateException("isSupported() should be called before attempting to set content sensitivity as it is not supported on this device.");
        }
        View viewFindViewById = ((Activity) this.b).findViewById(i2);
        if (viewFindViewById == null) {
            throw new IllegalArgumentException(za0.i(i2, "FlutterView with ID ", "not found"));
        }
        if (viewFindViewById.getContentSensitivity() == i) {
            return;
        }
        viewFindViewById.setContentSensitivity(i);
        viewFindViewById.invalidate();
    }
}
