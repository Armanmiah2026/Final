package com.trilead.ssh2;

import com.trilead.ssh2.channel.Channel;
import com.trilead.ssh2.channel.ChannelManager;
import com.trilead.ssh2.channel.LocalAcceptThread;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class LocalStreamForwarder {
    ChannelManager cm;
    Channel cn;
    String host_to_connect;
    LocalAcceptThread lat;
    int port_to_connect;

    public LocalStreamForwarder(ChannelManager channelManager, String str, int i) {
        this.cm = channelManager;
        this.host_to_connect = str;
        this.port_to_connect = i;
        this.cn = channelManager.openDirectTCPIPChannel(str, i, "127.0.0.1", 0);
    }

    public void close() {
        this.cm.closeChannel(this.cn, "Closed due to user request.", true);
    }

    public InputStream getInputStream() {
        return this.cn.getStdoutStream();
    }

    public OutputStream getOutputStream() {
        return this.cn.getStdinStream();
    }
}
