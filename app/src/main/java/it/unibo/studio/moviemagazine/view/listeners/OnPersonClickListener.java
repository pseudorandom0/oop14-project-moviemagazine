package it.unibo.studio.moviemagazine.view.listeners;

import it.unibo.studio.moviemagazine.model.interfaces.Person;

/**
 * Listener interface for clicks on a person in a person list
 */
public interface OnPersonClickListener {
    void onPersonClick(Person clicked);
}
