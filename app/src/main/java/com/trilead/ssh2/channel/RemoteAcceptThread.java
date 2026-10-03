package com.trilead.ssh2.channel;

import com.trilead.ssh2.log.Logger;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteAcceptThread extends Thread {
    private static final Logger log = Logger.getLogger(RemoteAcceptThread.class);
    Channel c;
    String remoteConnectedAddress;
    int remoteConnectedPort;
    String remoteOriginatorAddress;
    int remoteOriginatorPort;
    Socket s;
    String targetAddress;
    int targetPort;

    public RemoteAcceptThread(Channel channel, String str, int i, String str2, int i2, String str3, int i3) {
        this.c = channel;
        this.remoteConnectedAddress = str;
        this.remoteConnectedPort = i;
        this.remoteOriginatorAddress = str2;
        this.remoteOriginatorPort = i2;
        this.targetAddress = str3;
        this.targetPort = i3;
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(30, "RemoteAcceptThread: " + str + "/" + i + ", R: " + str2 + "/" + i2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Channel channel = this.c;
            channel.cm.sendOpenConfirmation(channel);
            this.s = new Socket(this.targetAddress, this.targetPort);
            Channel channel2 = this.c;
            StreamForwarder streamForwarder = new StreamForwarder(channel2, null, null, channel2.getStdoutStream(), this.s.getOutputStream(), "RemoteToLocal");
            StreamForwarder streamForwarder2 = new StreamForwarder(this.c, null, null, this.s.getInputStream(), this.c.getStdinStream(), "LocalToRemote");
            streamForwarder.setDaemon(true);
            streamForwarder.start();
            streamForwarder2.run();
            while (streamForwarder.isAlive()) {
                try {
                    streamForwarder.join();
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            }
            Channel channel3 = this.c;
            channel3.cm.closeChannel(channel3, "EOF on both streams reached.", true);
            this.s.close();
        } catch (IOException e) {
            log.log(50, "IOException in proxy code", e);
            try {
                Channel channel4 = this.c;
                channel4.cm.closeChannel(channel4, "IOException in proxy code (" + e.getMessage() + ")", true);
            } catch (IOException unused2) {
            }
            try {
                Socket socket = this.s;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException unused3) {
            }
        }
    }
}
