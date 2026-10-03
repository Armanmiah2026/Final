package sensei0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.trilead.ssh2.packets.Packets;
import com.trilead.ssh2.sftp.ErrorCodes;
import com.trilead.ssh2.sftp.Packet;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class gb {
    public static final int[] d = {0, 4, 8};
    public static final SparseIntArray e;
    public final HashMap a = new HashMap();
    public final boolean b = true;
    public final HashMap c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e = sparseIntArray;
        sparseIntArray.append(76, 25);
        sparseIntArray.append(77, 26);
        sparseIntArray.append(79, 29);
        sparseIntArray.append(80, 30);
        sparseIntArray.append(86, 36);
        sparseIntArray.append(85, 35);
        sparseIntArray.append(58, 4);
        sparseIntArray.append(57, 3);
        sparseIntArray.append(55, 1);
        sparseIntArray.append(94, 6);
        sparseIntArray.append(95, 7);
        sparseIntArray.append(65, 17);
        sparseIntArray.append(66, 18);
        sparseIntArray.append(67, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(81, 32);
        sparseIntArray.append(82, 33);
        sparseIntArray.append(64, 10);
        sparseIntArray.append(63, 9);
        sparseIntArray.append(98, 13);
        sparseIntArray.append(101, 16);
        sparseIntArray.append(99, 14);
        sparseIntArray.append(96, 11);
        sparseIntArray.append(100, 15);
        sparseIntArray.append(97, 12);
        sparseIntArray.append(89, 40);
        sparseIntArray.append(74, 39);
        sparseIntArray.append(73, 41);
        sparseIntArray.append(88, 42);
        sparseIntArray.append(72, 20);
        sparseIntArray.append(87, 37);
        sparseIntArray.append(62, 5);
        sparseIntArray.append(75, 82);
        sparseIntArray.append(84, 82);
        sparseIntArray.append(78, 82);
        sparseIntArray.append(56, 82);
        sparseIntArray.append(54, 82);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(90, 54);
        sparseIntArray.append(68, 55);
        sparseIntArray.append(91, 56);
        sparseIntArray.append(69, 57);
        sparseIntArray.append(92, 58);
        sparseIntArray.append(70, 59);
        sparseIntArray.append(59, 61);
        sparseIntArray.append(61, 62);
        sparseIntArray.append(60, 63);
        sparseIntArray.append(27, 64);
        sparseIntArray.append(106, 65);
        sparseIntArray.append(33, 66);
        sparseIntArray.append(107, 67);
        sparseIntArray.append(Packet.SSH_FXP_DATA, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(Packet.SSH_FXP_HANDLE, 68);
        sparseIntArray.append(93, 69);
        sparseIntArray.append(71, 70);
        sparseIntArray.append(31, 71);
        sparseIntArray.append(29, 72);
        sparseIntArray.append(30, 73);
        sparseIntArray.append(32, 74);
        sparseIntArray.append(28, 75);
        sparseIntArray.append(Packet.SSH_FXP_NAME, 76);
        sparseIntArray.append(83, 77);
        sparseIntArray.append(108, 78);
        sparseIntArray.append(53, 80);
        sparseIntArray.append(52, 81);
    }

    public static int[] c(j5 j5Var, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = j5Var.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = h30.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && j5Var.isInEditMode() && (j5Var.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) j5Var.getParent();
                if (strTrim != null) {
                    HashMap map = constraintLayout.u;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.u.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public static bb d(Context context, AttributeSet attributeSet) {
        bb bbVar = new bb();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i30.a);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            db dbVar = bbVar.c;
            fb fbVar = bbVar.e;
            cb cbVar = bbVar.d;
            if (index != 1 && 23 != index && 24 != index) {
                dbVar.getClass();
                cbVar.getClass();
                fbVar.getClass();
            }
            SparseIntArray sparseIntArray = e;
            int i2 = sparseIntArray.get(index);
            eb ebVar = bbVar.b;
            switch (i2) {
                case 1:
                    cbVar.o = f(typedArrayObtainStyledAttributes, index, cbVar.o);
                    break;
                case 2:
                    cbVar.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.F);
                    break;
                case 3:
                    cbVar.n = f(typedArrayObtainStyledAttributes, index, cbVar.n);
                    break;
                case 4:
                    cbVar.m = f(typedArrayObtainStyledAttributes, index, cbVar.m);
                    break;
                case 5:
                    cbVar.v = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    cbVar.z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, cbVar.z);
                    break;
                case 7:
                    cbVar.A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, cbVar.A);
                    break;
                case 8:
                    cbVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.G);
                    break;
                case 9:
                    cbVar.s = f(typedArrayObtainStyledAttributes, index, cbVar.s);
                    break;
                case 10:
                    cbVar.r = f(typedArrayObtainStyledAttributes, index, cbVar.r);
                    break;
                case 11:
                    cbVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.L);
                    break;
                case 12:
                    cbVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.M);
                    break;
                case 13:
                    cbVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.I);
                    break;
                case 14:
                    cbVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.K);
                    break;
                case 15:
                    cbVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.N);
                    break;
                case 16:
                    cbVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.J);
                    break;
                case 17:
                    cbVar.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, cbVar.d);
                    break;
                case 18:
                    cbVar.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, cbVar.e);
                    break;
                case 19:
                    cbVar.f = typedArrayObtainStyledAttributes.getFloat(index, cbVar.f);
                    break;
                case 20:
                    cbVar.t = typedArrayObtainStyledAttributes.getFloat(index, cbVar.t);
                    break;
                case 21:
                    cbVar.c = typedArrayObtainStyledAttributes.getLayoutDimension(index, cbVar.c);
                    break;
                case ErrorCodes.SSH_FX_CANNOT_DELETE /* 22 */:
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, ebVar.a);
                    ebVar.a = i3;
                    ebVar.a = d[i3];
                    break;
                case ErrorCodes.SSH_FX_INVALID_PARAMETER /* 23 */:
                    cbVar.b = typedArrayObtainStyledAttributes.getLayoutDimension(index, cbVar.b);
                    break;
                case ErrorCodes.SSH_FX_FILE_IS_A_DIRECTORY /* 24 */:
                    cbVar.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.C);
                    break;
                case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_CONFLICT /* 25 */:
                    cbVar.g = f(typedArrayObtainStyledAttributes, index, cbVar.g);
                    break;
                case ErrorCodes.SSH_FX_BYTE_RANGE_LOCK_REFUSED /* 26 */:
                    cbVar.h = f(typedArrayObtainStyledAttributes, index, cbVar.h);
                    break;
                case ErrorCodes.SSH_FX_DELETE_PENDING /* 27 */:
                    cbVar.B = typedArrayObtainStyledAttributes.getInt(index, cbVar.B);
                    break;
                case ErrorCodes.SSH_FX_FILE_CORRUPT /* 28 */:
                    cbVar.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.D);
                    break;
                case ErrorCodes.SSH_FX_OWNER_INVALID /* 29 */:
                    cbVar.i = f(typedArrayObtainStyledAttributes, index, cbVar.i);
                    break;
                case 30:
                    cbVar.j = f(typedArrayObtainStyledAttributes, index, cbVar.j);
                    break;
                case 31:
                    cbVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.H);
                    break;
                case 32:
                    cbVar.p = f(typedArrayObtainStyledAttributes, index, cbVar.p);
                    break;
                case Packets.SSH_MSG_KEX_DH_GEX_REPLY /* 33 */:
                    cbVar.q = f(typedArrayObtainStyledAttributes, index, cbVar.q);
                    break;
                case Packets.SSH_MSG_KEX_DH_GEX_REQUEST /* 34 */:
                    cbVar.E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.E);
                    break;
                case 35:
                    cbVar.l = f(typedArrayObtainStyledAttributes, index, cbVar.l);
                    break;
                case 36:
                    cbVar.k = f(typedArrayObtainStyledAttributes, index, cbVar.k);
                    break;
                case 37:
                    cbVar.u = typedArrayObtainStyledAttributes.getFloat(index, cbVar.u);
                    break;
                case 38:
                    bbVar.a = typedArrayObtainStyledAttributes.getResourceId(index, bbVar.a);
                    break;
                case 39:
                    cbVar.P = typedArrayObtainStyledAttributes.getFloat(index, cbVar.P);
                    break;
                case 40:
                    cbVar.O = typedArrayObtainStyledAttributes.getFloat(index, cbVar.O);
                    break;
                case 41:
                    cbVar.Q = typedArrayObtainStyledAttributes.getInt(index, cbVar.Q);
                    break;
                case 42:
                    cbVar.R = typedArrayObtainStyledAttributes.getInt(index, cbVar.R);
                    break;
                case 43:
                    ebVar.c = typedArrayObtainStyledAttributes.getFloat(index, ebVar.c);
                    break;
                case 44:
                    fbVar.k = true;
                    fbVar.l = typedArrayObtainStyledAttributes.getDimension(index, fbVar.l);
                    break;
                case 45:
                    fbVar.b = typedArrayObtainStyledAttributes.getFloat(index, fbVar.b);
                    break;
                case 46:
                    fbVar.c = typedArrayObtainStyledAttributes.getFloat(index, fbVar.c);
                    break;
                case 47:
                    fbVar.d = typedArrayObtainStyledAttributes.getFloat(index, fbVar.d);
                    break;
                case 48:
                    fbVar.e = typedArrayObtainStyledAttributes.getFloat(index, fbVar.e);
                    break;
                case 49:
                    fbVar.f = typedArrayObtainStyledAttributes.getDimension(index, fbVar.f);
                    break;
                case Packets.SSH_MSG_USERAUTH_REQUEST /* 50 */:
                    fbVar.g = typedArrayObtainStyledAttributes.getDimension(index, fbVar.g);
                    break;
                case Packets.SSH_MSG_USERAUTH_FAILURE /* 51 */:
                    fbVar.h = typedArrayObtainStyledAttributes.getDimension(index, fbVar.h);
                    break;
                case Packets.SSH_MSG_USERAUTH_SUCCESS /* 52 */:
                    fbVar.i = typedArrayObtainStyledAttributes.getDimension(index, fbVar.i);
                    break;
                case Packets.SSH_MSG_USERAUTH_BANNER /* 53 */:
                    fbVar.j = typedArrayObtainStyledAttributes.getDimension(index, fbVar.j);
                    break;
                case 54:
                    cbVar.S = typedArrayObtainStyledAttributes.getInt(index, cbVar.S);
                    break;
                case 55:
                    cbVar.T = typedArrayObtainStyledAttributes.getInt(index, cbVar.T);
                    break;
                case 56:
                    cbVar.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.U);
                    break;
                case 57:
                    cbVar.V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.V);
                    break;
                case 58:
                    cbVar.W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.W);
                    break;
                case 59:
                    cbVar.X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.X);
                    break;
                case Packets.SSH_MSG_USERAUTH_INFO_REQUEST /* 60 */:
                    fbVar.a = typedArrayObtainStyledAttributes.getFloat(index, fbVar.a);
                    break;
                case Packets.SSH_MSG_USERAUTH_INFO_RESPONSE /* 61 */:
                    cbVar.w = f(typedArrayObtainStyledAttributes, index, cbVar.w);
                    break;
                case 62:
                    cbVar.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.x);
                    break;
                case 63:
                    cbVar.y = typedArrayObtainStyledAttributes.getFloat(index, cbVar.y);
                    break;
                case 64:
                    dbVar.a = f(typedArrayObtainStyledAttributes, index, dbVar.a);
                    break;
                case 65:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        dbVar.getClass();
                    } else {
                        String str = wf0.b[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        dbVar.getClass();
                    }
                    break;
                case 66:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    dbVar.getClass();
                    break;
                case 67:
                    dbVar.d = typedArrayObtainStyledAttributes.getFloat(index, dbVar.d);
                    break;
                case 68:
                    ebVar.d = typedArrayObtainStyledAttributes.getFloat(index, ebVar.d);
                    break;
                case 69:
                    cbVar.Y = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    cbVar.Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    cbVar.a0 = typedArrayObtainStyledAttributes.getInt(index, cbVar.a0);
                    break;
                case 73:
                    cbVar.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, cbVar.b0);
                    break;
                case 74:
                    cbVar.e0 = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 75:
                    cbVar.i0 = typedArrayObtainStyledAttributes.getBoolean(index, cbVar.i0);
                    break;
                case 76:
                    dbVar.b = typedArrayObtainStyledAttributes.getInt(index, dbVar.b);
                    break;
                case 77:
                    cbVar.f0 = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 78:
                    ebVar.b = typedArrayObtainStyledAttributes.getInt(index, ebVar.b);
                    break;
                case 79:
                    dbVar.c = typedArrayObtainStyledAttributes.getFloat(index, dbVar.c);
                    break;
                case Packets.SSH_MSG_GLOBAL_REQUEST /* 80 */:
                    cbVar.g0 = typedArrayObtainStyledAttributes.getBoolean(index, cbVar.g0);
                    break;
                case Packets.SSH_MSG_REQUEST_SUCCESS /* 81 */:
                    cbVar.h0 = typedArrayObtainStyledAttributes.getBoolean(index, cbVar.h0);
                    break;
                case Packets.SSH_MSG_REQUEST_FAILURE /* 82 */:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return bbVar;
    }

    public static int f(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(ConstraintLayout constraintLayout) {
        int i;
        HashSet hashSet;
        int i2;
        int i3;
        String resourceEntryName;
        gb gbVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = gbVar.c;
        HashSet<Integer> hashSet2 = new HashSet(map.keySet());
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = constraintLayout.getChildAt(i4);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (gbVar.b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map.containsKey(Integer.valueOf(id))) {
                        hashSet2.remove(Integer.valueOf(id));
                        bb bbVar = (bb) map.get(Integer.valueOf(id));
                        if (childAt instanceof j5) {
                            bbVar.d.c0 = 1;
                        }
                        cb cbVar = bbVar.d;
                        eb ebVar = bbVar.b;
                        fb fbVar = bbVar.e;
                        int i5 = cbVar.c0;
                        if (i5 != -1 && i5 == 1) {
                            j5 j5Var = (j5) childAt;
                            j5Var.setId(id);
                            j5Var.setType(cbVar.a0);
                            j5Var.setMargin(cbVar.b0);
                            j5Var.setAllowsGoneWidget(cbVar.i0);
                            int[] iArr = cbVar.d0;
                            if (iArr != null) {
                                j5Var.setReferencedIds(iArr);
                            } else {
                                String str = cbVar.e0;
                                if (str != null) {
                                    int[] iArrC = c(j5Var, str);
                                    cbVar.d0 = iArrC;
                                    j5Var.setReferencedIds(iArrC);
                                }
                            }
                        }
                        xa xaVar = (xa) childAt.getLayoutParams();
                        xaVar.a();
                        bbVar.a(xaVar);
                        HashMap map2 = bbVar.f;
                        Class<?> cls = childAt.getClass();
                        for (String str2 : map2.keySet()) {
                            ua uaVar = (ua) map2.get(str2);
                            int i6 = childCount;
                            String strS = za0.s("set", str2);
                            HashSet hashSet3 = hashSet2;
                            try {
                                int iU = za0.u(uaVar.a);
                                Class cls2 = Integer.TYPE;
                                Class cls3 = Float.TYPE;
                                switch (iU) {
                                    case 0:
                                        i3 = i4;
                                        cls.getMethod(strS, cls2).invoke(childAt, Integer.valueOf(uaVar.b));
                                        break;
                                    case 1:
                                        i3 = i4;
                                        cls.getMethod(strS, cls3).invoke(childAt, Float.valueOf(uaVar.c));
                                        break;
                                    case 2:
                                        i3 = i4;
                                        cls.getMethod(strS, cls2).invoke(childAt, Integer.valueOf(uaVar.f));
                                        break;
                                    case 3:
                                        Method method = cls.getMethod(strS, Drawable.class);
                                        i3 = i4;
                                        try {
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(uaVar.f);
                                            method.invoke(childAt, colorDrawable);
                                        } catch (IllegalAccessException e2) {
                                            e = e2;
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                            e.printStackTrace();
                                        } catch (NoSuchMethodException e3) {
                                            e = e3;
                                            Log.e("TransitionLayout", e.getMessage());
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + strS);
                                        } catch (InvocationTargetException e4) {
                                            e = e4;
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                            e.printStackTrace();
                                        }
                                        break;
                                    case 4:
                                        cls.getMethod(strS, CharSequence.class).invoke(childAt, uaVar.d);
                                        i3 = i4;
                                        break;
                                    case 5:
                                        cls.getMethod(strS, Boolean.TYPE).invoke(childAt, Boolean.valueOf(uaVar.e));
                                        i3 = i4;
                                        break;
                                    case 6:
                                        cls.getMethod(strS, cls3).invoke(childAt, Float.valueOf(uaVar.c));
                                        i3 = i4;
                                        break;
                                    default:
                                        i3 = i4;
                                        break;
                                }
                            } catch (IllegalAccessException e5) {
                                e = e5;
                                i3 = i4;
                            } catch (NoSuchMethodException e6) {
                                e = e6;
                                i3 = i4;
                            } catch (InvocationTargetException e7) {
                                e = e7;
                                i3 = i4;
                            }
                            childCount = i6;
                            hashSet2 = hashSet3;
                            i4 = i3;
                        }
                        i = childCount;
                        hashSet = hashSet2;
                        i2 = i4;
                        childAt.setLayoutParams(xaVar);
                        if (ebVar.b == 0) {
                            childAt.setVisibility(ebVar.a);
                        }
                        childAt.setAlpha(ebVar.c);
                        childAt.setRotation(fbVar.a);
                        childAt.setRotationX(fbVar.b);
                        childAt.setRotationY(fbVar.c);
                        childAt.setScaleX(fbVar.d);
                        childAt.setScaleY(fbVar.e);
                        if (!Float.isNaN(fbVar.f)) {
                            childAt.setPivotX(fbVar.f);
                        }
                        if (!Float.isNaN(fbVar.g)) {
                            childAt.setPivotY(fbVar.g);
                        }
                        childAt.setTranslationX(fbVar.h);
                        childAt.setTranslationY(fbVar.i);
                        childAt.setTranslationZ(fbVar.j);
                        if (fbVar.k) {
                            childAt.setElevation(fbVar.l);
                        }
                    } else {
                        i = childCount;
                        hashSet = hashSet2;
                        i2 = i4;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i4 = i2 + 1;
                gbVar = this;
                childCount = i;
                hashSet2 = hashSet;
            }
            i = childCount;
            hashSet = hashSet2;
            i2 = i4;
            i4 = i2 + 1;
            gbVar = this;
            childCount = i;
            hashSet2 = hashSet;
        }
        for (Integer num : hashSet2) {
            bb bbVar2 = (bb) map.get(num);
            cb cbVar2 = bbVar2.d;
            int i7 = cbVar2.c0;
            if (i7 != -1 && i7 == 1) {
                Context context = constraintLayout.getContext();
                j5 j5Var2 = new j5(context);
                j5Var2.a = new int[32];
                j5Var2.h = new HashMap();
                j5Var2.c = context;
                k5 k5Var = new k5();
                k5Var.f0 = 0;
                k5Var.g0 = true;
                k5Var.h0 = 0;
                j5Var2.q = k5Var;
                j5Var2.d = k5Var;
                j5Var2.g();
                j5Var2.setVisibility(8);
                j5Var2.setId(num.intValue());
                int[] iArr2 = cbVar2.d0;
                if (iArr2 != null) {
                    j5Var2.setReferencedIds(iArr2);
                } else {
                    String str3 = cbVar2.e0;
                    if (str3 != null) {
                        int[] iArrC2 = c(j5Var2, str3);
                        cbVar2.d0 = iArrC2;
                        j5Var2.setReferencedIds(iArrC2);
                    }
                }
                j5Var2.setType(cbVar2.a0);
                j5Var2.setMargin(cbVar2.b0);
                xa xaVarA = ConstraintLayout.a();
                j5Var2.g();
                bbVar2.a(xaVarA);
                constraintLayout.addView(j5Var2, xaVarA);
            }
            if (cbVar2.a) {
                View gqVar = new gq(constraintLayout.getContext());
                gqVar.setId(num.intValue());
                xa xaVarA2 = ConstraintLayout.a();
                bbVar2.a(xaVarA2);
                constraintLayout.addView(gqVar, xaVarA2);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        gb gbVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = gbVar.c;
        map.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            xa xaVar = (xa) childAt.getLayoutParams();
            int id = childAt.getId();
            if (gbVar.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new bb());
            }
            bb bbVar = (bb) map.get(Integer.valueOf(id));
            HashMap map2 = new HashMap();
            Class<?> cls = childAt.getClass();
            HashMap map3 = gbVar.a;
            for (String str : map3.keySet()) {
                ua uaVar = (ua) map3.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        map2.put(str, new ua(uaVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                    } else {
                        map2.put(str, new ua(uaVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                    }
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NoSuchMethodException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                }
            }
            bbVar.f = map2;
            eb ebVar = bbVar.b;
            cb cbVar = bbVar.d;
            fb fbVar = bbVar.e;
            bbVar.a = id;
            cbVar.g = xaVar.d;
            cbVar.h = xaVar.e;
            cbVar.i = xaVar.f;
            cbVar.j = xaVar.g;
            cbVar.k = xaVar.h;
            cbVar.l = xaVar.i;
            cbVar.m = xaVar.j;
            cbVar.n = xaVar.k;
            cbVar.o = xaVar.l;
            cbVar.p = xaVar.p;
            cbVar.q = xaVar.q;
            cbVar.r = xaVar.r;
            cbVar.s = xaVar.s;
            cbVar.t = xaVar.z;
            cbVar.u = xaVar.A;
            cbVar.v = xaVar.B;
            cbVar.w = xaVar.m;
            cbVar.x = xaVar.n;
            cbVar.y = xaVar.o;
            cbVar.z = xaVar.P;
            cbVar.A = xaVar.Q;
            cbVar.B = xaVar.R;
            cbVar.f = xaVar.c;
            cbVar.d = xaVar.a;
            cbVar.e = xaVar.b;
            cbVar.b = ((ViewGroup.MarginLayoutParams) xaVar).width;
            cbVar.c = ((ViewGroup.MarginLayoutParams) xaVar).height;
            cbVar.C = ((ViewGroup.MarginLayoutParams) xaVar).leftMargin;
            cbVar.D = ((ViewGroup.MarginLayoutParams) xaVar).rightMargin;
            cbVar.E = ((ViewGroup.MarginLayoutParams) xaVar).topMargin;
            cbVar.F = ((ViewGroup.MarginLayoutParams) xaVar).bottomMargin;
            cbVar.O = xaVar.E;
            cbVar.P = xaVar.D;
            cbVar.R = xaVar.G;
            cbVar.Q = xaVar.F;
            cbVar.g0 = xaVar.S;
            cbVar.h0 = xaVar.T;
            cbVar.S = xaVar.H;
            cbVar.T = xaVar.I;
            cbVar.U = xaVar.L;
            cbVar.V = xaVar.M;
            cbVar.W = xaVar.J;
            cbVar.X = xaVar.K;
            cbVar.Y = xaVar.N;
            cbVar.Z = xaVar.O;
            cbVar.f0 = xaVar.U;
            cbVar.J = xaVar.u;
            cbVar.L = xaVar.w;
            cbVar.I = xaVar.t;
            cbVar.K = xaVar.v;
            cbVar.N = xaVar.x;
            cbVar.M = xaVar.y;
            cbVar.G = xaVar.getMarginEnd();
            cbVar.H = xaVar.getMarginStart();
            ebVar.a = childAt.getVisibility();
            ebVar.c = childAt.getAlpha();
            fbVar.a = childAt.getRotation();
            fbVar.b = childAt.getRotationX();
            fbVar.c = childAt.getRotationY();
            fbVar.d = childAt.getScaleX();
            fbVar.e = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                fbVar.f = pivotX;
                fbVar.g = pivotY;
            }
            fbVar.h = childAt.getTranslationX();
            fbVar.i = childAt.getTranslationY();
            fbVar.j = childAt.getTranslationZ();
            if (fbVar.k) {
                fbVar.l = childAt.getElevation();
            }
            if (childAt instanceof j5) {
                j5 j5Var = (j5) childAt;
                cbVar.i0 = j5Var.q.g0;
                cbVar.d0 = j5Var.getReferencedIds();
                cbVar.a0 = j5Var.getType();
                cbVar.b0 = j5Var.getMargin();
            }
            i++;
            gbVar = this;
        }
    }

    public final void e(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    bb bbVarD = d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        bbVarD.d.a = true;
                    }
                    this.c.put(Integer.valueOf(bbVarD.a), bbVarD);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }
}
