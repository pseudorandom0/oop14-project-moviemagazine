package it.unibo.studio.moviemagazine.view;

import it.unibo.studio.moviemagazine.model.interfaces.MovieCollection;
import it.unibo.studio.moviemagazine.model.interfaces.MovieList;

/**
 * This view is used to display a {@code MovieCollection} or a {@code MovieList}
 */
public interface CollectionDetailView extends View{

    /**
     * Displays the given {@link MovieCollection} to the user
     * @param collection to display
     */
    void displayCollection(MovieCollection collection);

    /**
     * Displays the given {@link MovieList}
     * @param movieList to display
     */
    void displayList(MovieList movieList);
}
