package it.unibo.studio.moviemagazine.fragments.tabcontainers;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.implementations.ListControllerFactory;
import it.unibo.studio.moviemagazine.fragments.MovieListFragment;

public class MoviesSectionFragment extends Fragment{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;

    public MoviesSectionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MoviesSectionFragment.
     */
    public static MoviesSectionFragment newInstance() {
        MoviesSectionFragment fragment = new MoviesSectionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tabFragment = inflater.inflate(R.layout.movies_section_fragment, container ,false);

        tabLayout = (TabLayout) tabFragment.findViewById(R.id.movies_section_tab_layout);
        viewPager = (ViewPager) tabFragment.findViewById(R.id.movies_section_tabs_pager);


        return tabFragment;
    }



    @Override
    public void onResume() {
        super.onResume();
        if(adapter == null){
            adapter = new MoviesSectionPagerAdapter(getChildFragmentManager());
        }
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    private class MoviesSectionPagerAdapter extends FragmentPagerAdapter {

        private MovieListFragment popular;
        private MovieListFragment topRated;
        private MovieListFragment upcoming;
        private MovieListFragment nowPlaying;

        private static final int ITEM_COUNT = 4;

        public MoviesSectionPagerAdapter(FragmentManager childFragmentManager) {
            super(childFragmentManager);
            popular = MovieListFragment.createWithController(ListControllerFactory.MOVIES_POPULAR);
            topRated = MovieListFragment.createWithController(ListControllerFactory.MOVIES_TOP_RATED);
            upcoming = MovieListFragment.createWithController(ListControllerFactory.MOVIES_UPCOMING);
            nowPlaying = MovieListFragment.createWithController(ListControllerFactory.MOVIES_NOW_PLAYING);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return popular;
                case 1:
                    return topRated;
                case 2:
                    return upcoming;
                case 3:
                    return nowPlaying;
                default:
                    Log.d("FragPagerAdapter", "ENTERED IN DEFAULT CASE!");
                    break;
            }
            return null;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return getResources().getString(R.string.popular_tab_label);
                case 1:
                    return getResources().getString(R.string.top_rated_tab_label);
                case 2:
                    return getResources().getString(R.string.upcoming_tab_label);
                case 3:
                    return getResources().getString(R.string.now_playing_tab_label);
            }
            return "";
        }

        @Override
        public int getCount() {
            return ITEM_COUNT;
        }
    }

}
