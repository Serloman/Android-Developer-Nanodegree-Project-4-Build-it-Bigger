package com.serloman.jokesui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jokesui.R;
import com.serloman.builditbigger.backend.myApi.model.Joke;

public class JokeActivity extends AppCompatActivity {

    public final static String ARG_JOKE = "ARG_JOKE";

    public static Intent newIntent(Context context, Joke joke){
        return newIntent(context, new ParcelableJoke(joke));
    }

    public static Intent newIntent(Context context, ParcelableJoke joke){
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(ARG_JOKE, joke);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.joke_activity);

        if(savedInstanceState==null)
            initJokeFragment();
    }

    private void initJokeFragment(){
        ParcelableJoke joke = getJoke();
        JokeFragment fragment = JokeFragment.newInstance(joke);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private ParcelableJoke getJoke(){
        return getIntent().getExtras().getParcelable(ARG_JOKE);
    }
}
