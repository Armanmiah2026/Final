package sensei0;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class vk extends et implements uo {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vk(int i, Object obj) {
        super(0);
        this.b = i;
        this.c = obj;
    }

    @Override // sensei0.uo
    public final Object a() throws NoSuchMethodException, ClassNotFoundException {
        switch (this.b) {
            case 0:
                Object obj = wk.d;
                File file = (File) this.c;
                synchronized (obj) {
                    wk.c.remove(file.getAbsolutePath());
                }
                return mg0.a;
            case 1:
                File file2 = (File) ((y10) this.c).a();
                String name = file2.getName();
                pr.i("getName(...)", name);
                String strSubstring = "";
                int iM0 = fc0.m0(name, '.');
                if (iM0 != -1) {
                    strSubstring = name.substring(iM0 + 1, name.length());
                    pr.i("substring(...)", strSubstring);
                }
                if (strSubstring.equals("preferences_pb")) {
                    File absoluteFile = file2.getAbsoluteFile();
                    pr.i("file.absoluteFile", absoluteFile);
                    return absoluteFile;
                }
                throw new IllegalStateException(("File extension for file: " + file2 + " does not match required extension for Preferences file: preferences_pb").toString());
            case 2:
                nb nbVar = (nb) this.c;
                Class<?> clsLoadClass = nbVar.a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                pr.i("loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)", clsLoadClass);
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getWindowExtensions", null);
                Class<?> clsLoadClass2 = nbVar.a.loadClass("androidx.window.extensions.WindowExtensions");
                pr.i("loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)", clsLoadClass2);
                pr.i("getWindowExtensionsMethod", declaredMethod);
                return Boolean.valueOf(declaredMethod.getReturnType().equals(clsLoadClass2) && Modifier.isPublic(declaredMethod.getModifiers()));
            case 3:
                mo moVar = (mo) this.c;
                new mz(10);
                moVar.getClass();
                throw new IllegalStateException("Can't access ViewModels from detached fragment");
            default:
                ih0 ih0Var = (ih0) this.c;
                return BigInteger.valueOf(ih0Var.a).shiftLeft(32).or(BigInteger.valueOf(ih0Var.b)).shiftLeft(32).or(BigInteger.valueOf(ih0Var.c));
        }
    }
}
