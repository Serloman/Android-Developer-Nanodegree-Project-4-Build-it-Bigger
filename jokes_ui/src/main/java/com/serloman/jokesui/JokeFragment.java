package com.serloman.jokesui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jokesui.R;
import com.serloman.builditbigger.backend.myApi.model.Joke;

/**
 * Created by Serloman on 11/08/2015.
 */
public class JokeFragment extends Fragment {

    public final static String ARG_JOKE = "ARG_JOKE";

    public static JokeFragment newInstance(ParcelableJoke joke){
        JokeFragment fragment = new JokeFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARG_JOKE, joke);
        fragment.setArguments(args);

        return fragment;
    }

    public JokeFragment() { }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.joke_fragment, container, false);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        initJoke();
    }

    private void initJoke(){
        Joke joke = getJoke();

        TextView jokeTextView = (TextView) getView().findViewById(R.id.jokeTextView);
        jokeTextView.setText(joke.getJoke());
    }

    private Joke getJoke(){
        return getArguments().getParcelable(ARG_JOKE);
    }
}
