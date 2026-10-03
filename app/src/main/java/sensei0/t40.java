package sensei0;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class t40 extends p0 {
    public final u40 d;
    public final WeakHashMap e = new WeakHashMap();

    public t40(u40 u40Var) {
        this.d = u40Var;
    }

    @Override // sensei0.p0
    public final boolean a(View view, AccessibilityEvent accessibilityEvent) {
        p0 p0Var = (p0) this.e.get(view);
        return p0Var != null ? p0Var.a(view, accessibilityEvent) : this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // sensei0.p0
    public final sv b(View view) {
        p0 p0Var = (p0) this.e.get(view);
        return p0Var != null ? p0Var.b(view) : super.b(view);
    }

    @Override // sensei0.p0
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        p0 p0Var = (p0) this.e.get(view);
        if (p0Var != null) {
            p0Var.c(view, accessibilityEvent);
        } else {
            super.c(view, accessibilityEvent);
        }
    }

    @Override // sensei0.p0
    public final void d(View view, d1 d1Var) {
        AccessibilityNodeInfo accessibilityNodeInfo = d1Var.a;
        u40 u40Var = this.d;
        RecyclerView recyclerView = u40Var.d;
        RecyclerView recyclerView2 = u40Var.d;
        boolean zS = recyclerView.s();
        View.AccessibilityDelegate accessibilityDelegate = this.a;
        if (zS || recyclerView2.getLayoutManager() == null) {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            return;
        }
        recyclerView2.getLayoutManager().E(view, d1Var);
        p0 p0Var = (p0) this.e.get(view);
        if (p0Var != null) {
            p0Var.d(view, d1Var);
        } else {
            accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        }
    }

    @Override // sensei0.p0
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        p0 p0Var = (p0) this.e.get(view);
        if (p0Var != null) {
            p0Var.e(view, accessibilityEvent);
        } else {
            super.e(view, accessibilityEvent);
        }
    }

    @Override // sensei0.p0
    public final boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        p0 p0Var = (p0) this.e.get(viewGroup);
        return p0Var != null ? p0Var.f(viewGroup, view, accessibilityEvent) : this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // sensei0.p0
    public final boolean g(View view, int i, Bundle bundle) {
        u40 u40Var = this.d;
        RecyclerView recyclerView = u40Var.d;
        RecyclerView recyclerView2 = u40Var.d;
        if (recyclerView.s() || recyclerView2.getLayoutManager() == null) {
            return super.g(view, i, bundle);
        }
        p0 p0Var = (p0) this.e.get(view);
        if (p0Var != null) {
            if (p0Var.g(view, i, bundle)) {
                return true;
            }
        } else if (super.g(view, i, bundle)) {
            return true;
        }
        m40 m40Var = recyclerView2.getLayoutManager().b.a;
        return false;
    }

    @Override // sensei0.p0
    public final void h(View view, int i) {
        p0 p0Var = (p0) this.e.get(view);
        if (p0Var != null) {
            p0Var.h(view, i);
        } else {
            super.h(view, i);
        }
    }

    @Override // sensei0.p0
    public final void i(View view, AccessibilityEvent accessibilityEvent) {
        p0 p0Var = (p0) this.e.get(view);
        if (p0Var != null) {
            p0Var.i(view, accessibilityEvent);
        } else {
            super.i(view, accessibilityEvent);
        }
    }
}
