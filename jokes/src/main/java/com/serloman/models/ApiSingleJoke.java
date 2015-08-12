package com.serloman.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serloman on 12/08/2015.
 */
public class ApiSingleJoke implements SingleJoke {
    String type;
    ApiJoke value;

    @Override
    public boolean isValid() {
        return type.compareTo("success")==0;
    }

    @Override
    public Joke getJoke() {
        return value;
    }


}
