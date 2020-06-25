package it.unibo.studio.moviemagazine.controllers.implementations;

import java.util.ArrayList;
import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.ReviewsListController;
import it.unibo.studio.moviemagazine.model.implementations.tmdb.MovieReviewsWrapper;
import it.unibo.studio.moviemagazine.model.interfaces.Review;
import it.unibo.studio.moviemagazine.view.ReviewsListView;
import it.unibo.studio.moviemagazine.webservice.facade.Movie;
import it.unibo.studio.moviemagazine.webservice.facade.ServiceFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Loads the reviews of a movie
 */
class ReviewsController extends BaseListController implements ReviewsListController{

    private final int movieId;
    private final Movie service;
    private Call<MovieReviewsWrapper> currentCall;
    private final Callback<MovieReviewsWrapper> callback;
    private MovieReviewsWrapper currentPage;
    private final List<Review> loaded;

    private ReviewsListView view;

    public ReviewsController(int movieId) {
        this.movieId = movieId;
        this.service = ServiceFactory.createService(Movie.class);
        this.loaded = new ArrayList<>();
        this.callback = new Callback<MovieReviewsWrapper>() {
            @Override
            public void onResponse(Call<MovieReviewsWrapper> call, Response<MovieReviewsWrapper> response) {
                currentPage = response.body();
                if(currentPage != null && currentPage.getReviews() != null){
                    loaded.addAll(currentPage.getReviews());
                    if(currentPage.getCurrentPage() == 1 && loaded.size() > 0){
                        view.setReviewsList(loaded);
                    }
                    if(view.isInForeground() && loaded.size() > 0){
                        view.notifyAdded(loaded.size());
                        if(currentPage.getTotalPages() > currentPage.getCurrentPage()){
                            view.registerOnScrollListener();
                        }
                    }
                } else {
                    if(currentPage == null){
                        view.displayError("Something went wrong");
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieReviewsWrapper> call, Throwable t) {
                view.displayError(t.getMessage());
            }
        };
    }

    @Override
    public void addReviewsListView(ReviewsListView view) {
        this.view = view;
    }

    @Override
    public void commandLoad() {
        if(currentPage == null){
            currentCall = service.getReviews(movieId, 1);
            currentCall.enqueue(callback);
        } else if(!loaded.isEmpty()){
            if(view.isInForeground()){
                view.setReviewsList(loaded);
                view.notifyAdded(loaded.size());
            }
        }
    }

    @Override
    public void commandLoadMore() {
        if (currentPage.getTotalPages() > currentPage.getCurrentPage()){
            currentCall = service.getReviews(movieId, (currentPage.getCurrentPage() + 1));
        } else {
            view.unregisterOnScrollListener();
            view.displayLocalizedMessage(R.string.review_list_no_more_items);
        }
    }


    @Override
    protected Call getCall() {
        return currentCall;
    }
}
