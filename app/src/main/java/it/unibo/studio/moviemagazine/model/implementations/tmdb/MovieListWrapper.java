package it.unibo.studio.moviemagazine.model.implementations.tmdb;


import com.google.gson.annotations.SerializedName;




import java.util.List;

import it.unibo.studio.moviemagazine.constants.Constants;

/**
 * This class wraps the results from all {@link it.unibo.studio.moviemagazine.webservice.facade.Movies} methods.
 */
public class MovieListWrapper extends PagedResultWrapper{

    @SerializedName(Constants.Parsing.MOVIE_LIST_RESULTS_MEMBER_NAME)
    private List<TMDBMovie> movies;

    public List<TMDBMovie> getMovies() {
        return movies;
    }

    private MovieListWrapper() {
    }

    @Override
    public int getPageSize() {
        return movies.size();
    }
}
