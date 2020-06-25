package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.PeopleListView;

/**
 * Interface for a controller that loads a list of {@link it.unibo.studio.moviemagazine.model.interfaces.Person}
 */
public interface PeopleListController extends ListController{
    /**
     * Adds the view where the people should be displayed
     * @param view the view to use
     */
    void addPeopleListView(PeopleListView view);
}
