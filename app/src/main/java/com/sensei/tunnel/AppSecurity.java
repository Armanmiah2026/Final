package com.sensei.tunnel;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import sensei0.fc0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class AppSecurity {
    public static final AppSecurity a = new AppSecurity();

    static {
        System.loadLibrary("senseicrypto");
    }

    public static byte[] a(Context context) {
        byte[] byteArray;
        Signature[] apkContentsSigners;
        byte[] byteArray2;
        try {
            PackageManager packageManager = context.getPackageManager();
            Signature signature = null;
            if (Build.VERSION.SDK_INT < 28) {
                Signature[] signatureArr = packageManager.getPackageInfo(context.getPackageName(), 64).signatures;
                if (signatureArr != null) {
                    if (signatureArr.length != 0) {
                        signature = signatureArr[0];
                    }
                    if (signature != null && (byteArray = signature.toByteArray()) != null) {
                        return byteArray;
                    }
                }
                return new byte[0];
            }
            SigningInfo signingInfo = packageManager.getPackageInfo(context.getPackageName(), 134217728).signingInfo;
            if (signingInfo != null && (apkContentsSigners = signingInfo.getApkContentsSigners()) != null) {
                if (apkContentsSigners.length != 0) {
                    signature = apkContentsSigners[0];
                }
                if (signature != null && (byteArray2 = signature.toByteArray()) != null) {
                    return byteArray2;
                }
            }
            return new byte[0];
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    private final native String nativeCertSha256(byte[] bArr);

    private final native String nativeDecrypt(String str, byte[] bArr, String str2);

    private final native boolean nativeIntegrityOk(byte[] bArr);

    public final String b(Context context) {
        try {
            return nativeCertSha256(a(context));
        } catch (Throwable unused) {
            return "";
        }
    }

    public final String c(Context context, String str) {
        if (str != null) {
            try {
                return nativeDecrypt(null, a(context), fc0.z0(str).toString());
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public final boolean d(Context context) {
        try {
            return nativeIntegrityOk(a(context));
        } catch (Throwable unused) {
            return false;
        }
    }
}
