package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.CreditsView;

/**
 * Interface for a controller that manages the loading of credits
 */
public interface ICreditsController extends Controller{

    /**
     * Adds the view to use for displaying credits
     * @param view
     */
    void addCreditsView(CreditsView view);
}
