package sensei0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class zz {
    public static final zz a;
    public static final zz b;
    public static final zz c;
    public static final zz d;
    public static final /* synthetic */ zz[] f;

    static {
        zz zzVar = new zz("DIRECT", 0);
        a = zzVar;
        zz zzVar2 = new zz("DIRECT_SNI", 1);
        b = zzVar2;
        zz zzVar3 = new zz("PROXY", 2);
        c = zzVar3;
        zz zzVar4 = new zz("PROXY_SNI", 3);
        d = zzVar4;
        f = new zz[]{zzVar, zzVar2, zzVar3, zzVar4};
    }

    public static zz valueOf(String str) {
        return (zz) Enum.valueOf(zz.class, str);
    }

    public static zz[] values() {
        return (zz[]) f.clone();
    }
}
