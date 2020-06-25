package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import it.unibo.studio.moviemagazine.constants.Constants;

/**
 * Wrapper for receiving movie lists
 */
public class MovieListsWrapper extends PagedResultWrapper{

    @SerializedName(Constants.Parsing.LISTS_RESUTS_MEMBER_NAME)
    private List<TMDBMovieList> lists;

    public List<TMDBMovieList> getLists() {
        return lists;
    }

    private MovieListsWrapper() {
    }

    @Override
    public int getPageSize() {
        return lists.size();
    }
}
