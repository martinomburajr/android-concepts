package com.martinomburajr.concepts.backgroundtasks.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.martinomburajr.concepts.backgroundtasks.jobscheduler.service.JobSchedulerOnChargedService;
import com.martinomburajr.concepts.backgroundtasks.jobscheduler.service.JobSchedulerService;

/**
 * Created by User on 11/3/2017.
 */

public class JobSchedulerTutorial {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void scheduleNotificationEvery30s(Context context) {
        ComponentName serviceComponent = new ComponentName(context, JobSchedulerService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0,serviceComponent);
        builder.setMinimumLatency(3 * 1000);
        builder.setOverrideDeadline(15 * 1000);


        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void scheduleNotificationOnPowerPluggedIn(Context context) {
        int jobid = 4432;
        ComponentName serviceComponent = new ComponentName(context, JobSchedulerOnChargedService.class);
        JobInfo.Builder jobInfo = new JobInfo.Builder(jobid,serviceComponent);
        jobInfo.setRequiresCharging(true);
        jobInfo.setPeriodic(14000);

        JobScheduler jobScheduler = (JobScheduler)context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(jobInfo.build());
    }
}
