package com.martinomburajr.concepts.threading.loaders.asynctaskloader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.martinomburajr.concepts.R;
import com.martinomburajr.concepts.threading.loaders.asynctaskloader.retrofitapi.WikipediaModel;
import com.martinomburajr.concepts.threading.loaders.asynctaskloader.samples.WikipediaAsyncTaskLoader;

import io.reactivex.Observable;

public class AsyncTaskLoaderActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Observable<WikipediaModel>> {

    private static final String TAG = "AsyncTaskLoader";
    TextView mTextView;
    EditText mEditText;

    LoaderManager loaderManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_loader);

        loaderManager = getLoaderManager();
        mTextView = (TextView)findViewById(R.id.asyncTaskLoaderTutorial_textView);
        mEditText = (EditText)findViewById(R.id.asyncTaskLoaderTutorial_editText);
        if(loaderManager.getLoader(123) != null) {
            loaderManager.initLoader(123,null,this);
        }
    }

    public void loadWikipedia(View view) {
        loaderManager.initLoader(123, null, this);
    }


    @Override
    public Loader<Observable<WikipediaModel>> onCreateLoader(int i, Bundle bundle) {
        String text = mEditText.getText().toString();
        return new WikipediaAsyncTaskLoader(this, text);
    }

    @Override
    public void onLoadFinished(Loader<Observable<WikipediaModel>> loader, Observable<WikipediaModel> wikipediaModelCall$) {
        wikipediaModelCall$.subscribe((WikipediaModel v) -> {
            String s = "";
            Log.e(TAG, "onNext "+ Thread.currentThread().getName());
        }, e -> {
            Log.e(TAG, "onError "+ e.toString() + Thread.currentThread().getName());
        }, () -> {
            Log.e(TAG, "onComplete "+  Thread.currentThread().getName());
        });
    }

    @Override
    public void onLoaderReset(Loader<Observable<WikipediaModel>> loader) {

    }

}
