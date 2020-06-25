package it.unibo.studio.moviemagazine.model.interfaces;

/**
 * Represents a credit of a {@link Person} in a {@link Movie}
 */
public interface Credit {
    /**
     * @return role of the {@code Person} in the {@code Movie}
     */
    String getRole();
    /**
     * @return id of the {@code Credit}
     */
    String getId();

    /**
     * @return the {@code Person} that has the {@code Credit}
     */
    Person getPerson();

    /**
     * @return the {@code Movie} associated to the {@code Credit}
     */
    Movie getMovie();

}