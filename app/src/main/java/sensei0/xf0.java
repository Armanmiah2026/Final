package sensei0;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xf0 {
    public static final pr a;
    public static final ev b;
    public static Paint c;

    static {
        Trace.beginSection(mm0.l0("TypefaceCompat static init"));
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            a = new dg0();
        } else if (i >= 29) {
            a = new cg0();
        } else if (i >= 28) {
            a = new bg0();
        } else if (i >= 26) {
            a = new ag0();
        } else {
            Method method = zf0.p;
            if (method == null) {
                Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
            }
            if (method != null) {
                a = new zf0();
            } else {
                a = new yf0();
            }
        }
        b = new ev(16);
        c = null;
        Trace.endSection();
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e6, code lost:
    
        r7 = r12.build();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface a(android.content.Context r16, sensei0.fo r17, android.content.res.Resources r18, int r19, java.lang.String r20, int r21, int r22, sensei0.pr r23, boolean r24) {
        /*
            Method dump skipped, instruction units count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.xf0.a(android.content.Context, sensei0.fo, android.content.res.Resources, int, java.lang.String, int, int, sensei0.pr, boolean):android.graphics.Typeface");
    }

    public static String b(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Typeface c(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    public static Font d(Typeface typeface) {
        if (c == null) {
            c = new Paint();
        }
        c.setTextSize(10.0f);
        c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
