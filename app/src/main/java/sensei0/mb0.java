package sensei0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mb0 implements Parcelable {
    public static final Parcelable.Creator<mb0> CREATOR = new bu(4);
    public int a;
    public int b;
    public int c;
    public int[] d;
    public int f;
    public int[] h;
    public ArrayList o;
    public boolean p;
    public boolean q;
    public boolean r;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        if (this.c > 0) {
            parcel.writeIntArray(this.d);
        }
        parcel.writeInt(this.f);
        if (this.f > 0) {
            parcel.writeIntArray(this.h);
        }
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeInt(this.q ? 1 : 0);
        parcel.writeInt(this.r ? 1 : 0);
        parcel.writeList(this.o);
    }
}
