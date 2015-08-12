package com.serloman.models;

import java.util.List;

/**
 * Created by Serloman on 11/08/2015.
 */
public interface Joke {
    int getId();
    String getJoke();
    List<String> getCategories();
}
