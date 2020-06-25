package it.unibo.studio.moviemagazine.model.implementations.tmdb;

import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Backdrop;

/**
 * Represents a backdrop image
 */
public class TMDBBackdrop extends TMDBImage implements Backdrop {

    private final List<String> sizes;

    TMDBBackdrop() {
        sizes = ImageConfigurationFactory.getSizes(Backdrop.class);
    }

    @Override
    protected String getSize(int width) {
        return sizes.get(sizes.indexOf("w" + Integer.toString(width)));
    }

    @Override
    protected String getSize(int width, int height) {
        throw new UnsupportedOperationException("The backdrop height is fixed by width, should use getSize(int width) instead");
    }


}
