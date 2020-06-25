package it.unibo.studio.moviemagazine.view;

import java.util.Map;

/**
 * A list view that allows filtering and sorting
 */
public interface FilterableMovieListView extends SortableMovieListView {

    /**
     *
     * @return {@code true} when the view wants the results filtered
     */
    boolean wantsFiltered();

    /**
     * Getter method for retrieving filters
     * @return the filters to use
     */
    Map<String,String> getFilters();
}
