package it.unibo.studio.moviemagazine.view.listeners;

import java.util.Map;

import it.unibo.studio.moviemagazine.constants.enums.MovieSortOrder;

/**
 *
 */
public interface OnFilterListener {

    void onFilterAndSortSet(Map<String,String> filterMap, MovieSortOrder order);
}
