package com.trilead.ssh2;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class ConnectionInfo {
    public String clientToServerCryptoAlgorithm;
    public String clientToServerMACAlgorithm;
    public String keyExchangeAlgorithm;
    public int keyExchangeCounter = 0;
    public byte[] serverHostKey;
    public String serverHostKeyAlgorithm;
    public String serverToClientCryptoAlgorithm;
    public String serverToClientMACAlgorithm;
}
