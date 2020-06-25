package it.unibo.studio.moviemagazine.webservice.facade;

import java.util.Map;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.CollectionListWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.PersonListWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Interface for using search methods
 */
public interface Search{

    /*
     * Multi search returns mixed results with movies, people and tv series. At the moment this method will not be used because the tv series are not supported.
     * @param page
     * @param query
     * @return
     */
    /*@GET(Constants.APIMethods.SEARCH_MULTI)
    Call<PersonListWrapper> searchMulti(@Query(Constants.APIParameters.PAGE)int page,
                                              @Query(value = Constants.APIParameters.QUERY, encoded = true) String query);*/

    @GET(Constants.APIMethods.SEARCH_MOVIE)
    Call<MovieListWrapper> searchMovie(@Query(Constants.APIParameters.PAGE) int page,
                                       @Query(value = Constants.APIParameters.QUERY, encoded = true) String query,
                                       @QueryMap Map<String,String> optionalFilters);

    /**
     * Search person method has 2 types of search to choose from, default is <em>phrase</em> and is ok for general search. While the other type, <em>ngram</em>,
     * is for an autocomplete search and will be useful in implementing autocomplete for actors when filtering in discover and using the fitler "with_cast".
     * @param page
     * @param query
     * @param type
     * @return
     */
    @GET(Constants.APIMethods.SEARCH_PERSON)
    Call<PersonListWrapper> searchPerson(@Query(Constants.APIParameters.PAGE) int page,
                                              @Query(value = Constants.APIParameters.QUERY, encoded = true) String query,
                                              @Query(Constants.APIParameters.SEARCH_TYPE) String type);

    @GET(Constants.APIMethods.SEARCH_LIST)
    Call<MovieListsWrapper> searchList(@Query(Constants.APIParameters.PAGE) int page,
                                             @Query(value = Constants.APIParameters.QUERY, encoded = true) String query);

    @GET(Constants.APIMethods.SEARCH_COLLECTION)
    Call<CollectionListWrapper> searchCollection(@Query(Constants.APIParameters.PAGE) int page,
                                                       @Query(value = Constants.APIParameters.QUERY, encoded = true) String query);

}
