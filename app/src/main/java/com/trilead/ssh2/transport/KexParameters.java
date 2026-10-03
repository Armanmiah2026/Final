package com.trilead.ssh2.transport;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class KexParameters {
    public String[] compression_algorithms_client_to_server;
    public String[] compression_algorithms_server_to_client;
    public byte[] cookie;
    public String[] encryption_algorithms_client_to_server;
    public String[] encryption_algorithms_server_to_client;
    public boolean first_kex_packet_follows;
    public String[] kex_algorithms;
    public String[] languages_client_to_server;
    public String[] languages_server_to_client;
    public String[] mac_algorithms_client_to_server;
    public String[] mac_algorithms_server_to_client;
    public int reserved_field1;
    public String[] server_host_key_algorithms;
}
