package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import it.unibo.studio.moviemagazine.constants.Constants;

/**
 * Wrapper for {@link TMDBMovieCollection} used for receiving results from search
 */
public class CollectionListWrapper extends PagedResultWrapper{

    @SerializedName(Constants.Parsing.COLLECTION_RESULTS_MEMBER_NAME)
    private List<TMDBMovieCollection> collections;

    public List<TMDBMovieCollection> getCollections() {
        return collections;
    }

    private CollectionListWrapper() {
    }

    @Override
    public int getPageSize() {
        return collections.size();
    }
}
