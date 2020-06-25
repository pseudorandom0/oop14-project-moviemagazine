package it.unibo.studio.moviemagazine.webservice.facade;

import it.unibo.studio.moviemagazine.controllers.ConfigurationController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.ImageConfigurationFactory;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBGenre;
import it.unibo.studio.moviemagazine.view.ConfigurationView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * This controller is special because it loads all the required data for later use in the application.
 * At the moment it loads the image configuration and the full list of movie genres.
 * It is implemented in this package because the {@code ServiceFactory.createImageConfigurationService()} and {@code Service.createGenresLoaderService} methods
 * have package local visibility for avoiding the creation of these services anywhere outside.
 */
public class ConfigurationManager implements ConfigurationController{

    private ConfigurationView view;
    /**
     * The counter is used for notifying the view when the loading is finished
     */
    private int callsToExecute;

    @Override
    public void commandConfigure() {
        loadBaseData();
    }

    public ConfigurationManager() {
        callsToExecute = 2;
    }

    private void loadBaseData(){
        view.displayLoading();
        final Configuration imagesConfiguration = ServiceFactory.createImageConfigurationService();
        final Genres genres = ServiceFactory.createGenresLoaderService();

        imagesConfiguration.configure().enqueue(new Callback<ImageConfigurationFactory>() {
            @Override
            public void onResponse(Call<ImageConfigurationFactory> call, Response<ImageConfigurationFactory> response) {
                if(callsToExecute > 1){
                    callsToExecute--;
                } else {
                    view.finishLoading();
                    view.displayHome();
                }
            }

            @Override
            public void onFailure(Call<ImageConfigurationFactory> call, Throwable t) {
                view.displayError(t.getMessage());
            }
        });


        genres.getMovieGenres().enqueue(new Callback<TMDBGenre>() {
            @Override
            public void onResponse(Call<TMDBGenre> call, Response<TMDBGenre> response) {
                response.body().initGenres();
                if(callsToExecute > 1){
                    callsToExecute--;
                } else {
                    view.finishLoading();
                    view.displayHome();
                }
            }

            @Override
            public void onFailure(Call<TMDBGenre> call, Throwable t) {
                view.displayError(t.getMessage());
            }
        });
    }

    @Override
    public void addConfigurationView(ConfigurationView view) {
        this.view = view;
    }
}
