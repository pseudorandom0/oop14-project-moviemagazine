package it.unibo.studio.moviemagazine.model.implementations.tmdb;


import com.google.gson.annotations.SerializedName;


import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.interfaces.Image;

/**
 * All the images URLs are built by combining base_url + size + file_path. The base_url is equal for all images
 * while the size depends on the image type. Each image has its own path and obtaining the same image in different
 * sizes is achieved by just changing the size part of the url, so the url generation logic is fixed but the size
 * to put in between the base url and the path depends on the image type and it's perfect for a template method design pattern.
 */
public abstract class TMDBImage implements Image{

    private final String base_url = ImageConfigurationFactory.getBaseUrl();
    @SerializedName(value = Constants.Parsing.IMAGE_PATH_MEMBER_NAME,
            alternate = {Constants.Parsing.BACKDROP_PATH_MEMBER_NAME,
                        Constants.Parsing.PROFILE_PATH_MEMBER_NAME,
                        Constants.Parsing.POSTER_PATH_MEMBER_NAME,
                        Constants.Parsing.LOGO_PATH_MEMBER_NAME})
    protected String path;


    /**
     * This method builds a complete url for an image.
     * @param width if the width passed is {@code Integer.MAX_VALUE} than the url returned points to the original sized image
     * @param height desired height of the image
     * @return the URL string of the image
     */
    @Override
    public String getUrl(int width, int height) {
        if(path == null || path.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(base_url)
                 .append(width == Integer.MAX_VALUE? "original" : height != 0? getSize(width,height) : getSize(width))
                 .append(path).toString();
    }

    protected abstract String getSize(int width);

    protected abstract String getSize(int width, int height);

}
