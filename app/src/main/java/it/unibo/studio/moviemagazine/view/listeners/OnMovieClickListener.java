package it.unibo.studio.moviemagazine.view.listeners;

import it.unibo.studio.moviemagazine.model.interfaces.Movie;

/**
 * Interface for capturing a click on a movie in a movie list
 */
public interface OnMovieClickListener{
    void onMovieClick(Movie clicked);
}