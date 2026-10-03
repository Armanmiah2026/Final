package sensei0;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.trilead.ssh2.sftp.ErrorCodes;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class sv implements u5, zw, f4, qw, pb, rb, wy, a6, gl, th, zi {
    public static final zp c = new zp(1);
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ sv(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public static int C(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            i3++;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = 1;
            }
        }
        return i3 + 1 > i2 ? i4 + 1 : i4;
    }

    public static boolean D(int i) {
        return (48 <= i && i <= 57) || i == 35 || i == 42;
    }

    public d1 A(int i) {
        return null;
    }

    public vb0 B() {
        xb0 xb0Var = (xb0) this.b;
        xb0Var.getClass();
        tn tnVar = pr.e;
        Object obj = xb0.f.get(xb0Var);
        if (obj == tnVar) {
            obj = null;
        }
        return (vb0) obj;
    }

    public boolean E(int i, int i2, Bundle bundle) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void F(sensei0.vb0 r7) {
        /*
            r6 = this;
            java.lang.String r0 = "newState"
            sensei0.pr.j(r0, r7)
            java.lang.Object r0 = r6.b
            sensei0.xb0 r0 = (sensei0.xb0) r0
        L9:
            r0.getClass()
            sensei0.tn r1 = sensei0.pr.e
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = sensei0.xb0.f
            java.lang.Object r2 = r2.get(r0)
            if (r2 != r1) goto L17
            r2 = 0
        L17:
            r3 = r2
            sensei0.vb0 r3 = (sensei0.vb0) r3
            boolean r4 = r3 instanceof sensei0.v30
            if (r4 == 0) goto L20
            r4 = 1
            goto L26
        L20:
            sensei0.gg0 r4 = sensei0.gg0.b
            boolean r4 = sensei0.pr.b(r3, r4)
        L26:
            if (r4 == 0) goto L29
            goto L33
        L29:
            boolean r4 = r3 instanceof sensei0.sd
            if (r4 == 0) goto L35
            int r4 = r7.a
            int r5 = r3.a
            if (r4 <= r5) goto L39
        L33:
            r3 = r7
            goto L39
        L35:
            boolean r4 = r3 instanceof sensei0.dl
            if (r4 == 0) goto L47
        L39:
            if (r2 != 0) goto L3c
            r2 = r1
        L3c:
            if (r3 != 0) goto L3f
            goto L40
        L3f:
            r1 = r3
        L40:
            boolean r1 = r0.a(r2, r1)
            if (r1 == 0) goto L9
            return
        L47:
            sensei0.ia r7 = new sensei0.ia
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.sv.F(sensei0.vb0):void");
    }

    public void G(int i, Object obj, v60 v60Var) {
        m9 m9Var = (m9) this.b;
        m9Var.S0(i, 3);
        v60Var.b((n) obj, m9Var.l);
        m9Var.S0(i, 4);
    }

    @Override // sensei0.zw
    public void a(pw pwVar, boolean z) {
        if (pwVar instanceof qc0) {
            ((qc0) pwVar).v.j().c(false);
        }
        zw zwVar = ((g2) this.b).f;
        if (zwVar != null) {
            zwVar.a(pwVar, z);
        }
    }

    @Override // sensei0.a6
    public void b(String str, y5 y5Var) {
        ((rd) this.b).t(str, y5Var, null);
    }

    @Override // sensei0.pb
    public sb build() {
        return new sb(new sv(((ContentInfo.Builder) this.b).build()));
    }

    @Override // sensei0.zi
    public void c(yi yiVar) {
        ((sk) this.b).b.q = yiVar;
    }

    @Override // sensei0.rb
    public ClipData d() {
        return ((ContentInfo) this.b).getClip();
    }

    @Override // sensei0.gl
    public Object e(il ilVar, yb ybVar) {
        Object objE = ((i3) this.b).e(new he(ilVar, 0), ybVar);
        return objE == vc.a ? objE : mg0.a;
    }

    @Override // sensei0.qw
    public void f(pw pwVar, MenuItem menuItem) {
        ((o7) this.b).h.removeCallbacksAndMessages(pwVar);
    }

    @Override // sensei0.a6
    public mh i(mh mhVar) {
        return ((rd) this.b).i(mhVar);
    }

    @Override // sensei0.u5
    public void j(Object obj, i3 i3Var) {
        HashMap map;
        HashMap map2;
        o4 o4Var = (o4) this.b;
        if (((io.flutter.view.a) o4Var.d) == null) {
            i3Var.s(null);
            return;
        }
        map = (HashMap) obj;
        String str = (String) map.get("type");
        map2 = (HashMap) map.get("data");
        str.getClass();
        switch (str) {
            case "tooltip":
                String str2 = (String) map2.get("message");
                if (str2 != null) {
                    io.flutter.view.b bVar = ((io.flutter.view.a) o4Var.d).a;
                    if (Build.VERSION.SDK_INT < 28) {
                        AccessibilityEvent accessibilityEventE = bVar.e(0, 32);
                        accessibilityEventE.getText().add(str2);
                        bVar.i(accessibilityEventE);
                    }
                    break;
                }
                break;
            case "announce":
                String str3 = (String) map2.get("message");
                if (str3 != null) {
                    io.flutter.view.a aVar = (io.flutter.view.a) o4Var.d;
                    if (Build.VERSION.SDK_INT >= 36) {
                        aVar.getClass();
                        Log.w("AccessibilityBridge", "Using AnnounceSemanticsEvent for accessibility is deprecated on Android. Migrate to using semantic properties for a more robust and accessible user experience.\nFlutter: If you are unsure why you are seeing this bug, it might be because you are using a widget that calls this method. See https://github.com/flutter/flutter/issues/165510 for more details.\nAndroid documentation: https://developer.android.com/reference/android/view/View#announceForAccessibility(java.lang.CharSequence)");
                    }
                    aVar.a.a.announceForAccessibility(str3);
                    break;
                }
                break;
            case "tap":
                Integer num = (Integer) map.get("nodeId");
                if (num != null) {
                    io.flutter.view.a aVar2 = (io.flutter.view.a) o4Var.d;
                    aVar2.a.h(num.intValue(), 1);
                    break;
                }
                break;
            case "focus":
                Integer num2 = (Integer) map.get("nodeId");
                if (num2 != null) {
                    io.flutter.view.a aVar3 = (io.flutter.view.a) o4Var.d;
                    aVar3.a.h(num2.intValue(), 8);
                    break;
                }
                break;
            case "longPress":
                Integer num3 = (Integer) map.get("nodeId");
                if (num3 != null) {
                    io.flutter.view.a aVar4 = (io.flutter.view.a) o4Var.d;
                    aVar4.a.h(num3.intValue(), 2);
                    break;
                }
                break;
        }
        i3Var.s(null);
    }

    @Override // sensei0.zw
    public boolean k(pw pwVar) {
        g2 g2Var = (g2) this.b;
        if (pwVar == g2Var.c) {
            return false;
        }
        ((qc0) pwVar).w.getClass();
        g2Var.getClass();
        zw zwVar = g2Var.f;
        if (zwVar != null) {
            return zwVar.k(pwVar);
        }
        return false;
    }

    @Override // sensei0.wy
    public rl0 l(View view, rl0 rl0Var) {
        ol0 ol0Var = rl0Var.a;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.b;
        if (!Objects.equals(coordinatorLayout.v, rl0Var)) {
            coordinatorLayout.v = rl0Var;
            boolean z = rl0Var.a() > 0;
            coordinatorLayout.w = z;
            coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
            if (!ol0Var.m()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    Field field = ai0.a;
                    if (childAt.getFitsSystemWindows() && ((ec) childAt.getLayoutParams()).a != null && ol0Var.m()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return rl0Var;
    }

    @Override // sensei0.rb
    public int m() {
        return ((ContentInfo) this.b).getFlags();
    }

    @Override // sensei0.a6
    public void n(String str, ByteBuffer byteBuffer) {
        ((rd) this.b).p(str, byteBuffer, null);
    }

    @Override // sensei0.rb
    public ContentInfo o() {
        return (ContentInfo) this.b;
    }

    @Override // sensei0.zi
    public void onCancel() {
        ((sk) this.b).b.q = null;
    }

    @Override // sensei0.a6
    public void p(String str, ByteBuffer byteBuffer, z5 z5Var) {
        ((rd) this.b).p(str, byteBuffer, z5Var);
    }

    @Override // sensei0.pb
    public void r(Uri uri) {
        ((ContentInfo.Builder) this.b).setLinkUri(uri);
    }

    @Override // sensei0.rb
    public int s() {
        return ((ContentInfo) this.b).getSource();
    }

    @Override // sensei0.pb
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.b).setExtras(bundle);
    }

    @Override // sensei0.a6
    public void t(String str, y5 y5Var, mh mhVar) {
        ((rd) this.b).t(str, y5Var, mhVar);
    }

    public String toString() {
        switch (this.a) {
            case 13:
                return "ContentInfoCompat{" + ((ContentInfo) this.b) + "}";
            default:
                return super.toString();
        }
    }

    @Override // sensei0.th
    public void u(mm0 mm0Var) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ka("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new wh(this, mm0Var, threadPoolExecutor, 0));
    }

    @Override // sensei0.qw
    public void w(pw pwVar, rw rwVar) {
        o7 o7Var = (o7) this.b;
        Handler handler = o7Var.h;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = o7Var.p;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (pwVar == ((n7) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        handler.postAtTime(new m7(this, i2 < arrayList.size() ? (n7) arrayList.get(i2) : null, rwVar, pwVar, 0), pwVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // sensei0.pb
    public void x(int i) {
        ((ContentInfo.Builder) this.b).setFlags(i);
    }

    public d1 y(int i) {
        return null;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [sensei0.qq] */
    public Bitmap z(ByteBuffer byteBuffer, ya yaVar) {
        try {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new ImageDecoder.OnHeaderDecodedListener() { // from class: sensei0.qq
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    sv svVar = this.a;
                    ColorSpace.Named unused = ColorSpace.Named.SRGB;
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                    imageDecoder.setAllocator(1);
                    pm pmVar = (pm) svVar.b;
                    if (pmVar != null) {
                        Size size = imageInfo.getSize();
                        FlutterJNI.nativeImageHeaderCallback(pmVar.a, size.getWidth(), size.getHeight());
                    }
                }
            });
        } catch (IOException e) {
            Log.e("FlutterImageDecoderImplDefault", "Failed to decode image", e);
            return null;
        }
    }

    public sv(m9 m9Var) {
        this.a = 10;
        mr.a("output", m9Var);
        this.b = m9Var;
        m9Var.l = this;
    }

    public sv(boolean z) {
        this.a = 7;
        this.b = new AtomicBoolean(z);
    }

    public sv(int i) {
        ex exVar;
        this.a = i;
        switch (i) {
            case 2:
                if (Build.VERSION.SDK_INT >= 26) {
                    this.b = new f1(this);
                } else {
                    this.b = new e1(this);
                }
                break;
            case 8:
                this.b = new AtomicInteger(0);
                break;
            case 16:
                break;
            case 18:
                this.b = new xb0(gg0.b);
                break;
            case ErrorCodes.SSH_FX_DELETE_PENDING /* 27 */:
                this.b = new SparseIntArray();
                new SparseIntArray();
                break;
            default:
                e30 e30Var = e30.c;
                try {
                    exVar = (ex) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
                } catch (Exception unused) {
                    exVar = c;
                }
                ex[] exVarArr = {zp.b, exVar};
                rv rvVar = new rv();
                rvVar.a = exVarArr;
                Charset charset = mr.a;
                this.b = rvVar;
                break;
        }
    }

    public sv(TextView textView) {
        this.a = 21;
        this.b = new ii(textView);
    }

    public sv(EditText editText) {
        this.a = 20;
        this.b = new i3(editText, 8);
    }

    public sv(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.a = 29;
        if (Build.VERSION.SDK_INT >= 25) {
            this.b = new er(uri, clipDescription, uri2);
        } else {
            this.b = new o4(uri, clipDescription, uri2, 10);
        }
    }

    public sv(Context context) {
        this.a = 19;
        this.b = context.getApplicationContext();
    }

    public sv(ContentInfo contentInfo) {
        this.a = 13;
        contentInfo.getClass();
        this.b = e6.l(contentInfo);
    }

    public sv(ClipData clipData, int i) {
        this.a = 12;
        this.b = e6.j(clipData, i);
    }

    public void g(int i) {
    }

    public void q(int i) {
    }

    public void v(int i, float f) {
    }
}
