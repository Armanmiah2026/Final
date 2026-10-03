package com.trilead.ssh2.transport;

import com.cbtunnel.plus.view.StatisticGraphData;
import com.trilead.ssh2.crypto.cipher.BlockCipher;
import com.trilead.ssh2.crypto.cipher.CipherInputStream;
import com.trilead.ssh2.crypto.cipher.CipherOutputStream;
import com.trilead.ssh2.crypto.cipher.NullCipher;
import com.trilead.ssh2.crypto.digest.MAC;
import com.trilead.ssh2.log.Logger;
import com.trilead.ssh2.packets.Packets;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class TransportConnection {
    private static final Logger log = Logger.getLogger(TransportConnection.class);
    CipherInputStream cis;
    CipherOutputStream cos;
    MAC recv_mac;
    byte[] recv_mac_buffer;
    byte[] recv_mac_buffer_cmp;
    final SecureRandom rnd;
    MAC send_mac;
    byte[] send_mac_buffer;
    int send_seq_number = 0;
    int recv_seq_number = 0;
    boolean useRandomPadding = false;
    int send_padd_blocksize = 8;
    int recv_padd_blocksize = 8;
    final byte[] send_padding_buffer = new byte[256];
    final byte[] send_packet_header_buffer = new byte[5];
    final byte[] recv_padding_buffer = new byte[256];
    final byte[] recv_packet_header_buffer = new byte[5];
    boolean recv_packet_header_present = false;
    StatisticGraphData.DataTransferStats _upDateBytes = StatisticGraphData.getStatisticData().getDataTransferStats();

    public TransportConnection(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        this.cis = new CipherInputStream(new NullCipher(), inputStream);
        this.cos = new CipherOutputStream(new NullCipher(), outputStream);
        this.rnd = secureRandom;
    }

    public void changeRecvCipher(BlockCipher blockCipher, MAC mac) {
        this.cis.changeCipher(blockCipher);
        this.recv_mac = mac;
        this.recv_mac_buffer = mac != null ? new byte[mac.size()] : null;
        this.recv_mac_buffer_cmp = mac != null ? new byte[mac.size()] : null;
        int blockSize = blockCipher.getBlockSize();
        this.recv_padd_blocksize = blockSize;
        if (blockSize < 8) {
            this.recv_padd_blocksize = 8;
        }
    }

    public void changeSendCipher(BlockCipher blockCipher, MAC mac) {
        if (!(blockCipher instanceof NullCipher)) {
            this.useRandomPadding = true;
        }
        this.cos.changeCipher(blockCipher);
        this.send_mac = mac;
        this.send_mac_buffer = mac != null ? new byte[mac.size()] : null;
        int blockSize = blockCipher.getBlockSize();
        this.send_padd_blocksize = blockSize;
        if (blockSize < 8) {
            this.send_padd_blocksize = 8;
        }
    }

    public int getPacketOverheadEstimate() {
        return this.send_padd_blocksize + 8 + this.send_mac_buffer.length;
    }

    public int receiveMessage(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (this.recv_packet_header_present) {
            this.recv_packet_header_present = false;
        } else {
            this.cis.read(this.recv_packet_header_buffer, 0, 5);
        }
        byte[] bArr2 = this.recv_packet_header_buffer;
        int i4 = ((bArr2[0] & 255) << 24) | ((bArr2[1] & 255) << 16) | ((bArr2[2] & 255) << 8) | (bArr2[3] & 255);
        int i5 = bArr2[4] & 255;
        if (i4 > TransportManager.MAX_PACKET_SIZE || i4 < 12) {
            throw new IOException(za0.i(i4, "Illegal packet size! (", ")"));
        }
        int i6 = (i4 - i5) - 1;
        if (i6 < 0) {
            throw new IOException(za0.i(i5, "Illegal padding_length in packet from remote (", ")"));
        }
        if (i6 >= i2) {
            throw new IOException("Receive buffer too small (" + i2 + ", need " + i6 + ")");
        }
        this.cis.read(bArr, i, i6);
        this.cis.read(this.recv_padding_buffer, 0, i5);
        if (this.recv_mac != null) {
            CipherInputStream cipherInputStream = this.cis;
            byte[] bArr3 = this.recv_mac_buffer;
            cipherInputStream.readPlain(bArr3, 0, bArr3.length);
            this.recv_mac.initMac(this.recv_seq_number);
            this.recv_mac.update(this.recv_packet_header_buffer, 0, 5);
            this.recv_mac.update(bArr, i, i6);
            this.recv_mac.update(this.recv_padding_buffer, 0, i5);
            this.recv_mac.getMac(this.recv_mac_buffer_cmp, 0);
            while (true) {
                byte[] bArr4 = this.recv_mac_buffer;
                if (i3 >= bArr4.length) {
                    break;
                }
                if (bArr4[i3] != this.recv_mac_buffer_cmp[i3]) {
                    throw new IOException("Remote sent corrupt MAC.");
                }
                i3++;
            }
        }
        this.recv_seq_number++;
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(90, "Received " + Packets.getMessageName(bArr[i] & 255) + " " + i6 + " bytes payload");
        }
        this._upDateBytes.addBytesReceived(i6);
        return i6;
    }

    public void sendMessage(byte[] bArr) throws IOException {
        sendMessage(bArr, 0, bArr.length, 0);
    }

    public void sendMessage(byte[] bArr, int i, int i2) throws IOException {
        sendMessage(bArr, i, i2, 0);
    }

    public void sendMessage(byte[] bArr, int i, int i2, int i3) throws IOException {
        if (i3 < 4) {
            i3 = 4;
        } else if (i3 > 64) {
            i3 = 64;
        }
        int i4 = i2 + 5;
        int i5 = i3 + i4;
        int i6 = this.send_padd_blocksize;
        int i7 = i5 % i6;
        if (i7 != 0) {
            i5 += i6 - i7;
        }
        if (i5 < 16) {
            i5 = 16;
        }
        int i8 = i5 - i4;
        if (this.useRandomPadding) {
            for (int i9 = 0; i9 < i8; i9 += 4) {
                int iNextInt = this.rnd.nextInt();
                byte[] bArr2 = this.send_padding_buffer;
                bArr2[i9] = (byte) iNextInt;
                bArr2[i9 + 1] = (byte) (iNextInt >> 8);
                bArr2[i9 + 2] = (byte) (iNextInt >> 16);
                bArr2[i9 + 3] = (byte) (iNextInt >> 24);
            }
        } else {
            for (int i10 = 0; i10 < i8; i10++) {
                this.send_padding_buffer[i10] = 0;
            }
        }
        byte[] bArr3 = this.send_packet_header_buffer;
        int i11 = i5 - 4;
        bArr3[0] = (byte) (i11 >> 24);
        bArr3[1] = (byte) (i11 >> 16);
        bArr3[2] = (byte) (i11 >> 8);
        bArr3[3] = (byte) i11;
        bArr3[4] = (byte) i8;
        this.cos.write(bArr3, 0, 5);
        this.cos.write(bArr, i, i2);
        this.cos.write(this.send_padding_buffer, 0, i8);
        MAC mac = this.send_mac;
        if (mac != null) {
            mac.initMac(this.send_seq_number);
            this.send_mac.update(this.send_packet_header_buffer, 0, 5);
            this.send_mac.update(bArr, i, i2);
            this.send_mac.update(this.send_padding_buffer, 0, i8);
            this.send_mac.getMac(this.send_mac_buffer, 0);
            CipherOutputStream cipherOutputStream = this.cos;
            byte[] bArr4 = this.send_mac_buffer;
            cipherOutputStream.writePlain(bArr4, 0, bArr4.length);
        }
        this.cos.flush();
        this._upDateBytes.addBytesSent(i2);
        Logger logger = log;
        if (logger.isEnabled()) {
            logger.log(90, "Sent " + Packets.getMessageName(bArr[i] & 255) + " " + i2 + " bytes payload");
        }
        this.send_seq_number++;
    }
}
