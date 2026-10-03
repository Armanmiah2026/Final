package sensei0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zf0 extends pr {
    public static final Class n;
    public static final Constructor o;
    public static final Method p;
    public static final Method q;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        o = constructor;
        n = cls;
        p = method2;
        q = method;
    }

    public static boolean c0(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) p.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface d0(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) n, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) q.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // sensei0.pr
    public final Typeface n(Context context, go goVar, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        MappedByteBuffer map;
        FileInputStream fileInputStream;
        try {
            objNewInstance = o.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            for (ho hoVar : goVar.a) {
                int i2 = hoVar.f;
                File fileN = wf0.n(context);
                if (fileN != null) {
                    try {
                        if (wf0.g(fileN, resources, i2)) {
                            try {
                                fileInputStream = new FileInputStream(fileN);
                            } catch (IOException unused2) {
                                map = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (map != null && c0(objNewInstance, map, hoVar.e, hoVar.b, hoVar.c)) {
                                }
                            } finally {
                            }
                        }
                    } finally {
                        fileN.delete();
                    }
                }
                map = null;
                if (map != null) {
                }
            }
            return d0(objNewInstance);
        }
        return null;
    }

    @Override // sensei0.pr
    public final Typeface o(Context context, jo[] joVarArr, int i) {
        Object objNewInstance;
        try {
            objNewInstance = o.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            int i2 = 0;
            ka0 ka0Var = new ka0(0);
            int length = joVarArr.length;
            while (true) {
                if (i2 < length) {
                    jo joVar = joVarArr[i2];
                    Uri uri = joVar.a;
                    ByteBuffer byteBufferR = (ByteBuffer) ka0Var.get(uri);
                    if (byteBufferR == null) {
                        byteBufferR = wf0.r(context, uri);
                        ka0Var.put(uri, byteBufferR);
                    }
                    if (byteBufferR == null || !c0(objNewInstance, byteBufferR, joVar.b, joVar.c, joVar.d)) {
                        break;
                    }
                    i2++;
                } else {
                    Typeface typefaceD0 = d0(objNewInstance);
                    if (typefaceD0 != null) {
                        return Typeface.create(typefaceD0, i);
                    }
                }
            }
        }
        return null;
    }
}
