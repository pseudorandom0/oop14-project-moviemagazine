package it.unibo.studio.moviemagazine.model.interfaces;

import java.util.List;

/**
 * 
 */
public interface MovieCollection {

    /**
     * @return
     */
     Poster getMainPoster();

    /**
     * @return
     */
     Backdrop getMainBackdrop();

    /**
     * @return
     */
     List<Backdrop> getBackdrops();

    /**
     * @return
     */
     List<Poster> getPosters();

    /**
     * @return
     */
     int getId();

    /**
     * @return
     */
     String getName();

    String getOverview();

    /**
     * @return
     */
     List<Movie> getParts();

}