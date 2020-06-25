package it.unibo.studio.moviemagazine.view;

import it.unibo.studio.moviemagazine.model.interfaces.Person;

/**
 * Interface for a view that displays the details of a person
 */
public interface PersonView extends View{

    /**
     * Displays the given person
     * @param person to display
     */
    void displayPerson(Person person);
}
