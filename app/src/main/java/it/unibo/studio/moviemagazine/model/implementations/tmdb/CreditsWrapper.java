package it.unibo.studio.moviemagazine.model.implementations.tmdb;


import java.util.List;


/**
 * Credits wrapper used for receiving credits of a movie or a person
 */
public class CreditsWrapper {

    private List<TMDBCastCredit> cast;
    private List<TMDBCrewCredit> crew;

    //id of movie or person
    protected int id;

    private CreditsWrapper() {
    }

    public List<TMDBCrewCredit> getCrew() {
        return crew;
    }

    public List<TMDBCastCredit> getCast() {
        return cast;
    }
}


