package sensei0;

import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qg implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ qg(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:345|24|(12:26|340|27|(12:29|(1:36)|38|39|314|40|41|349|51|(4:297|360|298|299)(7:54|55|(11:354|58|335|59|(10:329|61|62|331|63|64|366|78|(3:352|80|370)(1:369)|84)(1:76)|77|366|78|(0)(0)|84|56)|368|103|85|(1:(1:375)(3:323|107|108))(18:364|111|112|358|113|(1:115)|(1:119)|120|(2:122|123)(1:124)|316|125|(1:127)(1:128)|(1:130)(1:131)|132|(1:141)(10:321|135|136|(1:138)|143|(1:148)(1:147)|(1:153)|154|155|(3:327|157|(6:159|(5:161|(1:163)|(6:169|325|170|171|320|172)(1:180)|318|(6:182|(4:184|185|344|(4:(1:207)|(2:209|210)(1:214)|215|376)(2:216|(9:(1:226)|(11:228|356|229|(1:(2:231|(2:372|233)(1:235))(1:371))|234|(1:261)|262|(1:266)(1:(1:268)(1:269))|274|275|276)|279|280|281|282|312|283|378)(4:(1:221)|(1:223)|224|377)))|186|204|344|(0)(0))(5:187|(3:190|(2:192|(1:(1:195)(1:198))(2:199|200))(1:201)|(4:203|185|344|(0)(0)))(1:186)|204|344|(0)(0)))(1:164)|167|(0)(0)|318|(0)(0))(0))(0))|142|143|(5:148|(2:151|153)|154|155|(0)(0))(0)))|293|294)|37|349|51|(0)|297|360|298|299)(1:48)|47|37|349|51|(0)|297|360|298|299) */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0418, code lost:
    
        r6 = r7;
        r14 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x0481, code lost:
    
        r18 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x0486, code lost:
    
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x048a, code lost:
    
        if (r3[0] == 22) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x048c, code lost:
    
        r5.unread(r3, 0, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x048f, code lost:
    
        r25 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0492, code lost:
    
        r0 = sensei0.d00.w(r3, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0497, code lost:
    
        if (r0 <= 0) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x049b, code lost:
    
        if (r0 <= 65536) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x049e, code lost:
    
        r4 = new byte[r0];
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x04a1, code lost:
    
        if (r7 >= r0) goto L373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x04a3, code lost:
    
        r10 = r5.read(r4, r7, r0 - r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x04a9, code lost:
    
        if (r10 >= 0) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x04ac, code lost:
    
        r7 = r7 + r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x04ae, code lost:
    
        r7 = new byte[r0 + 5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x04b2, code lost:
    
        r25 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x04b6, code lost:
    
        java.lang.System.arraycopy(r3, 0, r7, 0, 5);
        java.lang.System.arraycopy(r4, 0, r7, 5, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x04bd, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x04be, code lost:
    
        r25 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x04cb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0552, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x0553, code lost:
    
        r25 = r5;
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0557, code lost:
    
        r3 = com.sensei.tunnel.SenseiTunnelVpnService.J0;
        sensei0.xe.i(r15 + r9 + "]: SNI rewrite failed: " + r0.getMessage() + "; relaying raw");
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x058e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x058f, code lost:
    
        r4 = r18;
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x05d1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x05d2, code lost:
    
        r3 = r1;
        r13 = r8;
        r15 = "Injector[";
        r6 = r7;
        r1 = r26;
        r2 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x0608, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:148:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03c9 A[Catch: Exception -> 0x039a, TryCatch #6 {Exception -> 0x039a, blocks: (B:172:0x0390, B:182:0x03c9, B:190:0x03df), top: B:320:0x0390 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0351 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0648 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x01de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0120 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0229  */
    /* JADX WARN: Type inference failed for: r14v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v22 */
    /* JADX WARN: Type inference failed for: r24v23 */
    /* JADX WARN: Type inference failed for: r24v27 */
    /* JADX WARN: Type inference failed for: r24v28 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v31 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.qg.a():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x06af A[Catch: all -> 0x054f, Exception -> 0x06e6, TryCatch #7 {all -> 0x054f, blocks: (B:152:0x0536, B:154:0x054b, B:158:0x0552, B:160:0x056b, B:162:0x056f, B:165:0x0581, B:168:0x058a, B:172:0x05a8, B:173:0x05c4, B:174:0x05ce, B:178:0x05f4, B:177:0x05ea, B:179:0x05f8, B:180:0x05fc, B:182:0x060c, B:183:0x0611, B:185:0x0623, B:188:0x062e, B:190:0x0638, B:191:0x064a, B:193:0x0655, B:195:0x0689, B:198:0x0696, B:201:0x06a2, B:203:0x06af, B:204:0x06ba, B:208:0x06d9, B:207:0x06d6, B:209:0x06e1, B:211:0x06e6), top: B:265:0x0536 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x06d6 A[Catch: all -> 0x054f, Exception -> 0x06e6, TryCatch #7 {all -> 0x054f, blocks: (B:152:0x0536, B:154:0x054b, B:158:0x0552, B:160:0x056b, B:162:0x056f, B:165:0x0581, B:168:0x058a, B:172:0x05a8, B:173:0x05c4, B:174:0x05ce, B:178:0x05f4, B:177:0x05ea, B:179:0x05f8, B:180:0x05fc, B:182:0x060c, B:183:0x0611, B:185:0x0623, B:188:0x062e, B:190:0x0638, B:191:0x064a, B:193:0x0655, B:195:0x0689, B:198:0x0696, B:201:0x06a2, B:203:0x06af, B:204:0x06ba, B:208:0x06d9, B:207:0x06d6, B:209:0x06e1, B:211:0x06e6), top: B:265:0x0536 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 2016
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.qg.run():void");
    }

    public /* synthetic */ qg(j1 j1Var, Socket socket, Socket socket2) {
        this.a = 3;
        this.b = socket;
        this.c = socket2;
    }
}
