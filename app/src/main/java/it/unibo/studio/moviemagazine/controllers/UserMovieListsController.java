package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.UserMovieListsView;

/**
 * Interface for a controller that loads a {@code List<MovieList>}
 */
public interface UserMovieListsController extends ListController{
    /**
     * Adds the view where the lists should be displayed
     * @param view the view to use
     */
    void addUserMovieListsView(UserMovieListsView view);
}
