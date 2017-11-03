package com.martinomburajr.concepts.backgroundtasks.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.martinomburajr.concepts.backgroundtasks.alarmmanager.receivers.AlarmManagerReceiver;

import java.util.Calendar;

/**
 * Created by User on 11/3/2017.
 */

public class AlarmManagerTutorial {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void displayNotificationIn15s(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME,15000, pendingIntent);
    }

    public void displayNotificationEvery2Min(Context context) {
       AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);

       Intent intent = new Intent(context, AlarmManagerReceiver.class);
       PendingIntent pendingIntent = PendingIntent.getBroadcast(context,3,intent, PendingIntent.FLAG_UPDATE_CURRENT);

       //Set the initial delay before the first alarm to 5mins, then call the alarm every 2 mins.
       alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, System.currentTimeMillis() + 1000*60*5, 1000*60*2, pendingIntent);
    }

    public void displayNotificationAt245Everyday(Context context) {
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmManagerReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,2,intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY,14);
        calendar.set(Calendar.MINUTE,2);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
    }

}

