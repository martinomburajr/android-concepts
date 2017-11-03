package com.martinomburajr.concepts.notifications;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.martinomburajr.concepts.R;

public class NotificationActivity extends AppCompatActivity {

    private static final String TAG = "NotificationActivity";
    Button mSimple, mSimpleChannelsAlerts,mSimpleChannelsAlertsStyle;
    NotificationTutorial notificationTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationTutorial = new NotificationTutorial(this);

        mSimple = (Button)findViewById(R.id.notificationActivity_simpleNotification);
        mSimpleChannelsAlerts = (Button)findViewById(R.id.notificationActivity_simpleChannelsAlerts);
        mSimpleChannelsAlertsStyle = (Button)findViewById(R.id.notificationActivity_simpleChannelsAlertsStyle);
    }

    public void showSimple(View view) {
        notificationTutorial.simpleNotification();
    }


    public void showSimpleChannelsAlerts(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationTutorial.simpleNotificationWChannelWAlerts();
        }else{
            Toast.makeText(this,"Requires Android Oreo (API 26+)", Toast.LENGTH_LONG);
        }
    }
    public void showSimpleNotificationWChannelWAlertsWStyle(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationTutorial.notificationWChannelWAlertsWStyleO();
        }else{
            notificationTutorial.notificationWChannelWAlertsWStyle();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showNotificationWIntents(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationTutorial.notificationWIntentsO();
        }else{
            notificationTutorial.notificationWIntents();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showNotificationWInbox(View view){
        notificationTutorial.notificationWInboxStyle();
    }

    public void showNotificationWUpdate(View view) {
        notificationTutorial.notificationWUpdate()
                .take(3)
                .subscribe(v -> {
                    Log.e(TAG,String.valueOf(v));
                });
    }
}
