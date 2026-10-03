package com.trilead.ssh2.channel;

import com.trilead.ssh2.sftp.AttribFlags;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class StreamForwarder extends Thread {
    byte[] buffer = new byte[AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT];
    Channel c;
    InputStream is;
    String mode;
    OutputStream os;
    Socket s;
    StreamForwarder sibling;

    public StreamForwarder(Channel channel, StreamForwarder streamForwarder, Socket socket, InputStream inputStream, OutputStream outputStream, String str) {
        this.is = inputStream;
        this.os = outputStream;
        this.mode = str;
        this.c = channel;
        this.sibling = streamForwarder;
        this.s = socket;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StreamForwarder streamForwarder;
        boolean zIsAlive;
        Socket socket;
        while (true) {
            try {
                try {
                    try {
                        int i = this.is.read(this.buffer);
                        if (i <= 0) {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        } else {
                            this.os.write(this.buffer, 0, i);
                            this.os.flush();
                        }
                    } catch (IOException unused2) {
                        return;
                    }
                } catch (IOException e) {
                    try {
                        Channel channel = this.c;
                        channel.cm.closeChannel(channel, "Closed due to exception in StreamForwarder (" + this.mode + "): " + e.getMessage(), true);
                    } catch (IOException unused3) {
                    }
                    try {
                        this.os.close();
                    } catch (IOException unused4) {
                    }
                    try {
                        this.is.close();
                    } catch (IOException unused5) {
                    }
                    if (this.sibling == null) {
                        return;
                    }
                    while (this.sibling.isAlive()) {
                        try {
                            this.sibling.join();
                        } catch (InterruptedException unused6) {
                        }
                    }
                    try {
                        Channel channel2 = this.c;
                        channel2.cm.closeChannel(channel2, "StreamForwarder (" + this.mode + ") is cleaning up the connection", true);
                    } catch (IOException unused7) {
                    }
                    socket = this.s;
                    if (socket == null) {
                        return;
                    }
                }
            } finally {
                if (streamForwarder != null) {
                    while (true) {
                        if (!zIsAlive) {
                            try {
                                break;
                            } catch (IOException unused8) {
                            }
                        }
                    }
                }
            }
        }
        this.os.close();
        try {
            this.is.close();
        } catch (IOException unused9) {
        }
        if (this.sibling != null) {
            while (this.sibling.isAlive()) {
                try {
                    this.sibling.join();
                } catch (InterruptedException unused10) {
                }
            }
            try {
                Channel channel3 = this.c;
                channel3.cm.closeChannel(channel3, "StreamForwarder (" + this.mode + ") is cleaning up the connection", true);
            } catch (IOException unused11) {
            }
            socket = this.s;
            if (socket == null) {
                return;
            }
            socket.close();
        }
    }
}
