package sensei0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class yf0 extends pr {
    public static Class n = null;
    public static Constructor o = null;
    public static Method p = null;
    public static Method q = null;
    public static boolean r = false;

    public static boolean c0(Object obj, String str, int i, boolean z) throws NoSuchMethodException {
        d0();
        try {
            return ((Boolean) p.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void d0() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (r) {
            return;
        }
        r = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        o = constructor;
        n = cls;
        p = method2;
        q = method;
    }

    @Override // sensei0.pr
    public Typeface n(Context context, go goVar, Resources resources, int i) throws NoSuchMethodException {
        d0();
        try {
            Object objNewInstance = o.newInstance(null);
            for (ho hoVar : goVar.a) {
                File fileN = wf0.n(context);
                if (fileN == null) {
                    return null;
                }
                try {
                    if (!wf0.g(fileN, resources, hoVar.f)) {
                        return null;
                    }
                    if (!c0(objNewInstance, fileN.getPath(), hoVar.b, hoVar.c)) {
                        return null;
                    }
                    fileN.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileN.delete();
                }
            }
            d0();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) n, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) q.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // sensei0.pr
    public Typeface o(Context context, jo[] joVarArr, int i) {
        String str;
        if (joVarArr.length >= 1) {
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(w(joVarArr, i).a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        try {
                            str = Os.readlink("/proc/self/fd/" + parcelFileDescriptorOpenFileDescriptor.getFd());
                        } finally {
                        }
                    } catch (ErrnoException unused) {
                    }
                    File file = OsConstants.S_ISREG(Os.stat(str).st_mode) ? new File(str) : null;
                    if (file != null && file.canRead()) {
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceCreateFromFile;
                    }
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        Typeface typefaceQ = q(context, fileInputStream);
                        fileInputStream.close();
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return typefaceQ;
                    } finally {
                    }
                }
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return null;
                }
            } catch (IOException unused2) {
            }
        }
        return null;
    }
}
