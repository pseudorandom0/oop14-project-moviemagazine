package it.unibo.studio.moviemagazine.fragments.tabcontainers;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.implementations.ListControllerFactory;
import it.unibo.studio.moviemagazine.fragments.SearchFragment;

/**
 *
 */
public class SearchSectionFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;



    public static SearchSectionFragment create(){
        SearchSectionFragment fragment = new SearchSectionFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tabFragment = inflater.inflate(R.layout.search_section_fragment, container ,false);

        tabLayout = (TabLayout) tabFragment.findViewById(R.id.search_tab_layout);
        viewPager = (ViewPager) tabFragment.findViewById(R.id.search_tabs_pager);


        return tabFragment;
    }


    @Override
    public void onResume() {
        super.onResume();
        if(adapter == null){
            adapter = new SearchSectionPagerAdapter(getChildFragmentManager());
        }
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    private class SearchSectionPagerAdapter extends FragmentPagerAdapter{

        SearchFragment searchMovies, searchLists, searchCollections, searchPeople;


        public SearchSectionPagerAdapter(FragmentManager fm) {
            super(fm);
            searchMovies = SearchFragment.create(ListControllerFactory.SEARCH_MOVIES);
            searchLists = SearchFragment.create(ListControllerFactory.SEARCH_LISTS);
            searchCollections = SearchFragment.create(ListControllerFactory.SEARCH_COLLECTIONS);
            searchPeople = SearchFragment.create(ListControllerFactory.SEARCH_PEOPLE);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return searchMovies;
                case 1:
                    return searchLists;
                case 2:
                    return searchPeople;
                case 3:
                    return searchCollections;
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return getResources().getString(R.string.search_movies_tab_label);
                case 1:
                    return getResources().getString(R.string.search_lists_tab_label);
                case 2:
                    return getResources().getString(R.string.search_people_tab_label);
                case 3:
                    return getResources().getString(R.string.search_collections_tab_label);
            }
            return "";
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}
