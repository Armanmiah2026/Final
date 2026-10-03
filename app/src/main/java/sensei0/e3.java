package sensei0;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import io.flutter.plugins.urllauncher.WebViewActivity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e3 {
    public static float a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static float b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    public static boolean c(File file, File file2) {
        try {
            Files.move(file.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static Intent d(WebViewActivity webViewActivity, r70 r70Var, IntentFilter intentFilter) {
        return webViewActivity.registerReceiver(r70Var, intentFilter, null, null, 0);
    }

    public static Intent e(WebViewActivity webViewActivity, r70 r70Var, IntentFilter intentFilter) {
        return webViewActivity.registerReceiver(r70Var, intentFilter, null, null, 2);
    }

    public static void f(MenuItem menuItem, char c, int i) {
        menuItem.setAlphabeticShortcut(c, i);
    }

    public static void g(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setContentDescription(charSequence);
    }

    public static void h(MenuItem menuItem, ColorStateList colorStateList) {
        menuItem.setIconTintList(colorStateList);
    }

    public static void i(MenuItem menuItem, PorterDuff.Mode mode) {
        menuItem.setIconTintMode(mode);
    }

    public static void j(MenuItem menuItem, char c, int i) {
        menuItem.setNumericShortcut(c, i);
    }

    public static void k(MenuItem menuItem, CharSequence charSequence) {
        menuItem.setTooltipText(charSequence);
    }
}
