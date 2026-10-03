package com.trilead.ssh2;

import com.trilead.ssh2.channel.ChannelManager;
import com.trilead.ssh2.channel.DynamicAcceptThread;
import java.net.InetSocketAddress;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DynamicPortForwarder {
    ChannelManager cm;
    DynamicAcceptThread dat;

    public DynamicPortForwarder(ChannelManager channelManager, InetSocketAddress inetSocketAddress, int i) {
        this.cm = channelManager;
        DynamicAcceptThread dynamicAcceptThread = new DynamicAcceptThread(channelManager, inetSocketAddress, i);
        this.dat = dynamicAcceptThread;
        dynamicAcceptThread.setDaemon(true);
        this.dat.start();
    }

    public void close() {
        this.dat.stopWorking();
    }

    public DynamicPortForwarder(ChannelManager channelManager, int i, int i2) {
        this.cm = channelManager;
        DynamicAcceptThread dynamicAcceptThread = new DynamicAcceptThread(channelManager, i, i2);
        this.dat = dynamicAcceptThread;
        dynamicAcceptThread.setDaemon(true);
        this.dat.start();
    }
}
