package it.unibo.studio.moviemagazine.model.interfaces;

import java.util.List;
import java.util.Locale;

/**
 * 
 */
public interface MovieList {



    /**
     * @return
     */
     List<Movie> getMovies();

    /**
     * @return
     */
     int getFavouriteCount();

    /**
     * @return
     */
     String getAuthor();

    /**
     * @return
     */
     String getDescription();

    /**
     * @return
     */
     String getId();

    /**
     * @return
     */
     int getMoviesCount();

    /**
     * @return
     */
     Locale getLanguage();

    /**
     * @return
     */
     String getName();

    /**
     * @return
     */
     Poster getPoster();

}