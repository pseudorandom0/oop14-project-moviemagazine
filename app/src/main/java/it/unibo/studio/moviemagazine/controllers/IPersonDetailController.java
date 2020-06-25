package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.PersonView;

/**
 * Interface for a controller that loads the details of a {@code Person}
 */
public interface IPersonDetailController extends Controller{

    /**
     * Adds the view where the details should be displayed
     * @param view the view where details should be displayed
     */
    void addPersonView(PersonView view);
}
