package it.unibo.studio.moviemagazine.controllers.implementations;

import it.unibo.studio.moviemagazine.controllers.IMovieDetailController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.TMDBMovie;
import it.unibo.studio.moviemagazine.view.MovieDetailView;
import it.unibo.studio.moviemagazine.webservice.facade.Movie;
import it.unibo.studio.moviemagazine.webservice.facade.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Loads the details of a movie.
 */
class MovieDetailController extends BaseController implements IMovieDetailController {

    private final int movieId;
    private MovieDetailView view;
    private final Movie service;
    private TMDBMovie loaded;
    private Call<TMDBMovie> currentCall;

    /**
     * Constructs a {@code MovieDetailController} that loads the details of a movie by the given id
     * @param movieId id of the movie to load
     */
    MovieDetailController(int movieId) {
        this.movieId = movieId;
        service = ServiceFactory.createService(Movie.class);
    }

    @Override
    public void commandLoad() {
        if(loaded == null){
            currentCall = service.getMovieById(movieId);
            currentCall.enqueue(new Callback<TMDBMovie>() {
                @Override
                public void onResponse(Call<TMDBMovie> call, Response<TMDBMovie> response) {
                    loaded = response.body();
                    if(loaded != null){
                        if(view.isInForeground()){
                            view.displayMovie(loaded);
                        }
                    } else {
                        view.displayError("Something went wrong");
                    }
                }

                @Override
                public void onFailure(Call<TMDBMovie> call, Throwable t) {
                    view.displayError(t.getMessage());
                }
            });
        } else {
            if(view.isInForeground()){
                view.displayMovie(loaded);
            }
        }
    }

    @Override
    protected Call getCall() {
        return currentCall;
    }

    @Override
    public void addMovieDetailView(MovieDetailView view) {
        this.view = view;
    }

}
