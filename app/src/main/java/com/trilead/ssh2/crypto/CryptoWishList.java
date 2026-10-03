package com.trilead.ssh2.crypto;

import com.trilead.ssh2.crypto.cipher.BlockCipherFactory;
import com.trilead.ssh2.crypto.digest.MessageMac;
import com.trilead.ssh2.transport.KexManager;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class CryptoWishList {
    public String[] kexAlgorithms = KexManager.getDefaultKexAlgorithmList();
    public String[] serverHostKeyAlgorithms = KexManager.getDefaultServerHostkeyAlgorithmList();
    public String[] c2s_enc_algos = BlockCipherFactory.getDefaultCipherList();
    public String[] s2c_enc_algos = BlockCipherFactory.getDefaultCipherList();
    public String[] c2s_mac_algos = MessageMac.getMacs();
    public String[] s2c_mac_algos = MessageMac.getMacs();
}
