package it.unibo.studio.moviemagazine.controllers;


/**
 * Base interface for list controllers that eventually will load more pages
 */
public interface ListController extends Controller{
    /**
     * Loads next page, if there is one.
     */
    void commandLoadMore();
}
