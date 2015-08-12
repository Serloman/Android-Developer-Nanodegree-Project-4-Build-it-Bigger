package com.udacity.gradle.builditbigger.apicalls;

import com.serloman.builditbigger.backend.myApi.model.Joke;

/**
 * Created by Serloman on 12/08/2015.
 */
public interface JokeListener {
    void onJokeReceived(Joke joke);
    void onError(Exception ex);
}
