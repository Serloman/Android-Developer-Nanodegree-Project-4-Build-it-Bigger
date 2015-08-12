package com.serloman.jokesui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jokesui.R;
import com.serloman.models.Joke;

public class JokeActivity extends AppCompatActivity {

    public final static String ARG_JOKE = "ARG_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.joke_activity);

        if(savedInstanceState==null)
            initJokeFragment();
    }

    private void initJokeFragment(){
        Joke joke = getJoke();
        JokeFragment fragment = JokeFragment.newInstance(joke);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private Joke getJoke(){
        return getIntent().getExtras().getParcelable(ARG_JOKE);
    }
}
