package it.unibo.studio.moviemagazine.model.implementations.tmdb;


import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Logo;

/**
 * Logo of a company
 */
public class TMDBLogo extends TMDBImage implements Logo {

    private final List<String> sizes;

    TMDBLogo() {
        sizes = ImageConfigurationFactory.getSizes(Logo.class);
    }

    @Override
    protected String getSize(int width) {
        return sizes.get(sizes.indexOf("w" + Integer.toString(width)));
    }

    @Override
    protected String getSize(int width, int height) {
        throw new UnsupportedOperationException("The logo height is fixed by width, should use getSize(int width) instead");
    }
}
