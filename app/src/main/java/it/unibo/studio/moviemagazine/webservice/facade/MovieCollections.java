package it.unibo.studio.moviemagazine.webservice.facade;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBMovieCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Interface for requesting {@link TMDBMovieCollection} details
 */
public interface MovieCollections{

    /**
     * Load the details of a {@code TMDBMovieCollection} by the given id
     * @param id of the {@code TMDBMovieCollection} to load
     * @return
     */
    @GET(Constants.APIMethods.COLLECTION_BY_ID)
    Call<TMDBMovieCollection> getCollectionById(@Path(Constants.APIParameters.ID) int id);

    //unused in this version
    /*@GET(Constants.APIMethods.COLLECTION_IMAGES)
    Call<List<TMDBImage>> getCollectionImages(@Path(Constants.APIParameters.ID) int id);*/
}
