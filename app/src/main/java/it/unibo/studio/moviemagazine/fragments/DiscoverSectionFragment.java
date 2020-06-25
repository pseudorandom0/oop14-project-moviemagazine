package it.unibo.studio.moviemagazine.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Map;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.constants.enums.MovieSortOrder;
import it.unibo.studio.moviemagazine.controllers.IDiscoverController;
import it.unibo.studio.moviemagazine.controllers.implementations.ListControllerFactory;
import it.unibo.studio.moviemagazine.controllers.implementations.MovieFilterController;
import it.unibo.studio.moviemagazine.view.FilterableMovieListView;
import it.unibo.studio.moviemagazine.activities.StickyBackStack;
import it.unibo.studio.moviemagazine.view.listeners.OnFilterListener;
import it.unibo.studio.moviemagazine.view.listeners.OnSortListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiscoverSectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoverSectionFragment extends MovieListFragment implements FilterableMovieListView, View.OnClickListener, OnFilterListener, OnSortListener{



    private MovieSortOrder sortOrder;
    private Map<String,String> filters;

    private IDiscoverController controller;

    private boolean wantsFiltered = true;
    private boolean wantsSorted = true;



    public DiscoverSectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment DiscoverSectionFragment.
     */
    public static DiscoverSectionFragment newInstance() {
        DiscoverSectionFragment fragment = new DiscoverSectionFragment();
        fragment.sortOrder = MovieFilterController.defaultSortOrder;
        fragment.filters = MovieFilterController.defaultFilters;
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.controller = ListControllerFactory.createDiscoverController();
        super.controller = this.controller;
        controller.addFilterableMovieListView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.discover_section_view, container, false);
        setUpLayout(view);
        return view;
    }

    @Override
    protected void setUpLayout(View view) {
        super.setUpLayout(view);
        view.findViewById(R.id.filterButton).setOnClickListener(this);
    }

    @Override
    public boolean wantsFiltered() {
        return wantsFiltered;
    }

    @Override
    public Map<String, String> getFilters() {
        return filters;
    }

    @Override
    public MovieSortOrder getSortOrder() {
        return sortOrder;
    }

    @Override
    public boolean wantsSorted() {
        return wantsSorted;
    }


    @Override
    public void onFilterAndSortSet(Map<String, String> filterMap, MovieSortOrder order) {
        this.filters = filterMap;
        this.sortOrder = order;
        ((StickyBackStack)getActivity()).setSticky(false);
        this.controller.commandReload();
    }

    @Override
    public void onSortSet(MovieSortOrder sortOrder) {
        wantsSorted = true;
        this.sortOrder = sortOrder;
    }

    @Override
    public void onClick(View v) {
        FiltersDialog dialog = new FiltersDialog();
        ((StickyBackStack)getActivity()).setSticky(true);
        dialog.setController(new MovieFilterController());
        dialog.setOnFilterListener(this);
        dialog.show(getChildFragmentManager(), null);
    }
}
