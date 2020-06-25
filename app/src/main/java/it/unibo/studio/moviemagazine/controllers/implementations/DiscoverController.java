package it.unibo.studio.moviemagazine.controllers.implementations;

import java.util.ArrayList;
import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.IDiscoverController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieListWrapper;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.view.FilterableMovieListView;
import it.unibo.studio.moviemagazine.view.MovieListView;
import it.unibo.studio.moviemagazine.webservice.facade.Discover;
import it.unibo.studio.moviemagazine.webservice.facade.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This controller uses {@link it.unibo.studio.moviemagazine.webservice.facade.Discover} service for loading movies
 */
class DiscoverController extends BaseListController implements IDiscoverController {

    private FilterableMovieListView view;


    private Call<MovieListWrapper> currentCall;
    private final Discover service;
    private MovieListWrapper currentPage;
    private final List<Movie> loaded;
    private final Callback<MovieListWrapper> callback;



    DiscoverController() {
        this.service = ServiceFactory.createService(Discover.class);
        this.loaded = new ArrayList<>();
        this.callback = new Callback<MovieListWrapper>() {
            @Override
            public void onResponse(Call<MovieListWrapper> call, Response<MovieListWrapper> response) {
                currentPage = response.body();
                if(currentPage != null && currentPage.getTotalResults() > 0){
                    if(currentPage.getCurrentPage() == 1){
                        view.setMovieList(loaded);
                        if(currentPage.getTotalPages() > 1){
                            view.registerOnScrollListener();
                        }
                    } else if(currentPage.getCurrentPage() == currentPage.getTotalPages()){
                        view.unregisterOnScrollListener();
                        view.displayLocalizedMessage(R.string.movie_list_no_more_items);
                    }
                    List<Movie> downloaded = new ArrayList<Movie>(currentPage.getMovies());
                    loaded.addAll(downloaded);
                    if(view.isInForeground()){
                        view.notifyAdded(downloaded.size());
                    }
                } else {
                    if(currentPage == null){
                        view.displayMessage("Something went wrong");
                    } else {
                        view.displayLocalizedMessage(R.string.movie_list_no_more_items);
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieListWrapper> call, Throwable t) {

            }
        };
    }

    @Override
    public void commandLoad() {

        if(!loaded.isEmpty()){
            if(view.isInForeground()){
                view.setMovieList(loaded);
                view.notifyAdded(loaded.size());
                view.registerOnScrollListener();
            }
        } else {
            currentCall = service.discoverMovies(1, view.getFilters(), view.getSortOrder().getParameterValue());
            currentCall.enqueue(callback);
        }
    }

    @Override
    public void commandLoadMore() {
        if(currentPage.getCurrentPage() == currentPage.getTotalPages()){
            view.unregisterOnScrollListener();
        } else {
            currentCall = service.discoverMovies(currentPage.getCurrentPage() + 1, view.getFilters(), view.getSortOrder().getParameterValue());
            currentCall.enqueue(callback);
        }
    }

    @Override
    public void commandReload(){
        int removed = loaded.size();
        loaded.clear();
        view.unregisterOnScrollListener();
        view.notifyRemoved(removed);
        commandLoad();
    }


    @Override
    public void addFilterableMovieListView(final FilterableMovieListView view){
        this.view = view;
    }

    @Override
    public void addMovieListView(MovieListView view) {

    }

    @Override
    protected Call getCall() {
        return this.currentCall;
    }
}
