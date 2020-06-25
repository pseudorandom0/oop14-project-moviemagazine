package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.FilterableMovieListView;

/**
 * Interface for discover section controller
 */
public interface IDiscoverController extends MovieListController{
    /**
     * Adds the view that should be used to display results and provide a way to retrieve the filters that user has set
     * @param view the view where results should be displayed and where the filters will be retrieved
     */
    void addFilterableMovieListView(final FilterableMovieListView view);

    /**
     * When the currently used filters change, the current results must be deleted and the loading must restart from
     * the first page
     */
    void commandReload();
}
