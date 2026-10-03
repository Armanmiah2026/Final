package io.flutter.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import sensei0.qs;
import sensei0.s1;
import sensei0.t1;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@qs
class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private int nextFlutterId;
    private final View rootAccessibilityView;
    private final s1 reflectionAccessors = new s1();
    private final SparseArray<t1> flutterIdToOrigin = new SparseArray<>();
    private final Map<t1, Integer> originToFlutterId = new HashMap();
    private final Map<View, Rect> embeddedViewToDisplayBounds = new HashMap();

    public AccessibilityViewEmbedder(View view, int i) {
        this.rootAccessibilityView = view;
        this.nextFlutterId = i;
    }

    private void addChildrenToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Long l;
        int iIntValue;
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            s1 s1Var = this.reflectionAccessors;
            Method method = s1Var.f;
            Field field = s1Var.e;
            Method method2 = s1Var.d;
            if (method2 == null && (field == null || method == null)) {
                l = null;
            } else if (method2 != null) {
                try {
                    l = (Long) method2.invoke(accessibilityNodeInfo, Integer.valueOf(i));
                } catch (IllegalAccessException e) {
                    Log.w(TAG, "Failed to access getChildId method.", e);
                    l = null;
                } catch (InvocationTargetException e2) {
                    Log.w(TAG, "The getChildId method threw an exception when invoked.", e2);
                    l = null;
                }
            } else {
                try {
                    l = (Long) method.invoke(field.get(accessibilityNodeInfo), Integer.valueOf(i));
                    l.getClass();
                } catch (ArrayIndexOutOfBoundsException e3) {
                    e = e3;
                    Log.w(TAG, "The longArrayGetIndex method threw an exception when invoked.", e);
                    l = null;
                } catch (IllegalAccessException e4) {
                    Log.w(TAG, "Failed to access longArrayGetIndex method or the childNodeId field.", e4);
                    l = null;
                } catch (InvocationTargetException e5) {
                    e = e5;
                    Log.w(TAG, "The longArrayGetIndex method threw an exception when invoked.", e);
                    l = null;
                }
            }
            if (l != null) {
                int iLongValue = (int) (l.longValue() >> 32);
                t1 t1Var = new t1(view, iLongValue);
                if (this.originToFlutterId.containsKey(t1Var)) {
                    iIntValue = this.originToFlutterId.get(t1Var).intValue();
                } else {
                    int i2 = this.nextFlutterId;
                    this.nextFlutterId = i2 + 1;
                    cacheVirtualIdMappings(view, iLongValue, i2);
                    iIntValue = i2;
                }
                accessibilityNodeInfo2.addChild(this.rootAccessibilityView, iIntValue);
            }
        }
    }

    private void cacheVirtualIdMappings(View view, int i, int i2) {
        t1 t1Var = new t1(view, i);
        this.originToFlutterId.put(t1Var, Integer.valueOf(i2));
        this.flutterIdToOrigin.put(i2, t1Var);
    }

    private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, int i, View view) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i);
        accessibilityNodeInfoObtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        accessibilityNodeInfoObtain.setSource(this.rootAccessibilityView, i);
        accessibilityNodeInfoObtain.setClassName(accessibilityNodeInfo.getClassName());
        Rect rect = this.embeddedViewToDisplayBounds.get(view);
        copyAccessibilityFields(accessibilityNodeInfo, accessibilityNodeInfoObtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, rect, accessibilityNodeInfoObtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, accessibilityNodeInfoObtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, accessibilityNodeInfoObtain);
        return accessibilityNodeInfoObtain;
    }

    private void copyAccessibilityFields(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
        accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
        accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
        accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
        accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
        accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
        accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
        accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
        accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
        accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        accessibilityNodeInfo2.setContextClickable(accessibilityNodeInfo.isContextClickable());
        accessibilityNodeInfo2.setDrawingOrder(accessibilityNodeInfo.getDrawingOrder());
        accessibilityNodeInfo2.setImportantForAccessibility(accessibilityNodeInfo.isImportantForAccessibility());
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo2.setAvailableExtraData(accessibilityNodeInfo.getAvailableExtraData());
            accessibilityNodeInfo2.setHintText(accessibilityNodeInfo.getHintText());
            accessibilityNodeInfo2.setShowingHintText(accessibilityNodeInfo.isShowingHintText());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setFlutterNodeParent(android.view.accessibility.AccessibilityNodeInfo r6, android.view.View r7, android.view.accessibility.AccessibilityNodeInfo r8) {
        /*
            r5 = this;
            sensei0.s1 r0 = r5.reflectionAccessors
            java.lang.reflect.Method r0 = r0.b
            r1 = 0
            java.lang.String r2 = "AccessibilityBridge"
            if (r0 == 0) goto L22
            java.lang.Object r0 = r0.invoke(r6, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            r0.getClass()     // Catch: java.lang.reflect.InvocationTargetException -> L13 java.lang.IllegalAccessException -> L15
            goto L74
        L13:
            r0 = move-exception
            goto L17
        L15:
            r0 = move-exception
            goto L1d
        L17:
            java.lang.String r3 = "The getParentNodeId method threw an exception when invoked."
            android.util.Log.w(r2, r3, r0)
            goto L22
        L1d:
            java.lang.String r3 = "Failed to access getParentNodeId method."
            android.util.Log.w(r2, r3, r0)
        L22:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r0 >= r3) goto L2e
            java.lang.String r6 = "Unexpected Android version. Unable to find the parent ID."
            android.util.Log.w(r2, r6)
            goto L73
        L2e:
            android.view.accessibility.AccessibilityNodeInfo r6 = android.view.accessibility.AccessibilityNodeInfo.obtain(r6)
            android.os.Parcel r0 = android.os.Parcel.obtain()
            r2 = 0
            r0.setDataPosition(r2)
            r6.writeToParcel(r0, r2)
            r0.setDataPosition(r2)
            long r3 = r0.readLong()
            boolean r6 = sensei0.s1.b(r2, r3)
            if (r6 == 0) goto L4d
            r0.readInt()
        L4d:
            r6 = 1
            boolean r6 = sensei0.s1.b(r6, r3)
            if (r6 == 0) goto L57
            r0.readLong()
        L57:
            r6 = 2
            boolean r6 = sensei0.s1.b(r6, r3)
            if (r6 == 0) goto L61
            r0.readInt()
        L61:
            r6 = 3
            boolean r6 = sensei0.s1.b(r6, r3)
            if (r6 == 0) goto L70
            long r1 = r0.readLong()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L70:
            r0.recycle()
        L73:
            r0 = r1
        L74:
            if (r0 != 0) goto L77
            goto L97
        L77:
            long r0 = r0.longValue()
            r6 = 32
            long r0 = r0 >> r6
            int r6 = (int) r0
            java.util.Map<sensei0.t1, java.lang.Integer> r0 = r5.originToFlutterId
            sensei0.t1 r1 = new sensei0.t1
            r1.<init>(r7, r6)
            java.lang.Object r6 = r0.get(r1)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L97
            android.view.View r7 = r5.rootAccessibilityView
            int r6 = r6.intValue()
            r8.setParent(r7, r6)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityViewEmbedder.setFlutterNodeParent(android.view.accessibility.AccessibilityNodeInfo, android.view.View, android.view.accessibility.AccessibilityNodeInfo):void");
    }

    private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo;
        t1 t1Var = this.flutterIdToOrigin.get(i);
        if (t1Var == null) {
            return null;
        }
        View view = t1Var.a;
        if (!this.embeddedViewToDisplayBounds.containsKey(view) || view.getAccessibilityNodeProvider() == null || (accessibilityNodeInfoCreateAccessibilityNodeInfo = view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(t1Var.b)) == null) {
            return null;
        }
        return convertToFlutterNode(accessibilityNodeInfoCreateAccessibilityNodeInfo, i, view);
    }

    public Integer getRecordFlutterId(View view, AccessibilityRecord accessibilityRecord) {
        Long lA = s1.a(this.reflectionAccessors, accessibilityRecord);
        if (lA == null) {
            return null;
        }
        return this.originToFlutterId.get(new t1(view, (int) (lA.longValue() >> 32)));
    }

    public AccessibilityNodeInfo getRootNode(View view, int i, Rect rect) {
        Long l;
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
        Method method = this.reflectionAccessors.a;
        if (method == null) {
            l = null;
        } else {
            try {
                l = (Long) method.invoke(accessibilityNodeInfoCreateAccessibilityNodeInfo, null);
            } catch (IllegalAccessException e) {
                Log.w(TAG, "Failed to access getSourceNodeId method.", e);
                l = null;
            } catch (InvocationTargetException e2) {
                Log.w(TAG, "The getSourceNodeId method threw an exception when invoked.", e2);
                l = null;
            }
        }
        if (l == null) {
            return null;
        }
        this.embeddedViewToDisplayBounds.put(view, rect);
        cacheVirtualIdMappings(view, (int) (l.longValue() >> 32), i);
        return convertToFlutterNode(accessibilityNodeInfoCreateAccessibilityNodeInfo, i, view);
    }

    public boolean onAccessibilityHoverEvent(int i, MotionEvent motionEvent) {
        t1 t1Var = this.flutterIdToOrigin.get(i);
        if (t1Var == null) {
            return false;
        }
        View view = t1Var.a;
        Rect rect = this.embeddedViewToDisplayBounds.get(view);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerPropertiesArr[i2] = pointerProperties;
            motionEvent.getPointerProperties(i2, pointerProperties);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i2, pointerCoords);
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i2] = pointerCoords2;
            pointerCoords2.x -= rect.left;
            pointerCoords2.y -= rect.top;
        }
        return view.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        t1 t1Var = this.flutterIdToOrigin.get(i);
        if (t1Var == null || (accessibilityNodeProvider = t1Var.a.getAccessibilityNodeProvider()) == null) {
            return false;
        }
        return accessibilityNodeProvider.performAction(t1Var.b, i2, bundle);
    }

    public View platformViewOfNode(int i) {
        t1 t1Var = this.flutterIdToOrigin.get(i);
        if (t1Var == null) {
            return null;
        }
        return t1Var.a;
    }

    public boolean requestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long lA = s1.a(this.reflectionAccessors, accessibilityEvent);
        if (lA != null) {
            int iLongValue = (int) (lA.longValue() >> 32);
            Integer num = this.originToFlutterId.get(new t1(view, iLongValue));
            if (num == null) {
                int i = this.nextFlutterId;
                this.nextFlutterId = i + 1;
                Integer numValueOf = Integer.valueOf(i);
                cacheVirtualIdMappings(view, iLongValue, i);
                num = numValueOf;
            }
            accessibilityEventObtain.setSource(this.rootAccessibilityView, num.intValue());
            accessibilityEventObtain.setClassName(accessibilityEvent.getClassName());
            accessibilityEventObtain.setPackageName(accessibilityEvent.getPackageName());
            for (int i2 = 0; i2 < accessibilityEventObtain.getRecordCount(); i2++) {
                AccessibilityRecord record = accessibilityEventObtain.getRecord(i2);
                Long lA2 = s1.a(this.reflectionAccessors, record);
                if (lA2 != null) {
                    t1 t1Var = new t1(view, (int) (lA2.longValue() >> 32));
                    if (this.originToFlutterId.containsKey(t1Var)) {
                        record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(t1Var).intValue());
                    }
                }
            }
            return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, accessibilityEventObtain);
        }
        return false;
    }
}
