package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.ReviewsListView;

/**
 * Interface for a controller that loads the reviews of a {@link it.unibo.studio.moviemagazine.model.interfaces.Movie}
 */
public interface ReviewsListController extends ListController{
    /**
     * Adds the view where the reviews should be displayed
     * @param view the view to use
     */
    void addReviewsListView(ReviewsListView view);
}
