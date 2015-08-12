package com.serloman;

import com.serloman.models.ApiJokesBatch;
import com.serloman.models.ApiSingleJoke;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Serloman on 12/08/2015.
 */
public interface ChuckNorrisJokesService {
    @GET("/jokes")
    ApiJokesBatch getAllJokes();

    @GET("/jokes/{id}")
    ApiSingleJoke getJoke(@Path("id") int id);

    @GET("/jokes/random")
    ApiSingleJoke getRandomJoke();

    @GET("/jokes/random/{limit}")
    ApiJokesBatch getMultipleRandomJokes(@Path("limit") int limit);
}
