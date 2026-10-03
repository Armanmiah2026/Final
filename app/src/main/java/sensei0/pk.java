package sensei0;

import android.app.Activity;
import android.os.Looper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pk implements r10 {
    public static final int s = (sk.class.hashCode() + 43) & 65535;
    public static final int t = (sk.class.hashCode() + 83) & 65535;
    public final Activity a;
    public String f;
    public String[] p;
    public yi q;
    public byte[] r;
    public boolean c = false;
    public boolean d = false;
    public boolean h = true;
    public int o = 20;
    public rk b = null;

    public pk(Activity activity) {
        this.a = activity;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0067  */
    @Override // sensei0.r10
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            int r0 = sensei0.pk.t
            r1 = 0
            r2 = -1
            java.lang.String r3 = "FilePickerDelegate"
            r4 = 0
            r5 = 1
            if (r7 != r0) goto L70
            if (r8 != r2) goto L65
            if (r9 != 0) goto L10
            goto La3
        L10:
            r6.b(r5)
            android.net.Uri r7 = r9.getData()
            if (r7 == 0) goto L65
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)
            java.lang.String r0 = r0.getAbsolutePath()
            r9.append(r0)
            java.lang.String r0 = java.io.File.separator
            r9.append(r0)
            android.app.Activity r0 = r6.a
            java.lang.String r2 = sensei0.k6.y(r0, r7)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.io.IOException -> L53
            java.io.OutputStream r7 = r0.openOutputStream(r7)     // Catch: java.io.IOException -> L53
            if (r7 == 0) goto L55
            byte[] r0 = r6.r     // Catch: java.io.IOException -> L53
            r7.write(r0)     // Catch: java.io.IOException -> L53
            r7.flush()     // Catch: java.io.IOException -> L53
            r7.close()     // Catch: java.io.IOException -> L53
            goto L55
        L53:
            r7 = move-exception
            goto L59
        L55:
            r6.d(r9)     // Catch: java.io.IOException -> L53
            return r5
        L59:
            java.lang.String r9 = "Error while saving file"
            android.util.Log.i(r3, r9, r7)
            java.lang.String r7 = r7.getMessage()
            r6.c(r9, r7)
        L65:
            if (r8 != 0) goto La3
            java.lang.String r7 = "User cancelled the save request"
            android.util.Log.i(r3, r7)
            r6.d(r1)
            goto La3
        L70:
            java.lang.String r0 = r6.f
            if (r0 != 0) goto L75
            goto La3
        L75:
            int r0 = sensei0.pk.s
            if (r7 != r0) goto L8d
            if (r8 != r2) goto L8d
            r6.b(r5)
            java.lang.Thread r7 = new java.lang.Thread
            sensei0.e2 r8 = new sensei0.e2
            r0 = 2
            r8.<init>(r0, r6, r9)
            r7.<init>(r8)
            r7.start()
            return r5
        L8d:
            if (r7 != r0) goto L9a
            if (r8 != 0) goto L9a
            java.lang.String r7 = "User cancelled the picker request"
            android.util.Log.i(r3, r7)
            r6.d(r1)
            return r5
        L9a:
            if (r7 != r0) goto La3
            java.lang.String r7 = "unknown_activity"
            java.lang.String r8 = "Unknown activity error, please fill an issue."
            r6.c(r7, r8)
        La3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pk.a(int, int, android.content.Intent):boolean");
    }

    public final void b(boolean z) {
        if (this.q == null || this.f.equals("dir")) {
            return;
        }
        new ok(this, Looper.getMainLooper(), z).obtainMessage().sendToTarget();
    }

    public final void c(String str, String str2) {
        if (this.b == null) {
            return;
        }
        b(false);
        this.b.a(str, str2, null);
        this.b = null;
    }

    public final void d(Serializable serializable) {
        int i = 0;
        b(false);
        if (this.b != null) {
            if (serializable != null && !(serializable instanceof String)) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = (ArrayList) serializable;
                int size = arrayList2.size();
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    nk nkVar = (nk) obj;
                    nkVar.getClass();
                    HashMap map = new HashMap();
                    map.put("path", nkVar.a);
                    map.put("name", nkVar.b);
                    map.put("size", Long.valueOf(nkVar.d));
                    map.put("bytes", nkVar.e);
                    map.put("identifier", nkVar.c.toString());
                    arrayList.add(map);
                }
                serializable = arrayList;
            }
            this.b.d(serializable);
            this.b = null;
        }
    }
}
