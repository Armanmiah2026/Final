package sensei0;

import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public final class nj {
    public static final String[] D;
    public static final int[] E;
    public static final byte[] F;
    public static final kj G;
    public static final kj[][] H;
    public static final kj[] I;
    public static final HashMap[] J;
    public static final HashMap[] K;
    public static final Set L;
    public static final HashMap M;
    public static final Charset N;
    public static final byte[] O;
    public static final byte[] P;
    public final FileDescriptor a;
    public int b;
    public final HashMap[] c;
    public final HashSet d;
    public ByteOrder e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public jj k;
    public static final boolean l = Log.isLoggable("ExifInterface", 3);
    public static final List m = Arrays.asList(1, 6, 3, 8);
    public static final List n = Arrays.asList(2, 7, 4, 5);
    public static final int[] o = {8, 8, 8};
    public static final int[] p = {8};
    public static final byte[] q = {-1, -40, -1};
    public static final byte[] r = {102, 116, 121, 112};
    public static final byte[] s = {109, 105, 102, 49};
    public static final byte[] t = {104, 101, 105, 99};
    public static final byte[] u = {97, 118, 105, 102};
    public static final byte[] v = {97, 118, 105, 115};
    public static final byte[] w = {79, 76, 89, 77, 80, 0};
    public static final byte[] x = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] y = {-119, 80, 78, 71, 13, 10, 26, 10};
    public static final byte[] z = "XML:com.adobe.xmp\u0000\u0000\u0000\u0000\u0000".getBytes(StandardCharsets.UTF_8);
    public static final byte[] A = {82, 73, 70, 70};
    public static final byte[] B = {87, 69, 66, 80};
    public static final byte[] C = {69, 88, 73, 70};

    static {
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        D = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        E = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        F = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        kj[] kjVarArr = {new kj(254, "NewSubfileType", 4), new kj(255, "SubfileType", 4), new kj("ImageWidth", 256, 3, 4), new kj("ImageLength", 257, 3, 4), new kj(258, "BitsPerSample", 3), new kj(259, "Compression", 3), new kj(262, "PhotometricInterpretation", 3), new kj(270, "ImageDescription", 2), new kj(271, "Make", 2), new kj(272, "Model", 2), new kj("StripOffsets", 273, 3, 4), new kj(274, "Orientation", 3), new kj(277, "SamplesPerPixel", 3), new kj("RowsPerStrip", 278, 3, 4), new kj("StripByteCounts", 279, 3, 4), new kj(282, "XResolution", 5), new kj(283, "YResolution", 5), new kj(284, "PlanarConfiguration", 3), new kj(296, "ResolutionUnit", 3), new kj(301, "TransferFunction", 3), new kj(305, "Software", 2), new kj(306, "DateTime", 2), new kj(315, "Artist", 2), new kj(318, "WhitePoint", 5), new kj(319, "PrimaryChromaticities", 5), new kj(330, "SubIFDPointer", 4), new kj(513, "JPEGInterchangeFormat", 4), new kj(514, "JPEGInterchangeFormatLength", 4), new kj(529, "YCbCrCoefficients", 5), new kj(530, "YCbCrSubSampling", 3), new kj(531, "YCbCrPositioning", 3), new kj(532, "ReferenceBlackWhite", 5), new kj(33432, "Copyright", 2), new kj(34665, "ExifIFDPointer", 4), new kj(34853, "GPSInfoIFDPointer", 4), new kj(4, "SensorTopBorder", 4), new kj(5, "SensorLeftBorder", 4), new kj(6, "SensorBottomBorder", 4), new kj(7, "SensorRightBorder", 4), new kj(23, "ISO", 3), new kj(46, "JpgFromRaw", 7), new kj(700, "Xmp", 1)};
        kj[] kjVarArr2 = {new kj(33434, "ExposureTime", 5), new kj(33437, "FNumber", 5), new kj(34850, "ExposureProgram", 3), new kj(34852, "SpectralSensitivity", 2), new kj(34855, "PhotographicSensitivity", 3), new kj(34856, "OECF", 7), new kj(34864, "SensitivityType", 3), new kj(34865, "StandardOutputSensitivity", 4), new kj(34866, "RecommendedExposureIndex", 4), new kj(34867, "ISOSpeed", 4), new kj(34868, "ISOSpeedLatitudeyyy", 4), new kj(34869, "ISOSpeedLatitudezzz", 4), new kj(36864, "ExifVersion", 2), new kj(36867, "DateTimeOriginal", 2), new kj(36868, "DateTimeDigitized", 2), new kj(36880, "OffsetTime", 2), new kj(36881, "OffsetTimeOriginal", 2), new kj(36882, "OffsetTimeDigitized", 2), new kj(37121, "ComponentsConfiguration", 7), new kj(37122, "CompressedBitsPerPixel", 5), new kj(37377, "ShutterSpeedValue", 10), new kj(37378, "ApertureValue", 5), new kj(37379, "BrightnessValue", 10), new kj(37380, "ExposureBiasValue", 10), new kj(37381, "MaxApertureValue", 5), new kj(37382, "SubjectDistance", 5), new kj(37383, "MeteringMode", 3), new kj(37384, "LightSource", 3), new kj(37385, "Flash", 3), new kj(37386, "FocalLength", 5), new kj(37396, "SubjectArea", 3), new kj(37500, "MakerNote", 7), new kj(37510, "UserComment", 7), new kj(37520, "SubSecTime", 2), new kj(37521, "SubSecTimeOriginal", 2), new kj(37522, "SubSecTimeDigitized", 2), new kj(40960, "FlashpixVersion", 7), new kj(40961, "ColorSpace", 3), new kj("PixelXDimension", 40962, 3, 4), new kj("PixelYDimension", 40963, 3, 4), new kj(40964, "RelatedSoundFile", 2), new kj(40965, "InteroperabilityIFDPointer", 4), new kj(41483, "FlashEnergy", 5), new kj(41484, "SpatialFrequencyResponse", 7), new kj(41486, "FocalPlaneXResolution", 5), new kj(41487, "FocalPlaneYResolution", 5), new kj(41488, "FocalPlaneResolutionUnit", 3), new kj(41492, "SubjectLocation", 3), new kj(41493, "ExposureIndex", 5), new kj(41495, "SensingMethod", 3), new kj(41728, "FileSource", 7), new kj(41729, "SceneType", 7), new kj(41730, "CFAPattern", 7), new kj(41985, "CustomRendered", 3), new kj(41986, "ExposureMode", 3), new kj(41987, "WhiteBalance", 3), new kj(41988, "DigitalZoomRatio", 5), new kj(41989, "FocalLengthIn35mmFilm", 3), new kj(41990, "SceneCaptureType", 3), new kj(41991, "GainControl", 3), new kj(41992, "Contrast", 3), new kj(41993, "Saturation", 3), new kj(41994, "Sharpness", 3), new kj(41995, "DeviceSettingDescription", 7), new kj(41996, "SubjectDistanceRange", 3), new kj(42016, "ImageUniqueID", 2), new kj(42032, "CameraOwnerName", 2), new kj(42033, "BodySerialNumber", 2), new kj(42034, "LensSpecification", 5), new kj(42035, "LensMake", 2), new kj(42036, "LensModel", 2), new kj(42240, "Gamma", 5), new kj(50706, "DNGVersion", 1), new kj("DefaultCropSize", 50720, 3, 4)};
        kj[] kjVarArr3 = {new kj(0, "GPSVersionID", 1), new kj(1, "GPSLatitudeRef", 2), new kj("GPSLatitude", 2, 5, 10), new kj(3, "GPSLongitudeRef", 2), new kj("GPSLongitude", 4, 5, 10), new kj(5, "GPSAltitudeRef", 1), new kj(6, "GPSAltitude", 5), new kj(7, "GPSTimeStamp", 5), new kj(8, "GPSSatellites", 2), new kj(9, "GPSStatus", 2), new kj(10, "GPSMeasureMode", 2), new kj(11, "GPSDOP", 5), new kj(12, "GPSSpeedRef", 2), new kj(13, "GPSSpeed", 5), new kj(14, "GPSTrackRef", 2), new kj(15, "GPSTrack", 5), new kj(16, "GPSImgDirectionRef", 2), new kj(17, "GPSImgDirection", 5), new kj(18, "GPSMapDatum", 2), new kj(19, "GPSDestLatitudeRef", 2), new kj(20, "GPSDestLatitude", 5), new kj(21, "GPSDestLongitudeRef", 2), new kj(22, "GPSDestLongitude", 5), new kj(23, "GPSDestBearingRef", 2), new kj(24, "GPSDestBearing", 5), new kj(25, "GPSDestDistanceRef", 2), new kj(26, "GPSDestDistance", 5), new kj(27, "GPSProcessingMethod", 7), new kj(28, "GPSAreaInformation", 7), new kj(29, "GPSDateStamp", 2), new kj(30, "GPSDifferential", 3), new kj(31, "GPSHPositioningError", 5)};
        kj[] kjVarArr4 = {new kj(1, "InteroperabilityIndex", 2)};
        kj[] kjVarArr5 = {new kj(254, "NewSubfileType", 4), new kj(255, "SubfileType", 4), new kj("ThumbnailImageWidth", 256, 3, 4), new kj("ThumbnailImageLength", 257, 3, 4), new kj(258, "BitsPerSample", 3), new kj(259, "Compression", 3), new kj(262, "PhotometricInterpretation", 3), new kj(270, "ImageDescription", 2), new kj(271, "Make", 2), new kj(272, "Model", 2), new kj("StripOffsets", 273, 3, 4), new kj(274, "ThumbnailOrientation", 3), new kj(277, "SamplesPerPixel", 3), new kj("RowsPerStrip", 278, 3, 4), new kj("StripByteCounts", 279, 3, 4), new kj(282, "XResolution", 5), new kj(283, "YResolution", 5), new kj(284, "PlanarConfiguration", 3), new kj(296, "ResolutionUnit", 3), new kj(301, "TransferFunction", 3), new kj(305, "Software", 2), new kj(306, "DateTime", 2), new kj(315, "Artist", 2), new kj(318, "WhitePoint", 5), new kj(319, "PrimaryChromaticities", 5), new kj(330, "SubIFDPointer", 4), new kj(513, "JPEGInterchangeFormat", 4), new kj(514, "JPEGInterchangeFormatLength", 4), new kj(529, "YCbCrCoefficients", 5), new kj(530, "YCbCrSubSampling", 3), new kj(531, "YCbCrPositioning", 3), new kj(532, "ReferenceBlackWhite", 5), new kj(33432, "Copyright", 2), new kj(34665, "ExifIFDPointer", 4), new kj(34853, "GPSInfoIFDPointer", 4), new kj(50706, "DNGVersion", 1), new kj("DefaultCropSize", 50720, 3, 4)};
        G = new kj(273, "StripOffsets", 3);
        H = new kj[][]{kjVarArr, kjVarArr2, kjVarArr3, kjVarArr4, kjVarArr5, kjVarArr, new kj[]{new kj(256, "ThumbnailImage", 7), new kj(8224, "CameraSettingsIFDPointer", 4), new kj(8256, "ImageProcessingIFDPointer", 4)}, new kj[]{new kj(257, "PreviewImageStart", 4), new kj(258, "PreviewImageLength", 4)}, new kj[]{new kj(4371, "AspectFrame", 3)}, new kj[]{new kj(55, "ColorSpace", 3)}};
        I = new kj[]{new kj(330, "SubIFDPointer", 4), new kj(34665, "ExifIFDPointer", 4), new kj(34853, "GPSInfoIFDPointer", 4), new kj(40965, "InteroperabilityIFDPointer", 4), new kj(8224, "CameraSettingsIFDPointer", 1), new kj(8256, "ImageProcessingIFDPointer", 1)};
        J = new HashMap[10];
        K = new HashMap[10];
        L = Collections.unmodifiableSet(new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance")));
        M = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        N = charsetForName;
        O = "Exif\u0000\u0000".getBytes(charsetForName);
        P = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            kj[][] kjVarArr6 = H;
            if (i >= kjVarArr6.length) {
                HashMap map = M;
                kj[] kjVarArr7 = I;
                map.put(Integer.valueOf(kjVarArr7[0].a), 5);
                map.put(Integer.valueOf(kjVarArr7[1].a), 1);
                map.put(Integer.valueOf(kjVarArr7[2].a), 2);
                map.put(Integer.valueOf(kjVarArr7[3].a), 3);
                map.put(Integer.valueOf(kjVarArr7[4].a), 7);
                map.put(Integer.valueOf(kjVarArr7[5].a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            J[i] = new HashMap();
            K[i] = new HashMap();
            for (kj kjVar : kjVarArr6[i]) {
                J[i].put(Integer.valueOf(kjVar.a), kjVar);
                K[i].put(kjVar.b, kjVar);
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad A[Catch: all -> 0x002e, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x002e, blocks: (B:3:0x001f, B:5:0x0022, B:12:0x0037, B:18:0x0054, B:25:0x0067, B:31:0x007a, B:28:0x006f, B:29:0x0073, B:30:0x0077, B:32:0x0084, B:34:0x008d, B:36:0x0093, B:38:0x0099, B:40:0x009f, B:45:0x00ad), top: B:55:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public nj(java.io.ByteArrayInputStream r9) {
        /*
            r8 = this;
            r8.<init>()
            sensei0.kj[][] r0 = sensei0.nj.H
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r8.c = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r2 = r0.length
            r1.<init>(r2)
            r8.d = r1
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            r8.e = r1
            java.lang.String r1 = "ExifInterface"
            boolean r2 = sensei0.nj.l
            r3 = 0
            r8.a = r3
            r3 = 0
            r4 = r3
        L1f:
            int r5 = r0.length     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            if (r4 >= r5) goto L37
            java.util.HashMap[] r5 = r8.c     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r6.<init>()     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r5[r4] = r6     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            int r4 = r4 + 1
            goto L1f
        L2e:
            r9 = move-exception
            goto Lb3
        L31:
            r9 = move-exception
            goto Lab
        L34:
            r9 = move-exception
            goto Lab
        L37:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r4 = 5000(0x1388, float:7.006E-42)
            r0.<init>(r9, r4)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            int r9 = r8.f(r0)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r8.b = r9     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r4 = 14
            r5 = 13
            r6 = 9
            r7 = 4
            if (r9 == r7) goto L84
            if (r9 == r6) goto L84
            if (r9 == r5) goto L84
            if (r9 != r4) goto L54
            goto L84
        L54:
            sensei0.mj r9 = new sensei0.mj     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            int r0 = r8.b     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r3 = 12
            if (r0 == r3) goto L77
            r3 = 15
            if (r0 != r3) goto L64
            goto L77
        L64:
            r3 = 7
            if (r0 != r3) goto L6b
            r8.g(r9)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            goto L7a
        L6b:
            r3 = 10
            if (r0 != r3) goto L73
            r8.k(r9)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            goto L7a
        L73:
            r8.j(r9)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            goto L7a
        L77:
            r8.d(r9, r0)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
        L7a:
            int r0 = r8.g     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            long r3 = (long) r0     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r9.b(r3)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r8.u(r9)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            goto La2
        L84:
            sensei0.ij r9 = new sensei0.ij     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            int r0 = r8.b     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            if (r0 != r7) goto L91
            r8.e(r9, r3, r3)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            goto La2
        L91:
            if (r0 != r5) goto L97
            r8.h(r9)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            goto La2
        L97:
            if (r0 != r6) goto L9d
            r8.i(r9)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
            goto La2
        L9d:
            if (r0 != r4) goto La2
            r8.l(r9)     // Catch: java.lang.Throwable -> L2e java.lang.UnsupportedOperationException -> L31 java.io.IOException -> L34
        La2:
            r8.a()
            if (r2 == 0) goto Lc2
        La7:
            r8.p()
            goto Lc2
        Lab:
            if (r2 == 0) goto Lbc
            java.lang.String r0 = "Invalid image: ExifInterface got an unsupported image format file (ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r0, r9)     // Catch: java.lang.Throwable -> L2e
            goto Lbc
        Lb3:
            r8.a()
            if (r2 == 0) goto Lbb
            r8.p()
        Lbb:
            throw r9
        Lbc:
            r8.a()
            if (r2 == 0) goto Lc2
            goto La7
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.nj.<init>(java.io.ByteArrayInputStream):void");
    }

    public static ByteOrder q(ij ijVar) throws IOException {
        short s2 = ijVar.readShort();
        boolean z2 = l;
        if (s2 == 18761) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s2 == 19789) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s2));
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        HashMap[] mapArr = this.c;
        if (strB != null && b("DateTime") == null) {
            HashMap map = mapArr[0];
            byte[] bytes = strB.concat(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR).getBytes(N);
            map.put("DateTime", new jj(2, bytes.length, bytes));
        }
        if (b("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", jj.a(0L, this.e));
        }
        if (b("ImageLength") == null) {
            mapArr[0].put("ImageLength", jj.a(0L, this.e));
        }
        if (b("Orientation") == null) {
            mapArr[0].put("Orientation", jj.a(0L, this.e));
        }
        if (b("LightSource") == null) {
            mapArr[1].put("LightSource", jj.a(0L, this.e));
        }
    }

    public final String b(String str) {
        jj jjVarC = c(str);
        if (jjVarC != null) {
            int i = jjVarC.a;
            if (str.equals("GPSTimeStamp")) {
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i);
                    return null;
                }
                lj[] ljVarArr = (lj[]) jjVarC.g(this.e);
                if (ljVarArr == null || ljVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(ljVarArr));
                    return null;
                }
                lj ljVar = ljVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (ljVar.a / ljVar.b));
                lj ljVar2 = ljVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (ljVar2.a / ljVar2.b));
                lj ljVar3 = ljVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (ljVar3.a / ljVar3.b)));
            }
            if (!L.contains(str)) {
                return jjVarC.f(this.e);
            }
            try {
                return Double.toString(jjVarC.d(this.e));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final jj c(String str) {
        jj jjVar;
        int i;
        jj jjVar2;
        if ("ISOSpeedRatings".equals(str)) {
            if (l) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        if ("Xmp".equals(str) && (i = this.b) != 4 && ((i == 9 || i == 15 || i == 12 || i == 13) && (jjVar2 = this.k) != null)) {
            return jjVar2;
        }
        for (int i2 = 0; i2 < H.length; i2++) {
            jj jjVar3 = (jj) this.c[i2].get(str);
            if (jjVar3 != null) {
                return jjVar3;
            }
        }
        if (!"Xmp".equals(str) || (jjVar = this.k) == null) {
            return null;
        }
        return jjVar;
    }

    public final void d(mj mjVar, int i) {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIC files is supported from SDK 28 and above");
        }
        if (i == 15 && i2 < 31) {
            throw new UnsupportedOperationException("Reading EXIF from AVIF files is supported from SDK 31 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(new hj(mjVar));
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.c;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", jj.c(Integer.parseInt(strExtractMetadata), this.e));
                }
                if (strExtractMetadata3 != null) {
                    mapArr[0].put("ImageLength", jj.c(Integer.parseInt(strExtractMetadata3), this.e));
                }
                if (strExtractMetadata2 != null) {
                    int i3 = Integer.parseInt(strExtractMetadata2);
                    mapArr[0].put("Orientation", jj.c(i3 != 90 ? i3 != 180 ? i3 != 270 ? 1 : 8 : 3 : 6, this.e));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i4 = Integer.parseInt(strExtractMetadata4);
                    int i5 = Integer.parseInt(strExtractMetadata5);
                    if (i5 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    mjVar.b(i4);
                    byte[] bArr = new byte[6];
                    mjVar.readFully(bArr);
                    int i6 = i4 + 6;
                    int i7 = i5 - 6;
                    if (!Arrays.equals(bArr, O)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i7];
                    mjVar.readFully(bArr2);
                    this.g = i6;
                    r(bArr2, 0);
                }
                String strExtractMetadata8 = mediaMetadataRetriever.extractMetadata(41);
                String strExtractMetadata9 = mediaMetadataRetriever.extractMetadata(42);
                if (strExtractMetadata8 != null && strExtractMetadata9 != null) {
                    int i8 = Integer.parseInt(strExtractMetadata8);
                    int i9 = Integer.parseInt(strExtractMetadata9);
                    long j = i8;
                    mjVar.b(j);
                    byte[] bArr3 = new byte[i9];
                    mjVar.readFully(bArr3);
                    this.k = new jj(j, bArr3, 1, i9);
                }
                if (l) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata3 + ", rotation " + strExtractMetadata2);
                }
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused) {
                }
            } catch (RuntimeException e) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", e);
            }
        } finally {
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x009e. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00a1. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x00a4. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0158 A[LOOP:0: B:10:0x0034->B:55:0x0158, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015f A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(sensei0.ij r23, int r24, int r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.nj.e(sensei0.ij, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int f(java.io.BufferedInputStream r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.nj.f(java.io.BufferedInputStream):int");
    }

    public final void g(mj mjVar) throws Throwable {
        int i;
        int i2;
        j(mjVar);
        HashMap[] mapArr = this.c;
        jj jjVar = (jj) mapArr[1].get("MakerNote");
        if (jjVar != null) {
            mj mjVar2 = new mj(jjVar.d);
            mjVar2.c = this.e;
            byte[] bArr = w;
            byte[] bArr2 = new byte[bArr.length];
            mjVar2.readFully(bArr2);
            mjVar2.b(0L);
            byte[] bArr3 = x;
            byte[] bArr4 = new byte[bArr3.length];
            mjVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                mjVar2.b(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                mjVar2.b(12L);
            }
            s(mjVar2, 6);
            jj jjVar2 = (jj) mapArr[7].get("PreviewImageStart");
            jj jjVar3 = (jj) mapArr[7].get("PreviewImageLength");
            if (jjVar2 != null && jjVar3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", jjVar2);
                mapArr[5].put("JPEGInterchangeFormatLength", jjVar3);
            }
            jj jjVar4 = (jj) mapArr[8].get("AspectFrame");
            if (jjVar4 != null) {
                int[] iArr = (int[]) jjVar4.g(this.e);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                jj jjVarC = jj.c(i5, this.e);
                jj jjVarC2 = jj.c(i6, this.e);
                mapArr[0].put("ImageWidth", jjVarC);
                mapArr[0].put("ImageLength", jjVarC2);
            }
        }
    }

    public final void h(ij ijVar) throws Throwable {
        if (l) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + ijVar);
        }
        ijVar.c = ByteOrder.BIG_ENDIAN;
        int i = ijVar.b;
        ijVar.a(y.length);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            if (z2 && z3) {
                return;
            }
            try {
                int i2 = ijVar.readInt();
                int i3 = ijVar.readInt();
                int i4 = ijVar.b;
                int i5 = i4 + i2 + 4;
                int i6 = i4 - i;
                if (i6 == 16 && i3 != 1229472850) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appear as the first chunk");
                }
                if (i3 == 1229278788) {
                    return;
                }
                if (i3 == 1700284774 && !z2) {
                    this.g = i6;
                    byte[] bArr = new byte[i2];
                    ijVar.readFully(bArr);
                    int i7 = ijVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(i3 >>> 24);
                    crc32.update(i3 >>> 16);
                    crc32.update(i3 >>> 8);
                    crc32.update(i3);
                    crc32.update(bArr);
                    if (((int) crc32.getValue()) != i7) {
                        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i7 + ", calculated CRC value: " + crc32.getValue());
                    }
                    r(bArr, 0);
                    x();
                    u(new ij(bArr));
                    z2 = true;
                } else if (i3 == 1767135348 && !z3) {
                    byte[] bArr2 = z;
                    if (i2 >= bArr2.length) {
                        int length = bArr2.length;
                        byte[] bArr3 = new byte[length];
                        ijVar.readFully(bArr3);
                        if (Arrays.equals(bArr3, bArr2)) {
                            int i8 = ijVar.b - i;
                            int i9 = i2 - length;
                            byte[] bArr4 = new byte[i9];
                            ijVar.readFully(bArr4);
                            this.k = new jj(i8, bArr4, 1, i9);
                            z3 = true;
                        }
                    }
                }
                ijVar.a(i5 - ijVar.b);
            } catch (EOFException e) {
                throw new IOException("Encountered corrupt PNG file.", e);
            }
        }
    }

    public final void i(ij ijVar) throws Throwable {
        boolean z2 = l;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + ijVar);
        }
        ijVar.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        ijVar.readFully(bArr);
        ijVar.readFully(bArr2);
        ijVar.readFully(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        ijVar.a(i - ijVar.b);
        ijVar.readFully(bArr4);
        e(new ij(bArr4), i, 5);
        ijVar.a(i3 - ijVar.b);
        ijVar.c = ByteOrder.BIG_ENDIAN;
        int i4 = ijVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = ijVar.readUnsignedShort();
            int unsignedShort2 = ijVar.readUnsignedShort();
            if (unsignedShort == G.a) {
                short s2 = ijVar.readShort();
                short s3 = ijVar.readShort();
                jj jjVarC = jj.c(s2, this.e);
                jj jjVarC2 = jj.c(s3, this.e);
                HashMap[] mapArr = this.c;
                mapArr[0].put("ImageLength", jjVarC);
                mapArr[0].put("ImageWidth", jjVarC2);
                if (z2) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s2) + ", width: " + ((int) s3));
                    return;
                }
                return;
            }
            ijVar.a(unsignedShort2);
        }
    }

    public final void j(mj mjVar) throws Throwable {
        o(mjVar);
        s(mjVar, 0);
        w(mjVar, 0);
        w(mjVar, 5);
        w(mjVar, 4);
        x();
        if (this.b == 8) {
            HashMap[] mapArr = this.c;
            jj jjVar = (jj) mapArr[1].get("MakerNote");
            if (jjVar != null) {
                mj mjVar2 = new mj(jjVar.d);
                mjVar2.c = this.e;
                mjVar2.a(6);
                s(mjVar2, 9);
                jj jjVar2 = (jj) mapArr[9].get("ColorSpace");
                if (jjVar2 != null) {
                    mapArr[1].put("ColorSpace", jjVar2);
                }
            }
        }
    }

    public final void k(mj mjVar) throws Throwable {
        if (l) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + mjVar);
        }
        j(mjVar);
        HashMap[] mapArr = this.c;
        jj jjVar = (jj) mapArr[0].get("JpgFromRaw");
        if (jjVar != null) {
            e(new ij(jjVar.d), (int) jjVar.c, 5);
        }
        jj jjVar2 = (jj) mapArr[0].get("ISO");
        jj jjVar3 = (jj) mapArr[1].get("PhotographicSensitivity");
        if (jjVar2 == null || jjVar3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", jjVar2);
    }

    public final void l(ij ijVar) throws Throwable {
        if (l) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + ijVar);
        }
        ijVar.c = ByteOrder.LITTLE_ENDIAN;
        ijVar.a(A.length);
        int i = ijVar.readInt() + 8;
        byte[] bArr = B;
        ijVar.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                ijVar.readFully(bArr2);
                int i2 = ijVar.readInt();
                int i3 = length + 8;
                if (Arrays.equals(C, bArr2)) {
                    byte[] bArrCopyOfRange = new byte[i2];
                    ijVar.readFully(bArrCopyOfRange);
                    byte[] bArr3 = O;
                    if (mm0.i0(bArrCopyOfRange, bArr3)) {
                        bArrCopyOfRange = Arrays.copyOfRange(bArrCopyOfRange, bArr3.length, i2);
                    }
                    this.g = i3;
                    r(bArrCopyOfRange, 0);
                    u(new ij(bArrCopyOfRange));
                    return;
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                length = i3 + i2;
                if (length == i) {
                    return;
                }
                if (length > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                ijVar.a(i2);
            } catch (EOFException e) {
                throw new IOException("Encountered corrupt WebP file.", e);
            }
        }
    }

    public final void m(ij ijVar, HashMap map) throws Throwable {
        jj jjVar = (jj) map.get("JPEGInterchangeFormat");
        jj jjVar2 = (jj) map.get("JPEGInterchangeFormatLength");
        if (jjVar == null || jjVar2 == null) {
            return;
        }
        int iE = jjVar.e(this.e);
        int iE2 = jjVar2.e(this.e);
        if (this.b == 7) {
            iE += this.h;
        }
        if (iE > 0 && iE2 > 0 && this.a == null) {
            ijVar.a(iE);
            ijVar.readFully(new byte[iE2]);
        }
        if (l) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iE + ", length: " + iE2);
        }
    }

    public final boolean n(HashMap map) {
        jj jjVar = (jj) map.get("ImageLength");
        jj jjVar2 = (jj) map.get("ImageWidth");
        if (jjVar == null || jjVar2 == null) {
            return false;
        }
        return jjVar.e(this.e) <= 512 && jjVar2.e(this.e) <= 512;
    }

    public final void o(mj mjVar) throws IOException {
        ByteOrder byteOrderQ = q(mjVar);
        this.e = byteOrderQ;
        mjVar.c = byteOrderQ;
        int unsignedShort = mjVar.readUnsignedShort();
        int i = this.b;
        if (i != 7 && i != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i2 = mjVar.readInt();
        if (i2 < 8) {
            throw new IOException(za0.h(i2, "Invalid first Ifd offset: "));
        }
        int i3 = i2 - 8;
        if (i3 > 0) {
            mjVar.a(i3);
        }
    }

    public final void p() {
        int i = 0;
        while (true) {
            HashMap[] mapArr = this.c;
            if (i >= mapArr.length) {
                return;
            }
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + mapArr[i].size());
            for (Map.Entry entry : mapArr[i].entrySet()) {
                jj jjVar = (jj) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + jjVar.toString() + ", tagValue: '" + jjVar.f(this.e) + "'");
            }
            i++;
        }
    }

    public final void r(byte[] bArr, int i) throws IOException {
        mj mjVar = new mj(bArr);
        o(mjVar);
        s(mjVar, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(sensei0.mj r30, int r31) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 948
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sensei0.nj.s(sensei0.mj, int):void");
    }

    public final void t(int i, String str, String str2) {
        HashMap[] mapArr = this.c;
        if (mapArr[i].isEmpty() || mapArr[i].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i];
        map.put(str2, (jj) map.get(str));
        mapArr[i].remove(str);
    }

    public final void u(ij ijVar) throws Throwable {
        jj jjVar;
        int iE;
        HashMap map = this.c[4];
        jj jjVar2 = (jj) map.get("Compression");
        if (jjVar2 == null) {
            m(ijVar, map);
            return;
        }
        int iE2 = jjVar2.e(this.e);
        if (iE2 != 1) {
            if (iE2 == 6) {
                m(ijVar, map);
                return;
            } else if (iE2 != 7) {
                return;
            }
        }
        jj jjVar3 = (jj) map.get("BitsPerSample");
        if (jjVar3 != null) {
            int[] iArr = (int[]) jjVar3.g(this.e);
            int[] iArr2 = o;
            if (Arrays.equals(iArr2, iArr) || (this.b == 3 && (jjVar = (jj) map.get("PhotometricInterpretation")) != null && (((iE = jjVar.e(this.e)) == 1 && Arrays.equals(iArr, p)) || (iE == 6 && Arrays.equals(iArr, iArr2))))) {
                jj jjVar4 = (jj) map.get("StripOffsets");
                jj jjVar5 = (jj) map.get("StripByteCounts");
                if (jjVar4 == null || jjVar5 == null) {
                    return;
                }
                long[] jArrR = mm0.r(jjVar4.g(this.e));
                long[] jArrR2 = mm0.r(jjVar5.g(this.e));
                if (jArrR == null || jArrR.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrR2 == null || jArrR2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrR.length != jArrR2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j = 0;
                for (long j2 : jArrR2) {
                    j += j2;
                }
                byte[] bArr = new byte[(int) j];
                this.f = true;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < jArrR.length; i3++) {
                    int i4 = (int) jArrR[i3];
                    int i5 = (int) jArrR2[i3];
                    if (i3 < jArrR.length - 1 && i4 + i5 != jArrR[i3 + 1]) {
                        this.f = false;
                    }
                    int i6 = i4 - i;
                    if (i6 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    try {
                        ijVar.a(i6);
                        int i7 = i + i6;
                        byte[] bArr2 = new byte[i5];
                        try {
                            ijVar.readFully(bArr2);
                            i = i7 + i5;
                            System.arraycopy(bArr2, 0, bArr, i2, i5);
                            i2 += i5;
                        } catch (EOFException unused) {
                            Log.d("ExifInterface", "Failed to read " + i5 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d("ExifInterface", "Failed to skip " + i6 + " bytes.");
                        return;
                    }
                }
                if (this.f) {
                    long j3 = jArrR[0];
                    return;
                }
                return;
            }
        }
        if (l) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void v(int i, int i2) throws Throwable {
        HashMap[] mapArr = this.c;
        boolean zIsEmpty = mapArr[i].isEmpty();
        boolean z2 = l;
        if (zIsEmpty || mapArr[i2].isEmpty()) {
            if (z2) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        jj jjVar = (jj) mapArr[i].get("ImageLength");
        jj jjVar2 = (jj) mapArr[i].get("ImageWidth");
        jj jjVar3 = (jj) mapArr[i2].get("ImageLength");
        jj jjVar4 = (jj) mapArr[i2].get("ImageWidth");
        if (jjVar == null || jjVar2 == null) {
            if (z2) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (jjVar3 == null || jjVar4 == null) {
            if (z2) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iE = jjVar.e(this.e);
        int iE2 = jjVar2.e(this.e);
        int iE3 = jjVar3.e(this.e);
        int iE4 = jjVar4.e(this.e);
        if (iE >= iE3 || iE2 >= iE4) {
            return;
        }
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    public final void w(mj mjVar, int i) throws Throwable {
        jj jjVarC;
        jj jjVarC2;
        HashMap[] mapArr = this.c;
        jj jjVar = (jj) mapArr[i].get("DefaultCropSize");
        jj jjVar2 = (jj) mapArr[i].get("SensorTopBorder");
        jj jjVar3 = (jj) mapArr[i].get("SensorLeftBorder");
        jj jjVar4 = (jj) mapArr[i].get("SensorBottomBorder");
        jj jjVar5 = (jj) mapArr[i].get("SensorRightBorder");
        if (jjVar != null) {
            if (jjVar.a == 5) {
                lj[] ljVarArr = (lj[]) jjVar.g(this.e);
                if (ljVarArr == null || ljVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(ljVarArr));
                    return;
                }
                jjVarC = jj.b(ljVarArr[0], this.e);
                jjVarC2 = jj.b(ljVarArr[1], this.e);
            } else {
                int[] iArr = (int[]) jjVar.g(this.e);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                jjVarC = jj.c(iArr[0], this.e);
                jjVarC2 = jj.c(iArr[1], this.e);
            }
            mapArr[i].put("ImageWidth", jjVarC);
            mapArr[i].put("ImageLength", jjVarC2);
            return;
        }
        if (jjVar2 != null && jjVar3 != null && jjVar4 != null && jjVar5 != null) {
            int iE = jjVar2.e(this.e);
            int iE2 = jjVar4.e(this.e);
            int iE3 = jjVar5.e(this.e);
            int iE4 = jjVar3.e(this.e);
            if (iE2 <= iE || iE3 <= iE4) {
                return;
            }
            jj jjVarC3 = jj.c(iE2 - iE, this.e);
            jj jjVarC4 = jj.c(iE3 - iE4, this.e);
            mapArr[i].put("ImageLength", jjVarC3);
            mapArr[i].put("ImageWidth", jjVarC4);
            return;
        }
        jj jjVar6 = (jj) mapArr[i].get("ImageLength");
        jj jjVar7 = (jj) mapArr[i].get("ImageWidth");
        if (jjVar6 == null || jjVar7 == null) {
            jj jjVar8 = (jj) mapArr[i].get("JPEGInterchangeFormat");
            jj jjVar9 = (jj) mapArr[i].get("JPEGInterchangeFormatLength");
            if (jjVar8 == null || jjVar9 == null) {
                return;
            }
            int iE5 = jjVar8.e(this.e);
            int iE6 = jjVar8.e(this.e);
            mjVar.b(iE5);
            byte[] bArr = new byte[iE6];
            mjVar.readFully(bArr);
            e(new ij(bArr), iE5, i);
        }
    }

    public final void x() throws Throwable {
        v(0, 5);
        v(0, 4);
        v(5, 4);
        HashMap[] mapArr = this.c;
        jj jjVar = (jj) mapArr[1].get("PixelXDimension");
        jj jjVar2 = (jj) mapArr[1].get("PixelYDimension");
        if (jjVar != null && jjVar2 != null) {
            mapArr[0].put("ImageWidth", jjVar);
            mapArr[0].put("ImageLength", jjVar2);
        }
        if (mapArr[4].isEmpty() && n(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!n(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        t(0, "ThumbnailOrientation", "Orientation");
        t(0, "ThumbnailImageLength", "ImageLength");
        t(0, "ThumbnailImageWidth", "ImageWidth");
        t(5, "ThumbnailOrientation", "Orientation");
        t(5, "ThumbnailImageLength", "ImageLength");
        t(5, "ThumbnailImageWidth", "ImageWidth");
        t(4, "Orientation", "ThumbnailOrientation");
        t(4, "ImageLength", "ThumbnailImageLength");
        t(4, "ImageWidth", "ThumbnailImageWidth");
    }
}
