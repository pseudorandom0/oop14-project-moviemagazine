package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Profile;

/**
 * Profile image of a person
 */
public class TMDBProfile extends TMDBImage implements Profile {

    private final List<String> sizes;

    TMDBProfile() {
        sizes = ImageConfigurationFactory.getSizes(Profile.class);
    }

    @Override
    protected String getSize(int width) {
        return sizes.get(sizes.indexOf("w" + Integer.toString(width)));
    }

    @Override
    protected String getSize(int width, int height) {
        return sizes.get(sizes.indexOf("h" + height));
    }

}
