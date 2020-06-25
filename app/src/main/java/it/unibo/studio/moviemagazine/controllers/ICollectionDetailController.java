package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.controllers.Controller;
import it.unibo.studio.moviemagazine.view.CollectionDetailView;

/**
 * Interface for a Controller that loads the details of {@link it.unibo.studio.moviemagazine.model.interfaces.MovieCollection}
 * or a {@link it.unibo.studio.moviemagazine.model.interfaces.MovieList}
 */
public interface ICollectionDetailController extends Controller{
    /**
     * Adds the view where the details of the collection will be displayed
     * @param view the view where details should be displayed
     */
    void addCollectionDetailView(CollectionDetailView view);

}
