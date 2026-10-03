package sensei0;

import android.text.TextUtils;
import android.util.Base64;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.sensei.tunnel.R;
import com.sensei.tunnel.SenseiTunnelVpnService;
import com.trilead.ssh2.sftp.ErrorCodes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class pf implements tx, zi {
    public static pf b;
    public static pf c;
    public final /* synthetic */ int a;

    public /* synthetic */ pf(int i) {
        this.a = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(sensei0.bi r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.pf.d(sensei0.bi, android.text.Editable, int, int, boolean):boolean");
    }

    public List a(String str) throws ClassNotFoundException, IOException {
        switch (this.a) {
            case 18:
                try {
                    return (List) new dc0(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            default:
                pr.j("listString", str);
                Object object = new dc0(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
                pr.g("null cannot be cast to non-null type kotlin.collections.List<*>", object);
                ArrayList arrayList = new ArrayList();
                for (Object obj : (List) object) {
                    if (obj instanceof String) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
        }
    }

    public String b(List list) throws IOException {
        switch (this.a) {
            case 18:
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(list);
                    objectOutputStream.flush();
                    return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            default:
                pr.j("list", list);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream2);
                objectOutputStream2.writeObject(list);
                objectOutputStream2.flush();
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 0);
                pr.i("encodeToString(...)", strEncodeToString);
                return strEncodeToString;
        }
    }

    @Override // sensei0.zi
    public void c(yi yiVar) {
        switch (this.a) {
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                SenseiTunnelVpnService.N0 = yiVar;
                yiVar.a(SenseiTunnelVpnService.J0 ? "connected" : "disconnected");
                break;
            default:
                SenseiTunnelVpnService.O0 = yiVar;
                break;
        }
    }

    public CharSequence f(Preference preference) {
        switch (this.a) {
            case 3:
                EditTextPreference editTextPreference = (EditTextPreference) preference;
                if (TextUtils.isEmpty(null)) {
                    return editTextPreference.a.getString(R.string.not_set);
                }
                return null;
            default:
                ListPreference listPreference = (ListPreference) preference;
                if (TextUtils.isEmpty(null)) {
                    return listPreference.a.getString(R.string.not_set);
                }
                return null;
        }
    }

    @Override // sensei0.tx
    public void l(i3 i3Var, rk rkVar) {
        switch (this.a) {
            case 0:
                break;
            default:
                rkVar.d(null);
                break;
        }
    }

    @Override // sensei0.zi
    public void onCancel() {
        switch (this.a) {
            case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                SenseiTunnelVpnService.N0 = null;
                break;
            default:
                SenseiTunnelVpnService.O0 = null;
                break;
        }
    }

    public /* synthetic */ pf(int i, Object obj) {
        this.a = i;
    }

    public pf(ro roVar, int i) {
        this.a = i;
        switch (i) {
            case 15:
                this.a = 15;
                new CopyOnWriteArrayList();
                break;
            default:
                new CopyOnWriteArrayList();
                break;
        }
    }

    public pf(kd kdVar) {
        this.a = 1;
        new aj(kdVar, "flutter/deferredcomponent", sb0.a).b(new pf(0, this));
        o4.O().getClass();
        new HashMap();
    }

    private final void e(i3 i3Var, rk rkVar) {
    }
}
