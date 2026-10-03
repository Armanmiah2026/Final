package com.trilead.ssh2;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class SFTPv3FileAttributes {
    public Long size = null;
    public Integer uid = null;
    public Integer gid = null;
    public Integer permissions = null;
    public Long atime = null;
    public Long mtime = null;

    public String getOctalPermissions() {
        Integer num = this.permissions;
        if (num == null) {
            return null;
        }
        String string = Integer.toString(num.intValue() & 65535, 8);
        StringBuffer stringBuffer = new StringBuffer();
        for (int length = 7 - string.length(); length > 0; length--) {
            stringBuffer.append('0');
        }
        stringBuffer.append(string);
        return stringBuffer.toString();
    }

    public boolean isDirectory() {
        Integer num = this.permissions;
        return (num == null || (num.intValue() & AttribFlags.SSH_FILEXFER_ATTR_UNTRANSLATED_NAME) == 0) ? false : true;
    }

    public boolean isRegularFile() {
        Integer num = this.permissions;
        return (num == null || (num.intValue() & AttribFlags.SSH_FILEXFER_ATTR_CTIME) == 0) ? false : true;
    }

    public boolean isSymlink() {
        Integer num = this.permissions;
        return (num == null || (num.intValue() & 40960) == 0) ? false : true;
    }
}
