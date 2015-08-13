package com.udacity.gradle.builditbigger.apicalls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import com.serloman.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;
import java.util.List;

/**
 * Created by Serloman on 12/08/2015.
 */
public class MultipleRandomJokesAsyncTask extends AsyncTask<Integer, Void, List<Joke>> {

    private Context mContext;
    private JokesListener mListener;
    private Exception mEx;

    public MultipleRandomJokesAsyncTask(Context context, JokesListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    protected List<Joke> doInBackground(Integer... params) {
        int limit = params[0];

        try {
            checkNetwork();
            return ApiInit.getInstance().getMultipleRandomJokes(limit).execute().getItems();
        } catch (IOException e) {
            mEx = e;
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Joke> jokes) {
        if(jokes!=null)
            mListener.onJokesReceived(jokes);
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