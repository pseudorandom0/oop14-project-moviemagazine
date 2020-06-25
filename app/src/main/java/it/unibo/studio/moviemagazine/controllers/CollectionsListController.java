package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.MovieCollectionsListView;

/**
 * Controller that loads a {@code List<MovieCollection>}
 */
public interface CollectionsListController extends ListController{
    /**
     * Adds a view where the controller will display the results
     * @param view the view where results should be displayed
     */
    void addCollectionsListView(MovieCollectionsListView view);
}
