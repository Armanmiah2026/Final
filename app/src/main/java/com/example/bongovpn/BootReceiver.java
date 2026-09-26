package com.example.bongovpn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/** Starts the app activity after boot only when the user explicitly enabled Connect on boot. */
public class BootReceiver extends BroadcastReceiver {
    @Override public void onReceive(Context context, Intent intent) {
        if (intent == null || !Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) return;
        SharedPreferences p = context.getSharedPreferences("vpn_profiles", Context.MODE_PRIVATE);
        if (!p.getBoolean("connect_on_boot", false)) return;
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        try { context.startActivity(i); } catch (Exception ignored) { }
    }
}
