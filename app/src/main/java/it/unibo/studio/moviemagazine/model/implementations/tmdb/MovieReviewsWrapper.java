package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import it.unibo.studio.moviemagazine.constants.Constants;

/**
 * Wrapper for reviews of a movie
 */
public class MovieReviewsWrapper extends PagedResultWrapper{

    private int id;
    @SerializedName(Constants.Parsing.REVIEW_LIST_RESULTS_MEMBER_NAME)
    private List<TMDBReview> reviews;


    public List<TMDBReview> getReviews(){
        return reviews;
    }

    public int getId() {
        return id;
    }

    private MovieReviewsWrapper() {
    }

    @Override
    public int getPageSize() {
        return reviews.size();
    }
}
