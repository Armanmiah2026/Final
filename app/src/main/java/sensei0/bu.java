package sensei0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class bu implements Parcelable.Creator {
    public final /* synthetic */ int a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                cu cuVar = new cu();
                cuVar.a = parcel.readInt();
                cuVar.b = parcel.readInt();
                cuVar.c = parcel.readInt() == 1;
                return cuVar;
            case 1:
                my myVar = new my(parcel);
                myVar.a = parcel.readInt();
                return myVar;
            case 2:
                return new ParcelImpl(parcel);
            case 3:
                lb0 lb0Var = new lb0();
                lb0Var.a = parcel.readInt();
                lb0Var.b = parcel.readInt();
                lb0Var.d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    lb0Var.c = iArr;
                    parcel.readIntArray(iArr);
                }
                return lb0Var;
            default:
                mb0 mb0Var = new mb0();
                mb0Var.a = parcel.readInt();
                mb0Var.b = parcel.readInt();
                int i2 = parcel.readInt();
                mb0Var.c = i2;
                if (i2 > 0) {
                    int[] iArr2 = new int[i2];
                    mb0Var.d = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i3 = parcel.readInt();
                mb0Var.f = i3;
                if (i3 > 0) {
                    int[] iArr3 = new int[i3];
                    mb0Var.h = iArr3;
                    parcel.readIntArray(iArr3);
                }
                mb0Var.p = parcel.readInt() == 1;
                mb0Var.q = parcel.readInt() == 1;
                mb0Var.r = parcel.readInt() == 1;
                mb0Var.o = parcel.readArrayList(lb0.class.getClassLoader());
                return mb0Var;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new cu[i];
            case 1:
                return new my[i];
            case 2:
                return new ParcelImpl[i];
            case 3:
                return new lb0[i];
            default:
                return new mb0[i];
        }
    }
}
