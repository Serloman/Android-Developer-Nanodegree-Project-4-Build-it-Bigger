package com.serloman;

import com.serloman.models.ApiJokesBatch;
import com.serloman.models.Joke;
import com.serloman.models.SingleJoke;

import java.util.List;

import retrofit.RestAdapter;

public class ChuckNorrisJokesProvider {

    private static final String API_ENDPOINT = "http://api.icndb.com";

    private RestAdapter mRestAdapter;
    private ChuckNorrisJokesService mService;

    public ChuckNorrisJokesProvider(){
        mRestAdapter = new RestAdapter.Builder().setEndpoint(API_ENDPOINT).build();
        mService = mRestAdapter.create(ChuckNorrisJokesService.class);
    }

    public Joke getJoke(int idJoke){
        SingleJoke singleJoke = this.mService.getJoke(idJoke);
        return singleJoke.getJoke();
    }

    public Joke getRandomJoke(){
        SingleJoke singleJoke = this.mService.getRandomJoke();
        return singleJoke.getJoke();
    }

    public List<Joke> getMultipleRandomJokes(int limit){
        ApiJokesBatch batch = mService.getMultipleRandomJokes(limit);
        return batch.getJokes();
    }
}
