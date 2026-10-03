package sensei0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.sensei.tunnel.R;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class o3 {
    public final int[] a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
    public final int[] b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    public final int[] c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
    public final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
    public final int[] e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
    public final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

    public static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList b(Context context, int i) {
        int iC = ge0.c(context, R.attr.colorControlHighlight);
        int iB = ge0.b(context, R.attr.colorButtonNormal);
        int[] iArr = ge0.b;
        int[] iArr2 = ge0.d;
        int iB2 = x9.b(iC, i);
        return new ColorStateList(new int[][]{iArr, iArr2, ge0.c, ge0.f}, new int[]{iB, iB2, x9.b(iC, i), i});
    }

    public static LayerDrawable c(p50 p50Var, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableC = p50Var.c(context, R.drawable.abc_star_black_48dp);
        Drawable drawableC2 = p50Var.c(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableC instanceof BitmapDrawable) && drawableC.getIntrinsicWidth() == dimensionPixelSize && drawableC.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableC;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableC.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableC.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableC2 instanceof BitmapDrawable) && drawableC2.getIntrinsicWidth() == dimensionPixelSize && drawableC2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableC2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableC2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableC2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void e(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = p3.b;
        }
        drawableMutate.setColorFilter(p3.b(i, mode));
    }

    public final ColorStateList d(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return wf0.k(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return wf0.k(context, R.color.abc_tint_switch_track);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return b(context, ge0.c(context, R.attr.colorButtonNormal));
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return b(context, 0);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return b(context, ge0.c(context, R.attr.colorAccent));
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return wf0.k(context, R.color.abc_tint_spinner);
            }
            if (a(this.b, i)) {
                return ge0.d(context, R.attr.colorControlNormal);
            }
            if (a(this.e, i)) {
                return wf0.k(context, R.color.abc_tint_default);
            }
            if (a(this.f, i)) {
                return wf0.k(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return wf0.k(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = ge0.d(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = ge0.b;
            iArr2[0] = ge0.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = ge0.e;
            iArr2[1] = ge0.c(context, R.attr.colorControlActivated);
            iArr[2] = ge0.f;
            iArr2[2] = ge0.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = ge0.b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = ge0.e;
            iArr2[1] = ge0.c(context, R.attr.colorControlActivated);
            iArr[2] = ge0.f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }
}
