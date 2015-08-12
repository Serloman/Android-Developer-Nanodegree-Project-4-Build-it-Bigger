package com.udacity.gradle.builditbigger.apicalls;

import android.os.AsyncTask;

import com.serloman.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;
import java.util.List;

/**
 * Created by Serloman on 12/08/2015.
 */
public class MultipleRandomJokesAsyncTask extends AsyncTask<Integer, Void, List<Joke>> {

    private JokesListener mListener;

    public MultipleRandomJokesAsyncTask(JokesListener listener){
        this.mListener = listener;
    }

    @Override
    protected List<Joke> doInBackground(Integer... params) {
        int limit = params[0];

        try {
            return ApiInit.getInstance().getMultipleRandomJokes(limit).execute().getItems();
        } catch (IOException e) {
            mListener.onError(e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Joke> jokes) {
        if(jokes!=null)
            mListener.onJokesReceived(jokes);
    }
}