package it.unibo.studio.moviemagazine.controllers;

import it.unibo.studio.moviemagazine.view.ConfigurationView;

/**
 * This controller is a special purpose controller, at application startup there a few things to configure like load
 * image configurations and the full list of movie genres.
 */
public interface ConfigurationController {

    /**
     * Adds a view where the controller can display that it is loading the configuration data or if something goes wrong,
     * it will display an error message
     * @param view the view to use
     */
    void addConfigurationView(ConfigurationView view);

    /**
     * Loads the images configuration and the full list of movie genres
     */
    void commandConfigure();
}
