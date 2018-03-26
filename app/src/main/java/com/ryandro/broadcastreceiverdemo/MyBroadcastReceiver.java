package com.ryandro.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by WIN 1O on 27-03-2018.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BroadCast Receiver","On Received Method Invoked");
        Toast.makeText(context,"Broadcast Receiver Invoked",Toast.LENGTH_LONG).show();
    }
}
