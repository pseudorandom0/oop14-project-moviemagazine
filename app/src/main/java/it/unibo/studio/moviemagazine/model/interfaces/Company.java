package it.unibo.studio.moviemagazine.model.interfaces;


/**
 * Represents the companies that produce the {@link Movie}. This interface is not used in this version.
 */
public interface Company {

    /**
     * @return
     */
     String getDescription();

    /**
     * @return
     */
     String getHeadQuarters();

    /**
     * @return
     */
     String getHompage();

    /**
     * @return
     */
     int getId();

    /**
     * @return
     */
     Logo getLogo();

    /**
     * @return
     */
     String getName();

    /**
     * @return
     */
     Company getParentCompany();

}