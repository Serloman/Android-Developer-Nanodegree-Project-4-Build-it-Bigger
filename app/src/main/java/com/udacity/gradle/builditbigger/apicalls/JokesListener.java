package com.udacity.gradle.builditbigger.apicalls;

import com.serloman.builditbigger.backend.myApi.model.Joke;

import java.util.List;

/**
 * Created by Serloman on 12/08/2015.
 */
public interface JokesListener {
    void onJokesReceived(List<Joke> jokes);
    void onError(Exception ex);
}
