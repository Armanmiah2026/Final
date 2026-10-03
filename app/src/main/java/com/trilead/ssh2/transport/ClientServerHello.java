package com.trilead.ssh2.transport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ClientServerHello {
    String client_line = "SSH-2.0-TrileadSSH2Java_213";
    String server_line;
    String server_versioncomment;

    public ClientServerHello(InputStream inputStream, OutputStream outputStream) throws IOException {
        outputStream.write(za0.o(new StringBuilder(), this.client_line, "\r\n").getBytes(StandardCharsets.ISO_8859_1));
        outputStream.flush();
        byte[] bArr = new byte[512];
        for (int i = 0; i < 50; i++) {
            String str = new String(bArr, 0, readLineRN(inputStream, bArr), StandardCharsets.ISO_8859_1);
            this.server_line = str;
            if (str.startsWith("SSH-")) {
                break;
            }
        }
        if (!this.server_line.startsWith("SSH-")) {
            throw new IOException("Malformed server identification string. There was no line starting with 'SSH-' amongst the first 50 lines.");
        }
        if (this.server_line.startsWith("SSH-1.99-")) {
            this.server_versioncomment = this.server_line.substring(9);
        } else {
            if (!this.server_line.startsWith("SSH-2.0-")) {
                throw new IOException("Server uses incompatible protocol, it is not SSH-2 compatible.");
            }
            this.server_versioncomment = this.server_line.substring(8);
        }
    }

    public static final int readLineRN(InputStream inputStream, byte[] bArr) throws IOException {
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = inputStream.read();
            if (i3 == -1) {
                throw new IOException("Premature connection close");
            }
            int i4 = i + 1;
            bArr[i] = (byte) i3;
            if (i3 == 13) {
                z = true;
            } else {
                if (i3 == 10) {
                    return i2;
                }
                if (z) {
                    throw new IOException("Malformed line sent by the server, the line does not end correctly.");
                }
                i2++;
                if (i4 >= bArr.length) {
                    throw new IOException("The server sent a too long line: ".concat(new String(bArr, StandardCharsets.ISO_8859_1)));
                }
            }
            i = i4;
        }
    }

    public byte[] getClientString() {
        return this.client_line.getBytes(StandardCharsets.ISO_8859_1);
    }

    public byte[] getServerString() {
        return this.server_line.getBytes(StandardCharsets.ISO_8859_1);
    }
}
