package com.martinomburajr.concepts.backgroundtasks.alarmmanager;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.martinomburajr.concepts.R;

public class AlarmManagerActivity extends AppCompatActivity {

    private AlarmManagerTutorial alarmManagerTutorial = new AlarmManagerTutorial();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void showNotificationIn15s(View view) {
        alarmManagerTutorial.displayNotificationIn15s(this);
    }

    public void showNotificationat245Everyday(View view) {
        alarmManagerTutorial.displayNotificationAt245Everyday(this);
    }

    public void showNotificationEvery2Min(View view) {
        alarmManagerTutorial.displayNotificationEvery2Min(this);
    }
}
