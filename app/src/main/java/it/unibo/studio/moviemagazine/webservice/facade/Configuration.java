package it.unibo.studio.moviemagazine.webservice.facade;

import it.unibo.studio.moviemagazine.constants.Constants;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.ImageConfigurationFactory;
import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Interface for getting image configuration at application startup
 */
interface Configuration{
    /**
     * Method for loading images configuration parameters.
     * @return dummy return, unused because the {@link ImageConfigurationFactory} needs only to initialize the static fields
     * @see <a href="http://docs.themoviedb.apiary.io/#reference/configuration/configuration/get">Configuration method docs</a>
     */
    @GET(Constants.APIMethods.CONFIGURATION)
    Call<ImageConfigurationFactory> configure();
}
