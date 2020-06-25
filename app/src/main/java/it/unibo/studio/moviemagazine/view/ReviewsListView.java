package it.unibo.studio.moviemagazine.view;

import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Review;

/**
 * Interface for a view that displays the reviews of a movie
 */
public interface ReviewsListView extends ListView{
    /**
     * Sets the model list to display
     * @param list to display
     */
    void setReviewsList(List<Review> list);
}
