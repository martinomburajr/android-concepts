package com.martinomburajr.concepts.backgroundtasks.jobscheduler.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.martinomburajr.concepts.notifications.NotificationTutorial;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by martinomburajr on 11/3/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerOnChargedService extends JobService {
    private static final String TAG = "JobOnChargedService";

    @Override
    public boolean onStartJob(JobParameters params) {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .map(var -> {
                    NotificationTutorial notificationTutorial = new NotificationTutorial(this);
                    String title = "JobScheduler: OnCharge Job";
                    String text = "The scheduled onCharge job has been completed";
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        notificationTutorial.createNotificationO(this, title,text);
                    }else{
                        notificationTutorial.createNotification(this, title,text);
                    }
                    return var;
                })
                .observeOn(Schedulers.newThread())
                .take(2)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.e(TAG, "onNext: " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete " + Thread.currentThread().getName());
                        jobFinished(params,true);
                    }
                });
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Toast.makeText(this, "Could not perform onCharge job", Toast.LENGTH_LONG);
        return true;
    }
}
