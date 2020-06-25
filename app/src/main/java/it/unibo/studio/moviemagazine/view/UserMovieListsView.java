package it.unibo.studio.moviemagazine.view;

import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.MovieList;

/**
 * Interface for a view that displays a list of {@link it.unibo.studio.moviemagazine.model.interfaces.MovieList}
 */
public interface UserMovieListsView extends ListView{
    /**
     * Sets the model list to display
     * @param lists to display
     */
    void setMovieLists(List<MovieList> lists);
}
