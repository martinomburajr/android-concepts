package com.martinomburajr.concepts.threading.loaders.asynctaskloader.retrofitapi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by User on 11/6/2017.
 */

public interface RetrofitWikipediaAPI {
    @GET("action=wbsearchentities&search={searchQuery}&language=en&limit=1")
    Observable<WikipediaModel> getSearch(@Path("searchQuery") String searchQuery);
}
