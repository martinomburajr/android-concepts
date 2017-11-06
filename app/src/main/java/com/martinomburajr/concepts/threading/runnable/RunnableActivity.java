package com.martinomburajr.concepts.threading.runnable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.martinomburajr.concepts.R;

public class RunnableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runnable);
    }

    public void onSimpleRunnable(View view){
        RunnableTutorial.simpleRunnable(this);
    }
}
