package it.unibo.studio.moviemagazine.view.listeners;

import it.unibo.studio.moviemagazine.model.interfaces.Genre;

/**
 * Listener interface for adding genre filters
 */
public interface OnGenreSelected {
    /**
     * Each genre in the list of genres has a checkbox that toggles the add/remove filter with that genre.
     * @param genre the genre selected
     * @param checked true if it was checked false if unchecked
     */
    void genreSelected(Genre genre, boolean checked);
}
