package it.unibo.studio.moviemagazine.webservice.facade;


import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.CreditsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieReviewsWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBMovie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Interface for getting data of a movie by its id
 */
public interface Movie{

    /**
     * Loads the details of a movie by id
     * @param id of the movie
     * @return the requested movie
     */
    @GET(Constants.APIMethods.MOVIE_BY_ID)
    Call<TMDBMovie> getMovieById(@Path(Constants.APIParameters.ID) int id);

    /**
     * Loads credits of a movie
     * @param id of the movie
     * @return movie credits
     */
    @GET(Constants.APIMethods.MOVIE_CREDITS)
    Call<CreditsWrapper> getCredits(@Path(Constants.APIParameters.ID) int id);

    //unused method in this version
    /*@GET(Constants.APIMethods.MOVIE_IMAGES)
       Call<List<TMDBImage>> getImages(@Path(Constants.APIParameters.ID)int id);*/

        /*@GET(Constants.APIMethods.MOVIE_KEYWORDS)
        Call<List<String>> getKeywords(@Path(Constants.APIParameters.ID)int id);*/

    /**
     * Loads reviews of a movie
     * @param id of the movie
     * @param page page number to load
     * @return
     */
    @GET(Constants.APIMethods.MOVIE_REVIEWS)
    Call<MovieReviewsWrapper> getReviews(@Path(Constants.APIParameters.ID)int id, @Query(Constants.APIParameters.PAGE) int page);

    /**
     * Loads the lists in which a {@code Movie} is inserted
     * @param id of the movie
     * @param page of lists to load
     * @return
     */
    @GET(Constants.APIMethods.MOVIE_LISTS)
    Call<MovieListsWrapper> getListsOfMovie(@Path(Constants.APIParameters.ID) int id, @Query(Constants.APIParameters.PAGE) int page);
}
