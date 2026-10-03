package sensei0;

import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jk0 {
    public static final lk0 a;

    static {
        lk0 mhVar;
        try {
            mhVar = new fb0((WebViewProviderFactoryBoundaryInterface) k6.d(WebViewProviderFactoryBoundaryInterface.class, ji0.a()));
        } catch (ClassNotFoundException unused) {
            mhVar = new mh(5);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        a = mhVar;
    }
}
