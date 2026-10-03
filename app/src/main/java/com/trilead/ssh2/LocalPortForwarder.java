package com.trilead.ssh2;

import com.trilead.ssh2.channel.ChannelManager;
import com.trilead.ssh2.channel.LocalAcceptThread;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class LocalPortForwarder {
    ChannelManager cm;
    String host_to_connect;
    LocalAcceptThread lat;
    int port_to_connect;

    public LocalPortForwarder(ChannelManager channelManager, int i, String str, int i2) {
        this.cm = channelManager;
        this.host_to_connect = str;
        this.port_to_connect = i2;
        LocalAcceptThread localAcceptThread = new LocalAcceptThread(channelManager, i, str, i2);
        this.lat = localAcceptThread;
        localAcceptThread.setDaemon(true);
        this.lat.start();
    }

    public void close() {
        this.lat.stopWorking();
    }

    public LocalPortForwarder(ChannelManager channelManager, InetSocketAddress inetSocketAddress, String str, int i) {
        this.cm = channelManager;
        this.host_to_connect = str;
        this.port_to_connect = i;
        LocalAcceptThread localAcceptThread = new LocalAcceptThread(channelManager, inetSocketAddress, str, i);
        this.lat = localAcceptThread;
        localAcceptThread.setDaemon(true);
        this.lat.start();
    }
}
