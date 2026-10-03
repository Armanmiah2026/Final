package sensei0;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x3 {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        pb svVar;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                svVar = new sv(clipData, 3);
            } else {
                qb qbVar = new qb();
                qbVar.b = clipData;
                qbVar.c = 3;
                svVar = qbVar;
            }
            ai0.g(textView, svVar.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        pb svVar;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            svVar = new sv(clipData, 3);
        } else {
            qb qbVar = new qb();
            qbVar.b = clipData;
            qbVar.c = 3;
            svVar = qbVar;
        }
        ai0.g(view, svVar.build());
        return true;
    }
}
