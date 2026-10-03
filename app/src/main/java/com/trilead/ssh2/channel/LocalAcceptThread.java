package com.trilead.ssh2.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class LocalAcceptThread extends Thread implements IChannelWorkerThread {
    ChannelManager cm;
    String host_to_connect;
    int port_to_connect;
    final ServerSocket ss;

    public LocalAcceptThread(ChannelManager channelManager, int i, String str, int i2) {
        this.cm = channelManager;
        this.host_to_connect = str;
        this.port_to_connect = i2;
        this.ss = new ServerSocket(i);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.cm.registerThread(this);
            while (true) {
                try {
                    Socket socketAccept = this.ss.accept();
                    try {
                        Channel channelOpenDirectTCPIPChannel = this.cm.openDirectTCPIPChannel(this.host_to_connect, this.port_to_connect, socketAccept.getInetAddress().getHostAddress(), socketAccept.getPort());
                        try {
                            try {
                                StreamForwarder streamForwarder = new StreamForwarder(channelOpenDirectTCPIPChannel, null, null, channelOpenDirectTCPIPChannel.getStdoutStream(), socketAccept.getOutputStream(), "RemoteToLocal");
                                StreamForwarder streamForwarder2 = new StreamForwarder(channelOpenDirectTCPIPChannel, streamForwarder, socketAccept, socketAccept.getInputStream(), channelOpenDirectTCPIPChannel.stdinStream, "LocalToRemote");
                                streamForwarder.setDaemon(true);
                                streamForwarder2.setDaemon(true);
                                streamForwarder.start();
                                streamForwarder2.start();
                            } catch (IOException e) {
                                e = e;
                                channelOpenDirectTCPIPChannel = channelOpenDirectTCPIPChannel;
                                try {
                                    channelOpenDirectTCPIPChannel.cm.closeChannel(channelOpenDirectTCPIPChannel, "Weird error during creation of StreamForwarder (" + e.getMessage() + ")", true);
                                } catch (IOException unused) {
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (IOException unused2) {
                        socketAccept.close();
                    }
                } catch (IOException unused3) {
                    stopWorking();
                    return;
                }
            }
        } catch (IOException unused4) {
            stopWorking();
        }
    }

    @Override // com.trilead.ssh2.channel.IChannelWorkerThread
    public void stopWorking() {
        try {
            this.ss.close();
        } catch (IOException unused) {
        }
    }

    public LocalAcceptThread(ChannelManager channelManager, InetSocketAddress inetSocketAddress, String str, int i) throws IOException {
        this.cm = channelManager;
        this.host_to_connect = str;
        this.port_to_connect = i;
        ServerSocket serverSocket = new ServerSocket();
        this.ss = serverSocket;
        serverSocket.bind(inetSocketAddress);
    }
}
