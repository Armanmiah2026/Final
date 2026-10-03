package sensei0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class cg0 extends pr {
    public static Font c0(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iF0 = f0(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int iF02 = f0(fontStyle, font2.getStyle());
            if (iF02 < iF0) {
                font = font2;
                iF0 = iF02;
            }
        }
        return font;
    }

    public static int f0(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    public final FontFamily d0(jo[] joVarArr, ContentResolver contentResolver) {
        Font fontBuild;
        String str;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FontFamily.Builder builder = null;
        for (jo joVar : joVarArr) {
            if (Objects.equals(joVar.a.getScheme(), "systemfont")) {
                fontBuild = e0(joVar);
            } else {
                try {
                    Uri uri = joVar.a;
                    str = joVar.e;
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
                    fontBuild = null;
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    fontBuild = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(joVar.c).setSlant(joVar.d ? 1 : 0).setTtcIndex(joVar.b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        fontBuild = ttcIndex.build();
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
            if (fontBuild != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(fontBuild);
                } else {
                    builder.addFont(fontBuild);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font e0(jo joVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    @Override // sensei0.pr
    public final Typeface n(Context context, go goVar, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (ho hoVar : goVar.a) {
                try {
                    Font fontBuild = new Font.Builder(resources, hoVar.f).setWeight(hoVar.b).setSlant(hoVar.c ? 1 : 0).setTtcIndex(hoVar.e).setFontVariationSettings(hoVar.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(c0(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // sensei0.pr
    public final Typeface o(Context context, jo[] joVarArr, int i) {
        try {
            FontFamily fontFamilyD0 = d0(joVarArr, context.getContentResolver());
            if (fontFamilyD0 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyD0).setStyle(c0(fontFamilyD0, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // sensei0.pr
    public final Typeface p(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyD0 = d0((jo[]) list.get(0), contentResolver);
            if (fontFamilyD0 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyD0);
            for (int i2 = 1; i2 < list.size(); i2++) {
                FontFamily fontFamilyD02 = d0((jo[]) list.get(i2), contentResolver);
                if (fontFamilyD02 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyD02);
                }
            }
            return customFallbackBuilder.setStyle(c0(fontFamilyD0, i).getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // sensei0.pr
    public final Typeface q(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // sensei0.pr
    public final Typeface r(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e);
            return null;
        }
    }

    @Override // sensei0.pr
    public final jo w(jo[] joVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
