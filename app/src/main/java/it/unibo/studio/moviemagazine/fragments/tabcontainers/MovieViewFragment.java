package it.unibo.studio.moviemagazine.fragments.tabcontainers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.unibo.studio.moviemagazine.R;
import it.unibo.studio.moviemagazine.controllers.implementations.ControllerFactory;
import it.unibo.studio.moviemagazine.fragments.BaseFragment;
import it.unibo.studio.moviemagazine.fragments.CreditsFragment;
import it.unibo.studio.moviemagazine.fragments.MovieDetailFragment;
import it.unibo.studio.moviemagazine.fragments.ReviewsListFragment;

/**
 * Fragment that displays the fragments of a movie detail
 */
public class MovieViewFragment extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    public static final String MOVIE_ID_KEY = "movie_id";
    private int movieId;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        movieId = args.getInt(MOVIE_ID_KEY);
    }

    /**
     * Creates a movie view fragment that displays the details of a movie
     * @param movieId the id of the movie to display
     * @return
     */
    public static MovieViewFragment newInstance(int movieId){
        MovieViewFragment fragment = new MovieViewFragment();
        Bundle args = new Bundle();
        args.putInt(MOVIE_ID_KEY, movieId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_view, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.movie_view_tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.movie_view_tabs_pager);

        adapter = new MovieViewPagerAdapter(getChildFragmentManager(), this.movieId);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private class MovieViewPagerAdapter extends FragmentPagerAdapter{

        private MovieDetailFragment detailFragment;
        private CreditsFragment creditsFragment;
        private ReviewsListFragment reviewsFragment;

        private static final int FRAGMENTS_COUNT = 3;

        public MovieViewPagerAdapter(FragmentManager fm, int movieId) {
            super(fm);
            detailFragment = MovieDetailFragment.newInstance(movieId);
            creditsFragment = CreditsFragment.createWithController(ControllerFactory.MOVIE_CREDITS_CONTROLLER, movieId);
            reviewsFragment = ReviewsListFragment.newInstance(movieId);

        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return detailFragment;
                case 1:
                    return creditsFragment;
                case 2:
                    return reviewsFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return FRAGMENTS_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return getResources().getString(R.string.movie_detail_tab_label);
                case 1:
                    return getResources().getString(R.string.movie_credit_tab_label);
                case 2:
                    return getResources().getString(R.string.movie_reviews_tab_label);
                default:
                    return null;
            }
        }
    }
}
