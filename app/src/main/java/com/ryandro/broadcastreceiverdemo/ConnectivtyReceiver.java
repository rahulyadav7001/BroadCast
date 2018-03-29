package com.ryandro.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by WIN 1O on 28-03-2018.
 */

public class ConnectivtyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnected();
        boolean isWifi = activeNetwork != null && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        boolean isMobileNetwork = activeNetwork != null && activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;

//        boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        if (isConnected && isWifi) {
            Toast.makeText(context, "Wifi Connection is available", Toast.LENGTH_LONG).show();
            Log.d("Connectivity Receiver","Wifi Connection is available");
        } else if (isConnected && isMobileNetwork) {
            Toast.makeText(context, "Mobile data Connection is available", Toast.LENGTH_LONG).show();
            Log.d("Connectivity Receiver","Mobile data  Connection is available");
        } else {
            Toast.makeText(context, "Oops! Connection is lost", Toast.LENGTH_LONG).show();
            Log.d("Connectivity Receiver","Oops! Connection is lost");
        }
    }
}
