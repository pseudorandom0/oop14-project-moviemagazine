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
import it.unibo.studio.moviemagazine.controllers.ICollectionDetailController;
import it.unibo.studio.moviemagazine.controllers.MovieListController;
import it.unibo.studio.moviemagazine.controllers.implementations.ListControllerFactory;
import it.unibo.studio.moviemagazine.fragments.CollectionDetailFragment;
import it.unibo.studio.moviemagazine.fragments.MovieListFragment;

/**
 *
 */
public class CollectionViewFragment extends Fragment {

    private int collectionId;
    private String listId;
    private static final String COLLECTION_ID_KEY = "collection_id";
    private static final String LIST_ID_KEY = "list_id";

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CollectionViewPagerAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if(args != null){
            this.collectionId = args.getInt(COLLECTION_ID_KEY, -1);
            this.listId = args.getString(LIST_ID_KEY, "");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tabFragment = inflater.inflate(R.layout.movie_collection_view, container ,false);

        tabLayout = (TabLayout) tabFragment.findViewById(R.id.movie_collection_tab_layout);
        viewPager = (ViewPager) tabFragment.findViewById(R.id.movie_collection_tabs_pager);


        return tabFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter == null){
            if(this.collectionId != -1){
                adapter = new CollectionViewPagerAdapter(getChildFragmentManager(), collectionId);
            } else {
                adapter = new CollectionViewPagerAdapter(getChildFragmentManager(), listId);
            }
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    public static CollectionViewFragment newInstance(int collectionId){
        CollectionViewFragment fragment = new CollectionViewFragment();
        Bundle args = new Bundle();
        args.putInt(COLLECTION_ID_KEY, collectionId);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Factory method that creates a new CollectionViewFragment for displaying a {@link it.unibo.studio.moviemagazine.model.interfaces.MovieList}
     * @param listId the id of the list
     * @return a new fragment that displays the {@link it.unibo.studio.moviemagazine.model.interfaces.MovieList} with the specified listId
     */
    public static CollectionViewFragment newInstance(String listId){
        CollectionViewFragment fragment = new CollectionViewFragment();
        Bundle args = new Bundle();
        args.putString(LIST_ID_KEY, listId);
        fragment.setArguments(args);
        return fragment;
    }



    private class CollectionViewPagerAdapter extends FragmentPagerAdapter{

        CollectionDetailFragment detailFragment;
        MovieListFragment partsFragment;

        public CollectionViewPagerAdapter(FragmentManager fm, int collectionId) {
            super(fm);
            ICollectionDetailController controller = ListControllerFactory.createCollectionController(collectionId);
            detailFragment = CollectionDetailFragment.createWithController(controller);
            partsFragment = MovieListFragment.createWithController((MovieListController)controller);
        }

        public CollectionViewPagerAdapter(FragmentManager fm, String listId) {
            super(fm);
            ICollectionDetailController controller = ListControllerFactory.createCollectionController(listId);
            detailFragment = CollectionDetailFragment.createWithController(controller);
            partsFragment = MovieListFragment.createWithController((MovieListController)controller);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return detailFragment;
            } else {
                return partsFragment;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return getString(R.string.movie_detail_tab_label); //same page title
            } else {
                return getString(R.string.collection_parts_tab_label);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
