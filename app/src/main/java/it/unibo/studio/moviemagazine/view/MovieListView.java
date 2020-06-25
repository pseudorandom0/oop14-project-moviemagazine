package it.unibo.studio.moviemagazine.view;

import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Movie;

/**
 * A list view of {@code Movie}s
 */
public interface MovieListView extends ListView {

    /**
     * Sets the model list to display
     * @param movies to display
     */
    void setMovieList(List<Movie> movies);
}
