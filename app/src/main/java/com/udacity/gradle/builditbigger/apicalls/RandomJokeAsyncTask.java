package com.udacity.gradle.builditbigger.apicalls;

import android.os.AsyncTask;

import com.serloman.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;

/**
 * Created by Serloman on 12/08/2015.
 */
public class RandomJokeAsyncTask extends AsyncTask<Void, Void, Joke> {

    private JokeListener mListener;

    public RandomJokeAsyncTask(JokeListener listener){
        this.mListener = listener;
    }

    @Override
    protected Joke doInBackground(Void... params) {

        try {
            return ApiInit.getInstance().getRandomJoke().execute();
        } catch (IOException e) {
            mListener.onError(e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Joke joke) {
        if(joke!=null)
            mListener.onJokeReceived(joke);
    }
}