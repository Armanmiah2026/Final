package com.trilead.ssh2;

import com.trilead.ssh2.packets.TypesReader;
import com.trilead.ssh2.packets.TypesWriter;
import com.trilead.ssh2.sftp.AttribFlags;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Vector;
import net.sourceforge.jsocks.Proxy;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class SFTPv3Client {
    String charsetName;
    final Connection conn;
    final PrintStream debug;
    boolean flag_closed;
    InputStream is;
    int next_request_id;
    OutputStream os;
    int protocol_version;
    HashMap server_extensions;
    final Session sess;

    @Deprecated
    public SFTPv3Client(Connection connection, PrintStream printStream) throws IOException {
        this.flag_closed = false;
        this.protocol_version = 0;
        this.server_extensions = new HashMap();
        this.next_request_id = 1000;
        this.charsetName = null;
        if (connection == null) {
            throw new IllegalArgumentException("Cannot accept null argument!");
        }
        this.conn = connection;
        this.debug = printStream;
        if (printStream != null) {
            printStream.println("Opening session and starting SFTP subsystem.");
        }
        Session sessionOpenSession = connection.openSession();
        this.sess = sessionOpenSession;
        sessionOpenSession.startSubSystem("sftp");
        this.is = sessionOpenSession.getStdout();
        this.os = new BufferedOutputStream(sessionOpenSession.getStdin(), 2048);
        if (this.is == null) {
            throw new IOException("There is a problem with the streams of the underlying channel.");
        }
        init();
    }

    private final void checkHandleValidAndOpen(SFTPv3FileHandle sFTPv3FileHandle) throws IOException {
        if (sFTPv3FileHandle.client != this) {
            throw new IOException("The file handle was created with another SFTPv3FileHandle instance.");
        }
        if (sFTPv3FileHandle.isClosed) {
            throw new IOException("The file handle is closed.");
        }
    }

    private final void closeHandle(byte[] bArr) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(bArr, 0, bArr.length);
        sendMessage(4, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    private byte[] createAttrs(SFTPv3FileAttributes sFTPv3FileAttributes) {
        TypesWriter typesWriter = new TypesWriter();
        if (sFTPv3FileAttributes == null) {
            typesWriter.writeUINT32(0);
        } else {
            int i = sFTPv3FileAttributes.size != null ? 1 : 0;
            if (sFTPv3FileAttributes.uid != null && sFTPv3FileAttributes.gid != null) {
                i |= 2;
            }
            if (sFTPv3FileAttributes.permissions != null) {
                i |= 4;
            }
            if (sFTPv3FileAttributes.atime != null && sFTPv3FileAttributes.mtime != null) {
                i |= 8;
            }
            typesWriter.writeUINT32(i);
            Long l = sFTPv3FileAttributes.size;
            if (l != null) {
                typesWriter.writeUINT64(l.longValue());
            }
            Integer num = sFTPv3FileAttributes.uid;
            if (num != null && sFTPv3FileAttributes.gid != null) {
                typesWriter.writeUINT32(num.intValue());
                typesWriter.writeUINT32(sFTPv3FileAttributes.gid.intValue());
            }
            Integer num2 = sFTPv3FileAttributes.permissions;
            if (num2 != null) {
                typesWriter.writeUINT32(num2.intValue());
            }
            Long l2 = sFTPv3FileAttributes.atime;
            if (l2 != null && sFTPv3FileAttributes.mtime != null) {
                typesWriter.writeUINT32(l2.intValue());
                typesWriter.writeUINT32(sFTPv3FileAttributes.mtime.intValue());
            }
        }
        return typesWriter.getBytes();
    }

    private final String expandString(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & 255;
            if (i4 < 32 || i4 > 126) {
                stringBuffer.append("{0x" + Integer.toHexString(i4) + "}");
            } else {
                stringBuffer.append((char) i4);
            }
        }
        return stringBuffer.toString();
    }

    private void expectStatusOKMessage(int i) throws IOException {
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i2 = typesReader.readByte();
        if (typesReader.readUINT32() != i) {
            throw new IOException("The server sent an invalid id field.");
        }
        if (i2 != 101) {
            throw new IOException(za0.i(i2, "The SFTP server sent an unexpected packet type (", ")"));
        }
        int uint32 = typesReader.readUINT32();
        if (uint32 != 0) {
            throw new SFTPException(typesReader.readString(), uint32);
        }
    }

    private final int generateNextRequestID() {
        int i;
        synchronized (this) {
            i = this.next_request_id;
            this.next_request_id = i + 1;
        }
        return i;
    }

    private void init() throws IOException {
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_INIT (3)...");
        }
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeUINT32(3);
        sendMessage(1, 0, typesWriter.getBytes());
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Waiting for SSH_FXP_VERSION...");
        }
        TypesReader typesReader = new TypesReader(receiveMessage(34000));
        int i = typesReader.readByte();
        if (i != 2) {
            throw new IOException(za0.i(i, "The server did not send a SSH_FXP_VERSION packet (got ", ")"));
        }
        this.protocol_version = typesReader.readUINT32();
        PrintStream printStream3 = this.debug;
        if (printStream3 != null) {
            printStream3.println("SSH_FXP_VERSION: protocol_version = " + this.protocol_version);
        }
        if (this.protocol_version != 3) {
            throw new IOException(za0.n(new StringBuilder("Server version "), this.protocol_version, " is currently not supported"));
        }
        while (typesReader.remain() != 0) {
            String string = typesReader.readString();
            byte[] byteString = typesReader.readByteString();
            this.server_extensions.put(string, byteString);
            PrintStream printStream4 = this.debug;
            if (printStream4 != null) {
                printStream4.println("SSH_FXP_VERSION: extension: " + string + " = '" + expandString(byteString, 0, byteString.length) + "'");
            }
        }
    }

    private final byte[] openDirectory(String str) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_OPENDIR...");
            this.debug.flush();
        }
        sendMessage(11, iGenerateNextRequestID, typesWriter.getBytes());
        TypesReader typesReader = new TypesReader(receiveMessage(34000));
        int i = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            throw new IOException("The server sent an invalid id field.");
        }
        if (i != 102) {
            if (i != 101) {
                throw new IOException(za0.i(i, "The SFTP server sent an unexpected packet type (", ")"));
            }
            throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
        }
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got SSH_FXP_HANDLE.");
            this.debug.flush();
        }
        return typesReader.readByteString();
    }

    private SFTPv3FileHandle openFile(String str, int i, SFTPv3FileAttributes sFTPv3FileAttributes) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        typesWriter.writeUINT32(i);
        typesWriter.writeBytes(createAttrs(sFTPv3FileAttributes));
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_OPEN...");
            this.debug.flush();
        }
        sendMessage(3, iGenerateNextRequestID, typesWriter.getBytes());
        TypesReader typesReader = new TypesReader(receiveMessage(34000));
        int i2 = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            throw new IOException("The server sent an invalid id field.");
        }
        if (i2 != 102) {
            if (i2 != 101) {
                throw new IOException(za0.i(i2, "The SFTP server sent an unexpected packet type (", ")"));
            }
            throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
        }
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got SSH_FXP_HANDLE.");
            this.debug.flush();
        }
        return new SFTPv3FileHandle(this, typesReader.readByteString());
    }

    private SFTPv3FileAttributes readAttrs(TypesReader typesReader) throws IOException {
        SFTPv3FileAttributes sFTPv3FileAttributes = new SFTPv3FileAttributes();
        int uint32 = typesReader.readUINT32();
        if ((uint32 & 1) != 0) {
            PrintStream printStream = this.debug;
            if (printStream != null) {
                printStream.println("SSH_FILEXFER_ATTR_SIZE");
            }
            sFTPv3FileAttributes.size = Long.valueOf(typesReader.readUINT64());
        }
        if ((uint32 & 2) != 0) {
            PrintStream printStream2 = this.debug;
            if (printStream2 != null) {
                printStream2.println("SSH_FILEXFER_ATTR_V3_UIDGID");
            }
            sFTPv3FileAttributes.uid = Integer.valueOf(typesReader.readUINT32());
            sFTPv3FileAttributes.gid = Integer.valueOf(typesReader.readUINT32());
        }
        if ((uint32 & 4) != 0) {
            PrintStream printStream3 = this.debug;
            if (printStream3 != null) {
                printStream3.println("SSH_FILEXFER_ATTR_PERMISSIONS");
            }
            sFTPv3FileAttributes.permissions = Integer.valueOf(typesReader.readUINT32());
        }
        if ((uint32 & 8) != 0) {
            PrintStream printStream4 = this.debug;
            if (printStream4 != null) {
                printStream4.println("SSH_FILEXFER_ATTR_V3_ACMODTIME");
            }
            sFTPv3FileAttributes.atime = Long.valueOf(((long) typesReader.readUINT32()) & 4294967295L);
            sFTPv3FileAttributes.mtime = Long.valueOf(((long) typesReader.readUINT32()) & 4294967295L);
        }
        if ((uint32 & AttribFlags.SSH_FILEXFER_ATTR_EXTENDED) != 0) {
            int uint322 = typesReader.readUINT32();
            PrintStream printStream5 = this.debug;
            if (printStream5 != null) {
                printStream5.println("SSH_FILEXFER_ATTR_EXTENDED (" + uint322 + ")");
            }
            while (uint322 > 0) {
                typesReader.readByteString();
                typesReader.readByteString();
                uint322--;
            }
        }
        return sFTPv3FileAttributes;
    }

    private final void readBytes(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int i3 = this.is.read(bArr, i, i2);
            if (i3 < 0) {
                throw new IOException("Unexpected end of sftp stream.");
            }
            if (i3 == 0 || i3 > i2) {
                throw new IOException("Underlying stream implementation is bogus!");
            }
            i2 -= i3;
            i += i3;
        }
    }

    private final byte[] receiveMessage(int i) throws IOException {
        byte[] bArr = new byte[4];
        readBytes(bArr, 0, 4);
        int i2 = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i2 > i || i2 <= 0) {
            throw new IOException(za0.h(i2, "Illegal sftp packet len: "));
        }
        byte[] bArr2 = new byte[i2];
        readBytes(bArr2, 0, i2);
        return bArr2;
    }

    private final Vector scanDirectory(byte[] bArr) throws IOException {
        Vector vector = new Vector();
        while (true) {
            int iGenerateNextRequestID = generateNextRequestID();
            TypesWriter typesWriter = new TypesWriter();
            typesWriter.writeString(bArr, 0, bArr.length);
            PrintStream printStream = this.debug;
            if (printStream != null) {
                printStream.println("Sending SSH_FXP_READDIR...");
                this.debug.flush();
            }
            sendMessage(12, iGenerateNextRequestID, typesWriter.getBytes());
            byte[] bArrReceiveMessage = receiveMessage(Proxy.SOCKS_NO_PROXY);
            PrintStream printStream2 = this.debug;
            if (printStream2 != null) {
                printStream2.println("Got REPLY.");
                this.debug.flush();
            }
            TypesReader typesReader = new TypesReader(bArrReceiveMessage);
            int i = typesReader.readByte();
            if (typesReader.readUINT32() != iGenerateNextRequestID) {
                throw new IOException("The server sent an invalid id field.");
            }
            if (i != 104) {
                if (i != 101) {
                    throw new IOException(za0.i(i, "The SFTP server sent an unexpected packet type (", ")"));
                }
                int uint32 = typesReader.readUINT32();
                if (uint32 == 1) {
                    return vector;
                }
                throw new SFTPException(typesReader.readString(), uint32);
            }
            int uint322 = typesReader.readUINT32();
            PrintStream printStream3 = this.debug;
            if (printStream3 != null) {
                printStream3.println("Parsing " + uint322 + " name entries...");
            }
            while (uint322 > 0) {
                SFTPv3DirectoryEntry sFTPv3DirectoryEntry = new SFTPv3DirectoryEntry();
                sFTPv3DirectoryEntry.filename = typesReader.readString(this.charsetName);
                sFTPv3DirectoryEntry.longEntry = typesReader.readString(this.charsetName);
                sFTPv3DirectoryEntry.attributes = readAttrs(typesReader);
                vector.addElement(sFTPv3DirectoryEntry);
                PrintStream printStream4 = this.debug;
                if (printStream4 != null) {
                    printStream4.println("File: '" + sFTPv3DirectoryEntry.filename + "'");
                }
                uint322--;
            }
        }
    }

    private final void sendMessage(int i, int i2, byte[] bArr, int i3, int i4) throws IOException {
        int i5 = i4 + 1;
        if (i != 1) {
            i5 = i4 + 5;
        }
        this.os.write(i5 >> 24);
        this.os.write(i5 >> 16);
        this.os.write(i5 >> 8);
        this.os.write(i5);
        this.os.write(i);
        if (i != 1) {
            this.os.write(i2 >> 24);
            this.os.write(i2 >> 16);
            this.os.write(i2 >> 8);
            this.os.write(i2);
        }
        this.os.write(bArr, i3, i4);
        this.os.flush();
    }

    private SFTPv3FileAttributes statBoth(String str, int i) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_STAT/SSH_FXP_LSTAT...");
            this.debug.flush();
        }
        sendMessage(i, iGenerateNextRequestID, typesWriter.getBytes());
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i2 = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            throw new IOException("The server sent an invalid id field.");
        }
        if (i2 == 105) {
            return readAttrs(typesReader);
        }
        if (i2 != 101) {
            throw new IOException(za0.i(i2, "The SFTP server sent an unexpected packet type (", ")"));
        }
        throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
    }

    public SFTPv3FileAttributes _stat(String str) throws SFTPException {
        try {
            return stat(str);
        } catch (SFTPException e) {
            int serverErrorCode = e.getServerErrorCode();
            if (serverErrorCode == 2 || serverErrorCode == 10) {
                return null;
            }
            throw e;
        }
    }

    public String canonicalPath(String str) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_REALPATH...");
            this.debug.flush();
        }
        sendMessage(16, iGenerateNextRequestID, typesWriter.getBytes());
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            throw new IOException("The server sent an invalid id field.");
        }
        if (i == 104) {
            if (typesReader.readUINT32() == 1) {
                return typesReader.readString(this.charsetName);
            }
            throw new IOException("The server sent an invalid SSH_FXP_NAME packet.");
        }
        if (i != 101) {
            throw new IOException(za0.i(i, "The SFTP server sent an unexpected packet type (", ")"));
        }
        throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
    }

    public void chmod(String str, int i) throws IOException {
        SFTPv3FileAttributes sFTPv3FileAttributes = new SFTPv3FileAttributes();
        sFTPv3FileAttributes.permissions = Integer.valueOf(i);
        setstat(str, sFTPv3FileAttributes);
    }

    public void close() {
        this.sess.close();
    }

    public void closeFile(SFTPv3FileHandle sFTPv3FileHandle) {
        if (sFTPv3FileHandle == null) {
            throw new IllegalArgumentException("the handle argument may not be null");
        }
        try {
            if (!sFTPv3FileHandle.isClosed) {
                closeHandle(sFTPv3FileHandle.fileHandle);
            }
        } finally {
            sFTPv3FileHandle.isClosed = true;
        }
    }

    public SFTPv3FileHandle createFile(String str) {
        return createFile(str, null);
    }

    public SFTPv3FileHandle createFileTruncate(String str) {
        return createFileTruncate(str, null);
    }

    public void createSymlink(String str, String str2) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str2, this.charsetName);
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_SYMLINK...");
            this.debug.flush();
        }
        sendMessage(20, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public boolean exists(String str) {
        return _stat(str) != null;
    }

    public void fsetstat(SFTPv3FileHandle sFTPv3FileHandle, SFTPv3FileAttributes sFTPv3FileAttributes) throws IOException {
        checkHandleValidAndOpen(sFTPv3FileHandle);
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        byte[] bArr = sFTPv3FileHandle.fileHandle;
        typesWriter.writeString(bArr, 0, bArr.length);
        typesWriter.writeBytes(createAttrs(sFTPv3FileAttributes));
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_FSETSTAT...");
            this.debug.flush();
        }
        sendMessage(10, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public SFTPv3FileAttributes fstat(SFTPv3FileHandle sFTPv3FileHandle) throws IOException {
        checkHandleValidAndOpen(sFTPv3FileHandle);
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        byte[] bArr = sFTPv3FileHandle.fileHandle;
        typesWriter.writeString(bArr, 0, bArr.length);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_FSTAT...");
            this.debug.flush();
        }
        sendMessage(8, iGenerateNextRequestID, typesWriter.getBytes());
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            throw new IOException("The server sent an invalid id field.");
        }
        if (i == 105) {
            return readAttrs(typesReader);
        }
        if (i != 101) {
            throw new IOException(za0.i(i, "The SFTP server sent an unexpected packet type (", ")"));
        }
        throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
    }

    public String getCharset() {
        return this.charsetName;
    }

    public int getProtocolVersion() {
        return this.protocol_version;
    }

    public Vector ls(String str) throws IOException {
        byte[] bArrOpenDirectory = openDirectory(str);
        Vector vectorScanDirectory = scanDirectory(bArrOpenDirectory);
        closeHandle(bArrOpenDirectory);
        return vectorScanDirectory;
    }

    public SFTPv3FileAttributes lstat(String str) {
        return statBoth(str, 7);
    }

    public void mkdir(String str, int i) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        typesWriter.writeUINT32(4);
        typesWriter.writeUINT32(i);
        sendMessage(14, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public void mkdirs(String str, int i) throws IOException {
        SFTPv3FileAttributes sFTPv3FileAttributes_stat = _stat(str);
        if (sFTPv3FileAttributes_stat == null || !sFTPv3FileAttributes_stat.isDirectory()) {
            int iLastIndexOf = str.lastIndexOf("/");
            if (iLastIndexOf > 0) {
                mkdirs(str.substring(0, iLastIndexOf), i);
            }
            try {
                mkdir(str, i);
            } catch (IOException e) {
                throw new IOException("Failed to mkdir ".concat(str), e);
            }
        }
    }

    public void mv(String str, String str2) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        typesWriter.writeString(str2, this.charsetName);
        sendMessage(18, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public SFTPv3FileHandle openFileRO(String str) {
        return openFile(str, 1, null);
    }

    public SFTPv3FileHandle openFileRW(String str) {
        return openFile(str, 3, null);
    }

    public int read(SFTPv3FileHandle sFTPv3FileHandle, long j, byte[] bArr, int i, int i2) throws IOException {
        checkHandleValidAndOpen(sFTPv3FileHandle);
        if (i2 > 32768 || i2 <= 0) {
            throw new IllegalArgumentException("invalid len argument");
        }
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        byte[] bArr2 = sFTPv3FileHandle.fileHandle;
        typesWriter.writeString(bArr2, 0, bArr2.length);
        typesWriter.writeUINT64(j);
        typesWriter.writeUINT32(i2);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_READ...");
            this.debug.flush();
        }
        sendMessage(5, iGenerateNextRequestID, typesWriter.getBytes());
        TypesReader typesReader = new TypesReader(receiveMessage(34000));
        int i3 = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            throw new IOException("The server sent an invalid id field.");
        }
        if (i3 == 103) {
            PrintStream printStream2 = this.debug;
            if (printStream2 != null) {
                printStream2.println("Got SSH_FXP_DATA...");
                this.debug.flush();
            }
            int uint32 = typesReader.readUINT32();
            if (uint32 < 0 || uint32 > i2) {
                throw new IOException("The server sent an invalid length field.");
            }
            typesReader.readBytes(bArr, i, uint32);
            return uint32;
        }
        if (i3 != 101) {
            throw new IOException(za0.i(i3, "The SFTP server sent an unexpected packet type (", ")"));
        }
        int uint322 = typesReader.readUINT32();
        if (uint322 != 1) {
            throw new SFTPException(typesReader.readString(), uint322);
        }
        PrintStream printStream3 = this.debug;
        if (printStream3 == null) {
            return -1;
        }
        printStream3.println("Got SSH_FX_EOF.");
        this.debug.flush();
        return -1;
    }

    public String readLink(String str) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_READLINK...");
            this.debug.flush();
        }
        sendMessage(19, iGenerateNextRequestID, typesWriter.getBytes());
        byte[] bArrReceiveMessage = receiveMessage(34000);
        PrintStream printStream2 = this.debug;
        if (printStream2 != null) {
            printStream2.println("Got REPLY.");
            this.debug.flush();
        }
        TypesReader typesReader = new TypesReader(bArrReceiveMessage);
        int i = typesReader.readByte();
        if (typesReader.readUINT32() != iGenerateNextRequestID) {
            throw new IOException("The server sent an invalid id field.");
        }
        if (i == 104) {
            if (typesReader.readUINT32() == 1) {
                return typesReader.readString(this.charsetName);
            }
            throw new IOException("The server sent an invalid SSH_FXP_NAME packet.");
        }
        if (i != 101) {
            throw new IOException(za0.i(i, "The SFTP server sent an unexpected packet type (", ")"));
        }
        throw new SFTPException(typesReader.readString(), typesReader.readUINT32());
    }

    public void rm(String str) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        sendMessage(13, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public void rmdir(String str) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        sendMessage(15, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public void setCharset(String str) throws IOException {
        if (str == null) {
            this.charsetName = str;
            return;
        }
        try {
            Charset.forName(str);
            this.charsetName = str;
        } catch (Exception e) {
            throw new IOException("This charset is not supported", e);
        }
    }

    public void setstat(String str, SFTPv3FileAttributes sFTPv3FileAttributes) throws IOException {
        int iGenerateNextRequestID = generateNextRequestID();
        TypesWriter typesWriter = new TypesWriter();
        typesWriter.writeString(str, this.charsetName);
        typesWriter.writeBytes(createAttrs(sFTPv3FileAttributes));
        PrintStream printStream = this.debug;
        if (printStream != null) {
            printStream.println("Sending SSH_FXP_SETSTAT...");
            this.debug.flush();
        }
        sendMessage(9, iGenerateNextRequestID, typesWriter.getBytes());
        expectStatusOKMessage(iGenerateNextRequestID);
    }

    public SFTPv3FileAttributes stat(String str) {
        return statBoth(str, 17);
    }

    public void write(SFTPv3FileHandle sFTPv3FileHandle, long j, byte[] bArr, int i, int i2) throws IOException {
        checkHandleValidAndOpen(sFTPv3FileHandle);
        while (i2 > 0) {
            int i3 = AttribFlags.SSH_FILEXFER_ATTR_CTIME;
            if (i2 <= 32768) {
                i3 = i2;
            }
            int iGenerateNextRequestID = generateNextRequestID();
            TypesWriter typesWriter = new TypesWriter();
            byte[] bArr2 = sFTPv3FileHandle.fileHandle;
            typesWriter.writeString(bArr2, 0, bArr2.length);
            typesWriter.writeUINT64(j);
            typesWriter.writeString(bArr, i, i3);
            PrintStream printStream = this.debug;
            if (printStream != null) {
                printStream.println("Sending SSH_FXP_WRITE...");
                this.debug.flush();
            }
            sendMessage(6, iGenerateNextRequestID, typesWriter.getBytes());
            j += (long) i3;
            i += i3;
            i2 -= i3;
            TypesReader typesReader = new TypesReader(receiveMessage(34000));
            int i4 = typesReader.readByte();
            if (typesReader.readUINT32() != iGenerateNextRequestID) {
                throw new IOException("The server sent an invalid id field.");
            }
            if (i4 != 101) {
                throw new IOException(za0.i(i4, "The SFTP server sent an unexpected packet type (", ")"));
            }
            int uint32 = typesReader.readUINT32();
            if (uint32 != 0) {
                throw new SFTPException(typesReader.readString(), uint32);
            }
        }
    }

    public OutputStream writeToFile(String str) {
        final SFTPv3FileHandle sFTPv3FileHandleCreateFile = createFile(str);
        return new OutputStream() { // from class: com.trilead.ssh2.SFTPv3Client.1
            private long offset = 0;

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                SFTPv3Client.this.closeFile(sFTPv3FileHandleCreateFile);
            }

            @Override // java.io.OutputStream
            public void write(int i) throws IOException {
                write(new byte[]{(byte) i});
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                SFTPv3Client.this.write(sFTPv3FileHandleCreateFile, this.offset, bArr, i, i2);
                this.offset += (long) i2;
            }
        };
    }

    public SFTPv3FileHandle createFile(String str, SFTPv3FileAttributes sFTPv3FileAttributes) {
        return openFile(str, 11, sFTPv3FileAttributes);
    }

    public SFTPv3FileHandle createFileTruncate(String str, SFTPv3FileAttributes sFTPv3FileAttributes) {
        return openFile(str, 27, sFTPv3FileAttributes);
    }

    private final void sendMessage(int i, int i2, byte[] bArr) throws IOException {
        sendMessage(i, i2, bArr, 0, bArr.length);
    }

    public SFTPv3Client(Connection connection) {
        this(connection, null);
    }

    public InputStream read(String str) {
        final SFTPv3FileHandle sFTPv3FileHandleOpenFileRO = openFileRO(str);
        return new InputStream() { // from class: com.trilead.ssh2.SFTPv3Client.2
            private long offset = 0;

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                SFTPv3Client.this.closeFile(sFTPv3FileHandleOpenFileRO);
            }

            @Override // java.io.InputStream
            public int read() {
                byte[] bArr = new byte[1];
                if (read(bArr) < 0) {
                    return -1;
                }
                return bArr[0];
            }

            @Override // java.io.InputStream
            public long skip(long j) {
                this.offset += j;
                return j;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = SFTPv3Client.this.read(sFTPv3FileHandleOpenFileRO, this.offset, bArr, i, i2);
                if (i3 < 0) {
                    return -1;
                }
                this.offset += (long) i3;
                return i3;
            }
        };
    }
}
