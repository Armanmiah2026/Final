package com.example.bongovpn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.provider.OpenableColumns;
import android.database.Cursor;
import android.net.VpnService;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.provider.MediaStore;
import android.net.Uri;
import android.os.PowerManager;
import android.provider.Settings;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.CheckBox;
import android.content.pm.ApplicationInfo;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.example.bongovpn.utils.PayloadGeneratorDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import ai.bongotech.bongovpn.BongoVpn;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_OVPN_FILE = 7001;
    private static final int REQUEST_V2RAY_FILE = 7002;
    private static final int REQUEST_VPN_PERMISSION = 7003;
    private static final int REQUEST_LOCK_FILE = 7100;
    private static final int REQUEST_UNLOCK_FILE = 7101;
    private static final int REQUEST_SERVICE_FILE = 7102;
    private static final int REQUEST_WALLPAPER = 7103;
    private static final int REQUEST_SAVE_LOCKED_PAYLOAD = 7104;
    private static final int REQUEST_IMPORT_LOCKED_PAYLOAD = 7105;
    private static final String KEY_DEVICE_TOKEN = "device_token";
    private static final String KEY_SELECTED_OVPN = "selected_ovpn";
    private static final String KEY_SELECTED_V2 = "selected_v2";
    private static final String PREFS = "vpn_profiles";
    private static final String KEY_OVPN_PROFILES = "ovpn_profiles";
    private static final String KEY_V2RAY_PROFILES = "v2ray_profiles";
    private static final String KEY_HISTORY = "connection_history";
    private static final String KEY_PAYLOADS = "standalone_payloads";
    private static final String KEY_ACTIVE_PAYLOAD = "active_payload_id";
    private static final String KEY_LOCK_META_PREFIX = "lockmeta_";
    private static final String KEY_CONFIG_PACKS = "service_config_packs";
    private static final String KEY_SERVER_FILTER_PAYLOAD = "server_filter_payload";
    private static final String KEY_WALLPAPER = "custom_wallpaper";
    private static final String KEY_PRIVATE_SERVERS = "private_servers";
    private static final String KEY_AUTO_RECONNECT = "auto_reconnect";
    private static final String KEY_AUTO_REFRESH_FREE = "auto_refresh_free";
    private static final String KEY_ALWAYS_ON = "always_on_vpn";
    private static final String KEY_KILL_SWITCH = "kill_switch";
    private static final String KEY_CONNECT_BOOT = "connect_on_boot";
    private static final String KEY_CUSTOM_DNS = "custom_dns";
    private static final String FREE_SERVER_SOURCE_URL = "https://www.vpngate.net/en/";
    private static final String FREE_SERVER_API_URL = "https://www.vpngate.net/api/iphone/";

    private MaterialButton btnConnect, btnImportConfig, btnManualConfig, btnPayload, btnClearConfig, btnMenu, btnAddConfig, btnReload, btnOpenVpn, btnV2Ray, btnSettings, btnSpeedTest, btnFavoritesHome, btnLogsHome, btnQuickConnectHome;
    private Spinner spinnerProtocol, spinnerProfile;
    private TextView tvDownloadSpeed, tvUploadSpeed, tvSessionUsage, tvProfileInfo, tvImportedFiles, tvDeviceContext, tvConnectionState, tvSelectedServerHome, tvServerCount, tvPayloadCount;
    private LinearLayout configList;

    private BongoVpn bongoVpn;
    private SharedPreferences prefs;
    private boolean isOpenVpnSelected = true;
    private boolean authTestMode = false;
    private String selectedProtocol = ProtocolRegistry.OPENVPN;
    private int selectedProfile = -1;
    private String pendingV2RayConfig = null;
    private boolean failoverActive = false;
    private int failoverNextIndex = -1;
    private boolean receiverRegistered = false;
    private JSONObject pendingLockedPayload = null;
    private final BroadcastReceiver xrayReceiver = new BroadcastReceiver() {
        @Override public void onReceive(Context context, Intent intent) {
            if (intent == null) return;
            String action = intent.getAction();
            if (V2RayService.ACTION_CONNECTED.equals(action)) {
                failoverActive = false;
                String name = intent.getStringExtra(V2RayService.EXTRA_SERVER_NAME);
                showConnectionSuccess("V2Ray/Xray", name == null ? "V2Ray server" : name);
                tvSessionUsage.setText("V2Ray/Xray connected • " + (name == null ? "server" : name));
                btnConnect.setEnabled(true);
                btnConnect.setText("Disconnect V2Ray");
            } else if (V2RayService.ACTION_ERROR.equals(action)) {
                String error = intent.getStringExtra(V2RayService.EXTRA_ERROR);
                tvSessionUsage.setText("Xray error: " + (error == null ? "unknown" : error));
                if (!tryNextFailover()) {
                    failoverActive = false;
                    btnConnect.setEnabled(true);
                    btnConnect.setText("Connect V2Ray / Xray");
                    Toast.makeText(MainActivity.this, "All available servers failed", Toast.LENGTH_LONG).show();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        applyCustomWallpaper();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        selectedProfile = prefs.getInt(KEY_SELECTED_OVPN, -1);
        if (android.os.Build.VERSION.SDK_INT >= 33 && checkSelfPermission("android.permission.POST_NOTIFICATIONS") != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 8100);
        }
        bongoVpn = new BongoVpn(this);

        btnConnect = findViewById(R.id.btnConnect);
        btnImportConfig = findViewById(R.id.btnImportConfig);
        btnManualConfig = findViewById(R.id.btnManualConfig);
        btnPayload = findViewById(R.id.btnPayload);
        btnClearConfig = findViewById(R.id.btnClearConfig);
        btnMenu = findViewById(R.id.btnMenu);
        btnAddConfig = findViewById(R.id.btnAddConfig);
        btnReload = findViewById(R.id.btnReload);
        btnOpenVpn = findViewById(R.id.btnOpenVpn);
        btnV2Ray = findViewById(R.id.btnV2Ray);
        btnSettings = findViewById(R.id.btnSettings);
        btnSpeedTest = findViewById(R.id.btnSpeedTest);
        btnFavoritesHome = findViewById(R.id.btnFavoritesHome);
        btnLogsHome = findViewById(R.id.btnLogsHome);
        btnQuickConnectHome = findViewById(R.id.btnQuickConnectHome);
        configList = findViewById(R.id.configList);
        spinnerProtocol = findViewById(R.id.spinnerProtocol);
        spinnerProfile = findViewById(R.id.spinnerProfile);
        tvDownloadSpeed = findViewById(R.id.tvDownloadSpeed);
        tvUploadSpeed = findViewById(R.id.tvUploadSpeed);
        tvSessionUsage = findViewById(R.id.tvSessionUsage);
        tvProfileInfo = findViewById(R.id.tvProfileInfo);
        tvImportedFiles = findViewById(R.id.tvImportedFiles);
        tvDeviceContext = findViewById(R.id.tvDeviceContext);
        tvConnectionState = findViewById(R.id.tvConnectionState);
        tvSelectedServerHome = findViewById(R.id.tvSelectedServerHome);
        tvServerCount = findViewById(R.id.tvServerCount);
        tvPayloadCount = findViewById(R.id.tvPayloadCount);
        updateDeviceContext();
        tvProfileInfo.setOnClickListener(v -> showServerListDialog());

        setupProtocolSpinner();
        setupProfileSpinner();
        setupOpenVpnListener();
        IntentFilter xf = new IntentFilter();
        xf.addAction(V2RayService.ACTION_CONNECTED);
        xf.addAction(V2RayService.ACTION_ERROR);
        if (android.os.Build.VERSION.SDK_INT >= 33) registerReceiver(xrayReceiver, xf, Context.RECEIVER_NOT_EXPORTED); else registerReceiver(xrayReceiver, xf);
        receiverRegistered = true;
        refreshProfileUi();
        showStartupFileToast();

        btnImportConfig.setOnClickListener(v -> {
            if (isOpenVpnSelected) importOpenVpnFile(); else importV2RayFile();
        });
        btnManualConfig.setOnClickListener(v -> showManualConfigDialog());
        btnPayload.setOnClickListener(v -> showPayloadDialog(-1));
        btnClearConfig.setOnClickListener(v -> clearSelectedProfile());
        btnConnect.setOnClickListener(v -> handleSelectedProtocolConnection());
        btnOpenVpn.setOnClickListener(v -> setProtocolMode(true));
        btnV2Ray.setOnClickListener(v -> setProtocolMode(false));
        btnAddConfig.setOnClickListener(v -> showAddConfigurationChooser());
        btnReload.setOnClickListener(v -> refreshProfileUi());
        btnMenu.setOnClickListener(v -> showMenuPopup());
        btnSettings.setOnClickListener(v -> showSettingsDialog());
        View homeServers = findViewById(R.id.btnServerListHome);
        if (homeServers != null) homeServers.setOnClickListener(v -> showServerListDialog());
        View homeFreeServers = findViewById(R.id.btnFreeServersHome);
        if (homeFreeServers != null) homeFreeServers.setOnClickListener(v -> showFreeServerListDialog());
        View homePayloads = findViewById(R.id.btnPayloadsHome);
        if (homePayloads != null) homePayloads.setOnClickListener(v -> showPayloadDialog(-1));
        View homeAddServer = findViewById(R.id.btnAddServerHome);
        if (homeAddServer != null) homeAddServer.setOnClickListener(v -> showAddConfigurationChooser());
        View homeSettings = findViewById(R.id.btnSettingsHome);
        if (homeSettings != null) homeSettings.setOnClickListener(v -> showSettingsDialog());
        View navServers = findViewById(R.id.btnServersNav);
        if (navServers != null) navServers.setOnClickListener(v -> showServerListDialog());
        View navPayload = findViewById(R.id.btnPayloadNav);
        if (navPayload != null) navPayload.setOnClickListener(v -> showPayloadDialog(-1));
        View navSettings = findViewById(R.id.btnSettingsNav);
        if (navSettings != null) navSettings.setOnClickListener(v -> showSettingsDialog());
        btnSpeedTest.setOnClickListener(v -> showSpeedTestDialog());
        if (btnFavoritesHome != null) btnFavoritesHome.setOnClickListener(v -> showFavoritesDialog());
        if (btnLogsHome != null) btnLogsHome.setOnClickListener(v -> showHistoryDialog());
        if (btnQuickConnectHome != null) btnQuickConnectHome.setOnClickListener(v -> quickConnectFastest());
        View homeNav = findViewById(R.id.btnHomeNav);
        if (homeNav != null) homeNav.setOnClickListener(v -> { View root=findViewById(R.id.main); if(root instanceof ViewGroup){ View child=((ViewGroup)root).getChildAt(0); if(child instanceof ScrollView) ((ScrollView)child).smoothScrollTo(0,0); } });
        View splash = findViewById(R.id.splashOverlay);
        if (splash != null) splash.postDelayed(() -> splash.animate().alpha(0f).setDuration(220).withEndAction(() -> splash.setVisibility(View.GONE)).start(), 950);
    }

    private void setupProtocolSpinner() {
        List<String> protocols = ProtocolRegistry.all();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, protocols);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProtocol.setAdapter(adapter);
        spinnerProtocol.setSelection(0, false);
        selectedProtocol = ProtocolRegistry.OPENVPN;
        spinnerProtocol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedProtocol = protocols.get(position);
                boolean newOpenVpn = ProtocolRegistry.OPENVPN.equals(selectedProtocol);
                boolean newV2 = ProtocolRegistry.V2RAY.equals(selectedProtocol);
                if (newOpenVpn != isOpenVpnSelected) {
                    isOpenVpnSelected = newOpenVpn;
                    selectedProfile = prefs.getInt(newOpenVpn ? KEY_SELECTED_OVPN : KEY_SELECTED_V2, -1);
                    refreshProfileUi();
                } else {
                    updateProtocolToggleUi();
                }
                updateConnectLabel();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) { }
        });
    }

    private void updateConnectLabel() {
        if (btnConnect == null) return;
        if (ProtocolRegistry.OPENVPN.equals(selectedProtocol)) btnConnect.setText("Connect OpenVPN");
        else if (ProtocolRegistry.V2RAY.equals(selectedProtocol)) btnConnect.setText("Connect V2Ray / Xray");
        else btnConnect.setText("Connect " + selectedProtocol);
    }

    private void handleSelectedProtocolConnection() {
        if (ProtocolRegistry.OPENVPN.equals(selectedProtocol)) {
            handleOpenVpnConnection();
            return;
        }
        if (ProtocolRegistry.V2RAY.equals(selectedProtocol)) {
            handleV2RayConnection();
            return;
        }
        Toast.makeText(this,
                selectedProtocol + " is registered in the multi-protocol profile system, but vpn.zip does not contain a native " + selectedProtocol + " engine yet.",
                Toast.LENGTH_LONG).show();
    }

    private void setProtocolMode(boolean openVpn) {
        isOpenVpnSelected = openVpn;
        selectedProfile = prefs.getInt(openVpn?KEY_SELECTED_OVPN:KEY_SELECTED_V2, -1);
        if (spinnerProtocol != null) spinnerProtocol.setSelection(openVpn ? 0 : 1, false);
        refreshProfileUi();
    }

    private void updateProtocolToggleUi() {
        if (btnOpenVpn == null || btnV2Ray == null) return;
        if (isOpenVpnSelected) {
            btnOpenVpn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(0,169,92)));
            btnOpenVpn.setTextColor(Color.WHITE);
            btnV2Ray.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(7,31,43)));
            btnV2Ray.setTextColor(Color.rgb(150,176,187));
        } else {
            btnV2Ray.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(0,169,92)));
            btnV2Ray.setTextColor(Color.WHITE);
            btnOpenVpn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(7,31,43)));
            btnOpenVpn.setTextColor(Color.rgb(150,176,187));
        }
    }

    private void showAddConfigurationChooser() {
        showAddServerDialog();
    }

    private MaterialButton actionButton(String text, boolean primary) {
        MaterialButton b = new MaterialButton(this);
        b.setText(text); b.setTextSize(14); b.setAllCaps(false); b.setMinHeight(dp(54));
        b.setTextColor(primary ? Color.WHITE : Color.rgb(214,239,247));
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(primary ? Color.rgb(9,132,199) : Color.rgb(7,31,43)));
        b.setStrokeColor(android.content.res.ColorStateList.valueOf(primary ? Color.rgb(20,191,255) : Color.rgb(19,61,76)));
        b.setStrokeWidth(dp(1)); b.setCornerRadius(dp(16));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, dp(54));
        lp.bottomMargin = dp(8); b.setLayoutParams(lp); return b;
    }

    private void importFromClipboard() {
        try {
            android.content.ClipboardManager cm = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            if (cm == null || !cm.hasPrimaryClip()) throw new IllegalArgumentException("Clipboard is empty");
            CharSequence text = cm.getPrimaryClip().getItemAt(0).coerceToText(this);
            String config = text == null ? "" : text.toString().trim();
            if (config.isEmpty()) throw new IllegalArgumentException("Clipboard is empty");
            if (isOpenVpnSelected) showSaveOvpnProfileDialog("clipboard.ovpn", config);
            else showSaveV2RayProfileDialog("clipboard-v2ray.txt", config);
        } catch (Exception e) { Toast.makeText(this, "Clipboard: " + safeMessage(e), Toast.LENGTH_LONG).show(); }
    }

    private void showMenuPopup() {
        LinearLayout content = verticalBox();
        content.setPadding(dp(22), dp(18), dp(22), dp(18));
        TextView brand = new TextView(this);
        brand.setText("🛡  Sensei Tunnel"); brand.setTextSize(22);
        brand.setTypeface(android.graphics.Typeface.DEFAULT, android.graphics.Typeface.BOLD);
        brand.setTextColor(Color.rgb(225,244,250)); content.addView(brand);
        TextView sub = new TextView(this);
        sub.setText("All app services"); sub.setTextSize(13); sub.setTextColor(Color.rgb(145,173,184));
        content.addView(sub);
        String[] items = {
                "⚙  Settings", "◔  Speed Test", "◉  Diagnostics", "◷  Connection History",
                "●  Account", "▣  APN Settings", "↕  4G/5G Switcher", "▣  Battery Optimization",
                "↻  Reload Configs", "▤  Server List", "🌐  Free Server List", "🖥  Private VPN Server", "▱  Payload List", "🖥  Private Server Installer", "🔐  File Locker",
                "▣  Device Token", "⚡  Quick Connect", "↻  Auto Reconnect", "?  Help Center", "ⓘ  About"
        };
        for (String item : items) {
            MaterialButton b = actionButton(item, false); b.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START); content.addView(b);
            if (item.contains("APN")) b.setOnClickListener(v -> openSystemSettings(Settings.ACTION_APN_SETTINGS, "APN settings are controlled by Android."));
            else if (item.contains("Settings")) b.setOnClickListener(v -> showSettingsDialog());
            else if (item.contains("Speed Test")) b.setOnClickListener(v -> showSpeedTestDialog());
            else if (item.contains("Diagnostics")) b.setOnClickListener(v -> showDiagnosticsDialog());
            else if (item.contains("Connection History")) b.setOnClickListener(v -> showHistoryDialog());
            else if (item.contains("Account")) b.setOnClickListener(v -> showAccountDialog());
            else if (item.contains("4G/5G")) b.setOnClickListener(v -> openSystemSettings(Settings.ACTION_NETWORK_OPERATOR_SETTINGS, "Open Android mobile-network settings and choose the preferred network type."));
            else if (item.contains("Battery")) b.setOnClickListener(v -> openBatteryOptimization());
            else if (item.contains("Reload")) b.setOnClickListener(v -> { refreshProfileUi(); Toast.makeText(this,"Configs reloaded",Toast.LENGTH_SHORT).show(); });
            else if (item.equals("▤  Server List")) b.setOnClickListener(v -> showServerListDialog());
            else if (item.contains("Free Server List")) b.setOnClickListener(v -> showFreeServerListDialog());
            else if (item.contains("Private VPN Server")) b.setOnClickListener(v -> showPrivateVpnServerDialog());
            else if (item.contains("Payload List")) b.setOnClickListener(v -> showPayloadDialog(-1));
            else if (item.contains("Private Server Installer")) b.setOnClickListener(v -> showPrivateServerList());
            else if (item.contains("File Locker")) b.setOnClickListener(v -> showFileLockerDialog());
            else if (item.contains("Device Token")) b.setOnClickListener(v -> showDeviceTokenDialog());
            else if (item.contains("Quick Connect")) b.setOnClickListener(v -> showQuickConnectDialog());
            else if (item.contains("Auto Reconnect")) b.setOnClickListener(v -> showAutoReconnectDialog());
            else if (item.contains("Help")) b.setOnClickListener(v -> showInfoDialog("Help Center", "1. Add/import a server.\n2. Open Payload List and create a payload.\n3. Tap Server List inside the payload and select the server.\n4. Use & Connect applies that payload only to the selected server.\n5. Connect normally to use the payload assigned to that server.\n\nOpenVPN auth-user-pass credentials are stored per server. V2Ray/Xray accepts share links or Xray JSON."));
            else if (item.contains("About")) b.setOnClickListener(v -> showInfoDialog("About", "Sensei Tunnel • OpenVPN + V2Ray/Xray\nLocal multi-protocol VPN manager with server, payload, failover and file-locker tools."));
        }
        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true); scroll.addView(content);
        int maxHeight = (int)(getResources().getDisplayMetrics().heightPixels * 0.86f);
        android.app.Dialog d = new AlertDialog.Builder(this).setView(scroll).create();
        d.setOnShowListener(x -> { if (d.getWindow()!=null) d.getWindow().setLayout(-1, maxHeight); });
        d.show();
        if (d.getWindow()!=null) d.getWindow().setLayout(-1, maxHeight);
    }

    private void showFavoritesDialog() {
        LinearLayout body=verticalBox(); body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout tabs=new LinearLayout(this); tabs.setPadding(0,0,0,dp(8)); uiTabs(tabs,new String[]{"Favorites","Recent"},0,null); body.addView(tabs);
        EditText search=uiSearch("Search favorite servers…"); body.addView(search,new LinearLayout.LayoutParams(-1,dp(44)));
        JSONArray o=profiles(KEY_OVPN_PROFILES); LinearLayout list=new LinearLayout(this); list.setOrientation(LinearLayout.VERTICAL); body.addView(list);
        for(int i=0;i<o.length();i++){JSONObject p=o.optJSONObject(i);if(p==null||!p.optBoolean("favorite",false))continue;final int idx=i; String name=p.optString("name","Server");String country=p.optString("country",getCountryName());long ms=p.optLong("lastLatencyMs",-1);LinearLayout c=uiCard("★  "+name,(ms>0?"◉ "+ms+" ms  •  ":"")+country);c.setPadding(dp(12),dp(10),dp(12),dp(10));c.setOnClickListener(v->{isOpenVpnSelected=true;selectedProfile=idx;prefs.edit().putInt(KEY_SELECTED_OVPN,idx).apply();refreshProfileUi();showServerDetailsDialog(idx);});list.addView(c,new LinearLayout.LayoutParams(-1,dp(70)));((LinearLayout.LayoutParams)c.getLayoutParams()).bottomMargin=dp(7);}
        if(list.getChildCount()==0){TextView e=uiLabel("No favorite servers yet. Add ★ from Server List.",13,uiMuted());e.setPadding(0,dp(18),0,dp(18));list.addView(e);}
        showReferenceScreen("Favorite Servers",body);
    }
    private void quickConnectFastest(){
        JSONArray a=profiles(KEY_OVPN_PROFILES); int best=-1; long bestMs=Long.MAX_VALUE;
        for(int i=0;i<a.length();i++){JSONObject p=a.optJSONObject(i);if(p==null||!isProfileAllowed(p))continue;long ms=p.optLong("lastLatencyMs",-1);if(ms>0&&ms<bestMs){best=i;bestMs=ms;}}
        if(best<0){showServerListDialog();Toast.makeText(this,"Test server latency first; the fastest tested server will be selected automatically.",Toast.LENGTH_LONG).show();return;}
        isOpenVpnSelected=true;selectedProfile=best;prefs.edit().putInt(KEY_SELECTED_OVPN,best).apply();refreshProfileUi();handleOpenVpnConnection();
    }

    private void showQuickConnectDialog(){
        LinearLayout body=verticalBox();body.setPadding(dp(4),dp(4),dp(4),dp(18));
        TextView power=uiLabel("◉",52,Color.rgb(31,221,170));power.setGravity(Gravity.CENTER);body.addView(power,new LinearLayout.LayoutParams(-1,dp(72)));
        TextView t=uiLabel("Tap to connect",14,uiText());t.setGravity(Gravity.CENTER);body.addView(t);
        JSONArray a=profiles(KEY_OVPN_PROFILES);int best=-1;long bestMs=Long.MAX_VALUE;for(int i=0;i<a.length();i++){JSONObject p=a.optJSONObject(i);if(p==null)continue;long ms=p.optLong("lastLatencyMs",-1);if(ms>0&&ms<bestMs){best=i;bestMs=ms;}}
        String name=best>=0?a.optJSONObject(best).optString("name","Fastest Server"):"Fastest Server";LinearLayout card=uiCard("🇯🇵  "+name,bestMs<Long.MAX_VALUE?bestMs+" ms":"Latency not tested");body.addView(card);
        MaterialButton connect=uiButton("Connect",true);body.addView(connect);MaterialButton change=uiButton("Change Server",false);body.addView(change);
        android.app.Dialog d=showReferenceScreen("Quick Connect",body);connect.setOnClickListener(v->{d.dismiss();quickConnectFastest();});change.setOnClickListener(v->{d.dismiss();showServerListDialog();});
    }

    private void showAutoReconnectDialog(){
        LinearLayout body=verticalBox();body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout hero=uiCard("◉  Auto Reconnect Enabled","Your VPN will automatically reconnect if the connection drops.");body.addView(hero);
        EditText retries=uiSearch("Max Retry Count   5 times");body.addView(retries,new LinearLayout.LayoutParams(-1,dp(48)));
        EditText interval=uiSearch("Retry Interval   10 seconds");body.addView(interval,new LinearLayout.LayoutParams(-1,dp(48)));
        Switch enabled=new Switch(this);enabled.setText("Enable Auto Reconnect");enabled.setTextColor(uiText());enabled.setChecked(prefs.getBoolean(KEY_AUTO_RECONNECT,true));body.addView(uiSettingCard(enabled));
        MaterialButton save=uiButton("Save",true);body.addView(save);android.app.Dialog d=showReferenceScreen("Auto Reconnect",body);save.setOnClickListener(v->{prefs.edit().putBoolean(KEY_AUTO_RECONNECT,enabled.isChecked()).apply();d.dismiss();Toast.makeText(this,"Auto reconnect saved",Toast.LENGTH_SHORT).show();});
    }

    private void showDiagnosticsDialog() {
        StringBuilder s = new StringBuilder();
        s.append("Current protocol: ").append(isOpenVpnSelected ? "OpenVPN" : "V2Ray/Xray").append('\n');
        s.append("OpenVPN connected: ").append(bongoVpn != null && bongoVpn.isConnected()).append('\n');
        s.append("Xray running: ").append(prefs.getBoolean("xray_running", false)).append('\n');
        s.append("OVPN profiles: ").append(profiles(KEY_OVPN_PROFILES).length()).append('\n');
        s.append("V2Ray profiles: ").append(profiles(KEY_V2RAY_PROFILES).length()).append('\n');
        s.append("Country: ").append(getCountryName()).append("\n");
        s.append("Network: ").append(getNetworkDescription()).append("\n");
        s.append("Status: ").append(tvSessionUsage.getText());
        showInfoDialog("Diagnostics", s.toString());
    }

    private void showHistoryDialog() {
        LinearLayout body=verticalBox(); body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout tabs=new LinearLayout(this); uiTabs(tabs,new String[]{"Logs","Statistics"},0,null); body.addView(tabs);
        String history=prefs.getString(KEY_HISTORY,"").trim(); if(history.isEmpty())history="No connection history yet.";
        for(String line:history.split("\\n")){String icon=line.toLowerCase().contains("disconnect")?"●  ":(line.toLowerCase().contains("error")?"●  ":"●  ");LinearLayout c=uiCard(icon+line,"Connection event");body.addView(c,new LinearLayout.LayoutParams(-1,dp(68)));((LinearLayout.LayoutParams)c.getLayoutParams()).bottomMargin=dp(7);}
        MaterialButton clear=uiButton("Clear Connection Logs",false); body.addView(clear); clear.setOnClickListener(v->{prefs.edit().remove(KEY_HISTORY).apply();Toast.makeText(this,"Connection logs cleared",Toast.LENGTH_SHORT).show();});
        showReferenceScreen("Connection Logs",body);
    }
    private void showAccountDialog() {
        showInfoDialog("Account", "Local account mode\n\nDevice Token: " + deviceToken() + "\nOpenVPN servers: " + profiles(KEY_OVPN_PROFILES).length() + "\nV2Ray/Xray servers: " + profiles(KEY_V2RAY_PROFILES).length() + "\nPayloads: " + payloads().length() + "\n\nNo online account is required.");
    }

    private void openSystemSettings(String action, String fallback) {
        try { startActivity(new Intent(action)); }
        catch (Exception e) { showInfoDialog("System Settings", fallback); }
    }

    private void openBatteryOptimization() {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                PowerManager pm = (PowerManager) getSystemService(POWER_SERVICE);
                if (pm != null && !pm.isIgnoringBatteryOptimizations(getPackageName())) {
                    Intent i = new Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                    i.setData(Uri.parse("package:" + getPackageName()));
                    startActivity(i);
                    return;
                }
            }
            showInfoDialog("Battery Optimization", "Battery optimization is already disabled for this app, or Android does not expose this option on this device.");
        } catch (Exception e) { showInfoDialog("Battery Optimization", "Open Android Settings → Battery → Battery optimization and allow Sensei Tunnel to run without optimization."); }
    }

    private void showSpeedTestDialog() {
        LinearLayout body=verticalBox(); body.setPadding(dp(4),dp(4),dp(4),dp(18));
        JSONObject selected=getSelectedProfile(KEY_OVPN_PROFILES); String name=selected==null?"Japan • Tokyo":selected.optString("name","Server"); long latency=selected==null?-1:selected.optLong("lastLatencyMs",-1);
        LinearLayout card=uiCard("◉  "+name,(latency>0?"◉ "+latency+" ms":"Ping not tested"));
        LinearLayout metrics=new LinearLayout(this); metrics.setPadding(0,dp(12),0,0);
        TextView down=uiLabel("Download\n— Mbps",14,uiText()); TextView up=uiLabel("Upload\n— Mbps",14,uiText()); TextView ping=uiLabel("Ping\n"+(latency>0?latency+" ms":"—"),14,uiText());
        metrics.addView(down,new LinearLayout.LayoutParams(0,dp(56),1));metrics.addView(up,new LinearLayout.LayoutParams(0,dp(56),1));metrics.addView(ping,new LinearLayout.LayoutParams(0,dp(56),1));card.addView(metrics);body.addView(card);
        TextView note=uiLabel("Speed test uses the current network path. Results depend on carrier, Wi‑Fi and server load.",11,uiMuted());note.setPadding(0,dp(10),0,dp(10));body.addView(note);
        MaterialButton test=uiButton("Test Again",true);body.addView(test);
        showReferenceScreen("Speed Test & Ping",body);
        test.setOnClickListener(v->{test.setEnabled(false);test.setText("Testing…");new Thread(()->{String r="Failed";try{long start=System.nanoTime();HttpURLConnection c=(HttpURLConnection)new URL("https://speed.cloudflare.com/__down?bytes=800000").openConnection();c.setConnectTimeout(7000);c.setReadTimeout(10000);long bytes=0;byte[] buf=new byte[8192];int n;try(InputStream in=c.getInputStream()){while((n=in.read(buf))!=-1)bytes+=n;}double sec=Math.max(.001,(System.nanoTime()-start)/1e9);r=String.format(java.util.Locale.US,"%.2f Mbps",(bytes*8/sec)/1_000_000.0);c.disconnect();}catch(Exception e){r=safeMessage(e);}final String rr=r;runOnUiThread(()->{down.setText("Download\n"+rr);test.setEnabled(true);test.setText("Test Again");});},"speed-v5").start();});
    }
    private void addHistory(String event) {
        String old = prefs.getString(KEY_HISTORY, "");
        String line = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()) + " — " + event;
        String all = line + (old.isEmpty() ? "" : "\n" + old);
        String[] lines = all.split("\n");
        StringBuilder limited = new StringBuilder();
        for (int i = 0; i < Math.min(lines.length, 30); i++) { if (i > 0) limited.append('\n'); limited.append(lines[i]); }
        prefs.edit().putString(KEY_HISTORY, limited.toString()).apply();
    }

    private void showSettingsDialog() {
        LinearLayout body=verticalBox(); body.setPadding(dp(4),dp(4),dp(4),dp(18));
        TextView s1=uiLabel("CONNECTION",10,uiMuted());s1.setTypeface(null,android.graphics.Typeface.BOLD);body.addView(s1);
        Switch autoReconnect=new Switch(this);autoReconnect.setText("Auto Reconnect");autoReconnect.setTextColor(uiText());autoReconnect.setChecked(prefs.getBoolean(KEY_AUTO_RECONNECT,true));body.addView(uiSettingCard(autoReconnect));
        Switch alwaysOn=new Switch(this);alwaysOn.setText("Always On VPN");alwaysOn.setTextColor(uiText());alwaysOn.setChecked(prefs.getBoolean(KEY_ALWAYS_ON,false));body.addView(uiSettingCard(alwaysOn));
        Switch kill=new Switch(this);kill.setText("Kill Switch");kill.setTextColor(uiText());kill.setChecked(prefs.getBoolean(KEY_KILL_SWITCH,false));body.addView(uiSettingCard(kill));
        Switch boot=new Switch(this);boot.setText("Connect on Boot");boot.setTextColor(uiText());boot.setChecked(prefs.getBoolean(KEY_CONNECT_BOOT,false));body.addView(uiSettingCard(boot));
        TextView s2=uiLabel("NETWORK",10,uiMuted());s2.setTypeface(null,android.graphics.Typeface.BOLD);s2.setPadding(0,dp(14),0,dp(4));body.addView(s2);
        EditText dns=uiSearch("DNS Settings  (blank = system)");dns.setText(prefs.getString(KEY_CUSTOM_DNS,""));body.addView(dns,new LinearLayout.LayoutParams(-1,dp(48)));
        MaterialButton vpn=uiButton("◉  Always-on / VPN Settings",false);body.addView(vpn);vpn.setOnClickListener(v->openSystemSettings(Settings.ACTION_VPN_SETTINGS,"Open Android VPN settings."));
        MaterialButton protocol=uiButton("⇄  Connection Protocol   •   "+selectedProtocol,false);body.addView(protocol);protocol.setOnClickListener(v->showInfoDialog("Connection Protocol","Choose OpenVPN or V2Ray/Xray from the protocol selector in the app engine."));
        TextView s3=uiLabel("APP",10,uiMuted());s3.setTypeface(null,android.graphics.Typeface.BOLD);s3.setPadding(0,dp(14),0,dp(4));body.addView(s3);
        MaterialButton speed=uiButton("◔  Speed Test & Ping",false);body.addView(speed);speed.setOnClickListener(v->showSpeedTestDialog());
        MaterialButton logs=uiButton("◷  Connection Logs",false);body.addView(logs);logs.setOnClickListener(v->showHistoryDialog());
        MaterialButton save=uiButton("Save Settings",true);body.addView(save);
        android.app.Dialog d=showReferenceScreen("Settings",body);
        save.setOnClickListener(v->{prefs.edit().putBoolean(KEY_AUTO_RECONNECT,autoReconnect.isChecked()).putBoolean(KEY_ALWAYS_ON,alwaysOn.isChecked()).putBoolean(KEY_KILL_SWITCH,kill.isChecked()).putBoolean(KEY_CONNECT_BOOT,boot.isChecked()).putString(KEY_CUSTOM_DNS,dns.getText().toString().trim()).apply();Toast.makeText(this,"Settings saved",Toast.LENGTH_SHORT).show();d.dismiss();});
    }

    private LinearLayout uiSettingCard(Switch sw){LinearLayout c=uiCard(sw.getText().toString(),"");c.removeAllViews();c.setGravity(Gravity.CENTER_VERTICAL);c.addView(sw,new LinearLayout.LayoutParams(0,dp(58),1));return c;}
    private void applyCustomWallpaper(){
        try{String path=prefs.getString(KEY_WALLPAPER,"");FrameLayout root=findViewById(R.id.main);if(root==null)return;if(path.isEmpty()){root.setBackgroundColor(Color.rgb(3,19,30));return;}BitmapFactory.Options o=new BitmapFactory.Options();o.inSampleSize=2;android.graphics.Bitmap b=BitmapFactory.decodeFile(path,o);if(b!=null){BitmapDrawable d=new BitmapDrawable(getResources(),b);d.setAlpha(70);d.setGravity(Gravity.CENTER);root.setBackground(d);}}catch(Exception ignored){}
    }

    private void saveWallpaper(Uri uri){try{File f=new File(getFilesDir(),"wallpaper.bin");try(InputStream in=getContentResolver().openInputStream(uri);FileOutputStream out=new FileOutputStream(f)){byte[] b=new byte[8192];int n;while((n=in.read(b))!=-1)out.write(b,0,n);}prefs.edit().putString(KEY_WALLPAPER,f.getAbsolutePath()).apply();applyCustomWallpaper();Toast.makeText(this,"Wallpaper saved",Toast.LENGTH_SHORT).show();}catch(Exception e){Toast.makeText(this,"Wallpaper failed: "+safeMessage(e),Toast.LENGTH_LONG).show();}}

    private void showPrivateServerInstaller(){
        LinearLayout box=verticalBox();
        EditText host=edit("Server IP / hostname","");
        EditText user=edit("SSH username","root");
        EditText pass=edit("SSH password","");
        pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        EditText port=edit("SSH port","22"); port.setInputType(InputType.TYPE_CLASS_NUMBER);
        CheckBox openvpn=new CheckBox(this); openvpn.setText("Install OpenVPN packages"); openvpn.setChecked(true);
        CheckBox xray=new CheckBox(this); xray.setText("Install Xray packages"); xray.setChecked(true);
        EditText vpnPorts=edit("VPN ports to open (comma separated)","443,1194");
        box.addView(host);box.addView(user);box.addView(pass);box.addView(port);box.addView(openvpn);box.addView(xray);box.addView(vpnPorts);
        TextView note=new TextView(this); note.setText("Only the ports entered here are opened. SSH password is used for this session only and is not saved."); box.addView(note);
        AlertDialog d=new AlertDialog.Builder(this).setTitle("Private Server Installer").setView(box).setNegativeButton("Cancel",null).setPositiveButton("Install",null).create();
        d.setOnShowListener(x->{
            d.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v->{
                try {
                    int ssh=Integer.parseInt(port.getText().toString().trim());
                    List<Integer> ps=new ArrayList<>();
                    for(String z:vpnPorts.getText().toString().split(",")){try{int q=Integer.parseInt(z.trim());if(q>0&&q<=65535)ps.add(q);}catch(Exception ignored){}}
                    if(host.getText().toString().trim().isEmpty())throw new IllegalArgumentException("Server host is required");
                    new Thread(()->{
                        try {
                            String h=host.getText().toString().trim();
                            String u=user.getText().toString().trim();
                            boolean ov=openvpn.isChecked(), xr=xray.isChecked();
                            String r=ServerInstaller.install(h,ssh,u,pass.getText().toString(),ov,xr,ps);
                            JSONObject rec=new JSONObject(); rec.put("id",java.util.UUID.randomUUID().toString()); rec.put("host",h); rec.put("sshPort",ssh); rec.put("username",u); rec.put("openvpn",ov); rec.put("xray",xr);
                            JSONArray ports=new JSONArray(); for(Integer q:ps) ports.put(q); rec.put("vpnPorts",ports); rec.put("installedAt",System.currentTimeMillis());
                            JSONArray priv=privateServers(); priv.put(rec); savePrivateServers(priv);
                            runOnUiThread(()->Toast.makeText(this,r+"\nSaved to Private Server List",Toast.LENGTH_LONG).show());
                        } catch(Exception e) {
                            runOnUiThread(()->Toast.makeText(this,"Installer failed: "+safeMessage(e),Toast.LENGTH_LONG).show());
                        }
                    },"ssh-installer").start();
                    d.dismiss();
                } catch(Exception e) { Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show(); }
            });
        });
        d.show();
    }

    private JSONArray privateServers(){ try{return new JSONArray(prefs.getString(KEY_PRIVATE_SERVERS,"[]"));}catch(Exception e){return new JSONArray();} }
    private void savePrivateServers(JSONArray a){prefs.edit().putString(KEY_PRIVATE_SERVERS,a.toString()).apply();}


    /** Public/free OpenVPN source. The app never treats a TCP-open port as a successful VPN login. */
    private void showFreeServerListDialog() {
        LinearLayout body=verticalBox();body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout tabs=new LinearLayout(this);body.addView(tabs);
        EditText search=uiSearch("Search free servers…");body.addView(search,new LinearLayout.LayoutParams(-1,dp(44)));
        TextView status=uiLabel("Loading public servers…",11,uiMuted());status.setPadding(dp(4),dp(10),0,dp(6));body.addView(status);
        LinearLayout list=new LinearLayout(this);list.setOrientation(LinearLayout.VERTICAL);body.addView(list);
        MaterialButton refresh=uiButton("↻  Refresh Server List",true);body.addView(refresh);
        Switch auto=new Switch(this);auto.setText("Auto Refresh");auto.setTextColor(uiText());auto.setChecked(prefs.getBoolean(KEY_AUTO_REFRESH_FREE,true));body.addView(uiSettingCard(auto));
        MaterialButton url=uiButton("＋  Manual URL / Import .ovpn",false);body.addView(url);
        MaterialButton source=uiButton("◉  VPN Gate   •   Community   •   Manual URL",false);body.addView(source);
        View.OnClickListener liveTab=v->{list.removeAllViews();status.setText("Refreshing VPN Gate catalog…");loadVpnGateApiToView(status,list);};
        View.OnClickListener sourceTab=v->{list.removeAllViews();status.setText("Choose a public source or paste your own URL.");MaterialButton gate=uiButton("VPN Gate / Public OpenVPN",false);MaterialButton manual=uiButton("Manual URL",false);list.addView(gate);list.addView(manual);gate.setOnClickListener(liveTab);manual.setOnClickListener(x->showOvpnUrlImportDialog());};
        uiTabs(tabs,new String[]{"Live Servers","Multiple Sources"},0,new View.OnClickListener[]{liveTab,sourceTab});
        android.app.Dialog d=showReferenceScreen("Free Server",body);
        refresh.setOnClickListener(liveTab);url.setOnClickListener(v->showOvpnUrlImportDialog());source.setOnClickListener(sourceTab);
        if(auto.isChecked())refresh.performClick();
    }

    private void loadVpnGateApiToView(TextView status, LinearLayout list){
        new Thread(()->{try{HttpURLConnection c=(HttpURLConnection)new URL(FREE_SERVER_API_URL).openConnection();c.setConnectTimeout(9000);c.setReadTimeout(15000);c.setRequestProperty("User-Agent","SenseiTunnel/5.0");c.connect();if(c.getResponseCode()>=400)throw new java.io.IOException("HTTP "+c.getResponseCode());InputStream in=c.getInputStream();ByteArrayOutputStream out=new ByteArrayOutputStream();byte[] buf=new byte[8192];int n;while((n=in.read(buf))!=-1&&out.size()<8_000_000)out.write(buf,0,n);in.close();c.disconnect();List<JSONObject> rows=parseVpnGateCsv(out.toString("UTF-8"));int limit=Math.min(10,rows.size());for(int i=0;i<limit;i++){JSONObject q=rows.get(i);final JSONObject item=q;String country=q.optString("country","Unknown");String host=q.optString("host","server");int tcp=q.optInt("tcp",0);runOnUiThread(()->{LinearLayout card=uiCard("◉  "+country+"  •  "+host,"Public free server  •  TCP "+(tcp>0?tcp:"—")+"  •  OpenVPN");MaterialButton save=uiButton("Download Config",false);card.addView(save);save.setOnClickListener(v->showSaveFreeOvpnProfileDialog(item));card.setOnClickListener(v->showSaveFreeOvpnProfileDialog(item));list.addView(card,new LinearLayout.LayoutParams(-1,dp(92)));((LinearLayout.LayoutParams)card.getLayoutParams()).bottomMargin=dp(7);});}final int total=rows.size();runOnUiThread(()->status.setText("Live Servers  •  "+total+" public profiles available"));}catch(Exception e){runOnUiThread(()->status.setText("Could not load public catalog: "+safeMessage(e)));}},"free-v5").start();
    }

    private void loadFreeServerSource(String sourceUrl, TextView status, LinearLayout box, AlertDialog dialog) {
        status.setText("Loading server list…");
        new Thread(() -> {
            String html = ""; Exception failure = null;
            try {
                HttpURLConnection c = (HttpURLConnection) new URL(sourceUrl).openConnection();
                c.setConnectTimeout(8000); c.setReadTimeout(12000); c.setRequestProperty("User-Agent", "Mozilla/5.0 SenseiTunnel/1.0");
                c.setInstanceFollowRedirects(true); c.connect();
                if (c.getResponseCode() >= 400) throw new java.io.IOException("HTTP " + c.getResponseCode());
                InputStream in = c.getInputStream(); ByteArrayOutputStream out = new ByteArrayOutputStream(); byte[] buf = new byte[8192]; int n;
                while ((n = in.read(buf)) != -1 && out.size() < 2_000_000) out.write(buf,0,n);
                in.close(); html = out.toString("UTF-8"); c.disconnect();
            } catch (Exception e) { failure = e; }
            final String page = html; final Exception err = failure;
            runOnUiThread(() -> {
                if (err != null) { status.setText("Could not load source: " + safeMessage(err) + "\nYou can use Import OVPN from URL or VPN Gate."); return; }
                List<String> links = extractOvpnLinks(page, sourceUrl);
                status.setText(links.size() + " OpenVPN profile link(s) found. TCP reachability is not treated as VPN authentication.");
                for (String link : links) {
                    MaterialButton b = actionButton("OPENVPN • " + link, false); box.addView(b, box.indexOfChild(status));
                    b.setOnClickListener(v -> { dialog.dismiss(); downloadAndSaveOvpn(link); });
                }
                if (links.isEmpty()) {
                    MaterialButton manual = actionButton("▣  No .ovpn links found — import URL manually", false); box.addView(manual, box.indexOfChild(status));
                    manual.setOnClickListener(v -> { dialog.dismiss(); showOvpnUrlImportDialog(); });
                }
            });
        }, "free-server-fetch").start();
    }

    private void loadVpnGateApi(TextView status, LinearLayout box, AlertDialog dialog) {
        status.setText("Loading live VPN Gate servers…");
        new Thread(() -> {
            String csv = null; Exception failure = null;
            try {
                HttpURLConnection c = (HttpURLConnection) new URL(FREE_SERVER_API_URL).openConnection();
                c.setConnectTimeout(9000); c.setReadTimeout(15000);
                c.setRequestProperty("User-Agent", "Mozilla/5.0 SenseiTunnel/1.1");
                c.setInstanceFollowRedirects(true); c.connect();
                if (c.getResponseCode() >= 400) throw new java.io.IOException("HTTP " + c.getResponseCode());
                InputStream in = c.getInputStream(); ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[8192]; int n;
                while ((n = in.read(buf)) != -1 && out.size() < 8_000_000) out.write(buf, 0, n);
                in.close(); c.disconnect(); csv = out.toString("UTF-8");
            } catch (Exception e) { failure = e; }
            final String data = csv; final Exception err = failure;
            runOnUiThread(() -> {
                if (err != null) { status.setText("Live server list failed: " + safeMessage(err) + "\nUse the source-page loader or direct URL import."); return; }
                try {
                    List<JSONObject> servers = parseVpnGateCsv(data);
                    status.setText(servers.size() + " live public server config(s) available. Tap Download & Save to add one to Server List.");
                    int limit = Math.min(servers.size(), 30);
                    for (int i = 0; i < limit; i++) {
                        JSONObject q = servers.get(i);
                        String country = q.optString("country", "Unknown");
                        String host = q.optString("host", q.optString("ip", "server"));
                        int tcp = q.optInt("tcp", 0);
                        int udp = q.optInt("udp", 0);
                        MaterialButton b = actionButton("FREE • " + country + " • " + host + "\nTCP " + (tcp > 0 ? tcp : "-") + " • UDP " + (udp > 0 ? udp : "-"), false);
                        box.addView(b, Math.max(0, box.indexOfChild(status)));
                        b.setOnClickListener(v -> {
                            dialog.dismiss();
                            try {
                                String config = q.optString("config", "").trim();
                                if (config.isEmpty()) throw new IllegalArgumentException("Server did not provide an OpenVPN config");
                                showSaveFreeOvpnProfileDialog(q);
                            } catch (Exception e) { Toast.makeText(this, "Config error: " + safeMessage(e), Toast.LENGTH_LONG).show(); }
                        });
                    }
                    if (servers.size() > limit) {
                        TextView more = new TextView(this); more.setText("Showing first " + limit + " live profiles. Reload to refresh the catalog."); more.setPadding(0, dp(10), 0, dp(10)); box.addView(more, box.indexOfChild(status));
                    }
                } catch (Exception e) { status.setText("Could not parse live server list: " + safeMessage(e)); }
            });
        }, "vpngate-api-fetch").start();
    }

    private List<JSONObject> parseVpnGateCsv(String csv) throws Exception {
        List<JSONObject> out = new ArrayList<>();
        if (csv == null || csv.trim().isEmpty()) return out;
        String[] lines = csv.replace("\r", "").split("\n");
        String[] headers = null;
        for (String line : lines) {
            if (line.startsWith("#")) continue;
            List<String> row = parseCsvLine(line);
            if (headers == null && row.contains("CountryShort") && row.contains("OpenVPN_ConfigData_Base64")) { headers = row.toArray(new String[0]); continue; }
            if (headers == null || row.size() < headers.length) continue;
            try {
                JSONObject q = new JSONObject();
                for (int i = 0; i < headers.length && i < row.size(); i++) q.put(headers[i], row.get(i));
                String b64 = q.optString("OpenVPN_ConfigData_Base64", "").trim();
                String config = b64.isEmpty() ? "" : new String(Base64.decode(b64, Base64.DEFAULT), java.nio.charset.StandardCharsets.UTF_8);
                if (config.isEmpty() || !config.contains("client") || !config.contains("remote")) continue;
                q.put("config", config);
                q.put("country", q.optString("CountryLong", q.optString("CountryShort", "Unknown")));
                q.put("host", q.optString("IP", q.optString("HostName", "server")));
                q.put("tcp", parseInt(q.optString("OpenVPN_TCPPort", "0"), 0));
                q.put("udp", parseInt(q.optString("OpenVPN_UDPPort", "0"), 0));
                out.add(q);
            } catch (Exception ignored) {}
        }
        return out;
    }

    private void markLastSavedFreeServer(String host, String country) {
        try {
            JSONArray a=profiles(KEY_OVPN_PROFILES);
            if(a.length()==0)return;
            JSONObject p=a.getJSONObject(a.length()-1);
            p.put("source","VPN_GATE"); p.put("freeServer",true); p.put("host",host); p.put("country",country);
            p.put("favorite",p.optBoolean("favorite",false)); p.put("lastLatencyMs",p.optLong("lastLatencyMs",-1));
            saveProfiles(KEY_OVPN_PROFILES,a); selectedProfile=a.length()-1;
            prefs.edit().putInt(KEY_SELECTED_OVPN,selectedProfile).apply();
        } catch(Exception ignored){}
    }

    private long probeLatency(String host, int port, int timeoutMs) {
        long start=System.nanoTime();
        try { java.net.Socket socket=new java.net.Socket(); socket.connect(new java.net.InetSocketAddress(host,port),timeoutMs); socket.close(); return (System.nanoTime()-start)/1_000_000L; }
        catch(Exception e){ return -1L; }
    }

    private void loadFastestFreeServer(TextView status, LinearLayout box, AlertDialog dialog) {
        status.setText("Finding fastest public server…");
        new Thread(() -> {
            try {
                HttpURLConnection c=(HttpURLConnection)new URL(FREE_SERVER_API_URL).openConnection();
                c.setConnectTimeout(9000); c.setReadTimeout(15000); c.setRequestProperty("User-Agent","SenseiTunnel/1.0.2"); c.connect();
                if(c.getResponseCode()>=400) throw new java.io.IOException("HTTP "+c.getResponseCode());
                InputStream in=c.getInputStream(); ByteArrayOutputStream out=new ByteArrayOutputStream(); byte[] b=new byte[8192]; int n;
                while((n=in.read(b))!=-1 && out.size()<8_000_000) out.write(b,0,n); in.close(); c.disconnect();
                List<JSONObject> list=parseVpnGateCsv(out.toString("UTF-8"));
                final List<JSONObject> candidates=list.subList(0,Math.min(12,list.size()));
                for(JSONObject q:candidates){String h=q.optString("host",q.optString("ip",""));int port=q.optInt("tcp",0);long ms=port>0?probeLatency(h,port,2500):-1;q.put("latencyMs",ms);}
                candidates.sort((a,b1)->Long.compare(a.optLong("latencyMs",Long.MAX_VALUE)<0?Long.MAX_VALUE:a.optLong("latencyMs",Long.MAX_VALUE), b1.optLong("latencyMs",Long.MAX_VALUE)<0?Long.MAX_VALUE:b1.optLong("latencyMs",Long.MAX_VALUE)));
                JSONObject best=candidates.isEmpty()?null:candidates.get(0); if(best==null||best.optLong("latencyMs",-1)<0) throw new IllegalStateException("No reachable public server found");
                final JSONObject chosen=best;
                runOnUiThread(()->{ status.setText("Fastest reachable: "+chosen.optString("country","Unknown")+" • "+chosen.optString("host","server")+" • "+chosen.optLong("latencyMs")+" ms");
                    MaterialButton save=actionButton("⬇  Download & Save Fastest Server",true); box.addView(save,Math.max(0,box.indexOfChild(status))); save.setOnClickListener(v->{dialog.dismiss();showSaveFreeOvpnProfileDialog(chosen);}); });
            } catch(Exception e){runOnUiThread(()->status.setText("Fastest-server test failed: "+safeMessage(e)));}
        },"fastest-free-server").start();
    }

    private List<String> parseCsvLine(String line) {
        List<String> row = new ArrayList<>(); StringBuilder cell = new StringBuilder(); boolean quoted = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '\"') {
                if (quoted && i + 1 < line.length() && line.charAt(i + 1) == '\"') { cell.append('\"'); i++; } else quoted = !quoted;
            } else if (ch == ',' && !quoted) { row.add(cell.toString()); cell.setLength(0); } else cell.append(ch);
        }
        row.add(cell.toString()); return row;
    }

    private void showSaveFreeOvpnProfileDialog(JSONObject server) {
        String country = server.optString("country", "Unknown");
        String host = server.optString("host", "free-server");
        String config = server.optString("config", "");
        LinearLayout box = verticalBox();
        EditText name = edit("Server name", "VPN Gate • " + host);
        EditText user = edit("Username", "vpn");
        EditText pass = edit("Password", "vpn");
        EditText countryInput = edit("Server country", country);
        box.addView(name); box.addView(user); box.addView(pass); box.addView(countryInput);
        TextView note = new TextView(this); note.setText("This public profile will be saved into Server List. You can then select it and press Connect OpenVPN."); note.setTextSize(12); note.setTextColor(Color.rgb(175,194,203)); box.addView(note);
        new AlertDialog.Builder(this).setTitle("Download & Save Free Server").setView(box).setNegativeButton("Cancel", null).setPositiveButton("Save & Use", (d, w) -> {
            try {
                addProfile(KEY_OVPN_PROFILES, name.getText().toString().trim(), config, user.getText().toString().trim(), pass.getText().toString(), null, countryInput.getText().toString().trim());
                isOpenVpnSelected = true;
                prefs.edit().putInt(KEY_SELECTED_OVPN, selectedProfile).remove(KEY_ACTIVE_PAYLOAD).apply();
                refreshProfileUi();
                Toast.makeText(this, "Free server saved and selected. Tap Connect OpenVPN to use it.", Toast.LENGTH_LONG).show();
            } catch (Exception e) { Toast.makeText(this, "Save failed: " + safeMessage(e), Toast.LENGTH_LONG).show(); }
        }).show();
    }

    private List<String> extractOvpnLinks(String html, String baseUrl) {
        java.util.LinkedHashSet<String> set = new java.util.LinkedHashSet<>();
        java.util.regex.Matcher m = java.util.regex.Pattern.compile("(?i)href\\s*=\\s*[\\\"']([^\\\"']+\\.ovpn(?:\\?[^\\\"']*)?)[\\\"']").matcher(html);
        while (m.find()) { String u = m.group(1); try { set.add(new URL(new URL(baseUrl), u).toString()); } catch(Exception ignored) {} }
        // Some providers expose the config as a direct .ovpn URL in plain text.
        java.util.regex.Matcher t = java.util.regex.Pattern.compile("(?i)(https?://[^\\s\\\"'<>]+\\.ovpn(?:\\?[^\\s\\\"'<>]*)?)").matcher(html);
        while (t.find()) set.add(t.group(1));
        return new ArrayList<>(set);
    }

    private void downloadAndSaveOvpn(String url) {
        LinearLayout body=verticalBox();body.setPadding(dp(18),dp(18),dp(18),dp(18));TextView title=uiLabel("Downloading config…",16,uiText());title.setTypeface(null,android.graphics.Typeface.BOLD);body.addView(title);android.widget.ProgressBar progress=new android.widget.ProgressBar(this,null,android.R.attr.progressBarStyleHorizontal);progress.setIndeterminate(true);body.addView(progress,new LinearLayout.LayoutParams(-1,dp(12)));TextView status=uiLabel("Connecting to source…",12,uiMuted());status.setPadding(0,dp(10),0,0);body.addView(status);android.app.Dialog d=showReferenceScreen("Free Server Download",body);
        new Thread(() -> {String config=null;Exception failure=null;try{HttpURLConnection c=(HttpURLConnection)new URL(url).openConnection();c.setConnectTimeout(8000);c.setReadTimeout(12000);c.setRequestProperty("User-Agent","Mozilla/5.0 SenseiTunnel/5.0");c.connect();if(c.getResponseCode()>=400)throw new java.io.IOException("HTTP "+c.getResponseCode());BufferedReader r=new BufferedReader(new InputStreamReader(c.getInputStream(),java.nio.charset.StandardCharsets.UTF_8));StringBuilder sb=new StringBuilder();String line;while((line=r.readLine())!=null)sb.append(line).append('\n');r.close();c.disconnect();config=sb.toString().trim();if(!config.contains("client")&&!config.contains("remote")&&!config.contains("dev"))throw new IllegalArgumentException("Downloaded file is not an OpenVPN profile");}catch(Exception e){failure=e;}final String cfg=config;final Exception err=failure;runOnUiThread(()->{if(err!=null){d.dismiss();Toast.makeText(this,"Download failed: "+safeMessage(err),Toast.LENGTH_LONG).show();return;}status.setText("Download complete • file ready to save");progress.setIndeterminate(false);progress.setMax(100);progress.setProgress(100);new Handler(getMainLooper()).postDelayed(()->{d.dismiss();showSaveOvpnProfileDialog(getFileNameFromUrl(url),cfg);},350);});},"ovpn-download").start();
    }

    private String getFileNameFromUrl(String url){ try{String p=new URL(url).getPath();String n=p.substring(p.lastIndexOf('/')+1);return n.isEmpty()?"free-server.ovpn":n;}catch(Exception e){return "free-server.ovpn";} }

    private void showOvpnUrlImportDialog() {
        LinearLayout box=verticalBox(); EditText url=edit("Direct .ovpn URL","https://example.com/server.ovpn"); box.addView(url);
        new AlertDialog.Builder(this).setTitle("Import OVPN from URL").setView(box).setNegativeButton("Cancel",null).setPositiveButton("Download",(d,w)->{String u=url.getText().toString().trim();if(!u.startsWith("http://")&&!u.startsWith("https://")){Toast.makeText(this,"Valid HTTP/HTTPS URL required",Toast.LENGTH_LONG).show();return;}downloadAndSaveOvpn(u);}).show();
    }

    /** Private server means a server/profile owned or authorized by the user; no third-party credentials are assumed. */
    private void showPrivateVpnServerDialog() {
        LinearLayout box=verticalBox();
        TextView note=new TextView(this); note.setText("Import your own .ovpn file, then enter the server username/password if required. The app does not create or guess private-server credentials."); note.setTextSize(13); note.setTextColor(Color.rgb(175,194,203)); box.addView(note);
        MaterialButton importBtn=actionButton("▣  Import my .ovpn file",true); box.addView(importBtn);
        MaterialButton pasteBtn=actionButton("✎  Paste my .ovpn config",false); box.addView(pasteBtn);
        MaterialButton urlBtn=actionButton("▣  Import my .ovpn URL",false); box.addView(urlBtn);
        AlertDialog d=new AlertDialog.Builder(this).setTitle("My Private VPN Server").setView(box).setPositiveButton("Close",null).create();
        importBtn.setOnClickListener(v->{d.dismiss();importOpenVpnFile();});
        pasteBtn.setOnClickListener(v->{d.dismiss();showManualConfigDialog();});
        urlBtn.setOnClickListener(v->{d.dismiss();showOvpnUrlImportDialog();});
        d.show();
    }

    private void showPrivateServerList(){
        JSONArray a=privateServers(); LinearLayout box=verticalBox();
        TextView note=new TextView(this); note.setText("Installed private servers. SSH passwords are never stored by the app."); note.setTextSize(13); note.setTextColor(Color.rgb(175,194,203)); box.addView(note);
        MaterialButton add=actionButton("＋ Install Private Server",true); box.addView(add);
        if(a.length()==0){TextView e=new TextView(this);e.setText("No private servers saved yet.");box.addView(e);}
        for(int i=0;i<a.length();i++){JSONObject q=a.optJSONObject(i);if(q==null)continue; final int idx=i;
            StringBuilder label=new StringBuilder("🖥  ").append(q.optString("host","Server"));
            label.append("\nSSH: ").append(q.optInt("sshPort",22)).append(" • VPN ports: ").append(q.optJSONArray("vpnPorts")==null?0:q.optJSONArray("vpnPorts").length());
            MaterialButton b=actionButton(label.toString(),false); box.addView(b);
            b.setOnClickListener(v->showPrivateServerActions(idx));
        }
        ScrollView sc=new ScrollView(this);sc.setFillViewport(true);sc.addView(box);AlertDialog d=new AlertDialog.Builder(this).setTitle("Private Server List").setView(sc).setPositiveButton("Close",null).create();
        add.setOnClickListener(v->{d.dismiss();showPrivateServerInstaller();}); d.show();
    }

    private void showPrivateServerActions(int index){
        JSONArray a=privateServers(); JSONObject q=a.optJSONObject(index); if(q==null)return;
        String[] actions={"Check Server Port","Create Server Access File","Delete","Close"};
        new AlertDialog.Builder(this).setTitle(q.optString("host","Private Server")).setItems(actions,(d,w)->{
            if(w==0){ final String host=q.optString("host",""); final int sshPort=q.optInt("sshPort",22); new Thread(()->{ boolean ok=false; try{ java.net.Socket s=new java.net.Socket(); s.connect(new java.net.InetSocketAddress(host,sshPort),2500); s.close(); ok=true; }catch(Exception ignored){} final boolean f=ok; final String status=(f?"ONLINE: ":"OFFLINE: ")+host; runOnUiThread(()->Toast.makeText(this,status,Toast.LENGTH_LONG).show()); },"private-probe").start();}
            else if(w==1)showCreatePrivateServerAccessFile(q);
            else if(w==2){a.remove(index);savePrivateServers(a);Toast.makeText(this,"Private server removed",Toast.LENGTH_SHORT).show();}
        }).show();
    }

    private void showCreatePrivateServerAccessFile(JSONObject server){
        LinearLayout box=verticalBox(); EditText name=edit("File name","server-"+System.currentTimeMillis()+".stserver"); EditText expiry=edit("Expire date (YYYY-MM-DD, blank = no expiry)",""); EditText max=edit("Maximum device count","1");max.setInputType(InputType.TYPE_CLASS_NUMBER);
        TextView t=new TextView(this);t.setText("Server: "+server.optString("host","")+"\nDevice Token: "+deviceToken());box.addView(name);box.addView(expiry);box.addView(max);box.addView(t);
        AlertDialog d=new AlertDialog.Builder(this).setTitle("Create Server Access File").setView(box).setNegativeButton("Cancel",null).setPositiveButton("Create",null).create();
        d.setOnShowListener(x->d.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v->{try{String ex=expiry.getText().toString().trim();validateDate(ex);String fn=name.getText().toString().trim();if(fn.isEmpty())fn="server.stserver";if(!fn.endsWith(".stserver"))fn+=".stserver";JSONObject pack=new JSONObject();pack.put("format","SenseiTunnelPrivateServerFile");pack.put("version",1);pack.put("deviceToken",deviceToken());pack.put("expiresAt",ex);pack.put("maxDevices",Math.max(1,parseInt(max.getText().toString(),1)));pack.put("privateServer",server);File dir=new File(getFilesDir(),"service_files");dir.mkdirs();File f=new File(dir,fn);byte[] iv=new byte[12];new java.security.SecureRandom().nextBytes(iv);javax.crypto.Cipher c=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");c.init(javax.crypto.Cipher.ENCRYPT_MODE,serviceKey(deviceToken()),new javax.crypto.spec.GCMParameterSpec(128,iv));byte[] enc=c.doFinal(pack.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8));try(FileOutputStream out=new FileOutputStream(f)){out.write(iv);out.write(enc);}Toast.makeText(this,"Saved: "+f.getAbsolutePath(),Toast.LENGTH_LONG).show();d.dismiss();}catch(Exception e){Toast.makeText(this,"Create failed: "+safeMessage(e),Toast.LENGTH_LONG).show();}}));d.show();
    }

    private LinearLayout fieldWrap(){
        LinearLayout w=new LinearLayout(this); w.setOrientation(LinearLayout.VERTICAL); w.setPadding(dp(12),0,dp(12),0);
        android.graphics.drawable.GradientDrawable bg=new android.graphics.drawable.GradientDrawable(); bg.setColor(Color.rgb(5,27,41)); bg.setCornerRadius(dp(12)); bg.setStroke(dp(1),uiStroke()); w.setBackground(bg);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,dp(50)); lp.bottomMargin=dp(8); w.setLayoutParams(lp); return w;
    }
    private EditText uiField(String hint,String value){
        EditText e=new EditText(this); e.setHint(hint); e.setText(value==null?"":value); e.setTextColor(uiText()); e.setHintTextColor(Color.rgb(102,132,145));
        e.setTextSize(13); e.setSingleLine(true); e.setPadding(dp(12),0,dp(12),0); e.setBackgroundColor(Color.TRANSPARENT);
        android.graphics.drawable.GradientDrawable bg=new android.graphics.drawable.GradientDrawable(); bg.setColor(Color.rgb(5,27,41)); bg.setCornerRadius(dp(12)); bg.setStroke(dp(1),uiStroke()); e.setBackground(bg);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,dp(50)); lp.bottomMargin=dp(8); e.setLayoutParams(lp); return e;
    }

    private int uiBlue() { return Color.rgb(12, 132, 220); }
    private int uiBg() { return Color.rgb(2, 15, 24); }
    private int uiCard() { return Color.rgb(6, 28, 42); }
    private int uiStroke() { return Color.rgb(18, 63, 83); }
    private int uiText() { return Color.rgb(226, 244, 250); }
    private int uiMuted() { return Color.rgb(126, 151, 163); }

    private TextView uiLabel(String text, float size, int color) {
        TextView t = new TextView(this); t.setText(text); t.setTextSize(size); t.setTextColor(color); return t;
    }

    private LinearLayout uiCard(String title, String subtitle) {
        LinearLayout card = new LinearLayout(this); card.setOrientation(LinearLayout.VERTICAL); card.setPadding(dp(14),dp(12),dp(14),dp(12));
        android.graphics.drawable.GradientDrawable bg = new android.graphics.drawable.GradientDrawable(); bg.setColor(uiCard()); bg.setCornerRadius(dp(13)); bg.setStroke(dp(1), uiStroke()); card.setBackground(bg);
        TextView a = uiLabel(title,14,uiText()); a.setTypeface(null,android.graphics.Typeface.BOLD); card.addView(a);
        if(subtitle!=null && !subtitle.isEmpty()){TextView b=uiLabel(subtitle,11,uiMuted()); b.setPadding(0,dp(3),0,0); card.addView(b);}
        return card;
    }

    private MaterialButton uiButton(String text, boolean primary) {
        MaterialButton b = new MaterialButton(this); b.setText(text); b.setAllCaps(false); b.setTextSize(12); b.setMinHeight(dp(48)); b.setTextColor(primary?Color.WHITE:uiText());
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(primary?uiBlue():Color.rgb(7,31,45))); b.setStrokeColor(android.content.res.ColorStateList.valueOf(primary?uiBlue():uiStroke())); b.setStrokeWidth(dp(1)); b.setCornerRadius(dp(13));
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,dp(48)); lp.bottomMargin=dp(8); b.setLayoutParams(lp); return b;
    }

    private EditText uiSearch(String hint) {
        EditText e=edit(hint,""); e.setSingleLine(true); e.setTextColor(uiText()); e.setHintTextColor(Color.rgb(92,119,132)); e.setPadding(dp(14),0,dp(14),0); return e;
    }

    private android.app.Dialog showReferenceScreen(String title, View body) {
        final android.app.Dialog d = new android.app.Dialog(this);
        LinearLayout root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setBackgroundColor(uiBg()); root.setPadding(dp(10),dp(8),dp(10),0);
        LinearLayout header=new LinearLayout(this); header.setGravity(Gravity.CENTER_VERTICAL); header.setPadding(dp(2),0,dp(2),dp(8));
        MaterialButton back=uiButton("‹",false); back.setLayoutParams(new LinearLayout.LayoutParams(dp(42),dp(42))); back.setTextSize(22); back.setPadding(0,0,0,0); header.addView(back);
        TextView h=uiLabel(title,17,uiText()); h.setTypeface(null,android.graphics.Typeface.BOLD); h.setGravity(Gravity.CENTER_VERTICAL); header.addView(h,new LinearLayout.LayoutParams(0,dp(42),1));
        root.addView(header); back.setOnClickListener(v->d.dismiss());
        ScrollView sc=new ScrollView(this); sc.setFillViewport(true); sc.setClipToPadding(false); sc.addView(body); root.addView(sc,new LinearLayout.LayoutParams(-1,0,1));
        LinearLayout nav=new LinearLayout(this); nav.setGravity(Gravity.CENTER); nav.setPadding(0,dp(4),0,dp(7));
        MaterialButton home=uiButton("⌂\nHome",false), servers=uiButton("≡\nServers",false), payload=uiButton("◈\nPayloads",false), settings=uiButton("⚙\nSettings",false);
        for(MaterialButton b:new MaterialButton[]{home,servers,payload,settings}){b.setTextSize(9);b.setMinHeight(dp(48));b.setPadding(0,0,0,0);nav.addView(b,new LinearLayout.LayoutParams(0,dp(48),1));}
        home.setOnClickListener(v->{d.dismiss();}); servers.setOnClickListener(v->{d.dismiss();showServerListDialog();}); payload.setOnClickListener(v->{d.dismiss();showPayloadDialog(-1);}); settings.setOnClickListener(v->{d.dismiss();showSettingsDialog();});
        root.addView(nav); d.setContentView(root);
        if(d.getWindow()!=null){d.getWindow().setBackgroundDrawableResource(android.R.color.transparent);d.getWindow().setStatusBarColor(uiBg());d.getWindow().setNavigationBarColor(uiBg());}
        d.setOnShowListener(x->{if(d.getWindow()!=null)d.getWindow().setLayout(-1,-1);}); d.show(); if(d.getWindow()!=null)d.getWindow().setLayout(-1,-1); return d;
    }

    private void uiTabs(LinearLayout row, String[] labels, int selected, View.OnClickListener[] listeners) {
        for(int i=0;i<labels.length;i++){final int ix=i;MaterialButton b=uiButton(labels[i],i==selected);b.setMinHeight(dp(40));b.setTextSize(10);b.setPadding(dp(4),0,dp(4),0);row.addView(b,new LinearLayout.LayoutParams(0,dp(40),1)); if(listeners!=null&&listeners.length>i&&listeners[i]!=null)b.setOnClickListener(listeners[i]);}
    }

    private void showInfoDialog(String title, String message) {
        new AlertDialog.Builder(this).setTitle(title).setMessage(message).setPositiveButton("OK", null).show();
    }

    private void setupProfileSpinner() {
        spinnerProfile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position <= 0) selectedProfile = -1; else { List<Integer> ids=visibleProfileIndices(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES); selectedProfile = (position-1 < ids.size()) ? ids.get(position-1) : -1; }
                prefs.edit().putInt(isOpenVpnSelected?KEY_SELECTED_OVPN:KEY_SELECTED_V2, selectedProfile).apply();
                updateProfileInfo();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) { selectedProfile = -1; }
        });
    }

    private void setupOpenVpnListener() {
        if (!bongoVpn.hasNotificationPermission()) bongoVpn.requestNotificationPermission();
        bongoVpn.setVpnListener(new BongoVpn.VpnListener() {
            @Override public void onVpnConnected() {
                if (isOpenVpnSelected) {
                    btnConnect.setEnabled(true); btnConnect.setText("Disconnect OpenVPN"); btnConnect.setTextColor(Color.RED);
                    tvSessionUsage.setText(authTestMode ? "AUTH OK • Payload OK • VPN connected" : "OpenVPN connected");
                    addHistory(authTestMode ? "OpenVPN auth/payload test OK" : "OpenVPN connected");
                    markSelectedServerStatus(authTestMode ? "AUTH_OK" : "CONNECTED");
                    failoverActive = false;
                    showConnectionSuccess("OpenVPN", selectedServerName());
                    if (authTestMode) {
                        Toast.makeText(MainActivity.this, "Server LIVE • Username/Password OK • Payload accepted", Toast.LENGTH_LONG).show();
                        new Handler(getMainLooper()).postDelayed(() -> { authTestMode = false; if (bongoVpn.isConnected()) bongoVpn.stopVpn(); }, 1200);
                    }
                }
            }
            @Override public void onVpnStopped() {
                if (isOpenVpnSelected) {
                    btnConnect.setEnabled(true); btnConnect.setText("Connect OpenVPN"); btnConnect.setTextColor(Color.BLACK);
                    tvSessionUsage.setText(authTestMode ? "Authentication test stopped" : "OpenVPN disconnected");
                    addHistory(authTestMode ? "OpenVPN auth test stopped" : "OpenVPN disconnected");
                    authTestMode = false;
                    if (!tryNextFailover()) failoverActive=false;
                }
            }
            @Override public void onStatusUpdate(String status) { if (isOpenVpnSelected) tvSessionUsage.setText(status); }
            @Override public void onError(String errorMessage) {
                if (isOpenVpnSelected) {
                    btnConnect.setEnabled(true); btnConnect.setText("Connect OpenVPN");
                    tvSessionUsage.setText(authTestMode ? "AUTH FAILED / CONNECTION FAILED" : (errorMessage == null ? "OpenVPN error" : errorMessage));
                    markSelectedServerStatus(authTestMode ? "AUTH_FAILED" : "ERROR");
                    if (authTestMode) Toast.makeText(MainActivity.this, "Server may be LIVE, but username/password or payload/connection failed", Toast.LENGTH_LONG).show();
                    authTestMode = false;
                    if (!tryNextFailover()) { failoverActive = false; btnConnect.setEnabled(true); }
                }
            }
            @Override public void onSpeedUpdate(long downloadBytes, long uploadBytes, long downloadSpeed, long uploadSpeed) {
                if (isOpenVpnSelected) {
                    tvDownloadSpeed.setText(bongoVpn.formatSpeed(downloadSpeed));
                    tvUploadSpeed.setText(bongoVpn.formatSpeed(uploadSpeed));
                    tvSessionUsage.setText("Down: " + BongoVpn.formatBytes(downloadBytes) + " | Up: " + BongoVpn.formatBytes(uploadBytes));
                }
            }
        });
    }

    private void handleOpenVpnConnection() {
        btnConnect.setEnabled(false);
        if (bongoVpn.isConnected()) {
            btnConnect.setText("Disconnecting..."); bongoVpn.stopVpn(); return;
        }

        try {
            JSONObject profile = getSelectedProfile(KEY_OVPN_PROFILES);
            String config = profile == null ? readAsset("japan.ovpn") : profile.optString("config", "");
            String username = profile == null ? "" : profile.optString("username", "");
            String password = profile == null ? "" : profile.optString("password", "");
            if (profile != null) { JSONObject payload = payloadForServer(KEY_OVPN_PROFILES, selectedProfile); if (payload == null) payload = profile.optJSONObject("payload"); config = applyOpenVpnProxy(config, payload); }

            if (config.trim().isEmpty()) throw new IllegalArgumentException("OVPN configuration is empty");
            boolean needsAuth = containsAuthUserPass(config);
            if (needsAuth && (username.trim().isEmpty() || password.isEmpty())) {
                btnConnect.setEnabled(true);
                showCredentialsDialog(profile, config);
                return;
            }

            if (profile == null) bongoVpn.attachFromAsset("japan.ovpn", username, password);
            else if (!attachFromStringCompat(config, username, password))
                throw new IllegalStateException("BongoVPN attachFromString API not available");

            btnConnect.setText("Connecting...");
            addHistory("OpenVPN connecting: " + (profile == null ? "assets/japan.ovpn" : profile.optString("name", "Unnamed")));
            if (bongoVpn.hasVpnPermission()) bongoVpn.startVpn();
            else { bongoVpn.requestVpnPermission(); btnConnect.setEnabled(true); btnConnect.setText("Connect OpenVPN"); }
        } catch (Exception e) {
            btnConnect.setEnabled(true); tvSessionUsage.setText("OpenVPN error: " + safeMessage(e));
            Toast.makeText(this, "OpenVPN: " + safeMessage(e), Toast.LENGTH_LONG).show();
        }
    }

    private boolean attachFromStringCompat(String config, String username, String password) throws Exception {
        for (Method method : bongoVpn.getClass().getMethods()) {
            if (!method.getName().equals("attachFromString") || !Modifier.isPublic(method.getModifiers())) continue;
            Class<?>[] p = method.getParameterTypes();
            if (p.length == 3 && p[0] == String.class && p[1] == String.class && p[2] == String.class) {
                method.invoke(bongoVpn, config, username, password); return true;
            }
            if (p.length == 1 && p[0] == String.class) { method.invoke(bongoVpn, config); return true; }
        }
        return false;
    }

    private void importOpenVpnFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE); intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"application/x-openvpn-profile", "text/plain", "application/octet-stream"});
        startActivityForResult(intent, REQUEST_OVPN_FILE);
    }

    private void importV2RayFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE); intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"application/json", "text/plain", "application/octet-stream"});
        startActivityForResult(intent, REQUEST_V2RAY_FILE);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_WALLPAPER) { if(resultCode==RESULT_OK && data!=null && data.getData()!=null) saveWallpaper(data.getData()); return; }
        if (requestCode == REQUEST_LOCK_FILE) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) lockSelectedUri(data.getData());
            return;
        }
        if (requestCode == REQUEST_SERVICE_FILE) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) importServiceFile(data.getData());
            return;
        }
        if (requestCode == REQUEST_SAVE_LOCKED_PAYLOAD) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null && pendingLockedPayload != null) saveLockedPayloadDocument(data.getData(), pendingLockedPayload);
            pendingLockedPayload = null;
            return;
        }
        if (requestCode == REQUEST_IMPORT_LOCKED_PAYLOAD) {
            if (resultCode == RESULT_OK && data != null && data.getData() != null) importLockedPayloadDocument(data.getData());
            return;
        }
        if (requestCode == REQUEST_VPN_PERMISSION) {
            if (resultCode == RESULT_OK && pendingV2RayConfig != null) startV2RayService(pendingV2RayConfig);
            else tvSessionUsage.setText("VPN permission denied");
            pendingV2RayConfig = null; return;
        }
        if ((requestCode != REQUEST_OVPN_FILE && requestCode != REQUEST_V2RAY_FILE) || resultCode != RESULT_OK || data == null || data.getData() == null) return;
        try {
            Uri uri = data.getData();
            String config = readTextFromUri(uri).trim();
            String name = getDisplayName(uri);
            if (config.isEmpty()) throw new IllegalArgumentException("File is empty");
            if (requestCode == REQUEST_OVPN_FILE) {
                showSaveOvpnProfileDialog(name, config);
            } else {
                showSaveV2RayProfileDialog(name, config);
            }
        } catch (Exception e) { Toast.makeText(this, "Could not read file: " + safeMessage(e), Toast.LENGTH_LONG).show(); }
    }

    private void showAddServerDialog() {
        final android.app.Dialog d = new android.app.Dialog(this);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(10), dp(8), dp(10), 0);
        root.setBackgroundColor(uiBg());

        LinearLayout header = new LinearLayout(this);
        header.setGravity(Gravity.CENTER_VERTICAL);
        MaterialButton back = uiButton("‹", false);
        back.setLayoutParams(new LinearLayout.LayoutParams(dp(42), dp(42)));
        back.setTextSize(22); back.setPadding(0,0,0,0);
        header.addView(back);
        TextView title = uiLabel("Add Server / Config", 17, uiText());
        title.setTypeface(null, android.graphics.Typeface.BOLD);
        header.addView(title, new LinearLayout.LayoutParams(0, dp(42), 1));
        root.addView(header);

        LinearLayout tabs = new LinearLayout(this);
        tabs.setPadding(0, dp(4), 0, dp(8));
        root.addView(tabs);
        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(dp(10), dp(4), dp(10), dp(14));
        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true); scroll.addView(content);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));

        Runnable showOvpn = () -> {
            content.removeAllViews();
            TextView hint = uiLabel("Import an .ovpn file and save it to Server List.", 12, uiMuted());
            content.addView(hint); hint.setPadding(0,0,0,dp(10));
            MaterialButton pick = uiButton("▣  Choose .ovpn File", true); content.addView(pick);
            EditText url = edit("Or paste .ovpn URL", ""); content.addView(url);
            EditText name = edit("Server name", "My OpenVPN Server"); content.addView(name);
            EditText country = edit("Country", getCountryName()); content.addView(country);
            EditText user = edit("Username (optional)", ""); content.addView(user);
            EditText pass = edit("Password (optional)", ""); pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); content.addView(pass);
            MaterialButton save = uiButton("Save Server", true); content.addView(save);
            pick.setOnClickListener(v -> { d.dismiss(); importOpenVpnFile(); });
            save.setOnClickListener(v -> {
                String u = url.getText().toString().trim();
                if (u.isEmpty()) { Toast.makeText(this, "Choose a file or enter an .ovpn URL", Toast.LENGTH_LONG).show(); return; }
                d.dismiss(); downloadAndSaveOvpn(u);
            });
        };
        Runnable showUrl = () -> {
            content.removeAllViews();
            TextView hint = uiLabel("Paste a direct .ovpn, V2Ray/Xray share link, or config URL.", 12, uiMuted());
            content.addView(hint); hint.setPadding(0,0,0,dp(10));
            EditText name = edit("Server name", "My Free Server"); content.addView(name);
            EditText country = edit("Country", getCountryName()); content.addView(country);
            EditText url = edit("Config URL", "https://example.com/server.ovpn"); url.setSingleLine(true); content.addView(url);
            Spinner type = new Spinner(this);
            ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"OpenVPN", "V2Ray / Xray"});
            type.setAdapter(a); content.addView(type, new LinearLayout.LayoutParams(-1, dp(52)));
            MaterialButton save = uiButton("Save Server", true); content.addView(save);
            save.setOnClickListener(v -> {
                String u=url.getText().toString().trim(); if(u.isEmpty()){Toast.makeText(this,"Config URL is required",Toast.LENGTH_LONG).show();return;}
                d.dismiss();
                if(type.getSelectedItemPosition()==0) downloadAndSaveOvpn(u); else downloadAndSaveV2Ray(u, name.getText().toString().trim(), country.getText().toString().trim());
            });
        };
        Runnable showManual = () -> {
            content.removeAllViews();
            TextView hint = uiLabel("Enter a complete OpenVPN or V2Ray/Xray configuration manually.", 12, uiMuted());
            content.addView(hint); hint.setPadding(0,0,0,dp(10));
            EditText name = edit("Server name", "My Manual Server"); content.addView(name);
            EditText country = edit("Country", getCountryName()); content.addView(country);
            Spinner type = new Spinner(this);
            ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"OpenVPN", "V2Ray / Xray"});
            type.setAdapter(a); content.addView(type, new LinearLayout.LayoutParams(-1, dp(52)));
            EditText cfg = edit("Paste configuration", ""); cfg.setGravity(Gravity.TOP|Gravity.START); cfg.setMinLines(10); cfg.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE); content.addView(cfg);
            EditText user = edit("Username (OpenVPN optional)", ""); content.addView(user);
            EditText pass = edit("Password (OpenVPN optional)", ""); pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD); content.addView(pass);
            MaterialButton save = uiButton("Save Server", true); content.addView(save);
            save.setOnClickListener(v -> {
                String c=cfg.getText().toString().trim(); if(c.isEmpty()){Toast.makeText(this,"Configuration is required",Toast.LENGTH_LONG).show();return;}
                try {
                    if(type.getSelectedItemPosition()==0) addProfile(KEY_OVPN_PROFILES,name.getText().toString().trim(),c,user.getText().toString(),pass.getText().toString(),null,country.getText().toString().trim());
                    else addProfile(KEY_V2RAY_PROFILES,name.getText().toString().trim(),c,"","",null,country.getText().toString().trim());
                    refreshProfileUi(); d.dismiss(); Toast.makeText(this,"Server saved to Server List",Toast.LENGTH_SHORT).show();
                } catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}
            });
        };
        uiTabs(tabs, new String[]{".ovpn File","URL","Manual"}, 0, new View.OnClickListener[]{v->showOvpn.run(), v->showUrl.run(), v->showManual.run()});
        showOvpn.run();
        back.setOnClickListener(v->d.dismiss());
        d.setContentView(root); d.setOnShowListener(x->{if(d.getWindow()!=null)d.getWindow().setLayout(-1,-1);});
        d.show(); if(d.getWindow()!=null){d.getWindow().setBackgroundDrawableResource(android.R.color.transparent);d.getWindow().setLayout(-1,-1);}
    }

    private void downloadAndSaveV2Ray(String url, String name, String country) {
        LinearLayout body=verticalBox(); TextView status=uiLabel("Downloading config…",16,uiText()); body.addView(status); android.widget.ProgressBar p=new android.widget.ProgressBar(this,null,android.R.attr.progressBarStyleHorizontal); p.setIndeterminate(true); body.addView(p,new LinearLayout.LayoutParams(-1,dp(12))); android.app.Dialog d=showReferenceScreen("Server Download",body);
        new Thread(()->{String cfg=null;Exception err=null;try{HttpURLConnection c=(HttpURLConnection)new URL(url).openConnection();c.setConnectTimeout(8000);c.setReadTimeout(12000);c.setRequestProperty("User-Agent","SenseiTunnel/5.0.2");c.connect();if(c.getResponseCode()>=400)throw new java.io.IOException("HTTP "+c.getResponseCode());BufferedReader r=new BufferedReader(new InputStreamReader(c.getInputStream(),java.nio.charset.StandardCharsets.UTF_8));StringBuilder sb=new StringBuilder();String line;while((line=r.readLine())!=null)sb.append(line).append('\n');r.close();c.disconnect();cfg=sb.toString().trim();if(cfg.isEmpty())throw new IllegalArgumentException("Empty configuration");}catch(Exception e){err=e;}final String f=cfg;final Exception e=err;runOnUiThread(()->{if(e!=null){d.dismiss();Toast.makeText(this,"Download failed: "+safeMessage(e),Toast.LENGTH_LONG).show();return;}d.dismiss();try{addProfile(KEY_V2RAY_PROFILES,name==null||name.isEmpty()?getFileNameFromUrl(url):name,f,"","",null,country);refreshProfileUi();Toast.makeText(this,"V2Ray/Xray server saved",Toast.LENGTH_SHORT).show();}catch(Exception ex){Toast.makeText(this,safeMessage(ex),Toast.LENGTH_LONG).show();}});},"v2ray-download").start();
    }

    private void showSaveOvpnProfileDialog(String fileName, String config) {
        LinearLayout box = verticalBox();
        EditText name = edit("Server name / file name", fileName);
        EditText user = edit("Username (only if auth-user-pass is required)", "");
        EditText pass = edit("Password", ""); pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        EditText country = edit("Server country", getCountryName());
        box.addView(name); box.addView(user); box.addView(pass); box.addView(country);
        boolean needsAuth = containsAuthUserPass(config);
        TextView note = new TextView(this); note.setText(needsAuth ? "This OVPN contains auth-user-pass. Enter credentials if the server requires them." : "No auth-user-pass directive detected. Credentials are optional."); note.setPadding(0, dp(8), 0, 0); box.addView(note);
        new AlertDialog.Builder(this).setTitle("Save OVPN server")
                .setView(box).setNegativeButton("Cancel", null)
                .setPositiveButton("Save", (d,w) -> {
                    try { addProfile(KEY_OVPN_PROFILES, name.getText().toString().trim(), config, user.getText().toString(), pass.getText().toString(), null, country.getText().toString().trim()); refreshProfileUi(); Toast.makeText(this, "OVPN server saved: " + name.getText(), Toast.LENGTH_SHORT).show(); }
                    catch (Exception e) { Toast.makeText(this, safeMessage(e), Toast.LENGTH_LONG).show(); }
                }).show();
    }

    private void showSaveV2RayProfileDialog(String fileName, String config) {
        LinearLayout box = verticalBox();
        EditText name = edit("Server name / file name", fileName); box.addView(name);
        EditText country = edit("Server country", getCountryName()); box.addView(country);
        new AlertDialog.Builder(this).setTitle("Save V2Ray/Xray server").setView(box).setNegativeButton("Cancel", null)
                .setPositiveButton("Save", (d,w) -> { try { addProfile(KEY_V2RAY_PROFILES, name.getText().toString().trim(), config, "", "", null, country.getText().toString().trim()); refreshProfileUi(); Toast.makeText(this, "V2Ray/Xray server saved: " + name.getText(), Toast.LENGTH_SHORT).show(); } catch (Exception e) { Toast.makeText(this, safeMessage(e), Toast.LENGTH_LONG).show(); } }).show();
    }

    private void showManualConfigDialog() {
        if (!isOpenVpnSelected) { showManualV2RayDialog(); return; }
        LinearLayout box = verticalBox();
        EditText name = edit("Server name", "Manual OVPN");
        EditText config = edit("Paste complete .ovpn configuration", ""); config.setGravity(Gravity.TOP | Gravity.START); config.setMinLines(10); config.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        EditText user = edit("Username (optional)", "");
        EditText pass = edit("Password (optional)", ""); pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        EditText country = edit("Server country", getCountryName());
        box.addView(name); box.addView(config); box.addView(user); box.addView(pass); box.addView(country);
        new AlertDialog.Builder(this).setTitle("Manual OpenVPN Server").setView(box).setNegativeButton("Cancel", null).setPositiveButton("Save", (d,w) -> {
            String c = config.getText().toString().trim(); if (c.isEmpty()) { Toast.makeText(this,"OVPN config is required",Toast.LENGTH_LONG).show(); return; }
            try { addProfile(KEY_OVPN_PROFILES, name.getText().toString().trim(), c, user.getText().toString(), pass.getText().toString(), null, country.getText().toString().trim()); refreshProfileUi(); } catch (Exception e) { Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show(); }
        }).show();
    }

    private void showManualV2RayDialog() {
        LinearLayout box = verticalBox(); EditText name = edit("Server name", "Manual V2Ray"); EditText country = edit("Server country", getCountryName()); EditText input = edit("Paste vless://, vmess://, trojan://, or Xray JSON", "");
        input.setGravity(Gravity.TOP | Gravity.START); input.setMinLines(10); input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE); box.addView(name); box.addView(country); box.addView(input);
        new AlertDialog.Builder(this).setTitle("Manual V2Ray / Xray").setView(box).setNegativeButton("Cancel", null).setPositiveButton("Save", (d,w) -> {
            String c=input.getText().toString().trim(); if(c.isEmpty()){Toast.makeText(this,"V2Ray config is required",Toast.LENGTH_LONG).show();return;} try{addProfile(KEY_V2RAY_PROFILES,name.getText().toString().trim(),c,"","",null,country.getText().toString().trim());refreshProfileUi();}catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}
        }).show();
    }

    private JSONArray payloads() { try { return new JSONArray(prefs.getString(KEY_PAYLOADS, "[]")); } catch(Exception e) { return new JSONArray(); } }
    private void savePayloads(JSONArray a) { prefs.edit().putString(KEY_PAYLOADS, a.toString()).apply(); }

    private void showPayloadEditor(final JSONObject[] holder) {
        JSONObject old = holder[0] == null ? new JSONObject() : holder[0];
        showStandalonePayloadEditor(-1, old, holder);
    }

    private void showStandalonePayloadEditor(int payloadIndex, JSONObject oldInput, final JSONObject[] externalHolder) {
        JSONObject old = oldInput == null ? new JSONObject() : oldInput;
        PayloadGeneratorDialog generator = new PayloadGeneratorDialog(this);
        generator.setDialogTitle(payloadIndex >= 0 ? "Edit Payload" : "Payload Generator");
        generator.setInitialPayload(old.optString("generatorInput", ""));
        generator.setGenerateListener("Next", generated -> showGeneratedPayloadSaveDialog(payloadIndex, old, externalHolder, generated));
        generator.setCancelListener("Cancel", () -> {});
        generator.show();
    }

    private void showGeneratedPayloadSaveDialog(int payloadIndex, JSONObject old, final JSONObject[] externalHolder, String generated) {
        LinearLayout box = verticalBox();
        EditText name = edit("Payload name", old.optString("name", "RK Payload"));
        EditText country = edit("Payload country", old.optString("country", getCountryName()));
        TextView selected = new TextView(this);
        selected.setText("Server: " + payloadServerLabel(old));
        selected.setTextSize(14); selected.setTextColor(Color.rgb(50,70,62)); selected.setPadding(0,dp(8),0,dp(8));
        MaterialButton choose = actionButton("▤  Select OpenVPN Server", false);
        choose.setOnClickListener(v -> chooseServerForPayload(old, selected, country));
        EditText preview = edit("Generated payload", generated);
        preview.setGravity(Gravity.TOP|Gravity.START); preview.setMinLines(9);
        preview.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        TextView note = new TextView(this);
        note.setText("Payload is generated with the RK generator. You can edit the generated text before saving.");
        note.setTextSize(12); note.setTextColor(Color.rgb(150,176,187));
        box.addView(name); box.addView(country); box.addView(selected); box.addView(choose); box.addView(preview); box.addView(note);
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle(payloadIndex>=0?"Edit Payload":"Save Payload")
                .setView(box).setNegativeButton("Cancel", null).setPositiveButton("Save", null).create();
        dialog.setOnShowListener(x -> dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v -> {
            try {
                String serverKey = old.optString("serverKey", "");
                int serverIndex = old.optInt("serverIndex", -1);
                JSONObject out = new JSONObject();
                out.put("id", old.optString("id", java.util.UUID.randomUUID().toString()));
                out.put("name", name.getText().toString().trim().isEmpty() ? "Payload" : name.getText().toString().trim());
                out.put("country", country.getText().toString().trim().isEmpty() ? getCountryName() : country.getText().toString().trim());
                out.put("type", "RK_GENERATED");
                out.put("template", preview.getText().toString());
                out.put("generatorInput", old.optString("generatorInput", ""));
                out.put("proxyHost", old.optString("proxyHost", ""));
                out.put("proxyPort", old.optString("proxyPort", ""));
                out.put("sni", old.optString("sni", ""));
                out.put("serverKey", serverKey); out.put("serverIndex", serverIndex);
                out.put("serverName", old.optString("serverName", serverIndex >= 0 ? "Server" : "Not selected"));
                out.put("mode", serverIndex >= 0 ? "OPENVPN" : "V2RAY");
                JSONArray all = payloads();
                if (payloadIndex >= 0 && payloadIndex < all.length()) all.put(payloadIndex, out); else all.put(out);
                savePayloads(all);
                if (externalHolder != null) externalHolder[0] = out;
                prefs.edit().putString(KEY_ACTIVE_PAYLOAD, out.optString("id")).apply();
                Toast.makeText(this, "Payload saved" + (serverIndex >= 0 ? " for " + out.optString("serverName") : ""), Toast.LENGTH_SHORT).show();
                dialog.dismiss(); refreshProfileUi();
            } catch (Exception e) { Toast.makeText(this, safeMessage(e), Toast.LENGTH_LONG).show(); }
        }));
        dialog.show();
    }

    private String payloadServerLabel(JSONObject p) {
        String n=p==null?"":p.optString("serverName",""); if(!n.isEmpty()) return n;
        int idx=p==null?-1:p.optInt("serverIndex",-1); String key=p==null?"":p.optString("serverKey","");
        if(idx>=0 && !key.isEmpty()) { JSONArray a=profiles(key); JSONObject s=a.optJSONObject(idx); if(s!=null) return s.optString("name","Server"); }
        return "Not selected";
    }

    private void chooseServerForPayload(final JSONObject payload, final TextView label, final EditText country) {
        LinearLayout box=verticalBox();
        JSONArray o=profiles(KEY_OVPN_PROFILES); int shown=0;
        TextView note=new TextView(this); note.setText("OpenVPN servers only. V2Ray/Xray uses the config selected from Configs and does not require a server assignment here."); note.setTextSize(13); note.setTextColor(Color.rgb(145,173,184)); note.setPadding(0,0,0,dp(10)); box.addView(note);
        for(int i=0;i<o.length();i++){ JSONObject p=o.optJSONObject(i); if(p==null)continue; String ctry=p.optString("country",""); if(!ctry.isEmpty()&&!countryMatches(ctry))continue; final int idx=i; MaterialButton b=actionButton("OPENVPN • "+p.optString("name","Unnamed")+"\n"+p.optString("country",getCountryName()),false); box.addView(b); b.setOnClickListener(x->{try{payload.put("serverKey",KEY_OVPN_PROFILES);payload.put("serverIndex",idx);payload.put("serverName",p.optString("name","Server"));label.setText("Server: "+p.optString("name","Server"));country.setText(p.optString("country",getCountryName()));}catch(Exception ignored){} }); shown++;}
        if(shown==0){TextView e=new TextView(this);e.setText("No servers are available for the current country.");e.setPadding(dp(8),dp(20),dp(8),dp(20));box.addView(e);}
        ScrollView scroll=new ScrollView(this);scroll.addView(box); AlertDialog d=new AlertDialog.Builder(this).setTitle("Select Server").setView(scroll).setPositiveButton("Close",null).create(); d.show();
    }

    private JSONObject activePayload(){String id=prefs.getString(KEY_ACTIVE_PAYLOAD,"");if(id.isEmpty())return null;JSONArray a=payloads();for(int i=0;i<a.length();i++){JSONObject p=a.optJSONObject(i);if(p!=null&&id.equals(p.optString("id","")))return p;}return null;}

    private JSONObject payloadForServer(String key,int index) {
        JSONArray a=payloads(); String active=prefs.getString(KEY_ACTIVE_PAYLOAD,"");
        for(int i=0;i<a.length();i++){JSONObject p=a.optJSONObject(i);if(p==null)continue; if(key.equals(p.optString("serverKey",""))&&index==p.optInt("serverIndex",-1)){if(active.equals(p.optString("id","")))return p; if(!active.isEmpty()) continue; return p;}}
        for(int i=0;i<a.length();i++){JSONObject p=a.optJSONObject(i);if(p!=null&&key.equals(p.optString("serverKey",""))&&index==p.optInt("serverIndex",-1))return p;}
        return null;
    }


    /** Manual payload entry compatible with the classic payload/server workflow.
     *  The generated-payload editor remains available; this adds a direct payload form
     *  so users can paste/edit a payload and bind it to a saved OpenVPN server.
     */
    private void showManualPayloadDialog(int payloadIndex) {
        JSONArray all=payloads();
        JSONObject old=(payloadIndex>=0&&payloadIndex<all.length())?all.optJSONObject(payloadIndex):new JSONObject();
        if(old==null) old=new JSONObject();
        final JSONObject payloadOld=old;

        LinearLayout body=verticalBox(); body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout tabs=new LinearLayout(this); body.addView(tabs,new LinearLayout.LayoutParams(-1,dp(42)));
        MaterialButton generate=uiButton("Generate",false), manual=uiButton("Manual",true);
        generate.setMinHeight(dp(40)); manual.setMinHeight(dp(40)); generate.setTextSize(10); manual.setTextSize(10);
        tabs.addView(generate,new LinearLayout.LayoutParams(0,dp(40),1)); tabs.addView(manual,new LinearLayout.LayoutParams(0,dp(40),1));

        TextView hint=uiLabel("Enter your own HTTP/HTTPS payload and assign it to an OpenVPN server.",12,uiMuted());
        hint.setPadding(dp(2),dp(8),dp(2),dp(10)); body.addView(hint);
        EditText name=uiField("Payload Name",old.optString("name","My Custom Payload")); body.addView(name);
        TextView typeLabel=uiLabel("Payload Type",11,uiMuted()); typeLabel.setPadding(dp(2),dp(6),0,dp(4)); body.addView(typeLabel);
        Spinner typeSpin=new Spinner(this); String[] types={"HTTP","SSL/TLS","WebSocket","gRPC","V2Ray","Custom"};
        typeSpin.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,types));
        String ot=old.optString("type","HTTP"); for(int i=0;i<types.length;i++)if(types[i].equalsIgnoreCase(ot)||("RK_GENERATED".equals(ot)&&i==0))typeSpin.setSelection(i);
        LinearLayout typeWrap=fieldWrap();typeWrap.addView(typeSpin,new LinearLayout.LayoutParams(-1,dp(46)));body.addView(typeWrap);
        EditText host=uiField("Host / SNI",old.optString("proxyHost",old.optString("sni","example.com"))); body.addView(host);
        EditText port=uiField("Port",old.optString("proxyPort","443")); port.setInputType(InputType.TYPE_CLASS_NUMBER); body.addView(port);
        EditText payload=uiField("Raw Payload",old.optString("template","")); payload.setGravity(Gravity.TOP|Gravity.START); payload.setMinLines(7); payload.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE); body.addView(payload,new LinearLayout.LayoutParams(-1,dp(150)));
        EditText sni=uiField("SNI (optional)",old.optString("sni","")); body.addView(sni);
        TextView serverLabel=uiLabel("Server: "+payloadServerLabel(old),12,uiText()); serverLabel.setPadding(dp(2),dp(8),dp(2),dp(8)); body.addView(serverLabel);
        MaterialButton choose=uiButton("▤  Select OpenVPN Server",false); body.addView(choose);
        TextView note=uiLabel("Supported placeholders: [host], [port], [host_port], [crlf], [protocol], [method]",10,uiMuted()); note.setPadding(dp(2),dp(2),dp(2),dp(10)); body.addView(note);
        MaterialButton save=uiButton("✓  Save Payload",true); body.addView(save);

        android.app.Dialog d=showReferenceScreen(payloadIndex>=0?"Edit Payload":"Add Payload",body);
        generate.setOnClickListener(v->{d.dismiss();showStandalonePayloadEditor(payloadIndex,payloadOld,new JSONObject[]{payloadOld});});
        choose.setOnClickListener(v->{EditText c=new EditText(this);c.setText(payloadOld.optString("country",getCountryName()));chooseServerForPayload(payloadOld,serverLabel,c);});
        save.setOnClickListener(v->{try{
            String text=payload.getText().toString().trim(); if(text.isEmpty())throw new IllegalArgumentException("Raw payload is required");
            JSONObject out=new JSONObject(); out.put("id",payloadOld.optString("id",java.util.UUID.randomUUID().toString()));
            out.put("name",name.getText().toString().trim().isEmpty()?"Payload":name.getText().toString().trim());
            out.put("type",types[typeSpin.getSelectedItemPosition()]); out.put("template",payload.getText().toString());
            out.put("proxyHost",host.getText().toString().trim()); out.put("proxyPort",port.getText().toString().trim()); out.put("sni",sni.getText().toString().trim());
            out.put("serverKey",payloadOld.optString("serverKey","")); out.put("serverIndex",payloadOld.optInt("serverIndex",-1));
            out.put("serverName",payloadOld.optString("serverName","Not selected")); out.put("country",payloadOld.optString("country",getCountryName()));
            out.put("mode",out.optInt("serverIndex",-1)>=0?"OPENVPN":"V2RAY");
            if(payloadIndex>=0&&payloadIndex<all.length())all.put(payloadIndex,out);else all.put(out); savePayloads(all); prefs.edit().putString(KEY_ACTIVE_PAYLOAD,out.optString("id")).apply();
            refreshProfileUi(); Toast.makeText(this,"Payload saved",Toast.LENGTH_SHORT).show(); d.dismiss();
        }catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}});
    }

    private void showPayloadDialog(int profileIndex) {
        if(profileIndex>=0){showPayloadDialogForKey(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES,profileIndex);return;}
        LinearLayout body=verticalBox();body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout tabs=new LinearLayout(this);uiTabs(tabs,new String[]{"All Payloads","Favorites"},0,null);body.addView(tabs);
        EditText search=uiSearch("Search payloads…");body.addView(search,new LinearLayout.LayoutParams(-1,dp(44)));
        LinearLayout chips=new LinearLayout(this);uiTabs(chips,new String[]{"HTTP","SSL/TLS","WebSocket","gRPC","V2Ray","Custom"},0,null);body.addView(chips);
        MaterialButton add=uiButton("＋  Add Payload",true);body.addView(add);
        LinearLayout list=new LinearLayout(this);list.setOrientation(LinearLayout.VERTICAL);body.addView(list);
        JSONArray all=payloads();for(int i=0;i<all.length();i++){JSONObject p=all.optJSONObject(i);if(p==null)continue;final int idx=i;String name=p.optString("name","Payload");String type=p.optString("type","Custom");String status=p.optString("status","UNKNOWN");LinearLayout card=uiCard((p.optBoolean("favorite",false)?"★  ":"◉  ")+name,type+" payload  •  "+status);MaterialButton open=uiButton("Open",false);card.addView(open);open.setOnClickListener(v->showPayloadActions(idx));card.setOnClickListener(v->showPayloadActions(idx));list.addView(card,new LinearLayout.LayoutParams(-1,dp(92)));((LinearLayout.LayoutParams)card.getLayoutParams()).bottomMargin=dp(7);}
        if(all.length()==0){TextView e=uiLabel("No payloads yet. Add one using Generate or Manual.",13,uiMuted());e.setPadding(0,dp(18),0,dp(18));list.addView(e);}
        add.setOnClickListener(v->showAddPayloadChooserScreen());
        showReferenceScreen("Payload List",body);
    }
    private void showAddPayloadChooserScreen(){
        LinearLayout body=verticalBox(); body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout tabs=new LinearLayout(this); body.addView(tabs,new LinearLayout.LayoutParams(-1,dp(42)));
        MaterialButton genTab=uiButton("Generate",true), manualTab=uiButton("Manual",false);
        genTab.setMinHeight(dp(40)); manualTab.setMinHeight(dp(40)); genTab.setTextSize(10); manualTab.setTextSize(10);
        tabs.addView(genTab,new LinearLayout.LayoutParams(0,dp(40),1)); tabs.addView(manualTab,new LinearLayout.LayoutParams(0,dp(40),1));
        TextView title=uiLabel("Create a payload",18,uiText()); title.setTypeface(null,android.graphics.Typeface.BOLD); title.setPadding(dp(2),dp(16),dp(2),dp(4)); body.addView(title);
        TextView sub=uiLabel("Choose Generate for assisted payload building or Manual to enter the exact payload yourself.",12,uiMuted()); sub.setPadding(dp(2),0,dp(2),dp(14)); body.addView(sub);
        LinearLayout card=uiCard("⚡  Payload Generator","HTTP / CONNECT • Split • Injection • Headers"); body.addView(card,new LinearLayout.LayoutParams(-1,dp(86)));
        MaterialButton open=uiButton("⚙  Open Payload Generator",true); body.addView(open);
        MaterialButton manual=uiButton("✎  Open Manual Payload Editor",false); body.addView(manual);
        TextView note=uiLabel("After saving, the payload can be assigned to a server and used with Connect.",11,uiMuted()); note.setPadding(dp(2),dp(4),dp(2),dp(12)); body.addView(note);
        android.app.Dialog d=showReferenceScreen("Add Payload",body);
        open.setOnClickListener(v->{d.dismiss();showStandalonePayloadEditor(-1,new JSONObject(),new JSONObject[]{new JSONObject()});});
        manual.setOnClickListener(v->{d.dismiss();showManualPayloadDialog(-1);});
        genTab.setOnClickListener(v->{genTab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(uiBlue()));manualTab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(7,31,45)));});
        manualTab.setOnClickListener(v->{d.dismiss();showManualPayloadDialog(-1);});
    }

    private void showPayloadActions(int index){
        JSONArray a=payloads(); JSONObject p=a.optJSONObject(index); if(p==null)return;
        boolean favorite=p.optBoolean("favorite",false); String[] actions={favorite?"☆ Remove Favorite":"★ Add Favorite","Use & Connect","Edit Payload","Test Payload","Lock Payload to Phone Storage","Delete Payload","Close"};
        new AlertDialog.Builder(this).setTitle(p.optString("name","Payload")).setItems(actions,(d,w)->{
            if(w==0){try{p.put("favorite",!favorite);a.put(index,p);savePayloads(a);Toast.makeText(this,!favorite?"Payload added to Favorites":"Payload removed from Favorites",Toast.LENGTH_SHORT).show();}catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}}
            else if(w==1){try{String key=p.optString("serverKey","");int si=p.optInt("serverIndex",-1);if(!key.isEmpty()&&si>=0){isOpenVpnSelected=key.equals(KEY_OVPN_PROFILES);selectedProfile=si;prefs.edit().putInt(isOpenVpnSelected?KEY_SELECTED_OVPN:KEY_SELECTED_V2,si).apply();}else{isOpenVpnSelected=false;selectedProfile=prefs.getInt(KEY_SELECTED_V2,-1);if(selectedProfile<0){Toast.makeText(this,"Select a V2Ray/Xray config first",Toast.LENGTH_LONG).show();return;}}prefs.edit().putString(KEY_ACTIVE_PAYLOAD,p.optString("id","")).apply();refreshProfileUi();new android.os.Handler(getMainLooper()).postDelayed(()->{if(isOpenVpnSelected)handleOpenVpnConnection();else handleV2RayConnection();},350);}catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}}
            else if(w==2){showStandalonePayloadEditor(index,p,new JSONObject[]{p});}
            else if(w==3){testPayloadAsync(p);}
            else if(w==4){lockPayloadToPhoneStorage(p);}
            else if(w==5){try{a.remove(index);savePayloads(a);if(p.optString("id").equals(prefs.getString(KEY_ACTIVE_PAYLOAD,"")))prefs.edit().remove(KEY_ACTIVE_PAYLOAD).apply();Toast.makeText(this,"Payload deleted",Toast.LENGTH_SHORT).show();}catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}}
        }).show();
    }

    private void testPayloadAsync(JSONObject p){
        new Thread(()->{
            boolean ok=false; String detail="";
            try {
                String host=p.optString("proxyHost","").trim(); int port=parseInt(p.optString("proxyPort",""),-1);
                String key=p.optString("serverKey",""); int idx=p.optInt("serverIndex",-1);
                JSONObject sp=(!key.isEmpty()&&idx>=0)?profiles(key).optJSONObject(idx):null;
                if(host.isEmpty()&&sp!=null){
                    java.util.regex.Matcher m=java.util.regex.Pattern.compile("(?im)^\\s*remote\\s+([^\\s]+)(?:\\s+(\\d+))?").matcher(sp.optString("config",""));
                    if(m.find()){host=m.group(1);port=parseInt(m.group(2),443);}
                }
                if(host.isEmpty()||port<=0||port>65535)throw new IllegalArgumentException("No valid test host/port");
                String type=p.optString("type","None"); String template=p.optString("template","");
                boolean tls=type.toLowerCase(java.util.Locale.US).contains("ssl")||p.optString("sni","").trim().length()>0;
                java.net.Socket raw;
                if(tls){
                    javax.net.ssl.SSLContext ctx=javax.net.ssl.SSLContext.getInstance("TLS");ctx.init(null,null,null);
                    javax.net.ssl.SSLSocketFactory sf=ctx.getSocketFactory(); javax.net.ssl.SSLSocket ss=(javax.net.ssl.SSLSocket)sf.createSocket();
                    ss.connect(new java.net.InetSocketAddress(host,port),3000); String sni=p.optString("sni","").trim(); if(!sni.isEmpty()){
                        try{javax.net.ssl.SSLParameters spm=ss.getSSLParameters();spm.setServerNames(java.util.Collections.singletonList(new javax.net.ssl.SNIHostName(sni)));ss.setSSLParameters(spm);}catch(Exception ignored){}
                    }
                    ss.startHandshake();
                    if(template.trim().isEmpty()){ok=true;detail="TLS handshake OK";} else {String req=expandPayloadTemplate(template,host,port);ss.getOutputStream().write(req.getBytes(java.nio.charset.StandardCharsets.ISO_8859_1));ss.getOutputStream().flush();byte[] buf=new byte[512];int n=ss.getInputStream().read(buf);String resp=n>0?new String(buf,0,n,java.nio.charset.StandardCharsets.ISO_8859_1):"";ok=n>0&&(resp.startsWith("HTTP/")||resp.contains("101 Switching Protocols")||resp.contains("200"));detail=ok?"TLS + payload response OK":"TLS connected but payload response invalid";}ss.close();
                } else {
                    raw=new java.net.Socket();raw.connect(new java.net.InetSocketAddress(host,port),3000);
                    if(template.trim().isEmpty()){ok=true;detail="TCP endpoint reachable";}else{String req=expandPayloadTemplate(template,host,port);raw.getOutputStream().write(req.getBytes(java.nio.charset.StandardCharsets.ISO_8859_1));raw.getOutputStream().flush();raw.setSoTimeout(3000);byte[] buf=new byte[512];int n=raw.getInputStream().read(buf);String resp=n>0?new String(buf,0,n,java.nio.charset.StandardCharsets.ISO_8859_1):"";ok=n>0&&(resp.startsWith("HTTP/")||resp.contains("101 Switching Protocols")||resp.contains("200"));detail=ok?"TCP + payload response OK":"Endpoint reachable but payload response invalid";}raw.close();
                }
            } catch(Exception e){detail=safeMessage(e);}
            final boolean good=ok; final String msg=detail;runOnUiThread(()->{try{String id=p.optString("id","");JSONArray a=payloads();for(int i=0;i<a.length();i++){JSONObject q=a.optJSONObject(i);if(q!=null&&id.equals(q.optString("id",""))){q.put("status",good?"GOOD":"WRONG");q.put("statusDetail",msg);q.put("statusAt",System.currentTimeMillis());a.put(i,q);break;}}savePayloads(a);}catch(Exception ignored){}Toast.makeText(this,(good?"GOOD: ":"WRONG: ")+p.optString("name","Payload")+" • "+msg,Toast.LENGTH_LONG).show();});
        },"payload-test").start();
    }

    private String expandPayloadTemplate(String template,String host,int port){
        String hp=host+":"+port; String protocol=port==443?"HTTPS":"HTTP";
        return template.replace("[crlf]","\r\n").replace("[host_port]",hp).replace("[host]",host).replace("[port]",String.valueOf(port)).replace("[protocol]",protocol).replace("[method]","GET");
    }

    private void showPayloadDialogForKey(String key, int profileIndex) {
        JSONObject p=payloadForServer(key,profileIndex); if(p==null){Toast.makeText(this,"No payload is assigned to this server. Create one from Payload List.",Toast.LENGTH_LONG).show();return;}
        showPayloadActions(payloadIndexById(p.optString("id","")));
    }

    private int payloadIndexById(String id){JSONArray a=payloads();for(int i=0;i<a.length();i++)if(id.equals(a.optJSONObject(i).optString("id","")))return i;return -1;}

    private void showServerListDialog() {
        LinearLayout body=verticalBox();body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout tabs=new LinearLayout(this);uiTabs(tabs,new String[]{"All Servers","Favorites"},0,null);body.addView(tabs);
        EditText search=uiSearch("⌕  Search servers…");body.addView(search,new LinearLayout.LayoutParams(-1,dp(44)));
        LinearLayout chips=new LinearLayout(this);uiTabs(chips,new String[]{"All","Fastest","OpenVPN","V2Ray"},0,null);body.addView(chips);
        MaterialButton add=uiButton("＋  Add Server / Config",true);body.addView(add);add.setOnClickListener(v->showAddServerDialog());
        LinearLayout list=new LinearLayout(this);list.setOrientation(LinearLayout.VERTICAL);body.addView(list);
        JSONArray o=profiles(KEY_OVPN_PROFILES);for(int i=0;i<o.length();i++){JSONObject p=o.optJSONObject(i);if(!isProfileAllowed(p))continue;final int idx=i;String n=p.optString("name","Unnamed");String c=p.optString("country",getCountryName());long ms=p.optLong("lastLatencyMs",-1);String meta=ms>0?"◉ "+ms+" ms":"○  Ping —";LinearLayout card=uiCard((p.optBoolean("favorite",false)?"★  ":"◉  ")+n,c+"  •  "+meta);card.setOnClickListener(v->showServerDetailsDialog(idx));list.addView(card,new LinearLayout.LayoutParams(-1,dp(70)));((LinearLayout.LayoutParams)card.getLayoutParams()).bottomMargin=dp(7);}
        if(o.length()==0){LinearLayout card=uiCard("🇯🇵  Bundled OpenVPN","Bundled profile • tap to connect");card.setOnClickListener(v->handleOpenVpnConnection());list.addView(card,new LinearLayout.LayoutParams(-1,dp(70)));}
        showReferenceScreen("Server List",body);
    }

    private void showServerDetailsDialog(int index){
        JSONArray a=profiles(KEY_OVPN_PROFILES);JSONObject p=a.optJSONObject(index);if(p==null)return;
        LinearLayout body=verticalBox();body.setPadding(dp(4),dp(4),dp(4),dp(18));
        LinearLayout top=uiCard("🇯🇵  "+p.optString("name","Server"),"◉ "+(p.optLong("lastLatencyMs",-1)>0?p.optLong("lastLatencyMs")+" ms":"Ping —")+"   •   "+p.optString("country",getCountryName()));body.addView(top);
        String host=p.optString("host","");int port=p.optInt("port",1194);if(host.isEmpty()){java.util.regex.Matcher m=java.util.regex.Pattern.compile("(?im)^\\s*remote\\s+([^\\s]+)(?:\\s+(\\d+))?").matcher(p.optString("config",""));if(m.find()){host=m.group(1);port=parseInt(m.group(2),1194);}}
        body.addView(uiCard("Type","OpenVPN"));body.addView(uiCard("IP / Host",host.isEmpty()?"—":host));body.addView(uiCard("Port",String.valueOf(port)));body.addView(uiCard("Protocol","OpenVPN"));body.addView(uiCard("Uptime","—"));
        MaterialButton fav=uiButton(p.optBoolean("favorite",false)?"★  Remove from Favorites":"☆  Add to Favorites",false);body.addView(fav);
        MaterialButton download=uiButton("⇩  Download Config",false);body.addView(download);
        MaterialButton connect=uiButton("⌁  Connect",true);body.addView(connect);
        android.app.Dialog d=showReferenceScreen("Server Details",body);
        fav.setOnClickListener(v->{try{p.put("favorite",!p.optBoolean("favorite",false));a.put(index,p);saveProfiles(KEY_OVPN_PROFILES,a);fav.setText(p.optBoolean("favorite")?"★  Remove from Favorites":"☆  Add to Favorites");}catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}});
        download.setOnClickListener(v->showSaveOvpnProfileDialog(p.optString("name","server")+".ovpn",p.optString("config","")));
        connect.setOnClickListener(v->{isOpenVpnSelected=true;selectedProfile=index;prefs.edit().putInt(KEY_SELECTED_OVPN,index).apply();refreshProfileUi();d.dismiss();handleOpenVpnConnection();});
    }
    private void showServerActions(int index) {
        JSONArray a=profiles(KEY_OVPN_PROFILES); JSONObject p=a.optJSONObject(index); if(p==null)return;
        boolean favorite=p.optBoolean("favorite",false);
        String[] actions={favorite?"☆ Remove Favorite":"★ Add Favorite","Test Latency","Connect This Server","Delete Server","Close"};
        new AlertDialog.Builder(this).setTitle(p.optString("name","Server")).setItems(actions,(d,w)->{
            try {
                if(w==0){p.put("favorite",!favorite);a.put(index,p);saveProfiles(KEY_OVPN_PROFILES,a);refreshProfileUi();Toast.makeText(this,!favorite?"Added to Favorites":"Removed from Favorites",Toast.LENGTH_SHORT).show();}
                else if(w==1){String host=p.optString("host","");int port=0;if(host.isEmpty()){java.util.regex.Matcher m=java.util.regex.Pattern.compile("(?im)^\\s*remote\\s+([^\\s]+)(?:\\s+(\\d+))?").matcher(p.optString("config",""));if(m.find()){host=m.group(1);port=parseInt(m.group(2),443);}}else{java.util.regex.Matcher m=java.util.regex.Pattern.compile("(?im)^\\s*remote\\s+[^\\s]+\\s+(\\d+)").matcher(p.optString("config",""));if(m.find())port=parseInt(m.group(1),443);if(port<=0)port=443;}if(host.isEmpty())throw new IllegalArgumentException("Server host not found");final String h=host;final int pr=port;Toast.makeText(this,"Testing "+h+":"+pr,Toast.LENGTH_SHORT).show();new Thread(()->{long ms=probeLatency(h,pr,3000);runOnUiThread(()->{try{JSONArray x=profiles(KEY_OVPN_PROFILES);JSONObject q=x.optJSONObject(index);if(q!=null){q.put("lastLatencyMs",ms);q.put("lastTestedAt",System.currentTimeMillis());q.put("lastStatus",ms>0?"REACHABLE":"UNREACHABLE");x.put(index,q);saveProfiles(KEY_OVPN_PROFILES,x);refreshProfileUi();}Toast.makeText(this,ms>0?"Latency: "+ms+" ms":"Server unreachable",Toast.LENGTH_LONG).show();}catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}});},"server-latency").start();}
                else if(w==2){isOpenVpnSelected=true;selectedProfile=index;prefs.edit().putInt(KEY_SELECTED_OVPN,index).remove(KEY_ACTIVE_PAYLOAD).apply();refreshProfileUi();handleOpenVpnConnection();}
                else if(w==3){a.remove(index);saveProfiles(KEY_OVPN_PROFILES,a);onServerDeleted(KEY_OVPN_PROFILES,index);if(selectedProfile==index)selectedProfile=-1;refreshProfileUi();Toast.makeText(this,"Server deleted",Toast.LENGTH_SHORT).show();}
            }catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}
        }).show();
    }

    private void showCredentialsDialog(JSONObject profile, String config) {
        LinearLayout box = verticalBox(); EditText user = edit("Username", profile == null ? "" : profile.optString("username","")); EditText pass = edit("Password", profile == null ? "" : profile.optString("password","")); pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); box.addView(user); box.addView(pass);
        new AlertDialog.Builder(this).setTitle("OpenVPN credentials required").setView(box).setNegativeButton("Cancel", null).setPositiveButton("Save & Connect", (d,w)->{
            if(profile == null){ Toast.makeText(this,"Select/import an OVPN profile first",Toast.LENGTH_LONG).show(); return; }
            try { profile.put("username",user.getText().toString()); profile.put("password",pass.getText().toString()); updateProfile(KEY_OVPN_PROFILES,selectedProfile,profile); refreshProfileUi(); handleOpenVpnConnection(); } catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}
        }).show();
    }

    private void handleV2RayConnection() {
        if (prefs.getBoolean("xray_running", false)) {
            stopService(new Intent(this, V2RayService.class));
            prefs.edit().putBoolean("xray_running", false).apply();
            btnConnect.setText("Connect V2Ray / Xray");
            tvSessionUsage.setText("V2Ray/Xray stopped");
            addHistory("V2Ray/Xray stopped");
            return;
        }
        JSONObject profile = getSelectedProfile(KEY_V2RAY_PROFILES);
        if (profile == null) { Toast.makeText(this, "Select or import a V2Ray/Xray profile first", Toast.LENGTH_LONG).show(); return; }
        failoverActive = true;
        failoverNextIndex = selectedProfile;
        String config = profile.optString("config", "").trim();
        if (config.isEmpty()) { Toast.makeText(this,"V2Ray config is empty",Toast.LENGTH_LONG).show(); return; }
        try { JSONObject payload = activePayload(); if (payload == null) payload = profile.optJSONObject("payload"); config = applyPayloadToXrayConfig(config, payload); } catch(Exception e) { Toast.makeText(this, "V2Ray config/payload: " + safeMessage(e), Toast.LENGTH_LONG).show(); return; }
        pendingV2RayConfig = config;
        Intent prepare = VpnService.prepare(this);
        if (prepare != null) startActivityForResult(prepare, REQUEST_VPN_PERMISSION); else startV2RayService(config);
    }

    private void startV2RayService(String config) {
        Intent i = new Intent(this, V2RayService.class); i.putExtra(V2RayService.EXTRA_CONFIG, config); i.putExtra(V2RayService.EXTRA_SERVER_NAME, profileNameForConfig(config)); JSONObject p=getSelectedProfile(KEY_V2RAY_PROFILES); if(p!=null){i.putExtra(V2RayService.EXTRA_ALLOW_ADULT,p.optBoolean("allowAdult",true)); JSONArray apps=p.optJSONArray("allowedApps"); if(apps!=null)i.putExtra(V2RayService.EXTRA_ALLOWED_APPS,apps.toString());} JSONObject active=activePayload(); if(active!=null)i.putExtra(V2RayService.EXTRA_PAYLOAD_NAME,active.optString("name","Payload"));
        if (android.os.Build.VERSION.SDK_INT >= 26) startForegroundService(i); else startService(i);
        btnConnect.setText("Disconnect V2Ray"); tvSessionUsage.setText("V2Ray/Xray starting...");
        addHistory("V2Ray/Xray connecting: " + profileNameForConfig(config));
    }

    private String profileNameForConfig(String config) {
        try {
            JSONObject p = getSelectedProfile(KEY_V2RAY_PROFILES);
            return p == null ? "Unnamed" : p.optString("name", "Unnamed");
        } catch (Exception e) { return "Unnamed"; }
    }

    private void clearSelectedProfile() {
        String key = isOpenVpnSelected ? KEY_OVPN_PROFILES : KEY_V2RAY_PROFILES;
        if (selectedProfile < 0) { Toast.makeText(this,"Select a profile first",Toast.LENGTH_SHORT).show(); return; }
        try { JSONArray arr = profiles(key); String removedName = arr.getJSONObject(selectedProfile).optString("name", "Unnamed"); arr.remove(selectedProfile); saveProfiles(key,arr); onServerDeleted(key,selectedProfile); addHistory("Deleted " + (isOpenVpnSelected ? "OVPN: " : "V2Ray: ") + removedName); selectedProfile=-1; prefs.edit().remove(isOpenVpnSelected?KEY_SELECTED_OVPN:KEY_SELECTED_V2).apply(); refreshProfileUi(); } catch(Exception e){Toast.makeText(this,safeMessage(e),Toast.LENGTH_LONG).show();}
    }

    private void refreshProfileUi() {
        final int desiredProfile = selectedProfile;
        if (tvServerCount != null) {
            int serverCount = profiles(KEY_OVPN_PROFILES).length() + profiles(KEY_V2RAY_PROFILES).length();
            tvServerCount.setText(serverCount + (serverCount == 1 ? " server" : " servers"));
        }
        if (tvPayloadCount != null) {
            int payloadCount = payloads().length();
            tvPayloadCount.setText(payloadCount + (payloadCount == 1 ? " payload" : " payloads"));
        }
        migrateLegacyAttachedPayloads();
        List<String> names = new ArrayList<>(); names.add("Use bundled asset / select profile");
        try { JSONArray arr=profiles(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES); for(int i=0;i<arr.length();i++) { JSONObject p=arr.getJSONObject(i); if(isProfileAllowed(p)) names.add(p.optString("name","Unnamed")); } } catch(Exception ignored){}
        ArrayAdapter<String> a=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,names); a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); spinnerProfile.setAdapter(a);
        updateProtocolToggleUi();
        updateUiState(); updateImportedFilesText();
        renderConfigList();
        spinnerProfile.post(() -> { int pos=0; if(desiredProfile>=0){List<Integer> ids=visibleProfileIndices(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES);int ix=ids.indexOf(desiredProfile);if(ix>=0)pos=ix+1;} spinnerProfile.setSelection(pos); });
    }

    private void probeProfileAsync(final JSONObject p, final TextView label) {
        new Thread(() -> {
            boolean ok = false;
            try {
                String host = "";
                int port = -1;
                String config = p == null ? "" : p.optString("config", "");

                if (isOpenVpnSelected) {
                    java.util.regex.Matcher m = java.util.regex.Pattern
                            .compile("(?im)^\\s*remote\\s+([^\\s]+)(?:\\s+(\\d+))?")
                            .matcher(config);
                    if (m.find()) {
                        host = m.group(1);
                        port = m.group(2) == null ? 443 : Integer.parseInt(m.group(2));
                    }
                } else {
                    JSONObject x = new JSONObject(normalizeXrayForPayload(config));
                    JSONArray outbounds = x.optJSONArray("outbounds");
                    if (outbounds != null) {
                        for (int i = 0; i < outbounds.length(); i++) {
                            JSONObject ob = outbounds.optJSONObject(i);
                            if (ob == null) continue;
                            String protocol = ob.optString("protocol", "");
                            if ("freedom".equalsIgnoreCase(protocol) || "blackhole".equalsIgnoreCase(protocol)) continue;
                            JSONObject settings = ob.optJSONObject("settings");
                            if (settings != null) {
                                JSONArray vnext = settings.optJSONArray("vnext");
                                if (vnext != null && vnext.length() > 0) {
                                    JSONObject server = vnext.optJSONObject(0);
                                    if (server != null) {
                                        host = server.optString("address", "");
                                        port = server.optInt("port", 443);
                                    }
                                }
                                if (host.isEmpty()) {
                                    JSONObject servers = settings.optJSONObject("servers");
                                    if (servers != null) {
                                        JSONArray list = servers.optJSONArray("servers");
                                        if (list != null && list.length() > 0) {
                                            JSONObject server = list.optJSONObject(0);
                                            if (server != null) {
                                                host = server.optString("address", "");
                                                port = server.optInt("port", 443);
                                            }
                                        }
                                    }
                                }
                            }
                            if (!host.isEmpty()) break;
                        }
                    }
                }

                if (!host.isEmpty() && port > 0 && port <= 65535) {
                    java.net.Socket socket = new java.net.Socket();
                    socket.connect(new java.net.InetSocketAddress(host, port), 1800);
                    ok = true;
                    try { socket.close(); } catch (Exception ignored) { }
                }
            } catch (Exception ignored) {
                ok = false;
            }

            final boolean online = ok;
            runOnUiThread(() -> {
                if (!isFinishing() && label != null) {
                    label.setText(online ? "ONLINE" : "OFFLINE");
                    label.setTextColor(online ? Color.rgb(0, 150, 80) : Color.rgb(180, 55, 55));
                }
            });
        }, "server-probe").start();
    }

    private void renderConfigList() {
        if (configList == null) return;
        configList.removeAllViews();
        JSONArray all = profiles(isOpenVpnSelected ? KEY_OVPN_PROFILES : KEY_V2RAY_PROFILES);
        if (all.length() == 0) {
            TextView empty = new TextView(this); empty.setText("No saved profiles yet.\nTap ＋ to import or add one manually.");
            empty.setTextSize(15); empty.setTextColor(Color.rgb(115,128,122)); empty.setGravity(Gravity.CENTER); empty.setPadding(dp(12),dp(22),dp(12),dp(22)); configList.addView(empty); return;
        }
        for (int i=0;i<all.length();i++) {
            final int index=i;
            if (!isProfileAllowed(all.optJSONObject(i))) continue;
            try {
                JSONObject p=all.getJSONObject(i);
                LinearLayout card=new LinearLayout(this); card.setOrientation(LinearLayout.VERTICAL); card.setPadding(dp(16),dp(13),dp(12),dp(13));
                android.graphics.drawable.GradientDrawable bg=new android.graphics.drawable.GradientDrawable(); bg.setColor(Color.WHITE); bg.setCornerRadius(dp(18)); bg.setStroke(dp(1), Color.rgb(215,230,222)); card.setBackground(bg);
                LinearLayout top=new LinearLayout(this); top.setGravity(Gravity.CENTER_VERTICAL);
                TextView icon=new TextView(this); icon.setText(isOpenVpnSelected?"◉":"⚡"); icon.setTextSize(24); icon.setTextColor(Color.rgb(0,169,92)); icon.setPadding(0,0,dp(12),0); top.addView(icon);
                TextView name=new TextView(this); name.setText(p.optString("name","Unnamed")); name.setTextSize(17); name.setTypeface(android.graphics.Typeface.DEFAULT,android.graphics.Typeface.BOLD); name.setTextColor(Color.rgb(225,244,250)); top.addView(name,new LinearLayout.LayoutParams(0,-2,1));
                TextView protocol=new TextView(this); protocol.setText(isOpenVpnSelected?"OVPN":"VLESS / VMess / Trojan / Xray"); protocol.setTextSize(12); protocol.setTextColor(Color.rgb(150,176,187)); top.addView(protocol);
                TextView online=new TextView(this); online.setText("CHECKING..."); online.setTextSize(10); online.setTypeface(android.graphics.Typeface.DEFAULT,android.graphics.Typeface.BOLD); online.setTextColor(Color.rgb(120,120,120)); online.setPadding(dp(8),0,0,0); top.addView(online);
                card.addView(top);
                probeProfileAsync(p, online);
                JSONObject assignedPayload=payloadForServer(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES,index); TextView details=new TextView(this); details.setText("Tap to select  •  " + (p.optString("username","").isEmpty()?"No saved credentials":"Credentials saved") + "  •  Payload: " + (assignedPayload == null ? "None" : assignedPayload.optString("name","Unnamed"))); details.setTextSize(12); details.setTextColor(Color.rgb(135,164,176)); details.setPadding(dp(38),dp(4),0,dp(4)); card.addView(details);
                LinearLayout actions=new LinearLayout(this); actions.setGravity(Gravity.END); MaterialButton select=new MaterialButton(this); select.setText("Use"); select.setAllCaps(false); select.setTextColor(Color.WHITE); select.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(0,169,92))); select.setCornerRadius(dp(14));
                MaterialButton del=new MaterialButton(this); del.setText("Delete"); del.setAllCaps(false); del.setTextColor(Color.rgb(211,47,47)); del.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(35,18,23))); del.setCornerRadius(dp(14)); del.setLayoutParams(new LinearLayout.LayoutParams(-2,dp(44)));
                MaterialButton test=new MaterialButton(this); test.setText("Test"); test.setAllCaps(false); test.setTextColor(Color.rgb(0,120,70)); test.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.rgb(7,31,43))); test.setCornerRadius(dp(14)); test.setLayoutParams(new LinearLayout.LayoutParams(-2,dp(44)));
                actions.addView(del); actions.addView(test); actions.addView(select); card.addView(actions);
                View.OnClickListener choose=v->{ selectedProfile=index; prefs.edit().putInt(isOpenVpnSelected?KEY_SELECTED_OVPN:KEY_SELECTED_V2, selectedProfile).apply(); List<Integer> ids=visibleProfileIndices(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES); int vi=ids.indexOf(index); if(vi>=0) spinnerProfile.setSelection(vi+1); updateProfileInfo(); updateUiState(); Toast.makeText(this,"Selected: "+p.optString("name","Unnamed"),Toast.LENGTH_SHORT).show(); };
                card.setOnClickListener(choose); select.setOnClickListener(choose);
                del.setOnClickListener(v->{ String key=isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES; JSONArray a=profiles(key); a.remove(index); saveProfiles(key,a); onServerDeleted(key,index); selectedProfile=-1; prefs.edit().remove(isOpenVpnSelected?KEY_SELECTED_OVPN:KEY_SELECTED_V2).apply(); refreshProfileUi(); });
                test.setOnClickListener(v->{ if(!isOpenVpnSelected){Toast.makeText(this,"Select OpenVPN to test username/password",Toast.LENGTH_LONG).show();return;} selectedProfile=index; prefs.edit().putInt(KEY_SELECTED_OVPN,index).apply(); authTestMode=true; Toast.makeText(this,"Testing LIVE + username/password + assigned payload...",Toast.LENGTH_SHORT).show(); handleOpenVpnConnection(); });
                LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(-1,dp(150)); lp.bottomMargin=dp(10); configList.addView(card,lp);
            } catch(Exception ignored) {}
        }
    }

    private void onServerDeleted(String key,int index){
        try{JSONArray a=payloads();JSONArray out=new JSONArray();for(int i=0;i<a.length();i++){JSONObject p=a.optJSONObject(i);if(p==null)continue;if(key.equals(p.optString("serverKey",""))){int si=p.optInt("serverIndex",-1);if(si==index)continue;if(si>index)p.put("serverIndex",si-1);}out.put(p);}savePayloads(out);}catch(Exception ignored){}
    }

    private String applyOpenVpnProxy(String config, JSONObject payload) {
        if(payload==null) return config;
        String host=payload.optString("proxyHost","").trim(), port=payload.optString("proxyPort","").trim();
        if(host.isEmpty()||port.isEmpty()) return config;
        for(String line:config.split("\\r?\\n")){String t=line.trim(); if(!t.startsWith("#")&&!t.startsWith(";")&&t.startsWith("http-proxy ")) return config;}
        return config + "\nhttp-proxy " + host + " " + port + "\n";
    }

    private String applyPayloadToXrayConfig(String input, JSONObject payload) throws Exception {
        if(payload==null||payload.length()==0) return input;
        String json=normalizeXrayForPayload(input); JSONObject root=new JSONObject(json);
        JSONArray outs=root.optJSONArray("outbounds"); if(outs==null||outs.length()==0) return input;
        String proxyHost=payload.optString("proxyHost","").trim(), proxyPort=payload.optString("proxyPort","").trim();
        if(!proxyHost.isEmpty()&&!proxyPort.isEmpty()) {
            JSONObject proxy=new JSONObject(); proxy.put("tag","payload-proxy"); proxy.put("protocol","http"); proxy.put("settings",new JSONObject().put("servers",new JSONArray().put(new JSONObject().put("address",proxyHost).put("port",Integer.parseInt(proxyPort))))); outs.put(proxy);
            for(int i=0;i<outs.length()-1;i++){JSONObject o=outs.optJSONObject(i); if(o==null)continue; if(!"payload-proxy".equals(o.optString("tag"))){JSONObject ss=o.optJSONObject("streamSettings"); if(ss==null)ss=new JSONObject(); JSONObject sock=ss.optJSONObject("sockopt"); if(sock==null)sock=new JSONObject(); sock.put("dialerProxy","payload-proxy"); ss.put("sockopt",sock); o.put("streamSettings",ss);}}
        }
        String template=payload.optString("template",""); if(!template.isEmpty()) applyWsPayload(outs,template,payload.optString("type",""));
        String sni=payload.optString("sni","").trim(); if(!sni.isEmpty()){for(int i=0;i<outs.length();i++){JSONObject o=outs.optJSONObject(i);if(o==null||"payload-proxy".equals(o.optString("tag")))continue;JSONObject ss=o.optJSONObject("streamSettings");if(ss==null)ss=new JSONObject();if("tls".equalsIgnoreCase(ss.optString("security",""))||"SSL WebSocket".equalsIgnoreCase(payload.optString("type",""))){JSONObject ts=ss.optJSONObject("tlsSettings");if(ts==null)ts=new JSONObject();ts.put("serverName",sni);ss.put("tlsSettings",ts);o.put("streamSettings",ss);}}}
        root.put("outbounds",outs); return root.toString();
    }

    private String normalizeXrayForPayload(String input) throws Exception {
        String t=input.trim();
        if(t.startsWith("{")) return t;
        JSONObject req=new JSONObject().put("apiVersion",3).put("method","convertShareLinksToXrayJson").put("payload",new JSONObject().put("text",t));
        JSONObject resp=new JSONObject(invokeCoreReflection(req.toString()));
        if(!resp.optBoolean("success",false)) throw new IllegalArgumentException(resp.optString("error","Invalid V2Ray share link"));
        Object data=resp.opt("data"); if(data instanceof JSONObject) return data.toString(); if(data instanceof String) return new JSONObject((String)data).toString();
        throw new IllegalArgumentException("Xray share-link conversion returned no config");
    }

    private String invokeCoreReflection(String request) throws Exception {
        String[] classes={"libXray.LibXray","io.github.wanliyunyan.libxray.LibXray","com.wanliyunyan.libxray.LibXray","io.github.toolshubofficial.libxray.LibXray","com.toolshubofficial.libxray.LibXray"};
        Throwable last=null;
        for(String cn:classes){try{Class<?> cls=Class.forName(cn);for(Method m:cls.getMethods()){if(!(m.getName().equals("invoke")||m.getName().equals("Invoke"))||!Modifier.isStatic(m.getModifiers()))continue;Class<?>[] ps=m.getParameterTypes();if(ps.length==1&&ps[0]==String.class&&m.getReturnType()==String.class)return (String)m.invoke(null,request);}}catch(Throwable e){last=e;}}
        throw new IllegalStateException("libXray Invoke API unavailable",last);
    }

    private void applyWsPayload(JSONArray outs,String template,String type){
        String normalized=template.replace("\\r\\n","\n").replace("[crlf]","\n"); String path=null,host=null;
        java.util.regex.Matcher m=java.util.regex.Pattern.compile("(?i)^GET\\s+([^\\s]+)",java.util.regex.Pattern.MULTILINE).matcher(normalized); if(m.find())path=m.group(1);
        m=java.util.regex.Pattern.compile("(?im)^Host:\\s*([^\\s]+)").matcher(normalized); if(m.find())host=m.group(1).trim();
        String lower=type==null?"":type.toLowerCase(java.util.Locale.US);
        for(int i=0;i<outs.length();i++){
            JSONObject o=outs.optJSONObject(i); if(o==null||"payload-proxy".equals(o.optString("tag")))continue;
            JSONObject ss=o.optJSONObject("streamSettings"); if(ss==null)ss=new JSONObject();
            String net=ss.optString("network","").toLowerCase(java.util.Locale.US);
            try{
                if(lower.contains("httpupgrade")){
                    JSONObject hu=ss.optJSONObject("httpupgradeSettings");if(hu==null)hu=new JSONObject();
                    if(path!=null&&!path.isEmpty())hu.put("path",path);if(host!=null&&!host.isEmpty())hu.put("host",host);
                    ss.put("network","httpupgrade");ss.put("httpupgradeSettings",hu);
                } else if(lower.contains("websocket")||"ws".equals(net)){
                    JSONObject ws=ss.optJSONObject("wsSettings");if(ws==null)ws=new JSONObject();
                    if(path!=null&&!path.isEmpty())ws.put("path",path);if(host!=null&&!host.isEmpty())ws.put("headers",new JSONObject().put("Host",host));
                    ss.put("network","ws");ss.put("wsSettings",ws);
                    if(lower.contains("ssl"))ss.put("security","tls");
                } else if(lower.contains("grpc")){
                    JSONObject gs=ss.optJSONObject("grpcSettings");if(gs==null)gs=new JSONObject();
                    if(path!=null&&!path.isEmpty())gs.put("serviceName",path.startsWith("/")?path.substring(1):path);ss.put("network","grpc");ss.put("grpcSettings",gs);
                } else if(lower.contains("http/2")){
                    JSONObject hs=ss.optJSONObject("httpSettings");if(hs==null)hs=new JSONObject();
                    if(path!=null&&!path.isEmpty())hs.put("path",path);if(host!=null&&!host.isEmpty())hs.put("host",new JSONArray().put(host));ss.put("network","http");ss.put("httpSettings",hs);
                } else if(lower.contains("xhttp")){
                    JSONObject xs=ss.optJSONObject("xhttpSettings");if(xs==null)xs=new JSONObject();
                    if(path!=null&&!path.isEmpty())xs.put("path",path);if(host!=null&&!host.isEmpty())xs.put("host",host);ss.put("network","xhttp");ss.put("xhttpSettings",xs);
                }
                o.put("streamSettings",ss);
            }catch(Exception ignored){}
        }
    }

    private void updateDeviceContext(){ if(tvDeviceContext!=null) tvDeviceContext.setText("Country: "+getCountryName()+"  •  "+getNetworkDescription()); }

    private void updateUiState() {
        if (tvConnectionState != null) {
            boolean connected = bongoVpn != null && bongoVpn.isConnected();
            boolean xray = prefs.getBoolean("xray_running", false);
            tvConnectionState.setText((connected || xray) ? "Connected" : "Disconnected");
            tvConnectionState.setTextColor((connected || xray) ? Color.rgb(65, 235, 170) : Color.rgb(170, 190, 200));
        }
        if(isOpenVpnSelected){btnImportConfig.setText("Import .ovpn File");btnManualConfig.setText("Manual OVPN Config");btnClearConfig.setText("Delete Selected OVPN");updateOpenVpnButtonState();}
        else{btnImportConfig.setText("Import V2Ray/Xray File");btnManualConfig.setText("Manual V2Ray / Xray");btnClearConfig.setText("Delete Selected V2Ray");boolean running=prefs.getBoolean("xray_running",false);btnConnect.setText(running?"Disconnect V2Ray":"Connect V2Ray / Xray");btnConnect.setTextColor(Color.WHITE);btnConnect.setEnabled(true);tvSessionUsage.setText(running?"V2Ray/Xray connected":"Ready for Xray core");}
        updateProfileInfo();
    }

    private void updateOpenVpnButtonState(){if(bongoVpn!=null&&bongoVpn.isConnected()){btnConnect.setText("Disconnect OpenVPN");btnConnect.setTextColor(Color.WHITE);}else{btnConnect.setText("Connect OpenVPN");btnConnect.setTextColor(Color.WHITE);}btnConnect.setEnabled(true);}

    private void updateProfileInfo(){
        if(tvProfileInfo==null)return; try{JSONArray arr=profiles(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES); if(selectedProfile>=0&&selectedProfile<arr.length()){JSONObject p=arr.getJSONObject(selectedProfile); String name=p.optString("name","Unnamed"); tvProfileInfo.setText("Selected: "+name); if(tvSelectedServerHome!=null) tvSelectedServerHome.setText(name+"  •  "+p.optString("country",getCountryName()));}else {tvProfileInfo.setText(isOpenVpnSelected?"Selected: bundled assets/japan.ovpn":"Select a saved V2Ray/Xray profile"); if(tvSelectedServerHome!=null) tvSelectedServerHome.setText(isOpenVpnSelected?"Bundled OpenVPN profile":"Select a saved V2Ray/Xray profile");}}catch(Exception e){tvProfileInfo.setText("Profile error");}
    }

    private void updateImportedFilesText(){
        StringBuilder sb=new StringBuilder("Available for ").append(getCountryName()).append(": "); int count=0;
        try {
            JSONArray o=profiles(KEY_OVPN_PROFILES), v=profiles(KEY_V2RAY_PROFILES);
            for(int i=0;i<o.length();i++) if(isProfileAllowed(o.optJSONObject(i))) count++;
            for(int i=0;i<v.length();i++) if(isProfileAllowed(v.optJSONObject(i))) count++;
            sb.append(count);
            if(count>0){
                sb.append("\n");
                for(int i=0;i<o.length();i++){JSONObject p=o.optJSONObject(i);if(isProfileAllowed(p))sb.append("• OVPN: ").append(p.optString("name","Unnamed")).append("\n");}
                for(int i=0;i<v.length();i++){JSONObject p=v.optJSONObject(i);if(isProfileAllowed(p))sb.append("• V2Ray: ").append(p.optString("name","Unnamed")).append("\n");}
            }
        } catch(Exception ignored) {}
        tvImportedFiles.setText(sb.toString());
    }

    private void showStartupFileToast(){
        try{JSONArray o=profiles(KEY_OVPN_PROFILES),v=profiles(KEY_V2RAY_PROFILES);int n=o.length()+v.length();StringBuilder s=new StringBuilder("Saved/imported files: ").append(n);for(int i=0;i<o.length();i++)s.append("\nOVPN: ").append(o.getJSONObject(i).optString("name","Unnamed"));for(int i=0;i<v.length();i++)s.append("\nV2Ray: ").append(v.getJSONObject(i).optString("name","Unnamed"));Toast.makeText(this,s.toString(),Toast.LENGTH_LONG).show();}catch(Exception ignored){}
    }

    private void migrateLegacyAttachedPayloads() {
        try {
            JSONArray existing=payloads(); boolean changed=false;
            String[] keys={KEY_OVPN_PROFILES,KEY_V2RAY_PROFILES};
            for(String key:keys){JSONArray a=profiles(key);for(int i=0;i<a.length();i++){JSONObject p=a.optJSONObject(i);if(p==null)continue;JSONObject pl=p.optJSONObject("payload");if(pl==null||pl.length()==0)continue;String id=pl.optString("id","");if(id.isEmpty())id=java.util.UUID.randomUUID().toString();boolean found=false;for(int j=0;j<existing.length();j++){if(id.equals(existing.optJSONObject(j).optString("id",""))){found=true;break;}}if(!found){pl.put("id",id);pl.put("serverKey",key);pl.put("serverIndex",i);pl.put("serverName",p.optString("name","Server"));existing.put(pl);changed=true;}}}
            if(changed)savePayloads(existing);
        } catch(Exception ignored) {}
    }

    private JSONArray profiles(String key){try{return new JSONArray(prefs.getString(key,"[]"));}catch(Exception e){return new JSONArray();}}
    private void saveProfiles(String key,JSONArray a){prefs.edit().putString(key,a.toString()).apply();}
    private void addProfile(String key,String name,String config,String user,String pass,JSONObject payload)throws Exception{ addProfile(key,name,config,user,pass,payload,getCountryName()); }
    private void addProfile(String key,String name,String config,String user,String pass,JSONObject payload,String country)throws Exception{if(name==null||name.trim().isEmpty())name="Imported";JSONArray a=profiles(key);JSONObject p=new JSONObject();p.put("name",name);p.put("config",config);p.put("username",user==null?"":user);p.put("password",pass==null?"":pass);p.put("country",country==null||country.trim().isEmpty()?getCountryName():country.trim());if(payload!=null&&payload.length()>0)p.put("payload",payload);a.put(p);saveProfiles(key,a);selectedProfile=a.length()-1;}
    private void updateProfile(String key,int index,JSONObject obj)throws Exception{JSONArray a=profiles(key);if(index>=0&&index<a.length()){a.put(index,obj);saveProfiles(key,a);}}
    private JSONObject getSelectedProfile(String key){try{JSONArray a=profiles(key);if(selectedProfile<0||selectedProfile>=a.length())return null;JSONObject p=a.getJSONObject(selectedProfile);String tok=p.optString("serviceDeviceToken","");if(!tok.isEmpty()&&!tok.equals(deviceToken()))throw new SecurityException("This service profile belongs to another device token");String ex=p.optString("serviceExpiresAt","");if(!ex.isEmpty()&&isExpired(ex))throw new SecurityException("Service profile expired on "+ex);return isProfileAllowed(p)?p:null;}catch(Exception e){Toast.makeText(this,"Profile unavailable: "+safeMessage(e),Toast.LENGTH_LONG).show();return null;}}

    private LinearLayout verticalBox(){LinearLayout b=new LinearLayout(this);b.setOrientation(LinearLayout.VERTICAL);b.setPadding(dp(18),dp(8),dp(18),0);b.setBackgroundColor(Color.rgb(3,19,30));return b;}
    private EditText edit(String hint,String text){EditText e=new EditText(this);e.setHint(hint);e.setText(text==null?"":text);e.setTextColor(Color.rgb(225,244,250));e.setHintTextColor(Color.rgb(115,143,154));e.setSingleLine(false);e.setPadding(0,dp(6),0,dp(6));return e;}
    private String readTextFromUri(Uri uri)throws Exception{StringBuilder r=new StringBuilder();try(BufferedReader br=new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(uri)))){String line;while((line=br.readLine())!=null)r.append(line).append('\n');}return r.toString();}
    private String getDisplayName(Uri uri){
        try(Cursor c=getContentResolver().query(uri,new String[]{OpenableColumns.DISPLAY_NAME},null,null,null)){
            if(c!=null&&c.moveToFirst()){String n=c.getString(0);if(n!=null&&!n.trim().isEmpty())return n;}
        }catch(Exception ignored){}
        String n=uri.getLastPathSegment();if(n==null)n="Imported file";int slash=n.lastIndexOf('/');if(slash>=0)n=n.substring(slash+1);return n;
    }
    private String readAsset(String name)throws Exception{StringBuilder r=new StringBuilder();try(BufferedReader br=new BufferedReader(new InputStreamReader(getAssets().open(name)))){String l;while((l=br.readLine())!=null)r.append(l).append('\n');}return r.toString();}
    private boolean containsAuthUserPass(String c){for(String line:c.split("\\r?\\n")){String s=line.trim();if(s.startsWith("auth-user-pass")&&!s.startsWith("#")&&!s.startsWith(";"))return true;}return false;}
    private List<Integer> visibleProfileIndices(String key) { List<Integer> ids=new ArrayList<>(); JSONArray a=profiles(key); for(int i=0;i<a.length();i++) if(isProfileAllowed(a.optJSONObject(i))) ids.add(i); return ids; }

    private boolean isProfileAllowed(JSONObject p) {
        if(p==null)return false;
        String tok=p.optString("serviceDeviceToken",""); if(!tok.isEmpty()&&!tok.equals(deviceToken()))return false;
        String ex=p.optString("serviceExpiresAt","").trim(); if(!ex.isEmpty()){try{if(isExpired(ex))return false;}catch(Exception e){return false;}}
        String c=p.optString("country","").trim();
        if(!c.isEmpty()&&!countryMatches(c))return false;
        if(KEY_OVPN_PROFILES.equals(currentProfileKey()) && prefs.getBoolean(KEY_SERVER_FILTER_PAYLOAD,false)) {
            int idx=findProfileIndex(KEY_OVPN_PROFILES,p);
            if(payloadForServer(KEY_OVPN_PROFILES,idx)==null)return false;
        }
        return true;
    }

    private String currentProfileKey(){return isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES;}
    private int findProfileIndex(String key, JSONObject target){JSONArray a=profiles(key);for(int i=0;i<a.length();i++)if(a.optJSONObject(i)==target)return i;String id=target.optString("id","");for(int i=0;i<a.length();i++)if(!id.isEmpty()&&id.equals(a.optJSONObject(i).optString("id","")))return i;return -1;}

    private boolean countryMatches(String country) {
        if ("Global".equalsIgnoreCase(country) || "Any".equalsIgnoreCase(country)) return true;
        String c=country.trim(); String iso=getCountryIso();
        if(c.equalsIgnoreCase(iso) || c.equalsIgnoreCase(getCountryName())) return true;
        try { String us=new java.util.Locale("",iso).getDisplayCountry(java.util.Locale.US); if(c.equalsIgnoreCase(us)) return true; } catch(Exception ignored){}
        return false;
    }

    private String getCountryIso() {
        try {
            TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
            String iso = tm == null ? "" : tm.getSimCountryIso();
            if (iso == null || iso.trim().isEmpty()) iso = tm == null ? "" : tm.getNetworkCountryIso();
            if (iso == null || iso.trim().isEmpty()) iso = java.util.Locale.getDefault().getCountry();
            return iso == null ? "" : iso.toUpperCase(java.util.Locale.US);
        } catch (Exception e) { return java.util.Locale.getDefault().getCountry(); }
    }

    private String getCountryName() {
        String iso = getCountryIso();
        if (iso.length() == 2) {
            try { return new java.util.Locale("", iso).getDisplayCountry(java.util.Locale.getDefault()); } catch (Exception ignored) { }
        }
        return "Unknown";
    }

    private String getNetworkDescription() {
        try {
            ConnectivityManager cm = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
            Network n = cm == null ? null : cm.getActiveNetwork();
            NetworkCapabilities nc = n == null ? null : cm.getNetworkCapabilities(n);
            if (nc != null && nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) return "Wi-Fi";
            if (nc != null && nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                TelephonyManager tm=(TelephonyManager)getSystemService(TELEPHONY_SERVICE);
                String op=tm==null?"":tm.getNetworkOperatorName();
                return "SIM" + (op==null||op.trim().isEmpty()?"":" • "+op.trim());
            }
            if (nc != null && nc.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) return "Ethernet";
        } catch (Exception ignored) { }
        return "Offline/Unknown";
    }

    private void markSelectedServerStatus(String status) {
        try { if(!isOpenVpnSelected || selectedProfile<0) return; JSONArray a=profiles(KEY_OVPN_PROFILES); if(selectedProfile>=a.length()) return; JSONObject p=a.getJSONObject(selectedProfile); p.put("lastStatus",status); p.put("lastStatusAt",System.currentTimeMillis()); saveProfiles(KEY_OVPN_PROFILES,a); } catch(Exception ignored) {}
    }

    private String selectedServerName() {
        JSONObject p=getSelectedProfile(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES);
        return p==null?"Server":p.optString("name","Server");
    }

    private void showConnectionSuccess(String protocol, String server) {
        String msg="Connected • "+server+"\nCountry: "+getCountryName()+"\nNetwork: "+getNetworkDescription();
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        tvSessionUsage.setText(protocol+" online • "+getCountryName()+" • "+getNetworkDescription());
    }

    private boolean tryNextFailover() {
        if (!failoverActive || !prefs.getBoolean(KEY_AUTO_RECONNECT,true)) return false;
        String key=isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES;
        JSONArray a=profiles(key);
        int start=failoverNextIndex<0?0:failoverNextIndex+1;
        for(int i=start;i<a.length();i++) {
            JSONObject p=a.optJSONObject(i); if(!isProfileAllowed(p)) continue;
            failoverNextIndex=i; selectedProfile=i; prefs.edit().putInt(isOpenVpnSelected?KEY_SELECTED_OVPN:KEY_SELECTED_V2, selectedProfile).apply(); refreshProfileUi();
            Toast.makeText(this,"Trying next server: "+p.optString("name","Unnamed"),Toast.LENGTH_SHORT).show();
            if(isOpenVpnSelected) { new android.os.Handler(getMainLooper()).postDelayed(this::handleOpenVpnConnection,500); }
            else { new android.os.Handler(getMainLooper()).postDelayed(this::handleV2RayConnection,500); }
            return true;
        }
        return false;
    }

    private void validateDate(String ex)throws Exception{if(ex==null||ex.trim().isEmpty())return;java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd",java.util.Locale.US);f.setLenient(false);f.parse(ex.trim());}
    private boolean isExpired(String ex)throws Exception{validateDate(ex);java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd",java.util.Locale.US);f.setLenient(false);java.util.Date d=f.parse(ex.trim());java.util.Calendar c=java.util.Calendar.getInstance();c.set(java.util.Calendar.HOUR_OF_DAY,0);c.set(java.util.Calendar.MINUTE,0);c.set(java.util.Calendar.SECOND,0);c.set(java.util.Calendar.MILLISECOND,0);c.add(java.util.Calendar.DAY_OF_MONTH,1);return !c.getTime().before(d);}

    private String deviceToken() {
        String token=prefs.getString(KEY_DEVICE_TOKEN,"");
        if(token.isEmpty()) { token=java.util.UUID.randomUUID().toString().replace("-","").toUpperCase(java.util.Locale.US); prefs.edit().putString(KEY_DEVICE_TOKEN,token).apply(); }
        return token;
    }

    private void showDeviceTokenDialog() {
        LinearLayout box=verticalBox(); TextView t=new TextView(this); t.setText("Device Token\n\n"+deviceToken()); t.setTextSize(18); t.setTextColor(Color.rgb(30,45,39)); box.addView(t);
        MaterialButton copy=actionButton("Copy Token",true); box.addView(copy);
        AlertDialog d=new AlertDialog.Builder(this).setTitle("Device Token").setView(box).setNegativeButton("Regenerate",(x,w)->{prefs.edit().remove(KEY_DEVICE_TOKEN).apply();showDeviceTokenDialog();}).setPositiveButton("Close",null).create();
        copy.setOnClickListener(v->{android.content.ClipboardManager cm=(android.content.ClipboardManager)getSystemService(CLIPBOARD_SERVICE);cm.setPrimaryClip(android.content.ClipData.newPlainText("Device Token",deviceToken()));Toast.makeText(this,"Device token copied",Toast.LENGTH_SHORT).show();}); d.show();
    }

    private void lockPayloadToPhoneStorage(JSONObject payload) {
        try {
            if (payload == null || payload.length() == 0) throw new IllegalArgumentException("Payload is empty");
            pendingLockedPayload = new JSONObject(payload.toString());
            String safe = payload.optString("name", "payload").replaceAll("[^a-zA-Z0-9._-]", "_");
            if (!safe.toLowerCase(java.util.Locale.US).endsWith(".payload.lock")) safe += ".payload.lock";
            Intent i = new Intent(Intent.ACTION_CREATE_DOCUMENT);
            i.addCategory(Intent.CATEGORY_OPENABLE); i.setType("application/octet-stream"); i.putExtra(Intent.EXTRA_TITLE, safe);
            startActivityForResult(i, REQUEST_SAVE_LOCKED_PAYLOAD);
        } catch (Exception e) { Toast.makeText(this, "Lock payload failed: " + safeMessage(e), Toast.LENGTH_LONG).show(); }
    }

    private void saveLockedPayloadDocument(Uri uri, JSONObject payload) {
        try {
            JSONObject envelope = new JSONObject(); envelope.put("format", "SenseiTunnelLockedPayload"); envelope.put("version", 1); envelope.put("payload", payload);
            byte[] plain = envelope.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8);
            byte[] iv = new byte[12]; new java.security.SecureRandom().nextBytes(iv);
            javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");
            c.init(javax.crypto.Cipher.ENCRYPT_MODE, FileLocker.getOrCreateKey(), new javax.crypto.spec.GCMParameterSpec(128, iv));
            byte[] encrypted = c.doFinal(plain);
            try (OutputStream out = getContentResolver().openOutputStream(uri, "w")) {
                if (out == null) throw new IllegalStateException("Storage destination could not be opened");
                out.write(iv); out.write(encrypted); out.flush();
            }
            try { getContentResolver().takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION); } catch (Exception ignored) {}
            Toast.makeText(this, "Locked payload saved to phone storage", Toast.LENGTH_LONG).show();
        } catch (Exception e) { Toast.makeText(this, "Save locked payload failed: " + safeMessage(e), Toast.LENGTH_LONG).show(); }
    }

    private void importLockedPayloadDocument(Uri uri) {
        try {
            byte[] all; try (InputStream in = getContentResolver().openInputStream(uri); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                if (in == null) throw new IllegalStateException("File could not be opened"); byte[] b = new byte[8192]; int n; while ((n=in.read(b))!=-1) out.write(b,0,n); all=out.toByteArray();
            }
            if (all.length < 13) throw new IllegalArgumentException("Invalid locked payload file");
            byte[] iv = java.util.Arrays.copyOfRange(all,0,12);
            javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding"); c.init(javax.crypto.Cipher.DECRYPT_MODE, FileLocker.getOrCreateKey(), new javax.crypto.spec.GCMParameterSpec(128,iv));
            JSONObject envelope = new JSONObject(new String(c.doFinal(all,12,all.length-12), java.nio.charset.StandardCharsets.UTF_8));
            if (!"SenseiTunnelLockedPayload".equals(envelope.optString("format"))) throw new IllegalArgumentException("Unsupported locked payload file");
            JSONObject payload = envelope.optJSONObject("payload"); if (payload == null) throw new IllegalArgumentException("Payload data missing");
            JSONArray a=payloads(); a.put(payload); savePayloads(a); prefs.edit().putString(KEY_ACTIVE_PAYLOAD,payload.optString("id",java.util.UUID.randomUUID().toString())).apply();
            Toast.makeText(this,"Locked payload imported",Toast.LENGTH_LONG).show(); refreshProfileUi();
        } catch (Exception e) { Toast.makeText(this, "Import locked payload failed: " + safeMessage(e), Toast.LENGTH_LONG).show(); }
    }

    private void showFileLockerDialog() {
        LinearLayout box=verticalBox(); TextView info=new TextView(this); info.setText("Files are encrypted with an Android Keystore key and stored in this app's private storage. Other apps cannot read the encrypted copy."); info.setTextSize(14); info.setTextColor(Color.rgb(75,90,83)); box.addView(info);
        MaterialButton lock=actionButton("🔒 Lock a File",true); MaterialButton service=actionButton("📦 Create Service File",false); MaterialButton importService=actionButton("📥 Import Service File",false); MaterialButton list=actionButton("📁 Locked Files",false); MaterialButton serviceList=actionButton("🗂 Service Files + Share",false); box.addView(lock);box.addView(service);box.addView(importService);box.addView(list);box.addView(serviceList);
        AlertDialog d=new AlertDialog.Builder(this).setTitle("File Locker").setView(box).setNegativeButton("Close",null).create();
        lock.setOnClickListener(v->{d.dismiss();Intent i=new Intent(Intent.ACTION_OPEN_DOCUMENT);i.addCategory(Intent.CATEGORY_OPENABLE);i.setType("*/*");startActivityForResult(i,REQUEST_LOCK_FILE);});
        service.setOnClickListener(v->{d.dismiss();showCreateServiceFileDialog();}); importService.setOnClickListener(v->{d.dismiss();Intent i=new Intent(Intent.ACTION_OPEN_DOCUMENT);i.addCategory(Intent.CATEGORY_OPENABLE);i.setType("*/*");startActivityForResult(i,REQUEST_SERVICE_FILE);}); list.setOnClickListener(v->{d.dismiss();showLockedFiles();}); serviceList.setOnClickListener(v->{d.dismiss();showServiceFiles();}); d.show();
    }

    private void showCreateServiceFileDialog() {
        LinearLayout box=verticalBox();
        EditText name=edit("File name", "service-"+System.currentTimeMillis()+".stconfig");
        EditText expiry=edit("Expire date (YYYY-MM-DD, blank = no expiry)", "");
        EditText maxDevices=edit("Maximum device count", "1"); maxDevices.setInputType(InputType.TYPE_CLASS_NUMBER);
        EditText networkName=edit("Network name", getNetworkDescription());
        TextView cfg=new TextView(this); cfg.setText("Service content: nothing selected"); cfg.setTextSize(14); cfg.setTextColor(Color.rgb(55,70,63));
        final JSONObject[] chosenServer={null}; final JSONObject[] chosenPayload={null}; final JSONObject[] chosenConfig={null};
        MaterialButton pick=actionButton("▤ Select Server / Config / Payload",false);
        MaterialButton apps=actionButton("☑ Select Apps allowed through VPN",false);
        MaterialButton porn=actionButton("Porn/Adult sites: OFF (blocked)",false);
        final JSONArray[] selectedApps={new JSONArray()}; final boolean[] allowAdult={false};
        pick.setOnClickListener(v->showServiceContentPicker(cfg,chosenServer,chosenConfig,chosenPayload));
        apps.setOnClickListener(v->showAppPicker(selectedApps[0]));
        porn.setOnClickListener(v->{allowAdult[0]=!allowAdult[0];porn.setText(allowAdult[0]?"Porn/Adult sites: ON":"Porn/Adult sites: OFF (blocked)");});
        TextView token=new TextView(this); token.setText("Device Token: "+deviceToken()); token.setTextSize(12); token.setTextColor(Color.rgb(95,108,101));
        box.addView(name);box.addView(expiry);box.addView(maxDevices);box.addView(networkName);box.addView(cfg);box.addView(pick);box.addView(apps);box.addView(porn);box.addView(token);
        AlertDialog d=new AlertDialog.Builder(this).setTitle("Create Service File").setView(box).setNegativeButton("Cancel",null).setPositiveButton("Create",null).create();
        d.setOnShowListener(x->d.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(v->{
            try {
                String fn=name.getText().toString().trim(); if(fn.isEmpty())fn="service.stconfig"; if(chosenServer[0]==null&&chosenConfig[0]==null&&chosenPayload[0]==null)throw new IllegalArgumentException("Select at least one: server, config or payload"); if(chosenServer[0]!=null&&chosenConfig[0]!=null)throw new IllegalArgumentException("Choose OpenVPN server OR V2Ray/Xray config, not both"); if(!fn.endsWith(".stconfig"))fn+=".stconfig";
                String ex=expiry.getText().toString().trim(); validateDate(ex);
                JSONObject pack=new JSONObject(); pack.put("format","SenseiTunnelServiceFile"); pack.put("version",3); pack.put("maxDevices",Math.max(1,parseInt(maxDevices.getText().toString(),1))); pack.put("deviceToken",deviceToken()); pack.put("createdAt",System.currentTimeMillis()); pack.put("expiresAt",ex);
                pack.put("protocol",chosenServer[0]!=null?"OPENVPN":(chosenConfig[0]!=null?"V2RAY":"NONE"));
                if(chosenServer[0]!=null) pack.put("server",chosenServer[0]); else pack.put("server",JSONObject.NULL);
                if(chosenConfig[0]!=null) pack.put("config",chosenConfig[0]); else pack.put("config",JSONObject.NULL);
                if(chosenPayload[0]!=null) pack.put("payload",chosenPayload[0]); else pack.put("payload",JSONObject.NULL);
                pack.put("allowedApps",selectedApps[0]); pack.put("allowAdult",allowAdult[0]); pack.put("networkName",networkName.getText().toString().trim());
                File dir=new File(getFilesDir(),"service_files");dir.mkdirs();File f=new File(dir,fn);byte[] iv=new byte[12];new java.security.SecureRandom().nextBytes(iv);javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,serviceKey(deviceToken()),new javax.crypto.spec.GCMParameterSpec(128,iv));byte[] encrypted=cipher.doFinal(pack.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8));try(FileOutputStream fos=new FileOutputStream(f)){fos.write(iv);fos.write(encrypted);}
                Toast.makeText(this,"Service file created:\n"+f.getAbsolutePath(),Toast.LENGTH_LONG).show(); d.dismiss();
            }catch(Exception e){Toast.makeText(this,"Create failed: "+safeMessage(e),Toast.LENGTH_LONG).show();}
        })); d.show();
    }

    private void copyServiceMeta(JSONObject pack,JSONObject profile)throws Exception{String ex=pack.optString("expiresAt","");if(!ex.isEmpty())profile.put("serviceExpiresAt",ex);profile.put("serviceDeviceToken",pack.optString("deviceToken",deviceToken()));profile.put("serviceMaxDevices",pack.optInt("maxDevices",1));profile.put("networkName",pack.optString("networkName",getNetworkDescription()));profile.put("allowAdult",pack.optBoolean("allowAdult",true));JSONArray apps=pack.optJSONArray("allowedApps");if(apps!=null)profile.put("allowedApps",apps);}

    private void importServiceFile(Uri uri){
        try {
            byte[] all; try(InputStream in=getContentResolver().openInputStream(uri);ByteArrayOutputStream out=new ByteArrayOutputStream()){byte[] b=new byte[8192];int n;while((n=in.read(b))!=-1)out.write(b,0,n);all=out.toByteArray();}
            if(all.length<13)throw new IllegalArgumentException("Invalid service file");
            byte[] iv=java.util.Arrays.copyOfRange(all,0,12);javax.crypto.Cipher c=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");c.init(javax.crypto.Cipher.DECRYPT_MODE,serviceKey(deviceToken()),new javax.crypto.spec.GCMParameterSpec(128,iv));JSONObject pack=new JSONObject(new String(c.doFinal(all,12,all.length-12),java.nio.charset.StandardCharsets.UTF_8));
            String token=pack.optString("deviceToken",""); if(!deviceToken().equals(token))throw new SecurityException("This service file belongs to another device token");
            String ex=pack.optString("expiresAt","").trim();if(!ex.isEmpty()&&isExpired(ex))throw new SecurityException("Service file expired on "+ex);
            JSONObject server=pack.optJSONObject("server"); JSONObject config=pack.optJSONObject("config"); JSONObject payload=pack.optJSONObject("payload"); JSONObject privateServer=pack.optJSONObject("privateServer");
            if(privateServer!=null){JSONArray a=privateServers();a.put(privateServer);savePrivateServers(a);Toast.makeText(this,"Private server access imported",Toast.LENGTH_LONG).show();return;}
            String key=server!=null?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES;
            if(server!=null){addProfile(KEY_OVPN_PROFILES,server.optString("name","Imported Server"),server.optString("config",""),server.optString("username",""),server.optString("password",""),payload,server.optString("country",getCountryName())); JSONObject imported=profiles(KEY_OVPN_PROFILES).optJSONObject(profiles(KEY_OVPN_PROFILES).length()-1); if(imported!=null){copyServiceMeta(pack,imported);updateProfile(KEY_OVPN_PROFILES,profiles(KEY_OVPN_PROFILES).length()-1,imported);}}
            else if(config!=null){addProfile(KEY_V2RAY_PROFILES,config.optString("name","Imported Config"),config.optString("config",""),"","",payload,config.optString("country",getCountryName())); JSONObject imported=profiles(KEY_V2RAY_PROFILES).optJSONObject(profiles(KEY_V2RAY_PROFILES).length()-1); if(imported!=null){copyServiceMeta(pack,imported);updateProfile(KEY_V2RAY_PROFILES,profiles(KEY_V2RAY_PROFILES).length()-1,imported);}}
            else if(payload!=null){JSONArray a=payloads();a.put(payload);savePayloads(a);} else throw new IllegalArgumentException("Service file has no server, config or payload");

            Toast.makeText(this,"Service file imported"+(ex.isEmpty()?"":" • expires "+ex),Toast.LENGTH_LONG).show();refreshProfileUi();
        }catch(Exception e){Toast.makeText(this,"Import service file failed: "+safeMessage(e),Toast.LENGTH_LONG).show();}
    }

    private void showServiceFiles(){
        File dir=new File(getFilesDir(),"service_files");if(!dir.exists())dir.mkdirs();File[] fs=dir.listFiles();LinearLayout box=verticalBox();
        if(fs==null||fs.length==0){TextView e=new TextView(this);e.setText("No service files created yet.");box.addView(e);} else for(File f:fs){LinearLayout row=new LinearLayout(this);row.setGravity(Gravity.CENTER_VERTICAL);TextView t=new TextView(this);t.setText(f.getName()+"\n"+(f.length()/1024)+" KB\n"+f.getAbsolutePath());t.setTextSize(14);row.addView(t,new LinearLayout.LayoutParams(0,-2,1));MaterialButton share=actionButton("Share",false);row.addView(share);share.setOnClickListener(v->shareServiceFile(f));box.addView(row);}
        ScrollView sc=new ScrollView(this);sc.setFillViewport(true);sc.addView(box);new AlertDialog.Builder(this).setTitle("Service Files").setView(sc).setPositiveButton("Close",null).show();
    }

    private void shareServiceFile(File f){try{android.net.Uri uri=androidx.core.content.FileProvider.getUriForFile(this,getPackageName()+".fileprovider",f);Intent i=new Intent(Intent.ACTION_SEND);i.setType("application/octet-stream");i.putExtra(Intent.EXTRA_STREAM,uri);i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);startActivity(Intent.createChooser(i,"Share service file"));}catch(Exception e){Toast.makeText(this,"Share failed: "+safeMessage(e),Toast.LENGTH_LONG).show();}}

    private javax.crypto.SecretKey serviceKey(String token) throws Exception {
        byte[] salt="SenseiTunnelServiceFileV2".getBytes(java.nio.charset.StandardCharsets.UTF_8); javax.crypto.SecretKeyFactory f=javax.crypto.SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); javax.crypto.spec.PBEKeySpec spec=new javax.crypto.spec.PBEKeySpec(token.toCharArray(),salt,120000,256); byte[] k=f.generateSecret(spec).getEncoded(); return new javax.crypto.spec.SecretKeySpec(k,"AES");
    }

    private void showServiceContentPicker(TextView label, final JSONObject[] server, final JSONObject[] config, final JSONObject[] payload){
        LinearLayout box=verticalBox();
        MaterialButton s=actionButton("▣ Select OpenVPN Server",false); MaterialButton c=actionButton("⚡ Select V2Ray/Xray Config",false); MaterialButton p=actionButton("▱ Select Payload",false); TextView state=new TextView(this);state.setText("Choose any combination. You may create server only, payload only, config only, or server + payload.");box.addView(state);box.addView(s);box.addView(c);box.addView(p);
        s.setOnClickListener(v->{LinearLayout b=verticalBox();JSONArray a=profiles(KEY_OVPN_PROFILES);for(int i=0;i<a.length();i++){JSONObject q=a.optJSONObject(i);if(q==null)continue;MaterialButton x=actionButton(q.optString("name","Server")+"\n"+q.optString("country",getCountryName()),false);b.addView(x);final JSONObject qq=q;x.setOnClickListener(z->{server[0]=qq; config[0]=null; state.setText("Server: "+qq.optString("name","Server")+"\nPayload: "+(payload[0]==null?"none":payload[0].optString("name","Payload")));});}new AlertDialog.Builder(this).setTitle("Select OpenVPN Server").setView(new ScrollView(this){{setFillViewport(true);addView(b);}}).setPositiveButton("Close",null).show();});
        c.setOnClickListener(v->{LinearLayout b=verticalBox();JSONArray a=profiles(KEY_V2RAY_PROFILES);for(int i=0;i<a.length();i++){JSONObject q=a.optJSONObject(i);if(q==null)continue;MaterialButton x=actionButton(q.optString("name","Config"),false);b.addView(x);final JSONObject qq=q;x.setOnClickListener(z->{config[0]=qq; server[0]=null; state.setText("Config: "+qq.optString("name","Config")+"\nPayload: "+(payload[0]==null?"none":payload[0].optString("name","Payload")));});}new AlertDialog.Builder(this).setTitle("Select V2Ray/Xray Config").setView(new ScrollView(this){{setFillViewport(true);addView(b);}}).setPositiveButton("Close",null).show();});
        p.setOnClickListener(v->{LinearLayout b=verticalBox();JSONArray a=payloads();for(int i=0;i<a.length();i++){JSONObject q=a.optJSONObject(i);if(q==null)continue;MaterialButton x=actionButton(q.optString("name","Payload")+"\n"+q.optString("type","None"),false);b.addView(x);final JSONObject qq=q;x.setOnClickListener(z->{payload[0]=qq;state.setText("Payload: "+qq.optString("name","Payload")+"\nServer: "+payloadServerLabel(qq));});}new AlertDialog.Builder(this).setTitle("Select Payload").setView(new ScrollView(this){{setFillViewport(true);addView(b);}}).setPositiveButton("Close",null).show();});
        new AlertDialog.Builder(this).setTitle("Service File Content").setView(box).setPositiveButton("Done",(d,w)->label.setText((server[0]!=null?"Server: "+server[0].optString("name","Server")+" ":"")+(config[0]!=null?"Config: "+config[0].optString("name","Config")+" ":"")+(payload[0]!=null?"Payload: "+payload[0].optString("name","Payload"):""))).show();
    }

    private void showConfigPicker(TextView label){
        LinearLayout box=verticalBox(); JSONArray a=profiles(isOpenVpnSelected?KEY_OVPN_PROFILES:KEY_V2RAY_PROFILES);
        for(int i=0;i<a.length();i++){JSONObject p=a.optJSONObject(i);if(p==null||!isProfileAllowed(p))continue;final int idx=i;MaterialButton b=actionButton(p.optString("name","Config")+"\n"+p.optString("country",getCountryName()),false);box.addView(b);b.setOnClickListener(v->{selectedProfile=idx;prefs.edit().putInt(isOpenVpnSelected?KEY_SELECTED_OVPN:KEY_SELECTED_V2,idx).apply();label.setText("Config: "+p.optString("name","Config"));});}
        ScrollView sc=new ScrollView(this);sc.addView(box);new AlertDialog.Builder(this).setTitle("Select Config").setView(sc).setPositiveButton("Close",null).show();
    }

    private void showAppPicker(final JSONArray current){
        final List<String> pkgs=new ArrayList<>(); final List<String> labels=new ArrayList<>();
        android.content.pm.PackageManager pm=getPackageManager(); for(android.content.pm.ApplicationInfo ai:pm.getInstalledApplications(android.content.pm.PackageManager.GET_META_DATA)){if(ai.packageName.equals(getPackageName()))continue;CharSequence l=pm.getApplicationLabel(ai);pkgs.add(ai.packageName);labels.add((l==null?ai.packageName:l.toString())+"\n"+ai.packageName);}
        boolean[] checked=new boolean[pkgs.size()]; for(int i=0;i<pkgs.size();i++)for(int j=0;j<current.length();j++)if(pkgs.get(i).equals(current.optString(j)))checked[i]=true;
        new AlertDialog.Builder(this).setTitle("Apps allowed through VPN").setMultiChoiceItems(labels.toArray(new String[0]),checked,(d,which,isChecked)->checked[which]=isChecked).setPositiveButton("Save",(d,w)->{try{for(int z=current.length()-1;z>=0;z--)current.remove(z);for(int i=0;i<pkgs.size();i++)if(checked[i])current.put(pkgs.get(i));Toast.makeText(this,"App access list saved",Toast.LENGTH_SHORT).show();}catch(Exception ignored){}}).setNegativeButton("Cancel",null).show();
    }

    private void showLockedFiles() {
        File dir=new File(getFilesDir(),"locked_files"); if(!dir.exists())dir.mkdirs(); File[] fs=dir.listFiles();
        LinearLayout box=verticalBox(); if(fs==null||fs.length==0){TextView e=new TextView(this);e.setText("No locked files.");box.addView(e);} else for(File f:fs){MaterialButton b=actionButton("🔐 "+f.getName(),false);box.addView(b);b.setOnClickListener(v->unlockAndPreview(f));}
        new AlertDialog.Builder(this).setTitle("Locked Files • "+(fs==null?0:fs.length)).setView(box).setPositiveButton("Close",null).show();
    }

    private void lockSelectedUri(Uri uri) {
        try { String name=getDisplayName(uri); if(name==null||name.trim().isEmpty())name="file"; File dir=new File(getFilesDir(),"locked_files");dir.mkdirs();File out=new File(dir,java.util.UUID.randomUUID().toString()+".senseilock");
            javax.crypto.SecretKey key=FileLocker.getOrCreateKey(); byte[] iv=new byte[12];new java.security.SecureRandom().nextBytes(iv);javax.crypto.Cipher c=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");c.init(javax.crypto.Cipher.ENCRYPT_MODE,key,new javax.crypto.spec.GCMParameterSpec(128,iv));
            try(InputStream in=getContentResolver().openInputStream(uri);FileOutputStream fos=new FileOutputStream(out)){fos.write(iv);javax.crypto.CipherOutputStream cos=new javax.crypto.CipherOutputStream(fos,c);byte[] buf=new byte[8192];int n;while((n=in.read(buf))!=-1)cos.write(buf,0,n);cos.close();}
            prefs.edit().putString("lockname_"+out.getName(),name).apply();Toast.makeText(this,"File locked: "+name,Toast.LENGTH_LONG).show();
        } catch(Exception e){Toast.makeText(this,"Lock failed: "+safeMessage(e),Toast.LENGTH_LONG).show();}
    }

    private void unlockAndPreview(File f) {
        try { byte[] all; try(FileInputStream fis=new FileInputStream(f); ByteArrayOutputStream bos=new ByteArrayOutputStream()){byte[] b=new byte[8192];int n;while((n=fis.read(b))!=-1)bos.write(b,0,n);all=bos.toByteArray();} if(all.length<13)throw new IllegalArgumentException("Invalid locked file");byte[] iv=java.util.Arrays.copyOfRange(all,0,12);javax.crypto.Cipher c=javax.crypto.Cipher.getInstance("AES/GCM/NoPadding");c.init(javax.crypto.Cipher.DECRYPT_MODE,FileLocker.getOrCreateKey(),new javax.crypto.spec.GCMParameterSpec(128,iv));byte[] plain=c.doFinal(all,12,all.length-12);String original=prefs.getString("lockname_"+f.getName(),f.getName());String lower=original.toLowerCase(java.util.Locale.US);if(lower.endsWith(".txt")||lower.endsWith(".json")||lower.endsWith(".ovpn")||lower.endsWith(".conf")){String text=new String(plain,java.nio.charset.StandardCharsets.UTF_8);EditText e=edit(original,text);e.setGravity(Gravity.TOP|Gravity.START);e.setMinLines(14);new AlertDialog.Builder(this).setTitle("Unlocked • "+original).setView(e).setPositiveButton("Close",null).show();} else if(lower.endsWith(".jpg")||lower.endsWith(".jpeg")||lower.endsWith(".png")){android.graphics.Bitmap bmp=android.graphics.BitmapFactory.decodeByteArray(plain,0,plain.length);android.widget.ImageView ivw=new android.widget.ImageView(this);ivw.setImageBitmap(bmp);ivw.setAdjustViewBounds(true);new AlertDialog.Builder(this).setTitle("Unlocked • "+original).setView(ivw).setPositiveButton("Close",null).show();} else Toast.makeText(this,"Encrypted file opened only inside Sensei Tunnel. Preview for this file type is not implemented.",Toast.LENGTH_LONG).show();}
        catch(Exception e){Toast.makeText(this,"Unlock failed: "+safeMessage(e),Toast.LENGTH_LONG).show();}
    }

    private int parseInt(String value, int fallback){
        try { return Integer.parseInt(value == null ? "" : value.trim()); }
        catch (Exception ignored) { return fallback; }
    }

    private String safeMessage(Exception e){Throwable t=e;while(t.getCause()!=null)t=t.getCause();return t.getMessage()==null?t.getClass().getSimpleName():t.getMessage();}
    private int dp(int v){return Math.round(v*getResources().getDisplayMetrics().density);}

    @Override protected void onDestroy(){ if(receiverRegistered){try{unregisterReceiver(xrayReceiver);}catch(Exception ignored){}} if(bongoVpn!=null)bongoVpn.release(); super.onDestroy(); }
}
