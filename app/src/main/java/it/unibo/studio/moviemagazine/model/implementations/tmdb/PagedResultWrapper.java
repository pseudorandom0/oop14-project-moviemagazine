package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import com.google.gson.annotations.SerializedName;

import it.unibo.studio.moviemagazine.constants.Constants;

/**
 * Used for pagination control
 */
public abstract class PagedResultWrapper {
    @SerializedName(Constants.Parsing.CURRENT_PAGE_MEMBER_NAME)
    private int currentPage;
    @SerializedName(Constants.Parsing.TOTAL_PAGES_MEMBER_NAME)
    private int totalPages;
    @SerializedName(Constants.Parsing.TOTAL_RESULTS_MEMBER_NAME)
    private int totalResults;


    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public abstract int getPageSize();
}
