package com.martinomburajr.concepts.backgroundtasks.jobscheduler.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.martinomburajr.concepts.backgroundtasks.jobscheduler.JobSchedulerTutorial;

/**
 * Created by User on 11/3/2017.
 */

public class MyJobSchedulerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            JobSchedulerTutorial.scheduleNotificationEvery30s(context);
        }
    }
}
