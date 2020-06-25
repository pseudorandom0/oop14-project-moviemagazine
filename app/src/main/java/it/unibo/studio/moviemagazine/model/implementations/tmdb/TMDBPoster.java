package it.unibo.studio.moviemagazine.model.implementations.tmdb;



import java.util.List;

import it.unibo.studio.moviemagazine.model.interfaces.Poster;

/**
 * Poster image
 */
public class TMDBPoster extends TMDBImage implements Poster {

    private final List<String> sizes;

    TMDBPoster() {
        sizes = ImageConfigurationFactory.getSizes(Poster.class);
    }

    @Override
    public String getUrl(int width, int height) {
        return super.getUrl(width,0);
    }

    @Override
    protected String getSize(int width, int height) {
        throw new UnsupportedOperationException("The poster height is fixed by width, should use getSize(int width) instead");
    }
    @Override
    protected String getSize(int width) {
        return sizes.get(sizes.indexOf("w" + Integer.toString(width)));
    }
}
