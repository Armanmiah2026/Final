package sensei0;

import android.content.DialogInterface;
import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class eg extends mo implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public final dg t;
    public int u;
    public boolean v;
    public boolean w;

    public eg() {
        int i = 2;
        new f5(i, this);
        new cg(this);
        this.t = new dg(this);
        this.u = -1;
        new pf(i, this);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        String str;
        if (this.v) {
            return;
        }
        if (ro.f(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        if (this.w) {
            return;
        }
        this.w = true;
        this.v = true;
        if (this.u >= 0) {
            ro roVarD = d();
            int i = this.u;
            if (i < 0) {
                throw new IllegalArgumentException(za0.h(i, "Bad id: "));
            }
            synchronized (roVarD.a) {
            }
            this.u = -1;
            return;
        }
        i5 i5Var = new i5(d());
        to toVar = new to();
        toVar.a = 3;
        toVar.b = this;
        ((ArrayList) i5Var.d).add(toVar);
        toVar.c = 0;
        toVar.d = 0;
        toVar.e = 0;
        toVar.f = 0;
        ro roVar = (ro) i5Var.e;
        if (i5Var.c) {
            throw new IllegalStateException("commit already called");
        }
        if (ro.f(2)) {
            Log.v("FragmentManager", "Commit: " + i5Var);
            PrintWriter printWriter = new PrintWriter(new bv());
            ArrayList arrayList = (ArrayList) i5Var.d;
            printWriter.print("  ");
            printWriter.print("mName=");
            printWriter.print((String) null);
            printWriter.print(" mIndex=");
            printWriter.print(i5Var.b);
            printWriter.print(" mCommitted=");
            printWriter.println(i5Var.c);
            if (!arrayList.isEmpty()) {
                printWriter.print("  ");
                printWriter.println("Operations:");
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    to toVar2 = (to) arrayList.get(i2);
                    switch (toVar2.a) {
                        case 0:
                            str = "NULL";
                            break;
                        case 1:
                            str = "ADD";
                            break;
                        case 2:
                            str = "REPLACE";
                            break;
                        case 3:
                            str = "REMOVE";
                            break;
                        case 4:
                            str = "HIDE";
                            break;
                        case 5:
                            str = "SHOW";
                            break;
                        case 6:
                            str = "DETACH";
                            break;
                        case 7:
                            str = "ATTACH";
                            break;
                        case 8:
                            str = "SET_PRIMARY_NAV";
                            break;
                        case 9:
                            str = "UNSET_PRIMARY_NAV";
                            break;
                        case 10:
                            str = "OP_SET_MAX_LIFECYCLE";
                            break;
                        default:
                            str = "cmd=" + toVar2.a;
                            break;
                    }
                    printWriter.print("  ");
                    printWriter.print("  Op #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.print(str);
                    printWriter.print(" ");
                    printWriter.println(toVar2.b);
                    if (toVar2.c != 0 || toVar2.d != 0) {
                        printWriter.print("  ");
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(toVar2.c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(toVar2.d));
                    }
                    if (toVar2.e != 0 || toVar2.f != 0) {
                        printWriter.print("  ");
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(toVar2.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(toVar2.f));
                    }
                }
            }
            printWriter.close();
        }
        i5Var.c = true;
        i5Var.b = -1;
        synchronized (roVar.a) {
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
