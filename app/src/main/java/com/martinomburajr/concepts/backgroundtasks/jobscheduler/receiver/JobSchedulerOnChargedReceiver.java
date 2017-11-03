package com.martinomburajr.concepts.backgroundtasks.jobscheduler.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.martinomburajr.concepts.backgroundtasks.jobscheduler.JobSchedulerTutorial;

/**
 * Created by martinomburajr on 11/3/2017.
 */

public class JobSchedulerOnChargedReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onReceive(Context context, Intent intent) {
        String string = intent.getDataString();
        JobSchedulerTutorial.scheduleNotificationOnPowerPluggedIn(context);
    }
}
