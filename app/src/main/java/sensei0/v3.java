package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class v3 extends ImageView {
    public final k3 a;
    public final u3 b;
    public boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v3(Context context, int i) {
        super(context, null, i);
        me0.a(context);
        this.c = false;
        ge0.a(this, getContext());
        k3 k3Var = new k3(this);
        this.a = k3Var;
        k3Var.d(null, i);
        u3 u3Var = new u3(this);
        this.b = u3Var;
        u3Var.c(null, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.a();
        }
        u3 u3Var = this.b;
        if (u3Var != null) {
            u3Var.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        k3 k3Var = this.a;
        if (k3Var != null) {
            return k3Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        k3 k3Var = this.a;
        if (k3Var != null) {
            return k3Var.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        r60 r60Var;
        u3 u3Var = this.b;
        if (u3Var == null || (r60Var = (r60) u3Var.c) == null) {
            return null;
        }
        return (ColorStateList) r60Var.c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        r60 r60Var;
        u3 u3Var = this.b;
        if (u3Var == null || (r60Var = (r60) u3Var.c) == null) {
            return null;
        }
        return (PorterDuff.Mode) r60Var.d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.b.b).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.f(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        u3 u3Var = this.b;
        if (u3Var != null) {
            u3Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        u3 u3Var = this.b;
        if (u3Var != null && drawable != null && !this.c) {
            u3Var.a = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (u3Var != null) {
            u3Var.a();
            if (this.c) {
                return;
            }
            ImageView imageView = (ImageView) u3Var.b;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(u3Var.a);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        u3 u3Var = this.b;
        if (u3Var != null) {
            ImageView imageView = (ImageView) u3Var.b;
            if (i != 0) {
                Drawable drawableM = wf0.m(imageView.getContext(), i);
                if (drawableM != null) {
                    ah.a(drawableM);
                }
                imageView.setImageDrawable(drawableM);
            } else {
                imageView.setImageDrawable(null);
            }
            u3Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        u3 u3Var = this.b;
        if (u3Var != null) {
            u3Var.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        k3 k3Var = this.a;
        if (k3Var != null) {
            k3Var.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        u3 u3Var = this.b;
        if (u3Var != null) {
            if (((r60) u3Var.c) == null) {
                u3Var.c = new r60();
            }
            r60 r60Var = (r60) u3Var.c;
            r60Var.c = colorStateList;
            r60Var.b = true;
            u3Var.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        u3 u3Var = this.b;
        if (u3Var != null) {
            if (((r60) u3Var.c) == null) {
                u3Var.c = new r60();
            }
            r60 r60Var = (r60) u3Var.c;
            r60Var.d = mode;
            r60Var.a = true;
            u3Var.a();
        }
    }
}
