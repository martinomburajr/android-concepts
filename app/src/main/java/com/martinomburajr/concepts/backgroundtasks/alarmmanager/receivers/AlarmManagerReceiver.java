package com.martinomburajr.concepts.backgroundtasks.alarmmanager.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.martinomburajr.concepts.notifications.NotificationTutorial;

public class AlarmManagerReceiver extends BroadcastReceiver {

    public AlarmManagerReceiver() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationTutorial notificationTutorial = new NotificationTutorial(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationTutorial.notificationWChannelWAlertsWStyleO();
        }else{
            notificationTutorial.notificationWChannelWAlertsWStyle();
        }
        Toast.makeText(context,"Here is your notification",Toast.LENGTH_LONG);
    }
}
