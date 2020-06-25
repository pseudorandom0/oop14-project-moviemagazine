package it.unibo.studio.moviemagazine.view;

import it.unibo.studio.moviemagazine.controllers.ConfigurationController;

/**
 * Interface of the first view visible to the user
 */
public interface ConfigurationView extends View {

    /**
     * Displays a widget that shows something is loading
     */
    void displayLoading();

    /**
     * Stops the loading widget
     */
    void finishLoading();

    /**
     * When the loading finishes, home must be displayed
     */
    void displayHome();

    /**
     * Attaches a {@link ConfigurationController} to the view
     * @param controller that manages the configuration
     */
    void attachViewObserver(ConfigurationController controller);
}
