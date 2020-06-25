package it.unibo.studio.moviemagazine.webservice.facade;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface for requesting trending movies
 */
public interface Movies{

    /**
     * Loads the movies actually in cinemas
     * @param page of movies to load
     * @return
     */
    @GET(Constants.APIMethods.MOVIES_NOW_PLAYING)
    Call<MovieListWrapper> getNowPlaying(@Query(Constants.APIParameters.PAGE) int page);

    /**
     * Loads the popular movies
     * @param page of movies to load
     * @return
     */
    @GET(Constants.APIMethods.MOVIES_POPULAR)
    Call<MovieListWrapper> getPopular(@Query(Constants.APIParameters.PAGE) int page);

    /**
     * Loads the community top rated movies
     * @param page of movies to load
     * @return
     */
    @GET(Constants.APIMethods.MOVIES_TOP_RATED)
    Call<MovieListWrapper> getTopRated(@Query(Constants.APIParameters.PAGE) int page);

    /**
     * Loads the upcoming movies
     * @param page of movies to load
     * @return
     */
    @GET(Constants.APIMethods.MOVIES_UPCOMING)
    Call<MovieListWrapper> getUpcoming(@Query(Constants.APIParameters.PAGE) int page);


}
