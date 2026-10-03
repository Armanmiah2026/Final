package sensei0;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.ClassLoaderCreator {
    public final /* synthetic */ int a;

    public /* synthetic */ c(int i) {
        this.a = i;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(classLoader) == null) {
                    return d.b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new j6(parcel, classLoader);
            case 2:
                return new g8(parcel, classLoader);
            case 3:
                return new gc(parcel, classLoader);
            case 4:
                return new bw(parcel, classLoader);
            case 5:
                return new o40(parcel, classLoader);
            case 6:
                return new x90(parcel, classLoader);
            case 7:
                return new xd0(parcel, classLoader);
            default:
                return new ve0(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new d[i];
            case 1:
                return new j6[i];
            case 2:
                return new g8[i];
            case 3:
                return new gc[i];
            case 4:
                return new bw[i];
            case 5:
                return new o40[i];
            case 6:
                return new x90[i];
            case 7:
                return new xd0[i];
            default:
                return new ve0[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                if (parcel.readParcelable(null) == null) {
                    return d.b;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new j6(parcel, null);
            case 2:
                return new g8(parcel, null);
            case 3:
                return new gc(parcel, null);
            case 4:
                return new bw(parcel, null);
            case 5:
                return new o40(parcel, null);
            case 6:
                return new x90(parcel, null);
            case 7:
                return new xd0(parcel, null);
            default:
                return new ve0(parcel, null);
        }
    }
}
