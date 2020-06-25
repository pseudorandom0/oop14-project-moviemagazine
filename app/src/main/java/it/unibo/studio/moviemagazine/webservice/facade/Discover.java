package it.unibo.studio.moviemagazine.webservice.facade;

import java.util.Map;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListWrapper;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Interface for exploring tmdb and filter results
 */
public interface    Discover{

    /**
     * Method for browsing and filtering movies
     * @param page the page to be loaded
     * @param filters the filters to apply
     * @param sortBy how the movies should be sorted
     * @return the call to enqueue for loading the movies with given parameters
     */
    @GET(Constants.APIMethods.DISCOVER_MOVIES)
    Call<MovieListWrapper> discoverMovies(@Query(Constants.APIParameters.PAGE) int page, @QueryMap Map<String,String> filters, @Query(Constants.APIParameters.SORT_BY) String sortBy);
}
