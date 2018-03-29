package com.ryandro.broadcastreceiverdemo;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    String ACTION = "TestBraodCast";

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("My broadrCast", "call custome broad cast");
            Toast.makeText(context, "call custome broad cast", Toast.LENGTH_LONG).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_BroadCast = (Button) findViewById(R.id.btn_BroadCast);
        btn_BroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sendBroadcast(new Intent(ACTION));
                setAlarm();
            }

        });


    }

    private void setAlarm() {
        EditText editText = (EditText) findViewById(R.id.et_time);
        String strTime = editText.getText().toString();
        if (strTime != null && !strTime.equalsIgnoreCase("")) {
            int time = Integer.parseInt(strTime);
            Intent intent = new Intent(MainActivity.this, MyAlarmBroadCastReciver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1234512345, intent, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                    + (time * 1000), pendingIntent);
            Toast.makeText(MainActivity.this, "Alarm set in " + time + " seconds.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(broadcastReceiver, new IntentFilter(ACTION));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
