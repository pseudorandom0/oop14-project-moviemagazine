package it.unibo.studio.moviemagazine.view;

import android.support.v4.app.Fragment;

/**
 * The main view represents the container for all application views and is implemented by each *SectionActivity
 */
public interface MainView extends View{

    /**
     * Displays the home view of the section
     */
    void displayContent();

    /**
     * Replaces the current view in the container with the given view
     * @param fragment the view to put in the container
     */
    void replaceFragment(Fragment fragment);

}
