package com.udacity.gradle.builditbigger;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.serloman.builditbigger.backend.myApi.model.Joke;
import com.serloman.jokesui.JokeActivity;
import com.serloman.jokesui.ParcelableJoke;
import com.udacity.gradle.builditbigger.apicalls.JokeListener;
import com.udacity.gradle.builditbigger.apicalls.RandomJokeAsyncTask;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();

        JokeListener listener = new JokeListener() {
            @Override
            public void onJokeReceived(Joke joke) {
                openJoke(joke);
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
                Toast.makeText(getBaseContext(), getString(R.string.error_getting_joke), Toast.LENGTH_SHORT).show();
            }
        };

        RandomJokeAsyncTask task = new RandomJokeAsyncTask(this, listener);
        task.execute();
    }

    private void openJoke(Joke joke){
        startActivity(JokeActivity.newIntent(this, joke));
    }


}
