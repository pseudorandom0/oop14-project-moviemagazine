package it.unibo.studio.moviemagazine.view;

import it.unibo.studio.moviemagazine.model.interfaces.Movie;

/**
 * Displays the details of a {@link Movie}
 */
public interface MovieDetailView extends View{
    /**
     * Displays to the user the given movie
     * @param movie to display
     */
    void displayMovie(Movie movie);
}
