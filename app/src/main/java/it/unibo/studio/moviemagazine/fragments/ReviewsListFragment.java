package it.unibo.studio.moviemagazine.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.adapters.ReviewAdapter;
import it.unibo.studio.moviemagazine.controllers.ReviewsListController;
import it.unibo.studio.moviemagazine.controllers.implementations.ListControllerFactory;
import it.unibo.studio.moviemagazine.model.interfaces.Review;
import it.unibo.studio.moviemagazine.view.ReviewsListView;
import it.unibo.studio.moviemagazine.view.listeners.EndlessScrollListener;

/**
 * Fragment that displays the reviews of a movie
 */
public class ReviewsListFragment extends BaseFragment implements ReviewsListView{

    private static final String MOVIE_ID_KEY = "movie_id";

    private ReviewsListController controller;
    private RecyclerView reviewsList;
    private LinearLayoutManager layoutManager;
    private ReviewAdapter adapter;


    public static ReviewsListFragment newInstance(int movieId){
        ReviewsListFragment fragment = new ReviewsListFragment();
        Bundle args = new Bundle();
        args.putInt(MOVIE_ID_KEY, movieId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        this.controller = ListControllerFactory.createReviewsListController(args.getInt(MOVIE_ID_KEY));
        this.controller.addReviewsListView(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        controller.commandLoad();
    }

    @Override
    public void onStop() {
        super.onStop();
        controller.cancelLoad();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_reviews_list, container, false);
        setUpLayout(view);
        return view;
    }

    protected void setUpLayout(View view){
        reviewsList = (RecyclerView) view.findViewById(R.id.movieReviewsList);

        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new ReviewAdapter();

        reviewsList.setLayoutManager(layoutManager);
        reviewsList.setAdapter(adapter);
    }


    @Override
    public void registerOnScrollListener() {
        reviewsList.addOnScrollListener(new EndlessScrollListener(layoutManager, controller, adapter));
    }

    @Override
    public void setReviewsList(List<Review> list) {
        adapter.setReviews(list);
    }

    @Override
    public void notifyAdded(int count) {
        adapter.notifyItemRangeInserted(adapter.getItemCount() - count, adapter.getItemCount());
    }

    @Override
    public void notifyRemoved(int count) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void unregisterOnScrollListener() {
        reviewsList.clearOnScrollListeners();
    }

}
