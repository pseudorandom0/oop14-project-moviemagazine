package it.unibo.studio.moviemagazine.view;

/**
 *
 */
public interface ListView extends View{


    /**
     * Tells the view to register the scroll listener
     */
    void registerOnScrollListener();

    /**
     * Tells the view to remove the scroll listener
     */
    void unregisterOnScrollListener();

    /**
     * Notifies the list view that elements were added to the model list and the view should be refreshed.
     * @param count of the added elements
     */
    void notifyAdded(int count);

    /**
     * Notifies the list view that elements were removed from the model list and the view should be refreshed.
     * @param count of the removed elements
     */
    void notifyRemoved(int count);
}
