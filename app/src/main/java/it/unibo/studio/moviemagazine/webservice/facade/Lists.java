package it.unibo.studio.moviemagazine.webservice.facade;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBMovieList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Interface for loading detailed {@link TMDBMovieList}
 */
public interface Lists{

    /**
     * Get a list by id
     * @param id id of the list
     * @return the movie list requested
     */
    @GET(Constants.APIMethods.LIST_BY_ID)
    Call<TMDBMovieList> getListById(@Path(Constants.APIParameters.ID) String id);
}
