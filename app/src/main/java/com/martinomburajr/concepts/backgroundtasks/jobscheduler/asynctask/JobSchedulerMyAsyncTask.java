package com.martinomburajr.concepts.backgroundtasks.jobscheduler.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import com.martinomburajr.concepts.notifications.NotificationTutorial;

/**
 * Created by User on 11/3/2017.
 */

public class JobSchedulerMyAsyncTask extends AsyncTask<Context, Context, Boolean> {
    int mSleepTime;
    public JobSchedulerMyAsyncTask(int sleepTime) {
        mSleepTime = sleepTime;
    }

    @Override
    protected Boolean doInBackground(Context... contexts) {
        try {
            Thread.sleep(mSleepTime*1000);
            NotificationTutorial notificationTutorial = new NotificationTutorial(contexts[0]);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationTutorial.notificationWChannelWAlertsWStyleO();
                return true;
            }else{
                notificationTutorial.notificationWChannelWAlertsWStyle();
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean success) {
        super.onPostExecute(success);
        if(success) {

        }
    }
}
