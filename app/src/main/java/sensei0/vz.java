package sensei0;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
public class vz implements xm {
    public Context a;

    public static void b(a6 a6Var, final vz vzVar) {
        mh mhVarH = a6Var.h();
        lx lxVar = lx.g;
        j1 j1Var = new j1(a6Var, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getTemporaryPath", lxVar, mhVarH);
        if (vzVar != null) {
            final int i = 0;
            j1Var.l(new u5(vzVar) { // from class: sensei0.kx
                public final /* synthetic */ vz b;

                {
                    this.b = vzVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i) {
                        case 0:
                            vz vzVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, vzVar2.a.getCacheDir().getPath());
                            } catch (Throwable th) {
                                arrayList = xe.R(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            vz vzVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                Context context = vzVar3.a;
                                File filesDir = context.getFilesDir();
                                if (filesDir == null) {
                                    filesDir = new File(context.getDataDir().getPath(), "files");
                                }
                                arrayList2.add(0, filesDir.getPath());
                            } catch (Throwable th2) {
                                arrayList2 = xe.R(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            vz vzVar4 = this.b;
                            ArrayList arrayList3 = new ArrayList();
                            try {
                                Context context2 = vzVar4.a;
                                File dir = context2.getDir("flutter", 0);
                                if (dir == null) {
                                    dir = new File(context2.getDataDir().getPath(), "app_flutter");
                                }
                                arrayList3.add(0, dir.getPath());
                            } catch (Throwable th3) {
                                arrayList3 = xe.R(th3);
                            }
                            i3Var.s(arrayList3);
                            break;
                        case 3:
                            vz vzVar5 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            try {
                                arrayList4.add(0, vzVar5.a.getCacheDir().getPath());
                            } catch (Throwable th4) {
                                arrayList4 = xe.R(th4);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 4:
                            vz vzVar6 = this.b;
                            ArrayList arrayList5 = new ArrayList();
                            try {
                                String absolutePath = null;
                                File externalFilesDir = vzVar6.a.getExternalFilesDir(null);
                                if (externalFilesDir != null) {
                                    absolutePath = externalFilesDir.getAbsolutePath();
                                }
                                arrayList5.add(0, absolutePath);
                            } catch (Throwable th5) {
                                arrayList5 = xe.R(th5);
                            }
                            i3Var.s(arrayList5);
                            break;
                        case 5:
                            vz vzVar7 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                vzVar7.getClass();
                                ArrayList arrayList7 = new ArrayList();
                                for (File file : vzVar7.a.getExternalCacheDirs()) {
                                    if (file != null) {
                                        arrayList7.add(file.getAbsolutePath());
                                    }
                                }
                                arrayList6.add(0, arrayList7);
                            } catch (Throwable th6) {
                                arrayList6 = xe.R(th6);
                            }
                            i3Var.s(arrayList6);
                            break;
                        default:
                            vz vzVar8 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            try {
                                arrayList8.add(0, vzVar8.a((nx) ((ArrayList) obj).get(0)));
                            } catch (Throwable th7) {
                                arrayList8 = xe.R(th7);
                            }
                            i3Var.s(arrayList8);
                            break;
                    }
                }
            });
        } else {
            j1Var.l(null);
        }
        j1 j1Var2 = new j1(a6Var, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationSupportPath", lxVar, a6Var.h());
        if (vzVar != null) {
            final int i2 = 1;
            j1Var2.l(new u5(vzVar) { // from class: sensei0.kx
                public final /* synthetic */ vz b;

                {
                    this.b = vzVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i2) {
                        case 0:
                            vz vzVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, vzVar2.a.getCacheDir().getPath());
                            } catch (Throwable th) {
                                arrayList = xe.R(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            vz vzVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                Context context = vzVar3.a;
                                File filesDir = context.getFilesDir();
                                if (filesDir == null) {
                                    filesDir = new File(context.getDataDir().getPath(), "files");
                                }
                                arrayList2.add(0, filesDir.getPath());
                            } catch (Throwable th2) {
                                arrayList2 = xe.R(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            vz vzVar4 = this.b;
                            ArrayList arrayList3 = new ArrayList();
                            try {
                                Context context2 = vzVar4.a;
                                File dir = context2.getDir("flutter", 0);
                                if (dir == null) {
                                    dir = new File(context2.getDataDir().getPath(), "app_flutter");
                                }
                                arrayList3.add(0, dir.getPath());
                            } catch (Throwable th3) {
                                arrayList3 = xe.R(th3);
                            }
                            i3Var.s(arrayList3);
                            break;
                        case 3:
                            vz vzVar5 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            try {
                                arrayList4.add(0, vzVar5.a.getCacheDir().getPath());
                            } catch (Throwable th4) {
                                arrayList4 = xe.R(th4);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 4:
                            vz vzVar6 = this.b;
                            ArrayList arrayList5 = new ArrayList();
                            try {
                                String absolutePath = null;
                                File externalFilesDir = vzVar6.a.getExternalFilesDir(null);
                                if (externalFilesDir != null) {
                                    absolutePath = externalFilesDir.getAbsolutePath();
                                }
                                arrayList5.add(0, absolutePath);
                            } catch (Throwable th5) {
                                arrayList5 = xe.R(th5);
                            }
                            i3Var.s(arrayList5);
                            break;
                        case 5:
                            vz vzVar7 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                vzVar7.getClass();
                                ArrayList arrayList7 = new ArrayList();
                                for (File file : vzVar7.a.getExternalCacheDirs()) {
                                    if (file != null) {
                                        arrayList7.add(file.getAbsolutePath());
                                    }
                                }
                                arrayList6.add(0, arrayList7);
                            } catch (Throwable th6) {
                                arrayList6 = xe.R(th6);
                            }
                            i3Var.s(arrayList6);
                            break;
                        default:
                            vz vzVar8 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            try {
                                arrayList8.add(0, vzVar8.a((nx) ((ArrayList) obj).get(0)));
                            } catch (Throwable th7) {
                                arrayList8 = xe.R(th7);
                            }
                            i3Var.s(arrayList8);
                            break;
                    }
                }
            });
        } else {
            j1Var2.l(null);
        }
        j1 j1Var3 = new j1(a6Var, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationDocumentsPath", lxVar, a6Var.h());
        if (vzVar != null) {
            final int i3 = 2;
            j1Var3.l(new u5(vzVar) { // from class: sensei0.kx
                public final /* synthetic */ vz b;

                {
                    this.b = vzVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i3) {
                        case 0:
                            vz vzVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, vzVar2.a.getCacheDir().getPath());
                            } catch (Throwable th) {
                                arrayList = xe.R(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            vz vzVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                Context context = vzVar3.a;
                                File filesDir = context.getFilesDir();
                                if (filesDir == null) {
                                    filesDir = new File(context.getDataDir().getPath(), "files");
                                }
                                arrayList2.add(0, filesDir.getPath());
                            } catch (Throwable th2) {
                                arrayList2 = xe.R(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            vz vzVar4 = this.b;
                            ArrayList arrayList3 = new ArrayList();
                            try {
                                Context context2 = vzVar4.a;
                                File dir = context2.getDir("flutter", 0);
                                if (dir == null) {
                                    dir = new File(context2.getDataDir().getPath(), "app_flutter");
                                }
                                arrayList3.add(0, dir.getPath());
                            } catch (Throwable th3) {
                                arrayList3 = xe.R(th3);
                            }
                            i3Var.s(arrayList3);
                            break;
                        case 3:
                            vz vzVar5 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            try {
                                arrayList4.add(0, vzVar5.a.getCacheDir().getPath());
                            } catch (Throwable th4) {
                                arrayList4 = xe.R(th4);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 4:
                            vz vzVar6 = this.b;
                            ArrayList arrayList5 = new ArrayList();
                            try {
                                String absolutePath = null;
                                File externalFilesDir = vzVar6.a.getExternalFilesDir(null);
                                if (externalFilesDir != null) {
                                    absolutePath = externalFilesDir.getAbsolutePath();
                                }
                                arrayList5.add(0, absolutePath);
                            } catch (Throwable th5) {
                                arrayList5 = xe.R(th5);
                            }
                            i3Var.s(arrayList5);
                            break;
                        case 5:
                            vz vzVar7 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                vzVar7.getClass();
                                ArrayList arrayList7 = new ArrayList();
                                for (File file : vzVar7.a.getExternalCacheDirs()) {
                                    if (file != null) {
                                        arrayList7.add(file.getAbsolutePath());
                                    }
                                }
                                arrayList6.add(0, arrayList7);
                            } catch (Throwable th6) {
                                arrayList6 = xe.R(th6);
                            }
                            i3Var.s(arrayList6);
                            break;
                        default:
                            vz vzVar8 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            try {
                                arrayList8.add(0, vzVar8.a((nx) ((ArrayList) obj).get(0)));
                            } catch (Throwable th7) {
                                arrayList8 = xe.R(th7);
                            }
                            i3Var.s(arrayList8);
                            break;
                    }
                }
            });
        } else {
            j1Var3.l(null);
        }
        j1 j1Var4 = new j1(a6Var, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationCachePath", lxVar, a6Var.h());
        if (vzVar != null) {
            final int i4 = 3;
            j1Var4.l(new u5(vzVar) { // from class: sensei0.kx
                public final /* synthetic */ vz b;

                {
                    this.b = vzVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i4) {
                        case 0:
                            vz vzVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, vzVar2.a.getCacheDir().getPath());
                            } catch (Throwable th) {
                                arrayList = xe.R(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            vz vzVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                Context context = vzVar3.a;
                                File filesDir = context.getFilesDir();
                                if (filesDir == null) {
                                    filesDir = new File(context.getDataDir().getPath(), "files");
                                }
                                arrayList2.add(0, filesDir.getPath());
                            } catch (Throwable th2) {
                                arrayList2 = xe.R(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            vz vzVar4 = this.b;
                            ArrayList arrayList3 = new ArrayList();
                            try {
                                Context context2 = vzVar4.a;
                                File dir = context2.getDir("flutter", 0);
                                if (dir == null) {
                                    dir = new File(context2.getDataDir().getPath(), "app_flutter");
                                }
                                arrayList3.add(0, dir.getPath());
                            } catch (Throwable th3) {
                                arrayList3 = xe.R(th3);
                            }
                            i3Var.s(arrayList3);
                            break;
                        case 3:
                            vz vzVar5 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            try {
                                arrayList4.add(0, vzVar5.a.getCacheDir().getPath());
                            } catch (Throwable th4) {
                                arrayList4 = xe.R(th4);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 4:
                            vz vzVar6 = this.b;
                            ArrayList arrayList5 = new ArrayList();
                            try {
                                String absolutePath = null;
                                File externalFilesDir = vzVar6.a.getExternalFilesDir(null);
                                if (externalFilesDir != null) {
                                    absolutePath = externalFilesDir.getAbsolutePath();
                                }
                                arrayList5.add(0, absolutePath);
                            } catch (Throwable th5) {
                                arrayList5 = xe.R(th5);
                            }
                            i3Var.s(arrayList5);
                            break;
                        case 5:
                            vz vzVar7 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                vzVar7.getClass();
                                ArrayList arrayList7 = new ArrayList();
                                for (File file : vzVar7.a.getExternalCacheDirs()) {
                                    if (file != null) {
                                        arrayList7.add(file.getAbsolutePath());
                                    }
                                }
                                arrayList6.add(0, arrayList7);
                            } catch (Throwable th6) {
                                arrayList6 = xe.R(th6);
                            }
                            i3Var.s(arrayList6);
                            break;
                        default:
                            vz vzVar8 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            try {
                                arrayList8.add(0, vzVar8.a((nx) ((ArrayList) obj).get(0)));
                            } catch (Throwable th7) {
                                arrayList8 = xe.R(th7);
                            }
                            i3Var.s(arrayList8);
                            break;
                    }
                }
            });
        } else {
            j1Var4.l(null);
        }
        j1 j1Var5 = new j1(a6Var, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalStoragePath", lxVar, a6Var.h());
        if (vzVar != null) {
            final int i5 = 4;
            j1Var5.l(new u5(vzVar) { // from class: sensei0.kx
                public final /* synthetic */ vz b;

                {
                    this.b = vzVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i5) {
                        case 0:
                            vz vzVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, vzVar2.a.getCacheDir().getPath());
                            } catch (Throwable th) {
                                arrayList = xe.R(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            vz vzVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                Context context = vzVar3.a;
                                File filesDir = context.getFilesDir();
                                if (filesDir == null) {
                                    filesDir = new File(context.getDataDir().getPath(), "files");
                                }
                                arrayList2.add(0, filesDir.getPath());
                            } catch (Throwable th2) {
                                arrayList2 = xe.R(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            vz vzVar4 = this.b;
                            ArrayList arrayList3 = new ArrayList();
                            try {
                                Context context2 = vzVar4.a;
                                File dir = context2.getDir("flutter", 0);
                                if (dir == null) {
                                    dir = new File(context2.getDataDir().getPath(), "app_flutter");
                                }
                                arrayList3.add(0, dir.getPath());
                            } catch (Throwable th3) {
                                arrayList3 = xe.R(th3);
                            }
                            i3Var.s(arrayList3);
                            break;
                        case 3:
                            vz vzVar5 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            try {
                                arrayList4.add(0, vzVar5.a.getCacheDir().getPath());
                            } catch (Throwable th4) {
                                arrayList4 = xe.R(th4);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 4:
                            vz vzVar6 = this.b;
                            ArrayList arrayList5 = new ArrayList();
                            try {
                                String absolutePath = null;
                                File externalFilesDir = vzVar6.a.getExternalFilesDir(null);
                                if (externalFilesDir != null) {
                                    absolutePath = externalFilesDir.getAbsolutePath();
                                }
                                arrayList5.add(0, absolutePath);
                            } catch (Throwable th5) {
                                arrayList5 = xe.R(th5);
                            }
                            i3Var.s(arrayList5);
                            break;
                        case 5:
                            vz vzVar7 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                vzVar7.getClass();
                                ArrayList arrayList7 = new ArrayList();
                                for (File file : vzVar7.a.getExternalCacheDirs()) {
                                    if (file != null) {
                                        arrayList7.add(file.getAbsolutePath());
                                    }
                                }
                                arrayList6.add(0, arrayList7);
                            } catch (Throwable th6) {
                                arrayList6 = xe.R(th6);
                            }
                            i3Var.s(arrayList6);
                            break;
                        default:
                            vz vzVar8 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            try {
                                arrayList8.add(0, vzVar8.a((nx) ((ArrayList) obj).get(0)));
                            } catch (Throwable th7) {
                                arrayList8 = xe.R(th7);
                            }
                            i3Var.s(arrayList8);
                            break;
                    }
                }
            });
        } else {
            j1Var5.l(null);
        }
        j1 j1Var6 = new j1(a6Var, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalCachePaths", lxVar, a6Var.h());
        if (vzVar != null) {
            final int i6 = 5;
            j1Var6.l(new u5(vzVar) { // from class: sensei0.kx
                public final /* synthetic */ vz b;

                {
                    this.b = vzVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i6) {
                        case 0:
                            vz vzVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, vzVar2.a.getCacheDir().getPath());
                            } catch (Throwable th) {
                                arrayList = xe.R(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            vz vzVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                Context context = vzVar3.a;
                                File filesDir = context.getFilesDir();
                                if (filesDir == null) {
                                    filesDir = new File(context.getDataDir().getPath(), "files");
                                }
                                arrayList2.add(0, filesDir.getPath());
                            } catch (Throwable th2) {
                                arrayList2 = xe.R(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            vz vzVar4 = this.b;
                            ArrayList arrayList3 = new ArrayList();
                            try {
                                Context context2 = vzVar4.a;
                                File dir = context2.getDir("flutter", 0);
                                if (dir == null) {
                                    dir = new File(context2.getDataDir().getPath(), "app_flutter");
                                }
                                arrayList3.add(0, dir.getPath());
                            } catch (Throwable th3) {
                                arrayList3 = xe.R(th3);
                            }
                            i3Var.s(arrayList3);
                            break;
                        case 3:
                            vz vzVar5 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            try {
                                arrayList4.add(0, vzVar5.a.getCacheDir().getPath());
                            } catch (Throwable th4) {
                                arrayList4 = xe.R(th4);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 4:
                            vz vzVar6 = this.b;
                            ArrayList arrayList5 = new ArrayList();
                            try {
                                String absolutePath = null;
                                File externalFilesDir = vzVar6.a.getExternalFilesDir(null);
                                if (externalFilesDir != null) {
                                    absolutePath = externalFilesDir.getAbsolutePath();
                                }
                                arrayList5.add(0, absolutePath);
                            } catch (Throwable th5) {
                                arrayList5 = xe.R(th5);
                            }
                            i3Var.s(arrayList5);
                            break;
                        case 5:
                            vz vzVar7 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                vzVar7.getClass();
                                ArrayList arrayList7 = new ArrayList();
                                for (File file : vzVar7.a.getExternalCacheDirs()) {
                                    if (file != null) {
                                        arrayList7.add(file.getAbsolutePath());
                                    }
                                }
                                arrayList6.add(0, arrayList7);
                            } catch (Throwable th6) {
                                arrayList6 = xe.R(th6);
                            }
                            i3Var.s(arrayList6);
                            break;
                        default:
                            vz vzVar8 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            try {
                                arrayList8.add(0, vzVar8.a((nx) ((ArrayList) obj).get(0)));
                            } catch (Throwable th7) {
                                arrayList8 = xe.R(th7);
                            }
                            i3Var.s(arrayList8);
                            break;
                    }
                }
            });
        } else {
            j1Var6.l(null);
        }
        j1 j1Var7 = new j1(a6Var, "dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalStoragePaths", lxVar, a6Var.h());
        if (vzVar == null) {
            j1Var7.l(null);
        } else {
            final int i7 = 6;
            j1Var7.l(new u5(vzVar) { // from class: sensei0.kx
                public final /* synthetic */ vz b;

                {
                    this.b = vzVar;
                }

                @Override // sensei0.u5
                public final void j(Object obj, i3 i3Var) {
                    switch (i7) {
                        case 0:
                            vz vzVar2 = this.b;
                            ArrayList arrayList = new ArrayList();
                            try {
                                arrayList.add(0, vzVar2.a.getCacheDir().getPath());
                            } catch (Throwable th) {
                                arrayList = xe.R(th);
                            }
                            i3Var.s(arrayList);
                            break;
                        case 1:
                            vz vzVar3 = this.b;
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                Context context = vzVar3.a;
                                File filesDir = context.getFilesDir();
                                if (filesDir == null) {
                                    filesDir = new File(context.getDataDir().getPath(), "files");
                                }
                                arrayList2.add(0, filesDir.getPath());
                            } catch (Throwable th2) {
                                arrayList2 = xe.R(th2);
                            }
                            i3Var.s(arrayList2);
                            break;
                        case 2:
                            vz vzVar4 = this.b;
                            ArrayList arrayList3 = new ArrayList();
                            try {
                                Context context2 = vzVar4.a;
                                File dir = context2.getDir("flutter", 0);
                                if (dir == null) {
                                    dir = new File(context2.getDataDir().getPath(), "app_flutter");
                                }
                                arrayList3.add(0, dir.getPath());
                            } catch (Throwable th3) {
                                arrayList3 = xe.R(th3);
                            }
                            i3Var.s(arrayList3);
                            break;
                        case 3:
                            vz vzVar5 = this.b;
                            ArrayList arrayList4 = new ArrayList();
                            try {
                                arrayList4.add(0, vzVar5.a.getCacheDir().getPath());
                            } catch (Throwable th4) {
                                arrayList4 = xe.R(th4);
                            }
                            i3Var.s(arrayList4);
                            break;
                        case 4:
                            vz vzVar6 = this.b;
                            ArrayList arrayList5 = new ArrayList();
                            try {
                                String absolutePath = null;
                                File externalFilesDir = vzVar6.a.getExternalFilesDir(null);
                                if (externalFilesDir != null) {
                                    absolutePath = externalFilesDir.getAbsolutePath();
                                }
                                arrayList5.add(0, absolutePath);
                            } catch (Throwable th5) {
                                arrayList5 = xe.R(th5);
                            }
                            i3Var.s(arrayList5);
                            break;
                        case 5:
                            vz vzVar7 = this.b;
                            ArrayList arrayList6 = new ArrayList();
                            try {
                                vzVar7.getClass();
                                ArrayList arrayList7 = new ArrayList();
                                for (File file : vzVar7.a.getExternalCacheDirs()) {
                                    if (file != null) {
                                        arrayList7.add(file.getAbsolutePath());
                                    }
                                }
                                arrayList6.add(0, arrayList7);
                            } catch (Throwable th6) {
                                arrayList6 = xe.R(th6);
                            }
                            i3Var.s(arrayList6);
                            break;
                        default:
                            vz vzVar8 = this.b;
                            ArrayList arrayList8 = new ArrayList();
                            try {
                                arrayList8.add(0, vzVar8.a((nx) ((ArrayList) obj).get(0)));
                            } catch (Throwable th7) {
                                arrayList8 = xe.R(th7);
                            }
                            i3Var.s(arrayList8);
                            break;
                    }
                }
            });
        }
    }

    public final ArrayList a(nx nxVar) {
        String str;
        ArrayList arrayList = new ArrayList();
        Context context = this.a;
        switch (nxVar) {
            case EF5:
                str = null;
                break;
            case EF13:
                str = "music";
                break;
            case EF21:
                str = "podcasts";
                break;
            case EF29:
                str = "ringtones";
                break;
            case EF37:
                str = "alarms";
                break;
            case EF45:
                str = "notifications";
                break;
            case EF53:
                str = "pictures";
                break;
            case EF61:
                str = "movies";
                break;
            case EF70:
                str = "downloads";
                break;
            case EF79:
                str = "dcim";
                break;
            case EF88:
                str = "documents";
                break;
            default:
                throw new RuntimeException("Unrecognized directory: " + nxVar);
        }
        for (File file : context.getExternalFilesDirs(str)) {
            if (file != null) {
                arrayList.add(file.getAbsolutePath());
            }
        }
        return arrayList;
    }

    @Override // sensei0.xm
    public final void e(j1 j1Var) {
        b((a6) j1Var.b, null);
    }

    @Override // sensei0.xm
    public final void g(j1 j1Var) {
        a6 a6Var = (a6) j1Var.b;
        Context context = (Context) j1Var.a;
        try {
            b(a6Var, this);
        } catch (Exception e) {
            Log.e("PathProviderPlugin", "Received exception while setting up PathProviderPlugin", e);
        }
        this.a = context;
    }
}
