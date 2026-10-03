package sensei0;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class yr implements dx {
    public static final yr a = new yr();

    @Override // sensei0.dx
    public final ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object objJ = wf0.J(obj);
        if (objJ instanceof String) {
            bc0 bc0Var = bc0.b;
            String strQuote = JSONObject.quote((String) objJ);
            bc0Var.getClass();
            return bc0.d(strQuote);
        }
        bc0 bc0Var2 = bc0.b;
        String string = objJ.toString();
        bc0Var2.getClass();
        return bc0.d(string);
    }

    @Override // sensei0.dx
    public final Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            bc0.b.getClass();
            JSONTokener jSONTokener = new JSONTokener(bc0.c(byteBuffer));
            Object objNextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return objNextValue;
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }
}
