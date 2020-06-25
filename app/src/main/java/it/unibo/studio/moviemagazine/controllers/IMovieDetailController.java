package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.MovieDetailView;

/**
 * Interface for a controller that loads the details of a {@code Movie}
 */
public interface IMovieDetailController extends Controller{

    /**
     * Adds the view where the details should be displayed
     * @param view the view where details should be displayed
     */
    void addMovieDetailView(MovieDetailView view);

}
