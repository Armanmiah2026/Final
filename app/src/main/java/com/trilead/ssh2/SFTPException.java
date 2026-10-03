package com.trilead.ssh2;

import com.trilead.ssh2.sftp.ErrorCodes;
import java.io.IOException;
import sensei0.za0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class SFTPException extends IOException {
    private static final long serialVersionUID = 578654644222421811L;
    private final int sftpErrorCode;
    private final String sftpErrorMessage;

    public SFTPException(String str, int i) {
        super(constructMessage(str, i));
        this.sftpErrorMessage = str;
        this.sftpErrorCode = i;
    }

    private static String constructMessage(String str, int i) {
        String[] description = ErrorCodes.getDescription(i);
        if (description == null) {
            return za0.k(str, " (UNKNOW SFTP ERROR CODE)");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" (");
        sb.append(description[0]);
        sb.append(": ");
        return za0.o(sb, description[1], ")");
    }

    public int getServerErrorCode() {
        return this.sftpErrorCode;
    }

    public String getServerErrorCodeSymbol() {
        String[] description = ErrorCodes.getDescription(this.sftpErrorCode);
        if (description != null) {
            return description[0];
        }
        return "UNKNOW SFTP ERROR CODE " + this.sftpErrorCode;
    }

    public String getServerErrorCodeVerbose() {
        String[] description = ErrorCodes.getDescription(this.sftpErrorCode);
        return description == null ? za0.n(new StringBuilder("The error code "), this.sftpErrorCode, " is unknown.") : description[1];
    }

    public String getServerErrorMessage() {
        return this.sftpErrorMessage;
    }
}
