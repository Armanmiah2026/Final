package com.trilead.ssh2;

import com.trilead.ssh2.sftp.AttribFlags;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class DHGexParameters {
    private static final int MAX_ALLOWED = 8192;
    private static final int MIN_ALLOWED = 1024;
    private final int max_group_len;
    private final int min_group_len;
    private final int pref_group_len;

    public DHGexParameters() {
        this(1024, 2048, AttribFlags.SSH_FILEXFER_ATTR_MIME_TYPE);
    }

    public int getMax_group_len() {
        return this.max_group_len;
    }

    public int getMin_group_len() {
        return this.min_group_len;
    }

    public int getPref_group_len() {
        return this.pref_group_len;
    }

    public DHGexParameters(int i) {
        if (i < 1024 || i > 8192) {
            throw new IllegalArgumentException("pref_group_len out of range!");
        }
        this.pref_group_len = i;
        this.min_group_len = 0;
        this.max_group_len = 0;
    }

    public DHGexParameters(int i, int i2, int i3) {
        if (i < 1024 || i > 8192) {
            throw new IllegalArgumentException("min_group_len out of range!");
        }
        if (i2 < 1024 || i2 > 8192) {
            throw new IllegalArgumentException("pref_group_len out of range!");
        }
        if (i3 < 1024 || i3 > 8192) {
            throw new IllegalArgumentException("max_group_len out of range!");
        }
        if (i2 < i || i2 > i3) {
            throw new IllegalArgumentException("pref_group_len is incompatible with min and max!");
        }
        if (i3 >= i) {
            this.min_group_len = i;
            this.pref_group_len = i2;
            this.max_group_len = i3;
            return;
        }
        throw new IllegalArgumentException("max_group_len must not be smaller than min_group_len!");
    }
}
