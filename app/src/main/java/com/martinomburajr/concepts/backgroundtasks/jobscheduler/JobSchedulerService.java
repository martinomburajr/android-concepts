package com.martinomburajr.concepts.backgroundtasks.jobscheduler;

import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.martinomburajr.concepts.R;
import com.martinomburajr.concepts.backgroundtasks.jobscheduler.asynctask.JobSchedulerMyAsyncTask;

/**
 * Created by User on 11/3/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerService extends JobService {
    private static final String TAG = "SyncService";
    private Context mContext;
    public JobSchedulerService(Context context) {
        mContext = context;
    }

    public JobSchedulerService() {

    }

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {
        JobSchedulerMyAsyncTask myAsyncTask = new JobSchedulerMyAsyncTask(5) {
            @Override
            protected void onPostExecute(Boolean success) {
                super.onPostExecute(success);
                if(success) {
                    jobFinished(jobParameters,success);
                }
            }
        };
        myAsyncTask.execute(this);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        NotificationManager notificationManager = (NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(mContext,"1");
        notification.setContentTitle("Job Failure");
        notification.setContentText("Failed to execute the job, parameters not met");
        notification.setSmallIcon(R.drawable.ic_menu_slideshow);
        notificationManager.notify(12,notification.build());
        return true;
    }
}
