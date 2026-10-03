package sensei0;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class fg0 extends ReplacementSpan {
    public final eg0 b;
    public TextPaint f;
    public final Paint.FontMetricsInt a = new Paint.FontMetricsInt();
    public short c = -1;
    public float d = 1.0f;

    public fg0(eg0 eg0Var) {
        pr.h("rasterizer cannot be null", eg0Var);
        this.b = eg0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void draw(android.graphics.Canvas r19, java.lang.CharSequence r20, int r21, int r22, float r23, int r24, int r25, int r26, android.graphics.Paint r27) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r27
            boolean r3 = r1 instanceof android.text.Spanned
            r4 = 0
            if (r3 == 0) goto L4a
            android.text.Spanned r1 = (android.text.Spanned) r1
            java.lang.Class<android.text.style.CharacterStyle> r3 = android.text.style.CharacterStyle.class
            r5 = r21
            r6 = r22
            java.lang.Object[] r1 = r1.getSpans(r5, r6, r3)
            android.text.style.CharacterStyle[] r1 = (android.text.style.CharacterStyle[]) r1
            int r3 = r1.length
            if (r3 == 0) goto L42
            int r3 = r1.length
            r5 = 0
            r6 = 1
            if (r3 != r6) goto L26
            r3 = r1[r5]
            if (r3 != r0) goto L26
            goto L42
        L26:
            android.text.TextPaint r3 = r0.f
            if (r3 != 0) goto L31
            android.text.TextPaint r3 = new android.text.TextPaint
            r3.<init>()
            r0.f = r3
        L31:
            r4 = r3
            r4.set(r2)
        L35:
            int r3 = r1.length
            if (r5 >= r3) goto L40
            r3 = r1[r5]
            r3.updateDrawState(r4)
            int r5 = r5 + 1
            goto L35
        L40:
            r10 = r4
            goto L52
        L42:
            boolean r1 = r2 instanceof android.text.TextPaint
            if (r1 == 0) goto L40
            r4 = r2
            android.text.TextPaint r4 = (android.text.TextPaint) r4
            goto L40
        L4a:
            boolean r1 = r2 instanceof android.text.TextPaint
            if (r1 == 0) goto L40
            r4 = r2
            android.text.TextPaint r4 = (android.text.TextPaint) r4
            goto L40
        L52:
            if (r10 == 0) goto L82
            int r1 = r10.bgColor
            if (r1 == 0) goto L82
            short r1 = r0.c
            float r1 = (float) r1
            float r8 = r23 + r1
            r1 = r24
            float r7 = (float) r1
            r1 = r26
            float r9 = (float) r1
            int r1 = r10.getColor()
            android.graphics.Paint$Style r3 = r10.getStyle()
            int r4 = r10.bgColor
            r10.setColor(r4)
            android.graphics.Paint$Style r4 = android.graphics.Paint.Style.FILL
            r10.setStyle(r4)
            r5 = r19
            r6 = r23
            r5.drawRect(r6, r7, r8, r9, r10)
            r10.setStyle(r3)
            r10.setColor(r1)
        L82:
            sensei0.uh r1 = sensei0.uh.a()
            r1.getClass()
            r1 = r25
            float r1 = (float) r1
            if (r10 == 0) goto L8f
            goto L90
        L8f:
            r10 = r2
        L90:
            sensei0.eg0 r2 = r0.b
            sensei0.j1 r3 = r2.b
            java.lang.Object r4 = r3.d
            android.graphics.Typeface r4 = (android.graphics.Typeface) r4
            android.graphics.Typeface r5 = r10.getTypeface()
            r10.setTypeface(r4)
            int r2 = r2.a
            int r13 = r2 * 2
            java.lang.Object r2 = r3.b
            r12 = r2
            char[] r12 = (char[]) r12
            r14 = 2
            r11 = r19
            r15 = r23
            r16 = r1
            r17 = r10
            r11.drawText(r12, r13, r14, r15, r16, r17)
            r10.setTypeface(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.fg0.draw(android.graphics.Canvas, java.lang.CharSequence, int, int, float, int, int, int, android.graphics.Paint):void");
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        eg0 eg0Var = this.b;
        this.d = fAbs / (eg0Var.b().a(14) != 0 ? ((ByteBuffer) r8.d).getShort(r1 + r8.a) : (short) 0);
        qx qxVarB = eg0Var.b();
        int iA = qxVarB.a(14);
        if (iA != 0) {
            ((ByteBuffer) qxVarB.d).getShort(iA + qxVarB.a);
        }
        short s = (short) ((eg0Var.b().a(12) != 0 ? ((ByteBuffer) r5.d).getShort(r7 + r5.a) : (short) 0) * this.d);
        this.c = s;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s;
    }
}
