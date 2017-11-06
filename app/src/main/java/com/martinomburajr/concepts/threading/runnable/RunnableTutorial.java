package com.martinomburajr.concepts.threading.runnable;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by martinomburajr on 11/4/17.
 */

public class RunnableTutorial {
    public static void simpleRunnable(Context context) {
        Runnable r = () -> {
            try {
                Toast.makeText(context, "Starting runnable", Toast.LENGTH_SHORT).show();
                android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                Log.i("simpleRunnable: ", Thread.currentThread().getName());
                Thread.sleep(1600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        r.run();
    }
}
