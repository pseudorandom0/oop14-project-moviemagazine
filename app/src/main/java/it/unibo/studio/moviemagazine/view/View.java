package it.unibo.studio.moviemagazine.view;

/**
 * Base view interface
 */
public interface View {

    /**
     * @return {@code true} when the view is visible to the user
     */
    boolean isInForeground();

    /**
     * Displays an error message
     * @param message of the error
     */
    void displayError(final String message);

    /**
     * Method for showing a simple message to the user, like "No more items to display"
     * @param message The message to show to the user
     */
    void displayMessage(String message);

    /**
     * This method is for requesting the movie list view to display a localized message by passing the resource id of the message to display.
     * @param resId the id of the message to display
     */
    void displayLocalizedMessage(int resId);
}
