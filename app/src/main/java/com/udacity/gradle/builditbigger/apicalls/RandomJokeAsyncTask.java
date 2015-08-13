package com.udacity.gradle.builditbigger.apicalls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import com.serloman.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;

/**
 * Created by Serloman on 12/08/2015.
 */
public class RandomJokeAsyncTask extends AsyncTask<Void, Void, Joke> {

    private Context mContext;
    private JokeListener mListener;
    private Exception mEx;

    public RandomJokeAsyncTask(Context context, JokeListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    protected Joke doInBackground(Void... params) {

        try {
            checkNetwork();
            return ApiInit.getInstance().getRandomJoke().execute();
        } catch (IOException e) {
            mEx = e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(Joke joke) {
        if(joke!=null)
            mListener.onJokeReceived(joke);
        else
            mListener.onError(mEx);
    }

    private void checkNetwork() throws IOException {
        ConnectivityManager manager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);;
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(!(networkInfo!=null && networkInfo.isConnected() && networkInfo.isAvailable()))
            throw new IOException("Network not available");
    }
}