package it.unibo.studio.moviemagazine.controllers;


import java.util.Date;
import java.util.List;

import it.unibo.studio.moviemagazine.constants.enums.MovieSortOrder;
import it.unibo.studio.moviemagazine.model.interfaces.Genre;

/**
 * Interface or filter controller
 */
public interface FilterController {

    /**
     * Adds a release time based filter
     * @param year the year to filter
     */
    void setReleaseYear(Date year);

    /**
     * Adds a with genre filter
     * @param genre the genre filter to add
     */
    void addWithGenre(Genre genre);

    /**
     * Removes the genre from filters
     * @param genre genre to remove
     */
    void removeWithGenre(Genre genre);

    /**
     * Sets the movie sorting order
     * @param order how the movies should be sorted
     */
    void setMovieSortOrder(MovieSortOrder order);

    /**
     * There is a default sort order for movies
     * @return the default sort order of movies
     */
    MovieSortOrder getDefaultMovieSortOrder();

    /**
     * This method produces the values to use in the release year filter view.
     * @return a list of integers containing the last 40 years
     */
    List<Integer> getReleaseYearValues();
}
