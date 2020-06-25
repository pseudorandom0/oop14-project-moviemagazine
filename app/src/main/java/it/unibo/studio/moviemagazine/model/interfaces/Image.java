package it.unibo.studio.moviemagazine.model.interfaces;

/**
 * 
 */
public interface Image {

    /**
     * Creates the url of the image in the requested size
     * @param width needed
     * @param height needed
     * @return url of the image
     */
    String getUrl(int width, int height);

}