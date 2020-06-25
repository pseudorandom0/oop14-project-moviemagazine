package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import it.unibo.studio.moviemagazine.model.interfaces.Company;
import it.unibo.studio.moviemagazine.model.interfaces.Logo;

/**
 * Models a company
 */
public class TMDBCompany implements Company {

    private String name;
    private int id;
    private String description;
    private String headquarters;
    private String homepage;
    private TMDBLogo logo;
    private TMDBCompany parentCompany;

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getHeadQuarters() {
        return this.headquarters;
    }

    @Override
    public String getHompage() {
        return this.homepage;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Logo getLogo() {
        return this.logo;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Company getParentCompany() {
        return this.parentCompany;
    }
}
