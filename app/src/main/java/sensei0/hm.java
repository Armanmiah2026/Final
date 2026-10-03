package sensei0;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hm {
    public static final gm a;
    public static final gm b;
    public static final gm c;
    public static final gm d;
    public static final gm e;
    public static final gm f;
    public static final gm g;
    public static final gm h;
    public static final gm i;
    public static final gm j;
    public static final List k;
    public static final List l;
    public static final fm m;
    public static final Map n;
    public static final Map o;

    static {
        gm gmVar = new gm("--aot-shared-library-name=", "AOTSharedLibraryName");
        a = gmVar;
        gm gmVar2 = new gm("--aot-shared-library-name=", "aot-shared-library-name", "io.flutter.embedding.engine.loader.FlutterLoader.", true);
        b = gmVar2;
        gm gmVar3 = new gm("--flutter-assets-dir=", "FlutterAssetsDir");
        c = gmVar3;
        gm gmVar4 = new gm("--flutter-assets-dir=", "flutter-assets-dir", "io.flutter.embedding.engine.loader.FlutterLoader.", true);
        d = gmVar4;
        gm gmVar5 = new gm("--old-gen-heap-size=", "OldGenHeapSize");
        e = gmVar5;
        gm gmVar6 = new gm("--enable-impeller=", "EnableImpeller");
        gm gmVar7 = new gm("--impeller-backend=", "ImpellerBackend");
        gm gmVar8 = new gm("--enable-dart-profiling", "EnableDartProfiling");
        gm gmVar9 = new gm("--profile-startup", "ProfileStartup");
        gm gmVar10 = new gm("--trace-startup", "TraceStartup");
        gm gmVar11 = new gm("--merged-platform-ui-thread", "MergedPlatformUIThread");
        gm gmVar12 = new gm("--vm-snapshot-data=", "VmSnapshotData");
        f = gmVar12;
        gm gmVar13 = new gm("--isolate-snapshot-data=", "IsolateSnapshotData");
        g = gmVar13;
        gm gmVar14 = new gm("--enable-hcpp-and-surface-control", "EnableHcpp");
        gm gmVar15 = new gm("--enable-flutter-gpu", "EnableFlutterGPU");
        gm gmVar16 = new gm("--impeller-lazy-shader-mode", "ImpellerLazyShaderInitialization");
        gm gmVar17 = new gm("--impeller-antialias-lines", "ImpellerAntialiasLines");
        gm gmVar18 = new gm(0, "--enable-opengl-gpu-tracing", "EnableOpenGLGPUTracing");
        gm gmVar19 = new gm(0, "--enable-vulkan-gpu-tracing", "EnableVulkanGPUTracing");
        gm gmVar20 = new gm(0, "--skia-deterministic-rendering", "SkiaDeterministicRendering");
        gm gmVar21 = new gm(0, "--enable-software-rendering", "EnableSoftwareRendering");
        h = gmVar21;
        gm gmVar22 = new gm(0, "--use-test-fonts", "UseTestFonts");
        gm gmVar23 = new gm(0, "--vm-service-port=", "VMServicePort");
        gm gmVar24 = new gm(0, "--enable-vulkan-validation", "EnableVulkanValidation");
        gm gmVar25 = new gm(0, "--test-flag", "TestFlag");
        i = gmVar25;
        gm gmVar26 = new gm(0, "--leak-vm=", "LeakVM");
        j = gmVar26;
        gm gmVar27 = new gm(0, "--start-paused", "StartPaused");
        gm gmVar28 = new gm(0, "--disable-service-auth-codes", "DisableServiceAuthCodes");
        gm gmVar29 = new gm(0, "--disable-service-origin-check", "DisableServiceOriginCheck");
        gm gmVar30 = new gm(0, "--endless-trace-buffer", "EndlessTraceBuffer");
        gm gmVar31 = new gm(0, "--trace-skia", "TraceSkia");
        gm gmVar32 = new gm(0, "--trace-skia-allowlist=", "TraceSkiaAllowList");
        gm gmVar33 = new gm(0, "--trace-systrace", "TraceSystrace");
        gm gmVar34 = new gm(0, "--trace-to-file=", "TraceToFile");
        gm gmVar35 = new gm(0, "--profile-microtasks", "ProfileMicrotasks");
        gm gmVar36 = new gm(0, "--dump-skp-on-shader-compilation", "DumpSkpOnShaderCompilation");
        gm gmVar37 = new gm(0, "--purge-persistent-cache", "PurgePersistentCache");
        gm gmVar38 = new gm(0, "--verbose-logging", "VerboseLogging");
        gm gmVar39 = new gm(0, "--dart-flags=", "DartFlags");
        gm gmVar40 = new gm(0, "--no-enable-merged-platform-ui-thread", "DisableMergedPlatformUIThread");
        List<gm> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(gmVar23, gmVar22, gmVar21, gmVar20, gmVar, gmVar3, gmVar6, gmVar7, gmVar24, gmVar27, gmVar28, gmVar29, gmVar30, gmVar8, gmVar9, gmVar31, gmVar32, gmVar33, gmVar34, gmVar35, gmVar36, gmVar38, gmVar39, gmVar11, gmVar40, gmVar2, gmVar4, gmVar5, gmVar12, gmVar13, gmVar37, gmVar10, gmVar26, gmVar25, gmVar15, gmVar16, gmVar17, gmVar18, gmVar19, gmVar14));
        k = listUnmodifiableList;
        l = Collections.unmodifiableList(Arrays.asList(gmVar40));
        fm fmVar = new fm();
        fmVar.put(gmVar2, gmVar);
        fmVar.put(gmVar4, gmVar3);
        m = fmVar;
        HashMap map = new HashMap(listUnmodifiableList.size());
        HashMap map2 = new HashMap(listUnmodifiableList.size());
        for (gm gmVar41 : listUnmodifiableList) {
            map.put(gmVar41.a, gmVar41);
            map2.put(gmVar41.b, gmVar41);
        }
        n = Collections.unmodifiableMap(map);
        o = Collections.unmodifiableMap(map2);
    }

    public static gm a(String str) {
        int iIndexOf = str.indexOf(61);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf + 1);
        }
        gm gmVar = (gm) n.get(str);
        gm gmVar2 = (gm) m.get(gmVar);
        return gmVar2 != null ? gmVar2 : gmVar;
    }
}
