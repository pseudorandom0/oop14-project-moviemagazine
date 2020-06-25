package it.unibo.studio.moviemagazine.webservice.facade;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListWrapper;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBGenre;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 */
interface Genres{

    /**
     * This method is not used because the same feature can be implemented by using the {@link Discover} service by simply add a query parameter
     * "with_genres" that supports even multiple genres. Anyway this method is not completely useless beacuse it has a parameter named "include_all_movies"
     * that is a sort of a relevance filter, because when set to false, only movies with 10 or more votes are included in the response.
     * @param id of the genre
     * @param page page to load
     * @return the call to enqueue for loading the page of movies for the given genre
     */
    @GET(Constants.APIMethods.MOVIES_BY_GENRE)
    Call<MovieListWrapper> getMoviesForGenre(@Path(Constants.APIParameters.ID) int id, @Query(Constants.APIParameters.PAGE) int page, @Query(Constants.APIParameters.INCLUDE_ALL_MOVIES) boolean includeAllMovies);

    /**
     * Loads the full list of movie genres
     * @return dummy return, just to comply with the json structure. Anyway nothing happens if used in some way.
     */
    @GET(Constants.APIMethods.LOAD_MOVIE_GENRES)
    Call<TMDBGenre> getMovieGenres();

}
