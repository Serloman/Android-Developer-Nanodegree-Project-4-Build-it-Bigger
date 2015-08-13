package com.udacity.gradle.builditbigger.apicalls;

import android.test.InstrumentationTestCase;

import com.serloman.builditbigger.backend.myApi.model.Joke;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Serloman on 13/08/2015.
 */
public class RandomJokeAsyncTaskTest extends InstrumentationTestCase implements JokeListener{

    private CountDownLatch mSignal;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mSignal = new CountDownLatch(1);
    }

    public void testRandomJoke() throws Throwable {
        final RandomJokeAsyncTask mRandomJoke = new RandomJokeAsyncTask(this.getInstrumentation().getTargetContext(), this);

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                executeTask(mRandomJoke);
            }
        });
    }

    private void executeTask(RandomJokeAsyncTask task){
        task.execute();

        try {
            mSignal.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
            fail();
        }
    }

    @Override
    public void onJokeReceived(Joke joke) {
        assertNotNull(joke);
        assertNotNull(joke.getJoke());

        if(joke!=null)
            assertEquals(false, joke.getJoke().compareTo("")==0);

        mSignal.countDown();
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
        fail();

    }
}