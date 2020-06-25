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
import it.unibo.studio.moviemagazine.adapters.MovieAdapter;
import it.unibo.studio.moviemagazine.controllers.implementations.ListControllerFactory;
import it.unibo.studio.moviemagazine.controllers.MovieListController;
import it.unibo.studio.moviemagazine.fragments.tabcontainers.MovieViewFragment;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.view.MainView;
import it.unibo.studio.moviemagazine.view.MovieListView;
import it.unibo.studio.moviemagazine.view.listeners.EndlessScrollListener;
import it.unibo.studio.moviemagazine.view.listeners.OnMovieClickListener;

/**
 * Simple fragment that manages a list of movies
 */
public class MovieListFragment extends BaseFragment implements MovieListView, OnMovieClickListener{


    private RecyclerView list;
    private LinearLayoutManager layoutManager;
    private MovieAdapter adapter;
    private static final String CONTROLLER_TYPE_KEY = "controller_type";
    protected MovieListController controller;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        //instantiate the right controller
        if(args != null){
            this.controller = ListControllerFactory.createMovieListController(args.getInt(CONTROLLER_TYPE_KEY));
        }
    }

    public static MovieListFragment createWithController(final int CONTROLLER_TYPE){
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        args.putInt(CONTROLLER_TYPE_KEY, CONTROLLER_TYPE);
        fragment.setArguments(args);
        return fragment;
    }

    public static MovieListFragment createWithController(MovieListController controller){
        MovieListFragment fragment = new MovieListFragment();
        fragment.controller = controller;
        return fragment;
    }

    @Override
    public void onStop() {
        super.onStop();
        controller.cancelLoad();
    }


    @Override
    public void onResume() {
        super.onResume();
        controller.commandLoad();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_layout, container, false);
        setUpLayout(view);
        return view;
    }

    protected void setUpLayout(View view){
        list = (RecyclerView)view.findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new MovieAdapter(this);

        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
        this.controller.addMovieListView(this);
    }

    @Override
    public void registerOnScrollListener() {
        list.addOnScrollListener(new EndlessScrollListener(layoutManager, controller, adapter));
    }



    @Override
    public void unregisterOnScrollListener() {
        list.clearOnScrollListeners();
    }


    @Override
    public void setMovieList(List<Movie> movies) {
        adapter.setMovies(movies);
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
    public void onMovieClick(Movie clicked) {
        requestDisplayMovie(clicked);
    }

    private void requestDisplayMovie(Movie movie){
        MovieViewFragment fragment = MovieViewFragment.newInstance(movie.getId());
        ((MainView)getActivity()).replaceFragment(fragment);
    }

}
