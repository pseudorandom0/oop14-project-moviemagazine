package it.unibo.studio.moviemagazine.model.interfaces;

import java.util.Date;
import java.util.List;

/**
 * 
 */
public interface Person {

    /**
     * @return
     */
     List<String> getNicknames();

    /**
     * @return
     */
     String getBiography();

    /**
     * @return
     */
     Date getBirthday();

    /**
     * @return
     */
     Date getDeathday();

    /**
     * @return
     */
     boolean isAlive();

    /**
     * @return
     */
     String getHomepage();

    /**
     * @return
     */
     int getId();

    /**
     * @return
     */
     String getName();

    /**
     * @return
     */
     String getPlaceOfBirth();

    /**
     * @return
     */
     Profile getProfileImage();

    /**
     * @return
     */
     List<Profile> getAllProfileImages();

}