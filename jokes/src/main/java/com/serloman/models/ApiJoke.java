package com.serloman.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serloman on 12/08/2015.
 */
public class ApiJoke implements Joke{
    int id;
    String joke;
    List<String> categories;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getJoke() {
        return joke;
    }

    @Override
    public List<String> getCategories() {
        if(categories==null)
            return new ArrayList<>();

        return categories;
    }
}
