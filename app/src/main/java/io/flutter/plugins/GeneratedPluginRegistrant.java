package io.flutter.plugins;

import android.util.Log;
import sensei0.am;
import sensei0.em;
import sensei0.hk0;
import sensei0.qs;
import sensei0.sk;
import sensei0.t90;
import sensei0.vz;
import sensei0.yg0;

/* JADX INFO: compiled from: r8-map-id-00735fe6446b7f9f17dce574405a24dabe5e3f583c7585d5161835d7802417a9 */
/* JADX INFO: loaded from: classes.dex */
@qs
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(em emVar) {
        try {
            emVar.d.a(new sk());
        } catch (Exception e) {
            Log.e(TAG, "Error registering plugin file_picker, com.mr.flutter.plugin.filepicker.FilePickerPlugin", e);
        }
        try {
            emVar.d.a(new am());
        } catch (Exception e2) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e2);
        }
        try {
            emVar.d.a(new vz());
        } catch (Exception e3) {
            Log.e(TAG, "Error registering plugin path_provider_android, io.flutter.plugins.pathprovider.PathProviderPlugin", e3);
        }
        try {
            emVar.d.a(new t90());
        } catch (Exception e4) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e4);
        }
        try {
            emVar.d.a(new yg0());
        } catch (Exception e5) {
            Log.e(TAG, "Error registering plugin url_launcher_android, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e5);
        }
        try {
            emVar.d.a(new hk0());
        } catch (Exception e6) {
            Log.e(TAG, "Error registering plugin webview_flutter_android, io.flutter.plugins.webviewflutter.WebViewFlutterPlugin", e6);
        }
    }
}
