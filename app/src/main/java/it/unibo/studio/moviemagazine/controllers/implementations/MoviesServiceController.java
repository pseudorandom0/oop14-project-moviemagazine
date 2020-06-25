package it.unibo.studio.moviemagazine.controllers.implementations;

import java.util.ArrayList;
import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.MovieListController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListWrapper;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.view.MovieListView;
import it.unibo.studio.moviemagazine.webservice.facade.Movies;
import it.unibo.studio.moviemagazine.webservice.facade.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This is the controller for loading movies with the {@link it.unibo.studio.moviemagazine.webservice.facade.Movies} service interface
 */
class MoviesServiceController extends BaseListController implements MovieListController {


    private final Callback<MovieListWrapper> callback;
    private final MovieLoadingStrategy strategy;
    private MovieListWrapper currentPage;
    private final List<Movie> loaded;
    private Call<MovieListWrapper> currentCall;
    private MovieListView view;
    private final int method;


    MoviesServiceController(int method) {
        this.loaded = new ArrayList<>();
        this.method = method;
        this.strategy = new MovieLoadingStrategy() {

            private final Movies service = ServiceFactory.createService(Movies.class);

            @Override
            public Call<MovieListWrapper> createCall(int method) {
                switch (method){
                    case ListControllerFactory.MOVIES_POPULAR:
                        return service.getPopular(currentPage != null? currentPage.getCurrentPage() + 1 : 1);
                    case ListControllerFactory.MOVIES_TOP_RATED:
                        return service.getTopRated(currentPage != null? currentPage.getCurrentPage() + 1 : 1);
                    case ListControllerFactory.MOVIES_UPCOMING:
                        return service.getUpcoming(currentPage != null? currentPage.getCurrentPage() + 1 : 1);
                    case ListControllerFactory.MOVIES_NOW_PLAYING:
                        return service.getNowPlaying(currentPage != null? currentPage.getCurrentPage() + 1 : 1);
                    default:
                        return null;
                }
            }
        };

        callback = new Callback<MovieListWrapper>() {
            @Override
            public void onResponse(Call<MovieListWrapper> call, Response<MovieListWrapper> response) {
                currentPage = response.body();
                if(currentPage != null){
                    loaded.addAll(currentPage.getMovies());
                    if(currentPage.getCurrentPage() == 1){
                        view.setMovieList(loaded);
                    }
                    view.notifyAdded(currentPage.getPageSize());
                } else {
                    view.displayError("Something went wrong");
                }
            }

            @Override
            public void onFailure(Call<MovieListWrapper> call, Throwable t) {
                view.displayError(t.getMessage());
            }
        };
    }

    @Override
    public void commandLoad() {
        if(currentPage == null){
            currentCall = strategy.createCall(method);
            currentCall.enqueue(callback);
            view.registerOnScrollListener();
        } else {
            view.setMovieList(loaded);
            view.notifyAdded(loaded.size());
            view.registerOnScrollListener();
        }
    }

    @Override
    public void commandLoadMore() {
        if (currentPage.getTotalPages() > currentPage.getCurrentPage()) {
            currentCall = strategy.createCall(method);
            currentCall.enqueue(callback);
        } else {
            view.unregisterOnScrollListener();
            view.displayLocalizedMessage(R.string.movie_list_no_more_items);
        }
    }


    @Override
    public void addMovieListView(MovieListView view) {
        this.view = view;
    }

    @Override
    protected Call getCall() {
        return this.currentCall;
    }

    /**
     * Interface for a movie loading strategy where the strategy is how the calls are created
     */
    private interface MovieLoadingStrategy {
        /**
         * Factory method for creating calls
         * @param method is one of the {@code MOVIES_*} constants
         * @return the call to enqueue
         */
        Call<MovieListWrapper> createCall(int method);
    }

}
