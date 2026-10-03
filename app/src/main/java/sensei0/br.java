package sensei0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import net.sourceforge.jsocks.Proxy;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class br extends BaseInputConnection implements tu {
    public final nn a;
    public final int b;
    public final i3 c;
    public final uu d;
    public final EditorInfo e;
    public ExtractedTextRequest f;
    public boolean g;
    public CursorAnchorInfo.Builder h;
    public final ExtractedText i;
    public final InputMethodManager j;
    public final DynamicLayout k;
    public final sv l;
    public final o4 m;
    public int n;

    public br(nn nnVar, int i, i3 i3Var, o4 o4Var, uu uuVar, EditorInfo editorInfo) {
        FlutterJNI flutterJNI = new FlutterJNI();
        super(nnVar, true);
        this.g = false;
        this.i = new ExtractedText();
        this.n = 0;
        this.a = nnVar;
        this.b = i;
        this.c = i3Var;
        this.d = uuVar;
        uuVar.a(this);
        this.e = editorInfo;
        this.m = o4Var;
        this.l = new sv(24, flutterJNI);
        this.k = new DynamicLayout(uuVar, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.j = (InputMethodManager) nnVar.getContext().getSystemService("input_method");
    }

    @Override // sensei0.tu
    public final void a(boolean z) {
        uu uuVar = this.d;
        uuVar.getClass();
        int selectionStart = Selection.getSelectionStart(uuVar);
        int selectionEnd = Selection.getSelectionEnd(uuVar);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(uuVar);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(uuVar);
        InputMethodManager inputMethodManager = this.j;
        nn nnVar = this.a;
        inputMethodManager.updateSelection(nnVar, selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
        ExtractedTextRequest extractedTextRequest = this.f;
        if (extractedTextRequest != null) {
            inputMethodManager.updateExtractedText(nnVar, extractedTextRequest.token, c(extractedTextRequest));
        }
        if (this.g) {
            inputMethodManager.updateCursorAnchorInfo(nnVar, b());
        }
    }

    public final CursorAnchorInfo b() {
        CursorAnchorInfo.Builder builder = this.h;
        if (builder == null) {
            this.h = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        CursorAnchorInfo.Builder builder2 = this.h;
        uu uuVar = this.d;
        uuVar.getClass();
        int selectionStart = Selection.getSelectionStart(uuVar);
        uuVar.getClass();
        builder2.setSelectionRange(selectionStart, Selection.getSelectionEnd(uuVar));
        uuVar.getClass();
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(uuVar);
        uuVar.getClass();
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(uuVar);
        if (composingSpanStart < 0 || composingSpanEnd <= composingSpanStart) {
            this.h.setComposingText(-1, "");
        } else {
            this.h.setComposingText(composingSpanStart, uuVar.toString().subSequence(composingSpanStart, composingSpanEnd));
        }
        return this.h.build();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        this.d.b();
        this.n++;
        return super.beginBatchEdit();
    }

    public final ExtractedText c(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.i;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        CharSequence string = this.d;
        string.getClass();
        extractedText.selectionStart = Selection.getSelectionStart(string);
        string.getClass();
        extractedText.selectionEnd = Selection.getSelectionEnd(string);
        if (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) {
            string = string.toString();
        }
        extractedText.text = string;
        return extractedText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final void closeConnection() {
        super.closeConnection();
        this.d.e(this);
        while (this.n > 0) {
            endBatchEdit();
            this.n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        int i2;
        if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                if (inputContentInfo.getDescription().getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    Uri contentUri = inputContentInfo.getContentUri();
                    String mimeType = inputContentInfo.getDescription().getMimeType(0);
                    Context context = this.a.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (inputStreamOpenInputStream != null) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[Proxy.SOCKS_NO_PROXY];
                                while (true) {
                                    try {
                                        i2 = inputStreamOpenInputStream.read(bArr);
                                    } catch (IOException unused) {
                                        i2 = -1;
                                    }
                                    if (i2 == -1) {
                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                        HashMap map = new HashMap();
                                        map.put("mimeType", mimeType);
                                        map.put("data", byteArray);
                                        map.put("uri", contentUri.toString());
                                        ((aj) this.c.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(this.b), "TextInputAction.commitContent", map), null);
                                        inputContentInfo.releasePermission();
                                        return true;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i2);
                                }
                            }
                        } catch (FileNotFoundException unused2) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused3) {
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x0285, code lost:
    
        r14 = r14 + r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0040 A[ADDED_TO_REGION, EDGE_INSN: B:197:0x0040->B:18:0x0040 BREAK  A[LOOP:2: B:63:0x00fb->B:200:?], REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x01ab A[ADDED_TO_REGION, EDGE_INSN: B:205:0x01ab->B:108:0x01ab BREAK  A[LOOP:4: B:143:0x022c->B:210:?], REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0174 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(boolean r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 737
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.br.d(boolean, boolean):boolean");
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        uu uuVar = this.d;
        uuVar.getClass();
        if (Selection.getSelectionStart(uuVar) == -1) {
            return true;
        }
        return super.deleteSurroundingText(i, i2);
    }

    public final boolean e(boolean z, boolean z2) {
        uu uuVar = this.d;
        int selectionStart = Selection.getSelectionStart(uuVar);
        int selectionEnd = Selection.getSelectionEnd(uuVar);
        boolean z3 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z2) {
            z3 = true;
        }
        beginBatchEdit();
        DynamicLayout dynamicLayout = this.k;
        if (z3) {
            if (z) {
                Selection.moveUp(uuVar, dynamicLayout);
            } else {
                Selection.moveDown(uuVar, dynamicLayout);
            }
            int selectionStart2 = Selection.getSelectionStart(uuVar);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z) {
                Selection.extendUp(uuVar, dynamicLayout);
            } else {
                Selection.extendDown(uuVar, dynamicLayout);
            }
            setSelection(Selection.getSelectionStart(uuVar), Selection.getSelectionEnd(uuVar));
        }
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        boolean zEndBatchEdit = super.endBatchEdit();
        this.n--;
        this.d.c();
        return zEndBatchEdit;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public final Editable getEditable() {
        return this.d;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        this.f = (i & 1) != 0 ? extractedTextRequest : null;
        return c(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int i) {
        beginBatchEdit();
        boolean z = true;
        uu uuVar = this.d;
        if (i == 16908319) {
            setSelection(0, uuVar.length());
        } else {
            nn nnVar = this.a;
            if (i == 16908320) {
                int selectionStart = Selection.getSelectionStart(uuVar);
                int selectionEnd = Selection.getSelectionEnd(uuVar);
                if (selectionStart != selectionEnd) {
                    int iMin = Math.min(selectionStart, selectionEnd);
                    int iMax = Math.max(selectionStart, selectionEnd);
                    ((ClipboardManager) nnVar.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", uuVar.subSequence(iMin, iMax)));
                    uuVar.delete(iMin, iMax);
                    setSelection(iMin, iMin);
                }
            } else if (i == 16908321) {
                int selectionStart2 = Selection.getSelectionStart(uuVar);
                int selectionEnd2 = Selection.getSelectionEnd(uuVar);
                if (selectionStart2 != selectionEnd2) {
                    ((ClipboardManager) nnVar.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", uuVar.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
                }
            } else if (i == 16908322) {
                ClipData primaryClip = ((ClipboardManager) nnVar.getContext().getSystemService("clipboard")).getPrimaryClip();
                if (primaryClip != null) {
                    CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(nnVar.getContext());
                    int iMax2 = Math.max(0, Selection.getSelectionStart(uuVar));
                    int iMax3 = Math.max(0, Selection.getSelectionEnd(uuVar));
                    int iMin2 = Math.min(iMax2, iMax3);
                    int iMax4 = Math.max(iMax2, iMax3);
                    if (iMin2 != iMax4) {
                        uuVar.delete(iMin2, iMax4);
                    }
                    uuVar.insert(iMin2, charSequenceCoerceToText);
                    int length = charSequenceCoerceToText.length() + iMin2;
                    setSelection(length, length);
                }
            } else {
                z = false;
            }
        }
        endBatchEdit();
        return z;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i) {
        int i2 = this.b;
        i3 i3Var = this.c;
        if (i == 0) {
            ((aj) i3Var.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.unspecified"), null);
            return true;
        }
        if (i == 1) {
            ((aj) i3Var.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.newline"), null);
            return true;
        }
        if (i == 2) {
            ((aj) i3Var.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.go"), null);
            return true;
        }
        if (i == 3) {
            ((aj) i3Var.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.search"), null);
            return true;
        }
        if (i == 4) {
            ((aj) i3Var.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.send"), null);
            return true;
        }
        if (i == 5) {
            ((aj) i3Var.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.next"), null);
            return true;
        }
        if (i != 7) {
            ((aj) i3Var.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.done"), null);
            return true;
        }
        ((aj) i3Var.b).a("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i2), "TextInputAction.previous"), null);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        i3 i3Var = this.c;
        i3Var.getClass();
        HashMap map = new HashMap();
        map.put("action", str);
        if (bundle != null) {
            HashMap map2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    map2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    map2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    map2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    map2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    map2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    map2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    map2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    map2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            map.put("data", map2);
        }
        ((aj) i3Var.b).a("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(this.b), map), null);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i) {
        if ((i & 1) != 0) {
            this.j.updateCursorAnchorInfo(this.a, b());
        }
        this.g = (i & 2) != 0;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.m.L(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) {
        beginBatchEdit();
        boolean zCommitText = charSequence.length() == 0 ? super.commitText(charSequence, i) : super.setComposingText(charSequence, i);
        endBatchEdit();
        return zCommitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setSelection(int i, int i2) {
        beginBatchEdit();
        boolean selection = super.setSelection(i, i2);
        endBatchEdit();
        return selection;
    }
}
