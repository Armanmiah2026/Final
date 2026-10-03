package sensei0;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.view.DisplayCutout;
import android.view.ViewConfiguration;
import android.widget.TextView;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tb {
    public static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static Executor b(Context context) {
        return context.getMainExecutor();
    }

    public static int c(Object obj) {
        return ((Icon) obj).getResId();
    }

    public static int d(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    public static int e(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    public static int f(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    public static int g(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }

    public static int h(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    public static PrecomputedText.Params i(i4 i4Var) {
        return i4Var.getTextMetricsParams();
    }

    public static void j(TextView textView, int i) {
        textView.setFirstBaselineToTopHeight(i);
    }

    public static boolean k(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
