package sensei0;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class m60 {
    public final ClassLoader a;
    public final nb b;
    public final nb c;

    public m60(ClassLoader classLoader, nb nbVar) {
        this.a = classLoader;
        this.b = nbVar;
        this.c = new nb(classLoader);
    }

    public final WindowLayoutComponent a() {
        nb nbVar = this.c;
        nbVar.getClass();
        boolean zB = false;
        try {
            pr.i("loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)", nbVar.a.loadClass("androidx.window.extensions.WindowExtensionsProvider"));
            if (k6.X("WindowExtensionsProvider#getWindowExtensions is not valid", new vk(2, nbVar)) && k6.X("WindowExtensions#getWindowLayoutComponent is not valid", new l60(this, 3)) && k6.X("FoldingFeature class is not valid", new l60(this, 0))) {
                int iA = yj.a();
                if (iA == 1) {
                    zB = b();
                } else if (2 <= iA && iA <= Integer.MAX_VALUE && b()) {
                    if (k6.X("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new l60(this, 2))) {
                        zB = true;
                    }
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        if (!zB) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused2) {
            return null;
        }
    }

    public final boolean b() {
        return k6.X("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new l60(this, 1));
    }
}
