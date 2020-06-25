package it.unibo.studio.moviemagazine.view;

import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.MovieCollection;

/**
 * A view that displays a list of {@link MovieCollection}s
 */
public interface MovieCollectionsListView extends ListView{
    /**
     * Sets the model list to display
     * @param collections the {@code MovieCollection}s to display
     */
    void setCollectionsList(List<MovieCollection> collections);
}
