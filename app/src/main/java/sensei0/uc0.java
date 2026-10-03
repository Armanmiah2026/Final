package sensei0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class uc0 extends MenuInflater {
    public static final Class[] e;
    public static final Class[] f;
    public final Object[] a;
    public final Object[] b;
    public final Context c;
    public Object d;

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public uc0(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i;
        XmlPullParser xmlPullParser2;
        ColorStateList colorStateList;
        int resourceId;
        tc0 tc0Var = new tc0(this, menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i) {
                if (eventType != 3) {
                    xmlPullParser2 = xmlPullParser;
                    z = z;
                } else {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        xmlPullParser2 = xmlPullParser;
                        z2 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            tc0Var.b = 0;
                            tc0Var.c = 0;
                            tc0Var.d = 0;
                            tc0Var.e = 0;
                            tc0Var.f = true;
                            tc0Var.g = true;
                        } else if (name2.equals("item")) {
                            if (!tc0Var.h) {
                                tc0Var.h = true;
                                tc0Var.b(tc0Var.a.add(tc0Var.b, tc0Var.i, tc0Var.j, tc0Var.k));
                            }
                        } else if (name2.equals("menu")) {
                            xmlPullParser2 = xmlPullParser;
                            z = true;
                        }
                        xmlPullParser2 = xmlPullParser;
                        z = z;
                    }
                }
                eventType = xmlPullParser2.next();
                i = 2;
                z = z;
                z2 = z2;
            } else {
                if (!z2) {
                    String name3 = xmlPullParser.getName();
                    boolean zEquals = name3.equals("group");
                    Context context = this.c;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p30.m);
                        tc0Var.b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        tc0Var.c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        tc0Var.d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        tc0Var.e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        tc0Var.f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        tc0Var.g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, p30.n);
                            tc0Var.i = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
                            tc0Var.j = (typedArrayObtainStyledAttributes2.getInt(5, tc0Var.c) & (-65536)) | (typedArrayObtainStyledAttributes2.getInt(6, tc0Var.d) & 65535);
                            tc0Var.k = typedArrayObtainStyledAttributes2.getText(7);
                            tc0Var.l = typedArrayObtainStyledAttributes2.getText(8);
                            tc0Var.m = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes2.getString(9);
                            tc0Var.n = string == null ? (char) 0 : string.charAt(0);
                            tc0Var.o = typedArrayObtainStyledAttributes2.getInt(16, AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE);
                            String string2 = typedArrayObtainStyledAttributes2.getString(10);
                            tc0Var.p = string2 == null ? (char) 0 : string2.charAt(0);
                            tc0Var.q = typedArrayObtainStyledAttributes2.getInt(20, AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE);
                            if (typedArrayObtainStyledAttributes2.hasValue(11)) {
                                tc0Var.r = typedArrayObtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                            } else {
                                tc0Var.r = tc0Var.e;
                            }
                            tc0Var.s = typedArrayObtainStyledAttributes2.getBoolean(3, false);
                            tc0Var.t = typedArrayObtainStyledAttributes2.getBoolean(4, tc0Var.f);
                            tc0Var.u = typedArrayObtainStyledAttributes2.getBoolean(1, tc0Var.g);
                            tc0Var.v = typedArrayObtainStyledAttributes2.getInt(21, -1);
                            tc0Var.y = typedArrayObtainStyledAttributes2.getString(12);
                            tc0Var.w = typedArrayObtainStyledAttributes2.getResourceId(13, 0);
                            tc0Var.x = typedArrayObtainStyledAttributes2.getString(15);
                            String string3 = typedArrayObtainStyledAttributes2.getString(14);
                            boolean z3 = string3 != null;
                            if (z3 && tc0Var.w == 0 && tc0Var.x == null) {
                                if (tc0Var.a(string3, f, this.b) != null) {
                                    throw new ClassCastException();
                                }
                            } else if (z3) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            tc0Var.z = typedArrayObtainStyledAttributes2.getText(17);
                            tc0Var.A = typedArrayObtainStyledAttributes2.getText(22);
                            if (typedArrayObtainStyledAttributes2.hasValue(19)) {
                                tc0Var.C = ah.c(typedArrayObtainStyledAttributes2.getInt(19, -1), tc0Var.C);
                            } else {
                                tc0Var.C = null;
                            }
                            if (typedArrayObtainStyledAttributes2.hasValue(18)) {
                                if (!typedArrayObtainStyledAttributes2.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = wf0.k(context, resourceId)) == null) {
                                    colorStateList = typedArrayObtainStyledAttributes2.getColorStateList(18);
                                }
                                tc0Var.B = colorStateList;
                            } else {
                                tc0Var.B = null;
                            }
                            typedArrayObtainStyledAttributes2.recycle();
                            tc0Var.h = false;
                            xmlPullParser2 = xmlPullParser;
                        } else if (name3.equals("menu")) {
                            tc0Var.h = true;
                            SubMenu subMenuAddSubMenu = tc0Var.a.addSubMenu(tc0Var.b, tc0Var.i, tc0Var.j, tc0Var.k);
                            tc0Var.b(subMenuAddSubMenu.getItem());
                            xmlPullParser2 = xmlPullParser;
                            b(xmlPullParser2, attributeSet, subMenuAddSubMenu);
                        } else {
                            xmlPullParser2 = xmlPullParser;
                            str = name3;
                            z2 = true;
                        }
                        eventType = xmlPullParser2.next();
                        i = 2;
                        z = z;
                        z2 = z2;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z = z;
            }
            eventType = xmlPullParser2.next();
            i = 2;
            z = z;
            z2 = z2;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof pw)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z = false;
        try {
            try {
                layout = this.c.getResources().getLayout(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof pw) {
                    pw pwVar = (pw) menu;
                    if (!pwVar.m) {
                        pwVar.s();
                        z = true;
                    }
                }
                b(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((pw) menu).r();
                }
                layout.close();
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (z) {
                ((pw) menu).r();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
