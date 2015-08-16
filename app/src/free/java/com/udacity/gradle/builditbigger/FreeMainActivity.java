package com.udacity.gradle.builditbigger;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.serloman.builditbigger.backend.myApi.model.Joke;
import com.serloman.jokesui.JokeActivity;

/**
 * Created by Serloman on 16/08/2015.
 * Example from https://developers.google.com/admob/android/interstitial
 */
public class FreeMainActivity extends MainActivity{
    InterstitialAd mInterstitialAd;
    Joke mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();

                freeOpenJoke();
            }
        });

        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    protected void openJoke(Joke joke) {
        mJoke = joke;

        hideLoading();

        if (mInterstitialAd.isLoaded())
            mInterstitialAd.show();
    }

    private void freeOpenJoke(){
        if(mJoke!=null)
            startActivity(JokeActivity.newIntent(this, mJoke));
    }
}
