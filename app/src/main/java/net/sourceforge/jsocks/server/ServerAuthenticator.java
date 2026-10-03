package net.sourceforge.jsocks.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.Socket;
import net.sourceforge.jsocks.ProxyMessage;
import net.sourceforge.jsocks.UDPEncapsulation;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public interface ServerAuthenticator {
    boolean checkRequest(DatagramPacket datagramPacket, boolean z);

    boolean checkRequest(ProxyMessage proxyMessage);

    void endSession();

    InputStream getInputStream();

    OutputStream getOutputStream();

    UDPEncapsulation getUdpEncapsulation();

    ServerAuthenticator startSession(Socket socket);
}
