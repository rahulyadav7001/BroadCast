package com.ryandro.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by WIN 1O on 27-03-2018.
 */

public class MyAlarmBroadCastReciver extends BroadcastReceiver{
    MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
//        mediaPlayer = MediaPlayer.create(context,)
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }
}
