package com.serloman.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serloman on 12/08/2015.
 */
public class ApiJokesBatch implements JokesBatch{
    List<ApiJoke> value;
    String type;

    @Override
    public boolean isValid() {
        return type.compareTo("success")==0;
    }

    @Override
    public List<Joke> getJokes() {
        List<Joke> jokes = new ArrayList<>();

        for(ApiJoke joke : value)
            jokes.add(joke);

        return jokes;
    }

    public List<ApiJoke> getApiJokes(){
        return value;
    }
}
