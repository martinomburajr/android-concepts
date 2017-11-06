package com.martinomburajr.concepts.threading.loaders.asynctaskloader.samples;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.martinomburajr.concepts.threading.loaders.asynctaskloader.retrofitapi.RetrofitWikipediaAPI;
import com.martinomburajr.concepts.threading.loaders.asynctaskloader.retrofitapi.WikipediaModel;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by User on 11/6/2017.
 */

public class WikipediaAsyncTaskLoader extends AsyncTaskLoader<Object> {
    public static String TAG = "WikiAsyncTaskLoader";
    public String mSearchText = "";
    public WikipediaModel wikipediaModel;
    public WikipediaAsyncTaskLoader(Context context, String searchText) {
        super(context);
        mSearchText = searchText;
        wikipediaModel = new WikipediaModel();
    }

    public WikipediaAsyncTaskLoader(Context context) {
        super(context);
        mSearchText = "";
        wikipediaModel = new WikipediaModel();
    }

    @Override
    public Observable<WikipediaModel> loadInBackground() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org/w/api.php?")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RetrofitWikipediaAPI  wikipediaAPI = retrofit.create(RetrofitWikipediaAPI.class);
        return wikipediaAPI.getSearch(mSearchText);
    }

    @Override
    public void deliverResult(Object data) {
        super.deliverResult(data);
    }
}
