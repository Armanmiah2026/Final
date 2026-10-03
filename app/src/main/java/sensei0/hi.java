package sensei0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class hi extends xe {
    public final TextView w;
    public final di x;
    public boolean y = true;

    public hi(TextView textView) {
        this.w = textView;
        this.x = new di(textView);
    }

    @Override // sensei0.xe
    public final void E(boolean z) {
        if (z) {
            TextView textView = this.w;
            textView.setTransformationMethod(S(textView.getTransformationMethod()));
        }
    }

    @Override // sensei0.xe
    public final void F(boolean z) {
        this.y = z;
        TextView textView = this.w;
        textView.setTransformationMethod(S(textView.getTransformationMethod()));
        textView.setFilters(n(textView.getFilters()));
    }

    @Override // sensei0.xe
    public final TransformationMethod S(TransformationMethod transformationMethod) {
        return this.y ? ((transformationMethod instanceof li) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new li(transformationMethod) : transformationMethod instanceof li ? ((li) transformationMethod).a : transformationMethod;
    }

    @Override // sensei0.xe
    public final InputFilter[] n(InputFilter[] inputFilterArr) {
        if (!this.y) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof di) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArray.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            di diVar = this.x;
            if (i4 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = diVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i4] == diVar) {
                return inputFilterArr;
            }
            i4++;
        }
    }

    @Override // sensei0.xe
    public final boolean r() {
        return this.y;
    }
}
