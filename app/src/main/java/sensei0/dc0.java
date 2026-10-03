package sensei0;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class dc0 extends ObjectInputStream {
    @Override // java.io.ObjectInputStream
    public final Class resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
        Set setA = wf0.A("java.util.Arrays$ArrayList", "java.util.ArrayList", "java.lang.String", "[Ljava.lang.String;");
        String name = objectStreamClass != null ? objectStreamClass.getName() : null;
        if (name == null || setA.contains(name)) {
            return super.resolveClass(objectStreamClass);
        }
        throw new ClassNotFoundException(objectStreamClass.getName());
    }
}
