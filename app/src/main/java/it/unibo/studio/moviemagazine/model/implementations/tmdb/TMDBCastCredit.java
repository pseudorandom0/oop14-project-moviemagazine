package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import it.unibo.studio.moviemagazine.model.interfaces.CastCredit;

/**
 * Models a cast credit
 */
public class TMDBCastCredit extends TMDBCredit implements CastCredit {


    protected int order;
    protected String character;
    protected int castId;


    TMDBCastCredit() {
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public String getRole() {
        return getCharacter();
    }
}
