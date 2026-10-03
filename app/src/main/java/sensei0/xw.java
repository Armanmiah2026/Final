package sensei0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class xw extends gh {
    public final int u;
    public final int v;
    public qw w;
    public rw x;

    public xw(Context context, boolean z) {
        super(context, z);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.u = 21;
            this.v = 22;
        } else {
            this.u = 22;
            this.v = 21;
        }
    }

    @Override // sensei0.gh, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        nw nwVar;
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.w != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                nwVar = (nw) headerViewListAdapter.getWrappedAdapter();
            } else {
                nwVar = (nw) adapter;
                headersCount = 0;
            }
            rw rwVarB = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= nwVar.getCount()) ? null : nwVar.getItem(i);
            rw rwVar = this.x;
            if (rwVar != rwVarB) {
                pw pwVar = nwVar.a;
                if (rwVar != null) {
                    this.w.f(pwVar, rwVar);
                }
                this.x = rwVarB;
                if (rwVarB != null) {
                    this.w.w(pwVar, rwVarB);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.u) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.v) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (nw) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (nw) adapter).a.c(false);
        return true;
    }

    public void setHoverListener(qw qwVar) {
        this.w = qwVar;
    }

    @Override // sensei0.gh, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
