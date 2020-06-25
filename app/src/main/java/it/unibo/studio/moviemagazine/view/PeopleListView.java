package it.unibo.studio.moviemagazine.view;

import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Person;

/**
 * Interface for a list view of {@code Person}s
 */
public interface PeopleListView extends ListView{
    /**
     * Sets the model list to display
     * @param people to display
     */
    void setPeopleList(List<Person> people);
}
