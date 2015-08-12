package com.serloman.models;

import java.util.List;

/**
 * Created by Serloman on 11/08/2015.
 */
public class SimpleJoke implements Joke {
    private int mId;
    private String mJoke;
    private List<String> mCategories;

    public SimpleJoke(Joke joke){
        this(joke.getId(), joke.getJoke(), joke.getCategories());
    }

    public SimpleJoke(int id, String joke,List<String> categories){
        this.mId = id;
        this.mJoke = joke;
        this.mCategories = categories;
    }

    @Override
    public int getId() {
        return mId;
    }

    @Override
    public String getJoke() {
        return mJoke;
    }

    @Override
    public List<String> getCategories() {
        return mCategories;
    }
}