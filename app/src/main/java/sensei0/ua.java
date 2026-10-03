package sensei0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class ua {
    public int a;
    public int b;
    public float c;
    public String d;
    public boolean e;
    public int f;

    public ua(ua uaVar, Object obj) {
        uaVar.getClass();
        this.a = uaVar.a;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), i30.c);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        int i = 0;
        Object string2 = null;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == 0) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == 1) {
                string2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i = 6;
            } else {
                int i3 = 3;
                if (index == 3) {
                    string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else {
                    i3 = 4;
                    if (index == 2) {
                        string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                    } else {
                        if (index == 7) {
                            string2 = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                        } else if (index == 4) {
                            string2 = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                        } else {
                            i3 = 5;
                            if (index == 5) {
                                string2 = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                                i = 2;
                            } else if (index == 6) {
                                string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                                i = 1;
                            } else if (index == 8) {
                                string2 = typedArrayObtainStyledAttributes.getString(index);
                            }
                        }
                        i = 7;
                    }
                }
                i = i3;
            }
        }
        if (string != null && string2 != null) {
            ua uaVar = new ua();
            uaVar.a = i;
            uaVar.b(string2);
            map.put(string, uaVar);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (za0.u(this.a)) {
            case 0:
                this.b = ((Integer) obj).intValue();
                break;
            case 1:
                this.c = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f = ((Integer) obj).intValue();
                break;
            case 4:
                this.d = (String) obj;
                break;
            case 5:
                this.e = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.c = ((Float) obj).floatValue();
                break;
        }
    }
}
