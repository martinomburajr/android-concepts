package com.martinomburajr.concepts.backgroundtasks.jobscheduler;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.martinomburajr.concepts.R;

public class JobSchedulerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_scheduler);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void showNotificationEvery30s(View view) {
        JobSchedulerTutorial.scheduleNotificationEvery30s(this);
    }

    public void showNotification30sAfterCharge(View view) {
        JobSchedulerTutorial.scheduleNotificationOnPowerPluggedIn(this);
    }
}
