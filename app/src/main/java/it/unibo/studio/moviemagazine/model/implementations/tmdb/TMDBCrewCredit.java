package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import it.unibo.studio.moviemagazine.model.interfaces.CrewCredit;

/**
 * Models a crew credit
 */
public class TMDBCrewCredit extends TMDBCredit implements CrewCredit {

    protected String department;
    protected String job;

    TMDBCrewCredit() {
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public String getJob() {
        return this.job;
    }

    @Override
    public String getRole() {
        return getDepartment() + ": " + getJob();
    }
}
