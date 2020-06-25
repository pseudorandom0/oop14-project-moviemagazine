package it.unibo.studio.moviemagazine.view;

import it.unibo.studio.moviemagazine.constants.enums.MovieSortOrder;

/**
 * A movie list view that can handle the request of ordering the movie list view
 */
public interface SortableMovieListView extends MovieListView{

    /**
     * @return the sort order desired by the view
     */
    MovieSortOrder getSortOrder();

    /**
     * @return {@code true} when the view wants the results sorted
     */
    boolean wantsSorted();

}
