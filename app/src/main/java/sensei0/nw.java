package sensei0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nw extends BaseAdapter {
    public final pw a;
    public int b = -1;
    public boolean c;
    public final boolean d;
    public final LayoutInflater e;
    public final int f;

    public nw(pw pwVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.a = pwVar;
        this.f = i;
        a();
    }

    public final void a() {
        pw pwVar = this.a;
        rw rwVar = pwVar.s;
        if (rwVar != null) {
            pwVar.i();
            ArrayList arrayList = pwVar.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((rw) arrayList.get(i)) == rwVar) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final rw getItem(int i) {
        ArrayList arrayListK;
        boolean z = this.d;
        pw pwVar = this.a;
        if (z) {
            pwVar.i();
            arrayListK = pwVar.j;
        } else {
            arrayListK = pwVar.k();
        }
        int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (rw) arrayListK.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListK;
        boolean z = this.d;
        pw pwVar = this.a;
        if (z) {
            pwVar.i();
            arrayListK = pwVar.j;
        } else {
            arrayListK = pwVar.k();
        }
        return this.b < 0 ? arrayListK.size() : arrayListK.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int i2 = getItem(i).b;
        int i3 = i - 1;
        int i4 = i3 >= 0 ? getItem(i3).b : i2;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.a.l() && i2 != i4) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        bx bxVar = (bx) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        bxVar.b(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
