package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.MovieListView;

/**
 * Interface for a controller that manages a list of movies
 */
public interface MovieListController extends ListController{
    /**
     * Adds the view where the movies should be displayed
     * @param view the view to use
     */
    void addMovieListView(MovieListView view);
}
