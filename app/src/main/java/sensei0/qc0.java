package sensei0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class qc0 extends pw implements SubMenu {
    public final pw v;
    public final rw w;

    public qc0(Context context, pw pwVar, rw rwVar) {
        super(context);
        this.v = pwVar;
        this.w = rwVar;
    }

    @Override // sensei0.pw
    public final boolean d(rw rwVar) {
        return this.v.d(rwVar);
    }

    @Override // sensei0.pw
    public final boolean e(pw pwVar, MenuItem menuItem) {
        return super.e(pwVar, menuItem) || this.v.e(pwVar, menuItem);
    }

    @Override // sensei0.pw
    public final boolean f(rw rwVar) {
        return this.v.f(rwVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.w;
    }

    @Override // sensei0.pw
    public final pw j() {
        return this.v.j();
    }

    @Override // sensei0.pw
    public final boolean l() {
        return this.v.l();
    }

    @Override // sensei0.pw
    public final boolean m() {
        return this.v.m();
    }

    @Override // sensei0.pw
    public final boolean n() {
        return this.v.n();
    }

    @Override // sensei0.pw, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.v.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        q(0, null, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        q(0, charSequence, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        q(0, null, 0, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.w.setIcon(drawable);
        return this;
    }

    @Override // sensei0.pw, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.v.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        q(0, null, i, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        q(i, null, 0, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.w.setIcon(i);
        return this;
    }
}
