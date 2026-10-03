package sensei0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ag0 extends yf0 {
    public final Class s;
    public final Constructor t;
    public final Method u;
    public final Method v;
    public final Method w;
    public final Method x;
    public final Method y;

    public ag0() throws NoSuchMethodException {
        Method methodI0;
        Constructor<?> constructor;
        Method methodH0;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodH0 = h0(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodI0 = i0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            methodI0 = null;
            constructor = null;
            methodH0 = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.s = cls;
        this.t = constructor;
        this.u = methodH0;
        this.v = method;
        this.w = method2;
        this.x = method3;
        this.y = methodI0;
    }

    public static Method h0(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    public final boolean e0(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.u.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface f0(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.s, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.y.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean g0(Object obj) {
        try {
            return ((Boolean) this.w.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method i0(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @Override // sensei0.yf0, sensei0.pr
    public final Typeface n(Context context, go goVar, Resources resources, int i) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.u;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.n(context, goVar, resources, i);
        }
        try {
            objNewInstance = this.t.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            ho[] hoVarArr = goVar.a;
            int length = hoVarArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    ho hoVar = hoVarArr[i2];
                    Context context2 = context;
                    if (e0(context2, objNewInstance, hoVar.a, hoVar.e, hoVar.b, hoVar.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(hoVar.d))) {
                        i2++;
                        context = context2;
                    } else {
                        try {
                            this.x.invoke(objNewInstance, null);
                            break;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                } else if (g0(objNewInstance)) {
                    return f0(objNewInstance);
                }
            }
        }
        return null;
    }

    @Override // sensei0.yf0, sensei0.pr
    public final Typeface o(Context context, jo[] joVarArr, int i) throws IOException {
        Object objNewInstance;
        Typeface typefaceF0;
        boolean zBooleanValue;
        if (joVarArr.length >= 1) {
            Method method = this.u;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap map = new HashMap();
                    for (jo joVar : joVarArr) {
                        if (joVar.f == 0) {
                            Uri uri = joVar.a;
                            if (!map.containsKey(uri)) {
                                map.put(uri, wf0.r(context, uri));
                            }
                        }
                    }
                    Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                    try {
                        objNewInstance = this.t.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        objNewInstance = null;
                    }
                    if (objNewInstance != null) {
                        int length = joVarArr.length;
                        int i2 = 0;
                        boolean z = false;
                        while (true) {
                            Method method2 = this.x;
                            if (i2 < length) {
                                jo joVar2 = joVarArr[i2];
                                ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(joVar2.a);
                                if (byteBuffer != null) {
                                    try {
                                        zBooleanValue = ((Boolean) this.v.invoke(objNewInstance, byteBuffer, Integer.valueOf(joVar2.b), null, Integer.valueOf(joVar2.c), Integer.valueOf(joVar2.d ? 1 : 0))).booleanValue();
                                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                                        zBooleanValue = false;
                                    }
                                    if (!zBooleanValue) {
                                        method2.invoke(objNewInstance, null);
                                        break;
                                    }
                                    z = true;
                                }
                                i2++;
                                z = z;
                            } else if (!z) {
                                method2.invoke(objNewInstance, null);
                            } else if (g0(objNewInstance) && (typefaceF0 = f0(objNewInstance)) != null) {
                                return Typeface.create(typefaceF0, i);
                            }
                        }
                    }
                } else {
                    jo joVarW = w(joVarArr, i);
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(joVarW.a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(joVarW.c).setItalic(joVarW.d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } finally {
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // sensei0.pr
    public final Typeface r(Context context, Resources resources, int i, String str, int i2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.u;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.r(context, resources, i, str, i2);
        }
        try {
            objNewInstance = this.t.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            if (!e0(context, objNewInstance, str, 0, -1, -1, null)) {
                try {
                    this.x.invoke(objNewInstance, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (g0(objNewInstance)) {
                return f0(objNewInstance);
            }
        }
        return null;
    }
}
