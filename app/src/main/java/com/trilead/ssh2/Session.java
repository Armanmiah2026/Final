package com.trilead.ssh2;

import com.trilead.ssh2.channel.Channel;
import com.trilead.ssh2.channel.ChannelManager;
import com.trilead.ssh2.channel.X11ServerData;
import com.trilead.ssh2.packets.PacketSignal;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class Session {
    ChannelManager cm;
    Channel cn;
    final SecureRandom rnd;
    boolean flag_pty_requested = false;
    boolean flag_x11_requested = false;
    boolean flag_execution_started = false;
    boolean flag_closed = false;
    String x11FakeCookie = null;

    public Session(ChannelManager channelManager, SecureRandom secureRandom) {
        this.cm = channelManager;
        this.cn = channelManager.openSessionChannel();
        this.rnd = secureRandom;
    }

    public void close() {
        synchronized (this) {
            try {
                if (this.flag_closed) {
                    return;
                }
                this.flag_closed = true;
                String str = this.x11FakeCookie;
                if (str != null) {
                    this.cm.unRegisterX11Cookie(str, true);
                }
                try {
                    this.cm.closeChannel(this.cn, "Closed due to user request", true);
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void execCommand(String str) {
        if (str == null) {
            throw new IllegalArgumentException("cmd argument may not be null");
        }
        synchronized (this) {
            if (this.flag_closed) {
                throw new IOException("This session is closed.");
            }
            if (this.flag_execution_started) {
                throw new IOException("A remote execution has already started.");
            }
            this.flag_execution_started = true;
        }
        this.cm.requestExecCommand(this.cn, str);
    }

    public String getExitSignal() {
        return this.cn.getExitSignal();
    }

    public Integer getExitStatus() {
        return this.cn.getExitStatus();
    }

    public InputStream getStderr() {
        return this.cn.getStderrStream();
    }

    public OutputStream getStdin() {
        return this.cn.getStdinStream();
    }

    public InputStream getStdout() {
        return this.cn.getStdoutStream();
    }

    public void ping() {
        synchronized (this) {
            if (this.flag_closed) {
                throw new IOException("This session is closed.");
            }
        }
        this.cm.requestChannelTrileadPing(this.cn);
    }

    public void pipeStderr(OutputStream outputStream) {
        this.cn.pipeStderrStream(outputStream);
    }

    public void pipeStdout(OutputStream outputStream) {
        this.cn.pipeStdoutStream(outputStream);
    }

    public void requestDumbPTY() throws IOException {
        requestPTY("dumb", 0, 0, 0, 0, null);
    }

    public void requestPTY(String str) throws IOException {
        requestPTY(str, 0, 0, 0, 0, null);
    }

    public void requestWindowChange(int i, int i2, int i3, int i4) {
        synchronized (this) {
            if (this.flag_closed) {
                throw new IOException("This session is closed.");
            }
            if (!this.flag_pty_requested) {
                throw new IOException("A PTY was not requested.");
            }
        }
        this.cn.requestWindowChange(i, i2, i3, i4);
    }

    public void requestX11Forwarding(String str, int i, byte[] bArr, boolean z) {
        String string;
        if (str == null) {
            throw new IllegalArgumentException("hostname argument may not be null");
        }
        synchronized (this) {
            if (this.flag_closed) {
                throw new IOException("This session is closed.");
            }
            if (this.flag_x11_requested) {
                throw new IOException("X11 forwarding was already requested.");
            }
            if (this.flag_execution_started) {
                throw new IOException("Cannot request X11 forwarding at this stage anymore, a remote execution has already started.");
            }
            this.flag_x11_requested = true;
        }
        X11ServerData x11ServerData = new X11ServerData();
        x11ServerData.hostname = str;
        x11ServerData.port = i;
        x11ServerData.x11_magic_cookie = bArr;
        byte[] bArr2 = new byte[16];
        do {
            this.rnd.nextBytes(bArr2);
            StringBuffer stringBuffer = new StringBuffer(32);
            for (int i2 = 0; i2 < 16; i2++) {
                String hexString = Integer.toHexString(bArr2[i2] & 255);
                if (hexString.length() != 2) {
                    hexString = "0".concat(hexString);
                }
                stringBuffer.append(hexString);
            }
            string = stringBuffer.toString();
        } while (this.cm.checkX11Cookie(string) != null);
        this.cm.requestX11(this.cn, z, "MIT-MAGIC-COOKIE-1", string, 0);
        synchronized (this) {
            try {
                if (!this.flag_closed) {
                    this.x11FakeCookie = string;
                    this.cm.registerX11Cookie(string, x11ServerData);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void setWindowSize(int i) {
        this.cn.setWindowSize(i);
    }

    public void signal(String str) {
        synchronized (this) {
            if (this.flag_closed) {
                throw new IOException("This session is closed.");
            }
        }
        this.cn.signal(str);
    }

    public void startShell() {
        synchronized (this) {
            if (this.flag_closed) {
                throw new IOException("This session is closed.");
            }
            if (this.flag_execution_started) {
                throw new IOException("A remote execution has already started.");
            }
            this.flag_execution_started = true;
        }
        this.cm.requestShell(this.cn);
    }

    public void startSubSystem(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name argument may not be null");
        }
        synchronized (this) {
            if (this.flag_closed) {
                throw new IOException("This session is closed.");
            }
            if (this.flag_execution_started) {
                throw new IOException("A remote execution has already started.");
            }
            this.flag_execution_started = true;
        }
        this.cm.requestSubSystem(this.cn, str);
    }

    public int waitForCondition(int i, long j) {
        if (j >= 0) {
            return this.cm.waitForCondition(this.cn, j, i);
        }
        throw new IllegalArgumentException("timeout must be non-negative!");
    }

    @Deprecated
    public int waitUntilDataAvailable(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout must not be negative!");
        }
        int iWaitForCondition = this.cm.waitForCondition(this.cn, j, 28);
        if ((iWaitForCondition & 1) != 0) {
            return -1;
        }
        if ((iWaitForCondition & 12) != 0) {
            return 1;
        }
        if ((iWaitForCondition & 16) != 0) {
            return 0;
        }
        throw new IllegalStateException(za0.i(iWaitForCondition, "Unexpected condition result (", ")"));
    }

    public void requestPTY(String str, int i, int i2, int i3, int i4, byte[] bArr) throws IOException {
        byte[] bArr2 = bArr;
        if (str == null) {
            throw new IllegalArgumentException("TERM cannot be null.");
        }
        if (bArr2 == null || bArr2.length <= 0) {
            bArr2 = new byte[]{0};
        } else if (bArr2[bArr2.length - 1] != 0) {
            throw new IOException("Illegal terminal modes description, does not end in zero byte");
        }
        byte[] bArr3 = bArr2;
        synchronized (this) {
            if (this.flag_closed) {
                throw new IOException("This session is closed.");
            }
            if (this.flag_pty_requested) {
                throw new IOException("A PTY was already requested.");
            }
            if (this.flag_execution_started) {
                throw new IOException("Cannot request PTY at this stage anymore, a remote execution has already started.");
            }
            this.flag_pty_requested = true;
        }
        this.cm.requestPTY(this.cn, str, i, i2, i3, i4, bArr3);
    }

    public void signal(int i) {
        String strStrsignal = PacketSignal.strsignal(i);
        if (strStrsignal != null) {
            signal(strStrsignal);
            return;
        }
        throw new IllegalArgumentException(za0.h(i, "Unrecognized signal code: "));
    }
}
