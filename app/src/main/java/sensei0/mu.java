package sensei0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class mu implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ qu b;

    public /* synthetic */ mu(qu quVar, int i) {
        this.a = i;
        this.b = quVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                xw xwVar = this.b.c;
                if (xwVar != null) {
                    xwVar.setListSelectionHidden(true);
                    xwVar.requestLayout();
                }
                break;
            default:
                qu quVar = this.b;
                xw xwVar2 = quVar.c;
                if (xwVar2 != null && xwVar2.isAttachedToWindow() && quVar.c.getCount() > quVar.c.getChildCount() && quVar.c.getChildCount() <= Integer.MAX_VALUE) {
                    quVar.D.setInputMethodMode(2);
                    quVar.b();
                    break;
                }
                break;
        }
    }
}
