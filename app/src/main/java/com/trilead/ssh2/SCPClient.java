package com.trilead.ssh2;

import com.trilead.ssh2.sftp.AttribFlags;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class SCPClient {
    Connection conn;

    /* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
    public class LenNamePair {
        String filename;
        long length;

        public LenNamePair() {
        }
    }

    public SCPClient(Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("Cannot accept null argument!");
        }
        this.conn = connection;
    }

    private LenNamePair parseCLine(String str) throws IOException {
        if (str.length() < 8) {
            throw new IOException("Malformed C line sent by remote SCP binary, line too short.");
        }
        if (str.charAt(4) != ' ' || str.charAt(5) == ' ') {
            throw new IOException("Malformed C line sent by remote SCP binary.");
        }
        int iIndexOf = str.indexOf(32, 5);
        if (iIndexOf == -1) {
            throw new IOException("Malformed C line sent by remote SCP binary.");
        }
        String strSubstring = str.substring(5, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring.length() <= 0 || strSubstring2.length() <= 0) {
            throw new IOException("Malformed C line sent by remote SCP binary.");
        }
        if (strSubstring2.length() + strSubstring.length() + 6 != str.length()) {
            throw new IOException("Malformed C line sent by remote SCP binary.");
        }
        try {
            long j = Long.parseLong(strSubstring);
            if (j < 0) {
                throw new IOException("Malformed C line sent by remote SCP binary, illegal file length.");
            }
            LenNamePair lenNamePair = new LenNamePair();
            lenNamePair.length = j;
            lenNamePair.filename = strSubstring2;
            return lenNamePair;
        } catch (NumberFormatException unused) {
            throw new IOException("Malformed C line sent by remote SCP binary, cannot parse file length.");
        }
    }

    private void readResponse(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i == 0) {
            return;
        }
        if (i != 1) {
            throw new IOException(za0.h(i, "Remote scp terminated with error code "));
        }
        throw new IOException(za0.l("Remote scp terminated with error (", receiveLine(inputStream), ")."));
    }

    private void receiveFiles(Session session, OutputStream[] outputStreamArr) throws IOException {
        int i;
        String strReceiveLine;
        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(session.getStdin(), 512);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(session.getStdout(), 40000);
        bufferedOutputStream.write(0);
        bufferedOutputStream.flush();
        for (OutputStream outputStream : outputStreamArr) {
            do {
                i = bufferedInputStream.read();
                if (i < 0) {
                    throw new IOException("Remote scp terminated unexpectedly.");
                }
                strReceiveLine = receiveLine(bufferedInputStream);
            } while (i == 84);
            if (i == 1 || i == 2) {
                throw new IOException(za0.s("Remote SCP error: ", strReceiveLine));
            }
            if (i != 67) {
                throw new IOException("Remote SCP error: " + ((char) i) + strReceiveLine);
            }
            LenNamePair cLine = parseCLine(strReceiveLine);
            bufferedOutputStream.write(0);
            bufferedOutputStream.flush();
            long j = cLine.length;
            while (j > 0) {
                int i2 = bufferedInputStream.read(bArr, 0, j > ((long) AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) ? 8192 : (int) j);
                if (i2 < 0) {
                    throw new IOException("Remote scp terminated connection unexpectedly");
                }
                outputStream.write(bArr, 0, i2);
                j -= (long) i2;
            }
            readResponse(bufferedInputStream);
            bufferedOutputStream.write(0);
            bufferedOutputStream.flush();
        }
    }

    private String receiveLine(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(30);
        while (stringBuffer.length() <= 8192) {
            int i = inputStream.read();
            if (i < 0) {
                throw new IOException("Remote scp terminated unexpectedly.");
            }
            if (i == 10) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) i);
        }
        throw new IOException("Remote scp sent a too long line");
    }

    private void sendBytes(Session session, byte[] bArr, String str, String str2) throws IOException {
        OutputStream stdin = session.getStdin();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(session.getStdout(), 512);
        readResponse(bufferedInputStream);
        String str3 = "C" + str2 + " " + bArr.length + " " + str + "\n";
        Charset charset = StandardCharsets.ISO_8859_1;
        stdin.write(str3.getBytes(charset));
        stdin.flush();
        readResponse(bufferedInputStream);
        stdin.write(bArr, 0, bArr.length);
        stdin.write(0);
        stdin.flush();
        readResponse(bufferedInputStream);
        stdin.write("E\n".getBytes(charset));
        stdin.flush();
    }

    private void sendFiles(Session session, String[] strArr, String[] strArr2, String str) throws Throwable {
        String name;
        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(session.getStdin(), 40000);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(session.getStdout(), 512);
        readResponse(bufferedInputStream);
        int i = 0;
        while (i < strArr.length) {
            File file = new File(strArr[i]);
            long length = file.length();
            if (strArr2 == null || strArr2.length <= i || (name = strArr2[i]) == null) {
                name = file.getName();
            }
            bufferedOutputStream.write(("C" + str + " " + length + " " + name + "\n").getBytes(StandardCharsets.ISO_8859_1));
            bufferedOutputStream.flush();
            readResponse(bufferedInputStream);
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                while (length > 0) {
                    int i2 = i;
                    int i3 = length > ((long) AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) ? 8192 : (int) length;
                    try {
                        if (fileInputStream2.read(bArr, 0, i3) != i3) {
                            throw new IOException("Cannot read enough from local file " + strArr[i2]);
                        }
                        bufferedOutputStream.write(bArr, 0, i3);
                        length -= (long) i3;
                        i = i2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
                fileInputStream2.close();
                bufferedOutputStream.write(0);
                bufferedOutputStream.flush();
                readResponse(bufferedInputStream);
                i++;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        bufferedOutputStream.write("E\n".getBytes(StandardCharsets.ISO_8859_1));
        bufferedOutputStream.flush();
    }

    public void get(String str, String str2) {
        get(new String[]{str}, str2);
    }

    public void put(String str, String str2) {
        put(new String[]{str}, str2, "0600");
    }

    public void get(String str, OutputStream outputStream) {
        get(new String[]{str}, new OutputStream[]{outputStream});
    }

    public void put(String[] strArr, String str) {
        put(strArr, str, "0600");
    }

    private void get(String[] strArr, OutputStream[] outputStreamArr) {
        if (strArr != null && outputStreamArr != null) {
            if (strArr.length == outputStreamArr.length) {
                if (strArr.length == 0) {
                    return;
                }
                String str = "scp -f";
                for (String str2 : strArr) {
                    if (str2 != null) {
                        String strTrim = str2.trim();
                        if (strTrim.length() == 0) {
                            throw new IllegalArgumentException("Cannot accept empty filename.");
                        }
                        str = str + " " + strTrim;
                    } else {
                        throw new IllegalArgumentException("Cannot accept null filename.");
                    }
                }
                Session sessionOpenSession = null;
                try {
                    try {
                        sessionOpenSession = this.conn.openSession();
                        sessionOpenSession.execCommand(str);
                        receiveFiles(sessionOpenSession, outputStreamArr);
                        sessionOpenSession.close();
                        return;
                    } catch (IOException e) {
                        throw new IOException("Error during SCP transfer.", e);
                    }
                } catch (Throwable th) {
                    if (sessionOpenSession != null) {
                        sessionOpenSession.close();
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("Length of arguments does not match.");
        }
        throw new IllegalArgumentException("Null argument.");
    }

    public void put(String str, String str2, String str3) {
        put(new String[]{str}, str2, str3);
    }

    public void put(String str, String str2, String str3, String str4) {
        put(new String[]{str}, new String[]{str2}, str3, str4);
    }

    public void put(byte[] bArr, String str, String str2) {
        put(bArr, str, str2, "0600");
    }

    public void put(byte[] bArr, String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            if (str3.length() == 4) {
                for (int i = 0; i < str3.length(); i++) {
                    if (!Character.isDigit(str3.charAt(i))) {
                        throw new IllegalArgumentException("Invalid mode.");
                    }
                }
                String strTrim = str2.trim();
                if (strTrim.length() <= 0) {
                    strTrim = ".";
                }
                String strConcat = "scp -t -d ".concat(strTrim);
                Session sessionOpenSession = null;
                try {
                    try {
                        sessionOpenSession = this.conn.openSession();
                        sessionOpenSession.execCommand(strConcat);
                        sendBytes(sessionOpenSession, bArr, str, str3);
                        sessionOpenSession.close();
                        return;
                    } catch (IOException e) {
                        throw new IOException("Error during SCP transfer.", e);
                    }
                } catch (Throwable th) {
                    if (sessionOpenSession != null) {
                        sessionOpenSession.close();
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("Invalid mode.");
        }
        throw new IllegalArgumentException("Null argument.");
    }

    public void get(String[] strArr, String str) {
        if (strArr != null && str != null) {
            if (strArr.length == 0) {
                return;
            }
            String str2 = "scp -f";
            for (String str3 : strArr) {
                if (str3 != null) {
                    String strTrim = str3.trim();
                    if (strTrim.length() == 0) {
                        throw new IllegalArgumentException("Cannot accept empty filename.");
                    }
                    str2 = str2 + " " + strTrim;
                } else {
                    throw new IllegalArgumentException("Cannot accept null filename.");
                }
            }
            Session sessionOpenSession = null;
            try {
                try {
                    sessionOpenSession = this.conn.openSession();
                    sessionOpenSession.execCommand(str2);
                    receiveFiles(sessionOpenSession, strArr, str);
                    sessionOpenSession.close();
                    return;
                } catch (IOException e) {
                    throw new IOException("Error during SCP transfer.", e);
                }
            } catch (Throwable th) {
                if (sessionOpenSession != null) {
                    sessionOpenSession.close();
                }
                throw th;
            }
        }
        throw new IllegalArgumentException("Null argument.");
    }

    public void put(String[] strArr, String str, String str2) {
        put(strArr, (String[]) null, str, str2);
    }

    public void put(String[] strArr, String[] strArr2, String str, String str2) {
        if (strArr != null && str != null && str2 != null) {
            if (str2.length() == 4) {
                for (int i = 0; i < str2.length(); i++) {
                    if (!Character.isDigit(str2.charAt(i))) {
                        throw new IllegalArgumentException("Invalid mode.");
                    }
                }
                if (strArr.length == 0) {
                    return;
                }
                String strTrim = str.trim();
                if (strTrim.length() <= 0) {
                    strTrim = ".";
                }
                String strConcat = "scp -t -d ".concat(strTrim);
                for (String str3 : strArr) {
                    if (str3 == null) {
                        throw new IllegalArgumentException("Cannot accept null filename.");
                    }
                }
                Session sessionOpenSession = null;
                try {
                    try {
                        sessionOpenSession = this.conn.openSession();
                        sessionOpenSession.execCommand(strConcat);
                        sendFiles(sessionOpenSession, strArr, strArr2, str2);
                        sessionOpenSession.close();
                        return;
                    } catch (IOException e) {
                        throw new IOException("Error during SCP transfer.", e);
                    }
                } catch (Throwable th) {
                    if (sessionOpenSession != null) {
                        sessionOpenSession.close();
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("Invalid mode.");
        }
        throw new IllegalArgumentException("Null argument.");
    }

    private void receiveFiles(Session session, String[] strArr, String str) throws Throwable {
        int i;
        String strReceiveLine;
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(session.getStdin(), 512);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(session.getStdout(), 40000);
        bufferedOutputStream.write(0);
        bufferedOutputStream.flush();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            do {
                i = bufferedInputStream.read();
                if (i >= 0) {
                    strReceiveLine = receiveLine(bufferedInputStream);
                } else {
                    throw new IOException("Remote scp terminated unexpectedly.");
                }
            } while (i == 84);
            if (i == 1 || i == 2) {
                throw new IOException(za0.s("Remote SCP error: ", strReceiveLine));
            }
            if (i != 67) {
                throw new IOException("Remote SCP error: " + ((char) i) + strReceiveLine);
            }
            LenNamePair cLine = parseCLine(strReceiveLine);
            bufferedOutputStream.write(0);
            bufferedOutputStream.flush();
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(new File(str + File.separatorChar + cLine.filename));
            } catch (Throwable th) {
                th = th;
            }
            try {
                long j = cLine.length;
                while (j > 0) {
                    int i3 = bufferedInputStream.read(bArr, 0, j > ((long) AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT) ? 8192 : (int) j);
                    if (i3 >= 0) {
                        fileOutputStream.write(bArr, 0, i3);
                        j -= (long) i3;
                    } else {
                        throw new IOException("Remote scp terminated connection unexpectedly");
                    }
                }
                fileOutputStream.close();
                readResponse(bufferedInputStream);
                bufferedOutputStream.write(0);
                bufferedOutputStream.flush();
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
    }
}
