package it.unibo.studio.moviemagazine.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.adapters.AbstractListAdapter;
import it.unibo.studio.moviemagazine.adapters.MovieAdapter;
import it.unibo.studio.moviemagazine.adapters.MovieCollectionAdapter;
import it.unibo.studio.moviemagazine.adapters.PersonAdapter;
import it.unibo.studio.moviemagazine.adapters.UserMovieListAdapter;
import it.unibo.studio.moviemagazine.controllers.CollectionsListController;
import it.unibo.studio.moviemagazine.controllers.ISearchController;
import it.unibo.studio.moviemagazine.controllers.MovieListController;
import it.unibo.studio.moviemagazine.controllers.PeopleListController;
import it.unibo.studio.moviemagazine.controllers.UserMovieListsController;
import it.unibo.studio.moviemagazine.controllers.implementations.ListControllerFactory;
import it.unibo.studio.moviemagazine.fragments.tabcontainers.CollectionViewFragment;
import it.unibo.studio.moviemagazine.fragments.tabcontainers.MovieViewFragment;
import it.unibo.studio.moviemagazine.fragments.tabcontainers.PersonViewFragment;
import it.unibo.studio.moviemagazine.model.interfaces.Movie;
import it.unibo.studio.moviemagazine.model.interfaces.MovieCollection;
import it.unibo.studio.moviemagazine.model.interfaces.MovieList;
import it.unibo.studio.moviemagazine.model.interfaces.Person;
import it.unibo.studio.moviemagazine.view.MainView;
import it.unibo.studio.moviemagazine.view.MovieCollectionsListView;
import it.unibo.studio.moviemagazine.view.MovieListView;
import it.unibo.studio.moviemagazine.view.PeopleListView;
import it.unibo.studio.moviemagazine.view.SearchView;
import it.unibo.studio.moviemagazine.view.UserMovieListsView;
import it.unibo.studio.moviemagazine.view.listeners.EndlessScrollListener;
import it.unibo.studio.moviemagazine.view.listeners.OnCollectionClickListener;
import it.unibo.studio.moviemagazine.view.listeners.OnListClickListener;
import it.unibo.studio.moviemagazine.view.listeners.OnMovieClickListener;
import it.unibo.studio.moviemagazine.view.listeners.OnPersonClickListener;

/**
 * Fragment for search section
 */
public class SearchFragment extends BaseFragment implements SearchView, MovieListView, UserMovieListsView,
        PeopleListView, MovieCollectionsListView, OnMovieClickListener, OnPersonClickListener, OnListClickListener, OnCollectionClickListener{

    public static final String SEARCH_TYPE_KEY = "list_type";

    private ISearchController controller;

    private RecyclerView list;
    private EditText searchEditText;

    private AbstractListAdapter adapter;
    private LinearLayoutManager layoutManager;


    public static SearchFragment create(int SEARCH_TYPE){
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putInt(SEARCH_TYPE_KEY, SEARCH_TYPE);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null){
            int searchType = args.getInt(SEARCH_TYPE_KEY);
            controller = ListControllerFactory.createSearchController(searchType);
            controller.addSearchView(this);
            switch (searchType){
                case ListControllerFactory.SEARCH_PEOPLE:
                    adapter = new PersonAdapter(this);
                    ((PeopleListController)controller).addPeopleListView(this);
                    break;
                case ListControllerFactory.SEARCH_COLLECTIONS:
                    adapter = new MovieCollectionAdapter(this);
                    ((CollectionsListController)controller).addCollectionsListView(this);
                    break;
                case ListControllerFactory.SEARCH_LISTS:
                    adapter = new UserMovieListAdapter(this);
                    ((UserMovieListsController)controller).addUserMovieListsView(this);
                    break;
                case ListControllerFactory.SEARCH_MOVIES:
                    adapter = new MovieAdapter(this);
                    ((MovieListController)controller).addMovieListView(this);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_layout, container, false);

        list = (RecyclerView) view.findViewById(R.id.recycler_view);
        view.findViewById(R.id.searchButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.commandSearch();
            }
        });
        searchEditText = (EditText) view.findViewById(R.id.searchEditText);

        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);

        return view;
    }

    @Override
    public String getQuery() {
        return searchEditText.getText().toString();
    }

    @Override
    public void setCollectionsList(List<MovieCollection> collections) {
        ((MovieCollectionAdapter)adapter).setCollections(collections);
    }

    @Override
    public void setMovieList(List<Movie> movies) {
        ((MovieAdapter)adapter).setMovies(movies);
    }

    @Override
    public void setPeopleList(List<Person> people) {
        ((PersonAdapter)adapter).setPeople(people);
    }

    @Override
    public void setMovieLists(List<MovieList> lists) {
        ((UserMovieListAdapter)adapter).setMovieLists(lists);
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
    public void notifyAdded(int count) {
        adapter.notifyItemRangeInserted(adapter.getItemCount() - count, adapter.getItemCount());
    }

    @Override
    public void notifyRemoved(int count) {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onMovieClick(Movie clicked) {
        MovieViewFragment fragment = MovieViewFragment.newInstance(clicked.getId());
        ((MainView)getActivity()).replaceFragment(fragment);
    }

    @Override
    public void onCollectionClick(MovieCollection clicked) {
        CollectionViewFragment fragment = CollectionViewFragment.newInstance(clicked.getId());
        ((MainView)getActivity()).replaceFragment(fragment);
    }

    @Override
    public void onListClick(MovieList clicked) {
        CollectionViewFragment fragment = CollectionViewFragment.newInstance(clicked.getId());
        ((MainView)getActivity()).replaceFragment(fragment);
    }

    @Override
    public void onPersonClick(Person clicked) {
        PersonViewFragment fragment = PersonViewFragment.newInstance(clicked.getId());
        ((MainView)getActivity()).replaceFragment(fragment);
    }
}
