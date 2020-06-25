package it.unibo.studio.moviemagazine.model.interfaces;

import java.util.Locale;

/**
 * 
 */
public interface Review {

    /**
     * @return
     */
     String getId();

    /**
     * @return
     */
     String getAuthor();

    /**
     * @return
     */
     String getContent();

    /**
     * @return
     */
     Locale getLanguage();

}