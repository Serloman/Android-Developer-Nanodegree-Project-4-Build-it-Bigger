package com.serloman.models;

import java.util.List;

/**
 * Created by Serloman on 12/08/2015.
 */
public interface JokesBatch {
    boolean isValid();
    List<Joke> getJokes();
}
