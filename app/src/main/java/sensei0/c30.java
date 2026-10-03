package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c30 extends d30 implements ps, fp {
    @Override // sensei0.w6
    public final ms d() {
        y40.a.getClass();
        return this;
    }

    @Override // sensei0.fp
    public final Object g(Object obj) {
        h();
        throw null;
    }

    public final void h() {
        if (this.o) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        ms msVarF = f();
        if (msVarF == this) {
            throw new yc("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        }
        ((c30) ((ps) msVarF)).h();
    }
}
