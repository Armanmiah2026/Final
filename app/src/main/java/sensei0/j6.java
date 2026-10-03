package sensei0;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.AbsSavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class j6 extends d {
    public static final Parcelable.Creator<j6> CREATOR = new c(1);
    public final int c;
    public final int d;
    public final boolean f;
    public final boolean h;
    public final boolean o;

    public j6(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.f = parcel.readInt() == 1;
        this.h = parcel.readInt() == 1;
        this.o = parcel.readInt() == 1;
    }

    @Override // sensei0.d, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public j6(BottomSheetBehavior bottomSheetBehavior) {
        super(AbsSavedState.EMPTY_STATE);
        this.c = bottomSheetBehavior.L;
        this.d = bottomSheetBehavior.e;
        this.f = bottomSheetBehavior.b;
        this.h = bottomSheetBehavior.I;
        this.o = bottomSheetBehavior.J;
    }
}
