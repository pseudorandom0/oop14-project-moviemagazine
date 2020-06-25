package it.unibo.studio.moviemagazine.view;

/**
 * Interface for a view that allows to search with user input
 */
public interface SearchView extends View{
    /**
     *
     * @return the query inserted by a user
     */
    String getQuery();
}
