package it.unibo.studio.moviemagazine.controllers;

/**
 * Base interface for all controller that load data from the service
 */
public interface Controller {
    /**
     * Called by a view when it becomes visible and wants the data to be loaded
     */
    void commandLoad();

    /**
     * If for some reason the view becomes invisible and the loading of the movies is useless, this is the command to stop the current loading
    */
     void cancelLoad();
}
