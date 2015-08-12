/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.serloman.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.serloman.models.Joke;
import com.serloman.ChuckNorrisJokesProvider;

import java.util.List;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.serloman.com",
                ownerName = "backend.builditbigger.serloman.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        Joke joke = getRandomJoke();

        MyBean response = new MyBean();
        response.setData("Lol Hi, " + name + " " + joke.getJoke());

        return response;
    }

    @ApiMethod(name = "getRandomJoke")
    public Joke getRandomJoke(){
        ChuckNorrisJokesProvider jokesProvider = new ChuckNorrisJokesProvider();

        return jokesProvider.getRandomJoke();
    }

    @ApiMethod(name = "getJoke")
    public Joke getJoke(@Named("id")int id){
        ChuckNorrisJokesProvider jokesProvider = new ChuckNorrisJokesProvider();

        return jokesProvider.getRandomJoke();
    }

    @ApiMethod(name = "getMultipleRandomJokes")
    public List<Joke> getMultipleRandomJokes(@Named("limit") int limit){
        ChuckNorrisJokesProvider jokesProvider = new ChuckNorrisJokesProvider();

        return jokesProvider.getMultipleRandomJokes(limit);
    }

}
